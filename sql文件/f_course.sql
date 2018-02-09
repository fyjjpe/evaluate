/*
Navicat MySQL Data Transfer

Source Server         : 本地MySql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : evaluate

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-02-09 14:35:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for f_course
-- ----------------------------
DROP TABLE IF EXISTS `f_course`;
CREATE TABLE `f_course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `full_score` int(11) NOT NULL DEFAULT '100',
  `is_delete` bit(1) DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_name` (`name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_course
-- ----------------------------
INSERT INTO `f_course` VALUES ('1', '大学语文', '2018-02-06 10:39:02', '2018-02-06 19:45:50', '100', '\0');
INSERT INTO `f_course` VALUES ('2', '高等数学', '2018-02-06 10:39:05', '2018-02-07 10:36:42', '150', '\0');
INSERT INTO `f_course` VALUES ('3', '大学英语', '2018-02-06 10:39:07', '2018-02-07 17:40:59', '100', '\0');
INSERT INTO `f_course` VALUES ('4', '大学物理', '2018-02-06 10:39:09', null, '100', '\0');
INSERT INTO `f_course` VALUES ('5', '无机化学', '2018-02-06 10:39:11', '2018-02-07 10:54:53', '100', '\0');
INSERT INTO `f_course` VALUES ('6', '计算机基础', '2018-02-06 10:39:15', null, '100', '\0');
INSERT INTO `f_course` VALUES ('7', 'C语言', '2018-02-06 10:39:19', null, '100', '\0');
INSERT INTO `f_course` VALUES ('8', 'Java语言', '2018-02-07 10:38:37', null, '100', '\0');
