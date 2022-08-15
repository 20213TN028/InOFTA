package com.edu.utez.asesesoria.model.places;

import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPlace {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public List<BeanPlace> getAll(){
        List<BeanPlace> places = new ArrayList<>();
        BeanPlace place = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM place;");
            rs = pste.executeQuery();
            while(rs.next()){
                place = new BeanPlace();
                place.setId(rs.getLong("id"));
                place.setName(rs.getString("name"));
                place.setStatus(rs.getInt("status"));
                places.add(place);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPlace.class.getName()).log(Level.SEVERE, "Error getAllPlaces", e);
        }finally{
            closeConnection();
        }
        return places;
    }

    public BeanPlace getOne(Long id){
        BeanPlace place = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM place WHERE id=?");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                place = new BeanPlace();
                place.setId(rs.getLong("id"));
                place.setName(rs.getString("name"));
                place.setStatus(rs.getInt("status"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPlace.class.getName()).log(Level.SEVERE, "Error getOnePlace", e);
        }finally{
            closeConnection();
        }
        return place;
    }

    public boolean save(BeanPlace place){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO place (name, status) VALUES (?, ?)");
            pste.setString(1, place.getName());
            pste.setInt(2, 1);
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPlace.class.getName()).log(Level.SEVERE, "Error savePlace", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean update(BeanPlace place){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE place SET name=? WHERE id=?");
            pste.setString(1, place.getName());
            pste.setLong(2, place.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPlace.class.getName()).log(Level.SEVERE, "Error updatePlace", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean disable(BeanPlace place){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE place SET status=? WHERE id=?");
            pste.setInt(1, 0);
            pste.setLong(2, place.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPlace.class.getName()).log(Level.SEVERE, "Error disablePlace", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean enable(BeanPlace place){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE place SET status=? WHERE id=?");
            pste.setInt(1, 1);
            pste.setLong(2, place.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPlace.class.getName()).log(Level.SEVERE, "Error enablePlace", e);
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
