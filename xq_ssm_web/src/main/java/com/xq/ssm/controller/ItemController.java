package com.xq.ssm.controller;


import com.xq.ssm.pojo.Item;
import com.xq.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/item")
public class ItemController {
    @Autowired
    private ItemService itemService;


    @RequestMapping("/showItem")
    @ResponseBody
    public Item findById(int id){
        return itemService.findById(id);
//        return "success";
    }

    /*@RequestMapping("/showItem/{id}")
    public String findById(@PathVariable("id") int id, Model model){
        Item item = itemService.findById(id);
        model.addAttribute("item",item);
        return "item"; *//*逻辑视图名*//*
    }*/
}
