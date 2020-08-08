create table user_password
(
    id              int auto_increment,
    encrpt_password varchar(255)  null,
    user_id         int default 0 not null,
    primary key (id, user_id)
)
    charset = utf8;

INSERT INTO seckill.user_password (id, encrpt_password, user_id) VALUES (1, 'demoData', 1);
INSERT INTO seckill.user_password (id, encrpt_password, user_id) VALUES (2, 'demoData', 2);
INSERT INTO seckill.user_password (id, encrpt_password, user_id) VALUES (3, 'demoData', 3);
INSERT INTO seckill.user_password (id, encrpt_password, user_id) VALUES (4, 'demoData', 4);
INSERT INTO seckill.user_password (id, encrpt_password, user_id) VALUES (5, 'demoData', 6);
INSERT INTO seckill.user_password (id, encrpt_password, user_id) VALUES (6, 'www1234', 7);
INSERT INTO seckill.user_password (id, encrpt_password, user_id) VALUES (7, '566a1fc42bc3fa17a3920221d2b24d34', 8);