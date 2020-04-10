package com.belonk.aop.basic.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * 切面(aspect)：切面是对横切关注点的抽象。
 * 连接点(joinpoint)：被拦截到的点。在spring中,这些点指的是方法,因为spring只支持方法类型的连接点。
 * 切入点(pointcut)：对连接点如何拦截的定义
 * 通知(advice): 指拦截到连接点之后所要做的事情
 * 目标对象(target): 被代理的对象
 * 织入(weave): 指把切面应用到目标对象来创建新的代理对象的过程
 * 引入(introduction): 在不修改类代码的前提下, Introduction可以在运行期为类动态地添加一些方法或属性
 * <p>
 * 使用@Aspect注意定义一个切面，用来对CalcService的divide方法进行扩展，增加功能。
 * <p>
 * Created by sun on 2020/4/10.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
@Aspect
public class CalcAspect {
	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *
	 * Static fields/constants/initializer
	 *
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */



	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *
	 * Instance fields
	 *
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */



	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *
	 * Constructors
	 *
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */



	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 *
	 * Methods
	 *
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 */

	/**
	 * 使用@Pointcut定义切点，该注解用在方法上，仅标识切点的信息，方法的内容应该是空的，因为它没有意义。
	 * 注解使用AspectJ表达式来定义切入点范围.
	 */
	@Pointcut("execution(* com.belonk.aop..CalcService.divide(..))")
	public void dividePointcut() {
	}

	/*
	前置通知：在一个方法执行前，执行通知
	后置通知：在一个方法执行后，不考虑执行结果，执行通知
	异常通知：在一个方法执行之后，只有在方法抛出异常时，才执行通知
	最终通知：在一个方法执行之后，只有在方法成功完成时，才能执行通知
	环绕通知：在方法调用前后，执行通知
	 */

	/**
	 * 使用@Before注解定义前置通知.
	 * <p>
	 * 注解属性可以引用定义切入点的方法名称，也可以使用AspectJ表达式自定义切入点
	 */
	@Before("dividePointcut()")
	public void doBefore(JoinPoint joinPoint) {
		System.out.println("doBefore, joinPoint : " + joinPoint.getSignature());
	}

	/**
	 * 后置通知
	 */
	@After("dividePointcut()")
	public void doAfter(JoinPoint joinPoint) {
		System.out.println("doAfter, joinPoint: " + joinPoint.getSignature());
	}

	/**
	 * 最终通知
	 */
	@AfterReturning(pointcut = "dividePointcut()", returning = "returnValue")
	public void doAfterReturning(JoinPoint joinPoint, Object returnValue) {
		System.out.println("doAfterReturning: " + joinPoint.getSignature() + ", returnValue: " + returnValue);
	}

	/**
	 * 异常通知
	 */
	@AfterThrowing(pointcut = "dividePointcut()", throwing = "ex")
	public void doAfterThrowing(JoinPoint joinPoint, Exception ex) {
		System.out.println("doAfterThrowing, joinPoint : " + joinPoint.getSignature() + ", Exception: " + ex.getMessage());
	}

	/**
	 * 环绕通知
	 */
	@Around("dividePointcut()")
	public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("doAround start, joinPoint: " + joinPoint.getSignature());
		Object ret = joinPoint.proceed();
		System.out.println("doAround end, joinPoint: " + joinPoint.getSignature());
		return ret;
	}
}