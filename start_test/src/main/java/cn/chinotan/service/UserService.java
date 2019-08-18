package cn.chinotan.service;

import cn.chinotan.entity.User;
import cn.chinotan.entity.UserBak;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author xingcheng
 * @since 2019-02-16
 */
public interface UserService extends IService<User> {

    /**
     * 通过name获取全部userBak
     * @param name
     * @return
     */
    List<UserBak> getBakByName(String name);
    
}
