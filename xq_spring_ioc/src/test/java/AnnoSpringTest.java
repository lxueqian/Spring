import com.xq.config.SpringConfig;
import com.xq.service.UserService;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnoSpringTest {
    @Test
    public void test1(){
        //注解开发
        AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = app.getBean(UserService.class);
        userService.save();
    }
}
