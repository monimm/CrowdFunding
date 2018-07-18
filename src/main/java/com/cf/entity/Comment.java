package com.cf.entity;

/*
@Author  moni
@Desc    评论实体类
@Date    2018年7月17日
*/
import java.sql.Date;

public class Comment {
	private Integer id; // 评论的id
	private Integer projectId; // 该评论对应的项目id
	private Integer userId; // 评论对应的用户id
	private String  username;
	private String content; // 评论内容
	private Date time; // 评论日期

	@Override
	public String toString() {
		return "Comment [id=" + id + ", projectId=" + projectId + ", userId=" + userId + ", content=" + content
				+ ", time=" + time + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
