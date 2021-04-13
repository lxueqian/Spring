package com.xq.listener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextLoaderListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {

        ServletContext servletContext = sce.getServletContext();
        String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");

        ApplicationContext app = new ClassPathXmlApplicationContext(contextConfigLocation);

        //将Spring应用上下文对象存储到ServletContext域中
        servletContext.setAttribute("app",app);
        //还需要webXML配置一下监听器、全局变量初始化

    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
