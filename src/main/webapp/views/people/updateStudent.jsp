<%@ page import="com.edu.utez.asesesoria.model.people.BeanPerson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>ADMIN | Modificar Datos de Estudiantes</title>
    <jsp:include page="../layouts/head.jsp"/>
</head>
<body>
<%
    BeanPerson person = (BeanPerson) request.getAttribute("person");
%>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <div class="card-header">
                    <div class="row">
                        <div class="col text-center fw-bold">Formulario de Modificación de Datos de Estudiantes</div>
                    </div>
                </div>
                <div class="card-body" >
                    <div class="row">
                        <div class="col">
                            <form class="row g-3 needs-validation" novalidate action="update-student-confirm" method="post">
                                <div class="col-md-4">
                                    <label for="validationCustom01" class="form-label fw-bold">Nombre:</label>
                                    <input type="text" class="form-control" id="validationCustom01" value="<%= person.getName()%>" required
                                           name="name">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                    <input type="hidden" name="id" id="id" value="<%= person.getId()%>">
                                </div>
                                <div class="col-md-4">
                                    <label for="validationCustom02" class="form-label fw-bold">Primer Apellido:</label>
                                    <input type="text" class="form-control" id="validationCustom02" value="<%= person.getLastname()%>" required
                                           name="surname">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <label for="validationCustom03" class="form-label fw-bold">Segundo Apellido:</label>
                                    <input type="text" class="form-control" id="validationCustom03" value="<%= person.getSurname()%>"
                                           aria-describedby="inputGroupPrepend" required name="lastname">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-md-6">
                                    <label for="validationCustom04" class="form-label fw-bold">Correo Electrónico:</label>
                                    <input type="email" class="form-control" id="validationCustom04" value="<%= person.getEmail()%>" required
                                           name="email">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-6">
                                    <label for="validationCustom06" class="form-label fw-bold">Fecha de Nacimiento:</label>
                                    <input type="date" class="form-control" id="validationCustom06" value="<%= person.getBirthDay()%>" required
                                           name="birthDay">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <div class="col-6">
                                    <label for="validationCustom07" class="form-label fw-bold">Matrícula:</label>
                                    <input type="text" class="form-control" id="validationCustom07" value="<%= person.getStudentID()%>" required
                                           name="studentId">
                                    <div class="invalid-feedback">
                                        Campo obligatorio.
                                    </div>
                                </div>
                                <hr>
                                <div class="col-12 text-end">
                                    <a href="get-student?id=<%= person.getId()%>" class="btn btn-outline-danger btn-sm">Cancelar</a>
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
