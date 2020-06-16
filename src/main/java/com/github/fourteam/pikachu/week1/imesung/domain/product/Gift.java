package com.github.fourteam.pikachu.week1.imesung.domain.product;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "giftId")
public class Gift {
    private static Logger logger = LoggerFactory.getLogger(Gift.class);

    private String giftId;
    private Long giftStock;

    /**
     * Name : 일반 고객 주문 가능 여부 확인
     * Date : 2020/06/17
     * info : 사은품의 개수가 0이면 주문 불가
     */
    public boolean chkGeneral() {
        if(this.giftStock == 0) {
            logger.info("일반 고객이므로 사은품이 존재하지 않아 주문 불가");
            return false;
        }
        return true;
    }

    /**
     * Name : 임직원 주문 가능 여부 확인
     * Date : 2020/06/17
     */
    public boolean chkExcutive() {
        if(this.giftStock > 0) {
            logger.info("임직원 고객이므로 사은품이 존재하여 주문 불가");
            return false;
        }
        return true;
    }

    /**
     * Name : 임직원 주문 가능 여부 확인
     * Date : 2020/06/17
     */
    public boolean chkPartner() {
        if(this.giftStock < 10) {
            logger.info("협력사 고객이므로 사은품 10개 미만으로 주문 불가");
            return false;
        }
        return true;
    }

}
