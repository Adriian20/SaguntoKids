document.addEventListener('DOMContentLoaded', function () {
    // Iniciar Sesión Usuario
    const btnIniciarSesion = document.getElementById('btnIniciarSesion');

    btnIniciarSesion.addEventListener('click', function () {
        const correo = document.getElementById('correo');
        const contrasenya = document.getElementById('password');

        // Enviar la solicitud de inicio de sesión al servidor
        fetch('http://localhost:8888/SaguntoKids/usuarios/iniciarSesion', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                email: correo.value,
                contrasenya: contrasenya.value,
            }),
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    throw new Error('Error al iniciar sesión');
                }
            })
            .then(data => {
                // Inicio de sesión exitoso, procesar la información de la empresa
                console.log('Inicio de sesión exitoso:', data);
                localStorage.setItem('usuarioData', JSON.stringify(data));
                window.location.href = `http://localhost:8888/SaguntoKids/usuarios/zonaP/${data.idusuario}`;
            })
            .catch(error => {
                // Error de inicio de sesión, mostrar un mensaje de error
                console.error('Error de inicio de sesión:', error);
                document.querySelector('.error').innerText = 'Los datos introducidos no son correctos';
            });
    });
});
