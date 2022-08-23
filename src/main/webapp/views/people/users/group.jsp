<%@ page import="com.edu.utez.asesesoria.model.suscriptions.BeanSuscription" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.utez.asesesoria.model.courses.BeanCourse" %>
<%@ page import="com.edu.utez.asesesoria.model.people.BeanPerson" %>
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
                <div class="card-header">
                    <div class="row">
                        <div class="col fw-bold">Grupo: blabla</div>
                        <!--<div class="col text-end">
                            <a href="register-course" class="btn btn-outline-primary btn-sm">
                                <i class="fa-solid fa-backpack"></i> AGREGAR TALLER
                            </a>
                        </div>-->
                    </div>
                </div>
                <div class="card-body">
                    <div class="row">
                        <div class="col">
                            <%
                                BeanCourse course = (BeanCourse) request.getAttribute("course");
                            %>
                            <%
                                List<BeanSuscription> suscs = (List<BeanSuscription>) request.getAttribute("suscs");
                                int count = 1;
                            %>
                            <table class="table table-hover table-sm">
                                <thead>
                                <th>#</th>
                                <th>Status</th>
                                <th>Users ID</th>
                                <th>Course ID</th>
                                </thead>
                                <tbody>
                                <%
                                    for(BeanSuscription susc : suscs){
                                %>
                                <tr>
                                    <td><%= count++%></td>
                                    <td><%= susc.getStatus()%></td>
                                    <td><%= susc.getUsersId()%></td>
                                    <td><%= susc.getCourseId()%></td>
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
