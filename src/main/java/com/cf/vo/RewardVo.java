package com.cf.vo;

public class RewardVo {
	private String returnType;
	private int orderMoney;
	private String returnDetail;
	public String getReturnType() {
		return returnType;
	}
	public void setReturnType(String returnType) {
		switch(returnType)
		{
		case "1":
			this.returnType = "实物回报";
			break;
		case "2":
			this.returnType = "虚拟回报";
			break;
		default:
			this.returnType = "其他回报";
		}
	}
	public int getOrderMoney() {
		return orderMoney;
	}
	public void setOrderMoney(int orderMoney) {
		this.orderMoney = orderMoney;
	}
	public String getReturnDetail() {
		return returnDetail;
	}
	public void setReturnDetail(String returnDetail) {
		this.returnDetail = returnDetail;
	}
}
