package com.github.fourteam.pikachu.week1.imesung.domain.customer;

public class CustomerFactory {
    public SuperCustomer createCustomer(int gubun) {
        SuperCustomer superCustomer = null;
        if(gubun == 0) {
            superCustomer = new ExcutiveCustomer();
        } else if(gubun == 1) {
            superCustomer = new GeneralCustomer();
        } else {
            superCustomer = new RejectCustomer();
        }
        return superCustomer;
    }
}
