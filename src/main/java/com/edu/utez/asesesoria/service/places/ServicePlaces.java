package com.edu.utez.asesesoria.service.places;

import com.edu.utez.asesesoria.model.places.BeanPlace;
import com.edu.utez.asesesoria.model.places.DaoPlace;

import java.util.List;

public class ServicePlaces {
    DaoPlace daoPlace = new DaoPlace();
    public List<BeanPlace> getAll(){
        return daoPlace.getAll();
    }
    public BeanPlace getOne(long id){
        return daoPlace.getOne(id);
    }
    public boolean save(BeanPlace place){
        return daoPlace.save(place);
    }
    public boolean update(BeanPlace place){
        return daoPlace.update(place);
    }
    public boolean disable(BeanPlace place){
        return daoPlace.disable(place);
    }
    public boolean enable(BeanPlace place){
        return daoPlace.enable(place);
    }


}
