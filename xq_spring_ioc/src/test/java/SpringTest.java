import com.xq.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {
    @Test
    /*scope属性测试
    * singleton
    * prototype
    * 每次都要获取容器对象
    * */

    public void test1(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过配置文件中的id获得UserDaoImpl实现类对象
        UserDao userDao = (UserDao) app.getBean("userDao");
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao);
        System.out.println(userDao1);
    }
}
