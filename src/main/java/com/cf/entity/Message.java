package com.cf.entity;

import java.sql.Date;
/*
@Author  moni
@Desc    消息的实体类
@Date    2018年7月17日
*/
public class Message {
	private Integer id;    //消息的唯一id
	private Integer userId;//用户id
	private String info;   //消息的内容
	private Date time;     //消息日期
	private Integer state; //消息的状态（未读、已读）
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
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", userId=" + userId + ", info=" + info + ", time=" + time + ", state=" + state
				+ "]";
	}
	
}
