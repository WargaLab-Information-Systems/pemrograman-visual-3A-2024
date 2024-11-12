/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package coba.aja;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class coba1 extends javax.swing.JFrame {
     Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
    
    public coba1() {
        initComponents();
        conn = KoneksiDB.getConnection();
        satuanDurasiComboBox.setSelectedIndex(-1);
        
          // Model tabel Karyawan
        modelKaryawan = new DefaultTableModel();
        tblKaryawan.setModel(modelKaryawan);
        modelKaryawan.addColumn("ID Karyawan");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");

        // Model tabel Proyek
        modelProyek = new DefaultTableModel();
        tblProyek.setModel(modelProyek);
        modelProyek.addColumn("ID Proyek");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi Minggu");

        // Model tabel Transaksi Proyek
        modelTransaksi = new DefaultTableModel();
        tblTransaksi.setModel(modelTransaksi);
        modelTransaksi.addColumn("ID Transaksi");
        modelTransaksi.addColumn("Nama Karyawan");
        modelTransaksi.addColumn("Nama Proyek");
        modelTransaksi.addColumn("Peran");
        

    }
 private void loadDataKaryawan() {
        modelKaryawan.setRowCount(0);
        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelKaryawan.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getString("nama_karyawan"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
            updateComboBoxKaryawan(); // Perbarui ComboBox setelah data karyawan dimuat
        } catch (SQLException e) {
            System.out.println("Error Load Data Karyawan: " + e.getMessage());
        }
    }
  private void saveDataKaryawan() {
        // Pastikan semua komponen input terisi sebelum menyimpan
        if (tfnamakaryawan.getText().isEmpty() || tfjabatan.getText().isEmpty() || tfdepartemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum menyimpan data!", "Error", JOptionPane.ERROR_MESSAGE);;
            return;
        }

        try {
            String sql = "INSERT INTO karyawan (nama_karyawan, jabatan, departemen) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfnamakaryawan.getText());
            ps.setString(2, tfjabatan.getText());
            ps.setString(3, tfdepartemen.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil disimpan");
            loadDataKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Save Data Karyawan: " + e.getMessage());
        }
    }
   private void updateDataKaryawan() {
        // Pastikan semua komponen input terisi sebelum memperbarui
        if (tfIdkaryawan.getText().isEmpty() || tfnamakaryawan.getText().isEmpty() || 
            tfjabatan.getText().isEmpty() || tfdepartemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum mengupdate data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            // Cek apakah ID karyawan ada dalam tabel
            int idKaryawan = Integer.parseInt(tfIdkaryawan.getText());
            String checkSql = "SELECT COUNT(*) FROM karyawan WHERE id_karyawan = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, idKaryawan);
            ResultSet checkRs = checkPs.executeQuery();
            checkRs.next();
            if (checkRs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "ID karyawan tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String sql = "UPDATE karyawan SET nama_karyawan = ?, jabatan = ?, departemen = ? WHERE id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tfnamakaryawan.getText());
            ps.setString(2, tfjabatan.getText());
            ps.setString(3, tfdepartemen.getText());
            ps.setInt(4, idKaryawan);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil diupdate");
            loadDataKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData(); 
        } catch (SQLException e) {
            System.out.println("Error Update Data Karyawan: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID karyawan harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   
 private void deleteDataKaryawan() {
        if (tfIdkaryawan.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID karyawan tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idKaryawan = Integer.parseInt(tfIdkaryawan.getText());

            // Cek apakah ID karyawan ada dalam tabel
            String checkSql = "SELECT COUNT(*) FROM karyawan WHERE id_karyawan = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, idKaryawan);
            ResultSet checkRs = checkPs.executeQuery();
            checkRs.next();
            if (checkRs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "ID karyawan tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            // Tampilkan dialog konfirmasi
            int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data karyawan ini?", 
                                                         "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM karyawan WHERE id_karyawan = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idKaryawan);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data karyawan berhasil dihapus");
                loadDataKaryawan();
                updateComboBoxKaryawan();
                resetSemuaData();
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data Karyawan: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID karyawan harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
//  private void loadDataProyek() {
//        modelProyek.setRowCount(0);
//        try {
//            String sql = "SELECT * FROM proyek";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                int durasi = rs.getInt("durasi_pengerjaan");
//                String satuan = rs.getString("satuan_durasi");
//                modelProyek.addRow(new Object[]{
//                    rs.getInt("id_proyek"),
//                    rs.getString("nama_proyek"),
////                    rs.getInt("durasi_pengerjaan") // Jika durasi_minggu adalah integer
//                    durasi + " " + satuan    
//                });
//            }
//        } catch (SQLException e) {
//            System.out.println("Error Load Data Proyek: " + e.getMessage());
//        }
//    }
 private void loadDataProyek() {
    // Membersihkan data pada model tabel sebelum memuat data baru
    modelProyek.setRowCount(0);
    try {
        String sql = "SELECT * FROM proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            int durasi = rs.getInt("durasi_pengerjaan");       // Mendapatkan durasi dari database
            String satuan = rs.getString("satuan_durasi");     // Mendapatkan satuan durasi dari database
            
            // Menambahkan data ke modelProyek dengan format durasi + satuan
            modelProyek.addRow(new Object[]{
                rs.getInt("id_proyek"),                          // ID proyek
                rs.getString("nama_proyek"),                     // Nama proyek
                durasi + " " + satuan                            // Durasi dengan satuan (misalnya, "10 minggu")
            });
        }
    } catch (SQLException e) {
        System.out.println("Error Load Data Proyek: " + e.getMessage());
    }
}

    private void saveDataProyek() {
    try {
        // Mendapatkan data dari inputan
        String namaProyek = tfnamaproyek.getText();
        int durasi = Integer.parseInt(tfdurasipengerjaan.getText());
        String satuanDurasi = (String) satuanDurasiComboBox.getSelectedItem(); // Ambil dari ComboBox

        // Query untuk menyimpan data proyek ke database
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan, satuan_durasi) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, namaProyek);
        ps.setInt(2, durasi);
        ps.setString(3, satuanDurasi); // Simpan satuan durasi, misalnya "minggu" atau "hari"

        // Eksekusi perintah SQL
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data proyek berhasil disimpan");
        loadDataProyek(); // Muat ulang data tabel
        updateComboBoxProyek();
        resetSemuaData();
    } catch (SQLException e) {
        System.out.println("Error Save Data Proyek: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Durasi harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
   private void updateDataProyek() {
    if (tfidproyek.getText().isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    try {
        // Cek apakah ID proyek ada dalam tabel
        int idProyek = Integer.parseInt(tfidproyek.getText());
        String checkSql = "SELECT COUNT(*) FROM proyek WHERE id_proyek = ?";
        PreparedStatement checkPs = conn.prepareStatement(checkSql);
        checkPs.setInt(1, idProyek);
        ResultSet checkRs = checkPs.executeQuery();
        checkRs.next();
        
        if (checkRs.getInt(1) == 0) {
            JOptionPane.showMessageDialog(this, "ID proyek tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Perbarui data proyek dengan durasi dan satuan durasi
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ?, satuan_durasi = ? WHERE id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tfnamaproyek.getText()); // nama proyek
        ps.setInt(2, Integer.parseInt(tfdurasipengerjaan.getText())); // durasi pengerjaan
        ps.setString(3, (String) satuanDurasiComboBox.getSelectedItem()); // satuan durasi, misalnya "hari" atau "minggu"
        ps.setInt(4, idProyek); // ID proyek

        // Eksekusi pembaruan
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data proyek berhasil diupdate");
        loadDataProyek(); // Refresh data di tabel
        updateComboBoxProyek();
        resetSemuaData();
    } catch (SQLException e) {
        System.out.println("Error Update Data Proyek: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Pastikan ID dan durasi berformat angka!", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


      private void deleteDataProyek() {
        if (tfidproyek.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idProyek = Integer.parseInt(tfidproyek.getText());

            // Cek apakah ID proyek ada dalam tabel
            String checkSql = "SELECT COUNT(*) FROM proyek WHERE id_proyek = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, idProyek);
            ResultSet checkRs = checkPs.executeQuery();
            checkRs.next();
            if (checkRs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "ID proyek tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data proyek ini?", 
                                                         "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM proyek WHERE id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idProyek);
                ps.executeUpdate();
                JOptionPane.showMessageDialog(this, "Data proyek berhasil dihapus");
                loadDataProyek();
                updateComboBoxProyek();
                resetSemuaData();
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data Proyek: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID proyek harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
  // Memuat data ke ComboBox Karyawan dan Proyek
    private void loadComboBoxData() {
        try {
            String sql = "SELECT nama_karyawan FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbKaryawan.removeAllItems();
            while (rs.next()) {
                cbKaryawan.addItem(rs.getString("nama_karyawan"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Karyawan: " + e.getMessage());
        }

        try {
            String sql = "SELECT nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbProyek.removeAllItems();
            while (rs.next()) {
                cbProyek.addItem(rs.getString("nama_proyek"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Proyek: " + e.getMessage());
        }
    }

    private void loadDataTransaksi() {
        modelTransaksi.setRowCount(0); // Mengosongkan tabel sebelum memuat ulang data
        try {
            String sql = "SELECT transaksi.id_transaksi, karyawan.nama_karyawan, proyek.nama_proyek, transaksi.peran " +
                         "FROM transaksi transaksi " +
                         "JOIN karyawan ON transaksi.id_karyawan = karyawan.id_karyawan " +
                         "JOIN proyek ON transaksi.id_proyek = proyek.id_proyek " +
                         "ORDER BY transaksi.id_transaksi ASC"; // Mengurutkan berdasarkan ID transaksi
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelTransaksi.addRow(new Object[]{
                    rs.getInt("id_transaksi"),
                    rs.getString("nama_karyawan"),
                    rs.getString("nama_proyek"),
                    rs.getString("peran")  // Menyimpan peran sebagai String
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Transaksi: " + e.getMessage());
        }
        resetSemuaData(); // Reset setelah load data
    }

    private void saveDataTransaksi() {
        // Pastikan semua komponen input terisi sebelum menyimpan
        if (tfPeran.getText().isEmpty() || getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum menyimpan data transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String peran = tfPeran.getText(); // Mengambil peran sebagai String
            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, getSelectedKaryawanId());
            ps.setInt(2, getSelectedProyekId());
            ps.setString(3, peran); // Menyimpan sebagai String
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan");

            // Memuat ulang tabel agar data terbaru berada di bawah
            loadDataTransaksi();
        } catch (SQLException e) {
            System.out.println("Error Save Data Transaksi: " + e.getMessage());
        }
    }

    private void updateDataTransaksi() {
        if (tfidtransaksi.getText().isEmpty() || tfPeran.getText().isEmpty() || 
            getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum mengedit data!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idTransaksi;
        try {
            idTransaksi = Integer.parseInt(tfidtransaksi.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID transaksi harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String checkSql = "SELECT COUNT(*) FROM transaksi WHERE id_transaksi = ?";
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, idTransaksi);
            ResultSet checkRs = checkPs.executeQuery();
            checkRs.next();
            if (checkRs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int idKaryawan = getSelectedKaryawanId();
            int idProyek = getSelectedProyekId();
            String peran = tfPeran.getText();

            String sql = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_transaksi = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, peran);
            ps.setInt(4, idTransaksi);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diupdate");
                loadDataTransaksi();
            }
        } catch (SQLException e) {
            System.out.println("Error Update Data Transaksi: " + e.getMessage());
        }
    }


    private void deleteDataTransaksi() {
        if (tfidtransaksi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "ID transaksi tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int idTransaksi;
        try {
            idTransaksi = Integer.parseInt(tfidtransaksi.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID transaksi harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String checkSql = "SELECT COUNT(*) FROM transaksi WHERE id_transaksi = ?";
        try {
            PreparedStatement checkPs = conn.prepareStatement(checkSql);
            checkPs.setInt(1, idTransaksi);
            ResultSet checkRs = checkPs.executeQuery();
            checkRs.next();
            if (checkRs.getInt(1) == 0) {
                JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int response = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus data transaksi ini?", 
                                                         "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (response == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM transaksi WHERE id_transaksi = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idTransaksi);
                int rowsAffected = ps.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus");
                    resetSemuaData();
                    loadDataTransaksi();
                } else {
                    JOptionPane.showMessageDialog(this, "Gagal menghapus data transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data Transaksi: " + e.getMessage());
        }
    }
    private int getSelectedKaryawanId() {
        // Metode untuk mendapatkan ID karyawan berdasarkan ComboBox
        String karyawanName = (String) cbKaryawan.getSelectedItem();
        try {
            String sql = "SELECT id_karyawan FROM karyawan WHERE nama_karyawan = ?";
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
        String proyekName = (String) cbProyek.getSelectedItem();
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
        return -1; // Kembalikan nilai negatif jika tidak ditemukan
    }
    
    private void updateComboBoxKaryawan() {
        cbKaryawan.removeAllItems(); // Hapus semua item di ComboBox terlebih dahulu
        try {
            String sql = "SELECT nama_karyawan FROM karyawan"; // Ambil data nama karyawan dari tabel karyawan
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cbKaryawan.addItem(rs.getString("nama_karyawan")); // Tambahkan setiap nama karyawan ke ComboBox
            }
        } catch (SQLException e) {
            System.out.println("Error Update ComboBox Karyawan: " + e.getMessage());
        }
    }
    
    private void updateComboBoxProyek() {
            cbProyek.removeAllItems(); // Hapus semua item di ComboBox terlebih dahulu
            try {
                String sql = "SELECT nama_proyek FROM proyek"; // Ambil data nama proyek dari tabel proyek
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    cbProyek.addItem(rs.getString("nama_proyek")); // Tambahkan setiap nama proyek ke ComboBox
                }
            } catch (SQLException e) {
                System.out.println("Error Update ComboBox Proyek: " + e.getMessage());
        }
    }


    private void resetSemuaData() {
        // Tab Karyawan
        tfnamakaryawan.setText("");
        tfjabatan.setText("");
        tfdepartemen.setText("");
        tfIdkaryawan.setText("");

        // Tab Proyek
        tfnamaproyek.setText("");
        tfidproyek.setText("");
        tfdurasipengerjaan.setText(""); 

        // Tab Transaksi Proyek
        tfidtransaksi.setText("");
        cbKaryawan.setSelectedIndex(-1);
        cbProyek.setSelectedIndex(-1);
        tfPeran.setText("");

     
    }


     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jComboBox1 = new javax.swing.JComboBox<>();
        tabbedPaneCustom1 = new coba.aja.TabbedPaneCustom();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfidproyek = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        tfnamaproyek = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tfdurasipengerjaan = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProyek = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        btnhapusproyek = new javax.swing.JButton();
        btneditproyek = new javax.swing.JButton();
        btntambahproyek = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        satuanDurasiComboBox = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        tfidtransaksi = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        cbKaryawan = new javax.swing.JComboBox<>();
        cbProyek = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        tfPeran = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        btnhapustransaksi = new javax.swing.JButton();
        btnedittransaksi = new javax.swing.JButton();
        btntambahtransaksi = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tfIdkaryawan = new javax.swing.JTextField();
        tfnamakaryawan = new javax.swing.JTextField();
        tfjabatan = new javax.swing.JTextField();
        tfdepartemen = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        btnhapus = new javax.swing.JButton();
        btnedit = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel7.setBackground(new java.awt.Color(255, 204, 51));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel5.setText("ID Proyek :");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));
        jPanel7.add(tfidproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        jLabel6.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel6.setText("Nama Proyek :");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, -1, -1));
        jPanel7.add(tfnamaproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 150, -1));

        jLabel7.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel7.setText("Durasi Pengerjaan :");
        jPanel7.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));
        jPanel7.add(tfdurasipengerjaan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 150, -1));

        jPanel8.setBackground(new java.awt.Color(102, 153, 255));

        tblProyek.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblProyek);

        jPanel9.setLayout(new java.awt.GridBagLayout());

        btnhapusproyek.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnhapusproyek.setText("HAPUS");
        btnhapusproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusproyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 32, 10, 14);
        jPanel9.add(btnhapusproyek, gridBagConstraints);

        btneditproyek.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btneditproyek.setText("EDIT");
        btneditproyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btneditproyekMouseClicked(evt);
            }
        });
        btneditproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditproyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 26, 10, 0);
        jPanel9.add(btneditproyek, gridBagConstraints);

        btntambahproyek.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btntambahproyek.setText("TAMBAH");
        btntambahproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahproyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 25, 10, 0);
        jPanel9.add(btntambahproyek, gridBagConstraints);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 0, 460, 430));

        jLabel12.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel12.setText("Pilih");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, -1, -1));

        satuanDurasiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hari", "Minggu" }));
        satuanDurasiComboBox.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
                satuanDurasiComboBoxPopupMenuWillBecomeVisible(evt);
            }
        });
        satuanDurasiComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                satuanDurasiComboBoxActionPerformed(evt);
            }
        });
        jPanel7.add(satuanDurasiComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 150, -1));

        jPanel2.add(jPanel7, java.awt.BorderLayout.CENTER);

        tabbedPaneCustom1.addTab("Proyek", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel12.setBackground(new java.awt.Color(255, 204, 0));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel8.setText("ID Transaksi");
        jPanel12.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));
        jPanel12.add(tfidtransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 128, -1));

        jLabel9.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel9.setText("Pilih Karyawan :");
        jPanel12.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 128, -1));

        jLabel10.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel10.setText("Pilih Proyek :");
        jPanel12.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        cbKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbKaryawanActionPerformed(evt);
            }
        });
        jPanel12.add(cbKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 128, -1));

        jPanel12.add(cbProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 128, -1));

        jLabel11.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel11.setText("Peran :");
        jPanel12.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, -1, -1));
        jPanel12.add(tfPeran, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 128, -1));

        jPanel10.setBackground(new java.awt.Color(102, 153, 255));

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tblTransaksi);

        jPanel11.setBackground(new java.awt.Color(255, 204, 102));
        jPanel11.setLayout(new java.awt.GridBagLayout());

        btnhapustransaksi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnhapustransaksi.setText("Hapus");
        btnhapustransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapustransaksiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 36, 21, 30);
        jPanel11.add(btnhapustransaksi, gridBagConstraints);

        btnedittransaksi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnedittransaksi.setText("Edit");
        btnedittransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnedittransaksiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 34, 21, 0);
        jPanel11.add(btnedittransaksi, gridBagConstraints);

        btntambahtransaksi.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btntambahtransaksi.setText("Tambah");
        btntambahtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahtransaksiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 29, 21, 0);
        jPanel11.add(btntambahtransaksi, gridBagConstraints);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel12.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, 480, -1));

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanel12.add(btnreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 380, -1, -1));

        jPanel3.add(jPanel12, java.awt.BorderLayout.CENTER);

        tabbedPaneCustom1.addTab("Transaksi", jPanel3);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel6.setBackground(new java.awt.Color(255, 204, 0));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel1.setText("ID Karyawan:");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel2.setText("NAMA :");
        jPanel6.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, 100, -1));

        jLabel3.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel3.setText("JABATAN :");
        jPanel6.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe Script", 1, 12)); // NOI18N
        jLabel4.setText("DEPARTEMEN :");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));
        jPanel6.add(tfIdkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 120, -1));
        jPanel6.add(tfnamakaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 120, -1));

        tfjabatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfjabatanActionPerformed(evt);
            }
        });
        jPanel6.add(tfjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 120, -1));

        tfdepartemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdepartemenActionPerformed(evt);
            }
        });
        jPanel6.add(tfdepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 120, -1));

        jPanel4.setBackground(new java.awt.Color(102, 153, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblKaryawan);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(2, 0, 470, 330));

        jPanel5.setBackground(new java.awt.Color(255, 204, 102));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        btnhapus.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnhapus.setText("Hapus");
        btnhapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 35, 26, 40);
        jPanel5.add(btnhapus, gridBagConstraints);

        btnedit.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnedit.setText("Edit");
        btnedit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 34, 26, 0);
        jPanel5.add(btnedit, gridBagConstraints);

        btntambah.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(21, 49, 26, 0);
        jPanel5.add(btntambah, gridBagConstraints);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 380, 70));

        jPanel6.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 0, 480, 430));

        jPanel1.add(jPanel6, java.awt.BorderLayout.CENTER);

        tabbedPaneCustom1.addTab("Karyawan", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tfdepartemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfdepartemenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfdepartemenActionPerformed

    private void btnhapusproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusproyekActionPerformed
        // TODO add your handling code here:
        deleteDataProyek();
    }//GEN-LAST:event_btnhapusproyekActionPerformed

    private void tfjabatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfjabatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfjabatanActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
         saveDataKaryawan();
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnhapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusActionPerformed
        // TODO add your handling code here:
         deleteDataKaryawan();
    }//GEN-LAST:event_btnhapusActionPerformed

    private void btneditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditActionPerformed
        // TODO add your handling code here:
         updateDataKaryawan();
    }//GEN-LAST:event_btneditActionPerformed

    private void btntambahproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahproyekActionPerformed
        // TODO add your handling code here:
        saveDataProyek();
    }//GEN-LAST:event_btntambahproyekActionPerformed

    private void btneditproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditproyekActionPerformed
        // TODO add your handling code here:
        updateDataProyek();
    }//GEN-LAST:event_btneditproyekActionPerformed

    private void btntambahtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahtransaksiActionPerformed
        // TODO add your handling code here:
        saveDataTransaksi();
    }//GEN-LAST:event_btntambahtransaksiActionPerformed

    private void btnedittransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnedittransaksiActionPerformed
        // TODO add your handling code here:
        updateDataTransaksi();
    }//GEN-LAST:event_btnedittransaksiActionPerformed

    private void btneditproyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btneditproyekMouseClicked
        // TODO add your handling code here:
        updateDataProyek();
    }//GEN-LAST:event_btneditproyekMouseClicked

    private void cbKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbKaryawanActionPerformed

    private void btnhapustransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapustransaksiActionPerformed
        // TODO add your handling code here:
        deleteDataTransaksi();
    }//GEN-LAST:event_btnhapustransaksiActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        resetSemuaData();
    }//GEN-LAST:event_btnresetActionPerformed
    
    private void satuanDurasiComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_satuanDurasiComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_satuanDurasiComboBoxActionPerformed

    private void satuanDurasiComboBoxPopupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_satuanDurasiComboBoxPopupMenuWillBecomeVisible
        // TODO add your handling code here:
