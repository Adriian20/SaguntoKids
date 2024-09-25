-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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
  `tipo_actividad` varchar(45) NOT NULL,
  `id_empresa_actividad` int NOT NULL,
  `tipo_actividad` enum('deportivas','formativas','ambas') DEFAULT NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idActividadEmpresa_idx` (`id_empresa_actividad`),
  CONSTRAINT `id_empresa_actividad` FOREIGN KEY (`id_empresa_actividad`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
  KEY `id_actividad_empresa_idx` (`id_empresa_actividad`),
  CONSTRAINT `id_empresa_actividad` FOREIGN KEY (`id_empresa_actividad`) REFERENCES `empresa` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
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

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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
-- Table structure for table `dias_semana`
--

DROP TABLE IF EXISTS `dias_semana`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dias_semana` (
  `id_dia` int NOT NULL AUTO_INCREMENT,
  `nombre_dia` varchar(20) NOT NULL,
  PRIMARY KEY (`id_dia`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dias_semana`
--

LOCK TABLES `dias_semana` WRITE;
/*!40000 ALTER TABLE `dias_semana` DISABLE KEYS */;
INSERT INTO `dias_semana` VALUES (1,'Lunes'),(2,'Martes'),(3,'Miércoles'),(4,'Jueves'),(5,'Viernes'),(6,'Sábado'),(7,'Domingo');
/*!40000 ALTER TABLE `dias_semana` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-09 10:58:03

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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
-- Table structure for table `horario`
--

DROP TABLE IF EXISTS `horario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `horario` (
  `id_Horario` int NOT NULL AUTO_INCREMENT,
  `hora_inicio` varchar(5) DEFAULT NULL,
  `hora_fin` varchar(5) DEFAULT NULL,
  `id_perfil` int DEFAULT NULL,
  `id_dia_semana` int DEFAULT NULL,
  PRIMARY KEY (`id_Horario`),
  KEY `fk_horario_ibfk_2` (`id_perfil`),
  KEY `id_dia_semana` (`id_dia_semana`),
  CONSTRAINT `fk_horario_ibfk_2` FOREIGN KEY (`id_perfil`) REFERENCES `perfiles` (`id`),
  CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`id_dia_semana`) REFERENCES `dias_semana` (`id_dia`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `horario`
--

LOCK TABLES `horario` WRITE;
/*!40000 ALTER TABLE `horario` DISABLE KEYS */;
/*!40000 ALTER TABLE `horario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-09 10:58:03

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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
-- Table structure for table `matricula`
--

DROP TABLE IF EXISTS `matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `matricula` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_perfil_matriculado` int NOT NULL,
  `id_actividades_matriculadas` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idActividadesMatriculadas_idx` (`id_actividades_matriculadas`),
  KEY `idPerfilMatriculado_idx` (`id_perfil_matriculado`),
  CONSTRAINT `id_actividades_matriculadas` FOREIGN KEY (`id_actividades_matriculadas`) REFERENCES `actividad` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `id_perfil_matriculado` FOREIGN KEY (`id_perfil_matriculado`) REFERENCES `perfiles` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matricula`
--

LOCK TABLES `matricula` WRITE;
/*!40000 ALTER TABLE `matricula` DISABLE KEYS */;
INSERT INTO `matricula` VALUES (1,1,1),(2,3,2);
/*!40000 ALTER TABLE `matricula` ENABLE KEYS */;
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

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `curso` varchar(4) DEFAULT NULL,
  `tipo_actividad` enum('deportivas','formativas','ambas') DEFAULT NULL,
  `id_usuario_perfil` int NOT NULL,
  `cantidad_dias` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuarioPerfil_idx` (`id_usuario_perfil`),
  CONSTRAINT `idUsuarioPerfil` FOREIGN KEY (`id_usuario_perfil`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
INSERT INTO `perfiles` VALUES (9,'Carlos','García','1inf','formativas',1,NULL),(10,'Ana','Martínez','2pri','formativas',2,NULL),(11,'Luis','López','3eso','deportivas',3,NULL),(12,'aaa','aaaa','1inf','ambas',1,NULL),(13,'ss','sssss','3inf','deportivas',1,NULL),(14,'ss','sssss','3inf','deportivas',1,NULL),(15,'ss','sssss','3inf','deportivas',1,NULL),(16,'ss3','sssss','3inf','deportivas',1,NULL),(17,'eeee','eeeeee','3inf','ambas',1,NULL),(18,'lala','lolo','2pri','deportivas',1,NULL),(19,'lala','lololo','4pri','deportivas',1,NULL),(20,'lala','lololola','4pri','deportivas',1,NULL),(21,'laoakhdlksad','ADdFD','1pri','ambas',1,NULL),(22,'laoakhdlksad','ADdFD','1pri','ambas',1,NULL);
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-09 10:58:03

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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
-- Table structure for table `tarjetas`
--

DROP TABLE IF EXISTS `tarjetas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tarjetas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titular` varchar(45) NOT NULL,
  `numero` varchar(16) NOT NULL,
  `caducidad` varchar(5) NOT NULL,
  `cvc` int NOT NULL,
  `id_usuario` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idUsuario_idx` (`id_usuario`),
  CONSTRAINT `id_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tarjetas`
--

LOCK TABLES `tarjetas` WRITE;
/*!40000 ALTER TABLE `tarjetas` DISABLE KEYS */;
INSERT INTO `tarjetas` VALUES (1,'Juan Pérez','1234567890123456','12/23',123,1),(2,'María Gómez','2345678901234567','05/24',456,2),(3,'Carlos López','3456789012345678','09/25',789,3),(4,'Carlos López','9876543210987654','11/26',456,3),(5,'Laura Sánchez','4567890123456789','03/26',12,4),(6,'Laura Sánchez','7654321098765432','08/28',789,4),(7,'Roberto Martín','5678901234567890','07/27',345,5);
/*!40000 ALTER TABLE `tarjetas` ENABLE KEYS */;
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

-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyecto
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
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(22) NOT NULL,
  `apellidos` varchar(45) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `cp` int NOT NULL,
  `email` varchar(45) NOT NULL,
  `contrasenya` varchar(45) NOT NULL,
  `cuenta_bancaria` varchar(45) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'Juan','Pérez González','Calle Alameda 123, Valencia',46001,'juan.perez@mail.com','clave123','ES1234567890123456789012'),(2,'María','Gómez Rodríguez','Avenida Diagonal 456, Barcelona',8001,'maria.gomez@mail.com','clave456','ES2109876543210987654321'),(3,'Carlos','López Martínez','Calle Raval 789, Castellón',12001,'carlos.lopez@mail.com','clave789','ES3456789012345678901234'),(4,'Laura','Sánchez López','Avenida Gaudí 012, Barcelona',8001,'laura.sanchez@mail.com','clave012','ES4567890123456789012345'),(5,'Roberto','Martín Fernández','Calle Gran Vía 345, Madrid',28001,'roberto.martin@mail.com','clave345','ES5678901234567890123456');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
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
  `tipo_actividad` enum('deportivas','formativas','ambas') DEFAULT NULL,
  `id_empresa_actividad` int NOT NULL,
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

