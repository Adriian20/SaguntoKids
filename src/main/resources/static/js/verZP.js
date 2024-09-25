document.addEventListener('DOMContentLoaded', function () {
    // Obtener el ID del cliente de la URL
    const urlPath = window.location.pathname;
    const idUsuario = urlPath.split('/').pop(); // Obtener el último segmento de la URL

    // Realizar una solicitud para obtener los detalles de la usuario con el CIF proporcionado
    fetch(`http://localhost:8888/SaguntoKids/usuarios/ver/${idUsuario}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
    })
        .then(response => {
            if (!response.ok) {
                throw new Error(`Error al ver el usuario. Estado: ${response.status}`);
            }
            return response.json();
        })
        .then(usuario => {
            // Procesar los datos de la usuario
            console.log('Datos del usuario:', usuario);
            // Ejemplo: mostrar los datos en el formulario
            document.getElementById('nombre').value = usuario.nombre;
            document.getElementById('apellidos').value = usuario.apellidos;
            document.getElementById('direccion').value = usuario.direccion;
            document.getElementById('codigoPostal').value = usuario.cp;
            document.getElementById('correoElectronico').value = usuario.email;
            document.getElementById('password').value = usuario.contrasenya;
            document.getElementById('password2').value = usuario.contrasenya;
            document.getElementById('cuentaBancaria').value = usuario.cuentaBancaria;
            localStorage.setItem("id", idUsuario);
        })
        .catch(error => {
            console.error(error);
        });
});
