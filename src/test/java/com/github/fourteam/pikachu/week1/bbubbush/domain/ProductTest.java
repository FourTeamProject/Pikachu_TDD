package com.github.fourteam.pikachu.week1.bbubbush.domain;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProductTest {

    @Test
    public void 기본객체_생성() {
        // given
        Product product = new Product.Builder()
                .productCode(10L)
                .productPrice(120000L)
                .giftNo(100L)
                .stock(100)
                .build();

        // when - 아직은 별도의 서비스 코드가 없음

        // then
        assertThat(product, is(notNullValue()));
        assertThat(product.getPrdCd(), is(equalTo(10L)));
        assertThat(product.getPrdPrc(), is(equalTo(120000L)));
        assertThat(product.getGiftNo(), is(equalTo(100L)));
        assertThat(product.getStock(), is(equalTo(100)));

    }
}