//           if (satuanDurasiComboBox.setSelectedIndex() == 0) {
//            satuanDurasiComboBox.addItem("Hari");
//            satuanDurasiComboBox.addItem("Minggu");
//            satuanDurasiComboBox.addItem("Bulan");
//        }
    }//GEN-LAST:event_satuanDurasiComboBoxPopupMenuWillBecomeVisible

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(coba1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(coba1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(coba1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(coba1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coba1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnedit;
    private javax.swing.JButton btneditproyek;
    private javax.swing.JButton btnedittransaksi;
    private javax.swing.JButton btnhapus;
    private javax.swing.JButton btnhapusproyek;
    private javax.swing.JButton btnhapustransaksi;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntambahproyek;
    private javax.swing.JButton btntambahtransaksi;
    private javax.swing.JComboBox<String> cbKaryawan;
    private javax.swing.JComboBox<String> cbProyek;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JComboBox<String> satuanDurasiComboBox;
    private coba.aja.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JTable tblProyek;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField tfIdkaryawan;
    private javax.swing.JTextField tfPeran;
    private javax.swing.JTextField tfdepartemen;
    private javax.swing.JTextField tfdurasipengerjaan;
    private javax.swing.JTextField tfidproyek;
    private javax.swing.JTextField tfidtransaksi;
    private javax.swing.JTextField tfjabatan;
    private javax.swing.JTextField tfnamakaryawan;
    private javax.swing.JTextField tfnamaproyek;
    // End of variables declaration//GEN-END:variables
}
