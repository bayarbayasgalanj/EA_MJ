package cs544.bank.service.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import cs544.bank.domain.Account;
import cs544.bank.logging.Logger;

@Aspect
@Component
public class DAOLogAdvice {
    private static final Logger logger = new Logger();
    
    @After("execution(* cs544.bank.dao.*.*(..))") 
    public void logDAOCall(JoinPoint joinpoint) {
        Object[] args = joinpoint.getArgs();
        logger.log(joinpoint.getSignature().getName());
        StringBuilder sb = new StringBuilder()
                .append(joinpoint.getTarget().getClass().getSimpleName())
                .append(": ")
                .append(joinpoint.getSignature().getName());
        if (args == null || args.length == 0) {
            logger.log(sb.toString());
        } else if (args[0] instanceof Account ac) {
            sb.append(" account with accountnr= ").append(ac.getAccountnumber());
            logger.log(sb.toString());
        } else if (args[0] instanceof Number n) {
            sb.append(" account with accountnr= ").append(n);
            logger.log(sb.toString());
        }
    }
}
