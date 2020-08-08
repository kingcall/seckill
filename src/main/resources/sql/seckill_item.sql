create table item
(
    id          int auto_increment
        primary key,
    title       varchar(50)    null comment '商品名称',
    price       decimal(10, 2) null comment '商品价格',
    description varchar(255)   null comment '描述信息',
    sales       int            null comment '销量',
    imgurl      varchar(255)   null comment '图片信息'
)
    charset = utf8;

INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (1, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (2, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (3, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (4, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (5, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (6, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (7, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (8, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (9, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (10, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (11, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (12, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (13, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (14, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (15, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (16, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (17, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (18, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (19, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (20, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (21, '苹果', 1.00, '好吃的苹果', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (22, '西瓜', 1.00, '好吃的西瓜', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (23, 'xxx', 1.00, 'demoData', 1, 'demoData');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (24, 'iphoneX', 9000.00, '最好用的手机 iphoneX', 0, 'iphoneX');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (26, '甘肃——五角星', 9.90, '甘肃的特产水果', null, 'http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (27, '甘肃——五角星', 9.90, '甘肃的特产水果', null, 'http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (28, '甘肃——五角星', 9.90, '甘肃的特产水果', null, 'http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (29, '甘肃——五角星', 9.90, '甘肃的特产水果', null, 'http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (30, '甘肃——五角星', 9.90, '甘肃的特产水果', null, 'http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (31, '甘肃——五角星', 9.90, '甘肃的特产水果', null, 'http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg');
INSERT INTO seckill.item (id, title, price, description, sales, imgurl) VALUES (32, '甘肃——五角星', 9.90, '甘肃的特产水果', null, 'http://img.improve-yourmemory.com/pic/d8abf5c40d6c37f5880c07ee4210554b-2.jpg');