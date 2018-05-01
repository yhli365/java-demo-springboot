package demo.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import demo.entity.User;

/**
 * 服务接口
 * 
 * @author Yanhong Lee
 *
 */
@WebService
public interface UserService {

	@WebMethod
	public String getName(@WebParam(name = "userId") Long userId);

	@WebMethod
	public User getUser(long userId);

}
