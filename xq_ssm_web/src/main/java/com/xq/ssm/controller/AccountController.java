package com.xq.ssm.controller;

import com.xq.ssm.pojo.Account;
import com.xq.ssm.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    @RequestMapping(value = "/save",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public String save(Account account){
        accountService.save(account);
        return "保存成功";
    }

    @RequestMapping("/findall")
    public ModelAndView findAll(ModelAndView modelAndView){
        List<Account> all = accountService.findAll();
        modelAndView.addObject("accountlist",all);
        modelAndView.setViewName("accountlist");
        return modelAndView;
    }

    @RequestMapping("/findById")
    @ResponseBody
    public Account findById(int id){
        return accountService.findById(id);
    }



}
