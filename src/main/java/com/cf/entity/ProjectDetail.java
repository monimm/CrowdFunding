package com.cf.entity;

/*
@Author  moni
@Desc    项目详情表的实体类  
@Date    2018年7月17日
*/
public class ProjectDetail {

	// id同project的id
	private Integer id;
	// 身份证号
	private String idNumber;
	// 这里是发起人的姓名 不是项目名
	private String name;
	private String phone;
	private String title;
	private String purpose;
	private String location;
	private String labels;
	private String coverStory;
	private String additional;

	@Override
	public String toString() {
		return "ProjectDetail [id=" + id + ", idNumber=" + idNumber + ", name=" + name + ", phone =" + phone
				+ ", title=" + title + ", labels=" + labels + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLabels() {
		return labels;
	}

	public void setLabels(String labels) {
		this.labels = labels;
	}

	public String getCoverStory() {
		return coverStory;
	}

	public void setCoverStory(String coverStory) {
		this.coverStory = coverStory;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
