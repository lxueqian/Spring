package com.xq.ssm.service;

import com.xq.ssm.pojo.Account;
import org.springframework.stereotype.Service;

import java.util.List;

public interface AccountService {
    public void save(Account account);
    public List<Account> findAll();
    public Account findById(int id);
}
