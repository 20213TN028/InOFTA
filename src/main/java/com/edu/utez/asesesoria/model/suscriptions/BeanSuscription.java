package com.edu.utez.asesesoria.model.suscriptions;

public class BeanSuscription {
    private long id;
    private int status;
    private long usersId;
    private long courseId;

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
}
