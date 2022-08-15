package com.edu.utez.asesesoria.controller.places;

import com.edu.utez.asesesoria.model.places.BeanPlace;
import com.edu.utez.asesesoria.service.places.ServicePlaces;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ServletPlaces",
        urlPatterns = {"/get-places",
                "/register-place",
                "/update-place",
                //"/delete-place",
                "/register-place-confirm",
                "/update-place-confirm",
                //"/delete-place-confirm"
                "/disable-place",
                "/enable-place"
        })

public class ServletPlaces extends HttpServlet {
    String action, urlRedirect = "/get-places";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action) {
            case "/get-places":
                request.setAttribute("places", new ServicePlaces().getAll());
                urlRedirect = "/views/places/index.jsp";
                break;
            case "/register-place":
                urlRedirect = "/views/places/create.jsp";
                break;
            case "/update-place":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                request.setAttribute("place", new ServicePlaces().getOne(Long.parseLong(id)));
                //request.setAttribute("people", new ServicePeople().getOne(Long.parseLong(id)));
                urlRedirect = "/views/places/update.jsp";
                break;
            default:
                urlRedirect = "/get-places";
        }
        request.getRequestDispatcher(urlRedirect).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        action = request.getServletPath();
        switch (action) {
            case "/register-place-confirm":
                String name = request.getParameter("name");
                try {
                    BeanPlace place = new BeanPlace();
                    place.setName(name);
                    boolean result = new ServicePlaces().save(place);
                    if (result) {
                        urlRedirect = "/get-places?message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/update-place-confirm":
                String nameU = request.getParameter("name");
                String id = request.getParameter(("id"));
                try {
                    BeanPlace placeU = new BeanPlace();
                    placeU.setName(nameU);
                    placeU.setId(Long.parseLong(id));
                    boolean resultU = new ServicePlaces().update(placeU);
                    if (resultU) {
                        urlRedirect = "/get-places?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/disable-place":
                String statusDi = request.getParameter("statusTD");
                String idDi = request.getParameter(("idTD"));
                try {
                    BeanPlace placeDi = new BeanPlace();
                    placeDi.setStatus(Integer.parseInt(statusDi));
                    placeDi.setId(Long.parseLong(idDi));
                    boolean resultDi = new ServicePlaces().disable(placeDi);
                    if (resultDi) {
                        urlRedirect = "/get-places?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-places";
                break;
            case "/enable-place":
                String statusE = request.getParameter("statusTD");
                String idE = request.getParameter(("idTD"));
                try {
                    BeanPlace placeE = new BeanPlace();
                    placeE.setStatus(Integer.parseInt(statusE));
                    placeE.setId(Long.parseLong(idE));
                    boolean resultE = new ServicePlaces().enable(placeE);
                    if (resultE) {
                        urlRedirect = "/get-places?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-places?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-places";
                break;
            default:
                urlRedirect = "/get-places";
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
