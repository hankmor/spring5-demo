package com.belonk.spring.ext.service;

import com.belonk.spring.ext.bean.Monkey;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 后置处理器：在容器中Bean初始化前后自定义一些操作。
 * <p>
 * Spring容器的bean都会执行后置处理器。
 * <p>
 * Created by sun on 2020/3/19.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
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
	 * 在传入的bean属性设置之后、初始化之前调用。
	 * <p>
	 * 例如：在bean设置属性之后，且在调用afterPropertiesSet之前，会调用该方法。
	 *
	 * @param bean     当前调用postProcessBeforeInitialization方法的bean
	 * @param beanName 当前bean的名称
	 * @return 最后被使用的bean，可以是传入的bean，也可以对其进行包装
	 * @throws BeansException 异常
	 */
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor -> postProcessBeforeInitialization");
		// 此时，Bean的属性已经有值了
		if (bean instanceof Monkey) {
			if ("monkeyking".equals(beanName)) {
				((Monkey) bean).setName("sunwukong");
			}
			System.out.println("    > Monkey name: " + ((Monkey) bean).getName());
		}
		System.out.println("    > bean name : " + beanName + ", bean type : " + bean.getClass());
		return bean;
	}

	/**
	 * 在传入的bean初始化完成之后调用。
	 * <p>
	 * 如果Bean时有FactoryBean生产的，则也会执行该方法。
	 *
	 * @param bean     当前执行后置处理器的bean
	 * @param beanName 当前bean名称
	 * @return 最后被使用的bean，可以是传入的bean，也可以对其进行包装
	 * @throws BeansException 异常
	 */
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("MyBeanPostProcessor -> postProcessAfterInitialization");
		if (bean instanceof Monkey) {
			System.out.println("    > Monkey name: " + ((Monkey) bean).getName());
		}
		System.out.println("    > bean name : " + beanName + ", bean type : " + bean.getClass());
		return bean;
	}
}