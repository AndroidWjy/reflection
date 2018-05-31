import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author wangjinyang@g7.com.cn
 */
@ComponentScan(basePackages = {"com.wjy.aspect"})
@SpringBootApplication
public class AspectApplication {
    public static void main(String[] args) {
        SpringApplication.run(AspectApplication.class, args);
    }
}
