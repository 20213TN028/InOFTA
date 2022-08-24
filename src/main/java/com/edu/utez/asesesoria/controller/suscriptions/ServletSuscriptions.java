package com.edu.utez.asesesoria.controller.suscriptions;

import com.edu.utez.asesesoria.model.courses.BeanCourse;
import com.edu.utez.asesesoria.model.suscriptions.BeanSuscription;
import com.edu.utez.asesesoria.service.courses.ServiceCourses;
import com.edu.utez.asesesoria.service.people.ServicePeople;
import com.edu.utez.asesesoria.service.suscriptions.ServiceSuscriptions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletSuscriptions",
        urlPatterns = {"/get-group",
                "/inscribe",
                "/release",
                "/get-profesor-group"
        })
public class ServletSuscriptions extends HttpServlet {
    String action, urlRedirect = "/get-offers";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action) {
            case "/get-profesor-group":


                break;
            case "/get-group":
                String idP = request.getParameter("idP");
                idP = (idP == null) ? "0" : idP;
                System.out.println("id: "+idP);
                BeanCourse course = new ServiceCourses().findIdCourse(Long.parseLong(idP));
                long idC = course.getId();
                System.out.println("ID COURSE: "+idC);

                request.setAttribute("suscs", new ServiceSuscriptions().getGroup(idC));
                request.setAttribute("course", new ServiceCourses().getOne(idC));
                request.setAttribute("person", new ServicePeople().getOne(Long.parseLong(idP)));
                urlRedirect = "/views/people/users/group.jsp";
                break;
            default:
                urlRedirect = "/get-offers";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        action = request.getServletPath();
        switch (action){
            case "/inscribe":
                String usersId = request.getParameter("usersId");
                String courseId = request.getParameter("courseId");
                System.out.println(usersId+"       "+ courseId);
                try {
                    BeanSuscription susc = new BeanSuscription();
                    susc.setUsersId(Long.parseLong(usersId));
                    susc.setCourseId(Long.parseLong(courseId));
                    boolean result = new ServiceSuscriptions().fillGroup(susc);
                    System.out.println("Result: "+result);
                    if (result) {
                        urlRedirect = "/get-offers?id="+susc.getUsersId()+"&message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-offers?id="+susc.getUsersId()+"&message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    System.out.println(e);
                    urlRedirect = "/index.jsp?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/release":

                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
