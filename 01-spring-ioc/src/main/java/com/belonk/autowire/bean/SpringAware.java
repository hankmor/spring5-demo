package com.belonk.autowire.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.*;
import org.springframework.context.annotation.ImportAware;
import org.springframework.context.weaving.LoadTimeWeaverAware;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.instrument.classloading.LoadTimeWeaver;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringValueResolver;

/**
 * 要使用Spring底层的Bean，可以使用Spring提供的{@link org.springframework.beans.factory.Aware}接口，它采用回调模式，将底
 * 层Bean通过XxxAware传递给回调方法，从而被应用使用。
 *
 *
 *
 * <p>
 * Created by sun on 2020/3/30.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
@Component
public class SpringAware implements
        // 用于获取ApplicationContext
        ApplicationContextAware,
        // 获取Spring设置的bean名称
        BeanNameAware,
        // 获取加载当前Bean的类加载器
        BeanClassLoaderAware,
        // 获取LoadTimeWeaver
        LoadTimeWeaverAware,
        // 获取Spring占位符解析器，可以解析${}, #{}
        EmbeddedValueResolverAware,
        // 获取资源加载器
        ResourceLoaderAware,
        // 获取@Import导入配置类的元注解信息（AnnotationMetadata）
        ImportAware,
        // 获取BeanFactory
        BeanFactoryAware,
        // 获取运行时环境信息
        EnvironmentAware,
        // 获取MessageSource（一般是ApplicationContext）国际化信息
        MessageSourceAware,
        // 获取通知发布器
        NotificationPublisherAware,
        // 获取时间发布器
        ApplicationEventPublisherAware {

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

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader : " + classLoader);
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory : " + beanFactory);
    }

    public void setBeanName(String name) {
        System.out.println("setBeanName : " + name);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext : " + applicationContext);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("setApplicationEventPublisher : " + applicationEventPublisher);
    }

    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("setEmbeddedValueResolver : " + resolver);
    }

    public void setEnvironment(Environment environment) {
        System.out.println("setEnvironment : " + environment);
    }

    public void setMessageSource(MessageSource messageSource) {
        System.out.println("setMessageSource : " + messageSource);
    }

    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("setResourceLoader : " + resourceLoader);
    }

    public void setImportMetadata(AnnotationMetadata importMetadata) {
        System.out.println("setImportMetadata : " + importMetadata);
        System.out.println(importMetadata.getAnnotationTypes());
    }

    public void setLoadTimeWeaver(LoadTimeWeaver loadTimeWeaver) {
        System.out.println("setLoadTimeWeaver : " + loadTimeWeaver);
    }

    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        System.out.println("setNotificationPublisher : " + notificationPublisher);
    }
}