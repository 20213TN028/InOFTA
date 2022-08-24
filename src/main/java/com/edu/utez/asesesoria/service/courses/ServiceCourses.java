package com.edu.utez.asesesoria.service.courses;

import com.edu.utez.asesesoria.model.courses.DaoCourse;
import com.edu.utez.asesesoria.model.courses.BeanCourse;

import java.io.InputStream;
import java.util.List;

public class ServiceCourses {
    DaoCourse daoCourse = new DaoCourse();
    public List<BeanCourse> getAll(){
        return daoCourse.getAll();
    }
    public BeanCourse getOne(long id){
        return daoCourse.getOne(id);
    }
    public boolean save(BeanCourse course, InputStream image){
        return daoCourse.save(course, image);
    }
    public boolean update(BeanCourse course){
        return daoCourse.update(course);
    }
    public boolean disable(BeanCourse course){
        return daoCourse.disable(course);
    }
    public boolean enable(BeanCourse course){
        return daoCourse.enable(course);
    }
    public BeanCourse findIdCourse (long id){return daoCourse.findIdCourse(id);}
}
