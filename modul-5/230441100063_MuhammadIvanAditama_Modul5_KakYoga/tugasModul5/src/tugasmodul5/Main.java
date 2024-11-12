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
 * @author Ivan Aditama
 */
public class Main extends javax.swing.JFrame {

    //inisiasi GLobal Variable
    Connection conn;
//    private DefaultTableModel model;
    //end global variable
    
    public Main() {
        initComponents();
        conn = koneksi.getConnection();
        
        cbNamaa();
        cbProyek();
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();    
    }

    private void kosong(){
        txtIdKaryawan.setText("");
        txtIdProyek.setText("");
        txtIdTransaksi.setText("");
        txtNama.setText("");
        txtJabatan.setText("");
        txtDepartemen.setText("");
        txtProyek.setText("");
        txtDurasi.setText("");
        txtPeran.setText("");
        cbNama.setSelectedIndex(0);
        cbProyek.setSelectedIndex(0);
    }
    
    private void loadDataKaryawan(){
        DefaultTableModel modelK = new DefaultTableModel();
        tbl_karyawan.setModel(modelK);

        modelK.addColumn("ID");
        modelK.addColumn("Nama");
        modelK.addColumn("Jabatan");
        modelK.addColumn("Departemen");
        
        modelK.setRowCount(0);

        try {
            String sql = "SELECT * FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               // Menambahkan baris ke dalam model tabel
               modelK.addRow(new Object[]{
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
    
    private void loadDataProyek(){
        DefaultTableModel modelP = new DefaultTableModel();
        tbl_proyek.setModel(modelP);
        
        modelP.addColumn("ID");
        modelP.addColumn("Proyek");
        modelP.addColumn("Durasi");
        
        modelP.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               // Menambahkan baris ke dalam model tabel
               modelP.addRow(new Object[]{
               rs.getInt("id_proyek"),
               rs.getString("nama_proyek"),
               rs.getString("durasi_pengerjaan"),
             });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
    }
    
    private void loadDataTransaksi(){
        DefaultTableModel modelT = new DefaultTableModel();
        tbl_transaksi.setModel(modelT);
        
        modelT.addColumn("ID");
        modelT.addColumn("Id_Karyawan");
        modelT.addColumn("Id_Proyek");
        modelT.addColumn("Peran");
        
        modelT.setRowCount(0);
        
        try {
            String sql = "SELECT * FROM transaksi";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
               // Menambahkan baris ke dalam model tabel
               modelT.addRow(new Object[]{
               rs.getInt("id_transaksi"),
               rs.getString("id_karyawan"),
               rs.getString("id_proyek"),
               rs.getString("peran"),
             });
            }
        } catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
    }
    
    private void saveDataKaryawan(){
        if(txtNama.getText().isEmpty()|| txtJabatan.getText().isEmpty()||txtDepartemen.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Salah satu form masih kosong", "peringatan", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
            String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtNama.getText());
            ps.setString(2, txtJabatan.getText());
            ps.setString(3, txtDepartemen.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadDataKaryawan();
          } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
          }
        }
    }
    
    private void saveDataProyek(){
        if(txtProyek.getText().isEmpty()|| txtDurasi.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Salah satu form masih kosong", "peringatan", JOptionPane.ERROR_MESSAGE);
        }else{
            try{
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtProyek.getText());
            ps.setString(2, txtDurasi.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadDataProyek();
          } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
          }
        }
        
    }
    
