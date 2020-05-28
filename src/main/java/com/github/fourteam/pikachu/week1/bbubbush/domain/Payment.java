package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.type.PaymentType;

public class Payment {
    private OrderSheet orderSheet;
    private PaymentType paymentType;   // 기본은 신용카드

    private long totalPayment;

    public Payment(OrderSheet orderSheet){
        this(orderSheet, PaymentType.CreditCard);
    }

    public Payment(OrderSheet orderSheet, PaymentType paymentType) {
        this.orderSheet = orderSheet;
        this.paymentType = paymentType;

        this.totalPayment = orderSheet.getProduct().getPrdPrc();
        this.totalPayment = orderSheet.getProduct().getPrdPrc();
    }

    public void pay() {
        if ( this.orderSheet.getCustomer().canUsePoint() ) {
            final long point = this.orderSheet.getCustomer().getPoint();
            if ( this.totalPaymentMoreThanPoint(point) ) {
                // 결제금액 >= 포인트
                this.orderSheet.getCustomer().usePoint(point);
                this.totalPayment -= point;
            }
            else {
                // 결제금액 < 포인트
                this.orderSheet.getCustomer().usePoint(point - this.totalPayment);
                this.totalPayment = 0;
            }
        }
        System.out.println(this.toString());
    }

    private boolean totalPaymentMoreThanPoint(long point) {
        return this.totalPayment >= point;
    }

    @Override
    public String toString() {
        return "[" +
                orderSheet.getCustomer().getUserName() + " 님이 구매하신 상품의 금액은 총 " + orderSheet.getProduct().getPrdPrc() + " 원 입니다. \n" +
                "사용하신 포인트는 " + (this.totalPayment == orderSheet.getProduct().getPrdPrc() ? "없으며, " : (orderSheet.getProduct().getPrdPrc() - orderSheet.getCustomer().getPoint())) + " 이며, 남은 포인트는 " + orderSheet.getCustomer().getPoint() + " 입니다.\n" +
                (this.totalPayment == 0 ? "구매해주셔서 감사합니다." : "남은 잔액 " + this.totalPayment + " 원은 " + this.paymentType.getPaymentName() + " 으로 결제했습니다.") +
                "]";
    }
}
