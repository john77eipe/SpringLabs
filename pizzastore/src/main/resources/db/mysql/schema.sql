-- -----------------------------------------------------
-- Naming Conventions

-- Table Naming:                tbl_[name]
-- eg:                          tbl_user
-- Primary column Naming:       id
-- eg:                          id
-- FK column Naming:            [column name]_id
-- eg:                          billing_addr_id
-- Index Naming:                [FK column name]_idx
-- eg:                          billing_addr_id_idx
-- Unique Index Naming:         [column name]_uidx
-- eg:                          name_uidx
-- Constraint Naming:           fk__[left table name]_[right table name]_[some suffix]
-- eg:                          fk__tbl_order_tbl_address_bill
-- -----------------------------------------------------

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';


-- -----------------------------------------------------
-- Schema store
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `store` ;
CREATE SCHEMA IF NOT EXISTS `store` DEFAULT CHARACTER SET UTF8MB4;
USE `store` ;

-- -----------------------------------------------------
-- Table `store`.`tbl_authorities`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `store`.`tbl_authorities` (
  `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
  `authority` VARCHAR(255) NULL DEFAULT NULL,
  `user_id` BIGINT(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store`.`tbl_address`
-- -----------------------------------------------------

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
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store`.`tbl_user`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `store`.`tbl_user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `display_name` VARCHAR(32) NOT NULL,
  `first_name` VARCHAR(32) NOT NULL,
  `email` VARCHAR(256) NOT NULL,
  `password` VARCHAR(256) NOT NULL,
  `type` INT(1) NULL DEFAULT '1',
  `yob` INT(4) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(245) NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_uidx` (`name` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza_variant`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza_variant` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `sku` VARCHAR(45) NOT NULL,
  `pizza_id` INT(11) NOT NULL,
  `price` FLOAT(8,2) NOT NULL,
  `tax` FLOAT(8,2) NOT NULL,
  `qty_on_hand` INT(11) NOT NULL,
  `qty_on_sale` INT(11) NOT NULL,
  `out_of_stock_limit` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `sku_uidx` (`sku` ASC) VISIBLE,
  INDEX `pizza_id_idx` (`pizza_id` ASC) VISIBLE,
  CONSTRAINT `fk__tbl_pizza_variant_tbl_pizza`
    FOREIGN KEY (`pizza_id`)
    REFERENCES `store`.`tbl_pizza` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza_option`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza_option` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `option_type` VARCHAR(45) NOT NULL,
  `option_value` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store`.`tbl_pizza_variety`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `store`.`tbl_pizza_variety` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `pizza_variant_id` INT(11) NOT NULL,
  `pizza_option_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `pizza_option_id_idx` (`pizza_option_id` ASC) VISIBLE,
  INDEX `pizza_variant_id_idx` (`pizza_variant_id` ASC) VISIBLE,
  CONSTRAINT `fk__tbl_pizza_variety_tbl_pizza_option`
    FOREIGN KEY (`pizza_option_id`)
    REFERENCES `store`.`tbl_pizza_option` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_pizza_variety_tbl_pizza_variant`
    FOREIGN KEY (`pizza_variant_id`)
    REFERENCES `store`.`tbl_pizza_variant` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `store`.`tbl_order`
-- -----------------------------------------------------

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
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `store`.`tbl_order_item`
-- -----------------------------------------------------

CREATE TABLE IF NOT EXISTS `store`.`tbl_order_item` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `order_id` INT(11) NOT NULL,
  `pizza_variant_id` INT(11) NOT NULL,
  `unit_price` FLOAT(6,2) NOT NULL,
  `quantity` INT(100) NOT NULL,
  `total_price` FLOAT(8,2) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `order_id_idx` (`order_id` ASC) VISIBLE,
  INDEX `pizza_variant_id_idx` (`pizza_variant_id` ASC) VISIBLE,
  CONSTRAINT `fk__tbl_order_item_tbl_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `store`.`tbl_order` (`id`)
    ON DELETE RESTRICT
    ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_order_item_tbl_pizza_variant`
    FOREIGN KEY (`pizza_variant_id`)
    REFERENCES `store`.`tbl_pizza_variant` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;