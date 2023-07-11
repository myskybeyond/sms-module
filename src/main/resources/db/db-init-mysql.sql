/*
 Navicat Premium Data Transfer

 Source Server         : mariadb-virtual
 Source Server Type    : MariaDB
 Source Server Version : 100505 (10.5.5-MariaDB-1:10.5.5+maria~focal)
 Source Host           : localhost:13306
 Source Schema         : sms

 Target Server Type    : MariaDB
 Target Server Version : 100505 (10.5.5-MariaDB-1:10.5.5+maria~focal)
 File Encoding         : 65001

 Date: 20/06/2023 14:14:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_sms_template
-- ----------------------------
DROP TABLE IF EXISTS `t_sms_template`;
CREATE TABLE `t_sms_template`  (
  `sms_template_id` int(11) NOT NULL AUTO_INCREMENT,
  `template_code` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sms_usage` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sign_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `sms_template` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `enabled` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'Y',
  PRIMARY KEY (`sms_template_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;


-- ----------------------------
-- Table structure for t_sms_send
-- ----------------------------
DROP TABLE IF EXISTS `t_sms_send`;
CREATE TABLE `t_sms_send`  (
  `sms_send_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增',
  `mobile` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '手机号',
  `sms_usage` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用途',
  `send_time` datetime NOT NULL COMMENT '发送',
  `sms_variable` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '变量',
  `is_used` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '是否使用',
  `request_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `send_code` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `message` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '消息内容',
  `biz_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `org_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sms_send_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 43 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

-- ----------------------------
-- Table structure for t_sms_template init sql execute
-- ----------------------------
INSERT INTO `sms`.`t_sms_template` ( `template_code`, `sms_usage`, `sign_name`, `sms_template`, `enabled`) VALUES ( 'SMS_150570927', 'DUTY_NOTICE', '上元智能', '${name}您好，{dutyDt}需要您打扫{dutyArea}区域，请关注！', 'Y');
