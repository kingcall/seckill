package com.kingcall.seckill.controller;

import com.kingcall.seckill.entity.Item;
import com.kingcall.seckill.entity.ItemStock;
import com.kingcall.seckill.model.ItemModel;
import com.kingcall.seckill.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping("/create")
    public void create(@Valid ItemModel itemModel) {
        Item item = new Item();
        itemService.createItem(itemModel);
    }


    @RequestMapping("/get")
    public ItemModel getItem(@RequestParam("id") int id) {
        return itemService.getItem(id);
    }

    @RequestMapping("/list")
    public List<ItemModel> listItmes() {
        return itemService.listItmes();
    }


}
