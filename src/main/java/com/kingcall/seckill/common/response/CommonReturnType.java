package com.kingcall.seckill.common.response;


import lombok.Data;

@Data
public class CommonReturnType {
    /**
     * 请求的处理结果 sucess fail
     */
    String status;
    /**
     * status= sucess 则data 存储返回的数据
     * 否则存储通用的错误码格式
     */
    private Object data;

    public static CommonReturnType create(Object data) {
        return CommonReturnType.create(data, "sucess");
    }

    public static CommonReturnType create(Object data, String status) {
        CommonReturnType commonReturnType = new CommonReturnType();
        commonReturnType.setData(data);
        commonReturnType.setStatus(status);
        return commonReturnType;
    }
}
