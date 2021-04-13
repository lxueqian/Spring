package com.xq.dao.impl;

import com.xq.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;


public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("save running...");
    }
}
