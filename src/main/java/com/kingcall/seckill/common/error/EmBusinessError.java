package com.kingcall.seckill.common.error;

public enum EmBusinessError implements CommonError {
    /**
     * 1000开头的代表用户信息错误
     */
    USER_NOT_EXISTT(10001, "用户不存在"),
    /**
     * 参数不合法
     */
    PARAMETER_VALIDATION_ERROR(00001, "参数不合法"),
    UNKONW_ERROR(00002,"未知错误")
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
