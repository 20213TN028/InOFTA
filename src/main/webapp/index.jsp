<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>OFTA | Iniciar Sesion</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<style>
    body {
        margin: 0;
        padding: 0;
        background-repeat: no-repeat;
        background-size: cover;
        background-image:url(images/UTEZ_Carrusel2.jpg);
        background-color: gray;
        height: 100vh;
        overflow: hidden;
    }

    .login {
        position: absolute;
        top: 73%;
        left: 22%;
        transform: translate(-50%, -50%);
        width: 25vw;
        background: gray;
        border-radius: 6px;
        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
        -ms-border-radius: 6px;
        -o-border-radius: 6px;
    }

    .centro {
        position: absolute;
        top: 73%;
        left: 22%;
        transform: translate(-50%, -50%);
        height: 980px;
        width: 600px;
        background: whitesmoke;
        border-radius: 2px;
        background: #fcfcfc;
        -webkit-border-radius: 6px;
        -moz-border-radius: 6px;
    }

    .centro img {
        /* text-align: center; */
        padding:  13px 97px 10px;
        border-bottom: 1px solid rgb(0, 0, 0);
    }

    .centro form {
        padding: 39px 27px;
        box-sizing: border-box;
    }

    form .campotexto {
        position: relative;
        border-bottom: 2px solid #000000;
        margin: 30px 0;
    }

    .campotexto input {
        width: 100%;
        padding: 0 5px;
        height: 40px;
        font-size: 16px;
        border: none;
        background: none;
        outline: none;
    }

    .campotexto label {
        position: absolute;
        top: 50%;
        left: 5px;
        color: #000000;
        transform: translateY(-50%);
        font-size: 16px;
        pointer-events: none;
    }

    .campotexto span::before {
        content: '';
        position: absolute;
        top: 40px;
        left: 0;
        width: 0px;
        height: 2px;
        background: #0914ac;
        transition: .5s;
    }

    .campotexto input:focus~label,
    .campotexto input:valid~label {
        top: -5px;
        color: #000000;
    }

    .campotexto input:focus~span::before,
    .campotexto input:valid~span::before {
        width: 100%;
    }

    .pass {
        margin: -5px 0 20px 5px;
        color: #000000;
        cursor: pointer;
        margin-left: 120px;
    }

    .pass:hover {
        text-decoration: underline;
    }

    input[type="submit"] {
        width: 68%;
        height: 62px;
        margin: 30px 59px;
        border: 1px solid;
        margin-top: 4%;
        border-radius: 25px;
        font-size: 18px;
        font-weight: 700;
        cursor: pointer;
        -webkit-border-radius: 25px;
    }

    input[type="submit"]:hover {
        background: #1C3258;
        color: #ffffff;
        transition: .5s;
    }


    .registrolink{
        margin: 30px 0;
        margin-top: 14px;
        text-align: center;
        font-size: 16px;
        color: #000000;
        text-align: center;
        color: #000000;
        margin-right: 60px;
    }

    .registrolink a{
        color: #000ed4;
        text-decoration: none;
    }

    .registrolink a:hover{
        text-decoration: underline;
    }

    .HomeAbout {
        width: 100vw;
        height: 25vh;
    }
    .logoutez{
        height: 210px;
        margin-left:-2px;
    }

    .picture{
        margin-left: 1%;
    }

    .fondo{
        width: 99vw;
        height: 50vw;
        margin-left: 263px;
    }
</style>

<section class="vh-100">

    <div class="contenedor">
        <div class="centro">
            <img  class="logoutez" src="views/images/UTEZ%20COLOR.svg">
            <form novalidate action="login" method="post">
                <div class="campotexto">
                    <input type="email" id="form2Example18" class="form-control form-control-lg" name="emaill"/>
                    <span></span>
                    <label >Correo Institucional</label>
                </div>
                <div class="campotexto">
                    <input type="password" id="form2Example28" class="form-control form-control-lg" name="passs"/>
                    <span></span>
                    <label>Contraseña</label>
                </div>
                <!-- <div class="pass">Olvidaste la Contraseña?</div>--->
                <input name="submit" type="submit" value="Iniciar Sesión">
                <div class="registrolink">
                    ¿Eres estudiante? <a href="register-student">Registrate Aquí</a>
                </div>
            </form>
        </div>
    </div>
    <div>
        <picture class="picture">
            <img class="fondo"  src="views/images/UTEZ_Carrusel2.jpg">
        </picture>
    </div>

</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>