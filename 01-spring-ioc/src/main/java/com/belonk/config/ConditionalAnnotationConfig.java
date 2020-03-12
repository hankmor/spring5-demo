package com.belonk.config;

import com.belonk.bean.User;
import com.belonk.condition.LinuxCondition;
import com.belonk.condition.WindowsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Created by sun on 2020/3/12.
 *
 * @author sunfuchang03@126.com
 * @version 1.0
 * @since 1.0
 */
@Configuration
public class ConditionalAnnotationConfig {
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

    // ========================================================================================================
    //
    // 条件是通过系统环境变量os.name来判断操作系统，测试时可以在启动时设置VM的参数来更改os.name的值，格式如下：
    //     -Dos.name=linux
    // 这样，环境变量取出来的os.name就为设置的值了
    //
    // ========================================================================================================

    /**
     * 如果操作系统是windows，则会注入该bean。
     * <p>
     * Conditional注解是Spring4.0以后新增的，用来判断bean是否可以注册，当配置的条件都满足时，
     * 则bean才会被注册。
     *
     * @return User对象
     */
    @Bean("billGates")
    @Conditional(value = WindowsCondition.class)
    public User windowsCreator() {
        User billGates = new User();
        billGates.setName("bill gates");
        return billGates;
    }

    /**
     * 如果当前系统是linux，则会注入该bean。
     *
     * @return User对象
     */
    @Bean("linus")
    @Conditional(value = LinuxCondition.class)
    public User linuxCreator() {
        User linus = new User();
        linus.setName("linus");
        return linus;
    }
}