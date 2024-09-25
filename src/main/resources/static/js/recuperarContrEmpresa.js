document.addEventListener('DOMContentLoaded', function () {
    const btnRecuperarContr = document.getElementById('btnRecuperarContr');

    btnRecuperarContr.addEventListener('click', function () {
        const cifInput = document.getElementById('cif');
        const contrInput = document.getElementById('contr');
        const contr2Input = document.getElementById('contr2');

        const cif = cifInput.value;
        const contr = contrInput.value;
        const contr2 = contr2Input.value;

        // Validar los datos
        let errorCif = '';
        let errorContr = '';
        let errorContr2 = '';

        if (cif === "") {
            errorCif = 'El CIF es obligatorio';
            cifInput.focus();
        } else if (cif.length !== 9) {
            errorCif = 'El CIF debe tener 9 caracteres';
        }

        if (contr === "") {
            errorContr = 'La contraseña es obligatoria';
            contrInput.focus();
        } else if (contr.length < 8) {
            errorContr = 'La contraseña debe tener al menos 8 caracteres';
        }

        if (contr2 === "") {
            errorContr2 = 'La contraseña es obligatoria';
            contr2Input.focus();
        } else if (contr2.length < 8) {
            errorContr2 = 'La contraseña debe tener al menos 8 caracteres';
        }

        if (contr !== contr2) {
            errorContr2 = 'Las dos contraseñas deben coincidir';
            contr2Input.focus();
        }

        document.getElementById('errorCif').innerText = errorCif;
        document.getElementById('errorContr').innerText = errorContr;
        document.getElementById('errorContr2').innerText = errorContr2;

        if (errorCif || errorContr || errorContr2) {
            return;
        }

        // Realizar solicitud para verificar si el CIF existe
        fetch(`http://localhost:8888/SaguntoKids/empresas/verificarCif`, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify({
                cif: cif
            })
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error al verificar el CIF. Estado: ${response.status}`);
                } else {
                    return response.json();
                }
            })
            .then(data => {
                if (data) {
                    // Si el CIF existe, actualizar la contraseña
                    return fetch(`http://localhost:8888/SaguntoKids/empresas/cambiarContrasenya`, {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json'
                        },
                        body: JSON.stringify({
                            cif: cif,
                            contrasenya: contr
                        })
                    });
                } else {
                    throw new Error('El CIF proporcionado no existe');
                }
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error al cambiar la contraseña. Estado: ${response.status}`);
                } else {
                    return response.json();
                }
            })
            .then(result => {
                // Éxito al cambiar la contraseña
                console.log('Contraseña cambiada exitosamente:', result);
                window.location.href = `http://localhost:8888/SaguntoKids/empresas/inicioSesionEmpresa`;
            })
            .catch(error => {
                // Manejar errores
                console.error('Error:', error.message);
                document.getElementById('errorCif').innerText = error.message;
            });

    });
});
