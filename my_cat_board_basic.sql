-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: localhost    Database: my_cat
-- ------------------------------------------------------
-- Server version	8.0.33

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board_basic`
--

DROP TABLE IF EXISTS `board_basic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `board_basic` (
  `b_no` int NOT NULL AUTO_INCREMENT,
  `b_title` char(20) DEFAULT NULL,
  `b_writerID` char(20) NOT NULL,
  `b_datetime` datetime NOT NULL,
  `b_cont` text,
  `tag_b_no` int DEFAULT NULL,
  PRIMARY KEY (`b_no`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_basic`
--

LOCK TABLES `board_basic` WRITE;
/*!40000 ALTER TABLE `board_basic` DISABLE KEYS */;
INSERT INTO `board_basic` VALUES (5,'skek','skfkrh','2023-06-09 15:54:20','sorkdhktek',NULL),(6,'asdf','3342','2023-06-12 12:33:50','asdasgdasdf',NULL),(7,'adfgadsf','argadf','2023-06-12 12:33:57','adsfasdf',NULL),(8,'asdfasd','asdfasdf','2023-06-12 12:34:01','asdfasdfaesga',NULL),(11,'asdfasdfas','asdfasdfasdf','2023-06-12 13:16:10','aaafsdasdf',NULL),(12,'ya','nada','2023-06-12 15:31:21','naga',NULL),(13,'ya','nudo','2023-06-12 15:31:27','naga',NULL),(14,'ya','ndoo','2023-06-12 15:31:38','poooer',NULL),(17,'yq','ty','2023-06-12 15:35:11','utututututut',NULL),(19,'12','12','2023-06-12 15:41:02','12',NULL),(20,'ya','ya','2023-06-12 17:07:59','yaya',NULL),(21,'ya','ya','2023-06-12 17:09:08','yaya',NULL),(25,'ya','ya','2023-06-12 17:22:35','yaya',NULL),(26,'ya','ya','2023-06-12 17:22:54','yaya',NULL),(27,NULL,'ya','2023-06-13 09:14:59','yaya',5),(28,NULL,'ya','2023-06-13 09:15:37','yaya',27),(29,NULL,'ya','2023-06-13 09:18:52','yayata',5),(30,NULL,'ya','2023-06-13 09:32:27','gaaga',28),(31,NULL,'nada','2023-06-13 10:36:46','context',30),(32,NULL,'nada','2023-06-13 10:38:08','nuya',5),(33,NULL,'nuya','2023-06-13 10:38:58','yy',32);
/*!40000 ALTER TABLE `board_basic` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-06-13 12:12:32
