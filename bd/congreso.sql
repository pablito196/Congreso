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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.evento: ~3 rows (aproximadamente)
DELETE FROM `evento`;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` (`IdEvento`, `NombreEvento`, `Lugar`, `FechaInicio`, `FechaFin`, `Costo`, `Descripcion`, `Seleccionado`) VALUES
	(1, 'Congreso de jóvenes', 'Villa Bolivariana', '2018-01-27 00:00:00', '2018-01-31 00:00:00', 100.00, 'Primer Congreso de jovenes cristianos', b'0'),
	(2, 'Congreso nacional de misiones', 'Villa bolivariana', '2018-01-09 00:00:00', '2018-01-23 00:00:00', 150.00, 'Incluye hospedaje para todos los participantes', b'1'),
	(3, 'Conferencia de misiones Sucre', 'Teatro Gran Mariscal', '2018-01-15 00:00:00', '2018-01-20 00:00:00', 200.00, 'Ninguna', b'0');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;

-- Volcando estructura para tabla congreso.eventoparticipante
DROP TABLE IF EXISTS `eventoparticipante`;
CREATE TABLE IF NOT EXISTS `eventoparticipante` (
  `IdEventoParticipante` int(11) NOT NULL AUTO_INCREMENT,
  `IdEvento` int(11) DEFAULT NULL,
  `IdParticipante` int(11) DEFAULT NULL,
  `IdMonitor` int(11) DEFAULT NULL,
  `FechaRegistro` datetime DEFAULT NULL,
  `NumeroHabitacion` varchar(10) DEFAULT NULL,
  `Observaciones` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`IdEventoParticipante`),
  KEY `IdEvento` (`IdEvento`),
  KEY `IdParticipante` (`IdParticipante`),
  KEY `IdMonitor` (`IdMonitor`),
  CONSTRAINT `eventoparticipante_evento_fk` FOREIGN KEY (`IdEvento`) REFERENCES `evento` (`IdEvento`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `eventoparticipante_monitor_fk` FOREIGN KEY (`IdMonitor`) REFERENCES `monitor` (`IdMonitor`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `eventoparticipante_participante_fk` FOREIGN KEY (`IdParticipante`) REFERENCES `participante` (`IdParticipante`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.eventoparticipante: ~24 rows (aproximadamente)
DELETE FROM `eventoparticipante`;
/*!40000 ALTER TABLE `eventoparticipante` DISABLE KEYS */;
INSERT INTO `eventoparticipante` (`IdEventoParticipante`, `IdEvento`, `IdParticipante`, `IdMonitor`, `FechaRegistro`, `NumeroHabitacion`, `Observaciones`) VALUES
	(3, 1, 3, 2, '2018-01-12 00:00:00', '34', NULL),
	(4, 1, 3, 1, '2018-01-12 00:00:00', '34', 'ninguna'),
	(5, 1, 3, 2, '2018-01-12 00:00:00', '34', 'ninguna'),
	(6, 1, 3, 2, '2018-01-12 00:00:00', '34', 'ninguna'),
	(7, 1, 3, 1, '2018-01-12 00:00:00', '34', 'ninguna'),
	(8, 1, 6, 2, '2018-01-12 00:00:00', '34', 'ninguna1'),
	(9, 1, 6, 1, '2018-01-12 00:00:00', '34', 'ninguna1'),
	(10, 1, 6, 2, '2018-01-13 00:00:00', '34', 'ninguna'),
	(11, 1, 6, 1, '2018-01-13 00:00:00', '34', 'ninguna'),
	(12, 1, 6, 1, '2018-01-13 00:00:00', '12', 'ninguna'),
	(13, 1, 6, 1, '2018-01-13 00:00:00', '34', 'ninguna'),
	(14, 1, 6, 2, '2018-01-13 00:00:00', '34', 'ninguna2'),
	(15, 1, 2, 1, '2018-01-13 00:00:00', '34', 'ninguna'),
	(16, 1, 6, 1, '2018-01-13 00:00:00', '23', 'ninguna2'),
	(17, 1, 2, 1, '2018-01-13 00:00:00', '34', 'ninguna2'),
	(18, 1, 6, 2, '2018-01-13 00:00:00', '34', 'ninguna'),
	(19, 1, 6, 2, '2018-01-13 00:00:00', '43', 'ninguna'),
	(20, 1, 7, 1, '2018-01-13 00:00:00', '35', 'Saldo de 20 Bs.'),
	(21, 2, 7, 2, '2018-01-16 00:00:00', '12', 'Ninguna'),
	(22, 2, 3, 2, '2018-01-16 00:00:00', '2', 'Ninguna'),
	(23, 2, 8, 2, '2018-01-16 00:00:00', '2', 'ninguna'),
	(24, 3, 7, 3, '2018-01-18 00:00:00', '12', ''),
	(25, 1, 9, 2, '2018-01-18 00:00:00', '45', ''),
	(26, 1, 10, 3, '2018-01-18 00:00:00', '12', '');
/*!40000 ALTER TABLE `eventoparticipante` ENABLE KEYS */;

-- Volcando estructura para tabla congreso.gasto
DROP TABLE IF EXISTS `gasto`;
CREATE TABLE IF NOT EXISTS `gasto` (
  `IdGasto` int(11) NOT NULL AUTO_INCREMENT,
  `Concepto` varchar(800) DEFAULT NULL,
  `FechaGasto` datetime DEFAULT NULL,
  `Monto` decimal(11,2) DEFAULT NULL,
  `IdEvento` int(11) DEFAULT NULL,
  PRIMARY KEY (`IdGasto`),
  KEY `IdEvento` (`IdEvento`),
  CONSTRAINT `gasto_evento_fk` FOREIGN KEY (`IdEvento`) REFERENCES `evento` (`IdEvento`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.gasto: ~0 rows (aproximadamente)
DELETE FROM `gasto`;
/*!40000 ALTER TABLE `gasto` DISABLE KEYS */;
/*!40000 ALTER TABLE `gasto` ENABLE KEYS */;

-- Volcando estructura para vista congreso.listaeventoparticipante
DROP VIEW IF EXISTS `listaeventoparticipante`;
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `listaeventoparticipante` (
	`IdEventoParticipante` INT(11) NOT NULL,
	`IdEvento` INT(11) NULL,
	`IdParticipante` INT(11) NULL,
	`IdMonitor` INT(11) NULL,
	`FechaRegistro` DATETIME NULL,
	`NumeroHabitacion` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`Observaciones` VARCHAR(1000) NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Volcando estructura para vista congreso.listaeventos
DROP VIEW IF EXISTS `listaeventos`;
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `listaeventos` (
	`IdEvento` INT(11) NOT NULL,
	`NombreEvento` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`Lugar` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`FechaInicio` DATETIME NULL,
	`FechaFin` DATETIME NULL,
	`Costo` DECIMAL(11,2) NULL,
	`Descripcion` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`Seleccionado` BIT(1) NULL
) ENGINE=MyISAM;

-- Volcando estructura para vista congreso.listamonitores
DROP VIEW IF EXISTS `listamonitores`;
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `listamonitores` (
	`IdMonitor` INT(11) NOT NULL,
	`CI` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`NombreMonitor` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`Institucion` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`Direccion` VARCHAR(300) NULL COLLATE 'utf8_general_ci',
	`Telefono` VARCHAR(15) NULL COLLATE 'utf8_general_ci'
) ENGINE=MyISAM;

-- Volcando estructura para vista congreso.listapagos
DROP VIEW IF EXISTS `listapagos`;
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `listapagos` (
	`IdPago` INT(11) NOT NULL,
	`IdEventoParticipante` INT(11) NULL,
	`Fecha` DATETIME NULL,
	`MontoPagado` DECIMAL(11,2) NULL,
	`Saldo` DECIMAL(11,2) NULL
) ENGINE=MyISAM;

-- Volcando estructura para vista congreso.listaparticipantes
DROP VIEW IF EXISTS `listaparticipantes`;
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `listaparticipantes` (
	`IdParticipante` INT(11) NOT NULL,
	`CI` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`NombreParticipante` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`Ciudad` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`Direccion` VARCHAR(150) NULL COLLATE 'utf8_general_ci',
	`CorreoElectronico` VARCHAR(300) NULL COLLATE 'utf8_general_ci',
	`Telefono` VARCHAR(15) NULL COLLATE 'utf8_general_ci',
	`Institucion` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`EsEliminado` BIT(1) NULL
) ENGINE=MyISAM;

-- Volcando estructura para vista congreso.listaparticipantesevento
DROP VIEW IF EXISTS `listaparticipantesevento`;
-- Creando tabla temporal para superar errores de dependencia de VIEW
CREATE TABLE `listaparticipantesevento` (
	`IdEventoParticipante` INT(11) NOT NULL,
	`CI` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`NombreParticipante` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`Ciudad` VARCHAR(50) NULL COLLATE 'utf8_general_ci',
	`Telefono` VARCHAR(15) NULL COLLATE 'utf8_general_ci',
	`Institucion` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`NumeroHabitacion` VARCHAR(10) NULL COLLATE 'utf8_general_ci',
	`FechaRegistro` DATETIME NULL,
	`NombreMonitor` VARCHAR(500) NULL COLLATE 'utf8_general_ci',
	`MontoPagado` DECIMAL(33,2) NULL,
	`Saldo` DECIMAL(11,2) NULL
) ENGINE=MyISAM;

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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.monitor: ~3 rows (aproximadamente)
DELETE FROM `monitor`;
/*!40000 ALTER TABLE `monitor` DISABLE KEYS */;
INSERT INTO `monitor` (`IdMonitor`, `CI`, `NombreMonitor`, `Institucion`, `Direccion`, `Telefono`) VALUES
	(1, '410011', 'Juan Lopez', '', '', ''),
	(2, '4111117', 'Esteban Fernandez', 'MCC', 'Junin #56', '6478944'),
	(3, '7894561', 'Jose Luis Coronado', 'Asambleas de Dios', 'Junin 23', '6478945');
/*!40000 ALTER TABLE `monitor` ENABLE KEYS */;

-- Volcando estructura para procedimiento congreso.PaActivarParticipante
DROP PROCEDURE IF EXISTS `PaActivarParticipante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaActivarParticipante`(
	in _IdParticipante int
)
BEGIN
 update participante set EsEliminado = 0
	where IdParticipante = _IdParticipante;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaBuscarEventoSeleccionado
DROP PROCEDURE IF EXISTS `PaBuscarEventoSeleccionado`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaBuscarEventoSeleccionado`()
BEGIN
	select * from listaeventos where Seleccionado = 1;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaBuscarParticipante
