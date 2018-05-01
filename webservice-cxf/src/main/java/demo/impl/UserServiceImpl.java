package demo.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import demo.entity.User;
import demo.service.UserService;

/**
 * 服务实现类
 * 
 * @author Yanhong Lee
 *
 */
@WebService(targetNamespace = "http://service.demo/", //
		endpointInterface = "demo.service.UserService")
public class UserServiceImpl implements UserService {
	private static Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public String getName(Long userId) {
		log.info("exec[getName]# userId=" + userId);
		return "my-" + userId;
	}

	@Override
	public User getUser(long userId) {
		log.info("exec[getUser]# userId=" + userId);
		User user = new User();
		user.setUserId(userId);
		user.setUsername("my-" + userId);
		user.setEmail(userId + "@qq.com");
		return user;
	}

}
