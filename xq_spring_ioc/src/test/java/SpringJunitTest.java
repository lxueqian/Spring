import com.xq.config.DataSourceConfig;
import com.xq.config.SpringConfig;
import com.xq.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:applicationContext.xml")
@ContextConfiguration(classes = {SpringConfig.class})
public class SpringJunitTest {
    @Autowired //注入userService测试对象
    private UserService userService;

    @Autowired
    private DataSource dataSource;

    @Test //测试userService的方法
    public void test1(){
        userService.save();
    }

    @Test //dataSource
    public void test2() throws SQLException {
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
    }


}
