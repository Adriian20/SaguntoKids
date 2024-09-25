//funcion para crear elemento vacio mediante el DOM
export function crearElemento(tipo = "br", padre = contenido) {
    let elemento = document.createElement(tipo);
    padre.appendChild(elemento);
    return elemento;
}

//funcion para crear un elemento con contenido texto mediante el DOM
export function crearElementoTexto(texto = "Ejemplo", tipo = "div", padre = contenido) {
    let elemento = document.createElement(tipo);
    elemento.textContent = texto;
    padre.appendChild(elemento);
    return elemento;
}
