package com.belonk.test;

import com.belonk.bean.MyBean;
import com.belonk.config.SpringConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 2020/2/21.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class AnnotationIOCTest {
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
	public void test1() {
		// 构造基于注解配置的IOC容器，传入配置类
		AnnotationConfigApplicationContext applicationContext  = new AnnotationConfigApplicationContext(SpringConfig.class);
		int                                beanDefinitionCount = applicationContext.getBeanDefinitionCount();
		String[]                           beanDefinitionNames = applicationContext.getBeanDefinitionNames();
		MyBean                             myBean              = applicationContext.getBean(MyBean.class);
		System.out.println("bean count: " + beanDefinitionCount);
		for (String beanDefinitionName : beanDefinitionNames) {
			System.out.println(beanDefinitionName);
		}
		System.out.println("myBean : " + myBean);
		/*~:
		bean count: 7
		org.springframework.context.annotation.internalConfigurationAnnotationProcessor
		org.springframework.context.annotation.internalAutowiredAnnotationProcessor
		org.springframework.context.annotation.internalCommonAnnotationProcessor
		org.springframework.context.event.internalEventListenerProcessor
		org.springframework.context.event.internalEventListenerFactory
		springConfig
		bean
		myBean : MyBean(name=spring)
		 */
	}
}