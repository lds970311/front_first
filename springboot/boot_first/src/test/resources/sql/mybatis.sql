/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.208.146
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : 192.168.208.146:3306
 Source Schema         : mybatis

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 15/02/2022 22:45:15
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

use mybatis_plus;
-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept`
(
    `id`        int                                                          NOT NULL AUTO_INCREMENT,
    `dept_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept`
VALUES (1, '人事部');
INSERT INTO `tbl_dept`
VALUES (2, '财务部');
INSERT INTO `tbl_dept`
VALUES (3, '研发部');
INSERT INTO `tbl_dept`
VALUES (4, '行政部');
INSERT INTO `tbl_dept`
VALUES (5, '商务部');

-- ----------------------------
-- Table structure for tbl_employee
-- ----------------------------
DROP TABLE IF EXISTS `tbl_employee`;
CREATE TABLE `tbl_employee`
(
    `id`        int                                                           NOT NULL AUTO_INCREMENT,
    `last_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `gender`    char(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci      NULL DEFAULT NULL,
    `email`     varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
    `dept_id`   int                                                           NULL DEFAULT NULL,
    `status`    varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci  NULL DEFAULT NULL,
    PRIMARY KEY (`id`) USING BTREE,
    INDEX `fk_dept` (`dept_id`) USING BTREE,
    CONSTRAINT `fk_dept` FOREIGN KEY (`dept_id`) REFERENCES `tbl_dept` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB
  AUTO_INCREMENT = 2011
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_general_ci
  ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tbl_employee
-- ----------------------------
INSERT INTO `tbl_employee`
VALUES (1, 'tom', '0', 'tom@gmail.com', 1, 'login');
INSERT INTO `tbl_employee`
VALUES (2, 'jack', '0', 'jack@123.com', 2, 'login');
INSERT INTO `tbl_employee`
VALUES (3, 'lucy', '1', 'lucy@qq.com', 3, 'login');
INSERT INTO `tbl_employee`
VALUES (4, 'jase', '1', ' jase@123.com', 3, 'login');
INSERT INTO `tbl_employee`
VALUES (5, 'louis', '1', ' louis@qq.com', 5, 'login');
INSERT INTO `tbl_employee`
VALUES (6, 'Jerry', '0', 'Jessy@facebook.com ', 4, 'login');
INSERT INTO `tbl_employee`
VALUES (7, '21245', '1', '21245126.com', NULL, 'login');
INSERT INTO `tbl_employee`
VALUES (8, '51314', '1', '51314126.com', NULL, 'login');
INSERT INTO `tbl_employee`
VALUES (9, '1389', '1', '1389126.com', NULL, 'login');
INSERT INTO `tbl_employee`
VALUES (10, '9410', '1', '9410126.com', NULL, 'login');

SET FOREIGN_KEY_CHECKS = 1;
