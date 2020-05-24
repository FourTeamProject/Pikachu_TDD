package com.github.fourteam.pikachu.week1.bbubbush.domain;

public class Product {
    private final long prdCd;      // 상품코드
    private final long prdPrc;     // 상품가격
    private final long giftNo;     // 사은품 코드 - 0 일 경우 사은품 없음!
    private final int stock;       // 재고

    public static class Builder {
        // 필수값
        private final long productCode;
        private final long productPrice;

        // 기본값이 존재하는 옵션
        private long giftNo = 0;
        private int stock = 0;

        public Builder (long productCode, long productPrice) {
            this.productCode = productCode;
            this.productPrice = productPrice;

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
    public String toString () {
        return "prdCd : " + this.prdCd + ", prdPrc : " + this.prdPrc + ", giftNo : " + this.giftNo + ", stock : " + this.stock;
    }

}
