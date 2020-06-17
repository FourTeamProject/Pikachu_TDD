package com.github.fourteam.pikachu.week1.imesung.domain.product;

public class GiftProduct implements Gift {

	private Long stock;
	
	@Override
	public boolean checkGift() {
		return stock > 0L;
	}

}
