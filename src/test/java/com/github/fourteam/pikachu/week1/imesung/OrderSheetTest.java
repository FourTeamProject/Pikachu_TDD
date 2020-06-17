package com.github.fourteam.pikachu.week1.imesung;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.CustomerType;
import com.github.fourteam.pikachu.week1.imesung.domain.order.OrderSheet;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Gift;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class OrderSheetTest {
    private List<Customer> customers = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Gift> gifts = new ArrayList<>();


    @Before
    public void setUp() {

        //고객 생성
        customers.add(new Customer.Builder("imesung", "hyesung")
                .customerGubun("0")
                .point(1000)
                .blackConsumerFlg(false)
                .build());

        customers.add(new Customer.Builder("mike6321", "junwoo")
                .customerGubun("1")
                .point(2000)
                .blackConsumerFlg(false)
                .build());

        customers.add(new Customer.Builder("partner", "partner")
                .customerGubun("3")
                .point(0)
                .blackConsumerFlg(true)
                .customerType(CustomerType.PARTNER)
                .supId("9")
                .build());

        //상품 생성
        products.add(Product.builder()
                .prdId("1")
                .prdStock(3L)
                .prdPrice(10000L)
                .supId("9")
                .build());

        products.add(Product.builder()
                .prdId("2")
                .prdStock(2L)
                .prdPrice(15000L)
                .supId("9")
                .build());

        products.add(Product.builder()
                .prdId("3")
                .prdStock(5L)
                .prdPrice(10000L)
                .build());

        products.add(Product.builder()
                .prdId("4")
                .prdStock(0L)
                .prdPrice(10000L)
                .build());

        //사은품 생성
        gifts.add(Gift.builder()
                .giftId("1")
                .giftStock(0L)
                .build());

        gifts.add(Gift.builder()
                .giftId("2")
                .giftStock(10L)
                .build());

        gifts.add(Gift.builder()
                .giftId("3")
                .giftStock(8L)
                .build());
    }

    @Test
    public void 협력사고객_주문가능여부() {
        //given
        Customer customer = new Customer.Builder("partner", "partner")
                .customerGubun("3")
                .point(0)
                .blackConsumerFlg(true)
                .customerType(CustomerType.PARTNER)
                .supId("9")
                .build();

        Product product = products.get(0);
        Gift gift = gifts.get(1);
        OrderSheet orderSheet = OrderSheet.builder()
                .customer(customer)
                .product(product)
                .gift(gift)
                .build();

        //when
        Map<String, String> orderSheetMap = orderSheet.custChkByOrder();

        //then
        assertThat(orderSheetMap.get("retCd"), is(equalTo("S")));

    }

    @Test
    public void 임직원_주문조건확인() {
        //given
        Customer customer = new Customer.Builder("excutives", "excutives")
                .customerGubun("1")
                .point(110L)
                .blackConsumerFlg(false)
                .customerType(CustomerType.EXECUTIVES)
                //.retireDate("2020/06/15")
                .build();

        Product product = Product.builder()
                .prdId("3")
                .prdStock(3L)
                .prdPrice(10000L)
                .build();

        OrderSheet orderSheet = OrderSheet.builder()
                .customer(customer)
                .product(product)
                .build();


        //when
        Map<String, String> orderSheetMap = orderSheet.custChkByOrder();

        //then
        assertThat(orderSheetMap.get("retCd"), is(equalTo("S")));

    }
}