/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modul5;

import java.sql.DriverManager;
//import java.sql.Connection;
//import java.sql.SQLDataException;
/**
 *
 * @author HP VICTUS
 */
public class Koneksi {
    private static java.sql.Connection Koneksi;
    public static java.sql.Connection getKoneksi(){
        try{
            String url = "jdbc:mysql://localhost:3306/db_mahasiswa";
            String user = "root";
            String pass = "";
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Koneksi = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil");
        }catch(Exception e){
            System.out.println("Koneksi gagal "+e.getMessage());
        }
        return Koneksi;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        getKoneksi();
        // TODO code application logic here
    }
    
}
