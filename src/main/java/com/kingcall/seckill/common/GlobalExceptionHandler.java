package com.kingcall.seckill.common;


import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.common.response.CommonReturnType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    @ResponseStatus(HttpStatus.OK)
    public Object handle(BusinessException businessException) {
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("errCode", businessException.getErrorCode());
        msg.put("errorMsg", businessException.getErrorMsg());
        return CommonReturnType.create(msg, "fail");
    }


    /**
     * 如果你只统一处理 BindException 这个异常的话，你会发现这个方案有时候好用，有时候却会“失灵”。为什么呢？因为对于不同的参数解析方式，
     * Spring做参数校验时会抛出不同的异常，而且这些异常没有继承关系，通过异常获取校验结果的方式也各不相
     * <p>
     * 下面就是常见的参数绑定异常
     *
     * @param e
     * @return
     */
    @ExceptionHandler({ConstraintViolationException.class,
            MethodArgumentNotValidException.class,
            ServletRequestBindingException.class,
            BindException.class})
    public Object handleValidationException(Exception e) {
        String msg = "";
        if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException t = (MethodArgumentNotValidException) e;
            msg = t.getBindingResult().getModel().get("message").toString();
        } else if (e instanceof BindException) {
            BindException t = (BindException) e;
            msg = t.getBindingResult().toString();
        } else if (e instanceof ConstraintViolationException) {
            ConstraintViolationException t = (ConstraintViolationException) e;
            msg = t.getConstraintViolations().stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
        } else if (e instanceof MissingServletRequestParameterException) {
            MissingServletRequestParameterException t = (MissingServletRequestParameterException) e;
            msg = t.getParameterName() + " 不能为空";
        } else if (e instanceof MissingPathVariableException) {
            MissingPathVariableException t = (MissingPathVariableException) e;
            msg = t.getVariableName() + " 不能为空";
        } else {
            msg = "必填参数缺失";
        }
        log.warn("参数校验不通过,msg: {}", msg);
        return CommonReturnType.create(msg, "fail");
    }

    @ExceptionHandler(Exception.class)
    public Object handle(Exception e) {
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("errCode", EmBusinessError.UNKONW_ERROR.getErrorCode());
        msg.put("errorMsg", EmBusinessError.UNKONW_ERROR.getErrorMsg());
        return CommonReturnType.create(msg, "fail");
    }

}
