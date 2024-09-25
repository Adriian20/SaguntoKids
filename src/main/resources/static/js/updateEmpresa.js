document.addEventListener('DOMContentLoaded', function () {
    // Obtener el CIF del cliente de la URL
    const urlPath = window.location.pathname;
    const idEmpresa = urlPath.split('/').pop(); // Obtener el último segmento de la URL

    const btnEditarEmpresa = document.getElementById('btnEditarEmpresa');
    btnEditarEmpresa.addEventListener('click', function () {
        const idInput = document.getElementById('id');
        const nombreInput = document.getElementById('nombre');
        const cifInput = document.getElementById('cif');
        const direccionInput = document.getElementById('direccion');
        const emailInput = document.getElementById('email');
        const cuentaBancariaInput = document.getElementById('cuenta');
        const telInput = document.getElementById('tel');
        const tipoActividadInput = document.getElementById('actividad');
        const descInput = document.getElementById('desc');

        //
        const id = idInput.value;
        const nombre = nombreInput.value;
        const cif = cifInput.value;
        const direccion = direccionInput.value;
        const email = emailInput.value;
        const cuentaBancaria = cuentaBancariaInput.value;
        const tel = telInput.value;
        const tipoActividad = tipoActividadInput.value;
        const desc = descInput.value;

        // Validar los datos
        let errorNombre = '';
        let errorDireccion = '';
        let errorEmail = '';
        let errorCuentaBancaria = '';
        let errorTel = '';
        let errorDesc = '';

        if (nombre.length == 0) {
            errorNombre = 'El nombre no puede estar vacío';
            nombreInput.focus();
        }

        if (direccion.length == 0) {
            errorDireccion = 'La direccion no puede estar vacía';
            direccionInput.focus();
        }

        if (email.length == 0) {
            errorEmail = 'El email no puede estar vacío';
            emailInput.focus();
        } else if (!/\S+@\S+\.\S+/.test(email)) {
            errorEmail = 'El email no es valido';
        }

        if (cuentaBancaria.length == 0) {
            errorCuentaBancaria = 'La cuenta bancaria no puede estar vacía';
            cuentaBancariaInput.focus();
        } else if (!/^ES\d{22}$/.test(cuentaBancaria)) {
            errorCuentaBancaria = 'La cuenta bancaria no es válida';
        }

        if (tel.length == 0) {
            errorTel = 'El telefono no puede estar vacío';
            telInput.focus();
        } else if (!/^[0-9]+$/.test(tel)) {
            errorTel = 'El telefono solo puede contener números';
        }

        if (desc.length == 0) {
            errorDesc = 'La descripción no puede estar vacía';
            descInput.focus();
        }

        // Mostrar errores en pantalla
        document.querySelector('.errorNombre').innerText = errorNombre;
        document.querySelector('.errorDireccion').innerText = errorDireccion;
        document.querySelector('.errorEmail').innerText = errorEmail;
        document.querySelector('.errorCuentaBancaria').innerText = errorCuentaBancaria;
        document.querySelector('.errorTel').innerText = errorTel;
        document.querySelector('.errorDesc').innerText = errorDesc;

        // Si hay errores, detener el proceso de inicio de sesión
        if (errorNombre || errorDireccion || errorEmail || errorCuentaBancaria || errorTel || errorDesc) {
            return;
        }

        // Realizar una solicitud para obtener los datos actuales de la empresa
        fetch(`http://localhost:8888/SaguntoKids/empresas/ver/${idEmpresa}`)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error al obtener los datos de la empresa. Estado: ${response.status}`);
                }
                return response.json();
            })
            .then(empresa => {
                // Obtener la contraseña de los datos actuales de la empresa
                const contrasenya = empresa.contrasenya;
                const img = empresa.img;

                // Construir el objeto con los datos actualizados, incluida la contraseña
                const datosActualizados = {
                    "idempresa": id,
                    "nombre": nombre,
                    "cif": cif,
                    "telefono": tel,
                    "direccion": direccion,
                    "email": email,
                    "contrasenya": contrasenya,
                    "cuentaBancaria": cuentaBancaria,
                    "tipoActividad": tipoActividad,
                    "img": img,
                    "descripcion": desc,
                };

                console.log(datosActualizados);

                // Realizar la solicitud para actualizar el cliente con el ID proporcionado
                fetch(`http://localhost:8888/SaguntoKids/empresas/actualizar/${idEmpresa}`, {
                    method: 'PUT',
                    headers: {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(datosActualizados)
                })
                    .then(response => {
                        if (!response.ok) {
                            throw new Error(`Error al actualizar el cliente. Estado: ${response.status}`);
                        }
                        return response.json();
                    })
                    .then(empresaActualizada => {
                        console.log('Empresa actualizada:', empresaActualizada);
                    })
                    .catch(error => {
                        console.error(error);
                    });
            })
            .catch(error => {
                console.error(error);
            });
    });
});
