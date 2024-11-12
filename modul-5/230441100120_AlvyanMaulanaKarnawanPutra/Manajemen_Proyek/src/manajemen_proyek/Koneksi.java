/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manajemen_proyek;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author TOSHIBA
 */
public class Koneksi {
    private static java.sql.Connection koneksi;


    public static Connection getkoneksi() {
        try {
            String URL = "jdbc:mysql://localhost:3306/db_manajemenproyek";
            String USER = "root";
            String PASS = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(URL,USER,PASS);
            System.out.println("koneksi berhasil");
        } catch (Exception e) {
            System.out.println("error bang : " + e.getMessage());
        }
        return koneksi;
    }
    
    public static void main(String[] args) {
        getkoneksi();
    }
}
