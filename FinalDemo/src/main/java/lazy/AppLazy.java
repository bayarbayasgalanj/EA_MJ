package lazy;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// https://manalabs.org/videos/cs544/2023-06/quiz/3
public class AppLazy {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Testing Spring Startup----");
        MyClass mc = context.getBean("myClass", MyClass.class);
        // mc.sayHello();
        // context.close();
    }
}