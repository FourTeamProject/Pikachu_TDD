package com.github.fourteam.pikachu.week1.junwoo.impl;

import com.github.fourteam.pikachu.week1.junwoo.dto.cutomer.Customer;
import com.github.fourteam.pikachu.week1.junwoo.dto.role.Role;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project : pikachu
 *
 * @author : jwdeveloper
 * @comment :
 * Time : 12:21 오전
 */
public class GeneralCustomerAuthorityCheckImplTest {
    @Test
    public void authorityCheckt() {
        Customer customer = Customer.builder()
                                    .userId("bbubbush")
                                    .userName("이상훈")
                                    .point(0)
                                    .role(Role.BLACKCONSUMER)
                                    .build();

        assertNotNull(customer);
        assertFalse("블랙컨슈머 고객은 주문이 불가합니다...",customer.getRole() == Role.BLACKCONSUMER);

    }
}