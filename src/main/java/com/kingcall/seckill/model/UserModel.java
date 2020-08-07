package com.kingcall.seckill.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class UserModel {

    private Integer id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @NotNull(message = "性别不能不填")
    private Byte gender;

    @NotNull(message = "年龄不能不填")
    @Min(value = 0,message = "年龄必须大于0")
    @Max(value = 150,message = "年龄必须小于150")
    private Short age;

    @NotBlank(message = "手机不能为空")
    private String phone;

    private String registerMode;

    private String thirdPartyId;

    @NotBlank(message = "密码不能为空")
    @Length(min = 6,message = "密码长度不能小于6")
    private String encrptPassword;
}
