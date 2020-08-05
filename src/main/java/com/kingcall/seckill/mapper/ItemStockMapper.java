package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.ItemStock;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemStockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemStock record);

    int insertSelective(ItemStock record);

    ItemStock selectByPrimaryKey(Integer id);
    ItemStock selectByItemId(Integer itemId);

    int updateByPrimaryKeySelective(ItemStock record);

    int updateByPrimaryKey(ItemStock record);
}
