package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL =
        "jdbc:mysql://localhost:3306/SegurosGroup?useSSL=false&useUnicode=true&characterEncoding=UTF-8";
    private static final String USER = "root";   
    private static final String PASS = "root";
    
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver"); // 
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("No se encontró el driver MySQL 5.1.47", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}
