package cn.kind.fx.ioc.annotation;

import java.lang.annotation.*;

/**
 * @Auther yiliang
 * @Date 2020/8/20 15:53
 * @Description $
 */
@Retention(RetentionPolicy.RUNTIME)//运行时注解
@Target(ElementType.TYPE)//作用再类上
@Documented
@Component
public @interface JController {
	String value() default "";
}
