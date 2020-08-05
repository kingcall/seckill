package com.kingcall.seckill.service.impl;

import com.kingcall.seckill.common.MD5Util;
import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.mapper.UserMapper;
import com.kingcall.seckill.mapper.UserPasswdMapper;
import com.kingcall.seckill.entity.User;
import com.kingcall.seckill.entity.UserPasswd;
import com.kingcall.seckill.service.UserService;
import com.kingcall.seckill.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Autowired
    UserPasswdMapper userPasswdMapper;

    @Override
    public UserModel getUserById(int id) {
        User user = userMapper.selectByPrimaryKey(id);
        if (user == null) {
            return null;
        }
        UserPasswd passwd = userPasswdMapper.selectByUserId(user.getId());
        return converUserModel(user, passwd);
    }

    @Override
    @Transactional
    public void register(UserModel userModel) throws BusinessException {
        if (userModel == null) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        if (StringUtils.isEmpty(userModel.getName()) || userModel.getAge() == null || userModel.getGender() == null || StringUtils.isEmpty(userModel.getPhone())) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR);
        }

        User user = new User();
        BeanUtils.copyProperties(userModel, user);
        try {
            userMapper.insertSelective(user);
        } catch (DuplicateKeyException e) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "手机号重复注册");
        }

        UserPasswd passwd = new UserPasswd();
        BeanUtils.copyProperties(userModel, passwd);
        passwd.setUserId(user.getId());
        userPasswdMapper.insertSelective(passwd);
    }

    @Override
    public void login(String telephone, String password) throws BusinessException {
        // 通过用户手机获取用户信息
        User user = userMapper.selectByTelephone(telephone);
        if (user == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXISTT);
        }
        UserPasswd passwd = userPasswdMapper.selectByUserId(user.getId());
        if (!MD5Util.stringToMD5(password).equals(passwd.getEncrptPassword())) {
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR, "密码错误");
        }
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
