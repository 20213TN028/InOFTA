package com.edu.utez.asesesoria.service.quarters;

import com.edu.utez.asesesoria.model.quarters.BeanQuarter;
import com.edu.utez.asesesoria.model.quarters.DaoQuarter;

import java.util.List;

public class ServiceQuarters {
    DaoQuarter daoQuarter = new DaoQuarter();
    public List<BeanQuarter> getAll(){
        return daoQuarter.getAll();
    }
    public BeanQuarter getOne(long id){
        return daoQuarter.getOne(id);
    }
    public boolean save(BeanQuarter quarter){
        return daoQuarter.save(quarter);
    }
    public boolean update(BeanQuarter quarter){
        return daoQuarter.update(quarter);
    }
    public boolean disable(BeanQuarter quarter){
        return daoQuarter.disable(quarter);
    }
    public boolean enable(BeanQuarter quarter){
        return daoQuarter.enable(quarter);
    }
}
