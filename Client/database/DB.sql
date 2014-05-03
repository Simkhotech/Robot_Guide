CREATE DATABASE  IF NOT EXISTS `db_robot_guide` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `db_robot_guide`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: db_robot_guide
-- ------------------------------------------------------
-- Server version	5.7.3-m13

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
-- Table structure for table `excursion_exhibit_tbl`
--

DROP TABLE IF EXISTS `excursion_exhibit_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excursion_exhibit_tbl` (
  `excursion_id` int(11) NOT NULL,
  `exhibit_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion_exhibit_tbl`
--

LOCK TABLES `excursion_exhibit_tbl` WRITE;
/*!40000 ALTER TABLE `excursion_exhibit_tbl` DISABLE KEYS */;
INSERT INTO `excursion_exhibit_tbl` VALUES (1,1),(1,2),(1,3),(1,4),(2,1),(2,3),(2,4);
/*!40000 ALTER TABLE `excursion_exhibit_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `excursion_tbl`
--

DROP TABLE IF EXISTS `excursion_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `excursion_tbl` (
  `excursion_id` int(11) NOT NULL AUTO_INCREMENT,
  `excursion_name` varchar(200) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`excursion_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `excursion_tbl`
--

LOCK TABLES `excursion_tbl` WRITE;
/*!40000 ALTER TABLE `excursion_tbl` DISABLE KEYS */;
INSERT INTO `excursion_tbl` VALUES (1,'Экскурсия 1'),(2,'Экскурсия 2');
/*!40000 ALTER TABLE `excursion_tbl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `exhibit_tbl`
--

DROP TABLE IF EXISTS `exhibit_tbl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `exhibit_tbl` (
  `exhibit_id` int(11) NOT NULL AUTO_INCREMENT,
  `exhibit_name` varchar(200) COLLATE utf8_bin NOT NULL,
  `exhibit_use` tinyint(1) NOT NULL,
  `exhibit_description` varchar(200) COLLATE utf8_bin NOT NULL,
  `exhibit_URL` varchar(200) COLLATE utf8_bin NOT NULL,
  `exhibit_x` int(11) NOT NULL,
  `exhibit_y` int(11) NOT NULL,
  PRIMARY KEY (`exhibit_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `exhibit_tbl`
--

LOCK TABLES `exhibit_tbl` WRITE;
/*!40000 ALTER TABLE `exhibit_tbl` DISABLE KEYS */;
INSERT INTO `exhibit_tbl` VALUES (1,'Экспонат 1',0,'Забавное описание Экскурсии 1','URL 1',1,1),(2,'Экспонат 2',0,'Забавное описание Экскурсии 2','URL 2',2,2),(3,'Экспонат 3',0,'Забавное описание Экскурсии 3','URL 3',3,3),(4,'Экспонат 4',0,'Забавное описание Экскурсии 4','URL 4',4,4);
/*!40000 ALTER TABLE `exhibit_tbl` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-01  1:24:47
