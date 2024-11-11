
import javax.swing.table.DefaultTableModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author User
 */
public class Main extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan, modelProyek, modelTransaksi;
    ArrayList<Integer> listIdKaryawan = new ArrayList<>();
    ArrayList<Integer> listIdProyek = new ArrayList<>();
    /**
     * Creates new form Main
     */
    public Main() {
        initComponents();
        
        conn = connection.getConnection();
        setupKaryawanModel();
        setupProyekModel();
        setupTransaksiModel();
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        setupCmbBoxKaryawan();
        setupCmbBoxProyek();
    }
    
    private void setupKaryawanModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");
        
        this.modelKaryawan = model;
        tbKaryawan.setModel(model);
        tbKaryawan.setEnabled(false);
    }
    
    private void setupProyekModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Nama Proyek");
        model.addColumn("Durasi");

        this.modelProyek = model;
        tbProyek.setModel(modelProyek);
        tbProyek.setEnabled(false);
    }
    
    private void setupTransaksiModel() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Karyawan");
        model.addColumn("Proyek");
        model.addColumn("Peran");
        
        this.modelTransaksi = model;
        tbTransaksi.setModel(modelTransaksi);
        tbTransaksi.setEnabled(false);
    }
    
    private void loadDataKaryawan() {
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
                rs.getString("dapartemen")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Load Data Karyawan" + e.getMessage());
       }
    }
    
    private void loadDataProyek() {
      modelProyek.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
            modelProyek.addRow(new Object[]{
                rs.getInt("id"),
                rs.getString("nama_proyek"),
                rs.getString("durasi_pengerjaan") + " Minggu"
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Load Data Proyek" + e.getMessage());
       }
    }
    
    private void loadDataTransaksi() {
      modelTransaksi.setRowCount(0);

      try {
          String sql = "SELECT transaksi.id, karyawan.nama, proyek.nama_proyek, transaksi.peran "
             + "FROM transaksi "
             + "JOIN karyawan ON transaksi.id_karyawan = karyawan.id "
             + "JOIN proyek ON transaksi.id_proyek = proyek.id;";
          
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();
          
          while (rs.next()) {
            modelTransaksi.addRow(new Object[]{
                rs.getInt("id"),               
                rs.getString("nama"),          
                rs.getString("nama_proyek"),  
                rs.getString("peran")   
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Load Data Transaksi" + e.getMessage());
       }
    }
    
//    Utils
    private boolean validateTextField(JTextField textField, String errorMessage) {
        if (textField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, errorMessage);
            return false;
        }
        return true;
    }
    
//    Action
    private void saveDataKaryawan() {
      if (!validateTextField(namaKaryawanField, "Nama Karyawan Harus diisi")) {
         return;
      }
      
      if (!validateTextField(jabatanKaryawanField, "Jabatan Karyawan Harus diisi")) {
         return;
      }
      
      if (!validateTextField(departemenKaryawanField, "Dapartemen Karyawan Harus diisi")) {
         return;
      }
        
      try{
         String sql = "INSERT INTO karyawan (nama, jabatan, dapartemen) VALUES (?, ?, ?)";
         PreparedStatement ps = conn.prepareStatement(sql);
         ps.setString(1, namaKaryawanField.getText());
         ps.setString(2, jabatanKaryawanField.getText());
         ps.setString(3, departemenKaryawanField.getText());
         ps.executeUpdate();
         JOptionPane.showMessageDialog(this, "Data Karyawan saved successfully");
         loadDataKaryawan();
         loadDataTransaksi();
         
         namaKaryawanField.setText("");
         jabatanKaryawanField.setText("");
         departemenKaryawanField.setText("");
       } catch (SQLException e) {
         System.out.println("Error Save Data Karyawan" + e.getMessage());
       }
    }
    
    private void updateDataKaryawan() {
      if (!validateTextField(idKaryawanField, "ID Karyawan Harus diisi")) {
         return;
      }
      
      if (!validateTextField(namaKaryawanField, "Nama Karyawan Harus diisi")) {
         return;
      }
      
      if (!validateTextField(jabatanKaryawanField, "Jabatan Karyawan Harus diisi")) {
         return;
      }
      
      if (!validateTextField(departemenKaryawanField, "Dapartemen Karyawan Harus diisi")) {
         return;
      }
        
      try {
          String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, dapartemen = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setString(1, namaKaryawanField.getText());
          ps.setString(2, jabatanKaryawanField.getText());
          ps.setString(3, departemenKaryawanField.getText());
          ps.setInt(4, Integer.parseInt(idKaryawanField.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data Karyawan updated successfully");
          loadDataKaryawan();
          loadDataTransaksi();
          
          
          idKaryawanField.setText("");
          namaKaryawanField.setText("");
          jabatanKaryawanField.setText("");
          departemenKaryawanField.setText("");
      }  catch (SQLException e) {
          System.out.println("Error Update Data Karyawan" + e.getMessage());
      }
    }
    
    private void deleteDataKaryawan() {
      if (!validateTextField(idKaryawanField, "ID Karyawan Harus diisi")) {
         return;
      }   
     
     try  {
          String sql = "DELETE FROM karyawan WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(idKaryawanField.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data karyawan deleted successfully");
          loadDataKaryawan();
          loadDataTransaksi();
          
          idKaryawanField.setText("");
     } catch (SQLException e) {
          System.out.println("Error Deleted Data Karyawan" + e.getMessage());
      }
    }
    
     private void saveDataProyek() {  
      if (!validateTextField(namaProyekField, "Nama Proyek Harus diisi")) {
         return;
      }
      
      if (!validateTextField(durasiProyekField, "Durasi Proyek Harus diisi")) {
         return;
      }
      
      try {
          try{
            String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaProyekField.getText());
            ps.setInt(2, Integer.parseInt(durasiProyekField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Proyek saved successfully");
            loadDataProyek();
            
            namaProyekField.setText("");
            durasiProyekField.setText("");
          } catch (SQLException e) {
            System.out.println("Error Save Data Proyek" + e.getMessage());
          }
      }catch(NumberFormatException ex) {
          JOptionPane.showMessageDialog(this, "Durasi yang anda inputkan bukan angka", "Durasi Proyek", JOptionPane.ERROR_MESSAGE);
      }
    }
     
    private void updateDataProyek() {
      if (!validateTextField(idProyekField, "ID Proyek Harus diisi")) {
         return;
      } 
      if (!validateTextField(namaProyekField, "Nama Proyek Harus diisi")) {
         return;
      }
      if (!validateTextField(durasiProyekField, "Durasi Proyek Harus diisi")) {
         return;
      }
      
      try {
          try {
            String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, namaProyekField.getText());
            ps.setInt(2, Integer.parseInt(durasiProyekField.getText()));
            ps.setInt(3, Integer.parseInt(idProyekField.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data Proyek updated successfully");
            loadDataProyek();
            loadDataTransaksi();
            
            idProyekField.setText("");
            namaProyekField.setText("");
            durasiProyekField.setText("");
        }  catch (SQLException e) {
            System.out.println("Error Update Data Proyek" + e.getMessage());
        }
      }catch (NumberFormatException ex) {
          JOptionPane.showMessageDialog(this, "Durasi yang anda inputkan bukan angka", "Durasi Proyek", JOptionPane.ERROR_MESSAGE);
      }
    }
    
    private void deleteDataProyek() {
        if (!validateTextField(idProyekField, "ID Proyek Harus diisi")) {
            return;
        } 
     
        try  {
             String sql = "DELETE FROM proyek WHERE id = ?";
             PreparedStatement ps = conn.prepareStatement(sql);
             ps.setInt(1, Integer.parseInt(idProyekField.getText()));
             ps.executeUpdate();
             JOptionPane.showMessageDialog(this, "Data proyek deleted successfully");
             loadDataProyek();
             loadDataTransaksi();
             
             idProyekField.setText("");
        } catch (SQLException e) {
             System.out.println("Error Deleted Data Proyek" + e.getMessage());
        }
    }
    
    
    private void setupCmbBoxKaryawan() {
        karyawanBox.removeAllItems();
        try {
            String query = "SELECT id, nama FROM karyawan";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                listIdKaryawan.add(id);  
                karyawanBox.addItem(nama);
            }
            
        } catch (SQLException e) {
            System.out.println("Error Query Combo box Karyawan" + e.getMessage());
        }
    }
    
    private void setupCmbBoxProyek() {
        projectBox.removeAllItems();
        try {
            String query = "SELECT id, nama_proyek FROM proyek";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String namaProyek = rs.getString("nama_proyek");
                listIdProyek.add(id); 
                projectBox.addItem(namaProyek); 
            }
        } catch (SQLException e) {
            System.out.println("Error Query Combo box Proyek" + e.getMessage());
        }
    }
    
    private void saveDataTransaksi() {
        if (!validateTextField(peranTransaksiField, "Peran Transaksi Harus diisi")) {
         return;
        }
         
         
        int idKaryawan = karyawanBox.getSelectedIndex();
        int idProyek = projectBox.getSelectedIndex();

        
        try{
           String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
           PreparedStatement ps = conn.prepareStatement(sql);
           ps.setInt(1, listIdKaryawan.get(idKaryawan));
           ps.setInt(2, listIdProyek.get(idProyek));
           ps.setString(3, peranTransaksiField.getText());
           ps.executeUpdate();
           JOptionPane.showMessageDialog(this, "Data Transaksi saved successfully");
           loadDataTransaksi();
           
         } catch (SQLException e) {
           System.out.println("Error Save Data Transaksi" + e.getMessage());
         }
    }
    
     private void updateDataTransaksi() {
        if (!validateTextField(idTransaksiField, "Id Harus diisi")) {
         return;
        }
         
        int idKaryawan = karyawanBox.getSelectedIndex();
        int idProyek = projectBox.getSelectedIndex();
        
      try {
          String sql = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, listIdKaryawan.get(idKaryawan));
          ps.setInt(2, listIdProyek.get(idProyek));
          ps.setString(3, peranTransaksiField.getText());
          ps.setInt(4, Integer.parseInt(idTransaksiField.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data Transaksi updated successfully");
          loadDataTransaksi();
      }  catch (SQLException e) {
          System.out.println("Error Update Data Transaksi" + e.getMessage());
      }
    }
    
    private void deleteDataTransaksi() {
        if (!validateTextField(idTransaksiField, "Id Harus diisi")) {
         return;
        }
         
     try  {
          String sql = "DELETE FROM transaksi WHERE id = ?";
          PreparedStatement ps = conn.prepareStatement(sql);
          ps.setInt(1, Integer.parseInt(idTransaksiField.getText()));
          ps.executeUpdate();
          JOptionPane.showMessageDialog(this, "Data transaksi deleted successfully");
          loadDataTransaksi();
     } catch (SQLException e) {
          System.out.println("Error Deleted Data Transaksi" + e.getMessage());
      }
    }
    
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
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        tabbedPane = new javax.swing.JTabbedPane();
        karyawanPane = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKaryawan = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        idKaryawanField = new javax.swing.JTextField();
        namaLabel = new javax.swing.JLabel();
        namaKaryawanField = new javax.swing.JTextField();
        jabatanLabel = new javax.swing.JLabel();
        jabatanKaryawanField = new javax.swing.JTextField();
        departemenLabel = new javax.swing.JLabel();
        departemenKaryawanField = new javax.swing.JTextField();
        tambahKaryawan = new javax.swing.JButton();
        ubahKaryawan = new javax.swing.JButton();
        hapusKaryawan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        proyekPane = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbProyek = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        idProyekField = new javax.swing.JTextField();
        namaLabel1 = new javax.swing.JLabel();
        namaProyekField = new javax.swing.JTextField();
        jabatanLabel1 = new javax.swing.JLabel();
        durasiProyekField = new javax.swing.JTextField();
        tambahProyek = new javax.swing.JButton();
        ubahProyek = new javax.swing.JButton();
        hapusProyek = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        transaksiPane = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbTransaksi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        idTransaksiField = new javax.swing.JTextField();
        namaLabel2 = new javax.swing.JLabel();
        jabatanLabel2 = new javax.swing.JLabel();
        departemenLabel1 = new javax.swing.JLabel();
        peranTransaksiField = new javax.swing.JTextField();
        tambahTransaksi = new javax.swing.JButton();
        ubahTransaksi = new javax.swing.JButton();
        hapusTransaksi = new javax.swing.JButton();
        karyawanBox = new javax.swing.JComboBox<>();
        projectBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPane.setBackground(new java.awt.Color(0, 0, 255));
        tabbedPane.setForeground(new java.awt.Color(255, 255, 255));

        karyawanPane.setBackground(new java.awt.Color(255, 255, 255));
        karyawanPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel1.setText("Action");
        karyawanPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, -1, -1));

        tbKaryawan.setBackground(new java.awt.Color(204, 204, 204));
        tbKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nama", "Jabatan", "Departemen"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tbKaryawan);

        karyawanPane.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 350, 270));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Id :");

        idKaryawanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idKaryawanFieldActionPerformed(evt);
            }
        });

        namaLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaLabel.setText("Nama :");

        namaKaryawanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaKaryawanFieldActionPerformed(evt);
            }
        });

        jabatanLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jabatanLabel.setText("Jabatan :");

        jabatanKaryawanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jabatanKaryawanFieldActionPerformed(evt);
            }
        });

        departemenLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        departemenLabel.setText("Departemen :");

        departemenKaryawanField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departemenKaryawanFieldActionPerformed(evt);
            }
        });

        tambahKaryawan.setText("Tambah");
        tambahKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahKaryawanActionPerformed(evt);
            }
        });

        ubahKaryawan.setText("Ubah");
        ubahKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahKaryawanActionPerformed(evt);
            }
        });

        hapusKaryawan.setText("Hapus");
        hapusKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusKaryawanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tambahKaryawan)
                    .addComponent(jabatanLabel)
                    .addComponent(jLabel3)
                    .addComponent(namaLabel)
                    .addComponent(departemenLabel))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ubahKaryawan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusKaryawan))
                    .addComponent(idKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(departemenKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jabatanKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel)
                    .addComponent(namaKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jabatanLabel)
                    .addComponent(jabatanKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departemenLabel)
                    .addComponent(departemenKaryawanField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahKaryawan)
                    .addComponent(ubahKaryawan)
                    .addComponent(hapusKaryawan))
                .addContainerGap())
        );

        karyawanPane.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 350, 210));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel5.setText("Data Karyawan");
        karyawanPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        tabbedPane.addTab("Karyawan", karyawanPane);

        proyekPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel2.setText("Proyek");

        tbProyek.setBackground(new java.awt.Color(204, 204, 204));
        tbProyek.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbProyek);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Id :");

        idProyekField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idProyekFieldActionPerformed(evt);
            }
        });

        namaLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaLabel1.setText("Nama Proyek :");

        namaProyekField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaProyekFieldActionPerformed(evt);
            }
        });

        jabatanLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jabatanLabel1.setText("Durasi :");

        durasiProyekField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                durasiProyekFieldActionPerformed(evt);
            }
        });

        tambahProyek.setText("Tambah");
        tambahProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahProyekActionPerformed(evt);
            }
        });

        ubahProyek.setText("Ubah");
        ubahProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahProyekActionPerformed(evt);
            }
        });

        hapusProyek.setText("Hapus");
        hapusProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusProyekActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tambahProyek)
                    .addComponent(jabatanLabel1)
                    .addComponent(jLabel6)
                    .addComponent(namaLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ubahProyek)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusProyek))
                    .addComponent(idProyekField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaProyekField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(durasiProyekField, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 41, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idProyekField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel1)
                    .addComponent(namaProyekField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jabatanLabel1)
                    .addComponent(durasiProyekField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahProyek)
                    .addComponent(ubahProyek)
                    .addComponent(hapusProyek))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel7.setText("Action");

        javax.swing.GroupLayout proyekPaneLayout = new javax.swing.GroupLayout(proyekPane);
        proyekPane.setLayout(proyekPaneLayout);
        proyekPaneLayout.setHorizontalGroup(
            proyekPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proyekPaneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(proyekPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(27, 27, 27)
                .addGroup(proyekPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        proyekPaneLayout.setVerticalGroup(
            proyekPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(proyekPaneLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(proyekPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(proyekPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Proyek", proyekPane);

        transaksiPane.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel4.setText("Data Transaksi");

        tbTransaksi.setBackground(new java.awt.Color(204, 204, 204));
        tbTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tbTransaksi);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Id :");

        idTransaksiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                idTransaksiFieldActionPerformed(evt);
            }
        });

        namaLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        namaLabel2.setText("Karyawan :");

        jabatanLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jabatanLabel2.setText("Project :");

        departemenLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        departemenLabel1.setText("Peran");

        peranTransaksiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                peranTransaksiFieldActionPerformed(evt);
            }
        });

        tambahTransaksi.setText("Tambah");
        tambahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahTransaksiActionPerformed(evt);
            }
        });

        ubahTransaksi.setText("Ubah");
        ubahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahTransaksiActionPerformed(evt);
            }
        });

        hapusTransaksi.setText("Hapus");
        hapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusTransaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(9, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tambahTransaksi)
                    .addComponent(jabatanLabel2)
                    .addComponent(jLabel8)
                    .addComponent(namaLabel2)
                    .addComponent(departemenLabel1))
                .addGap(26, 26, 26)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(ubahTransaksi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hapusTransaksi))
                    .addComponent(idTransaksiField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(peranTransaksiField, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(karyawanBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(projectBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idTransaksiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaLabel2)
                    .addComponent(karyawanBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jabatanLabel2)
                    .addComponent(projectBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(departemenLabel1)
                    .addComponent(peranTransaksiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambahTransaksi)
                    .addComponent(ubahTransaksi)
                    .addComponent(hapusTransaksi))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        jLabel9.setText("Action");

        javax.swing.GroupLayout transaksiPaneLayout = new javax.swing.GroupLayout(transaksiPane);
        transaksiPane.setLayout(transaksiPaneLayout);
        transaksiPaneLayout.setHorizontalGroup(
            transaksiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPaneLayout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(transaksiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(63, 63, 63)
                .addGroup(transaksiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        transaksiPaneLayout.setVerticalGroup(
            transaksiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(transaksiPaneLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(transaksiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(transaksiPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(77, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Transaksi", transaksiPane);

        jPanel4.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 830, 420));

        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Manajemen Data");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void idKaryawanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idKaryawanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idKaryawanFieldActionPerformed

    private void namaKaryawanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaKaryawanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaKaryawanFieldActionPerformed

    private void jabatanKaryawanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jabatanKaryawanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jabatanKaryawanFieldActionPerformed

    private void departemenKaryawanFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departemenKaryawanFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_departemenKaryawanFieldActionPerformed

    private void tambahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahKaryawanActionPerformed
        // TODO add your handling code here:
        saveDataKaryawan();
        setupCmbBoxKaryawan();
        setupCmbBoxProyek();
    }//GEN-LAST:event_tambahKaryawanActionPerformed

    private void ubahKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahKaryawanActionPerformed
        // TODO add your handling code here:
        updateDataKaryawan();
        setupCmbBoxKaryawan();
        setupCmbBoxProyek();
    }//GEN-LAST:event_ubahKaryawanActionPerformed

    private void hapusKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusKaryawanActionPerformed
        // TODO add your handling code here:
        deleteDataKaryawan();
        setupCmbBoxKaryawan();
        setupCmbBoxProyek();
    }//GEN-LAST:event_hapusKaryawanActionPerformed

    private void idProyekFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idProyekFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idProyekFieldActionPerformed

    private void namaProyekFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaProyekFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaProyekFieldActionPerformed

    private void durasiProyekFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_durasiProyekFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_durasiProyekFieldActionPerformed

    private void tambahProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahProyekActionPerformed
        // TODO add your handling code here:
        saveDataProyek();
        setupCmbBoxKaryawan();
        setupCmbBoxProyek();
    }//GEN-LAST:event_tambahProyekActionPerformed

    private void ubahProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahProyekActionPerformed
        // TODO add your handling code here:
        updateDataProyek();
        setupCmbBoxKaryawan();
        setupCmbBoxProyek();
    }//GEN-LAST:event_ubahProyekActionPerformed

    private void hapusProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusProyekActionPerformed
        // TODO add your handling code here:
        deleteDataProyek();
        setupCmbBoxKaryawan();
        setupCmbBoxProyek();
    }//GEN-LAST:event_hapusProyekActionPerformed

    private void idTransaksiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_idTransaksiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_idTransaksiFieldActionPerformed

    private void peranTransaksiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_peranTransaksiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_peranTransaksiFieldActionPerformed

    private void tambahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahTransaksiActionPerformed
        // TODO add your handling code here:
        saveDataTransaksi();
    }//GEN-LAST:event_tambahTransaksiActionPerformed

    private void ubahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahTransaksiActionPerformed
        // TODO add your handling code here:
        updateDataTransaksi();
    }//GEN-LAST:event_ubahTransaksiActionPerformed

    private void hapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusTransaksiActionPerformed
        // TODO add your handling code here:
        deleteDataTransaksi();
    }//GEN-LAST:event_hapusTransaksiActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField departemenKaryawanField;
    private javax.swing.JLabel departemenLabel;
    private javax.swing.JLabel departemenLabel1;
    private javax.swing.JTextField durasiProyekField;
    private javax.swing.JButton hapusKaryawan;
    private javax.swing.JButton hapusProyek;
    private javax.swing.JButton hapusTransaksi;
    private javax.swing.JTextField idKaryawanField;
    private javax.swing.JTextField idProyekField;
    private javax.swing.JTextField idTransaksiField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTextField jabatanKaryawanField;
    private javax.swing.JLabel jabatanLabel;
    private javax.swing.JLabel jabatanLabel1;
    private javax.swing.JLabel jabatanLabel2;
    private javax.swing.JComboBox<String> karyawanBox;
    private javax.swing.JPanel karyawanPane;
    private javax.swing.JTextField namaKaryawanField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel namaLabel1;
    private javax.swing.JLabel namaLabel2;
    private javax.swing.JTextField namaProyekField;
    private javax.swing.JTextField peranTransaksiField;
    private javax.swing.JComboBox<String> projectBox;
    private javax.swing.JPanel proyekPane;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JButton tambahKaryawan;
    private javax.swing.JButton tambahProyek;
    private javax.swing.JButton tambahTransaksi;
    private javax.swing.JTable tbKaryawan;
    private javax.swing.JTable tbProyek;
    private javax.swing.JTable tbTransaksi;
    private javax.swing.JPanel transaksiPane;
    private javax.swing.JButton ubahKaryawan;
    private javax.swing.JButton ubahProyek;
    private javax.swing.JButton ubahTransaksi;
    // End of variables declaration//GEN-END:variables
}
