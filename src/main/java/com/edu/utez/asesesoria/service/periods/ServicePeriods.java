package com.edu.utez.asesesoria.service.periods;

import com.edu.utez.asesesoria.model.periods.BeanPeriod;
import com.edu.utez.asesesoria.model.periods.DaoPeriod;
import com.edu.utez.asesesoria.model.quarters.BeanQuarter;
import com.edu.utez.asesesoria.model.quarters.DaoQuarter;

import java.util.List;

public class ServicePeriods {
    DaoPeriod daoPeriod = new DaoPeriod();

    public List<BeanPeriod> getAll(){
        return daoPeriod.getAll();
    }

    public BeanPeriod getOne(long id){
        return daoPeriod.getOne(id);
    }

    public boolean save(BeanPeriod period){
        return daoPeriod.save(period);
    }

    public boolean update(BeanPeriod period){
        return daoPeriod.update(period);
    }
    public boolean disable(BeanPeriod period){
        return daoPeriod.disable(period);
    }
    public boolean enable(BeanPeriod period){
        return daoPeriod.enable(period);
    }
}
