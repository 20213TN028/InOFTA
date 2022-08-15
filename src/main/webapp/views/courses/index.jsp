<%@ page import="com.edu.utez.asesesoria.model.courses.BeanCourse" %>
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
    <title>OFTA | Talleres</title>
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
                        <div class="col fw-bold">Listado de Talleres</div>
                        <div class="col text-end">
                            <a href="register-course" class="btn btn-outline-primary btn-sm">
                                <i class="fas fa-user-plus"></i> AGREGAR TALLER
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <%
                                List<BeanCourse> courses
                                        = (List<BeanCourse>) request.getAttribute("courses");
                                int count = 1;
                            %>
                            <table class="table table-hover table-sm">
                                <thead>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Tipo</th>
                                <th>Espacio</th>
                                <th>Docente</th>
                                <th>Horario</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                                </thead>
                                <tbody>
                                <%
                                    for(BeanCourse course : courses){
                                %>
                                    <tr>
                                        <td><%= count++%></td>
                                        <td><%= course.getName()%></td>
                                        <td><%= course.getType()%></td>
                                        <td><%= course.getPlaceName()%></td>
                                        <td><%= course.getUsersName()%></td>
                                        <td><%= course.getScheName()%></td>
                                        <td><%= course.getStatus() == 1 ? "Activo" : "Inactivo" %></td>
                                        <td>
                                            <a href="update-course?id=<%= course.getId()%>" class="btn btn-outline-warning btn-sm">EDITAR</a>
                                            <%
                                                if (course.getStatus() == 1) {
                                            %>
                                            <a class="btn btn-outline-danger btn-sm"
                                               data-bs-toggle="modal" data-bs-target="#deleteCourse-<%= course.getId()%>">DESHABILITAR</a>
                                            <%
                                            }else {
                                            %>
                                            <a class="btn btn-outline-success btn-sm"
                                               data-bs-toggle="modal" data-bs-target="#enableCourse-<%= course.getId()%>">HABILITAR</a>
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
    for(BeanCourse course : courses){
%>
<div class="modal fade" id="deleteCourse-<%= course.getId()%>" tabindex="-1" aria-labelledby="deleteCourseLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form novalidate action="disable-course" method="post">
                <input type="hidden" name="idTD" id="idTD" value="<%= course.getId()%>"/>
                <input type="hidden" name="statusTD" id="statusTD" value="<%= course.getStatus()%>">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteCourseLabel">Deshabilitar Taller</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Seguro de deshabilitar taller: <%= course.getName()%>?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="enableCourse-<%= course.getId()%>" tabindex="-1" aria-labelledby="enableCourseLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form novalidate action="enable-course" method="post">
                <input type="hidden" name="idTD" id="idTD" value="<%= course.getId()%>"/>
                <input type="hidden" name="statusTD" id="statusTD" value="<%= course.getStatus()%>">
                <div class="modal-header">
                    <h5 class="modal-title" id="enableCourseLabel">Habilitar Taller</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Seguro de habilitar taller: <%= course.getName() %>?
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
