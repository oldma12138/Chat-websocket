/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : webchat

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-05-19 12:24:23
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `time` varchar(255) DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `detail` varchar(255) DEFAULT NULL,
  `ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `sex` int(11) DEFAULT NULL COMMENT '1：男，0：女',
  `age` int(11) DEFAULT NULL,
  `profilehead` varchar(255) DEFAULT NULL COMMENT '个人头像',
  `profile` varchar(255) DEFAULT NULL COMMENT '个人简介',
  `firsttime` varchar(255) DEFAULT NULL COMMENT '注册时间',
  `lasttime` varchar(255) DEFAULT NULL COMMENT '最后登录时间',
  `status` int(11) DEFAULT NULL COMMENT '账号状态 1：正常，0禁用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '李白', '123123', '李白', '2', '23', 'a6044c0f-32ed-424c-bed0-a3dc1b4236fb.png', '2', '2', '2019-05-19 12:17:50', '1');
INSERT INTO `user` VALUES ('3', '张三', '123123', '张三', '1', '2', 'c9dc3188-a2e5-44e5-b46b-524fa590c145.png', '123', '2', '2019-05-19 12:19:10', '1');
SET FOREIGN_KEY_CHECKS=1;
