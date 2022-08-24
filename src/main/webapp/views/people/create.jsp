<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADMIN | Registrar Docente</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>
<jsp:include page="../layouts/navbarAdmin.jsp"/>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col text-center fw-bold">Formulario de Registro de Docentes</div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <form class="row g-3 needs-validation" id="form" novalidate action="save-instructor" method="post">
                                <div class="col-md-4" id="group-name">
                                    <label for="validationCustom01" class="form-label fw-bold">Nombre:</label>
                                    <input type="text" class="form-control" id="validationCustom01" value="" required
                                    name="name">
                                    <div class="invalid-feedback">
                                        Campo obligatorio. Se requiere de Solo Letras
                                    </div>
                                </div>
                                <div class="col-md-4" id="group-lastname">
                                    <label for="validationCustom02" class="form-label fw-bold">Primer apellido:</label>
                                    <input type="text" class="form-control" id="validationCustom02" value="" required
                                    name="lastname">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-md-4" id="group-surname">
                                    <label for="validationCustom03" class="form-label fw-bold">Segundo apellido:</label>
                                    <input type="text" class="form-control" id="validationCustom03"
                                           aria-describedby="inputGroupPrepend" required name="surname">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>

                                </div>
                                <div class="col-md-6" id="group-email">
                                    <label for="validationCustom04" class="form-label fw-bold">Correo Electrónico:</label>
                                    <input type="email" class="form-control" id="validationCustom04" required name="email">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-md-6" id="group-pass">
                                    <label for="validationCustom05" class="form-label fw-bold">Contraseña:</label>
                                    <input type="password" id="validationCustom05" class="form-control" required name="pass">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-6" id="group-birthDay">
                                    <label for="validationCustom06" class="form-label fw-bold">Fecha de Nacimiento:</label>
                                    <input type="date" class="form-control" id="validationCustom06" required name="birthDay">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-6" id="group-employeeNumber">
                                    <label for="validationCustom07" class="form-label fw-bold">Número de Empleado:</label>
                                    <input type="text" class="form-control" id="validationCustom07" required name="employeeNumber">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <hr>
                                <div class="col-12 text-end">
                                    <a href="get-people" class="btn btn-outline-danger btn-sm"><i class="fa-solid fa-ban"></i> Cancelar</a>
                                    <button class="btn btn-outline-success btn-sm" type="submit" id="liveToastBtn"><i class="fa fa-send"></i> Enviar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
    <div id="liveToast" class="toast hide" role="alert" aria-live="assertive" aria-atomic="true">
        <div class="toast-header">
            <img src="..." class="rounded me-2" alt="...">
            <strong class="me-auto">OFTA</strong>
            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
        </div>
        <
            /*boolean result = (boolean) request.getAttribute("result");
            System.out.println(result);
            if (result) {
        %>
        <div class="toast-body">
            Registrado correctamente.
        </div>
        <
            }else {
        %>
        <div class="toast-body">
            Error.
        </div>
        <
            }*/
        %>

    </div>
</div>-->
<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
