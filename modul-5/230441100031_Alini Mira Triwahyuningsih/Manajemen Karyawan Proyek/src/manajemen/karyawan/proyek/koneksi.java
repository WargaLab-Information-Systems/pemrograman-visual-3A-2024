/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package manajemen.karyawan.proyek;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLDataException;

/**
 *
 * @author LENOVO V13 HENDRIK
 */
public class koneksi {
    
    private static java.sql.Connection koneksi;
    static java.sql.Connection getKoneksi(){
        try {
            String url = "jdbc:mysql://localhost:3306/db_manajemenkaryawanproyek";
            String user = "root";
            String pass ="";
            
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            koneksi = DriverManager.getConnection(url, user, pass);
            System.out.println("Koneksi berhasil");
        }catch(Exception e){
            System.err.println("Koneksi gagal" + e.getMessage());
        }
        return koneksi;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        getKoneksi();
    
    }
    
}
