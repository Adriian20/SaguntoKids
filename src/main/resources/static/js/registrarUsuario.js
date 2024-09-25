document.addEventListener('DOMContentLoaded', function () {
    // Registrar Empresa
    const btnRegistrarse = document.getElementById('btnRegistrarse');

    btnRegistrarse.addEventListener('click', function () {

        const nombre = document.getElementById('nombre').value;
        const apellidos = document.getElementById('apellidos').value;
        const direccion = document.getElementById('direccion').value;
        const codigoPostal = document.getElementById('codigoPostal').value;
        const correoElectronico = document.getElementById('correoElectronico').value;
        const contrasenya = document.getElementById('contrasenya').value;
        const cuentaBancaria = document.getElementById('cuentaBancaria').value;
        const verificacion = document.getElementById('verificacion').checked; // Obtener estado de la casilla de verificación
        const term = document.getElementById('term').checked; // Obtener estado de la casilla de verificación

        // Construir el objeto con los datos de la nueva usuario
        const datosActualizados = {
            "nombre": nombre,
            "apellidos": apellidos,
            "direccion": direccion,
            "cp": codigoPostal,
            "email": correoElectronico,
            "contrasenya": contrasenya,
            "cuentaBancaria": cuentaBancaria,
            "verificacion": verificacion,
            "term": term
        };

        console.log(datosActualizados);

        // Llamar al backend para registrar la nueva usuario
        fetch('http://localhost:8888/SaguntoKids/usuarios/registrar', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosActualizados)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error al registrar el usuario. Estado: ${response.status}`);
                }
                return response.json(); // Parsear la respuesta JSON
            })
            .then(data => {
                if (data && data.idusuario) {
                    console.log('Usuario registrado:', data);
                    // Redirigir a la página zona privada de tu usuario
                    window.location.href = `http://localhost:8888/SaguntoKids/usuarios/zonaP/${data.idusuario}`;
                }
            })
            .catch(error => {
                console.error(error);
            });
    });
});
