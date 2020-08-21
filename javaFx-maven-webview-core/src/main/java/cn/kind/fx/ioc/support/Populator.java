package cn.kind.fx.ioc.support;

import cn.kind.fx.ioc.annotation.AutoWire;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

/**
 * @Auther yiliang
 * @Date 2020/8/20 16:17
 * @Description $
 */
public class Populator {


	public void populate(Map<String, Object> instanceMapping) {
		//首先要判断ioc容器中有没有东西
		if (instanceMapping.isEmpty()){
			return;
		}
		//循环遍历每一个容器中的对象
		Map.Entry<String, Object> next = null;
		for(Iterator<Map.Entry<String, Object>> iterator = instanceMapping.entrySet().iterator();
		     iterator.hasNext();){
			 next = iterator.next();
			//获取对象字段
			Field[] declaredFields = next.getValue().getClass().getDeclaredFields();
			for (Field field : declaredFields) {

				if (!field.isAnnotationPresent(AutoWire.class)){
					continue;
				}
				AutoWire annotation = field.getAnnotation(AutoWire.class);

				//有指定id 的使用指定的id,为空就以类(接口)名为id
				String id = annotation.value();
				if ("".equals(id)){
					id = field.getType().getName();
				}
				field.setAccessible(true);

				//反射注入
				try {
					field.set(next.getValue(), instanceMapping.get(id));
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}

			}

		}

	}
}
