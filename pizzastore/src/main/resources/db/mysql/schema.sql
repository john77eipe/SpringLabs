SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema store
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `store` ;

-- -----------------------------------------------------
-- Schema store
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `store` DEFAULT CHARACTER SET utf8 ;
USE `store` ;

-- -----------------------------------------------------
-- Table `store`.`tbl_authorities`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_authorities` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_authorities` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(255) NULL DEFAULT NULL,
  `user_account_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKnfogtu00cjttxk3jjmcx10xwc` (`user_account_id` ASC) VISIBLE)
ENGINE = MyISAM
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_address`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_address` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_address` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `full_name` VARCHAR(256) NOT NULL,
  `company` VARCHAR(256) NULL DEFAULT NULL,
  `address_line_1` VARCHAR(128) NOT NULL,
  `address_line_2` VARCHAR(256) NOT NULL,
  `address_line_3` VARCHAR(256) NULL DEFAULT NULL,
  `city` VARCHAR(256) NOT NULL,
  `state` VARCHAR(256) NOT NULL,
  `postal_code` VARCHAR(256) NOT NULL,
  `country` VARCHAR(256) NOT NULL,
  `type` INT(1) NOT NULL,
  `default_billing` TINYINT(1) NULL DEFAULT '0',
  `default_shipping` TINYINT(1) NULL DEFAULT '0',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_user`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_user` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `display_name` VARCHAR(32) NOT NULL,
  `first_name` VARCHAR(32) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `type` INT(1) NULL DEFAULT '1',
  `yob` INT(4) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_order` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_order` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `user_id` INT(11) NOT NULL,
  `shipping_addr_id` INT(11) NOT NULL,
  `billing_addr_id` INT(11) NOT NULL,
  `order_state` INT(1) NOT NULL DEFAULT '1',
  `shipping_cost` FLOAT(6,2) NOT NULL DEFAULT '0.00',
  `shipping_tax` FLOAT(6,2) NOT NULL DEFAULT '0.00',
  `total` FLOAT(12,2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `shipping_addr_id_idx` (`shipping_addr_id` ASC) VISIBLE,
  INDEX `billing_addr_id_idx` (`billing_addr_id` ASC) VISIBLE,
  CONSTRAINT `fk__tbl_order_tbl_address_bill`
    FOREIGN KEY (`billing_addr_id`)
    REFERENCES `store`.`tbl_address` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_order_tbl_address_ship`
    FOREIGN KEY (`shipping_addr_id`)
    REFERENCES `store`.`tbl_address` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_order_tbl_user`
    FOREIGN KEY (`user_id`)
    REFERENCES `store`.`tbl_user` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_pizza` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza` (
  `id_pizza` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(245) NULL,
  PRIMARY KEY (`id_pizza`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza_variant`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_pizza_variant` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza_variant` (
  `id_pizza_variant` INT(11) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(45) NOT NULL,
  `id_pizza` INT(11) NOT NULL,
  `price` FLOAT(8,2) NOT NULL,
  `tax` FLOAT(8,2) NOT NULL,
  `qty_on_hand` INT(11) NOT NULL,
  `qty_on_sale` INT(11) NOT NULL,
  `out_of_stock_limit` INT(11) NOT NULL,
  PRIMARY KEY (`id_pizza_variant`),
  UNIQUE INDEX `sku_UNIQUE` (`sku` ASC) VISIBLE,
  INDEX `fk_tbl_pizza_variant_id_pizza_idx` (`id_pizza` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_pizza_variant_id_pizza`
    FOREIGN KEY (`id_pizza`)
    REFERENCES `store`.`tbl_pizza` (`id_pizza`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_order_item`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_order_item` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_order_item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(11) NOT NULL,
  `pizza_variant_id` INT(11) NOT NULL,
  `unit_price` FLOAT(6,2) NOT NULL,
  `quantity` INT(100) NOT NULL,
  `total_price` FLOAT(8,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_id_idx` (`order_id` ASC) VISIBLE,
  INDEX `fk_tbl_order_item_id_pizza_variant_idx` (`pizza_variant_id` ASC) VISIBLE,
  CONSTRAINT `fk__tbl_order_item_tbl_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `store`.`tbl_order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_order_item_id_pizza_variant`
    FOREIGN KEY (`pizza_variant_id`)
    REFERENCES `store`.`tbl_pizza_variant` (`id_pizza_variant`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza_option`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_pizza_option` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza_option` (
  `id_pizza_option` INT(11) NOT NULL AUTO_INCREMENT,
  `option_type` VARCHAR(45) NOT NULL,
  `option_value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id_pizza_option`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza_variety`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `store`.`tbl_pizza_variety` ;

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza_variety` (
  `id_pizza_variety` INT(11) NOT NULL AUTO_INCREMENT,
  `id_pizza_variant` INT(11) NOT NULL,
  `id_pizza_option` INT(11) NOT NULL,
  INDEX `fk_tbl_pizza_variety_id_pizza_option_idx` (`id_pizza_option` ASC) VISIBLE,
  INDEX `fk_tbl_pizza_variety_id_pizza_variety_idx` (`id_pizza_variety` ASC) VISIBLE,
  PRIMARY KEY (`id_pizza_variety`),
  INDEX `fk_tbl_pizza_variety_id_pizza_variant_idx` (`id_pizza_variant` ASC) VISIBLE,
  CONSTRAINT `fk_tbl_pizza_variety_id_pizza_option`
    FOREIGN KEY (`id_pizza_option`)
    REFERENCES `store`.`tbl_pizza_option` (`id_pizza_option`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk_tbl_pizza_variety_id_pizza_variant`
    FOREIGN KEY (`id_pizza_variant`)
    REFERENCES `store`.`tbl_pizza_variant` (`id_pizza_variant`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
