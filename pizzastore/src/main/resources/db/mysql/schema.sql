use store;

-- dropping order and order items
DROP TABLE IF EXISTS `tbl_order_item`;
DROP TABLE IF EXISTS `tbl_order`;
-- dropping category maps, option groups, option maps
DROP TABLE IF EXISTS `tbl_pizza_category_map`;
DROP TABLE IF EXISTS `tbl_pizza_option_group`;
DROP TABLE IF EXISTS `tbl_pizza_variant_option_map`;
-- dropping option group and options
DROP TABLE IF EXISTS `tbl_option`;
DROP TABLE IF EXISTS `tbl_option_group`;

-- dropping user
DROP TABLE IF EXISTS `tbl_authorities`;
DROP TABLE IF EXISTS `tbl_user`;
-- dropping top level tables - address, pizza variant, pizza and category
DROP TABLE IF EXISTS `tbl_address`;
DROP TABLE IF EXISTS `tbl_pizza_variant`;
DROP TABLE IF EXISTS `tbl_pizza`;
DROP TABLE IF EXISTS `tbl_category`;

-- convention used for FK's
-- fk__ForeignKeyTable_PrimaryKeyTable
-- convention used for index on ForeignKey Columns
-- ForeignKeyColumn_idx

--
-- Table structure for table `tbl_category`
--
CREATE TABLE `tbl_category` (
  `id`                  INT(11)         NOT NULL AUTO_INCREMENT,
  `category`            VARCHAR(45)     DEFAULT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_pizza`
--
CREATE TABLE `tbl_pizza` (
  `id`                  INT(11)         NOT NULL AUTO_INCREMENT,
  `name`                VARCHAR(45)     DEFAULT NULL,
  `price`               FLOAT(45,2)     DEFAULT NULL,
  `desc`                VARCHAR(500)    DEFAULT NULL,
  `category_default`    INT(11)         DEFAULT NULL,
  `quantity`            INT(11)         DEFAULT NULL,
  `tax`                 FLOAT(45,2)     DEFAULT NULL,
  `on_sale`             INT(1)          DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `category_default_idx` (`category_default`),
  CONSTRAINT `fk__tbl_pizza_tbl_category` FOREIGN KEY (`category_default`) REFERENCES `tbl_category` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
  -- deletes shouldn't cascade and be set as null as a pizza shouldn't be deleted when a category is deleted 
  -- (no action is equal to default which prevents the operation on category table)
  -- updates should cascade
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_pizza_category_map`
--
CREATE TABLE `tbl_pizza_category_map` (
  `id`                  INT(11)         NOT NULL AUTO_INCREMENT,
  `pizza_id`            INT(11)         DEFAULT NULL,
  `category_id`         INT(11)         DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `category_id_idx` (`category_id`),
  KEY `pizza_id_idx` (`pizza_id`),
  CONSTRAINT `fk__tbl_pizza_category_map_tbl_category` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  -- deletes and updates should cascade when category is modified
  CONSTRAINT `fk__tbl_pizza_category_map_tbl_pizza` FOREIGN KEY (`pizza_id`) REFERENCES `tbl_pizza` (`id`)  ON DELETE CASCADE ON UPDATE CASCADE
  -- deletes and updates should cascade when pizza is modified
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_address`
--
CREATE TABLE `tbl_address` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `full_name`           VARCHAR(256)        NOT NULL,
  `company`             VARCHAR(256)        DEFAULT NULL,
  `address_line_1`      VARCHAR(128)        NOT NULL,
  `address_line_2`      VARCHAR(256)        NOT NULL,
  `address_line_3`      VARCHAR(256)        DEFAULT NULL,
  -- only address line 3 is allowed to be NULL
  `city`                VARCHAR(256)        NOT NULL,
  `state`               VARCHAR(256)        NOT NULL,
  `postal_code`         VARCHAR(256)        NOT NULL,
  `country`             VARCHAR(256)        NOT NULL,
  `type`                INT(1)              NOT NULL,
  -- type is billing 1 or shipping 2
  `default_billing`     BOOLEAN             DEFAULT FALSE,
  -- flag representing if this is the default billing
  `default_shipping`    BOOLEAN             DEFAULT FALSE,
   -- flag representing if this is the default shipping

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_user`
--
CREATE TABLE `tbl_user` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `display_name`        VARCHAR(32)         NOT NULL,
  `first_name`          VARCHAR(32)         NOT NULL,
  `email`               VARCHAR(256)        NOT NULL,
  `password`            VARCHAR(256)        NOT NULL,
  `type`                INT(1)              DEFAULT '1',
  -- type takes 1:customer, 2:owner, 3: admin
  `yob`                 INT(4)              NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


CREATE TABLE `tbl_authorities` (
  `id`              INT(11)         NOT NULL AUTO_INCREMENT,
  `authority`       VARCHAR(255)    DEFAULT NULL,
  `user_account_id` INT(11)         DEFAULT NULL,

  PRIMARY KEY (`id`),
  KEY `user_account_id_idx` (`user_account_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;

--
-- Table structure for table `tbl_pizza_variant`
-- A Pizza Variant represents a single stock keeping unit (SKU) in the store’s inventory.
-- Whereas a Product/Pizza is a “container” of variants, the variant itself holds the data on price, tax category etc.
-- When one adds items to their cart, they are adding ProductVariants, not Products.
--
CREATE TABLE `tbl_pizza_variant` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `sku`                 VARCHAR(256)        NOT NULL,
  `price`               FLOAT(8,2)          NOT NULL,
  `tax`                 FLOAT(8,2)          DEFAULT 0,
  `qty_on_hand`         INT(11)             NOT NULL,
  `out_of_stock_limit`  INT(11)             NOT NULL,
  `on_sale`             INT(1)              DEFAULT 0,
  `pizza_id`            INT(11)             NOT NULL,

  PRIMARY KEY (`id`),
  KEY `pizza_id_idx` (`pizza_id`),
  CONSTRAINT `fk__tbl_pizza_variant_tbl_pizza` FOREIGN KEY (`pizza_id`) REFERENCES `tbl_pizza` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_order`
--
CREATE TABLE `tbl_order` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `user_id`             INT(11)             NOT NULL,
  `shipping_addr_id`    INT(11)             NOT NULL,
  `billing_addr_id`     INT(11)             NOT NULL,
  `order_state`         INT(1)              NOT NULL DEFAULT 1,
  -- 'order state gets these other values: 1:'AddingItems', 2:'OrderPlaced', 3:'Shipped', 4:'Delivered'
  `shipping_cost`       FLOAT(6,2)          NOT NULL DEFAULT 0,
  `shipping_tax`        FLOAT(6,2)          NOT NULL DEFAULT 0,
  `total`               FLOAT(12,2)         NULL,

  PRIMARY KEY (`id`),
  KEY `user_id_idx` (`user_id`),
  KEY `shipping_addr_id_idx` (`shipping_addr_id`),
  KEY `billing_addr_id_idx` (`billing_addr_id`),
  CONSTRAINT `fk__tbl_order_tbl_user` FOREIGN KEY (`user_id`) REFERENCES `tbl_user` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_order_tbl_address_ship` FOREIGN KEY (`shipping_addr_id`) REFERENCES `tbl_address` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_order_tbl_address_bill` FOREIGN KEY (`billing_addr_id`) REFERENCES `tbl_address` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_order_item`
--
CREATE TABLE `tbl_order_item` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `order_id`            INT(11)             NOT NULL,
  `pizza_variant_id`    INT(11)             NOT NULL,
  -- pizza_variant_id represents the sku bought
  `unit_price`          FLOAT(6,2)          NOT NULL,
  `quantity`            INT(100)            NOT NULL,
  `total_price`         FLOAT(8,2)          NOT NULL,

  PRIMARY KEY (`id`),
  KEY `order_id_idx` (`order_id`),
  KEY `pizza_variant_id_idx` (`pizza_variant_id`),
  CONSTRAINT `fk__tbl_order_item_tbl_order` FOREIGN KEY (`order_id`) REFERENCES `tbl_order` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_order_item_tbl_pizza_variant` FOREIGN KEY (`pizza_variant_id`) REFERENCES `tbl_pizza_variant` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_option_group`
-- This represents group of options/attributes.
--
CREATE TABLE `tbl_option_group` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `group`   		    VARCHAR(256)        NOT NULL,

  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_pizza_option`
-- This represents different attributes of Product/Pizza variants.
-- No 2 product variants will have the same product options
--
CREATE TABLE `tbl_option` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `option`              VARCHAR(256)        NOT NULL,
  `group_id`            INT(11)             NOT NULL,

  PRIMARY KEY (`id`),
  KEY `group_id_idx` (`group_id`),
  CONSTRAINT `fk__tbl_option_tbl_option_group` FOREIGN KEY (`group_id`) REFERENCES `tbl_option_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_pizza_option_group`
-- This represents which option groups applies to which products/pizzas.
--
CREATE TABLE `tbl_pizza_option_group` (
  `id`                  INT(11)             NOT NULL AUTO_INCREMENT,
  `pizza_id`            INT(11)             NOT NULL,
  `option_group_id`     INT(11)             NOT NULL,

  PRIMARY KEY (`id`),
  KEY `option_group_idx` (`option_group_id`),
  KEY `pizza_id_idx` (`pizza_id`),
  CONSTRAINT `fk__tbl_pizza_option_group_tbl_option_group` FOREIGN KEY (`option_group_id`) REFERENCES `tbl_option_group` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_pizza_option_group_tbl_pizza` FOREIGN KEY (`pizza_id`) REFERENCES `tbl_pizza` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1;



--
-- Table structure for table `tbl_pizza_variant_option_map`
-- This represents group of options/attributes that applies to pizzas variants (individual SKUs).
--
CREATE TABLE `tbl_pizza_variant_option_map` (
   `id`                 INT(11)             NOT NULL AUTO_INCREMENT,
  `pizza_variant_id`    INT(11)             NOT NULL,
  `pizza_option_id`     INT(11)             NOT NULL,

  KEY `pizza_variant_id_idx` (`pizza_variant_id`),
  KEY `pizza_option_idx` (`pizza_option_id`),
  PRIMARY KEY (`id`),
  CONSTRAINT `fk__tbl_pizza_variant_option_map_tbl_pizza_variant` FOREIGN KEY (`pizza_variant_id`) REFERENCES `tbl_pizza_variant` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk__tbl_pizza_variant_option_map_tbl_option` FOREIGN KEY (`pizza_option_id`) REFERENCES `tbl_option` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1;