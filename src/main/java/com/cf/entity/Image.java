package com.cf.entity;

/*
@Author  moni
@Desc    图片实体类
@Date    2018年7月17日
*/
public class Image {
	Integer type; // 图片的类型
	String name; // 图片名字
	Integer projectId; // 图片对应的项目id（如果有）
	Integer userId; // 图片对应的用户id（如果有）

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

 
	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Image [type=" + type + ", name=" + name + ", projectId=" + projectId + ", userId=" + userId + "]";
	}

 
}
