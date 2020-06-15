package com.github.fourteam.pikachu.week1.bbubbush.domain.product;

import lombok.Builder;
import lombok.Getter;

@Getter
public class SalesProduct implements Product{

    private Long stock;
    private GiftProduct gift;

    @Builder
    public SalesProduct(Long stock) {
        this.stock = stock;
    }
    /**
     * Name: 상품 주문가능여부 확인
     * Date: 2020/06/15
     * Info:
     *  재고가 있으면 true, 없으면 false
     */
    @Override
    public boolean checkProduct() {
        return stock > 0;
    }

    @Override
    public boolean hasGiftProduct() {
        return gift.getStock() > 0L;
    }
}
