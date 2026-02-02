package com.rays.test;

public class Order {
	
	private String product;
	private String price;
	private String quantity;
	
	
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public Order(String product, String price, String quantity) {
		
		this.product = product;
		this.price = price;
		this.quantity = quantity;
	}
	public Order() {
	}
	
}
