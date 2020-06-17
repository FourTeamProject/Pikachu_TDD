package com.github.fourteam.pikachu.week1.imesung.domain.customer;

import java.util.ArrayList;
import java.util.List;

import pikachu.domain.product.Product;

@Builder
public class PartnerCust implements Customer{

	private List<Product> products = new ArrayList<>();
	
	@Override
	public boolean chkCustomerGubun() {
		return products.size() >= 3;
	}
	
	public boolean 
}
