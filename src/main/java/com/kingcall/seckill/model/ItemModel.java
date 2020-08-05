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
    @Min(value = 0, message = "商品价格必须大于0")
    private BigDecimal price;

    /**
     * 销量
     */
    private Integer sales;

    @NotNull(message = "图片信息不能为空")
    private String imgurl;
}