DROP PROCEDURE IF EXISTS `PaBuscarParticipante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaBuscarParticipante`(
	IN _Ci varchar(10)
)
BEGIN
	select * from participante where CI = _Ci;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaBuscarParticipanteEvento
DROP PROCEDURE IF EXISTS `PaBuscarParticipanteEvento`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaBuscarParticipanteEvento`(
	in _IdParticipante int,
	in _IdEvento int
)
BEGIN
	select * from listaeventoparticipante 
	where IdParticipante = _IdParticipante and IdEvento = _IdEvento;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaBuscarUltimoPago
DROP PROCEDURE IF EXISTS `PaBuscarUltimoPago`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaBuscarUltimoPago`(
	in _IdEventoParticipante int
)
BEGIN
select *
from listapagos
where IdEventoParticipante = _IdEventoParticipante
order by IdPago desc
limit 1;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaDesactivarParticipante
DROP PROCEDURE IF EXISTS `PaDesactivarParticipante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaDesactivarParticipante`(
	in _IdParticipante int
)
BEGIN
	update participante set EsEliminado = 1
	where IdParticipante = _IdParticipante;
END//
DELIMITER ;

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
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.pago: ~30 rows (aproximadamente)
DELETE FROM `pago`;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` (`IdPago`, `IdEventoParticipante`, `Fecha`, `MontoPagado`, `Saldo`) VALUES
	(1, 17, '2018-01-13 00:00:00', 23.00, 12.00),
	(2, 18, '2018-01-13 00:00:00', 23.00, 0.00),
	(3, 19, '2018-01-13 00:00:00', 23.00, 0.00),
	(4, 20, '2018-01-13 00:00:00', 100.00, 20.00),
	(5, 17, '2018-01-15 00:00:00', 10.00, 2.00),
	(6, 20, '2018-01-15 00:00:00', 10.00, 10.00),
	(7, 17, '2018-01-15 00:00:00', 1.00, 1.00),
	(8, 17, '2018-01-15 00:00:00', 1.00, 0.00),
	(9, 21, '2018-01-16 00:00:00', 45.00, 105.00),
	(10, 22, '2018-01-16 00:00:00', 87.00, 63.00),
	(11, 23, '2018-01-16 00:00:00', 50.00, 100.00),
	(12, 23, '2018-01-16 00:00:00', 20.00, 30.00),
	(13, 22, '2018-01-17 00:00:00', 20.00, 43.00),
	(14, 23, '2018-01-17 00:00:00', 10.00, 20.00),
	(15, 22, '2018-01-17 00:00:00', 43.00, 0.00),
	(16, 20, '2018-01-18 00:00:00', 5.00, 5.00),
	(17, 24, '2018-01-18 00:00:00', 100.00, 100.00),
	(18, 20, '2018-01-18 00:00:00', 3.00, 2.00),
	(19, 20, '2018-01-18 00:00:00', 2.00, 0.00),
	(20, 25, '2018-01-18 00:00:00', 25.00, 75.00),
	(21, 26, '2018-01-18 00:00:00', 50.00, 50.00),
	(22, 25, '2018-01-18 00:00:00', 12.00, 63.00),
	(23, 25, '2018-01-18 00:00:00', 21.00, 42.00),
	(24, 26, '2018-01-22 00:00:00', 42.00, 8.00),
	(25, 25, '2018-01-22 00:00:00', 5.00, 37.00),
	(26, 25, '2018-01-22 00:00:00', 5.00, 32.00),
	(27, 25, '2018-01-22 00:00:00', 8.00, 24.00),
	(28, 25, '2018-01-22 00:00:00', 4.00, 20.00),
	(29, 25, '2018-01-22 00:00:00', 2.00, 18.00),
	(30, 24, '2018-01-22 00:00:00', 40.00, 60.00);
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;

-- Volcando estructura para procedimiento congreso.PaInsertarEvento
DROP PROCEDURE IF EXISTS `PaInsertarEvento`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaInsertarEvento`(
	IN _NombreEvento varchar(500),
	IN _Lugar varchar(500),
	IN _FechaInicio datetime,
	IN _FechaFin datetime,
	IN _Costo decimal(11,2),
	IN _Descripcion varchar(500)
)
BEGIN
	insert into Evento (NombreEvento,Lugar,FechaInicio,FechaFin,Costo,Descripcion) values (_NombreEvento,_Lugar,_FechaInicio,_FechaFin,_Costo,_Descripcion);
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaInsertarEventoParticipante
DROP PROCEDURE IF EXISTS `PaInsertarEventoParticipante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaInsertarEventoParticipante`(
	IN _IdEvento INT,
    IN _IdParticipante INT,
    IN _IdMonitor INT,
    IN _FechaRegistro date,
    IN _NumeroHabitacion varchar(10),
	In _Observaciones varchar(1000)
)
BEGIN
	insert into eventoparticipante (IdEvento,IdParticipante,IdMonitor,FechaRegistro,NumeroHabitacion,Observaciones) values 
									(_IdEvento,_IdParticipante,_IdMonitor,_FechaRegistro,_NumeroHabitacion,_Observaciones);
	SELECT LAST_INSERT_ID();
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

