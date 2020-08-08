create table item_stock_sales
(
    id      int auto_increment
        primary key,
    item_id int           not null,
    stock   int           not null comment '库存',
    sales   int default 0 not null comment '销量',
    constraint un_itemId
        unique (item_id)
)
    charset = utf8;

INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (1, 1, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (2, 2, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (3, 3, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (4, 4, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (5, 5, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (6, 6, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (7, 7, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (8, 8, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (9, 9, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (10, 10, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (11, 11, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (12, 12, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (13, 13, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (14, 14, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (15, 15, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (16, 16, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (17, 17, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (18, 18, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (19, 19, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (20, 20, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (21, 21, 20, 10);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (22, 22, 2000, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (23, 23, 1, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (24, 24, 970, 30);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (25, 26, 1000, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (26, 27, 1000, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (27, 28, 1000, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (28, 29, 1000, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (29, 30, 1000, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (30, 31, 1000, 0);
INSERT INTO seckill.item_stock_sales (id, item_id, stock, sales) VALUES (31, 32, 10000, 0);