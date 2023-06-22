package cs544;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class TraceAspect {
    @Autowired
    private MyClass myClass;

    @Before("execution(* cs544.*.*(..))")
    public void beforeTrace(JoinPoint jp) {
        System.out.println(jp.getSignature().getName() + " is about to execute");

        if (jp.getTarget() instanceof MyClass) {
            MyClass my = (MyClass) jp.getTarget();
            // my.setText("From Advice");
        }
    }
}
