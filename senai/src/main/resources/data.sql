-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: miaudopt
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `adocoes`
--

DROP TABLE IF EXISTS `adocoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adocoes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fk_adotante` int DEFAULT NULL,
  `fk_doador` int DEFAULT NULL,
  `fk_pet` int DEFAULT NULL,
  `dt_adocao` date DEFAULT NULL,
  `status_adocao` enum('DISPONÍVEL','EM PROCESSO','ADOTADO') DEFAULT NULL,
  `motivo_adotante` text,
  `motivo_doador` text,
  `OBSERVACOES` text,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_adotante` (`fk_adotante`),
  KEY `fk_doador` (`fk_doador`),
  KEY `fk_pet` (`fk_pet`),
  CONSTRAINT `adocoes_ibfk_1` FOREIGN KEY (`fk_adotante`) REFERENCES `adotantes` (`id`),
  CONSTRAINT `adocoes_ibfk_2` FOREIGN KEY (`fk_doador`) REFERENCES `doadores` (`id`),
  CONSTRAINT `adocoes_ibfk_3` FOREIGN KEY (`fk_pet`) REFERENCES `pets` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adocoes`
--

LOCK TABLES `adocoes` WRITE;
/*!40000 ALTER TABLE `adocoes` DISABLE KEYS */;
INSERT INTO `adocoes` VALUES (1,1,1,3,'2024-01-12','ADOTADO','Quero companhia em casa.','Adotante mostrou responsabilidade.','A adaptação foi tranquila.'),(2,2,1,5,'2024-01-20','EM PROCESSO','Procuro um animal calmo.','Pet ainda está em avaliação.','Aguardando visita final.'),(3,3,2,2,'2024-02-01','DISPONÍVEL','Ainda avaliando opções.','Pet disponível para adoção.','Adotante indeciso.'),(4,4,3,7,'2024-02-15','ADOTADO','Quero um cão para atividades ao ar livre.','Ótima compatibilidade.','A adoção foi imediata.'),(5,5,2,1,'2024-02-20','ADOTADO','Sempre quis um gato.','Pet sociável e dócil.','Entrega realizada.'),(6,6,4,4,'2024-02-28','EM PROCESSO','Quero adotar mas ainda estou vendo a rotina.','Pet precisa de acompanhamento.','Retorno marcado.'),(7,7,3,6,'2024-03-03','DISPONÍVEL','Curioso sobre adoção.','Pet ainda não foi adotado.','Sem visitas ainda.'),(8,8,4,9,'2024-03-10','ADOTADO','Busco um pet para a família.','Perfil ideal.','Família adorou o pet.'),(9,9,5,10,'2024-03-12','ADOTADO','Quero um cão pequeno.','Pet saudável.','Adaptação rápida.'),(10,10,6,8,'2024-03-15','EM PROCESSO','Amei o pet, falta confirmar mudança.','Adotante parece responsável.','Aguardando documentação.'),(11,11,7,11,'2024-03-20','DISPONÍVEL','Apenas pesquisando por enquanto.','Pet ainda listado.','Nenhuma visita agendada.'),(12,12,8,12,'2024-03-22','ADOTADO','Preciso de companhia para estudos.','Pet muito dócil.','Pet já está no novo lar.'),(13,13,9,13,'2024-03-25','EM PROCESSO','Quero um pet que combine com meu espaço.','Pet exige cuidados moderados.','Agendada entrevista.'),(14,14,10,14,'2024-03-28','ADOTADO','Quero adotar um gato adulto.','Gato muito tranquilo.','Adoção concluída.'),(15,15,2,15,'2024-04-01','DISPONÍVEL','Avaliando mais animais.','Pet sem interessados ainda.','Sem novidades.'),(16,1,4,16,'2024-04-03','EM PROCESSO','Gostei do comportamento do pet.','Boa compatibilidade.','Visita marcada.'),(17,2,6,17,'2024-04-05','ADOTADO','Quero um pet carinhoso.','Pet muito sociável.','Novo tutor feliz.'),(18,3,7,18,'2024-04-10','EM PROCESSO','Busco um cão jovem.','Pet com energia alta.','Aguardando retorno do adotante.'),(19,4,8,19,'2024-04-12','DISPONÍVEL','Ainda pesquisando.','Pet saudável e pronto.','Nenhum candidato forte.'),(20,5,9,20,'2024-04-14','ADOTADO','Quero um pet para companhia.','Adotante muito atencioso.','Adoção realizada.'),(21,6,1,2,'2024-04-16','EM PROCESSO','Revisando rotina com pet.','Pet dócil.','Aguardando aprovação.'),(22,7,2,4,'2024-04-20','ADOTADO','Quero um cão para passeios.','Pet energético.','Transição concluída.'),(23,8,3,6,'2024-04-22','DISPONÍVEL','Ainda vendo opções.','Pet saudável.','Prospecção inicial.'),(24,9,4,8,'2024-04-25','EM PROCESSO','Adotante em análise.','Boa compatibilidade.','Nova visita agendada.'),(25,10,5,10,'2024-04-27','ADOTADO','Quero companhia para meus filhos.','Boa interação com crianças.','Entrega concluída.'),(26,11,6,12,'2024-04-30','EM PROCESSO','Quero um gato calmo.','Pet tranquilo.','Aguardando assinatura.'),(27,12,7,1,'2024-05-02','DISPONÍVEL','Observando pets.','Pet ainda no abrigo.','Sem visitas recentes.'),(28,13,8,3,'2024-05-05','ADOTADO','Conexão imediata com o pet.','Ótimo adotante.','Finalizado.'),(29,14,9,5,'2024-05-07','EM PROCESSO','Quero adotar em breve.','Pet com boa saúde.','Acompanhamento iniciado.'),(30,15,10,7,'2024-05-10','ADOTADO','Quero um animal companheiro.','Adotante muito dedicado.','Pet no novo lar.');
/*!40000 ALTER TABLE `adocoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adotantes`
--

DROP TABLE IF EXISTS `adotantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `adotantes` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `telefone` char(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adotantes`
--

LOCK TABLES `adotantes` WRITE;
/*!40000 ALTER TABLE `adotantes` DISABLE KEYS */;
INSERT INTO `adotantes` VALUES (1,'Pedro Henrique','11911223344','pedro@gmail.com'),(2,'Larissa Monteiro','11922334455','lari@gmail.com'),(3,'Daniel Costa','11933445566','daniel@yahoo.com'),(4,'Maria Fernanda','11944556677','maria@hotmail.com'),(5,'Camila Rocha','11955667788','camila@outlook.com'),(6,'José Almeida','11966778899','jose@mail.com'),(7,'Vinícius Prado','11977889900','vini@gmail.com'),(8,'Eduarda Freire','11988990011','eduarda@gmail.com'),(9,'Felipe Moraes','11999001122','felipe@yahoo.com'),(10,'Júlia Souza','11910101010','julia@gmail.com'),(11,'Sandro Ribeiro','11912121212','sandro@mail.com'),(12,'Monique Arruda','11923232323','monique@hotmail.com'),(13,'Rafaela Dias','11934343434','rafa@gmail.com'),(14,'Caio Martins','11945454545','caio@gmail.com'),(15,'Bruna Torres','11956565656','bruna@mail.com');
/*!40000 ALTER TABLE `adotantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `doadores`
--

DROP TABLE IF EXISTS `doadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `doadores` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `cpf` char(15) DEFAULT NULL,
  `telefone` char(15) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `dt_registro` date DEFAULT NULL,
  `dt_update` date DEFAULT NULL,
  `dt_nascimento` date DEFAULT NULL,
  `fk_login` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_login` (`fk_login`),
  CONSTRAINT `doadores_ibfk_1` FOREIGN KEY (`fk_login`) REFERENCES `login` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `doadores`
--

LOCK TABLES `doadores` WRITE;
/*!40000 ALTER TABLE `doadores` DISABLE KEYS */;
INSERT INTO `doadores` VALUES (1,'Márcia Santos','123.456.789-10','11987654321','marcia@gmail.com','2024-01-10','2024-02-01','1985-03-12',1),(2,'João Paz','987.654.321-00','11966554433','joao@hotmail.com','2023-11-20','2024-01-15','1990-07-09',2),(3,'Carolina Alves','741.852.963-11','11999887766','carol@yahoo.com','2024-02-14','2024-02-20','1998-12-22',3),(4,'Dr. Leo Veterinário','159.357.258-44','11955554444','vet@mail.com','2024-03-01','2024-03-15','1979-04-03',4),(5,'Luiz Oliveira','111.222.333-44','11944332211','luiz@mail.com','2024-02-10','2024-02-11','1987-04-18',6),(6,'Marta Freitas','555.444.333-22','11955668844','marta@mail.com','2024-03-04','2024-03-05','1977-01-29',7),(7,'Paulo César','666.777.222-99','11966778899','paulo@gmail.com','2024-01-20','2024-01-22','1983-08-16',8),(8,'Ana Lima','222.333.444-66','11977889900','ana@hotmail.com','2024-01-25','2024-02-02','1995-02-14',9),(9,'Ricardo Souza','123.123.123-55','11988990011','ricardo@yahoo.com','2024-03-01','2024-03-10','1989-03-30',10),(10,'Aline Cruz','777.555.111-88','11999881122','aline@mail.com','2024-02-22','2024-02-25','1992-09-10',11),(11,'Gabriel Santos','999.888.777-66','11976543210','gs@gmail.com','2024-01-12','2024-01-14','2000-11-05',12),(12,'Claudia Menezes','888.999.111-22','11965434567','claudia@mail.com','2024-02-18','2024-02-20','1980-06-21',13);
/*!40000 ALTER TABLE `doadores` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `especies`
--

DROP TABLE IF EXISTS `especies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `especies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome_especie` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `especies`
--

LOCK TABLES `especies` WRITE;
/*!40000 ALTER TABLE `especies` DISABLE KEYS */;
INSERT INTO `especies` VALUES (1,'Gato'),(2,'Cachorro');
/*!40000 ALTER TABLE `especies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `login` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `telefone` char(15) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `login`
--

LOCK TABLES `login` WRITE;
/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `login` VALUES (1,'marcia_santos','marcia@gmail.com','11987654321','senha123'),(2,'joao_paz','joao@hotmail.com','11966554433','seguro321'),(3,'carolzinha','carol@yahoo.com','11999887766','abc123'),(4,'doador_vet','vet@mail.com','11955554444','vet321'),(5,'admin_miau','admin@miau.com','11944443333','admin123'),(6,'luiz_oliveira','luiz@mail.com','11944332211','l123'),(7,'marta_freitas','marta@mail.com','11955668844','mf321'),(8,'paulo_silva','paulo@gmail.com','11966778899','ps987'),(9,'ana_lima','ana@hotmail.com','11977889900','al123'),(10,'ricardo_souza','ricardo@yahoo.com','11988990011','rs321'),(11,'aline_cruz','aline@mail.com','11999881122','ac987'),(12,'gabriel_santos','gs@gmail.com','11976543210','gs432'),(13,'claudia_menezes','claudia@mail.com','11965434567','cm998'),(14,'roberto_esteves','roberto@outlook.com','11999884422','re123'),(15,'patricia_monteiro','patricia@gmail.com','11988776655','pm2024');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pets`
--

DROP TABLE IF EXISTS `pets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pets` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(255) DEFAULT NULL,
  `raca` varchar(255) DEFAULT NULL,
  `idade` int DEFAULT NULL,
  `porte` enum('pequeno','médio','grande') DEFAULT NULL,
  `sexo` enum('F','M') DEFAULT NULL,
  `disponibilidade` enum('Disponível','Adotado') DEFAULT NULL,
  `fotos` varchar(255) DEFAULT NULL,
  `cor` varchar(255) DEFAULT NULL,
  `vacinado` tinyint(1) DEFAULT NULL,
  `qtd_doses` tinyint DEFAULT NULL,
  `dt_registro` date DEFAULT NULL,
  `castrado` tinyint(1) DEFAULT NULL,
  `descricao` text,
  `fk_especie` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_especie` (`fk_especie`),
  CONSTRAINT `pets_ibfk_1` FOREIGN KEY (`fk_especie`) REFERENCES `especies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=41 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pets`
--

LOCK TABLES `pets` WRITE;
/*!40000 ALTER TABLE `pets` DISABLE KEYS */;
INSERT INTO `pets` VALUES (1,'Mingau','SRD',2,'pequeno','M','Disponível','mingau.jpg','Branco',1,2,'2024-01-15',1,'Calmo e ótimo para apartamentos.',1),(2,'Luna','Persa',1,'pequeno','F','Disponível','luna.jpg','Cinza',1,1,'2024-02-10',0,'Carinhosa e brincalhona.',1),(3,'Nina','Siamês',3,'pequeno','F','Disponível','nina.jpg','Bege',1,2,'2024-03-03',1,'Elegante e comunicativa.',1),(4,'Bartolomeu','Angorá',4,'pequeno','M','Disponível','bart.jpg','Branco',0,0,'2024-02-20',0,'Muito dócil.',1),(5,'Pretinha','SRD',1,'pequeno','F','Disponível','pretinha.jpg','Preta',1,1,'2024-02-14',0,'Fofa e carente.',1),(6,'Garfield','Exótico',5,'pequeno','M','Disponível','garfield.jpg','Laranja',1,2,'2024-02-02',1,'Famoso por comer muito.',1),(7,'Zelda','Bengal',3,'pequeno','F','Disponível','zelda.jpg','Rajada',1,2,'2024-03-09',1,'Energética e curiosa.',1),(8,'Tom','Azul Russo',2,'pequeno','M','Disponível','tom.jpg','Cinza',1,1,'2024-02-27',0,'Sério e calmo.',1),(9,'Mimi','SRD',2,'pequeno','F','Disponível','mimi.jpg','Marrom',1,2,'2024-01-19',1,'Muito dócil.',1),(10,'Felix','SRD',3,'pequeno','M','Disponível','felix.jpg','Preto e branco',1,2,'2024-03-12',1,'Muito sociável.',1),(11,'Sushi','Siamês',1,'pequeno','M','Disponível','sushi.jpg','Bege',1,1,'2024-03-08',0,'Ativo e esperto.',1),(12,'Jade','Persa',4,'pequeno','F','Disponível','jade.jpg','Cinza claro',1,3,'2024-02-25',1,'Muito tranquila.',1),(13,'Lola','SRD',2,'pequeno','F','Disponível','lola.jpg','Caramelo',1,1,'2024-02-10',0,'Carinhosa.',1),(14,'Pixel','Bengal',1,'pequeno','M','Disponível','pixel.jpg','Rajado',1,1,'2024-03-11',0,'Agitado.',1),(15,'Chicó','SRD',5,'pequeno','M','Disponível','chico.jpg','Cinza',1,2,'2024-01-10',1,'Quieto e amigável.',1),(16,'Safira','Azul Russo',3,'pequeno','F','Disponível','safira.jpg','Cinza',1,2,'2024-02-18',1,'Elegante.',1),(17,'Tigrinho','SRD',1,'pequeno','M','Disponível','tigrinho.jpg','Tigrado',0,0,'2024-03-10',0,'Muito brincalhão.',1),(18,'Amora','SRD',2,'pequeno','F','Disponível','amora.jpg','Preta',1,1,'2024-02-21',1,'Muito amorosa.',1),(19,'Pudim','Exótico',4,'pequeno','M','Disponível','pudim.jpg','Bege',1,2,'2024-02-07',1,'Calmo.',1),(20,'Fumaça','SRD',3,'pequeno','M','Disponível','fumaca_g.jpg','Cinza escuro',1,2,'2024-01-29',1,'Sossegado.',1),(21,'Thor','Labrador',3,'grande','M','Disponível','thor.jpg','Amarelo',1,3,'2024-03-05',1,'Cheio de energia.',2),(22,'Belinha','Poodle',4,'médio','F','Disponível','belinha.jpg','Branca',1,3,'2024-01-22',1,'Carinhosa e obediente.',2),(23,'Rufus','Vira-Lata',5,'médio','M','Disponível','rufus.jpg','Caramelo',1,2,'2024-01-18',1,'Brincalhão.',2),(24,'Bob','Beagle',2,'médio','M','Disponível','bob.jpg','Tri-color',1,2,'2024-02-12',0,'Curioso.',2),(25,'Meg','Husky',1,'grande','F','Disponível','meg.jpg','Cinza',1,1,'2024-03-01',0,'Muito ativa.',2),(26,'Toby','Golden Retriever',4,'grande','M','Disponível','toby.jpg','Dourado',1,3,'2024-01-30',1,'Gentil.',2),(27,'Spike','Bulldog',6,'médio','M','Disponível','spike.jpg','Branco',1,3,'2024-03-05',1,'Bravo mas amoroso.',2),(28,'Lili','Shih Tzu',4,'pequeno','F','Disponível','lili.jpg','Marrom',1,2,'2024-02-19',1,'Companheira.',2),(29,'Cookie','Corgi',2,'médio','F','Disponível','cookie.jpg','Caramelo',1,1,'2024-03-01',0,'Perna-curta vibe.',2),(30,'Max','Pastor Alemão',5,'grande','M','Disponível','max.jpg','Marrom e preto',1,3,'2024-01-15',1,'Protetor.',2),(31,'Duke','Rottweiler',4,'grande','M','Disponível','duke.jpg','Preto e marrom',1,3,'2024-02-12',1,'Forte e leal.',2),(32,'Molly','Border Collie',1,'médio','F','Disponível','molly.jpg','Preto e branco',1,1,'2024-03-02',0,'Inteligente.',2),(33,'Nina','Vira-Lata',3,'médio','F','Disponível','nina_c.jpg','Caramelo',1,2,'2024-02-10',1,'Muito dócil.',2),(34,'Fred','Labrador',2,'grande','M','Disponível','fred.jpg','Chocolate',1,2,'2024-02-28',0,'Companheiro.',2),(35,'Lady','Poodle',6,'pequeno','F','Disponível','lady.jpg','Branca',1,3,'2024-01-05',1,'Carinhosa.',2),(36,'Bolt','Husky',1,'grande','M','Disponível','bolt.jpg','Preto e branco',1,1,'2024-03-11',0,'Muito agitado.',2),(37,'Samantha','SRD',4,'médio','F','Disponível','sam.jpg','Preta',1,2,'2024-02-16',1,'Muito fiel.',2),(38,'Pirata','SRD',3,'médio','M','Disponível','pirata.jpg','Marrom',1,1,'2024-03-01',0,'Um olho só.',2),(39,'Bidu','Lulu da Pomerânia',2,'pequeno','M','Disponível','bidu.jpg','Bege',1,2,'2024-02-18',1,'Fofo demais.',2),(40,'Nala','Vira-Lata',5,'médio','F','Disponível','nala.jpg','Preta e branca',1,3,'2024-01-21',1,'Calma e amável.',2);
/*!40000 ALTER TABLE `pets` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-04 21:38:57