package cn.chinotan.entity.chinotan.service.impl;

import cn.chinotan.entity.chinotan.entity.User;
import cn.chinotan.entity.chinotan.mapper.UserMapper;
import cn.chinotan.entity.chinotan.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author xingcheng
 * @since 2019-02-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