    private void saveDataTransaksi(){
        try {
            String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cbNama.getSelectedItem().toString());
            ps.setString(2, cbProyek.getSelectedItem().toString());
            ps.setString(3, txtPeran.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadDataTransaksi();
        } catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void updateKaryawan(){
        try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id_karyawan = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, txtNama.getText());
          ps.setString(2, txtJabatan.getText());
          ps.setString(3, txtDepartemen.getText());
          ps.setInt(4, Integer.parseInt(txtIdKaryawan.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDataKaryawan();
        }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
    
    private void updateProyek(){
        try {
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id_proyek = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, txtProyek.getText());
          ps.setString(2, txtDurasi.getText());
          ps.setInt(3, Integer.parseInt(txtIdProyek.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDataProyek();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
    
    private void updateTransaksi(){
        try {
          String sql = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_transaksi = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, cbNama.getSelectedItem().toString());
          ps.setString(2, cbProyek.getSelectedItem().toString());
          ps.setString(2, txtPeran.getText());
          ps.setInt(3, Integer.parseInt(txtIdTransaksi.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDataTransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }
    
    private void deleteKaryawan(){
        try {
            String idK = txtIdKaryawan.getText();

            if (idK.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID belum dipilih. Silakan pilih data terlebih dahulu.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM karyawan WHERE id_karyawan = ?";
//                    java.sql.Connection conn = (Connection) koneksi.getConnection();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, idK);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    loadDataKaryawan();
                    kosong();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void deleteProyek(){
        try {
            String idP = txtIdProyek.getText();

            if (idP.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID belum dipilih. Silakan pilih data terlebih dahulu.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM proyek WHERE id_proyek = ?";
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, idP);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    loadDataProyek();
                    kosong();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void deleteTransaksi(){
        try {
            String idT = txtIdTransaksi.getText();

            if (idT.isEmpty()) {
                JOptionPane.showMessageDialog(null, "ID belum dipilih. Silakan pilih data terlebih dahulu.");
            } else {
                int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

                if (confirm == JOptionPane.YES_OPTION) {
                    String sql = "DELETE FROM transaksi WHERE id_transaksi = ?";
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, idT);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");
                    loadDataTransaksi();
                    kosong();
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void cbNamaa(){
        try {
            String sql = "SELECT id_karyawan FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbNama.removeAllItems();
//            int count = 0;
            while (rs.next()) {
                cbNama.addItem(rs.getString("id_karyawan"));
//                count++;
            }
        }
        catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
        }
    }
    
    private void cbProyek(){
        try {
            String sql = "SELECT id_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            cbProyek.removeAllItems();
            int count = 0;
            while (rs.next()) {
                cbProyek.addItem(rs.getString("id_proyek"));
                count++;
            }
        }
        catch (SQLException e) {
           System.out.println("Error Save Data" + e.getMessage());
         }
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

        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        tabbedPaneCustom1 = new tugasmodul5.TabbedPaneCustom();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtJabatan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtDepartemen = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtIdKaryawan = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtIdProyek = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtProyek = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDurasi = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtIdTransaksi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbNama = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        cbProyek = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        txtPeran = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("MV Boli", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("APLIKASI MANAJAMEN KARYAWAN & PROYEK");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        tabbedPaneCustom1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(83, 142, 142));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_karyawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "NAMA", "JABATAN", "DEPARTEMEN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbl_karyawan);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 440, 228));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("TABEL KARYAWAN");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel3.setText("Nama :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel5.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 61;
        jPanel5.add(txtNama, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel4.setText("Jabatan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel5.add(jLabel4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 61;
        jPanel5.add(txtJabatan, gridBagConstraints);

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel1.setText("Departemen :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel5.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 61;
        jPanel5.add(txtDepartemen, gridBagConstraints);

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel2.setText("ID :");
        jPanel5.add(jLabel2, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 61;
        jPanel5.add(txtIdKaryawan, gridBagConstraints);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 250));

        jPanel6.setLayout(new java.awt.GridLayout(2, 3));

        jButton1.setText("TAMBAH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton1);

        jButton2.setText("EDIT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton2);

        jButton3.setText("HAPUS");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton3);

        jButton10.setText("KELUAR");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton10);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 130));

        tabbedPaneCustom1.addTab("Karyawan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(128, 85, 128));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "PROYEK", "DURASI"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tbl_proyek);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 440, 230));

        jLabel11.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TABEL PROYEK");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 20, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel8.setText("ID :");
        jPanel7.add(jLabel8, new java.awt.GridBagConstraints());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 61;
        jPanel7.add(txtIdProyek, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel9.setText("Proyek :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel7.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 61;
        jPanel7.add(txtProyek, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel10.setText("Durasi proyek :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel7.add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 61;
        jPanel7.add(txtDurasi, gridBagConstraints);

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 250));

        jPanel8.setLayout(new java.awt.GridLayout(2, 0));

        jButton4.setText("TAMBAH");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton4);

        jButton5.setText("EDIT");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton5);

        jButton6.setText("HAPUS");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton6);

        jButton11.setText("KELUAR");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel8.add(jButton11);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 130));

        tabbedPaneCustom1.addTab("Proyek", jPanel2);

        jPanel3.setBackground(new java.awt.Color(51, 90, 117));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID_TRANSAKSI", "ID_KARYAWAN", "ID_PROYEK", "PERAN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, 440, 228));

        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("TABEL TRANSAKSI");
        jPanel3.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, -1, -1));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel5.setText("ID :");
        jPanel9.add(jLabel5, new java.awt.GridBagConstraints());

        txtIdTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdTransaksiActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 61;
        jPanel9.add(txtIdTransaksi, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel6.setText("Id_karyawan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel9.add(jLabel6, gridBagConstraints);

        cbNama.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        cbNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamaActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 61;
        jPanel9.add(cbNama, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel13.setText("Id_Proyek :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        jPanel9.add(jLabel13, gridBagConstraints);

        cbProyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 61;
        jPanel9.add(cbProyek, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 16)); // NOI18N
        jLabel14.setText("Peran :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        jPanel9.add(jLabel14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 61;
        jPanel9.add(txtPeran, gridBagConstraints);

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 250));

        jPanel10.setLayout(new java.awt.GridLayout(2, 0));

        jButton7.setText("TAMBAH");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton7);

        jButton8.setText("EDIT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton8);

        jButton9.setText("HAPUS");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton9);

        jButton12.setText("KELUAR");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton12);

        jPanel3.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 210, 130));

        tabbedPaneCustom1.addTab("Transaksi", jPanel3);

        jPanel4.add(tabbedPaneCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 668, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 690, 500));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saveDataKaryawan();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        updateKaryawan();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        saveDataProyek();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbNamaActionPerformed

    private void txtIdTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdTransaksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdTransaksiActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        deleteTransaksi();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        deleteProyek();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteKaryawan();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        saveDataTransaksi();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        updateProyek();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        updateTransaksi();
        cbNamaa();
        cbProyek();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbNama;
    private javax.swing.JComboBox<String> cbProyek;
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
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private tugasmodul5.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField txtDepartemen;
    private javax.swing.JTextField txtDurasi;
    private javax.swing.JTextField txtIdKaryawan;
    private javax.swing.JTextField txtIdProyek;
    private javax.swing.JTextField txtIdTransaksi;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtPeran;
    private javax.swing.JTextField txtProyek;
    // End of variables declaration//GEN-END:variables
}
