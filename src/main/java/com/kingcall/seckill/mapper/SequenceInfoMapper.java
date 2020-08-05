package com.kingcall.seckill.mapper;

import com.kingcall.seckill.entity.sequenceInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SequenceInfoMapper {
    int deleteByPrimaryKey(String tableName);

    int insert(sequenceInfo record);

    int insertSelective(sequenceInfo record);

    sequenceInfo getSequenceByName(String tableName);

    int updateByPrimaryKeySelective(sequenceInfo record);

    int updateByPrimaryKey(sequenceInfo record);
}
