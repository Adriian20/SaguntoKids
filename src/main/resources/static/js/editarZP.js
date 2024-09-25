document.addEventListener('DOMContentLoaded', function () {
    // Obtener el CIF del usuario de la URL
    const urlPath = window.location.pathname;
    const idUsuario = urlPath.split('/').pop(); // Obtener el último segmento de la URL

    // Obtener el botón de guardar cambios
    const guardarBtn = document.getElementById('guardarBtn');

    // Agregar evento click al botón de guardar cambios
    guardarBtn.addEventListener('click', function () {
        // Obtener los valores de los campos de entrada
        const nombreInput = document.getElementById('nombre');
        const apellidosInput = document.getElementById('apellidos');
        const direccionInput = document.getElementById('direccion');
        const codigoPostalInput = document.getElementById('codigoPostal');
        const correoElectronicoInput = document.getElementById('correoElectronico');
        const passwordInput = document.getElementById('password');
        const password2Input = document.getElementById('password2');
        const cuentaBancariaInput = document.getElementById('cuentaBancaria');

        const nombre = nombreInput.value;
        const apellidos = apellidosInput.value;
        const direccion = direccionInput.value;
        const codigoPostal = codigoPostalInput.value;
        const correoElectronico = correoElectronicoInput.value;
        const password = passwordInput.value;
        const password2 = password2Input.value;
        const cuentaBancaria = cuentaBancariaInput.value;

        const datosActualizados = {
            "idusuario": idUsuario,
            "nombre": nombre,
            "apellidos": apellidos,
            "direccion": direccion,
            "cp": codigoPostal,
            "email": correoElectronico,
            "contrasenya": password,
            "cuentaBancaria": cuentaBancaria
        };

        // Realizar la solicitud para actualizar al usuario con el ID proporcionado
        fetch(`http://localhost:8888/SaguntoKids/usuarios/actualizar/${idUsuario}`, {
            method: 'PUT',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(datosActualizados)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error al actualizar al usuario. Estado: ${response.status}`);
                }
                return response.json();
            })
            .then(usuarioActualizado => {
                console.log('Usuario actualizado:', usuarioActualizado);
                window.location.reload();
            })
            .catch(error => {
                console.error(error);
            });
    });

    // Agregar evento click al elemento "edit" para mostrar u ocultar el botón "guardarBtn"
    document.getElementById('edit').addEventListener('click', function () {
        if (guardarBtn.style.display === 'none') {
            guardarBtn.style.display = 'block';
        } else {
            guardarBtn.style.display = 'none';
        }
    });
});
