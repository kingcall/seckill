package com.kingcall.seckill.service.model;

import lombok.Data;

@Data
public class UserModel {
    private Integer id;

    private String name;

    private Byte gender;

    private Short age;

    private String phone;

    private String registerMode;

    private String thirdPartyId;

    private String encrptPassword;
}
