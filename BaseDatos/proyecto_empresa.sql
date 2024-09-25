-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: saguntokids
-- ------------------------------------------------------
-- Server version	8.0.35

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
-- Table structure for table `empresa`
--

DROP TABLE IF EXISTS `empresa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `empresa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `cif` varchar(9) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `telefono` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `tipo_actividad` int NOT NULL,
  `contrasenya` varchar(45) NOT NULL,
  `img` varchar(45) NOT NULL,
  `cuenta_bancaria` varchar(24) NOT NULL,
  `descripcion` varchar(499) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `empresa`
--

LOCK TABLES `empresa` WRITE;
/*!40000 ALTER TABLE `empresa` DISABLE KEYS */;
INSERT INTO `empresa` VALUES (1,'Academia Especializada en Matemáticas MathGenius','12345678A','Calle San Vicente 1, Valencia',46002,'info@mathgenius.com',1,'clave123','logo_mathgenius.png','ES11223344556677889900AA','Academia educativa especializada en la enseñanza de las matemáticas. Nuestros profesores altamente calificados y métodos innovadores ayudan a los estudiantes a mejorar sus habilidades matemáticas y alcanzar el éxito académico.'),(2,'Instituto de Idiomas Polyglot','87654321B','Avenida Paseo de Gracia 2, Barcelona',8002,'info@polyglot.com',1,'clave456','logo_polyglot.png','ES99887766554433221100BB','Instituto especializado en la enseñanza de idiomas, con un enfoque principal en inglés y alemán. Nuestro objetivo es proporcionar a los estudiantes las habilidades lingüísticas necesarias para tener éxito en un mundo globalizado.'),(3,'Gimnasio Fitness Zone','56781234C','Calle San Félix 3, Castellón',12002,'info@fitnesszone.com',2,'clave789','logo_fitnesszone.png','ES44556677889900112233CC','Gimnasio moderno con instalaciones de última generación que ofrece una amplia variedad de deportes, incluyendo fitness, yoga, pilates, natación, tenis y más. Nuestros entrenadores altamente capacitados brindan un enfoque personalizado para lograr los objetivos de cada cliente.'),(4,'Colegio de Verano AquaAdventure','43218765D','Avenida Blasco Ibáñez 4, Valencia',46010,'info@aquaadventure.com',2,'clave012','logo_aquaadventure.png','ES66778899001122334455DD','Colegio de verano especializado en actividades deportivas acuáticas y recreativas. Ofrecemos una experiencia única donde los estudiantes pueden participar en deportes acuáticos, juegos al aire libre, excursiones y más. Fomentamos el aprendizaje, la diversión y la amistad.');
/*!40000 ALTER TABLE `empresa` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-12 18:16:33
