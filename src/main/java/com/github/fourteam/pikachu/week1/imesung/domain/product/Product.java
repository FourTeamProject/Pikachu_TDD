package com.github.fourteam.pikachu.week1.imesung.domain.product;

public abstract class Product {
	private Gift gift;
	
	public boolean checkGift() {
		return gift.checkGift();
	}
	public abstract boolean checkProduct();


}