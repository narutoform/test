package cn.chinotan.interceptor;

import cn.chinotan.dto.request.CommonRequest;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * @program: test
 * @description:
 * @author: xingcheng
 * @create: 2019-03-02 18:29
 **/
public class TestInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String isTestHeader = httpServletRequest.getHeader("isTest");
        // 先从header中去，取不到就从queryParam中取
        if (StringUtils.isNotBlank(isTestHeader)) {
            Boolean isTestBoolean = Objects.equals(isTestHeader, "true");
            CommonRequest.setTest(isTestBoolean);
        } else {
            String isTestParam = httpServletRequest.getParameter("isTest");
            if (StringUtils.isNotBlank(isTestParam)) {
                Boolean isTestBoolean = Objects.equals(isTestParam, "true");
                CommonRequest.setTest(isTestBoolean);
            }
        }
        return true;
    }
    
}