-- Volcando estructura para procedimiento congreso.PaInsertarPago
DROP PROCEDURE IF EXISTS `PaInsertarPago`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaInsertarPago`(
	IN _IdEventoParticipante INT,
    IN _Fecha DATETIME,
    IN _MontoPagado decimal(11,2),
    IN _Saldo decimal(11,2)
)
BEGIN

  insert into pago (IdEventoParticipante,Fecha,MontoPagado,Saldo) values
			  (_IdEventoParticipante,_Fecha,_MontoPagado,_Saldo);
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

-- Volcando estructura para procedimiento congreso.PaListarEventos
DROP PROCEDURE IF EXISTS `PaListarEventos`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaListarEventos`()
BEGIN
	select * from listaeventos
	order by NombreEvento;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaListarMonitores
DROP PROCEDURE IF EXISTS `PaListarMonitores`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaListarMonitores`()
BEGIN
	select * from listamonitores order by NombreMonitor;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaListarPagos
DROP PROCEDURE IF EXISTS `PaListarPagos`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaListarPagos`(
	in _IdEventoParticipante int
)
BEGIN
	select * from pago where IdEventoParticipante = _IdEventoParticipante;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaListarParticipantes
DROP PROCEDURE IF EXISTS `PaListarParticipantes`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaListarParticipantes`()
BEGIN
	select * from listaparticipantes
	order by NombreParticipante asc;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaListarParticipantesPagoCompleto
DROP PROCEDURE IF EXISTS `PaListarParticipantesPagoCompleto`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaListarParticipantesPagoCompleto`()
BEGIN
select listaparticipantesevento.IdEventoParticipante, listaparticipantesevento.CI, 
	listaparticipantesevento.NombreParticipante, listaparticipantesevento.Ciudad, 
	listaparticipantesevento.Telefono, listaparticipantesevento.Institucion, 
	listaparticipantesevento.NumeroHabitacion, listaparticipantesevento.FechaRegistro, 
	listaparticipantesevento.NombreMonitor,listaparticipantesevento.MontoPagado, 
	listaparticipantesevento.Saldo
	from listaparticipantesevento, listaeventoparticipante, listaeventos
	where listaparticipantesevento.IdEventoParticipante = listaeventoparticipante.IdEventoParticipante
	and listaeventoparticipante.IdEvento = listaeventos.IdEvento
	and listaeventos.Seleccionado = 1
	and listaparticipantesevento.Saldo <= 0
	order by listaparticipantesevento.Institucion asc, listaparticipantesevento.NombreParticipante asc;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaListarParticipantesPagoPendiente
