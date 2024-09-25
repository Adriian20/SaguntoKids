const URL = "http://localhost:8888/SaguntoKids/rest/PerfilesController";

document.addEventListener('DOMContentLoaded', function () {
    /* cargarPerfiles(); */
    document.getElementById("botonActualizar").style.display = "none";
    document.getElementById('form-crearP').addEventListener('submit', function (event) {

        event.preventDefault();
        const nombre = document.getElementById('nom').value;
        const apellidos = document.getElementById('ape').value;
        const curso = document.getElementById('curso').value;
        const tipoActividad = document.getElementById('t-act').value;
        const cantidadDias = document.getElementById('cantD').value;

        const nuevoPerfil = {
            "nombre": nombre,
            "apellidos": apellidos,
            "curso": curso,
            "tipoActividad": tipoActividad,
            "idActividad": 9,
            "idUsuarioPerfil": 4,
            "cantidadDias": cantidadDias

        };

        console.log(nuevoPerfil);
        fetch(URL + '/registrarPerfil', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevoPerfil)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error al registrar el perfil. Estado: ${response.status}`);
                }

                return response.json();

            })
            .then(perfilRegistrado => {
                console.log('Perfil registrado:', perfilRegistrado);
                const perfilId = perfilRegistrado.id; // Suponiendo que el ID del perfil se llama 'id'
                console.log('ID del perfil registrado:', perfilId);
                console.log(perfilId);
                const horarios = obtenerHorarios(perfilId);
                horarios.forEach(horario => {
                    // Llama a registrarHorario con los argumentos necesarios
                    registrarHorario(perfilId, horario, horario.idDiaSemana);
                    alert("Perfil registrado correctamente");
                    window.location.href = "http://localhost:8888/SaguntoKids/zonaP";
                });
            })



    .catch(error => {
                console.error(error);
            });
    });
});

function registrarHorario(perfilId, nuevoHorarioPerfil) {
    console.log('nuevoHorarioPerfil:', nuevoHorarioPerfil);
    const horarioGuardar = {
        "horaInicio": nuevoHorarioPerfil.horaInicio,
        "horaFin": nuevoHorarioPerfil.horaFin,
        "idDiaSemana": nuevoHorarioPerfil.idDiaSemana,
        "idPerfil": perfilId

    };


    fetch(`http://localhost:8888/SaguntoKids/rest/HorarioController/registrar1`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(horarioGuardar)

    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error al registrar el horario. Estado: ${response.status}`);
            }
            return response.json();
        })
        .then(horarioRegistrado => {
            //  console.log(`Horario del ${idDiaSemana} registrado:`, perfilRegistrado);
        })
        .catch(error => {
            console.error(error);
        });

}

function obtenerHorarios(perfilId) {
    const diasSemana = ["Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado"];
    const nuevoHorarioPerfil = [];

    diasSemana.forEach(dia => {
        const horaInicio = document.querySelector(`select[name='${dia}']#${dia}_inicio`).value;
        const horaFin = document.querySelector(`select[name='${dia}']#${dia}_fin`).value;
        const idDiaSemana = diasSemana.indexOf(dia) + 1;
        console.log('horaInicio   ', horaInicio);
        console.log('horaInicio   ', horaFin);

        if (horaInicio !== '' || horaFin !== '') {

            nuevoHorarioPerfil.push({
                horaInicio: horaInicio,
                horaFin: horaFin,
                idPerfil: perfilId,
                idDiaSemana: idDiaSemana
            });
        } else {
            const idDiaSemana = diasSemana.indexOf(dia) + 1;
        }
        console.log('diasSemana   ', idDiaSemana);


    });

    return nuevoHorarioPerfil;

}

