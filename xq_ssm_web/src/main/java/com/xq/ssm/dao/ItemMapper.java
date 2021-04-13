package com.xq.ssm.dao;

import com.xq.ssm.pojo.Item;

/*
* 命名：表名+Mapper
* */
public interface ItemMapper {
    public Item findById(int id);
}
