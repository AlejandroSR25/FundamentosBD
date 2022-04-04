package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    
    static private Conexion conexion = null;
    
    private Conexion(){
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/vacunas_hospital", "root", "admin");
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }        
    }
    
    static public Conexion getConexion(){
        if (conexion == null) {
             conexion = new Conexion();
         }
         return conexion;
    }
    
    public Connection getConnection(){
        return con;
    }
    
  }
