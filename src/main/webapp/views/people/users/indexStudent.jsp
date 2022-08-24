<%@ page import="com.edu.utez.asesesoria.model.people.BeanPerson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String email = (String) (session.getAttribute("email"));
    String pass = (String) (session.getAttribute("pass"));
    if (email!=null && pass!=null){
%>
<html>
<head>
    <title>OFTA | Perfil Estudiante</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<jsp:include page="../../layouts/navbarStudent.jsp"/>
<%
    BeanPerson person = (BeanPerson) request.getAttribute("person");
%>
<div class="row align-content-center">
    <div class="container rounded bg-white mt-3 mb-3 align-content-center">
        <div style="background-color:#f9f9f9; color: white;" class="row align-content-center mx-5">
            <div class="card-header" style="background-color:#009575; color: white;">
                <div class="row">
                    <center><div class="col fw-bold text-center">PERFIL DE ESTUDIANTE</div></center>
                    <div class="col text-end">
                    </div>
                </div>
            </div>
            <div class="col-md-4 border">
                <div class="d-flex flex-column align-items-center text-center p-3 py-5">
                    <span style="color:black;" class="font-weight-bold"><%= person.getName()+" "+person.getSurname()+" "+person.getLastname()%></span>
                    <span style="color: black;" class="text-black-50"><%= person.getEmail()%></span>
                    <img src="..." class="rounded-circle mt-5" style="width: 80px;" alt="Avatar" />
                    <div class="mt-5 text-center"><a href="update-student?id=<%= person.getId()%>" class="btn btn-outline-warning btn-sm">Modificar Datos</a></div>
                </div>
            </div>
            <div class="col-md-8 border">
                <div class="p-3 py-5">
                    <div class="d-flex justify-content-between align-items-center mb-2"></div>
                    <div class="row mt-2">
                        <input type="hidden" name="id" id="id" value="<%= person.getId()%>">
                        <div class="col-md-12"><label style="color: black;" class="labels">Nombre(s)</label><input style="background-color:#009575; color: white;" class="form-control" class="btn btn-outline-success" type="text" value="<%= person.getName()%>" readonly></div>
                        <div class="col-md-6"><label style="color: black;" class="labels">Apellido Paterno</label><input style="background-color:#009575; color: white;" class="form-control" class="btn btn-outline-success" type="text" value="<%= person.getSurname()%>" readonly></div>
                        <div class="col-md-6"><label style="color: black;" class="labels">Apellido Materno</label><input style="background-color:#009575; color: white;" class="form-control" class="btn btn-outline-success" type="text" value="<%= person.getLastname()%>" readonly></div>
                        <div class="col-md-6"><label style="color: black;" class="labels">Matrícula</label><input style="background-color:#009575; color: white;" class="form-control" class="btn btn-outline-success" type="text" value="<%= person.getStudentID()%>" readonly></div>
                        <div class="col-md-6"><label style="color: black;" class="labels">Fecha de Nacimiento</label><input style="background-color:#009575; color: white;" class="form-control" class="btn btn-outline-success" type="date" value="<%= person.getBirthDay()%>" readonly></div>
                        <div class="col-md-12"><label style="color: black;" class="labels">Correo Electrónico</label><input style="background-color:#009575; color: white;" class="form-control" class="btn btn-outline-success" type="text" value="<%= person.getEmail()%>" readonly></div>
                        <div class="mt-5 text-center"><button style="background-color:#094770; color: white;" type="button" class="btn btn-secondary">Cambiar Contraseña</button></div>

                    </div>
                </div>

            </div>
        </div>
    </div>
</div>
<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>
<%
    }else{
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
%>
