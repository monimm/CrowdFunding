package com.cf.entity;
 
import java.sql.Date;

/*
@Author  moni
@Desc    订单实体类
@Date    2018年7月17日
*/
public class Order {
	private Integer id;			//订单id
	private Integer userId;		//用户id
	private Integer projectId;	//项目id
	private Integer money;		//订单金额
	private Date date;			//日期
	private String phone;		//手机号
	private String name;		//名字
	private String orderId;		//随机生成的订单号
	private Integer state;		//状态

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", userId=" + userId + ", projectId=" + projectId + ", money=" + money + ", date="
				+ date + ", phone=" + phone + ", name=" + name + ", orderId=" + orderId + ", state=" + state + "]";
	}

}
