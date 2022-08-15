package com.edu.utez.asesesoria.controller.quarters;

import com.edu.utez.asesesoria.model.quarters.BeanQuarter;
import com.edu.utez.asesesoria.service.quarters.ServiceQuarters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletQuarters",
        urlPatterns = {"/get-quarters",
                "/register-quarter",
                "/update-quarter",
                //"/delete-quarter",
                "/save-quarter",
                "/update-quarter-confirm",
                //"/delete-quarter-confirm",
                "/disable-quarter",
                "/enable-quarter"
        })

public class ServletQuarters extends HttpServlet {
    String action, urlRedirect = "/get-quarters";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action) {
            case "/get-quarters":
                request.setAttribute("quarters", new ServiceQuarters().getAll());
                urlRedirect = "/views/quarters/index.jsp";
                break;
            case "/register-quarter":
                urlRedirect = "/views/quarters/create.jsp";
                break;
            case "/update-quarter":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                request.setAttribute("quarter", new ServiceQuarters().getOne(Long.parseLong(id)));
                //request.setAttribute("people", new ServicePeople().getOne(Long.parseLong(id)));
                urlRedirect = "/views/quarters/update.jsp";
                break;
            default:
                urlRedirect = "/get-quarters";
                break;
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        action = request.getServletPath();
        switch (action) {
            case "/save-quarter":
                String name = request.getParameter("name");
                String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                try {
                    BeanQuarter quarter = new BeanQuarter();
                    quarter.setName(name);
                    quarter.setStartDate(Date.valueOf(startDate));
                    quarter.setEndDate(Date.valueOf(endDate));
                    boolean result = new ServiceQuarters().save(quarter);
                    if (result) {
                        urlRedirect = "/get-quarters?message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/update-quarter-confirm":
                String nameU = request.getParameter("name");
                String startDateU = request.getParameter("startDate");
                String endDateU = request.getParameter("endDate");
                String idU = request.getParameter(("id"));
                try {
                    BeanQuarter quarterU = new BeanQuarter();
                    quarterU.setName(nameU);
                    quarterU.setStartDate(Date.valueOf(startDateU));
                    quarterU.setEndDate(Date.valueOf(endDateU));
                    quarterU.setId(Long.parseLong(idU));
                    boolean resultU = new ServiceQuarters().update(quarterU);
                    if (resultU) {
                        urlRedirect = "/get-quarters?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/disable-quarter":
                String statusDi = request.getParameter("statusTD");
                String idDi = request.getParameter(("idTD"));
                try {
                    BeanQuarter quarterDi = new BeanQuarter();
                    quarterDi.setStatus(Integer.parseInt(statusDi));
                    quarterDi.setId(Long.parseLong(idDi));
                    boolean resultDi = new ServiceQuarters().disable(quarterDi);
                    if (resultDi) {
                        urlRedirect = "/get-quarters?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-quarters";
                break;
            case "/enable-quarter":
                String statusE = request.getParameter("statusTD");
                String idE = request.getParameter(("idTD"));
                try {
                    BeanQuarter quarterE = new BeanQuarter();
                    quarterE.setStatus(Integer.parseInt(statusE));
                    quarterE.setId(Long.parseLong(idE));
                    boolean resultE = new ServiceQuarters().enable(quarterE);
                    if (resultE) {
                        urlRedirect = "/get-quarters?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-quarters?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-quarters";
                break;
            default:
                urlRedirect = "/get-quarters";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
