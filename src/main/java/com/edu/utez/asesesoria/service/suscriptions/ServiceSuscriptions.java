package com.edu.utez.asesesoria.service.suscriptions;

import com.edu.utez.asesesoria.model.suscriptions.BeanSuscription;
import com.edu.utez.asesesoria.model.suscriptions.DaoSuscription;

import java.util.List;

public class ServiceSuscriptions {
    DaoSuscription daoSuscription = new DaoSuscription();
    public List<BeanSuscription> getGroup(long id){return daoSuscription.getGroup(id);}
    public BeanSuscription getOne(long id){
        return daoSuscription.getOne(id);
    }
    public boolean fillGroup(BeanSuscription susc){return daoSuscription.fillGroup(susc);}

}
