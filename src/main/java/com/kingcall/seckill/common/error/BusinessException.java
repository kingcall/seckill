package com.kingcall.seckill.common.error;

public class BusinessException extends Exception implements CommonError {

    private CommonError commonError;
    public BusinessException (CommonError commonError){
        super();
        this.commonError = commonError;
    }

    public BusinessException (String errorMessage){
        super();
        setErrorMsg(errorMessage);
    }

    @Override
    public int getErrorCode() {
        return this.commonError.getErrorCode();
    }

    @Override
    public String getErrorMsg() {
        return this.commonError.getErrorMsg();
    }

    @Override
    public CommonError setErrorMsg(String errorMsg) {
        return this.commonError.setErrorMsg(errorMsg);
    }
}
