package com.kingcall.seckill.model;


import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.relational.core.sql.In;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PromoModel {
    private Integer id;
    @NotBlank(message = "活动名称不能为空")
    private String promoName;

    @NotBlank(message = "开始时间不能为空")
    private DateTime startTime;

    @NotBlank(message = "结束时间不能为空")
    private DateTime endTime;

    @NotBlank(message = "商品不能为不能为空")
    private Integer itemId;

    @NotBlank(message = "价格不能为不能为空")
    private Long promoPrice;
    /**
     * 秒杀活动状态 1 没有开始  2进行中 3已结束
     */
    private Integer status;


}
