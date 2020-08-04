package com.kingcall.seckill.entity;

import lombok.Data;

@Data
public class User {
    private Integer id;

    private String name;

    private Byte gender;

    private Short age;

    private String phone;

    private String registerMode;

    private String thirdPartyId;

}
