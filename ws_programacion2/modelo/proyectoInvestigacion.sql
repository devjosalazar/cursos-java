CREATE DATABASE  IF NOT EXISTS `bdproyectoinvestigacion` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `bdproyectoinvestigacion`;
-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: bdproyectoinvestigacion
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `investigador`
--

DROP TABLE IF EXISTS `investigador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `investigador` (
  `idInvestigador` int NOT NULL,
  `Postgrado_idPostgrado` int NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `universidad` varchar(40) NOT NULL,
  `direccion` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL,
  PRIMARY KEY (`idInvestigador`),
  KEY `fk_postgrado` (`Postgrado_idPostgrado`),
  CONSTRAINT `fk_postgrado` FOREIGN KEY (`Postgrado_idPostgrado`) REFERENCES `postgrado` (`idPostgrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `investigador`
--

LOCK TABLES `investigador` WRITE;
/*!40000 ALTER TABLE `investigador` DISABLE KEYS */;
INSERT INTO `investigador` VALUES (1,1,'Carolina Gomez','Universidad del Quindio','Cra 12 # 45-10','caro24@hotmail.com'),(2,3,'Carolina Gomez','Universidad del Quindio','Cra 14 # 14-40','csanchez@gmail.com'),(3,4,'Carolina Gomez','Universidad del Cauca','Ed. Santa Monica Apto 202','mangelri@yahoo.es'),(4,3,'Andrea Zapata','Universidad del Cauca','Calle 25 # 111111-10','andreazapata@unicauca.edu.co'),(5,4,'manuel Gomez','Universidad EAFIT','Cra 20 # 12-12','manuelfergo@hotmail.com');
/*!40000 ALTER TABLE `investigador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `participante` (
  `idParticipante` int NOT NULL,
  `Rol_idRol` int NOT NULL,
  `Investigador_idInvestigador` int NOT NULL,
  `Proyecto_idProyecto` int NOT NULL,
  PRIMARY KEY (`idParticipante`),
  KEY `fk_rol` (`Rol_idRol`),
  KEY `fk_investigador` (`Investigador_idInvestigador`),
  KEY `fk_proyecto` (`Proyecto_idProyecto`),
  CONSTRAINT `fk_investigador` FOREIGN KEY (`Investigador_idInvestigador`) REFERENCES `investigador` (`idInvestigador`),
  CONSTRAINT `fk_proyecto` FOREIGN KEY (`Proyecto_idProyecto`) REFERENCES `proyecto` (`idProyecto`),
  CONSTRAINT `fk_rol` FOREIGN KEY (`Rol_idRol`) REFERENCES `rol` (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` VALUES (1,1,1,1),(2,1,2,3),(3,1,5,4),(4,2,3,2),(5,2,4,2),(6,2,1,1);
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `postgrado`
--

DROP TABLE IF EXISTS `postgrado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `postgrado` (
  `idPostgrado` int NOT NULL,
  `nombre` varchar(90) DEFAULT NULL,
  PRIMARY KEY (`idPostgrado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `postgrado`
--

LOCK TABLES `postgrado` WRITE;
/*!40000 ALTER TABLE `postgrado` DISABLE KEYS */;
INSERT INTO `postgrado` VALUES (1,'Especialización'),(2,'Maestría'),(3,'Doctorado'),(4,'PostDoctorado');
/*!40000 ALTER TABLE `postgrado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proyecto`
--

DROP TABLE IF EXISTS `proyecto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proyecto` (
  `idProyecto` int NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `totalPresupuesto` double(15,2) NOT NULL,
  `fechaInicio` date NOT NULL,
  `fechaFin` date NOT NULL,
  PRIMARY KEY (`idProyecto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proyecto`
--

LOCK TABLES `proyecto` WRITE;
/*!40000 ALTER TABLE `proyecto` DISABLE KEYS */;
INSERT INTO `proyecto` VALUES (1,'Colaboratorio de usabilidad',12000000.00,'2009-12-01','2018-12-01'),(2,'Laboratorio robótica',12000000.00,'2010-12-01','2018-12-01'),(3,'Red de alta velocidad RENATA',13000000.00,'2007-01-01','2009-01-01'),(4,'Componentes para realidad aumentada',13000000.00,'2008-01-01','2009-01-01');
/*!40000 ALTER TABLE `proyecto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `rol` (
  `idRol` int NOT NULL,
  `descripcion` varchar(40) NOT NULL,
  PRIMARY KEY (`idRol`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'Auxiliar'),(2,'Coinvestigador'),(3,'Investigador principal'),(4,'Joven investigador');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-07  9:04:23
