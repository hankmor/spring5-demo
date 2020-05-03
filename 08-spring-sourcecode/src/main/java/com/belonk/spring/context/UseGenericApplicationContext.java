package com.belonk.spring.context;

import com.belonk.spring.common.UserService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by sun on 2020/4/23.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class UseGenericApplicationContext {
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

	public static void main(String[] args) {
		/*
		 *  GenericApplicationContext内部持有一个DefaultListableBeanFactory的引用，大多数工作都交给它来完成
		 */
		// 创建classpath resource
		ClassPathResource classPathResource = new ClassPathResource("beans.xml");
		// 创建GenericApplicationContext，它实现了BeanDefinitionRegistry
		GenericApplicationContext genericApplicationContext = new GenericApplicationContext();
		// 创建XmlBeanDefinitionReader
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(genericApplicationContext);
		// 加载bean定义
		int definitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		System.out.println("共加载的bean定义数量：" + definitionCount);

		// 刷新容器，从而启动容器
		genericApplicationContext.refresh();

		BeanDefinition userServiceBeanDef = genericApplicationContext.getBeanDefinition("userService");
		System.out.println(userServiceBeanDef);
		UserService userService = (UserService) genericApplicationContext.getBean("userService");
		System.out.println(userService.getUser());
	}
}