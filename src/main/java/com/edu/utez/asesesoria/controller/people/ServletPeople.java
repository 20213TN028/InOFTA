package com.edu.utez.asesesoria.controller.people;

import com.edu.utez.asesesoria.model.people.BeanPerson;
import com.edu.utez.asesesoria.service.people.ServicePeople;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

@WebServlet(name = "ServletPeople",
        urlPatterns = {"/get-people",
                "/register-instructor",
                "/update-instructor",
                //"/delete-instructor",
                "/save-instructor",
                "/update-instructor-confirm",
                //"/delete-instructor-confirm",
                "/disable-instructor",
                "/enable-instructor",
                //----------------------------
                "/get-students",
                "/register-student",
                "/update-student",
                //"/delete-student",
                "/save-student",
                "/update-student-confirm",
                //"/delete-student-confirm",
                "/disable-student",
                "/enable-student",
                "/index-instructor",
                "/index-student"
        })
public class ServletPeople extends HttpServlet {
    String action, urlRedirect = "/get-people";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        action = request.getServletPath();
        switch (action) {
            case "/get-people":
                request.setAttribute("people", new ServicePeople().getAll());
                urlRedirect = "/views/people/index.jsp";
                break;
            case "/index-instructor":
                urlRedirect = "/views/people/users/indexInstructor.jsp";
                break;
            case "/index-student":
                urlRedirect = "/views/people/users/indexStudent.jsp";
                break;
            case "/register-instructor":
                urlRedirect = "/views/people/create.jsp";
                break;
            case "/update-instructor":
                String id = request.getParameter("id");
                id = (id == null) ? "0" : id;
                //BeanPerson person = servicePeople.getOne(Long.parseLong(id));
                request.setAttribute("person", new ServicePeople().getOne(Long.parseLong(id)));
                //request.setAttribute("people", new ServicePeople().getOne(Long.parseLong(id)));
                urlRedirect = "/views/people/update.jsp";
                break;
            case "/register-student":
                urlRedirect = "/views/people/createStudent.jsp";
                break;
            case "/update-student":
                urlRedirect = "/views/people/updateStudent.jsp";
                break;
            default:
                urlRedirect = "/get-people";
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
            case "/save-instructor":
                String name = request.getParameter("name");
                String surname = request.getParameter("surname");
                String lastname = request.getParameter("lastname");
                String email = request.getParameter("email");
                String pass = request.getParameter("pass");
                String birthDay = request.getParameter("birthDay");
                String employeeNumber = request.getParameter("employeeNumber");
                try {
                    BeanPerson person = new BeanPerson();
                    person.setName(name);
                    person.setSurname(surname);
                    person.setLastname(lastname);
                    person.setEmail(email);
                    person.setPassword(pass);
                    person.setBirthDay(Date.valueOf(birthDay));
                    person.setEmployeeNumber(employeeNumber);
                    boolean result;
                    boolean rb = new ServicePeople().validatePerson(person);
                    System.out.println(rb);

                    if (rb) {
                        result = new ServicePeople().save(person);
                        System.out.println("No Existe Este Registro, Se puede Ingresar Un Dato");
                    }else {
                        result = false;
                        System.out.println("Existe Este Registro, No Se Puede Ingresar Un Registro");
                    }

                    if (result) {
                        urlRedirect = "/get-people?message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                    }

                } catch (Exception e) {
                    urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/update-instructor-confirm":
                String nameU = request.getParameter("name");
                String surnameU = request.getParameter("surname");
                String lastnameU = request.getParameter("lastname");
                String emailU = request.getParameter("email");
                String passU = request.getParameter("pass");
                String birthDayU = request.getParameter("birthDay");
                String employeeNumberU = request.getParameter("employeeNumber");
                String idU = request.getParameter(("id"));
                try {
                    BeanPerson personU = new BeanPerson();
                    personU.setName(nameU);
                    personU.setSurname(surnameU);
                    personU.setLastname(lastnameU);
                    personU.setEmail(emailU);
                    personU.setPassword(passU);
                    personU.setBirthDay(Date.valueOf(birthDayU));
                    personU.setEmployeeNumber(employeeNumberU);
                    personU.setId(Long.parseLong(idU));
                    boolean resultU = new ServicePeople().update(personU);
                    //boolean resultU = servicePeople.update(personU);
                    if (resultU) {
                        urlRedirect = "/get-people?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/disable-instructor":
                String statusDi = request.getParameter("statusTD");
                String idDi = request.getParameter(("idTD"));
                System.out.println("Status: "+ statusDi);
                try{
                    BeanPerson personDi = new BeanPerson();
                    personDi.setStatus(Integer.parseInt(statusDi));
                    personDi.setId(Long.parseLong(idDi));
                    boolean resultDi = new ServicePeople().disable(personDi);
                    System.out.println("Status: "+ statusDi);
                    if (resultDi) {
                        urlRedirect = "/get-people?message=Deshabilitado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e){
                    urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-people";
                break;
            case "/enable-instructor":
                String statusE = request.getParameter("statusTD");
                String idE = request.getParameter(("idTD"));
                try{
                    BeanPerson personE = new BeanPerson();
                    personE.setStatus(Integer.parseInt(statusE));
                    personE.setId(Long.parseLong(idE));
                    System.out.println("Status: "+ statusE);
                    boolean resultE = new ServicePeople().enable(personE);
                    System.out.println("Status: "+ statusE);
                    if (resultE) {
                        urlRedirect = "/get-people?message=Deshabilitado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e){
                    urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-people";
                break;
            case "/save-student":
                String nameS = request.getParameter("name");
                String surnameS = request.getParameter("surname");
                String lastnameS = request.getParameter("lastname");
                String emailS = request.getParameter("email");
                String passS = request.getParameter("pass");
                String birthDayS = request.getParameter("birthDay");
                String studentIdS = request.getParameter("studentId");
                try {
                    BeanPerson personS = new BeanPerson();
                    personS.setName(nameS);
                    personS.setSurname(surnameS);
                    personS.setLastname(lastnameS);
                    personS.setEmail(emailS);
                    personS.setPassword(passS);
                    personS.setBirthDay(Date.valueOf(birthDayS));
                    personS.setStudentID(studentIdS);
                    boolean resultS;
                    boolean resultB = new ServicePeople().validatePerson(personS);
                    System.out.println(resultB);

                    if (resultB) {
                        resultS = new ServicePeople().saveStudent(personS);
                        System.out.println("No Existe Este Registro, Se puede Ingresar Un Dato");
                    }else {
                        resultS = false;
                        System.out.println("Existe Este Registro, No Se Puede Ingresar Un Registro");
                    }

                    if (resultS) {
                        urlRedirect = "/index.jsp?message=Registrado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/index.jsp?message=Hubo un error&result=false&status=400";
                    }

                } catch (Exception e) {
                    urlRedirect = "/index.jsp?message=Hubo un error&result=false&status=400";
                }
                break;
            /*case "/delete-instructor-confirm":
                try{
                    String idToDelete = request.getParameter("idTD");
                    idToDelete = (idToDelete == null) ? "0" : idToDelete;
                    System.out.println(idToDelete);
                    boolean resultAction = servicePeople.delete(Long.parseLong(idToDelete));
                    if (resultAction) {
                        urlRedirect = "/get-people?message=Eliminado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e){
                    urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-people";
                break;*/
            case "/update-student-confirm":
                String nameUS = request.getParameter("name");
                String surnameUS = request.getParameter("surname");
                String lastnameUS = request.getParameter("lastname");
                String emailUS = request.getParameter("email");
                String passUS = request.getParameter("pass");
                String birthDayUS = request.getParameter("birthDay");
                String studentIdUS = request.getParameter("studentId");
                String idUS = request.getParameter(("id"));
                try {
                    BeanPerson personUS = new BeanPerson();
                    personUS.setName(nameUS);
                    personUS.setSurname(surnameUS);
                    personUS.setLastname(lastnameUS);
                    personUS.setEmail(emailUS);
                    personUS.setPassword(passUS);
                    personUS.setBirthDay(Date.valueOf(birthDayUS));
                    personUS.setEmployeeNumber(studentIdUS);
                    personUS.setId(Long.parseLong(idUS));
                    boolean resultUS = new ServicePeople().updateStudent(personUS);
                    //boolean resultU = servicePeople.update(personU);
                    if (resultUS) {
                        urlRedirect = "/get-people?message=Modificado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e) {
                    urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                }
                break;
            case "/disable-student": // Cómo va a funcionar?????????
                String statusDiS = request.getParameter("statusTD");
                String idDiS = request.getParameter(("idTD"));
                try{
                    BeanPerson personDiS = new BeanPerson();
                    personDiS.setStatus(Integer.parseInt(statusDiS));
                    personDiS.setId(Long.parseLong(idDiS));
                    System.out.println("Status: "+ statusDiS);
                    boolean resultDiS = new ServicePeople().disable(personDiS);
                    System.out.println("Status: "+ statusDiS);
                    if (resultDiS) {
                        urlRedirect = "/get-people?message=Deshabilitado correctamente&result=true&status=200";
                    } else {
                        urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                    }
                } catch (Exception e){
                    urlRedirect = "/get-people?message=Hubo un error&result=false&status=400";
                }
                urlRedirect = "/get-people";
                break;
            default:
                urlRedirect = "/get-people";
        }
        response.sendRedirect(request.getContextPath() + urlRedirect);
    }
}
