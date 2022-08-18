package com.edu.utez.asesesoria.controller.suscriptions;

import com.edu.utez.asesesoria.model.courses.BeanCourse;
import com.edu.utez.asesesoria.model.suscriptions.BeanSuscription;
import com.edu.utez.asesesoria.service.courses.ServiceCourses;
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
                "/release"
        })
public class ServletSuscriptions extends HttpServlet {
    String action, urlRedirect = "/get-offers";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action){
            case "/inscribe":
                String usersId = request.getParameter("id");
                String courseId = request.getParameter("courseId");
                try {
                    BeanSuscription susc = new BeanSuscription();
                    susc.setUsersId(Long.parseLong(usersId));
                    susc.setCourseId(Long.parseLong(courseId));
                    boolean result = new ServiceSuscriptions().fillGroup(susc);
                    System.out.println("Result: "+result);
                    if (result) {
                        urlRedirect = "/get-offers?id="+susc.getUsersId()+"?message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-offers?id="+susc.getUsersId()+"?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/index.jsp?message=Hubo un error&result=false&status=400";
                }
                break;
        }
    }
}