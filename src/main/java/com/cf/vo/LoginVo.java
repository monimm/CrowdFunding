package com.cf.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class LoginVo {
	
	@NotNull
	private String username;
	
	@NotNull
	@Length(min=32)
	private String password;

	@Override
	public String toString() {
		return "LoginVo [username=" + username + ", password=" + password + "]";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
