<%@ page import="com.edu.utez.asesesoria.model.quarters.BeanQuarter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADMIN | Modificar Datos de Cuatrimestres</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>
<jsp:include page="../layouts/navbarAdmin.jsp"/>
<%
    BeanQuarter quarter = (BeanQuarter) request.getAttribute("quarter");
%>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col text-center fw-bold">Formulario de Modificación de Datos de Cuatrimestres</div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <form class="row g-3 needs-validation" novalidate action="update-quarter-confirm" method="post">
                                <div class="col-md-4">
                                    <label for="validationCustom01" class="form-label fw-bold">Nombre:</label>
                                    <input type="text" class="form-control" id="validationCustom01" value="<%= quarter.getName()%>" required
                                           name="name">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                    <input type="hidden" name="id" id="id" value="<%= quarter.getId()%>">
                                </div>
                                <div class="col-6">
                                    <label for="validationCustom06" class="form-label fw-bold">Fecha de Inicio:</label>
                                    <input type="date" class="form-control" id="validationCustom06" value="<%= quarter.getStartDate()%>" required
                                           name="startDate">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-6">
                                    <label for="validationCustom07" class="form-label fw-bold">Fecha de Fin:</label>
                                    <input type="date" class="form-control" id="validationCustom07" value="<%= quarter.getEndDate()%>"  required
                                           name="endDate">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <hr>
                                <div class="col-12 text-end">
                                    <a href="get-quarters" class="btn btn-outline-danger btn-sm">Cancelar</a>
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
</html>
