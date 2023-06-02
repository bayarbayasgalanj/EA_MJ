package cs544.bank.service.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Aspect
@Component
public class StopWatchAdvice {

    @Around("execution(* cs544.bank.service.*.*(..))")
	public Object methodTimer(ProceedingJoinPoint call ) throws Throwable { 
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
