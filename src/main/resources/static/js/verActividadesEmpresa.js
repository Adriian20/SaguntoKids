import { crearElemento, crearElementoTexto } from "./functionInterno.js";

// Crear actividad
async function crearActividades() {
    try {
        const idempresa = localStorage.getItem("id");
        const response = await fetch(`http://localhost:8888/SaguntoKids/actividades/empresa/${idempresa}`, {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json'
            }
        });

        if (!response.ok) {
            throw new Error('Error al obtener la lista de actividades');
        }

        const dataList = await response.json();
        let contenido = document.querySelector("main > article");

        dataList.forEach(data => {
            console.log(data)
            let act = crearElemento("article", contenido);
            act.classList.add("actividadEmpresa");
            let img = crearElemento("img", act);
            fetch(`http://localhost:8888/SaguntoKids/imagen/recuImgAct/${data.id}`, {
                method: 'GET',
            })

                .then(url => url.blob())
                .then(imgU => {
                    const imgURL = URL.createObjectURL(imgU)
                    img.src = imgURL;
                })
            crearElementoTexto(data.nombre, "h3", act); // Usar data.titulo obtenido de la respuesta
            let actDiv = crearElemento("div", act);
            crearElementoTexto("GRUPO ABIERTO:", "h5", actDiv);
            //Transformar de array1 a array2
            var c = ["I1", "I2", "I3", "P1", "P2", "P3", "P4", "P5", "P6", "E1", "E2", "E3", "E4", "B1", "B2"];
            var clases = ["Primero de infantil", "Segundo de infantil", "Tercero de infantil", "Primero de primaria", "Segundo de primaria", "Tercero de primaria", "Cuarto de primaria", "Quinto de primaria", "Sexto de primaria", "Primero de la ESO", "Segundo de la ESO", "Tercero de la ESO", "Cuarto de la ESO", "Primero de bachiller", "Segundo de bachiller"];
            for (var i = 0; i < c.length; i++) {
                if (c[i] == data.curso) {
                    crearElementoTexto(clases[i], "h5", actDiv);
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
            crearElementoTexto(diasS, "h5", actDiv);
            crearElementoTexto(data.descripcion, "p", act); // Usar data.infoExtra obtenido de la respuesta
            let a = crearElemento("a", act);
            crearElementoTexto("Editar", "button", a);
            a.addEventListener("click", function () {
                var actividadUrl = `http://localhost:8888/SaguntoKids/actividades/editarActividad/${data.id}`;
                window.location.href = actividadUrl;
            })
        });
    } catch (error) {
        console.error('Error al crear la actividad:', error);
    }
}

document.addEventListener('DOMContentLoaded', crearActividades);