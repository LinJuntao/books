/*
Navicat MySQL Data Transfer

Source Server         : 120.78.75.213
Source Server Version : 50722
Source Host           : 120.78.75.213:3306
Source Database       : booksmanage

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-11-16 16:04:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `b_art`
-- ----------------------------
DROP TABLE IF EXISTS `b_art`;
CREATE TABLE `b_art` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book4.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '4',
  `remove` int(2) DEFAULT '0' COMMENT '0代表false，1代表true',
  PRIMARY KEY (`id`),
  KEY `艺术与摄影` (`kindid`),
  CONSTRAINT `艺术与摄影` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_art
-- ----------------------------

-- ----------------------------
-- Table structure for `b_biography`
-- ----------------------------
DROP TABLE IF EXISTS `b_biography`;
CREATE TABLE `b_biography` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book2.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '2',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `传记` (`kindid`),
  CONSTRAINT `传记` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_biography
-- ----------------------------

-- ----------------------------
-- Table structure for `b_cartoon`
-- ----------------------------
DROP TABLE IF EXISTS `b_cartoon`;
CREATE TABLE `b_cartoon` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book3.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '3',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `青春动漫` (`kindid`),
  CONSTRAINT `青春动漫` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_cartoon
-- ----------------------------

-- ----------------------------
-- Table structure for `b_children`
-- ----------------------------
DROP TABLE IF EXISTS `b_children`;
CREATE TABLE `b_children` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book5.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '5',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `儿童` (`kindid`),
  CONSTRAINT `儿童` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_children
-- ----------------------------

-- ----------------------------
-- Table structure for `b_fun`
-- ----------------------------
DROP TABLE IF EXISTS `b_fun`;
CREATE TABLE `b_fun` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book9.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '9',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `娱乐与体育` (`kindid`),
  CONSTRAINT `娱乐与体育` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_fun
-- ----------------------------

-- ----------------------------
-- Table structure for `b_history`
-- ----------------------------
DROP TABLE IF EXISTS `b_history`;
CREATE TABLE `b_history` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book7.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '7',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `历史` (`kindid`),
  CONSTRAINT `历史` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_history
-- ----------------------------

-- ----------------------------
-- Table structure for `b_language`
-- ----------------------------
DROP TABLE IF EXISTS `b_language`;
CREATE TABLE `b_language` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book12.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '12',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `外语学习` (`kindid`),
  CONSTRAINT `外语学习` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_language
-- ----------------------------

-- ----------------------------
-- Table structure for `b_life`
-- ----------------------------
DROP TABLE IF EXISTS `b_life`;
CREATE TABLE `b_life` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book11.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '11',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `科技与生活` (`kindid`),
  CONSTRAINT `科技与生活` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_life
-- ----------------------------

-- ----------------------------
-- Table structure for `b_literature`
-- ----------------------------
DROP TABLE IF EXISTS `b_literature`;
CREATE TABLE `b_literature` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book1.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '1',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `文学` (`kindid`),
  CONSTRAINT `文学` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_literature
-- ----------------------------

-- ----------------------------
-- Table structure for `b_novel`
-- ----------------------------
DROP TABLE IF EXISTS `b_novel`;
CREATE TABLE `b_novel` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book13.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '13',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `novel` (`kindid`),
  CONSTRAINT `novel` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_novel
-- ----------------------------

-- ----------------------------
-- Table structure for `b_social`
-- ----------------------------
DROP TABLE IF EXISTS `b_social`;
CREATE TABLE `b_social` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book6.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '6',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `社会与科学` (`kindid`),
  CONSTRAINT `社会与科学` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_social
-- ----------------------------

-- ----------------------------
-- Table structure for `b_succer`
-- ----------------------------
DROP TABLE IF EXISTS `b_succer`;
CREATE TABLE `b_succer` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book8.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '8',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `哲学与成功` (`kindid`),
  CONSTRAINT `哲学与成功` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_succer
-- ----------------------------

-- ----------------------------
-- Table structure for `b_traval`
-- ----------------------------
DROP TABLE IF EXISTS `b_traval`;
CREATE TABLE `b_traval` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT 'http://120.78.75.213:8080/kindid/book10.jpg',
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '10',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `旅游` (`kindid`),
  CONSTRAINT `旅游` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of b_traval
-- ----------------------------

-- ----------------------------
-- Table structure for `collcetion_book`
-- ----------------------------
DROP TABLE IF EXISTS `collcetion_book`;
CREATE TABLE `collcetion_book` (
  `collcetion_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏书籍的ID',
  `collcetion_book_id` int(11) NOT NULL COMMENT '收藏书籍的ID',
  `collcetion_book_kindid` int(11) NOT NULL COMMENT '收藏书籍的种类ID',
  `collcetion_username` varchar(255) DEFAULT NULL COMMENT '收藏的用户名',
  `collcetion_userId` int(11) NOT NULL COMMENT '收藏用户的id',
  PRIMARY KEY (`collcetion_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collcetion_book
-- ----------------------------

-- ----------------------------
-- Table structure for `g_user`
-- ----------------------------
DROP TABLE IF EXISTS `g_user`;
CREATE TABLE `g_user` (
  `date` varchar(255) DEFAULT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是管理员的表格',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '这是管理员的表格',
  `nul` int(2) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of g_user
-- ----------------------------
INSERT INTO `g_user` VALUES ('2018-07-11 09:06:50', '1', 'books', '123456', '管理员1', '0');
INSERT INTO `g_user` VALUES ('2018-09-20', '2', 'manageJun', '123456', 'juntao管理员', '0');

-- ----------------------------
-- Table structure for `kindid`
-- ----------------------------
DROP TABLE IF EXISTS `kindid`;
CREATE TABLE `kindid` (
  `kindid` int(255) NOT NULL AUTO_INCREMENT,
  `kindname` varchar(255) DEFAULT NULL COMMENT '这是分类的表格',
  PRIMARY KEY (`kindid`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of kindid
-- ----------------------------
INSERT INTO `kindid` VALUES ('1', '文学');
INSERT INTO `kindid` VALUES ('2', '传记');
INSERT INTO `kindid` VALUES ('3', '青春动漫');
INSERT INTO `kindid` VALUES ('4', '艺术与摄影');
INSERT INTO `kindid` VALUES ('5', '少儿');
INSERT INTO `kindid` VALUES ('6', '社会科学');
INSERT INTO `kindid` VALUES ('7', '历史');
INSERT INTO `kindid` VALUES ('8', '励志与成功');
INSERT INTO `kindid` VALUES ('9', '娱乐与体育');
INSERT INTO `kindid` VALUES ('10', '旅游');
INSERT INTO `kindid` VALUES ('11', '科技与生活');
INSERT INTO `kindid` VALUES ('12', '外语学习');
INSERT INTO `kindid` VALUES ('13', '小说');

-- ----------------------------
-- Table structure for `mlog`
-- ----------------------------
DROP TABLE IF EXISTS `mlog`;
CREATE TABLE `mlog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `loguser` varchar(255) DEFAULT NULL,
  `logtime` varchar(255) DEFAULT NULL,
  `logcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mlog
-- ----------------------------
INSERT INTO `mlog` VALUES ('1', 'books', '2018-11-16 15:42:48', '[管理员: books]在 2018-11-16 15:42:48,操作了: /login方法 .');
INSERT INTO `mlog` VALUES ('2', 'books', '2018-11-16 15:42:48', '[管理员: books]在 2018-11-16 15:42:48,操作了: /showManager方法 .');

-- ----------------------------
-- Table structure for `newbooks`
-- ----------------------------
DROP TABLE IF EXISTS `newbooks`;
CREATE TABLE `newbooks` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT NULL,
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `艺术与摄影` (`kindid`),
  CONSTRAINT `新书榜` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newbooks
-- ----------------------------

-- ----------------------------
-- Table structure for `qk_news`
-- ----------------------------
DROP TABLE IF EXISTS `qk_news`;
CREATE TABLE `qk_news` (
  `newsid` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) DEFAULT NULL,
  `context` varchar(255) DEFAULT NULL,
  `newstime` varchar(255) DEFAULT NULL,
  `issuer` varchar(255) DEFAULT NULL,
  `titleimg` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`newsid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qk_news
-- ----------------------------

-- ----------------------------
-- Table structure for `s_user`
-- ----------------------------
DROP TABLE IF EXISTS `s_user`;
CREATE TABLE `s_user` (
  `date` varchar(255) DEFAULT NULL,
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是学生成员的表',
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL COMMENT '这是学生用户表',
  `nul` int(2) DEFAULT '1',
  `downloadNul` int(255) DEFAULT '0' COMMENT '用户的下载量',
  `shareNul` int(255) DEFAULT '0' COMMENT '用户的分享量，判断是否能成为会员',
  `ifMember` int(255) DEFAULT '0' COMMENT '是否为会员,0为否，1为是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of s_user
-- ----------------------------
INSERT INTO `s_user` VALUES ('2018-09-20 10:10:02', '1', 'juntao', '123456', '自己测试用的帐号', '1', '0', '0', '0');
INSERT INTO `s_user` VALUES ('2018-10-08 10:25:43', '2', 'webbing', 'asd230.+', 'hahah', '1', '0', '0', '0');

-- ----------------------------
-- Table structure for `share_from_user`
-- ----------------------------
DROP TABLE IF EXISTS `share_from_user`;
CREATE TABLE `share_from_user` (
  `id` int(255) NOT NULL AUTO_INCREMENT COMMENT '这是书本的种类',
  `bookname` varchar(255) DEFAULT NULL,
  `altertime` varchar(255) DEFAULT NULL,
  `bookintro` varchar(255) DEFAULT NULL,
  `downloadIVN` varchar(255) DEFAULT NULL,
  `downlaodNUM` varchar(255) DEFAULT NULL,
  `bookimg` varchar(255) DEFAULT NULL,
  `manage` varchar(255) DEFAULT NULL,
  `kindid` int(255) DEFAULT '6',
  `remove` int(2) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `社会与科学` (`kindid`),
  CONSTRAINT `share_from_user_ibfk_1` FOREIGN KEY (`kindid`) REFERENCES `kindid` (`kindid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of share_from_user
-- ----------------------------

-- ----------------------------
-- Table structure for `shopping_book`
-- ----------------------------
DROP TABLE IF EXISTS `shopping_book`;
CREATE TABLE `shopping_book` (
  `shopping_id` int(255) NOT NULL AUTO_INCREMENT,
  `shopping_book_id` int(255) DEFAULT NULL,
  `shopping_book_kindid` int(255) DEFAULT NULL,
  `shopping_username` char(255) DEFAULT NULL,
  `shopping_userId` int(255) DEFAULT NULL,
  `shopping_statue` int(255) DEFAULT '0' COMMENT '0代表未下载，1代表已下载',
  PRIMARY KEY (`shopping_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopping_book
-- ----------------------------

-- ----------------------------
-- Table structure for `ulog`
-- ----------------------------
DROP TABLE IF EXISTS `ulog`;
CREATE TABLE `ulog` (
  `logid` int(11) NOT NULL AUTO_INCREMENT,
  `loguser` varchar(255) DEFAULT NULL,
  `logtime` varchar(255) DEFAULT NULL,
  `logcontent` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`logid`)
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ulog
-- ----------------------------
INSERT INTO `ulog` VALUES ('1', 'juntao', '2018-09-20 10:10:22', '[普通用户: juntao]在2018-09-20 10:10:22,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('2', 'juntao', '2018-09-20 10:10:22', '[普通用户: juntao]在2018-09-20 10:10:22,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('3', 'juntao', '2018-09-20 10:10:26', '[普通用户: juntao]在2018-09-20 10:10:26,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('4', 'juntao', '2018-09-20 10:10:46', '[普通用户: juntao]在2018-09-20 10:10:46,操作了:/collectionData方法.');
INSERT INTO `ulog` VALUES ('5', 'juntao', '2018-09-20 10:10:46', '[普通用户: juntao]在2018-09-20 10:10:46,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('6', 'juntao', '2018-09-20 10:10:56', '[普通用户: juntao]在2018-09-20 10:10:56,操作了:/findAllBooksData方法.');
INSERT INTO `ulog` VALUES ('7', 'juntao', '2018-09-20 10:10:56', '[普通用户: juntao]在2018-09-20 10:10:56,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('8', 'juntao', '2018-10-02 10:15:26', '[普通用户: juntao]在2018-10-02 10:15:26,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('9', 'juntao', '2018-10-02 10:15:26', '[普通用户: juntao]在2018-10-02 10:15:26,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('10', 'juntao', '2018-10-02 10:15:32', '[普通用户: juntao]在2018-10-02 10:15:32,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('11', 'webbing', '2018-10-08 10:25:51', '[普通用户: webbing]在2018-10-08 10:25:51,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('12', 'webbing', '2018-10-08 10:25:51', '[普通用户: webbing]在2018-10-08 10:25:51,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('13', 'webbing', '2018-10-08 10:25:55', '[普通用户: webbing]在2018-10-08 10:25:55,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('14', 'webbing', '2018-10-08 10:26:01', '[普通用户: webbing]在2018-10-08 10:26:01,操作了:/booksLinkPaging方法.');
INSERT INTO `ulog` VALUES ('15', 'webbing', '2018-10-08 10:26:10', '[普通用户: webbing]在2018-10-08 10:26:10,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('16', 'webbing', '2018-10-08 10:26:10', '[普通用户: webbing]在2018-10-08 10:26:10,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('17', 'webbing', '2018-10-08 10:26:12', '[普通用户: webbing]在2018-10-08 10:26:12,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('18', 'webbing', '2018-10-08 10:26:13', '[普通用户: webbing]在2018-10-08 10:26:13,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('19', 'webbing', '2018-10-08 10:26:14', '[普通用户: webbing]在2018-10-08 10:26:14,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('20', 'webbing', '2018-10-08 10:26:14', '[普通用户: webbing]在2018-10-08 10:26:14,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('21', 'webbing', '2018-10-08 10:26:15', '[普通用户: webbing]在2018-10-08 10:26:15,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('22', 'webbing', '2018-10-08 10:26:15', '[普通用户: webbing]在2018-10-08 10:26:15,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('23', 'webbing', '2018-10-08 10:26:15', '[普通用户: webbing]在2018-10-08 10:26:15,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('24', 'webbing', '2018-10-08 10:26:16', '[普通用户: webbing]在2018-10-08 10:26:16,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('25', 'webbing', '2018-10-08 10:26:16', '[普通用户: webbing]在2018-10-08 10:26:16,操作了:/showData方法.');
INSERT INTO `ulog` VALUES ('26', 'webbing', '2018-10-08 10:26:36', '[普通用户: webbing]在2018-10-08 10:26:36,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('27', 'webbing', '2018-10-08 10:26:37', '[普通用户: webbing]在2018-10-08 10:26:37,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('28', 'webbing', '2018-10-08 10:26:38', '[普通用户: webbing]在2018-10-08 10:26:38,操作了:/newsOne方法.');
INSERT INTO `ulog` VALUES ('29', 'webbing', '2018-10-08 10:26:38', '[普通用户: webbing]在2018-10-08 10:26:38,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('30', 'webbing', '2018-10-08 10:26:54', '[普通用户: webbing]在2018-10-08 10:26:54,操作了:/shoppingData方法.');
INSERT INTO `ulog` VALUES ('31', 'webbing', '2018-10-08 10:26:54', '[普通用户: webbing]在2018-10-08 10:26:54,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('32', 'webbing', '2018-10-08 10:27:09', '[普通用户: webbing]在2018-10-08 10:27:09,操作了:/findAllBooksData方法.');
INSERT INTO `ulog` VALUES ('33', 'webbing', '2018-10-08 10:27:09', '[普通用户: webbing]在2018-10-08 10:27:09,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('34', 'webbing', '2018-10-08 10:27:13', '[普通用户: webbing]在2018-10-08 10:27:13,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('35', 'webbing', '2018-10-08 10:27:13', '[普通用户: webbing]在2018-10-08 10:27:13,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('36', 'webbing', '2018-10-08 10:44:18', '[普通用户: webbing]在2018-10-08 10:44:18,操作了:/booksLinkPaging方法.');
INSERT INTO `ulog` VALUES ('37', 'webbing', '2018-10-08 10:44:21', '[普通用户: webbing]在2018-10-08 10:44:21,操作了:/booksLinkPaging方法.');
INSERT INTO `ulog` VALUES ('38', 'webbing', '2018-10-08 10:44:23', '[普通用户: webbing]在2018-10-08 10:44:23,操作了:/booksLinkPaging方法.');
INSERT INTO `ulog` VALUES ('39', 'webbing', '2018-10-08 10:44:23', '[普通用户: webbing]在2018-10-08 10:44:23,操作了:/booksLinkPaging方法.');
INSERT INTO `ulog` VALUES ('40', 'webbing', '2018-10-08 10:44:23', '[普通用户: webbing]在2018-10-08 10:44:23,操作了:/booksLinkPaging方法.');
INSERT INTO `ulog` VALUES ('41', 'webbing', '2018-10-08 10:44:24', '[普通用户: webbing]在2018-10-08 10:44:24,操作了:/booksLinkPaging方法.');
INSERT INTO `ulog` VALUES ('42', 'juntao', '2018-10-08 14:35:23', '[普通用户: juntao]在2018-10-08 14:35:23,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('43', 'juntao', '2018-10-08 14:35:23', '[普通用户: juntao]在2018-10-08 14:35:23,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('44', 'juntao', '2018-10-08 14:35:26', '[普通用户: juntao]在2018-10-08 14:35:26,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('45', 'juntao', '2018-10-08 14:39:09', '[普通用户: juntao]在2018-10-08 14:39:09,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('46', 'juntao', '2018-10-08 14:39:09', '[普通用户: juntao]在2018-10-08 14:39:09,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('47', 'juntao', '2018-10-08 14:39:10', '[普通用户: juntao]在2018-10-08 14:39:10,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('48', 'juntao', '2018-10-08 14:39:51', '[普通用户: juntao]在2018-10-08 14:39:51,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('49', 'juntao', '2018-10-08 14:39:52', '[普通用户: juntao]在2018-10-08 14:39:52,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('50', 'juntao', '2018-10-08 14:39:54', '[普通用户: juntao]在2018-10-08 14:39:54,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('51', 'juntao', '2018-10-08 14:39:55', '[普通用户: juntao]在2018-10-08 14:39:55,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('52', 'juntao', '2018-10-08 14:40:33', '[普通用户: juntao]在2018-10-08 14:40:33,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('53', 'juntao', '2018-10-08 14:40:35', '[普通用户: juntao]在2018-10-08 14:40:35,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('54', 'juntao', '2018-10-08 14:46:15', '[普通用户: juntao]在2018-10-08 14:46:15,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('55', 'juntao', '2018-10-08 14:46:15', '[普通用户: juntao]在2018-10-08 14:46:15,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('56', 'juntao', '2018-10-08 14:46:16', '[普通用户: juntao]在2018-10-08 14:46:16,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('57', 'juntao', '2018-10-08 16:33:06', '[普通用户: juntao]在2018-10-08 16:33:06,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('58', 'juntao', '2018-10-08 16:33:06', '[普通用户: juntao]在2018-10-08 16:33:06,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('59', 'juntao', '2018-10-08 16:33:07', '[普通用户: juntao]在2018-10-08 16:33:07,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('60', 'juntao', '2018-10-08 16:35:37', '[普通用户: juntao]在2018-10-08 16:35:37,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('61', 'juntao', '2018-10-08 16:35:39', '[普通用户: juntao]在2018-10-08 16:35:39,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('62', 'juntao', '2018-10-08 16:38:26', '[普通用户: juntao]在2018-10-08 16:38:26,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('63', 'juntao', '2018-10-08 16:38:26', '[普通用户: juntao]在2018-10-08 16:38:26,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('64', 'juntao', '2018-10-08 16:38:27', '[普通用户: juntao]在2018-10-08 16:38:27,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('65', 'juntao', '2018-10-08 16:52:15', '[普通用户: juntao]在2018-10-08 16:52:15,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('66', 'juntao', '2018-10-08 16:52:15', '[普通用户: juntao]在2018-10-08 16:52:15,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('67', 'juntao', '2018-10-08 16:52:16', '[普通用户: juntao]在2018-10-08 16:52:16,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('68', 'juntao', '2018-10-08 16:53:56', '[普通用户: juntao]在2018-10-08 16:53:56,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('69', 'juntao', '2018-10-08 16:53:56', '[普通用户: juntao]在2018-10-08 16:53:56,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('70', 'juntao', '2018-10-08 16:53:57', '[普通用户: juntao]在2018-10-08 16:53:57,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('71', 'juntao', '2018-11-16 15:42:19', '[普通用户: juntao]在2018-11-16 15:42:19,操作了:/login方法.');
INSERT INTO `ulog` VALUES ('72', 'juntao', '2018-11-16 15:42:19', '[普通用户: juntao]在2018-11-16 15:42:19,操作了:/showUser方法.');
INSERT INTO `ulog` VALUES ('73', 'juntao', '2018-11-16 15:42:22', '[普通用户: juntao]在2018-11-16 15:42:22,操作了:/memberIf方法.');
INSERT INTO `ulog` VALUES ('74', 'juntao', '2018-11-16 15:42:39', '[普通用户: juntao]在2018-11-16 15:42:39,操作了:/login方法.');
