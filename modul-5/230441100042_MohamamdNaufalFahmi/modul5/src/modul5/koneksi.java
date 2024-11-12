/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package modul5;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author THINKPAD
 */
public class koneksi {
     private static java.sql.Connection koneksi;
    
    public static java.sql.Connection getKoneksi(){
            try{
                String url = "jdbc:mysql://localhost:3306/db_manajemen";
                String user = "root";
                String password = "";
                DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
                koneksi = DriverManager.getConnection(url, user, password);
                JOptionPane.showMessageDialog(null, "Koneksi Berhasil!");
                System.out.println("Terkoneksi BOSS");
            }catch (SQLException e){
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.err.println("Gagal wakk : " + e.getMessage());
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
