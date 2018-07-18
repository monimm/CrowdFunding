package com.cf.entity;


/*
@Author  moni
@Desc    用户实体类
@Date    2018年7月17日
*/

public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer money;
	private String phone;
	private String mail;

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + username + ", password=" + password + ", money=" + money + ", phone="
				+ phone + ", mail=" + mail + "]";
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
