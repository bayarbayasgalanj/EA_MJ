package cs544.bank.service.aop;


import org.apache.logging.log4j.LogManager;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class JMSLogAdvice {
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(JMSLogAdvice.class.getName());
    // private static final 
    
    @After("execution(* cs544.bank.jms.*.*(..))") 
    public void logJMSMessage(JoinPoint joinpoint) {
        logger.warn(joinpoint.getSignature().getName());
    }

}
