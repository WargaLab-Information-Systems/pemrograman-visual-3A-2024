
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class connection {
    private static final String URL = "jdbc:mysql://localhost:3306/pemvis_modul_lima";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Database nya udh terkoneksi");
        } catch (SQLException e) {
            System.out.println("error : " + e.getMessage());
        }
        return conn;
    }
    
    public static void main(String[] args) {
        getConnection();
    }
}
