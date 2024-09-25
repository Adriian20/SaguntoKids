document.addEventListener('DOMContentLoaded', function () {
    // Registrar Empresa
    const btnRegistrarse = document.getElementById('btnRegistrarse');

    const imgInput = document.getElementById('img');
    const previewImage = document.getElementById('previewImage');

    imgInput.addEventListener('change', function () {
        const file = imgInput.files[0];

        if (file && file.type.match('image.*')) {
            const reader = new FileReader();

            reader.onload = function (e) {
                previewImage.src = e.target.result;
            };

            reader.readAsDataURL(file);
        } else {
            previewImage.src = ""; // Vaciar la vista previa si no se selecciona una imagen válida
            alert('Selecciona un archivo de imagen válido.');
        }
    });

    btnRegistrarse.addEventListener('click', function () {

        const nombreInput = document.getElementById('nombre');
        const cifInput = document.getElementById('cif');
        const tlfnInput = document.getElementById('tlfn');
        const direccionInput = document.getElementById('direccion');
        const emailInput = document.getElementById('email');
        const contrInput = document.getElementById('contr');
        const contrInput2 = document.getElementById('contr');
        const cuentaBancariaInput = document.getElementById('cuentaBancaria');
        const tipoActividadInput = document.getElementById('categorias');
        const descInput = document.getElementById('desc');
        const imgInput = document.getElementById('img');
        const terminosInput = document.getElementById('terminosCond');

        const nombre = nombreInput.value;
        const cif = cifInput.value;
        const tlfn = tlfnInput.value;
        const direccion = direccionInput.value;
        const email = emailInput.value;
        const contr = contrInput.value;
        const contr2 = contrInput2.value;
        const cuentaBancaria = cuentaBancariaInput.value;
        const tipoActividad = tipoActividadInput.value;
        const desc = descInput.value;
        const img = imgInput.value;
        const terminos = terminosInput;

        // Validar los datos
        let errorNombre = '';
        let errorCif = '';
        let errorTlfn = '';
        let errorDireccion = '';
        let errorEmail = '';
        let errorContr = '';
        let errorContr2 = '';
        let errorCuentaBancaria = '';
        let errorTipoActividad = '';
        let errorDesc = '';
        let errorImg = '';
        let errorTerminos = '';

        if (nombre === '') {
            errorNombre = 'El nombre es obligatorio';
            nombreInput.focus();
        }

        if (cif === '') {
            errorCif = 'El CIF es obligatorio';
            cifInput.focus();
        } else if (cif.length !== 9) {
            errorCif = 'El CIF debe tener 9 caracteres';
            cifInput.focus();
        }

        if (tlfn === '') {
            errorTlfn = 'El telefono es obligatorio';
            tlfnInput.focus();
        } else if (tlfn.length !== 9) {
            errorTlfn = 'El telefono debe tener 9 caracteres';
            tlfnInput.focus();
        }

        if (direccion === '') {
            errorDireccion = 'La direccion es obligatoria';
            direccionInput.focus();
        }

        if (email === '') {
            errorEmail = 'El email es obligatorio';
            emailInput.focus();
        } else if (!/\S+@\S+\.\S+/.test(email)) {
            errorEmail = 'El email no es valido';
            emailInput.focus();
        }

        if (contr === '') {
            errorContr = 'La contrasenya es obligatoria';
            contrInput.focus();
        } else if (contr.length < 8) {
            errorContr = 'La contrasenya debe tener al menos 8 caracteres';
            contrInput.focus();
        }

        if (contr2 === '') {
            errorContr2 = 'La contrasenya es obligatoria';
            contrInput2.focus();
        } else if (contr !== contr2) {
            errorContr2 = 'Las contrasenyas no coinciden';
            contrInput2.focus();
        }

        if (cuentaBancaria === '') {
            errorCuentaBancaria = 'La cuenta bancaria es obligatoria';
            cuentaBancariaInput.focus();
        } else if (!/^ES\d{22}$/.test(cuentaBancaria)) {
            errorCuentaBancaria = 'La cuenta bancaria no es válida';
            cuentaBancariaInput.focus();
        }

        if (tipoActividad === '') {
            errorTipoActividad = 'El tipo de actividad es obligatorio';
            tipoActividadInput.focus();
        }

        if (desc === '') {
            errorDesc = 'La descripccion es obligatoria';
            descInput.focus();
        }

        if (img === '') {
            errorImg = 'La imagen es obligatoria';
            imgInput.focus();
        }

        if (!terminos.checked) {
            errorTerminos = 'Debes aceptar los terminos y condiciones';
            terminosInput.focus();
        }

        // Si hay errores, mostrarlos
        document.querySelector('.errorNombre').innerText = errorNombre;
        document.querySelector('.errorCif').innerText = errorCif;
        document.querySelector('.errorTelefono').innerText = errorTlfn;
        document.querySelector('.errorDireccion').innerText = errorDireccion;
        document.querySelector('.errorEmail').innerText = errorEmail;
        document.querySelector('.errorContr').innerText = errorContr;
        document.querySelector('.errorContr2').innerText = errorContr2;
        document.querySelector('.errorCuentaBancaria').innerText = errorCuentaBancaria;
        document.querySelector('.errorActividad').innerText = errorTipoActividad;
        document.querySelector('.errorDesc').innerText = errorDesc;
        document.querySelector('.errorImg').innerText = errorImg;
        document.querySelector('.errorTerminos').innerText = errorTerminos;

        if (errorNombre || errorCif || errorTlfn || errorDireccion || errorEmail || errorContr || errorContr2 || errorCuentaBancaria || errorTipoActividad || errorDesc || errorImg || errorTerminos) {
            return;
        }

        // Construir el objeto con los datos de la nueva empresa
        const nuevaEmpresa = {
            "nombre": nombre,
            "cif": cif,
            "telefono": tlfn,
            "direccion": direccion,
            "email": email,
            "contrasenya": contr,
            "cuentaBancaria": cuentaBancaria,
            "tipoActividad": tipoActividad,
            "img": img,
            "descripcion": desc,
            "terminos": terminos.checked
        };

        console.log(nuevaEmpresa);

        // Llamar al backend para registrar la nueva empresa
        fetch('http://localhost:8888/SaguntoKids/empresas/registrar', {
            method: 'POST',
            headers: {
                'Accept': 'application/json',
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(nuevaEmpresa)
        })
            .then(response => {
                if (!response.ok) {
                    throw new Error(`Error al registrar la empresa. Estado: ${response.status}`);
                }
                return response.json(); // Parsear la respuesta JSON
            })
            .then(data => {
                fetch(`http://localhost:8888/SaguntoKids/imagen/empresa/${data.idempresa}`, {
                    method: 'GET',
                })
                    .then(url => url.blob())
                    .then(imgU => {
                        const imgURL = URL.createObjectURL(imgU)
                        img.src = imgURL;
                    })
                if (data && data.idempresa) {
                    console.log('Empresa registrada:', data);
                    // Redirigir a la página zona privada de tu empresa
                    window.location.href = `http://localhost:8888/SaguntoKids/empresas/zonaPrivEmpresa/${data.idempresa}`;
                }
            })
            .catch(error => {
                console.error(error);
            });
    });
});