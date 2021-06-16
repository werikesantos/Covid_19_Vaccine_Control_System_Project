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
  `periodo` varchar(3) NOT NULL,
  `descricao` varchar(4000) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `produtora` (`produtora`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vacina`
--

LOCK TABLES `vacina` WRITE;
/*!40000 ALTER TABLE `vacina` DISABLE KEYS */;
INSERT INTO `vacina` VALUES (1,'Universidade Oxford','Astrazeneca','Fiocruz',2,'90','* Tecnologia *\nA vacina produzida pela Universidade de Oxford (Reino Unido)\nusa uma tecnologia conhecida como vetor viral não \nreplicante. \nPor isso, utiliza um \"vírus vivo\", como um adenovírus \n(que causa o resfriado comum), que não tem capacidade de \nse replicar no organismo humano ou prejudicar a saúde.\n \nEste adenovírus também é modificado por meio de \nengenharia genética para passar a carregar em si as \ninstruções para a produção de uma proteína característica\ndo coronavírus, conhecida como espícula. \nAo entrar nas células, o adenovírus faz com que elas passem\na produzir essa proteína e a exiba em sua superfície, \no que é detectado pelo sistema imune, que cria formas\nde combater o coronavírus e cria uma resposta protetora\ncontra uma infecção.\n\n* Eficácia *\nA AstraZeneca e a Universidade de Oxford anunciaram dois \nresultados distintos de eficácia desta vacina —62% quando \naplicada em duas doses completas e 90% com meia dose \nseguida de outra completa. \nA eficácia média, segundo os cientistas responsáveis,\né de 70%.'),(2,'Sinovac - CoronaVac','Instituto Butantan','Instituto Butantan',2,'28','* Tecnologia *\nA vacina de origem chinesa é feita com o vírus inativado: \nele é cultivado e multiplicado numa cultura de células e \ndepois inativado por meio de calor ou produto químico. \nOu seja, o corpo que recebe a vacina com o vírus \n—já inativado— começa a gerar os anticorpos \nnecessários no combate da doença.\n\nAs células que dão início à resposta imune encontram \nos vírus inativados e os capturam, \nativando os linfócitos, células especializadas \ncapazes de combater microrganismos. \nOs linfócitos produzem anticorpos, que se ligam \naos vírus para impedir que eles infectem nossas células.\n\n* Eficácia *\nA eficácia geral da CoronaVac é 50,38%, ou seja, \nos vacinadostêm 50,38% menos risco de adoecer e,\ncaso pegue covid-19, a vacina oferece 100% de eficácia\npara não adoecer gravemente e 78% para \nprevenir casos leves.'),(3,'Pfizer','Pfizer/BioNTech','BioNTech',2,'90','* Tecnologia *\nA vacina utiliza a tecnologia chamada de mRNA ou \nRNA-mensageiro, diferente da CoronaVac ou da \nAstraZenca/Oxford, que utilizam o cultivo do vírus em \nlaboratório.\nOs imunizantes são criados a partir da replicação de \nsequências de RNA por meio de engenharia genética, \no que torna o processo mais barato e mais rápido. \n\nO RNA mensageiro mimetiza a proteína spike, específica \ndo vírus Sars-CoV-2, que o auxilia a invadir as células \nhumanas. Essa \"cópia\", no entanto, não é nociva como o \nvírus, mas é suficiente para desencadear uma reação das \ncélulas do sistema imunológico, que cria uma defesa \nrobusta no organismo. O imunizante da Pfizer precisa ser \nestocado a -75ºC —um dos grandes.\n\n* Eficácia *\nA farmacêutica Pfizer anunciou hoje que sua vacina contra a \ncovid-19, elaborada em parceria com a empresa alemã \nBioNTech, é segura e tem 95% de eficácia. \nEssa é a conclusão final da terceira fase de testes.'),(4,'Moderna','Moderna','Moderna',2,'42','* Tecnologia *\nAssim como a da Pfizer, a vacina da Moderna também utiliza \na tecnologia de RNA mensageiro, que mimetiza a proteína \nspike —específica do vírus Sars-CoV-2— que o auxilia a \ninvadir as células humanas. \n\nPorém, essa \"cópia\" não é nociva como o vírus, mas é \nsuficiente para desencadear uma reação das células do \nsistema imunológico, que cria uma defesa robusta no \norganismo. A única diferença para a vacina da Pfizer é que \nesta necessita de armazenamento de -20ºC.\n\n* Eficacia * \nUm estudo publicado por cientistas independentes no \nNew England Journal of Medicine confirmou que a vacina \nda Moderna tem eficácia de 94,1% na prevenção da doença.'),(5,'Instituto Gamaleya - Sputnik V','Instituto Gamaleya','União Química',2,'90','* Tecnologia * \nAssim como a da AstraZeneca, a Sputnik V, desenvolvida \npeloInstituto Gamaleya de Pesquisa da Rússia, \né uma vacina de \"vetor viral\", ou seja, ela utiliza outros vírus \npreviamente manipulados para que sejam inofensivos para \no organismo e, ao mesmo tempo, capazes de induzir \numa resposta para combater a covid-19.\n\nUma vez injetados no organismo, eles entram nas células e \nfazem com que elas passem a produzir e exibir essa \nproteína em sua superfície. Isso alerta o sistema \nimunológico, que aciona células de defesa e, desta forma, \naprende a combater o Sars-CoV-2. A diferença para a de \nOxford é que a Sputnik usa adenovírus diferentes na primeira\ne segunda doses, o que, segundo especialistas, \nreforça a resposta imunológica.\n\n* Eficácia * \nA vacina tem eficácia de 91,6% contra a covid-19 em suas \nmanifestações sintomáticas, segundo uma análise dos \ntestes clínicos publicada pelo periódico The Lancet e \nvalidada por especialistas independentes.'),(6,'Janssen','Janssen/Johnson & Johnson','Johnson & Johnson',1,'0','* Tecnologia * \nA vacina produzida pela farmacêutica Janssen, da \ncompanhia Johnson & Johnson, diferente das outras, \nprecisa apenas de uma dose única. \nA tecnologia é baseada em vetores de adenovírus —tipo de \nvírus que causam o resfriado comum, mas ao serem \nmodificados para desenvolver a vacina, eles não se \nreplicam e não causam resfriado.\n\nOutra parte do processo envolve o código genético do próprio\nvírus Sars-CoV-2. Para produzir a vacina, um pedaço da \nproteína \"S\", presente nessas espículas responsáveis pela\nligação do vírus às células do corpo humano, é colocado \ndentro do adenovírus (que é o vetor, ou transportador).\n\nQuando a pessoa recebe a vacina composta do adenovírus\nnão replicante, que carrega a informação genética do novo \ncoronavírus, o corpo inicia um processo de defesa e \nproduz anticorpos contra aquele invasor, criando uma \nmemória no corpo contra o coronavírus.\n\n* Eficácia *\nEm janeiro deste ano, a farmacêutica anunciou eficácia \nglobal da vacina de 66%. Em março, a Janssen informou \nque o imunizante contra covid-19 tem 87% de eficácia \ncontra formas graves da variante brasileira.'),(7,'Unidos var','Camp Nou Varion','Camp Nou Varion',1,'-','* Tecnologia * \nA vacina produzida pela Unidos var, usa uma tecnologia\nconhecida como vetor viral não  replicante.  \nPor isso, utiliza um \"vírus vivo\", como um adenovírus.\nEste adenovírus também é modificado por meio de  \nengenharia genética para passar a carregar em si as  \ninstruções para a produção de uma proteína característica \ndo coronavírus, conhecida como espícula.  \n\n* Eficácia * \nA Unidos var anunciaram dois  resultados distintos de \neficácia desta vacina —90% quando  aplicada na \nprimeira dose. \nA eficácia média, segundo os cientistas responsáveis,\né de 90%.'),(8,'Nações Unidas','Naval LTDA','Naval LTDA',1,'-','* Tecnologia *  \nA vacina produzida pela Unidos var, usa uma tecnologia \nconhecida como vetor viral não  replicante.   \nPor isso, utiliza um \"vírus vivo\", como um adenovírus. \n\n* Eficácia *  A Unidos var anunciaram dois  resultados distintos\n de  eficácia desta vacina —90% quando  aplicada na \nprimeira dose.  ');
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

-- Dump completed on 2021-06-16  1:46:34
