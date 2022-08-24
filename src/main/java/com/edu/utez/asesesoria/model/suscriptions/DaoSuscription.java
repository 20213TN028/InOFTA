package com.edu.utez.asesesoria.model.suscriptions;

import com.edu.utez.asesesoria.model.courses.BeanCourse;
import com.edu.utez.asesesoria.model.courses.DaoCourse;
import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoSuscription {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public BeanSuscription getOne(Long id){
        BeanSuscription susc = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM suscriptions INNER JOIN users ON suscriptions.users_id = users.id INNER JOIN course ON suscriptions.course_id = course.id WHERE suscriptions.id = ?;");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                susc = new BeanSuscription();
                susc.setId(rs.getLong("suscriptions.id"));
                susc.setStatus(rs.getInt("suscriptions.status"));
                susc.setUsersId(rs.getLong("users_id"));
                susc.setCourseId(rs.getLong("course_id"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoSuscription.class.getName()).log(Level.SEVERE, "Error getOneSuscription", e);
        }finally{
            closeConnection();
        }
        return susc;
    }

    public List<BeanSuscription> getGroup(long id){
        List<BeanSuscription> suscs = new ArrayList<>();
        BeanSuscription susc = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM suscriptions \n" +
                    "INNER JOIN users ON suscriptions.users_id=users.id \n" +
                    "INNER JOIN course ON suscriptions.course_id=course.id \n" +
                    "WHERE suscriptions.course_id = ?;");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                susc = new BeanSuscription();
                susc.setId(rs.getLong("suscriptions.id"));
                susc.setStatus(rs.getInt("users.status"));
                susc.setNameStudent(rs.getString("users.name"));
                susc.setSurnameStudent(rs.getString("users.surname"));
                susc.setLastnameStudent(rs.getString("users.lastname"));
                suscs.add(susc);
                System.out.println("Status Student: "+susc.getStatusStudent());
            }
        }catch (SQLException e){
            Logger.getLogger(DaoSuscription.class.getName()).log(Level.SEVERE, "Error getAllGroups", e);
        }finally{
            closeConnection();
        }
        return suscs;
    }

    public boolean fillGroup(BeanSuscription susc){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO suscriptions (status, users_id, course_id) " +
                    "VALUES (?, ?, ?)");
            pste.setInt(1, 1);
            pste.setLong(2, susc.getUsersId());
            pste.setLong(3, susc.getCourseId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoSuscription.class.getName()).log(Level.SEVERE, "Error fillGroup", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public BeanSuscription findUserStatus(long idCourse){
        BeanSuscription susc = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM suscriptions INNER JOIN users ON suscriptions.users_id = users.id WHERE suscriptions.course_id = ? AND users.role = 'ESTUDIANTE';");
            pste.setLong(1, idCourse);
            rs = pste.executeQuery();
            while(rs.next()){
                susc = new BeanSuscription();
                susc.setStatusStudent(rs.getInt("users.status"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoSuscription.class.getName()).log(Level.SEVERE, "Error findUserStudents", e);
        }finally{
            closeConnection();
        }
        return susc;
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
