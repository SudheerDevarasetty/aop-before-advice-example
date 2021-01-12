package com.javatpoint.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import com.javatpoint.model.Account;

@Aspect
@Component
public class EmployeeServiceAspect {
	@Before(value = "execution(* com.javatpoint.service.EmployeeService.*(..)) and args(empId, fname, sname)")
	public void beforeAdvice(JoinPoint joinPoint, String empId, String fname, String sname) {
		System.out.println("Before method:" + joinPoint.getSignature());
		System.out.println(
				"Creating Employee with first name - " + fname + ", second name - " + sname + " and id - " + empId);
	}

	@After(value = "execution(* com.javatpoint.service.EmployeeService.*(..)) and args(empId)")
	public void afterAdvice(JoinPoint joinPoint, String empId) {
		System.out.println("After method:" + joinPoint.getSignature());
		System.out.println("Deleting Employee  id - " + empId);
	}

	// Displays all the available methods i.e. the advice will be called for all the
	// methods
	@Pointcut(value = "execution(* com.javatpoint.service.BankService.*(..))")
	private void logDisplayingBalance() {
		System.out.println("The method logDisplayingBalance() before invokation of the method ");
	}

	@Around(value = "logDisplayingBalance()")
	public void aroundAdvice(ProceedingJoinPoint jp) throws Throwable {
		System.out.println(
				"The method aroundAdvice() before invokation of the method " + jp.getSignature().getName() + " method");
		try {
			jp.proceed();
		} finally {

		}
		System.out.println(
				"The method aroundAdvice() after invokation of the method " + jp.getSignature().getName() + " method");
	}

	@AfterReturning(value = "execution(* com.javatpoint.service.impl.AccountServiceImpl.*(..))", returning = "account")
	public void afterReturningAdvice(JoinPoint joinPoint, Account account) {
		System.out.println("After Returing method:" + joinPoint.getSignature());
		System.out.println(account);
	}

	@AfterThrowing(value = "execution(* com.javatpoint.service.impl.AccountServiceImpl.*(..))", throwing = "ex")
	public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {
		System.out.println("After Throwing exception in method:" + joinPoint.getSignature());
		System.out.println("Exception is:" + ex.getMessage());
	}
}
