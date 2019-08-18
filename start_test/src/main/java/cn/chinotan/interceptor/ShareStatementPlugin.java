package cn.chinotan.interceptor;

import cn.chinotan.aop.TableConfig;
import cn.chinotan.controller.UserController;
import cn.chinotan.dto.request.CommonRequest;
import cn.chinotan.service.Strategy;
import cn.chinotan.service.impl.BakStrategy;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Proxy;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * 完成插件签名：
 * 告诉MyBatis当前插件用来拦截哪个对象的哪个方法
 * type  指四大对象拦截哪个对象，
 * method ： 代表拦截哪个方法  ,在StatementHandler 中查看，需要拦截的方法
 * args  ：代表参数
 */
@Component
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {
                Connection.class, Integer.class})})
public class ShareStatementPlugin implements Interceptor {

    private static final Logger LOG = LoggerFactory.getLogger(ShareStatementPlugin.class);

    @Autowired
    private Map<String, Strategy> strategyMap;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        StatementHandler statementHandler = realTarget(invocation.getTarget());
        MetaObject metaObject = SystemMetaObject.forObject(statementHandler);
        doTable(statementHandler, metaObject);
        return invocation.proceed();
    }

    private void doTable(StatementHandler handler, MetaObject metaStatementHandler) throws ClassNotFoundException {
        BoundSql boundSql = handler.getBoundSql();
        String originalSql = boundSql.getSql();

        if (originalSql != null && !originalSql.equals("")) {
            LOG.info("分表前的SQL：{}", originalSql);
            MappedStatement mappedStatement = (MappedStatement) metaStatementHandler
                    .getValue("delegate.mappedStatement");
            String id = mappedStatement.getId();
            String className = id.substring(0, id.lastIndexOf("."));
            Class<?> classObj = Class.forName(className);
            Class baseEntity = null;
            Type[] interfacesTypes = classObj.getGenericInterfaces();
            for (Type type : interfacesTypes) {
                if (type instanceof ParameterizedType) {
                    ParameterizedType interfacesType = (ParameterizedType) interfacesTypes[0];
                    Type t = interfacesType.getActualTypeArguments()[0];
                    baseEntity = (Class) t;
                }
            }
            // 根据配置自动生成分表SQL
            TableConfig tableConfig = classObj.getAnnotation(TableConfig.class);
            // 获取表名 并进行相应转化
            String tableName = baseEntity.getSimpleName().toLowerCase();
            if (StringUtils.isNotBlank(tableConfig.value())) {
                tableName = tableConfig.value();
            }

            if (tableConfig != null && tableConfig.isTest()) {
                // 获取策略来处理
                Strategy strategy = strategyMap.get(tableConfig.strategy());
                if (strategy instanceof BakStrategy) {
                    ThreadLocal<Boolean> isTest = CommonRequest.isTest;
                    Boolean aBoolean = isTest.get();
                    LOG.info("是否测试：{}", aBoolean);
                    if (aBoolean) {
                        String convertedSql = originalSql.replaceAll(tableName, strategy.convert(tableName));
                        metaStatementHandler.setValue("delegate.boundSql.sql", convertedSql);
                        LOG.info("分表后的SQL：{}", convertedSql);
                    }
                }
            }
        }
    }

    @Override
    public Object plugin(Object target) {
        if (target instanceof StatementHandler) {
            return Plugin.wrap(target, this);
        }
        return target;
    }

    @Override
    public void setProperties(Properties properties) {
    }

    /**
     * 获得真正的处理对象,可能多层代理
     *
     * @param target
     * @param <T>
     * @return
     */
    public static <T> T realTarget(Object target) {
        if (Proxy.isProxyClass(target.getClass())) {
            MetaObject metaObject = SystemMetaObject.forObject(target);
            return realTarget(metaObject.getValue("h.target"));
        }
        return (T) target;
    }
}
