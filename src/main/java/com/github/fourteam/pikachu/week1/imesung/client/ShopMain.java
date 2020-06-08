package com.github.fourteam.pikachu.week1.imesung.client;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShopMain {
    private static Logger logger = LoggerFactory.getLogger(ShopMain.class);

    public static void main(String[] args) {
        Customer customer = new Customer.Builder("mike6321", "junwoo")
                .customerGubun("1")
                .point(2000)
                .blackConsumerFlg(false)
                .build();

        customer.chkCustGubun();

    }
}
