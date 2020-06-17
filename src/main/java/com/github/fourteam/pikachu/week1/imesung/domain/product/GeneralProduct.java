package com.github.fourteam.pikachu.week1.imesung.domain.product;

@Getter @Builder
public class GeneralProduct extends Product{

	private Long stock;
	private Gift gift;
	
	@Override
	public boolean checkProduct() {
		return stock > 0L;
	}

	public boolean checkGift() {
		return gift.checkGift();
	}
}
