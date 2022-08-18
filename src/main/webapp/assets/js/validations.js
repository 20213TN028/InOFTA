// Variable para acceder al formulario
const form = document.getElementById('form')

// Variable para acceder a las entradas de los formularios
const inputs = document.querySelectorAll('#form input')

// Objeto con las expresiones regulares
const expresiones = {
    textnumbers: /^[a-zA-Z0-9\_\-]{4,16}$/, // Letras, numeros, guion y guion_bajo /* * La vas a usar para las de tipo texto */
    text: /^[a-zA-ZÀ-ÿ\s]{1,40}$/, // Letras y espacios, pueden llevar acentos.
    password: /^.{4,12}$/, // 4 a 12 digitos.
    email: /^[a-zA-Z0-9_.+-]+@utez\.edu\.mx$/, // Correo Institucional
    numbers: /^\d{1,10}$/, // 1 a 14 numeros.
    matricula: /^[0-9]{5}[a-z]{2}[0-9]{3}$/, // Validar una matricula
    employeeNumber: /^[A-Z]{2}[0-9]{4}$/ //Vlaidar Numero de Empleado
}

// Objeto con las banderas para validar si hay datos dentro del input
const campos = {
    name: false,
    nameq: false,
    namep: false,
    surname: false,
    lastname: false,
    email: false,
    password: false,
    //birth: false,
    matricula: false,
    type: false,
    placeId: false,
    usersId: false,
    quarterId: false
}

// Funcion para validar el formulario completo
const validarFormulario = (e) => {
    switch (e.target.name) {
        case "name":
            validarCampo(expresiones.text, e.target, 'name')
            break;
        case "nameq":
            validarCampo(expresiones.text, e.target, 'nameq')
            break;
        case "namep":
            validarCampo(expresiones.text, e.target, 'namep')
            break;
        case "surname":
            validarCampo(expresiones.text, e.target, 'surname')
            break;
        case "lastname":
            validarCampo(expresiones.text, e.target, 'lastname')
            break;
        case "email":
            validarCampo(expresiones.email, e.target, 'email')
            break;
        case "password":
            validarCampo(expresiones.password, e.target, 'password')
            break;
        // case "birth":
        //     validarCampo(expresiones.textnumbers, e.target, 'birth')
        //     break;
        case "matricula":
            validarCampo(expresiones.matricula, e.target, 'matricula')
            break;
        case "type":
            validarCampo(expresiones.text, e.target, 'type')
            break;
        case "placeId":
            validarCampo(expresiones.numbers, e.target, 'placeId')
            break;
        case "usersId":
            validarCampo(expresiones.numbers, e.target, 'usersId')
            break;
        case "quarterId":
            validarCampo(expresiones.numbers, e.target, 'quarterId')
            break;
    }
}

// Funcion para validar campo por campo
const validarCampo = (expresion, input, campo) => {
    if (expresion.test(input.value)) {
        document.getElementById(`group-${campo}`).classList.remove('form-group-incorrecto')
        document.querySelector(`#group-${campo} .invalid-feedback`).classList.remove('invalid-feedback-active')
        campos[campo] = true
    } else {
        document.getElementById(`group-${campo}`).classList.add('form-group-incorrecto')
        document.querySelector(`#group-${campo} .invalid-feedback`).classList.add('invalid-feedback-active')
        campos[campo] = false
    }
}

// Evento con los que se valida el Formulario
inputs.forEach((input) => {
    input.addEventListener('keyup', validarFormulario)
    input.addEventListener('blur', validarFormulario)
})

// Evento para corroborar que a la hora de mandar el formulrio este este lleno
form.addEventListener('submit', (e) => {
    e.preventDefault()
    // Registro de Docentes y Estudiantes
    if (campos.name && campos.surname && campos.lastname && campos.email && campos.password && campos.matricula) {
        document.getElementById('form-message').classList.remove('form-message-activo')
        form.reset()
        // Registro de Talleres
    } else if (campos.name && campos.type && campos.placeId && campos.usersId){
        document.getElementById('form-message').classList.remove('form-message-activo')
        form.reset()
        // Registro de Periodos
    } else if (campos.name && campos.type && campos.quarterId){
        document.getElementById('form-message').classList.remove('form-message-activo')
        form.reset()
        // Registro de Espacios
    } else if (campos.namep){
        document.getElementById('form-message').classList.remove('form-message-activo')
        form.reset()
        // Registro de Cuatri
    } else if (campos.nameq){
        document.getElementById('form-message').classList.remove('form-message-activo')
        form.reset()
    }else {
        document.getElementById('form-message').classList.add('form-message-activo')
    }
})