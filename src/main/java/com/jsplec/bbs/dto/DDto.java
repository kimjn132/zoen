package com.jsplec.bbs.dto;

public class DDto {

	
	int deliveryCo_id;
	String deliveryCo_name;
	String deliveryCo_phone;
	String deliveryCo_email;
	
	public DDto() {
		
	}

	public DDto(int deliveryCo_id, String deliveryCo_name, String deliveryCo_phone, String deliveryCo_email) {
		super();
		this.deliveryCo_id = deliveryCo_id;
		this.deliveryCo_name = deliveryCo_name;
		this.deliveryCo_phone = deliveryCo_phone;
		this.deliveryCo_email = deliveryCo_email;
	}

	public int getDeliveryCo_id() {
		return deliveryCo_id;
	}

	public void setDeliveryCo_id(int deliveryCo_id) {
		this.deliveryCo_id = deliveryCo_id;
	}

	public String getDeliveryCo_name() {
		return deliveryCo_name;
	}

	public void setDeliveryCo_name(String deliveryCo_name) {
		this.deliveryCo_name = deliveryCo_name;
	}

	public String getDeliveryCo_phone() {
		return deliveryCo_phone;
	}

	public void setDeliveryCo_phone(String deliveryCo_phone) {
		this.deliveryCo_phone = deliveryCo_phone;
	}

	public String getDeliveryCo_email() {
		return deliveryCo_email;
	}

	public void setDeliveryCo_email(String deliveryCo_email) {
		this.deliveryCo_email = deliveryCo_email;
	}

	
}
