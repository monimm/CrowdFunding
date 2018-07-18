package com.cf.vo;

import java.sql.Date;

public class ProAndUsers {
 
	private Integer userId;
	private String username;
 
	private Integer projectId;
 
	private Integer money;
	
	private Date date;
	private String phone;
 
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
 
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "ProAndUsers [userId=" + userId + ", username=" + username + ", projectId=" + projectId + ", money="
				+ money + ", date=" + date + ", phone=" + phone + "]";
	}
 
}
