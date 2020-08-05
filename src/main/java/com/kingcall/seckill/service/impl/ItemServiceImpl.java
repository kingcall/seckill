package com.kingcall.seckill.service.impl;

import com.kingcall.seckill.entity.Item;
import com.kingcall.seckill.entity.ItemStock;
import com.kingcall.seckill.mapper.ItemMapper;
import com.kingcall.seckill.mapper.ItemStockMapper;
import com.kingcall.seckill.model.ItemModel;
import com.kingcall.seckill.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    ItemMapper itemMapper;

    @Autowired
    ItemStockMapper stockMapper;

    @Override
    @Transactional
    public void createItem(@Valid ItemModel itemModel) {

        Item item = new Item();
        BeanUtils.copyProperties(itemModel, item);
        itemMapper.insertSelective(item);

        ItemStock stock = new ItemStock();
        BeanUtils.copyProperties(itemModel, stock);
        stock.setItemId(item.getId());
        stockMapper.insertSelective(stock);
    }

    @Override
    public List<ItemModel> listItmes() {
        return itemMapper.listItem().stream().map(item -> {
            ItemStock itemStock = stockMapper.selectByItemId(item.getId());
            return convertItemModel(item, itemStock);
        }).collect(Collectors.toList());
    }

    @Override
    public ItemModel getItem(int id) {
        Item item = itemMapper.selectByPrimaryKey(id);
        if (item == null) {
            return null;
        }
        ItemStock stock = stockMapper.selectByItemId(id);
        return convertItemModel(item, stock);
    }

    @Override
    @Transactional
    public boolean decreaseStock(Integer itemId, Integer amount) {
        int affectRow = stockMapper.decreaseStock(itemId, amount);
        if (affectRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    private ItemModel convertItemModel(Item item, ItemStock stock) {
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(item, itemModel);
        itemModel.setStock(stock.getStock());
        return itemModel;
    }
}
