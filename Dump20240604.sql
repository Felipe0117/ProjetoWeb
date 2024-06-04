CREATE DATABASE  IF NOT EXISTS `mercadoweb` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `mercadoweb`;
-- MySQL dump 10.13  Distrib 5.6.23, for Win64 (x86_64)
--
-- Host: localhost    Database: mercadoweb
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.24-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `carrinho`
--

DROP TABLE IF EXISTS `carrinho`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `carrinho` (
  `id_carrinho` int(11) NOT NULL AUTO_INCREMENT,
  `nome_produto_carrinho` varchar(255) DEFAULT NULL,
  `valor_produto_carrinho` float(8,2) DEFAULT NULL,
  `imagem_produto_carrinho` longblob DEFAULT NULL,
  `descricao_produto_carrinho` varchar(999) DEFAULT NULL,
  `quantidadecarrinho` int(11) DEFAULT NULL,
  `valor_produtos_total` float DEFAULT NULL,
  `total` float DEFAULT NULL,
  `produto_id3` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_carrinho`),
  KEY `produto_id3` (`produto_id3`),
  CONSTRAINT `carrinho_ibfk_1` FOREIGN KEY (`produto_id3`) REFERENCES `produtos` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `carrinho`
--

LOCK TABLES `carrinho` WRITE;
/*!40000 ALTER TABLE `carrinho` DISABLE KEYS */;
/*!40000 ALTER TABLE `carrinho` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Celulares'),(2,'Monitores'),(3,'Peças'),(4,'Acessórios'),(5,'Gabinetes'),(6,'Cadeiras'),(7,'Headsets');
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `enderecos`
--

DROP TABLE IF EXISTS `enderecos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `enderecos` (
  `id_endereco` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id1` int(11) DEFAULT NULL,
  `rua` varchar(75) NOT NULL,
  `numero` int(11) NOT NULL,
  `cep` char(9) NOT NULL,
  `complemento` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`id_endereco`),
  KEY `usuario_id1` (`usuario_id1`),
  CONSTRAINT `usuario_id1` FOREIGN KEY (`usuario_id1`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `enderecos`
--

LOCK TABLES `enderecos` WRITE;
/*!40000 ALTER TABLE `enderecos` DISABLE KEYS */;
/*!40000 ALTER TABLE `enderecos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `estoque` (
  `id_estoque` int(11) NOT NULL AUTO_INCREMENT,
  `produto_id2` int(11) DEFAULT NULL,
  `quantidade_estoque` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_estoque`),
  KEY `produto_id2` (`produto_id2`),
  CONSTRAINT `produto_id2` FOREIGN KEY (`produto_id2`) REFERENCES `produtos` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos`
--

DROP TABLE IF EXISTS `pedidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos` (
  `id_pedido` int(11) NOT NULL AUTO_INCREMENT,
  `usuario_id2` int(11) DEFAULT NULL,
  `endereco_id` int(11) DEFAULT NULL,
  `status_pagamento` enum('concluido','pendente') DEFAULT 'pendente',
  `metodo_pagamento` enum('pix','debito','credito') NOT NULL,
  `valor_total` float(8,2) DEFAULT NULL,
  `data_hora` datetime DEFAULT NULL,
  PRIMARY KEY (`id_pedido`),
  KEY `usuario_id2` (`usuario_id2`),
  KEY `endereco_id` (`endereco_id`),
  CONSTRAINT `endereco_id` FOREIGN KEY (`endereco_id`) REFERENCES `enderecos` (`id_endereco`),
  CONSTRAINT `usuario_id2` FOREIGN KEY (`usuario_id2`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos`
--

LOCK TABLES `pedidos` WRITE;
/*!40000 ALTER TABLE `pedidos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pedidos_produtos`
--

DROP TABLE IF EXISTS `pedidos_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pedidos_produtos` (
  `id_pedido_produto` int(11) NOT NULL AUTO_INCREMENT,
  `pedido_id` int(11) DEFAULT NULL,
  `produto_id` int(11) DEFAULT NULL,
  `quantidade` tinyint(4) DEFAULT NULL,
  `preco_unitario` float(8,2) DEFAULT NULL,
  PRIMARY KEY (`id_pedido_produto`),
  KEY `pedido_id` (`pedido_id`),
  KEY `produto_id` (`produto_id`),
  CONSTRAINT `pedido_id` FOREIGN KEY (`pedido_id`) REFERENCES `pedidos` (`id_pedido`),
  CONSTRAINT `produto_id` FOREIGN KEY (`produto_id`) REFERENCES `produtos` (`id_produto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pedidos_produtos`
--

LOCK TABLES `pedidos_produtos` WRITE;
/*!40000 ALTER TABLE `pedidos_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `pedidos_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `produtos` (
  `id_produto` int(11) NOT NULL AUTO_INCREMENT,
  `categoria_id` int(11) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `imagem` longblob DEFAULT NULL,
  `valor` float(8,2) DEFAULT NULL,
  `descricao` varchar(999) DEFAULT NULL,
  PRIMARY KEY (`id_produto`),
  KEY `categoria_id` (`categoria_id`),
  CONSTRAINT `categoria_id` FOREIGN KEY (`categoria_id`) REFERENCES `categorias` (`id_categoria`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (1,1,'Samsung Galaxy S23 FE','assets/OIP.jpg',2159.00,'O Galaxy S23 FE é um dos smartphones mais recentes da Samsung. Com design elegante e moderno, uma tela grande e vibrante e um poderoso conjunto de câmeras. Ele é equipado com o processador Octa-Core Exynos 2200, para navegar na web, assistir vídeos, jogar jogos e muito mais sem problemas, 8GB de memória RAM e 128GB de armazenamento interno, que é suficiente para armazenar fotos, vídeos, músicas e outros arquivos. Tudo isso, garante um desempenho rápido e fluido. A tela é infinita Dynamic AMOLED 2X de 6,4\" (158,9mm) com resolução FHD+ (1080x2340), que proporciona imagens nítidas e vibrantes, enquanto a câmera traseira tripla de 50MP + 12MP + 10MP e a câmera frontal de 10MP, permitem tirar fotos e vídeos de alta qualidade com diferentes opções de lentes para capturar diferentes tipos de imagens e postar nas redes sociais. O Galaxy S23 FE também é compatível com a tecnologia 5G, para você aproveitar da velocidade de internet ultrarrápida independente do lugar em que estiver.'),(2,2,'Monitor Gamer AOC 23.8\" Full HD','assets/Ex4.jpg',599.99,'Teste'),(3,4,'Mouse Gamer Logitech G403','assets/Ex3.jpg',209.90,'Teste'),(4,4,'MOUSEPAD GAMER TGT','assets/Ex2.jpg',39.99,'Teste'),(5,4,'Agentes LEGO - JETT Valorant','assets/Ex5.jpg',135.90,'Teste');
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(155) DEFAULT NULL,
  `senha` varchar(45) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `telefone` char(15) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `cpf` char(14) DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `usuario` (`usuario`,`cpf`,`telefone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'mercadoweb'
--

--
-- Dumping routines for database 'mercadoweb'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-06-04 17:18:49
