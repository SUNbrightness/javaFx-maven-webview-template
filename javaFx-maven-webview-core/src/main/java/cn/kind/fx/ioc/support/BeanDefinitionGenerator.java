package cn.kind.fx.ioc.support;

import cn.kind.fx.ioc.annotation.Component;
import cn.kind.fx.ioc.annotation.JController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther yiliang
 * @Date 2020/8/20 16:40
 * @Description $
 */
public class BeanDefinitionGenerator {


	public static List<BeanDefinition> generator(String className) {
		try {
			Class<?> aClass = Class.forName(className);
			String[] ids = generateIds(aClass);
			if (null==ids){
				return null;
			}
			List<BeanDefinition> list = new ArrayList();
			for (String id : ids) {
				list.add(new BeanDefinition(id,aClass));
			}

			return list;

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	/*
	 * Description:生成id数组
	 *
	 *
	 * 3.@Component 有value 返回id= value
	 * 4. 不带容器要实例化的注解 null
	 * @Param:
			* @Return:
			* @Author: yiliang
			* @Date: 2020/8/20 4:49 下午
	 */

	private static String[] generateIds(Class<?> aClass) {
		String[] ids = null;

//		带有@Controller 注解但是注解value没给值,@Controller一般没有接口定义,用类的全名作为id返回ids长度为1
		if (aClass.isAnnotationPresent(JController.class)){
			ids = new String[]{aClass.getName()};
		}else if (aClass.isAnnotationPresent(Component.class)){
//			@Component 没有value 获取所有的接口实现
//	         我们在使用@AutoWire时为什么使用接口可以注入实现类,原因就是这里,我们把接口作为了获取bean 的id
			Component component = aClass.getAnnotation(Component.class);
			String value = component.value();
			//有值时用值为id
			if (!"".equals(value)){
				return new String[]{value};
			}else{
				Class<?>[] interfaces = aClass.getInterfaces();
				ids = new String[interfaces.length+1];
				for (int i = 0; i < interfaces.length; i++) {
					ids[i] = interfaces[i].getName();
				}
				//还要加上本身的类名为id
				ids[interfaces.length] = aClass.getName();

				return ids;
			}

		}



		return ids;
	}
}
