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
-- Table structure for table `cidadao`
--

DROP TABLE IF EXISTS `cidadao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cidadao` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(60) NOT NULL,
  `nascimento` varchar(10) NOT NULL,
  `celular` varchar(14) DEFAULT NULL,
  `cpf` varchar(14) NOT NULL,
  `endereco` varchar(100) NOT NULL,
  `n` varchar(20) NOT NULL,
  `email` varchar(80) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cpf` (`cpf`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidadao`
--

LOCK TABLES `cidadao` WRITE;
/*!40000 ALTER TABLE `cidadao` DISABLE KEYS */;
INSERT INTO `cidadao` VALUES (1,'werike Marques','02/03/2021','11 9 6547-8502','456.654.789-02','Rua do zé caneta','1478','werike@gmail.com'),(2,'Mario Sobrado','24/89/4963','11 9 4565-5656','777.845.356-55','Rua visitorio','1645','mario@gmail.com'),(3,'Teste teste','45/45/6985','11 9 4567-5689','456.456.456-55','Avenida xicara','6789','Rua vencimento'),(6,'lucas nunes','02/12/1996','11983661963','4510831185','rua ','66','lucasnunes@gmail.com'),(10,'leandro vieira','12/08/1995','11 9 8645-8545','454.656.879-55','Rua vitorio','124','leandro@gmail.com'),(11,'Carlos Vecinio','30/06/1978','11 9 8998-6445','436.789.456-55','Rua carlinhos','7845','Rua valorante'),(12,'celular fonte','25/09/1998','11 9 7845-9898','456.778.789-52','Rua santa efigenia','4567','celular@gmail.com');
/*!40000 ALTER TABLE `cidadao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-11 18:44:26
