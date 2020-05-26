package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;

public class Product {
    private final long prdCd;      // 상품코드
    private final long prdPrc;     // 상품가격
    private final long giftNo;     // 사은품 코드 - 0 일 경우 사은품 없음!
    private final int stock;       // 재고

    public static class Builder {
        // 필수값
        private long productCode;
        private long productPrice;

        // 기본값이 존재하는 옵션
        private long giftNo = 0;
        private int stock = 0;

        public Builder () {

        }
        public Builder productCode(long productCode) {
            this.productCode = productCode;
            return this;
        }
        public Builder productPrice(long productPrice) {
            this.productPrice = productPrice;
            return this;
        }
        public Builder giftNo(long giftNo) {
            this.giftNo = giftNo;
            return this;
        }
        public Builder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public Product build() {
            if ( this.productCode == 0L ) throw new RequiredValueException("상품코드는 필수값 입니다.");
            if ( this.productPrice == 0L ) throw new RequiredValueException("상품가격은 필수값 입니다.");

            return new Product(this);
        }
    }

    private Product(Builder builder) {
        this.prdCd = builder.productCode;
        this.prdPrc = builder.productPrice;
        this.giftNo = builder.giftNo;
        this.stock = builder.stock;
    }

    public long getPrdCd() {
        return prdCd;
    }

    public long getPrdPrc() {
        return prdPrc;
    }

    public long getGiftNo() {
        return giftNo;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "Product{" +
                "prdCd=" + prdCd +
                ", prdPrc=" + prdPrc +
                ", giftNo=" + giftNo +
                ", stock=" + stock +
                '}';
    }

    public boolean checkProduct() {
        return this.stock > 0;
    }
}
