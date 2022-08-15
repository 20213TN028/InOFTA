package com.edu.utez.asesesoria.model.people;

import java.sql.Date;

public class BeanPerson {
    private long id;
    private String name;
    private String surname;
    private String lastname;
    private Date birthDay;
    private String email;
    private String password;
    private String employeeNumber;
    private String studentID;
    private String role;
    private int status;

    public BeanPerson() {
    }

    public BeanPerson(String name, String surname, String lastname, Date birthDay, String email, String password, String employeeNumber, String studentID, String role, int status) {
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.birthDay = birthDay;
        this.email = email;
        this.password = password;
        this.employeeNumber = employeeNumber;
        this.studentID = studentID;
        this.role = role;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
