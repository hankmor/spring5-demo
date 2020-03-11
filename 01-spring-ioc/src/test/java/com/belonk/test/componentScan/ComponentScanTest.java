package com.belonk.test.componentScan;

import com.belonk.bean.User;
import com.belonk.config.BasicComponentScanConfig;
import com.belonk.config.ComponentScanFilterConfig;
import com.belonk.config.CustomFilterConfig;
import com.belonk.test.BaseIOCTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 2020/2/21.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ComponentScanTest extends BaseIOCTest {
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
	public void testBasicComponentScan() {
		// 构造基于注解配置的IOC容器，传入配置类
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicComponentScanConfig.class);
		User                               user               = applicationContext.getBean(User.class);
		System.out.println("user : " + user);
		/*~:
		user : User(name=spring)
		*/
	}

	@Test
	public void testComponentScanFilter() {
		// 被@Controller标注且未实现MyFilter接口的类会被扫描
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanFilterConfig.class);
		printBeans(applicationContext);
		/*~:
		bean count: 7
		org.springframework.context.annotation.internalConfigurationAnnotationProcessor
		org.springframework.context.annotation.internalAutowiredAnnotationProcessor
		org.springframework.context.annotation.internalCommonAnnotationProcessor
		org.springframework.context.event.internalEventListenerProcessor
		org.springframework.context.event.internalEventListenerFactory
		componentScanFilterConfig
		myUserController
		 */
	}

	@Test
	public void testCustomFilterComponentScan() {
		// 包含user或者User的bean都会被扫描
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CustomFilterConfig.class);
		printBeans(applicationContext);
		/*~:
		bean count: 11
		org.springframework.context.annotation.internalConfigurationAnnotationProcessor
		org.springframework.context.annotation.internalAutowiredAnnotationProcessor
		org.springframework.context.annotation.internalCommonAnnotationProcessor
		org.springframework.context.event.internalEventListenerProcessor
		org.springframework.context.event.internalEventListenerFactory
		customFilterConfig
		user
		myUserController
		userController
		userDao
		userService
		 */
	}
}