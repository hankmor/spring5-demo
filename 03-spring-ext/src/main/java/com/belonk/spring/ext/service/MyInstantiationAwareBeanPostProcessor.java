package com.belonk.spring.ext.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * InstantiationAwareBeanPostProcessor在bean实例化前后执行，即是在bean创建前后，初始化之前执行。
 * 与BeanPostProcessor的区别在于，BeanPostProcessor在bean已经创建完成了，在初始化前后执行，而
 * InstantiationAwareBeanPostProcessor是在bean创建前后。
 * <p>
 * Created by sun on 2020/4/27.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
@Component
public class MyInstantiationAwareBeanPostProcessor implements InstantiationAwareBeanPostProcessor {
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

	// 在Bean创建之前执行回调，可以自定义bean的创建，比如包装bean为代理对象
	// 如果返回null，则会执行默认创建流程，否则bean的创建流程中断，spring会使用返回的bean对象
	public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor -> postProcessBeforeInstantiation");
		System.out.println("    -> beanClass : " + beanClass);
		System.out.println("    -> beanName : " + beanName);
		return null;
	}

	// 实例创建完成后、在属性赋值之前回调，可以用于自定义属性赋值，如果返回true(通常都是true)则会执行默认的属性赋值流程
	// 如果是false则会终止后续InstantiationAwareBeanPostProcessor的调用
	public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor -> postProcessAfterInstantiation");
		System.out.println("    -> bean : " + bean);
		System.out.println("    -> beanName : " + beanName);
		return false;
	}

	// 在bean的属性值应用到属性之前回调，如果实现提供自定义的后处理属性值实现，则应返回null（默认值），否则返回pv
	public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
		System.out.println("MyInstantiationAwareBeanPostProcessor -> postProcessProperties");
		System.out.println("    -> pvs : " + pvs);
		System.out.println("    -> bean : " + bean);
		System.out.println("    -> beanName : " + beanName);
		return null;
	}
}