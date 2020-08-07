package com.kingcall.seckill.model;


import com.kingcall.seckill.common.TimeValidate;
import lombok.Data;
import org.joda.time.DateTime;
import org.springframework.data.relational.core.sql.In;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.math.BigDecimal;
import java.util.Date;

@Data
@TimeValidate(startTime = "startTime", endTime = "endTime")
public class PromoModel {
    private Integer id;

    @NotBlank(message = "活动名称不能为空")
    private String promoName;

    @NotNull(message = "开始时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime startTime;

    @NotNull(message = "结束时间不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private DateTime endTime;

    @NotNull(message = "商品不能为空")
    private Integer itemId;

    @NotNull(message = "价格不能为空")
    @Min(value = 0, message = "商品价格不能小于0")
    private BigDecimal promoPrice;
    /**
     * 秒杀活动状态 1 没有开始  2进行中 3已结束
     */
    private Integer status;


}
