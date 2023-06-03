package cs544D5;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App5 {

    public static void main(String[] args) {
        System.out.println("========");
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        System.out.println("Testing Spring Startup");
        AClass a = context.getBean(AClass.class);
        a.getAText();
        a.getBText();
        context.close();
    }
}