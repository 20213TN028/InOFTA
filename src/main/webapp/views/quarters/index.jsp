<%@ page import="com.edu.utez.asesesoria.model.quarters.BeanQuarter" %>
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
    <title>OFTA | Cuatrimestres</title>
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
                        <div class="col fw-bold">Listado de Cuatrimestres</div>
                        <div class="col text-end">
                            <a href="register-quarter" class="btn btn-outline-primary btn-sm">
                                <i class="fa-solid fa-calendar-plus"></i> AGREGAR CUATRIMESTRE
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <%
                                List<BeanQuarter> quarters
                                        = (List<BeanQuarter>) request.getAttribute("quarters");
                                int count = 1;
                            %>
                            <table class="table table-hover table-sm">
                                <thead>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Fecha de Inicio</th>
                                <th>Fecha de Fin</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                                </thead>
                                <tbody>
                                <%
                                    for(BeanQuarter quarter : quarters){
                                %>
                                    <tr>
                                        <td><%= count++%></td>
                                        <td><%= quarter.getName()%></td>
                                        <td><%= quarter.getStartDate()%></td>
                                        <td><%= quarter.getEndDate()%></td>
                                        <td><%= quarter.getStatus() == 1 ? "Activo" : "Inactivo" %></td>
                                        <td>
                                            <a href="update-quarter?id=<%= quarter.getId()%>" class="btn btn-outline-warning btn-sm"><i class="fa-solid fa-pen-to-square"></i> EDITAR</a>
                                            <%
                                                if (quarter.getStatus() == 1) {
                                            %>
                                            <a class="btn btn-outline-danger btn-sm"
                                               data-bs-toggle="modal" data-bs-target="#deleteQuarter-<%= quarter.getId()%>"><i class="fa-solid fa-circle-exclamation"></i> DESHABILITAR</a>
                                            <%
                                            }else {
                                            %>
                                            <a class="btn btn-outline-success btn-sm"
                                               data-bs-toggle="modal" data-bs-target="#enableQuarter-<%= quarter.getId()%>"><i class="fa-solid fa-circle-check"></i> HABILITAR</a>
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
    for(BeanQuarter quarter : quarters){
%>
<div class="modal fade" id="deleteQuarter-<%= quarter.getId()%>" tabindex="-1" aria-labelledby="deleteQuarterLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form novalidate action="disable-quarter" method="post">
                <input type="hidden" name="idTD" id="idTD" value="<%= quarter.getId()%>"/>
                <input type="hidden" name="statusTD" id="statusTD" value="<%= quarter.getStatus()%>">
                <div class="modal-header">
                    <h5 class="modal-title" id="deleteQuarterLabel">Deshabilitar Cuatrimestre</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Seguro de deshabilitar cuatrimestre: <%= quarter.getName()%>?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="enableQuarter-<%= quarter.getId()%>" tabindex="-1" aria-labelledby="enableQuarterLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form novalidate action="enable-quarter" method="post">
                <input type="hidden" name="idTD" id="idTD" value="<%= quarter.getId()%>"/>
                <input type="hidden" name="statusTD" id="statusTD" value="<%= quarter.getStatus()%>">
                <div class="modal-header">
                    <h5 class="modal-title" id="enableQuarterLabel">Habilitar Cuatrimestre</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Seguro de habilitar cuatrimestre: <%= quarter.getName()%>?
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
