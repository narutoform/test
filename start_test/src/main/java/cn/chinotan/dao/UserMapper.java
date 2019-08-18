package cn.chinotan.dao;

import cn.chinotan.aop.TableConfig;
import cn.chinotan.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author xingcheng
 * @since 2019-02-16
 */
@TableConfig(strategy="bak")
public interface UserMapper extends BaseMapper<User> {
    
}
