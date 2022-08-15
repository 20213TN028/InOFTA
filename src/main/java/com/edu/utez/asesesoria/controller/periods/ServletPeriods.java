package com.edu.utez.asesesoria.controller.periods;

import com.edu.utez.asesesoria.model.periods.BeanPeriod;
import com.edu.utez.asesesoria.service.periods.ServicePeriods;
import com.edu.utez.asesesoria.service.quarters.ServiceQuarters;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletPeriods",
        urlPatterns = {"/get-periods",
                "/register-period",
                "/update-period",
                //"/delete-period",
                "/save-period",
                "/update-period-confirm",
                //"/delete-period-confirm",
                "/disable-period",
                "/enable-period"
        })

public class ServletPeriods extends HttpServlet {
    String action, urlRedirect = "/get-periods";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action) {
            case "/get-periods":
                request.setAttribute("periods", new ServicePeriods().getAll());
                urlRedirect = "/views/periods/index.jsp";
                break;
            case "/register-period":
                request.setAttribute("quarters", new ServiceQuarters().getAll());
                urlRedirect = "/views/periods/create.jsp";
                break;
            case "/update-period":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                request.setAttribute("period", new ServicePeriods().getOne(Long.parseLong(id)));
                request.setAttribute("quarters", new ServiceQuarters().getAll());
                urlRedirect = "/views/periods/update.jsp";
                break;
            default:
                urlRedirect = "/get-periods";
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
            case "/save-period":
                String name = request.getParameter("name");
                String startDate = request.getParameter("startDate");
                String endDate = request.getParameter("endDate");
                String type = request.getParameter("type");
                String quarterId = request.getParameter("quarterId");
                String quarterName = request.getParameter("quarterName");
                try {
                    BeanPeriod period = new BeanPeriod();
                    period.setName(name);
                    period.setStartDate(Date.valueOf(startDate));
                    period.setEndDate(Date.valueOf(endDate));
                    period.setType(type);
                    period.setQuarterId(Long.parseLong(quarterId));
                    period.setQuarterName(quarterName);
                    boolean result = new ServicePeriods().save(period);
                    if (result) {
                        urlRedirect = "/get-periods?message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/update-period-confirm":
                String nameU = request.getParameter("name");
                String startDateU = request.getParameter("startDate");
                String endDateU = request.getParameter("endDate");
                String typeU = request.getParameter("type");
                String quarterIdU = request.getParameter("quarterId");
                String idU = request.getParameter(("id"));

                System.out.println(quarterIdU);
                try {
                    BeanPeriod periodU = new BeanPeriod();
                    periodU.setName(nameU);
                    periodU.setStartDate(Date.valueOf(startDateU));
                    periodU.setEndDate(Date.valueOf(endDateU));
                    periodU.setType(typeU);
                    periodU.setQuarterId(Long.parseLong(quarterIdU));
                    periodU.setId(Long.parseLong(idU));
                    boolean resultU = new ServicePeriods().update(periodU);
                    if (resultU) {
                        urlRedirect = "/get-periods?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/disable-period":
                String statusDi = request.getParameter("statusTD");
                String idDi = request.getParameter(("idTD"));
                try {
                    BeanPeriod periodDi = new BeanPeriod();
                    periodDi.setStatus(Integer.parseInt(statusDi));
                    periodDi.setId(Long.parseLong(idDi));
                    boolean resultDi = new ServicePeriods().enable(periodDi);
                    if (resultDi) {
                        urlRedirect = "/get-periods?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-periods";
                break;
            case "/enable-period":
                String statusE = request.getParameter("statusTD");
                String idE = request.getParameter(("idTD"));
                try {
                    BeanPeriod periodE = new BeanPeriod();
                    periodE.setStatus(Integer.parseInt(statusE));
                    periodE.setId(Long.parseLong(idE));
                    boolean resultE = new ServicePeriods().enable(periodE);
                    if (resultE) {
                        urlRedirect = "/get-periods?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-periods?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-periods";
                break;
            default:
                urlRedirect = "/get-periods";
                break;
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
