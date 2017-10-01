
CREATE TABLE `vasari`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(64) NOT NULL,
  `category` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));
