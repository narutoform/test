package cn.chinotan;

import cn.chinotan.entity.User;
import cn.chinotan.entity.UserBak;
import cn.chinotan.service.UserBakService;
import cn.chinotan.service.UserService;
import cn.chinotan.service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.aop.framework.AopContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @program: test
 * @description: Mockito测试类
 * @author: xingcheng
 * @create: 2019-07-13 17:00
 **/
@Slf4j
@RunWith(PowerMockRunner.class)
@PrepareForTest({AopContext.class})
@PowerMockIgnore("javax.management.*")
public class MyMockitoTest {
    
    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserService userServiceMock;
                                                                        
    @Mock
    private UserBakService userBakService;

    @Test
    public void testOne() {
        // mock数据准备
        PowerMockito.mockStatic(AopContext.class);
        when(AopContext.currentProxy()).thenReturn(userServiceMock);
        User user = new User();
        user.setId(1L);
        user.setName("xc");
        List<User> userList = Lists.newArrayList(user);
        when(userServiceMock.list(any())).thenReturn(userList);
        UserBak userBak = new UserBak();
        userBak.setId(1L);
        userBak.setName("xc");
        List<UserBak> userBakList = Lists.newArrayList(userBak);
        when(userBakService.list(any())).thenReturn(userBakList);
        // mock方法测试
        List<UserBak> xc = userService.getBakByName("xc");
        log.info("testOne{}", xc);
    }
    
}
