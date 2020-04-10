package com.belonk.aop.basic.test;

import com.belonk.aop.basic.config.CalcAopConfig;
import com.belonk.aop.basic.service.CalcService;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 2020/4/10.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class CalcServiceTest {
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

	@Test
	public void testDivide() {
		AnnotationConfigApplicationContext context     = new AnnotationConfigApplicationContext(CalcAopConfig.class);
		CalcService                        calcService = context.getBean(CalcService.class);
		int                                a           = 8, b = 2;
		int                                result      = calcService.divide(a, b);
		System.out.println(a + " divide " + b + " is " + result);

		a = 8;
		b = 0;
		result = calcService.divide(a, b);
		System.out.println(a + " divide " + b + " is " + result);

		context.close();

		/*~:
		doAround start, joinPoint: int com.belonk.aop.basic.service.CalcService.divide(int,int)
		doBefore, joinPoint : int com.belonk.aop.basic.service.CalcService.divide(int,int)
		doAround end, joinPoint: int com.belonk.aop.basic.service.CalcService.divide(int,int)
		doAfter, joinPoint: int com.belonk.aop.basic.service.CalcService.divide(int,int)
		doAfterReturning: int com.belonk.aop.basic.service.CalcService.divide(int,int), returnValue: 4
		8 divide 2 is 4
		doAround start, joinPoint: int com.belonk.aop.basic.service.CalcService.divide(int,int)
		doBefore, joinPoint : int com.belonk.aop.basic.service.CalcService.divide(int,int)
		doAfter, joinPoint: int com.belonk.aop.basic.service.CalcService.divide(int,int)
		doAfterThrowing, joinPoint : int com.belonk.aop.basic.service.CalcService.divide(int,int), Exception: / by zero
		 */
	}
}