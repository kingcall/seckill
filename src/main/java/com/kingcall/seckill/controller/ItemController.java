package com.kingcall.seckill.controller;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.entity.Item;
import com.kingcall.seckill.model.ItemModel;
import com.kingcall.seckill.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public CommonReturnType create(@Valid ItemModel itemModel) {
        Item item = new Item();
        itemService.createItem(itemModel);
        return CommonReturnType.create("上架成功");
    }


    @RequestMapping("/get")
    public ItemModel getItem(@RequestParam("id") int id) throws BusinessException {
        ItemModel itemModel = itemService.getItem(id);
        if (itemModel==null){
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST_ERROR);
        }
        return itemModel;
    }

    @RequestMapping("/list")
    public List<ItemModel> listItmes() {
        return itemService.listItmes();
    }


}
