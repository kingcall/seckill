package com.kingcall.seckill.service;

import com.kingcall.seckill.model.PromoModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PromoServiceTest {
    @Autowired
    PromoService promoService;
    @Test
    void getPromoByItemId() {
        PromoModel promoModel=promoService.getPromoByPrimaryKey(9);
        assertEquals(2,promoModel.getStatus(),"活动状态信息异常");
        System.out.println(promoModel);

    }

    @Test
    void createPromo() {
    }

    @Test
    void getPromoByPrimaryKey() {
    }
}