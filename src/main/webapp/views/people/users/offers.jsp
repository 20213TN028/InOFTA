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
<div class="container mt-5">
    <div class="card">
        <div class="card-header">
            <div class="row">
                <div class="col fw-bold">Talleres Ofertados</div>
            </div>
        </div>
        <div class="card-body">
            <div class="row row-cols-1 row-cols-md-2 g-4">
                <%
                    List<BeanCourse> courses
                            = (List<BeanCourse>) request.getAttribute("courses");
                    BeanPerson person = (BeanPerson) request.getAttribute("person");
                    for (BeanCourse course : courses) {
                %>
                <div class="col">
                    <div class="card">
                        <form action="inscribe" method="post">
                            <input type="hidden" name="usersId" id="usersId" value="<%= person.getId()%>">
                            <img src="data:image/jpeg;base64, <%= course.getImage()%>" class="card-img-top" alt="...">
                            <input type="hidden" name="courseId" id="courseId" value="<%= course.getId()%>">
                            <div class="card-body">
                                <h5 class="card-title text-center"><%= course.getName()%>
                                </h5>
                                <hr>
                                <div class="text-center m-5">
                                    <ul class="list-group list-group-flush text-center">
                                        <li class="list-group-item">Tipo de Taller: <%= course.getType()%>
                                        </li>
                                        <li class="list-group-item">Docente: <%= course.getUsersName()%>
                                        </li>
                                        <li class="list-group-item">Espacio: <%= course.getPlaceName()%>
                                        </li>
                                        <li class="list-group-item">Horarios: <%= course.getScheName()%></li>
                                    </ul>
                                </div>
                                <hr>
                                <div class="col-12 text-center">
                                    <button class="btn" style="background-color:#009575; color: white; border: #f9f9f9" type="submit"><i
                                            class="fa-solid fa-circle-check"></i> Inscribirse
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
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