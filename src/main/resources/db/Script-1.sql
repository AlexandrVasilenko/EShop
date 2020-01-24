CREATE DATABASE eshopdb
	CHARSET SET utf8;
	
USE eshopdb;

CREATE TABLE `abilities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `picture` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(1500) DEFAULT NULL,
  `price` int(11) DEFAULT 0,
  `level` varchar(100) NOT NULL,
  `obtained` tinyint(1) DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8


CREATE TABLE `profiles` (
  `playerid` int(11) NOT NULL,
  `alcohol` bit(1) NOT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `inLove` bit(1) NOT NULL,
  `nutritionType` varchar(255) DEFAULT NULL,
  `playerAge` int(11) NOT NULL,
  `playerName` varchar(255) DEFAULT NULL,
  `sleepingHours` int(11) NOT NULL,
  `smoking` bit(1) NOT NULL,
  `sportActivity` int(11) NOT NULL,
  `timereserve` int(11) DEFAULT NULL,
  PRIMARY KEY (`playerid`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8


CREATE TABLE `results` (
  `playerid` int(11) NOT NULL,
  `abilitylist` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`playerid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8