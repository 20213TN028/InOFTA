package com.edu.utez.asesesoria.model.places;

public class BeanPlace {
    private long id;
    private String name;
    private int status;

    public BeanPlace() {
    }

    public BeanPlace(String name, int status) {
        this.name = name;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
