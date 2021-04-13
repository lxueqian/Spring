package com.xq.dao.impl;

import com.xq.dao.UserDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//<bean id="userDao" class="com.xq.dao.impl.UserDaoImpl">
//@Component("userDao")
@Repository("userDao") //用于DAO层Bean的实例化
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }

    @PostConstruct //初始化方法
    public void init(){
        System.out.println("初始化方法...");
    }
    @PreDestroy //销毁方法
    public void destory(){
        System.out.println("销毁方法....");
    }
}
