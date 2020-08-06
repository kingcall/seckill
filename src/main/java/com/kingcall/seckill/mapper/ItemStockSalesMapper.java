package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.ItemStockSales;

public interface ItemStockSalesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemStockSales record);

    int insertSelective(ItemStockSales record);

    ItemStockSales selectByPrimaryKey(Integer id);
    ItemStockSales selectByItemId(Integer itemId);

    int updateByPrimaryKeySelective(ItemStockSales record);

    int updateByPrimaryKey(ItemStockSales record);

    int decreaseStock(Integer itemId, Integer amount);

    int increaseSales(Integer itemId, Integer amount);
}