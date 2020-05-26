package com.github.fourteam.pikachu.week1.bbubbush.service;

import com.github.fourteam.pikachu.week1.bbubbush.domain.Customer;
import com.github.fourteam.pikachu.week1.bbubbush.domain.Product;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;
import static org.hamcrest.CoreMatchers.*;
import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class OrderServiceTest {
    private OrderService orderService;
    private Customer[] customers;
    private Product[] products;

    @Before
    public void setUp () {
        orderService = new OrderService();

        // 상품정보
        products = new Product[3];
        products[0] = new Product.Builder()
                .productCode(111111L)
                .productPrice(20000L)
                .giftNo(12345L)
                .stock(10)
                .build();
        products[1] = new Product.Builder()
                .productCode(222222L)
                .productPrice(10000L)
                .giftNo(0L)
                .stock(40)
                .build();
        products[2] = new Product.Builder()
                .productCode(333333L)
                .productPrice(10000L)
                .giftNo(0L)
                .stock(0)
                .build();

        // 고객정보
        this.customers = new Customer[4];
        this.customers[0] = new Customer.Builder("dynee313", "dy", CustomerType.Employees)
                .hasPoint(0L)
                .isBlackConsumer(false)
                .builder();
        this.customers[1] = new Customer.Builder("imesung", "hs", CustomerType.Employees)
                .hasPoint(10000L)
                .isBlackConsumer(false)
                .builder();
        this.customers[2] = new Customer.Builder("mike6321", "jw", CustomerType.Normal)
                .hasPoint(2000L)
                .isBlackConsumer(false)
                .builder();
        this.customers[3] = new Customer.Builder("bbubbush", "sh", CustomerType.Normal)
                .hasPoint(0L)
                .isBlackConsumer(true)
                .builder();
    }

    @Test
    public void 주문서_진입가능여부_확인 () {
        Product product = products[0];
        Customer customer = customers[0];

        Map<String, String> responseMap = orderService.requestOrder(product, customer);

        assertThat(responseMap.get("Status"), Is.is(equalTo("E")));
    }

}