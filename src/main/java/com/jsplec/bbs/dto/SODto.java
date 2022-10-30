package com.jsplec.bbs.dto;

import java.sql.Timestamp;

public class SODto {
	int soId;
	int soSupplier_sId;
	int soProduct_pId;
	int soQuantity;
	int soPrice;
	Timestamp soSenddate;
	Timestamp soGetdate;
	
	public SODto() {
		// TODO Auto-generated constructor stub
	}

	public SODto(int soId, int soSupplier_sId, int soProduct_pId, int soQuantity, int soPrice, Timestamp soSenddate,
			Timestamp soGetdate) {
		super();
		this.soId = soId;
		this.soSupplier_sId = soSupplier_sId;
		this.soProduct_pId = soProduct_pId;
		this.soQuantity = soQuantity;
		this.soPrice = soPrice;
		this.soSenddate = soSenddate;
		this.soGetdate = soGetdate;
	}

	public int getSoId() {
		return soId;
	}

	public void setSoId(int soId) {
		this.soId = soId;
	}

	public int getSoSupplier_sId() {
		return soSupplier_sId;
	}

	public void setSoSupplier_sId(int soSupplier_sId) {
		this.soSupplier_sId = soSupplier_sId;
	}

	public int getSoProduct_pId() {
		return soProduct_pId;
	}

	public void setSoProduct_pId(int soProduct_pId) {
		this.soProduct_pId = soProduct_pId;
	}

	public int getSoQuantity() {
		return soQuantity;
	}

	public void setSoQuantity(int soQuantity) {
		this.soQuantity = soQuantity;
	}

	public int getSoPrice() {
		return soPrice;
	}

	public void setSoPrice(int soPrice) {
		this.soPrice = soPrice;
	}

	public Timestamp getSoSenddate() {
		return soSenddate;
	}

	public void setSoSenddate(Timestamp soSenddate) {
		this.soSenddate = soSenddate;
	}

	public Timestamp getSoGetdate() {
		return soGetdate;
	}

	public void setSoGetdate(Timestamp soGetdate) {
		this.soGetdate = soGetdate;
	}
	
	
	
	
}
