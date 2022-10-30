package com.jsplec.bss.dto;

import java.sql.Timestamp;

public class BDeliveryDto {

	int delivery_id;
	int deliveryCo_id;
	int pId;
	String cId;
	int oId;
	Timestamp delivery_initdate;
	Timestamp delivery_enddate;
	
	public BDeliveryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BDeliveryDto(int delivery_id, int deliveryCo_id, int pId, String cId, int oId, Timestamp delivery_initdate,
			Timestamp delivery_enddate) {
		super();
		this.delivery_id = delivery_id;
		this.deliveryCo_id = deliveryCo_id;
		this.pId = pId;
		this.cId = cId;
		this.oId = oId;
		this.delivery_initdate = delivery_initdate;
		this.delivery_enddate = delivery_enddate;
	}

	public int getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

	public int getDeliveryCo_id() {
		return deliveryCo_id;
	}

	public void setDeliveryCo_id(int deliveryCo_id) {
		this.deliveryCo_id = deliveryCo_id;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public Timestamp getDelivery_initdate() {
		return delivery_initdate;
	}

	public void setDelivery_initdate(Timestamp delivery_initdate) {
		this.delivery_initdate = delivery_initdate;
	}

	public Timestamp getDelivery_enddate() {
		return delivery_enddate;
	}

	public void setDelivery_enddate(Timestamp delivery_enddate) {
		this.delivery_enddate = delivery_enddate;
	}
	
	
}

