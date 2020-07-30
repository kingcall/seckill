package com.kingcall.seckill.service.impl;

import com.kingcall.seckill.mapper.UserMapper;
import com.kingcall.seckill.mapper.UserPasswdMapper;
import com.kingcall.seckill.model.User;
import com.kingcall.seckill.model.UserPasswd;
import com.kingcall.seckill.service.UserService;
import com.kingcall.seckill.service.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserPasswdMapper userPasswdMapper;

    @Override
    public UserModel getUserById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user==null){
            return null;
        }
       UserPasswd passwd= userPasswdMapper.selectByUserId(user.getId());
        return converUserModel(user, passwd);
    }

    private UserModel converUserModel(User user, UserPasswd passwd) {
        UserModel userModel = new UserModel();
        BeanUtils.copyProperties(user, userModel);
        if (passwd == null) {
            return userModel;
        }
        userModel.setEncrptPassword(passwd.getEncrptPassword());
        return userModel;
    }
}
