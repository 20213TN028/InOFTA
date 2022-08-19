<%@ page import="com.edu.utez.asesesoria.model.courses.BeanCourse" %>
<%@ page import="com.edu.utez.asesesoria.model.places.BeanPlace" %>
<%@ page import="com.edu.utez.asesesoria.model.people.BeanPerson" %>
<%@ page import="java.util.List" %>
<%@ page import="com.edu.utez.asesesoria.model.schedules.BeanSchedule" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>ADMIN | Modificar Datos de Talleres</title>
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
            <div class="col text-center fw-bold">Formulario de Modificación de Datos de Talleres</div>
          </div>
        </div>
        <%
          BeanCourse course = (BeanCourse) request.getAttribute("course");
          List<BeanPlace> places
                  = (List<BeanPlace>) request.getAttribute("places");
          List<BeanPerson> people
                  = (List<BeanPerson>) request.getAttribute("people");
          List<BeanSchedule> schedules
                  = (List<BeanSchedule>) request.getAttribute("schedules");
        %>
        <div class="card-body">
          <div class="row">
            <div class="col">
              <form class="row g-3 needs-validation" novalidate action="update-course-confirm" method="post">
                <div class="col-md-4">
                  <label for="validationCustom01" class="form-label fw-bold">Nombre:</label>
                  <input type="text" class="form-control" id="validationCustom01" value="<%= course.getName()%>" required
                         name="name">
                  <div class="invalid-feedback">
                    Campo obligatorio.
                  </div>
                  <input type="hidden" name="id" id="id" value="<%= course.getId()%>">
                </div>
                <div class="col-md-4">
                  <label for="validationCustom02" class="form-label fw-bold">Tipo de Taller:</label>
                  <select class="form-select form-select-sm" aria-label=".form-select-sm example" id="validationCustom02"
                          name="type">
                    <option selected><%= course.getType()%></option>
                    <option value="Deportivo">Deportivo</option>
                    <option value="Cultural">Cultural</option>
                  </select>
                  <div class="invalid-feedback">
                    Campo obligatorio.
                  </div>
                </div>
                <div class="col-6">
                  <label for="validationCustom06" class="form-label fw-bold">Horario:</label>
                  <select class="form-select form-select-sm" aria-label=".form-select-sm example" id="validationCustom06"
                          name="scheId">
                    <option value="<%= course.getScheId()%>" selected>¿Deseas cambiar selección?</option>
                    <%
                      for(BeanSchedule schedule : schedules){
                    %>
                    <option value="<%= schedule.getId()%>"><%= schedule.getDescription()%></option>
                    <%
                      }
                    %>
                  </select>
                  <div class="invalid-feedback">
                    Campo obligatorio.
                  </div>
                </div>
                <div class="col-6">
                  <label for="validationCustom03" class="form-label fw-bold">Espacio:</label>
                  <select class="form-select form-select-sm" aria-label=".form-select-sm example" id="validationCustom03"
                          name="placeId">
                    <option value="<%= course.getPlaceId()%>" selected><%= course.getPlaceName()%></option>
                    <%
                      for(BeanPlace place : places){
                    %>
                    <option name="placeName" value="<%= place.getId()%>"><%= place.getName()%></option>
                    <%
                      }
                    %>
                  </select>
                </div>
                <div class="col-6">
                  <label for="validationCustom08" class="form-label fw-bold">Docente:</label>
                  <select class="form-select form-select-sm" aria-label=".form-select-sm example" id="validationCustom08"
                          name="usersId">
                    <option value="<%= course.getUsersId()%>" selected><%= course.getUsersName()%></option>
                    <%
                      for(BeanPerson person : people){
                        String fullName = person.getName()+" "+person.getLastname()+" "+person.getSurname();
                    %>
                    <option name="userName" value="<%= person.getId()%>"><%= fullName%></option>
                    <%
                      }
                    %>
                  </select>
                </div>
                <hr>
                <div class="col-12 text-end">
                  <a href="get-courses" class="btn btn-outline-danger btn-sm">Cancelar</a>
                  <button class="btn btn-outline-success btn-sm" type="submit"><i class="fa fa-send"></i> Enviar</button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
<jsp:include page="../layouts/footer.jsp"/>
</body>
</html>
