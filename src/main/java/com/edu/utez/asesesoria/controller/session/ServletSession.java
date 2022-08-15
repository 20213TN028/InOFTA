package com.edu.utez.asesesoria.controller.session;

import com.edu.utez.asesesoria.model.people.BeanPerson;
import com.edu.utez.asesesoria.model.people.DaoPerson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet (name="validate", value = "/validate")

public class ServletSession extends HttpServlet {

    HttpSession session;

    @Override
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
    }
}
