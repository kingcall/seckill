package com.kingcall.seckill.common;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {TimeLimitValidate.class})
public @interface TimeValidate {
    String message() default "开始时间不能大于结束时间";

    String startTime() default "startTime";
    String endTime() default "endTime";
    boolean required() default true;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}