package com.kingcall.seckill.service;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.model.OrderModel;

public interface OrderService {
    /**
     *
     * @param userId
     * @param itemId
     * @param amount 下单的个数
     * @return
     */
    OrderModel createOrder(Integer userId, Integer itemId, Integer amount) throws BusinessException;
}
