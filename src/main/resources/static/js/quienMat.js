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
        let contenido = document.querySelector("main");

        dataList.forEach(data => {
            let div = crearElemento("div", contenido);
            div.classList.add("selMatricula");
            crearElementoTexto("GRUPO ABIERTO:", "h5", act1);
           
            //Hacer peticion con un foreach
            crearElementoTexto(, "button", div);


            let a3 = crearElemento("a", div);
            a3.setAttribute('th:href', '@{/CreaPerf}');
            crearElementoTexto("Continuar", "button", a3);

            let a = crearElemento("a", div);
            a.setAttribute('th:href', '@{/infAct}');
            crearElementoTexto("Cancelar", "button", a);

            let a2 = crearElemento("a", div);
            a2.setAttribute('th:href', '@{/mat}');
            crearElementoTexto("Continuar", "button", a2);
        });
    } catch (error) {
        console.error('Error al crear la actividad:', error);
    }
}

document.addEventListener('DOMContentLoaded', crearActividades);