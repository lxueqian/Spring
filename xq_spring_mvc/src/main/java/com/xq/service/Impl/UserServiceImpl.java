package com.xq.service.Impl;

import com.xq.dao.UserDao;
import com.xq.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService") //用于服务层Bean实例化
@Scope("prototype")
public class UserServiceImpl implements UserService {

    @Resource(name="userDao") //同上
    private UserDao userDao;

    //@Value("${key}")
    private int age;
    private String username;


    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }


    public void save() {
        System.out.println("saving......");
    }
}
