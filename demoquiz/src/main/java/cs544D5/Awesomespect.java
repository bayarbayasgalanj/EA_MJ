package cs544D5;

import jakarta.annotation.PostConstruct;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Awesomespect {
    @Value("Test")
    private String text;

public Awesomespect() {
System.out.println("AwesomeAspect Constructor - text: " + text);
}

@PostConstruct
public void start()
    {
System.out.println("AwesomeAspect start method - text: " + text);
    }
@Around ("execution(* cs544.*.get*(..))")
public Object beforeTrace(ProceedingJoinPoint pjp) throws Throwable {
String name = pjp.getTarget().getClass().getSimpleName();
if (name.equals("BClass")) {
return "Something";
}
return pjp.proceed();
}
}