/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugasmodul5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class manajemenkaryawanproyek extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
    /**
     * Creates new form 
     */
    public manajemenkaryawanproyek() {
        initComponents();
        conn = koneksi.getConnection();
        
        initTableModels();
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadComboBoxKaryawan();
        loadComboBoxProyek();
        clearTransaksiFields();
       
    }

    private void initTableModels() {
    modelKaryawan = new DefaultTableModel(new String[] { "ID", "Nama", "Jabatan", "Departemen" }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; 
        }
    };
    tbl_Karyawan.setModel(modelKaryawan);

    modelProyek = new DefaultTableModel(new String[] { "ID", "Nama Proyek", "Pengerjaan Mingguan" }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tbl_Proyek.setModel(modelProyek);

    modelTransaksi = new DefaultTableModel(new String[] { "ID Karyawan", "ID Proyek", "Nama Karyawan", "Nama Proyek", "Durasi" }, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tbl_Transaksi.setModel(modelTransaksi);
}
//    menampilkan ke table
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
            
            tbl_Karyawan.repaint();
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
                    String.format("%d Minggu", rs.getInt("durasi_pengerjaan"))
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Proyek: " + e.getMessage());
        }
    }
    
    private void loadDataTransaksi() {
        modelTransaksi.setRowCount(0);
        try {
            String sql = "SELECT t.id_karyawan, t.id_proyek, t.durasi, " +
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
                    rs.getString("nama_proyek"),
                    String.format("%d Minggu", rs.getInt("durasi"))
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal memuat data transaksi: " + e.getMessage());
        }
    }
    
