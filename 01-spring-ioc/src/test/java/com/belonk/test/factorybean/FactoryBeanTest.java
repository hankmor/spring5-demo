package com.belonk.test.factorybean;

import com.belonk.factorybean.bean.CarFactoryBean;
import com.belonk.factorybean.config.FactoryBeanConfig;
import com.belonk.test.BaseIOCTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 2020/3/18.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
public class FactoryBeanTest extends BaseIOCTest {
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
    public void testFactoryBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FactoryBeanConfig.class);
        //获取容器中的carFactoryBean实例
        Object car = context.getBean("carFactoryBean");
        // 如果CarFactoryBean的getObject方法返回null，则carFactoryBean.getClass返回nullBean：
        // class org.springframework.beans.factory.support.NullBean
        // 否则，返回创建的Car的class：
        // class com.belonk.factorybean.bean.Car
        System.out.println(car.getClass());
        // 默认是单例的
        Object anotherCar = context.getBean("carFactoryBean");
        // 默认情况下输出为true，如果CarFactoryBean的isSingleton方法返回false，则实例变成了prototype的
        // 每次获取都是一个新的实例，所以这里输出为false
        System.out.println(car == anotherCar);

        // carFactoryBean.getClass()返回产生的bean的class，那么如果返回CarFactoryBean本身呢？
        // 只需要在bean name前加一个"&"前缀即可，见BeanFactory的FACTORY_BEAN_PREFIX定义
        Object carFactoryBean = context.getBean("&carFactoryBean");
        assert carFactoryBean.getClass().equals(CarFactoryBean.class);
        CarFactoryBean factoryBean = (CarFactoryBean) carFactoryBean;
        if (factoryBean.getObject() == null) {
            assert "org.springframework.beans.factory.support.NullBean".equals(car.getClass().getCanonicalName());
        } else {
            assert "com.belonk.factorybean.bean.Car".equals(car.getClass().getCanonicalName());
        }

        if (factoryBean.isSingleton()) {
            assert car == anotherCar;
        } else {
            assert car != anotherCar;
        }
    }
}