<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>OFTA | Iniciar Sesion</title>
    <jsp:include page="/views/layouts/head.jsp"/>
</head>
<body>
<!--<div class="container-sm">
<form action="validate" method="post">
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">Correo Electronico:</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" name="email">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">Contraseña:</label>
        <input type="password" class="form-control" id="exampleInputPassword1" name="pass">
    </div>
    <a href="register-student" type="button" class="btn btn-primary btn-sm">Registrarse</a>
    <button type="submit" class="btn btn-primary" name="action" value="start">Submit</button>
</form>
</div>-->

<!--<style>
    .bg-image-vertical {
        position: relative;
        overflow: hidden;
        background-repeat: no-repeat;
        background-position: right center;
        background-size: auto 100%;
    }

    @media (min-width: 1025px) {
        .h-custom-2 {
            height: 100%;
        }
    }
</style>-->

<section class="vh-100">
    <div class="container text-center mt-5 px-5">
        <div class="container text-center mt-3 px-5">
            <div class="container text-center px-5">
                <div class="container text-center px-5">
                    <div class="container text-center px-5">
                        <div class="container text-center px-5">
                            <div class="container text-center px-5">
                                <div class="container text-center pt-3 px-5 border">
                                    <div class="col-md-12 text-black">
                                        <div class="align-items-center">
                                            <form novalidate action="login" method="post">
                                                <button class="btn btn-outline-success"><span class="h1 fw-bold">OFTA</span></button>
                                                <h3 class="fw-normal mt-3 mb-3 pb-3" style="letter-spacing: 1px;">Iniciar Sesión</h3>

                                                <div class="form-outline mb-4">
                                                    <input type="email" id="form2Example18" class="form-control form-control-lg" name="email"/>
                                                    <label class="form-label" for="form2Example18">Correo Electrónico</label>
                                                </div>

                                                <div class="form-outline mb-4">
                                                    <input type="password" id="form2Example28" class="form-control form-control-lg" name="pass"/>
                                                    <label class="form-label" for="form2Example28">Contraseña</label>
                                                </div>

                                                <div class="pt-1 mb-4">
                                                    <button class="btn btn-info btn-lg btn-block" type="submit">Iniciar Sesión</button>
                                                </div>

                                                <p>¿Eres estudiante? <a href="register-student" class="link-info">Registrate aquí</a></p>

                                            </form>

                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="/views/layouts/footer.jsp"/>
</body>
</html>