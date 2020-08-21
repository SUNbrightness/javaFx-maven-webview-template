package cn.kind.fx.ioc.annotation;

import java.lang.annotation.*;

/**
 * @Auther yiliang
 * @Date 2020/8/20 15:58
 * @Description $
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})//作用在类上
@Documented
public @interface JMapping {
}
