package com.github.fourteam.pikachu.week1.bbubbush.domain;


import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;

public class GiftProduct implements Products {
    private final long giftCd;      // 사은품코드
    private final int stock;       // 재고

    public static class Builder {
        private long giftCd;
        private int stock = 0;

        public Builder (long giftCd, int stock) {
            this.giftCd = giftCd;
            this.stock = stock;
        }
        public Builder giftCd(long giftCd) {
            this.giftCd = giftCd;
            return this;
        }
        public Builder stock(int stock) {
            this.stock = stock;
            return this;
        }

        public GiftProduct build() {
            return new GiftProduct(this);
        }
    }

    private GiftProduct(Builder builder) {
        this.giftCd = builder.giftCd;
        this.stock = builder.stock;
    }

    public long getGiftCd() {
        return giftCd;
    }

    public int getStock() {
        return stock;
    }

    @Override
    public String toString() {
        return "GiftProduct{" +
                "giftCd=" + giftCd +
                ", stock=" + stock +
                '}';
    }

    // checkGift() 기능 구현
    @Override
    public boolean checkHasStock() {
        return this.stock > 0;
    }
}
