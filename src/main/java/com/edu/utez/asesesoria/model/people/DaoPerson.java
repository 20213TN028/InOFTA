package com.edu.utez.asesesoria.model.people;

import com.edu.utez.asesesoria.utils.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoPerson {
    Connection conn;
    PreparedStatement pste;
    CallableStatement cstn;
    ResultSet rs;

    public List<BeanPerson> getAll(){
        List<BeanPerson> people = new ArrayList<>();
        BeanPerson person = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM users WHERE role='DOCENTE';");
            rs = pste.executeQuery();
            while(rs.next()){
                person = new BeanPerson();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthDay(rs.getDate("birth_day"));
                person.setEmail(rs.getString("email"));
                person.setEmployeeNumber(rs.getString("employee_number"));
                //person.setStudentID(rs.getString("student_id"));
                person.setRole(rs.getString("role"));
                person.setStatus(rs.getInt("status"));
                people.add(person);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error getAllPeople", e);
        }finally{
            closeConnection();
        }
        return people;
    }

    public BeanPerson getOne(Long id){
        BeanPerson person = null;
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM users WHERE id=?");
            pste.setLong(1, id);
            rs = pste.executeQuery();
            while(rs.next()){
                person = new BeanPerson();
                person.setId(rs.getLong("id"));
                person.setName(rs.getString("name"));
                person.setSurname(rs.getString("surname"));
                person.setLastname(rs.getString("lastname"));
                person.setBirthDay(rs.getDate("birth_day"));
                person.setEmail(rs.getString("email"));
                person.setEmployeeNumber(rs.getString("employee_number"));
                person.setStudentID(rs.getString("student_id"));
                person.setRole(rs.getString("role"));
                person.setStatus(rs.getShort("status"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error getOnePerson", e);
        }finally{
            closeConnection();
        }
        return person;
    }

    public boolean save(BeanPerson person){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO users (name, surname, lastname, birth_day, role, email, password, employee_number, status)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pste.setString(1, person.getName());
            pste.setString(2, person.getSurname());
            pste.setString(3, person.getLastname());
            pste.setDate(4, person.getBirthDay());
            pste.setString(5, "DOCENTE");
            pste.setString(6, person.getEmail());
            pste.setString(7, person.getPassword());
            pste.setString(8, person.getEmployeeNumber());
            pste.setInt(9, 1);
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error savePerson", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean saveStudent(BeanPerson person){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("INSERT INTO users (name, surname, lastname, birth_day, role, email, password, student_id, status)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pste.setString(1, person.getName());
            pste.setString(2, person.getSurname());
            pste.setString(3, person.getLastname());
            pste.setDate(4, person.getBirthDay());
            pste.setString(5, "ESTUDIANTE");
            pste.setString(6, person.getEmail());
            pste.setString(7, person.getPassword());
            pste.setString(8, person.getStudentID());
            pste.setInt(9, 1);
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error savePersonStudent", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean update(BeanPerson person){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE users SET name=?, surname=?, lastname=?, birth_day=?, email=?, employee_number=?" +
                    " WHERE id=?");
            pste.setString(1, person.getName());
            pste.setString(2, person.getSurname());
            pste.setString(3, person.getLastname());
            pste.setDate(4, person.getBirthDay());
            pste.setString(5, person.getEmail());
            pste.setString(6, person.getEmployeeNumber());
            pste.setLong(7, person.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error updatePerson", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean updateStudent(BeanPerson person){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE users SET name=?, surname=?, lastname=?, birth_day=?, email=?, student_id=?" +
                    " WHERE id=?");
            pste.setString(1, person.getName());
            pste.setString(2, person.getSurname());
            pste.setString(3, person.getLastname());
            pste.setDate(4, person.getBirthDay());
            pste.setString(5, person.getEmail());
            pste.setString(6, person.getStudentID());
            pste.setLong(7, person.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error updateStudent", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean disable(BeanPerson person){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE users SET status=? WHERE id=?");
            pste.setInt(1, 0);
            pste.setLong(2, person.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error disablePerson", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public boolean enable(BeanPerson person){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("UPDATE users SET status=? WHERE id=?");
            pste.setInt(1, 1);
            pste.setLong(2, person.getId());
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error enablePerson", e);
        }finally {
            closeConnection();
        }
        return false;
    }

    public BeanPerson login(String email, String password){
        BeanPerson person = new BeanPerson();
        try {
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT email, password, role, id FROM users WHERE email=? AND password=?");
            pste.setString(1, email);
            pste.setString(2, password);
            rs = pste.executeQuery();
            while (rs.next()){
                person.setId(rs.getLong("id"));
                person.setEmail(rs.getString("email"));
                person.setPassword(rs.getString("password"));
                person.setRole(rs.getString("role"));
                return person;
            }
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error loginPerson", e);
        }finally {
            closeConnection();
        }
        return person;
    }

    public boolean validatePerson(BeanPerson person){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("SELECT * FROM users WHERE email=? OR (employee_number=? OR student_id=?)");
            pste.setString(1, person.getEmail());
            pste.setString(2, person.getEmployeeNumber());
            pste.setString(3, person.getStudentID());
            rs = pste.executeQuery();
            return !rs.next();
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error validatePerson", e);
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

    public boolean delete(long id){
        try{
            conn = new MySQLConnection().connect();
            pste = conn.prepareStatement("DELETE FROM users WHERE id=?");
            pste.setLong(1, id);
            return pste.executeUpdate() == 1;
        }catch (SQLException e){
            Logger.getLogger(DaoPerson.class.getName()).log(Level.SEVERE, "Error deletePerson", e);
        }finally {
            closeConnection();
        }
        return false;
    }
}
