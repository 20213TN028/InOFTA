package com.edu.utez.asesesoria.model.periods;

import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPeriod {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public List<BeanPeriod> getAll(){
        List<BeanPeriod> periods = new ArrayList<>();
        BeanPeriod period = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM period INNER JOIN quarter ON quarter_id = quarter.id;");
            rs = pste.executeQuery();
            while(rs.next()){
                period = new BeanPeriod();
                period.setId(rs.getLong("id"));
                period.setName(rs.getString("name"));
                period.setStartDate(rs.getDate("start_date"));
                period.setEndDate(rs.getDate("end_date"));
                period.setStatus(rs.getInt("status"));
                period.setType(rs.getString("type"));
                period.setQuarterId(rs.getLong("quarter_id"));
                period.setQuarterName(rs.getString("quarter.name"));
                periods.add(period);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPeriod.class.getName()).log(Level.SEVERE, "Error getAllPeriods", e);
        }finally{
            closeConnection();
        }
        return periods;
    }

    public BeanPeriod getOne(Long id){
        BeanPeriod period = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM period INNER JOIN quarter ON quarter_id = quarter.id WHERE period.id=?");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                period = new BeanPeriod();
                period.setId(rs.getLong("id"));
                period.setName(rs.getString("name"));
                period.setStartDate(rs.getDate("start_date"));
                period.setEndDate(rs.getDate("end_date"));
                period.setType(rs.getString("type"));
                period.setStatus(rs.getInt("status"));
                period.setId(rs.getLong("quarter_id"));
                period.setQuarterName(rs.getString("quarter.name"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPeriod.class.getName()).log(Level.SEVERE, "Error getOnePeriod", e);
        }finally{
            closeConnection();
        }
        return period;
    }

    public boolean save(BeanPeriod period){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO period (name, start_date, end_date, status, type, quarter_id) VALUES (?, ?, ?, ?, ?, ?)");
            pste.setString(1, period.getName());
            pste.setDate(2, period.getStartDate());
            pste.setDate(3, period.getEndDate());
            pste.setInt(4, 1);
            pste.setString(5, period.getType());
            pste.setLong(6, period.getQuarterId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPeriod.class.getName()).log(Level.SEVERE, "Error savePeriod", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean update(BeanPeriod period){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE period SET name=?, start_date=?, end_date=?, type=?, quarter_id=? WHERE id=?");
            pste.setString(1, period.getName());
            pste.setDate(2, period.getStartDate());
            pste.setDate(3, period.getEndDate());
            pste.setString(4, period.getType());
            pste.setLong(5, period.getQuarterId());
            pste.setLong(6, period.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPeriod.class.getName()).log(Level.SEVERE, "Error updatePeriod", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean disable(BeanPeriod period){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE period SET status=? WHERE id=?");
            pste.setInt(1, 0);
            pste.setLong(2, period.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPeriod.class.getName()).log(Level.SEVERE, "Error disablePeriod", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean enable(BeanPeriod period){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE period SET status=? WHERE id=?");
            pste.setInt(1, 1);
            pste.setLong(2, period.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPeriod.class.getName()).log(Level.SEVERE, "Error enablePeriod", e);
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
