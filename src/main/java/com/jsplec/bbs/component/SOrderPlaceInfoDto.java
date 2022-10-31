package com.jsplec.bbs.component;

public class SOrderPlaceInfoDto {
	public int sId;
	public int pSaleprice;
	
	public SOrderPlaceInfoDto() {
		// TODO Auto-generated constructor stub
	}

	public SOrderPlaceInfoDto(int sId, int pSaleprice) {
		super();
		this.sId = sId;
		this.pSaleprice = pSaleprice;
	}

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	public int getpSaleprice() {
		return pSaleprice;
	}

	public void setpSaleprice(int pSaleprice) {
		this.pSaleprice = pSaleprice;
	}
	
	
	
}
