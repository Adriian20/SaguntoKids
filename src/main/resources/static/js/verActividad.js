document.addEventListener('DOMContentLoaded', function () {
    // Obtener el ID del cliente de la URL
    const urlPath = window.location.pathname;
    const idActividad = urlPath.split('/').pop(); // Obtener el último segmento de la URL

    // Realizar una solicitud para obtener los detalles de la actividad con el CIF proporcionado
    fetch(`http://localhost:8888/SaguntoKids/actividades/ver/${idActividad}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error al ver la actividad. Estado: ${response.status}`);
            }
            return response.json();
        })
        .then(actividad => {
            // Procesar los datos de la actividad
            console.log('Datos de la actividad:', actividad);
            // Ejemplo: mostrar los datos en el formulario
            document.getElementById('nombre').value = actividad.nombre;
            document.getElementById('dias').value = actividad.dias_semana;
            document.getElementById('diasCant').value = actividad.numero_dias;
            document.getElementById('horario').value = actividad.horario_dias;
            document.getElementById('img').value = actividad.img;
            document.getElementById('curso').value = actividad.curso;
            document.getElementById('desc').value = actividad.descripcion;
            document.getElementById('precio').value = actividad.precio;
            document.getElementById('matricula').value = actividad.matricula;
            document.getElementById('categorias').value = actividad.tipo_actividad;
        })
        .catch(error => {
            console.error(error);
        });
});
