package com.kingcall.seckill.controller;

import com.kingcall.seckill.common.Constant;
import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.model.UserModel;
import com.kingcall.seckill.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {
    @Autowired
    OrderService orderService;

    @Autowired
    HttpServletRequest httpServlet;


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonReturnType create(
            @RequestParam(name = "userId") Integer userId,
            @RequestParam(name = "itemId") Integer itemId,
            @RequestParam(name = "amount") Integer amount,
            @RequestParam(name = "promoId", required = false) Integer promoId) throws BusinessException {

        // 必須是登录用户才能下单
        Object is_login = httpServlet.getSession().getAttribute(Constant.IS_LOGIN);

        if (is_login == null || (boolean) is_login == false) {
            throw new BusinessException(EmBusinessError.USER_NOT_LOGIN);
        }
        UserModel userModel = (UserModel) httpServlet.getSession().getAttribute(Constant.LOGIN_USER);
        orderService.createOrder(userId, itemId, amount, promoId);
        return CommonReturnType.create("下单成功");
    }

}
