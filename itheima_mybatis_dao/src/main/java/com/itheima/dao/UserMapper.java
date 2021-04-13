package com.itheima.dao;

import com.itheima.domain.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {

    public List<User> findAll() throws IOException;

    public User findById(int id);
    
    /*
     UserMapper接口定义是有规则的
    * <mapper namespace="com.itheima.dao.UserMapper">

    <!--查询操作-->
    <select id="findById" parameterType="int" resultType="user">
        select * from user where id=#{id}
    </select>
    *
    * */

}
