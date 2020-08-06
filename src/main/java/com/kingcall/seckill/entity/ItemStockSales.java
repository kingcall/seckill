package com.kingcall.seckill.entity;

import lombok.Data;

@Data
public class ItemStockSales {
    private Integer id;

    private Integer itemId;

    private Integer stock;

    private Integer sales;
}