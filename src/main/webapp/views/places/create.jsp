<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADMIN | Registrar Espacios</title>
    <link rel="stylesheet" href="../../assets/css/style.css">
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
                        <div class="col text-center fw-bold">Formulario de Registro de Espacios</div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <form class="row g-3 needs-validation" id="group-namep" novalidate action="register-place-confirm" method="post">
                                <div class="col-md-6" id="group-name">
                                    <label for="validationCustom01" class="form-label fw-bold">Nombre:</label>
                                    <input type="text" class="form-control" id="validationCustom01" value="" required
                                           name="name">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <hr>
                                <div class="col-12 text-end">
                                    <a href="get-places" class="btn btn-outline-danger btn-sm"><i class="fa-solid fa-ban"></i> Cancelar</a>
                                    <button class="btn btn-outline-success btn-sm" type="submit"><i class="fa fa-send"></i> Enviar</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<jsp:include page="../layouts/footer.jsp"/>
</body>
<script src="../../assets/js/validations.js"></script>
</html>
