CREATE DATABASE  IF NOT EXISTS `bookie` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bookie`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: bookie
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
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `account` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `purpose` varchar(45) NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `time` datetime NOT NULL,
  `fkiduser` int(11) NOT NULL,
  `currency` varchar(45) DEFAULT NULL,
  `rate` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idKorisnik2_idx` (`fkiduser`),
  CONSTRAINT `fk_idKorisnik2` FOREIGN KEY (`fkiduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=419 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (270,'registracija',5.00,'2019-04-10 07:52:20',23,NULL,NULL),(271,'uplata',1000.00,'2019-04-10 07:53:27',23,NULL,NULL),(373,'kupovina',33.00,'2019-04-10 17:30:06',23,NULL,NULL),(374,'kupovina',33.00,'2019-04-10 17:30:12',23,NULL,NULL),(375,'kupovina',33.00,'2019-04-10 17:30:16',23,NULL,NULL),(376,'nagrada',50.00,'2019-04-10 17:36:31',23,NULL,NULL),(377,'kupovina',33.00,'2019-04-10 17:46:29',23,NULL,NULL),(378,'kupovina',33.00,'2019-04-10 17:46:32',23,NULL,NULL),(379,'kupovina',33.00,'2019-04-10 17:46:36',23,NULL,NULL),(380,'nagrada',50.00,'2019-04-10 17:49:57',23,NULL,NULL),(381,'kupovina',333.00,'2019-04-11 09:18:53',23,NULL,NULL),(382,'nagrada',500.00,'2019-04-11 09:20:00',23,NULL,NULL),(383,'kupovina',333.00,'2019-04-11 09:21:22',23,NULL,NULL),(384,'kupovina',333.00,'2019-04-11 11:19:28',23,NULL,NULL),(385,'kupovina',333.00,'2019-04-11 11:22:59',23,NULL,NULL),(386,'nagrada',500.00,'2019-04-11 11:25:02',23,NULL,NULL),(387,'kupovina',333.00,'2019-04-11 11:30:15',23,NULL,NULL),(388,'kupovina',333.00,'2019-04-11 12:11:36',23,NULL,NULL),(389,'kupovina',333.00,'2019-04-11 12:44:58',23,NULL,NULL),(390,'kupovina',333.00,'2019-04-11 12:52:06',23,NULL,NULL),(391,'nagrada',500.00,'2019-04-11 12:54:07',23,NULL,NULL),(392,'kupovina',333.00,'2019-04-11 13:02:14',23,NULL,NULL),(393,'uplata',511.00,'2019-04-17 13:03:24',23,'BGN',2.00),(394,'uplata',511.00,'2019-04-17 13:19:39',23,'BGN',2.00),(395,'isplata',511.00,'2019-04-17 13:19:48',23,'BGN',2.00),(396,'isplata',511.00,'2019-04-17 13:23:18',23,'BGN',2.00),(397,'uplata',511.00,'2019-04-17 13:23:25',23,'BGN',2.00),(398,'uplata',511.30,'2019-04-17 13:32:31',23,'BGN',1.96),(399,'isplata',511.30,'2019-04-17 13:32:38',23,'BGN',1.96),(400,'deposit',10700.00,'2019-04-25 06:58:10',23,NULL,NULL),(401,'deposit',306.78,'2019-04-25 06:59:48',23,'BGN',1.96),(404,'buy',333.00,'2019-05-05 06:42:52',23,NULL,NULL),(405,'buy',333.00,'2019-05-05 06:47:45',23,NULL,NULL),(406,'buy',333.00,'2019-05-05 06:59:56',23,NULL,NULL),(407,'reward',499.50,'2019-05-05 07:00:43',23,NULL,NULL),(408,'buy',333.00,'2019-05-05 07:23:35',23,NULL,NULL),(409,'buy',455.00,'2019-05-19 10:45:18',23,NULL,NULL),(410,'buy',455.00,'2019-05-19 10:51:11',23,NULL,NULL),(411,'buy',600.00,'2019-05-19 10:55:54',23,NULL,NULL),(414,'deposit',1000.00,'2019-05-20 13:09:17',23,NULL,NULL),(415,'withdrawal',1000.00,'2019-05-20 13:12:08',23,NULL,NULL),(416,'withdrawal',511.30,'2019-05-20 13:13:42',23,'BGN',1.96),(417,'buy',333.00,'2019-05-20 13:21:08',23,NULL,NULL);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `game`
--

DROP TABLE IF EXISTS `game`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `game` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `designation` varchar(100) NOT NULL,
  `flag` int(11) DEFAULT NULL,
  `time` datetime NOT NULL,
  `fkidoperater` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_IdOperater_idx` (`fkidoperater`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `game`
--

LOCK TABLES `game` WRITE;
/*!40000 ALTER TABLE `game` DISABLE KEYS */;
INSERT INTO `game` VALUES (1,'partizan-zvezda-radnicki derbi br 250',2,'2019-05-05 07:23:00',1),(3,'nasi-od preko, susedno selo derbi 350',0,'2019-04-10 17:50:00',1),(4,'da li ce da skoci, sa most\', 0-nece, 1-mozda, 2-hoce',0,'2019-04-10 17:51:00',1),(17,'partizan-zvezda derbi br 1000',0,'2019-05-19 10:57:00',1);
/*!40000 ALTER TABLE `game` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gameticket`
--

DROP TABLE IF EXISTS `gameticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `gameticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `prediction` int(11) NOT NULL,
  `fkidticket` int(11) NOT NULL,
  `fkidgame` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idTiket_idx` (`fkidticket`),
  KEY `fk_idUtakmica_idx` (`fkidgame`),
  CONSTRAINT `fk_idTiket` FOREIGN KEY (`fkidticket`) REFERENCES `ticket` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idUtakmica` FOREIGN KEY (`fkidgame`) REFERENCES `game` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=131 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gameticket`
--

LOCK TABLES `gameticket` WRITE;
/*!40000 ALTER TABLE `gameticket` DISABLE KEYS */;
INSERT INTO `gameticket` VALUES (104,0,71,1),(105,1,72,1),(106,2,73,1),(107,0,74,1),(108,1,75,1),(109,2,76,1),(110,0,77,1),(111,1,78,1),(112,0,79,1),(113,0,80,1),(114,0,81,1),(115,0,82,1),(116,0,83,1),(117,0,84,1),(118,0,85,1),(121,0,88,1),(122,0,89,1),(123,0,90,1),(124,0,91,1),(125,0,92,17),(126,0,93,17),(128,0,96,1),(129,1,96,3),(130,2,96,4);
/*!40000 ALTER TABLE `gameticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operater`
--

DROP TABLE IF EXISTS `operater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `operater` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `operater`
--

LOCK TABLES `operater` WRITE;
/*!40000 ALTER TABLE `operater` DISABLE KEYS */;
INSERT INTO `operater` VALUES (1,'pera','sjekira');
/*!40000 ALTER TABLE `operater` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ticket`
--

DROP TABLE IF EXISTS `ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `ticket` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `amount` decimal(10,0) NOT NULL,
  `processed` int(11) DEFAULT NULL,
  `fkiduser` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_idKorisnik_idx` (`fkiduser`),
  CONSTRAINT `fk_idKorisnik` FOREIGN KEY (`fkiduser`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=97 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ticket`
--

LOCK TABLES `ticket` WRITE;
/*!40000 ALTER TABLE `ticket` DISABLE KEYS */;
INSERT INTO `ticket` VALUES (71,33,1,23),(72,33,1,23),(73,33,1,23),(74,33,1,23),(75,33,1,23),(76,33,1,23),(77,333,1,23),(78,333,1,23),(79,333,1,23),(80,333,1,23),(81,333,1,23),(82,333,1,23),(83,333,1,23),(84,333,1,23),(85,333,1,23),(88,333,1,23),(89,333,1,23),(90,333,1,23),(91,333,1,23),(92,455,1,23),(93,455,1,23),(96,333,1,23);
/*!40000 ALTER TABLE `ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `pass` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=62 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (23,'mladen','mladenilic79@gmail.com','sekira');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-22 12:50:21
