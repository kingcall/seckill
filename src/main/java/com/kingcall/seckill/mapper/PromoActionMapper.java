package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.PromoAction;
import org.springframework.stereotype.Repository;

@Repository
public interface PromoActionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PromoAction record);

    int insertSelective(PromoAction record);

    PromoAction selectByPrimaryKey(Integer id);
    PromoAction selectByItemId(Integer itemId);

    int updateByPrimaryKeySelective(PromoAction record);

    int updateByPrimaryKey(PromoAction record);
}