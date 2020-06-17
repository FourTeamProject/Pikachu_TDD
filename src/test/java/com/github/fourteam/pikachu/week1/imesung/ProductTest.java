package com.github.fourteam.pikachu.week1.imesung;

import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductTest {

    @Before
    public void setUp() {
        Product product = Product.builder()
                .prdId("1")
                .prdStock(3L)
                .prdPrice(10000L)
                .supId("9")
                .build();
    }

    @Test
    public void 재고여부확인() {
        //given
        Product product = Product.builder()
                .prdId("1")
                .prdStock(3L)
                .prdPrice(10000L)
                .supId("9")
                .build();

        //when

        //then
        assertTrue(product.checkProduct());
    }
}