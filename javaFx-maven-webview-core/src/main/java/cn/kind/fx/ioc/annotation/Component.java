package cn.kind.fx.ioc.annotation;
import java.lang.annotation.*;
/**
 * @Auther yiliang
 * @Date 2020/8/20 16:48
 * @Description $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
public @interface Component {
	String value() default "";
}
