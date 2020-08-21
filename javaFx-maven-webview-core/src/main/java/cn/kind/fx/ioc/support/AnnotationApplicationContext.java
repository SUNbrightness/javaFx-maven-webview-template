package cn.kind.fx.ioc.support;

import cn.kind.fx.ioc.ApplicationContext;
import cn.kind.fx.ioc.BeanRegister;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Auther yiliang
 * @Date 2020/8/20 16:02
 * @Description $
 */
public class AnnotationApplicationContext implements ApplicationContext, BeanRegister {

	//所有的实例存放点
	// benaId + object
	private Map<String,Object> instanceMapping = new ConcurrentHashMap<String, Object>();

	//保存所有bean的信息,主要包含的bean的类型,id等信息
	private List<BeanDefinition> beanDefinitions = new ArrayList<>();

	//配置文件的config
	private Properties config = new Properties();

	public AnnotationApplicationContext(Class aClass) {
		Package aPackage = aClass.getPackage();

		//载入扫描配置信息
		config.setProperty(BeanDefinitionParser.SCAN_PACKAGE,aPackage.getName());
	}

	public AnnotationApplicationContext(String location) {
		InputStream is = null;

		try {
			//定位
			 is = this.getClass().getClassLoader().getResourceAsStream(location);
			//载入
			config.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	//调用具体委派的注入类进行注入
	private void populate() {
		Populator populator = new Populator();
		populator.populate(instanceMapping);

	}

	//调用具体的创建对象创建bean
	private void createBean() {
		BeanCreate create = new BeanCreate(this);
		create.create(beanDefinitions);
	}

	//调用具体的注册对象注册bean信息
	private void register() {
		BeanDefinitionParser beanDefintionParser = new BeanDefinitionParser(this);
		beanDefintionParser.parse(config);
	}

	@Override
	public Object getBean(String id) {
		return instanceMapping.get(id);
	}

	@Override
	public <T> T getBean(String id, Class<T> clazz) {
		return (T)getBean(id);
	}

	@Override
	public Map<String, Object> getBeans() {
		return instanceMapping;
	}

	@Override
	public void start() {

		//注册
		register();

		//实例化
		createBean();

		//注入
		populate();
	}


	@Override
	public void registBeanDefinition(List<BeanDefinition> bds){
		beanDefinitions.addAll(bds);
	}

	@Override
	public void registInstanceMapping(String id, Object instance){
		instanceMapping.put(id, instance);
	}

}
