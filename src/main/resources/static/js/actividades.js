import { crearElemento, crearElementoTexto } from "./functionInterno.js";

// Crear actividad
async function crearActividades(var1) {
    try {
        var url = 'http://localhost:8888/SaguntoKids/actividades/listar';
        switch (var1) {
            case 1:
                url = 'http://localhost:8888/SaguntoKids/actividades/listarAsc'
                break;
            case 2:
                url = 'http://localhost:8888/SaguntoKids/actividades/listarDesc'
                break
            case 3:
                url = 'http://localhost:8888/SaguntoKids/actividades/listarAlf'
                break    
        }
        const response = await fetch(url, {
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
            let act = crearElemento("article", contenido);
            act.classList.add("actividad");
            let actDiv = crearElemento("div", act);
            let img = crearElemento("img", actDiv);
            fetch(`http://localhost:8888/SaguntoKids/imagen/recuImgAct/${data.id}`, {
                method: 'GET',
            })

                .then(url => url.blob())
                .then(imgU => {
                    const imgURL = URL.createObjectURL(imgU)
                    img.src = imgURL;
                })
            crearElementoTexto(data.nombre, "h3", actDiv); // Usar data.titulo obtenido de la respuesta
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
            a.setAttribute('th:href', '@{/infAct}');
            crearElementoTexto("MÁS INFORMACION", "button", a);
            a.addEventListener("click", function () {
                var actividadUrl = `http://localhost:8888/SaguntoKids/actividades/verActividad/${data.id}`;
                window.location.href = actividadUrl;
            })
        });
    } catch (error) {
        console.error('Error al crear la actividad:', error);
    }
}

document.addEventListener('DOMContentLoaded', crearActividades);