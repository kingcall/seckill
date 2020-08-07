package com.kingcall.seckill.service.impl;

import com.kingcall.seckill.entity.Item;
import com.kingcall.seckill.entity.ItemStockSales;
import com.kingcall.seckill.mapper.ItemMapper;
import com.kingcall.seckill.mapper.ItemStockSalesMapper;
import com.kingcall.seckill.model.ItemModel;
import com.kingcall.seckill.model.PromoModel;
import com.kingcall.seckill.service.ItemService;
import com.kingcall.seckill.service.PromoService;
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
    ItemStockSalesMapper itemStockSalesMapper;

    @Autowired
    PromoService promoService;

    @Override
    @Transactional
    public void createItem(@Valid ItemModel itemModel) {

        Item item = new Item();
        BeanUtils.copyProperties(itemModel, item);
        itemMapper.insertSelective(item);

        ItemStockSales stock = new ItemStockSales();
        BeanUtils.copyProperties(itemModel, stock);
        stock.setItemId(item.getId());
        itemStockSalesMapper.insertSelective(stock);
    }

    @Override
    public List<ItemModel> listItmes() {
        return itemMapper.listItem().stream().map(item -> {
            ItemStockSales itemStock = itemStockSalesMapper.selectByItemId(item.getId());
            return convertItemModel(item, itemStock);
        }).collect(Collectors.toList());
    }

    @Override
    public ItemModel getItem(int id) {
        //获取商品主信息
        Item item = itemMapper.selectByPrimaryKey(id);
        if (item == null) {
            return null;
        }
        // 获取商品库存信息
        ItemStockSales stock = itemStockSalesMapper.selectByItemId(id);
        ItemModel itemModel = convertItemModel(item, stock);

        // 获取商品活动信息
        PromoModel promoModel = promoService.getPromoByItemId(id);
        if (promoModel != null && promoModel.getStatus() != 3) {
            itemModel.setPromoModel(promoModel);
        }

        return itemModel;
    }

    @Override
    @Transactional
    public boolean decreaseStock(Integer itemId, Integer amount) {
        int affectRow = itemStockSalesMapper.decreaseStock(itemId, amount);
        if (affectRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean increaseSales(Integer itemId, Integer amount) {
        int affectRow = itemStockSalesMapper.increaseSales(itemId, amount);
        if (affectRow > 0) {
            return true;
        } else {
            return false;
        }
    }

    private ItemModel convertItemModel(Item item, ItemStockSales stock) {
        ItemModel itemModel = new ItemModel();
        BeanUtils.copyProperties(item, itemModel);
        itemModel.setStock(stock.getStock());
        return itemModel;
    }
}
