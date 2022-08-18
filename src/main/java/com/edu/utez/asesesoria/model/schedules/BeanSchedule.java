package com.edu.utez.asesesoria.model.schedules;

public class BeanSchedule {
    private long id;
    private String description;
    private int status;

    public BeanSchedule() {
    }

    public BeanSchedule(String description, int status) {
        this.description = description;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
