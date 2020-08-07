package com.kingcall.seckill.entity;

import lombok.Data;

import java.util.Date;

@Data
public class PromoAction {
    private Integer id;
    private String promoName;
    private Date startTime;
    private Date endTime;
    private Integer itemId;
    private Long promoPrice;
}