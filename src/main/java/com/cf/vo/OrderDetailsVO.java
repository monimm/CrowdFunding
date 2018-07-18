package com.cf.vo;

public class OrderDetailsVO {
	private Integer projectId;
	private Integer userId;
	private Integer money;
	private String phone;
	public Integer getProjectId() {
		return projectId;
	}
	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	@Override
	public String toString() {
		return "OrderDetailsVO [projectId=" + projectId + ", userId=" + userId + ", money=" + money + ", phone=" + phone
				+ "]";
	}
	 
	
}
