package com.belonk.autowire.test;

import com.belonk.autowire.bean.*;
import com.belonk.autowire.config.AutowireBeanConfig;
import com.belonk.autowire.config.ProfileBeanConfig;
import com.belonk.autowire.config.ProfileBeanConfig1;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

/**
 * Created by sun on 2020/3/23.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class AutowireConfigTest {
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
    public void testAutowire() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AutowireBeanConfig.class);

        BeanHolder       beanHolder           = context.getBean(BeanHolder.class);
        NecessaryBean    necessaryBean        = beanHolder.getNecessaryBean();
        NecessaryBean    necessaryBean1       = beanHolder.getNecessaryBean2();
        NecessaryBean    necessaryBean2       = beanHolder.getNecessaryBean3();
        MayNotExistsBean mayNotExistsBean     = beanHolder.getMayNotExistsBean();
        PrimaryBean      primaryBean          = beanHolder.getPrimaryBean();
        ResourceBean     myResourceBean       = beanHolder.getMyResourceBean();
        ResourceBean     resourceBean         = beanHolder.getResourceBean();
        ResourceBean     annotherResourceBean = beanHolder.getAnnotherResourceBean();
        InjectBean       injectBean           = beanHolder.getInjectBean();
        InjectBean       annotherInjectBean   = beanHolder.getAnnotherInjectBean();

        assert "necessaryBean".equals(necessaryBean.getName());
        assert "necessaryBean2".equals(necessaryBean1.getName());
        assert necessaryBean1 == necessaryBean2;
        assert mayNotExistsBean == null;
        assert "primaryBean2".equals(primaryBean.getName());
        assert "resourceBean1".equals(myResourceBean.getName());
        assert "resourceBean1".equals(resourceBean.getName());
        assert "resourceBean2".equals(annotherResourceBean.getName());
        assert "injectBean1".equals(injectBean.getName());
        assert "injectBean2".equals(annotherInjectBean.getName());

        Motor motor = context.getBean(Motor.class);
        Car   car   = context.getBean(Car.class);
        assert motor == car.getMotor();

        SpringAware springAware = context.getBean(SpringAware.class);
        System.out.println(springAware);
    }

    @Test
    public void testProfile1() {
        // 通过设置运行时参数的方式激活profile，运行时设置参数: -Dspring.profiles.active=dev
        AnnotationConfigApplicationContext context     = new AnnotationConfigApplicationContext(ProfileBeanConfig.class);
        Map<String, Env>                   beansOfType = context.getBeansOfType(Env.class);
        assert beansOfType.size() == 2;
        assert beansOfType.containsKey("uatBean");
        assert beansOfType.containsKey("devBean");
        for (String s : beansOfType.keySet()) {
            System.out.println("beanName : " + s);
            System.out.println("env name : " + beansOfType.get(s).name());
        }
        context.close();
    }

    @Test
    public void testProfile2() {
        // 通过编码的方式激活profile
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        //~ 先设置激活的Profile，然后再启动容器
        // 激活profile，可以设置多个，该值对应@Profile注解的value属性
        context.getEnvironment().setActiveProfiles("dev", "test");
        context.register(ProfileBeanConfig.class);
        context.refresh();
        Map<String, Env> beansOfType = context.getBeansOfType(Env.class);
        assert beansOfType.size() == 3;
        assert beansOfType.containsKey("uatBean");
        assert beansOfType.containsKey("devBean");
        assert beansOfType.containsKey("testBean");
        for (String s : beansOfType.keySet()) {
            System.out.println("beanName : " + s);
            System.out.println("env name : " + beansOfType.get(s).name());
        }
        context.close();
    }

    @Test
    public void testProfile3() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("uat");
        context.register(ProfileBeanConfig1.class);
        context.refresh();
        Map<String, Env> beansOfType = context.getBeansOfType(Env.class);
        // 激活的profile未uat，ProfileBeanConfig1下一个Bean都不会注册
        assert beansOfType.size() == 0;
        context.close();
    }

    @Test
    public void testProfile4() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(ProfileBeanConfig1.class);
        context.refresh();
        Map<String, Env> beansOfType = context.getBeansOfType(Env.class);
        // 激活的profile未dev，ProfileBeanConfig1注册了两个bean
        assert beansOfType.size() == 2;
        assert beansOfType.containsKey("uatBean");
        assert beansOfType.containsKey("devBean");
        for (String s : beansOfType.keySet()) {
            System.out.println("beanName : " + s);
            System.out.println("env name : " + beansOfType.get(s).name());
        }
        context.close();
    }
}