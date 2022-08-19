package com.edu.utez.asesesoria.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
    public Connection connect(){
        try{
            final String USER = "admin",
                    PASSWORD= "Root4Ws2022",
                    DBNAME = "ofta",
                    TIMEZONE = "America/Mexico_City",
                    USESSL = "false",
                    PUBLICKEY= "true",
                    HOST ="dbs-integra-2022.crifpezkzwbz.us-east-1.rds.amazonaws.com",
                    PORT = "3306";
            String dataSource = String.format("jdbc:mysql://%s:%s/%s?user=%s&password=%s&serverTimezone=%s&useSSL=%s&allowPublicKeyRetrieval=%s",
                    HOST,PORT,DBNAME,USER,PASSWORD,TIMEZONE,USESSL,PUBLICKEY);
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            return DriverManager.getConnection(dataSource);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = new MySQLConnection().connect();
        if (conn != null){
            System.out.println("Conexion exitosa");
            conn.close();
        }else{
            System.out.println("Connexion fallida");
        }
    }
}
