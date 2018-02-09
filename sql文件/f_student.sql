/*
Navicat MySQL Data Transfer

Source Server         : 本地MySql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : evaluate

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-02-09 14:35:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for f_student
-- ----------------------------
DROP TABLE IF EXISTS `f_student`;
CREATE TABLE `f_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` varchar(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `className` varchar(255) NOT NULL,
  `score` varchar(1024) DEFAULT NULL,
  `score_by_self` int(11) DEFAULT NULL,
  `is_pass` int(1) NOT NULL DEFAULT '0',
  `self_date` datetime DEFAULT NULL,
  `create_date` datetime NOT NULL,
  `update_date` datetime DEFAULT NULL,
  `is_delete` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of f_student
-- ----------------------------
INSERT INTO `f_student` VALUES ('1', '20180201', '张三', '计142', '{\"高等数学\":80,\"大学英语\":90}', '80', '0', '2018-02-07 15:38:50', '2018-02-06 10:13:14', '2018-02-07 14:33:48', '\0');
INSERT INTO `f_student` VALUES ('2', '20180202', '曾超', '计143', '{\"大学语文\":80}', '0', '0', '2018-02-07 17:31:54', '2018-02-07 14:30:33', '2018-02-09 10:26:20', '\0');
INSERT INTO `f_student` VALUES ('3', '20180203', '大熊猫', '计144', '{\"C语言\":80,\"高等数学\":90,\"大学英语\":90}', '0', '2', '2018-02-08 11:50:04', '2018-02-07 14:49:35', '2018-02-09 10:26:50', '\0');
INSERT INTO `f_student` VALUES ('4', '20180204', '李四', '计144', null, null, '0', null, '2018-02-09 11:34:38', '2018-02-09 11:34:44', '\0');
