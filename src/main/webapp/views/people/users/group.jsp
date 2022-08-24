<%@ page import="com.edu.utez.asesesoria.model.suscriptions.BeanSuscription" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.utez.asesesoria.model.courses.BeanCourse" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String email2 = (String) (session.getAttribute("email"));
    String pass2 = (String) (session.getAttribute("pass"));
    if (email2 != null && pass2 != null) {
%>
<html>
<head>
    <title>OFTA | Grupo</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<jsp:include page="../../layouts/navbarInstructor.jsp"/>
<div class="container mt-5">
    <div class="row">
        <div class="col-12">
            <div class="card">
                <%
                    List<BeanSuscription> suscs = (List<BeanSuscription>) request.getAttribute("suscs");
                    int count = 1;
                    BeanCourse course = (BeanCourse) request.getAttribute("course");
                %>
                <div class="card-header">
                    <div class="row">
                        <div class="col fw-bold">Grupo</div>
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <table class="table table-hover table-sm">
                                <thead>
                                <th>#</th>
                                <th>Nombre</th>
                                <th>Estado</th>
                                <th>Acciones</th>
                                </thead>
                                <tbody>
                                <%
                                    for (BeanSuscription susc : suscs) {
                                %>
                                <input type="hidden" name="idC" id="idC" value="<%= susc.getCourseId()%>">
                                <tr>
                                    <td><%= count++%></td>
                                    <td><%= susc.getNameStudent() + " " + susc.getSurnameStudent() + " " + susc.getLastnameStudent()%></td>
                                    <td>
                                        <%
                                            if (susc.getStatusStudent() == 1 || susc.getStatusStudent() == 2) {
                                        %>
                                            En curso
                                        <%
                                            } else if (susc.getStatusStudent() == 3) {
                                        %>
                                            Liberado
                                        <%
                                            } else if (susc.getStatusStudent() == 4) {
                                        %>
                                            No liberado
                                        <%
                                            } else {
                                        %>
                                            Baja
                                        <%
                                            }
                                        %>
                                    </td>
                                    <td>Coming Soon!</td>
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
<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>
<%
    } else {
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
%>
