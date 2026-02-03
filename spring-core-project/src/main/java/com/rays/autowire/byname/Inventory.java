package com.rays.autowire.byname;

public class Inventory {

	private int stock;

	public Inventory() {

	}

	public Inventory(int stock) {
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int sold(int qty) {
		stock -= qty; // stock = stock - qty;
		return stock;
	}

}