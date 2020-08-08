create table `order`
(
    id          varchar(50)    not null comment '订单ID'
        primary key,
    user_id     int            null comment '下单用户',
    item_id     int            null comment '商品ID',
    item_price  decimal(10, 2) null comment '商品价格',
    amount      int            null comment '下单数量',
    order_price decimal(20)    null comment '下单总金额',
    promo_id    int default 0  not null comment '活动ID'
)
    charset = utf8;

INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('2020-08-06000000007', 7, 21, 1.00, 600, 600, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('2020-08-06000000017', 7, 21, 1.00, 300, 300, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('2020-08-06000000027', 7, 21, 1.00, 50, 50, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('20200806000000037', 7, 21, 1.00, 10, 10, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('20200806000000047', 7, 21, 1.00, 1, 1, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('20200806000000057', 7, 21, 1.00, 9, 9, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('20200806000000067', 7, 21, 1.00, 10, 10, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('20200807000000077', 7, 24, 9000.00, 10, 90000, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('20200807000000137', 7, 24, 9000.00, 10, 90000, 0);
INSERT INTO seckill.`order` (id, user_id, item_id, item_price, amount, order_price, promo_id) VALUES ('20200807000000147', 7, 24, 8000.00, 10, 80000, 9);