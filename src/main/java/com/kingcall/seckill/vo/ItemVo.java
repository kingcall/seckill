package com.kingcall.seckill.vo;

import com.kingcall.seckill.model.PromoModel;
import lombok.Data;
import org.joda.time.DateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * 整合商品的信息和活动的信息
 */
@Data
public class ItemVo {
    private Integer id;
    private String title;
    private Integer stock;
    private String description;
    private BigDecimal price;
    private Integer sales;
    private String imgurl;
    /**
     * 秒杀活动的信息
     */
    private Long promoPrice;
    /**
     *秒杀活动的状态 0 没有秒杀活动  1 没有开始  2进行中
     */
    private Integer proStatus;
    private DateTime startTime;
    private DateTime endTime;
    private String promoName;
    private Integer promoId;
}
