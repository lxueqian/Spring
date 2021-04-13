package com.xq.demo;

import com.xq.service.Impl.UserServiceImpl;
import com.xq.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* Bean注入测试程序：
*   注意如果直接创建UserService，会出现空指针异常，因为没有userDao实例
* */
public class UserServiceDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过配置文件中的id获得UserServiceImpl实现类对象
        UserService us = (UserService) app.getBean("userService");

        //传入字节码对象类型不适用于xml中有多个同样类型的情况，还是用xml中的id比较好
        UserService us1 = app.getBean(UserService.class);
        //调用实现类方法
        us.save();
        System.out.println(us);

        /*UserService us = new UserServiceImpl();
        us.save();  //java.lang.NullPointerException*/

    }
}
