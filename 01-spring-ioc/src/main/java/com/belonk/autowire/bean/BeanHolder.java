package com.belonk.autowire.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by sun on 2020/3/23.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
@Data
@Component
public class BeanHolder {
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
     * @Autowired注解：
     * 1、按照类型自动装配(注入)bean。默认情况下，被注入的bean必须存在于IOC容器，否则抛出异常。如果按照类型能够找到多个
     * bean，则Spring会再按照被注入对象的属性名称来装配bean，比如这里的necessaryBean和necessaryBean2会注入不同的bean。
     * 2、可以指定其required实行为false，来表示：如果b被注入的bean能找到就自动装配，否则不装配
     * 3、如果非要按照bean名称来注入，则需要结合@Qualifier注解
     * 4、如果同一类型的bean存在多个，按照属性名称也找不到对应的bean时，Spring会抛出NoUniqueBeanDefinitionException异常，
     * 此时，可以使用@Primary注解，表示优先注入的bean
     *
     * @Aualifier注解：限定被注入的bean的名称，结合@Autowired注解使用
     * @Primary注解：多个同类型的bean，被该注解标注的bean会被优先使用，而不会抛出异常
     */

    @Autowired
    private NecessaryBean necessaryBean;

    /*
     *这里类型为NecessaryBean的bean有两个，那么Spring再按照属性名称去装配bean，即：再去从IOC容器中查找名称为属性名称
     * necessaryBean2的bean，然后装配
     */

    @Autowired
    private NecessaryBean necessaryBean2;

    /*
     * 这里使用了@Qualifier来限定注入名称为necessaryBean2的bean，所以necessaryBean3跟necessaryBean2是相同的bean。
     * 即：necessaryBean2 == necessaryBean3 为true
     */

    @Autowired
    @Qualifier("necessaryBean2")
    private NecessaryBean necessaryBean3;

    /*
     * MayNotExistsBean在IOC容器中并不存在(并未添加到容器)，所以默认自动装备会抛出异常，可以指定
     * @Autowired(required = false)来表示：容器有这个Bean就自动注入，没有就不自动注入了，不会抛出异常。
     */

    @Autowired(required = false)
    private MayNotExistsBean mayNotExistsBean;

    /**
     * 容器中存在两个PrimaryBean，自动注入时使用哪个？容器会抛出NoUniqueBeanDefinitionException异常，可以使用@Primary注解
     * 来表示哪一个bean会被优先使用
     */
    @Autowired
    private PrimaryBean primaryBean;

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


}