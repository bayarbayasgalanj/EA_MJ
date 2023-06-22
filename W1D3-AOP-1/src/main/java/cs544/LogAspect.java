package cs544;

import org.apache.logging.log4j.LogManager; 
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect; 
import org.aspectj.lang.annotation.Before; 
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class LogAspect {
    private static final Logger logger = LogManager.getLogger(LogAspect.class.getName());
    
    // @Before("execution(* cs544.IEmailSender.*(..))") 
    // public void logBefore(JoinPoint joinpoint) {
    //     logger.warn(joinpoint.getSignature().getName()); 
    // }
    @After("execution(* cs544.IEmailSender.sendEmail(..))") 
    public void logAfter(JoinPoint joinpoint) {
        // System.out.println(joinpoint.getArgs());
        EmailSender em = (EmailSender) joinpoint.getTarget();
        logger.warn(joinpoint.getSignature().getName()+
        " address="+joinpoint.getArgs()[0]+
        " message= "+joinpoint.getArgs()[1]+
        " server = " + em.getOutgoingMailServer()
        );
    }
    @Around("execution(* cs544.CustomerDAO.save(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable { 
        System.out.println(" ---------- START ---------");
		StopWatch sw = new StopWatch(); 
        sw.start(call.getSignature().getName());
		Object retVal = call.proceed();
		sw.stop();
		long totaltime = sw.getLastTaskTimeMillis();
		   // print the time to the console
		System.out.println("Time to execute save = "+totaltime+"ms");
		return retVal; 
	}
}
