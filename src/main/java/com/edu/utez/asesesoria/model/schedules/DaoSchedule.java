package com.edu.utez.asesesoria.model.schedules;

import com.edu.utez.asesesoria.model.courses.BeanCourse;
import com.edu.utez.asesesoria.model.courses.DaoCourse;
import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSchedule {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public List<BeanSchedule> getAll(){
        List<BeanSchedule> schedules = new ArrayList<>();
        BeanSchedule schedule = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM schedules;");
            rs = pste.executeQuery();
            while(rs.next()){
                schedule = new BeanSchedule();
                schedule.setId(rs.getLong("id"));
                schedule.setDescription(rs.getString("description"));
                schedules.add(schedule);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoSchedule.class.getName()).log(Level.SEVERE, "Error getAllSchedules", e);
        }finally{
            closeConnection();
        }
        return schedules;
    }

    public BeanSchedule getOne(long id){
        BeanSchedule schedule = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM schedules WHERE id=?;");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                schedule = new BeanSchedule();
                schedule.setId(rs.getLong("id"));
                schedule.setDescription(rs.getString("description"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoSchedule.class.getName()).log(Level.SEVERE, "Error getOneSchedule", e);
        }finally{
            closeConnection();
        }
        return schedule;
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
