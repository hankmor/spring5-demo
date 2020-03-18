package com.belonk.scope.config;

import com.belonk.scope.bean.LazyBean;
import com.belonk.scope.bean.PrototypeBean;
import com.belonk.componentscan.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

/**
 * Created by sun on 2020/2/22.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
@Configuration
public class ScopeConfig {
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
	 * 默认情况下，Spring管理的bean都是单例的。在IOC容器完成创建之前，会创建所有bean。
	 *
	 * @return
	 */
	@Bean
	public User user() {
		System.out.println("创建User对象...");
		User user = new User();
		user.setName("spring");
		return user;
	}

	/**
	 * 默认情况下，Spring管理的bean都是单例的。在IOC容器完成创建之前，会创建所有bean。
	 * <p>
	 * 可以通过@Scope注解来标识Spring 管理的bean的范围，包括以下值：
	 * - singleton: 单例，只有一个bean实例，默认值
	 * - prototype: 原型，每次获取bean斗殴创建一个新实例
	 * - request: 每次请求创建一个bean实例
	 * - session: 每个session一个bean实例
	 * 其中，request和session需要在web环境中。
	 * <p>
	 * 如果scope为prototype，则容器创建时并不会创建bean，而是在获取bean时创建bean。
	 *
	 * @return bean
	 */
	@Bean
	@Scope("prototype")
	public PrototypeBean prototypeBean() {
		System.out.println("创建PrototypeBean对象...");
		return new PrototypeBean();
	}

	/**
	 * 默认情况下，单例bean会在容器创建时创建，可以使用@Lazy注解来使bean被延迟加载，被延迟加载的bean并不会在容器创建
	 * 时创建，而是在第一次获取bean时创建。
	 *
	 * @return bean
	 */
	@Bean
	@Lazy
	public LazyBean lazyBean() {
		System.out.println("创建LazyBean...");
		return new LazyBean();
	}
}