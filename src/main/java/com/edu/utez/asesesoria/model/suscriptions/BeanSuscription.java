package com.edu.utez.asesesoria.model.suscriptions;

public class BeanSuscription {
    private long id;
    private int status;
    private long usersId;
    private long courseId;
    private String nameStudent;
    private String surnameStudent;
    private String lastnameStudent;
    private int statusStudent;

    public BeanSuscription() {
    }

    public BeanSuscription(int status, long usersId, long courseId) {
        this.status = status;
        this.usersId = usersId;
        this.courseId = courseId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUsersId() {
        return usersId;
    }

    public void setUsersId(long usersId) {
        this.usersId = usersId;
    }

    public long getCourseId() {
        return courseId;
    }

    public void setCourseId(long courseId) {
        this.courseId = courseId;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public String getSurnameStudent() {
        return surnameStudent;
    }

    public void setSurnameStudent(String surnameStudent) {
        this.surnameStudent = surnameStudent;
    }

    public String getLastnameStudent() {
        return lastnameStudent;
    }

    public void setLastnameStudent(String lastnameStudent) {
        this.lastnameStudent = lastnameStudent;
    }

    public int getStatusStudent() {
        return statusStudent;
    }

    public void setStatusStudent(int statusStudent) {
        this.statusStudent = statusStudent;
    }
}
