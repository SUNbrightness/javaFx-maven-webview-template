package cn.kind.fx.core;

/**
 * @Auther yiliang
 * @Date 2020/8/21 10:14
 * @Description 一个用来装数据的实体
 */
public class JControllerMapping {

	private String path;

	private Object object;

	public JControllerMapping(String path, Object object) {
		this.path = path;
		this.object = object;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}
}