//    CRUD tab karyawan
    
    private void tambahKaryawan() {
        if (tf_Nama.getText().trim().isEmpty() || 
        tf_Jabatan.getText().trim().isEmpty() || 
        tf_Departemen.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; // Hentikan eksekusi jika ada field yang kosong
    }
        PreparedStatement ps = null;
        try {
        String sql = "INSERT INTO tb_karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tf_Nama.getText().trim());
        ps.setString(2, tf_Jabatan.getText().trim());
        ps.setString(3, tf_Departemen.getText().trim());

        int affectedRows = ps.executeUpdate(); 
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
        JOptionPane.showMessageDialog(this, "Kesalahan saat menambah Data Karyawan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
    } 

}
    
    private void updateKaryawan() {
    int id;
    try {
        id = Integer.parseInt(id_Karyawan.getText().trim()); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "ID Karyawan tidak valid.", "Kesalahan", JOptionPane.ERROR_MESSAGE);
        return; 
    }

    if (tf_Nama.getText().trim().isEmpty() || 
        tf_Jabatan.getText().trim().isEmpty() || 
        tf_Departemen.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }

    PreparedStatement ps = null; 
    try {
        String sql = "UPDATE tb_karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        ps = conn.prepareStatement(sql);
        ps.setString(1, tf_Nama.getText().trim());
        ps.setString(2, tf_Jabatan.getText().trim());
        ps.setString(3, tf_Departemen.getText().trim());
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
    } 

}

    private void hapusKaryawan() {
    try {
        int id = Integer.parseInt(id_Karyawan.getText()); 
        String sql = "DELETE FROM tb_karyawan WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
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
    
//    CRUD tab proyek
    
    private void tambahProyek() {
    if (tf_Namaproyek.getText().trim().isEmpty() || 
        tf_Durasiproyek.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "field Nama dan Durasi proyek harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
        
    try {
        String sql = "INSERT INTO tb_proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_Namaproyek.getText());  
        ps.setString(2, tf_Durasiproyek.getText()); 
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
       
    if (id_Proyek.getText().trim().isEmpty() || 
    tf_Namaproyek.getText().trim().isEmpty() || 
    tf_Durasiproyek.getText().trim().isEmpty()) {
    JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
    return; 
    }
    try {
        int id = Integer.parseInt(id_Proyek.getText()); 
        String sql = "UPDATE tb_proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_Namaproyek.getText()); 
        ps.setString(2, tf_Durasiproyek.getText());  
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
        int id = Integer.parseInt(id_Proyek.getText()); 

        DefaultTableModel model = (DefaultTableModel) tbl_Proyek.getModel();
        
        for (int i = 0; i < model.getRowCount(); i++) {
            int tableId = (int) model.getValueAt(i, 0); 
            if (tableId == id) {
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
    
//    read combobox tab transaksi
    
    private void loadComboBoxKaryawan() {
    CB_Karyawan.removeAllItems();
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
            CB_Karyawan.addItem(tampilan);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memuat Data Karyawan: " + e.getMessage());
    }
}

    private void loadComboBoxProyek() {
    CB_Proyek.removeAllItems();
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
            CB_Proyek.addItem(tampilan);
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
//    CRUD tab transaksi
        
    private void tambahTransaksi() {
        try {
            if (CB_Karyawan.getSelectedItem() == null || CB_Proyek.getSelectedItem() == null || tf_Perantransaksi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih karyawan, proyek, dan isi peran terlebih dahulu");
                return;
            }

            String sql = "INSERT INTO tb_transaksi (id_karyawan, id_proyek, durasi) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);

            int idKaryawan = getSelectedId(CB_Karyawan.getSelectedItem().toString());
            int idProyek = getSelectedId(CB_Proyek.getSelectedItem().toString());

            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setInt(3, Integer.parseInt(tf_Perantransaksi.getText().trim()));

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
    if (CB_Karyawan.getSelectedIndex() == 0 || 
        CB_Proyek.getSelectedIndex() == 0 || 
        tf_Departemen.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    PreparedStatement ps = null; 
    try {
        String sql = "UPDATE tb_transaksi SET durasi = ? WHERE id_karyawan = ? AND id_proyek = ?";
        ps = conn.prepareStatement(sql);

        int idKaryawan = getSelectedId(CB_Karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(CB_Proyek.getSelectedItem().toString());

        ps.setInt(1, Integer.parseInt(tf_Perantransaksi.getText().trim()));
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
    } 

}

    private void hapusTransaksi() {
    // Memastikan ComboBox tidak kosong
    if (CB_Karyawan.getSelectedItem() == null || CB_Proyek.getSelectedItem() == null) {
        JOptionPane.showMessageDialog(this, "Silakan pilih karyawan dan proyek sebelum menghapus transaksi.", 
                                      "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    PreparedStatement ps = null; 
    try {
        String sql = "DELETE FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        ps = conn.prepareStatement(sql);
        
        int idKaryawan = getSelectedId(CB_Karyawan.getSelectedItem().toString());
        int idProyek = getSelectedId(CB_Proyek.getSelectedItem().toString());
        
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
    } 

}
    
    private void clearKaryawanFields() {
        id_Karyawan.setText("");
        tf_Nama.setText("");
        tf_Jabatan.setText("");
        tf_Departemen.setText("");
    }

    private void clearProyekFields() {
        id_Proyek.setText("");
        tf_Namaproyek.setText("");
        tf_Durasiproyek.setText("");
    }
    
    private void clearTransaksiFields() {
        CB_Karyawan.setSelectedIndex(-1);
        CB_Proyek.setSelectedIndex(-1);
        tf_Perantransaksi.setText("");
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        karyawan = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        id_Karyawan = new javax.swing.JTextField();
        tf_Nama = new javax.swing.JTextField();
        tf_Jabatan = new javax.swing.JTextField();
        tf_Departemen = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        btn_Ckaryawan = new javax.swing.JButton();
        btn_Ukaryawan = new javax.swing.JButton();
        btn_Dkaryawan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_Karyawan = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        proyek = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        id_Proyek = new javax.swing.JTextField();
        tf_Namaproyek = new javax.swing.JTextField();
        tf_Durasiproyek = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        btn_Cproyek = new javax.swing.JButton();
        btn_Uproyek = new javax.swing.JButton();
        btn_Dproyek = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_Proyek = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        transaksi = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_Perantransaksi = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        btn_Ctransaksi = new javax.swing.JButton();
        btn_Utransaksi = new javax.swing.JButton();
        btn_Dtransaksi = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        CB_Karyawan = new javax.swing.JComboBox<>();
        CB_Proyek = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_Transaksi = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(682, 539));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        karyawan.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel1.setText("ID                  :");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel2.setText("Nama            :");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel3.setText("Jabatan        :");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel4.setText("Departemen :");

        jPanel7.setLayout(new java.awt.GridLayout(1, 0));

        btn_Ckaryawan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Ckaryawan.setText("SIMPAN");
        btn_Ckaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CkaryawanActionPerformed(evt);
            }
        });
        jPanel7.add(btn_Ckaryawan);

        btn_Ukaryawan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Ukaryawan.setText("UBAH");
        btn_Ukaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UkaryawanActionPerformed(evt);
            }
        });
        jPanel7.add(btn_Ukaryawan);

        btn_Dkaryawan.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Dkaryawan.setText("HAPUS");
        btn_Dkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DkaryawanActionPerformed(evt);
            }
        });
        jPanel7.add(btn_Dkaryawan);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tf_Nama, javax.swing.GroupLayout.DEFAULT_SIZE, 338, Short.MAX_VALUE)
                    .addComponent(tf_Departemen, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tf_Jabatan, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(id_Karyawan))
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(id_Karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(tf_Nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))
                    .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tf_Jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)))
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_Departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbl_Karyawan.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_KaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_Karyawan);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(105, Short.MAX_VALUE))
        );

        karyawan.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel15.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        jLabel15.setText("AMBATUKAM GROUP");

        jLabel17.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel17.setText("KARYAWAN");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(214, 214, 214)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(185, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(222, 222, 222))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel15)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        karyawan.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("karyawan", karyawan);

        proyek.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel5.setText("ID                              :");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel6.setText("Minggu");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel7.setText("Durasi Pengerjaan  :");

        jPanel13.setLayout(new java.awt.GridLayout(1, 0));

        btn_Cproyek.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Cproyek.setText("SIMPAN");
        btn_Cproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CproyekActionPerformed(evt);
            }
        });
        jPanel13.add(btn_Cproyek);

        btn_Uproyek.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Uproyek.setText("UBAH");
        btn_Uproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UproyekActionPerformed(evt);
            }
        });
        jPanel13.add(btn_Uproyek);

        btn_Dproyek.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Dproyek.setText("HAPUS");
        btn_Dproyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DproyekActionPerformed(evt);
            }
        });
        jPanel13.add(btn_Dproyek);

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel8.setText("Nama Proyek           :");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id_Proyek, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tf_Namaproyek, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(tf_Durasiproyek, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)))
                .addGap(20, 20, 20))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(id_Proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Namaproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(11, 11, 11)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Durasiproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbl_Proyek.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_ProyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_Proyek);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        proyek.add(jPanel8, java.awt.BorderLayout.CENTER);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(0, 100));
        jPanel9.setLayout(null);

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\USER\\Downloads\\Tanpa judul (672 x 100 piksel).png")); // NOI18N
        jPanel9.add(jLabel13);
        jLabel13.setBounds(0, 0, 950, 100);

        jLabel14.setFont(new java.awt.Font("Berlin Sans FB", 1, 12)); // NOI18N
        jLabel14.setText("AMBATUKAM GROUP");
        jPanel9.add(jLabel14);
        jLabel14.setBounds(253, 50, 160, 40);

        jLabel18.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel18.setText("PROYEK PEMBANGUNAN");
        jPanel9.add(jLabel18);
        jLabel18.setBounds(10, 10, 230, 50);

        proyek.add(jPanel9, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("proyek", proyek);

        transaksi.setLayout(new java.awt.BorderLayout());

        jPanel10.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel9.setText("Karyawan                :");

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel11.setText("Peran                       :");

        jPanel15.setLayout(new java.awt.GridLayout(1, 0));

        btn_Ctransaksi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Ctransaksi.setText("SIMPAN");
        btn_Ctransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_CtransaksiActionPerformed(evt);
            }
        });
        jPanel15.add(btn_Ctransaksi);

        btn_Utransaksi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Utransaksi.setText("UBAH");
        btn_Utransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UtransaksiActionPerformed(evt);
            }
        });
        jPanel15.add(btn_Utransaksi);

        btn_Dtransaksi.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btn_Dtransaksi.setText("HAPUS");
        btn_Dtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_DtransaksiActionPerformed(evt);
            }
        });
        jPanel15.add(btn_Dtransaksi);

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel12.setText("Proyek                     :");

        CB_Karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 12)); // NOI18N
        jLabel10.setText("Minggu");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(CB_Proyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(CB_Karyawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(tf_Perantransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)))
                .addGap(20, 20, 20))
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(CB_Karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(CB_Proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_Perantransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        tbl_Transaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tbl_Transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_TransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_Transaksi);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 448, Short.MAX_VALUE))
                .addGap(106, 106, 106))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(98, Short.MAX_VALUE))
        );

        transaksi.add(jPanel10, java.awt.BorderLayout.CENTER);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(672, 100));

        jLabel19.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel19.setText("TRANSAKSI PEMBANGUNAN");

        jLabel16.setFont(new java.awt.Font("Berlin Sans FB", 1, 18)); // NOI18N
        jLabel16.setText("AMBATUKAM GROUP");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel19)
                .addContainerGap(224, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addGap(143, 143, 143))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel16)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        transaksi.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jTabbedPane1.addTab("transaksi", transaksi);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 672, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_CkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CkaryawanActionPerformed
        // TODO add your handling code here:
        tambahKaryawan();
    }//GEN-LAST:event_btn_CkaryawanActionPerformed

    private void btn_UkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UkaryawanActionPerformed
        // TODO add your handling code here:
        updateKaryawan();
    }//GEN-LAST:event_btn_UkaryawanActionPerformed

    private void btn_DkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DkaryawanActionPerformed
        // TODO add your handling code here:
        if (id_Karyawan.getText().trim().isEmpty() || 
        tf_Nama.getText().trim().isEmpty() || 
        tf_Jabatan.getText().trim().isEmpty() || 
        tf_Departemen.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
        int reset = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus data ini?", "Konfirmasi hapus", JOptionPane.YES_NO_OPTION);
        if(reset == JOptionPane.YES_OPTION){
        hapusKaryawan();
        }else if(reset == JOptionPane.NO_OPTION){
        }
        clearKaryawanFields();
    }//GEN-LAST:event_btn_DkaryawanActionPerformed

    private void btn_CproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CproyekActionPerformed
        // TODO add your handling code here:
        tambahProyek();
    }//GEN-LAST:event_btn_CproyekActionPerformed

    private void btn_UproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UproyekActionPerformed
        // TODO add your handling code here:
        updateProyek();
    }//GEN-LAST:event_btn_UproyekActionPerformed

    private void btn_DproyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DproyekActionPerformed
        // TODO add your handling code here:
        if (id_Proyek.getText().trim().isEmpty() || 
        tf_Namaproyek.getText().trim().isEmpty() || 
        tf_Durasiproyek.getText().trim().isEmpty()) {
        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return; 
    }
        int reset = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus data ini?", "Konfirmasi hapus", JOptionPane.YES_NO_OPTION);
        if(reset == JOptionPane.YES_OPTION){
        hapusProyek();
        }else if(reset == JOptionPane.NO_OPTION){
        }
        clearProyekFields();
    }//GEN-LAST:event_btn_DproyekActionPerformed

    private void btn_CtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_CtransaksiActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_btn_CtransaksiActionPerformed

    private void btn_UtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UtransaksiActionPerformed
        // TODO add your handling code here:
        updateTransaksi();
    }//GEN-LAST:event_btn_UtransaksiActionPerformed

    private void btn_DtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_DtransaksiActionPerformed
        // TODO add your handling code here:
