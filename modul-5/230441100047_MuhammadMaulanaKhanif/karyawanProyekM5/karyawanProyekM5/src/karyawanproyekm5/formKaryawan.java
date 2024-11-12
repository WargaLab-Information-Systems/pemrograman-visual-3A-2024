/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package karyawanproyekm5;

import com.formdev.flatlaf.FlatLightLaf;
import java.awt.PopupMenu;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class formKaryawan extends javax.swing.JFrame {
    int row1 = 0;
    /**
     * Creates new form formKaryawan
     */
    public formKaryawan() {
        initComponents();
        load_tabelKaryawan();
        load_tabelProyek();
        load_tabelTransaksi();
        load_comboBoxKaryawanProyek();  
    }

        private void load_tabelKaryawan(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");
        try {
            String sql = "select * from karyawan";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
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
            jTableKaryawan.setModel(model);
            System.out.println("njay");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
        
        private void load_tabelProyek(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Proyek");
        model.addColumn("Durasi");
        try { 
            String sql = "select * from proyek";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()){
                model.addRow(
                        new Object[]{
                            res.getString("id"),
                            res.getString("nama_proyek"),
                            res.getString("durasi_pengerjaan"),
                        }
                    );
                }
            jTableProyek.setModel(model);
            System.out.println("njay");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
        private void load_comboBoxKaryawanProyek(){
        try {
            jComboBoxNamaKaryawanTransaksi.removeAllItems();
            jComboBoxNamaProyekTransaksi.removeAllItems();
            String sql = "select * from karyawan";
            String sql1 = "select * from proyek";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
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
            System.out.println("njaydar");
        }catch(Exception e){
            System.out.println("123");
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
        private void load_tabelTransaksi(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Karyawan");
        model.addColumn("Proyek");
        model.addColumn("Peran");
        try {
            String sql = "SELECT karyawan.nama AS nama_karyawan, proyek.nama_proyek AS nama_proyek, peran FROM transaksi JOIN karyawan ON transaksi.id_karyawan = karyawan.id JOIN proyek ON transaksi.id_proyek = proyek.id;";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
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
            jTableTransaksi.setModel(model);
            System.out.println("njay");
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
        
  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableKaryawan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jButtonTambahKaryawan = new javax.swing.JButton();
        jButtonUpdateKaryawan = new javax.swing.JButton();
        jButtonDeleteKaryawan = new javax.swing.JButton();
        jLabelIdKaryawan = new javax.swing.JLabel();
        jTextFieldIdKaryawan = new javax.swing.JTextField();
        jLabelNamaKaryawan = new javax.swing.JLabel();
        jTextFieldNamaKaryawan = new javax.swing.JTextField();
        jLabelJabatan = new javax.swing.JLabel();
        jTextFieldJabatan = new javax.swing.JTextField();
        jLabelDepartemen = new javax.swing.JLabel();
        jTextFieldDepartemen = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableProyek = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jButtonTambahProyek = new javax.swing.JButton();
        jButtonUpdateProyek = new javax.swing.JButton();
        jButtonDeleteProyek = new javax.swing.JButton();
        jLabelIdProyek = new javax.swing.JLabel();
        jTextFieldIdProyek = new javax.swing.JTextField();
        jLabelNamaProyek = new javax.swing.JLabel();
        jTextFieldNamaProyek = new javax.swing.JTextField();
        jLabelDurasiProyek = new javax.swing.JLabel();
        jTextFieldDurasiProyek = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableTransaksi = new javax.swing.JTable();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jButtonTambahTransaksi = new javax.swing.JButton();
        jButtonUpdateTransaksi = new javax.swing.JButton();
        jButtonDeleteTransaksi = new javax.swing.JButton();
        jLabel1NamaKaryawanTransaksi = new javax.swing.JLabel();
        jComboBoxNamaKaryawanTransaksi = new javax.swing.JComboBox<>();
        jLabelNamaProyekTransaksi = new javax.swing.JLabel();
        jComboBoxNamaProyekTransaksi = new javax.swing.JComboBox<>();
        jLabelPeran = new javax.swing.JLabel();
        jTextFieldPeran = new javax.swing.JTextField();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.LEFT);

        jPanel3.setLayout(null);

        jTableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama", "Jabatan", "Departemen"
            }
        ));
        jTableKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableKaryawan);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(310, 52, 296, 320);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jButtonTambahKaryawan.setText("Tambah");
        jButtonTambahKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahKaryawanActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonTambahKaryawan);

        jButtonUpdateKaryawan.setText("Update");
        jButtonUpdateKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateKaryawanActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonUpdateKaryawan);

        jButtonDeleteKaryawan.setText("Delete");
        jButtonDeleteKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteKaryawanActionPerformed(evt);
            }
        });
        jPanel5.add(jButtonDeleteKaryawan);

        jPanel4.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 288, 242, -1));

        jLabelIdKaryawan.setText("ID");
        jPanel4.add(jLabelIdKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 160, 26));
        jPanel4.add(jTextFieldIdKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 32, 254, -1));

        jLabelNamaKaryawan.setText("Nama");
        jPanel4.add(jLabelNamaKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 56, 160, 26));
        jPanel4.add(jTextFieldNamaKaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 87, 254, -1));

        jLabelJabatan.setText("Jabatan");
        jPanel4.add(jLabelJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 115, 160, 26));
        jPanel4.add(jTextFieldJabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 147, 254, -1));

        jLabelDepartemen.setText("Departemen");
        jPanel4.add(jLabelDepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 187, 160, 26));
        jPanel4.add(jTextFieldDepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 219, 254, -1));

        jPanel3.add(jPanel4);
        jPanel4.setBounds(23, 58, 254, 317);

        jPanel14.setBackground(new java.awt.Color(51, 204, 0));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Karyawan");
        jPanel14.add(jLabel12);

        jPanel3.add(jPanel14);
        jPanel14.setBounds(0, 0, 660, 42);

        jTabbedPane1.addTab("Karyawan", jPanel3);

        jTableProyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama Proyek", "Durasi"
            }
        ));
        jTableProyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableProyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableProyek);

        jPanel8.setPreferredSize(new java.awt.Dimension(254, 317));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jButtonTambahProyek.setText("Tambah");
        jButtonTambahProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahProyekActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonTambahProyek);

        jButtonUpdateProyek.setText("Update");
        jButtonUpdateProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateProyekActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonUpdateProyek);

        jButtonDeleteProyek.setText("Delete");
        jButtonDeleteProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteProyekActionPerformed(evt);
            }
        });
        jPanel9.add(jButtonDeleteProyek);

        jPanel8.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 272, 242, -1));

        jLabelIdProyek.setText("ID");
        jPanel8.add(jLabelIdProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 140, 26));
        jPanel8.add(jTextFieldIdProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 250, -1));

        jLabelNamaProyek.setText("Nama Proyek");
        jPanel8.add(jLabelNamaProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 140, 26));
        jPanel8.add(jTextFieldNamaProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 250, -1));

        jLabelDurasiProyek.setText("Durasi Pengerjaan");
        jPanel8.add(jLabelDurasiProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 140, 26));
        jPanel8.add(jTextFieldDurasiProyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 250, -1));

        jPanel13.setBackground(new java.awt.Color(255, 102, 102));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Proyek");
        jPanel13.add(jLabel11);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proyek", jPanel6);

        jTableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Karyawan", "Proyek", "Peran"
            }
        ));
        jTableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableTransaksi);

        jPanel10.setPreferredSize(new java.awt.Dimension(254, 317));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        jButtonTambahTransaksi.setText("Tambah");
        jButtonTambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTambahTransaksiActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonTambahTransaksi);

        jButtonUpdateTransaksi.setText("Update");
        jButtonUpdateTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateTransaksiActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonUpdateTransaksi);

        jButtonDeleteTransaksi.setText("Delete");
        jButtonDeleteTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteTransaksiActionPerformed(evt);
            }
        });
        jPanel11.add(jButtonDeleteTransaksi);

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 242, -1));

        jLabel1NamaKaryawanTransaksi.setText("Nama Karyawan");
        jPanel10.add(jLabel1NamaKaryawanTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 113, 26));

        jPanel10.add(jComboBoxNamaKaryawanTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 247, -1));

        jLabelNamaProyekTransaksi.setText("Nama Proyek");
        jPanel10.add(jLabelNamaProyekTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 128, 26));

        jPanel10.add(jComboBoxNamaProyekTransaksi, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 247, -1));

        jLabelPeran.setText("Peran");
        jPanel10.add(jLabelPeran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 128, 26));
        jPanel10.add(jTextFieldPeran, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 247, -1));

        jPanel12.setBackground(new java.awt.Color(0, 204, 204));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Transaksi");
        jPanel12.add(jLabel10);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi", jPanel7);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setPreferredSize(new java.awt.Dimension(641, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        jLabel1.setText("DASHBOARD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonTambahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            String sql;
            sql = "insert into karyawan (nama, jabatan, departemen) values ('" + jTextFieldNamaKaryawan.getText() + "','" + jTextFieldJabatan.getText() + "','" + jTextFieldDepartemen.getText() + "')";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            load_tabelKaryawan();
            load_comboBoxKaryawanProyek();
            kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonTambahKaryawanActionPerformed

    public void kosong(){
        jTextFieldIdKaryawan.setText("");
        jTextFieldNamaKaryawan.setText("");
        jTextFieldJabatan.setText("");
        jTextFieldDepartemen.setText("");
        jTextFieldIdProyek.setText("");
        jTextFieldNamaProyek.setText("");
        jTextFieldDurasiProyek.setText("");
        jComboBoxNamaKaryawanTransaksi.setSelectedIndex(0);
        jComboBoxNamaProyekTransaksi.setSelectedIndex(0);
        jTextFieldPeran.setText("");
    }
    
    private void jButtonTambahProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahProyekActionPerformed
        // TODO add your handling code here:
        try {
            String sql;
            sql = "insert into proyek (nama_proyek, durasi_pengerjaan) values ('" + jTextFieldNamaProyek.getText() + "','" + jTextFieldDurasiProyek.getText() + " minggu')";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            load_tabelProyek();
            load_comboBoxKaryawanProyek();
            kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonTambahProyekActionPerformed

    private void jButtonUpdateKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            String sql;
            sql = "UPDATE karyawan SET nama = '" + jTextFieldNamaKaryawan.getText() + "', " + "jabatan = '" + jTextFieldJabatan.getText() + "', " + "departemen = '" + jTextFieldDepartemen.getText() + "' " + "WHERE id = '" + jTextFieldIdKaryawan.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            load_tabelKaryawan();
            load_comboBoxKaryawanProyek();
            kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateKaryawanActionPerformed

    private void jButtonUpdateProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateProyekActionPerformed
        // TODO add your handling code here:
        try {
            String sql;
            sql = "UPDATE proyek SET nama_proyek = '" + jTextFieldNamaProyek.getText() + "', " + "durasi_pengerjaan = '" + jTextFieldDurasiProyek.getText() + "'" + "WHERE id = '" + jTextFieldIdKaryawan.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");
            load_tabelProyek();
            load_comboBoxKaryawanProyek();
//            kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateProyekActionPerformed

    private void jTableKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableKaryawanMouseClicked
        // TODO add your handling code here:
        int row = jTableKaryawan.getSelectedRow(); 
        
        if (row != -1) {
            jTextFieldIdKaryawan.setText(jTableKaryawan.getValueAt(row, 0).toString());
            jTextFieldNamaKaryawan.setText(jTableKaryawan.getValueAt(row, 1).toString());
            jTextFieldJabatan.setText(jTableKaryawan.getValueAt(row, 2).toString()); 
            jTextFieldDepartemen.setText(jTableKaryawan.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_jTableKaryawanMouseClicked

    private void jTableProyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableProyekMouseClicked
        // TODO add your handling code here:
        int row = jTableProyek.getSelectedRow(); 
        
        if (row != -1) {
            jTextFieldIdProyek.setText(jTableProyek.getValueAt(row, 0).toString());
            jTextFieldNamaProyek.setText(jTableProyek.getValueAt(row, 1).toString());
            jTextFieldDurasiProyek.setText(jTableProyek.getValueAt(row, 2).toString());   
        }
    }//GEN-LAST:event_jTableProyekMouseClicked

    private void jButtonDeleteKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteKaryawanActionPerformed
        // TODO add your handling code here:
        try {
            String sql;
            sql = "DELETE from karyawan where id = '" + jTextFieldIdKaryawan.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            
            int pilihan = JOptionPane.showConfirmDialog(this, "apakah anda yakin lurd?");
            if (pilihan == JOptionPane.YES_OPTION) {
            pst.execute();
            load_tabelKaryawan();
            }
            kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteKaryawanActionPerformed

    private void jButtonDeleteProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteProyekActionPerformed
        // TODO add your handling code here:
        try {
            String sql;
            sql = "DELETE from proyek where id = '" + jTextFieldIdProyek.getText() + "'";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            int pilihan = JOptionPane.showConfirmDialog(this, "apakah anda yakin lurd?");
            if (pilihan == JOptionPane.YES_OPTION) {
            pst.execute();
            load_tabelProyek();
            load_comboBoxKaryawanProyek();
            }
            kosong();
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteProyekActionPerformed

    private void jButtonTambahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTambahTransaksiActionPerformed
        // TODO add your handling code here:
        int idKaryawan = jComboBoxNamaKaryawanTransaksi.getSelectedIndex()+1;
        int idProyek = jComboBoxNamaProyekTransaksi.getSelectedIndex()+1;
        int id_proyek = 0;
        int id_karyawan = 0;
        try{
            String sql = "select id from karyawan ;";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            int ulang = 1;
            while (res.next()){
                System.out.println(ulang);
                if(ulang == idKaryawan){
                    id_karyawan = res.getInt("id");
//                    System.out.println(res.getString("id"));
                }
                ulang++;
            }  
            ulang = 1;
            String sql1 = "select id from proyek; ";
            java.sql.Statement stm1 = conn.createStatement();
            java.sql.ResultSet res1 = stm1.executeQuery(sql1);
             while (res1.next()){
                if(ulang == idProyek){
//                    System.out.println(res1.getString("id"));
                    id_proyek = res1.getInt("id");
                }
                ulang++;
            }  
            ulang = 1;
            
            String addTransaksi = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(addTransaksi);
            ps.setInt(1, id_karyawan);
            ps.setInt(2, id_proyek);
            ps.setString(3, jTextFieldPeran.getText());
            ps.executeUpdate();
            kosong();
            load_tabelTransaksi();
        } catch (SQLException e) {
          System.out.println("Error Save Data Transaksi" + e.getMessage());
        }
    }//GEN-LAST:event_jButtonTambahTransaksiActionPerformed

    private void jTableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableTransaksiMouseClicked
        // TODO add your handling code here:
        row1 = jTableTransaksi.getSelectedRow(); 
        
        if (row1 != -1) {
            jTextFieldPeran.setText(jTableTransaksi.getValueAt(row1, 2).toString());
            jComboBoxNamaKaryawanTransaksi.setSelectedItem(jTableTransaksi.getValueAt(row1, 0).toString());
            jComboBoxNamaProyekTransaksi.setSelectedItem(jTableTransaksi.getValueAt(row1, 1).toString());
        }
    }//GEN-LAST:event_jTableTransaksiMouseClicked

    private void jButtonUpdateTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateTransaksiActionPerformed
        // TODO add your handling code here:
        int idKaryawan = jComboBoxNamaKaryawanTransaksi.getSelectedIndex()+1;
        int idProyek = jComboBoxNamaProyekTransaksi.getSelectedIndex()+1;
        int id_proyek = 0;
        int id_karyawan = 0;
        try{
            String sql = "select * from karyawan ";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            int ulang = 1;
            while (res.next()){
//                System.out.println(ulang);
                if(ulang == idKaryawan){
                    id_karyawan = res.getInt("id");
                    System.out.println(res.getString("id"));
                    System.out.println(res.getString("nama"));
                }
                ulang++;
            }  
            ulang = 1;
            String sql1 = "select * from proyek ";
            java.sql.Statement stm1 = conn.createStatement();
            java.sql.ResultSet res1 = stm1.executeQuery(sql1);
            while (res1.next()){
                if(ulang == idProyek){
                    System.out.println(res1.getString("id"));
                    System.out.println(res1.getString("nama_proyek"));
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
                System.out.println("warr");
                int idKaryawanTransaksi = res2.getInt("id_karyawan");
                int idProyekTransaksi = res2.getInt("id_proyek");
                System.out.println("ini row ke " + row2);
                System.out.println(res2.getInt("id_karyawan"));
                System.out.println(res2.getInt("id_proyek"));
                String addTransaksi = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_karyawan = ? AND id_proyek = ?;";
                System.out.println("duarrr156234");
                PreparedStatement ps = conn.prepareStatement(addTransaksi);
                ps.setInt(1, id_karyawan);
                ps.setInt(2, id_proyek);
                ps.setString(3, jTextFieldPeran.getText());
                ps.setInt(4, idKaryawanTransaksi);
                ps.setInt(5, idProyekTransaksi);
                ps.executeUpdate();
                load_tabelTransaksi();
                System.out.println("berhasil");
            }ulang++;  }
            kosong();
        } catch (SQLException e) {
          System.out.println("Error Save Data Transaksi" + e.getMessage());
        }
    }//GEN-LAST:event_jButtonUpdateTransaksiActionPerformed

    private void jButtonDeleteTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteTransaksiActionPerformed
        // TODO add your handling code here:
        int id_proyek = 0;
        int id_karyawan = 0;
        try{
            int ulang = 1;
            String sql2 = "select id_karyawan, id_proyek from transaksi";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
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
                load_tabelTransaksi();
                System.out.println("berhasil");
            }ulang++;  }
            kosong();
        } catch (SQLException e) {
          System.out.println("Error Save Data Transaksi" + e.getMessage());
        }
    }//GEN-LAST:event_jButtonDeleteTransaksiActionPerformed
    

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
         try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception e) {
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formKaryawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonDeleteKaryawan;
    private javax.swing.JButton jButtonDeleteProyek;
    private javax.swing.JButton jButtonDeleteTransaksi;
    private javax.swing.JButton jButtonTambahKaryawan;
    private javax.swing.JButton jButtonTambahProyek;
    private javax.swing.JButton jButtonTambahTransaksi;
    private javax.swing.JButton jButtonUpdateKaryawan;
    private javax.swing.JButton jButtonUpdateProyek;
    private javax.swing.JButton jButtonUpdateTransaksi;
    private javax.swing.JComboBox<String> jComboBoxNamaKaryawanTransaksi;
    private javax.swing.JComboBox<String> jComboBoxNamaProyekTransaksi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel1NamaKaryawanTransaksi;
    private javax.swing.JLabel jLabelDepartemen;
    private javax.swing.JLabel jLabelDurasiProyek;
    private javax.swing.JLabel jLabelIdKaryawan;
    private javax.swing.JLabel jLabelIdProyek;
    private javax.swing.JLabel jLabelJabatan;
    private javax.swing.JLabel jLabelNamaKaryawan;
    private javax.swing.JLabel jLabelNamaProyek;
    private javax.swing.JLabel jLabelNamaProyekTransaksi;
    private javax.swing.JLabel jLabelPeran;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
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
    private javax.swing.JTable jTableKaryawan;
    private javax.swing.JTable jTableProyek;
    private javax.swing.JTable jTableTransaksi;
    private javax.swing.JTextField jTextFieldDepartemen;
    private javax.swing.JTextField jTextFieldDurasiProyek;
    private javax.swing.JTextField jTextFieldIdKaryawan;
    private javax.swing.JTextField jTextFieldIdProyek;
    private javax.swing.JTextField jTextFieldJabatan;
    private javax.swing.JTextField jTextFieldNamaKaryawan;
    private javax.swing.JTextField jTextFieldNamaProyek;
    private javax.swing.JTextField jTextFieldPeran;
    // End of variables declaration//GEN-END:variables
}
