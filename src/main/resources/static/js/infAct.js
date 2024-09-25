import { crearElemento, crearElementoTexto } from "./functionInterno.js";

// Crear actividad
async function crearActividades() {
    try {
        const urlPath = window.location.pathname;
        const idActividad = urlPath.split('/').pop();
        const response = await fetch(`http://localhost:8888/SaguntoKids/actividades/ver/${idActividad}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Error al obtener la lista de actividades');
        }

        let data = await response.json();

        // Si data no es un array, lo convertimos en un array con un solo elemento
        if (!Array.isArray(data)) {
            data = [data];
        }

        let contenido = document.querySelector("main>div");

        // Ahora data siempre es un array, por lo que podemos usar forEach
        data.forEach(actividad => {
            let act1 = crearElemento("article", contenido);
            act1.classList.add("minActividad");
            crearElementoTexto(actividad.nombre, "h2", act1);
            let img = crearElemento("img", act1);
            fetch(`http://localhost:8888/SaguntoKids/imagen/actividad/${actividad.id}`, {
                method: 'GET',
            })
                .then(url => url.blob())
                .then(imgU => {
                    const imgURL = URL.createObjectURL(imgU)
                    img.src = imgURL;
                });
            let act11 = crearElemento("div", act1);
            act11.classList.add("centrar");
            crearElementoTexto("GRUPO ABIERTO:", "h5", act11);

            //Transformar de array1 a array2
            var c = ["I1", "I2", "I3", "P1", "P2", "P3", "P4", "P5", "P6", "E1", "E2", "E3", "E4", "B1", "B2"];
            var clases = ["Primero de infantil", "Segundo de infantil", "Tercero de infantil", "Primero de primaria", "Segundo de primaria", "Tercero de primaria", "Cuarto de primaria", "Quinto de primaria", "Sexto de primaria", "Primero de la ESO", "Segundo de la ESO", "Tercero de la ESO", "Cuarto de la ESO", "Primero de bachiller", "Segundo de bachiller"];
            for (var i = 0; i < c.length; i++) {
                if (c[i] == actividad.curso) {
                    crearElementoTexto(clases[i], "h5", act11);
                }
            }
            //Transformar de array1 a array2
            var d = ["L", "M", "X", "J", "V", "S", "D"];
            var dias = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"];
            let letra = "";
            let diasS = "";
            for (var j = 0; j < actividad.dias_semana.length; j += 2) {
                letra = actividad.dias_semana.charAt(j);
                for (var i = 0; i < d.length; i++) {
                    if (d[i] == letra) {
                        if (diasS !== "") {
                            diasS += ", ";
                        }
                        diasS += dias[i];
                    }
                }
            }
            if (diasS.indexOf(",") !== -1) {
                const ultComa = diasS.lastIndexOf(", ");
                diasS = diasS.substring(0, ultComa) + " y" + diasS.substring(ultComa + 1);
            }
            crearElementoTexto(diasS, "h5", act11);
            let act2 = crearElemento("article", contenido);
            crearElementoTexto(actividad.descripcion, "p", act2); // Usar actividad.infoExtra obtenido de la respuesta
            crearElementoTexto(actividad.precio, "p", act2);
        });
    } catch (error) {
        console.error('Error al crear la actividad:', error);
    }
}

document.addEventListener('DOMContentLoaded', crearActividades);