DROP PROCEDURE IF EXISTS `PaListarParticipantesPagoPendiente`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaListarParticipantesPagoPendiente`()
BEGIN
	select listaparticipantesevento.IdEventoParticipante, listaparticipantesevento.CI, 
	listaparticipantesevento.NombreParticipante, listaparticipantesevento.Ciudad, 
	listaparticipantesevento.Telefono, listaparticipantesevento.Institucion, 
	listaparticipantesevento.NumeroHabitacion, listaparticipantesevento.FechaRegistro, 
	listaparticipantesevento.NombreMonitor,listaparticipantesevento.MontoPagado, 
	listaparticipantesevento.Saldo
	from listaparticipantesevento, listaeventoparticipante, listaeventos
	where listaparticipantesevento.IdEventoParticipante = listaeventoparticipante.IdEventoParticipante
	and listaeventoparticipante.IdEvento = listaeventos.IdEvento
	and listaeventos.Seleccionado = 1
	and listaparticipantesevento.Saldo > 0
	order by listaparticipantesevento.Institucion asc, listaparticipantesevento.NombreParticipante asc;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaListarParticipantesVigentes
DROP PROCEDURE IF EXISTS `PaListarParticipantesVigentes`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaListarParticipantesVigentes`()
BEGIN
	select * from listaparticipantes
	where EsEliminado = 0
	order by NombreParticipante asc;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaModificarEvento
