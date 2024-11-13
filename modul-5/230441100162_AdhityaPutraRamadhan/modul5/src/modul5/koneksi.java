package modul5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author sadewa
 */
public class koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/manajemen";
    private static final String USER = "root";
    private static final String PASS = "";
    
    private static Connection conn = null;


    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER, PASS);
                JOptionPane.showMessageDialog(null, "Koneksi Berhasil!");
                System.out.println("terkoneksi");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Koneksi Gagal! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("error bang : " + e.getMessage());
            }
        }
        return conn;
    }

    public static void tutupkoneksiConnection() {
        if (conn != null) {
            try {
                conn.close();
                JOptionPane.showMessageDialog(null, "Koneksi Ditutup");
                System.out.println("Koneksi berhasil ditutup.");
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Gagal Menutup Koneksi! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                System.out.println("saat menutup mengalami eror : " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        getConnection();  
        tutupkoneksiConnection();
    }
}