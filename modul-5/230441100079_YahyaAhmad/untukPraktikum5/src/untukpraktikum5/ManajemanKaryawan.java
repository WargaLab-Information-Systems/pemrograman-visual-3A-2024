/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package untukpraktikum5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author ya991
 */
public class ManajemanKaryawan extends javax.swing.JFrame {

    /**
     * Creates new form ManajemanKaryawan
     */
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;
    public ManajemanKaryawan() {
        initComponents();
        conn = koneksi.getConnection();
        
        modelKaryawan = new DefaultTableModel();
        tabel_karyawan.setModel(modelKaryawan);
        modelKaryawan.addColumn("ID Karyawan");
        modelKaryawan.addColumn("Nama Karyawan");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");
        
        modelProyek = new DefaultTableModel();
        tabel_proyek.setModel(modelProyek);
        modelProyek.addColumn("ID Proyek");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi");
        
        modelTransaksi = new DefaultTableModel();
        tabel_transaksi.setModel(modelTransaksi);
        modelTransaksi.addColumn("ID Transaksi");
        modelTransaksi.addColumn("Nama Karyawan");
        modelTransaksi.addColumn("Nama Proyek");
        modelTransaksi.addColumn("Peran");
        
        TampilKaryawan();
        TampilProyek();
        tampilTransaksi();
        loadComboBoxData();
    }
    private void TampilKaryawan() {
      modelKaryawan.setRowCount(0);

        try {
            String sql = "SELECT * FROM karyawan";
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
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void updateComboBoxKaryawan() {
        cb_namakaryawantransaksi.removeAllItems();
        try {
            String sql = "SELECT nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cb_namakaryawantransaksi.addItem(rs.getString("nama")); // Tambahkan setiap nama karyawan ke ComboBox
            }
        } catch (SQLException e) {
            System.out.println("Error Update ComboBox Karyawan: " + e.getMessage());
        }
    }
    
    private void updateComboBoxProyek() {
        cb_namaproyektransaksi.removeAllItems();
        try {
            String sql = "SELECT nama FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cb_namaproyektransaksi.addItem(rs.getString("nama_proyek")); // Tambahkan setiap nama karyawan ke ComboBox
            }
        } catch (SQLException e) {
            System.out.println("Error Update ComboBox Karyawan: " + e.getMessage());
        }
    }
    
    private void resetSemuaData() {
        // Tab Karyawan
        tf_namakaryawan.setText("");
        cb_jabatan.setSelectedIndex(0);
        tf_departemen.setText("");
        tf_idkaryawaan.setText("");

        // Tab Proyek
        tf_idproyek.setText("");
        tf_namaproyek.setText("");
        tf_durasiproyek.setText("");

        // Tab Transaksi Proyek
        tf_peran.setText("");
        cb_namakaryawantransaksi.setSelectedIndex(0);
        cb_namaproyektransaksi.setSelectedIndex(0);
    }
    
