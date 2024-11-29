/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyek;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class karyawan3 extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel model;
    private DefaultTableModel model1;
    private DefaultTableModel model2;
   
    public karyawan3() {
        initComponents();
        conn = (Connection) koneksi.getkoneksi();;
        
        model = new DefaultTableModel();
        tbl_karyawan.setModel(model);
        
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("DEPATERMEN");
        
        loadDatakaryawan();
        
        model1 = new DefaultTableModel();
        tbl_proyek.setModel(model1);
    

        model1.addColumn("ID");
        model1.addColumn("NAMA PROYEK");
        model1.addColumn("DURASI");

        loadDataproyek();
        
        model2 = new DefaultTableModel();
        tbl_transaksi.setModel(model2);
    
        model2.addColumn("ID KARYAWAN");
        model2.addColumn("NAMA KARYAWAN");
        model2.addColumn("ID PROYEK");
        model2.addColumn("NAMA PROYEK");
        model2.addColumn("PERAN");

        loadDatatransaksi();
        loadProyek();
        loadKaryawan();
        
    }
     private void loadDatakaryawan() {
      model.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             model.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama"),
             rs.getString("jabatan"),
             rs.getString("departemen"),
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }
     
     private void loadDataproyek() {
      model1.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             model1.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getString("durasi_pengerjaan")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }

    private void loadDatatransaksi() {

        model2.setRowCount(0);

          try {
              String sql = "SELECT k.nama AS karyawan, p.nama_proyek AS proyek,t.* FROM transaksi t JOIN karyawan k ON t.id_karyawan = k.id JOIN proyek p ON t.id_proyek = p.id";
              PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query 
              ResultSet rs = ps.executeQuery();//menyimpan data
              while (rs.next()) {
                 // Menambahkan baris ke dalam model tabel
                 model2.addRow(new Object[]{
                 rs.getInt("id_karyawan"),
                 rs.getString("karyawan"),
                 rs.getInt("id_proyek"),
                 rs.getString("proyek"),
                 rs.getString("peran")
               });
              }
          } catch (SQLException e) {
             System.out.println("Error Save Data" + e.getMessage());
           }
    }
    
    private void loadProyek() {
    String proyek = "SELECT id, Nama_Proyek FROM proyek";
    cb_proyek.removeAllItems();
    cb_proyek.addItem("Pilih Proyek");

    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String idProyek = rsProyek.getString("id");
            String namaProyek = rsProyek.getString("Nama_Proyek");
            cb_proyek.addItem(idProyek );
        }
    } catch (SQLException e) {
        System.out.println("Error Load Proyek Data: " + e.getMessage());
    }
}
    
    private void loadKaryawan() {
    String karyawan = "SELECT id, Nama FROM karyawan";
    cb_karyawan.removeAllItems();
    cb_karyawan.addItem("Pilih Karyawan");

    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String idKaryawan = rsKaryawan.getString("id");
            String namaKaryawan = rsKaryawan.getString("Nama");
            cb_karyawan.addItem(idKaryawan );
        }
    } catch (SQLException e) {
        System.out.println("Error Load Karyawan Data: " + e.getMessage());
    }
}

    
    private void simpanDatakaryawan() {
      try {
            if (tf_idK.getText().trim().isEmpty() || tf_namaK.getText().trim().isEmpty() || tf_jabatan.getText().trim().isEmpty() || tf_departemen.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, tf_idK.getText().trim());
            ps.setString(2, tf_namaK.getText().trim());
            ps.setString(3, tf_jabatan.getText().trim());
            ps.setString(4, tf_departemen.getText().trim());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadDatakaryawan();
            kosong();
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        }

    }
    
    private void editDatakaryawan() {
      try {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ?WHERE id = ?";

            PreparedStatement ps = conn.prepareStatement(sql);//pelingdung untuk si query

            ps.setString(1, tf_namaK.getText());
            ps.setString(2, tf_jabatan.getText());
            ps.setString(3, tf_departemen.getText());
            ps.setInt(4, Integer.parseInt(tf_idK.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data updated successfully");
            loadDatakaryawan();
            
            kosong();
        }catch (SQLException e) {
            System.out.println("Error Save Data" + e.getMessage());
            }
    }
    
     //Delete Data
    private void hapusDatakaryawan() {
        try {
            int confirm = JOptionPane.showConfirmDialog(null, "Yakin nih mau dihapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM karyawan WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(tf_idK.getText()));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil dihapus.", "Informasi", JOptionPane.INFORMATION_MESSAGE);
                loadDatakaryawan();
                kosong();
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
        }
    }
    
    private void kosong(){
        tf_idK.setText("");
        tf_namaK.setText("");
        tf_jabatan.setText("");
        tf_departemen.setText("");
    }
    
    private void kosong1(){
        tf_idP.setText("");
        tf_namaP.setText("");
        tf_durasi.setText("");
    }
    
    private void kosong2(){
        tf_peran.setText("");
    }
     
     
     
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cb_proyek = new javax.swing.JComboBox<>();
        cb_karyawan = new javax.swing.JComboBox<>();
        tf_peran = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        btn_simpanT = new javax.swing.JButton();
        btn_hapusT = new javax.swing.JButton();
        btn_editT = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        tf_idP = new javax.swing.JTextField();
        tf_namaP = new javax.swing.JTextField();
        tf_durasi = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        btn_simpanP = new javax.swing.JButton();
        btn_editP = new javax.swing.JButton();
        btn_hapusP = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tf_idK = new javax.swing.JTextField();
        tf_namaK = new javax.swing.JTextField();
        tf_jabatan = new javax.swing.JTextField();
        tf_departemen = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btn_editK = new javax.swing.JButton();
        btn_simpanK = new javax.swing.JButton();
        btn_hapusK = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(173, 179, 48));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Id Karyawan :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Id Proyek :");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setText("Peran :");

        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
        jScrollPane3.setViewportView(tbl_transaksi);

        jLabel2.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel2.setText("TRANSAKSI PROYEK");

        cb_proyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih--" }));
        cb_proyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_proyekActionPerformed(evt);
            }
        });

        cb_karyawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        btn_simpanT.setBackground(new java.awt.Color(173, 179, 48));
        btn_simpanT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_simpanT.setText("SIMPAN");
        btn_simpanT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanTActionPerformed(evt);
            }
        });

        btn_hapusT.setBackground(new java.awt.Color(173, 179, 48));
        btn_hapusT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hapusT.setText("HAPUS");
        btn_hapusT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusTActionPerformed(evt);
            }
        });

        btn_editT.setBackground(new java.awt.Color(173, 179, 48));
        btn_editT.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_editT.setText("EDIT");
        btn_editT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_simpanT, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(btn_editT, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(btn_hapusT, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpanT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapusT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel4)
                .addGap(134, 134, 134)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(134, 134, 134))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(234, 234, 234))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 644, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(cb_proyek, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(cb_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cb_proyek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cb_karyawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(29, 29, 29)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 57, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Transaksi", jPanel2);

        jPanel7.setBackground(new java.awt.Color(31, 181, 163));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setText("id : ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setText("Nama Proyek :");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setText("Durasi Pengerjaan :");

        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3"
            }
        ));
        jScrollPane2.setViewportView(tbl_proyek);

        tf_namaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaPActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        btn_simpanP.setBackground(new java.awt.Color(31, 181, 163));
        btn_simpanP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_simpanP.setText("SIMPAN");
        btn_simpanP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanPActionPerformed(evt);
            }
        });

        btn_editP.setBackground(new java.awt.Color(31, 181, 163));
        btn_editP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_editP.setText("EDIT");
        btn_editP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editPActionPerformed(evt);
            }
        });

        btn_hapusP.setBackground(new java.awt.Color(31, 181, 163));
        btn_hapusP.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hapusP.setText("HAPUS");
        btn_hapusP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(btn_simpanP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_editP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapusP, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpanP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_editP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapusP, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel7.setText("INFORMASI PROYEK");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(tf_idP, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(37, 37, 37)
                                .addComponent(tf_namaP, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(tf_durasi, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(135, 135, 135)
                                .addComponent(jLabel10)
                                .addGap(96, 96, 96)
                                .addComponent(jLabel9))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel7))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 646, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
                .addGap(12, 12, 12)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel10)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_idP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_namaP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_durasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Proyek", jPanel3);

        jPanel5.setBackground(new java.awt.Color(150, 248, 67));

        jLabel11.setFont(new java.awt.Font("Bodoni MT", 1, 18)); // NOI18N
        jLabel11.setText("INFORMASI KARYAWAN");

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
        jScrollPane1.setViewportView(tbl_karyawan);

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("id : ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setText("Nama :");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setText("Jabatan :");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setText("Departemen :");

        tf_namaK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_namaKActionPerformed(evt);
            }
        });

        tf_departemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_departemenActionPerformed(evt);
            }
        });

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btn_editK.setBackground(new java.awt.Color(150, 248, 67));
        btn_editK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_editK.setText("EDIT");
        btn_editK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editKActionPerformed(evt);
            }
        });

        btn_simpanK.setBackground(new java.awt.Color(150, 248, 67));
        btn_simpanK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_simpanK.setText("SIMPAN");
        btn_simpanK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanKActionPerformed(evt);
            }
        });

        btn_hapusK.setBackground(new java.awt.Color(150, 248, 67));
        btn_hapusK.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_hapusK.setText("HAPUS");
        btn_hapusK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btn_simpanK, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(btn_editK, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btn_hapusK, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(87, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_editK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_simpanK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_hapusK, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel12)
                        .addGap(134, 134, 134)
                        .addComponent(jLabel13)
                        .addGap(94, 94, 94)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(jLabel15))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(224, 224, 224)
                        .addComponent(jLabel11))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(tf_idK, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_namaK, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(tf_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 584, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(92, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_idK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_namaK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tf_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Karyawan", jPanel4);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 29, -1, -1));

        jLabel1.setFont(new java.awt.Font("Bodoni MT", 1, 14)); // NOI18N
        jLabel1.setText("APLIKASI MANAJEMEN KARYAWAN DAN PROYEK");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 6, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 693, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf_namaKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaKActionPerformed

    private void tf_departemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_departemenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_departemenActionPerformed

    private void btn_simpanKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanKActionPerformed
        // TODO add your handling code here:
        simpanDatakaryawan();
    }//GEN-LAST:event_btn_simpanKActionPerformed

    private void btn_hapusKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusKActionPerformed
        // TODO add your handling code here:
        hapusDatakaryawan();
    }//GEN-LAST:event_btn_hapusKActionPerformed

    private void tf_namaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_namaPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_namaPActionPerformed

    private void btn_simpanPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanPActionPerformed
        // TODO add your handling code here:
        try {
        // Validasi input
            if (tf_idP.getText().trim().isEmpty() || tf_namaP.getText().trim().isEmpty() || tf_durasi.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Data tidak lengkap", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(tf_idP.getText().trim()));
            ps.setString(2, tf_namaP.getText().trim());
            ps.setInt(3, Integer.parseInt(tf_durasi.getText().trim()));

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadDataproyek();
            kosong1();
            
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Durasi harus berupa angka", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btn_simpanPActionPerformed

    private void btn_editPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editPActionPerformed
        // TODO add your handling code here:
        try {
          String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          
          ps.setString(1, tf_namaP.getText());
          ps.setInt(2, Integer.parseInt(tf_durasi.getText()));
          ps.setInt(3, Integer.parseInt(tf_idP.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data updated successfully");
          loadDataproyek();
          kosong1();
          
      }  catch (SQLException e) {
          System.out.println("Error Save Data" + e.getMessage());
      }
    }//GEN-LAST:event_btn_editPActionPerformed

    private void btn_hapusPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusPActionPerformed
        // TODO add your handling code here:
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin nih mau dihapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM proyek WHERE id = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(tf_idP.getText()));
                ps.executeUpdate();

                JOptionPane.showMessageDialog(this, "Data deleted successfully");
                loadDataproyek();
                kosong2();
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusPActionPerformed

    private void btn_hapusTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusTActionPerformed
        // TODO add your handling code here:
        try {
            int confirm = JOptionPane.showConfirmDialog(this, "Yakin nih mau dihapus?", "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "DELETE FROM transaksii WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, Integer.parseInt(cb_karyawan.getSelectedItem().toString()));
                ps.setInt(2, Integer.parseInt(cb_proyek.getSelectedItem().toString()));
                ps.execute();

                JOptionPane.showMessageDialog(this, "Data yang dihapus sukses");
                loadDatatransaksi();
                loadProyek();
                loadKaryawan();
                kosong2();
            }
        } catch (SQLException e) {
            System.out.println("Error Delete Data: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_hapusTActionPerformed

    private void btn_simpanTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanTActionPerformed
        // TODO add your handling code here:
        if (tf_peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "harap isi data dengan benar", "DISCLAIMER !!!", JOptionPane.WARNING_MESSAGE);
        } else if (tf_peran.getText().trim().matches("^\\s+$")) {
            JOptionPane.showMessageDialog(this, "Data tidak valid", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
    
        try {
            String sql = "INSERT INTO transaksii (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, cb_karyawan.getSelectedItem().toString());
            ps.setString(2, cb_proyek.getSelectedItem().toString());
            ps.setString(3, tf_peran.getText().trim());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data saved successfully");
            loadDatatransaksi();
            loadProyek();
            loadKaryawan();
            kosong2();
            
        } catch (SQLException e) {
            System.out.println("Error Save Data: " + e.getMessage());
            }
        }
    }//GEN-LAST:event_btn_simpanTActionPerformed

    private void btn_editTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editTActionPerformed
        // TODO add your handling code here:
        try {
           // Validasi apakah semua field telah diisi
            if (tf_peran.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Semua kolom harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return; // Menghentikan proses jika ada field yang kosong
            }

            String selectedKaryawan = (String) cb_karyawan.getSelectedItem();
            String selectedProyek = (String) cb_proyek.getSelectedItem();
            String peran = tf_peran.getText(); 

            // Perbarui data transaksi di database
            String sqlUpdate = "UPDATE transaksii SET Peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, peran);    
            ps.setInt(2, Integer.parseInt(selectedKaryawan));  
            ps.setInt(3, Integer.parseInt(selectedProyek));    
            int rowsUpdated = ps.executeUpdate();

            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(null, "Data berhasil diperbarui!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan atau tidak ada perubahan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            }
            
            loadDatatransaksi();
            loadProyek();
            loadKaryawan();
            
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
    }//GEN-LAST:event_btn_editTActionPerformed

    private void btn_editKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editKActionPerformed
        // TODO add your handling code here:
        editDatakaryawan();
    }//GEN-LAST:event_btn_editKActionPerformed

    private void cb_proyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_proyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cb_proyekActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tbl_transaksiMouseClicked
    
    
    
    
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
            java.util.logging.Logger.getLogger(karyawan3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(karyawan3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(karyawan3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(karyawan3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new karyawan3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_editK;
    private javax.swing.JButton btn_editP;
    private javax.swing.JButton btn_editT;
    private javax.swing.JButton btn_hapusK;
    private javax.swing.JButton btn_hapusP;
    private javax.swing.JButton btn_hapusT;
    private javax.swing.JButton btn_simpanK;
    private javax.swing.JButton btn_simpanP;
    private javax.swing.JButton btn_simpanT;
    private javax.swing.JComboBox<String> cb_karyawan;
    private javax.swing.JComboBox<String> cb_proyek;
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
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
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
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_durasi;
    private javax.swing.JTextField tf_idK;
    private javax.swing.JTextField tf_idP;
    private javax.swing.JTextField tf_jabatan;
    private javax.swing.JTextField tf_namaK;
    private javax.swing.JTextField tf_namaP;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
    
