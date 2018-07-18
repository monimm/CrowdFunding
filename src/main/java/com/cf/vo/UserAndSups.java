package com.cf.vo;

import java.sql.Date;

import com.cf.utils.StateUtils;

public class UserAndSups {
	private Integer userId;
	private Integer projectId;
	private String projectName;
	private String targetMoney;
	private String currentMoney;
	private Integer money;
	private Integer state;
	private Date date;
	private Integer proState;
	private String orderId;
	
	//这个属性供视图view-model使用
	private String stateName;
	
 
	public String getTargetMoney() {
		return targetMoney;
	}
	public void setTargetMoney(String targetMoney) {
		this.targetMoney = targetMoney;
	}
	public String getCurrentMoney() {
		return currentMoney;
	}
	public void setCurrentMoney(String currentMoney) {
		this.currentMoney = currentMoney;
	}
 
	public Integer getMoney() {
		return money;
	}
	public void setMoney(Integer money) {
		this.money = money;
	}
 
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
 
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
 
 
	public Integer getProState() {
		return proState;
	}
	public void setProState(Integer proState) {
		this.proState = proState;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	 
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
		this.stateName = StateUtils.getStateName(state);
	}
	@Override
	public String toString() {
		return "UserAndSups [userId=" + userId + ", projectId=" + projectId + ", projectName=" + projectName
				+ ", targetMoney=" + targetMoney + ", currentMoney=" + currentMoney + ", money=" + money + ", state="
				+ state + ", date=" + date + ", proState=" + proState + "]";
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getStateName() {
		return stateName;
	}
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	
}
