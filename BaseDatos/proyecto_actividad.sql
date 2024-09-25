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
-- Table structure for table `actividad`
--

DROP TABLE IF EXISTS `actividad`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `actividad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `dias_semana` varchar(10) NOT NULL,
  `numero_dias` varchar(1) NOT NULL,
  `horario_dias` varchar(20) NOT NULL,
  `curso` varchar(2) NOT NULL,
  `img` varchar(45) NOT NULL,
  `descripcion` varchar(499) NOT NULL,
  `precio` float NOT NULL,
  `matricula` float DEFAULT NULL,
  `id_empresa_actividad` int NOT NULL,
  `tipo_actividad` enum('deportivas','formativas','ambas') DEFAULT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idActividadEmpresa_idx` (`id_empresa_actividad`),
  CONSTRAINT `id_empresa_actividad` FOREIGN KEY (`id_empresa_actividad`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `actividad`
--

LOCK TABLES `actividad` WRITE;
/*!40000 ALTER TABLE `actividad` DISABLE KEYS */;
INSERT INTO `actividad` VALUES (1,'Clases de Matemáticas','L','1','15:00-16:00','I1','img_matematicas.jpg','Sumérgete en un mundo de diversión matemática para niños. Descubre números y formas de manera emocionante con juegos interactivos y actividades creativas. ¡Aprende mientras juegas y despierta tu amor por las matemáticas desde pequeño!',50,20,'Formativa',1),(2,'Entrenamiento Fitness','M','1','15:00-16:30','P3','img_fitness.jpg','Embárcate en una emocionante aventura de entrenamiento fitness diseñada especialmente para niños. Diviértete mientras desarrollas habilidades motoras, fuerza y resistencia. ¡Ejercítate con juegos y actividades que harán que el fitness sea una experiencia emocionante y saludable para los más pequeños',30,15,'Deportiva',3),(3,'Clases de Inglés','X','1','15:00-16:00','P3','img_ingles.jpg','Descubre el mundo del inglés de manera divertida y educativa en nuestras clases diseñadas para niños. Aprende el idioma con juegos interactivos, canciones y actividades creativas. ¡Fomenta la confianza lingüística desde temprana edad y disfruta del viaje hacia el dominio del inglés de manera lúdica y participativa!',40,25,'Formativa',2),(4,'Entrenamiento Deportivo','M,J','2','16:00-17:30','P5','img_deportes.jpg','Únete a nuestro entrenamiento deportivo para niños de quinto de primaria. Desarrolla habilidades atléticas, trabajo en equipo y una vida activa a través de juegos divertidos y desafíos emocionantes. ¡Prepárate para fortalecer tu cuerpo y mente mientras disfrutas de la pasión por el deporte en un ambiente motivador y educativo!',35,18,'Deportiva',4),(5,'Yoga Relajante','X,V','2','16:00-17:30','E2','img_yoga.jpg','Explora la serenidad del yoga en nuestras clases relajantes diseñadas para estudiantes de segundo de la ESO. Encuentra equilibrio entre mente y cuerpo a través de posturas suaves, técnicas de respiración y meditación. ¡Cultiva la calma interior y mejora tu bienestar físico y emocional mientras disfrutas de una experiencia rejuvenecedora de yoga relajante!',25,10,'Deportiva',3),(6,'Clases de Ciencias','M,S','2','09:00-10:30','E2','img_ciencias.jpg','Embárcate en emocionantes clases de ciencias diseñadas para estudiantes de segundo de la ESO. Descubre los misterios del mundo natural a través de experimentos prácticos, investigaciones y debates estimulantes. ¡Explora la fascinante interconexión de la biología, química y física mientras desarrollas habilidades científicas críticas para comprender y apreciar el asombroso universo que nos rodea!',45,30,'Formativa',1),(7,'Natación','L,X,V','3','15:00-16:30','E4','img_natacion.jpg','Sumérgete en nuestras clases de natación diseñadas para adolescentes. Aprende y perfecciona las habilidades acuáticas, mejora la resistencia y fortalece tu confianza en el agua. Con un enfoque divertido y seguro, descubre los beneficios del ejercicio acuático mientras te diviertes y adquieres habilidades esenciales para toda la vida. ¡Haz de la natación una experiencia saludable y emocionante',55,40,'Deportiva',4),(8,'Clases de Alemán','M,J,S','3','15:00-16:30','B1','img_aleman.jpg','Explora el fascinante idioma alemán en nuestras clases interactivas. Aprende de manera dinámica con énfasis en la conversación, gramática y cultura. Sumérgete en un viaje educativo que te permitirá desarrollar habilidades lingüísticas sólidas y disfrutar del aprendizaje del alemán de manera divertida y efectiva.',40,25,'Formativa',2),(9,'terwert','d','3','3','er','C:\\fakepath\\panelSolar.png','erwqre',23,4,'Deportiva',1);
/*!40000 ALTER TABLE `actividad` ENABLE KEYS */;
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
