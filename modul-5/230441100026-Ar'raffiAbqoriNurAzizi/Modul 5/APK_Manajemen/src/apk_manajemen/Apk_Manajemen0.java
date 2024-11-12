package apk_manajemen;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Apk_Manajemen0 extends javax.swing.JFrame {
    Connection konek;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
    private DefaultTableModel model3;

    public Apk_Manajemen0() {
        initComponents();
        setTitle("INPUT DATA KARYAWAN DAN OPERASIONAL");
        konek = Koneksi.getConnection();
        
        model1 = new DefaultTableModel();
        tbl_karyawan.setModel(model1);
        model1.addColumn("ID");
        model1.addColumn("Nama");
        model1.addColumn("Jabatan");
        model1.addColumn("Departemen");
        loadEmployee();
        
        model2 = new DefaultTableModel();
        tbl_proyek.setModel(model2);
        model2.addColumn("ID");
        model2.addColumn("Nama Proyek");
        model2.addColumn("Durasi(minggu)");
        loadProject();
        
        model3 = new DefaultTableModel();
        tbl_transaksi.setModel(model3);
        model3.addColumn("Pegawai");
        model3.addColumn("Proyek");
        model3.addColumn("Peran");
        loadTransaction();
        
        loadEmployeeNames();
        loadProjectNames();
    }

    private void loadEmployee(){
        model1.setRowCount(0);
        try{
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               model1.addRow(new Object[]{
               rs.getInt("id"),
               rs.getString("nama"),
               rs.getString("jabatan"),
               rs.getString("departemen")
            });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
    }
    
    private void loadProject() {
        model2.setRowCount(0);
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model2.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void loadTransaction() {
        model3.setRowCount(0);
        try {
            String sql = "SELECT k.nama AS karyawan, p.nama_proyek AS proyek, t.peran " +
                         "FROM transaksi t " +
                         "JOIN karyawan k ON t.id_karyawan = k.id " +
                         "JOIN proyek p ON t.id_proyek = p.id";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                model3.addRow(new Object[]{
                    rs.getString("karyawan"),
                    rs.getString("proyek"),
                    rs.getString("peran")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading transaction data: " + e.getMessage());
        }
    }
    
     private void loadEmployeeNames() {
        cmb_transaksi_karyawan.removeAllItems();
        try {
            String sql = "SELECT nama FROM karyawan";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmb_transaksi_karyawan.addItem(rs.getString("nama"));
            }
        } catch (SQLException e) {
            System.out.println("Error loading employee names: " + e.getMessage());
        }
    }
    
    private void loadProjectNames() {
        cmb_transakasi_project.removeAllItems();
        try {
            String sql = "SELECT nama_proyek FROM proyek";
            PreparedStatement ps = konek.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmb_transakasi_project.addItem(rs.getString("nama_proyek"));
            }
        } catch (SQLException e) {
            System.out.println("Error loading project names: " + e.getMessage());
        }
    }
    
    private int getIdKaryawan() throws SQLException {
        String namaKaryawan = (String) cmb_transaksi_karyawan.getSelectedItem();
        String sql = "SELECT id FROM karyawan WHERE nama = ?";
        PreparedStatement ps = konek.prepareStatement(sql);
        ps.setString(1, namaKaryawan);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        throw new SQLException("ID karyawan tidak ditemukan untuk nama: " + namaKaryawan);
    }

    private int getIdProyek() throws SQLException {
        String namaProyek = (String) cmb_transakasi_project.getSelectedItem();
        String sql = "SELECT id FROM proyek WHERE nama_proyek = ?";
        PreparedStatement ps = konek.prepareStatement(sql);
        ps.setString(1, namaProyek);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getInt("id");
        }
        throw new SQLException("ID proyek tidak ditemukan untuk nama: " + namaProyek);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        shadowRenderer1 = new raven.tabbed.ShadowRenderer();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        JPKaryawan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_id_karyawan = new javax.swing.JTextField();
        tf_nama_karyawan = new javax.swing.JTextField();
        cmb_jabatan = new javax.swing.JComboBox<>();
        cmb_departemen = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        btn_TambahKaryawan = new javax.swing.JButton();
        btn_UpdateKaryawan = new javax.swing.JButton();
        btn_HapusKaryawan = new javax.swing.JButton();
        btn_ClearKaryawan = new javax.swing.JButton();
        JPProyek = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        tf_id_proyek = new javax.swing.JTextField();
        tf_durasi = new javax.swing.JTextField();
        tf_nama_proyek = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        btn_TambahProyek = new javax.swing.JButton();
        btn_UpdateProyek = new javax.swing.JButton();
        btn_HapusProyek = new javax.swing.JButton();
        btn_ClearProyek = new javax.swing.JButton();
        JPTransaksi = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        tf_peran_transaksi = new javax.swing.JTextField();
        cmb_transakasi_project = new javax.swing.JComboBox<>();
        cmb_transaksi_karyawan = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jPanel15 = new javax.swing.JPanel();
        btn_TambahTransaksi = new javax.swing.JButton();
        btn_UpdateTransaksi = new javax.swing.JButton();
        btn_HapusTransaksi = new javax.swing.JButton();
        btn_ClearTransaksi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 51, 51));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(25, 23, 21));
        jPanel3.setPreferredSize(new java.awt.Dimension(845, 60));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Fauget.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setMaximumSize(new java.awt.Dimension(40, 40));
        jLabel1.setMinimumSize(new java.awt.Dimension(40, 40));
        jLabel1.setPreferredSize(new java.awt.Dimension(40, 40));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("GeoSlab703 Md BT", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("APLIKASI MANAJEMEN");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(new java.awt.Color(25, 23, 21));
        jPanel4.setLayout(new java.awt.BorderLayout());

        tabbedPaneCustom1.setBackground(new java.awt.Color(25, 23, 21));
        tabbedPaneCustom1.setFont(new java.awt.Font("GeoSlab703 Md BT", 1, 14)); // NOI18N
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(255, 145, 77));

        JPKaryawan.setBackground(new java.awt.Color(25, 23, 21));
        JPKaryawan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(25, 23, 21));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Nama Karyawan  :");
        jPanel7.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 63, 153, -1));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("ID                       :");
        jPanel7.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 11, 153, -1));

        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jabatan              :");
        jPanel7.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 110, 153, -1));

        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Departemen        :");
        jPanel7.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(25, 158, -1, -1));

        tf_id_karyawan.setBackground(new java.awt.Color(25, 23, 21));
        tf_id_karyawan.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tf_id_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        tf_id_karyawan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_id_karyawan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_id_karyawanFocusGained(evt);
            }
        });
        jPanel7.add(tf_id_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 11, 234, 35));

        tf_nama_karyawan.setBackground(new java.awt.Color(25, 23, 21));
        tf_nama_karyawan.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tf_nama_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        tf_nama_karyawan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_nama_karyawan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_nama_karyawanFocusGained(evt);
            }
        });
        jPanel7.add(tf_nama_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 58, 234, 35));

        cmb_jabatan.setBackground(new java.awt.Color(25, 23, 21));
        cmb_jabatan.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cmb_jabatan.setForeground(new java.awt.Color(255, 255, 255));
        cmb_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Pilih Jabatan---", "Manager", "Akuntan", "Pemasaran", "Pengembang", "Supervisor" }));
        jPanel7.add(cmb_jabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 105, 234, 35));

        cmb_departemen.setBackground(new java.awt.Color(25, 23, 21));
        cmb_departemen.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cmb_departemen.setForeground(new java.awt.Color(255, 255, 255));
        cmb_departemen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---Pilih Departemen---", "HR", "IT", "Marketing", "Finance", "Operations" }));
        jPanel7.add(cmb_departemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(196, 158, 234, 36));

        JPKaryawan.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 450, 210));

        tbl_karyawan.setBackground(new java.awt.Color(25, 23, 21));
        tbl_karyawan.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tbl_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Jabatan", "Departemen"
            }
        ));
        tbl_karyawan.setGridColor(new java.awt.Color(25, 23, 21));
        tbl_karyawan.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_karyawan.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_karyawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_karyawan);

        JPKaryawan.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 233, -1, 283));

        jPanel8.setBackground(new java.awt.Color(29, 62, 105));
        jPanel8.setLayout(new java.awt.GridLayout(4, 0));

        btn_TambahKaryawan.setBackground(new java.awt.Color(29, 62, 105));
        btn_TambahKaryawan.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_TambahKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btn_TambahKaryawan.setText("Tambah");
        btn_TambahKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(btn_TambahKaryawan);

        btn_UpdateKaryawan.setBackground(new java.awt.Color(29, 62, 105));
        btn_UpdateKaryawan.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_UpdateKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btn_UpdateKaryawan.setText("Update");
        btn_UpdateKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(btn_UpdateKaryawan);

        btn_HapusKaryawan.setBackground(new java.awt.Color(29, 62, 105));
        btn_HapusKaryawan.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_HapusKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btn_HapusKaryawan.setText("Hapus");
        btn_HapusKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HapusKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(btn_HapusKaryawan);

        btn_ClearKaryawan.setBackground(new java.awt.Color(29, 62, 105));
        btn_ClearKaryawan.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_ClearKaryawan.setForeground(new java.awt.Color(255, 255, 255));
        btn_ClearKaryawan.setText("Clear");
        btn_ClearKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearKaryawanActionPerformed(evt);
            }
        });
        jPanel8.add(btn_ClearKaryawan);

        JPKaryawan.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(464, 6, 138, 510));

        tabbedPaneCustom1.addTab("DATA KARYAWAN ", JPKaryawan);

        JPProyek.setBackground(new java.awt.Color(25, 23, 21));
        JPProyek.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(25, 23, 21));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Nama Proyek      :");
        jPanel9.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 82, 154, -1));

        jLabel8.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ID                       :");
        jPanel9.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 15, 154, -1));

        jLabel11.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Durasi (minggu)  : ");
        jPanel9.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 137, -1, -1));

        tf_id_proyek.setBackground(new java.awt.Color(25, 23, 21));
        tf_id_proyek.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tf_id_proyek.setForeground(new java.awt.Color(255, 255, 255));
        tf_id_proyek.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_id_proyek.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_id_proyekFocusGained(evt);
            }
        });
        jPanel9.add(tf_id_proyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 16, 240, 36));

        tf_durasi.setBackground(new java.awt.Color(25, 23, 21));
        tf_durasi.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tf_durasi.setForeground(new java.awt.Color(255, 255, 255));
        tf_durasi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_durasi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_durasiFocusGained(evt);
            }
        });
        jPanel9.add(tf_durasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 131, 240, 36));

        tf_nama_proyek.setBackground(new java.awt.Color(25, 23, 21));
        tf_nama_proyek.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tf_nama_proyek.setForeground(new java.awt.Color(255, 255, 255));
        tf_nama_proyek.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_nama_proyek.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_nama_proyekFocusGained(evt);
            }
        });
        jPanel9.add(tf_nama_proyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(192, 76, 240, 36));

        JPProyek.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, -1, 190));

        tbl_proyek.setBackground(new java.awt.Color(25, 23, 21));
        tbl_proyek.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tbl_proyek.setForeground(new java.awt.Color(255, 255, 255));
        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nama Proyek", "Durasi (Minggu) "
            }
        ));
        tbl_proyek.setGridColor(new java.awt.Color(25, 23, 21));
        tbl_proyek.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_proyek.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_proyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_proyek);

        JPProyek.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 213, -1, 306));

        jPanel11.setBackground(new java.awt.Color(29, 62, 105));
        jPanel11.setLayout(new java.awt.GridLayout(4, 0));

        btn_TambahProyek.setBackground(new java.awt.Color(29, 62, 105));
        btn_TambahProyek.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_TambahProyek.setForeground(new java.awt.Color(255, 255, 255));
        btn_TambahProyek.setText("Tambah");
        btn_TambahProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahProyekActionPerformed(evt);
            }
        });
        jPanel11.add(btn_TambahProyek);

        btn_UpdateProyek.setBackground(new java.awt.Color(29, 62, 105));
        btn_UpdateProyek.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_UpdateProyek.setForeground(new java.awt.Color(255, 255, 255));
        btn_UpdateProyek.setText("Update");
        btn_UpdateProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateProyekActionPerformed(evt);
            }
        });
        jPanel11.add(btn_UpdateProyek);

        btn_HapusProyek.setBackground(new java.awt.Color(29, 62, 105));
        btn_HapusProyek.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_HapusProyek.setForeground(new java.awt.Color(255, 255, 255));
        btn_HapusProyek.setText("Hapus");
        btn_HapusProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HapusProyekActionPerformed(evt);
            }
        });
        jPanel11.add(btn_HapusProyek);

        btn_ClearProyek.setBackground(new java.awt.Color(29, 62, 105));
        btn_ClearProyek.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_ClearProyek.setForeground(new java.awt.Color(255, 255, 255));
        btn_ClearProyek.setText("Clear");
        btn_ClearProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearProyekActionPerformed(evt);
            }
        });
        jPanel11.add(btn_ClearProyek);

        JPProyek.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(463, 6, 139, 511));

        tabbedPaneCustom1.addTab("DATA PROYEK", JPProyek);

        JPTransaksi.setBackground(new java.awt.Color(25, 23, 21));
        JPTransaksi.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setBackground(new java.awt.Color(25, 23, 21));
        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Proyek                    : ");
        jPanel14.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 73, -1, -1));

        jLabel16.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Karyawan / Pegawai : ");
        jPanel14.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 24, -1, -1));

        jLabel17.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Peran                      :");
        jPanel14.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(17, 123, 180, -1));

        tf_peran_transaksi.setBackground(new java.awt.Color(25, 23, 21));
        tf_peran_transaksi.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        tf_peran_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        tf_peran_transaksi.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tf_peran_transaksi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tf_peran_transaksiFocusGained(evt);
            }
        });
        jPanel14.add(tf_peran_transaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 116, 226, 38));

        cmb_transakasi_project.setBackground(new java.awt.Color(25, 23, 21));
        cmb_transakasi_project.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cmb_transakasi_project.setForeground(new java.awt.Color(255, 255, 255));
        cmb_transakasi_project.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        jPanel14.add(cmb_transakasi_project, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 67, 226, 37));

        cmb_transaksi_karyawan.setBackground(new java.awt.Color(25, 23, 21));
        cmb_transaksi_karyawan.setFont(new java.awt.Font("Trebuchet MS", 1, 14)); // NOI18N
        cmb_transaksi_karyawan.setForeground(new java.awt.Color(255, 255, 255));
        jPanel14.add(cmb_transaksi_karyawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(209, 18, 226, 37));

        JPTransaksi.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 452, -1));

        tbl_transaksi.setBackground(new java.awt.Color(25, 23, 21));
        tbl_transaksi.setFont(new java.awt.Font("Trebuchet MS", 0, 14)); // NOI18N
        tbl_transaksi.setForeground(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Pegawai", "Proyek", "Peran "
            }
        ));
        tbl_transaksi.setGridColor(new java.awt.Color(25, 23, 21));
        tbl_transaksi.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tbl_transaksi.setSelectionForeground(new java.awt.Color(255, 255, 255));
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_transaksi);

        JPTransaksi.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 189, -1, 330));

        jPanel15.setBackground(new java.awt.Color(29, 62, 105));
        jPanel15.setLayout(new java.awt.GridLayout(4, 0));

        btn_TambahTransaksi.setBackground(new java.awt.Color(29, 62, 105));
        btn_TambahTransaksi.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_TambahTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_TambahTransaksi.setText("Tambah");
        btn_TambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TambahTransaksiActionPerformed(evt);
            }
        });
        jPanel15.add(btn_TambahTransaksi);

        btn_UpdateTransaksi.setBackground(new java.awt.Color(29, 62, 105));
        btn_UpdateTransaksi.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_UpdateTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_UpdateTransaksi.setText("Update");
        btn_UpdateTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateTransaksiActionPerformed(evt);
            }
        });
        jPanel15.add(btn_UpdateTransaksi);

        btn_HapusTransaksi.setBackground(new java.awt.Color(29, 62, 105));
        btn_HapusTransaksi.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_HapusTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_HapusTransaksi.setText("Hapus");
        btn_HapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_HapusTransaksiActionPerformed(evt);
            }
        });
        jPanel15.add(btn_HapusTransaksi);

        btn_ClearTransaksi.setBackground(new java.awt.Color(29, 62, 105));
        btn_ClearTransaksi.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btn_ClearTransaksi.setForeground(new java.awt.Color(255, 255, 255));
        btn_ClearTransaksi.setText("Clear");
        btn_ClearTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearTransaksiActionPerformed(evt);
            }
        });
        jPanel15.add(btn_ClearTransaksi);

        JPTransaksi.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 6, 136, 513));

        tabbedPaneCustom1.addTab("TRANSAKSI PROYEK", JPTransaksi);

        jPanel4.add(tabbedPaneCustom1, java.awt.BorderLayout.PAGE_START);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_TambahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahKaryawanActionPerformed
        try {
            if (tf_id_karyawan.getText().trim().isEmpty() || tf_nama_karyawan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong");
                return;
            }
            if ("---Pilih Jabatan---".equals(cmb_jabatan.getSelectedItem().toString()) ||
                "---Pilih Departemen---".equals(cmb_departemen.getSelectedItem().toString())) {
                JOptionPane.showMessageDialog(this, "Silakan pilih Jabatan dan Departemen yang valid");
                return;
            }
            
            int id = Integer.parseInt(tf_id_karyawan.getText().trim());
            String sqlCheck = "SELECT id FROM karyawan WHERE id = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, id);
            ResultSet rs = psCheck.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "ID karyawan sudah ada, gunakan ID yang berbeda");
                return;
            }
            String sqlInsert = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
            PreparedStatement psInsert = konek.prepareStatement(sqlInsert);
            psInsert.setInt(1, id);
            psInsert.setString(2, tf_nama_karyawan.getText().trim());
            psInsert.setString(3, cmb_jabatan.getSelectedItem().toString());
            psInsert.setString(4, cmb_departemen.getSelectedItem().toString());
            psInsert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Karyawan berhasil ditambahkan");

            loadEmployee();
            loadEmployeeNames();
            loadTransaction();
            loadProjectNames();

            tf_id_karyawan.setText("");
            tf_nama_karyawan.setText("");
            cmb_jabatan.setSelectedIndex(0);
            cmb_departemen.setSelectedIndex(0);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Save Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_TambahKaryawanActionPerformed

    private void btn_UpdateKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateKaryawanActionPerformed
        try {
            if (tf_id_karyawan.getText().trim().isEmpty() && tf_nama_karyawan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID dan Nama tidak boleh kosong");
                return;
            } else if (tf_id_karyawan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID tidak boleh kosong");
                return;
            } else if (tf_nama_karyawan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama tidak boleh kosong");
                return;
            }
            String sqlCheck = "SELECT nama, jabatan, departemen FROM karyawan WHERE id = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, Integer.parseInt(tf_id_karyawan.getText()));
            ResultSet rs = psCheck.executeQuery();
            if (rs.next()) {
                String currentName = rs.getString("nama");
                String currentPosition = rs.getString("jabatan");
                String currentDepartment = rs.getString("departemen");

                boolean isNameSame = currentName.equals(tf_nama_karyawan.getText().trim());
                boolean isPositionSame = currentPosition.equals(cmb_jabatan.getSelectedItem().toString());
                boolean isDepartmentSame = currentDepartment.equals(cmb_departemen.getSelectedItem().toString());

                if (isNameSame && isPositionSame && isDepartmentSame) {
                    JOptionPane.showMessageDialog(this, "Tidak ada perubahan data. Silakan ubah setidaknya satu field sebelum memperbarui.");
                    return;
                }
            }
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setString(1, tf_nama_karyawan.getText());
            ps.setString(2, cmb_jabatan.getSelectedItem().toString());
            ps.setString(3, cmb_departemen.getSelectedItem().toString());
            ps.setInt(4, Integer.parseInt(tf_id_karyawan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");

            tf_id_karyawan.setText("");
            tf_nama_karyawan.setText("");
            cmb_jabatan.setSelectedIndex(0);
            cmb_departemen.setSelectedIndex(0);

            loadEmployee();
            loadEmployeeNames();
            loadTransaction();
            loadProjectNames();
        } catch (SQLException e) {
            System.out.println("Error Update Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_UpdateKaryawanActionPerformed

    private void btn_HapusKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HapusKaryawanActionPerformed
        try {
            if (tf_id_karyawan.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID tidak boleh kosong");
                return;
            }
            int id = Integer.parseInt(tf_id_karyawan.getText().trim());
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Karyawan berhasil dihapus");
                loadEmployee();
                loadEmployeeNames();
                loadTransaction();
            } else {
                JOptionPane.showMessageDialog(this, "ID karyawan tidak ditemukan");
            }

            tf_id_karyawan.setText("");
            tf_nama_karyawan.setText("");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_HapusKaryawanActionPerformed

    private void btn_ClearKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearKaryawanActionPerformed
        tf_id_karyawan.setText("");
        tf_nama_karyawan.setText("");
        cmb_jabatan.setSelectedIndex(0);
        cmb_departemen.setSelectedIndex(0);
    }//GEN-LAST:event_btn_ClearKaryawanActionPerformed

    private void btn_TambahProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahProyekActionPerformed
        try {
            if (tf_id_proyek.getText().trim().isEmpty() || tf_nama_proyek.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID dan Nama Proyek tidak boleh kosong");
                return;
            }
            int projectId = Integer.parseInt(tf_id_proyek.getText().trim());

            String sqlCheck = "SELECT id FROM proyek WHERE id = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, projectId);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                JOptionPane.showMessageDialog(this, "ID proyek sudah ada, gunakan ID yang berbeda");
                return;
            }

            // Mendapatkan durasi dari input dan menambahkan " minggu" setelahnya
            int durasiInput = Integer.parseInt(tf_durasi.getText().trim());
            String durasiDenganMinggu = durasiInput + " minggu"; // Konversi ke String dengan tambahan " minggu"

            String sqlInsert = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
            PreparedStatement psInsert = konek.prepareStatement(sqlInsert);
            psInsert.setInt(1, projectId);
            psInsert.setString(2, tf_nama_proyek.getText().trim());
            psInsert.setString(3, durasiDenganMinggu); // Menyimpan durasi dengan tambahan " minggu"
            psInsert.executeUpdate();
            JOptionPane.showMessageDialog(this, "Proyek berhasil ditambahkan");

            loadProject();
            loadProjectNames();
            tf_id_proyek.setText("");
            tf_nama_proyek.setText("");
            tf_durasi.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Save Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID dan durasi harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_TambahProyekActionPerformed

    private void btn_UpdateProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateProyekActionPerformed
        try {
            if (tf_id_proyek.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID tidak boleh kosong");
                return;
            }
            if (tf_nama_proyek.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama Proyek tidak boleh kosong");
                return;
            }
            if (tf_durasi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Durasi tidak boleh kosong");
                return;
            }

            int projectId = Integer.parseInt(tf_id_proyek.getText().trim());
            String newNamaProyek = tf_nama_proyek.getText().trim();
            String newDurasi = tf_durasi.getText().trim() + " minggu";

            // Fetch the current project details from the database
            String selectSql = "SELECT nama_proyek, durasi_pengerjaan FROM proyek WHERE id = ?";
            PreparedStatement selectPs = konek.prepareStatement(selectSql);
            selectPs.setInt(1, projectId);
            ResultSet rs = selectPs.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Proyek tidak ditemukan");
                return;
            }

            String oldNamaProyek = rs.getString("nama_proyek");
            String oldDurasi = rs.getString("durasi_pengerjaan");
            
            // digunakan untuk membandingkan yang lama dengan yang baru apakah ada perubahan atau tidak makanya pakai boolean
            boolean isNamaBerubah = !newNamaProyek.equals(oldNamaProyek);
            boolean isDurasiBerubah = !newDurasi.equals(oldDurasi);

            // jika tidak ada perubahan maka keluar notifikasi
            if (!isNamaBerubah && !isDurasiBerubah) {
                JOptionPane.showMessageDialog(this, "Tidak ada perubahan pada Nama Proyek dan Durasi");
                return;
            }

            // untuk update data dengan kolom nama_proyek durasi dengan id sebagai acuan
            String sqlUpdate = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement psUpdate = konek.prepareStatement(sqlUpdate);
            psUpdate.setString(1, newNamaProyek);
            psUpdate.setString(2, newDurasi);
            psUpdate.setInt(3, projectId);
            psUpdate.executeUpdate();

            // Data berhasil disimpan dan mereset input pengguna
            JOptionPane.showMessageDialog(this, "Data berhasil diperbarui");
            loadProject();
            loadProjectNames();
            loadTransaction();
            tf_id_proyek.setText("");
            tf_nama_proyek.setText("");
            tf_durasi.setText("");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Update Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID dan Durasi harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_UpdateProyekActionPerformed

    private void btn_HapusProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HapusProyekActionPerformed
        try {
            if (tf_id_proyek.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID proyek tidak boleh kosong");
                return;
            }
            
            int projectId = Integer.parseInt(tf_id_proyek.getText().trim());
            int confirm = JOptionPane.showConfirmDialog(this, "Apakah Anda yakin ingin menghapus proyek ini?", 
                                        "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
            if (confirm != JOptionPane.YES_OPTION) {
                return;
            }
            String sqlDeleteTransaksi = "DELETE FROM transaksi WHERE id_proyek = ?";
            PreparedStatement psDeleteTransaksi = konek.prepareStatement(sqlDeleteTransaksi);
            psDeleteTransaksi.setInt(1, projectId);
            psDeleteTransaksi.executeUpdate();
            
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, projectId);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Proyek berhasil dihapus");
                loadProject();
                loadProjectNames();
                loadTransaction();
            } else {
                JOptionPane.showMessageDialog(this, "ID proyek tidak ditemukan");
            }

            tf_id_proyek.setText(""); //mengahpus ID
            tf_nama_proyek.setText(""); //mengahpus ID
            tf_durasi.setText(""); //mengahpus ID

            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Error Delete Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID harus berupa angka yang valid");
        }
    }//GEN-LAST:event_btn_HapusProyekActionPerformed

    private void btn_ClearProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearProyekActionPerformed
        tf_id_proyek.setText("");
        tf_nama_proyek.setText("");
        tf_durasi.setText("");
    }//GEN-LAST:event_btn_ClearProyekActionPerformed

    private void btn_TambahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TambahTransaksiActionPerformed
        try {
            if (tf_peran_transaksi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
                return;
            }

            int idKaryawan = getIdKaryawan();
            int idProyek = getIdProyek();

            String sqlCheck = "SELECT * FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, idKaryawan);
            psCheck.setInt(2, idProyek);
            ResultSet rsCheck = psCheck.executeQuery();

            if (rsCheck.next()) {
                JOptionPane.showMessageDialog(this, "Kombinasi karyawan dan proyek sudah ada. Tidak dapat menambahkan data duplikat.");
                return;
            }

            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, tf_peran_transaksi.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data berhasil disimpan");
            // untuk reset kembali ke posisi awal
            cmb_transaksi_karyawan.setSelectedIndex(0);
            cmb_transakasi_project.setSelectedIndex(0);
            tf_peran_transaksi.setText("");
            loadTransaction();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_TambahTransaksiActionPerformed

    private void btn_UpdateTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateTransaksiActionPerformed
        try {
            if (tf_peran_transaksi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong");
                return;
            }
            int idKaryawan = getIdKaryawan();
            int idProyek = getIdProyek();

            String sqlCheck = "SELECT * FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement psCheck = konek.prepareStatement(sqlCheck);
            psCheck.setInt(1, idKaryawan);
            psCheck.setInt(2, idProyek);
            ResultSet rs = psCheck.executeQuery();

            if (rs.next()) {
                String role = rs.getString("peran");
                if (role.equals(tf_peran_transaksi.getText().trim())) {
                    JOptionPane.showMessageDialog(this, "Tidak ada perubahan data. Silakan ubah peran sebelum memperbarui.");
                    return;
                }

                String sqlUpdate = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement psUpdate = konek.prepareStatement(sqlUpdate);
                psUpdate.setString(1, tf_peran_transaksi.getText());
                psUpdate.setInt(2, idKaryawan);
                psUpdate.setInt(3, idProyek);
                psUpdate.executeUpdate();                                                                           
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diperbarui");
                cmb_transaksi_karyawan.setSelectedIndex(0);
                cmb_transakasi_project.setSelectedIndex(0);
                tf_peran_transaksi.setText("");
                loadTransaction();
            } else {
                JOptionPane.showMessageDialog(this, "Transaksi tidak ditemukan. Pastikan memilih karyawan dan proyek yang valid.");
            }
        } catch (SQLException e) {
            System.out.println("Error Update Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_UpdateTransaksiActionPerformed

    private void btn_HapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_HapusTransaksiActionPerformed
        try {
            if (tf_peran_transaksi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Peran tidak boleh kosong untuk menghapus data");
                return;
            }

            int idKaryawan = getIdKaryawan();
            int idProyek = getIdProyek();

            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = konek.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            int rowsDeleted = ps.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus");
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau gagal dihapus");
            }

            cmb_transaksi_karyawan.setSelectedIndex(0);
            cmb_transakasi_project.setSelectedIndex(0);
            tf_peran_transaksi.setText("");
            loadTransaction();
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_HapusTransaksiActionPerformed

    private void btn_ClearTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearTransaksiActionPerformed
        cmb_transaksi_karyawan.setSelectedIndex(0);
        cmb_transakasi_project.setSelectedIndex(0);
        tf_peran_transaksi.setText("");
    }//GEN-LAST:event_btn_ClearTransaksiActionPerformed

    private void tbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_karyawanMouseClicked
        // TODO add your handling code here:
        int row = tbl_karyawan.getSelectedRow(); 
        
        if (row != -1) {
            tf_id_karyawan.setText(tbl_karyawan.getValueAt(row, 0).toString());
            tf_nama_karyawan.setText(tbl_karyawan.getValueAt(row, 1).toString());
            cmb_jabatan.setSelectedItem(tbl_karyawan.getValueAt(row, 2).toString());
            cmb_departemen.setSelectedItem(tbl_karyawan.getValueAt(row, 3).toString());  
        }
    }//GEN-LAST:event_tbl_karyawanMouseClicked

    private void tbl_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proyekMouseClicked
        // TODO add your handling code here:
        int row = tbl_proyek.getSelectedRow(); 
        
        if (row != -1) {
            
            tf_id_proyek.setText(tbl_proyek.getValueAt(row, 0).toString());
            tf_nama_proyek.setText(tbl_proyek.getValueAt(row, 1).toString());
            tf_durasi.setText(tbl_proyek.getValueAt(row, 2).toString());                
        }
    }//GEN-LAST:event_tbl_proyekMouseClicked

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // TODO add your handling code here:
        int row = tbl_transaksi.getSelectedRow(); 
