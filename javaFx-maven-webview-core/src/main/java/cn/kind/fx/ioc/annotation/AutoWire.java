package cn.kind.fx.ioc.annotation;

import java.lang.annotation.*;

/**
 * @Auther yiliang
 * @Date 2020/8/20 15:55
 * @Description $
 */
@Retention(RetentionPolicy.RUNTIME)
//作用在字段上
@Target(ElementType.FIELD)
@Documented
public @interface AutoWire {
	String value() default "";
}
