package cn.kind.fx.ioc.support;

/**
 * @Auther yiliang
 * @Date 2020/8/20 16:05
 * @Description $bean
 */
public class BeanDefinition {

	private String id;
	private Class clazz;

	public BeanDefinition(String id, Class clazz) {
		this.id = id;
		this.clazz = clazz;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Class getClazz() {
		return clazz;
	}

	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}


	public Object getInstance(){
		try {
			return clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
