/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.3.28
 Source Server Type    : MySQL
 Source Server Version : 50619
 Source Host           : 192.168.3.28:3306
 Source Schema         : dd

 Target Server Type    : MySQL
 Target Server Version : 50619
 File Encoding         : 65001

 Date: 18/10/2018 16:36:30
*/

SET
NAMES
utf8mb4;
SET
FOREIGN_KEY_CHECKS
=
0;

-- ----------------------------
-- Table structure for tb_ac_client
-- ----------------------------
DROP TABLE IF EXISTS `tb_ac_client`;
CREATE TABLE `tb_ac_client`
(
  `id`        int(11) UNSIGNED NOT NULL AUTO_INCREMENT,
  `client_id` varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端ID',
  `name`      varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端名称',
  `secret`    varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '秘钥',
  `comment`   varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '备注',
  `status`    varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '0' COMMENT '状态，1:启用，0:停用',
  `add_time`  bigint(20) NULL DEFAULT NULL COMMENT '添加时间',
  `ext`       longtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '参数配置',
  `white_ip`  varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'ip白名单',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_ac_log
-- ----------------------------
DROP TABLE IF EXISTS `tb_ac_log`;
CREATE TABLE `tb_ac_log`
(
  `id`          int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `client_id`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '客户端ID',
  `source`      varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '调用来源：rest 或者ams',
  `ip`          varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP',
  `class_name`  varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '类名',
  `method`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '方法名',
  `remake`      varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作说明',
  `rq`          mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '请求参数',
  `rs`          mediumtext CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '响应结果',
  `create_time` bigint(20) NULL DEFAULT NULL COMMENT '操作时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for tb_ac_rule
-- ----------------------------
DROP TABLE IF EXISTS `tb_ac_rule`;
CREATE TABLE `tb_ac_rule`
(
  `id`             int(11) NOT NULL AUTO_INCREMENT,
  `from_client_id` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '来源系统id',
  `to_client_id`   varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '去向系统id',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `from_to_idx`(`from_client_id`, `to_client_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

SET
FOREIGN_KEY_CHECKS
=
1;
