package com.belonk.autowire.config;

import com.belonk.autowire.bean.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * Created by sun on 2020/3/23.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
@Configuration
@ComponentScan("com.belonk.autowire")
public class AutowireBeanConfig {
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
     * 在容器中再添加一个Bean，指定其名称。
     * <p>
     * 容器中会存在两个类型为NecessaryBean的bean，一个是被扫描出来的，另一个是这里显示申明的。
     *
     * @return bean
     */
    @Bean(name = "necessaryBean2")
    public NecessaryBean necessaryBean2() {
        return new NecessaryBean("necessaryBean2");
    }

    /*
     * 添加两个PrimaryBean
     */

    @Bean//(autowireCandidate = false) // 设置当前bean不是首选被自动注入的
    public PrimaryBean primaryBean1() {
        return new PrimaryBean("primaryBean1");
    }

    /*
     * 这里标注了@Primary注解，优先使用primaryBean2。
     * 如果没有标注，则会抛出NoUniqueBeanDefinitionException异常，因为同一类型的bean容器中存在多个，
     * Spring不知道用哪一个来装配。
     *
     * 另外，@Bean注解支持autowireCandidate属性，可以用来设置当前bean不是自动注入的候选bean，即：自动注入不会考虑注入当前bean给其他bean
     * 如果其他bean依赖的bean仅有一个实例，而且标注了autowireCandidate=false，那么Spring找不到可自动注入的候选bean会抛出
     * NoSuchBeanDefinitionException异常
     */

    @Bean
    @Primary // 设置当前bean是首选自动注入bean
    public PrimaryBean primaryBean2() {
        return new PrimaryBean("primaryBean2");
    }

    @Bean
    @Primary
    public ResourceBean resourceBean1() {
        return new ResourceBean("resourceBean1");
    }

    @Bean
    public ResourceBean resourceBean2() {
        return new ResourceBean("resourceBean2");
    }

    @Bean
    @Primary
    public InjectBean injectBean1() {
        return new InjectBean("injectBean1");
    }

    @Bean
    public InjectBean injectBean2() {
        return new InjectBean("injectBean2");
    }

    // 测试参数依赖

    /*
     * Bean car依赖一个Motor对象，该Motor对象容器里边已经存在，则会使用容器中的。
     * Motor参数加了@Autowire，可以省略
     */
    @Bean
    public Car car(@Autowired Motor motor) {
        return new Car(motor);
    }
}