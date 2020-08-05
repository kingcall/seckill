package com.kingcall.seckill.controller;


import com.kingcall.seckill.common.Constant;
import com.kingcall.seckill.common.error.BusinessException;
import com.kingcall.seckill.common.error.EmBusinessError;
import com.kingcall.seckill.common.response.CommonReturnType;
import com.kingcall.seckill.service.UserService;
import com.kingcall.seckill.model.UserModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Random;

@Slf4j
@RestController
@RequestMapping("/user")
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

    /**
     * @param userModel 用户注册时提供的信息
     * @param optCode   发送到用户手机上的optCode
     * @return
     */
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public CommonReturnType register(@Valid UserModel userModel,String optCode) throws BusinessException {
        // 验收手机号和optcode 是否对应
        String inSessionOptcode = (String) httpServlet.getSession().getAttribute(userModel.getPhone());
        if (!StringUtils.equals(optCode, inSessionOptcode)) {
            log.debug(optCode+"==========="+inSessionOptcode);
            //throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"验证码错误");
        } else {
            // 处理用户注册请求
            userService.register(userModel);
            return CommonReturnType.create("注册成功");
        }
        userService.register(userModel);
        return CommonReturnType.create("注册成功");
    }



    @RequestMapping("/login")
    public CommonReturnType login(@RequestParam(name = "telephone") String telephone,@RequestParam(name = "telephone") String passwd) throws BusinessException {
        // 入参数校验
        if (StringUtils.isEmpty(telephone)|| StringUtils.isEmpty(passwd)){
            throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,"参数不能为空");
        }
        userService.login(telephone, passwd);
        // 将用户信息加入到登陆成功的session 内
        httpServlet.getSession().setAttribute(Constant.IS_LOGIN, true);
        return CommonReturnType.create("登陆成功");
    }

}
