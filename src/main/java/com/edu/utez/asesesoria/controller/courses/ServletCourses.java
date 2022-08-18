package com.edu.utez.asesesoria.controller.courses;

import com.edu.utez.asesesoria.model.courses.BeanCourse;
import com.edu.utez.asesesoria.service.courses.ServiceCourses;
import com.edu.utez.asesesoria.service.people.ServicePeople;
import com.edu.utez.asesesoria.service.places.ServicePlaces;
import com.edu.utez.asesesoria.service.schedules.ServiceSchedules;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletCourse",
        urlPatterns = {"/get-courses",
                "/register-course",
                "/update-course",
                "/save-course",
                "/update-course-confirm",
                "/disable-course",
                "/enable-course",
                "/get-offers"
        })

public class ServletCourses extends HttpServlet {
    String action, urlRedirect = "/get-courses";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action){
            case "/get-courses":
                request.setAttribute("courses", new ServiceCourses().getAll());
                urlRedirect = "/views/courses/index.jsp";
                break;
            case "/get-offers":
                String idO = request.getParameter("id");
                idO = (idO == null) ? "0" : idO;
                request.setAttribute("courses", new ServiceCourses().getAll());
                request.setAttribute("person", new ServicePeople().getOne(Long.parseLong(idO)));
                urlRedirect = "/views/people/users/offers.jsp";
                break;
            case "/register-course":
                request.setAttribute("courses", new ServiceCourses().getAll());
                request.setAttribute("places", new ServicePlaces().getAll());
                request.setAttribute("people", new ServicePeople().getAll());
                request.setAttribute("schedules", new ServiceSchedules().getAll());
                urlRedirect = "/views/courses/create.jsp";
                break;
            case "/update-course":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                request.setAttribute("course", new ServiceCourses().getOne(Long.parseLong(id)));
                request.setAttribute("places", new ServicePlaces().getAll());
                request.setAttribute("people", new ServicePeople().getAll());
                request.setAttribute("schedules", new ServiceSchedules().getAll());
                urlRedirect = "/views/courses/update.jsp";
                break;
            default:
                urlRedirect = "/get-courses";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        action = request.getServletPath();
        switch (action){
            case "/save-course":
                String name = request.getParameter("name");
                String type = request.getParameter("type");
                String placeId = request.getParameter("placeId");
                String usersId = request.getParameter("usersId");
                String scheId = request.getParameter("scheId");
                String placeName = request.getParameter("placeName");
                String userName = request.getParameter("userName");
                String scheName = request.getParameter("scheName");
                try {
                    BeanCourse course = new BeanCourse();
                    course.setName(name);
                    course.setType(type);
                    course.setPlaceId(Long.parseLong(placeId));
                    course.setUsersId(Long.parseLong(usersId));
                    course.setScheId(Long.parseLong(scheId));
                    course.setPlaceName(placeName);
                    course.setUsersName(userName);
                    course.setScheName(scheName);
                    boolean result = new ServiceCourses().save(course);
                    System.out.println("Result: "+result);
                    if (result) {
                        System.out.println(placeId+" "+placeName);
                        System.out.println(usersId+" "+userName);
                        System.out.println(scheId+" "+scheName);
                        urlRedirect = "/get-courses?message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/update-course-confirm":
                String nameU = request.getParameter("name");
                String typeU = request.getParameter("type");
                String placeIdU = request.getParameter("placeId");
                String usersIdU = request.getParameter("usersId");
                String scheIdU = request.getParameter("scheId");
                String idU = request.getParameter(("id"));
                System.out.println(placeIdU+"  "+usersIdU);

                try {
                    BeanCourse courseU = new BeanCourse();
                    courseU.setName(nameU);
                    courseU.setType(typeU);
                    courseU.setPlaceId(Long.parseLong(placeIdU));
                    courseU.setUsersId(Long.parseLong(usersIdU));
                    courseU.setScheId(Long.parseLong(scheIdU));
                    courseU.setId(Long.parseLong(idU));
                    System.out.println("placeId: "+placeIdU+"/usersId: "+usersIdU+"/scheId: "+scheIdU);
                    boolean resultU = new ServiceCourses().update(courseU);
                    System.out.println(placeIdU+"  "+usersIdU);
                    if (resultU) {
                        urlRedirect = "/get-courses?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/disable-course":
                String statusDi = request.getParameter("statusTD");
                String idDi = request.getParameter(("idTD"));
                try {
                    BeanCourse courseDi = new BeanCourse();
                    courseDi.setStatus(Integer.parseInt(statusDi));
                    courseDi.setId(Long.parseLong(idDi));
                    boolean resultDi = new ServiceCourses().disable(courseDi);
                    if (resultDi) {
                        urlRedirect = "/get-courses?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-courses";
                break;
            case "/enable-course":
                String statusE = request.getParameter("statusTD");
                String idE = request.getParameter(("idTD"));
                try {
                    BeanCourse courseE = new BeanCourse();
                    courseE.setStatus(Integer.parseInt(statusE));
                    courseE.setId(Long.parseLong(idE));
                    boolean resultE = new ServiceCourses().enable(courseE);
                    if (resultE) {
                        urlRedirect = "/get-courses?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-courses?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-courses";
                break;
            default:
                urlRedirect = "/get-courses";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
