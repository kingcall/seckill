package com.kingcall.seckill.common;


import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.common.response.CommonReturnType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(Exception.class)
    public Object handle(Exception e) {
        Map<String, Object> msg = new HashMap<String, Object>();
        msg.put("errCode", EmBusinessError.UNKONW_ERROR.getErrorCode());
        msg.put("errorMsg", EmBusinessError.UNKONW_ERROR.getErrorMsg());
        return CommonReturnType.create(msg, "fail");
    }

}
