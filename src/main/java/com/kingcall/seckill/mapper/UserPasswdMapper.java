package com.kingcall.seckill.mapper;

import com.kingcall.seckill.model.UserPasswd;

public interface UserPasswdMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserPasswd record);

    int insertSelective(UserPasswd record);

    UserPasswd selectByPrimaryKey(Integer id);

    UserPasswd selectByUserId(Integer id);

    int updateByPrimaryKeySelective(UserPasswd record);

    int updateByPrimaryKey(UserPasswd record);


}
