package cs544;

import org.aspectj.lang.ProceedingJoinPoint;

public interface ICustomerDAO {
	public void save(Customer customer) ;
	// public Object invoke(ProceedingJoinPoint call )  throws Throwable;
}
