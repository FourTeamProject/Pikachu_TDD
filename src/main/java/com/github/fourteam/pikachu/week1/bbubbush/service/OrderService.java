package com.github.fourteam.pikachu.week1.bbubbush.service;

import com.github.fourteam.pikachu.week1.bbubbush.domain.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.Product;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;

import java.util.HashMap;
import java.util.Map;

public class OrderService {

    public Map<String, String> requestOrder(Product product, Customer customer) {
        return this.orderSheetRequest(product, customer);
    }

    private Map<String, String> orderSheetRequest (Product product, Customer customer) {
        HashMap<String, String> outputMap = new HashMap<>();
        outputMap.put("Status", "E");

        boolean canOrder = product.checkProduct();
        if ( !canOrder ) {
            outputMap.put("Message", "상품 재고부족으로 인하여 불가");
            return outputMap;
        }

        canOrder = canOrder && customer.checkCustomerStatus();
        if ( !canOrder ) {
            if ( customer.getUserType().equals(CustomerType.Employees) ) {
                outputMap.put("Message", "포인트가 존재하지 않습니다.");
            }
            else if ( customer.getUserType().equals(CustomerType.Normal) ) {
                outputMap.put("Message", "블랙컨슈머는 주문할 수 없습니다.");
            }
            return outputMap;
        }

        outputMap.put("Status", "S");
        return outputMap;
    }

}
