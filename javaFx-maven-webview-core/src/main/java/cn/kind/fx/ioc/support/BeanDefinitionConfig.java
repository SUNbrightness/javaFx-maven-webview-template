package cn.kind.fx.ioc.support;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Auther yiliang
 * @Date 2020/8/20 18:00
 * @Description $
 */
public class BeanDefinitionConfig {


	public Properties getProperties(String location) throws IOException {
		Properties properties = new Properties();

		//定位
		InputStream is = this.getClass().getClassLoader().getResourceAsStream(location);
		//载入
		properties.load(is);
		return properties;
	}
}
