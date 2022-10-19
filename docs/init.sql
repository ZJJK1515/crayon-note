-- MySQL dump 10.14  Distrib 5.5.36-MariaDB, for Win64 (x86)
--
-- Host: localhost    Database: crayondb
-- ------------------------------------------------------
-- Server version	5.5.36-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crayon_article`
--

DROP TABLE IF EXISTS `crayon_article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crayon_article` (
                                  `article_id` bigint(20) NOT NULL,
                                  `article_title` varchar(100) NOT NULL DEFAULT '',
                                  `article_content` text NOT NULL,
                                  `create_user_id` bigint(20) NOT NULL DEFAULT '-1',
                                  `create_username` varchar(50) NOT NULL DEFAULT '',
                                  `update_user_id` bigint(20) NOT NULL DEFAULT '-1',
                                  `update_username` varchar(50) NOT NULL DEFAULT '',
                                  `create_time` datetime NOT NULL,
                                  `modify_time` datetime NOT NULL,
                                  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crayon_article`
--

LOCK TABLES `crayon_article` WRITE;
/*!40000 ALTER TABLE `crayon_article` DISABLE KEYS */;
INSERT INTO `crayon_article` VALUES (1,'','哈哈哈',-1,'',-1,'','2021-06-10 11:13:34','2021-06-10 11:13:36');
/*!40000 ALTER TABLE `crayon_article` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-10 17:11:24
-- MySQL dump 10.14  Distrib 5.5.36-MariaDB, for Win64 (x86)
--
-- Host: localhost    Database: crayonlogdb
-- ------------------------------------------------------
-- Server version	5.5.36-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `crayon_log0`
--

DROP TABLE IF EXISTS `crayon_log0`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crayon_log0` (
                               `log_id` bigint(20) NOT NULL,
                               `log_content` text NOT NULL,
                               PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crayon_log0`
--

LOCK TABLES `crayon_log0` WRITE;
/*!40000 ALTER TABLE `crayon_log0` DISABLE KEYS */;
/*!40000 ALTER TABLE `crayon_log0` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crayon_log1`
--

DROP TABLE IF EXISTS `crayon_log1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crayon_log1` (
                               `log_id` bigint(20) NOT NULL,
                               `log_content` text NOT NULL,
                               PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crayon_log1`
--

LOCK TABLES `crayon_log1` WRITE;
/*!40000 ALTER TABLE `crayon_log1` DISABLE KEYS */;
/*!40000 ALTER TABLE `crayon_log1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crayon_log2`
--

DROP TABLE IF EXISTS `crayon_log2`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crayon_log2` (
                               `log_id` bigint(20) NOT NULL,
                               `log_content` text NOT NULL,
                               PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crayon_log2`
--

LOCK TABLES `crayon_log2` WRITE;
/*!40000 ALTER TABLE `crayon_log2` DISABLE KEYS */;
/*!40000 ALTER TABLE `crayon_log2` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crayon_log3`
--

DROP TABLE IF EXISTS `crayon_log3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crayon_log3` (
                               `log_id` bigint(20) NOT NULL,
                               `log_content` text NOT NULL,
                               PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crayon_log3`
--

LOCK TABLES `crayon_log3` WRITE;
/*!40000 ALTER TABLE `crayon_log3` DISABLE KEYS */;
/*!40000 ALTER TABLE `crayon_log3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `crayon_log4`
--

DROP TABLE IF EXISTS `crayon_log4`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `crayon_log4` (
                               `log_id` bigint(20) NOT NULL,
                               `log_content` text NOT NULL,
                               PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `crayon_log4`
--

LOCK TABLES `crayon_log4` WRITE;
/*!40000 ALTER TABLE `crayon_log4` DISABLE KEYS */;
/*!40000 ALTER TABLE `crayon_log4` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-10 17:12:57


-- auto-generated definition
create table crayon_user
(
    id              bigint                   not null comment '主键'
        primary key,
    user_id         bigint                   not null comment '用户id',
    login_name      varchar(20)   default '' not null comment '登录名',
    email           varchar(100)  default '' not null comment '邮箱',
    username        varchar(20)   default '' not null comment '昵称/用户名',
    password        varchar(50)   default '' not null comment '密码',
    user_avatar     varchar(1000) default '' not null comment '头像图片.',
    create_user_id  bigint                   not null comment '创建人id',
    create_username varchar(20)   default '' not null comment '创建人用户名',
    modify_user_id  bigint                   not null comment '修改人id',
    modify_username varchar(20)   default '' not null comment '修改人用户名'
)
    comment '用户表';


