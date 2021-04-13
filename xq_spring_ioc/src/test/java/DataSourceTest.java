import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DataSourceTest {
    @Test //Spring容器产生数据源对象
    public void testDruidXML() throws PropertyVetoException, SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource ds = (DataSource) app.getBean("dataSource");
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test //c3p0
    public void testc3p0() throws PropertyVetoException, SQLException {
        ComboPooledDataSource ds = new ComboPooledDataSource();
        ds.setDriverClass("com.mysql.jdbc.Driver");
        ds.setJdbcUrl("jdbc:mysql://localhost:3306/db");
        ds.setUser("root");
        ds.setPassword("root");
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test //Druid
    public void testDruid() throws PropertyVetoException, SQLException {
        DruidDataSource ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/db");
        ds.setUsername("root");
        ds.setPassword("root");
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test //读取properties配置文件 Druid
    public void testDruidProperties() throws PropertyVetoException, SQLException {

        ResourceBundle rb = ResourceBundle.getBundle("jdbc");//resources下面的文件
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        DruidDataSource ds = new DruidDataSource();

        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        Connection conn = ds.getConnection();
        System.out.println(conn);
        conn.close();
    }

    /*之前学习的读取配置文件方法
    *  static {
        Properties pro = new Properties();
        InputStream rs = Demo7ConnectionPool.class.getClassLoader().getResourceAsStream("druid.pro");
        try {
            pro.load(rs);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    * */
}
