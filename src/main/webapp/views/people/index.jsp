<%@ page import="com.edu.utez.asesesoria.model.people.BeanPerson" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String email = (String) (session.getAttribute("email"));
    String pass = (String) (session.getAttribute("pass"));
    if (email!=null && pass!=null){
%>
<html>
<head>
    <title>OFTA | Docentes</title>
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
                            <div class="col fw-bold">Listado de Docentes</div>
                            <div class="col text-end">
                                <a href="register-instructor" class="btn btn-outline-primary btn-sm">
                                    <i class="fas fa-user-plus"></i> AGREGAR DOCENTE
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <%
                                    List<BeanPerson> people
                                            = (List<BeanPerson>) request.getAttribute("people");
                                    int count = 1;
                                %>
                                <table class="table table-hover table-sm">
                                    <thead>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>Correo Electronico</th>
                                    <th>Fecha de Nacimiento</th>
                                    <th>Rol</th>
                                    <th>Numero de Empleado</th>
                                    <th>Estado</th>
                                    <th>Acciones</th>
                                    </thead>
                                    <tbody>
                                    <%
                                        for(BeanPerson person : people){
                                    %>
                                        <tr>
                                            <td><%= count++%></td>
                                            <td><%= person.getName() +" "+ person.getLastname() +" "+ person.getSurname() %></td>
                                            <td><%= person.getEmail() %></td>
                                            <td><%= person.getBirthDay().toString() %></td>
                                            <td><%= person.getRole() %></td>
                                            <td><%= person.getEmployeeNumber() %></td>
                                            <td><%= person.getStatus() == 1 ? "Activo" : "Inactivo" %></td>
                                            <!--<td>${person.count}</td>
                                            <td>${person.name} ${person.surname} ${person.lastname}</td>
                                            <td>${person.email}</td>
                                            <td>${person.birthDay}</td>
                                            <td>${person.role}</td>
                                            <td>${person.employeeNumber}</td>
                                            <td>${person.status == 1 ? "Activo":"Inactivo"}</td>-->
                                            <td>
                                                <a href="update-instructor?id=<%= person.getId()%>" class="btn btn-outline-warning btn-sm">EDITAR</a>
                                                <%
                                                    if (person.getStatus() == 1) {
                                                %>
                                                <a class="btn btn-outline-danger btn-sm"
                                                   data-bs-toggle="modal" data-bs-target="#deletePerson-<%= person.getId()%>">DESHABILITAR</a>
                                                <%
                                                    }else {
                                                %>
                                                <a class="btn btn-outline-success btn-sm"
                                                   data-bs-toggle="modal" data-bs-target="#enablePerson-<%= person.getId()%>">HABILITAR</a>
                                                <%
                                                    }
                                                %>
                                            </td>
                                        </tr>
                                    <%
                                        }
                                    %>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
        <%
            for(BeanPerson person : people){
        %>
    <div class="modal fade" id="deletePerson-<%= person.getId()%>" tabindex="-1" aria-labelledby="deletePersonLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form novalidate action="disable-instructor" method="post">
                    <input type="hidden" name="idTD" id="idTD" value="<%= person.getId()%>"/>
                    <input type="hidden" name="statusTD" id="statusTD" value="<%= person.getStatus()%>">
                <div class="modal-header">
                    <h5 class="modal-title" id="deletePersonLabel">Deshabilitar Usuario</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Seguro de deshabilitar a: <%= person.getName() +" "+ person.getLastname() +" "+ person.getSurname() %>?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal fade" id="enablePerson-<%= person.getId()%>" tabindex="-1" aria-labelledby="enablePersonLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form novalidate action="enable-instructor" method="post">
                    <input type="hidden" name="idTD" id="idTD" value="<%= person.getId()%>"/>
                    <input type="hidden" name="statusTD" id="statusTD" value="<%= person.getStatus()%>">
                    <div class="modal-header">
                        <h5 class="modal-title" id="enablePersonLabel">Habilitar Usuario</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ¿Seguro de habilitar a: <%= person.getName() +" "+ person.getLastname() +" "+ person.getSurname() %>?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Confirmar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%
        }
    %>
    <jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
<%
    }else{
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
%>