//        if (CB_Karyawan.getSelectedIndex() == 0 || 
//        CB_Proyek.getSelectedIndex() == 0 || 
//        tf_Departemen.getText().trim().isEmpty()) {
//        JOptionPane.showMessageDialog(this, "Semua field harus diisi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
//        return; 
//    }
        int reset = JOptionPane.showConfirmDialog(null, "Apakah Anda ingin menghapus data ini?", "Konfirmasi hapus", JOptionPane.YES_NO_OPTION);
        if(reset == JOptionPane.YES_OPTION){
        hapusTransaksi();
        }else if(reset == JOptionPane.NO_OPTION){
        }
        clearTransaksiFields();
    }//GEN-LAST:event_btn_DtransaksiActionPerformed

    private void tbl_KaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_KaryawanMouseClicked
        // TODO add your handling code here:
        int row = tbl_Karyawan.getSelectedRow(); 
        
        if (row != -1) {
            id_Karyawan.setText(tbl_Karyawan.getValueAt(row, 0).toString());
            tf_Nama.setText(tbl_Karyawan.getValueAt(row, 1).toString());
            tf_Jabatan.setText(tbl_Karyawan.getValueAt(row, 2).toString()); 
            tf_Departemen.setText(tbl_Karyawan.getValueAt(row, 3).toString());    
        }
    }//GEN-LAST:event_tbl_KaryawanMouseClicked

    private void tbl_ProyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_ProyekMouseClicked
        // TODO add your handling code here:
        int row = tbl_Proyek.getSelectedRow(); 
        
        if (row != -1) {
            id_Proyek.setText(tbl_Proyek.getValueAt(row, 0).toString());
            tf_Namaproyek.setText(tbl_Proyek.getValueAt(row, 1).toString());
            tf_Durasiproyek.setText(tbl_Proyek.getValueAt(row, 2).toString().replace("Minggu", ""));    
        }
    }//GEN-LAST:event_tbl_ProyekMouseClicked

    private void tbl_TransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_TransaksiMouseClicked
        // TODO add your handling code here:
        int row = tbl_Transaksi.getSelectedRow();
        if (row != -1) {
            // Dapatkan nilai ID dari tabel
            String idKaryawanText = tbl_Transaksi.getValueAt(row, 0).toString();
            String idProyekText = tbl_Transaksi.getValueAt(row, 1).toString();

            int idKaryawan = Integer.parseInt(idKaryawanText);
            int idProyek = Integer.parseInt(idProyekText);

            for (int i = 0; i < CB_Karyawan.getItemCount(); i++) {
                String itemText = CB_Karyawan.getItemAt(i);
                if (getSelectedId(itemText) == idKaryawan) {
                    CB_Karyawan.setSelectedIndex(i);
                    break;
                }
            }

            for (int i = 0; i < CB_Proyek.getItemCount(); i++) {
                String itemText = CB_Proyek.getItemAt(i);
                if (getSelectedId(itemText) == idProyek) {
                    CB_Proyek.setSelectedIndex(i);
                    break;
                }
            }
            tf_Perantransaksi.setText(tbl_Transaksi.getValueAt(row, 4).toString().replace("Minggu", ""));
        }
    }//GEN-LAST:event_tbl_TransaksiMouseClicked
    
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
            java.util.logging.Logger.getLogger(manajemenkaryawanproyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(manajemenkaryawanproyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(manajemenkaryawanproyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(manajemenkaryawanproyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new manajemenkaryawanproyek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CB_Karyawan;
    private javax.swing.JComboBox<String> CB_Proyek;
    private javax.swing.JButton btn_Ckaryawan;
    private javax.swing.JButton btn_Cproyek;
    private javax.swing.JButton btn_Ctransaksi;
    private javax.swing.JButton btn_Dkaryawan;
    private javax.swing.JButton btn_Dproyek;
    private javax.swing.JButton btn_Dtransaksi;
    private javax.swing.JButton btn_Ukaryawan;
    private javax.swing.JButton btn_Uproyek;
    private javax.swing.JButton btn_Utransaksi;
    private javax.swing.JTextField id_Karyawan;
    private javax.swing.JTextField id_Proyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
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
    private javax.swing.JPanel karyawan;
    private javax.swing.JPanel proyek;
    private javax.swing.JTable tbl_Karyawan;
    private javax.swing.JTable tbl_Proyek;
    private javax.swing.JTable tbl_Transaksi;
    private javax.swing.JTextField tf_Departemen;
    private javax.swing.JTextField tf_Durasiproyek;
    private javax.swing.JTextField tf_Jabatan;
    private javax.swing.JTextField tf_Nama;
    private javax.swing.JTextField tf_Namaproyek;
    private javax.swing.JTextField tf_Perantransaksi;
    private javax.swing.JPanel transaksi;
    // End of variables declaration//GEN-END:variables
}
