package com.belonk.autowire.test;

import com.belonk.autowire.bean.BeanHolder;
import com.belonk.autowire.bean.MayNotExistsBean;
import com.belonk.autowire.bean.NecessaryBean;
import com.belonk.autowire.bean.PrimaryBean;
import com.belonk.autowire.config.AutowireBeanConfig;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        BeanHolder       beanHolder       = context.getBean(BeanHolder.class);
        NecessaryBean    necessaryBean    = beanHolder.getNecessaryBean();
        NecessaryBean    necessaryBean1   = beanHolder.getNecessaryBean2();
        NecessaryBean    necessaryBean2   = beanHolder.getNecessaryBean3();
        MayNotExistsBean mayNotExistsBean = beanHolder.getMayNotExistsBean();
        PrimaryBean      primaryBean      = beanHolder.getPrimaryBean();

        assert "necessaryBean".equals(necessaryBean.getName());
        assert "necessaryBean2".equals(necessaryBean1.getName());
        assert necessaryBean1 == necessaryBean2;
        assert mayNotExistsBean == null;
        assert "primaryBean2".equals(primaryBean.getName());
    }
}