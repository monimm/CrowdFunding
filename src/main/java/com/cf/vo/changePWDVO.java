package com.cf.vo;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class changePWDVO {

	private String phoneOmail;
	private String IDcode;
	@NotNull
	@Length(min = 32)
	private String newPWD;
	private int type;

	@Override
	public String toString() {
		return "changePWDVO [phoneOmail=" + phoneOmail + ", IDcode=" + IDcode + ", newPWD=" + newPWD + ", type=" + type
				+ "]";
	}

	public String getPhoneOmail() {
		return phoneOmail;
	}

	public void setPhoneOmail(String phoneOmail) {
		this.phoneOmail = phoneOmail;
	}

	public String getIDcode() {
		return IDcode;
	}

	public void setIDcode(String iDcode) {
		IDcode = iDcode;
	}

	public String getNewPWD() {
		return newPWD;
	}

	public void setNewPWD(String newPWD) {
		this.newPWD = newPWD;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
}
