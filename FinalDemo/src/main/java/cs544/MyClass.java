package cs544;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;
import jakarta.ws.rs.ext.ParamConverter.Lazy;

// @Scope("prototype")
@Scope
// @Lazy
@Component
public class MyClass 
// extends MySuper 
{

    public MyClass() { 
        System.out.println("MyClass From Class Constructor");
        // setText("From Class Constructor"); 
    }

    public void sayHello() {
        // System.out.println("Hello is: " + getText());
    }

    @PreDestroy
    public void destroy() {
        System.out.println("Destroying MyClass");
    }
}