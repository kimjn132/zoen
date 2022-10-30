package com.jsplec.bbs.dto;


public class BProductDto {

	int pId;
	String pName;
	String pColor;
	String pSize;
	String pDetail;
	int pSaleprice;
	String pCategory;
	String pBrand;
	int pStock;
	
	public BProductDto() {
		// TODO Auto-generated constructor stub
	}

	



	public BProductDto(int pId, String pName, String pBrand, String pCategory) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pBrand = pBrand;
		this.pCategory = pCategory;
	}





	public BProductDto(int pId, String pName, String pColor, String pSize, String pDetail, int pSaleprice, String pCategory,
			String pBrand, int pStock) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pColor = pColor;
		this.pSize = pSize;
		this.pDetail = pDetail;
		this.pSaleprice = pSaleprice;
		this.pCategory = pCategory;
		this.pBrand = pBrand;
		this.pStock = pStock;
	}





	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpColor() {
		return pColor;
	}

	public void setpColor(String pColor) {
		this.pColor = pColor;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getpDetail() {
		return pDetail;
	}

	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}

	public int getpSaleprice() {
		return pSaleprice;
	}

	public void setpSaleprice(int pSaleprice) {
		this.pSaleprice = pSaleprice;
	}

	public String getpCategory() {
		return pCategory;
	}

	public void setpCategory(String pCategory) {
		this.pCategory = pCategory;
	}

	public String getpBrand() {
		return pBrand;
	}

	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}

	public int getpStock() {
		return pStock;
	}

	public void setpStock(int pStock) {
		this.pStock = pStock;
	}
	
	
	
}
