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
  CONSTRAINT `fk_configuration_vehicle` FOREIGN KEY (`vin_vehicle`) REFERENCES `vehicle` (`vin`) ON DELETE CASCADE
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
INSERT INTO `customer` VALUES (1,'Dupont','Jean','jean.dupont@gmail.com','+32471234567','Rue de la Loi 1','1990-05-12',1000,'Brussels'),(2,'Martin','Claire','claire.martin@gmail.com','+33612345678','Avenue Victor Hugo','1985-03-20',75000,'Paris'),(3,'Smith','John','john.smith@gmail.com','+15551234567','5th Avenue','1992-11-01',10001,'New York'),(4,'Leroy','Sophie','sophie.leroy@gmail.com','+32470111222','Rue du Centre 12','1991-08-10',4000,'Liege'),(5,'Bernard','Lucas','lucas.bernard@gmail.com','+32473334455','Avenue Louise 50','1988-01-15',1000,'Brussels'),(6,'Petit','Emma','emma.petit@gmail.com','+33699887766','Rue Nationale 20','1995-07-02',59000,'Lille'),(7,'Garcia','Carlos','carlos.garcia@gmail.com','+34666777888','Gran Via 45','1987-11-23',28001,'Madrid'),(8,'Muller','Anna','anna.muller@gmail.com','+491511223344','Alexanderplatz 8','1993-09-14',10115,'Berlin'),(9,'Dubois','Nicolas','nicolas.dubois@gmail.com','+33644556677','Boulevard Voltaire 11','1990-12-19',75001,'Paris'),(10,'Johnson','Emily','emily.johnson@gmail.com','+15559876543','Sunset Boulevard 9','1996-04-08',90001,'Los Angeles'),(11,'Tanaka','Hiroshi','hiroshi.tanaka@gmail.com','+81399887766','Shibuya Street 2','1984-06-30',1000001,'Tokyo'),(12,'Lambert','Thomas','thomas.lambert@gmail.com','+32475555111','Rue Royale 25','1989-04-15',1000,'Brussels'),(13,'Janssens','Julie','julie.janssens@gmail.com','+32476666222','Meir 12','1993-07-22',2000,'Antwerp'),(14,'Peeters','Maxime','maxime.peeters@gmail.com','+32477777333','Rue Saint-Gilles 45','1987-11-10',4000,'Liege'),(15,'Dubois','Camille','camille.dubois@gmail.com','+33611112222','Rue Victor Hugo 8','1991-03-18',69001,'Lyon'),(16,'Martin','Antoine','antoine.martin@gmail.com','+33622223333','Avenue République 15','1985-08-09',75001,'Paris'),(17,'Bernard','Laura','laura.bernard@gmail.com','+33633334444','Rue Nationale 7','1997-12-01',59000,'Lille'),(18,'Garcia','Miguel','miguel.garcia@gmail.com','+34611112222','Gran Via 101','1988-06-21',28001,'Madrid'),(19,'Lopez','Maria','maria.lopez@gmail.com','+34622223333','Diagonal 55','1992-09-30',8001,'Barcelona'),(20,'Fernandez','Pablo','pablo.fernandez@gmail.com','+34633334444','Calle Mayor 18','1980-02-14',46001,'Valencia'),(21,'Muller','Lena','lena.muller@gmail.com','+491701112233','Alexanderplatz 20','1994-04-25',10115,'Berlin'),(22,'Schmidt','Jonas','jonas.schmidt@gmail.com','+491702223344','Marienplatz 9','1986-07-19',80331,'Munich'),(23,'Weber','Emma','emma.weber@gmail.com','+491703334455','Domplatz 3','1990-01-11',50667,'Cologne'),(24,'Rossi','Marco','marco.rossi@gmail.com','+393331112233','Via Roma 10','1988-10-20',100,'Rome'),(25,'Bianchi','Giulia','giulia.bianchi@gmail.com','+393332223344','Corso Milano 22','1995-05-05',20100,'Milan'),(26,'Ferrari','Luca','luca.ferrari@gmail.com','+393333334455','Via Napoli 6','1982-12-12',80100,'Naples'),(27,'Johnson','Michael','michael.johnson@gmail.com','+15551112222','Broadway 120','1984-04-04',10001,'New York'),(28,'Williams','Sarah','sarah.williams@gmail.com','+15552223333','Ocean Drive 18','1996-09-16',33101,'Miami'),(29,'Brown','Kevin','kevin.brown@gmail.com','+15553334444','Sunset Blvd 88','1989-07-07',90001,'Los Angeles'),(30,'Anderson','Olivia','olivia.anderson@gmail.com','+15554445555','Main Street 45','1998-03-13',60601,'Chicago'),(31,'Taylor','James','james.taylor@gmail.com','+15556667777','Market Street 20','1981-01-01',77001,'Houston'),(32,'Svensson','Erik','erik.svensson@gmail.com','+46701112233','Centralgatan 4','1987-11-03',11120,'Stockholm'),(33,'Nilsson','Anna','anna.nilsson@gmail.com','+46702223344','Parkvagen 18','1993-08-15',41103,'Gothenburg'),(34,'Yamamoto','Kenji','kenji.yamamoto@gmail.com','+81311223344','Shinjuku 5','1985-02-28',1000001,'Tokyo'),(35,'Sato','Yuki','yuki.sato@gmail.com','+81322334455','Namba 12','1994-10-09',5300001,'Osaka'),(36,'Kim','Minho','minho.kim@gmail.com','+821011223344','Gangnam 44','1991-06-06',100011,'Seoul'),(37,'Park','Jisoo','jisoo.park@gmail.com','+821022334455','Haeundae 9','1997-09-21',48058,'Busan'),(38,'Silva','Pedro','pedro.silva@gmail.com','+351911223344','Rua Augusta 15','1986-05-17',1000,'Lisbon'),(39,'Costa','Rita','rita.costa@gmail.com','+351922334455','Rua Santa Catarina 44','1992-12-24',4000,'Porto'),(40,'Kowalski','Adam','adam.kowalski@gmail.com','+48701122334','Rynek 7','1988-07-27',1,'Warsaw'),(41,'Nowak','Zofia','zofia.nowak@gmail.com','+48702233445','Florianska 20','1995-03-08',30001,'Krakow'),(42,'Van Dijk','Bram','bram.vandijk@gmail.com','+31611112222','Damrak 8','1989-08-11',1011,'Amsterdam'),(43,'De Vries','Sanne','sanne.devries@gmail.com','+31622223333','Coolsingel 12','1993-11-29',3011,'Rotterdam'),(44,'Bakker','Tom','tom.bakker@gmail.com','+31633334444','Binnenhof 4','1984-02-22',2511,'The Hague'),(45,'Dupuis','Arthur','arthur.dupuis@gmail.com','+32478888111','Rue de Namur 14','1990-06-18',5000,'Namur'),(46,'Moreau','Chloe','chloe.moreau@gmail.com','+32479999222','Grand Place 3','1998-04-02',7000,'Mons'),(47,'Simon','Louis','louis.simon@gmail.com','+32470000333','Rue des Flandres 25','1983-01-30',8000,'Bruges'),(48,'Henry','Lea','lea.henry@gmail.com','+32471111444','Korenmarkt 16','1996-10-14',9000,'Ghent'),(49,'Lefevre','Nathan','nathan.lefevre@gmail.com','+32472222555','Boulevard Tirou 9','1987-05-26',6000,'Charleroi'),(50,'Nguyen','Linh','linh.nguyen@gmail.com','+33677778888','Rue de Bordeaux 12','1994-08-19',33000,'Bordeaux'),(51,'Ivanov','Alex','alex.ivanov@gmail.com','+447700111222','King Street 10','1985-09-12',1001,'London'),(52,'Petrov','Mila','mila.petrov@gmail.com','+447700222333','Albert Dock 5','1997-01-05',3001,'Liverpool'),(53,'Olsen','Nora','nora.olsen@gmail.com','+4791112233','Karl Johans gate 2','1992-04-27',150,'Oslo'),(54,'Singh','Raj','raj.singh@gmail.com','+919811223344','Connaught Place','1988-12-18',110001,'New Delhi'),(55,'Patel','Anaya','anaya.patel@gmail.com','+919922334455','Marine Drive 40','1999-07-03',400001,'Mumbai'),(56,'Popescu','Andrei','andrei.popescu@gmail.com','+40711122334','Calea Victoriei 12','1986-03-25',10000,'Bucharest'),(57,'Ionescu','Elena','elena.ionescu@gmail.com','+40722233445','Piata Unirii 6','1994-11-15',10000,'Bucharest'),(58,'Novak','Martin','martin.novak@gmail.com','+420777111222','Vaclavske Namesti 5','1991-06-29',11000,'Prague'),(59,'Hansen','Freja','freja.hansen@gmail.com','+4522112233','Nyhavn 7','1995-09-09',1000,'Copenhagen'),(60,'Aalto','Mikko','mikko.aalto@gmail.com','+358401112233','Mannerheimintie 8','1987-02-17',100,'Helsinki');
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
  CONSTRAINT `fk_entretien_vehicle` FOREIGN KEY (`vin_number`) REFERENCES `vehicle` (`vin`) ON DELETE CASCADE,
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
  KEY `fk_sale_customer` (`customer_number`),
  KEY `fk_sale_vehicle` (`vin_vehicle`),
  CONSTRAINT `fk_sale_customer` FOREIGN KEY (`customer_number`) REFERENCES `customer` (`customer_number`),
  CONSTRAINT `fk_sale_vehicle` FOREIGN KEY (`vin_vehicle`) REFERENCES `vehicle` (`vin`) ON DELETE CASCADE,
  CONSTRAINT `sale_chk_1` CHECK ((`payment_method` in (_utf8mb4'Cash',_utf8mb4'Card',_utf8mb4'Bank Transfer',_utf8mb4'Financing'))),
  CONSTRAINT `sale_chk_2` CHECK ((`state` in (_utf8mb4'Pending',_utf8mb4'Completed',_utf8mb4'Cancelled')))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sale`
--

LOCK TABLES `sale` WRITE;
/*!40000 ALTER TABLE `sale` DISABLE KEYS */;
INSERT INTO `sale` VALUES ('2024-05-15','WBA123456789ABCDE','Bank Transfer','Completed',1),('2024-06-10','JT123456789ABCDEF','Cash','Completed',14),('2024-07-22','WAU987654321ABCDE','Financing','Completed',27),('2025-01-05','JSAAZC21S00100002','Card','Completed',8),('2025-01-15','JN1BJ1CR5HW000004','Cash','Completed',19),('2025-01-20','WMWXM710502000008','Bank Transfer','Completed',3),('2025-01-28','YV1RS61T242000003','Financing','Completed',22),('2025-02-03','WBA3A5C58DF000016','Card','Completed',11),('2025-02-10','JS2YB5A35C6000012','Cash','Completed',25),('2025-02-15','WMWMF31070T000018','Bank Transfer','Completed',7),('2025-02-20','JS2YC5A34D6000022','Financing','Completed',16),('2025-02-25','WBA8E9G51GNU00006','Card','Completed',29),('2025-03-01','W0L0SDL08F6000007','Cash','Completed',4),('2025-03-08','YV4A22PK8J1000013','Bank Transfer','Completed',13),('2025-03-14','JN8AS5MT9CW000014','Cash','Completed',20),('2025-03-20','W0LGT8EM6C1000017','Financing','Completed',6),('2025-04-02','JTNB11HK303000015','Card','Completed',18),('2025-04-05','JTDKN3DU0A0000005','Bank Transfer','Completed',30),('2025-04-08','YV1FS84A1C2000023','Cash','Completed',12),('2025-04-12','WAUZZZ4G6HN000010','Card','Completed',24),('2025-04-15','W0LPD6EH6D4000027','Financing','Completed',9),('2025-04-20','WAUZZZF44LA000020','Bank Transfer','Completed',17),('2025-04-25','WAUZZZF46MN000030','Cash','Completed',26),('2025-05-02','JTHBK1EG9F2000009','Card','Completed',2),('2025-05-10','JN1CV6EK9DM000024','Cash','Completed',21),('2025-05-18','JTHCE1BL0FA000019','Bank Transfer','Completed',15),('2025-06-01','JTHKD5BH5F2000029','Financing','Completed',28),('2025-06-15','WBA4J1C50KB000026','Card','Completed',10),('2026-01-08','JTDKB20U793412875','Cash','Completed',23),('2026-01-18','JTDBR32E720184563','Financing','Completed',5),('2026-02-05','KLATF08Y1VB329874','Card','Completed',19),('2026-02-20','KMHCG45C12U384761','Cash','Completed',30),('2026-03-10','JH4KA9650MC012874','Bank Transfer','Completed',14),('2026-03-18','BB1CC2DD3EE4FF504','Bank Transfer','Completed',45),('2026-03-22','JN1BJ1CP7JW184736','Card','Completed',8),('2026-03-25','BB1CC2DD3EE4FF514','Cash','Completed',57),('2026-04-01','1HGCM82633A482751','Bank Transfer','Completed',1),('2026-04-03','WBA8E9G51HNU38274','Card','Completed',2),('2026-04-05','JTDKN3DU7A1293846','Financing','Pending',4),('2026-04-07','VF1RFB00865473921','Cash','Completed',6),('2026-04-08','JHMCM56557C384729','Financing','Pending',22),('2026-04-10','BB1CC2DD3EE4FF509','Card','Completed',56),('2026-04-15','YS3FD49Y681273645','Cash','Completed',17),('2026-04-22','BB1CC2DD3EE4FF506','Financing','Completed',54),('2026-04-28','BB1CC2DD3EE4FF512','Cash','Cancelled',50),('2026-04-30','2HGFG11869H274851','Bank Transfer','Completed',25),('2026-05-02','VF7N2LFYHJD028374','Card','Completed',6),('2026-05-04','WA1ANAFY4J2147385','Financing','Pending',13),('2026-05-07','WAUZZZ8K9DA118274','Cash','Completed',29),('2026-05-09','WVWZZZ1JZXW563829','Bank Transfer','Completed',20),('2026-05-11','TRUUT28N531847562','Card','Completed',3),('2026-05-12','BB1CC2DD3EE4FF517','Bank Transfer','Completed',58),('2026-05-13','WBA3A5C58CF384920','Financing','Pending',27),('2026-05-15','BB1CC2DD3EE4FF520','Card','Completed',53),('2026-05-17','WDBUF56X98B274615','Cash','Completed',11),('2026-05-18','BB1CC2DD3EE4FF502','Cash','Completed',34),('2026-05-19','5YJSA1DN5DFP14752','Bank Transfer','Completed',16),('2026-05-20','BB1CC2DD3EE4FF519','Financing','Completed',40),('2026-05-21','AA1BB2CC3DD4EE501','Card','Completed',24),('2026-05-22','AA1BB2CC3DD4EE506','Financing','Completed',7),('2026-05-22','BB1CC2DD3EE4FF503','Card','Completed',36),('2026-05-23','AA1BB2CC3DD4EE514','Cash','Pending',18),('2026-05-23','BB1CC2DD3EE4FF515','Bank Transfer','Completed',43),('2026-05-24','AA1BB2CC3DD4EE525','Bank Transfer','Completed',12),('2026-05-24','BB1CC2DD3EE4FF508','Cash','Completed',37),('2026-05-25','BB1CC2DD3EE4FF513','Financing','Pending',36),('2026-05-26','BB1CC2DD3EE4FF516','Card','Completed',33),('2026-05-27','AA1BB2CC3DD4EE536','Card','Pending',26),('2026-05-27','BB1CC2DD3EE4FF511','Bank Transfer','Completed',42),('2026-05-28','AA1BB2CC3DD4EE542','Financing','Cancelled',9),('2026-05-28','BB1CC2DD3EE4FF507','Card','Pending',32),('2026-05-28','BB1CC2DD3EE4FF518','Financing','Completed',51),('2026-05-29','BB1CC2DD3EE4FF501','Bank Transfer','Completed',47),('2026-05-29','BB1CC2DD3EE4FF505','Financing','Pending',22),('2026-05-29','BB1CC2DD3EE4FF510','Cash','Completed',24);
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
  KEY `fk_trial_customer` (`customer_number`),
  KEY `fk_trial_vehicle` (`vin_number`),
  CONSTRAINT `fk_trial_customer` FOREIGN KEY (`customer_number`) REFERENCES `customer` (`customer_number`),
  CONSTRAINT `fk_trial_vehicle` FOREIGN KEY (`vin_number`) REFERENCES `vehicle` (`vin`) ON DELETE CASCADE,
  CONSTRAINT `trial_chk_1` CHECK ((`duration` between 1 and 180))
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trial`
--

