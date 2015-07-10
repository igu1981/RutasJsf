-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.1.47-community


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema rutas
--

CREATE DATABASE IF NOT EXISTS rutas;
USE rutas;

--
-- Definition of table `concejo`
--

DROP TABLE IF EXISTS `concejo`;
CREATE TABLE `concejo` (
  `concejoid` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  PRIMARY KEY (`concejoid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `concejo`
--

/*!40000 ALTER TABLE `concejo` DISABLE KEYS */;
INSERT INTO `concejo` (`concejoid`,`nombre`,`ubicacion`,`descripcion`) VALUES 
 (1,'valdes','valdes','centro ciudad'),
 (2,'gijon','gijon','alrededor  de gijon'),
 (3,'llanes','llanes','hermoso'),
 (5,'somiedo','somiedo','encanto'),
 (6,'potes','potes','hermoso'),
 (7,'pola siero','pola siero','friisimo'),
 (8,'aviles','aviles','normal'),
 (9,'aller','aller','guapisimo');
/*!40000 ALTER TABLE `concejo` ENABLE KEYS */;


--
-- Definition of table `rutas`
--

DROP TABLE IF EXISTS `rutas`;
CREATE TABLE `rutas` (
  `rutasid` int(11) NOT NULL AUTO_INCREMENT,
  `itinerario` varchar(45) NOT NULL,
  `distancia` int(11) NOT NULL,
  `duracion` int(11) NOT NULL,
  `dificultad` varchar(45) NOT NULL,
  `desnivel` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `ubicacion` varchar(45) NOT NULL,
  `descripcion` varchar(45) NOT NULL,
  `discriminador` varchar(45) NOT NULL,
  `concejo_concejoid` int(11) DEFAULT NULL,
  `usuarios_usuariosid` int(11) DEFAULT NULL,
  PRIMARY KEY (`rutasid`),
  KEY `fk_rutas_concejo1_idx` (`concejo_concejoid`),
  KEY `fk_rutas_usuarios1_idx` (`usuarios_usuariosid`),
  CONSTRAINT `fk_rutas_concejo1` FOREIGN KEY (`concejo_concejoid`) REFERENCES `concejo` (`concejoid`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_rutas_usuarios1` FOREIGN KEY (`usuarios_usuariosid`) REFERENCES `usuarios` (`usuariosid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rutas`
--

/*!40000 ALTER TABLE `rutas` DISABLE KEYS */;
INSERT INTO `rutas` (`rutasid`,`itinerario`,`distancia`,`duracion`,`dificultad`,`desnivel`,`fecha`,`ubicacion`,`descripcion`,`discriminador`,`concejo_concejoid`,`usuarios_usuariosid`) VALUES 
 (1,'valdes',8,2,'facil',250,'2015-09-12','valdes','facil de realizar','caminando',1,1),
 (2,'gijon',4,1,'facil',400,'2015-10-01','gijon','facil de realizar','caminando',2,3),
 (3,'siero',9,2,'media',350,'2015-09-25','siero','bonita','caminando',7,2),
 (4,'potes',10,3,'dificil',250,'2015-12-12','potes','previo entrenamiento','costera',6,1),
 (5,'llanes',5,1,'facil',100,'2015-08-15','llanes','facil de realizar','costera',3,2),
 (6,'gijon',15,3,'dificil',700,'2015-10-22','gijon','previo entrenamiento','trail',2,3),
 (7,'somiendo',20,4,'media',600,'2015-11-02','somiedo','previo entrenamiento','trail',5,3),
 (8,'aller',16,3,'facil',350,'2015-09-12','aller','previo entrenamiento','trail',9,2),
 (9,'aviles',6,1,'facil',220,'2015-07-18','aviles','facil de realizar','costera',8,1),
 (10,'villaviciosa',3,1,'media',100,'2015-08-22','villaviciosa','facil de realizar','caminando',2,2),
 (11,'someido',11,2,'media',460,'2015-07-22','somiedo','previo entrenamiento','trail',5,1),
 (13,'oviedo',13,0,'Facil',400,'2015-07-09','oviedo','facil de realizar','caminando',NULL,NULL),
 (14,'grado',5,0,'Facil',200,'2015-07-14','grado','facil de realizar','caminando',NULL,NULL),
 (15,'luarca',0,0,'Facil',0,'2015-07-23','luarca','muy bonita','caminando',NULL,NULL);
/*!40000 ALTER TABLE `rutas` ENABLE KEYS */;


--
-- Definition of table `rutascaminado`
--

DROP TABLE IF EXISTS `rutascaminado`;
CREATE TABLE `rutascaminado` (
  `rutasid` int(11) NOT NULL AUTO_INCREMENT,
  `tipoCalzado` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`rutasid`),
  CONSTRAINT `fk_rutasCaminado_rutas` FOREIGN KEY (`rutasid`) REFERENCES `rutas` (`rutasid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rutascaminado`
--

/*!40000 ALTER TABLE `rutascaminado` DISABLE KEYS */;
INSERT INTO `rutascaminado` (`rutasid`,`tipoCalzado`) VALUES 
 (1,'zapatillas'),
 (2,'zapatillas'),
 (3,'zapatillas,botas'),
 (10,'zapatillas'),
 (13,NULL),
 (14,NULL),
 (15,NULL);
/*!40000 ALTER TABLE `rutascaminado` ENABLE KEYS */;


--
-- Definition of table `rutascosteras`
--

DROP TABLE IF EXISTS `rutascosteras`;
CREATE TABLE `rutascosteras` (
  `rutasid` int(11) NOT NULL AUTO_INCREMENT,
  `tipoCalzado` varchar(45) NOT NULL,
  PRIMARY KEY (`rutasid`),
  CONSTRAINT `fk_rutasCosteras_rutas1` FOREIGN KEY (`rutasid`) REFERENCES `rutas` (`rutasid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rutascosteras`
--

/*!40000 ALTER TABLE `rutascosteras` DISABLE KEYS */;
INSERT INTO `rutascosteras` (`rutasid`,`tipoCalzado`) VALUES 
 (4,'zapatilas'),
 (5,'zapatillas'),
 (9,'zapatillas,botas');
/*!40000 ALTER TABLE `rutascosteras` ENABLE KEYS */;


--
-- Definition of table `rutastrail`
--

DROP TABLE IF EXISTS `rutastrail`;
CREATE TABLE `rutastrail` (
  `rutasid` int(11) NOT NULL AUTO_INCREMENT,
  `tipoCalzado` varchar(45) NOT NULL,
  PRIMARY KEY (`rutasid`),
  CONSTRAINT `fk_rutasTrail_rutas1` FOREIGN KEY (`rutasid`) REFERENCES `rutas` (`rutasid`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `rutastrail`
--

/*!40000 ALTER TABLE `rutastrail` DISABLE KEYS */;
INSERT INTO `rutastrail` (`rutasid`,`tipoCalzado`) VALUES 
 (6,'zapatillas de montaña'),
 (7,'zapatillas de montaña'),
 (8,'zapatillas de montaña'),
 (11,'zapatillas de montaña');
/*!40000 ALTER TABLE `rutastrail` ENABLE KEYS */;


--
-- Definition of table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
CREATE TABLE `usuarios` (
  `usuariosid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`usuariosid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

--
-- Dumping data for table `usuarios`
--

/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`usuariosid`,`username`,`password`) VALUES 
 (1,'ivan','admin'),
 (2,'alberto','alberto'),
 (3,'jose','jose');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;




/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
