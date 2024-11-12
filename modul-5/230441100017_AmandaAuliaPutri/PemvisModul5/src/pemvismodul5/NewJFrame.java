/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pemvismodul5;

import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AMANDA AULIA
 */
public class NewJFrame extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
    
    
    public NewJFrame() {
        initComponents();
        conn = koneksi.getConnection();

        initTableModels();
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
        clearTransaksiFields();
       

        clearTransaksiFields();
    }
    
    private void initTableModels() {
        modelKaryawan = new DefaultTableModel(new String[] { "ID", "Nama", "Jabatan", "Departemen" }, 0);
        tbl_karyawan.setModel(modelKaryawan);// tbl_karyawan ini menggunakan model modelKaryawan sebagai datanya.

        modelProyek = new DefaultTableModel(new String[] { "ID", "Nama Proyek", "Pengerjaan Mingguan" }, 0);
        tbl_proyek.setModel(modelProyek);

        modelTransaksi = new DefaultTableModel(new String[] { "ID Karyawan", "ID Proyek", "Nama Karyawan", "Peran",  "Nama Proyek", "Durasi Kerja Mingguan" }, 0);
        tbl_transaksi.setModel(modelTransaksi);
    }
    
    private void loadDataKaryawan() {
        modelKaryawan.setRowCount(0);
        try {
            String sql = "SELECT * FROM tb_karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelKaryawan.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Karyawan: " + e.getMessage());
        }
    }
    
    private void loadDataProyek() {
            modelProyek.setRowCount(0);
            try {
                String sql = "SELECT * FROM tb_proyek";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    modelProyek.addRow(new Object[]{
                        rs.getInt("id"),
                        rs.getString("nama_proyek"),
                        rs.getInt("durasi_pengerjaan") 
                    });
                }
            } catch (SQLException e) {
                System.out.println("Error Load Data Proyek: " + e.getMessage());
            }
        }
    
    private void loadDataTransaksi() {
            modelTransaksi.setRowCount(0);
            try {
                String sql = "SELECT t.id_karyawan, t.id_proyek, t.peran, " +
                             "k.nama AS nama_karyawan, p.nama_proyek AS nama_proyek, " +
                             "p.durasi_pengerjaan " +
                             "FROM tb_transaksi t " +
                             "JOIN tb_karyawan k ON t.id_karyawan = k.id " +
                             "JOIN tb_proyek p ON t.id_proyek = p.id";
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    modelTransaksi.addRow(new Object[]{
                        rs.getInt("id_karyawan"),
                        rs.getInt("id_proyek"),
                        rs.getString("nama_karyawan"),
                        rs.getString("peran"),
                        rs.getString("nama_proyek"),
                        rs.getInt("durasi_pengerjaan")
                    });
                }
            } catch (SQLException e) {
                System.out.println("Error Load Data Transaksi: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Gagal memuat data transaksi: " + e.getMessage());
            }
        }
    
    private void tambahKaryawan() {
        if (tf_nmkaryawan.getText().trim().isEmpty() || 
        tf_jbtkaryawan.getText().trim().isEmpty() || 
        tf_dptkaryawan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan eksekusi jika ada field yang kosong
    }
        PreparedStatement ps = null;
        try {
        String sql = "INSERT INTO tb_karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmkaryawan.getText().trim());// untuk menetapkan nilai 1 tf_nmkaryawan
        ps.setString(2, tf_jbtkaryawan.getText().trim());
        ps.setString(3, tf_dptkaryawan.getText().trim());

        int affectedRows = ps.executeUpdate(); //mengeksekusi perintah SQL yang mengubah data dalam database
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil ditambahkan.");
            loadDataKaryawan();
            clearKaryawanFields();
            loadComboBoxKaryawan();
            clearTransaksiFields();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal menambahkan data karyawan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan saat menambah Data Karyawan: " + e.getMessage(), 
                                      "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } finally {
        
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat menutup PreparedStatement: " + e.getMessage(), 
                                          "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void updateKaryawan() {
    // Validasi ID Karyawan
    if (id_karyawan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID Karyawan harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan eksekusi jika ID kosong
    }

    int id;
    try {
        id = Integer.parseInt(id_karyawan.getText().trim()); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID Karyawan tidak valid.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        return; 
    }

     
    if (tf_nmkaryawan.getText().trim().isEmpty() || 
        tf_jbtkaryawan.getText().trim().isEmpty() || 
        tf_dptkaryawan.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    PreparedStatement ps = null; 
    try {
        String sql = "UPDATE tb_karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmkaryawan.getText().trim());
        ps.setString(2, tf_jbtkaryawan.getText().trim());
        ps.setString(3, tf_dptkaryawan.getText().trim());
        ps.setInt(4, id);

        int affectedRows = ps.executeUpdate(); 
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil diupdate.");
            loadDataKaryawan();
            clearKaryawanFields();
            loadComboBoxKaryawan();
            clearTransaksiFields();
        } else {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data karyawan. ID tidak ditemukan.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan saat memperbarui Data Karyawan: " + e.getMessage(), 
                                      "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } finally {
        
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat menutup PreparedStatement: " + e.getMessage(), 
                                          "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
}

    private void hapusKaryawan() {
    try {
        int id = Integer.parseInt(id_karyawan.getText()); 
        String sql = "DELETE FROM tb_karyawan WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);// nomor parameter dimulai dari 0 bukan 1, menggantikan tanda tanya pertama (?) dalam query SQL dengan nilai id untuk menghapus data karyawan berdasarkan ID.
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Karyawan berhasil dihapus.");
        loadDataKaryawan();
        clearKaryawanFields();
        loadComboBoxKaryawan();
        clearTransaksiFields();
    } catch (SQLException e) {
        System.out.println("Error Hapus Data Karyawan: " + e.getMessage());
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    }
    loadComboBoxKaryawan();
}
    
    private void tambahProyek() {
        if (id_proyek.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong.", 
                                      "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    try {
        String sql = "INSERT INTO tb_proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmproyek.getText());  
        ps.setString(2, tf_dpproyek.getText()); 
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek();
        clearProyekFields(); 
        loadComboBoxProyek();
        clearTransaksiFields();
    } catch (SQLException e) {
        System.out.println("Error Tambah Data Proyek: " + e.getMessage());
    }
}
    private void updateProyek() {
         if (id_proyek.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong.", 
                                      "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
    try {
        int id = Integer.parseInt(id_proyek.getText()); 
        String sql = "UPDATE tb_proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_nmproyek.getText()); 
        ps.setString(2, tf_dpproyek.getText());  
        ps.setInt(3, id);
        
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil diupdate.");
        loadDataProyek();
        clearProyekFields();  
        loadComboBoxProyek();
        clearTransaksiFields();
    } catch (SQLException e) {
        System.out.println("Error Update Data Proyek: " + e.getMessage());
    }
}
    private void hapusProyek() {
    try {
        int id = Integer.parseInt(id_proyek.getText()); 

        DefaultTableModel model = (DefaultTableModel) tbl_proyek.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            int tableId = (int) model.getValueAt(i, 0); 
            if (tableId == id) {
                // Hapus dari database
                String sqlDelete = "DELETE FROM tb_proyek WHERE id = ?";
                PreparedStatement psDelete = conn.prepareStatement(sqlDelete);
                psDelete.setInt(1, id);
                psDelete.executeUpdate();
                
                // Hapus baris dari tabel GUI
                model.removeRow(i); 
                JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus dari tabel dan database.");
                loadDataProyek();
                clearProyekFields();
                loadComboBoxProyek();
                clearTransaksiFields();
 
                clearProyekFields();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Data Proyek tidak ditemukan di tabel.");
        
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID tidak valid");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error menghapus data: " + e.getMessage());
    }
}
    
    private void loadComboBoxKaryawan() {
    cmb_karyawan.removeAllItems();
    try {
        String sql = "SELECT id, nama, jabatan, departemen FROM tb_karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s, %s)", 
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            );
            cmb_karyawan.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
}

    private void loadComboBoxProyek() {
    cmb_proyek.removeAllItems();
    try {
        String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM tb_proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            String tampilan = String.format("ID: %d - %s (%s)", 
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan")
            );
            cmb_proyek.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Proyek: " + e.getMessage());
    }
}
    
    
    private int getSelectedId(String textComboBox) {
    if (textComboBox == null) return -1;
    try {
        String idPart = textComboBox.substring(textComboBox.indexOf("ID: ") + 4);
        return Integer.parseInt(idPart.substring(0, idPart.indexOf(" -")));
    } catch (Exception e) {
        System.out.println("Error parsing ID: " + e.getMessage());
        return -1;
    }
}
    
    
        private void tambahTransaksi() {
            try {
                if (cmb_karyawan.getSelectedItem() == null || cmb_proyek.getSelectedItem() == null || tf_perantransaksi.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(this, "Pilih karyawan, proyek, dan isi peran terlebih dahulu");
                    return;
                }

                String sql = "INSERT INTO tb_transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);

                int idKaryawan = getSelectedId(cmb_karyawan.getSelectedItem().toString());
                int idProyek = getSelectedId(cmb_proyek.getSelectedItem().toString());

                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);
                ps.setString(3, tf_perantransaksi.getText().trim());

                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
                    loadDataTransaksi();
                    clearTransaksiFields();
                }
            } catch (SQLException e) {
                System.out.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
            }
        }
        
        

        private void updateTransaksi() {
            if (tf_perantransaksi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong.", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return; 
        }
            PreparedStatement ps = null; 
        try {
            String sql = "UPDATE tb_transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            ps = conn.prepareStatement(sql);

            int idKaryawan = getSelectedId(cmb_karyawan.getSelectedItem().toString());
            int idProyek = getSelectedId(cmb_proyek.getSelectedItem().toString());

            ps.setString(1, tf_perantransaksi.getText().trim());
            ps.setInt(2, idKaryawan);
            ps.setInt(3, idProyek);

            int affectedRows = ps.executeUpdate(); 
            if (affectedRows > 0) {
                JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
                loadDataTransaksi();
                clearTransaksiFields();
            } else {
                JOptionPane.showMessageDialog(this, "Tidak ada data transaksi yang diperbarui. Pastikan ID karyawan dan proyek benar.", 
                                              "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan Memperbarui Data Transaksi: " + e.getMessage(), 
                                      "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Kesalahan saat menutup PreparedStatement: " + e.getMessage(), 
                                          "Kesalahan", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
        
        

    private void hapusTransaksi() {
    // Memastikan ComboBox tidak kosong
    if (cmb_karyawan.getSelectedItem() == null || cmb_proyek.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Silakan pilih karyawan dan proyek sebelum menghapus transaksi.", 
                                      "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    PreparedStatement ps = null; 
    try {
        String sql = "DELETE FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(cmb_karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(cmb_proyek.getSelectedItem().toString());
        
        ps.setInt(1, idKaryawan);
        ps.setInt(2, idProyek);
        
        int affectedRows = ps.executeUpdate(); 
        if (affectedRows > 0) {
            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus.");
            loadDataTransaksi();
            clearTransaksiFields();
        } else {
            JOptionPane.showMessageDialog(this, "Tidak ada transaksi yang dihapus. Pastikan ID karyawan dan proyek benar.", 
                                          "Informasi", JOptionPane.INFORMATION_MESSAGE);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan Menghapus Data Transaksi: " + e.getMessage(), 
                                      "Error", JOptionPane.ERROR_MESSAGE);
    } finally {
        try {
            if (ps != null) ps.close();
        } catch (SQLException e) {
            System.out.println("Kesalahan saat menutup PreparedStatement: " + e.getMessage());
        }
    }
}
    private void clearKaryawanFields() {
        id_karyawan.setText("");
        tf_nmkaryawan.setText("");
        tf_jbtkaryawan.setText("");
        tf_dptkaryawan.setText("");
    }

    private void clearProyekFields() {
        id_proyek.setText("");
        tf_nmproyek.setText("");
        tf_dpproyek.setText("");
    }
    
    private void clearTransaksiFields() {
        cmb_karyawan.setSelectedIndex(-1);
        cmb_proyek.setSelectedIndex(-1);
        tf_perantransaksi.setText("");
    }

    /**
     * Creates new form NewJFrame
     */
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        id_karyawan = new javax.swing.JTextField();
        tf_nmkaryawan = new javax.swing.JTextField();
        tf_jbtkaryawan = new javax.swing.JTextField();
        tf_dptkaryawan = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btn_crkaryawan = new javax.swing.JButton();
        btn_upkaryawan = new javax.swing.JButton();
        btn_delkaryawan = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        btn_resetKR = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        id_proyek = new javax.swing.JTextField();
        tf_nmproyek = new javax.swing.JTextField();
        tf_dpproyek = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        btn_crproyek = new javax.swing.JButton();
        btn_upproyek = new javax.swing.JButton();
        btn_delproyek = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        btn_resetPRY = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cmb_karyawan = new javax.swing.JComboBox<>();
        cmb_proyek = new javax.swing.JComboBox<>();
        tf_perantransaksi = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        btn_crtransaksi = new javax.swing.JButton();
        btn_uptransaksi = new javax.swing.JButton();
        btn_deltransaksi = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        btn_resetTRANS = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel1.setText("KARYAWAN.ID");
        jPanel4.add(jLabel1);
        jLabel1.setBounds(180, 10, 110, 20);

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel2.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(22, 26, 0, 0);
        jPanel5.add(jLabel2, gridBagConstraints);

        jLabel3.setText("Nama");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 26, 0, 0);
        jPanel5.add(jLabel3, gridBagConstraints);

        jLabel4.setText("Jabatan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 26, 0, 0);
        jPanel5.add(jLabel4, gridBagConstraints);

        jLabel5.setText("Departemen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 26, 20, 0);
        jPanel5.add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 68, 0, 26);
        jPanel5.add(id_karyawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 68, 0, 26);
        jPanel5.add(tf_nmkaryawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 68, 0, 26);
        jPanel5.add(tf_jbtkaryawan, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 145;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(18, 68, 20, 26);
        jPanel5.add(tf_dptkaryawan, gridBagConstraints);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(40, 30, 430, 169);

        jPanel6.setBackground(new java.awt.Color(51, 255, 204));

        btn_crkaryawan.setText("CREATE");
        btn_crkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crkaryawanActionPerformed(evt);
            }
        });
        jPanel6.add(btn_crkaryawan);

        btn_upkaryawan.setText("UPDATE");
        btn_upkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upkaryawanActionPerformed(evt);
            }
        });
        jPanel6.add(btn_upkaryawan);

        btn_delkaryawan.setText("DELETE");
        btn_delkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delkaryawanActionPerformed(evt);
            }
        });
        jPanel6.add(btn_delkaryawan);

        jPanel4.add(jPanel6);
        jPanel6.setBounds(40, 210, 430, 50);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel6.setText("TABEL KARYAWAN");
        jPanel4.add(jLabel6);
        jLabel6.setBounds(180, 270, 130, 20);

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
        jScrollPane1.setViewportView(tbl_karyawan);

        jPanel4.add(jScrollPane1);
        jScrollPane1.setBounds(40, 290, 422, 206);

        btn_resetKR.setText("RESET");
        btn_resetKR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetKRActionPerformed(evt);
            }
        });
        jPanel4.add(btn_resetKR);
        btn_resetKR.setBounds(390, 510, 72, 22);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("KARYAWAN", jPanel1);

        jPanel2.setLayout(null);

        jPanel7.setBackground(new java.awt.Color(0, 204, 204));

        jLabel7.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel7.setText("PROYEK.ID");

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("ID");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 24, 0, 0);
        jPanel8.add(jLabel8, gridBagConstraints);

        jLabel9.setText("Nama Proyek");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 24, 0, 0);
        jPanel8.add(jLabel9, gridBagConstraints);

        jLabel10.setText("Durasi Pengerjaan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(28, 24, 0, 0);
        jPanel8.add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(14, 6, 0, 60);
        jPanel8.add(id_proyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 6, 0, 60);
        jPanel8.add(tf_nmproyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 177;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 6, 35, 60);
        jPanel8.add(tf_dpproyek, gridBagConstraints);

        jPanel9.setBackground(new java.awt.Color(51, 255, 204));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_crproyek.setText("CREATE");
        btn_crproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crproyekActionPerformed(evt);
            }
        });
        jPanel9.add(btn_crproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 16, -1, -1));

        btn_upproyek.setText("UPDATE");
        btn_upproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_upproyekActionPerformed(evt);
            }
        });
        jPanel9.add(btn_upproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 16, -1, -1));

        btn_delproyek.setText("DELETE");
        btn_delproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_delproyekActionPerformed(evt);
            }
        });
        jPanel9.add(btn_delproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 16, -1, -1));

        jLabel11.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel11.setText("TABEL PROYEK");

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
        jScrollPane2.setViewportView(tbl_proyek);

        btn_resetPRY.setText("RESET");
        btn_resetPRY.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetPRYActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btn_resetPRY)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 424, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(174, 174, 174))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_resetPRY)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7);
        jPanel7.setBounds(0, 0, 520, 560);

        jTabbedPane1.addTab("PROYEK", jPanel2);

        jPanel10.setBackground(new java.awt.Color(0, 204, 204));

        jLabel12.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel12.setText("TRANSAKSI.ID");

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));

        jLabel13.setText("Karyawan");

        jLabel14.setText("Proyek");

        jLabel15.setText("Peran");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_proyek, 0, 255, Short.MAX_VALUE)
                    .addComponent(cmb_karyawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tf_perantransaksi))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmb_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(cmb_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tf_perantransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanel12.setBackground(new java.awt.Color(0, 255, 204));

        btn_crtransaksi.setText("CREATE");
        btn_crtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crtransaksiActionPerformed(evt);
            }
        });

        btn_uptransaksi.setText("UPDATE");
        btn_uptransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_uptransaksiActionPerformed(evt);
            }
        });

        btn_deltransaksi.setText("DELETE");
        btn_deltransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deltransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(btn_crtransaksi)
                .addGap(89, 89, 89)
                .addComponent(btn_uptransaksi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                .addComponent(btn_deltransaksi)
                .addGap(39, 39, 39))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_crtransaksi)
                    .addComponent(btn_uptransaksi)
                    .addComponent(btn_deltransaksi))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        jLabel16.setFont(new java.awt.Font("Segoe UI Semibold", 0, 14)); // NOI18N
        jLabel16.setText("TABEL TRANSAKSI");

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
        jScrollPane3.setViewportView(tbl_transaksi);

        btn_resetTRANS.setText("RESET");
        btn_resetTRANS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_resetTRANSActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_resetTRANS)
                    .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(189, 189, 189)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel10Layout.createSequentialGroup()
                            .addGap(190, 190, 190)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_resetTRANS)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("TRANSAKSI", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 579, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crtransaksiActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_btn_crtransaksiActionPerformed

    private void btn_crkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crkaryawanActionPerformed
        // TODO add your handling code here:
        tambahKaryawan();
        
    }//GEN-LAST:event_btn_crkaryawanActionPerformed

    private void btn_upkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upkaryawanActionPerformed
        // TODO add your handling code here:
        updateKaryawan();
    }//GEN-LAST:event_btn_upkaryawanActionPerformed

    private void btn_delkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delkaryawanActionPerformed
        // TODO add your handling code here:
        hapusKaryawan();
    }//GEN-LAST:event_btn_delkaryawanActionPerformed

    private void btn_crproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crproyekActionPerformed
        // TODO add your handling code here:
        tambahProyek();
    }//GEN-LAST:event_btn_crproyekActionPerformed

    private void btn_upproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_upproyekActionPerformed
        // TODO add your handling code here:
        updateProyek();
    }//GEN-LAST:event_btn_upproyekActionPerformed

    private void btn_delproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_delproyekActionPerformed
        // TODO add your handling code here:
        hapusProyek();
    }//GEN-LAST:event_btn_delproyekActionPerformed

    private void btn_uptransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_uptransaksiActionPerformed
        // TODO add your handling code here:
        updateTransaksi();
    }//GEN-LAST:event_btn_uptransaksiActionPerformed

    private void btn_deltransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deltransaksiActionPerformed
        // TODO add your handling code here:
        hapusTransaksi();
    }//GEN-LAST:event_btn_deltransaksiActionPerformed

    private void tbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_karyawanMouseClicked
        // TODO add your handling code here:
        int row = tbl_karyawan.getSelectedRow();

    if (row != -1) {
        id_karyawan.setText(tbl_karyawan.getValueAt(row, 0).toString());
        tf_nmkaryawan.setText(tbl_karyawan.getValueAt(row, 1).toString());
        tf_jbtkaryawan.setText(tbl_karyawan.getValueAt(row, 2).toString());
        tf_dptkaryawan.setText(tbl_karyawan.getValueAt(row, 3).toString());
    }
    }//GEN-LAST:event_tbl_karyawanMouseClicked

    private void tbl_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proyekMouseClicked
        // TODO add your handling code here:
        int row = tbl_proyek.getSelectedRow();

        if (row != -1) {
        id_proyek.setText(tbl_proyek.getValueAt(row, 0).toString());
        tf_nmproyek.setText(tbl_proyek.getValueAt(row, 1).toString());
        tf_dpproyek.setText(tbl_proyek.getValueAt(row, 2).toString());
    }
    }//GEN-LAST:event_tbl_proyekMouseClicked

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // TODO add your handling code here:
        int row = tbl_transaksi.getSelectedRow();

        if (row != -1) {
        String idKaryawan = tbl_transaksi.getValueAt(row, 0).toString();
        String idProyek = tbl_transaksi.getValueAt(row, 1).toString();
        
        // Atur JComboBox Karyawan
        for (int i = 0; i < cmb_karyawan.getItemCount(); i++) {
            if (cmb_karyawan.getItemAt(i).toString().contains(idKaryawan)) {
                cmb_karyawan.setSelectedIndex(i);
                break;
            }
        }

        // Atur JComboBox Proyek
        for (int i = 0; i < cmb_proyek.getItemCount(); i++) {
            if (cmb_proyek.getItemAt(i).toString().contains(idProyek)) {
                cmb_proyek.setSelectedIndex(i);
                break;
            }
        }

        tf_perantransaksi.setText(tbl_transaksi.getValueAt(row, 3).toString()); 
        tf_dpproyek.setText(tbl_transaksi.getValueAt(row, 5).toString()); 
    }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void btn_resetTRANSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetTRANSActionPerformed
        // TODO add your handling code here:
        clearTransaksiFields(); // Memanggil metode untuk membersihkan semua field input
        JOptionPane.showMessageDialog(null, "Form input transaksi telah direset");
    }//GEN-LAST:event_btn_resetTRANSActionPerformed

    private void btn_resetKRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetKRActionPerformed
        // TODO add your handling code here:
        clearKaryawanFields(); // Memanggil metode untuk membersihkan semua field input
        JOptionPane.showMessageDialog(null, "Form input transaksi telah direset");
    }//GEN-LAST:event_btn_resetKRActionPerformed

    private void btn_resetPRYActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_resetPRYActionPerformed
        // TODO add your handling code here:
        clearProyekFields(); // Memanggil metode untuk membersihkan semua field input
        JOptionPane.showMessageDialog(null, "Form input transaksi telah direset");
    }//GEN-LAST:event_btn_resetPRYActionPerformed

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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_crkaryawan;
    private javax.swing.JButton btn_crproyek;
    private javax.swing.JButton btn_crtransaksi;
    private javax.swing.JButton btn_delkaryawan;
    private javax.swing.JButton btn_delproyek;
    private javax.swing.JButton btn_deltransaksi;
    private javax.swing.JButton btn_resetKR;
    private javax.swing.JButton btn_resetPRY;
    private javax.swing.JButton btn_resetTRANS;
    private javax.swing.JButton btn_upkaryawan;
    private javax.swing.JButton btn_upproyek;
    private javax.swing.JButton btn_uptransaksi;
    private javax.swing.JComboBox<String> cmb_karyawan;
    private javax.swing.JComboBox<String> cmb_proyek;
    private javax.swing.JTextField id_karyawan;
    private javax.swing.JTextField id_proyek;
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
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_dpproyek;
    private javax.swing.JTextField tf_dptkaryawan;
    private javax.swing.JTextField tf_jbtkaryawan;
    private javax.swing.JTextField tf_nmkaryawan;
    private javax.swing.JTextField tf_nmproyek;
    private javax.swing.JTextField tf_perantransaksi;
    // End of variables declaration//GEN-END:variables
}
