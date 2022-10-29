package com.jsplec.zoen.dto;

import java.sql.Timestamp;

public class BCustomerDto {

	String cId;
	String cPw;
	String cAddress;
	String cEmail;
	String cPhone;
	Timestamp cJoinDate;
	Timestamp cEndDate;
	public BCustomerDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BCustomerDto(String cId, String cPw, String cAddress, String cEmail, String cPhone, Timestamp cJoinDate, Timestamp cEndDate) {
		super();
		this.cId = cId;
		this.cPw = cPw;
		this.cAddress = cAddress;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
		this.cJoinDate = cJoinDate;
		this.cEndDate = cEndDate;
	}
	public String getcId() {
		return cId;
	}
	public void setcId(String cId) {
		this.cId = cId;
	}
	public String getcPw() {
		return cPw;
	}
	public void setcPw(String cPw) {
		this.cPw = cPw;
	}
	public String getcAddress() {
		return cAddress;
	}
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcPhone() {
		return cPhone;
	}
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}
	public Timestamp getcJoinDate() {
		return cJoinDate;
	}
	public void setcJoinDate(Timestamp cJoinDate) {
		this.cJoinDate = cJoinDate;
	}
	public Timestamp getcDeleteDate() {
		return cEndDate;
	}
	public void setcDeleteDate(Timestamp cDeleteDate) {
		this.cEndDate = cDeleteDate;
	}
	
		
	
}
