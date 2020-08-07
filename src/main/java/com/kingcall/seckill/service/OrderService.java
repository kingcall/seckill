package com.kingcall.seckill.service;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.model.OrderModel;

public interface OrderService {
    /**
     *
     * @param userId  下单用户
     * @param itemId  下单商品
     * @param amount 下单的个数
     * @return
     */
    OrderModel createOrder(Integer userId, Integer itemId, Integer amount,Integer promoId) throws BusinessException;
}
