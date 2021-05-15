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
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` VALUES (1,'Universidade Oxford','Astrazeneca','Fiocruz',2,'03 meses','Tecnologia - A vacina produzida pela Universidade de Oxford (Reino Unido) usa uma tecnologia conhecida como vetor viral não replicante. Por isso, utiliza um \"vírus vivo\", como um adenovírus (que causa o resfriado comum), que não tem capacidade de se replicar no organismo humano ou prejudicar a saúde. Este adenovírus também é modificado por meio de engenharia genética para passar a carregar em si as instruções para a produção de uma proteína característica do coronavírus, conhecida como espícula. Ao entrar nas células, o adenovírus faz com que elas passem a produzir essa proteína e a exiba em sua superfície, o que é detectado pelo sistema imune, que cria formas de combater o coronavírus e cria uma resposta protetora contra uma infecção.\nEficácia - A AstraZeneca e a Universidade de Oxford anunciaram dois resultados distintos de eficácia desta vacina —62% quando aplicada em duas doses completas e 90% com meia dose seguida de outra completa. A eficácia média, segundo os cientistas responsáveis, é de 70%.'),(2,'Sinovac','Instituto Butantan','Instituto Butantan',2,'14 a 28 dias','Tecnologia\nA vacina de origem chinesa é feita com o vírus inativado: ele é cultivado e multiplicado numa cultura de células e depois inativado por meio de calor ou produto químico. \nOu seja, o corpo que recebe a vacina com o vírus —já inativado— começa a gerar os anticorpos necessários no combate da doença.\n\nAs células que dão início à resposta imune encontram os vírus inativados e os capturam, ativando os linfócitos, células especializadas capazes de combater microrganismos. \nOs linfócitos produzem anticorpos, que se ligam aos vírus para impedir que eles infectem nossas células.\n\nEficácia\nA eficácia geral da CoronaVac é 50,38%, ou seja, os vacinados têm 50,38% menos risco de adoecer e, caso pegue covid-19, a vacina oferece 100% de eficácia para não adoecer gravemente e 78% para prevenir casos leves.'),(3,'teste','testando','eu',2,'14 a 28 dias','veja aqui o teste testando o novo teste de teste testado!');
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

-- Dump completed on 2021-05-08 23:52:02
