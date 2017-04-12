/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50544
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50544
File Encoding         : 65001

Date: 2017-04-12 20:44:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for interset
-- ----------------------------
DROP TABLE IF EXISTS `interset`;
CREATE TABLE `interset` (
  `id` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `name` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL COMMENT '话题名字',
  `description` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL COMMENT '话题描述',
  `hot_Word1` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL COMMENT '热词1',
  `hot_Word2` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word3` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word4` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word5` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word6` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word7` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word8` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word9` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `hot_Word10` VARCHAR(32) CHARACTER SET latin1 DEFAULT NULL,
  `firTime` DATE DEFAULT NULL COMMENT '创建时间'
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for interset_context
-- ----------------------------
DROP TABLE IF EXISTS `interset_context`;
CREATE TABLE `interset_context` (
  `user_id` VARCHAR(32) COLLATE utf8_bin DEFAULT NULL,
  `context` VARCHAR(128) COLLATE utf8_bin DEFAULT NULL COMMENT '发布内容'
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- ----------------------------
-- Table structure for user_interset_relation
-- ----------------------------
DROP TABLE IF EXISTS `user_interset_relation`;
CREATE TABLE `user_interset_relation` (
  `user_id` VARCHAR(32) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `interset_id` VARCHAR(32) COLLATE utf8_bin DEFAULT NULL COMMENT '话题id',
  `context` VARCHAR(128) COLLATE utf8_bin DEFAULT NULL COMMENT '话题内容'
) ENGINE=INNODB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
