create table user
(
    id             int unsigned auto_increment
        primary key,
    name           varchar(50) null,
    gender         tinyint     null comment '1 男 2 女 9 不详',
    age            smallint    null comment '年龄',
    phone          varchar(11) null comment '电话',
    register_mode  varchar(50) null comment '注册方式',
    third_party_id varchar(64) null comment '第三方验证信息',
    constraint idx_unique
        unique (phone)
)
    charset = utf8;

INSERT INTO seckill.user (id, name, gender, age, phone, register_mode, third_party_id) VALUES (1, 'demoData', 1, 1, 'demoData4', 'demoData', 'demoData');
INSERT INTO seckill.user (id, name, gender, age, phone, register_mode, third_party_id) VALUES (2, 'demoData', 1, 1, 'demoData', 'demoData', 'demoData');
INSERT INTO seckill.user (id, name, gender, age, phone, register_mode, third_party_id) VALUES (3, 'demoData', 1, 1, 'demoData2', 'demoData', 'demoData');
INSERT INTO seckill.user (id, name, gender, age, phone, register_mode, third_party_id) VALUES (4, 'demoData', 1, 1, 'demoData3', 'demoData', 'demoData');
INSERT INTO seckill.user (id, name, gender, age, phone, register_mode, third_party_id) VALUES (6, 'demoData', 1, 1, 'demoData5', 'demoData', 'demoData');
INSERT INTO seckill.user (id, name, gender, age, phone, register_mode, third_party_id) VALUES (7, '刘文强', 1, 1, '18162385747', null, null);
INSERT INTO seckill.user (id, name, gender, age, phone, register_mode, third_party_id) VALUES (8, 'kingcall', 0, 0, '1816238', 'demoData', 'demoData');