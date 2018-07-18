package com.cf.entity;

import java.sql.Date;

/*
@Author  moni
@Desc    交易的实体类
@Date    2018年7月17日
*/

public class Trade {
	private Integer id; // 交易的id
	private Integer userId; // 用户id
	private String info; // 交易信息
	private Date time; // 时间
	private Integer money; // 交易金额

	public Integer getId() {
		return id;
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

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	@Override
	public String toString() {
		return "Trade [id=" + id + ", userId=" + userId + ", info=" + info + "]";
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

}
