package com.github.fourteam.pikachu.week1.imesung.domain.order;


import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;

import java.util.Map;

public abstract class OrderService {
    protected abstract Map<String, String> orderSheetRequest(Customer customer, Product product);

    public boolean createOrder(Customer customer, Product product) {

        Map<String, String> orderStatusResult = orderSheetRequest(customer, product);
        if(orderStatusResult.get("Status").equals("E")) {
            return true;
        }
        return false;
    }
}
