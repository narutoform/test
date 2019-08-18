package cn.chinotan.config;

import cn.chinotan.interceptor.TestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @program: test
 * @description:
 * @author: xingcheng
 * @create: 2019-03-02 18:33
 **/
@Configuration
public class WebAppConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new TestInterceptor()).addPathPatterns("/**");
    }
    
}
