package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.ItemStock;

public interface ItemStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemStock record);

    int insertSelective(ItemStock record);

    ItemStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemStock record);

    int updateByPrimaryKey(ItemStock record);
}