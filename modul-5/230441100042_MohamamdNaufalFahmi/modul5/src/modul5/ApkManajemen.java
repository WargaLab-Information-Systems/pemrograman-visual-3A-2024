/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;
import java.sql.Connection;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.*;
import javax.swing.JComboBox;
/**
 *
 * @author THINKPAD
 */
public class ApkManajemen extends javax.swing.JFrame {
    private Connection conn;
    /**
     * Creates new form ApkManajemen
     */
    public ApkManajemen() {
        initComponents();
        conn = koneksi.getKoneksi();
        loadTblKaryawan();
        loadTblProyek();
        loadTblTransaksi();
        loadComboBoxData();
    }
    // load tabel
    private void loadTblKaryawan() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nama");
    model.addColumn("Jabatan");
    model.addColumn("Departemen");
    try {
        String sql = "SELECT * FROM tb_karyawan";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[] {
                rs.getInt("id"),
                rs.getString("nama"),
                rs.getString("jabatan"),
                rs.getString("departemen")
            });
        }
        tbl_karyawan.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Load Data Karyawan: " + e.getMessage());
    }
}
    private void loadTblProyek() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("ID");
    model.addColumn("Nama Proyek");
    model.addColumn("Pengerjaan Mingguan");
    try {
//        int no = 1;
        String sql = "SELECT * FROM tb_proyek";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[] {
//                no++,
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getInt("durasi_pengerjaan")
            });
        }
        tbl_proyek.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error Load Data Proyek: " + e.getMessage());
    }
}
    private void loadTblTransaksi() {
    DefaultTableModel model = new DefaultTableModel();
    model.addColumn("No");
    model.addColumn("ID Karyawan");
    model.addColumn("ID Proyek");
    model.addColumn("Karyawan");
    model.addColumn("Proyek");
    model.addColumn("Peran");
    try {
        int no = 1;
        String sql = "SELECT t.id_karyawan, t.id_proyek, t.peran, " +
                     "k.nama AS nama_karyawan, p.nama_proyek AS nama_proyek " +
                     "FROM tb_transaksi t " +
                     "JOIN tb_karyawan k ON t.id_karyawan = k.id " +
                     "JOIN tb_proyek p ON t.id_proyek = p.id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            model.addRow(new Object[] {
                no++,
                rs.getInt("id_karyawan"),
                rs.getInt("id_proyek"),
                rs.getString("nama_karyawan"),
                rs.getString("nama_proyek"),
                rs.getString("peran")
            });
        }
        tbl_transaksi.setModel(model);
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Error load data transaksi: " + e.getMessage());
    }
}
// end load tabel
// reset
    private void resetK() {
        tf_idK.setText("");
        tf_namaK.setText("");
        tf_jabatanK.setText("");
        tf_departemenK.setText("");
    }
    private void resetP() {
        tf_idP.setText("");
        tf_namaP.setText("");
        tf_durasiP.setText("");
    }
    private void resetT() {
        comboK.setSelectedIndex(0); 
        comboP.setSelectedIndex(0); 
        tf_namaK.setText("");
        tf_namaP.setText("");
        tf_peran.setText("");             
    }
// end reset
// load combo box
    private void loadComboBoxData() {
        // ComboBox Karyawan
        try {
            String sql = "SELECT id, nama FROM tb_karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Format "id - nama" untuk ComboBox
                String item = rs.getString("id") + " - " + rs.getString("nama");
                comboK.addItem(item);  // Tambah item
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error load data karyawan: " + e.getMessage());
        }
        // ComboBox Proyek
        try {
            String sql = "SELECT id, nama_proyek FROM tb_proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                // Format "id - nama_proyek" untuk ComboBox
                String item = rs.getString("id") + " - " + rs.getString("nama_proyek");
                comboP.addItem(item);  // Tambah item
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error load data proyek: " + e.getMessage());
        }
    }