DROP PROCEDURE IF EXISTS `PaModificarEvento`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaModificarEvento`(
	IN _IdEvento int,
	IN _NombreEvento varchar(500),
	IN _Lugar varchar(500),
	IN _FechaInicio datetime,
	IN _FechaFin datetime,
	IN _Costo decimal(11,2),
	IN _Descripcion varchar(500)
)
BEGIN
	update evento set NombreEvento = _NombreEvento,
			Lugar = _Lugar, FechaInicio = _FechaInicio,
			FechaFin = _FechaFin, Costo = _Costo,
			Descripcion = _Descripcion
	where IdEvento = _IdEvento;
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaModificarParticipante
DROP PROCEDURE IF EXISTS `PaModificarParticipante`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaModificarParticipante`(
	IN _IdParticipante int,
	IN _Ci varchar(10),
	IN _NombreParticipante varchar(500),
	IN _Ciudad varchar(50),
	IN _CorreoElectronico varchar(300),
	IN _Direccion varchar(150),
	IN _Institucion varchar(500),
	IN _Telefono varchar(15)
)
BEGIN
	update participante set CI = _Ci, NombreParticipante = _NombreParticipante,
		Ciudad = _Ciudad, CorreoElectronico = _CorreoElectronico,
		Direccion = _Direccion, Institucion = _Institucion, Telefono = _Telefono
	where IdParticipante = _IdParticipante; 
