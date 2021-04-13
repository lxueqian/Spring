package com.xq.factory;

import com.xq.dao.UserDao;
import com.xq.dao.impl.UserDaoImpl;

public class StaticFactory {
    //不需要有工厂对象 因为是静态方法
    public static UserDao getUserDao(){
        return new UserDaoImpl();
    }

}
