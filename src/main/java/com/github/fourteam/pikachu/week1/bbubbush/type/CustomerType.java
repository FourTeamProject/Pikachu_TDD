package com.github.fourteam.pikachu.week1.bbubbush.type;

public enum CustomerType {
    Employees(0)
    , Normal(1)
    ;

    private int customerTypeValue;

    CustomerType (int customerTypeValue) {
        this.customerTypeValue = customerTypeValue;
    }

    public int getCustomerTypeValue() {
        return customerTypeValue;
    }
}
