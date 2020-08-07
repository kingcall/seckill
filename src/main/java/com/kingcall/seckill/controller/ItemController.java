package com.kingcall.seckill.controller;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.entity.Item;
import com.kingcall.seckill.model.ItemModel;
import com.kingcall.seckill.service.ItemService;
import com.kingcall.seckill.vo.ItemVo;
import org.springframework.beans.BeanUtils;
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
    public CommonReturnType getItem(@RequestParam("id") int id) throws BusinessException {
        ItemModel itemModel = itemService.getItem(id);
        if (itemModel == null) {
            throw new BusinessException(EmBusinessError.ITEM_NOT_EXIST_ERROR);
        }
        ItemVo itemVo = new ItemVo();
        BeanUtils.copyProperties(itemModel, itemVo);

        if (itemModel.getPromoModel() != null) {
            itemVo.setProStatus(itemModel.getPromoModel().getStatus());
            itemVo.setPromoId((itemModel.getPromoModel().getId()));
            itemVo.setStartTime((itemModel.getPromoModel().getStartTime()));
            itemVo.setEndTime((itemModel.getPromoModel().getEndTime()));
            itemVo.setPromoPrice((itemModel.getPromoModel().getPromoPrice()));
            itemVo.setPromoName(itemModel.getPromoModel().getPromoName());
        } else {
            itemVo.setProStatus(0);
        }
        return CommonReturnType.create(itemVo);
    }

    @RequestMapping("/list")
    public List<ItemModel> listItmes() {
        return itemService.listItmes();
    }


}
