<%@ page import="com.edu.utez.asesesoria.model.courses.BeanCourse" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.utez.asesesoria.model.people.BeanPerson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String email2 = (String) (session.getAttribute("email"));
    String pass2 = (String) (session.getAttribute("pass"));
    if (email2 != null && pass2 != null) {
%>
<html>
<head>
    <title>OFTA | Oferta de Talleres</title>
    <jsp:include page="../../layouts/head.jsp"/>
</head>
<body>
<jsp:include page="../../layouts/navbarStudent.jsp"/>
<%
    List<BeanCourse> courses
            = (List<BeanCourse>) request.getAttribute("courses");
    BeanPerson person = (BeanPerson) request.getAttribute("person");
%>
<div class="container p-5 my-5">
    <div class="row row-cols-1 row-cols-md-2 g-4">
        <form action="inscribe" method="post">
        <%
            for (BeanCourse course : courses) {
        %>

            <input type="hidden" name="id" id="id" value="<%= person.getId()%>">
            <div class="card" style="width: 18rem;">
                <div class="card-header" style="background-color:#009575; color: white;">
                    <div class="row">
                        <div class="col fw-bold text-center"><%= course.getName()%>
                        </div>
                        <input type="hidden" name="courseId" id="courseId" value="<%= course.getId()%>">
                    </div>
                </div>
                <div class="card-body">
                    <ul class="list-group list-group-flush text-center">
                        <li class="list-group-item">Tipo de Taller: <%= course.getType()%>
                        </li>
                        <li class="list-group-item">Docente: <%= course.getUsersName()%>
                        </li>
                        <li class="list-group-item">Espacio: <%= course.getPlaceName()%>
                        </li>
                        <li class="list-group-item">Número de Horario: <%= course.getScheName()%>
                        </li>
                    </ul>
                </div>

                <div class="col-12 text-center">
                    <button class="btn" style="background-color:#009575; color: white; border: #f9f9f9" type="submit"><i
                            class="fa-solid fa-circle-check"></i> Inscribirse
                    </button>
                </div>
            </div>
        </form>

    </div>
    <!-- -----------------------------------------------------------------------------------
    <div class="card">
        <div class="card-header" style="background-color:#009575; color: white;">
            <div class="row">
                <div class="col fw-bold text-center"></div>
            </div>
        </div>
        <div class="content-card">
            <div class="row">
                    <div class="col">
                        <input value="" type="text" class="form-control" readonly>
                    </div><br>
                    <div class="col">
                        <input value="" type="text" class="form-control" readonly>
                    </div><br>
                    <div class="row">
                        <div class="col">
                            <input value="" type="text" class="form-control" readonly>
                        </div>
                        <div class="col">
                            <input  type="text" class="form-control" placeholder="Espacio" readonly>
                        </div>
                    </div><br>

                    <div class="row">
                        <div class="col">
                            <input type="text" class="form-control" placeholder="Horario 1" readonly>
                        </div>
                        <div class="col">
                            <input  type="text" class="form-control" placeholder="Horario 2" readonly>
                        </div>
                        <div class="col">
                            <input  type="text" class="form-control" placeholder="Horario 3" readonly>
                        </div>
                    </div> <br>
                    <form action="inscribe" method="post">
                        <div class="col-12 border">
                            <a style="background-color:#009575; color: white;" class="btn" href="#"><i class="fa-solid fa-circle-check"></i> Inscribirse</a>
                        </div>
                    </form>
            </div>
        </div>
    </div>-->
    <%
        }
    %>
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