package com.github.fourteam.pikachu.week1.bbubbush.domain;

import static org.hamcrest.CoreMatchers.*;

import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {
    private Customer[] customers;

    /*Customer customer = new Customer("dynee313", "dy", 0, 0, false);      // 임직원
    Customer customer = new Customer("imesung", "hs", 0, 10000, false);   // 임직원
    Customer customer = new Customer("mike6321", "jw", 1, 2000, false);   // 일반고객
    Customer customer = new Customer("leetsh", "sh", 2, 0, true);      // 일반고객 블랙컨슈머*/

    @Before
    public void setUp() {
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
    public void 기본객체_생성하기() {
        // given
        Customer customer = new Customer.Builder("bbubbush", "이상훈", CustomerType.Employees)
                .hasPoint(1000L)
                .isBlackConsumer(false)
                .builder();

        // when

        // then
        assertThat(customer, is(notNullValue()));
        assertThat(customer.getUserId(), is(equalTo("bbubbush")));
        assertThat(customer.getUserName(), is(equalTo("이상훈")));
        assertThat(customer.getUserType(), is(equalTo(CustomerType.Employees)));
        assertThat(customer.getUserType().getCustomerTypeValue(), is(equalTo(0)));
        assertThat(customer.getPoint(), is(equalTo(1000L)));
        assertFalse(customer.isBlackConsumerFlg());
    }


    @Test
    public void 주문가능상태_체크() {
        // given - setUp() 객체사용
        boolean[] canOrderStatus = new boolean[this.customers.length];

        // when
        for (int i = 0; i < this.customers.length; i++) {
            canOrderStatus[i] = this.customers[i].checkCustomerStatus();
        }

        // then
        assertFalse(canOrderStatus[0]);
        assertTrue(canOrderStatus[1]);
        assertTrue(canOrderStatus[2]);
        assertFalse(canOrderStatus[3]);
    }
}