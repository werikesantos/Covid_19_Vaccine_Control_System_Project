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
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cidadao`
--

LOCK TABLES `cidadao` WRITE;
/*!40000 ALTER TABLE `cidadao` DISABLE KEYS */;
INSERT INTO `cidadao` VALUES (1,'Werike Marques Santos','02/03/2021','(11)96547-8502','456.654.789-02','Rua do zé caneta','1478','werike@gmail.com'),(2,'Guilherme Silva Alves','17/03/2001','(11)94565-5656','777.845.356-55','Rua visitorio','1645','guilhermes1@gmail.com'),(3,'Ricardino Bragança Silva Oliveira da Silvas Silva Souza','02/07/2000','(11)94567-5689','456.456.456-55','Avenida xicara','6789','ricardino@gmail.com'),(6,'Lucas Nunes','02/12/1996','(11)98366-1963','452.698.784-00','Rua claudino','1012','lucasnunes@gmail.com'),(10,'Leandro Vieira Silvas','12/08/1995','(11)98645-8545','454.656.879-55','Rua vitorio','124','leandro@gmail.com'),(11,'Carlos Vecinio Silvas Oliveira Cardoso do Amaral','30/06/1978','(11)98998-6445','436.789.456-55','Rua carlinhos','7845','Rua valorante'),(12,'Carminha Vieira Cardoso Filho','25/09/1998','(11)97845-9898','456.778.789-52','Rua santa efigenia','4567','carminha@gmail.com'),(15,'Leila marques Sant','27/04/1974','(11)97878-7878','222.444.888-22','rua velha','7845','leila@gmail.com'),(18,'Lilian Camargo Camarguinho Vanussa','30/07/1972','(11)98545-0666','225.151.515-55','Travessa das Oliveiras','1212','lilian@gmail.com'),(19,'Juliana  Leonor Silva Silvas Jr.','15/08/1990','(11)96448-8282','456.455.266-26','Rua Carmesita','7891','juliana@gmai.com'),(20,'Mauricio Sergipano Cardoso','06/07/2000','(11)97899-2999','445.626.361-58','Rua Albaniza','7892','mauricio@gmail.com'),(21,'Cristina  Alburquerquer Carlota','20/09/1997','(11)94578-9959','458.899.637-47','Rua Vilella Silveira','7829','cristina@gmail.com'),(22,'Lulu Cardoso Oliveira','27/04/1990','(11)94567-8491','458.415.152-66','Avenida Cardoso Carlos','9635','luluzinha@gmail.com'),(23,'Viviane Vinicius Silva','05/12/1970','(11)94262-6262','563.689.895-92','Praça Vicentino braga','3546','viviane@gmail.com'),(24,'Valeria Vicente Silvas','08/10/1978','(11)96548-4848','482.294.822-98','Travessa Ricarlos','6875','valeria@gmail.com'),(25,'Vanderlei Junior Marques','07/08/1999','(11)95599-2992','929.489.584-92','Travessa ridrigo solto','6782','vanderlei@gmail.com'),(32,'Isabella Silva Alvarenga Cristovania','18/08/1997','(11)96455-4454','181.841.848-21','Rua Albaniza','7821','isabella@gmail.com'),(33,'Cristina Alvaringa Albaniza','04/05/1990','(11)96546-6546','818.181.828-28','Rua vilella','4820','cristina@gmail.com');
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

-- Dump completed on 2021-06-06 22:52:19