END//
DELIMITER ;

-- Volcando estructura para procedimiento congreso.PaParticipantesListarEvento
DROP PROCEDURE IF EXISTS `PaParticipantesListarEvento`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaParticipantesListarEvento`()
BEGIN
	select listaparticipantesevento.IdEventoParticipante, listaparticipantesevento.CI, 
	listaparticipantesevento.NombreParticipante, listaparticipantesevento.Ciudad, 
	listaparticipantesevento.Telefono, listaparticipantesevento.Institucion, 
	listaparticipantesevento.NumeroHabitacion, listaparticipantesevento.FechaRegistro, 
	listaparticipantesevento.NombreMonitor,listaparticipantesevento.MontoPagado, 
	listaparticipantesevento.Saldo
	from listaparticipantesevento, listaeventoparticipante, listaeventos
	where listaparticipantesevento.IdEventoParticipante = listaeventoparticipante.IdEventoParticipante
	and listaeventoparticipante.IdEvento = listaeventos.IdEvento
	and listaeventos.Seleccionado = 1
	order by listaparticipantesevento.Institucion asc, listaparticipantesevento.NombreParticipante asc;
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
  `EsEliminado` bit(1) DEFAULT b'0',
  PRIMARY KEY (`IdParticipante`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Volcando datos para la tabla congreso.participante: ~8 rows (aproximadamente)
DELETE FROM `participante`;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
INSERT INTO `participante` (`IdParticipante`, `CI`, `NombreParticipante`, `Ciudad`, `Direccion`, `CorreoElectronico`, `Telefono`, `Institucion`, `EsEliminado`) VALUES
	(1, '4015789', 'Juan Manuel Llanos Serrudo', 'La Paz', 'Av. Ostria Gutierrez s/n', 'manu_llanos@gmail.com', '64789456', 'Asambleas de Dios', b'1'),
	(2, '4103785', 'Jose Flores', 'La Paz', 'Av. del Estudiante 300', 'flores_jose@latinmail.com', '78945612', 'CCU', b'0'),
	(3, '5678941', 'Jorge Perez', 'Sucre', 'Pando #49', 'jorge@gmail.com', '6478954', 'MCC', b'0'),
	(6, '7894561', 'Luis Lopez Perez', 'Sucre', 'Av. Jaime Mendoza', 'luis@gmail.com', '6478945', 'MCC', b'0'),
	(7, '4103650', 'Juan Pablo Cordero Romero', 'Sucre', 'Pando 49', 'jpablo.cordero.r@gmail.com', '73469213', 'MCC', b'0'),
	(8, '6665130', 'Emilce Herrera Santa Cruz', 'Sucre', 'Pando #49', 'emilce@gmail.com', '73421991', 'MCC', b'0'),
	(9, '1028475', 'Crispin Fernandez Gonzales', 'Potosi', 'Hoyos #57', 'fernandez@gmail.com', '6478945', 'CCU', b'0'),
	(10, '1085287', 'Juan Carlos Valdivia', 'Yacuiba', 'Bolivar #71', 'valdivia@hotmail.com', '78945612', 'Asambleas de Dios', b'1');
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;

-- Volcando estructura para procedimiento congreso.PaSeleccionarEvento
DROP PROCEDURE IF EXISTS `PaSeleccionarEvento`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `PaSeleccionarEvento`(
	IN _IdEvento int
)
BEGIN
	update evento set seleccionado = 0;
	update evento set seleccionado = 1 where IdEvento = _IdEvento;
END//
DELIMITER ;

-- Volcando estructura para vista congreso.listaeventoparticipante
DROP VIEW IF EXISTS `listaeventoparticipante`;
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `listaeventoparticipante`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listaeventoparticipante` AS select * from eventoparticipante ;

