package com.github.fourteam.pikachu.week1.imesung.domain.order;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import com.github.fourteam.pikachu.week1.imesung.domain.customer.CustomerType;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Gift;
import com.github.fourteam.pikachu.week1.imesung.domain.product.Product;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter
public class OrderSheet {
    private static Logger logger = LoggerFactory.getLogger(OrderSheet.class);

    private Customer customer;
    private Product product;
    private Gift gift;

    /**
     * Name : 고객 및 사은품 주문 가능 여부 확인
     * Date : 2020/06/17
     * Info : 고객 및 사은품에 따라 주문 가능 여부 확인
     */
    public Map<String, String> custChkByOrder() {
        Map<String, String> resultMap = new HashMap<>();
        boolean custChkFlg = false;
        if(customer.getCustomerType().equals(CustomerType.BLACKCONSUMER)){
            logger.info(customer.getUserId() + " 해당 고객 블랙 컨슈머");
        } else if(customer.getCustomerType().equals(CustomerType.EXECUTIVES)) {
            logger.info(customer.getUserId() + " 해당 고객 임직원");
            if(customer.excPoint()) {
                custChkFlg = true;
            }
            if(null != gift && gift.chkExcutive()) {
                custChkFlg = true;
            }

        } else if(this.customer.getCustomerType().equals(CustomerType.PARTNER)) {
            logger.info(this.customer.getUserId() + " 해당 고객 협력사");
            if(product.chkPartStock(customer.getSupId()) && gift.chkPartner()) {
                custChkFlg = true;
            }
        } else if(customer.getCustomerType().equals(CustomerType.GENERAL)) {
            if(gift.chkGeneral()) {
                custChkFlg = true;
            }
        }

        if(custChkFlg) {
            resultMap.put("retCd", "S");
        } else {
            resultMap.put("retCd", "F");
        }

        return resultMap;
    }

}
