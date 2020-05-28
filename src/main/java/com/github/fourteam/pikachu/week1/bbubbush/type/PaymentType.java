package com.github.fourteam.pikachu.week1.bbubbush.type;

public enum PaymentType {
    Kakaopay("카카오페이")
    , Cash("현금")
    , CreditCard("신용카드")
    , Point("포인트")
    ;

    private String paymentName;
    PaymentType(String name) {
        this.paymentName = name;
    }

    public String getPaymentName() {
        return paymentName;
    }
}
