package com.xq.service.Impl;

import com.xq.dao.UserDao;
import com.xq.domain.User;
import com.xq.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/*
 * service方法中需要调用UserDao对象的方法,Bean注入（在容器内部就可以把UserDao设置到UserService内部）
 * 1. set方法
 *     方法实现类中创建注入对象
 *     还需要修改配置文件<property name="userDao" ref="userDao"></property> setUserDao选取一部分开头小写
 *      简化：
 *      p命名空间注入 xmlns:p="http://www.springframework.org/schema/p"
 *      <bean id="userService" class="com.xq.service.Impl.UserServiceImpl" p:userDao-ref="userDao"></be
 *
 * 2. 构造方法
 *     方法实现类中创建注入对象
 *     还需要修改配置文件
 *          <bean id="userService" class="com.xq.service.Impl.UserServiceImpl" p:userDao-ref="userDao">
                <constructor-arg name="userDao" ref="userDao"></constructor-arg>
        </bean>                        构造方法参数

   属性的注入也是以上两种方式
   * 属性有：
   * 1.基本数据类型
   * 2.引用数据类型
   * 3.集合类型
 * */
//<bean id="userService" class="com.xq.service.Impl.UserServiceImpl">
//@Component("userService")
@Service("userService") //用于服务层Bean实例化
@Scope("prototype")
//@PropertySource("classpath:jdbc.properties") 和@Value("${key}")连用
public class UserServiceImpl implements UserService {
    //<property name="userDao" ref="userDao"></property>
    //@Autowired //使用在字段上用于根据类型依赖注入
    //@Qualifier("userDao")//ref 和@Autowired一起使用用于根据名称进行依赖注入
    @Resource(name="userDao") //同上
    private UserDao userDao;

    //@Value("${key}")
    private int age;
    private String username;
    private List<String> list;
    private Map<String, User> userMap;
    private Properties properties;

    //构造方法
    public UserServiceImpl() {
    }
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    //set方法

    public void setUserDao(UserDao userDao){
        this.userDao = userDao;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void save(){
        userDao.save();
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "userDao=" + userDao +
                '}';
    }
    /*//容器外获取对象拼接
     public void save(){
        //获取Spring容器对象
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过配置文件中的id获得UserDaoImpl实现类对象
        UserDao userDao = (UserDao) app.getBean("userDao");
        //调用实现类方法
        userDao.save();

    }*/

}
