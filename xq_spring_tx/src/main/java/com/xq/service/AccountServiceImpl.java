package com.xq.service;

import com.xq.dao.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("accountService")
//@Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
public class AccountServiceImpl implements AccountService {
    @Autowired
    private Account account;

    /*public void setAccount(Account account) {
        this.account = account;
    }*/

    /*在目标对象方法上标记事务，可设置参数，也可以直接在目标对象类上加此注解，表示这一类中所有切点方法
    都会以该事务参数被增强
    */
    @Transactional(isolation = Isolation.REPEATABLE_READ,propagation = Propagation.REQUIRED)
    public void transfer(String outMan, String inMan, double money) {
        account.out(outMan,money);
//        int a = 1/0;
        account.in(inMan,money);
    }

}
