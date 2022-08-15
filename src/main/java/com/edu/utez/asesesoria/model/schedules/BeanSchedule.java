package com.edu.utez.asesesoria.model.schedules;

public class BeanSchedule {
    private long id;
    private String description;

    public BeanSchedule() {
    }

    public BeanSchedule(long id, String description) {
        this.id = id;
        this.description = description;
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
}
