//package cn.chinotan.service.reliabletransmission;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.context.WebApplicationContext;
//import org.springframework.web.context.support.WebApplicationContextUtils;
//
//import javax.servlet.ServletContextEvent;
//import javax.servlet.ServletContextListener;
//import javax.servlet.annotation.WebListener;
//
///**
// * @program: test
// * @description: 可靠投递监听器
// * @author: xingcheng
// * @create: 2018-09-24 16:05
// **/
//@WebListener
//public class ReliableTransContextListener implements ServletContextListener {
//
//    Logger logger = LoggerFactory.getLogger(ReliableTransContextListener.class);
//
//    private WebApplicationContext springContext;
//
//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        logger.info("ReliableTransContextListener init start...........");
//        springContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
//        if (springContext != null) {
//            RetryCache retryCache = (RetryCache) springContext.getBean("retryCache");
//            new Thread(() -> retryCache.startRetry()).start();
//        }
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//    }
//}
