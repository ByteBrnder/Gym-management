/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : jsf

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 31/12/2024 11:29:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for hyklx
-- ----------------------------
DROP TABLE IF EXISTS `hyklx`;
CREATE TABLE `hyklx`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `dengji` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '会员卡等级',
  `jiage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '价格',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of hyklx
-- ----------------------------
INSERT INTO `hyklx` VALUES (1, '一等', '200');
INSERT INTO `hyklx` VALUES (2, '二等', '150');
INSERT INTO `hyklx` VALUES (3, '三等', '100');

-- ----------------------------
-- Table structure for jiaolianbiao
-- ----------------------------
DROP TABLE IF EXISTS `jiaolianbiao`;
CREATE TABLE `jiaolianbiao`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '姓名',
  `old` int NOT NULL COMMENT '年龄',
  `xinbie` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '性别',
  `phone` int NULL DEFAULT NULL COMMENT '电话',
  `sckc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '擅长课程',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of jiaolianbiao
-- ----------------------------
INSERT INTO `jiaolianbiao` VALUES (1, '颜俊华', 45, '男', 1813587971, '燃脂');
INSERT INTO `jiaolianbiao` VALUES (2, '璐璐', 30, '女', 1734121141, '腰臀训练');
INSERT INTO `jiaolianbiao` VALUES (3, '谭乐', 45, '男', 1734121141, '力量训练');
INSERT INTO `jiaolianbiao` VALUES (4, '贺易正', 41, '男', 1753846667, '腹肌训练');
INSERT INTO `jiaolianbiao` VALUES (6, '贺智睿', 42, '男', 1817890567, '腿部训练');
INSERT INTO `jiaolianbiao` VALUES (7, '莎莎', 29, '女', 1788900132, '腰部训练');
INSERT INTO `jiaolianbiao` VALUES (8, '姜武', 36, '男', 1890145890, '力量训练');

-- ----------------------------
-- Table structure for myhyk
-- ----------------------------
DROP TABLE IF EXISTS `myhyk`;
CREATE TABLE `myhyk`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `dengji` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `jiage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `goumaitime` datetime NULL DEFAULT NULL,
  `daoqitime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of myhyk
-- ----------------------------
INSERT INTO `myhyk` VALUES (21, 6, '一等', '200', '2024-11-28 13:06:17', '2024-11-28 13:06:17');

-- ----------------------------
-- Table structure for myscore
-- ----------------------------
DROP TABLE IF EXISTS `myscore`;
CREATE TABLE `myscore`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `kcname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `jiaolian` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `kctime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sxhykdj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 53 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of myscore
-- ----------------------------
INSERT INTO `myscore` VALUES (21, 8, '肝胆养护', '贺教练', '10：00-10：45', '0');
INSERT INTO `myscore` VALUES (22, 8, '燃脂操', '谭教练', '11：00-11：45', '0');
INSERT INTO `myscore` VALUES (23, 8, '民族舞', '璐教练', '13：00-13：45', '0');
INSERT INTO `myscore` VALUES (24, 4, '瑜伽', '璐教练', '9：00-9：45', '0');
INSERT INTO `myscore` VALUES (36, 6, '瑜伽', '璐璐', '周一 11：00-11：45', '0');
INSERT INTO `myscore` VALUES (38, 6, '动感单车', '颜俊华', '15：00-15：45', '一等');
INSERT INTO `myscore` VALUES (54, 6, '民族舞', '璐璐', '13：00-13：45', '一等');

-- ----------------------------
-- Table structure for plbiao
-- ----------------------------
DROP TABLE IF EXISTS `plbiao`;
CREATE TABLE `plbiao`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` int NULL DEFAULT NULL,
  `pl` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `fabiaotime` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of plbiao
-- ----------------------------
INSERT INTO `plbiao` VALUES (1, 8, '贺教练的瑜伽课非常好', '2024-11-28 17:59:29');
INSERT INTO `plbiao` VALUES (2, 6, '你好', '2024-11-28 19:54:54');
INSERT INTO `plbiao` VALUES (3, 6, '123123', '2024-11-28 22:15:04');
INSERT INTO `plbiao` VALUES (4, 6, '123123', '2024-11-28 22:17:22');
INSERT INTO `plbiao` VALUES (5, 6, '111', '2024-11-28 22:25:32');
INSERT INTO `plbiao` VALUES (6, 6, '222', '2024-11-28 22:25:54');
INSERT INTO `plbiao` VALUES (7, 6, '45', '2024-11-28 22:43:16');
INSERT INTO `plbiao` VALUES (8, 6, '46', '2024-11-28 22:45:47');
INSERT INTO `plbiao` VALUES (9, 6, '77', '2024-11-28 22:51:25');
INSERT INTO `plbiao` VALUES (10, 6, '77', '2024-11-28 22:52:55');
INSERT INTO `plbiao` VALUES (11, 7, '是吗', '2024-11-28 22:59:19');
INSERT INTO `plbiao` VALUES (12, 6, '非常好', '2024-12-06 22:02:35');
INSERT INTO `plbiao` VALUES (13, 6, '这个健身房非常好', '2024-12-13 19:06:30');

-- ----------------------------
-- Table structure for qicaibiao
-- ----------------------------
DROP TABLE IF EXISTS `qicaibiao`;
CREATE TABLE `qicaibiao`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `qcname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '器材名字',
  `jiage` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '价格',
  `goumaitime` datetime NULL DEFAULT NULL COMMENT '购买日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of qicaibiao
