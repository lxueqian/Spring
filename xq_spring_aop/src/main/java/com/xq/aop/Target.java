package com.xq.aop;

import org.springframework.stereotype.Component;

@Component("target")
public class Target implements TargetInterface{
    public void save() {
        System.out.println("saving......");
    }
}
