package cn.kind.fx.demo;

import cn.kind.fx.ioc.annotation.Component;

/**
 * @Auther yiliang
 * @Date 2020/8/20 17:31
 * @Description $
 */
@Component
public class MyService {
	public void say(String s){
		System.out.println(s);
	}
}
