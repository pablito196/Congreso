-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         5.5.27-log - MySQL Community Server (GPL)
-- SO del servidor:              Win64
-- HeidiSQL Versión:             9.4.0.5142
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Volcando estructura de base de datos para congreso
DROP DATABASE IF EXISTS `congreso`;
CREATE DATABASE IF NOT EXISTS `congreso` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `congreso`;

-- Volcando estructura para tabla congreso.evento
DROP TABLE IF EXISTS `evento`;
CREATE TABLE IF NOT EXISTS `evento` (
  `IdEvento` int(11) NOT NULL AUTO_INCREMENT,
  `NombreEvento` varchar(500) DEFAULT NULL,
  `Lugar` varchar(500) DEFAULT NULL,
  `FechaInicio` datetime DEFAULT NULL,
  `FechaFin` datetime DEFAULT NULL,
  `Costo` decimal(11,2) DEFAULT NULL,
  `Descripcion` varchar(500) DEFAULT NULL,
  `Seleccionado` bit(1) DEFAULT NULL,
  PRIMARY KEY (`IdEvento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.evento: ~1 rows (aproximadamente)
DELETE FROM `evento`;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` (`IdEvento`, `NombreEvento`, `Lugar`, `FechaInicio`, `FechaFin`, `Costo`, `Descripcion`, `Seleccionado`) VALUES
	(1, 'Congreso de jóvenes', 'Villa Bolivariana', '2018-01-27 00:00:00', NULL, 100.00, 'Primer Congreso', NULL);
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;

-- Volcando estructura para tabla congreso.eventoparticipante
DROP TABLE IF EXISTS `eventoparticipante`;
CREATE TABLE IF NOT EXISTS `eventoparticipante` (
  `IdEventoParticipante` int(11) NOT NULL AUTO_INCREMENT,
  `IdEvento` int(11) DEFAULT NULL,
  `IdParticipante` int(11) DEFAULT NULL,
  `IdMonitor` int(11) DEFAULT NULL,
  `FechaRegistro` datetime DEFAULT NULL,
  PRIMARY KEY (`IdEventoParticipante`),
  KEY `IdEvento` (`IdEvento`),
  KEY `IdParticipante` (`IdParticipante`),
  KEY `IdMonitor` (`IdMonitor`),
  CONSTRAINT `eventoparticipante_monitor_fk` FOREIGN KEY (`IdMonitor`) REFERENCES `monitor` (`IdMonitor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `eventoparticipante_evento_fk` FOREIGN KEY (`IdEvento`) REFERENCES `evento` (`IdEvento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `eventoparticipante_participante_fk` FOREIGN KEY (`IdParticipante`) REFERENCES `participante` (`IdParticipante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.eventoparticipante: ~0 rows (aproximadamente)
DELETE FROM `eventoparticipante`;
/*!40000 ALTER TABLE `eventoparticipante` DISABLE KEYS */;
/*!40000 ALTER TABLE `eventoparticipante` ENABLE KEYS */;

-- Volcando estructura para tabla congreso.monitor
DROP TABLE IF EXISTS `monitor`;
CREATE TABLE IF NOT EXISTS `monitor` (
  `IdMonitor` int(11) NOT NULL AUTO_INCREMENT,
  `CI` varchar(10) DEFAULT NULL,
  `NombreMonitor` varchar(500) DEFAULT NULL,
  `Institucion` varchar(500) DEFAULT NULL,
  `Direccion` varchar(300) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`IdMonitor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.monitor: ~0 rows (aproximadamente)
DELETE FROM `monitor`;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;

-- Volcando estructura para tabla congreso.pago
DROP TABLE IF EXISTS `pago`;
CREATE TABLE IF NOT EXISTS `pago` (
  `IdPago` int(11) NOT NULL AUTO_INCREMENT,
  `IdEventoParticipante` int(11) DEFAULT NULL,
  `Fecha` datetime DEFAULT NULL,
  `MontoPagado` decimal(11,2) DEFAULT NULL,
  `Saldo` decimal(11,2) DEFAULT NULL,
  PRIMARY KEY (`IdPago`),
  KEY `IdEventoParticipante` (`IdEventoParticipante`),
  CONSTRAINT `pago_eventoparticipante_fk` FOREIGN KEY (`IdEventoParticipante`) REFERENCES `eventoparticipante` (`IdEventoParticipante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.pago: ~0 rows (aproximadamente)
DELETE FROM `pago`;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;

-- Volcando estructura para procedimiento congreso.PaInsertarEvento
DROP PROCEDURE IF EXISTS `PaInsertarEvento`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaInsertarEvento`(
	IN _NombreEvento varchar(500),
	IN _Lugar varchar(500),
	IN _Fecha datetime,
	IN _Costo decimal(11,2),
	IN _Descripcion varchar(500)
)
BEGIN
	insert into Evento (NombreEvento,Lugar,Fecha,Costo,Descripcion) values (_NombreEvento,_Lugar,_Fecha,_Costo,_Descripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaInsertarMonitor
DROP PROCEDURE IF EXISTS `PaInsertarMonitor`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaInsertarMonitor`(
	IN _Ci varchar(10),
	IN _NombreMonitor varchar(500),
	IN _Direccion varchar(300),
	IN _Institucion varchar(300),
	IN _Telefono varchar(15)
)
BEGIN
	INSERT INTO monitor (CI,NombreMonitor,Direccion,Institucion,Telefono)
	values (_Ci,_NombreMonitor,_Direccion,_Institucion,_Telefono);
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaInsertarParticipante
DROP PROCEDURE IF EXISTS `PaInsertarParticipante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaInsertarParticipante`(
	IN _Ci varchar(10),
	IN _NombreParticipante varchar(500),
	IN _Ciudad varchar(50),
	IN _CorreoElectronico varchar(300),
	IN _Direccion varchar(150),
	IN _Institucion varchar(500),
	IN _Telefono varchar(15)
)
BEGIN
	INSERT INTO participante(CI,NombreParticipante,Ciudad,CorreoElectronico,
							Direccion,Institucion,Telefono) 
			values (_Ci,_NombreParticipante,_Ciudad,_CorreoElectronico,
							_Direccion,_Institucion,_Telefono);
	SELECT LAST_INSERT_ID();
END//
DELIMITER ;

-- Volcando estructura para tabla congreso.participante
DROP TABLE IF EXISTS `participante`;
CREATE TABLE IF NOT EXISTS `participante` (
  `IdParticipante` int(11) NOT NULL AUTO_INCREMENT,
  `CI` varchar(10) DEFAULT NULL,
  `NombreParticipante` varchar(500) DEFAULT NULL,
  `Ciudad` varchar(50) DEFAULT NULL,
  `Direccion` varchar(150) DEFAULT NULL,
  `CorreoElectronico` varchar(300) DEFAULT NULL,
  `Telefono` varchar(15) DEFAULT NULL,
  `Institucion` varchar(500) DEFAULT NULL,
  `NumeroHabitacion` varchar(10) DEFAULT NULL,
  `Observaciones` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`IdParticipante`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.participante: ~0 rows (aproximadamente)
DELETE FROM `participante`;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
