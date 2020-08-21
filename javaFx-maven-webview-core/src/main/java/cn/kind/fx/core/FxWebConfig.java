package cn.kind.fx.core;

import cn.kind.fx.ioc.ApplicationContext;
import cn.kind.fx.ioc.annotation.AutoWire;
import cn.kind.fx.ioc.annotation.Component;
import cn.kind.fx.ioc.annotation.JController;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import netscape.javascript.JSObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

/**
 * @Auther yiliang
 * @Date 2020/8/21 10:01
 * @Description $
 */

public class FxWebConfig {




	Logger logger = LoggerFactory.getLogger(FxWebConfig.class);

	public FxWebConfig(ApplicationContext context,WebEngine webEngine) {

		// 插入所有Controller注解的对象到html中
		//获取所有JController注解的对象
		List<JControllerMapping> beans =  getJControllerBean(context.getBeans());

		webEngine.getLoadWorker().stateProperty().addListener(
				(ObservableValue<? extends Worker.State> ov, Worker.State oldState,
				 Worker.State newState) -> {
					if (newState == Worker.State.SUCCEEDED) {
						JSObject win = (JSObject) webEngine.executeScript("window");
						//将所有JSObject进行绑定
						for (JControllerMapping jControllerMapping : beans) {
							String name =  jControllerMapping.getPath();
							win.setMember(name, jControllerMapping.getObject());
							logger.info("[{}]-->[{}]",name,jControllerMapping.getObject().getClass().getName());
						}
					}
				});

		// alert事件用于debug
		webEngine.setOnAlert((WebEvent<String> wEvent) -> {
			System.out.println("JS alert() message: " + wEvent.getData());
		});
	}

	private List<JControllerMapping> getJControllerBean(Map<String, Object> beans) {
		List<JControllerMapping> list = new ArrayList();
		Map.Entry<String, Object> next =null;
		for (Iterator<Map.Entry<String, Object>> iterator = beans.entrySet().iterator();
				iterator.hasNext();){
			next = iterator.next();
			Object value = next.getValue();
			if (value.getClass().isAnnotationPresent(JController.class)){
				JController annotation = value.getClass().getAnnotation(JController.class);
				if ("".equals(annotation.value())){
					throw new RuntimeException("@JController注解没有标注命名"+JController.class.getName());
				}
				list.add(new JControllerMapping(annotation.value(), value));
			}
		}
		return list;
	}
}
