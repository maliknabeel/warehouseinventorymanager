CREATE DATABASE  IF NOT EXISTS `vtb_pwi` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `vtb_pwi`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: vtb_pwi
-- ------------------------------------------------------
-- Server version	5.7.21-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand_product_type`
--

DROP TABLE IF EXISTS `brand_product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brand_product_type` (
  `id_product_type` int(11) NOT NULL AUTO_INCREMENT,
  `product_type` varchar(45) NOT NULL,
  `product_type_description` longtext,
  PRIMARY KEY (`id_product_type`),
  UNIQUE KEY `id_product_type_UNIQUE` (`id_product_type`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand_product_type`
--

LOCK TABLES `brand_product_type` WRITE;
/*!40000 ALTER TABLE `brand_product_type` DISABLE KEYS */;
INSERT INTO `brand_product_type` VALUES (1,'Finished','The product is completed and ready to be delived from ecommerce application.'),(2,'Component','This is a product that wil be used in some product to get it into finished state.'),(3,'Packaging','Not selleable and used to get a finished product.');
/*!40000 ALTER TABLE `brand_product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brandproductsentity`
--

DROP TABLE IF EXISTS `brandproductsentity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brandproductsentity` (
  `productId` int(11) NOT NULL,
  `brandName` varchar(255) DEFAULT NULL,
  `categotyName` varchar(255) DEFAULT NULL,
  `countryName` varchar(255) DEFAULT NULL,
  `productMeasurement` varchar(255) DEFAULT NULL,
  `productName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`productId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brandproductsentity`
--

LOCK TABLES `brandproductsentity` WRITE;
/*!40000 ALTER TABLE `brandproductsentity` DISABLE KEYS */;
/*!40000 ALTER TABLE `brandproductsentity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `brands`
--

DROP TABLE IF EXISTS `brands`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `brands` (
  `id_brands` int(11) NOT NULL AUTO_INCREMENT,
  `brand_name` varchar(45) NOT NULL,
  `brand_country` int(11) NOT NULL,
  `brand_description` varchar(45) DEFAULT NULL,
  `brand_category` int(11) NOT NULL,
  PRIMARY KEY (`id_brands`),
  UNIQUE KEY `id_brands_UNIQUE` (`id_brands`),
  KEY `brand_country_idx` (`brand_country`),
  KEY `brand_category_idx` (`brand_category`),
  CONSTRAINT `brand_category` FOREIGN KEY (`brand_category`) REFERENCES `categories` (`id_category`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `brand_country` FOREIGN KEY (`brand_country`) REFERENCES `country` (`id_country`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brands`
--

LOCK TABLES `brands` WRITE;
/*!40000 ALTER TABLE `brands` DISABLE KEYS */;
INSERT INTO `brands` VALUES (1,'Nikon',4,'This is brand is for cameras. ',3),(2,'VTB',4,'VTB makes facial and skin care products. ',4),(3,'Nivea',4,'This is a facial and skin care brand.',4);
/*!40000 ALTER TABLE `brands` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categories` (
  `id_category` int(11) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(45) NOT NULL,
  `category_description` longtext,
  PRIMARY KEY (`id_category`),
  UNIQUE KEY `id_brands_UNIQUE` (`id_category`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Cookies','A cookie is a baked or cooked food that is small, flat and sweet. It usually contains flour, sugar and some type of oil or fat. It may include other ingredients such as raisins, oats, chocolate chips, nuts, etc. In most English-speaking countries except for the United States and Canada, crisp cookies are called biscuits.'),(2,'Beverages','A drink or beverage is a liquid intended for human consumption. In addition to their basic function of satisfying thirst, drinks play important roles in human culture. Common types of drinks include plain water, milk, juices, coffee, tea, and soft drinks.'),(3,'Electronics','This category stores all products and brand information related to electronics.'),(4,'Facial and Skin ','The brands and products in this category belong to facial and skin products.');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `country` (
  `id_country` int(11) NOT NULL AUTO_INCREMENT,
  `country_code` varchar(45) NOT NULL,
  `country_name` varchar(45) NOT NULL,
  `country_continent` varchar(45) NOT NULL,
  PRIMARY KEY (`id_country`),
  UNIQUE KEY `id_country_UNIQUE` (`id_country`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'DXB','Dubai','Asia'),(2,'AUS','Australia','Oceania'),(3,'IRL','Ireland','Europe'),(4,'USA','United States','Northe America'),(5,'NLD','Netherlands','Europe'),(6,'ITA','Italy','Europe'),(7,'PAK','Pakistan','Asia'),(8,'MEX','Mexico','North America');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inventory`
--

DROP TABLE IF EXISTS `inventory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inventory` (
  `id_inventory` int(11) NOT NULL AUTO_INCREMENT,
  `inventory_product` int(11) NOT NULL,
  `inventory_product_pkging` int(11) NOT NULL,
  `finished_inventory_count` int(11) DEFAULT NULL,
  `inventory_in_stock` int(11) DEFAULT NULL,
  `inventory_in_transit` int(11) DEFAULT NULL,
  `inventory_avaliable_qty` int(11) DEFAULT NULL,
  `inventory_moq` int(11) DEFAULT NULL,
  `inventory_reorder_point` int(11) DEFAULT NULL,
  `warehouse_id` int(11) NOT NULL,
  PRIMARY KEY (`id_inventory`),
  UNIQUE KEY `id_inventory_UNIQUE` (`id_inventory`),
  KEY `product_id_idx` (`inventory_product`),
  KEY `pkging_id_idx` (`inventory_product_pkging`),
  KEY `product_fk_idx` (`inventory_product`),
  KEY `pkging_fk_idx` (`inventory_product_pkging`),
  KEY `warehouse_fk_idx` (`warehouse_id`),
  CONSTRAINT `pkging_fk` FOREIGN KEY (`inventory_product_pkging`) REFERENCES `product_pkging` (`id_product_pkging`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_fk` FOREIGN KEY (`inventory_product`) REFERENCES `products` (`id_products`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `warehouse_fk` FOREIGN KEY (`warehouse_id`) REFERENCES `warehouse` (`id_warehouse`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inventory`
--

LOCK TABLES `inventory` WRITE;
/*!40000 ALTER TABLE `inventory` DISABLE KEYS */;
INSERT INTO `inventory` VALUES (1,2,2,100,NULL,NULL,NULL,NULL,NULL,6),(2,3,3,1000,800,900,NULL,NULL,50,1),(3,4,2,100,900,800,1000,900,700,2);
/*!40000 ALTER TABLE `inventory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `measurement`
--

DROP TABLE IF EXISTS `measurement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `measurement` (
  `id_product_measurement` int(11) NOT NULL AUTO_INCREMENT,
  `product_measurement_size` varchar(45) NOT NULL,
  `product_measurement_description` longtext,
  `product_measurement_unit` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_product_measurement`),
  UNIQUE KEY `id_product_pkging_UNIQUE` (`id_product_measurement`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `measurement`
--

LOCK TABLES `measurement` WRITE;
/*!40000 ALTER TABLE `measurement` DISABLE KEYS */;
INSERT INTO `measurement` VALUES (1,'100ml','This is 100ml pacage size.','ml'),(2,'250ml','This is 250ml packaging size. ','ml'),(3,'1000ml','This is 1000ml packaging size.','ml'),(4,'small','This is small size of packaging. ',NULL),(5,'1500ml','This is a 1500 ml package size.','ml');
/*!40000 ALTER TABLE `measurement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `offices`
--

DROP TABLE IF EXISTS `offices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `offices` (
  `id_offices` int(11) NOT NULL AUTO_INCREMENT,
  `office_name` varchar(45) DEFAULT NULL,
  `office_address` varchar(45) DEFAULT NULL,
  `offices_country` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_offices`),
  UNIQUE KEY `id_offices_UNIQUE` (`id_offices`),
  KEY `office_country_idx` (`offices_country`),
  CONSTRAINT `office_country` FOREIGN KEY (`offices_country`) REFERENCES `country` (`id_country`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `offices`
--

LOCK TABLES `offices` WRITE;
/*!40000 ALTER TABLE `offices` DISABLE KEYS */;
INSERT INTO `offices` VALUES (1,'Headoffice','Head Office',4),(2,'Regional Office','Main Regional Office',7),(3,'Sub-Site Office','Sub-Site Office',7),(4,'Regional Office','Main Regional Office',8);
/*!40000 ALTER TABLE `offices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pkging_information`
--

DROP TABLE IF EXISTS `pkging_information`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pkging_information` (
  `id_pkging_info` int(11) NOT NULL AUTO_INCREMENT,
  `pkging_size` int(11) NOT NULL,
  `pkging_unit` varchar(45) NOT NULL,
  PRIMARY KEY (`id_pkging_info`),
  UNIQUE KEY `id_finished_product_pkging_UNIQUE` (`id_pkging_info`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pkging_information`
--

LOCK TABLES `pkging_information` WRITE;
/*!40000 ALTER TABLE `pkging_information` DISABLE KEYS */;
INSERT INTO `pkging_information` VALUES (1,12,'units'),(2,80,'units'),(3,80,'pcs');
/*!40000 ALTER TABLE `pkging_information` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_measurements`
--

DROP TABLE IF EXISTS `product_measurements`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_measurements` (
  `idproduct_measurements` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) NOT NULL,
  `measurement_id` int(11) NOT NULL,
  PRIMARY KEY (`idproduct_measurements`),
  UNIQUE KEY `idproduct_measurements_UNIQUE` (`idproduct_measurements`),
  KEY `product_id_idx` (`product_id`),
  KEY `measurement_id_idx` (`measurement_id`),
  CONSTRAINT `measurement_id_fk` FOREIGN KEY (`measurement_id`) REFERENCES `measurement` (`id_product_measurement`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_id_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id_products`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_measurements`
--

LOCK TABLES `product_measurements` WRITE;
/*!40000 ALTER TABLE `product_measurements` DISABLE KEYS */;
INSERT INTO `product_measurements` VALUES (1,2,1),(2,2,2),(3,4,3),(4,4,5);
/*!40000 ALTER TABLE `product_measurements` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product_pkging`
--

DROP TABLE IF EXISTS `product_pkging`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product_pkging` (
  `id_product_pkging` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `pkging_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_product_pkging`),
  UNIQUE KEY `id_product_pkging_UNIQUE` (`id_product_pkging`),
  KEY `product_id_idx` (`product_id`),
  KEY `pkging_id_idx` (`pkging_id`),
  CONSTRAINT `pkging_id` FOREIGN KEY (`pkging_id`) REFERENCES `pkging_information` (`id_pkging_info`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_id` FOREIGN KEY (`product_id`) REFERENCES `products` (`id_products`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product_pkging`
--

LOCK TABLES `product_pkging` WRITE;
/*!40000 ALTER TABLE `product_pkging` DISABLE KEYS */;
INSERT INTO `product_pkging` VALUES (1,2,2),(2,2,1),(3,3,2);
/*!40000 ALTER TABLE `product_pkging` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `products` (
  `id_products` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(45) NOT NULL,
  `product_brand` int(11) NOT NULL,
  `product_country` int(11) NOT NULL,
  `product_type` int(11) NOT NULL,
  PRIMARY KEY (`id_products`),
  UNIQUE KEY `id_products_UNIQUE` (`id_products`),
  KEY `product_brand_idx` (`product_brand`),
  KEY `product_type_idx` (`product_type`),
  KEY `product_country_idx` (`product_country`),
  CONSTRAINT `product_brand` FOREIGN KEY (`product_brand`) REFERENCES `brands` (`id_brands`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_country` FOREIGN KEY (`product_country`) REFERENCES `country` (`id_country`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `product_type` FOREIGN KEY (`product_type`) REFERENCES `brand_product_type` (`id_product_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (2,'Nivea Cream',3,4,1),(3,'VTB Facial',2,4,1),(4,'Nivea Lotion',3,4,1),(5,'Nivea Cream',3,4,1);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `warehouse`
--

DROP TABLE IF EXISTS `warehouse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `warehouse` (
  `id_warehouse` int(11) NOT NULL AUTO_INCREMENT,
  `warehouse_name` varchar(45) NOT NULL,
  `warehouse_address` varchar(45) NOT NULL,
  `warehouse_country` int(11) NOT NULL,
  PRIMARY KEY (`id_warehouse`),
  UNIQUE KEY `id_warehouse_UNIQUE` (`id_warehouse`),
  KEY `warehouse_country_idx` (`warehouse_country`),
  CONSTRAINT `warehouse_country` FOREIGN KEY (`warehouse_country`) REFERENCES `country` (`id_country`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `warehouse`
--

LOCK TABLES `warehouse` WRITE;
/*!40000 ALTER TABLE `warehouse` DISABLE KEYS */;
INSERT INTO `warehouse` VALUES (1,'Warehouse - 1','Main Warehouse , Down Town',4),(2,'Warehouse - 2','Transit Warehouse , UpTown',4),(4,'Warehouse - 5','Boarder Area',8),(5,'Warehouse - 3','Dry Port',7),(6,'Warehouse - 6','Qasim Port',7);
/*!40000 ALTER TABLE `warehouse` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-04-29 17:11:47
