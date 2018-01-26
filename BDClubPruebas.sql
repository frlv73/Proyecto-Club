CREATE DATABASE  IF NOT EXISTS `club` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `club`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: club
-- ------------------------------------------------------
-- Server version	5.7.20-log

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
-- Table structure for table `actividades`
--

DROP TABLE IF EXISTS `actividades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `actividades` (
  `id_actividad` int(11) NOT NULL,
  `descripción` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  `costo` double DEFAULT NULL,
  PRIMARY KEY (`id_actividad`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividades`
--

LOCK TABLES `actividades` WRITE;
/*!40000 ALTER TABLE `actividades` DISABLE KEYS */;
/*!40000 ALTER TABLE `actividades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `adicionales`
--

DROP TABLE IF EXISTS `adicionales`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `adicionales` (
  `id_adicional` int(11) NOT NULL,
  `costo_adicional` double NOT NULL,
  `unidad` varchar(45) NOT NULL,
  PRIMARY KEY (`id_adicional`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `adicionales`
--

LOCK TABLES `adicionales` WRITE;
/*!40000 ALTER TABLE `adicionales` DISABLE KEYS */;
/*!40000 ALTER TABLE `adicionales` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categorias`
--

DROP TABLE IF EXISTS `categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categorias` (
  `id_categoria` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`id_categoria`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categorias`
--

LOCK TABLES `categorias` WRITE;
/*!40000 ALTER TABLE `categorias` DISABLE KEYS */;
INSERT INTO `categorias` VALUES (1,'Activo',NULL),(2,'Cadete',NULL),(3,'Menor',NULL),(4,'Infante',NULL),(5,'Licencia Activo',NULL),(6,'Deportivo',NULL),(7,'Jubilado',NULL),(8,'Becado',NULL);
/*!40000 ALTER TABLE `categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `costo_cuotas`
--

DROP TABLE IF EXISTS `costo_cuotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `costo_cuotas` (
  `id_cuota` int(11) NOT NULL,
  `fecha_validez` date NOT NULL,
  `valor` double NOT NULL,
  PRIMARY KEY (`id_cuota`,`fecha_validez`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `costo_cuotas`
--

LOCK TABLES `costo_cuotas` WRITE;
/*!40000 ALTER TABLE `costo_cuotas` DISABLE KEYS */;
/*!40000 ALTER TABLE `costo_cuotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuotas`
--

DROP TABLE IF EXISTS `cuotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cuotas` (
  `idcuota` int(11) NOT NULL,
  `id_socio` int(11) NOT NULL,
  `mes` varchar(45) NOT NULL,
  `año` varchar(45) NOT NULL,
  `fecha_vto` date NOT NULL,
  `fecha_pago` date DEFAULT NULL,
  `importe` double DEFAULT NULL,
  PRIMARY KEY (`mes`,`año`),
  KEY `fk_idsocio_cuota_idx` (`id_socio`),
  KEY `fk_id_cuota_soc_idx` (`idcuota`),
  KEY `fk_id_socio_cuota_idx` (`id_socio`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuotas`
--

LOCK TABLES `cuotas` WRITE;
/*!40000 ALTER TABLE `cuotas` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `descuentos`
--

DROP TABLE IF EXISTS `descuentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `descuentos` (
  `id_descuento` int(11) NOT NULL,
  `descuento_gpo_fliar` double NOT NULL,
  `fecha_validez` date NOT NULL,
  PRIMARY KEY (`id_descuento`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `descuentos`
--

LOCK TABLES `descuentos` WRITE;
/*!40000 ALTER TABLE `descuentos` DISABLE KEYS */;
/*!40000 ALTER TABLE `descuentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dtos_categorias`
--

DROP TABLE IF EXISTS `dtos_categorias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dtos_categorias` (
  `iddtos_categorias` int(11) NOT NULL,
  `fecha_validez` date NOT NULL,
  `porcentaje` float NOT NULL,
  PRIMARY KEY (`iddtos_categorias`,`fecha_validez`),
  CONSTRAINT `fk_idcategoria` FOREIGN KEY (`iddtos_categorias`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dtos_categorias`
--

LOCK TABLES `dtos_categorias` WRITE;
/*!40000 ALTER TABLE `dtos_categorias` DISABLE KEYS */;
/*!40000 ALTER TABLE `dtos_categorias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `empleados`
--

DROP TABLE IF EXISTS `empleados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `empleados` (
  `id_empleado` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `contrasenia` varchar(45) DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  PRIMARY KEY (`id_empleado`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empleados`
--

LOCK TABLES `empleados` WRITE;
/*!40000 ALTER TABLE `empleados` DISABLE KEYS */;
/*!40000 ALTER TABLE `empleados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscripciones`
--

DROP TABLE IF EXISTS `inscripciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscripciones` (
  `id_inscripcion` int(11) NOT NULL,
  `id_socio` int(11) NOT NULL,
  `id_actividad` int(11) NOT NULL,
  `hora_ini` time NOT NULL,
  `dia_semana` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_inscripcion`),
  KEY `fk_idsocio_insc_idx` (`id_socio`),
  KEY `fk_idactiv_insc_idx` (`id_actividad`),
  CONSTRAINT `fk_idactiv_insc` FOREIGN KEY (`id_actividad`) REFERENCES `actividades` (`id_actividad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idsocio_insc` FOREIGN KEY (`id_socio`) REFERENCES `socios` (`id_socio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscripciones`
--

LOCK TABLES `inscripciones` WRITE;
/*!40000 ALTER TABLE `inscripciones` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscripciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instalaciones`
--

DROP TABLE IF EXISTS `instalaciones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instalaciones` (
  `id_instalacion` int(11) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `estado` varchar(45) DEFAULT NULL,
  `fecha_baja` date DEFAULT NULL,
  `id_adicional` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_instalacion`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instalaciones`
--

LOCK TABLES `instalaciones` WRITE;
/*!40000 ALTER TABLE `instalaciones` DISABLE KEYS */;
INSERT INTO `instalaciones` VALUES (1,'Cancha Tenis 1',NULL,NULL,NULL),(2,'Cancha Tenis 2',NULL,NULL,NULL),(3,'Cancha Tenis 3',NULL,NULL,NULL),(4,'Cancha Fútbol 1',NULL,NULL,NULL),(5,'Cancha Fútbol Cinco',NULL,NULL,NULL),(6,'Salón',NULL,NULL,NULL),(7,'Cancha Voley 1',NULL,NULL,NULL);
/*!40000 ALTER TABLE `instalaciones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recargos`
--

DROP TABLE IF EXISTS `recargos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `recargos` (
  `id_recargo` int(11) NOT NULL,
  `valor_recargo` double NOT NULL,
  `fecha_validez` date NOT NULL,
  PRIMARY KEY (`id_recargo`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recargos`
--

LOCK TABLES `recargos` WRITE;
/*!40000 ALTER TABLE `recargos` DISABLE KEYS */;
/*!40000 ALTER TABLE `recargos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reservas` (
  `id_reserva` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora_ini` time NOT NULL,
  `duracion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `id_socio` int(11) NOT NULL,
  `id_instalacion` int(11) NOT NULL,
  `estado` varchar(45) NOT NULL,
  PRIMARY KEY (`id_reserva`),
  KEY `fk_idsocio_idx` (`id_socio`),
  KEY `fk_idinstalacion_idx` (`id_instalacion`),
  CONSTRAINT `fk_idinstalacion_res` FOREIGN KEY (`id_instalacion`) REFERENCES `instalaciones` (`id_instalacion`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_idsocio_res` FOREIGN KEY (`id_socio`) REFERENCES `socios` (`id_socio`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `socios`
--

DROP TABLE IF EXISTS `socios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `socios` (
  `id_socio` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `usuario` varchar(45) DEFAULT NULL,
  `estado` varchar(45) NOT NULL DEFAULT 'Activo',
  `id_categoria_socio` int(11) NOT NULL,
  PRIMARY KEY (`id_socio`,`dni`),
  KEY `id_categoria_idx` (`id_categoria_socio`),
  CONSTRAINT `fk_id_categoria` FOREIGN KEY (`id_categoria_socio`) REFERENCES `categorias` (`id_categoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `socios`
--

LOCK TABLES `socios` WRITE;
/*!40000 ALTER TABLE `socios` DISABLE KEYS */;
INSERT INTO `socios` VALUES (1,4234242,'Socio','Prueba','Calle Falsa 123','3213213','socio@gmail.com','1234',NULL,'Activo',1);
/*!40000 ALTER TABLE `socios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-01-25 22:39:41
