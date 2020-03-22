package com.belonk.lifecycle.test;

import com.belonk.lifecycle.config.BeanLifeCycleConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 2020/3/18.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class LifeCycleTest {
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
    public void testLifeCycle1() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanLifeCycleConfig.class);
        // 默认bean都是单例的，在容器初始化完成后，会调用bean的构造器和初始化方法
        System.out.println("容器初始化完成...");
        Object lifeCycleBean5FactoryBean = context.getBean("lifeCycleBean5FactoryBean");
        Object bean                      = context.getBean("&lifeCycleBean5FactoryBean");
        // 容器自动退出，则不会调用bean的销毁方法，需要手动关闭容器
        context.close();
        /*~:
        postProcessBeforeInitialization, bean name : beanLifeCycleConfig, bean type : class com.belonk.lifecycle.config.BeanLifeCycleConfig$$EnhancerBySpringCGLIB$$1a66d054
        postProcessAfterInitialization, bean name : beanLifeCycleConfig, bean type : class com.belonk.lifecycle.config.BeanLifeCycleConfig$$EnhancerBySpringCGLIB$$1a66d054
        postProcessBeforeInitialization, bean name : lifeCycleBean5FactoryBean, bean type : class com.belonk.lifecycle.bean.LifeCycleBean5FactoryBean
        postProcessAfterInitialization, bean name : lifeCycleBean5FactoryBean, bean type : class com.belonk.lifecycle.bean.LifeCycleBean5FactoryBean
        invoke LifeCycleBean constructor
        postProcessBeforeInitialization, bean name : lifeCycleBean, bean type : class com.belonk.lifecycle.bean.LifeCycleBean
        invoke LifeCycleBean init method.
        postProcessAfterInitialization, bean name : lifeCycleBean, bean type : class com.belonk.lifecycle.bean.LifeCycleBean
        invoke LifeCycleBean2 constructor
        postProcessBeforeInitialization, bean name : lifeCycleBean2, bean type : class com.belonk.lifecycle.bean.LifeCycleBean2
        invoke LifeCycleBean2 afterPropertiesSet method
        postProcessAfterInitialization, bean name : lifeCycleBean2, bean type : class com.belonk.lifecycle.bean.LifeCycleBean2
        invoke LifeCycleBean3 constructor ...
        postProcessBeforeInitialization, bean name : lifeCycleBean3, bean type : class com.belonk.lifecycle.bean.LifeCycleBean3
        invoke LifeCycleBean3 init method ...
        postProcessAfterInitialization, bean name : lifeCycleBean3, bean type : class com.belonk.lifecycle.bean.LifeCycleBean3
        invoke LifeCycleBean4 constructor ...
        LifeCycleBean4 name: lifeCycleBean4
        postProcessBeforeInitialization, bean name : lifeCycleBean4, bean type : class com.belonk.lifecycle.bean.LifeCycleBean4
        invoke LifeCycleBean4 init method ...
        LifeCycleBean4 name: lifeCycleBean4
        postProcessAfterInitialization, bean name : lifeCycleBean4, bean type : class com.belonk.lifecycle.bean.LifeCycleBean4
        容器初始化完成...
        invoke LifeCycleBean5 constructor ...
        postProcessAfterInitialization, bean name : lifeCycleBean5FactoryBean, bean type : class com.belonk.lifecycle.bean.LifeCycleBean5
        invoke LifeCycleBean4 destory method ...
        invoke LifeCycleBean3 destory method ...
        invoke LifeCycleBean2 destroy method
        invoke LifeCycleBean destroy method.
         */
    }
}