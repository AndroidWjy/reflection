import com.wjy.aspect.event.DemoPublisher;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author wangjinyang@g7.com.cn
 */
public class testScope {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        DemoPublisher demoPublisher = context.getBean(DemoPublisher.class);
        demoPublisher.publish("hello world");
        context.close();
    }

}
