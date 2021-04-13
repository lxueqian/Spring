package com.xq.ssm.dao;

import com.xq.ssm.pojo.Account;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountMapper {
    public void save(Account account);
    public List<Account> findAll();

    @Select("select * from account where id=#{id}")
    public Account findById(int id);
}
