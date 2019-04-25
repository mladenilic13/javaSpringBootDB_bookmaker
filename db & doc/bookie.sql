CREATE DATABASE  IF NOT EXISTS `bookie` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `bookie`;
-- MySQL dump 10.13  Distrib 8.0.15, for Win64 (x86_64)
--
-- Host: localhost    Database: kladionica5seckurs
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
-- Table structure for table `korisnik`
--

DROP TABLE IF EXISTS `korisnik`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `korisnik` (
  `idkorisnik` int(11) NOT NULL AUTO_INCREMENT,
  `nazivkorisnik` varchar(45) NOT NULL,
  `emailkorisnik` varchar(45) NOT NULL,
  `passwordkorisnik` varchar(45) NOT NULL,
  PRIMARY KEY (`idkorisnik`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `korisnik`
--

LOCK TABLES `korisnik` WRITE;
/*!40000 ALTER TABLE `korisnik` DISABLE KEYS */;
INSERT INTO `korisnik` VALUES (23,'mladen','mladenilic79@gmail.com','sekira');
/*!40000 ALTER TABLE `korisnik` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `operater`
--

DROP TABLE IF EXISTS `operater`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `operater` (
  `idoperater` int(11) NOT NULL AUTO_INCREMENT,
  `nazivoperater` varchar(45) NOT NULL,
  `passwordoperater` varchar(45) NOT NULL,
  PRIMARY KEY (`idoperater`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;
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
-- Table structure for table `racun`
--

DROP TABLE IF EXISTS `racun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `racun` (
  `idracun` int(11) NOT NULL AUTO_INCREMENT,
  `svrha` varchar(45) NOT NULL,
  `iznos` decimal(10,2) NOT NULL,
  `vreme` datetime NOT NULL,
  `fkidkorisnik` int(11) NOT NULL,
  `valuta` varchar(45) DEFAULT NULL,
  `kurs` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`idracun`),
  KEY `fk_idKorisnik2_idx` (`fkidkorisnik`),
  CONSTRAINT `fk_idKorisnik2` FOREIGN KEY (`fkidkorisnik`) REFERENCES `korisnik` (`idkorisnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=400 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `racun`
--

LOCK TABLES `racun` WRITE;
/*!40000 ALTER TABLE `racun` DISABLE KEYS */;
INSERT INTO `racun` VALUES (270,'registracija',5.00,'2019-04-10 07:52:20',23,NULL,NULL),(271,'uplata',1000.00,'2019-04-10 07:53:27',23,NULL,NULL),(373,'kupovina',33.00,'2019-04-10 17:30:06',23,NULL,NULL),(374,'kupovina',33.00,'2019-04-10 17:30:12',23,NULL,NULL),(375,'kupovina',33.00,'2019-04-10 17:30:16',23,NULL,NULL),(376,'nagrada',50.00,'2019-04-10 17:36:31',23,NULL,NULL),(377,'kupovina',33.00,'2019-04-10 17:46:29',23,NULL,NULL),(378,'kupovina',33.00,'2019-04-10 17:46:32',23,NULL,NULL),(379,'kupovina',33.00,'2019-04-10 17:46:36',23,NULL,NULL),(380,'nagrada',50.00,'2019-04-10 17:49:57',23,NULL,NULL),(381,'kupovina',333.00,'2019-04-11 09:18:53',23,NULL,NULL),(382,'nagrada',500.00,'2019-04-11 09:20:00',23,NULL,NULL),(383,'kupovina',333.00,'2019-04-11 09:21:22',23,NULL,NULL),(384,'kupovina',333.00,'2019-04-11 11:19:28',23,NULL,NULL),(385,'kupovina',333.00,'2019-04-11 11:22:59',23,NULL,NULL),(386,'nagrada',500.00,'2019-04-11 11:25:02',23,NULL,NULL),(387,'kupovina',333.00,'2019-04-11 11:30:15',23,NULL,NULL),(388,'kupovina',333.00,'2019-04-11 12:11:36',23,NULL,NULL),(389,'kupovina',333.00,'2019-04-11 12:44:58',23,NULL,NULL),(390,'kupovina',333.00,'2019-04-11 12:52:06',23,NULL,NULL),(391,'nagrada',500.00,'2019-04-11 12:54:07',23,NULL,NULL),(392,'kupovina',333.00,'2019-04-11 13:02:14',23,NULL,NULL),(393,'uplata',511.00,'2019-04-17 13:03:24',23,'BGN',2.00),(394,'uplata',511.00,'2019-04-17 13:19:39',23,'BGN',2.00),(395,'isplata',511.00,'2019-04-17 13:19:48',23,'BGN',2.00),(396,'isplata',511.00,'2019-04-17 13:23:18',23,'BGN',2.00),(397,'uplata',511.00,'2019-04-17 13:23:25',23,'BGN',2.00),(398,'uplata',511.30,'2019-04-17 13:32:31',23,'BGN',1.96),(399,'isplata',511.30,'2019-04-17 13:32:38',23,'BGN',1.96);
/*!40000 ALTER TABLE `racun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tiket`
--

DROP TABLE IF EXISTS `tiket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tiket` (
  `idtiket` int(11) NOT NULL AUTO_INCREMENT,
  `uplaceno` decimal(10,0) NOT NULL,
  `obradjen` int(11) DEFAULT NULL,
  `fkidkorisnik` int(11) NOT NULL,
  PRIMARY KEY (`idtiket`),
  KEY `fk_idKorisnik_idx` (`fkidkorisnik`),
  CONSTRAINT `fk_idKorisnik` FOREIGN KEY (`fkidkorisnik`) REFERENCES `korisnik` (`idkorisnik`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=86 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tiket`
--

LOCK TABLES `tiket` WRITE;
/*!40000 ALTER TABLE `tiket` DISABLE KEYS */;
INSERT INTO `tiket` VALUES (71,33,1,23),(72,33,1,23),(73,33,1,23),(74,33,1,23),(75,33,1,23),(76,33,1,23),(77,333,1,23),(78,333,1,23),(79,333,1,23),(80,333,1,23),(81,333,1,23),(82,333,1,23),(83,333,1,23),(84,333,1,23),(85,333,1,23);
/*!40000 ALTER TABLE `tiket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utakmica`
--

DROP TABLE IF EXISTS `utakmica`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utakmica` (
  `idutakmica` int(11) NOT NULL AUTO_INCREMENT,
  `nazivutakmica` varchar(100) NOT NULL,
  `flagutakmica` int(11) DEFAULT NULL,
  `datumutakmica` datetime NOT NULL,
  `fkIdoperater` int(11) NOT NULL,
  PRIMARY KEY (`idutakmica`),
  KEY `fk_IdOperater_idx` (`fkIdoperater`),
  CONSTRAINT `fk_IdOperater` FOREIGN KEY (`fkIdoperater`) REFERENCES `operater` (`idoperater`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utakmica`
--

LOCK TABLES `utakmica` WRITE;
/*!40000 ALTER TABLE `utakmica` DISABLE KEYS */;
INSERT INTO `utakmica` VALUES (1,'partizan-zvezda-radnicki derbi br 250',1,'2019-04-11 13:03:00',1),(3,'nasi-od preko, susedno selo derbi 350',0,'2019-04-10 17:50:00',1),(4,'da li ce da skoci, sa most\', 0-nece, 1-mozda, 2-hoce',2,'2019-04-10 17:51:00',1);
/*!40000 ALTER TABLE `utakmica` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utakmicatiket`
--

DROP TABLE IF EXISTS `utakmicatiket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `utakmicatiket` (
  `idutakmicatiket` int(11) NOT NULL AUTO_INCREMENT,
  `predvidjanjeutakmicatiket` int(11) NOT NULL,
  `fkidtiket` int(11) NOT NULL,
  `fkidutakmica` int(11) NOT NULL,
  PRIMARY KEY (`idutakmicatiket`),
  KEY `fk_idTiket_idx` (`fkidtiket`),
  KEY `fk_idUtakmica_idx` (`fkidutakmica`),
  CONSTRAINT `fk_idTiket` FOREIGN KEY (`fkidtiket`) REFERENCES `tiket` (`idtiket`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_idUtakmica` FOREIGN KEY (`fkidutakmica`) REFERENCES `utakmica` (`idutakmica`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utakmicatiket`
--

LOCK TABLES `utakmicatiket` WRITE;
/*!40000 ALTER TABLE `utakmicatiket` DISABLE KEYS */;
INSERT INTO `utakmicatiket` VALUES (104,0,71,1),(105,1,72,1),(106,2,73,1),(107,0,74,1),(108,1,75,1),(109,2,76,1),(110,0,77,1),(111,1,78,1),(112,0,79,1),(113,0,80,1),(114,0,81,1),(115,0,82,1),(116,0,83,1),(117,0,84,1),(118,0,85,1);
/*!40000 ALTER TABLE `utakmicatiket` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-22 13:46:23
