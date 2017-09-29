CREATE SCHEMA `vasari` ;

CREATE TABLE `vasari`.`category` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));


CREATE TABLE `vasari`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  `category_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `category_idx` (`category_id` ASC),
  CONSTRAINT `category`
    FOREIGN KEY (`category_id`)
    REFERENCES `vasari`.`category` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);