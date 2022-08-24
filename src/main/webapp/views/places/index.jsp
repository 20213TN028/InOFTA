<%@ page import="com.edu.utez.asesesoria.model.places.BeanPlace" %>
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
    <title>OFTA | Espacios</title>
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
                            <div class="col fw-bold">Listado de Espacios</div>
                            <div class="col text-end">
                                <a href="register-place" class="btn btn-outline-primary btn-sm">
                                    <i class="fa-solid fa-square-plus"></i> AGREGAR ESPACIO
                                </a>
                            </div>
                        </div>
                    </div>
                    <div class="card-body">
                        <div class="row">
                            <div class="col">
                                <%
                                    List<BeanPlace> places
                                            = (List<BeanPlace>) request.getAttribute("places");
                                    int count = 1;
                                %>
                                <table class="table table-hover table-sm">
                                    <thead>
                                    <th>#</th>
                                    <th>Nombre</th>
                                    <th>Estado</th>
                                    <th>Acciones</th>
                                    </thead>
                                    <tbody>
                                    <%
                                        for(BeanPlace place : places){
                                    %>
                                        <tr>
                                            <td><%= count++%></td>
                                            <td><%= place.getName()%></td>
                                            <td><%= place.getStatus() == 1 ? "Activo" : "Inactivo" %></td>
                                            <td>
                                                <a href="update-place?id=<%= place.getId()%>" class="btn btn-outline-warning btn-sm"><i class="fa-solid fa-pen-to-square"></i> EDITAR</a>
                                                <%
                                                    if (place.getStatus() == 1) {
                                                %>
                                                <a class="btn btn-outline-danger btn-sm"
                                                   data-bs-toggle="modal" data-bs-target="#deletePlace-<%= place.getId()%>"><i class="fa-solid fa-circle-exclamation"></i> DESHABILITAR</a>
                                                <%
                                                }else {
                                                %>
                                                <a class="btn btn-outline-success btn-sm"
                                                   data-bs-toggle="modal" data-bs-target="#enablePlace-<%= place.getId()%>"><i class="fa-solid fa-circle-check"></i> HABILITAR</a>
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
        for(BeanPlace place : places){
    %>
    <div class="modal fade" id="deletePlace-<%= place.getId()%>" tabindex="-1" aria-labelledby="deletePlaceLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form novalidate action="disable-place" method="post">
                    <input type="hidden" name="idTD" id="idTD" value="<%= place.getId()%>"/>
                    <input type="hidden" name="statusTD" id="statusTD" value="<%= place.getStatus()%>">
                    <div class="modal-header">
                        <h5 class="modal-title" id="deletePlaceLabel">Deshabilitar Espacio</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ¿Seguro de deshabilitar espacio: <%= place.getName()%>?
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        <button type="submit" class="btn btn-primary">Confirmar</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="modal fade" id="enablePlace-<%= place.getId()%>" tabindex="-1" aria-labelledby="enablePlaceLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <form novalidate action="enable-place" method="post">
                    <input type="hidden" name="idTD" id="idTD" value="<%= place.getId()%>"/>
                    <input type="hidden" name="statusTD" id="statusTD" value="<%= place.getStatus()%>">
                    <div class="modal-header">
                        <h5 class="modal-title" id="enablePlaceLabel">Habilitar Espacio</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        ¿Seguro de habilitar espacio: <%= place.getName()%>?
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
