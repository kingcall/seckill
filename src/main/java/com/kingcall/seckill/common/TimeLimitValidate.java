package com.kingcall.seckill.common;

import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

@Slf4j
public class TimeLimitValidate implements ConstraintValidator<TimeValidate, Object> {

    private TimeValidate timeLimit;

    @Override
    public void initialize(TimeValidate constraintAnnotation) {
        this.timeLimit = constraintAnnotation;
    }


    @Override
    public boolean isValid(Object object, ConstraintValidatorContext constraintValidatorContext) {
        Object startTime = getObjectPropertyValue(object, timeLimit.startTime());
        Object endTime = getObjectPropertyValue(object, timeLimit.endTime());
        if (null == startTime || null == endTime || !startTime.getClass().equals(endTime.getClass())) {
            return true;
        }
        if (startTime instanceof Long && (Long) startTime > (Long) endTime) {
            return false;
        }
        boolean isValid = DateTime.parse(startTime.toString()).isBefore(DateTime.parse(endTime.toString()));
        if (isValid) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 从Object中获取指定的属性的值
     *
     * @param object
     * @param paramName
     * @return
     * @throws NoSuchFieldException
     * @throws IllegalAccessException
     */
    private Object getObjectPropertyValue(Object object, String paramName) {
        Field field = null;
        try {
            field = object.getClass().getDeclaredField(paramName);
            field.setAccessible(true);
            return field.get(object);
        } catch (Exception e) {
            log.info("===异常信息 e = ", e);
        }
        return null;
    }

}
