package com.kingcall.seckill.common.error;

public enum EmBusinessError implements CommonError {
    UNKONW_ERROR(10002,"未知错误"),
    /**
     * 参数不合法
     */
    PARAMETER_VALIDATION_ERROR(10001, "参数不合法"),

    /**
     * 2000开头的代表用户信息错误
     */
    USER_NOT_EXISTT(20001, "用户不存在"),
    USER_NOT_LOGIN(20002, "用户未登录"),

    /**
     * 3000 开头代表交易错误
     */
    ITEM_NOT_EXIST_ERROR(30001,"商品不存在"),
    ORDER_ERROR(30002,"交易错误"),



    ;


    private EmBusinessError(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }


    private int errorCode;
    private String errorMessage;

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public String getErrorMsg() {
        return this.errorMessage;
    }

    @Override
    public CommonError setErrorMsg(String errorMessage) {
        this.errorMessage = errorMessage;
        return this;
    }
    }
