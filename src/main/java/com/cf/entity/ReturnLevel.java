package com.cf.entity;

//回报分级的实体类。
public class ReturnLevel {
	private Integer id;
	private Integer projectId;
	private Integer returnType;
	private Integer orderMoney;
	private String returnDetail;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public Integer getReturnType() {
		return returnType;
	}

	public void setReturnType(Integer returnType) {
		this.returnType = returnType;
	}

	public Integer getMoney() {
		return orderMoney;
	}

	public void setMoney(Integer money) {
		this.orderMoney = money;
	}

	public String getReturnDetail() {
		return returnDetail;
	}

	public void setReturnDetail(String returnDetail) {
		this.returnDetail = returnDetail;
	}

	@Override
	public String toString() {
		return "ReturnLevel [id=" + id + ", projectId=" + projectId + ", returnType=" + returnType + ", orderMoney="
				+ orderMoney + ", returnDetail=" + returnDetail + "]";
	}

}
