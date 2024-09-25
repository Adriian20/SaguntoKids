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

        const dataList = await response.json();
        let contenido = document.querySelector("main>div");

        dataList.forEach(data => {
            crearElementoTexto(, "button", contenido);
            let act1 = crearElemento("div", contenido);
            act1.classList.add("centrar");
            crearElementoTexto("GRUPO ABIERTO:", "h5", act1);
            //Transformar de array1 a array2
            var c = ["I1", "I2", "I3", "P1", "P2", "P3", "P4", "P5", "P6", "E1", "E2", "E3", "E4", "B1", "B2"];
            var clases = ["Primero de infantil", "Segundo de infantil", "Tercero de infantil", "Primero de primaria", "Segundo de primaria", "Tercero de primaria", "Cuarto de primaria", "Quinto de primaria", "Sexto de primaria", "Primero de la ESO", "Segundo de la ESO", "Tercero de la ESO", "Cuarto de la ESO", "Primero de bachiller", "Segundo de bachiller"];
            for (var i = 0; i < c.length; i++) {
                if (c[i] == data.curso) {
                    crearElementoTexto(clases[i], "h5", act1);
                }
            }
            //Transformar de array1 a array2
            var d = ["L", "M", "X", "J", "V", "S", "D"];
            var dias = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo"];
            let letra = "";
            let diasS = "";
            for (var j = 0; j < data.dias_semana.length; j += 2) {
                letra = data.dias_semana.charAt(j);
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
            crearElementoTexto(diasS, "h5", act1);
            let act2 = crearElemento("div", contenido);
            crearElementoTexto("A pagar ahora:", "p", act2); // Usar data.infoExtra obtenido de la respuesta
            crearElementoTexto(data.precio, "button", act2);
            let a = crearElemento("a", contenido);
            a.setAttribute('th:href', '@{/quiMat}');
            crearElementoTexto("Cancelar", "button", a);
            let a2 = crearElemento("a", contenido);
            a2.setAttribute('th:href', '@{/matPag}');
            crearElementoTexto("Continuar", "button", a2);
        });
    } catch (error) {
        console.error('Error al crear la actividad:', error);
    }
}

document.addEventListener('DOMContentLoaded', crearActividades);