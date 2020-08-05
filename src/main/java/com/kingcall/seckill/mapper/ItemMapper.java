package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);
}
