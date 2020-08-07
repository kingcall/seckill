package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.SequenceInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceInfoMapper {
    int deleteByPrimaryKey(String tableName);

    int insert(SequenceInfo record);

    int insertSelective(SequenceInfo record);

    SequenceInfo getSequenceByName(String tableName);

    int updateByPrimaryKeySelective(SequenceInfo record);

    int updateByPrimaryKey(SequenceInfo record);
}
