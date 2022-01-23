/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.208.146
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 192.168.208.146:3306
 Source Schema         : mydb

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 22/01/2022 16:47:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`
(
    `id`      int                                                          NOT NULL AUTO_INCREMENT,
    `name`    varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '姓名',
    `age`     int                                                          NULL     DEFAULT NULL COMMENT '年龄',
    `gender`  char(3) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci     NOT NULL DEFAULT '' COMMENT '性别',
    `address` varchar(6) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL     DEFAULT NULL COMMENT '籍贯',
    `qq`      varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT 'qq',
    `email`   varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL     DEFAULT NULL COMMENT 'email',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 12
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
use mydb;
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('张三', 23, '男', ' 广东', '1234431', '123@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('李四', 21, '男', '天津', '55712312477', ' 8877123@gmail.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('王五', 25, '男', '江苏', '124235345523', '124235345523@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('Lucy', 23, '女', '湖南', '12456236767', '12456236767@126.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('张三', 23, '男', ' 广东', '1234431', '123@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('李四', 21, '男', '天津', '55712312477', ' 8877123@gmail.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('王五', 25, '男', '江苏', '124235345523', '124235345523@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('Lucy', 23, '女', '湖南', '12456236767', '12456236767@126.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('张三', 23, '男', ' 广东', '1234431', '123@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('李四', 21, '男', '天津', '55712312477', ' 8877123@gmail.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('王五', 25, '男', '江苏', '124235345523', '124235345523@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('Lucy', 23, '女', '湖南', '12456236767', '12456236767@126.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('张三', 23, '男', ' 广东', '1234431', '123@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('李四', 21, '男', '天津', '55712312477', ' 8877123@gmail.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('王五', 25, '男', '江苏', '124235345523', '124235345523@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('Lucy', 23, '女', '湖南', '12456236767', '12456236767@126.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('张三', 23, '男', ' 广东', '1234431', '123@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('李四', 21, '男', '天津', '55712312477', ' 8877123@gmail.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('王五', 25, '男', '江苏', '124235345523', '124235345523@qq.com');
INSERT INTO `user` (name, age, gender, address, qq, email)
VALUES ('Lucy', 23, '女', '湖南', '12456236767', '12456236767@126.com');

SET FOREIGN_KEY_CHECKS = 1;
