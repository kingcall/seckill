package com.kingcall.seckill.controller;


import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.mapper.UserMapper;
import com.kingcall.seckill.model.User;
import com.kingcall.seckill.service.UserService;
import com.kingcall.seckill.service.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/get")
    public CommonReturnType getUserById(int id ){
       UserModel user= userService.getUserById(id);
        return CommonReturnType.create(user);
    }
}
