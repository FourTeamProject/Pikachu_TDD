package com.github.fourteam.pikachu.week1.imesung.domain.customer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Customer {
    private static Logger logger = LoggerFactory.getLogger(Customer.class);

    private String userId;		//ID
    private String userName;		//name
    private String customerGubun;  //고객 상태
    private long point;			// 보유포인트
    private boolean blackConsumerFlg;	//거래거절 고객 여부


    public static class Builder {
        private final String userId;		//ID
        private final String userName;		//name
        private String customerGubun = "0";  //고객 상태
        private long point = 0L;			// 보유포인트
        private boolean blackConsumerFlg = true;	//거래거절 고객 여부

        public Builder(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        public Builder customerGubun(String customerGubun) {
            this.customerGubun = customerGubun;
            return this;
        }

        public Builder point(long point) {
            this.point = point;
            return this;
        }

        public Builder blackConsumerFlg(boolean blackConsumerFlg) {
            this.blackConsumerFlg = blackConsumerFlg;
            return this;
        }

        public Customer build() {
            return new Customer(this);
        }
    }


    public Customer(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.point = builder.point;
        this.customerGubun = builder.customerGubun;
        this.blackConsumerFlg = builder.blackConsumerFlg;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public long getPoint() {
        return point;
    }

    public boolean isBlackConsumerFlg() {
        return blackConsumerFlg;
    }

    //TDD
    public boolean chkCustGubun() {
        if(this.customerGubun.equals("0") || this.customerGubun.equals("1")) {
            logger.info(this.userName + "님은 저희 서비스를 이용할 수 있습니다.");
            return true;
        } else {
            return false;
        }
    }
}
