package com.belonk.spring.beanfactory;

import com.belonk.spring.common.UserService;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * Created by sun on 2020/4/23.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class UseDefaultListableBeanFactory {
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
		// 创建Resource
		ClassPathResource classPathResource = new ClassPathResource("beans.xml");
		// 创建BeanFactory
		DefaultListableBeanFactory defaultListableBeanFactory = new DefaultListableBeanFactory();
		// 创建xml bean定义信息读取器，需要传入bean定义注册表，而DefaultListableBeanFactory实现了BeanDefinitionRegistry
		XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(defaultListableBeanFactory);
		// 加载bean定义信息
		int definitionCount = xmlBeanDefinitionReader.loadBeanDefinitions(classPathResource);
		System.out.println("共加载的bean定义数量：" + definitionCount);

		BeanDefinition userServiceBeanDef = defaultListableBeanFactory.getBeanDefinition("userService");
		System.out.println(userServiceBeanDef);
		UserService userService = (UserService) defaultListableBeanFactory.getBean("userService");
		System.out.println(userService.getUser());
	}
}