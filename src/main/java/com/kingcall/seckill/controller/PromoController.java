package com.kingcall.seckill.controller;

import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.model.PromoModel;
import com.kingcall.seckill.service.PromoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/promo")
public class PromoController {
    @Autowired
    PromoService promoService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    CommonReturnType createPromo(@Valid PromoModel promoModel) {
        promoService.createPromo(promoModel);
        return CommonReturnType.create("创建活动成功");
    }
}
