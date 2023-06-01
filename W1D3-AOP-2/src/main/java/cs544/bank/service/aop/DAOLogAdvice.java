package cs544.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cs544.bank.logging.Logger;

@Aspect
@Component
public class DAOLogAdvice {
    private static final Logger logger = new Logger();
    
    @After("execution(* cs544.bank.dao.*.*(..))") 
    public void logDAOCall(JoinPoint joinpoint) {
        logger.log(joinpoint.getSignature().getName());
    }
}
