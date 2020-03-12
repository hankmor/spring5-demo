package com.belonk.test.componentScan;

import com.belonk.bean.User;
import com.belonk.config.*;
import com.belonk.controller.UserController;
import com.belonk.test.BaseIOCTest;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by sun on 2020/2/21.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
public class ComponentScanTest extends BaseIOCTest {
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
    public void testBasicComponentScan() {
        // 构造基于注解配置的IOC容器，传入配置类
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(BasicComponentScanConfig.class);
        User user = applicationContext.getBean(User.class);
        System.out.println("user : " + user);
		/*~:
		user : User(name=spring)
		*/
    }

    @Test
    public void testComponentScanFilter() {
        // 被@Controller标注且未实现MyFilter接口的类会被扫描
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanFilterConfig.class);
        printBeans(applicationContext);
		/*~:
		bean count: 7
		org.springframework.context.annotation.internalConfigurationAnnotationProcessor
		org.springframework.context.annotation.internalAutowiredAnnotationProcessor
		org.springframework.context.annotation.internalCommonAnnotationProcessor
		org.springframework.context.event.internalEventListenerProcessor
		org.springframework.context.event.internalEventListenerFactory
		componentScanFilterConfig
		myUserController
		 */
    }

    @Test
    public void testCustomFilterComponentScan() {
        // 包含user或者User的bean都会被扫描
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(CustomFilterConfig.class);
        printBeans(applicationContext);
		/*~:
		bean count: 11
		org.springframework.context.annotation.internalConfigurationAnnotationProcessor
		org.springframework.context.annotation.internalAutowiredAnnotationProcessor
		org.springframework.context.annotation.internalCommonAnnotationProcessor
		org.springframework.context.event.internalEventListenerProcessor
		org.springframework.context.event.internalEventListenerFactory
		customFilterConfig
		user
		myUserController
		userController
		userDao
		userService
		 */
    }

    @Test
    public void testComponentScanWithLazyBean() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(ComponentScanLazyConfig.class);
        System.out.println("容器创建完成...");
        // 由于@ComponentScan配置了lazyInit=true，所以在获取bean时在创建bean，而不是容器创建完成就已经创建
        UserController userController = applicationContext.getBean(UserController.class);
        System.out.println("获取UserController完成...");
		/*~:
		容器创建完成...
        创建UserController...
        获取UserController完成...
		 */
    }

    @Test
    public void testMultiComoponentScans() {
        // 配置了多个ComponentScan，自动扫描@Service和@Controller
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MultiComponentScanConfig.class);
        printBeans(context);
        /*~:
        bean count: 9
        org.springframework.context.annotation.internalConfigurationAnnotationProcessor
        org.springframework.context.annotation.internalAutowiredAnnotationProcessor
        org.springframework.context.annotation.internalCommonAnnotationProcessor
        org.springframework.context.event.internalEventListenerProcessor
        org.springframework.context.event.internalEventListenerFactory
        multiComponentScanConfig
        userService
        myUserController
        userController

         */
    }
}