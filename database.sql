CREATE SCHEMA IF NOT EXISTS `memo`;

CREATE TABLE IF NOT EXISTS `memo`.`user` (
    `userId` INT NOT NULL AUTO_INCREMENT,
    `userName` VARCHAR(50) NOT NULL,
    `password` VARCHAR(50) NOT NULL,
    `description` TEXT DEFAULT NULL,
    `avatar` TEXT DEFAULT NULL,
    PRIMARY KEY (`userId`),
    UNIQUE KEY `userName` (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `memo`.`event` (
	`eventId` INT NOT NULL AUTO_INCREMENT,
	`userId` INT NOT NULL,
    `eventName` VARCHAR(50) NOT NULL,
    `content` TEXT DEFAULT NULL,
    `startTime` VARCHAR(50) NOT NULL,
    `endTime` VARCHAR(50) NOT NULL,
	PRIMARY KEY (`eventId`),
    KEY `userId` (`userId`),
    CONSTRAINT `userId` FOREIGN KEY (`userId`) REFERENCES `user` (`userId`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
