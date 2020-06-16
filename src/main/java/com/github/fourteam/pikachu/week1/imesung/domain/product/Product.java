package com.github.fourteam.pikachu.week1.imesung.domain.product;

import com.github.fourteam.pikachu.week1.imesung.domain.customer.Customer;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

@Builder @AllArgsConstructor @NoArgsConstructor
@Getter @Setter @EqualsAndHashCode(of = "prdId")
public class Product {
    private static Logger logger = LoggerFactory.getLogger(Product.class);

    private String prdId;   //상품 코드
    private Long prdStock;  //상품 재고
    private Long prdPrice;  //상품 가격
    private String supId;   //협력사 코드


    /**
     * Name : 협력사 주문 가능 여부 확인
     * Date : 2020/06/17
     * Info :  협력사 직원은 상품 재고에 따라 주문 가능 여부 확인
     */
    public boolean chkPartStock(String supId) {
        boolean rsltFlg;
        logger.info("상품 협력사 코드 : " + this.supId + ", 고객 협력사 코드 : " + supId);
        if(this.supId.equals(supId) && this.prdStock >= 3) {
            logger.info(this.prdId + " 해당 상품 재고 3개 이상으로 협력사 직원 주문 가능");
            rsltFlg = true;
        } else {
            logger.info(this.prdId + " 해당 협력사 직원 주문 불가");
            rsltFlg = false;
        }
        return rsltFlg;
    }


    /**
     * Name : 상품 재고 확인
     * Date : 2020/06/17
     * Info : 상품 재고가 0개 이상이어야 주문 가능
     */
    public boolean checkProduct() {
        if(this.prdStock > 0) {
            return true;
        }
        return false;
    }
}
