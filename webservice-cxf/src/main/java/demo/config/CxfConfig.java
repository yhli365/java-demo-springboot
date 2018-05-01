package demo.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import demo.impl.UserServiceImpl;
import demo.service.UserService;

/**
 * 配置类
 * 
 * @author Yanhong Lee
 *
 */
@Configuration
public class CxfConfig {

	@Bean
	public ServletRegistrationBean dispatcherServlet() {
		return new ServletRegistrationBean(new CXFServlet(), "/soap/*");
	}

	@Bean(name = Bus.DEFAULT_BUS_ID)
	public SpringBus springBus() {
		return new SpringBus();
	}

	@Bean
	public UserService userService() {
		return new UserServiceImpl();
	}

	// 此处要注意导入正取的Endpoint、EndpointImpl包
	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(springBus(), userService());
		endpoint.publish("/user");
		return endpoint;
	}

}