-- ----------------------------
INSERT INTO `qicaibiao` VALUES (2, '坐姿推胸器', '120', '2024-11-26 11:01:41');
INSERT INTO `qicaibiao` VALUES (3, '高拉背训练器', '200', '2024-11-13 11:02:24');
INSERT INTO `qicaibiao` VALUES (4, '坐姿划船器', '189', '2024-11-13 11:02:53');
INSERT INTO `qicaibiao` VALUES (5, 'T杆划船机', '156', '2024-11-14 11:03:28');
INSERT INTO `qicaibiao` VALUES (6, '引体向上助力器', '199', '2024-11-14 11:04:19');
INSERT INTO `qicaibiao` VALUES (7, '肩部平举器', '216', '2024-11-13 11:05:00');
INSERT INTO `qicaibiao` VALUES (8, '卧推器', '115', '2024-11-12 20:52:02');
INSERT INTO `qicaibiao` VALUES (9, '卧推器1', '115', '2024-11-12 21:00:48');
INSERT INTO `qicaibiao` VALUES (10, 'tt', '15', '2024-11-21 09:34:35');

-- ----------------------------
-- Table structure for score
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `kcname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程名',
  `jiaolian` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '教练',
  `kctime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '课程时间',
  `sxhykdj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '所需会员卡等级',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES (4, '民族舞', '璐璐', '13：00-13：45', '一等');
INSERT INTO `score` VALUES (5, '动感单车', '颜俊华', '15：00-15：45', '一等');
INSERT INTO `score` VALUES (6, '经络瑜伽', '莎莎', '16：00-16：45', '二等');
INSERT INTO `score` VALUES (7, '杠铃操', '姜武', '17：00-17：45', '二等');
INSERT INTO `score` VALUES (8, '力量塑形', '王佳佳', '14：00-14:45', '二等');
INSERT INTO `score` VALUES (9, '腰部塑形', '贺易正', '11：00-11：45', '三等');
INSERT INTO `score` VALUES (10, '古典瑜伽', '莎莎', '10：00-10：45', '三等');
INSERT INTO `score` VALUES (11, '流瑜伽', '璐璐', '9：00-9：45', '三等');
INSERT INTO `score` VALUES (12, '跳绳2', '贺教练', '20:00-20:45', '一等');

-- ----------------------------
-- Table structure for tuanke
-- ----------------------------
DROP TABLE IF EXISTS `tuanke`;
CREATE TABLE `tuanke`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `tkname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `jiaolian` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `kctime` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `sxhykdj` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of tuanke
-- ----------------------------
INSERT INTO `tuanke` VALUES (1, '瑜伽', '璐璐', '周一 11：00-11：45', '0');
INSERT INTO `tuanke` VALUES (2, '肝胆养护', '贺易正', '周二 11：00-11：45', '0');
INSERT INTO `tuanke` VALUES (3, '燃脂操', '谭乐', '周三11：00-11：45', '0');
INSERT INTO `tuanke` VALUES (4, '搏击操', '王佳佳', '周四11：00-11：45', '0');
INSERT INTO `tuanke` VALUES (5, '踏板操', '颜俊华', '周五11：00-11：45', '0');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` int NOT NULL,
  `old` int NULL DEFAULT NULL,
  `xinbie` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `phone` int NULL DEFAULT NULL,
  `ruhuirq` date NULL DEFAULT NULL COMMENT '入会日期',
  `isadmin` bit(1) NULL DEFAULT NULL COMMENT '是否为管理员',
  `touxiang` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '陈', 123, 21, '男', 111111, '2024-10-20', b'0', 'http://120.76.202.105:9090/images/58da8622-f84a-4137-815c-7d1ff38928c8.jpg');
INSERT INTO `user` VALUES (4, 'tyj', 1234567, 21, '男', 135122222, '2024-11-07', b'0', 'http://120.76.202.105:9090/images/58da8622-f84a-4137-815c-7d1ff38928c8.jpg');
INSERT INTO `user` VALUES (5, 'tyj1', 123, 18, '男', 1111, '2024-11-13', b'0', 'http://120.76.202.105:9090/images/58da8622-f84a-4137-815c-7d1ff38928c8.jpg');
INSERT INTO `user` VALUES (6, 'ttt', 123, 18, '男', 1111235, '2024-11-17', b'0', 'http://120.76.202.105:9090/images/4d5a42e3-8963-4a4a-aa89-ea073ecec35f.jpg');
INSERT INTO `user` VALUES (7, 'ttt1', 123, 21, '男', 133333, '2024-11-18', b'1', 'http://120.76.202.105:9090/images/5582cbbf-2cb6-4bee-8144-34b263f08ccf.jpg');
INSERT INTO `user` VALUES (8, 'ttt2', 1234, 18, '男', 5555555, '2024-11-18', b'0', 'http://120.76.202.105:9090/images/15f36497-2853-4d2d-b89a-497437f0e171.jpg');
INSERT INTO `user` VALUES (10, 'yy', 456, 56, '男', 56789, '2024-11-29', b'0', 'http://120.76.202.105:9090/images/58da8622-f84a-4137-815c-7d1ff38928c8.jpg');

SET FOREIGN_KEY_CHECKS = 1;
