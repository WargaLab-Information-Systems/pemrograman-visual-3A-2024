/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5Lagi;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Font;
import javax.swing.UIManager;
import raven.popup.GlassPanePopup;
//-----------------------------------------
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import raven.alerts.MessageAlerts;
import raven.popup.component.PopupCallbackAction;
import raven.popup.component.PopupController;

/**
 *
 * @author Erlangga Satrya H
 */
public class tugasModul5 extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
    /**
     * Creates new form tugasModul5
     */
    String namaKaryawan,namaProyek;
    public tugasModul5() {
        
        
        
        GlassPanePopup.install(this);
        initComponents();
        conn = koneksi.getConnection();
        
    // Tabel Start---------------------------------------------------
    
    // Model Tabel Karyawan
        modelKaryawan = new DefaultTableModel();
        tbl_karyawan.setModel(modelKaryawan);
        modelKaryawan.addColumn("ID Karyawan");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");

    // Model tabel Proyek
        modelProyek = new DefaultTableModel();
        tbl_proyek.setModel(modelProyek);
        modelProyek.addColumn("ID Proyek");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi (Minggu)");
    
    // Model tabel Transaksi Proyek
        modelTransaksi = new DefaultTableModel();
        tbl_transaksi.setModel(modelTransaksi);
        modelTransaksi.addColumn("Nama Karyawan");
        modelTransaksi.addColumn("Nama Proyek");
        modelTransaksi.addColumn("Nama Peran");
        
        TampilKaryawan();
        TampilProyek();
        TampilTransaksi();
        loadComboBoxData();
    }
    //Tabel End---------------------------------------------------------

    
    
    
    
