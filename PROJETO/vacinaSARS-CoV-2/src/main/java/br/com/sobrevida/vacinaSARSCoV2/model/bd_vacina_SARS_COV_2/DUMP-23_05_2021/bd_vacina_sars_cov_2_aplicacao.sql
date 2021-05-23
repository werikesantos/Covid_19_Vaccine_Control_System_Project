-- MySQL dump 10.13  Distrib 8.0.24, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: bd_vacina_sars_cov_2
-- ------------------------------------------------------
-- Server version	8.0.24

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
-- Table structure for table `aplicacao`
--

DROP TABLE IF EXISTS `aplicacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aplicacao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idCidadao` int NOT NULL,
  `idVacina` int NOT NULL,
  `dose` int NOT NULL,
  `unica` varchar(10) DEFAULT NULL,
  `primeira` varchar(10) DEFAULT NULL,
  `segunda` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `idCidadao` (`idCidadao`),
  KEY `idVacina` (`idVacina`),
  CONSTRAINT `aplicacao_ibfk_1` FOREIGN KEY (`idCidadao`) REFERENCES `cidadao` (`id`),
  CONSTRAINT `aplicacao_ibfk_2` FOREIGN KEY (`idVacina`) REFERENCES `vacina` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplicacao`
--

LOCK TABLES `aplicacao` WRITE;
/*!40000 ALTER TABLE `aplicacao` DISABLE KEYS */;
INSERT INTO `aplicacao` VALUES (1,1,1,1,'null','20/05/2021','20/06/2021'),(5,11,6,0,'25/08/1993','null','null'),(6,6,3,2,'null','22/05/2021','31/05/2021'),(8,2,3,1,'null','25/08/1993','31/05/2021'),(10,15,3,1,'null','25/08/1993','31/05/2021'),(12,17,6,0,'null','null','31/05/2021');
/*!40000 ALTER TABLE `aplicacao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-23 19:04:37
