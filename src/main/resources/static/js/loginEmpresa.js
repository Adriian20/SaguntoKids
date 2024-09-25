document.addEventListener('DOMContentLoaded', function () {
    // Iniciar Sesión Empresa
    const btnIniciarSesion = document.getElementById('btnIniciarSesion');

    btnIniciarSesion.addEventListener('click', function () {
        const cifInput = document.getElementById('cif');
        const cif = cifInput.value;
        const contrasenyaInput = document.getElementById('contr');
        const contrasenya = contrasenyaInput.value;

        let errorCif = '';
        let errorContr = '';

        // Validar CIF
        if (cif.length !== 9) {
            errorCif = 'El CIF debe tener 9 caracteres';
            cifInput.focus();
        } else if (!/^[A-Za-z0-9]+$/.test(cif)) {
            errorCif = 'El CIF solo puede contener letras y números';
        }

        // Validar contraseña
        if (contrasenya.length < 8) {
            errorContr = 'La contraseña debe tener al menos 8 caracteres';
            contrasenyaInput.focus();
        }

        // Mostrar errores en pantalla
        document.querySelector('.errorCif').innerText = errorCif;
        document.querySelector('.errorContr').innerText = errorContr;

        // Si hay errores, detener el proceso de inicio de sesión
        if (errorCif || errorContr) {
            return;
        }

        // Enviar la solicitud de inicio de sesión al servidor
        fetch('http://localhost:8888/SaguntoKids/empresas/iniciarSesion', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify({
                cif, contrasenya,
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
                localStorage.setItem('empresaData', JSON.stringify(data));
                window.location.href = `http://localhost:8888/SaguntoKids/empresas/zonaPrivEmpresa/${data.idempresa}`;
            })
            .catch(error => {
                // Error de inicio de sesión, mostrar un mensaje de error
                console.error('Error de inicio de sesión:', error);
                document.querySelector('.error').innerText = 'Los datos introducidos no son correctos';
            });
    });
});