//    ===========================PEMBATASSSSSSSSSSS==========================
    
    
    
 
    // Start CRUD TABEL KARYAWAN--------------------------------------------------
    // Read    
      private void TampilKaryawan() {
      modelKaryawan.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modelKaryawan.addRow(new Object[]{
             rs.getInt("id_karyawan"),
             rs.getString("nama"),
             rs.getString("jabatan"),
             rs.getString("departemen")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    // Tambah
    private void TambahKaryawan() {
        
        // Validasi Input Nama Karyawan
        if(KaryawanField.getText().trim().isEmpty()) {
           MessageAlerts.getInstance().showMessage("Peringatan", "Nama Karyawan tidak boleh kosong!", MessageAlerts.MessageType.WARNING);
           return; //Menghentikan eksekusi jika input kosong
        }
        
        // Validasi Input Jabatan
        String jabatan = cmbJabatan.getSelectedItem().toString();
        if(jabatan.equals("--Pilih Jabatan--")) {
           MessageAlerts.getInstance().showMessage("Peringatan", "Jabatan tidak boleh kosong!", MessageAlerts.MessageType.WARNING);
           return; //Menghentikan eksekusi jika input kosong
        }
        
        // Validasi Input Departemen
        if(DepartemenField.getText().trim().isEmpty()) {
           MessageAlerts.getInstance().showMessage("Peringatan", "Departemen tidak boleh kosong!", MessageAlerts.MessageType.WARNING);
           return; //Menghentikan eksekusi jika input kosong
        }
        
        
        
        
        
        try{
            String sql = "INSERT INTO karyawan (nama, jabatan,departemen) VALUES (?, ?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, KaryawanField.getText());
            ps.setString(2, cmbJabatan.getSelectedItem().toString());
        
            ps.setString(3, DepartemenField.getText());
            ps.executeUpdate();
            
            MessageAlerts.getInstance().showMessage("Sukses Menyimpan Data", "Data berhasil dimasukkan ke dalam Tabel Karyawan.",MessageAlerts.MessageType.SUCCESS);
//            JOptionPane.showMessageDialog(this, "Data saved successfully");
            TampilKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    // Edit
    private void EditKaryawan() {
        try {
            
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                
     
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen=? WHERE id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, KaryawanField.getText());
            ps.setString(2, cmbJabatan.getSelectedItem().toString());
            ps.setString(3, DepartemenField.getText());
            ps.setInt(4, Integer.parseInt(idKaryawan.getText()));
            ps.executeUpdate();
            MessageAlerts.getInstance().showMessage("Sukses Memperbarui Data", "Informasi karyawan berhasil diperbarui. Semua perubahan telah tersimpan..",MessageAlerts.MessageType.SUCCESS);
            TampilKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData();
        }
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    // Hapus
    private void HapusKaryawan() {
        try  {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mmenghapus data ini?", "Hapus Data Karyawan?", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
            
            String sql = "DELETE FROM karyawan WHERE id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idKaryawan.getText()));
            ps.executeUpdate();
            MessageAlerts.getInstance().showMessage("Sukses Menghapus Data", "Data karyawan yang dipilih berhasil dihapus dari sistem.",MessageAlerts.MessageType.SUCCESS);
//            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            TampilKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData();
            }
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    // End CRUD TABEL KARYAWAN--------------------------------------------------
    
    //==============================PEMBATAS TABEL-------------------------------    
    
    // Start CRUD TABEL PROYEK--------------------------------------------------
    
    // Read  
      private void TampilProyek() {
      modelProyek.setRowCount(0);
      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modelProyek.addRow(new Object[]{
             rs.getInt("id_proyek"),
             rs.getString("nama_proyek"),
             rs.getString("durasi_pengerjaan"),
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    //Tambah
    private void TambahProyek() {
        
        // Validasi Input Nama Proyek
        if(ProyekField.getText().trim().isEmpty()) {
           MessageAlerts.getInstance().showMessage("Peringatan", "Nama Proyek tidak boleh kosong!", MessageAlerts.MessageType.WARNING);
           return; //Menghentikan eksekusi jika input kosong
        }
        
        // Validasi Input Durasi
        if(DurasiField.getText().trim().isEmpty()) {
           MessageAlerts.getInstance().showMessage("Peringatan", "Durasi tidak boleh kosong!", MessageAlerts.MessageType.WARNING);
           return; //Menghentikan eksekusi jika input kosong
        }
        
        // Memastikan input durasi angka
        try{
            Integer.parseInt(DurasiField.getText().trim());
        } catch (NumberFormatException e) {
            MessageAlerts.getInstance().showMessage("Inputan harus berupa angka", "untuk durasi wajib masukkan angka!",MessageAlerts.MessageType.WARNING);
            return; //Menghentikan eksekusi jika input bukan angka
        }
        
        try{
            String minggu = DurasiField.getText()+ " minggu";
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ProyekField.getText());
            ps.setString(2, minggu);
            ps.executeUpdate();
            MessageAlerts.getInstance().showMessage("Sukses Menyimpan Data", "Data berhasil dimasukkan ke dalam tabel proyek.",MessageAlerts.MessageType.SUCCESS);
//            JOptionPane.showMessageDialog(this, "Data saved successfully");
            TampilProyek();
            updateComboBoxProyek();
            resetSemuaData();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    //Edit
    private void EditProyek() {
        try {
            
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
            
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, ProyekField.getText());
            ps.setString(2, DurasiField.getText());
            ps.setInt(3, Integer.parseInt(idProyek.getText()));
            ps.executeUpdate();
            MessageAlerts.getInstance().showMessage("Sukses Memperbarui Data", "Informasi Proyek berhasil diperbarui. Semua perubahan telah tersimpan..",MessageAlerts.MessageType.SUCCESS);
//            JOptionPane.showMessageDialog(this, "Data updated successfully");
            TampilProyek();
            updateComboBoxProyek();
            resetSemuaData();
            
                }
        }  catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    //Hapus
    private void HapusProyek() {
        try  {
            
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mmenghapus data ini?", "Hapus Data Proyek?", JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
            
            String sql = "DELETE FROM proyek WHERE id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idProyek.getText()));
            ps.executeUpdate();
            MessageAlerts.getInstance().showMessage("Sukses Menghapus Data", "Data proyek yang dipilih berhasil dihapus dari sistem.",MessageAlerts.MessageType.SUCCESS);
//            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            TampilProyek();
            updateComboBoxProyek();
            resetSemuaData();
            }
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    // End CRUD TABEL PROYEK--------------------------------------------------
    
    //==============================PEMBATAS TABEL-------------------------------
    
    // Start CRUD TABEL Transaksi--------------------------------------------------
    private void TampilTransaksi() {
        modelTransaksi.setRowCount(0);
        System.out.println("fff");

        try {
            String sql = "SELECT karyawan.nama AS nama_karyawan, proyek.nama_proyek AS nama_proyek, peran FROM transaksi JOIN karyawan ON transaksi.id_karyawan = karyawan.id_karyawan JOIN proyek ON transaksi.id_proyek = proyek.id_proyek;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            System.out.println("gvg");
            while (rs.next()) {
                modelTransaksi.addRow(new Object[]{
//                    rs.getInt("id_transaksi"),
                    rs.getString("nama_karyawan"),  // Corrected here as well
                    rs.getString("nama_proyek"),     // Corrected here as well
                    rs.getString("peran"),
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading Transaksi data: " + e.getMessage());
        }
    }
    
    // End CRUD TABEL Transaksi--------------------------------------------------
    
    //======================PEMBATAS==========================================
    
    //Start load data    
    // Memuat data ke ComboBox Karyawan dan Proyek
    private void loadComboBoxData() {
        try {
            String sql = "SELECT nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cmbKaryawan.removeAllItems();
            while (rs.next()) {
                cmbKaryawan.addItem(rs.getString("nama"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Karyawan: " + e.getMessage());
        }

        try {
            String sql = "SELECT nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cmbProyek.removeAllItems();
            while (rs.next()) {
                cmbProyek.addItem(rs.getString("nama_proyek"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Proyek: " + e.getMessage());
        }
    }    
    //End load data    
    
    
    //===========================PEMBATAS================================
    
//  start  CRUD Tabel TRANSAKSI
    private void saveDataTransaksi() {
        
        // Pastikan semua komponen input terisi sebelum menyimpan
        if (getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum menyimpan data transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, getSelectedKaryawanId());
            ps.setInt(2, getSelectedProyekId());
            ps.setString(3, peran.getText());
            ps.executeUpdate();
            MessageAlerts.getInstance().showMessage("Sukses Menyimpan Data", "Data berhasil dimasukkan ke dalam tabel Transaksi.",MessageAlerts.MessageType.SUCCESS);
//            JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan");
            TampilTransaksi();
        } catch (SQLException e) {
            System.out.println("Error Save Data Transaksi: " + e.getMessage());
        }
    }
    
    private void updateDataTransaksi() {
        
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
        
//        // Pastikan semua input field terisi sebelum proses update
//        if (idKaryawan.getText().isEmpty() || 
//            getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
//            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum mengedit data!", "Error", JOptionPane.ERROR_MESSAGE);;
//            return;
//        }
        
//        if (idKaryawan.getText().isEmpty() || 
//        getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
//        JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum mengedit data!", "Error", JOptionPane.ERROR_MESSAGE);;
//        return;
//        }


        try {
            int idKaryawan = getSelectedKaryawanId();
            int idProyek = getSelectedProyekId();
            String peran1 = peran.getText();
            int idKaryawan1 = getSelectedKaryawanId1();
            int idProyek2 = getSelectedProyekId1();            
            

            String sql = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, peran1);
            ps.setInt(4, idKaryawan1);
            ps.setInt(5, idProyek2);            

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                MessageAlerts.getInstance().showMessage("Sukses Memperbarui Data", "Informasi proyek berhasil diperbarui. Semua perubahan telah tersimpan..",MessageAlerts.MessageType.SUCCESS);

//                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diupdate");
                TampilTransaksi();
            } else {
                JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!");
            }
         
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Pastikan ID berformat angka!");
        } catch (SQLException e) {
            System.out.println("Error Update Data Transaksi: " + e.getMessage());
        }
        }
    }

    private void deleteDataTransaksi() {
        
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
        
//            if (idKaryawan.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(this, "ID transaksi tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
//            
//            if (idProyek.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(this, "ID transaksi tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
//                return;
//            }
            
            try {
                int idKaryawan1 = getSelectedKaryawanId1();
                int idProyek2 = getSelectedProyekId1(); 
                System.out.println(idKaryawan1);
                System.out.println(idProyek2);
                String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idKaryawan1);
                ps.setInt(2, idProyek2);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                                MessageAlerts.getInstance().showMessage("Sukses Menghapus Data", "Data Transaksi yang dipilih berhasil dihapus dari sistem.",MessageAlerts.MessageType.SUCCESS);
//                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus");
                    TampilTransaksi();
                } else {
                    JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Pastikan ID berformat angka!");
            } catch (SQLException e) {
                System.out.println("Error Delete Data Transaksi: " + e.getMessage());
            }
        }
    }    
    
    //  End  CRUD Tabel TRANSAKSI
    
    //    ================================PEMBATAS==================================
    private int getSelectedKaryawanId() {
        // Metode untuk mendapatkan ID karyawan berdasarkan ComboBox
        String karyawanName = (String) cmbKaryawan.getSelectedItem();
        try {
            String sql = "SELECT id_karyawan FROM karyawan WHERE nama = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, karyawanName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_karyawan");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Karyawan ID: " + e.getMessage());
        }
        return -1; // Kembalikan nilai negatif jika tidak ditemukan
    }
    private int getSelectedProyekId() {
        // Metode untuk mendapatkan ID proyek berdasarkan ComboBox
        String proyekName = (String) cmbProyek.getSelectedItem();
        try {
            String sql = "SELECT id_proyek FROM proyek WHERE nama_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, proyekName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_proyek");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Proyek ID: " + e.getMessage());
        }
        return -1; 
    }
//    ====================================
//    pppp
        private int getSelectedKaryawanId1() {
        // Metode untuk mendapatkan ID karyawan berdasarkan ComboBox
//        String karyawanName = (String) cmbKaryawan.getSelectedItem();
        try {
            String sql = "SELECT id_karyawan FROM karyawan WHERE nama = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaKaryawan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_karyawan");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Karyawan ID: " + e.getMessage());
        }
        return -1; // Kembalikan nilai negatif jika tidak ditemukan
    }
    private int getSelectedProyekId1() {
        // Metode untuk mendapatkan ID proyek berdasarkan ComboBox
        String proyekName = (String) cmbProyek.getSelectedItem();
        try {
            String sql = "SELECT id_proyek FROM proyek WHERE nama_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaProyek);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id_proyek");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Proyek ID: " + e.getMessage());
        }
        return -1; 
    }
    
    
    
    
    
    
    //END
    
    //====================================PEMBATAS===========================
    
    //COMBO BOX KARYAWAN
        private void updateComboBoxKaryawan() {
        cmbKaryawan.removeAllItems(); // Hapus semua item di ComboBox terlebih dahulu
        try {
            String sql = "SELECT nama FROM karyawan"; // Ambil data nama karyawan dari tabel karyawan
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmbKaryawan.addItem(rs.getString("nama")); // Tambahkan setiap nama karyawan ke ComboBox
            }
        } catch (SQLException e) {
            System.out.println("Error Update ComboBox Karyawan: " + e.getMessage());
        }
    }
    //COMBO BOX KARYAWAN
    private void updateComboBoxProyek() {
            cmbProyek.removeAllItems(); // Hapus semua item di ComboBox terlebih dahulu
            try {
                String sql = "SELECT nama_proyek FROM proyek"; // Ambil data nama proyek dari tabel proyek
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    cmbProyek.addItem(rs.getString("nama_proyek")); // Tambahkan setiap nama proyek ke ComboBox
                }
            } catch (SQLException e) {
                System.out.println("Error Update ComboBox Proyek: " + e.getMessage());
        }
    }
    
    //==========================PEMBATAS================================
    //RESET DATA    
    private void resetSemuaData() {
        // Tab Karyawan
        KaryawanField.setText("");
        cmbJabatan.setSelectedIndex(-1);
        DepartemenField.setText("");
        idKaryawan.setText("");

        // Tab Proyek
        ProyekField.setText("");
        idProyek.setText("");
        DurasiField.setText(""); // Reset tfDurasiPengerjaan

        // Tab Transaksi Proyek
        peran.setText("");
        cmbKaryawan.setSelectedIndex(-1); // Mengatur ke pilihan kosong
        cmbProyek.setSelectedIndex(-1);
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        idKaryawan = new javax.swing.JTextField();
        KaryawanField = new javax.swing.JTextField();
        DepartemenField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        cmbJabatan = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        idProyek = new javax.swing.JTextField();
        ProyekField = new javax.swing.JTextField();
        DurasiField = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        peran = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        cmbKaryawan = new javax.swing.JComboBox<>();
        cmbProyek = new javax.swing.JComboBox<>();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel12.setText("WELCOME BROOOOOOO!!!!");

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/12.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel12)
                .addGap(252, 252, 252))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 738, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(119, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 389, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jTabbedPane1.addTab("Home", new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/HOME (1).png")), jPanel1); // NOI18N

        jPanel2.setLayout(null);

        tbl_karyawan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_karyawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_karyawan);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(470, 70, 506, 478);

        idKaryawan.setEditable(false);
        jPanel2.add(idKaryawan);
        idKaryawan.setBounds(160, 70, 245, 31);

        KaryawanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KaryawanFieldActionPerformed(evt);
            }
        });
        jPanel2.add(KaryawanField);
        KaryawanField.setBounds(160, 120, 245, 31);
        jPanel2.add(DepartemenField);
        DepartemenField.setBounds(160, 220, 245, 34);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("ID");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(30, 70, 14, 20);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Nama Karyawan");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(30, 120, 100, 20);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Jabatan");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(30, 180, 60, 20);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Departemen");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(30, 230, 90, 20);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/KaryawanBIG.png"))); // NOI18N
        jPanel7.add(jLabel9);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setText("Tabel Karyawan");
        jPanel7.add(jLabel2);

        jPanel2.add(jPanel7);
        jPanel7.setBounds(0, 10, 990, 50);

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Tambah (2).png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 100, 30));

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Edit (2).png"))); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 0, 100, 30));

        jButton3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Hapus (2).png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 100, 30));

        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Reset (1).png"))); // NOI18N
        jButton10.setText("Reset");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 0, 100, 30));

        jPanel2.add(jPanel13);
        jPanel13.setBounds(0, 290, 450, 40);

        cmbJabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Jabatan--", "Manager", "Engineer", "Analyst", "Designer", "Administrator" }));
        jPanel2.add(cmbJabatan);
        cmbJabatan.setBounds(160, 172, 240, 30);

        jTabbedPane1.addTab("Karyawan", new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Karyawan.png")), jPanel2); // NOI18N

        jPanel3.setLayout(null);

        tbl_proyek.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_proyekMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_proyek);

        jPanel3.add(jScrollPane3);
        jScrollPane3.setBounds(460, 70, 506, 478);

        jLabel22.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel22.setText("ID");
        jPanel3.add(jLabel22);
        jLabel22.setBounds(30, 70, 20, 20);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Nama Proyek");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(30, 130, 90, 20);

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Durasi");
        jPanel3.add(jLabel24);
        jLabel24.setBounds(30, 190, 43, 20);

        idProyek.setEditable(false);
        jPanel3.add(idProyek);
        idProyek.setBounds(160, 70, 250, 30);

        ProyekField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProyekFieldActionPerformed(evt);
            }
        });
        jPanel3.add(ProyekField);
        ProyekField.setBounds(160, 130, 250, 30);

        DurasiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DurasiFieldActionPerformed(evt);
            }
        });
        jPanel3.add(DurasiField);
        DurasiField.setBounds(160, 190, 250, 30);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8);
        jPanel8.setBounds(20, 410, 100, 100);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/ProyekBIG.png"))); // NOI18N
        jPanel9.add(jLabel10);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel3.setText("Tabel Proyek");
        jPanel9.add(jLabel3);

        jPanel3.add(jPanel9);
        jPanel9.setBounds(0, 10, 990, 50);

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Tambah (2).png"))); // NOI18N
        jButton4.setText("Tambah");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jButton5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Edit (2).png"))); // NOI18N
        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 100, 30));

        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Hapus (2).png"))); // NOI18N
        jButton6.setText("Hapus");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 100, 30));

        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 100, 30));

        jPanel3.add(jPanel11);
        jPanel11.setBounds(10, 260, 440, 40);

        jTabbedPane1.addTab("Proyek", new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Proyek.png")), jPanel3); // NOI18N

        jPanel4.setLayout(null);

        jPanel6.setLayout(null);

        jPanel5.setLayout(null);

        tbl_transaksi.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tbl_transaksi);

        jPanel5.add(jScrollPane4);
        jScrollPane4.setBounds(440, 70, 506, 478);

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Peran");
        jPanel5.add(jLabel25);
        jLabel25.setBounds(30, 190, 50, 20);

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Nama Karyawan");
        jPanel5.add(jLabel26);
        jLabel26.setBounds(30, 90, 100, 20);

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Nama Proyek");
        jPanel5.add(jLabel27);
        jLabel27.setBounds(30, 140, 90, 20);
        jPanel5.add(peran);
        peran.setBounds(140, 190, 280, 30);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/TransaksiBIG.png"))); // NOI18N
        jPanel10.add(jLabel11);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setText("Tabel Transaksi");
        jPanel10.add(jLabel4);

        jPanel5.add(jPanel10);
        jPanel10.setBounds(0, 10, 990, 40);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Tambah (2).png"))); // NOI18N
        jButton7.setText("Tambah");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 30));

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Edit (2).png"))); // NOI18N
        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 100, 30));

        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Hapus (2).png"))); // NOI18N
        jButton9.setText("Hapus");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 0, 100, 30));

        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Reset (1).png"))); // NOI18N
        jButton12.setText("Reset");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 0, 90, 30));

        jPanel5.add(jPanel12);
        jPanel12.setBounds(10, 240, 420, 40);

        cmbKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cmbKaryawan);
        cmbKaryawan.setBounds(140, 90, 280, 30);

        cmbProyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(cmbProyek);
        cmbProyek.setBounds(140, 140, 280, 30);

        jPanel6.add(jPanel5);
        jPanel5.setBounds(0, 0, 989, 581);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(0, 0, 989, 581);

        jTabbedPane1.addTab("Transaksi", new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/Transaksi.png")), jPanel4); // NOI18N

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel21.setText("SYNERGYHUB");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5Lagi/drawer/icon/logo.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel21)
                .addGap(317, 317, 317))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        HapusProyek();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        EditProyek();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void DurasiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DurasiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DurasiFieldActionPerformed

    private void ProyekFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProyekFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ProyekFieldActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        updateDataTransaksi();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EditKaryawan();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        TambahKaryawan();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        HapusKaryawan();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_karyawanMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbl_karyawan.getSelectedRow();
        if (selectedRow != -1) { // Pastikan ada baris yang diklik
            // Mengambil data dari kolom yang relevan
            String idKaryawan = tbl_karyawan.getValueAt(selectedRow, 0).toString();
            String namaKaryawan = tbl_karyawan.getValueAt(selectedRow, 1).toString();
            String jabatan = tbl_karyawan.getValueAt(selectedRow, 2).toString();
            String Departemen = tbl_karyawan.getValueAt(selectedRow, 3).toString();
            
            this.idKaryawan.setText(idKaryawan);
            KaryawanField.setText(idKaryawan);
            KaryawanField.setText(namaKaryawan);
            DepartemenField.setText(Departemen);
            cmbJabatan.setSelectedItem(jabatan);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_karyawanMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        TambahProyek();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void tbl_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proyekMouseClicked
        // TODO add your handling code here:
        int selectedRow = tbl_proyek.getSelectedRow();
        if (selectedRow != -1) { // Pastikan ada baris yang diklik
            // Mengambil data dari kolom yang relevan
            String idProyek = tbl_proyek.getValueAt(selectedRow, 0).toString();
            String namaProyek = tbl_proyek.getValueAt(selectedRow, 1).toString();
            String durasi = tbl_proyek.getValueAt(selectedRow, 2).toString();
            
//        //Menambahkan kata "hari" pada durasi
//        durasi += "Hari";
            
            this.idProyek.setText(idProyek);
            ProyekField.setText(namaProyek);
            DurasiField.setText(durasi+ "Minggu");
            
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_proyekMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mereset kolom inputan?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
        idKaryawan.setText("");
        KaryawanField.setText("");
        cmbJabatan.setSelectedIndex(0);
        DepartemenField.setText("");
        
        }// TODO add your handling code here:
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mereset kolom inputan?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
        idProyek.setText("");
        ProyekField.setText("");
        DurasiField.setText("");
        // TODO add your handling code here:
        }
    }//GEN-LAST:event_jButton11ActionPerformed

    private void KaryawanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KaryawanFieldActionPerformed
            // TODO add your handling code here:
    }//GEN-LAST:event_KaryawanFieldActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
                // TODO add your handling code here:
        int selectedRow = tbl_transaksi.getSelectedRow();
        if (selectedRow != -1) { // Pastikan ada baris yang diklik
            // Mengambil data dari kolom yang relevan
            String peran = tbl_transaksi.getValueAt(selectedRow, 2).toString();
            namaKaryawan = tbl_transaksi.getValueAt(selectedRow, 0).toString();
            namaProyek = tbl_transaksi.getValueAt(selectedRow, 1).toString();
            
            
            this.peran.setText(peran);
            cmbKaryawan.setSelectedItem(namaKaryawan);
            cmbProyek.setSelectedItem(namaProyek);
        }

        // TODO add your handling code here:
