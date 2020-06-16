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
    private CustomerType customerType;
    private String retireDate;
    private String supId;


    public static class Builder {
        private final String userId;		//ID
        private final String userName;		//name
        private String customerGubun = "0";  //고객 상태
        private long point = 0L;			// 보유포인트
        private boolean blackConsumerFlg = true;	//거래거절 고객 여부
        private CustomerType customerType;
        private String retireDate;
        private String supId;

        public Builder(String userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        public Builder customerGubun(String customerGubun) {
            this.customerGubun = customerGubun;
            return this;
        }

        public Builder customerType(CustomerType customerType) {
            this.customerType = customerType;
            return this;
        }

        public Builder point(long point) {
            this.point = point;
            return this;
        }

        public Builder retireDate(String retireDate) {
            this.retireDate = retireDate;
            return this;
        }

        public Builder blackConsumerFlg(boolean blackConsumerFlg) {
            this.blackConsumerFlg = blackConsumerFlg;
            return this;
        }

        public Builder supId(String supId) {
            this.supId = supId;
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
        this.customerType = builder.customerType;
        this.retireDate = builder.retireDate;
        this.supId = builder.supId;
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

    public String getSupId() {
        return supId;
    }

    public CustomerType getCustomerType() {
        return customerType;
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

    /**
     * 임직원 고객 포인터 확인
     */
    public boolean excPoint() {
        boolean rsltFlg;
        if(this.point == 0 || null != this.retireDate) {
            logger.info(this.userId + " 포인터 0원이거나 퇴사 직원으로 인해 주문 진입 불가.");
            rsltFlg = false;
        } else {
            logger.info(this.userId + " 포인터 0원 이상으로 주문 진입 가능.");
            rsltFlg = true;
        }
        return rsltFlg;
    }
}
