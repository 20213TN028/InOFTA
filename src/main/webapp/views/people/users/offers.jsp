<%@ page import="com.edu.utez.asesesoria.model.courses.BeanCourse" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.utez.asesesoria.model.people.BeanPerson" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<div class="container p-5 my-5 border">
    <div class="row row-cols-1 row-cols-md-2 g-4">
        <input type="hidden" name="id" id="id" value="<%= person.getId()%>">
        <%
            for(BeanCourse course : courses){
        %>
        <div class="card">
            <div class="card-header" style="background-color:#009575; color: white;">
                <div class="row">
                    <center><div class="col fw-bold"></div></center>
                    <div class="col text-end">
                    </div>
                </div>
            </div>
            <figure>
                <img src="fut.jpg">
            </figure>
            <div class="content-card">
                <div class="row">
                        <div class="col">
                            <input value="" type="text" class="form-control" placeholder="" readonly>
                        </div><br>
                        <div class="col">
                            <input value="" type="text" class="form-control" placeholder="" readonly>
                        </div><br>
                        <div class="row">
                            <div class="col">
                                <input style="color: black;" type="text" class="form-control" placeholder="Tipo de taller" readonly>
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
        </div>
    </div>
</div>
       <!-- <div class="col">
            <div class="card mt-3 w-100">
                <div class="card-header text-center"><%= //course.getName()%></div>

                <div class="row g-0">
                    <div class="col-md-4">
                        <div class="container border">
                            <img src="..." class="img-fluid rounded-start" alt="..." />
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="card-body">
                            <div class="container border">
                                <ul
                                        class="list-group list-group-flush list-group-horizontal"
                                >
                                    <li class="list-group-item"><%= //course.getName()%></li>
                                    <li class="list-group-item"><%= //course.getType()%></li>
                                </ul>
                            </div>
                            <div class="container border">
                                <ul
                                        class="list-group list-group-flush list-group-horizontal"
                                >
                                    <li class="list-group-item"><%= //course.getPlaceName()%></li>
                                    <li class="list-group-item"><%= //course.getUsersName()%></li>
                                </ul>
                            </div>
                            <div class="container border">
                                <ul
                                        class="list-group list-group-flush list-group-horizontal"
                                >
                                    <li class="list-group-item"><%= //course.getScheName()%></li>
                                    <li class="list-group-item">Horario 2</li>
                                    <li class="list-group-item">Horario 3</li>
                                </ul>
                            </div>
                        </div>
                    </div>
                    <div>
                        <hr />
                        <form action="inscribe" method="post" class="text-center">
                            <button type="submit" class="btn btn-primary">
                                Inscribir
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>-->
        <%
            }
        %>
    </div>
</div>
<jsp:include page="../../layouts/footer.jsp"/>
</body>
</html>
