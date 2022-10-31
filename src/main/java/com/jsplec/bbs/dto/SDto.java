package com.jsplec.bbs.dto;

import java.sql.Timestamp;

public class SDto {
	int sId;
	String sName;
	String sPhone;
	String sEmail;
	Timestamp sInitDate;
	Timestamp sEndDate;
	
	public SDto() {
		// TODO Auto-generated constructor stub
	}

	public SDto(int sId, String sName, String sPhone, String sEmail, Timestamp sInitDate, Timestamp sEndDate) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sEmail = sEmail;
		this.sInitDate = sInitDate;
		this.sEndDate = sEndDate;
	}

	public SDto(int sId, String sName, String sPhone, String sEmail) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sEmail = sEmail;
	}
	
	

	public SDto(String sName, String sPhone, String sEmail) {
		super();
		this.sName = sName;
		this.sPhone = sPhone;
		this.sEmail = sEmail;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsEmail() {
		return sEmail;
	}

	public void setsEmail(String sEmail) {
		this.sEmail = sEmail;
	}

	public Timestamp getsInitDate() {
		return sInitDate;
	}

	public void setsInitDate(Timestamp sInitDate) {
		this.sInitDate = sInitDate;
	}

	public Timestamp getsEndDate() {
		return sEndDate;
	}

	public void setsEndDate(Timestamp sEndDate) {
		this.sEndDate = sEndDate;
	}
	
	

}
