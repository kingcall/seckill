package com.kingcall.seckill.controller;

import com.alibaba.fastjson.JSON;
import com.kingcall.seckill.model.ItemModel;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
@AutoConfigureMockMvc
class ItemControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void create() throws Exception {
        ItemModel itemModel = new ItemModel();
        itemModel.setStock(10000);
        itemModel.setDescription("甘肃的特产水果");
        itemModel.setTitle("甘肃——五角星");
        itemModel.setPrice(new BigDecimal(9.9));
        itemModel.setImgurl("http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg");
        System.out.println(JSON.toJSONString(itemModel));
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .post("/item/create")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(JSON.toJSONString(itemModel))
                                )
                                .andExpect(MockMvcResultMatchers.status().isOk())
                                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void getItem() throws Exception {
        MvcResult mvcResult = mockMvc
                .perform(
                        MockMvcRequestBuilders
                                .get("/item/get")
                                .param("id", "24")

                )
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();
        log.info(mvcResult.getResponse().getContentAsString());
    }

    @Test
    void listItmes() throws Exception {
        mockMvc
                .perform(MockMvcRequestBuilders.get("/item/list"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}