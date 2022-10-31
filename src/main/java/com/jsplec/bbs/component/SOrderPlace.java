package com.jsplec.bbs.component;

public class SOrderPlace {
	public String soProduct_pId;
	public String pBrand;
	public String soQuantity;
	
	public SOrderPlace() {
		// TODO Auto-generated constructor stub
	}

	public SOrderPlace(String soProduct_pId, String pBrand, String soQuantity) {
		super();
		this.soProduct_pId = soProduct_pId;
		this.pBrand = pBrand;
		this.soQuantity = soQuantity;
	}

	public String getSoProduct_pId() {
		return soProduct_pId;
	}

	public void setSoProduct_pId(String soProduct_pId) {
		this.soProduct_pId = soProduct_pId;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public String getSoQuantity() {
		return soQuantity;
	}

	public void setSoQuantity(String soQuantity) {
		this.soQuantity = soQuantity;
	}
	
	
	
	
	
}
