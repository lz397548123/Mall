-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: mall
-- ------------------------------------------------------
-- Server version	8.0.15

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `123456_purchase`
--

DROP TABLE IF EXISTS `123456_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `123456_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `discount` double(10,2) NOT NULL,
  `commodity` varchar(20) NOT NULL,
  `number` int(10) NOT NULL,
  `price` double(10,4) NOT NULL,
  `price_all` double(10,4) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `123456_purchase`
--

LOCK TABLES `123456_purchase` WRITE;
/*!40000 ALTER TABLE `123456_purchase` DISABLE KEYS */;
INSERT INTO `123456_purchase` VALUES (1,'123456','杨昕萌','女',0.32,'蜂蜜',5,8888.8800,14222.2080,'2019-06-24 23:47:16');
/*!40000 ALTER TABLE `123456_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `397548123_purchase`
--

DROP TABLE IF EXISTS `397548123_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `397548123_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `discount` double(10,2) NOT NULL,
  `commodity` varchar(20) NOT NULL,
  `number` int(10) NOT NULL,
  `price` double(10,4) NOT NULL,
  `price_all` double(10,4) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `397548123_purchase`
--

LOCK TABLES `397548123_purchase` WRITE;
/*!40000 ALTER TABLE `397548123_purchase` DISABLE KEYS */;
INSERT INTO `397548123_purchase` VALUES (1,'397548123','梁壮','男',0.20,'苹果',1,10.6000,2.1200,'2019-06-09 06:29:37'),(2,'397548123','梁壮','男',0.20,'苹果',1,10.6000,2.1200,'2019-06-09 06:29:46'),(3,'397548123','梁壮','男',0.20,'苹果',3,10.6000,6.3600,'2019-06-13 14:54:47'),(4,'397548123','梁壮','男',0.20,'香蕉',3,4.8000,2.8800,'2019-06-22 21:31:36'),(5,'397548123','梁壮','男',0.20,'香蕉',2,4.8000,1.9200,'2019-06-22 21:34:13'),(6,'397548123','梁壮','男',0.20,'香蕉',2,4.8000,1.9200,'2019-06-22 22:28:27'),(7,'397548123','梁壮','男',0.20,'潘帅港',1,999.0000,199.8000,'2019-06-22 22:33:37'),(8,'397548123','梁壮','男',0.20,'香蕉',1,4.8000,0.9600,'2019-06-22 22:39:06');
/*!40000 ALTER TABLE `397548123_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `6416584_purchase`
--

DROP TABLE IF EXISTS `6416584_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `6416584_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `discount` double(10,2) NOT NULL,
  `commodity` varchar(20) NOT NULL,
  `number` int(10) NOT NULL,
  `price` double(10,4) NOT NULL,
  `price_all` double(10,4) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `6416584_purchase`
--

LOCK TABLES `6416584_purchase` WRITE;
/*!40000 ALTER TABLE `6416584_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `6416584_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `984615_purchase`
--

DROP TABLE IF EXISTS `984615_purchase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `984615_purchase` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `discount` double(10,2) NOT NULL,
  `commodity` varchar(20) NOT NULL,
  `number` int(10) NOT NULL,
  `price` double(10,4) NOT NULL,
  `price_all` double(10,4) NOT NULL,
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `984615_purchase`
--

LOCK TABLES `984615_purchase` WRITE;
/*!40000 ALTER TABLE `984615_purchase` DISABLE KEYS */;
/*!40000 ALTER TABLE `984615_purchase` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `commodityinfo`
--

DROP TABLE IF EXISTS `commodityinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `commodityinfo` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `commodity` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '商品',
  `manufacturer` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '厂商',
  `category` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '类别',
  `purchase_price` double(10,4) NOT NULL COMMENT '进价',
  `number` int(10) NOT NULL COMMENT '数量',
  `price` double(10,4) NOT NULL COMMENT '售价',
  `purchase_price_all` double(10,4) NOT NULL COMMENT '总进价',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '进货时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commodityinfo`
--

LOCK TABLES `commodityinfo` WRITE;
/*!40000 ALTER TABLE `commodityinfo` DISABLE KEYS */;
INSERT INTO `commodityinfo` VALUES (1,'苹果','北京','水果',8.8000,9,10.6000,79.2000,'2019-06-05 16:16:49'),(2,'香蕉','438宿舍','水果',3.2000,2,4.8000,6.4000,'2019-06-05 16:17:27'),(3,'蜂蜜','神农架','养生商品',320.0000,50,8888.8800,16000.0000,'2019-06-05 19:39:20'),(4,'菠萝','海南三亚','热带水果',30.9000,13,80.8000,401.7000,'2019-06-05 19:48:35'),(5,'橙子','杭州','水果',16.0000,30,20.5000,480.0000,'2019-06-05 19:55:03'),(6,'橘子','厦门','水果',17.2000,14,20.0000,240.8000,'2019-06-05 19:55:46'),(7,'尹正宇','人口贩卖公司','奴隶',1.2000,3,2.5000,3.6000,'2019-06-06 16:13:42'),(8,'元帅','人口贩卖机制','侍卫',2.0000,2,4.2000,4.0000,'2019-06-06 16:14:21'),(9,'潘帅港','人口贩卖公司','将军',888.0000,1,999.0000,888.0000,'2019-06-06 16:34:30'),(10,'213','3213','12313',12.0000,27,1221.0000,324.0000,'2019-06-13 14:53:29'),(11,'张委员','56165','3235',20.5000,3,88.0000,61.5000,'2019-06-23 16:30:48'),(12,'Java课本','6209宿舍','程序设计书',80.4000,4,100.9000,321.6000,'2019-06-24 20:43:05');
/*!40000 ALTER TABLE `commodityinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `saleinfo`
--

DROP TABLE IF EXISTS `saleinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `saleinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `commodity` varchar(20) NOT NULL COMMENT '商品名',
  `number` int(11) NOT NULL COMMENT '商品数量',
  `price` double(10,4) NOT NULL COMMENT '商品售价',
  `price_all` double(10,4) NOT NULL COMMENT '商品总价',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `saleinfo`
--

LOCK TABLES `saleinfo` WRITE;
/*!40000 ALTER TABLE `saleinfo` DISABLE KEYS */;
INSERT INTO `saleinfo` VALUES (1,'苹果',1,10.6000,2.1200,'2019-06-09 06:29:37'),(2,'苹果',1,10.6000,2.1200,'2019-06-09 06:29:46'),(3,'苹果',3,10.6000,6.3600,'2019-06-13 14:54:47'),(4,'香蕉',2,4.8000,1.9200,'2019-06-22 22:28:27'),(5,'潘帅港',1,999.0000,199.8000,'2019-06-22 22:33:37'),(6,'香蕉',1,4.8000,0.9600,'2019-06-22 22:39:07'),(7,'蜂蜜',5,8888.8800,14222.2080,'2019-06-24 23:47:17');
/*!40000 ALTER TABLE `saleinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `userinfo`
--

DROP TABLE IF EXISTS `userinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `userinfo` (
  `user` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '密码',
  `name` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `department` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '部门',
  `post` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '职务',
  `time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `userinfo`
--

LOCK TABLES `userinfo` WRITE;
/*!40000 ALTER TABLE `userinfo` DISABLE KEYS */;
INSERT INTO `userinfo` VALUES ('12345','12345','12345','男','秘书处','董事长','2019-06-06 11:37:13'),('397548123','lzqq397548123','梁壮','男','市场部','董事长','2019-06-06 11:37:36'),('123456','123456','尹正宇','女','进货部','干事','2019-06-06 15:58:41'),('1234567','123456','潘帅港','女','市场部','经理','2019-06-06 16:12:27'),('12345678','123456','元帅','男','服务部','干事','2019-06-06 16:33:03'),('11111','1234567','喻修飞','男','销售部','董事长','2019-06-13 14:52:02'),('123456789','1234567','张委员','男','市场部','董事长','2019-06-23 16:29:42'),('zhangwangwei','123456','张王卫','男','人事部','干事','2019-06-24 19:24:31');
/*!40000 ALTER TABLE `userinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vipinfo`
--

DROP TABLE IF EXISTS `vipinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `vipinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user` varchar(11) NOT NULL COMMENT '账号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '姓名',
  `sex` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '性别',
  `address` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '住址',
  `telephone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '电话',
  `discount` double(10,2) NOT NULL COMMENT '折扣',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vipinfo`
--

LOCK TABLES `vipinfo` WRITE;
/*!40000 ALTER TABLE `vipinfo` DISABLE KEYS */;
INSERT INTO `vipinfo` VALUES (1,'397548123','lzqq397548123','梁壮','男','郑州轻工业大学','15225831399',0.20,'2019-06-09 03:59:13'),(2,'123456','123456','杨昕萌','女','123456','15255555555',0.32,'2019-06-20 22:46:23'),(3,'984615','888888','喻修飞','男','6209','13775314896',0.98,'2019-06-24 21:12:37'),(4,'6416584','hahaha','曹振云','男','郑州轻工业大学','13888420138',0.77,'2019-06-24 21:13:15');
/*!40000 ALTER TABLE `vipinfo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `workerinfo`
--

DROP TABLE IF EXISTS `workerinfo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `workerinfo` (
  `id` int(20) NOT NULL COMMENT '工号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` varchar(10) NOT NULL COMMENT '性别',
  `age` int(10) NOT NULL COMMENT '年龄',
  `department` varchar(20) NOT NULL COMMENT '部门',
  `post` varchar(20) NOT NULL COMMENT '职务',
  `telephone` varchar(20) NOT NULL COMMENT '电话',
  `month_pay` double(20,4) NOT NULL COMMENT '月薪',
  `address` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '住址',
  `status` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '状态',
  `time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `workerinfo`
--

LOCK TABLES `workerinfo` WRITE;
/*!40000 ALTER TABLE `workerinfo` DISABLE KEYS */;
INSERT INTO `workerinfo` VALUES (1,'梁壮','男',18,'销售部','董事长','15225831399',30000.0000,'郑州轻工业大学创新基地338','ε=( o｀ω′)ノ（怒）','2019-06-09 07:13:20'),(2,'杨昕萌','男',88,'服务部','干事','15888888888',8.8000,'郑州轻工业大学创新基地338','(′д｀ )…彡…彡（哀）','2019-06-24 23:58:26'),(3,'张王卫','男',19,'人事部','董事长','13666666666',300000.0000,'郑州轻工业大学','(*^_^*)（笑)','2019-06-25 00:25:21'),(4,'123','男',123,'人事部','干事','18555555555',123.0000,'123','123','2019-06-25 00:25:41');
/*!40000 ALTER TABLE `workerinfo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-06-25  1:01:47
