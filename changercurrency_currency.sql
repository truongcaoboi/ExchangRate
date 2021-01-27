-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: changercurrency
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `currency`
--

DROP TABLE IF EXISTS `currency`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `currency` (
  `id` int NOT NULL AUTO_INCREMENT,
  `sum_name` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cur_name` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `exchange_rate` double DEFAULT NULL,
  `nation` varchar(200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `modify_date` bigint DEFAULT NULL,
  `number_code` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `ranking` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `sum_name` (`sum_name`)
) ENGINE=InnoDB AUTO_INCREMENT=362 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currency`
--

LOCK TABLES `currency` WRITE;
/*!40000 ALTER TABLE `currency` DISABLE KEYS */;
INSERT INTO `currency` VALUES (180,'AFN','Afghan afghani',77.450196,'Afghanistan',1611162480000,'971',NULL),(181,'EUR','European euro',0.825526,'',1611162480000,'978',3),(182,'ALL','Albanian lek',101.775,'Albania',1611162480000,'008',NULL),(183,'DZD','Algerian dinar',132.85272,'Algeria',1611162480000,'012',NULL),(184,'USD','United States dollar',1,'United States of America',1611162480000,'840',3),(185,'AOA','Angolan kwanza',656.23,'Angola',1611162480000,'973',NULL),(186,'XCD','East Caribbean dollar',2.70255,'',1611162480000,'951',NULL),(187,'ARS','Argentine peso',86.3593,'Argentina',1611162480000,'032',NULL),(188,'AMD','Armenian dram',521.418477,'Armenia',1611162480000,'051',NULL),(189,'AWG','Aruban florin',1.8,'Aruba (Netherlands)',1611162480000,'533',NULL),(190,'SHP','Saint Helena pound',0.731802,'Saint Helena (UK)',1611162480000,'654',NULL),(191,'AUD','Australian dollar',1.289317,'Australia',1611162480000,'036',3),(192,'AZN','Azerbaijan manat',1.700805,'Azerbaijan',1611162480000,'944',NULL),(193,'BSD','Bahamian dollar',1,'Bahamas',1611162480000,'044',NULL),(194,'BHD','Bahraini dinar',0.376985,'Bahrain',1611162480000,'048',NULL),(195,'BDT','Bangladeshi taka',84.803613,'Bangladesh',1611162480000,'050',NULL),(196,'BBD','Barbadian dollar',2,'Barbados',1611162480000,'052',NULL),(197,'BYN','Belarusian ruble',2.53998,'Belarus',1611162480000,NULL,NULL),(198,'BZD','Belize dollar',2.015637,'Belize',1611162480000,'084',NULL),(199,'XOF','West African CFA franc',541.509805,'',1611162480000,'952',NULL),(200,'BMD','Bermudian dollar',1,'Bermuda (UK)',1611162480000,'060',NULL),(201,'BTN','Bhutanese ngultrum',72.990767,'Bhutan',1611162480000,'064',NULL),(202,'BOB','Bolivian boliviano',6.884902,'Bolivia',1611162480000,'068',NULL),(203,'BAM','Bosnia and Herzegovina convertible mark',1.614747,'Bosnia and Herzegovina',1611162480000,'977',NULL),(204,'BWP','Botswana pula',10.922864,'Botswana',1611162480000,'072',NULL),(205,'BRL','Brazilian real',5.2918,'Brazil',1611162480000,'986',NULL),(206,'BND','Brunei dollar',1.326173,'Brunei',1611162480000,'096',NULL),(207,'BGN','Bulgarian lev',1.61732,'Bulgaria',1611162480000,'975',NULL),(208,'BIF','Burundi franc',1946.245163,'Burundi',1611162480000,'108',NULL),(209,'CVE','Cabo Verdean escudo',91.405,'Cabo Verde',1611162480000,'132',NULL),(210,'KHR','Cambodian riel',4055.370575,'Cambodia',1611162480000,'116',NULL),(211,'XAF','Central African CFA franc',541.509805,'Central African Republic',1611162480000,'950',NULL),(212,'CAD','Canadian dollar',1.26227,'Canada',1611162480000,'124',3),(213,'KYD','Cayman Islands dollar',0.833285,'Cayman Islands (UK)',1611162480000,'136',NULL),(214,'NZD','New Zealand dollar',1.391789,'New Zealand',1611162480000,'554',NULL),(215,'CLP','Chilean peso',722.1,'Chile',1611162480000,'152',NULL),(216,'CNY','Chinese Yuan Renminbi',6.4665,'China',1611162480000,'156',3),(217,'COP','Colombian peso',3491.499653,'Colombia',1611162480000,'170',NULL),(218,'KMF','Comorian franc',406.675213,'Comoros',1611162480000,'174',NULL),(219,'CDF','Congolese franc',1973.964828,'Congo, Democratic Republic of the',1611162480000,'976',NULL),(220,'none','Cook Islands dollar',-1,'Faroe Islands (Denmark)',1611225723735,NULL,NULL),(221,'CRC','Costa Rican colon',608.827189,'Costa Rica',1611162480000,'188',NULL),(222,'HRK','Croatian kuna',6.2425,'Croatia',1611162480000,'191',NULL),(223,'CUP','Cuban peso',26.5,'Cuba',1611162480000,'192',NULL),(224,'ANG','Netherlands Antillean guilder',1.794952,'',1611162480000,'532',NULL),(225,'CZK','Czech koruna',21.544,'Czechia',1611162480000,'203',NULL),(226,'DKK','Danish krone',6.14064,'',1611162480000,'208',NULL),(227,'DJF','Djiboutian franc',178.025653,'Djibouti',1611162480000,'262',NULL),(228,'DOP','Dominican peso',58.089554,'Dominican Republic',1611162480000,'214',NULL),(229,'EGP','Egyptian pound',15.7466,'Egypt',1611162480000,'818',NULL),(230,'ERN','Eritrean nakfa',14.999753,'Eritrea',1611162480000,'232',NULL),(231,'SZL','Swazi lilangeni',14.914339,'',1611162480000,'748',NULL),(232,'ETB','Ethiopian birr',39.393133,'Ethiopia',1611162480000,'230',NULL),(233,'FKP','Falkland Islands pound',0.731802,'Falkland Islands (UK)',1611162480000,'238',NULL),(234,'FJD','Fijian dollar',2.03795,'Fiji',1611162480000,'242',NULL),(235,'XPF','CFP franc',98.511501,'',1611162480000,'953',NULL),(236,'GMD','Gambian dalasi',51.75,'Gambia',1611162480000,'270',NULL),(237,'GEL','Georgian lari',3.305,'Georgia',1611162480000,'981',NULL),(238,'GHS','Ghanaian cedi',5.837965,'Ghana',1611162480000,'288',NULL),(239,'GIP','Gibraltar pound',0.731802,'Gibraltar (UK)',1611162480000,'292',NULL),(240,'GTQ','Guatemalan quetzal',7.787373,'Guatemala',1611162480000,'320',NULL),(241,'GGP','Guernsey Pound',0.731802,'Guernsey (UK)',1611162480000,NULL,NULL),(242,'GNF','Guinean franc',10228.189639,'Guinea',1611162480000,'324',NULL),(243,'GYD','Guyanese dollar',209.208903,'Guyana',1611162480000,'328',NULL),(244,'HTG','Haitian gourde',71.827807,'Haiti',1611162480000,'332',NULL),(245,'HNL','Honduran lempira',24.229381,'Honduras',1611162480000,'340',NULL),(246,'HKD','Hong Kong dollar',7.75175,'Hong Kong (China)',1611162480000,'344',NULL),(247,'HUF','Hungarian forint',295.023218,'Hungary',1611162480000,'348',NULL),(248,'ISK','Icelandic krona',129.48,'Iceland',1611162480000,'352',NULL),(249,'INR','Indian rupee',72.908157,'India',1611162480000,'356',NULL),(250,'IDR','Indonesian rupiah',14021.8935,'Indonesia',1611162480000,'360',NULL),(251,'XDR','SDR (Special Drawing Right)',0.693899,'',1611162480000,'960',NULL),(252,'IRR','Iranian rial',42101.7,'Iran',1611162480000,'364',NULL),(253,'IQD','Iraqi dinar',1460.986005,'Iraq',1611162480000,'368',NULL),(254,'IMP','Manx pound',0.731802,'',1611162480000,NULL,NULL),(255,'ILS','Israeli new shekel',3.27004,'Israel',1611162480000,'376',NULL),(256,'JMD','Jamaican dollar',144.733049,'Jamaica',1611162480000,'388',NULL),(257,'JPY','Japanese yen',103.5735,'Japan',1611162480000,'392',3),(258,'JEP','Jersey pound',0.731802,'Jersey (UK)',1611162480000,NULL,NULL),(259,'JOD','Jordanian dinar',0.709,'Jordan',1611162480000,'400',NULL),(260,'KZT','Kazakhstani tenge',418.978841,'Kazakhstan',1611162480000,'398',NULL),(261,'KES','Kenyan shilling',110.198603,'Kenya',1611162480000,'404',NULL),(262,'KWD','Kuwaiti dinar',0.302777,'Kuwait',1611162480000,'414',NULL),(263,'KGS','Kyrgyzstani som',83.938641,'Kyrgyzstan',1611162480000,'417',NULL),(264,'LAK','Lao kip',9319.843124,'Laos',1611162480000,'418',NULL),(265,'LBP','Lebanese pound',1514.519803,'Lebanon',1611162480000,'422',NULL),(266,'LSL','Lesotho loti',14.902997,'Lesotho',1611162480000,'426',NULL),(267,'LRD','Liberian dollar',169.500006,'Liberia',1611162480000,'430',NULL),(268,'LYD','Libyan dinar',4.463889,'Libya',1611162480000,'434',NULL),(269,'CHF','Swiss franc',0.889466,'Switzerland',1611162480000,'756',3),(270,'MOP','Macanese pataca',7.984115,'Macau (China)',1611162480000,'446',NULL),(271,'MGA','Malagasy ariary',3788.065102,'',1611162480000,'969',NULL),(272,'MWK','Malawian kwacha',771.915872,'Malawi',1611162480000,'454',NULL),(273,'MYR','Malaysian ringgit',4.0425,'Malaysia',1611162480000,'458',NULL),(274,'MVR','Maldivian rufiyaa',15.4,'Maldives',1611162480000,'462',NULL),(275,'MRU','Mauritanian ouguiya',36.3445,'Mauritania',1611162480000,NULL,NULL),(276,'MUR','Mauritian rupee',39.639999,'Mauritius',1611162480000,'480',NULL),(277,'MXN','Mexican peso',19.58701,'Mexico',1611162480000,'484',NULL),(278,'MDL','Moldovan leu',17.365729,'Moldova',1611162480000,'498',NULL),(279,'MNT','Mongolian tugrik',2854.932843,'Mongolia',1611162480000,'496',NULL),(280,'MAD','Moroccan dirham',8.968547,'Morocco',1611162480000,'504',NULL),(281,'MZN','Mozambican metical',75.040004,'Mozambique',1611162480000,'943',NULL),(282,'MMK','Myanmar kyat',1332.981861,'Myanmar (formerly Burma)',1611162480000,'104',NULL),(283,'NAD','Namibian dollar',14.89,'Namibia',1611162480000,'516',NULL),(284,'NPR','Nepalese rupee',116.785415,'Nepal',1611162480000,'524',NULL),(285,'NIO','Nicaraguan cordoba',34.959542,'Nicaragua',1611162480000,'558',NULL),(286,'NGN','Nigerian naira',387.573731,'Nigeria',1611162480000,'566',NULL),(287,'KPW','North Korean won',900.057,'North Korea',1611162480000,'408',NULL),(288,'MKD','Macedonian denar',50.87986,'',1611162480000,'807',NULL),(289,'NOK','Norwegian krone',8.480465,'Norway',1611162480000,'578',NULL),(290,'OMR','Omani rial',0.384946,'Oman',1611162480000,'512',NULL),(291,'PKR','Pakistani rupee',160.556419,'Pakistan',1611162480000,'586',NULL),(292,'PGK','Papua New Guinean kina',3.53,'Papua New Guinea',1611162480000,'598',NULL),(293,'PYG','Paraguayan guarani',6904.478724,'Paraguay',1611162480000,'600',NULL),(294,'PEN','Peruvian sol',3.615104,'Peru',1611162480000,'604',NULL),(295,'PHP','Philippine peso',48.009249,'Philippines',1611162480000,'608',NULL),(296,'PLN','Polish zloty',3.744653,'Poland',1611162480000,'985',NULL),(297,'QAR','Qatari riyal',3.641,'Qatar',1611162480000,'634',NULL),(298,'RON','Romanian leu',4.0237,'Romania',1611162480000,'946',NULL),(299,'RUB','Russian ruble',73.504,'Russia',1611162480000,'643',NULL),(300,'RWF','Rwandan franc',989.111888,'Rwanda',1611162480000,'646',NULL),(301,'WST','Samoan tala',2.508609,'Samoa',1611162480000,'882',NULL),(302,'STN','Sao Tome and Principe dobra',-1,'Sao Tome and Principe',1611225723735,NULL,NULL),(303,'SAR','Saudi Arabian riyal',3.751854,'Saudi Arabia',1611162480000,'682',NULL),(304,'RSD','Serbian dinar',97.4,'Serbia',1611162480000,'941',NULL),(305,'SCR','Seychellois rupee',21.203654,'Seychelles',1611162480000,'690',NULL),(306,'SLL','Sierra Leonean leone',10194.438439,'Sierra Leone',1611162480000,'694',NULL),(307,'SGD','Singapore dollar',1.32488,'Singapore',1611162480000,'702',3),(308,'SBD','Solomon Islands dollar',7.969266,'Solomon Islands',1611162480000,'090',NULL),(309,'SOS','Somali shilling',579.901895,'Somalia',1611162480000,'706',NULL),(310,'ZAR','South African rand',14.90432,'South Africa',1611162480000,'710',NULL),(311,'GBP','Pound sterling',0.731802,'',1611162480000,'826',3),(312,'KRW','South Korean won',1098.67905,'South Korea',1611162480000,'410',3),(313,'SSP','South Sudanese pound',-1,'South Sudan',1611225723735,NULL,NULL),(314,'LKR','Sri Lankan rupee',195.49682,'Sri Lanka',1611162480000,'144',NULL),(315,'SDG','Sudanese pound',55.3198,'Sudan',1611162480000,'938',NULL),(316,'SRD','Surinamese dollar',14.154,'Suriname',1611162480000,'968',NULL),(317,'SEK','Swedish krona',8.340175,'Sweden',1611162480000,'752',NULL),(318,'SYP','Syrian pound',512.828,'Syria',1611162480000,'760',NULL),(319,'TWD','New Taiwan dollar',27.883701,'',1611162480000,'901',NULL),(320,'TJS','Tajikistani somoni',11.39478,'Tajikistan',1611162480000,'972',NULL),(321,'TZS','Tanzanian shilling',2318.972749,'Tanzania',1611162480000,'834',NULL),(322,'THB','Thai baht',29.942612,'Thailand',1611162480000,'764',3),(323,'TOP','Tongan pa’anga',2.292365,'Tonga',1611162480000,'776',NULL),(324,'TTD','Trinidad and Tobago dollar',6.783187,'Trinidad and Tobago',1611162480000,'780',NULL),(325,'TND','Tunisian dinar',2.7075,'Tunisia',1611162480000,'788',NULL),(326,'TRY','Turkish lira',7.42,'Turkey',1611162480000,'949',NULL),(327,'TMT','Turkmen manat',3.51,'Turkmenistan',1611162480000,NULL,NULL),(328,'UGX','Ugandan shilling',3694.915306,'Uganda',1611162480000,'800',NULL),(329,'UAH','Ukrainian hryvnia',28.254502,'Ukraine',1611162480000,'980',NULL),(330,'AED','UAE dirham',3.6732,'',1611162480000,'784',NULL),(331,'UYU','Uruguayan peso',42.253483,'Uruguay',1611162480000,'858',NULL),(332,'UZS','Uzbekistani som',10500.296996,'Uzbekistan',1611162480000,'860',NULL),(333,'VUV','Vanuatu vatu',108.562315,'Vanuatu',1611162480000,'548',NULL),(334,'VES','Venezuelan bolivar',1560965.25,'Venezuela',1611162480000,NULL,NULL),(335,'VND','Vietnamese dong',23067.446959,'Vietnam',1611162480000,'704',3),(336,'YER','Yemeni rial',250.350066,'Yemen',1611162480000,'886',NULL),(337,'ZMW','Zambian kwacha',21.344667,'Zambia',1611162480000,NULL,NULL),(338,'STD','Sao Tome/Principe Dobra',20466.377105,'Sao Tome and Principe',1611162480000,'678',NULL),(339,'LVL','Latvian Lats',0.656261,'Latvia',1611162480000,'428',NULL),(340,'CUC','Cuban Convertible Peso',1,'Cuba',1611162480000,NULL,NULL),(341,'BCH','Bitcoin Cash',0.002022387833314795,'',1611162480000,NULL,NULL),(342,'BTC','Bitcoin',0.00002828241461680439,'',1611162480000,NULL,NULL),(343,'SVC','Salvadoran Colon',8.749783,'El Salvador',1611162480000,NULL,NULL),(344,'MRO','Mauritanian Ouguiya',356.999828,'Mauritania',1611162480000,'478',NULL),(345,'XPD','Palladium gram',0.00042054,'',1611162480000,'964',NULL),(346,'XPT','Platinum gram',0.0008994,'',1611162480000,'962',NULL),(347,'PAB','Panamanian Balboa',1,'Panama',1611162480000,'590',NULL),(348,'ETC','Ethereum Classic',0.11405759908753921,'',1611162480000,NULL,NULL),(349,'VEF','Venezuelan bolívar',248487.642241,'Venezuela',1611162480000,NULL,NULL),(350,'ETH','Ethereum',0.0007327617791455998,'',1611162480000,NULL,NULL),(351,'ZEC','Zcash',0.010100499974748751,'',1611162480000,NULL,NULL),(352,'ZMK','Zambian Kwacha',5253.075255,'Zambia',1611162480000,'894',NULL),(353,'XAG','Silver Ounce',0.0387147,'',1611162480000,'961',NULL),(354,'XAU','Gold Ounce - Gold Ounce',0.00053483,'',1611162480000,'959',3),(355,'DASH','Dash',0.008285656286120283,'',1611162480000,NULL,NULL),(356,'LTC','Litecoin',0.006717946995398206,'',1611162480000,NULL,NULL),(357,'USDC','Tether',1,'',1611162480000,NULL,NULL),(358,'LTL','Lithuanian litas',3.224845,'Lithuania',1611162480000,'440',NULL),(359,'XLM','Stellar',3.4318208726777297,'',1611162480000,NULL,NULL),(360,'BYR','Belarusian ruble',25399.8,'Belarus',1611162480000,'974',NULL),(361,'EOS','EOSIO Blockchain',0.36127167630057805,'',1611162480000,NULL,NULL);
/*!40000 ALTER TABLE `currency` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-01-22 21:11:10
