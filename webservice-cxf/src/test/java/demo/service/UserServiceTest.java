package demo.service;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.junit.Test;

import demo.entity.User;

public class UserServiceTest {

	// 接口地址
	String wsdlURL = "http://localhost:8080/soap/user?wsdl";

	/**
	 * 方式1. 动态调用方式
	 * 
	 * @throws Exception
	 */
	@Test
	public void dynamicClient() throws Exception {
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactory.createClient(wsdlURL);
		Object[] objects;

		// 数据准备
		long userId = 11L;

		System.out.println("call: getName---------------");
		objects = client.invoke("getName", userId);
		System.out.println("call: getName Result");
		System.out.println(objects[0].toString());

		System.out.println("call: getUser---------------");
		objects = client.invoke("getUser", userId);
		System.out.println("call: getUser Result");
		System.out.println(objects[0].toString());

	}

	/**
	 * 方式2. 代理类工厂的方式, 需要拿到对方的接口
	 * 
	 * @throws Exception
	 */
	@Test
	public void proxyClient() throws Exception {
		// 代理工厂
		JaxWsProxyFactoryBean jaxWsProxyFactoryBean = new JaxWsProxyFactoryBean();
		// 设置代理地址
		jaxWsProxyFactoryBean.setAddress(wsdlURL);
		// 设置接口类型
		jaxWsProxyFactoryBean.setServiceClass(UserService.class);
		// 创建一个代理接口实现
		UserService userService = (UserService) jaxWsProxyFactoryBean.create();
		// 数据准备
		long userId = 12L;
		// 调用代理接口的方法调用并返回结果
		System.out.println("call: getName---------------");
		String name = userService.getName(userId);
		System.out.println("call: getName Result");
		System.out.println(name);

		System.out.println("call: getUser---------------");
		User user = userService.getUser(userId);
		System.out.println("call: getUser Result");
		System.out.println(user.toString());

	}

}
