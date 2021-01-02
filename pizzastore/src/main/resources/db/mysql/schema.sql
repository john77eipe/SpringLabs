
DROP TABLE IF EXISTS `tbl_pizza_category_map`;
DROP TABLE IF EXISTS `tbl_pizza`;
DROP TABLE IF EXISTS `tbl_category`;

--
-- Table structure for table `pizza_category`
--

CREATE TABLE `tbl_category` (
  `id`          INT(11)         NOT NULL AUTO_INCREMENT,
  `category`    VARCHAR(45)     DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


--
-- Table structure for table `pizza`
--

CREATE TABLE `tbl_pizza` (
  `id`              INT(11)         NOT NULL AUTO_INCREMENT,
  `name`            VARCHAR(45)     DEFAULT NULL,
  `price`           FLOAT(45,2)     DEFAULT NULL,
  `desc`            VARCHAR(500)    DEFAULT NULL,
  `category_default` INT(11)        DEFAULT NULL,
  `quantity`        INT(11)         DEFAULT NULL,
  `tax`             FLOAT(45,2)     DEFAULT NULL,
  `on_sale`         INT(1)          DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_idx` (`category_default`),
  CONSTRAINT `fk_category` FOREIGN KEY (`category_default`) REFERENCES `tbl_category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
  -- deletes shouldn't cascade and be set as null as a pizza shouldn't be deleted when a category is deleted 
  -- (no action is equal to default which prevents the operation on category table)
  -- updates should cascade
) ENGINE=InnoDB AUTO_INCREMENT=1;

--
-- Table structure for table `pizza_category_map`
--

CREATE TABLE `tbl_pizza_category_map` (
  `id`          INT(11)         NOT NULL AUTO_INCREMENT,
  `pizza_id`    INT(11)         DEFAULT NULL,
  `category_id` INT(11)         DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_idx` (`category_id`),
  KEY `fk_pizza_idx` (`pizza_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  -- deletes and updates should cascade when category is touched
  CONSTRAINT `fk_pizza_id` FOREIGN KEY (`pizza_id`) REFERENCES `tbl_pizza` (`id`)  ON DELETE CASCADE ON UPDATE CASCADE
  -- deletes and updates should cascade when pizza is tocuhed
) ENGINE=InnoDB AUTO_INCREMENT=1;

--
-- Table structure for table `tbl_user`
--

CREATE TABLE `tbl_user` (
  `id`              INT(11)         NOT NULL AUTO_INCREMENT,
  `display_name`    VARCHAR(32)     NOT NULL,
  `first_name`      VARCHAR(32)     NOT NULL
  `email`           VARCHAR(256)    NOT NULL,
  `password`        VARCHAR(256)    NOT NULL,
  `type`            INT(1)          DEFAULT '1',
  -- type takes 1:customer, 2:owner, 3: admin
  `yob`             INT(4)          NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

--
-- Table structure for table `tbl_order`
--

CREATE TABLE `tbl_order` (
  `id`              INT(11)         NOT NULL AUTO_INCREMENT,
  `user_id`         INT(11)         NOT NULL,
  `shipping_addr_id`INT(11)         NOT NULL,
  `billing_addr_id` INT(11)         NOT NULL,
  `order_state`     INT(1)          NOT NULL DEFAULT 1
  -- 'order state gets these other values: 1:'AddingItems', 2:'OrderPlaced', 3:'Shipped', 4:'Delivered'
  `shipping_cost`   FLOAT(6,2)      NOT NULL DEFAULT 0,
  `shipping_tax`    FLOAT(6,2)      NOT NULL DEFAULT 0,
  `total`           FLOAT(12,2)     NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

--
-- Table structure for table `tbl_order_item`
--

CREATE TABLE `tbl_order_item` (
  `id`              INT(11)         NOT NULL AUTO_INCREMENT,
  `order_id`        INT(11)         NOT NULL,
  `pizza_id`        INT(11)         NOT NULL,      
  --pizza_id represents the pizza bought
  `unit_price`      FLOAT(6,2)      NOT NULL,
  `quantity`        INT(100)        NOT NULL,
  `total_price`     FLOAT(8,2)      NOT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

--
-- Table structure for table `tbl_address`
--

CREATE TABLE `tbl_address` (
  `id`              INT(11)         NOT NULL AUTO_INCREMENT,
  `user_id`         INT(11)         NOT NULL,
  `full_name`       VARCHAR(256)    NOT NULL,
  `company`         VARCHAR(256)    DEFAULT NULL,
  `address_line_1`  VARCHAR(128)    NOT NULL,
  `address_line_2`  VARCHAR(256)    NOT NULL,
  `address_line_3`  VARCHAR(256)    DEFAULT NULL,
  `city`            VARCHAR(256)    NOT NULL,
  `state`           VARCHAR(256)    NOT NULL,
  `postal_code`     VARCHAR(256)    NOT NULL,
  `country`         VARCHAR(256)    NOT NULL,
  `type`            INT(1)          NOT NULL,               
  -- type is billing 1 or shipping 2
  `default_billing`     BOOLEAN     DEFAULT NULL,
  `default_shipping`    BOOLEAN     DEFAULT NULL
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;