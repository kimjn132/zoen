package com.jsplec.bbs.component;

import java.sql.Timestamp;

public class SOrderList {
	public int soId;
	public String pBrand;
	public String pName;
	public int pSize;
	public int soQuantity;
	public Timestamp soSenddate;
	
	public SOrderList() {
		// TODO Auto-generated constructor stub
	}

	public SOrderList(int soId, String pBrand, String pName, int pSize, int soQuantity, Timestamp soSenddate) {
		super();
		this.soId = soId;
		this.pBrand = pBrand;
		this.pName = pName;
		this.pSize = pSize;
		this.soQuantity = soQuantity;
		this.soSenddate = soSenddate;
	}

	public int getSoId() {
		return soId;
	}

	public void setSoId(int soId) {
		this.soId = soId;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
		this.pSize = pSize;
	}

	public int getSoQuantity() {
		return soQuantity;
	}

	public void setSoQuantity(int soQuantity) {
		this.soQuantity = soQuantity;
	}

	public Timestamp getSoSenddate() {
		return soSenddate;
	}

	public void setSoSenddate(Timestamp soSenddate) {
		this.soSenddate = soSenddate;
	}

	
}
