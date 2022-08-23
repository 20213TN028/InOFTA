package com.edu.utez.asesesoria.controller.session;

import com.edu.utez.asesesoria.model.people.BeanPerson;
import com.edu.utez.asesesoria.model.people.DaoPerson;
import com.edu.utez.asesesoria.service.people.ServicePeople;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/*@WebServlet (name="validate", value = "/validate")*/
@WebServlet(name="ServletSession",
    urlPatterns = {"/login", "/logout", "/singin"})

public class ServletSession extends HttpServlet {

    HttpSession session;
    String action, urlRedirect = "index.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action){
            case "/singin":
                urlRedirect = "/views/people/createStudent.jsp";
                break;
            default:
                urlRedirect = "/index.jsp";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        action = request.getServletPath();
        switch (action){
            case "/login":
                String email = request.getParameter("emaill");
                String pass = request.getParameter("passs");
                DaoPerson person = new DaoPerson();
                BeanPerson log = new ServicePeople().login(email, pass);
                System.out.println(email+"   "+pass+"   "+log.getEmail()+"   "+log.getPassword()+"   "+log.getId());
                if (log.getId() != 0){
                    System.out.println("Encontrado");
                    session = request.getSession();
                    session.setAttribute("email",log.getEmail());
                    session.setAttribute("pass",log.getPassword());
                    session.setAttribute("role", log.getRole());
                    session.setAttribute("id", log.getId());
                    session.setAttribute("couseId", log.getCouseId());
                    System.out.println("couseSS: "+log.getCouseId());
                    System.out.println("In");
                    if (log.getRole().equals("ADMIN")) {
                        urlRedirect = "/get-people";
                        System.out.println("In -> ADMIN");
                    } else if (log.getRole().equals("DOCENTE")) {
                        urlRedirect = "/get-instructor?id="+log.getId();
                        System.out.println("In -> DOCENTE");
                    }else {
                        urlRedirect = "/get-student?id="+log.getId();
                        System.out.println("In -> ESTUDIANTE");
                    }
                }else{
                    System.out.println("No encontrado");
                    urlRedirect = "/index.jsp";
                }
                break;
            case "/logout":
                session = request.getSession();
                session.removeAttribute("email");
                session.removeAttribute("pass");
                session.removeAttribute("role");
                session.removeAttribute("id");
                session.removeAttribute("couseId");
                session.invalidate();
                urlRedirect = "/index.jsp";
                System.out.println("Out!!");
                break;
            default:
                session = request.getSession();
                session.removeAttribute("email");
                session.removeAttribute("pass");
                session.removeAttribute("role");
                session.removeAttribute("couseId");
                session.removeAttribute(("id"));
                session.invalidate();
                urlRedirect = "/index.jsp";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }

    /*@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "index.jsp";
        String in = request.getParameter("action");

        if (in.equalsIgnoreCase("start")){
            String email = request.getParameter("email");
            String pass = request.getParameter("pass");

            DaoPerson person = new DaoPerson();
            BeanPerson log = person.login(email, pass);

            if (log.getId() != 0) {
                session = request.getSession(true);
                session.setAttribute("email",log.getEmail());
                session.setAttribute("pass",log.getPassword());
                session.setAttribute("role", log.getRole());
                System.out.println("In");
                System.out.println(log.getRole());
                if (log.getRole().equals("ADMIN")) {
                    request.getRequestDispatcher("/get-people").forward(request, response);
                } else if (log.getRole().equals("DOCENTE")) {
                    request.getRequestDispatcher("/views/people/users/indexInstructor.jsp").forward(request, response);
                }else {
                    request.getRequestDispatcher("/views/people/users/indexStudent.jsp").forward(request, response);
                }

            }else {
                request.getRequestDispatcher(url).forward(request, response);
            }

        } else if (in.equalsIgnoreCase("close")) {
            session = request.getSession(false);
            session.removeAttribute("email");
            session.removeAttribute("pass");
            session.removeAttribute("role");
            session.invalidate();
            System.out.println("Out");
            request.getRequestDispatcher(url).forward(request, response);

        } else{
            request.getRequestDispatcher(url).forward(request, response);
        }
    }*/
}
