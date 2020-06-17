package com.github.fourteam.pikachu.week1.imesung;

import com.github.fourteam.pikachu.week1.imesung.domain.product.Gift;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GiftTest {

    @Before
    public void setUp() {
        Gift gift = Gift.builder()
                .giftId("1")
                .giftStock(0L)
                .build();
    }

}