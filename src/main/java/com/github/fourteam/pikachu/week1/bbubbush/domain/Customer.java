package com.github.fourteam.pikachu.week1.bbubbush.domain;

import com.github.fourteam.pikachu.week1.bbubbush.exception.RequiredValueException;
import com.github.fourteam.pikachu.week1.bbubbush.type.CustomerType;

public class Customer {
    private String userId;		        // ID
    private String userName;		    // name
    private CustomerType userType;			        // 0: 임직원, 1: 일반고객
    private long point;			        // 보유포인트
    private boolean blackConsumerFlg;	// 블랙컨슈머 여부
    
    public static class Builder {
        // 필수값
        private final String userId;
        private final String userName;
        private final CustomerType userType;

        // 옵션
        private long hasPoint = 0;
        private boolean isBlackConsumer = false;

        public Builder (final String userid, final String userName, final CustomerType userType) {
            this.userId = userid;
            this.userName = userName;
            this.userType = userType;
        }

        public Builder hasPoint(final long hasPoint) {
            this.hasPoint = hasPoint;
            return this;
        }

        public Builder isBlackConsumer(boolean isBlackConsumer){
            this.isBlackConsumer = isBlackConsumer;
            return this;
        }

        public Customer builder() {
            if ( this.userId == null || this.userId.length() == 0 ) throw new RequiredValueException("고객 아이디는 필수값 입니다.");
            if ( this.userName == null || this.userName.length() == 0 ) throw new RequiredValueException("이름은 필수값 입니다.");
            if ( this.userType == null ) throw new RequiredValueException("고객유형은 필수값 입니다.");
            return new Customer(this);
        }
    }

    private Customer(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.userType = builder.userType;
        this.point = builder.hasPoint;
        this.blackConsumerFlg = builder.isBlackConsumer;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public CustomerType getUserType() {
        return userType;
    }

    public long getPoint() {
        return point;
    }

    public boolean isBlackConsumerFlg() {
        return blackConsumerFlg;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userType=" + userType +
                ", point=" + point +
                ", blackConsumerFlg=" + blackConsumerFlg +
                '}';
    }


    public boolean checkCustomerStatus() {
        if ( this.userType.equals(CustomerType.Employees) ) {
            if ( this.point == 0L ) return false;
        }
        else if ( this.userType.equals(CustomerType.Normal) ) {
            if ( this.isBlackConsumerFlg() ) return false;
        }
        return true;
    }
}