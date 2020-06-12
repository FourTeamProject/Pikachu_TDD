package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;

public class NormalCustomer implements Customer {

    /**
     * Name: 주문가능상태 확인
     * Date: 2020/06/12
     * Info:
     *     일반 고객은 주문가능
     */
    @Override
    public boolean checkCustomerStatus() {
        return true;
    }
}
