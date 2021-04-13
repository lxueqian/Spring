package com.xq.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xq.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    //数据回写 页面跳转
    @RequestMapping("/quick") //路由
    public String save(){
        System.out.println("Controller running...");
//        return "success.jsp"; //配置前缀后缀就不用写了
        return "success"; //spring-mvc中配置前缀后缀就不用写了
    }

    //数据回写 字符串
    @RequestMapping("/quick3") //路由
    @ResponseBody //会在页面上面返回一个字符串，不会进行页面跳转
    public String save3(){
        return "success";
    }


    //回写数据json   jackson-core databind
    @RequestMapping("/quick4")
    @ResponseBody
    public String save4() throws JsonProcessingException {
        User user = new User();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(user);
        return json;
    }

    //回写json:添加mvc驱动不需要手动转换json，可以直接返回对象和集合
    @RequestMapping("/quick5")
    @ResponseBody
    public User save5() throws JsonProcessingException {
        User user = new User();
        return user;
    }

    /*//获得请求参数：前端可以添加属性，这里会自动匹配基本数据类型（名字需要相同）
    直接返回集合类型参数不需要封装为POJO（实际就是普通JavaBeans）
    也就是把这个List<User> user定义到一个类中变成一个属性，会自动给这个类set这个属性
    @RequestMapping("/quick6")
    @ResponseBody
    public void save6(@ResponseBody List<User> user) throws JsonProcessingException {
        System.out.println(list);
    }*/

    //Restful参数接收  请求 http://localhost:8080/quick7/zhangsan
    @RequestMapping("/quick7/{name}")
    @ResponseBody
    public void save7(@PathVariable(value="name",required=true) String username){
        System.out.println(username);
    }


    @RequestMapping("/quick2") //路由
    public ModelAndView save2(){
        /*
        * Model:封装数据
        * View:展示数据
        * */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        return modelAndView;
    }

    @RequestMapping("/quick8") //路由
    @ResponseBody //获取请求头作为方法输入
    public void save8(@RequestHeader(value="User-Agent",required=true) String user_agent){
        System.out.println(user_agent);
    }

    //单文件上传
    @RequestMapping("/quick9")
    @ResponseBody
    public void fileUpload(String name, MultipartFile uploadFile) throws IOException {
        String originalFilename = uploadFile.getOriginalFilename();
        uploadFile.transferTo(new File("C:\\upload\\"+originalFilename));
    }

    //多文件上传
    @RequestMapping("/quick9")
    @ResponseBody
    public void fileUpload2(String name, MultipartFile[] uploadFiles) throws IOException {
        for (MultipartFile uploadFile : uploadFiles) {
            String originalFilename = uploadFile.getOriginalFilename();
            uploadFile.transferTo(new File("C:\\upload\\"+originalFilename));
        }
    }
}
