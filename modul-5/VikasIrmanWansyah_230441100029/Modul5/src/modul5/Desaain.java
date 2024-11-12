/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;
import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Desaain extends javax.swing.JFrame {
     int row1 = 0;


    /**
     * Creates new form Desaain
     */
    public Desaain() { 
    initComponents();
    loadDataKaryawan();
    loadDataProyek();
    loadDatacomboBoxKaryawanProyek();
    loadDataTransaksi();
    
    }
   private void loadDataKaryawan(){
    DefaultTableModel model = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
       };
        model.addColumn("ID");
        model.addColumn("Nama ");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");
        try {
            String sql = "select * from karyawan";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow(
                        new Object[]{
                            res.getString("id"),
                            res.getString("nama"),
                            res.getString("jabatan"),
                            res.getString("departemen"),   
                    }
                );
            }
            tbl_karyawan.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void loadDataProyek(){
    DefaultTableModel model = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
       };
        model.addColumn("Id");
        model.addColumn("Nama Proyek");
        model.addColumn("Durasi");
        try { 
            String sql = "select * from proyek";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow(
                        new Object[]{
                            res.getString("id"),
                            res.getString("nama_proyek"),
                            res.getString("durasi_pekerjaan"),
                        }
                    );
                }
            tbl_proyek.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void loadDatacomboBoxKaryawanProyek(){
        try {
            jComboBoxNamaKaryawanTransaksi.removeAllItems();
            jComboBoxNamaProyekTransaksi.removeAllItems();
            String sql = "select * from karyawan";
            String sql1 = "select * from proyek";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            java.sql.Statement stm1 = conn.createStatement();
            java.sql.ResultSet res1 = stm1.executeQuery(sql1);
          
            while (res.next()){
                String namaKaryawan = res.getString("nama");
                String idKaryawan = res.getString("id");
                jComboBoxNamaKaryawanTransaksi.addItem(namaKaryawan);
            }
            while (res1.next()){
                String namaProyek = res1.getString("nama_proyek");
                jComboBoxNamaProyekTransaksi.addItem(namaProyek);
                String idProyek = res1.getString("id");
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void loadDataTransaksi(){
    DefaultTableModel model = new DefaultTableModel() {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
       };
        model.addColumn("Karyawan");
        model.addColumn("Proyek");
        model.addColumn("Peran");
        try {
            String sql = "SELECT karyawan.nama AS nama_karyawan, proyek.nama_proyek AS nama_proyek, peran FROM transaksi JOIN karyawan ON transaksi.id_karyawan = karyawan.id JOIN proyek ON transaksi.id_proyek = proyek.id;";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow(
                        new Object[]{            
                            res.getString("nama_karyawan"),
                            res.getString("nama_proyek"),
                            res.getString("peran")
                            }
                        );
                    }
            tbl_transaksi.setModel(model);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void Kosong() {
        id_karyawan.setText("");
        nama_karyawan.setText("");
        jabatan_karyawan.setText("");
        departemen_karyawan.setText("");
        id_proyek.setText("");
        nama_proyek.setText("");
        durasi_pekerjaan.setText("");
        jComboBoxNamaKaryawanTransaksi.setSelectedIndex(0);
        jComboBoxNamaProyekTransaksi.setSelectedIndex(0);
        pesanperan.setText("");
    }
    
    // ======================================== BUTTON KARYAWAN ========================================
    
    private void saveKaryawan() {                                 
      try {
        if (nama_karyawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama karyawan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            nama_karyawan.requestFocus();
            return;
        }
        if (jabatan_karyawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Jabatan karyawan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            jabatan_karyawan.requestFocus();
            return;
        }
        if (departemen_karyawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Departemen karyawan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            departemen_karyawan.requestFocus();
            return;
          }
          if(!nama_karyawan.getText().matches("[a-zA-Z ]+") ||
            !jabatan_karyawan.getText().matches("[a-zA-Z ]+") ||
            !departemen_karyawan.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "harus menggunakan huruf");
            return;
        }
          String sql = "insert into karyawan (nama, jabatan, departemen) values (?, ?, ?)";
          java.sql.Connection conn = (Connection) koneksi.getConnection();
          java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, nama_karyawan.getText());
                pst.setString(2, jabatan_karyawan.getText());
                pst.setString(3, departemen_karyawan.getText());
                pst.execute();
                JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            loadDataKaryawan();
            loadDatacomboBoxKaryawanProyek();
            Kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }   
    private void deleteKaryawan() {                                        
        try {
            String id = id_karyawan.getText();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID belum dipilih. Silakan pilih data terlebih dahulu");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM karyawan WHERE ID = ?";
                    java.sql.Connection conn = (Connection) koneksi.getConnection();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    loadDataKaryawan();
                    loadDatacomboBoxKaryawanProyek();
                    Kosong();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void updateKaryawan() {                                       
        try {
            if (nama_karyawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama karyawan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            nama_karyawan.requestFocus();
            return;
        }
            if (jabatan_karyawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Jabatan karyawan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            jabatan_karyawan.requestFocus();
            return;
        }
             if (departemen_karyawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Departemen karyawan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            departemen_karyawan.requestFocus();
            return;
        }
            if (id_karyawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ID karyawan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            id_karyawan.requestFocus();
            return;
        }
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "UPDATE karyawan SET Nama = ?, jabatan = ?, departemen = ? WHERE Id = ?";
            java.sql.Connection conn = koneksi.getConnection(); 
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

                pst.setString(1, nama_karyawan.getText());
                pst.setString(2, jabatan_karyawan.getText());
                pst.setString(3, departemen_karyawan.getText());
                pst.setString(4, id_karyawan.getText());

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

                loadDataKaryawan(); 
                Kosong();   
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void ResetKaryawan() {
        id_karyawan.setText("");
        nama_karyawan.setText("");
        jabatan_karyawan.setText("");
        departemen_karyawan.setText("");
    }
    
 // ======================================== BUTTON PROYEK ========================================
  
    private void saveProyek() {
    try {
        if (nama_proyek.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nama proyek tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            nama_proyek.requestFocus();
            return;
        }
        if (durasi_pekerjaan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Durasi pekerjaan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
            durasi_pekerjaan.requestFocus();
            return;
        }
          if (!nama_proyek.getText().matches("[a-zA-Z ]+")) {
            JOptionPane.showMessageDialog(null, "Nama Proyek hanya boleh mengandung huruf ");
            return;
        }
          if (!durasi_pekerjaan.getText().matches("[0-9]+")) {
            JOptionPane.showMessageDialog(null, "Durasi Pekerjaan hanya boleh mengandung angka");
            return;
        }
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pekerjaan) VALUES (?, ?)";
        java.sql.Connection conn = (Connection) koneksi.getConnection();
        java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, nama_proyek.getText());
                pst.setString(2, durasi_pekerjaan.getText() + " hari");
        pst.execute();
        JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
        loadDataProyek();
        loadDatacomboBoxKaryawanProyek();
        Kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void deleteProyek() {                                        
        try {
            String id = id_proyek.getText();

            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID belum dipilih. Silakan pilih data terlebih dahulu");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM proyek WHERE ID = ?";
                    java.sql.Connection conn = (Connection) koneksi.getConnection();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, id);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    loadDataProyek();
                    loadDatacomboBoxKaryawanProyek();
                    Kosong();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }  
    }
    private void updateproyek() {
        try {
            if (nama_proyek.getText().isEmpty()) {
                 JOptionPane.showMessageDialog(null, "Nama proyek tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
                 nama_proyek.requestFocus();
                return;
            }
            if (durasi_pekerjaan.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Durasi pekerjaan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
                durasi_pekerjaan.requestFocus();
                return;
        }
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                 String namaProyek = nama_proyek.getText();
                 String durasi = durasi_pekerjaan.getText();
            if (namaProyek.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama Proyek tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            if (durasi.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Durasi Pekerjaan tidak boleh kosong", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (!durasi.trim().matches("\\d+")) { 
                JOptionPane.showMessageDialog(null, "Durasi Pekerjaan harus berupa angka saja");
                return;
            }
            String durasiDenganHari = durasi + " hari";
            String sql = "UPDATE proyek SET Nama_Proyek = ?, Durasi_Pekerjaan = ? WHERE Id = ?";
            java.sql.Connection conn = koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, nama_proyek.getText());
            pst.setString(2, durasiDenganHari);
            pst.setString(3, id_proyek.getText());

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            
            loadDatacomboBoxKaryawanProyek();
            loadDataProyek();
            Kosong();
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    private void RisetProyek() {
        id_proyek.setText("");
        nama_proyek.setText("");
        durasi_pekerjaan.setText("");
    }

     // ======================================== BUTTON TRANSAKSI ========================================
    
    private void saveTransaksi(){
        int idKaryawan = jComboBoxNamaKaryawanTransaksi.getSelectedIndex()+1;
        int idProyek = jComboBoxNamaProyekTransaksi.getSelectedIndex()+1;
        int id_proyek = 0;
        int id_karyawan = 0;
        
        if (pesanperan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;  
    }
        try{
            
            String sql = "select id from karyawan ;";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            int ulang = 1;
            while (res.next()){
                if(ulang == idKaryawan){
                    id_karyawan = res.getInt("id");
                }
                ulang++;
            }  
            ulang = 1;
            String sql1 = "select id from proyek; ";
            java.sql.Statement stm1 = conn.createStatement();
            java.sql.ResultSet res1 = stm1.executeQuery(sql1);
             while (res1.next()){
                if(ulang == idProyek){
                    id_proyek = res1.getInt("id");
                }
                ulang++;
            }  
            String peran = pesanperan.getText();
                if (peran == null || peran.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Peran diisi terlebih dahulu");
                    return; 
            }
            String addTransaksi = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(addTransaksi);
            ps.setInt(1, id_karyawan);
            ps.setInt(2, id_proyek);
            ps.setString(3, pesanperan.getText());
            ps.executeUpdate();
            loadDataTransaksi();
            Kosong();
        } catch (SQLException e) {
          System.out.println("Error Save Data Transaksi" + e.getMessage());
        }
    }
    private void deleteTransaksi() {
        int id_proyek = 0;
        int id_karyawan = 0;
        try{
            int ulang = 1;
            String sql2 = "select id_karyawan, id_proyek from transaksi";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.Statement stm2 = conn.createStatement();
            java.sql.ResultSet res2 = stm2.executeQuery(sql2);
            int row2 = row1 + 1;
            while (res2.next()){
                if(ulang == row1+1){
                System.out.println("warr");
                int idKaryawanTransaksi = res2.getInt("id_karyawan");
                int idProyekTransaksi = res2.getInt("id_proyek");
                System.out.println("ini row ke " + row2);
                System.out.println(res2.getInt("id_karyawan"));
                System.out.println(res2.getInt("id_proyek"));
                String addTransaksi = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?;";
                System.out.println("duarrr156234");
                PreparedStatement ps = conn.prepareStatement(addTransaksi);
                ps.setInt(1, idKaryawanTransaksi);
                ps.setInt(2, idProyekTransaksi);
                ps.executeUpdate();
                loadDataTransaksi();
                System.out.println("berhasil");
            }ulang++;  }
            Kosong();
        } catch (SQLException e) {
          System.out.println("Error Save Data Transaksi" + e.getMessage());
        }
}
    private void updateTransaksi() {
        int idKaryawan = jComboBoxNamaKaryawanTransaksi.getSelectedIndex()+1;
        int idProyek = jComboBoxNamaProyekTransaksi.getSelectedIndex()+1;
        int id_proyek = 0;
        int id_karyawan = 0;
        
        if (pesanperan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;  
    }
        try{
            String sql = "select * from karyawan ";
            java.sql.Connection conn = (Connection) koneksi.getConnection();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            int ulang = 1;
            while (res.next()){
                if(ulang == idKaryawan){
                    id_karyawan = res.getInt("id");
                   
                }
                ulang++;
            }  
            ulang = 1;
            String sql1 = "select * from proyek ";
            java.sql.Statement stm1 = conn.createStatement();
            java.sql.ResultSet res1 = stm1.executeQuery(sql1);
            while (res1.next()){
                if(ulang == idProyek){
                   
                    id_proyek = res1.getInt("id");
                }
                ulang++;
            }  
            ulang = 1;
            String sql2 = "select id_karyawan, id_proyek from transaksi";
            java.sql.Statement stm2 = conn.createStatement();
            java.sql.ResultSet res2 = stm2.executeQuery(sql2);
            int row2 = row1 + 1;
            while (res2.next()){
                if(ulang == row1+1){
                
                int idKaryawanTransaksi = res2.getInt("id_karyawan");
                int idProyekTransaksi = res2.getInt("id_proyek");
                
               
                String addTransaksi = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_karyawan = ? AND id_proyek = ?;";
                PreparedStatement ps = conn.prepareStatement(addTransaksi);
                ps.setInt(1, id_karyawan);
                ps.setInt(2, id_proyek);
                ps.setString(3, pesanperan.getText());
                ps.setInt(4, idKaryawanTransaksi);
                ps.setInt(5, idProyekTransaksi);
                ps.executeUpdate();
                loadDataTransaksi();
                System.out.println("berhasil");
            }ulang++;  }
            Kosong();
        } catch (SQLException e) {
          System.out.println("Error Save Data Transaksi" + e.getMessage());
        } 
    }
    private void RisetTransaki() {
        pesanperan.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Atas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Tengah = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        karyawan = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        id_karyawan = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        departemen_karyawan = new javax.swing.JTextField();
        jabatan_karyawan = new javax.swing.JTextField();
        nama_karyawan = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        btnsaveKaryawan = new javax.swing.JButton();
        btnupdateKaryawan = new javax.swing.JButton();
        btndeleteKaryawan = new javax.swing.JButton();
        btnrisetKaryawan1 = new javax.swing.JButton();
        proyek = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        id_proyek = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        durasi_pekerjaan = new javax.swing.JTextField();
        nama_proyek = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        btnsaveproyek = new javax.swing.JButton();
        btnupdateproyek = new javax.swing.JButton();
        btndeleteproyek = new javax.swing.JButton();
        btndeleteproyek1 = new javax.swing.JButton();
        transaksi = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        pesanperan = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        btnsaveT = new javax.swing.JButton();
        btnupdateT = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jComboBoxNamaProyekTransaksi = new javax.swing.JComboBox<>();
        jComboBoxNamaKaryawanTransaksi = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximizedBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setMinimumSize(new java.awt.Dimension(574, 728));

        Atas.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\gambar3.png")); // NOI18N
        Atas.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("APLIKASI MANAJEMEN");
        Atas.add(jLabel2);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\User\\Documents\\gambar2.png")); // NOI18N
        Atas.add(jLabel3);

        getContentPane().add(Atas, java.awt.BorderLayout.PAGE_START);

        Tengah.setBackground(new java.awt.Color(153, 153, 153));

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        karyawan.setBackground(new java.awt.Color(204, 204, 204));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel9.setText("KARYAWAN");
        jPanel2.add(jLabel9);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel6.setText("ID ");

        id_karyawan.setRequestFocusEnabled(false);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel10.setText("NAMA");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel11.setText("DEPARTEMEN");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel12.setText("JABATAN");

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

        btnsaveKaryawan.setText("SAVE");
        btnsaveKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveKaryawanActionPerformed(evt);
            }
        });

        btnupdateKaryawan.setText("UPDATE");
        btnupdateKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateKaryawanActionPerformed(evt);
            }
        });

        btndeleteKaryawan.setText("DELETE");
        btndeleteKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteKaryawanActionPerformed(evt);
            }
        });

        btnrisetKaryawan1.setText("RESET");
        btnrisetKaryawan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnrisetKaryawan1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout karyawanLayout = new javax.swing.GroupLayout(karyawan);
        karyawan.setLayout(karyawanLayout);
        karyawanLayout.setHorizontalGroup(
            karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(karyawanLayout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(karyawanLayout.createSequentialGroup()
                        .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nama_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(83, 83, 83))
                    .addGroup(karyawanLayout.createSequentialGroup()
                        .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel11))
                        .addGap(27, 27, 27)
                        .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(departemen_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jabatan_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, karyawanLayout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(karyawanLayout.createSequentialGroup()
                        .addComponent(btnsaveKaryawan)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdateKaryawan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btndeleteKaryawan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnrisetKaryawan1)))
                .addGap(19, 19, 19))
        );
        karyawanLayout.setVerticalGroup(
            karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(karyawanLayout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(id_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(nama_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jabatan_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(departemen_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(karyawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsaveKaryawan)
                    .addComponent(btnupdateKaryawan)
                    .addComponent(btndeleteKaryawan)
                    .addComponent(btnrisetKaryawan1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Karyawan", karyawan);

        proyek.setBackground(new java.awt.Color(204, 204, 204));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("PROYEK");
        jPanel4.add(jLabel13);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel14.setText("ID");

        id_proyek.setRequestFocusEnabled(false);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel15.setText("NAMA PROYEK");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel16.setText("DURASI PEKERJAAN");

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbl_proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_proyekMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_proyek);

        btnsaveproyek.setText("SAVE");
        btnsaveproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveproyekActionPerformed(evt);
            }
        });

        btnupdateproyek.setText("UPDATE");
        btnupdateproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateproyekActionPerformed(evt);
            }
        });

        btndeleteproyek.setText("DELETE");
        btndeleteproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteproyekActionPerformed(evt);
            }
        });

        btndeleteproyek1.setText("RESET");
        btndeleteproyek1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteproyek1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout proyekLayout = new javax.swing.GroupLayout(proyek);
        proyek.setLayout(proyekLayout);
        proyekLayout.setHorizontalGroup(
            proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(proyekLayout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(proyekLayout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proyekLayout.createSequentialGroup()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, proyekLayout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(18, 18, 18)
                        .addComponent(durasi_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, proyekLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(proyekLayout.createSequentialGroup()
                        .addComponent(btnsaveproyek)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdateproyek)
                        .addGap(18, 18, 18)
                        .addComponent(btndeleteproyek)
                        .addGap(18, 18, 18)
                        .addComponent(btndeleteproyek1))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        proyekLayout.setVerticalGroup(
            proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proyekLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(id_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(nama_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(durasi_pekerjaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 342, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(proyekLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsaveproyek)
                    .addComponent(btnupdateproyek)
                    .addComponent(btndeleteproyek)
                    .addComponent(btndeleteproyek1))
                .addGap(24, 24, 24))
        );

        jTabbedPane1.addTab("Proyek", proyek);

        transaksi.setBackground(new java.awt.Color(204, 204, 204));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel4.setText("TRANSAKSI");
        jPanel1.add(jLabel4);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel5.setText("NAMA KARYAWAN");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel7.setText("NAMA PROYEK");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N
        jLabel8.setText("PERAN");

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_transaksi);

        btnsaveT.setText("SAVE");
        btnsaveT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsaveTActionPerformed(evt);
            }
        });

        btnupdateT.setText("UPDATE");
        btnupdateT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateTActionPerformed(evt);
            }
        });

        jButton3.setText("DELETE");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("RESET");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout transaksiLayout = new javax.swing.GroupLayout(transaksi);
        transaksi.setLayout(transaksiLayout);
        transaksiLayout.setHorizontalGroup(
            transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(transaksiLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(jLabel5))
                .addGap(32, 32, 32)
                .addGroup(transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pesanperan)
                    .addComponent(jComboBoxNamaProyekTransaksi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComboBoxNamaKaryawanTransaksi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(transaksiLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, transaksiLayout.createSequentialGroup()
                        .addComponent(btnsaveT)
                        .addGap(18, 18, 18)
                        .addComponent(btnupdateT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton4)
                        .addGap(130, 130, 130))))
        );
        transaksiLayout.setVerticalGroup(
            transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNamaKaryawanTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBoxNamaProyekTransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesanperan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 314, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(transaksiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnsaveT)
                    .addComponent(btnupdateT)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("     Transaksi         ", transaksi);

        javax.swing.GroupLayout TengahLayout = new javax.swing.GroupLayout(Tengah);
        Tengah.setLayout(TengahLayout);
        TengahLayout.setHorizontalGroup(
            TengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        TengahLayout.setVerticalGroup(
            TengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        getContentPane().add(Tengah, java.awt.BorderLayout.CENTER);

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jButton5.setText("KELUAR");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(454, Short.MAX_VALUE)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnupdateproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateproyekActionPerformed
        // TODO add your handling code here:
        updateproyek();
    }//GEN-LAST:event_btnupdateproyekActionPerformed

    private void btnsaveproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveproyekActionPerformed
        // TODO add your handling code here:
        saveProyek();
    }//GEN-LAST:event_btnsaveproyekActionPerformed

    private void btnsaveKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveKaryawanActionPerformed
        // TODO add your handling code here:
        saveKaryawan();
    }//GEN-LAST:event_btnsaveKaryawanActionPerformed

    private void btndeleteKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteKaryawanActionPerformed
        // TODO add your handling code here:
        deleteKaryawan();
    }//GEN-LAST:event_btndeleteKaryawanActionPerformed

    private void btnupdateKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateKaryawanActionPerformed
        // TODO add your handling code here:
        updateKaryawan();
    }//GEN-LAST:event_btnupdateKaryawanActionPerformed

    private void tbl_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proyekMouseClicked
        // TODO add your handling code here:
        int row = tbl_proyek.getSelectedRow(); 
        
        if (row != -1) {
            id_proyek.setText(tbl_proyek.getValueAt(row, 0).toString());
            nama_proyek.setText(tbl_proyek.getValueAt(row, 1).toString());
            durasi_pekerjaan.setText(tbl_proyek.getValueAt(row, 2).toString()); 
        }
    }//GEN-LAST:event_tbl_proyekMouseClicked

    private void btndeleteproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteproyekActionPerformed
        // TODO add your handling code here:
        deleteProyek();
    }//GEN-LAST:event_btndeleteproyekActionPerformed

    private void btnsaveTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsaveTActionPerformed
        // TODO add your handling code here:
        saveTransaksi();

    }//GEN-LAST:event_btnsaveTActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // TODO add your handling code here:
        row1 = tbl_transaksi.getSelectedRow(); 
        
        if (row1 != -1) {
             jComboBoxNamaKaryawanTransaksi.setSelectedItem(tbl_transaksi.getValueAt(row1, 0).toString());
             jComboBoxNamaProyekTransaksi.setSelectedItem(tbl_transaksi.getValueAt(row1, 1).toString());
             pesanperan.setText(tbl_transaksi.getValueAt(row1, 2).toString()); 
        }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteTransaksi();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnupdateTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateTActionPerformed
        // TODO add your handling code here:
        updateTransaksi();
    }//GEN-LAST:event_btnupdateTActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnrisetKaryawan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnrisetKaryawan1ActionPerformed
        // TODO add your handling code here:
        ResetKaryawan();
    }//GEN-LAST:event_btnrisetKaryawan1ActionPerformed

    private void btndeleteproyek1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteproyek1ActionPerformed
        // TODO add your handling code here:
        RisetProyek();
        
    }//GEN-LAST:event_btndeleteproyek1ActionPerformed

    private void tbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_karyawanMouseClicked
        // TODO add your handling code here:
        int row = tbl_karyawan.getSelectedRow();

        if (row != -1) {
            id_karyawan.setText(tbl_karyawan.getValueAt(row, 0).toString());
            nama_karyawan.setText(tbl_karyawan.getValueAt(row, 1).toString());
            jabatan_karyawan.setText(tbl_karyawan.getValueAt(row, 2).toString());
            departemen_karyawan.setText(tbl_karyawan.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_tbl_karyawanMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        RisetTransaki();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());
            UIManager.put( "Button.arc", 50 );
        } catch (Exception e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Desaain().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Atas;
    private javax.swing.JPanel Tengah;
    private javax.swing.JButton btndeleteKaryawan;
    private javax.swing.JButton btndeleteproyek;
    private javax.swing.JButton btndeleteproyek1;
    private javax.swing.JButton btnrisetKaryawan1;
    private javax.swing.JButton btnsaveKaryawan;
    private javax.swing.JButton btnsaveT;
    private javax.swing.JButton btnsaveproyek;
    private javax.swing.JButton btnupdateKaryawan;
    private javax.swing.JButton btnupdateT;
    private javax.swing.JButton btnupdateproyek;
    private javax.swing.JTextField departemen_karyawan;
    private javax.swing.JTextField durasi_pekerjaan;
    private javax.swing.JTextField id_karyawan;
    private javax.swing.JTextField id_proyek;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBoxNamaKaryawanTransaksi;
    private javax.swing.JComboBox<String> jComboBoxNamaProyekTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jabatan_karyawan;
    private javax.swing.JPanel karyawan;
    private javax.swing.JTextField nama_karyawan;
    private javax.swing.JTextField nama_proyek;
    private javax.swing.JTextField pesanperan;
    private javax.swing.JPanel proyek;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JPanel transaksi;
    // End of variables declaration//GEN-END:variables

   
}
