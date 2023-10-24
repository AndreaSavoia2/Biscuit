CREATE DATABASE  IF NOT EXISTS `biscuit` /*!40100 DEFAULT CHARACTER SET utf8mb3 */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biscuit`;
-- MySQL dump 10.13  Distrib 8.0.33, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: biscuit
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
-- Table structure for table `commenti`
--

DROP TABLE IF EXISTS `commenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `commenti` (
  `id_commento` int NOT NULL,
  `id_post` int NOT NULL,
  `id_utente_commentatore` int NOT NULL,
  `testo_commento` varchar(300) DEFAULT NULL,
  `data_commento` datetime DEFAULT NULL,
  PRIMARY KEY (`id_commento`),
  KEY `1_idx` (`id_utente_commentatore`),
  KEY `2_idx` (`id_post`),
  CONSTRAINT `Fk_utente_com` FOREIGN KEY (`id_utente_commentatore`) REFERENCES `user` (`id_user`),
  CONSTRAINT `kf_utente_post` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `commenti`
--

LOCK TABLES `commenti` WRITE;
/*!40000 ALTER TABLE `commenti` DISABLE KEYS */;
/*!40000 ALTER TABLE `commenti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `follow`
--

DROP TABLE IF EXISTS `follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `follow` (
  `id_follow` int NOT NULL AUTO_INCREMENT,
  `id_utente` int NOT NULL,
  `id_seguito` int NOT NULL,
  PRIMARY KEY (`id_follow`),
  KEY `UserID_Utente_UserID_idx` (`id_utente`),
  KEY `FollowingID_Utente_UserID_idx` (`id_seguito`),
  CONSTRAINT `idSeguito_Utente_idUtente` FOREIGN KEY (`id_seguito`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idUtente_Utente_idUtente` FOREIGN KEY (`id_utente`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `follow`
--

LOCK TABLES `follow` WRITE;
/*!40000 ALTER TABLE `follow` DISABLE KEYS */;
/*!40000 ALTER TABLE `follow` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `img_profile`
--

DROP TABLE IF EXISTS `img_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `img_profile` (
  `id_img` int NOT NULL AUTO_INCREMENT,
  `id_user` int NOT NULL,
  `img_name` varchar(255) DEFAULT NULL,
  `img_type` varchar(128) DEFAULT NULL,
  `img_data` longblob,
  PRIMARY KEY (`id_img`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `img_profile`
--

LOCK TABLES `img_profile` WRITE;
/*!40000 ALTER TABLE `img_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `img_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `post`
--

DROP TABLE IF EXISTS `post`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `post` (
  `id_post` int NOT NULL AUTO_INCREMENT,
  `id_utente` int NOT NULL,
  `titolo` varchar(45) NOT NULL,
  `contenuto` varchar(300) NOT NULL,
  `immagine` varchar(45) DEFAULT NULL,
  `data_pubblicazione` datetime DEFAULT NULL,
  PRIMARY KEY (`id_post`),
  KEY `id_user_post_utente_ud_user_idx` (`id_utente`),
  CONSTRAINT `id_user_post_utente_ud_user` FOREIGN KEY (`id_utente`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `post`
--

LOCK TABLES `post` WRITE;
/*!40000 ALTER TABLE `post` DISABLE KEYS */;
/*!40000 ALTER TABLE `post` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postfavoriti`
--

DROP TABLE IF EXISTS `postfavoriti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postfavoriti` (
  `id_postFavoriti` int NOT NULL AUTO_INCREMENT,
  `id_post` int NOT NULL,
  `id_utente` int NOT NULL,
  PRIMARY KEY (`id_postFavoriti`),
  KEY `3_idx` (`id_post`),
  KEY `4_idx` (`id_utente`),
  CONSTRAINT `Fk_PostFavoriti_Post` FOREIGN KEY (`id_post`) REFERENCES `post` (`id_post`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `Fk_PostFavoritiUtente_Utente` FOREIGN KEY (`id_utente`) REFERENCES `user` (`id_user`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postfavoriti`
--

LOCK TABLES `postfavoriti` WRITE;
/*!40000 ALTER TABLE `postfavoriti` DISABLE KEYS */;
/*!40000 ALTER TABLE `postfavoriti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `gender` enum('m','f','a') NOT NULL,
  `birthdate` varchar(10) NOT NULL,
  `registration_date` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id_user`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
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

-- Dump completed on 2023-10-24 12:04:22
