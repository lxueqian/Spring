package com.xq.factory;

import com.xq.dao.UserDao;
import com.xq.dao.impl.UserDaoImpl;

public class DynamicFactory {

    public UserDao getUserDao(){
        return new UserDaoImpl();
    }

}