// end load combo box
// pilih item berdasarkan ID
private void selectComboBoxItem(JComboBox comboBox, String id) {
    // format "ID - Nama"
    for (int i = 0; i < comboBox.getItemCount(); i++) {
        String item = comboBox.getItemAt(i).toString();
        if (item.startsWith(id + " -")) {  // Cek item dengan id benar
            comboBox.setSelectedIndex(i);  // Pilih item 
            break;
        }
    }
}
// end pilih item
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atas = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bawah = new javax.swing.JPanel();
        btnExit = new javax.swing.JButton();
        tengah = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        karyawan = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        tf_idK = new javax.swing.JTextField();
        tf_namaK = new javax.swing.JTextField();
        tf_jabatanK = new javax.swing.JTextField();
        tf_departemenK = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        btnTambahK = new javax.swing.JButton();
        btnUpdateK = new javax.swing.JButton();
        btnDeleteK = new javax.swing.JButton();
        proyek = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        tf_idP = new javax.swing.JTextField();
        tf_namaP = new javax.swing.JTextField();
        tf_durasiP = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        btnTambahP = new javax.swing.JButton();
        btnUpdateP = new javax.swing.JButton();
        btnDeleteP = new javax.swing.JButton();
        transaksi = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        comboK = new javax.swing.JComboBox<>();
        comboP = new javax.swing.JComboBox<>();
        tf_peran = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        btnTambahT = new javax.swing.JButton();
        btnUpdateT = new javax.swing.JButton();
        btnDeleteT = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        atas.setBackground(new java.awt.Color(86, 99, 115));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5/pekerja.png"))); // NOI18N
        atas.add(jLabel1);

        jLabel2.setFont(new java.awt.Font("Schadow BT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 232, 255));
        jLabel2.setText("APLIKASI MANAJEMEN KERJA");
        atas.add(jLabel2);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul5/grafik.png"))); // NOI18N
        atas.add(jLabel3);

        getContentPane().add(atas, java.awt.BorderLayout.PAGE_START);

        bawah.setBackground(new java.awt.Color(86, 99, 115));
        bawah.setPreferredSize(new java.awt.Dimension(597, 50));

        btnExit.setBackground(new java.awt.Color(255, 0, 51));
        btnExit.setForeground(new java.awt.Color(204, 232, 255));
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bawahLayout = new javax.swing.GroupLayout(bawah);
        bawah.setLayout(bawahLayout);
        bawahLayout.setHorizontalGroup(
            bawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bawahLayout.createSequentialGroup()
                .addContainerGap(504, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(21, 21, 21))
        );
        bawahLayout.setVerticalGroup(
            bawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bawahLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(btnExit)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        getContentPane().add(bawah, java.awt.BorderLayout.PAGE_END);

        tengah.setBackground(new java.awt.Color(155, 209, 255));

        jTabbedPane1.setBackground(new java.awt.Color(206, 213, 231));
        jTabbedPane1.setForeground(new java.awt.Color(86, 99, 115));
        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        karyawan.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(206, 213, 231));

        jLabel4.setFont(new java.awt.Font("Schadow BT", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(86, 99, 115));
        jLabel4.setText("KARYAWAN");
        jPanel5.add(jLabel4);

        karyawan.add(jPanel5, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBackground(new java.awt.Color(204, 232, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(86, 99, 115));
        jLabel7.setText("ID");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(86, 99, 115));
        jLabel8.setText("Nama");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, -1, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(86, 99, 115));
        jLabel9.setText("Jabatan");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(86, 99, 115));
        jLabel10.setText("Departemen");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, -1, -1));

        tf_idK.setEditable(false);
        tf_idK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idKActionPerformed(evt);
            }
        });
        jPanel6.add(tf_idK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, 170, -1));

        tf_namaK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaKActionPerformed(evt);
            }
        });
        jPanel6.add(tf_namaK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 170, -1));

        tf_jabatanK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_jabatanKActionPerformed(evt);
            }
        });
        jPanel6.add(tf_jabatanK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 100, 170, -1));
        jPanel6.add(tf_departemenK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 140, 170, -1));

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

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 440, 220));

        btnTambahK.setBackground(new java.awt.Color(86, 99, 115));
        btnTambahK.setForeground(new java.awt.Color(204, 232, 255));
        btnTambahK.setText("Tambah");
        btnTambahK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahKActionPerformed(evt);
            }
        });
        jPanel6.add(btnTambahK, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        btnUpdateK.setBackground(new java.awt.Color(86, 99, 115));
        btnUpdateK.setForeground(new java.awt.Color(204, 232, 255));
        btnUpdateK.setText("Update");
        btnUpdateK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateKActionPerformed(evt);
            }
        });
        jPanel6.add(btnUpdateK, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        btnDeleteK.setBackground(new java.awt.Color(86, 99, 115));
        btnDeleteK.setForeground(new java.awt.Color(204, 232, 255));
        btnDeleteK.setText("Delete");
        btnDeleteK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteKActionPerformed(evt);
            }
        });
        jPanel6.add(btnDeleteK, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        karyawan.add(jPanel6, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Karyawan", karyawan);

        proyek.setLayout(new java.awt.BorderLayout());

        jPanel8.setBackground(new java.awt.Color(206, 213, 231));

        jLabel5.setFont(new java.awt.Font("Schadow BT", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(86, 99, 115));
        jLabel5.setText("PROYEK");
        jPanel8.add(jLabel5);

        proyek.add(jPanel8, java.awt.BorderLayout.PAGE_START);

        jPanel9.setBackground(new java.awt.Color(204, 232, 255));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(86, 99, 115));
        jLabel11.setText("ID");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(86, 99, 115));
        jLabel12.setText("Nama Proyek");
        jPanel9.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(86, 99, 115));
        jLabel13.setText("Durasi Pengerjaan");
        jPanel9.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        tf_idP.setEditable(false);
        jPanel9.add(tf_idP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, 170, -1));
        jPanel9.add(tf_namaP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 170, -1));

        tf_durasiP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_durasiPKeyReleased(evt);
            }
        });
        jPanel9.add(tf_durasiP, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 170, -1));

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

        jPanel9.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 440, 240));

        jLabel14.setForeground(new java.awt.Color(86, 99, 115));
        jLabel14.setText("Per Minggu");
        jPanel9.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 120, -1, -1));

        btnTambahP.setBackground(new java.awt.Color(86, 99, 115));
        btnTambahP.setForeground(new java.awt.Color(204, 232, 255));
        btnTambahP.setText("Tambah");
        btnTambahP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahPActionPerformed(evt);
            }
        });
        jPanel9.add(btnTambahP, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, -1, -1));

        btnUpdateP.setBackground(new java.awt.Color(86, 99, 115));
        btnUpdateP.setForeground(new java.awt.Color(204, 232, 255));
        btnUpdateP.setText("Update");
        btnUpdateP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePActionPerformed(evt);
            }
        });
        jPanel9.add(btnUpdateP, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 440, -1, -1));

        btnDeleteP.setBackground(new java.awt.Color(86, 99, 115));
        btnDeleteP.setForeground(new java.awt.Color(204, 232, 255));
        btnDeleteP.setText("Delete");
        btnDeleteP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePActionPerformed(evt);
            }
        });
        jPanel9.add(btnDeleteP, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        proyek.add(jPanel9, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Proyek", proyek);

        transaksi.setLayout(new java.awt.BorderLayout());

        jPanel11.setBackground(new java.awt.Color(206, 213, 231));

        jLabel6.setFont(new java.awt.Font("Schadow BT", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(86, 99, 115));
        jLabel6.setText("TRANSAKSI");
        jPanel11.add(jLabel6);

        transaksi.add(jPanel11, java.awt.BorderLayout.PAGE_START);

        jPanel12.setBackground(new java.awt.Color(204, 232, 255));
        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(86, 99, 115));
        jLabel15.setText("ID Karyawan");
        jPanel12.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, -1, -1));

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(86, 99, 115));
        jLabel16.setText("ID Proyek");
        jPanel12.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(86, 99, 115));
        jLabel17.setText("Peran");
        jPanel12.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        comboK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan Pilih" }));
        comboK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboKActionPerformed(evt);
            }
        });
        jPanel12.add(comboK, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 160, -1));

        comboP.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Silahkan pilih" }));
        comboP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPActionPerformed(evt);
            }
        });
        jPanel12.add(comboP, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 160, -1));
        jPanel12.add(tf_peran, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 160, -1));

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

        jPanel12.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 440, 240));

        btnTambahT.setBackground(new java.awt.Color(86, 99, 115));
        btnTambahT.setForeground(new java.awt.Color(204, 232, 255));
        btnTambahT.setText("Tambah");
        btnTambahT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahTActionPerformed(evt);
            }
        });
        jPanel12.add(btnTambahT, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        btnUpdateT.setBackground(new java.awt.Color(86, 99, 115));
        btnUpdateT.setForeground(new java.awt.Color(204, 232, 255));
        btnUpdateT.setText("Update");
        btnUpdateT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTActionPerformed(evt);
            }
        });
        jPanel12.add(btnUpdateT, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, -1, -1));

        btnDeleteT.setBackground(new java.awt.Color(86, 99, 115));
        btnDeleteT.setForeground(new java.awt.Color(204, 232, 255));
        btnDeleteT.setText("Delete");
        btnDeleteT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteTActionPerformed(evt);
            }
        });
        jPanel12.add(btnDeleteT, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 430, -1, -1));

        transaksi.add(jPanel12, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Transaksi", transaksi);

        javax.swing.GroupLayout tengahLayout = new javax.swing.GroupLayout(tengah);
        tengah.setLayout(tengahLayout);
        tengahLayout.setHorizontalGroup(
            tengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 597, Short.MAX_VALUE)
        );
        tengahLayout.setVerticalGroup(
            tengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
        );

        getContentPane().add(tengah, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_jabatanKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_jabatanKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_jabatanKActionPerformed

    private void tf_idKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idKActionPerformed

    private void tf_namaKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaKActionPerformed

    private void btnTambahPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahPActionPerformed
        // Tambah tabel Proyek
        // Input dari form untuk proyek
        String namaProyek = tf_namaP.getText();   
        String durasiPengerjaan = tf_durasiP.getText();   
        // input tidak boleh kosong
        if (namaProyek.isEmpty() || durasiPengerjaan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Tambah data ke tabel tb_proyek
            String sql = "INSERT INTO tb_proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaProyek);
            ps.setString(2, durasiPengerjaan);
            // Eksekusi query dan cek hasil
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data proyek berhasil disimpan!");
                loadTblProyek();  // Memperbarui tabel proyek
                resetP();         // Reset 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahPActionPerformed

    private void btnUpdateKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateKActionPerformed
        // Update Data Karyawan
        // Ambil data dari form
        String id = tf_idK.getText();
        String nama = tf_namaK.getText();           
        String jabatan = tf_jabatanK.getText();     
        String departemen = tf_departemenK.getText(); 
        // input tidak boleh kosong
        if (id.isEmpty() || nama.isEmpty() || jabatan.isEmpty() || departemen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Update data di tabel tb_karyawan berdasarkan id
            String sql = "UPDATE tb_karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setString(2, jabatan);
            ps.setString(3, departemen);
            ps.setString(4, id);
            // Eksekusi query dan cek hasil
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data karyawan berhasil diperbarui!");
                loadTblKaryawan();
                resetK();           
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateKActionPerformed

    private void btnDeletePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePActionPerformed
        // Delete Data Proyek
        try {
            // Ambil ID yang dipilih dari field
            String id = tf_idP.getText();  // ID proyek yang akan dihapus
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Jika ID kosong, peringatan
            }
            // Konfirmasi penghapusan
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data proyek ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Menghapus data berdasarkan ID yang dipilih
                String sql = "DELETE FROM tb_proyek WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, id);  // Menetapkan ID untuk dihapus
                ps.executeUpdate();  // Eksekusi query penghapusan
                JOptionPane.showMessageDialog(this, "Data proyek berhasil dihapus!");
                // Memeriksa apakah tabel kosong
                String checkSql = "SELECT COUNT(*) AS total FROM tb_proyek";
                PreparedStatement checkPs = conn.prepareStatement(checkSql);
                ResultSet rs = checkPs.executeQuery();
                if (rs.next() && rs.getInt("total") == 0) {
                    // Jika tabel kosong, reset AUTO_INCREMENT ke 1
                    String resetSql = "ALTER TABLE tb_proyek AUTO_INCREMENT = 1";
                    PreparedStatement resetPs = conn.prepareStatement(resetSql);
                    resetPs.executeUpdate();
                }
                loadTblProyek();
                resetP();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeletePActionPerformed

    private void btnUpdateTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTActionPerformed
        // Update Data Transaksi
        // Ambil data dari form
        String selectedKaryawan = comboK.getSelectedItem().toString();
        String selectedProyek = comboP.getSelectedItem().toString();
        String peran = tf_peran.getText();  // Peran yang akan diupdate
        // Mengambil ID Karyawan dan ID Proyek dari combo box (ID berada sebelum tanda "-")
        String idKaryawan = selectedKaryawan.split(" - ")[0];
        String idProyek = selectedProyek.split(" - ")[0];
        // input tidak boleh kosong
        if (peran.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Query untuk memperbarui data peran berdasarkan ID Karyawan dan ID Proyek
            String sql = "UPDATE tb_transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, peran);
            ps.setString(2, idKaryawan); 
            ps.setString(3, idProyek);    
            // Eksekusi query dan cek hasil
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diperbarui!");
                loadTblTransaksi();
                resetT();    
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdateTActionPerformed

    private void btnTambahKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahKActionPerformed
        // Tambah Data Karyawan
        // input dari form
        String nama = tf_namaK.getText();           
        String jabatan = tf_jabatanK.getText();     
        String departemen = tf_departemenK.getText(); 
        // input tidak boleh kosong
        if (nama.isEmpty() || jabatan.isEmpty() || departemen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
         try {
        // menambahkan data ke tabel tb_karyawan
        String sql = "INSERT INTO tb_karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, nama);
        ps.setString(2, jabatan);
        ps.setString(3, departemen);
        // eksekusi query dan cek hasil
        int rowsInserted = ps.executeUpdate();
        if (rowsInserted > 0) {
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil disimpan!");
            loadTblKaryawan();
            resetK();      
        }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahKActionPerformed

    private void tbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_karyawanMouseClicked
        // TODO add your handling code here:
        int row = tbl_karyawan.getSelectedRow(); 
        if (row != -1) {
            // Isi field dengan data dari baris yang diklik
            tf_idK.setText(tbl_karyawan.getValueAt(row, 0).toString());
            tf_namaK.setText(tbl_karyawan.getValueAt(row, 1).toString());
            tf_jabatanK.setText(tbl_karyawan.getValueAt(row, 2).toString());
            tf_departemenK.setText(tbl_karyawan.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_tbl_karyawanMouseClicked

    private void btnDeleteKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteKActionPerformed
        // Delete Data Karyawan
        try {
            // Ambil ID yang dipilih dari field
            String id = tf_idK.getText();  // ID yang akan dihapus
            if (id.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Jika ID kosong, ada peringatan
            }
            // Konfirmasi penghapusan
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                // Query untuk menghapus data berdasarkan ID yang dipilih
                String sql = "DELETE FROM tb_karyawan WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, id);  // ID yang dipilih untuk dihapus
                ps.executeUpdate();  
                JOptionPane.showMessageDialog(this, "Data karyawan berhasil dihapus!");
                // Memeriksa apakah tabel kosong
                String checkSql = "SELECT COUNT(*) AS total FROM tb_karyawan";
                PreparedStatement checkPs = conn.prepareStatement(checkSql);
                ResultSet rs = checkPs.executeQuery();
                if (rs.next() && rs.getInt("total") == 0) {
                    // Jika tabel kosong, reset AUTO_INCREMENT ke 1
                    String resetSql = "ALTER TABLE tb_karyawan AUTO_INCREMENT = 1";
                    PreparedStatement resetPs = conn.prepareStatement(resetSql);
                    resetPs.executeUpdate();
                }
                loadTblKaryawan();
                resetK(); 
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDeleteKActionPerformed

    private void tbl_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proyekMouseClicked
        // TODO add your handling code here:
        int row = tbl_proyek.getSelectedRow();
        if (row != -1) {
            tf_idP.setText(tbl_proyek.getValueAt(row, 0).toString());  
            tf_namaP.setText(tbl_proyek.getValueAt(row, 1).toString());  
            tf_durasiP.setText(tbl_proyek.getValueAt(row, 2).toString());  
        }
    }//GEN-LAST:event_tbl_proyekMouseClicked

    private void btnUpdatePActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePActionPerformed
        // Update Data Proyek
        // Ambil data dari form
        String id = tf_idP.getText();  // Ambil ID proyek dari form
        String namaProyek = tf_namaP.getText();  // Nama proyek
        String pengerjaanMingguan = tf_durasiP.getText();  // Durasi pengerjaan per minggu
        // input tidak boleh kosong
        if (id.isEmpty() || namaProyek.isEmpty() || pengerjaanMingguan.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Update data di tabel tb_proyek berdasarkan id
            String sql = "UPDATE tb_proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaProyek);
            ps.setString(2, pengerjaanMingguan);
            ps.setString(3, id);
            // Eksekusi query dan cek hasil
            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(this, "Data proyek berhasil diperbarui!");
                loadTblProyek();  
                resetP();  
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal memperbarui data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUpdatePActionPerformed

    private void btnTambahTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahTActionPerformed
        // Tambah Data Transaksi
        String selectedKaryawan = comboK.getSelectedItem().toString();
        String selectedProyek = comboP.getSelectedItem().toString();
        // Mengambil ID karyawan dan ID proyek dari combo box (ID berada sebelum tanda "-")
        String idKaryawan = selectedKaryawan.split(" - ")[0];
        String idProyek = selectedProyek.split(" - ")[0];
        String peran = tf_peran.getText();  
        // input tidak boleh kosong
        if (idKaryawan.isEmpty() || idProyek.isEmpty() || peran.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data tidak boleh kosong!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Menambahkan data ke tabel tb_transaksi
            String sql = "INSERT INTO tb_transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idKaryawan);  // ID Karyawan yang dipilih
            ps.setString(2, idProyek);    
            ps.setString(3, peran);       
            // Eksekusi query dan cek hasil
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan!");
                loadTblTransaksi(); 
                resetT();    
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Gagal menyimpan data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnTambahTActionPerformed

    private void comboKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboKActionPerformed
        // TODO add your handling code here:
        // Menampilkan nama karyawan berdasarkan ID yang dipilih
        String selectedKaryawan = comboK.getSelectedItem().toString();
        String idKaryawan = selectedKaryawan.split(" - ")[0];  // Ambil ID karyawan dari string
        try {
            String sql = "SELECT nama FROM tb_karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idKaryawan);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tf_namaK.setText(rs.getString("nama"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching karyawan data: " + e.getMessage());
        }
    }//GEN-LAST:event_comboKActionPerformed

    private void comboPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPActionPerformed
        // TODO add your handling code here:
        // Menampilkan nama proyek berdasarkan ID yang dipilih
        String selectedProyek = comboP.getSelectedItem().toString();
        String idProyek = selectedProyek.split(" - ")[0];  // Ambil ID proyek dari string
        try {
            String sql = "SELECT nama_proyek FROM tb_proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, idProyek);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                tf_namaP.setText(rs.getString("nama_proyek"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error fetching proyek data: " + e.getMessage());
        }
    }//GEN-LAST:event_comboPActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // TODO add your handling code here:
        // Mendapatkan baris yang dipilih dari tabel
        int row = tbl_transaksi.getSelectedRow(); 
        if (row != -1) {  
            String idKaryawan = tbl_transaksi.getValueAt(row, 1).toString();  
            String idProyek = tbl_transaksi.getValueAt(row, 2).toString();    
            String peran = tbl_transaksi.getValueAt(row, 5).toString();       
            // Menampilkan data yang dipilih ke dalam form input
            // Pilih ID Karyawan di combo box
            selectComboBoxItem(comboK, idKaryawan);  
            // Pilih ID Proyek di combo box
            selectComboBoxItem(comboP, idProyek); 
            tf_peran.setText(peran);
        }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void btnDeleteTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteTActionPerformed
        // Delete Data Transaksi
        // Ambil ID yang dipilih dari combo box
        String selectedKaryawan = comboK.getSelectedItem().toString();
        String selectedProyek = comboP.getSelectedItem().toString();
        // Mengambil ID Karyawan dan ID Proyek dari combo box (ID berada sebelum tanda "-")
        String idKaryawan = selectedKaryawan.split(" - ")[0];
        String idProyek = selectedProyek.split(" - ")[0];
        // Konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data transaksi ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Query untuk menghapus data transaksi berdasarkan ID Karyawan dan ID Proyek
                String sql = "DELETE FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, idKaryawan);  // ID Karyawan
                ps.setString(2, idProyek);    // ID Proyek
                // Eksekusi query penghapusan
                int rowsDeleted = ps.executeUpdate();
                if (rowsDeleted > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus!");
                    loadTblTransaksi();
                    resetT();    
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnDeleteTActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null,"Keluar Program?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void tf_durasiPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_durasiPKeyReleased
        // TODO add your handling code here:
        String input = tf_durasiP.getText();
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Durasi pengerjaan harus berupa angka!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            tf_durasiP.setText("");  // field durasi kosong jika bukan angka
        }
    }//GEN-LAST:event_tf_durasiPKeyReleased

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
            java.util.logging.Logger.getLogger(ApkManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApkManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApkManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApkManajemen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApkManajemen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel atas;
    private javax.swing.JPanel bawah;
    private javax.swing.JButton btnDeleteK;
    private javax.swing.JButton btnDeleteP;
    private javax.swing.JButton btnDeleteT;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnTambahK;
    private javax.swing.JButton btnTambahP;
    private javax.swing.JButton btnTambahT;
    private javax.swing.JButton btnUpdateK;
    private javax.swing.JButton btnUpdateP;
    private javax.swing.JButton btnUpdateT;
    private javax.swing.JComboBox<String> comboK;
    private javax.swing.JComboBox<String> comboP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel karyawan;
    private javax.swing.JPanel proyek;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JPanel tengah;
    private javax.swing.JTextField tf_departemenK;
    private javax.swing.JTextField tf_durasiP;
    private javax.swing.JTextField tf_idK;
    private javax.swing.JTextField tf_idP;
    private javax.swing.JTextField tf_jabatanK;
    private javax.swing.JTextField tf_namaK;
    private javax.swing.JTextField tf_namaP;
    private javax.swing.JTextField tf_peran;
    private javax.swing.JPanel transaksi;
    // End of variables declaration//GEN-END:variables
}
