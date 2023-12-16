package com.techs.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.techs.services.EmployeeService;

@Aspect
@Component
public class LoggingAspect {

	private static final Logger log = LogManager.getLogger(EmployeeService.class);
	long startTime = 0;
	long endtime  = 0;

	@Pointcut("execution(* com.techs..*(..)))")
	public void candidateIdPointcut() {
	}

	// @Before("execution(* com.techs..*(..)))")
	@Before("candidateIdPointcut()")
	public void logBeforeAllMethodCall(JoinPoint joinPoint) throws Throwable {
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		log.info("Execution started with Class & Method===> " + className + ":: " + methodName);
		startTime = System.currentTimeMillis();
	}

	// @After("execution(* com.techs..*(..)))")
	@After("candidateIdPointcut()")
	public void logAfterAllMethodCall(JoinPoint joinPoint) throws Throwable {
		endtime = System.currentTimeMillis();
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		String className = methodSignature.getDeclaringType().getSimpleName();
		String methodName = methodSignature.getName();
		log.info("Execution ended with Class & Method===> " + className + ":: " + methodName
				+ ". Time taken for Execution is : " + (endtime - startTime) + "ms");
	}

	@AfterThrowing(pointcut = "candidateIdPointcut()", throwing = "e")
	public void logAfterThrowingAllMethodCall(JoinPoint joinPoint, Exception e) throws Throwable {
		log.debug(e.getMessage());
	}

//private final Logger log = LoggerFactory.getLogger(this.getClass());

//	@Around("execution(* com.techs..*(..)))")
//    public Object logMethodExecutionTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
//        final StopWatch stopWatch = new StopWatch();
//        //calculate method execution time
//        stopWatch.start();
//        Object result = proceedingJoinPoint.proceed();
//        stopWatch.stop();
//        //Log method execution time
//        log.info("Logging AOP - Execution time of "
//                + methodSignature.getDeclaringType().getSimpleName() // Class Name
//                + "." + methodSignature.getName() + " " // Method Name
//                + ":: " + stopWatch.getTotalTimeMillis() + " ms");
//        return result;
//    }

}
