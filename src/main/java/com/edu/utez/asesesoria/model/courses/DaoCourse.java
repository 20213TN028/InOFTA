package com.edu.utez.asesesoria.model.courses;

import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCourse {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public List<BeanCourse> getAll(){
        List<BeanCourse> courses = new ArrayList<>();
        BeanCourse course = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM course \n" +
                    "INNER JOIN users ON course.users_id = users.id \n" +
                    "INNER JOIN place ON course.place_id = place.id \n" +
                    "INNER JOIN schedule ON course.place_id = schedule.id;");
            rs = pste.executeQuery();
            while(rs.next()){
                course = new BeanCourse();
                course.setId(rs.getLong("course.id"));
                course.setName(rs.getString("course.name"));
                course.setType(rs.getString("course.type"));
                course.setStatus(rs.getInt("course.status"));
                course.setUsersId(rs.getLong("users_id"));
                course.setPlaceId(rs.getLong("place_id"));
                course.setScheId(rs.getLong("schedules_id"));
                course.setUsersName(rs.getString("users.name"));
                course.setPlaceName(rs.getString("place.name"));
                course.setScheName(rs.getString("schedule.description"));
                courses.add(course);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCourse.class.getName()).log(Level.SEVERE, "Error getAllCourses", e);
        }finally{
            closeConnection();
        }
        return courses;
    }

    public BeanCourse getOne(Long id){
        BeanCourse course = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM course INNER JOIN users ON course.users_id = users.id INNER JOIN place ON course.place_id = place.id INNER JOIN schedule ON course.place_id = schedule.id WHERE course.id = ?;");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                course = new BeanCourse();
                course.setId(rs.getLong("id"));
                course.setName(rs.getString("name"));
                course.setType(rs.getString("type"));
                course.setStatus(rs.getInt("status"));
                course.setPlaceId(rs.getLong("place_id"));
                course.setUsersId(rs.getLong("users_id"));
                course.setScheId(rs.getLong("schedules_id"));
                course.setUsersName(rs.getString("users.name"));
                course.setPlaceName(rs.getString("place.name"));
                course.setScheName(rs.getString("schedule.description"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoCourse.class.getName()).log(Level.SEVERE, "Error getOneCourse", e);
        }finally{
            closeConnection();
        }
        return course;
    }

    public boolean save(BeanCourse course){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO course (name, type, status, place_id, users_id, schedules_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?)");
            pste.setString(1, course.getName());
            pste.setString(2, course.getType());
            pste.setInt(3, 1);
            pste.setLong(4, course.getPlaceId());
            pste.setLong(5, course.getUsersId());
            pste.setLong(6, course.getScheId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoCourse.class.getName()).log(Level.SEVERE, "Error saveCourse", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean update(BeanCourse course){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE course SET name=?, type=?, place_id=?, users_id=?, schedules_id=? WHERE id=?");
            pste.setString(1, course.getName());
            pste.setString(2, course.getType());
            pste.setLong(3, course.getPlaceId());
            pste.setLong(4, course.getUsersId());
            pste.setLong(5, course.getScheId());
            pste.setLong(6, course.getId());
            boolean result = pste.executeUpdate() == 1;
            System.out.println(result);
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoCourse.class.getName()).log(Level.SEVERE, "Error updateCourse", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean disable(BeanCourse course){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE course SET status=? WHERE id=?");
            pste.setInt(1, 0);
            pste.setLong(2, course.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoCourse.class.getName()).log(Level.SEVERE, "Error disableCourse", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean enable(BeanCourse course){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE course SET status=? WHERE id=?");
            pste.setInt(1, 1);
            pste.setLong(2, course.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoCourse.class.getName()).log(Level.SEVERE, "Error enableCourse", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public void closeConnection(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pste != null){
                pste.close();
            }
            if(cstn != null){
                cstn.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch (SQLException e){

        }
    }
}
