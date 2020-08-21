package cn.kind.fx.demo;

import cn.kind.fx.ioc.ApplicationContext;
import cn.kind.fx.ioc.annotation.AutoWire;
import cn.kind.fx.ioc.annotation.JController;
import cn.kind.fx.ioc.support.AnnotationApplicationContext;

/**
 * @Auther yiliang
 * @Date 2020/8/20 17:29
 * @Description $
 */
@JController
public class MyController {

	@AutoWire
	private MyService myService;


	public void test(){
	myService.say("hello spring!");
	}

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationApplicationContext(MyController.class);
		MyController bean = context.getBean("cn.kind.fx.demo.MyController", MyController.class);
		bean.test();
	}




}
