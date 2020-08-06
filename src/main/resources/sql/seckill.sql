/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : localhost:3306
 Source Schema         : seckill

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 06/08/2020 09:21:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for item
-- ----------------------------
DROP TABLE IF EXISTS `item`;
CREATE TABLE `item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL COMMENT '商品名称',
  `price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `description` varchar(255) DEFAULT NULL COMMENT '描述信息',
  `sales` int(255) DEFAULT NULL COMMENT '销量',
  `imgurl` varchar(255) DEFAULT NULL COMMENT '图片信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item
-- ----------------------------
BEGIN;
INSERT INTO `item` VALUES (1, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (2, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (3, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (4, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (5, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (6, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (7, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (8, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (9, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (10, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (11, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (12, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (13, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (14, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (15, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (16, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (17, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (18, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (19, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (20, 'demoData', 1.00, 'demoData', 1, 'demoData');
INSERT INTO `item` VALUES (21, '苹果', 1.00, '好吃的苹果', 1, 'demoData');
INSERT INTO `item` VALUES (22, '西瓜', 1.00, '好吃的西瓜', 1, 'demoData');
INSERT INTO `item` VALUES (23, 'xxx', 1.00, 'demoData', 1, 'demoData');
COMMIT;

-- ----------------------------
-- Table structure for item_stock
-- ----------------------------
DROP TABLE IF EXISTS `item_stock`;
CREATE TABLE `item_stock` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `item_id` int(11) NOT NULL,
  `stock` int(255) NOT NULL COMMENT '库存',
  PRIMARY KEY (`id`),
  UNIQUE KEY `un_itemId` (`item_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of item_stock
-- ----------------------------
BEGIN;
INSERT INTO `item_stock` VALUES (1, 1, 1);
INSERT INTO `item_stock` VALUES (2, 2, 1);
INSERT INTO `item_stock` VALUES (3, 3, 1);
INSERT INTO `item_stock` VALUES (4, 4, 1);
INSERT INTO `item_stock` VALUES (5, 5, 1);
INSERT INTO `item_stock` VALUES (6, 6, 1);
INSERT INTO `item_stock` VALUES (7, 7, 1);
INSERT INTO `item_stock` VALUES (8, 8, 1);
INSERT INTO `item_stock` VALUES (9, 9, 1);
INSERT INTO `item_stock` VALUES (10, 10, 1);
INSERT INTO `item_stock` VALUES (11, 11, 1);
INSERT INTO `item_stock` VALUES (12, 12, 1);
INSERT INTO `item_stock` VALUES (13, 13, 1);
INSERT INTO `item_stock` VALUES (14, 14, 1);
INSERT INTO `item_stock` VALUES (15, 15, 1);
INSERT INTO `item_stock` VALUES (16, 16, 1);
INSERT INTO `item_stock` VALUES (17, 17, 1);
INSERT INTO `item_stock` VALUES (18, 18, 1);
INSERT INTO `item_stock` VALUES (19, 19, 1);
INSERT INTO `item_stock` VALUES (20, 20, 1);
INSERT INTO `item_stock` VALUES (21, 21, 50);
INSERT INTO `item_stock` VALUES (22, 22, 2000);
INSERT INTO `item_stock` VALUES (23, 23, 1);
COMMIT;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` varchar(50) NOT NULL COMMENT '订单ID',
  `user_id` int(11) DEFAULT NULL COMMENT '下单用户',
  `item_id` int(11) DEFAULT NULL COMMENT '商品ID',
  `item_price` decimal(10,2) DEFAULT NULL COMMENT '商品价格',
  `amount` int(10) DEFAULT NULL COMMENT '下单数量',
  `order_price` decimal(20,0) DEFAULT NULL COMMENT '下单总金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES ('2020-08-06000000007', 7, 21, 1.00, 600, 600);
INSERT INTO `order` VALUES ('2020-08-06000000017', 7, 21, 1.00, 300, 300);
INSERT INTO `order` VALUES ('2020-08-06000000027', 7, 21, 1.00, 50, 50);
COMMIT;

-- ----------------------------
-- Table structure for sequence_info
-- ----------------------------
DROP TABLE IF EXISTS `sequence_info`;
CREATE TABLE `sequence_info` (
  `table_name` varchar(30) NOT NULL,
  `current_value` int(10) DEFAULT '0',
  `step` int(10) DEFAULT '1',
  PRIMARY KEY (`table_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sequence_info
-- ----------------------------
BEGIN;
INSERT INTO `sequence_info` VALUES ('order', 3, 1);
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `gender` tinyint(255) DEFAULT NULL COMMENT '1 男 2 女 9 不详',
  `age` smallint(6) DEFAULT NULL COMMENT '年龄',
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `register_mode` varchar(50) DEFAULT NULL COMMENT '注册方式',
  `third_party_id` varchar(64) DEFAULT NULL COMMENT '第三方验证信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `idx_unique` (`phone`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'demoData', 1, 1, 'demoData4', 'demoData', 'demoData');
INSERT INTO `user` VALUES (2, 'demoData', 1, 1, 'demoData', 'demoData', 'demoData');
INSERT INTO `user` VALUES (3, 'demoData', 1, 1, 'demoData2', 'demoData', 'demoData');
INSERT INTO `user` VALUES (4, 'demoData', 1, 1, 'demoData3', 'demoData', 'demoData');
INSERT INTO `user` VALUES (6, 'demoData', 1, 1, 'demoData5', 'demoData', 'demoData');
INSERT INTO `user` VALUES (7, '刘文强', 1, 1, '18162385747', NULL, NULL);
COMMIT;

-- ----------------------------
-- Table structure for user_password
-- ----------------------------
DROP TABLE IF EXISTS `user_password`;
CREATE TABLE `user_password` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `encrpt_password` varchar(255) DEFAULT NULL,
  `user_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`,`user_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_password
-- ----------------------------
BEGIN;
INSERT INTO `user_password` VALUES (1, 'demoData', 1);
INSERT INTO `user_password` VALUES (2, 'demoData', 2);
INSERT INTO `user_password` VALUES (3, 'demoData', 3);
INSERT INTO `user_password` VALUES (4, 'demoData', 4);
INSERT INTO `user_password` VALUES (5, 'demoData', 6);
INSERT INTO `user_password` VALUES (6, 'www1234', 7);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
