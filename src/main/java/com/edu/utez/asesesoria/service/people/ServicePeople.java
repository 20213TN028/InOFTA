package com.edu.utez.asesesoria.service.people;

import com.edu.utez.asesesoria.model.people.BeanPerson;
import com.edu.utez.asesesoria.model.people.DaoPerson;

import java.util.List;

public class ServicePeople {
    DaoPerson daoPerson = new DaoPerson();
    public List<BeanPerson> getAll(){
        return daoPerson.getAll();
    }
    public BeanPerson getOne(long id){
        return daoPerson.getOne(id);
    }
    public boolean save(BeanPerson person){
        return daoPerson.save(person);
    }
    public boolean saveStudent(BeanPerson person){
        return daoPerson.saveStudent(person);
    }
    public boolean update(BeanPerson person){
        return daoPerson.update(person);
    }
    public boolean updateStudent(BeanPerson person){
        return daoPerson.updateStudent(person);
    }
    public boolean disable(BeanPerson person){return daoPerson.disable(person);}
    public boolean enable(BeanPerson person){return daoPerson.enable(person);}
    public boolean delete(long id) {return daoPerson.delete(id);}
    public boolean validatePerson(BeanPerson person){return daoPerson.validatePerson(person);}

    /*public static void main(String[] args) {
        BeanPerson person = new BeanPerson();
        //person.setEmail("joel.hernandez@gmail.com");
        //person.setStudentID("20213tn000");
        person.setEmail("alejandro.castillo@gmail.comm");
        person.setEmployeeNumber("99900");
        boolean result = new ServicePeople().validatePerson(person);
        if (result){
            System.out.println("continuar");
        }else {
            System.out.println("no continuar");
        }
    }*/
}