LOCK TABLES `trial` WRITE;
/*!40000 ALTER TABLE `trial` DISABLE KEYS */;
INSERT INTO `trial` VALUES ('2024-05-01','WAU987654321ABCDE',45,'Very comfortable car',1,1),('2024-05-03','JT123456789ABCDEF',30,'Customer interested',1,2),('2024-06-05','JT123456789ABCDEF',30,'Very sporty feel',1,14),('2024-07-15','WAU987654321ABCDE',45,'Customer impressed by comfort',1,27),('2024-08-20','WBA123456789ABCDE',20,'Quick test, interested',1,8),('2024-09-10','5YJ3E1EA7JF000001',60,'Loved the electric acceleration',1,19),('2024-10-03','JSAAZC21S00100002',25,'Small but practical',0,3),('2024-11-14','JN1BJ1CR5HW000004',40,'Customer undecided',0,22),('2024-12-01','WMWXM710502000008',30,'Fun city car',1,11),('2025-01-10','YV1RS61T242000003',50,'Smooth and quiet ride',1,25),('2025-01-19','WBA3A5C58DF000016',35,'Good value for money',1,7),('2025-01-25','JS2YB5A35C6000012',20,'Not convinced by power',0,16),('2025-02-02','WMWMF31070T000018',45,'Liked the premium feel',1,29),('2025-02-09','JS2YC5A34D6000022',30,'Comfortable for city',1,4),('2025-02-14','WBA8E9G51GNU00006',55,'Excellent diesel engine',1,13),('2025-02-21','W0L0SDL08F6000007',15,'Too basic for customer',0,20),('2025-03-05','YV4A22PK8J1000013',40,'Great SUV experience',1,6),('2025-03-12','JN8AS5MT9CW000014',25,'Customer found it too old',0,18),('2025-03-18','W0LGT8EM6C1000017',30,'Acceptable condition',0,30),('2025-03-25','JTNB11HK303000015',60,'Very impressed, wants financing',1,12),('2025-04-01','JTDKN3DU0A0000005',45,'Hybrid system appreciated',1,24),('2025-04-06','YV1FS84A1C2000023',35,'Scandinavian design loved',1,9),('2025-04-10','WAUZZZ4G6HN000010',50,'Premium Audi feel confirmed',1,17),('2025-04-14','W0LPD6EH6D4000027',20,'Too many kilometers',0,26),('2025-04-18','WAUZZZF44LA000020',40,'Good family SUV',1,2),('2025-04-22','WAUZZZF46MN000030',55,'Elegant and powerful',1,21),('2025-05-01','JTHBK1EG9F2000009',60,'Customer very enthusiastic',1,15),('2025-05-08','JN1CV6EK9DM000024',25,'Too small for family',0,28),('2025-05-15','JTHCE1BL0FA000019',45,'Smooth hybrid drive',1,10),('2025-05-22','JTHKD5BH5F2000029',50,'Premium feel, considering purchase',1,23),('2025-06-02','WBA4J1C50KB000026',35,'Nice coupe style',1,5),('2025-06-10','JTDKB20U793412875',30,'Good daily driver',1,19),('2025-06-20','JTDBR32E720184563',20,'Customer prefers SUV',0,14),('2025-07-05','KLATF08Y1VB329874',40,'Surprised by electric range',1,8),('2025-07-15','KMHCG45C12U384761',25,'Cute but underpowered',0,22),('2025-08-01','JH4KA9650MC012874',35,'Great city car',1,17),('2025-08-18','JN1BJ1CP7JW184736',30,'Good entry-level option',1,25),('2025-09-05','JHMCM56557C384729',55,'Very comfortable touring',1,6),('2025-09-20','YS3FD49Y681273645',20,'Lively and fun',1,13),('2025-10-08','2HGFG11869H274851',40,'Solid build quality',1,29),('2025-10-25','VF7N2LFYHJD028374',45,'Hybrid smooth on highway',1,20),('2025-11-10','WA1ANAFY4J2147385',60,'Very impressed by X3',1,3),('2025-11-28','WAUZZZ8K9DA118274',50,'Powerful and refined',1,27),('2025-12-10','WVWZZZ1JZXW563829',35,'Sporty feel, interested',1,11),('2025-12-20','TRUUT28N531847562',40,'Spacious and elegant',1,16),('2026-01-15','WBA3A5C58CF384920',55,'RS performance impressed',1,24),('2026-02-12','WDBUF56X98B274615',60,'M5 is a dream car',1,30),('2026-03-01','1HGCM82633A482751',45,'Customer liked comfort',1,1),('2026-03-02','WBA8E9G51HNU38274',30,'Interested in financing',1,2),('2026-03-03','JTDKN3DU7A1293846',60,'Very smooth drive',1,4),('2026-03-04','WAUZZZF42MN847362',25,'Powerful vehicle',1,5),('2026-03-05','VF1RFB00865473921',40,'Compact and practical',0,6),('2026-03-06','WA1LFAFP8CA672845',50,'Customer considering purchase',1,7),('2026-03-18','5YJSA1DN5DFP14752',45,'Impressed by Tesla tech',1,18),('2026-03-22','BB1CC2DD3EE4FF514',20,'Customer found better elsewhere',0,57),('2026-04-02','AA1BB2CC3DD4EE507',50,'Incredible Porsche experience',1,12),('2026-04-10','BB1CC2DD3EE4FF504',15,'Too many kilometers for customer',0,44),('2026-04-20','AA1BB2CC3DD4EE518',35,'Too expensive for customer',0,26),('2026-04-20','BB1CC2DD3EE4FF509',25,'Dacia practical but basic',0,56),('2026-04-28','BB1CC2DD3EE4FF506',30,'Honda Jazz fits daily needs',1,54),('2026-05-05','AA1BB2CC3DD4EE527',60,'Bentley beyond expectations',1,9),('2026-05-05','BB1CC2DD3EE4FF512',20,'Too old for the price asked',0,50),('2026-05-10','BB1CC2DD3EE4FF517',25,'Good Skoda but prefers Audi',0,58),('2026-05-12','BB1CC2DD3EE4FF520',30,'Practical and reliable Subaru',1,53),('2026-05-15','BB1CC2DD3EE4FF502',20,'Solid Golf, nothing surprising',0,55),('2026-05-18','BB1CC2DD3EE4FF519',35,'Good hybrid for daily use',1,40),('2026-05-19','AA1BB2CC3DD4EE538',55,'Rolls-Royce sheer luxury',1,7),('2026-05-20','BB1CC2DD3EE4FF515',25,'Mazda very comfortable on road',1,43),('2026-05-21','BB1CC2DD3EE4FF508',30,'Good family SUV, interested',1,37),('2026-05-22','BB1CC2DD3EE4FF503',40,'Silent and smooth EV drive',1,59),('2026-05-23','BB1CC2DD3EE4FF513',35,'Genesis quality surprised customer',1,36),('2026-05-24','BB1CC2DD3EE4FF511',45,'Audi e-tron GT is spectacular',1,42),('2026-05-25','BB1CC2DD3EE4FF516',55,'Impressed by Volvo hybrid range',1,33),('2026-05-26','BB1CC2DD3EE4FF518',40,'Jaguar felt very premium',1,51),('2026-05-27','BB1CC2DD3EE4FF505',50,'Loved the Taycan acceleration',1,22),('2026-05-28','BB1CC2DD3EE4FF510',30,'Ferrari dream come true',1,24),('2026-05-29','BB1CC2DD3EE4FF501',45,'Very smooth Mercedes experience',1,47),('2026-05-29','BB1CC2DD3EE4FF507',60,'Blown away by M3 power',1,32);
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
INSERT INTO `vehicle` VALUES ('1HGCM82633A482751',15000.00,'2026-01-10',28000.00,24000.00,'AA-101-AA',210,'Automatic',6,5,5,'Audi A3 S-Line',6,1,2021,'Gold','#111111','Glossy','Diesel','Audi','Sold',4),('2HGFG11869H274851',11200.00,'2026-05-12',25000.00,21000.00,'YU-225-DF',185,'Manual',6,5,5,'Ford Kuga',6,1,2020,'Premium','#0044AA','Glossy','Petrol','Ford','Sold',4),('5YJ3E1EA7JF000001',15221.44,'2025-01-12',45900.00,41200.00,'CAR-1001',325,'Automatic',8,5,5,'Tesla Model 3',7,1,2024,'Gold','#111111','Metallic','Electric','Tesla','New',1),('5YJSA1DN5DFP14752',44000.00,'2026-04-25',89000.00,84000.00,'TY-118-ZA',250,'Automatic',7,5,5,'BMW i5 Electric',7,1,2025,'Gold','#FFFFFF','Glossy','Electric','BMW','Sold',11),('5YJSA1E26HF000011',22112.00,'2025-01-11',53800.00,49200.00,'CAR-1011',410,'Automatic',8,5,5,'Tesla Model S',7,1,2024,'Gold','#2F4F4F','Metallic','Electric','Tesla','New',1),('5YJXCDE22HF000021',19222.22,'2025-01-18',61200.00,55900.00,'CAR-1021',450,'Automatic',8,5,7,'Tesla Model X',7,1,2025,'Gold','#000000','Metallic','Electric','Tesla','New',1),('AA1BB2CC3DD4EE501',23500.00,'2026-01-05',32000.00,27500.00,'AB-001-CD',150,'Manual',6,5,5,'Peugeot 208',6,1,2021,'Basic','#FF5733','Glossy','Petrol','Peugeot','Sold',1),('AA1BB2CC3DD4EE502',8100.00,'2026-02-10',27500.00,23000.00,'AB-002-CD',130,'Manual',6,5,5,'Citroen C3',6,0,2022,'Basic','#3498DB','Matte','Petrol','Citroen','New',2),('AA1BB2CC3DD4EE503',45000.00,'2025-11-20',18500.00,15000.00,'AB-003-CD',110,'Manual',5,5,5,'Dacia Sandero',5,0,2019,'Basic','#2ECC71','Glossy','Petrol','Dacia','Average',3),('AA1BB2CC3DD4EE504',12000.00,'2026-03-15',41000.00,36000.00,'AB-004-CD',200,'Automatic',7,5,5,'Volvo V60',7,1,2023,'Premium','#1ABC9C','Metallic','Hybrid','Volvo','New',4),('AA1BB2CC3DD4EE505',55000.00,'2025-09-10',14000.00,11000.00,'AB-005-CD',95,'Manual',5,5,5,'Fiat 500',5,0,2018,'Basic','#E74C3C','Glossy','Petrol','Fiat','Used',5),('AA1BB2CC3DD4EE506',31000.00,'2025-12-05',22000.00,18500.00,'AB-006-CD',140,'Automatic',6,5,5,'Skoda Octavia',6,1,2020,'Premium','#8E44AD','Glossy','Diesel','Skoda','Sold',6),('AA1BB2CC3DD4EE507',0.00,'2026-04-22',68000.00,62000.00,'AB-007-CD',300,'Automatic',8,5,5,'Porsche Macan Electric',7,1,2025,'Gold','#2C3E50','Metallic','Electric','Porsche','New',7),('AA1BB2CC3DD4EE508',19800.00,'2026-01-30',35000.00,30000.00,'AB-008-CD',175,'Automatic',7,5,5,'Mazda CX-5',6,1,2022,'Premium','#F39C12','Matte','Petrol','Mazda','Good',8),('AA1BB2CC3DD4EE509',72000.00,'2025-08-14',11500.00,9000.00,'AB-009-CD',100,'Manual',5,5,5,'Seat Ibiza',4,0,2016,'Basic','#BDC3C7','Glossy','Petrol','Seat','Average',9),('AA1BB2CC3DD4EE510',3000.00,'2026-05-01',52000.00,47000.00,'AB-010-CD',220,'Automatic',8,5,5,'Genesis G70',7,1,2024,'Gold','#1C1C1C','Metallic','Hybrid','Genesis','New',10),('AA1BB2CC3DD4EE511',88000.00,'2025-06-18',9500.00,7200.00,'AB-011-CD',90,'Manual',5,5,5,'Mitsubishi Space Star',4,0,2015,'Basic','#95A5A6','Matte','Petrol','Mitsubishi','Used',11),('AA1BB2CC3DD4EE512',14500.00,'2026-02-25',43000.00,38000.00,'AB-012-CD',210,'Automatic',7,5,5,'Jaguar E-Pace',6,1,2022,'Premium','#2980B9','Glossy','Diesel','Jaguar','Excellent',1),('AA1BB2CC3DD4EE513',0.00,'2026-05-20',95000.00,88000.00,'AB-013-CD',400,'Automatic',8,5,5,'Maserati Ghibli',7,1,2025,'Gold','#922B21','Metallic','Petrol','Maserati','New',2),('AA1BB2CC3DD4EE514',27000.00,'2025-10-08',29500.00,25000.00,'AB-014-CD',165,'Automatic',6,5,5,'Honda CR-V',6,1,2021,'Premium','#117A65','Glossy','Hybrid','Honda','Sold',3),('AA1BB2CC3DD4EE515',63000.00,'2025-07-30',13000.00,10500.00,'AB-015-CD',105,'Manual',5,5,5,'Hyundai i20',5,0,2017,'Basic','#F8C471','Matte','Petrol','Hyundai','Average',4),('AA1BB2CC3DD4EE516',5500.00,'2026-04-10',78000.00,72000.00,'AB-016-CD',350,'Automatic',8,5,5,'Land Rover Discovery',7,1,2025,'Gold','#1A252F','Glossy','Diesel','Land Rover','New',5),('AA1BB2CC3DD4EE517',38000.00,'2025-11-11',24000.00,20000.00,'AB-017-CD',155,'Manual',6,5,5,'Kia Sportage',6,0,2020,'Basic','#6C3483','Matte','Petrol','Kia','Good',6),('AA1BB2CC3DD4EE518',1200.00,'2026-05-15',120000.00,112000.00,'AB-018-CD',630,'Automatic',8,5,5,'Lamborghini Urus',7,1,2025,'Gold','#F4D03F','Metallic','Petrol','Lamborghini','New',7),('AA1BB2CC3DD4EE519',49000.00,'2025-09-25',16500.00,13500.00,'AB-019-CD',125,'Manual',6,5,5,'Volkswagen Polo',5,0,2019,'Basic','#1F618D','Glossy','Petrol','Volkswagen','Average',8),('AA1BB2CC3DD4EE520',11000.00,'2026-03-08',58000.00,52500.00,'AB-020-CD',265,'Automatic',8,5,5,'Cadillac CT5',7,1,2024,'Gold','#4A235A','Metallic','Petrol','Cadillac','Excellent',9),('AA1BB2CC3DD4EE521',0.00,'2026-05-22',35000.00,31000.00,'AB-021-CD',170,'Automatic',7,5,5,'BYD Atto 3',7,1,2025,'Gold','#148F77','Glossy','Electric','BYD','New',10),('AA1BB2CC3DD4EE522',82000.00,'2025-05-12',10000.00,7800.00,'AB-022-CD',88,'Manual',5,5,5,'Suzuki Alto',4,0,2014,'Basic','#AAB7B8','Matte','Petrol','Suzuki','Used',11),('AA1BB2CC3DD4EE523',21000.00,'2026-01-18',39000.00,34500.00,'AB-023-CD',195,'Automatic',7,5,5,'Subaru Outback',6,1,2022,'Premium','#2E4057','Metallic','Petrol','Subaru','Good',1),('AA1BB2CC3DD4EE524',0.00,'2026-05-10',48000.00,43500.00,'AB-024-CD',204,'Automatic',8,5,5,'Hyundai Ioniq 6',7,1,2025,'Gold','#0B3D91','Glossy','Electric','Hyundai','New',2),('AA1BB2CC3DD4EE525',36000.00,'2025-10-30',26500.00,22500.00,'AB-025-CD',160,'Automatic',6,5,5,'Alfa Romeo Giulia',6,1,2021,'Premium','#C0392B','Metallic','Petrol','Alfa Romeo','Sold',3),('AA1BB2CC3DD4EE526',15000.00,'2026-02-14',33500.00,29000.00,'AB-026-CD',180,'Automatic',6,5,5,'Jeep Compass',6,1,2022,'Premium','#1B4F72','Matte','Diesel','Jeep','Good',4),('AA1BB2CC3DD4EE527',4200.00,'2026-04-28',62000.00,57000.00,'AB-027-CD',280,'Automatic',8,5,5,'Bentley Bentayga',7,1,2024,'Gold','#17202A','Glossy','Hybrid','Bentley','Excellent',5),('AA1BB2CC3DD4EE528',58000.00,'2025-08-20',15500.00,12500.00,'AB-028-CD',118,'Manual',6,5,5,'Peugeot 308',5,0,2018,'Basic','#F0B27A','Matte','Diesel','Peugeot','Average',6),('AA1BB2CC3DD4EE529',0.00,'2026-05-18',55000.00,50000.00,'AB-029-CD',245,'Automatic',8,5,5,'Genesis GV80',7,1,2025,'Gold','#212F3D','Metallic','Hybrid','Genesis','New',7),('AA1BB2CC3DD4EE530',26500.00,'2025-12-20',21500.00,18000.00,'AB-030-CD',145,'Automatic',6,5,5,'Skoda Karoq',6,1,2021,'Premium','#5D6D7E','Glossy','Diesel','Skoda','Good',8),('AA1BB2CC3DD4EE531',93000.00,'2025-04-05',8800.00,6700.00,'AB-031-CD',86,'Manual',5,5,5,'Dacia Logan',4,0,2013,'Basic','#CDD3D8','Matte','Petrol','Dacia','Used',9),('AA1BB2CC3DD4EE532',7800.00,'2026-03-28',46000.00,41000.00,'AB-032-CD',215,'Automatic',7,5,5,'Mazda CX-60',7,1,2024,'Gold','#1C2833','Metallic','Hybrid','Mazda','Excellent',10),('AA1BB2CC3DD4EE533',33000.00,'2025-11-02',23000.00,19500.00,'AB-033-CD',152,'Manual',6,5,5,'Honda Civic',6,0,2020,'Basic','#7F8C8D','Glossy','Petrol','Honda','Good',11),('AA1BB2CC3DD4EE534',0.00,'2026-05-25',85000.00,78000.00,'AB-034-CD',390,'Automatic',8,5,5,'Aston Martin DBX',7,1,2025,'Gold','#154360','Metallic','Petrol','Aston Martin','New',1),('AA1BB2CC3DD4EE535',41000.00,'2025-10-14',17800.00,14500.00,'AB-035-CD',130,'Manual',6,5,5,'Seat Leon',5,0,2019,'Basic','#6E2F26','Matte','Petrol','Seat','Average',2),('AA1BB2CC3DD4EE536',9600.00,'2026-04-05',38000.00,33500.00,'AB-036-CD',190,'Automatic',7,5,5,'Kia EV6',7,1,2023,'Gold','#1E8BC3','Glossy','Electric','Kia','Sold',3),('AA1BB2CC3DD4EE537',67000.00,'2025-07-07',13800.00,11000.00,'AB-037-CD',115,'Manual',5,5,5,'Citroen C4',5,0,2017,'Basic','#D5DBDB','Matte','Diesel','Citroen','Average',4),('AA1BB2CC3DD4EE538',2800.00,'2026-05-08',72000.00,66000.00,'AB-038-CD',320,'Automatic',8,5,5,'Rolls-Royce Ghost',7,1,2025,'Gold','#1B2631','Glossy','Petrol','Rolls-Royce','New',5),('AA1BB2CC3DD4EE539',18700.00,'2026-01-22',36000.00,31000.00,'AB-039-CD',185,'Automatic',7,5,5,'Mitsubishi Eclipse Cross',6,1,2022,'Premium','#A9CCE3','Metallic','Hybrid','Mitsubishi','Good',6),('AA1BB2CC3DD4EE540',77000.00,'2025-06-01',12200.00,9500.00,'AB-040-CD',92,'Manual',5,5,5,'Fiat Panda',4,0,2015,'Basic','#FADBD8','Glossy','Petrol','Fiat','Used',7),('AA1BB2CC3DD4EE541',6200.00,'2026-04-16',64000.00,59000.00,'AB-041-CD',295,'Automatic',8,5,5,'Porsche Cayenne',7,1,2024,'Gold','#273746','Metallic','Hybrid','Porsche','New',8),('AA1BB2CC3DD4EE542',43000.00,'2025-09-03',19200.00,15800.00,'AB-042-CD',140,'Automatic',6,5,5,'Volkswagen Tiguan',6,0,2020,'Basic','#AEB6BF','Matte','Diesel','Volkswagen','Sold',9),('AA1BB2CC3DD4EE543',0.00,'2026-05-12',42000.00,38000.00,'AB-043-CD',218,'Automatic',8,5,5,'NIO ET5',7,1,2025,'Gold','#0E6655','Glossy','Electric','NIO','New',10),('AA1BB2CC3DD4EE544',25000.00,'2025-12-12',28000.00,24000.00,'AB-044-CD',163,'Automatic',6,5,5,'Jeep Wrangler',6,0,2021,'Basic','#7B7D7D','Matte','Petrol','Jeep','Good',11),('AA1BB2CC3DD4EE545',52000.00,'2025-08-08',16800.00,13700.00,'AB-045-CD',120,'Manual',6,5,5,'Opel Mokka',5,0,2018,'Basic','#85929E','Glossy','Diesel','Opel','Average',1),('AA1BB2CC3DD4EE546',1000.00,'2026-05-26',99000.00,91000.00,'AB-046-CD',580,'Automatic',8,5,5,'Ferrari Roma',7,1,2025,'Gold','#C0392B','Metallic','Petrol','Ferrari','New',2),('AA1BB2CC3DD4EE547',16000.00,'2026-02-08',34500.00,30000.00,'AB-047-CD',177,'Automatic',7,5,5,'Land Rover Defender',6,1,2022,'Premium','#1A5276','Glossy','Diesel','Land Rover','Good',3),('AA1BB2CC3DD4EE548',39000.00,'2025-10-22',20000.00,16800.00,'AB-048-CD',148,'Automatic',6,5,5,'Subaru Forester',6,0,2020,'Basic','#D4E6F1','Matte','Petrol','Subaru','Good',4),('AA1BB2CC3DD4EE549',0.00,'2026-05-24',44000.00,40000.00,'AB-049-CD',230,'Automatic',8,5,5,'Geely Zeekr 001',7,1,2025,'Gold','#0B5345','Metallic','Electric','Geely','New',5),('AA1BB2CC3DD4EE550',29000.00,'2025-11-29',25500.00,21500.00,'AB-050-CD',158,'Manual',6,5,5,'Dodge Challenger',5,0,2021,'Basic','#1C1C1C','Matte','Petrol','Dodge','Good',6),('BB1CC2DD3EE4FF501',5200.00,'2026-05-28',44000.00,39500.00,'BC-001-EF',218,'Automatic',7,5,5,'Mercedes-Benz GLA',7,1,2024,'Gold','#1A1A2E','Metallic','Hybrid','Mercedes-Benz','Sold',12),('BB1CC2DD3EE4FF502',31000.00,'2025-12-10',26000.00,22000.00,'BC-002-EF',163,'Automatic',6,5,5,'Volkswagen Golf',6,1,2021,'Premium','#566573','Glossy','Petrol','Volkswagen','Sold',34),('BB1CC2DD3EE4FF503',0.00,'2026-05-29',38000.00,34000.00,'BC-003-EF',204,'Automatic',8,5,5,'Kia Niro EV',7,1,2025,'Gold','#0E6655','Matte','Electric','Kia','Sold',36),('BB1CC2DD3EE4FF504',74000.00,'2025-06-15',11000.00,8500.00,'BC-004-EF',90,'Manual',5,5,5,'Citroen C1',4,0,2015,'Basic','#D5D8DC','Matte','Petrol','Citroen','Sold',45),('BB1CC2DD3EE4FF505',9800.00,'2026-04-03',57000.00,51500.00,'BC-005-EF',258,'Automatic',8,5,5,'Porsche Taycan',7,1,2024,'Gold','#212F3C','Metallic','Electric','Porsche','Sold',22),('BB1CC2DD3EE4FF506',47000.00,'2025-10-01',18000.00,15000.00,'BC-006-EF',136,'Manual',6,5,5,'Honda Jazz',5,0,2019,'Basic','#A9CCE3','Glossy','Hybrid','Honda','Sold',54),('BB1CC2DD3EE4FF507',0.00,'2026-05-27',72000.00,66000.00,'BC-007-EF',340,'Automatic',8,5,5,'BMW M3 Competition',7,1,2025,'Gold','#1C2833','Matte','Petrol','BMW','Sold',32),('BB1CC2DD3EE4FF508',22000.00,'2026-02-18',33000.00,28500.00,'BC-008-EF',177,'Automatic',7,5,5,'Hyundai Tucson',6,1,2022,'Premium','#5D6D7E','Glossy','Hybrid','Hyundai','Sold',37),('BB1CC2DD3EE4FF509',61000.00,'2025-07-20',14500.00,11500.00,'BC-009-EF',115,'Manual',5,5,5,'Dacia Duster',5,0,2018,'Basic','#7F8C8D','Matte','Petrol','Dacia','Sold',56),('BB1CC2DD3EE4FF510',3500.00,'2026-05-15',91000.00,84000.00,'BC-010-EF',510,'Automatic',8,5,5,'Ferrari Portofino',7,1,2025,'Gold','#C0392B','Metallic','Petrol','Ferrari','Sold',24),('BB1CC2DD3EE4FF511',18500.00,'2026-03-05',42000.00,37500.00,'BC-011-EF',231,'Automatic',8,5,5,'Audi e-tron GT',7,1,2023,'Gold','#1B2631','Glossy','Electric','Audi','Sold',42),('BB1CC2DD3EE4FF512',53000.00,'2025-09-14',16000.00,13000.00,'BC-012-EF',122,'Manual',6,5,5,'Renault Megane',5,0,2018,'Basic','#F0B27A','Matte','Diesel','Renault','Sold',50),('BB1CC2DD3EE4FF513',7200.00,'2026-04-25',54000.00,49000.00,'BC-013-EF',265,'Automatic',8,5,5,'Genesis G80',7,1,2024,'Gold','#2E4057','Metallic','Hybrid','Genesis','Sold',36),('BB1CC2DD3EE4FF514',85000.00,'2025-04-10',9200.00,7000.00,'BC-014-EF',86,'Manual',5,5,5,'Fiat Tipo',4,0,2014,'Basic','#CDD3D8','Glossy','Petrol','Fiat','Sold',57),('BB1CC2DD3EE4FF515',12000.00,'2026-03-20',36500.00,32000.00,'BC-015-EF',190,'Automatic',7,5,5,'Mazda CX-30',6,1,2023,'Premium','#1E8BC3','Glossy','Hybrid','Mazda','Sold',43),('BB1CC2DD3EE4FF516',0.00,'2026-05-26',48000.00,43000.00,'BC-016-EF',225,'Automatic',8,5,5,'Volvo XC90 Recharge',7,1,2025,'Gold','#17202A','Metallic','Hybrid','Volvo','Sold',33),('BB1CC2DD3EE4FF517',39000.00,'2025-11-08',22500.00,19000.00,'BC-017-EF',150,'Manual',6,5,5,'Skoda Superb',6,0,2020,'Basic','#85929E','Matte','Diesel','Skoda','Sold',58),('BB1CC2DD3EE4FF518',2100.00,'2026-05-20',65000.00,59500.00,'BC-018-EF',300,'Automatic',8,5,5,'Jaguar F-Pace',7,1,2025,'Gold','#154360','Glossy','Hybrid','Jaguar','Sold',51),('BB1CC2DD3EE4FF519',28000.00,'2026-01-12',31000.00,27000.00,'BC-019-EF',170,'Automatic',6,5,5,'Mitsubishi Outlander',6,1,2022,'Premium','#AEB6BF','Matte','Hybrid','Mitsubishi','Sold',40),('BB1CC2DD3EE4FF520',16000.00,'2026-02-28',29000.00,25000.00,'BC-020-EF',160,'Automatic',6,5,5,'Subaru XV',6,1,2022,'Premium','#148F77','Glossy','Petrol','Subaru','Sold',53),('JH4KA9650MC012874',9500.00,'2026-04-12',24000.00,21000.00,'MN-447-QS',190,'Manual',5,5,5,'Renault Captur',5,1,2020,'Basic','#DDDDDD','Matte','Petrol','Renault','Sold',5),('JHMCM56557C384729',13400.00,'2026-05-18',29500.00,25500.00,'QA-661-TR',195,'Automatic',6,5,5,'Toyota Corolla Touring',6,1,2021,'Premium','#999999','Glossy','Hybrid','Toyota','Sold',7),('jkhgbfjkhzegbfkuj',10000.00,'2026-05-26',10000.00,10000.00,'X-XXX-XXX',100,'Automatic',6,5,5,'',1,0,2020,'Basic','#000000','Glossy','Diesel','Alfa Romeo','New',1),('JN1BJ1CP7JW184736',6400.00,'2026-05-08',17000.00,14500.00,'LO-642-GH',165,'Manual',5,5,5,'Toyota Yaris',5,0,2018,'Basic','#EEEEEE','Matte','Petrol','Toyota','Sold',10),('JN1BJ1CR5HW000004',102331.11,'2025-01-28',13200.00,10500.00,'CAR-1004',110,'Manual',6,5,5,'Nissan Qashqai',5,0,2016,'Basic','#0000FF','Glossy','Diesel','Nissan','Sold',4),('JN1CV6EK9DM000024',109221.00,'2025-01-31',11800.00,9100.00,'CAR-1024',115,'Manual',6,5,5,'Nissan Micra',5,0,2016,'Basic','#0000FF','Glossy','Petrol','Nissan','Sold',4),('JN8AS5MT9CW000014',118522.20,'2025-01-29',9800.00,7600.00,'CAR-1014',102,'Manual',5,5,5,'Nissan Juke',4,0,2015,'Basic','#8B0000','Glossy','Petrol','Nissan','Sold',4),('JS2YB5A35C6000012',93114.77,'2025-02-21',11900.00,9300.00,'CAR-1012',98,'Manual',5,5,5,'Suzuki Vitara',5,0,2017,'Basic','#CD853F','Glossy','Petrol','Suzuki','Sold',2),('JS2YC5A34D6000022',72111.77,'2025-02-15',14200.00,11200.00,'CAR-1022',105,'Manual',5,5,5,'Suzuki S-Cross',5,0,2018,'Basic','#FFFFFF','Glossy','Petrol','Suzuki','Sold',2),('JSAAZC21S00100002',84211.20,'2025-02-03',12800.00,9900.00,'CAR-1002',95,'Manual',5,5,5,'Suzuki Swift',5,0,2017,'Basic','#FFFFFF','Glossy','Petrol','Suzuki','Sold',2),('JT123456789ABCDEF',45000.00,'2024-01-15',25000.00,18000.00,'1-ABC-123',190,'Automatic',6,5,5,'BMW Serie 3 full option',6,1,2020,'Premium','#000000','Glossy','Diesel','BMW','Sold',1),('JTDBR32E720184563',5000.00,'2026-01-25',60000.00,52000.00,'FF-606-FF',170,'Automatic',5,5,5,'Toyota Yaris Hybrid',5,1,2020,'Basic','#CCCCCC','Glossy','Hybrid','Toyota','Sold',9),('JTDKARFU8J3000025',35522.11,'2025-04-05',31400.00,27100.00,'CAR-1025',235,'Automatic',8,5,5,'Toyota Corolla',7,1,2024,'Gold','#FF0000','Metallic','Hybrid','Toyota','New',5),('JTDKB20U793412875',12700.00,'2026-05-01',26000.00,22000.00,'ER-229-VB',185,'Automatic',6,5,5,'Ford Focus ST',6,1,2020,'Premium','#880000','Glossy','Petrol','Ford','Sold',6),('JTDKN3DU0A0000005',28221.88,'2025-04-08',28700.00,24300.00,'CAR-1005',205,'Automatic',8,5,5,'Toyota Prius',7,1,2023,'Gold','#FF0000','Metallic','Hybrid','Toyota','Sold',5),('JTDKN3DU7A1293846',8000.00,'2026-01-14',42000.00,37000.00,'CC-303-CC',180,'Automatic',6,5,5,'Toyota Corolla Hybrid',6,1,2022,'Gold','#00AA00','Glossy','Hybrid','Toyota','Sold',6),('JTHBK1EG9F2000009',41220.55,'2025-02-27',31800.00,27200.00,'CAR-1009',245,'Automatic',8,5,5,'Lexus RX',7,1,2022,'Gold','#800080','Metallic','Hybrid','Lexus','Sold',4),('JTHCE1BL0FA000019',29888.44,'2025-02-26',38700.00,33900.00,'CAR-1019',285,'Automatic',8,5,5,'Lexus ES',7,1,2023,'Gold','#9370DB','Metallic','Hybrid','Lexus','Sold',4),('JTHKD5BH5F2000029',24410.77,'2025-02-22',40500.00,35600.00,'CAR-1029',310,'Automatic',8,5,5,'Lexus NX',7,1,2024,'Gold','#800080','Metallic','Hybrid','Lexus','Sold',4),('JTNB11HK303000015',34411.88,'2025-04-02',29900.00,25800.00,'CAR-1015',220,'Automatic',8,5,5,'Toyota Camry',7,1,2023,'Gold','#4682B4','Metallic','Hybrid','Toyota','Sold',5),('KLATF08Y1VB329874',4700.00,'2026-05-14',12500.00,9800.00,'IK-112-XC',155,'Manual',5,5,5,'Renault Zoe',5,1,2017,'Basic','#77AAFF','Glossy','Electric','Renault','Sold',5),('KMHCG45C12U384761',5400.00,'2026-04-27',14000.00,11000.00,'QS-909-HG',160,'Manual',5,5,5,'Renault Twingo',4,0,2017,'Basic','#FF66AA','Glossy','Petrol','Renault','Sold',4),('TRUUT28N531847562',29900.00,'2026-05-10',59000.00,54000.00,'RT-781-KL',255,'Automatic',7,5,5,'Audi Q7 S-Line',7,1,2024,'Gold','#333333','Glossy','Diesel','Audi','Sold',11),('VF1RFB00865473921',12000.00,'2026-01-22',27000.00,22000.00,'EE-505-EE',190,'Manual',6,5,5,'Renault Clio RS',5,1,2021,'Premium','#FF0000','Matte','Petrol','Renault','Sold',8),('VF7N2LFYHJD028374',19800.00,'2026-04-29',41000.00,37000.00,'WX-672-CD',225,'Automatic',6,5,5,'Toyota C-HR Hybrid',6,1,2022,'Premium','#008800','Matte','Hybrid','Toyota','Sold',5),('W0L0SDL08F6000007',132211.90,'2025-03-01',8900.00,6900.00,'CAR-1007',88,'Manual',5,5,5,'Opel Corsa',4,0,2014,'Basic','#FFFF00','Glossy','Petrol','Opel','Sold',2),('W0LGT8EM6C1000017',140411.32,'2025-03-05',7600.00,5900.00,'CAR-1017',82,'Manual',5,3,4,'Opel Astra',4,0,2013,'Basic','#D2691E','Matte','Petrol','Opel','Sold',2),('W0LPD6EH6D4000027',126332.40,'2025-03-17',8400.00,6500.00,'CAR-1027',85,'Manual',5,5,5,'Opel Insignia',4,0,2014,'Basic','#FFFF00','Matte','Petrol','Opel','Sold',2),('WA1ANAFY4J2147385',25500.00,'2026-05-06',48000.00,43000.00,'DF-876-YU',235,'Automatic',7,5,5,'BMW X3 Hybrid',7,1,2023,'Premium','#0A0A0A','Glossy','Hybrid','BMW','Sold',9),('WA1LFAFP8CA672845',18000.00,'2026-02-01',45000.00,39000.00,'GG-707-GG',240,'Automatic',7,5,5,'Audi Q5 Quattro',7,1,2022,'Gold','#0000FF','Glossy','Diesel','Audi','Excellent',10),('WAU987654321ABCDE',12000.00,'2024-03-10',32000.00,25000.00,'2-DEF-456',220,'Automatic',7,5,5,'Audi A4 sport',6,1,2022,'Gold','#FFFFFF','Matte','Hybrid','Audi','Sold',2),('WAUZZZ4G6HN000010',68211.73,'2025-04-12',21600.00,17900.00,'CAR-1010',165,'Automatic',7,5,5,'Audi A4',6,1,2020,'Premium','#A9A9A9','Glossy','Diesel','Audi','Sold',5),('WAUZZZ8K9DA118274',33000.00,'2026-04-18',61000.00,56000.00,'GH-821-JK',260,'Automatic',7,5,5,'BMW X6 Competition',7,1,2024,'Gold','#111111','Glossy','Hybrid','BMW','Sold',8),('WAUZZZF42MN847362',30000.00,'2026-01-20',55000.00,49000.00,'DD-404-DD',250,'Automatic',8,5,5,'BMW X5 M Sport',7,1,2023,'Gold','#222222','Glossy','Diesel','BMW','New',7),('WAUZZZF44LA000020',74221.55,'2025-04-09',20500.00,16800.00,'CAR-1020',160,'Automatic',7,5,5,'Audi Q3',6,1,2020,'Premium','#696969','Glossy','Diesel','Audi','Sold',5),('WAUZZZF46MN000030',63211.22,'2025-04-15',23800.00,19400.00,'CAR-1030',185,'Automatic',7,5,5,'Audi A6',6,1,2021,'Premium','#A9A9A9','Glossy','Diesel','Audi','Sold',5),('WBA123456789ABCDE',5000.00,'2024-04-01',40000.00,33000.00,'3-GHI-789',180,'Automatic',6,5,5,'Toyota Prius Hybrid',7,1,2023,'Gold','#808080','Glossy','Hybrid','Toyota','Sold',3),('WBA3A5C58CF384920',37200.00,'2026-05-03',74000.00,69000.00,'CV-761-NM',270,'Automatic',7,5,5,'Audi RS5',7,1,2024,'Gold','#222222','Matte','Hybrid','Audi','Sold',7),('WBA3A5C58DF000016',80111.65,'2025-02-10',16500.00,13400.00,'CAR-1016',145,'Manual',6,5,5,'BMW Series 1',6,1,2018,'Premium','#556B2F','Glossy','Diesel','BMW','Sold',1),('WBA4J1C50KB000026',67771.66,'2025-02-08',22600.00,18800.00,'CAR-1026',175,'Automatic',7,5,5,'BMW Series 4',6,1,2020,'Premium','#808080','Glossy','Diesel','BMW','Sold',1),('WBA8E9G51GNU00006',74412.32,'2025-02-17',19400.00,15900.00,'CAR-1006',150,'Automatic',7,5,5,'BMW Series 3',6,1,2019,'Premium','#222222','Metallic','Diesel','BMW','Sold',1),('WBA8E9G51HNU38274',22000.00,'2026-01-12',35000.00,30000.00,'BB-202-BB',200,'Manual',6,5,5,'Ford Focus Titanium',5,1,2020,'Premium','#FFFFFF','Matte','Petrol','Ford','Sold',5),('WDBUF56X98B274615',38900.00,'2026-05-16',81000.00,76000.00,'NM-843-PO',280,'Automatic',7,5,5,'BMW M5 Competition',7,1,2025,'Gold','#000000','Matte','Hybrid','BMW','Sold',6),('WMWMF31070T000018',61122.33,'2025-01-23',18800.00,15100.00,'CAR-1018',150,'Automatic',6,3,4,'Mini Countryman',6,1,2019,'Premium','#20B2AA','Metallic','Diesel','Mini','Sold',3),('WMWXM710502000008',55412.22,'2025-01-20',17900.00,14500.00,'CAR-1008',136,'Automatic',6,3,4,'Mini Cooper',6,1,2018,'Premium','#00FF00','Metallic','Petrol','Mini','Sold',3),('WMWZC31070T000028',58888.55,'2025-01-25',19600.00,15900.00,'CAR-1028',155,'Automatic',6,3,4,'Mini Clubman',6,1,2019,'Premium','#00FF00','Metallic','Diesel','Mini','Good',3),('WVWZZZ1JZXW563829',28500.00,'2026-04-14',52000.00,47000.00,'OP-778-LM',245,'Automatic',7,5,5,'Audi A5 Sportback',7,1,2023,'Gold','#000088','Glossy','Hybrid','Audi','Sold',6),('XXXXXXXXXXXXXXXXf',111.00,'2026-05-21',13200.00,13200.00,'X-XFff-FFF',132,'Automatic',6,5,5,'',1,0,2020,'Basic','#000000','Glossy','Diesel','Alfa Romeo','New',1),('XXXXXXXXXXXXXXXXm',110.00,'2026-05-21',111.00,111.00,'X-XXX-XXt',111,'Automatic',6,5,5,'',1,0,2020,'Basic','#000000','Glossy','Diesel','Alfa Romeo','New',6),('YS3FD49Y681273645',6800.00,'2026-04-20',19500.10,16500.00,'PL-551-WX',165,'Manual',5,5,5,'Toyota Aygo X',4,0,2018,'Basic','#F5F5F5','Matte','Petrol','Toyota','Sold',9),('YV1FS84A1C2000023',48811.14,'2025-03-08',26800.00,22600.00,'CAR-1023',210,'Automatic',8,5,5,'Volvo S60',7,1,2022,'Premium','#C0C0C0','Metallic','Hybrid','Volvo','Sold',3),('YV1RS61T242000003',65510.12,'2025-03-14',22400.00,18800.00,'CAR-1003',180,'Automatic',7,5,5,'Volvo XC40',6,1,2020,'Premium','#808080','Metallic','Hybrid','Volvo','Sold',6),('YV4A22PK8J1000013',50210.45,'2025-03-19',24900.00,20800.00,'CAR-1013',190,'Automatic',7,5,5,'Volvo XC60',6,1,2021,'Premium','#708090','Metallic','Hybrid','Volvo','Sold',3);
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
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2026-05-30 17:13:48
