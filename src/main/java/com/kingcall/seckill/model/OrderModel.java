package com.kingcall.seckill.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderModel {
    /**
     * 交易号
     */
    private String id;

    private Integer userId;

    private Integer itemId;

    /**
     * 购买的数量
     */
    private Integer amount;

    /**
     * 购买的金额
     */
    private BigDecimal orderPrice;

    /**
     * 购买时商品的价格
     */
    private BigDecimal itemPrice;

    /**
     * 表示订单是参与的秒杀活动
     */
    private Integer promoId;

}
