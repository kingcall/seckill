package com.kingcall.seckill.service;

import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.model.UserModel;


public interface UserService {
    UserModel getUserById(int id);

    void register(UserModel userModel) throws BusinessException;

    void login(String telephone, String password) throws BusinessException;
}
