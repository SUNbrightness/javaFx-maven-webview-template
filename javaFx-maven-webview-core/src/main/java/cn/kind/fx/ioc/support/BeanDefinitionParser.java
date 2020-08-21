package cn.kind.fx.ioc.support;

import cn.kind.fx.ioc.BeanRegister;
import cn.kind.fx.ioc.PUtil;

import java.io.File;
import java.net.URL;
import java.util.List;
import java.util.Properties;

/**
 * @Auther yiliang
 * @Date 2020/8/20 16:20
 * @Description $
 */
public class BeanDefinitionParser {

	//配置的扫描包的key
	public static final String SCAN_PACKAGE = "scanPackage";
	//容器注册对象
	private BeanRegister register;

	public BeanDefinitionParser(BeanRegister register) {
		this.register = register;
	}


	public void parse(Properties properties) {
		//获取要扫描的包
		String packageName = properties.getProperty(SCAN_PACKAGE);
		//执行注册
		doRegister(packageName);
	}

	private void doRegister(String packageName) {
		//获取此包名下的绝对路径
		URL resource = getClass().getClassLoader().getResource("./" + packageName.replaceAll("\\.", "/"));

		File dir = new File(resource.getFile());

		//循环遍历,递归找到所有的java文件
		for (File file : dir.listFiles()) {
			if (file.isDirectory()){
				//文件夹-->递归继续执行
				doRegister(PUtil.join(packageName,file.getName()));
			}else {
				//排除所有非.class命名的文件
				if (!file.getName().contains(".class")){
					continue;
				}

				//处理文件名来获取类名,运行时获取到的是class文件
				String className = PUtil.join(packageName, file.getName().replaceAll(".class", ""));
				//调用BeanDefintionGenerator.generate(className)方法,来处理
				//1.类带有容器要处理的注解,则解析id生成BeanDefinition集合返回
				//2.不带有需要处理的注解,注解返回null
				List<BeanDefinition> definitions = BeanDefinitionGenerator.generator(className);
				if(definitions==null){
					continue;
				}
				//向工厂内注册BeanDefinition
				this.register.registBeanDefinition(definitions);

			}
		}

	}

}
