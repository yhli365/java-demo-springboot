package demo.entity;

import java.io.Serializable;

/**
 * 实体类
 * 
 * @author Yanhong Lee
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long userId;

	private String username;

	private String email;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User(id=" + userId + ", name=" + username + ", email=" + email + ")";
	}

}
