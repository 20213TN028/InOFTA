package com.edu.utez.asesesoria.model.suscriptions;

import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
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
