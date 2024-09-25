--USUARIOS-----
INSERT INTO usuario (nombre, apellidos, direccion, cp, email, contrasenya, cuenta_bancaria)
VALUES 
    ('Juan', 'Pérez González', 'Calle Alameda 123, Valencia', 46001, 'juan.perez@mail.com', 'clave123', 'ES1234567890123456789012'),
    ('María', 'Gómez Rodríguez', 'Avenida Diagonal 456, Barcelona', 08001, 'maria.gomez@mail.com', 'clave456', 'ES2109876543210987654321'),
    ('Carlos', 'López Martínez', 'Calle Raval 789, Castellón', 12001, 'carlos.lopez@mail.com', 'clave789', 'ES3456789012345678901234'),
    ('Laura', 'Sánchez López', 'Avenida Gaudí 012, Barcelona', 08001, 'laura.sanchez@mail.com', 'clave012', 'ES4567890123456789012345'),
    ('Roberto', 'Martín Fernández', 'Calle Gran Vía 345, Madrid', 28001, 'roberto.martin@mail.com', 'clave345', 'ES5678901234567890123456');

INSERT INTO empresa (nombre, cif, direccion, telefono, email, tipo_actividad, contrasenya, img, cuenta_bancaria, descripcion)
VALUES 
    ('Academia Especializada en Matemáticas MathGenius', '12345678A', 'Calle San Vicente 1, Valencia', 46002, 'info@mathgenius.com', 1, 'clave123', 'logo_mathgenius.png', 'ES11223344556677889900AA', 'Academia educativa especializada en la enseñanza de las matemáticas. Nuestros profesores altamente calificados y métodos innovadores ayudan a los estudiantes a mejorar sus habilidades matemáticas y alcanzar el éxito académico.'),
    ('Instituto de Idiomas Polyglot', '87654321B', 'Avenida Paseo de Gracia 2, Barcelona', 08002, 'info@polyglot.com', 1, 'clave456', 'logo_polyglot.png', 'ES99887766554433221100BB', 'Instituto especializado en la enseñanza de idiomas, con un enfoque principal en inglés y alemán. Nuestro objetivo es proporcionar a los estudiantes las habilidades lingüísticas necesarias para tener éxito en un mundo globalizado.'),
    ('Gimnasio Fitness Zone', '56781234C', 'Calle San Félix 3, Castellón', 12002, 'info@fitnesszone.com', 2, 'clave789', 'logo_fitnesszone.png', 'ES44556677889900112233CC', 'Gimnasio moderno con instalaciones de última generación que ofrece una amplia variedad de deportes, incluyendo fitness, yoga, pilates, natación, tenis y más. Nuestros entrenadores altamente capacitados brindan un enfoque personalizado para lograr los objetivos de cada cliente.'),
    ('Colegio de Verano AquaAdventure', '43218765D', 'Avenida Blasco Ibáñez 4, Valencia', 46010, 'info@aquaadventure.com', 2, 'clave012', 'logo_aquaadventure.png', 'ES66778899001122334455DD', 'Colegio de verano especializado en actividades deportivas acuáticas y recreativas. Ofrecemos una experiencia única donde los estudiantes pueden participar en deportes acuáticos, juegos al aire libre, excursiones y más. Fomentamos el aprendizaje, la diversión y la amistad.');

INSERT INTO tarjetas (titular, numero, caducidad, cvc, id_usuario)
VALUES 
    ('Juan Pérez', '1234-5678-9012-3456', '12/23', 123, 1),
    ('María Gómez', '2345-6789-0123-4567', '05/24', 456, 2),
    ('Carlos López', '3456-7890-1234-5678', '09/25', 789, 3),
    ('Carlos López', '9876-5432-1098-7654', '11/26', 456, 3),
    ('Laura Sánchez', '4567-8901-2345-6789', '03/26', 012, 4),
    ('Laura Sánchez', '7654-3210-9876-5432', '08/28', 789, 4),
    ('Roberto Martín', '5678-9012-3456-7890', '07/27', 345, 5);

INSERT INTO perfiles (nombre, apellidos, curso, tipo_actividad, disponibilidad_horaria, id_usuario_perfil)
VALUES 
    ('Ana', 'Martínez', 'I1', 'Formativa', 'L=15:00-18:30,M=15:00-20:00,X=15:00-18:30,J=16:00-19:00,V=16:00-20:00', 1),
    ('Carlos', 'González', 'P3', 'Deportiva', 'M=15:00-20:00,X=15:00-18:30,J=16:00-19:00,S=09:00-11:00', 2),
    ('Laura', 'Rodríguez', 'P3', 'Formativa', 'X=15:00-18:30,J=16:00-19:00,V=16:00-20:00,S=09:00-13:00', 3),
    ('Javier', 'Fernández', 'P5', 'Deportiva', 'J=16:00-19:00,V=16:00-20:00,S=09:00-13:00', 4),
    ('Isabel', 'López', 'E2', 'Formativa', 'V=16:00-20:00,S=09:00-11:00', 5),
    ('Miguel', 'Gómez', 'E2', 'Deportiva', 'L=15:00-18:30,M=15:00-20:00,X=15:00-18:30,J=16:00-19:00,V=16:00-20:00,S=09:00-13:00', 1),
    ('Sofía', 'Díaz', 'E4', 'Formativa', 'M=15:00-20:00,X=15:00-18:30,J=16:00-19:00,V=16:00-20:00,S=09:00-11:00', 2),
    ('Alejandro', 'Hernández', 'B1', 'Deportiva', 'X=15:00-18:30,J=16:00-19:00,V=16:00-20:00,S=09:00-13:00', 3);

