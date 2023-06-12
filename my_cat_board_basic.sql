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
  `b_title` char(50) DEFAULT NULL,
  `b_writerID` char(50) DEFAULT NULL,
  `b_datetime` datetime DEFAULT NULL,
  `b_cont` text,
  PRIMARY KEY (`b_no`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_basic`
--

LOCK TABLES `board_basic` WRITE;
/*!40000 ALTER TABLE `board_basic` DISABLE KEYS */;
INSERT INTO `board_basic` VALUES (5,'skek','skfkrh','2023-06-09 15:54:20','sorkdhktek'),(6,'asdf','3342','2023-06-12 12:33:50','asdasgdasdf'),(7,'adfgadsf','argadf','2023-06-12 12:33:57','adsfasdf'),(8,'asdfasd','asdfasdf','2023-06-12 12:34:01','asdfasdfaesga'),(9,'asdfasd','asdfasdf','2023-06-12 12:34:04','asdfasfasdfasdf'),(11,'asdfasdfas','asdfasdfasdf','2023-06-12 13:16:10','aaafsdasdf');
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

-- Dump completed on 2023-06-12 13:28:53
