package com.kingcall.seckill.controller;


import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.mapper.UserMapper;
import com.kingcall.seckill.model.User;
import com.kingcall.seckill.service.UserService;
import com.kingcall.seckill.service.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Slf4j
@RestController("/user")
public class UserController {
    Random random = new Random();
    @Autowired
    UserService userService;
    @Autowired
    HttpServletRequest httpServlet;

    @RequestMapping("/get")
    public CommonReturnType getUserById(int id) throws BusinessException {
        UserModel user = userService.getUserById(id);
        if (id == 3) {
            throw new NullPointerException();
        }

        if (user == null) {
            throw new BusinessException(EmBusinessError.USER_NOT_EXISTT);
        }

        return CommonReturnType.create(user);
    }

    /**
     * 获取opt 短信接口
     *
     * @param telephone
     * @return
     */
    @RequestMapping("/getOpt")
    public CommonReturnType getOpt(@RequestParam(name = "telephone") String telephone) {
        // 按照一定的规则生成验证码
        int result = random.nextInt(99999);
        String optCode = String.valueOf(result);
        // 将验证码和用户手机号关联(可以采用redis)
        httpServlet.getSession().setAttribute(telephone, optCode);
        log.info("====================== telephone:{} optCode:{} ==================",telephone,optCode);
        // 发送验证码给用户
        return CommonReturnType.create(optCode);
    }
}
