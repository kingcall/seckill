package com.kingcall.seckill.service;

import com.kingcall.seckill.model.ItemModel;

import java.util.List;

public interface ItemService {
    void createItem(ItemModel itemModel);
    List<ItemModel> listItmes();
    ItemModel getItem(int id);
}
