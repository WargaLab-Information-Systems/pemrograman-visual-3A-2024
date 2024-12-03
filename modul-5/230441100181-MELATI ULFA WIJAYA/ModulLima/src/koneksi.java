/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Lenovo
 */

public class koneksi {
    private static java.sql.Connection koneksi;
    public static java.sql.Connection getKoneksi(){
        try{
            String url = "jdbc:mysql://localhost:3306/db_pekerja";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi Berhasil");
        }catch(Exception e){
            System.err.println("Koneksi Gagal " + e.getMessage());
        }
        return koneksi;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getKoneksi();
    }
}
//modul5pemvis