    private void TampilProyek() {
      modelProyek.setRowCount(0);
      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             modelProyek.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getString("durasi_pengerjaan"),
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
    
    
    private void loadComboBoxData() {
         try {
            String sql = "SELECT nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cb_namakaryawantransaksi.removeAllItems();
            while (rs.next()) {
                cb_namakaryawantransaksi.addItem(rs.getString("nama"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Karyawan: " + e.getMessage());
        }

        try {
            String sql = "SELECT nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cb_namaproyektransaksi.removeAllItems();
            while (rs.next()) {
                cb_namaproyektransaksi.addItem(rs.getString("nama_proyek"));
            }
        } catch (SQLException e) {
            System.out.println("Error Load Proyek: " + e.getMessage());
        }
    }
    
    private void tampilTransaksi() {
        modelTransaksi.setRowCount(0);

        try {
            String sql = "SELECT t.id, k.nama AS nama_karyawan, p.nama_proyek, t.peran " +
                         "FROM transaksi t " +
                         "JOIN karyawan k ON t.id = k.id " +
                         "JOIN proyek p ON t.id = p.id";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                modelTransaksi.addRow(new Object[]{
                    rs.getInt("id"),
                    rs.getString("nama_karyawan"),  // Corrected here as well
                    rs.getString("nama_proyek"),     // Corrected here as well
                    rs.getString("peran"),
                });
            }
        } catch (SQLException e) {
            System.out.println("Error loading Transaksi data: " + e.getMessage());
        }
    }
    
    private int getSelectedKaryawanId() {
        String karyawanName = (String) cb_namakaryawantransaksi.getSelectedItem();
        try {
            String sql = "SELECT id FROM karyawan WHERE nama = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, karyawanName);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Karyawan ID: " + e.getMessage());
        }
        return -1;
    }

    private int getSelectedProyekId() {
        String proyekId = (String) cb_namaproyektransaksi.getSelectedItem();
        try {
            String sql = "SELECT id FROM proyek WHERE nama_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, proyekId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("id");
            }
        } catch (SQLException e) {
            System.out.println("Error Get Proyek ID: " + e.getMessage());
        }
        return -1; // Return a negative value if not found
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        gradientRoundedPanel1 = new untukpraktikum5.GradientRoundedPanel();
        jLabel3 = new javax.swing.JLabel();
        tabbedPaneCustom1 = new untukpraktikum5.TabbedPaneCustom();
        jPanel3 = new javax.swing.JPanel();
        roundedPanel1 = new untukpraktikum5.RoundedPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tf_idkaryawaan = new javax.swing.JTextField();
        tf_namakaryawan = new javax.swing.JTextField();
        tf_departemen = new javax.swing.JTextField();
        cb_jabatan = new javax.swing.JComboBox<>();
        tambahKaryawan = new javax.swing.JButton();
        editKaryawan = new javax.swing.JButton();
        hapusKaryawan = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel_karyawan = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        roundedPanel2 = new untukpraktikum5.RoundedPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf_idproyek = new javax.swing.JTextField();
        tf_namaproyek = new javax.swing.JTextField();
        tf_durasiproyek = new javax.swing.JTextField();
        tambahProyek = new javax.swing.JButton();
        editProyek = new javax.swing.JButton();
        hapusPoroyek = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabel_proyek = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        roundedPanel3 = new untukpraktikum5.RoundedPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_peran = new javax.swing.JTextField();
        tambahtransaksi = new javax.swing.JButton();
        edittransaksi = new javax.swing.JButton();
        hapustransaksi = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabel_transaksi = new javax.swing.JTable();
        cb_namaproyektransaksi = new javax.swing.JComboBox<>();
        cb_namakaryawantransaksi = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        tf_idtransaksi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setBackground(new java.awt.Color(249, 249, 249));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setBackground(new java.awt.Color(166, 77, 121));
        jLabel1.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(106, 30, 85));
        jLabel1.setText("MANAJEMEN KARYAWAN");
        jPanel2.add(jLabel1, new java.awt.GridBagConstraints());

        jLabel2.setBackground(new java.awt.Color(166, 77, 121));
        jLabel2.setFont(new java.awt.Font("Poppins", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(106, 30, 85));
        jLabel2.setText("& PROYEK");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanel2.add(jLabel2, gridBagConstraints);

        gradientRoundedPanel1.setColorEnd(new java.awt.Color(249, 249, 249));
        gradientRoundedPanel1.setColorStart(new java.awt.Color(106, 30, 85));
        gradientRoundedPanel1.setRoundTopLeft(75);
        gradientRoundedPanel1.setRoundTopRight(75);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/custome/karyawa.png"))); // NOI18N

        javax.swing.GroupLayout gradientRoundedPanel1Layout = new javax.swing.GroupLayout(gradientRoundedPanel1);
        gradientRoundedPanel1.setLayout(gradientRoundedPanel1Layout);
        gradientRoundedPanel1Layout.setHorizontalGroup(
            gradientRoundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gradientRoundedPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        gradientRoundedPanel1Layout.setVerticalGroup(
            gradientRoundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gradientRoundedPanel1Layout.createSequentialGroup()
                .addGap(0, 44, Short.MAX_VALUE)
                .addComponent(jLabel3))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(gradientRoundedPanel1, gridBagConstraints);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        tabbedPaneCustom1.setBackground(new java.awt.Color(26, 26, 29));
        tabbedPaneCustom1.setForeground(new java.awt.Color(249, 249, 249));
        tabbedPaneCustom1.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(106, 30, 85));
        tabbedPaneCustom1.setUnselectedColor(new java.awt.Color(26, 26, 29));

        jPanel3.setForeground(new java.awt.Color(254, 249, 242));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel1.setBackground(new java.awt.Color(52, 49, 49));
        roundedPanel1.setForeground(new java.awt.Color(26, 26, 29));
        roundedPanel1.setRoundBottomLeft(25);
        roundedPanel1.setRoundBottomRight(25);
        roundedPanel1.setRoundTopLeft(25);
        roundedPanel1.setRoundTopRight(25);

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(249, 249, 249));
        jLabel5.setText("ID");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(249, 249, 249));
        jLabel6.setText("Nama");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(249, 249, 249));
        jLabel7.setText("Jabatan");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(249, 249, 249));
        jLabel8.setText("Departemen");

        tf_idkaryawaan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tf_namakaryawan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tf_departemen.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        cb_jabatan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cb_jabatan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Konstruksi", "Pengecoran", "Pengecatan", "Kelistrikan" }));

        tambahKaryawan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tambahKaryawan.setText("Tambah");
        tambahKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKaryawanActionPerformed(evt);
            }
        });

        editKaryawan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        editKaryawan.setText("Edit");
        editKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editKaryawanActionPerformed(evt);
            }
        });

        hapusKaryawan.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        hapusKaryawan.setText("Hapus");
        hapusKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKaryawanActionPerformed(evt);
            }
        });

        tabel_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Jabatan", "Departemen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_karyawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel_karyawan);

        javax.swing.GroupLayout roundedPanel1Layout = new javax.swing.GroupLayout(roundedPanel1);
        roundedPanel1.setLayout(roundedPanel1Layout);
        roundedPanel1Layout.setHorizontalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addComponent(tambahKaryawan)
                        .addGap(38, 38, 38)
                        .addComponent(editKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusKaryawan))
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_idkaryawaan)
                            .addComponent(tf_namakaryawan)
                            .addComponent(cb_jabatan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tf_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        roundedPanel1Layout.setVerticalGroup(
            roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel1Layout.createSequentialGroup()
                .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(roundedPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, roundedPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(tf_idkaryawaan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(tf_namakaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cb_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(tf_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addGroup(roundedPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahKaryawan)
                            .addComponent(editKaryawan)
                            .addComponent(hapusKaryawan))))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel3.add(roundedPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 740, 320));

        jLabel4.setFont(new java.awt.Font("Poppins Black", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(106, 30, 85));
        jLabel4.setText("TABEL KARYAWAN");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 20));

        tabbedPaneCustom1.addTab("Karyawan", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Poppins Black", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(106, 30, 85));
        jLabel9.setText("TABEL PROYEK");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 20));

        roundedPanel2.setBackground(new java.awt.Color(52, 49, 49));
        roundedPanel2.setForeground(new java.awt.Color(26, 26, 29));
        roundedPanel2.setRoundBottomLeft(25);
        roundedPanel2.setRoundBottomRight(25);
        roundedPanel2.setRoundTopLeft(25);
        roundedPanel2.setRoundTopRight(25);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(249, 249, 249));
        jLabel10.setText("ID");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(249, 249, 249));
        jLabel11.setText("Nama Proyek");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(249, 249, 249));
        jLabel12.setText("Durasi");

        tf_idproyek.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tf_namaproyek.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tf_durasiproyek.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tambahProyek.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tambahProyek.setText("Tambah");
        tambahProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahProyekActionPerformed(evt);
            }
        });

        editProyek.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        editProyek.setText("Edit");
        editProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editProyekActionPerformed(evt);
            }
        });

        hapusPoroyek.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        hapusPoroyek.setText("Hapus");
        hapusPoroyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusPoroyekActionPerformed(evt);
            }
        });

        tabel_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Proyek", "Durasi Proyek"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_proyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabel_proyek);

        javax.swing.GroupLayout roundedPanel2Layout = new javax.swing.GroupLayout(roundedPanel2);
        roundedPanel2.setLayout(roundedPanel2Layout);
        roundedPanel2Layout.setHorizontalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addComponent(tambahProyek)
                        .addGap(38, 38, 38)
                        .addComponent(editProyek, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46)
                        .addComponent(hapusPoroyek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(roundedPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                .addGap(29, 29, 29)))
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_idproyek)
                            .addComponent(tf_namaproyek)
                            .addComponent(tf_durasiproyek, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );
        roundedPanel2Layout.setVerticalGroup(
            roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel2Layout.createSequentialGroup()
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(tf_idproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(tf_namaproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(tf_durasiproyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(roundedPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahProyek)
                            .addComponent(editProyek)
                            .addComponent(hapusPoroyek))))
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jPanel4.add(roundedPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 740, 320));

        tabbedPaneCustom1.addTab("Proyek", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        roundedPanel3.setBackground(new java.awt.Color(52, 49, 49));
        roundedPanel3.setForeground(new java.awt.Color(26, 26, 29));
        roundedPanel3.setRoundBottomLeft(25);
        roundedPanel3.setRoundBottomRight(25);
        roundedPanel3.setRoundTopLeft(25);
        roundedPanel3.setRoundTopRight(25);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(249, 249, 249));
        jLabel13.setText("Nama Karyawan");

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(249, 249, 249));
        jLabel14.setText("Nama Proyek");

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(249, 249, 249));
        jLabel15.setText("Peran");

        tf_peran.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N

        tambahtransaksi.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tambahtransaksi.setText("Tambah");
        tambahtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahtransaksiActionPerformed(evt);
            }
        });

        edittransaksi.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        edittransaksi.setText("Edit");
        edittransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edittransaksiActionPerformed(evt);
            }
        });

        hapustransaksi.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        hapustransaksi.setText("Hapus");
        hapustransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapustransaksiActionPerformed(evt);
            }
        });

        tabel_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID Transaksi", "Nama Karyawan", "nama Proyek", "Peran"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabel_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabel_transaksiMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tabel_transaksi);

        cb_namaproyektransaksi.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cb_namaproyektransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cb_namakaryawantransaksi.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        cb_namakaryawantransaksi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setBackground(new java.awt.Color(255, 255, 255));
        jLabel16.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(249, 249, 249));
        jLabel16.setText("ID Transaksi");

        tf_idtransaksi.setFont(new java.awt.Font("Poppins", 0, 12)); // NOI18N
        tf_idtransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_idtransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout roundedPanel3Layout = new javax.swing.GroupLayout(roundedPanel3);
        roundedPanel3.setLayout(roundedPanel3Layout);
        roundedPanel3Layout.setHorizontalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(tambahtransaksi)
                        .addGap(38, 38, 38)
                        .addComponent(edittransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(hapustransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE))
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(33, 33, 33)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_peran)
                            .addComponent(cb_namaproyektransaksi, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cb_namakaryawantransaksi, 0, 243, Short.MAX_VALUE)
                            .addComponent(tf_idtransaksi))))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        roundedPanel3Layout.setVerticalGroup(
            roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(roundedPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(roundedPanel3Layout.createSequentialGroup()
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(tf_idtransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(cb_namakaryawantransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(cb_namaproyektransaksi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(roundedPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tambahtransaksi)
                            .addComponent(edittransaksi)
                            .addComponent(hapustransaksi))))
                .addContainerGap(69, Short.MAX_VALUE))
        );

        jPanel5.add(roundedPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 740, 320));

        jLabel17.setFont(new java.awt.Font("Poppins Black", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(106, 30, 85));
        jLabel17.setText("TABEL TRANSAKSI");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, 20));

        tabbedPaneCustom1.addTab("Transaksi", jPanel5);

        jPanel1.add(tabbedPaneCustom1, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 764, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 546, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tambahtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahtransaksiActionPerformed
        // TODO add your handling code here:
        if (getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum menyimpan data transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "INSERT INTO transaksi (id, id_karyawan, id_proyek, peran) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_idtransaksi.getText().toString());
            ps.setInt(2, getSelectedKaryawanId());
            ps.setInt(3, getSelectedProyekId());
            ps.setString(4, tf_peran.getText().toString());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan");
            tampilTransaksi();
        } catch (SQLException e) {
            System.out.println("Error Save Data Transaksi: " + e.getMessage());
        }
    }//GEN-LAST:event_tambahtransaksiActionPerformed

    private void tambahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKaryawanActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_idkaryawaan.getText().toString());
            ps.setString(2, tf_namakaryawan.getText());
            ps.setString(3, cb_jabatan.getSelectedItem().toString());
            ps.setString(4,     tf_departemen.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            TampilKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
            JOptionPane.showMessageDialog(this, "ID Sudah ada");

        }
    }//GEN-LAST:event_tambahKaryawanActionPerformed

    private void tabel_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_karyawanMouseClicked
        // TODO add your handling code here:
        int selectedRow = tabel_karyawan.getSelectedRow();
        if (selectedRow != -1) { // Pastikan ada baris yang diklik
            // Mengambil data dari kolom yang relevan
            String idKaryawan = tabel_karyawan.getValueAt(selectedRow, 0).toString();
            String namaKaryawan = tabel_karyawan.getValueAt(selectedRow, 1).toString();
            String jabatan = tabel_karyawan.getValueAt(selectedRow, 2).toString();
            String Departemen = tabel_karyawan.getValueAt(selectedRow, 3).toString();
            
            this.tf_idkaryawaan.setText(tf_idkaryawaan.toString());
            tf_idkaryawaan.setText(idKaryawan);
            tf_namakaryawan.setText(namaKaryawan);
            tf_departemen.setText(Departemen);
            cb_jabatan.setSelectedItem(jabatan);
        }
    }//GEN-LAST:event_tabel_karyawanMouseClicked

    private void editKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen=? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_idkaryawaan.getText());
            ps.setString(1, tf_namakaryawan.getText());
            ps.setString(2, cb_jabatan.getSelectedItem().toString());
            ps.setString(3, tf_departemen.getText());
            ps.setInt(4, Integer.parseInt(tf_idkaryawaan.getText()));
             ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            TampilKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_editKaryawanActionPerformed

    private void hapusKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKaryawanActionPerformed
        // TODO add your handling code here:
        try  {
            String sql = "DELETE FROM karyawan WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_idkaryawaan.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            TampilKaryawan();
            updateComboBoxKaryawan();
            resetSemuaData();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_hapusKaryawanActionPerformed

    private void tambahProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahProyekActionPerformed
        // TODO add your handling code here:
        try{
            String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_idproyek.getText().toString());
            ps.setString(2, tf_namaproyek.getText());
            ps.setString(3, tf_durasiproyek.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            TampilProyek();
            updateComboBoxProyek();
            resetSemuaData();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_tambahProyekActionPerformed

    private void tabel_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_proyekMouseClicked
        // TODO add your handling code here:
        int selectedRow = tabel_proyek.getSelectedRow();
        if (selectedRow != -1) {
            String idproyek = tabel_proyek.getValueAt(selectedRow, 0).toString();
            String namaproyek = tabel_proyek.getValueAt(selectedRow, 1).toString();
            String durasiproyek = tabel_proyek.getValueAt(selectedRow, 2).toString();
            
            this.tf_idproyek.setText(tf_idproyek.toString());
            tf_idproyek.setText(idproyek);
            tf_namaproyek.setText(namaproyek);
            tf_durasiproyek.setText(durasiproyek);
        }
    }//GEN-LAST:event_tabel_proyekMouseClicked

    private void editProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editProyekActionPerformed
        // TODO add your handling code here:
        try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.setString(1, tf_idproyek.getText());
            ps.setString(1, tf_namaproyek.getText());
            ps.setString(2, tf_durasiproyek.getText().toString());
            ps.setInt(3, Integer.parseInt(tf_idproyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            TampilProyek();
            updateComboBoxProyek();
            resetSemuaData();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_editProyekActionPerformed

    private void hapusPoroyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusPoroyekActionPerformed
        // TODO add your handling code here:
        try  {
            String sql = "DELETE FROM proyek WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_idproyek.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data deleted successfully");
            TampilProyek();
            updateComboBoxProyek();
            resetSemuaData();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }//GEN-LAST:event_hapusPoroyekActionPerformed

    private void hapustransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapustransaksiActionPerformed
        // TODO add your handling code here:
            if (tf_idtransaksi.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "ID transaksi tidak boleh kosong!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int idTransaksi = Integer.parseInt(tf_idtransaksi.getText());

                String sql = "DELETE FROM transaksi WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idTransaksi);

                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus");
                    tampilTransaksi();
                } else {
                    JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Pastikan ID berformat angka!");
            } catch (SQLException e) {
                System.out.println("Error Delete Data Transaksi: " + e.getMessage());
            }
    }//GEN-LAST:event_hapustransaksiActionPerformed

    private void edittransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edittransaksiActionPerformed
        // TODO add your handling code here:
        if (tf_idtransaksi.getText().isEmpty() || 
            getSelectedKaryawanId() == -1 || getSelectedProyekId() == -1) {
            JOptionPane.showMessageDialog(this, "Pastikan semua komponen telah terisi sebelum mengedit data!", "Error", JOptionPane.ERROR_MESSAGE);;
            return;
        }

        try {
            int idKaryawan = getSelectedKaryawanId();
            int idProyek = getSelectedProyekId();
            int idTransaksi = Integer.parseInt(tf_idtransaksi.getText());

            String sql = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, tf_peran.getText().toString());
            ps.setInt(4, idTransaksi);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data transaksi berhasil diupdate");
                tampilTransaksi();
            } else {
                JOptionPane.showMessageDialog(this, "ID transaksi tidak ditemukan!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Pastikan ID berformat angka!");
        } catch (SQLException e) {
            System.out.println("Error Update Data Transaksi: " + e.getMessage());
        }
    }//GEN-LAST:event_edittransaksiActionPerformed

    private void tabel_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabel_transaksiMouseClicked
        // TODO add your handling code here:
        int selectedRow = tabel_transaksi.getSelectedRow();
        if (selectedRow != -1) { // Pastikan ada baris yang diklik
            // Mengambil data dari kolom yang relevan
            String idTransaksi = tabel_transaksi.getValueAt(selectedRow, 0).toString();
            String namaKaryawan = tabel_transaksi.getValueAt(selectedRow, 1).toString();
            String namaProyek = tabel_transaksi.getValueAt(selectedRow, 2).toString();
            String peranini = tabel_transaksi.getValueAt(selectedRow, 3).toString();

            
            this.tf_idtransaksi.setText(idTransaksi);
            cb_namakaryawantransaksi.setSelectedItem(namaKaryawan);
            cb_namaproyektransaksi.setSelectedItem(namaProyek);
            tf_peran.setText(peranini);

        }
    }//GEN-LAST:event_tabel_transaksiMouseClicked

    private void tf_idtransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_idtransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_idtransaksiActionPerformed

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
            java.util.logging.Logger.getLogger(ManajemanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManajemanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManajemanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManajemanKaryawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManajemanKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cb_jabatan;
    private javax.swing.JComboBox<String> cb_namakaryawantransaksi;
    private javax.swing.JComboBox<String> cb_namaproyektransaksi;
    private javax.swing.JButton editKaryawan;
    private javax.swing.JButton editProyek;
    private javax.swing.JButton edittransaksi;
    private untukpraktikum5.GradientRoundedPanel gradientRoundedPanel1;
    private javax.swing.JButton hapusKaryawan;
    private javax.swing.JButton hapusPoroyek;
    private javax.swing.JButton hapustransaksi;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private untukpraktikum5.RoundedPanel roundedPanel1;
    private untukpraktikum5.RoundedPanel roundedPanel2;
    private untukpraktikum5.RoundedPanel roundedPanel3;
    private untukpraktikum5.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tabel_karyawan;
    private javax.swing.JTable tabel_proyek;
    private javax.swing.JTable tabel_transaksi;
    private javax.swing.JButton tambahKaryawan;
    private javax.swing.JButton tambahProyek;
    private javax.swing.JButton tambahtransaksi;
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_durasiproyek;
    private javax.swing.JTextField tf_idkaryawaan;
    private javax.swing.JTextField tf_idproyek;
    private javax.swing.JTextField tf_idtransaksi;
    private javax.swing.JTextField tf_namakaryawan;
    private javax.swing.JTextField tf_namaproyek;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
