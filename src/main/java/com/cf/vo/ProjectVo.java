package com.cf.vo;

import java.sql.Date;

public class ProjectVo {
	private Integer id;
	private String name;
	private Integer userId;
	private Integer state;
	private Integer type;
	private Integer targetMoney;
	private Integer currentMoney;
	private Date createTime;
	private Date endTime;
	private String purpose;
	private String coverStory;
	private String cover;


	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", userId=" + userId + ", state=" + state + ", type=" + type
				+ ", targetMoney=" + targetMoney + ", currentMoney=" + currentMoney + ", createTime=" + createTime
				+ ", cover=" + cover + "]";
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getTargetMoney() {
		return targetMoney;
	}

	public void setTargetMoney(Integer targetMoney) {
		this.targetMoney = targetMoney;
	}

	public Integer getCurrentMoney() {
		return currentMoney;
	}

	public void setCurrentMoney(Integer currentMoney) {
		this.currentMoney = currentMoney;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

 

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
 		this.cover = "/springUpload/coverPhoto/pid_"+ id +  "/" +cover;
	}

	public String getCoverStory() {
		return coverStory;
	}

	public void setCoverStory(String coverStory) {
		this.coverStory = coverStory;
	}

 

}
