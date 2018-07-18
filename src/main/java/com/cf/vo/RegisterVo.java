package com.cf.vo;

import javax.validation.constraints.NotNull;

public class RegisterVo {
	@NotNull
	private String username;
	@NotNull
	private String password;
	@NotNull
	private String usermailOrPhone;
	
	private int type;
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
	public String getUsermailOrPhone() {
		return usermailOrPhone;
	}
	public void setUsermailOrPhone(String usermail) {
		this.usermailOrPhone = usermail;
	}
	
	@Override
	public String toString() {
		return "RegisterVo [username=" + username + ", password=" + password + ", usermailOrPhone=" + usermailOrPhone + ",type="+type+"]";
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
}
