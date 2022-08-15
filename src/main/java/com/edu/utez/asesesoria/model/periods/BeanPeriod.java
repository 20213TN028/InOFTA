package com.edu.utez.asesesoria.model.periods;

import java.sql.Date;

public class BeanPeriod {
    private long id;
    private String name;
    private Date startDate;
    private Date endDate;
    private int status;
    private String type;
    private long quarterId;
    private String quarterName;

    public BeanPeriod() {
    }

    public BeanPeriod(String name, Date startDate, Date endDate, int status, String type, long quarterId, String quarterName) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.type = type;
        this.quarterId = quarterId;
        this.quarterName = quarterName;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getQuarterId() {
        return quarterId;
    }

    public void setQuarterId(long quarterId) {
        this.quarterId = quarterId;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }
}
