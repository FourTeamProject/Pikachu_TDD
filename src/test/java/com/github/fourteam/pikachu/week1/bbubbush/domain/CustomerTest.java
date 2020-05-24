package com.github.fourteam.pikachu.week1.bbubbush.domain;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void 기본객체_생성하기() {
        // given
        Customer customer = new Customer.Builder("bbubbush", "이상훈", 0)
                .hasPoint(1000L)
                .isBlackConsumer(false)
                .builder();

        // when

        // then
        assertThat(customer, is(notNullValue()));
        assertThat(customer.getUserId(), is(equalTo("bbubbush")));
        assertThat(customer.getUserName(), is(equalTo("이상훈")));
        assertThat(customer.getPoint(), is(equalTo(1000L)));
        assertFalse(customer.isBlackConsumerFlg());
    }

}