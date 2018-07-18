package com.cf.vo;

/*
@Author  moni
@Desc    项目完整信息，发起项目时使用
@Date    2018年7月18日
*/
public class ProjectInfoVo {

	// 个人信息3
	/////////////////////////
	private String proName;
	private String proIdNumber;
	private String proPhoneNumber;
	// ID正面
	// ID反面

	// 项目信息7
	/////////////////////////
	// 封面
	// 描述图片s
	private String proTitle;
	private String proPurpose;
	private String proCoverStory;
	// 宣传视频
	private int proTargetMoney;
	private int proLastTime;
	private String proLocation;
	private String proLabels;

	// 回报信息3
	/////////////////////////
	private int proTypeOfReward;
	private int proAmountForReward;
	private String proReward;

	@Override
	public String toString() {
		return "ProjectInfoVo [proName=" + proName + ", proIdNumber=" + proIdNumber + ", proPhoneNumber="
				+ proPhoneNumber + ", proTitle=" + proTitle + ", proPurpose=" + proPurpose + ", proCoverStory="
				+ proCoverStory + ", proTargetMoney=" + proTargetMoney + ", proLastTime=" + proLastTime
				+ ", proLocation=" + proLocation + ", proLabels=" + proLabels + ", proTypeOfReward=" + proTypeOfReward
				+ ", proAmountForReward=" + proAmountForReward + ", proReward=" + proReward + "]";
	}

	public String getProName() {
		return proName;
	}

	public void setProName(String proName) {
		this.proName = proName;
	}

	public String getProIdNumber() {
		return proIdNumber;
	}

	public void setProIdNumber(String proIdNumber) {
		this.proIdNumber = proIdNumber;
	}

	public String getProPhoneNumber() {
		return proPhoneNumber;
	}

	public void setProPhoneNumber(String proPhoneNumber) {
		this.proPhoneNumber = proPhoneNumber;
	}

	public String getProTitle() {
		return proTitle;
	}

	public void setProTitle(String proTitle) {
		this.proTitle = proTitle;
	}

	public String getProPurpose() {
		return proPurpose;
	}

	public void setProPurpose(String proPurpose) {
		this.proPurpose = proPurpose;
	}

	public String getProCoverStory() {
		return proCoverStory;
	}

	public void setProCoverStory(String proCoverstory) {
		this.proCoverStory = proCoverstory;
	}

	public String getProReward() {
		return proReward;
	}

	public void setProReward(String proReward) {
		this.proReward = proReward;
	}

	public int getProTargetMoney() {
		return proTargetMoney;
	}

	public void setProTargetMoney(int proTargetMoney) {
		this.proTargetMoney = proTargetMoney;
	}

	public int getProLastTime() {
		return proLastTime;
	}

	public void setProLastTime(int proLastTime) {
		this.proLastTime = proLastTime;
	}

	public String getProLocation() {
		return proLocation;
	}

	public void setProLocation(String proLocation) {
		this.proLocation = proLocation;
	}

	public String getProLabels() {
		return proLabels;
	}

	public void setProLabels(String prolabels) {
		this.proLabels = prolabels;
	}

	public int getProTypeOfReward() {
		return proTypeOfReward;
	}

	public void setProTypeOfReward(int proTypeOfReward) {
		this.proTypeOfReward = proTypeOfReward;
	}

	public int getProAmountForReward() {
		return proAmountForReward;
	}

	public void setProAmountForReward(int proAmountForReward) {
		this.proAmountForReward = proAmountForReward;
	}

}
