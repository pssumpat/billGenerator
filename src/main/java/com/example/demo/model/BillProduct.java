package com.example.demo.model;

public class BillProduct 
{
	private int quantity;
	private int serialNumber;
	private String productName;
	private long productPrice;
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public long getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}
	@Override
	public String toString() {
		return "BillProduct [quantity=" + quantity + ", serialNumber=" + serialNumber + ", productName=" + productName
				+ ", productPrice=" + productPrice + "]";
	}

}
