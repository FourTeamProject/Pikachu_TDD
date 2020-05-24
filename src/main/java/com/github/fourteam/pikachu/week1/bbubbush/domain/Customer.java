package com.github.fourteam.pikachu.week1.bbubbush.domain;

public class Customer {
    private String userId;		//ID
    private String userName;		//name
    private int gubun;			//0: 임직원, 1: 일반고객
    private long point;			// 보유포인트
    private boolean blackConsumerFlg;	//



    public static class Builder {
        private final String userId;
        private final String userName;
        private final int userType;

        private long hasPoint = 0;
        private boolean isBlackConsumer = false;

        public Builder (final String userid, final String userName, final int userType) {
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
            return new Customer(this);
        }
    }

    private Customer(Builder builder) {
        this.userId = builder.userId;
        this.userName = builder.userName;
        this.gubun = builder.userType;
        this.point = builder.hasPoint;
        this.blackConsumerFlg = builder.isBlackConsumer;
    }

    public String getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public int getGubun() {
        return gubun;
    }

    public long getPoint() {
        return point;
    }

    public boolean isBlackConsumerFlg() {
        return blackConsumerFlg;
    }
}