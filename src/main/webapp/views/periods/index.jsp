<%@ page import="com.edu.utez.asesesoria.model.periods.BeanPeriod" %>
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
    <title>OFTA | Periodos</title>
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
                        <div class="col fw-bold">Listado de Periodos</div>
                        <div class="col text-end">
                            <a href="register-period" class="btn btn-outline-primary btn-sm">
                                <i class="fas fa-user-plus"></i> AGREGAR PERIODO
                            </a>
                        </div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <%
                                List<BeanPeriod> periods
                                        = (List<BeanPeriod>) request.getAttribute("periods");
                                int count = 1;
                            %>
                            <table class="table table-hover table-sm">
                                <thead>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Fecha de Inicio</th>
                                <th>Fecha de Fin</th>
                                <th>Tipo</th>
                                <th>Cuatrimestre</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                                </thead>
                                <tbody>
                                <%
                                    for(BeanPeriod period : periods){
                                %>
                                    <tr>
                                        <td><%= count++%></td>
                                        <td><%= period.getName()%></td>
                                        <td><%= period.getStartDate()%></td>
                                        <td><%= period.getEndDate()%></td>
                                        <td><%= period.getType()%></td>
                                        <td><%= period.getQuarterName()%></td>
                                        <td><%= period.getStatus() == 1 ? "Activo" : "Inactivo" %></td>
                                        <td>
                                            <a href="update-period?id=<%= period.getId()%>" class="btn btn-outline-warning btn-sm">EDITAR</a>
                                            <%
                                                if (period.getStatus() == 1) {
                                            %>
                                            <a class="btn btn-outline-danger btn-sm"
                                               data-bs-toggle="modal" data-bs-target="#deletePeriod-<%= period.getId()%>">DESHABILITAR</a>
                                            <%
                                            }else {
                                            %>
                                            <a class="btn btn-outline-success btn-sm"
                                               data-bs-toggle="modal" data-bs-target="#enablePeriod-<%= period.getId()%>">HABILITAR</a>
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
    for(BeanPeriod period : periods){
%>
<div class="modal fade" id="deletePeriod-<%= period.getId()%>" tabindex="-1" aria-labelledby="deletePeriodLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form novalidate action="disable-period" method="post">
                <input type="hidden" name="idTD" id="idTD" value="<%= period.getId()%>"/>
                <input type="hidden" name="statusTD" id="statusTD" value="<%= period.getStatus()%>">
                <div class="modal-header">
                    <h5 class="modal-title" id="deletePeriodLabel">Deshabilitar Periodo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Seguro de deshabilitar periodo: <%= period.getName()%>?
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                    <button type="submit" class="btn btn-primary">Confirmar</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="modal fade" id="enablePeriod-<%= period.getId()%>" tabindex="-1" aria-labelledby="enablePeriodLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <form novalidate action="enable-period" method="post">
                <input type="hidden" name="idTD" id="idTD" value="<%= period.getId()%>"/>
                <input type="hidden" name="statusTD" id="statusTD" value="<%= period.getStatus()%>">
                <div class="modal-header">
                    <h5 class="modal-title" id="enablePeriodLabel">Habilitar Periodo</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    ¿Seguro de habilitar periodo: <%= period.getName()%>?
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
