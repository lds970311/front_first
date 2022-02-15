/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.208.147
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 192.168.208.147:3306
 Source Schema         : my_jdbc

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 14/02/2022 19:38:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`       int                                                        NOT NULL AUTO_INCREMENT,
    `name`     varchar(10) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL,
    `age`      int                                                        NULL     DEFAULT NULL,
    `password` varchar(15) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NOT NULL DEFAULT '123456',
    `address`  varchar(25) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL     DEFAULT NULL,
    `phone`    varchar(15) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL     DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = gb2312
  COLLATE = gb2312_chinese_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user`
VALUES (1, '章子怡', 32, 'qwerty', 'Beijing', '13788658672');
INSERT INTO `user`
VALUES (2, '郭富城', 21, 'abc123', 'HongKong', '15678909898');
INSERT INTO `user`
VALUES (3, '林志颖', 34, '654321', 'Taiwan', '18612124565');
INSERT INTO `user`
VALUES (4, '杨超越', 24, '987654367', '上海', '18912340998');
INSERT INTO `user`
VALUES (6, 'jinx', 23, '111222', '上海', '233');
INSERT INTO `user`
VALUES (7, '张学友', 54, '43415124', '香港', '99840324');
INSERT INTO `user`
VALUES (8, '周杰伦', 39, ' 9999911', '台北', '66412314');
INSERT INTO `user`
VALUES (9, '王力宏', 42, '77123124', '温哥华', '12315432');
INSERT INTO `user`
VALUES (10, '汪峰', 45, '312412 ', '北京 ', '12312455');

SET FOREIGN_KEY_CHECKS = 1;
