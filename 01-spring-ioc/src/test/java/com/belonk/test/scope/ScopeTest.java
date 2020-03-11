package com.belonk.test.scope;

import com.belonk.bean.LazyBean;
import com.belonk.bean.PrototypeBean;
import com.belonk.bean.User;
import com.belonk.config.ScopeConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 2020/2/21.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ScopeTest {
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
	public void testScopeDefault() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
		System.out.println("IOC容器创建完成...");
		User user  = applicationContext.getBean(User.class);
		User aUser = applicationContext.getBean(User.class);
		System.out.println(user == aUser);
		/*~:
		创建User对象...
		IOC容器创建完成...
		true
		*/
	}

	@Test
	public void testScopePrototype() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
		System.out.println("IOC容器创建完成...");
		PrototypeBean prototypeBean1 = applicationContext.getBean(PrototypeBean.class);
		PrototypeBean prototypeBean2 = applicationContext.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1 == prototypeBean2);
		/*~:
		IOC容器创建完成...
		创建PrototypeBean对象...
		创建PrototypeBean对象...
		false
		*/
	}

	@Test
	public void testLazy() {
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
		System.out.println("IOC容器创建完成...");
		LazyBean lazyBean1 = applicationContext.getBean(LazyBean.class);
		LazyBean lazyBean2 = applicationContext.getBean(LazyBean.class);
		System.out.println(lazyBean1 == lazyBean2);
		/*~:
		IOC容器创建完成...
		创建LazyBean...
		true
		*/
	}
}