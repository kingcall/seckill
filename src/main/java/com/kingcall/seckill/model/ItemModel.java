package com.kingcall.seckill.model;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ItemModel {
    private Integer id;
    /**
     * 商品名称
     */

    @NotBlank(message = "名称不能为空")
    private String title;

    @NotNull(message = "库存不能为空")
    private Integer stock;

    @NotBlank(message = "描述信息不能为空")
    private String description;

    @NotNull
    @Min(value = 0, message = "商品价格不能小于0")
    private BigDecimal price;

    /**
     * 销量
     */
    private Integer sales;

    @NotNull(message = "图片信息不能为空")
    private String imgurl;

    /**
     * 使用聚合模型，将商品正在进行和还未开始的活动聚合进来
     */
    PromoModel promoModel;
}
