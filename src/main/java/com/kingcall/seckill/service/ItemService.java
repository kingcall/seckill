package com.kingcall.seckill.service;

import com.kingcall.seckill.model.ItemModel;

import java.util.List;

public interface ItemService {
    void createItem(ItemModel itemModel);
    List<ItemModel> listItmes();
    ItemModel getItem(int id);

    /**
     * 减少库存操作
     * @param itemId
     * @param amount
     * @return
     */
    boolean decreaseStock(Integer itemId, Integer amount);
    boolean increaseSales(Integer itemId, Integer amount);
}
