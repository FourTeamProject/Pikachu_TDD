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
        customers.add(new Customer("mike6321", "jw", 1, 2000, false));
        customers.add(new Customer("imesung", "hs", 0, 10000, false));
        customers.add(new Customer("dynee313", "dy", 0, 0, false));
        customers.add(new Customer("leetsh", "sh", 2, 0, true));
    }

    @Test
    public void 기본객체_생성확인() {
        //given
        Customer customer = new Customer("mesung", "Hye Sung", 1, 3000, false);

        //when

        //then
        assertNotNull(customer);
        assertThat(customer.getUserId(), is(notNullValue()));
        assertThat(customer.getUserId(), is(equalTo("mesung")));
        assertThat(customer.getPoint(), is(equalTo(3000L)));
        assertThat(customer.getUserName(), is(equalTo("Hye Sung")));
        assertFalse(customer.isBlackConsumerFlg());

    }

    @Test
    public void 회원권한_확인() {
        //given
        Boolean [] custChkGubuns = new Boolean[customers.size()];

        //when
        for(int i = 0; i < customers.size(); i++) {
            custChkGubuns[i] = customers.get(i).chkCustGubunInTDD();
        }

        //then
        //given-when 활용
        assertTrue(custChkGubuns[0]);
        assertTrue(custChkGubuns[1]);
        assertTrue(custChkGubuns[2]);
        assertFalse(custChkGubuns[3]);

        //setUp 활용
        assertTrue(this.customers.get(0).chkCustGubunInTDD());
        assertTrue(this.customers.get(1).chkCustGubunInTDD());
        assertTrue(this.customers.get(2).chkCustGubunInTDD());
        assertFalse(this.customers.get(3).chkCustGubunInTDD());

    }
}