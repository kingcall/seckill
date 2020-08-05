package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    List<Item> listItem();

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}
