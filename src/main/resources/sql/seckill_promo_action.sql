create table promo_action
(
    id          int auto_increment
        primary key,
    promo_name  varchar(30) null,
    start_time  datetime    null,
    end_time    datetime    null,
    item_id     int         null,
    promo_price decimal     null
);

INSERT INTO seckill.promo_action (id, promo_name, start_time, end_time, item_id, promo_price) VALUES (9, 'iphoeX 暑期大促销', '2020-08-01 15:59:59', '2020-08-30 15:59:59', 24, 8000);