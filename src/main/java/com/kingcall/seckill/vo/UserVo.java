package com.kingcall.seckill.vo;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 用户的部分信息不能传到前台去
 */
public class UserVo {
    private Integer id;
    private String name;
    private String phone;
}
