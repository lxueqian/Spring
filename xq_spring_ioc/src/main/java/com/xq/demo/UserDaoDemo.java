package com.xq.demo;

import com.xq.dao.UserDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
    Spring编写代码
*   1.导入Spring开发的基本包坐标  /Spring/xq_spring_ioc/pom.xml (maven方法)
    2.编写Dao接口和实现类         src/main/java/com/xq
    3.创建Spring核心配置文件      src/main/resources/applicationContext.xml
    4.在Spring配置文件中配置UserDaoImpl   <bean id="userDao" class="com.xq.dao.impl.UserDaoImpl"></bean>
    5.使用Spring的API获得Bean实例 src/main/java/com/xq/demo
* */
public class UserDaoDemo {
    public static void main(String[] args) {
        //获取Spring容器对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过配置文件中的id获得UserDaoImpl实现类对象
        UserDao userDao = (UserDao) app.getBean("userDao");
        //调用实现类方法
        userDao.save();


    }
}
