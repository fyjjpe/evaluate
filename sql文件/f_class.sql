/*
Navicat MySQL Data Transfer

Source Server         : 本地MySql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : evaluate

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-02-09 14:35:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for f_class
-- ----------------------------
DROP TABLE IF EXISTS `f_class`;
CREATE TABLE `f_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `course` varchar(255) DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_name` (`name`) USING HASH
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_class
-- ----------------------------
INSERT INTO `f_class` VALUES ('1', '计142', '高等数学,大学英语,无机化学,C语言', '2018-02-06 15:39:42', '2018-02-07 10:54:43', '\0');
INSERT INTO `f_class` VALUES ('2', '计144', '高等数学,大学英语,大学物理,C语言', '2018-02-06 16:17:39', '2018-02-06 18:53:18', '\0');
INSERT INTO `f_class` VALUES ('3', '计143', '大学语文,无机化学', '2018-02-06 18:13:28', '2018-02-07 14:33:44', '\0');
INSERT INTO `f_class` VALUES ('4', '计141', '高等数学,大学语文', '2018-02-06 18:53:33', '2018-02-09 10:35:22', '\0');
