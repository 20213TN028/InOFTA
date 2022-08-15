package com.edu.utez.asesesoria.service.schedules;

import com.edu.utez.asesesoria.model.periods.BeanPeriod;
import com.edu.utez.asesesoria.model.periods.DaoPeriod;
import com.edu.utez.asesesoria.model.schedules.BeanSchedule;
import com.edu.utez.asesesoria.model.schedules.DaoSchedule;

import java.util.List;

public class ServiceSchedules {
    DaoSchedule daoSchedule = new DaoSchedule();

    public List<BeanSchedule> getAll(){
        return daoSchedule.getAll();
    }

    public BeanSchedule getOne(long id){
        return daoSchedule.getOne(id);
    }
}
