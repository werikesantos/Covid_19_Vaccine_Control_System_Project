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
-- Table structure for table `vacina`
--

DROP TABLE IF EXISTS `vacina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vacina` (
  `id` int NOT NULL AUTO_INCREMENT,
  `desenvolvedora` varchar(60) NOT NULL,
  `produtora` varchar(60) NOT NULL,
  `parceira` varchar(60) NOT NULL,
  `qtd_Dose` int NOT NULL,
  `periodo` varchar(12) NOT NULL,
  `descricao` varchar(4000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `produtora` (`produtora`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` VALUES (1,'Universidade Oxford','Astrazeneca','Fiocruz',2,'03 meses','* Tecnologia *\nA vacina produzida pela Universidade de Oxford (Reino Unido)\nusa uma tecnologia conhecida como vetor viral não \nreplicante. \nPor isso, utiliza um \"vírus vivo\", como um adenovírus \n(que causa o resfriado comum), que não tem capacidade de \nse replicar no organismo humano ou prejudicar a saúde.\n \nEste adenovírus também é modificado por meio de \nengenharia genética para passar a carregar em si as \ninstruções para a produção de uma proteína característica\ndo coronavírus, conhecida como espícula. \nAo entrar nas células, o adenovírus faz com que elas passem\na produzir essa proteína e a exiba em sua superfície, \no que é detectado pelo sistema imune, que cria formas\nde combater o coronavírus e cria uma resposta protetora\ncontra uma infecção.\n\n* Eficácia *\nA AstraZeneca e a Universidade de Oxford anunciaram dois \nresultados distintos de eficácia desta vacina —62% quando \naplicada em duas doses completas e 90% com meia dose \nseguida de outra completa. \nA eficácia média, segundo os cientistas responsáveis,\né de 70%.'),(2,'Sinovac','Instituto Butantan','Instituto Butantan',2,'14 a 28 dias','* Tecnologia *\nA vacina de origem chinesa é feita com o vírus inativado: \nele é cultivado e multiplicado numa cultura de células e \ndepois inativado por meio de calor ou produto químico. \nOu seja, o corpo que recebe a vacina com o vírus \n—já inativado— começa a gerar os anticorpos \nnecessários no combate da doença.\n\nAs células que dão início à resposta imune encontram \nos vírus inativados e os capturam, \nativando os linfócitos, células especializadas \ncapazes de combater microrganismos. \nOs linfócitos produzem anticorpos, que se ligam \naos vírus para impedir que eles infectem nossas células.\n\n* Eficácia *\nA eficácia geral da CoronaVac é 50,38%, ou seja, \nos vacinadostêm 50,38% menos risco de adoecer e,\ncaso pegue covid-19, a vacina oferece 100% de eficácia\npara não adoecer gravemente e 78% para \nprevenir casos leves.');
/*!40000 ALTER TABLE `vacina` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-05-10 16:11:27
