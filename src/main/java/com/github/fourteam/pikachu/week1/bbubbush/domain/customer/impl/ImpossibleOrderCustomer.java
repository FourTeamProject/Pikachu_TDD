package com.github.fourteam.pikachu.week1.bbubbush.domain.customer.impl;

import com.github.fourteam.pikachu.week1.bbubbush.domain.customer.Customer;

/**
 * Name: 거래거절 고객
 * Date: 2020/06/12
 * Info:
 *
 */
public class ImpossibleOrderCustomer implements Customer {

    @Override
    public boolean checkCustomerStatus() {
        return false;
    }
}
