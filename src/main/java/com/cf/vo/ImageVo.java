package com.cf.vo;

/*
@Author  moni
@Desc    图片实体类
@Date    2018年7月17日
*/

//从数据库读图片时  进行处理 将图片名加上路径

public class ImageVo {
	private Integer projectId;
	private Integer userId;
	private Integer type;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if(type == 1)
			this.name = "/springUpload/coverPhoto/pid_" + projectId + "/" + name;
		if(type == 2)
			this.name = "/springUpload/describePhoto/pid_" + projectId + "/" + name;
		if(type == 3)
			this.name = "/springUpload/idPhoto/pid_" + projectId + "/" + name;
		if(type == 4)
			this.name = "/springUpload/headImagePhoto/pid_" + userId + "/" + name;
	}

	public String toString() {
		return "name=" + name;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
