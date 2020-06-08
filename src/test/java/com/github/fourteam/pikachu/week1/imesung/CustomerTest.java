package com.github.fourteam.pikachu.week1.imesung;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

public class CustomerTest {
    private List<Customer> customers = new ArrayList<>();

    @Before
    public void setUp() {
        customers.add(new Customer.Builder("mike6321", "junwoo")
                .customerGubun("1")
                .point(2000)
                .blackConsumerFlg(false)
                .build());

        customers.add(new Customer.Builder("imesung", "hyesung")
                .customerGubun("0")
                .point(1000)
                .blackConsumerFlg(false)
                .build());

        customers.add(new Customer.Builder("bbubbush", "sanghoon")
                .customerGubun("0")
                .point(0)
                .blackConsumerFlg(false)
                .build());

        customers.add(new Customer.Builder("sinsa", "yujin")
                .customerGubun("2")
                .point(0)
                .blackConsumerFlg(true)
                .build());
    }

    @Test
    public void 기본객체_생성확인() {
        //given
        Customer customer = new Customer.Builder("mesung", "hyesung")
                .customerGubun("0")
                .point(1000)
                .blackConsumerFlg(false)
                .build();

        //when

        //then
        assertNotNull(customer);
        assertThat(customer.getUserId(), is(notNullValue()));
        assertThat(customer.getUserId(), is(equalTo("mesung")));
        assertThat(customer.getPoint(), is(equalTo(1000L)));
        assertThat(customer.getUserName(), is(equalTo("hyesung")));
        assertFalse(customer.isBlackConsumerFlg());

    }

    @Test
    public void 회원권한_확인() {
        //given
        Boolean [] custChkGubuns = new Boolean[customers.size()];

        //when
        for(int i = 0; i < customers.size(); i++) {
            custChkGubuns[i] = customers.get(i).chkCustGubun();
        }

        //then
        //given-when 활용
        assertTrue(custChkGubuns[0]);
        assertTrue(custChkGubuns[1]);
        assertTrue(custChkGubuns[2]);
        assertFalse(custChkGubuns[3]);

        //setUp 활용
        assertTrue(this.customers.get(0).chkCustGubun());
        assertTrue(this.customers.get(1).chkCustGubun());
        assertTrue(this.customers.get(2).chkCustGubun());
        assertFalse(this.customers.get(3).chkCustGubun());

    }
}