package com.edu.utez.asesesoria.model.quarters;

import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoQuarter {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public List<BeanQuarter> getAll(){
        List<BeanQuarter> quarters = new ArrayList<>();
        BeanQuarter quarter = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM quarter;");
            rs = pste.executeQuery();
            while(rs.next()){
                quarter = new BeanQuarter();
                quarter.setId(rs.getLong("id"));
                quarter.setName(rs.getString("name"));
                quarter.setStartDate(rs.getDate("start_date"));
                quarter.setEndDate(rs.getDate("end_date"));
                quarter.setStatus(rs.getInt("status"));
                quarters.add(quarter);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoQuarter.class.getName()).log(Level.SEVERE, "Error getAllQuarters", e);
        }finally{
            closeConnection();
        }
        return quarters;
    }

    public BeanQuarter getOne(Long id){
        BeanQuarter quarter = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM quarter WHERE id=?");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                quarter = new BeanQuarter();
                quarter.setId(rs.getLong("id"));
                quarter.setName(rs.getString("name"));
                quarter.setStartDate(rs.getDate("start_date"));
                quarter.setEndDate(rs.getDate("end_date"));
                quarter.setStatus(rs.getInt("status"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoQuarter.class.getName()).log(Level.SEVERE, "Error getOneQuarter", e);
        }finally{
            closeConnection();
        }
        return quarter;
    }

    public boolean save(BeanQuarter quarter){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO quarter (name, start_date, end_date, status) VALUES (?, ?, ?, ?)");
            pste.setString(1, quarter.getName());
            pste.setDate(2, quarter.getStartDate());
            pste.setDate(3, quarter.getEndDate());
            pste.setInt(4, 1);
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoQuarter.class.getName()).log(Level.SEVERE, "Error saveQuarter", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean update(BeanQuarter quarter){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE quarter SET name=?, start_date=?, end_date=? WHERE id=?");
            pste.setString(1, quarter.getName());
            pste.setDate(2, quarter.getStartDate());
            pste.setDate(3, quarter.getEndDate());
            pste.setLong(4, quarter.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoQuarter.class.getName()).log(Level.SEVERE, "Error disableQuarter", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean disable(BeanQuarter quarter){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE quarter SET status=? WHERE id=?");
            pste.setInt(1, 0);
            pste.setLong(2, quarter.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoQuarter.class.getName()).log(Level.SEVERE, "Error updateQuarter", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean enable(BeanQuarter quarter){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE quarter SET status=? WHERE id=?");
            pste.setInt(1, 1);
            pste.setLong(2, quarter.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoQuarter.class.getName()).log(Level.SEVERE, "Error enableQuarter", e);
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
