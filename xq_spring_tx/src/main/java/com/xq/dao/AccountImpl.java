package com.xq.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("account") //相当于注册实例化
public class AccountImpl implements Account {

    @Autowired //相当于引用 不用自己创建
    private JdbcTemplate jdbcTemplate;

    /*public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    使用注解可以不用set方法*/

    public void in(String outMan, double money) {
        jdbcTemplate.update("update account set balance=balance-? where name=?",money,outMan);
    }

    public void out(String inMan, double money) {
        jdbcTemplate.update("update account set balance=balance+? where name=?",money,inMan);
    }

}
