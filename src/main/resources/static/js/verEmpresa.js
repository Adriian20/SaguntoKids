document.addEventListener('DOMContentLoaded', function () {
    // Obtener el ID del cliente de la URL
    const urlPath = window.location.pathname;
    const idEmpresa = urlPath.split('/').pop(); // Obtener el último segmento de la URL

    // Realizar una solicitud para obtener los detalles de la empresa con el CIF proporcionado
    fetch(`http://localhost:8888/SaguntoKids/empresas/ver/${idEmpresa}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error al ver la empresa. Estado: ${response.status}`);
            }
            return response.json();
        })
        .then(empresa => {
            // Procesar los datos de la empresa
            console.log('Datos de la empresa:', empresa);
            // Ejemplo: mostrar los datos en el formulario
            document.getElementById('id').value = empresa.idempresa;
            document.getElementById('nombre').value = empresa.nombre;
            document.getElementById('cif').value = empresa.cif;
            document.getElementById('direccion').value = empresa.direccion;
            document.getElementById('email').value = empresa.email;
            document.getElementById('cuenta').value = empresa.cuentaBancaria;
            document.getElementById('actividad').value = empresa.tipoActividad;
            document.getElementById('tel').value = empresa.telefono;
            document.getElementById('desc').value = empresa.descripcion;
            localStorage.setItem("id", idEmpresa);
        })
        .catch(error => {
            console.error(error);
        });
});
