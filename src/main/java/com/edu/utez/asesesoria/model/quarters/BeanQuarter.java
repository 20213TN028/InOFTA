package com.edu.utez.asesesoria.model.quarters;

import java.sql.Date;

public class BeanQuarter {
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int status;

    public BeanQuarter() {
    }

    public BeanQuarter(String name, Date startDate, Date endDate, int status) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
