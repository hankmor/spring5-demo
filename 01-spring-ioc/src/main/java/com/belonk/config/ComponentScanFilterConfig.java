package com.belonk.config;

import com.belonk.MyFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

/**
 * <pre>
 * ComponentScan注解属性：
 *     - basePackages: 定义扫描的基础包，从基础包开始扫描组件
 *     - useDefaultFilters: 自动扫描被@Component、 @Repository、@Service、@Controller标注的bean
 *     - includeFilters: 定义仅被扫描的bean，需要将userDefaultFilters定义为false以禁用默认扫描策略
 *     - excludeFilters: 定义不被扫描的bean
 *     - lazyInit: 扫描出的bean是否懒加载，默认是false
 *
 * includeFilters和excludeFilters都使用ComponentScan下的Filter注解，该注解包含以下属性：
 *     - type: FilterType枚举类型，表示过滤类型，分为以下几种：
 *     - ANNOTATION: 基于注解来定义过滤规则
 *     - ASSIGNABLE_TYPE: 按照类继承来进行过滤
 *     - ASPECTJ: 基于aspectj表达式过滤
 *     - REGEX: 按照正则过滤
 *     - CUSTOM: 自定义过滤规则
 *     - classes: 过滤的类型，只有type为ANNOTATION、ASSIGNABLE_TYPE、CUSTOM可以定义类型
 *     - pattern: 过滤的表达式，type为ASPECTJ、REGEX可以定义表达式
 * </pre>
 * <p>
 * 这里的示例，本来可以扫描出来两个Controller，但是由于定义了excludeFilters，实现了MyFilter接口的controller被排除，
 * 所以仅能扫描出MyUserController。
 * <p>
 * <p>
 * Created by sun on 2020/3/11.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
@Configuration
@ComponentScan(basePackages = "com.belonk"
		// 使用includeFilters，useDefaultFilters必须设置为false
		, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)}, useDefaultFilters = false
		// 排除实现了MyFilter的Controller不扫描，其他都扫描
		, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyFilter.class)}
)
public class ComponentScanFilterConfig {
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


}