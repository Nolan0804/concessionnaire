-- MySQL dump 10.13  Distrib 8.0.46, for Win64 (x86_64)
--
-- Host: localhost    Database: cardealer
-- ------------------------------------------------------
-- Server version	8.0.46

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `brand`
--

DROP TABLE IF EXISTS `brand`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `brand` (
  `name` varchar(50) NOT NULL,
  `year_created` int NOT NULL,
  `origin_country` varchar(60) NOT NULL,
  PRIMARY KEY (`name`),
  KEY `fk_brand_country` (`origin_country`),
  CONSTRAINT `fk_brand_country` FOREIGN KEY (`origin_country`) REFERENCES `country` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `brand`
--

LOCK TABLES `brand` WRITE;
/*!40000 ALTER TABLE `brand` DISABLE KEYS */;
INSERT INTO `brand` VALUES ('Alfa Romeo',1910,'Italy'),('Aston Martin',1913,'United Kingdom'),('Audi',1909,'Germany'),('Bentley',1919,'United Kingdom'),('BMW',1916,'Germany'),('Bugatti',1909,'France'),('BYD',1995,'China'),('Cadillac',1902,'USA'),('Chevrolet',1911,'USA'),('Citroen',1919,'France'),('Dacia',1966,'Romania'),('Dodge',1900,'USA'),('Ferrari',1939,'Italy'),('Fiat',1899,'Italy'),('Ford',1903,'USA'),('Geely',1986,'China'),('Genesis',2015,'South Korea'),('Honda',1948,'Japan'),('Hyundai',1967,'South Korea'),('Jaguar',1922,'United Kingdom'),('Jeep',1941,'USA'),('Kia',1944,'South Korea'),('Koenigsegg',1994,'Sweden'),('Lamborghini',1963,'Italy'),('Land Rover',1948,'United Kingdom'),('Lexus',1989,'Japan'),('Maserati',1914,'Italy'),('Mazda',1920,'Japan'),('Mercedes-Benz',1926,'Germany'),('Mini',1969,'United Kingdom'),('Mitsubishi',1890,'Japan'),('NIO',2014,'China'),('Nissan',1933,'Japan'),('Opel',1887,'Germany'),('Peugeot',1890,'France'),('Porsche',1931,'Germany'),('Renault',1899,'France'),('Rolls-Royce',1904,'United Kingdom'),('Seat',1950,'Spain'),('Skoda',1895,'Czech Republic'),('Subaru',1953,'Japan'),('Suzuki',1909,'Japan'),('Tata',1945,'India'),('Tesla',2003,'USA'),('Toyota',1937,'Japan'),('Volkswagen',1937,'Germany'),('Volvo',1927,'Sweden');
/*!40000 ALTER TABLE `brand` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `configuration` (
  `option_name` varchar(60) NOT NULL,
  `vin_vehicle` varchar(17) NOT NULL,
  PRIMARY KEY (`option_name`,`vin_vehicle`),
  KEY `fk_configuration_vehicle` (`vin_vehicle`),
  CONSTRAINT `fk_configuration_option` FOREIGN KEY (`option_name`) REFERENCES `option` (`name`),
  CONSTRAINT `fk_configuration_vehicle` FOREIGN KEY (`vin_vehicle`) REFERENCES `vehicle` (`vin`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration`
--

LOCK TABLES `configuration` WRITE;
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` VALUES ('Bluetooth','1HGCM82633A482751'),('GPS','1HGCM82633A482751'),('Leather Seats','1HGCM82633A482751'),('Heated Seats','JT123456789ABCDEF'),('GPS','JTDKN3DU7A1293846'),('Lane Assist','JTDKN3DU7A1293846'),('Bluetooth','VF1RFB00865473921'),('Wireless Charging','VF1RFB00865473921'),('360 Camera','WA1LFAFP8CA672845'),('LED Matrix','WA1LFAFP8CA672845'),('Parking Camera','WAU987654321ABCDE'),('Sunroof','WAU987654321ABCDE'),('Premium Audio','WAUZZZF42MN847362'),('Sport Pack','WAUZZZF42MN847362'),('GPS','WBA123456789ABCDE'),('Leather Seats','WBA123456789ABCDE'),('Adaptive Cruise Control','WBA8E9G51HNU38274'),('Parking Camera','WBA8E9G51HNU38274');
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `country`
--

DROP TABLE IF EXISTS `country`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `country` (
  `name` varchar(60) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES ('Albania'),('Andorra'),('Argentina'),('Australia'),('Austria'),('Belgium'),('Bosnia and Herzegovina'),('Brazil'),('Bulgaria'),('Canada'),('China'),('Croatia'),('Cyprus'),('Czech Republic'),('Denmark'),('Estonia'),('Finland'),('France'),('Germany'),('Greece'),('Hungary'),('Iceland'),('India'),('Ireland'),('Italy'),('Japan'),('Kosovo'),('Latvia'),('Liechtenstein'),('Lithuania'),('Luxembourg'),('Malta'),('Mexico'),('Moldova'),('Monaco'),('Montenegro'),('Netherlands'),('New Zealand'),('North Macedonia'),('Norway'),('Poland'),('Portugal'),('Romania'),('San Marino'),('Serbia'),('Slovakia'),('Slovenia'),('South Africa'),('South Korea'),('Spain'),('Sweden'),('Switzerland'),('Ukraine'),('United Kingdom'),('USA'),('Vatican City');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `customer_number` int NOT NULL,
  `name` varchar(30) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(255) NOT NULL,
  `birthday_date` date DEFAULT NULL,
  `postal_code` int NOT NULL,
  `locality_name` varchar(100) NOT NULL,
  PRIMARY KEY (`customer_number`),
  KEY `fk_customer_locality` (`postal_code`,`locality_name`),
  CONSTRAINT `customer_chk_1` CHECK ((`customer_number` between 1 and 99999999)),
  CONSTRAINT `customer_chk_2` CHECK (regexp_like(`phone_number`,_utf8mb4'^\\+[0-9]{2,3}[0-9 ]+$')),
  CONSTRAINT `customer_chk_3` CHECK ((`email` like _utf8mb4'%@%.%')),
  CONSTRAINT `customer_chk_4` CHECK ((char_length(`phone_number`) >= 8))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Dupont','Jean','jean.dupont@gmail.com','+32471234567','Rue de la Loi 1','1990-05-12',1000,'Brussels'),(2,'Martin','Claire','claire.martin@gmail.com','+33612345678','Avenue Victor Hugo','1985-03-20',75000,'Paris'),(3,'Smith','John','john.smith@gmail.com','+15551234567','5th Avenue','1992-11-01',10001,'New York'),(4,'Leroy','Sophie','sophie.leroy@gmail.com','+32470111222','Rue du Centre 12','1991-08-10',4000,'Liege'),(5,'Bernard','Lucas','lucas.bernard@gmail.com','+32473334455','Avenue Louise 50','1988-01-15',1000,'Brussels'),(6,'Petit','Emma','emma.petit@gmail.com','+33699887766','Rue Nationale 20','1995-07-02',59000,'Lille'),(7,'Garcia','Carlos','carlos.garcia@gmail.com','+34666777888','Gran Via 45','1987-11-23',28001,'Madrid'),(8,'Muller','Anna','anna.muller@gmail.com','+491511223344','Alexanderplatz 8','1993-09-14',10115,'Berlin'),(9,'Dubois','Nicolas','nicolas.dubois@gmail.com','+33644556677','Boulevard Voltaire 11','1990-12-19',75001,'Paris'),(10,'Johnson','Emily','emily.johnson@gmail.com','+15559876543','Sunset Boulevard 9','1996-04-08',90001,'Los Angeles'),(11,'Tanaka','Hiroshi','hiroshi.tanaka@gmail.com','+81399887766','Shibuya Street 2','1984-06-30',1000001,'Tokyo');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `energy`
--

DROP TABLE IF EXISTS `energy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `energy` (
  `type` varchar(30) NOT NULL,
  `is_eco_friendly` tinyint(1) NOT NULL,
  PRIMARY KEY (`type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `energy`
--

LOCK TABLES `energy` WRITE;
/*!40000 ALTER TABLE `energy` DISABLE KEYS */;
INSERT INTO `energy` VALUES ('Diesel',0),('Electric',1),('Hybrid',1),('Hydrogen',1),('LPG',1),('Petrol',0);
/*!40000 ALTER TABLE `energy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `entretien`
--

DROP TABLE IF EXISTS `entretien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `entretien` (
  `date` date NOT NULL,
  `vin_number` varchar(17) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `annotation` varchar(255) DEFAULT NULL,
  `kilometer` decimal(10,2) NOT NULL,
  PRIMARY KEY (`date`,`vin_number`),
  KEY `fk_entretien_vehicle` (`vin_number`),
  CONSTRAINT `fk_entretien_vehicle` FOREIGN KEY (`vin_number`) REFERENCES `vehicle` (`vin`),
  CONSTRAINT `entretien_chk_1` CHECK ((`kilometer` between 0 and 999999.99))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `entretien`
--

LOCK TABLES `entretien` WRITE;
/*!40000 ALTER TABLE `entretien` DISABLE KEYS */;
INSERT INTO `entretien` VALUES ('2024-02-01','WBA123456789ABCDE','Oil change','Everything OK',43000.00),('2024-04-10','WAU987654321ABCDE','Brake replacement','Front brakes replaced',11000.00),('2026-02-10','1HGCM82633A482751','Oil change','Everything OK',15500.00),('2026-02-15','WBA8E9G51HNU38274','Brake replacement','Front brakes replaced',22500.00),('2026-02-18','JTDKN3DU7A1293846','Battery inspection','Hybrid system checked',8500.00),('2026-02-20','WAUZZZF42MN847362','Engine maintenance','No issue detected',30200.00),('2026-02-22','VF1RFB00865473921','Tire replacement','4 tires replaced',12500.00),('2026-02-25','JTDBR32E720184563','Annual maintenance','Vehicle in good condition',5200.00);
/*!40000 ALTER TABLE `entretien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `garanty`
--

DROP TABLE IF EXISTS `garanty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `garanty` (
  `type` varchar(30) NOT NULL,
  `duration` int NOT NULL,
  PRIMARY KEY (`type`),
  CONSTRAINT `garanty_chk_1` CHECK ((`duration` between 1 and 120))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `garanty`
--

LOCK TABLES `garanty` WRITE;
/*!40000 ALTER TABLE `garanty` DISABLE KEYS */;
INSERT INTO `garanty` VALUES ('Basic',12),('Gold',24),('Premium',36);
/*!40000 ALTER TABLE `garanty` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locality`
--

DROP TABLE IF EXISTS `locality`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locality` (
  `postal_code` int NOT NULL,
  `name` varchar(100) NOT NULL,
  `country_name` varchar(60) NOT NULL,
  PRIMARY KEY (`postal_code`,`name`,`country_name`),
  KEY `fk_locality_country` (`country_name`),
  CONSTRAINT `fk_locality_country` FOREIGN KEY (`country_name`) REFERENCES `country` (`name`),
  CONSTRAINT `locality_chk_1` CHECK ((`postal_code` between 1 and 99999999))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locality`
--

LOCK TABLES `locality` WRITE;
/*!40000 ALTER TABLE `locality` DISABLE KEYS */;
INSERT INTO `locality` VALUES (2000,'Sydney','Australia'),(3000,'Melbourne','Australia'),(1010,'Vienna','Austria'),(1000,'Brussels','Belgium'),(2000,'Antwerp','Belgium'),(4000,'Liege','Belgium'),(5000,'Namur','Belgium'),(6000,'Charleroi','Belgium'),(7000,'Mons','Belgium'),(8000,'Bruges','Belgium'),(9000,'Ghent','Belgium'),(1000,'Montreal','Canada'),(2000,'Toronto','Canada'),(3000,'Vancouver','Canada'),(100000,'Beijing','China'),(200000,'Shanghai','China'),(11000,'Prague','Czech Republic'),(1000,'Copenhagen','Denmark'),(100,'Helsinki','Finland'),(13001,'Marseille','France'),(31000,'Toulouse','France'),(33000,'Bordeaux','France'),(44000,'Nantes','France'),(59000,'Lille','France'),(67000,'Strasbourg','France'),(69001,'Lyon','France'),(75001,'Paris','France'),(10115,'Berlin','Germany'),(20095,'Hamburg','Germany'),(40213,'Dusseldorf','Germany'),(50667,'Cologne','Germany'),(60311,'Frankfurt','Germany'),(80331,'Munich','Germany'),(10552,'Athens','Greece'),(110001,'New Delhi','India'),(400001,'Mumbai','India'),(1,'Dublin','Ireland'),(100,'Rome','Italy'),(10100,'Turin','Italy'),(20100,'Milan','Italy'),(80100,'Naples','Italy'),(1000001,'Tokyo','Japan'),(4600001,'Nagoya','Japan'),(5300001,'Osaka','Japan'),(1011,'Amsterdam','Netherlands'),(2511,'The Hague','Netherlands'),(3011,'Rotterdam','Netherlands'),(150,'Oslo','Norway'),(1,'Warsaw','Poland'),(30001,'Krakow','Poland'),(1000,'Lisbon','Portugal'),(4000,'Porto','Portugal'),(10000,'Bucharest','Romania'),(48058,'Busan','South Korea'),(100011,'Seoul','South Korea'),(8001,'Barcelona','Spain'),(28001,'Madrid','Spain'),(41001,'Seville','Spain'),(46001,'Valencia','Spain'),(11120,'Stockholm','Sweden'),(41103,'Gothenburg','Sweden'),(1201,'Geneva','Switzerland'),(8001,'Zurich','Switzerland'),(1001,'London','United Kingdom'),(2001,'Manchester','United Kingdom'),(3001,'Liverpool','United Kingdom'),(4001,'Birmingham','United Kingdom'),(10001,'New York','USA'),(33101,'Miami','USA'),(60601,'Chicago','USA'),(77001,'Houston','USA'),(90001,'Los Angeles','USA');
/*!40000 ALTER TABLE `locality` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `option`
--

DROP TABLE IF EXISTS `option`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `option` (
  `name` varchar(60) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `value` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`name`),
  CONSTRAINT `option_chk_1` CHECK (((`value` is null) or (`value` >= 0)))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `option`
--

LOCK TABLES `option` WRITE;
/*!40000 ALTER TABLE `option` DISABLE KEYS */;
INSERT INTO `option` VALUES ('360 Camera','360 degree parking camera',950.00),('Adaptive Cruise Control','Automatic adaptive speed control',850.00),('Bluetooth','Wireless smartphone connectivity',250.00),('GPS','Integrated navigation system',500.00),('Heated Seats','Front heated seats',350.00),('Lane Assist','Lane departure assistance',650.00),('Leather Seats','Premium leather interior',1200.00),('LED Matrix','Advanced LED headlights',1400.00),('Parking Camera','Rear parking camera',400.00),('Premium Audio','High-end sound system',1100.00),('Sport Pack','Sport exterior package',2000.00),('Sunroof','Electric panoramic roof',900.00),('Wireless Charging','Wireless phone charging station',180.00);
/*!40000 ALTER TABLE `option` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sale`
--

DROP TABLE IF EXISTS `sale`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sale` (
  `date` date NOT NULL,
  `vin_vehicle` varchar(17) NOT NULL,
  `payment_method` varchar(30) NOT NULL,
  `state` varchar(30) NOT NULL,
  `customer_number` int NOT NULL,
  PRIMARY KEY (`date`,`vin_vehicle`),
  KEY `fk_sale_vehicle` (`vin_vehicle`),
  KEY `fk_sale_customer` (`customer_number`),
  CONSTRAINT `fk_sale_customer` FOREIGN KEY (`customer_number`) REFERENCES `customer` (`customer_number`),
  CONSTRAINT `fk_sale_vehicle` FOREIGN KEY (`vin_vehicle`) REFERENCES `vehicle` (`vin`),
  CONSTRAINT `sale_chk_1` CHECK ((`payment_method` in (_utf8mb4'Cash',_utf8mb4'Card',_utf8mb4'Bank Transfer',_utf8mb4'Financing'))),
  CONSTRAINT `sale_chk_2` CHECK ((`state` in (_utf8mb4'Pending',_utf8mb4'Completed',_utf8mb4'Cancelled')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES ('2024-05-15','WBA123456789ABCDE','Bank Transfer','Completed',1),('2026-04-01','1HGCM82633A482751','Bank Transfer','Completed',1),('2026-04-03','WBA8E9G51HNU38274','Card','Completed',2),('2026-04-05','JTDKN3DU7A1293846','Financing','Pending',4),('2026-04-07','VF1RFB00865473921','Cash','Completed',6);
/*!40000 ALTER TABLE `sale` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trial`
--

DROP TABLE IF EXISTS `trial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trial` (
  `date` date NOT NULL,
  `vin_number` varchar(17) NOT NULL,
  `duration` int NOT NULL,
  `comment` varchar(255) DEFAULT NULL,
  `is_potential_sale` tinyint(1) NOT NULL,
  `customer_number` int NOT NULL,
  PRIMARY KEY (`date`,`vin_number`),
  KEY `fk_trial_vehicle` (`vin_number`),
  KEY `fk_trial_customer` (`customer_number`),
  CONSTRAINT `fk_trial_customer` FOREIGN KEY (`customer_number`) REFERENCES `customer` (`customer_number`),
  CONSTRAINT `fk_trial_vehicle` FOREIGN KEY (`vin_number`) REFERENCES `vehicle` (`vin`),
  CONSTRAINT `trial_chk_1` CHECK ((`duration` between 1 and 180))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trial`
--

LOCK TABLES `trial` WRITE;
/*!40000 ALTER TABLE `trial` DISABLE KEYS */;
INSERT INTO `trial` VALUES ('2024-05-01','WAU987654321ABCDE',45,'Very comfortable car',1,1),('2024-05-03','JT123456789ABCDEF',30,'Customer interested',1,2),('2026-03-01','1HGCM82633A482751',45,'Customer liked comfort',1,1),('2026-03-02','WBA8E9G51HNU38274',30,'Interested in financing',1,2),('2026-03-03','JTDKN3DU7A1293846',60,'Very smooth drive',1,4),('2026-03-04','WAUZZZF42MN847362',25,'Powerful vehicle',1,5),('2026-03-05','VF1RFB00865473921',40,'Compact and practical',0,6),('2026-03-06','WA1LFAFP8CA672845',50,'Customer considering purchase',1,7);
/*!40000 ALTER TABLE `trial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vehicle`
--

DROP TABLE IF EXISTS `vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `vehicle` (
  `vin` varchar(17) NOT NULL,
  `kilometer` decimal(10,2) NOT NULL,
  `arrival_date` date NOT NULL,
  `sale_price` decimal(8,2) NOT NULL,
  `purchase_price` decimal(8,2) NOT NULL,
  `registration` varchar(20) DEFAULT NULL,
  `power` int NOT NULL,
  `gear_box_type` varchar(9) NOT NULL,
  `gear_number` int NOT NULL,
  `door_number` int NOT NULL,
  `seat_number` int NOT NULL,
  `information` varchar(255) DEFAULT NULL,
  `euro_standard` int NOT NULL,
  `is_vat_deductible` tinyint(1) NOT NULL,
  `production_year` year NOT NULL,
  `garanty_type` varchar(30) NOT NULL,
  `hex_color` varchar(7) NOT NULL,
  `type_color` varchar(30) NOT NULL,
  `energy` varchar(30) NOT NULL,
  `brand_name` varchar(50) NOT NULL,
  `state` varchar(50) NOT NULL,
  `saler` int NOT NULL,
  PRIMARY KEY (`vin`),
  UNIQUE KEY `registration_UNIQUE` (`registration`),
  KEY `fk_vehicle_garanty` (`garanty_type`),
  KEY `fk_vehicle_color` (`hex_color`,`type_color`),
  KEY `fk_vehicle_energy` (`energy`),
  KEY `fk_vehicle_brand` (`brand_name`),
  KEY `fk_vehicle_state` (`state`),
  KEY `fk_vehicle_saler` (`saler`),
  CONSTRAINT `fk_vehicle_brand` FOREIGN KEY (`brand_name`) REFERENCES `brand` (`name`),
  CONSTRAINT `fk_vehicle_energy` FOREIGN KEY (`energy`) REFERENCES `energy` (`type`),
  CONSTRAINT `fk_vehicle_garanty` FOREIGN KEY (`garanty_type`) REFERENCES `garanty` (`type`),
  CONSTRAINT `fk_vehicle_saler` FOREIGN KEY (`saler`) REFERENCES `customer` (`customer_number`),
  CONSTRAINT `vehicle_chk_1` CHECK ((char_length(`vin`) = 17)),
  CONSTRAINT `vehicle_chk_10` CHECK ((`door_number` between 3 and 5)),
  CONSTRAINT `vehicle_chk_11` CHECK ((`seat_number` between 1 and 9)),
  CONSTRAINT `vehicle_chk_12` CHECK ((`euro_standard` between 1 and 7)),
  CONSTRAINT `vehicle_chk_2` CHECK ((`production_year` >= 1886)),
  CONSTRAINT `vehicle_chk_3` CHECK ((`kilometer` between 0 and 999999.99)),
  CONSTRAINT `vehicle_chk_4` CHECK ((`sale_price` between 0 and 999999.99)),
  CONSTRAINT `vehicle_chk_5` CHECK ((`purchase_price` between 0 and 999999.99)),
  CONSTRAINT `vehicle_chk_6` CHECK ((`sale_price` >= `purchase_price`)),
  CONSTRAINT `vehicle_chk_7` CHECK ((`power` between 1 and 1000)),
  CONSTRAINT `vehicle_chk_8` CHECK ((`gear_box_type` in (_utf8mb4'Automatic',_utf8mb4'Manual'))),
  CONSTRAINT `vehicle_chk_9` CHECK ((`gear_number` between 5 and 8))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vehicle`
--

LOCK TABLES `vehicle` WRITE;
/*!40000 ALTER TABLE `vehicle` DISABLE KEYS */;
INSERT INTO `vehicle` VALUES ('1HGCM82633A482751',15000.00,'2026-01-10',28000.00,24000.00,'AA-101-AA',210,'Automatic',6,5,5,'Audi A3 S-Line',6,1,2021,'Gold','#111111','Glossy','Diesel','Audi','Sold',4),('2HGFG11869H274851',11200.00,'2026-05-12',25000.00,21000.00,'YU-225-DF',185,'Manual',6,5,5,'Ford Kuga',6,1,2020,'Premium','#0044AA','Glossy','Petrol','Ford','Good',4),('5YJ3E1EA7JF000001',15221.44,'2025-01-12',45900.00,41200.00,'CAR-1001',325,'Automatic',8,5,5,'Tesla Model 3',7,1,2024,'Gold','#111111','Metallic','Electric','Tesla','New',1),('5YJSA1DN5DFP14752',44000.00,'2026-04-25',89000.00,84000.00,'TY-118-ZA',250,'Automatic',7,5,5,'BMW i5 Electric',7,1,2025,'Gold','#FFFFFF','Glossy','Electric','BMW','New',11),('5YJSA1E26HF000011',22112.00,'2025-01-11',53800.00,49200.00,'CAR-1011',410,'Automatic',8,5,5,'Tesla Model S',7,1,2024,'Gold','#2F4F4F','Metallic','Electric','Tesla','New',1),('5YJXCDE22HF000021',19222.22,'2025-01-18',61200.00,55900.00,'CAR-1021',450,'Automatic',8,5,7,'Tesla Model X',7,1,2025,'Gold','#000000','Metallic','Electric','Tesla','New',1),('JH4KA9650MC012874',9500.00,'2026-04-12',24000.00,21000.00,'MN-447-QS',190,'Manual',5,5,5,'Renault Captur',5,1,2020,'Basic','#DDDDDD','Matte','Petrol','Renault','Good',5),('JHMCM56557C384729',13400.00,'2026-05-18',29500.00,25500.00,'QA-661-TR',195,'Automatic',6,5,5,'Toyota Corolla Touring',6,1,2021,'Premium','#999999','Glossy','Hybrid','Toyota','Excellent',7),('JN1BJ1CP7JW184736',6400.00,'2026-05-08',17000.00,14500.00,'LO-642-GH',165,'Manual',5,5,5,'Toyota Yaris',5,0,2018,'Basic','#EEEEEE','Matte','Petrol','Toyota','Used',10),('JN1BJ1CR5HW000004',102331.11,'2025-01-28',13200.00,10500.00,'CAR-1004',110,'Manual',6,5,5,'Nissan Qashqai',5,0,2016,'Basic','#0000FF','Glossy','Diesel','Nissan','Average',4),('JN1CV6EK9DM000024',109221.00,'2025-01-31',11800.00,9100.00,'CAR-1024',115,'Manual',6,5,5,'Nissan Micra',5,0,2016,'Basic','#0000FF','Glossy','Petrol','Nissan','Average',4),('JN8AS5MT9CW000014',118522.20,'2025-01-29',9800.00,7600.00,'CAR-1014',102,'Manual',5,5,5,'Nissan Juke',4,0,2015,'Basic','#8B0000','Glossy','Petrol','Nissan','Sold',4),('JS2YB5A35C6000012',93114.77,'2025-02-21',11900.00,9300.00,'CAR-1012',98,'Manual',5,5,5,'Suzuki Vitara',5,0,2017,'Basic','#CD853F','Glossy','Petrol','Suzuki','Average',2),('JS2YC5A34D6000022',72111.77,'2025-02-15',14200.00,11200.00,'CAR-1022',105,'Manual',5,5,5,'Suzuki S-Cross',5,0,2018,'Basic','#FFFFFF','Glossy','Petrol','Suzuki','Average',2),('JSAAZC21S00100002',84211.20,'2025-02-03',12800.00,9900.00,'CAR-1002',95,'Manual',5,5,5,'Suzuki Swift',5,0,2017,'Basic','#FFFFFF','Glossy','Petrol','Suzuki','Average',2),('JT123456789ABCDEF',45000.00,'2024-01-15',25000.00,18000.00,'1-ABC-123',190,'Automatic',6,5,5,'BMW Serie 3 full option',6,1,2020,'Premium','#000000','Glossy','Diesel','BMW','Excellent',1),('JTDBR32E720184563',5000.00,'2026-01-25',60000.00,52000.00,'FF-606-FF',170,'Automatic',5,5,5,'Toyota Yaris Hybrid',5,1,2020,'Basic','#CCCCCC','Glossy','Hybrid','Toyota','Correct',9),('JTDKARFU8J3000025',35522.11,'2025-04-05',31400.00,27100.00,'CAR-1025',235,'Automatic',8,5,5,'Toyota Corolla',7,1,2024,'Gold','#FF0000','Metallic','Hybrid','Toyota','New',5),('JTDKB20U793412875',12700.00,'2026-05-01',26000.00,22000.00,'ER-229-VB',185,'Automatic',6,5,5,'Ford Focus ST',6,1,2020,'Premium','#880000','Glossy','Petrol','Ford','Good',6),('JTDKN3DU0A0000005',28221.88,'2025-04-08',28700.00,24300.00,'CAR-1005',205,'Automatic',8,5,5,'Toyota Prius',7,1,2023,'Gold','#FF0000','Metallic','Hybrid','Toyota','New',5),('JTDKN3DU7A1293846',8000.00,'2026-01-14',42000.00,37000.00,'CC-303-CC',180,'Automatic',6,5,5,'Toyota Corolla Hybrid',6,1,2022,'Gold','#00AA00','Glossy','Hybrid','Toyota','Sold',6),('JTHBK1EG9F2000009',41220.55,'2025-02-27',31800.00,27200.00,'CAR-1009',245,'Automatic',8,5,5,'Lexus RX',7,1,2022,'Gold','#800080','Metallic','Hybrid','Lexus','New',4),('JTHCE1BL0FA000019',29888.44,'2025-02-26',38700.00,33900.00,'CAR-1019',285,'Automatic',8,5,5,'Lexus ES',7,1,2023,'Gold','#9370DB','Metallic','Hybrid','Lexus','New',4),('JTHKD5BH5F2000029',24410.77,'2025-02-22',40500.00,35600.00,'CAR-1029',310,'Automatic',8,5,5,'Lexus NX',7,1,2024,'Gold','#800080','Metallic','Hybrid','Lexus','New',4),('JTNB11HK303000015',34411.88,'2025-04-02',29900.00,25800.00,'CAR-1015',220,'Automatic',8,5,5,'Toyota Camry',7,1,2023,'Gold','#4682B4','Metallic','Hybrid','Toyota','New',5),('KLATF08Y1VB329874',4700.00,'2026-05-14',12500.00,9800.00,'IK-112-XC',155,'Manual',5,5,5,'Renault Zoe',5,1,2017,'Basic','#77AAFF','Glossy','Electric','Renault','Correct',5),('KMHCG45C12U384761',5400.00,'2026-04-27',14000.00,11000.00,'QS-909-HG',160,'Manual',5,5,5,'Renault Twingo',4,0,2017,'Basic','#FF66AA','Glossy','Petrol','Renault','Correct',4),('TRUUT28N531847562',29900.00,'2026-05-10',59000.00,54000.00,'RT-781-KL',255,'Automatic',7,5,5,'Audi Q7 S-Line',7,1,2024,'Gold','#333333','Glossy','Diesel','Audi','Excellent',11),('VF1RFB00865473921',12000.00,'2026-01-22',27000.00,22000.00,'EE-505-EE',190,'Manual',6,5,5,'Renault Clio RS',5,1,2021,'Premium','#FF0000','Matte','Petrol','Renault','Sold',8),('VF7N2LFYHJD028374',19800.00,'2026-04-29',41000.00,37000.00,'WX-672-CD',225,'Automatic',6,5,5,'Toyota C-HR Hybrid',6,1,2022,'Premium','#008800','Matte','Hybrid','Toyota','Excellent',5),('W0L0SDL08F6000007',132211.90,'2025-03-01',8900.00,6900.00,'CAR-1007',88,'Manual',5,5,5,'Opel Corsa',4,0,2014,'Basic','#FFFF00','Glossy','Petrol','Opel','Sold',2),('W0LGT8EM6C1000017',140411.32,'2025-03-05',7600.00,5900.00,'CAR-1017',82,'Manual',5,3,4,'Opel Astra',4,0,2013,'Basic','#D2691E','Matte','Petrol','Opel','Sold',2),('W0LPD6EH6D4000027',126332.40,'2025-03-17',8400.00,6500.00,'CAR-1027',85,'Manual',5,5,5,'Opel Insignia',4,0,2014,'Basic','#FFFF00','Matte','Petrol','Opel','Sold',2),('WA1ANAFY4J2147385',25500.00,'2026-05-06',48000.00,43000.00,'DF-876-YU',235,'Automatic',7,5,5,'BMW X3 Hybrid',7,1,2023,'Premium','#0A0A0A','Glossy','Hybrid','BMW','Excellent',9),('WA1LFAFP8CA672845',18000.00,'2026-02-01',45000.00,39000.00,'GG-707-GG',240,'Automatic',7,5,5,'Audi Q5 Quattro',7,1,2022,'Gold','#0000FF','Glossy','Diesel','Audi','Excellent',10),('WAU987654321ABCDE',12000.00,'2024-03-10',32000.00,25000.00,'2-DEF-456',220,'Automatic',7,5,5,'Audi A4 sport',6,1,2022,'Gold','#FFFFFF','Matte','Hybrid','Audi','Good',2),('WAUZZZ4G6HN000010',68211.73,'2025-04-12',21600.00,17900.00,'CAR-1010',165,'Automatic',7,5,5,'Audi A4',6,1,2020,'Premium','#A9A9A9','Glossy','Diesel','Audi','Good',5),('WAUZZZ8K9DA118274',33000.00,'2026-04-18',61000.00,56000.00,'GH-821-JK',260,'Automatic',7,5,5,'BMW X6 Competition',7,1,2024,'Gold','#111111','Glossy','Hybrid','BMW','New',8),('WAUZZZF42MN847362',30000.00,'2026-01-20',55000.00,49000.00,'DD-404-DD',250,'Automatic',8,5,5,'BMW X5 M Sport',7,1,2023,'Gold','#222222','Glossy','Diesel','BMW','New',7),('WAUZZZF44LA000020',74221.55,'2025-04-09',20500.00,16800.00,'CAR-1020',160,'Automatic',7,5,5,'Audi Q3',6,1,2020,'Premium','#696969','Glossy','Diesel','Audi','Good',5),('WAUZZZF46MN000030',63211.22,'2025-04-15',23800.00,19400.00,'CAR-1030',185,'Automatic',7,5,5,'Audi A6',6,1,2021,'Premium','#A9A9A9','Glossy','Diesel','Audi','Good',5),('WBA123456789ABCDE',5000.00,'2024-04-01',40000.00,33000.00,'3-GHI-789',180,'Automatic',6,5,5,'Toyota Prius Hybrid',7,1,2023,'Gold','#808080','Glossy','Hybrid','Toyota','Sold',3),('WBA3A5C58CF384920',37200.00,'2026-05-03',74000.00,69000.00,'CV-761-NM',270,'Automatic',7,5,5,'Audi RS5',7,1,2024,'Gold','#222222','Matte','Hybrid','Audi','New',7),('WBA3A5C58DF000016',80111.65,'2025-02-10',16500.00,13400.00,'CAR-1016',145,'Manual',6,5,5,'BMW Series 1',6,1,2018,'Premium','#556B2F','Glossy','Diesel','BMW','Good',1),('WBA4J1C50KB000026',67771.66,'2025-02-08',22600.00,18800.00,'CAR-1026',175,'Automatic',7,5,5,'BMW Series 4',6,1,2020,'Premium','#808080','Glossy','Diesel','BMW','Good',1),('WBA8E9G51GNU00006',74412.32,'2025-02-17',19400.00,15900.00,'CAR-1006',150,'Automatic',7,5,5,'BMW Series 3',6,1,2019,'Premium','#222222','Metallic','Diesel','BMW','Good',1),('WBA8E9G51HNU38274',22000.00,'2026-01-12',35000.00,30000.00,'BB-202-BB',200,'Manual',6,5,5,'Ford Focus Titanium',5,1,2020,'Premium','#FFFFFF','Matte','Petrol','Ford','Sold',5),('WDBUF56X98B274615',38900.00,'2026-05-16',81000.00,76000.00,'NM-843-PO',280,'Automatic',7,5,5,'BMW M5 Competition',7,1,2025,'Gold','#000000','Matte','Hybrid','BMW','New',6),('WMWMF31070T000018',61122.33,'2025-01-23',18800.00,15100.00,'CAR-1018',150,'Automatic',6,3,4,'Mini Countryman',6,1,2019,'Premium','#20B2AA','Metallic','Diesel','Mini','Good',3),('WMWXM710502000008',55412.22,'2025-01-20',17900.00,14500.00,'CAR-1008',136,'Automatic',6,3,4,'Mini Cooper',6,1,2018,'Premium','#00FF00','Metallic','Petrol','Mini','Good',3),('WMWZC31070T000028',58888.55,'2025-01-25',19600.00,15900.00,'CAR-1028',155,'Automatic',6,3,4,'Mini Clubman',6,1,2019,'Premium','#00FF00','Metallic','Diesel','Mini','Good',3),('WVWZZZ1JZXW563829',28500.00,'2026-04-14',52000.00,47000.00,'OP-778-LM',245,'Automatic',7,5,5,'Audi A5 Sportback',7,1,2023,'Gold','#000088','Glossy','Hybrid','Audi','New',6),('XXXXXXXXXXXXXXXXf',111.00,'2026-05-21',13200.00,13200.00,'X-XFff-FFF',132,'Automatic',6,5,5,'',1,0,2020,'Basic','#000000','Glossy','Diesel','Alfa Romeo','New',1),('XXXXXXXXXXXXXXXXm',111.00,'2026-05-21',111.00,111.00,'X-XXX-XXt',111,'Automatic',6,5,5,'',1,0,2020,'Basic','#000000','Glossy','Diesel','Alfa Romeo','New',6),('YS3FD49Y681273645',6800.00,'2026-04-20',19500.00,16500.00,'PL-551-WX',165,'Manual',5,5,5,'Toyota Aygo X',4,0,2018,'Basic','#F5F5F5','Matte','Petrol','Toyota','Used',9),('YV1FS84A1C2000023',48811.14,'2025-03-08',26800.00,22600.00,'CAR-1023',210,'Automatic',8,5,5,'Volvo S60',7,1,2022,'Premium','#C0C0C0','Metallic','Hybrid','Volvo','Good',3),('YV1RS61T242000003',65510.12,'2025-03-14',22400.00,18800.00,'CAR-1003',180,'Automatic',7,5,5,'Volvo XC40',6,1,2020,'Premium','#808080','Metallic','Hybrid','Volvo','Good',3),('YV4A22PK8J1000013',50210.45,'2025-03-19',24900.00,20800.00,'CAR-1013',190,'Automatic',7,5,5,'Volvo XC60',6,1,2021,'Premium','#708090','Metallic','Hybrid','Volvo','Good',3);
/*!40000 ALTER TABLE `vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary view structure for view `vehicle_complete_view`
--

DROP TABLE IF EXISTS `vehicle_complete_view`;
/*!50001 DROP VIEW IF EXISTS `vehicle_complete_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vehicle_complete_view` AS SELECT 
 1 AS `vin`,
 1 AS `kilometer`,
 1 AS `arrival_date`,
 1 AS `sale_price`,
 1 AS `purchase_price`,
 1 AS `registration`,
 1 AS `power`,
 1 AS `gear_box_type`,
 1 AS `gear_number`,
 1 AS `door_number`,
 1 AS `seat_number`,
 1 AS `information`,
 1 AS `euro_standard`,
 1 AS `is_vat_deductible`,
 1 AS `production_year`,
 1 AS `hex_color`,
 1 AS `type_color`,
 1 AS `state`,
 1 AS `garanty_type`,
 1 AS `garanty_duration`,
 1 AS `energy_type`,
 1 AS `is_eco_friendly`,
 1 AS `brand_name`,
 1 AS `year_created`,
 1 AS `origin_country`,
 1 AS `customer_number`,
 1 AS `customer_name`,
 1 AS `firstname`,
 1 AS `email`,
 1 AS `phone_number`,
 1 AS `address`,
 1 AS `birthday_date`,
 1 AS `locality_name`,
 1 AS `postal_code`,
 1 AS `country_name`*/;
SET character_set_client = @saved_cs_client;

--
-- Temporary view structure for view `vehicle_search_view`
--

DROP TABLE IF EXISTS `vehicle_search_view`;
/*!50001 DROP VIEW IF EXISTS `vehicle_search_view`*/;
SET @saved_cs_client     = @@character_set_client;
/*!50503 SET character_set_client = utf8mb4 */;
/*!50001 CREATE VIEW `vehicle_search_view` AS SELECT 
 1 AS `vin`,
 1 AS `door_number`,
 1 AS `sale_price`,
 1 AS `kilometer`,
 1 AS `brand_name`,
 1 AS `energy`,
 1 AS `year_created`,
 1 AS `is_eco_friendly`*/;
SET character_set_client = @saved_cs_client;

--
-- Final view structure for view `vehicle_complete_view`
--

/*!50001 DROP VIEW IF EXISTS `vehicle_complete_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vehicle_complete_view` AS select `v`.`vin` AS `vin`,`v`.`kilometer` AS `kilometer`,`v`.`arrival_date` AS `arrival_date`,`v`.`sale_price` AS `sale_price`,`v`.`purchase_price` AS `purchase_price`,`v`.`registration` AS `registration`,`v`.`power` AS `power`,`v`.`gear_box_type` AS `gear_box_type`,`v`.`gear_number` AS `gear_number`,`v`.`door_number` AS `door_number`,`v`.`seat_number` AS `seat_number`,`v`.`information` AS `information`,`v`.`euro_standard` AS `euro_standard`,`v`.`is_vat_deductible` AS `is_vat_deductible`,`v`.`production_year` AS `production_year`,`v`.`hex_color` AS `hex_color`,`v`.`type_color` AS `type_color`,`v`.`state` AS `state`,`g`.`type` AS `garanty_type`,`g`.`duration` AS `garanty_duration`,`e`.`type` AS `energy_type`,`e`.`is_eco_friendly` AS `is_eco_friendly`,`b`.`name` AS `brand_name`,`b`.`year_created` AS `year_created`,`b`.`origin_country` AS `origin_country`,`c`.`customer_number` AS `customer_number`,`c`.`name` AS `customer_name`,`c`.`firstname` AS `firstname`,`c`.`email` AS `email`,`c`.`phone_number` AS `phone_number`,`c`.`address` AS `address`,`c`.`birthday_date` AS `birthday_date`,`l`.`name` AS `locality_name`,`l`.`postal_code` AS `postal_code`,`co`.`name` AS `country_name` from ((((((`vehicle` `v` join `garanty` `g` on((`v`.`garanty_type` = `g`.`type`))) join `energy` `e` on((`v`.`energy` = `e`.`type`))) join `brand` `b` on((`v`.`brand_name` = `b`.`name`))) join `customer` `c` on((`v`.`saler` = `c`.`customer_number`))) join `locality` `l` on(((`c`.`locality_name` = `l`.`name`) and (`c`.`postal_code` = `l`.`postal_code`)))) join `country` `co` on((`l`.`country_name` = `co`.`name`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `vehicle_search_view`
--

/*!50001 DROP VIEW IF EXISTS `vehicle_search_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = utf8mb4 */;
/*!50001 SET character_set_results     = utf8mb4 */;
/*!50001 SET collation_connection      = utf8mb4_0900_ai_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`root`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `vehicle_search_view` AS select `v`.`vin` AS `vin`,`v`.`door_number` AS `door_number`,`v`.`sale_price` AS `sale_price`,`v`.`kilometer` AS `kilometer`,`v`.`brand_name` AS `brand_name`,`v`.`energy` AS `energy`,`b`.`year_created` AS `year_created`,`e`.`is_eco_friendly` AS `is_eco_friendly` from ((`vehicle` `v` join `brand` `b` on((`v`.`brand_name` = `b`.`name`))) join `energy` `e` on((`v`.`energy` = `e`.`type`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-22 22:54:45
