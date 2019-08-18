package cn.chinotan.service.impl;

import cn.chinotan.entity.User;
import cn.chinotan.dao.UserMapper;
import cn.chinotan.entity.UserBak;
import cn.chinotan.service.UserBakService;
import cn.chinotan.service.UserService;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xingcheng
 * @since 2019-02-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserBakService userBakService;
    
    @Override
    public List<UserBak> getBakByName(String name) {
        // 获取全部的男人用户id
        UserService userService = (UserService) AopContext.currentProxy();
        User user = new User();
        user.setName(name);
        Wrapper<User> wrapper = new QueryWrapper<>(user);
        List<User> userList = userService.list(wrapper);
        List<String> collectUserNameList = userList.stream().map(User::getName).collect(Collectors.toList());
        QueryWrapper<UserBak> bakWrapper = new QueryWrapper<>();
        bakWrapper.in("name", collectUserNameList);
        return userBakService.list(bakWrapper);
    }

}
