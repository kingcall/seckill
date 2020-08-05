package com.kingcall.seckill.controller;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonReturnType create(Integer userId, Integer itemId, Integer amount) throws BusinessException {
        orderService.createOrder(userId, itemId, amount);
        return CommonReturnType.create("下单成功");
    }

}