//        int selectedRow = tbl_transaksi.getSelectedRow();
//        if (selectedRow != -1) { // Pastikan ada baris yang diklik
//            // Mengambil data dari kolom yang relevan
//            String idTransaksi = tbl_transaksi.getValueAt(selectedRow, 0).toString();
//            String namaKaryawan = tbl_transaksi.getValueAt(selectedRow, 1).toString();
//            String namaProyek = tbl_transaksi.getValueAt(selectedRow, 2).toString();
//            
//            this.idTransaksiField.setText(idTransaksi);
//            cmbKaryawan.setSelectedItem(namaKaryawan);
//            cmbProyek.setSelectedItem(namaProyek);
//        }





    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        saveDataTransaksi();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        deleteDataTransaksi();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mereset kolom inputan?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);
            
        if (confirm == JOptionPane.YES_OPTION) {
//        cmbKaryawan.
        cmbKaryawan.setSelectedIndex(0);
        cmbProyek.setSelectedIndex(0);
        peran.setText("");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton12ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.themes");
        UIManager.put("default font",new Font(FlatRobotoFont.FAMILY,Font.PLAIN,13));
        FlatMacDarkLaf.setup();
        
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tugasModul5().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField DepartemenField;
    private javax.swing.JTextField DurasiField;
    private javax.swing.JTextField KaryawanField;
    private javax.swing.JTextField ProyekField;
    private javax.swing.JComboBox<String> cmbJabatan;
    private javax.swing.JComboBox<String> cmbKaryawan;
    private javax.swing.JComboBox<String> cmbProyek;
    private javax.swing.JTextField idKaryawan;
    private javax.swing.JTextField idProyek;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField peran;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    // End of variables declaration//GEN-END:variables
}
