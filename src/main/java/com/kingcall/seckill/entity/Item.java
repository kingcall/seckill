package com.kingcall.seckill.entity;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Item {
    private Integer id;

    private String title;

    private BigDecimal price;

    private String description;

    private String imgurl;

    private Integer sales;

}
