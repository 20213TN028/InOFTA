<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADMIN | Registrar Cuatrimestres</title>
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
                        <div class="col text-center fw-bold">Formulario de Registro de Cuatrimestres</div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <form class="row g-3 needs-validation" id="form" novalidate action="save-quarter" method="post">
                                <div class="col-md-4" id="group-name">
                                    <label for="validationCustom01" class="form-label fw-bold">Nombre:</label>
                                    <input type="text" class="form-control" id="validationCustom01" value="" required
                                           name="name">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-4" id="group-startDate">
                                    <label for="validationCustom06" class="form-label fw-bold">Fecha de Inicio:</label>
                                    <input type="date" class="form-control" id="validationCustom06" required name="startDate">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-4" id="endDate">
                                    <label for="validationCustom07" class="form-label fw-bold">Fecha de Fin:</label>
                                    <input type="date" class="form-control" id="validationCustom07" required name="endDate">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <hr>
                                <div class="col-12 text-end">
                                    <a href="get-quarters" class="btn btn-outline-danger btn-sm"><i class="fa-solid fa-ban"></i> Cancelar</a>
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
