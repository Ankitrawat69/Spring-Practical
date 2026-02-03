package com.rays.autowire.byname;

public class Payment {

	private double balance;

	public Payment() {

	}

	public Payment(double balance) {
		this.balance = balance;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public double makePayment(double amt) {
		balance = balance - amt;
		return balance;
	}

}