INSERT INTO actividad (nombre, dias_semana, numero_dias, horario_dias, curso, img, descripcion, precio, matricula, id_profesor, id_empresa_actividad)
VALUES 
    ('Clases de Matemáticas', 'L', '1', '15:00-16:00', 'I1', 'img_matematicas.jpg', 'Sumérgete en un mundo de diversión matemática para niños. Descubre números y formas de manera emocionante con juegos interactivos y actividades creativas. ¡Aprende mientras juegas y despierta tu amor por las matemáticas desde pequeño!', 50.0, 20.0, 1, 1),
    ('Entrenamiento Fitness', 'M', '1', '15:00-16:30', 'P3', 'img_fitness.jpg', 'Embárcate en una emocionante aventura de entrenamiento fitness diseñada especialmente para niños. Diviértete mientras desarrollas habilidades motoras, fuerza y resistencia. ¡Ejercítate con juegos y actividades que harán que el fitness sea una experiencia emocionante y saludable para los más pequeños', 30.0, 15.0, 1, 3),
    ('Clases de Inglés', 'X', '1', '15:00-16:00', 'P3', 'img_ingles.jpg', 'Descubre el mundo del inglés de manera divertida y educativa en nuestras clases diseñadas para niños. Aprende el idioma con juegos interactivos, canciones y actividades creativas. ¡Fomenta la confianza lingüística desde temprana edad y disfruta del viaje hacia el dominio del inglés de manera lúdica y participativa!', 40.0, 25.0, 1, 2),
    ('Entrenamiento Deportivo', 'M,J', '2', '16:00-17:30', 'P5', 'img_deportes.jpg', 'Únete a nuestro entrenamiento deportivo para niños de quinto de primaria. Desarrolla habilidades atléticas, trabajo en equipo y una vida activa a través de juegos divertidos y desafíos emocionantes. ¡Prepárate para fortalecer tu cuerpo y mente mientras disfrutas de la pasión por el deporte en un ambiente motivador y educativo!', 35.0, 18.0, 1, 4),
    ('Yoga Relajante', 'X,V', '2', '16:00-17:30', 'E2', 'img_yoga.jpg', 'Explora la serenidad del yoga en nuestras clases relajantes diseñadas para estudiantes de segundo de la ESO. Encuentra equilibrio entre mente y cuerpo a través de posturas suaves, técnicas de respiración y meditación. ¡Cultiva la calma interior y mejora tu bienestar físico y emocional mientras disfrutas de una experiencia rejuvenecedora de yoga relajante!', 25.0, 10.0, 1, 3),
    ('Clases de Ciencias', 'M,S', '2', '09:00-10:30', 'E2', 'img_ciencias.jpg', 'Embárcate en emocionantes clases de ciencias diseñadas para estudiantes de segundo de la ESO. Descubre los misterios del mundo natural a través de experimentos prácticos, investigaciones y debates estimulantes. ¡Explora la fascinante interconexión de la biología, química y física mientras desarrollas habilidades científicas críticas para comprender y apreciar el asombroso universo que nos rodea!', 45.0, 30.0, 1, 1),
    ('Natación', 'L,X,V', '3', '15:00-16:30', 'E4', 'img_natacion.jpg', 'Sumérgete en nuestras clases de natación diseñadas para adolescentes. Aprende y perfecciona las habilidades acuáticas, mejora la resistencia y fortalece tu confianza en el agua. Con un enfoque divertido y seguro, descubre los beneficios del ejercicio acuático mientras te diviertes y adquieres habilidades esenciales para toda la vida. ¡Haz de la natación una experiencia saludable y emocionante', 55.0, 40.0, 1, 4),
    ('Clases de Alemán', 'M,J,S', '3', '15:00-16:30', 'B1', 'img_aleman.jpg', 'Explora el fascinante idioma alemán en nuestras clases interactivas. Aprende de manera dinámica con énfasis en la conversación, gramática y cultura. Sumérgete en un viaje educativo que te permitirá desarrollar habilidades lingüísticas sólidas y disfrutar del aprendizaje del alemán de manera divertida y efectiva.', 40.0, 25.0, 1, 2);

INSERT INTO matricula (id_perfil_matriculado, id_actividades_matriculadas)
VALUES 
    (1, 1),
    (3, 2);