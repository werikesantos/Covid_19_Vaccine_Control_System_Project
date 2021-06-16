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
  `dose_aplicada` int NOT NULL,
  `data_aplicacao` varchar(10) NOT NULL,
  `previsao` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idCidadao` (`idCidadao`),
  KEY `idVacina` (`idVacina`),
  CONSTRAINT `aplicacao_ibfk_1` FOREIGN KEY (`idCidadao`) REFERENCES `cidadao` (`id`),
  CONSTRAINT `aplicacao_ibfk_2` FOREIGN KEY (`idVacina`) REFERENCES `vacina` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aplicacao`
--

LOCK TABLES `aplicacao` WRITE;
/*!40000 ALTER TABLE `aplicacao` DISABLE KEYS */;
INSERT INTO `aplicacao` VALUES (1,1,1,1,'20-05-2021','2021-06-20'),(30,32,6,1,'20-03-2021',NULL),(33,20,5,1,'27-03-2021','2021-06-25'),(34,10,4,1,'14-05-2021','2021-06-25'),(35,6,3,1,'27-03-2021','2021-06-25'),(36,15,2,1,'28-05-2021','2021-06-25'),(38,22,1,1,'27-03-2021','2021-06-25'),(39,25,2,1,'28-05-2021','2021-06-25'),(40,18,5,1,'27-03-2021','2021-06-25'),(41,24,4,1,'14-05-2021','2021-06-25'),(46,23,4,1,'14-05-2021','2021-06-25');
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

-- Dump completed on 2021-06-16  1:46:31