-- Volcando estructura para vista congreso.listaeventos
DROP VIEW IF EXISTS `listaeventos`;
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `listaeventos`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listaeventos` AS select * from evento ;

-- Volcando estructura para vista congreso.listamonitores
DROP VIEW IF EXISTS `listamonitores`;
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `listamonitores`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listamonitores` AS select * from monitor ;

-- Volcando estructura para vista congreso.listapagos
DROP VIEW IF EXISTS `listapagos`;
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `listapagos`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listapagos` AS select * from pago ;

-- Volcando estructura para vista congreso.listaparticipantes
DROP VIEW IF EXISTS `listaparticipantes`;
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `listaparticipantes`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listaparticipantes` AS select 
        `participante`.`IdParticipante` AS `IdParticipante`,
        `participante`.`CI` AS `CI`,
        `participante`.`NombreParticipante` AS `NombreParticipante`,
        `participante`.`Ciudad` AS `Ciudad`,
        `participante`.`Direccion` AS `Direccion`,
        `participante`.`CorreoElectronico` AS `CorreoElectronico`,
        `participante`.`Telefono` AS `Telefono`,
        `participante`.`Institucion` AS `Institucion`,
		`participante`.`EsEliminado` AS `EsEliminado`
    from
        `participante` ;

-- Volcando estructura para vista congreso.listaparticipantesevento
DROP VIEW IF EXISTS `listaparticipantesevento`;
-- Eliminando tabla temporal y crear estructura final de VIEW
DROP TABLE IF EXISTS `listaparticipantesevento`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listaparticipantesevento` AS select eventoparticipante.IdEventoParticipante, participante.CI, participante.NombreParticipante,
participante.Ciudad, participante.Telefono, participante.Institucion, eventoparticipante.NumeroHabitacion,
eventoparticipante.FechaRegistro, monitor.NombreMonitor,
(
select sum(MontoPagado)
from pago
where IdEventoParticipante = eventoparticipante.IdEventoParticipante
) as MontoPagado, 
(
select Saldo
from pago
where IdEventoParticipante = eventoparticipante.IdEventoParticipante
order by IdPago desc
limit 1
)
as Saldo
from eventoparticipante, monitor, participante
where eventoparticipante.IdParticipante = participante.IdParticipante and
eventoparticipante.IdMonitor = monitor.IdMonitor
order by IdEventoParticipante asc ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
