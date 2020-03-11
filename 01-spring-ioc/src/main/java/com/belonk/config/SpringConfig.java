package com.belonk.config;

import com.belonk.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * Created by sun on 2020/2/21.
 *
 * @author sunfuchang03@126.com
 * @since 1.0
 */
@Configuration
/*
 * ComponentScan注解属性：
 *    - basePackages: 定义扫描的基础包，从基础包开始扫描组件
 *    - useDefaultFilters: 自动扫描被@Component、 @Repository、@Service、@Controller标注的bean
 *    - includeFilters: 定义仅被扫描的bean，需要将userDefaultFilters定义为false以禁用默认扫描策略
 *    - excludeFilters: 定义不被扫描的bean
 *    - lazyInit: 扫描出的bean是否懒加载，默认是false
 * includeFilters和excludeFilters都使用ComponentScan下的Filter注解，该注解包含以下属性：
 *    - type: FilterType枚举类型，表示过滤类型，分为以下几种：
 *        - ANNOTATION: 基于注解来定义过滤规则
 *        - ASSIGNABLE_TYPE: 按照类来进行过滤
 *        - ASPECTJ: 基于aspectj表达式过滤
 *        - REGEX: 按照正则过滤
 *        - CUSTOM: 自定义过滤规则
 *    - classes: 过滤的类型，只有type为ANNOTATION、ASSIGNABLE_TYPE、CUSTOM可以定义类型
 *    - pattern: 过滤的表达式，type为ASPECTJ、REGEX可以定义表达式
 */
@ComponentScan(basePackages = "com.belonk"
		// 使用includeFilters，useDefaultFilters必须设置为false
		// , includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)}, useDefaultFilters = false
		// 排除Controller不扫描，其他都扫描
		// , excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)}
		// 定义按照类型过滤规则, 只会扫描实现了MyFilter接口的bean
		// , includeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = MyFilter.class)}, useDefaultFilters = false
		, includeFilters = {@ComponentScan.Filter(type = FilterType.CUSTOM, classes = CustomTypeFilter.class)}, useDefaultFilters = false
)

/*
	可以使用多个ComponentScan组合
 */
// @ComponentScans({
// 		@ComponentScan(basePackages = "com.belonk", includeFilters = {
// 				@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Service.class)
// 		}, useDefaultFilters = false),
// 		@ComponentScan(basePackages = "com.belonk", includeFilters = {
// 				@ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Controller.class)
// 		}, useDefaultFilters = false)
// })
public class SpringConfig {
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
	 * "@Bean"默认使用方法名称作为bean名称，可以自定义bean名称。
	 *
	 * @return bean实例
	 */
	@Bean("user")
	public User myUser() {
		User user = new User();
		user.setName("spring");
		return user;
	}
}