package com.kingcall.seckill.mapper;

import com.kingcall.seckill.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    User selectByPrimaryKey(Integer id);
    User selectByTelephone(String phone);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);


    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
