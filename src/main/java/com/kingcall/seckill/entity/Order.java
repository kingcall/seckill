package com.kingcall.seckill.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Order {
    private String id;

    private Integer userId;

    private Integer itemId;

    private BigDecimal itemPrice;

    private Integer amount;

    private BigDecimal orderPrice;

    private Integer promoId;


}
