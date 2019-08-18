package cn.chinotan.controller;


import cn.chinotan.entity.User;
import cn.chinotan.service.UserService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author xingcheng
 * @since 2019-02-16
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/list")
    public Object list() {
        List<User> list = userService.list();
        return list;
    }

    @GetMapping("/page/list/{current}/{size}")
    public Object page(@PathVariable("current") Long current, @PathVariable("size") Long size) {
        Page<User> objectPage = new Page<>(current, size);
        IPage<User> page = userService.page(objectPage);
        return page;
    }

    @GetMapping("/save/{name}")
    public Object save(@PathVariable("name") String name) {
        User user = new User();
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setName(name);
        boolean save = userService.save(user);
        return save;
    }

    @GetMapping("/update/{name}")
    public Object update(@PathVariable("name") String name) {
        User user = new User();
        user.setId(1L);
        user.setCreateTime(LocalDateTime.now());
        user.setUpdateTime(LocalDateTime.now());
        user.setName(name);
        boolean update = userService.updateById(user);
        return update;
    }
}

