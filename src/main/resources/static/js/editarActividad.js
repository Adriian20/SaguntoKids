document.addEventListener('DOMContentLoaded', function () {
    // Crear Cursos
    const btnEditarActividad = document.getElementById('btnEditarActividad');
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

    // Obtener el ID del cliente de la URL
    const urlPath = window.location.pathname;
    const idActividad = urlPath.split('/').pop(); // Obtener el último segmento de la URL

    if (!isNaN(idActividad)) {
        document.getElementById('btnCrearActividad').style.display = "none";

        // Actualizar Actividad
        btnEditarActividad.addEventListener('click', function () {
            const nombreInput = document.getElementById('nombre');
            const diasInput = document.getElementById('dias');
            const diasCantInput = document.getElementById('diasCant');
            const horarioInput = document.getElementById('horario');
            const imgInput = document.getElementById('img');
            const cursoInput = document.getElementById('curso');
            const descInput = document.getElementById('desc');
            const precioInput = document.getElementById('precio');
            const matriculaInput = document.getElementById('matricula');
            const tipoActividadInput = document.getElementById('categorias');

            const nombre = nombreInput.value;
            const dias = diasInput.value;
            const diasCant = diasCantInput.value;
            const horario = horarioInput.value;
            const curso = cursoInput.value;
            const img = imgInput.value;
            const desc = descInput.value;
            const precio = precioInput.value;
            const matricula = matriculaInput.value;
            const tipoActividad = tipoActividadInput.value;

            // Validar los datos
            let errorNombre = '';
            let errorDias = '';
            let errorDiasCant = '';
            let errorHorario = '';
            let errorCurso = '';
            let errorImg = '';
            let errorDesc = '';
            let errorPrecio = '';
            let errorMatricula = '';
            let errorActividad = '';

            if (nombre === "") {
                errorNombre = 'El nombre es obligatorio';
                nombreInput.focus();
            }

            if (dias === "") {
                errorDias = 'Los dias son obligatorios';
                diasInput.focus();
            }

            if (diasCant === "") {
                errorDiasCant = 'La cantidad de dias es obligatoria';
                diasCantInput.focus();
            } else if (isNaN(diasCant)) {
                errorDiasCant = 'La cantidad de dias debe ser un numero';
            }

            if (horario === "") {
                errorHorario = 'El horario es obligatorio';
                horarioInput.focus();
            }

            if (curso === "") {
                errorCurso = 'El curso es obligatorio';
                cursoInput.focus();
            } else if (curso.lenght < 2) {
                errorCurso = 'El nombre del curso debe tener al menos 2 caracteres';
                cursoInput.focus();
            }

            if (img === "") {
                errorImg = 'La imagen es obligatoria';
                imgInput.focus();
            }

            if (desc === "") {
                errorDesc = 'La descripccion es obligatoria';
                descInput.focus();
            }

            if (precio === "") {
                errorPrecio = 'El precio es obligatorio';
                precioInput.focus();
            } else if (isNaN(precio)) {
                errorPrecio = 'El precio debe ser un numero';
                precioInput.focus();
            }

            if (matricula === "") {
                errorMatricula = 'La matricula es obligatoria';
                matriculaInput.focus();
            } else if (isNaN(matricula)) {
                errorMatricula = 'La matricula debe ser un numero';
                matriculaInput.focus();
            }

            if (tipoActividad === "") {
                errorActividad = "La actividad es obligatoria";
                tipoActividadInput.focus();
            }

            // Mostrar errores en pantalla
            document.querySelector('.errorNombre').innerText = errorNombre;
            document.querySelector('.errorDias').innerText = errorDias;
            document.querySelector('.errorDiasCant').innerText = errorDiasCant;
            document.querySelector('.errorHorario').innerText = errorHorario;
            document.querySelector('.errorCurso').innerText = errorCurso;
            document.querySelector('.errorImg').innerText = errorImg;
            document.querySelector('.errorDesc').innerText = errorDesc;
            document.querySelector('.errorPrecio').innerText = errorPrecio;
            document.querySelector('.errorMatricula').innerText = errorMatricula;
            document.querySelector('.errorActividad').innerText = errorActividad;

            if (errorNombre || errorDias || errorDiasCant || errorHorario || errorCurso || errorImg || errorDesc || errorPrecio || errorMatricula || errorActividad) {
                return;
            }

            const diasAbreviados = mapearDiasSemanaAbreviatura(dias);

            const idempresa = localStorage.getItem("id");
            const datosActualizados = {
                "id": idActividad,
                "nombre": nombre,
                "dias_semana": diasAbreviados,
                "numero_dias": diasCant,
                "horario_dias": horario,
                "curso": curso,
                "img": img,
                "descripcion": desc,
                "precio": precio,
                "matricula": matricula,
                "tipo_actividad": tipoActividad,
                "id_empresa_actividad": idempresa
            };

            // Asegúrate de convertir idCliente a un número si es necesario
            const idActividadNumero = Number(idActividad);

            // Realizar la solicitud para actualizar la actividad con el ID proporcionado
            fetch(`http://localhost:8888/SaguntoKids/actividades/editar/${idActividadNumero}`, {
                method: 'PUT',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(datosActualizados)
            })
                .then(response => {
                    if (!response.ok) {
                        throw new Error(`Error al actualizar la actividad. Estado: ${response.status}`);
                    }
                    return response.json();
                })
                .then(actividadActualizada => {
                    console.log('Actividad actualizada:', actividadActualizada);
                    // Puedes hacer algo después de actualizar la actividad, como redirigir a la lista de actividades
                    window.location.href = `http://localhost:8888/SaguntoKids/empresas/zonaPrivEmpresa/${idempresa}`;
                })
                .catch(error => {
                    console.error(error);
                });
        });
    }


    // Función para mapear los nombres completos de los días de la semana a abreviaturas
    function mapearDiasSemanaAbreviatura(dias) {
        const diaSemanaAbreviatura = {
            "Lunes": "L",
            "Martes": "M",
            "Miércoles": "X",
            "Jueves": "J",
            "Viernes": "V",
            "Sábado": "S",
            "Domingo": "D"
        };
        return dias.split(',').map(dia => dia.trim()).map(dia => diaSemanaAbreviatura[dia]).join(',');
    }
})