//        tbl_transaksi
        
        if (row != -1) {
            cmb_transaksi_karyawan.setSelectedItem(tbl_transaksi.getValueAt(row, 0).toString());
            cmb_transakasi_project.setSelectedItem(tbl_transaksi.getValueAt(row, 1).toString());  
            tf_peran_transaksi.setText(tbl_transaksi.getValueAt(row, 2).toString());
        }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void tf_id_karyawanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_id_karyawanFocusGained
        // TODO add your handling code here:
        tf_id_karyawan.setText("");
    }//GEN-LAST:event_tf_id_karyawanFocusGained

    private void tf_nama_karyawanFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nama_karyawanFocusGained
        // TODO add your handling code here:
        tf_nama_karyawan.setText("");
    }//GEN-LAST:event_tf_nama_karyawanFocusGained

    private void tf_id_proyekFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_id_proyekFocusGained
        // TODO add your handling code here:
        tf_id_proyek.setText("");
    }//GEN-LAST:event_tf_id_proyekFocusGained

    private void tf_nama_proyekFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_nama_proyekFocusGained
        // TODO add your handling code here:
        tf_nama_proyek.setText("");
    }//GEN-LAST:event_tf_nama_proyekFocusGained

    private void tf_durasiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_durasiFocusGained
        // TODO add your handling code here:
        tf_durasi.setText("");
    }//GEN-LAST:event_tf_durasiFocusGained

    private void tf_peran_transaksiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_peran_transaksiFocusGained
        // TODO add your handling code here:
        tf_peran_transaksi.setText("");
    }//GEN-LAST:event_tf_peran_transaksiFocusGained
        
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Apk_Manajemen0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Apk_Manajemen0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Apk_Manajemen0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Apk_Manajemen0.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apk_Manajemen0().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPKaryawan;
    private javax.swing.JPanel JPProyek;
    private javax.swing.JPanel JPTransaksi;
    private javax.swing.JButton btn_ClearKaryawan;
    private javax.swing.JButton btn_ClearProyek;
    private javax.swing.JButton btn_ClearTransaksi;
    private javax.swing.JButton btn_HapusKaryawan;
    private javax.swing.JButton btn_HapusProyek;
    private javax.swing.JButton btn_HapusTransaksi;
    private javax.swing.JButton btn_TambahKaryawan;
    private javax.swing.JButton btn_TambahProyek;
    private javax.swing.JButton btn_TambahTransaksi;
    private javax.swing.JButton btn_UpdateKaryawan;
    private javax.swing.JButton btn_UpdateProyek;
    private javax.swing.JButton btn_UpdateTransaksi;
    private javax.swing.JComboBox<String> cmb_departemen;
    private javax.swing.JComboBox<String> cmb_jabatan;
    private javax.swing.JComboBox<String> cmb_transakasi_project;
    private javax.swing.JComboBox<String> cmb_transaksi_karyawan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private raven.tabbed.ShadowRenderer shadowRenderer1;
    private raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_id_karyawan;
    private javax.swing.JTextField tf_id_proyek;
    private javax.swing.JTextField tf_nama_karyawan;
    private javax.swing.JTextField tf_nama_proyek;
    private javax.swing.JTextField tf_peran_transaksi;
    // End of variables declaration//GEN-END:variables
}
