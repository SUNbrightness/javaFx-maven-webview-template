package cn.kind.fx.ioc.support;

import cn.kind.fx.ioc.BeanRegister;

import java.util.List;

/**
 * @Auther yiliang
 * @Date 2020/8/20 16:19
 * @Description $
 */
public class BeanCreate {

	private BeanRegister register;

	public BeanCreate(BeanRegister register) {
		this.register = register;
	}

	public void create(List<BeanDefinition> beanDefinitions) {
		for (BeanDefinition beanDefinition : beanDefinitions) {
			doCreate(beanDefinition);
		}
	}

	private void doCreate(BeanDefinition beanDefinition) {
		Object instance = beanDefinition.getInstance();
		this.register.registInstanceMapping(beanDefinition.getId(),instance);
	}
}
