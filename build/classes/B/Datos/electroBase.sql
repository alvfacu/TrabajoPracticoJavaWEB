# SQL Manager 2005 Lite for MySQL 3.7.0.1
# ---------------------------------------
# Host     : localhost
# Port     : 3306
# Database : electroBase


SET FOREIGN_KEY_CHECKS=0;

CREATE DATABASE `electroBase`
    CHARACTER SET 'latin1'
    COLLATE 'latin1_swedish_ci';

#
# Structure for the `color` table : 
#

CREATE TABLE `color` (
  `idColor` int(11) NOT NULL auto_increment,
  `color` varchar(20) default NULL,
  PRIMARY KEY  (`idColor`),
  UNIQUE KEY `idColor` (`idColor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `consumo` table : 
#

CREATE TABLE `consumo` (
  `idConsumo` int(11) NOT NULL auto_increment,
  `consumo` char(20) default NULL,
  `precio` float(9,3) NOT NULL,
  PRIMARY KEY  (`idConsumo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Structure for the `electrodomesticos` table : 
#

CREATE TABLE `electrodomesticos` (
  `idElectrodomestico` int(11) NOT NULL auto_increment,
  `precioBase` float(9,3) NOT NULL,
  `peso` float(9,3) NOT NULL,
  `carga` float(9,3) default NULL,
  `resolucion` float(9,3) default NULL,
  `sintonizadorTdt` tinyint(1) default NULL,
  `idConsumo` int(11) NOT NULL,
  `idColor` int(11) NOT NULL,
  PRIMARY KEY  (`idElectrodomestico`),
  UNIQUE KEY `idElectrodomestico` (`idElectrodomestico`),
  KEY `idConsumo` (`idConsumo`),
  KEY `electrodomesticos_fk1` (`idColor`),
  CONSTRAINT `electrodomesticos_fk` FOREIGN KEY (`idConsumo`) REFERENCES `consumo` (`idConsumo`),
  CONSTRAINT `electrodomesticos_fk1` FOREIGN KEY (`idColor`) REFERENCES `color` (`idColor`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

#
# Data for the `color` table  (LIMIT 0,500)
#

INSERT INTO `color` (`idColor`, `color`) VALUES 
  (1,'Blanco'),
  (2,'Negro'),
  (3,'Azul'),
  (4,'Rojo'),
  (5,'Azul');

COMMIT;

#
# Data for the `consumo` table  (LIMIT 0,500)
#

INSERT INTO `consumo` (`idConsumo`, `consumo`, `precio`) VALUES 
  (1,'A',100),
  (2,'B',80),
  (3,'C',60),
  (4,'D',50),
  (5,'E',30),
  (6,'F',10);

COMMIT;

#
# Data for the `electrodomesticos` table  (LIMIT 0,500)
#

INSERT INTO `electrodomesticos` (`idElectrodomestico`, `precioBase`, `peso`, `carga`, `resolucion`, `sintonizadorTdt`, `idConsumo`, `idColor`) VALUES 
  (17,23,32,NULL,12,0,2,2),
  (18,34,55,NULL,12,1,5,2),
  (19,33,12,12,NULL,NULL,2,2);

COMMIT;

