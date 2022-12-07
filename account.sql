/*
Navicat MySQL Data Transfer

Source Server         : rempte-mysql
Source Server Version : 80018
Source Host           : 111.229.145.9:3306
Source Database       : javaweb

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-02-12 19:23:09
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for account
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id主键，自增',
  `name` varchar(32) DEFAULT NULL,
  `password` varchar(50) NOT NULL COMMENT '密码',
  `createTime` datetime DEFAULT CURRENT_TIMESTAMP,
  `status` int(11) DEFAULT '0',
  `type` int(11) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `email` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8 COMMENT='用户表';

-- ----------------------------
-- Records of account
-- ----------------------------
INSERT INTO `account` VALUES ('1', 'admin', 'admin', '2022-11-05 10:05:00', '0', '3', '男', '15877403696', '2608589767@qq.com');
INSERT INTO `account` VALUES ('2', 'a', 'a', '2022-11-05 12:05:40', '0', '2', '男', '15877403696', '2608589767@qq.com');
INSERT INTO `account` VALUES ('3', 'b', 'b', '2022-11-05 15:21:00', '0', '1', '女', '15877403658', '2608589768@qq.com');


