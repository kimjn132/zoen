
package com.jsplec.bbs.dto;


import java.sql.Timestamp;

public class ZDto {

	// orders
	int oId;
	String cId;
	int pId;
	int delivery_id;
	int oQuantity;
	String oPayment;
	Timestamp oDate;

	// customer
	String cAddress;
	String cEmail;
	String cPhone;

	// product
	String pName;
	String pColor;
	int pSize;
	String pDetail;
	int pSaleprice;
	String pCategory;
	String pBrand;
	int pStock;

	// delivery
	int deliveryCo_id;
	String deliveryCo_name;

	public ZDto() {
		// TODO Auto-generated constructor stub
	}

	public ZDto(int pId, String pName, String pColor, int pSize, String pDetail, int pSaleprice, String pCategory,
			String pBrand) {
		super();
		this.pId = pId;
		this.pName = pName;
		this.pColor = pColor;
		this.pSize = pSize;
		this.pDetail = pDetail;
		this.pSaleprice = pSaleprice;
		this.pCategory = pCategory;
		this.pBrand = pBrand;
	}

	public ZDto(String pName, String pColor, int pSize, String pDetail, int pSaleprice, String pCategory,
			String pBrand) {
		super();

		this.pName = pName;
		this.pColor = pColor;
		this.pSize = pSize;
		this.pDetail = pDetail;
		this.pSaleprice = pSaleprice;
		this.pCategory = pCategory;
		this.pBrand = pBrand;
	}
	
	
	

	public ZDto(String cId, String cAddress, String cEmail, String cPhone) {
		super();
		this.cId = cId;
		this.cAddress = cAddress;
		this.cEmail = cEmail;
		this.cPhone = cPhone;
	}

	
	

	public ZDto(String cId, int pId, String pName) {
		super();
		this.cId = cId;
		this.pId = pId;
		this.pName = pName;
	}


	public int getoId() {
		return oId;
	}

	public void setoId(int oId) {
		this.oId = oId;
	}

	public String getcId() {
		return cId;
	}

	public void setcId(String cId) {
		this.cId = cId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public int getDelivery_id() {
		return delivery_id;
	}

	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}

	public int getoQuantity() {
		return oQuantity;
	}

	public void setoQuantity(int oQuantity) {
		this.oQuantity = oQuantity;
	}

	public String getoPayment() {
		return oPayment;
	}

	public void setoPayment(String oPayment) {
		this.oPayment = oPayment;
	}

	public Timestamp getoDate() {
		return oDate;
	}

	public void setoDate(Timestamp oDate) {
		this.oDate = oDate;
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

	public int getpSize() {
		return pSize;
	}

	public void setpSize(int pSize) {
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

		
}