
DROP TABLE IF EXISTS `tbl_pizza_category_map`;
DROP TABLE IF EXISTS `tbl_pizza`;
DROP TABLE IF EXISTS `tbl_category`;

--
-- Table structure for table `pizza_category`
--

CREATE TABLE `tbl_category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1;


--
-- Table structure for table `pizza`
--

CREATE TABLE `tbl_pizza` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `price` decimal(45,2) DEFAULT NULL,
  `desc` varchar(500) DEFAULT NULL,
  `category_default` int(11) DEFAULT NULL,
  `quantity` integer(11) DEFAULT NULL,
  `tax` decimal(45,2) DEFAULT NULL,
  `on_sale` int(1) DEFAULT NULL,
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
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `pizza_id` int(11) DEFAULT NULL,
  `category_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_category_idx` (`category_id`),
  KEY `fk_pizza_idx` (`pizza_id`),
  CONSTRAINT `fk_category_id` FOREIGN KEY (`category_id`) REFERENCES `tbl_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  -- deletes and updates should cascade when category is touched
  CONSTRAINT `fk_pizza_id` FOREIGN KEY (`pizza_id`) REFERENCES `tbl_pizza` (`id`)  ON DELETE CASCADE ON UPDATE CASCADE
  -- deletes and updates should cascade when pizza is tocuhed
) ENGINE=InnoDB AUTO_INCREMENT=1;