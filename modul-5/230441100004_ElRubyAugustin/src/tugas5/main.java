/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package tugas5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author NAOFUMI
 */
public class main extends javax.swing.JFrame {

    /**
     * Creates new form main
     */
    //inisiasi GLobal Variable
    Connection conn;
    private  DefaultTableModel model;
    private  DefaultTableModel model2;
    private  DefaultTableModel model3;
    
    public main() {
    initComponents();
    conn = koneksi.getConnection();
    
    // Initialize model and set up jTable1 for karyawan
    model = new DefaultTableModel();
    jTable1.setModel(model);
    model.addColumn("ID KARYAWAN");
    model.addColumn("NAMA");
    model.addColumn("JABATAN");
    model.addColumn("DEPARTEMEN");
    loadDatakaryawan();
    
    // Add mouse listener for jTable1
    jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable1MouseClicked(evt);
        }
    });

    // Initialize model and set up jTable2 for proyek
    model2 = new DefaultTableModel();
    jTable2.setModel(model2);
    model2.addColumn("ID PROYEK");
    model2.addColumn("NAMA PROYEK");
    model2.addColumn("DURASI PENGERJAAN");
    loadDataproyek();
    
    // Add mouse listener for jTable2
    jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable2MouseClicked(evt);
        }
    });

    // Initialize model and set up jTable3 for transaksi
    model3 = new DefaultTableModel();
    jTable4.setModel(model3);
    model3.addColumn("NAMA KARYAWAN");
    model3.addColumn("NAMA PROYEK");
    model3.addColumn("PERAN");
    loadDatatransaksi();
    
    // Add mouse listener for jTable3
    jTable4.addMouseListener(new java.awt.event.MouseAdapter() {
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            jTable3MouseClicked(evt);
        }
    });
}

// Event handler for jTable1 mouse click
private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = jTable1.getSelectedRow();
    tf_id.setText(model.getValueAt(selectedRow, 0).toString());
    tf_nama.setText(model.getValueAt(selectedRow, 1).toString());
    tf_jabatan.setText(model.getValueAt(selectedRow, 2).toString());
    tf_departemen.setText(model.getValueAt(selectedRow, 3).toString());
}

// Event handler for jTable2 mouse click
private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = jTable2.getSelectedRow();
    td_id.setText(model2.getValueAt(selectedRow, 0).toString());
    tf_namaProyek.setText(model2.getValueAt(selectedRow, 1).toString());
    tf_durasiProyek.setText(model2.getValueAt(selectedRow, 2).toString());
}

// Event handler for jTable3 mouse click
private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {
    int selectedRow = jTable4.getSelectedRow();
    JComboBox1.setSelectedItem(model3.getValueAt(selectedRow, 0).toString());
    JComboBox2.setSelectedItem(model3.getValueAt(selectedRow, 1).toString());
    tf_peran.setText(model3.getValueAt(selectedRow, 2).toString());
}

    private void loadDatakaryawan() {
      model.setRowCount(0);

      try {
          String sql = "SELECT * FROM karyawan";
           PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
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
      model2.setRowCount(0);

      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);//menyiapkan query
          ResultSet rs = ps.executeQuery();
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model2.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getInt("durasi_pengerjaan")
           });
          }
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
    }

    private void loadDatatransaksi() {
    model3.setRowCount(0);

    String proyek = "SELECT id, Nama_Proyek FROM proyek";
    String karyawan = "SELECT id, Nama FROM karyawan";
    JComboBox1.removeAllItems();
    JComboBox2.removeAllItems();

    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("Nama_Proyek");
            JComboBox2.addItem(namaProyek);
        }
    } catch (SQLException e) {
        System.out.println("Error Loading Data (Proyek): " + e.getMessage());
    }

    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("Nama");
            JComboBox1.addItem(namaKaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error Loading Data (Karyawan): " + e.getMessage());
    }

    String sql = "SELECT t.id_karyawan, k.Nama, t.id_proyek, p.Nama_Proyek, t.peran " +
                 "FROM transaksi t " +
                 "JOIN karyawan k ON t.id_karyawan = k.id " +
                 "JOIN proyek p ON t.id_proyek = p.id";

    try (PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            model3.addRow(new Object[]{
                rs.getString("Nama"),          
                rs.getString("Nama_Proyek"),   
                rs.getString("peran")          
            });
        }
    } catch (SQLException e) {
        System.out.println("Error Loading Data (Transaksi): " + e.getMessage());
    }
}

private void saveDatakaryawan() {
    try {
        // Cek apakah ID karyawan sudah ada
        String checkSql = "SELECT COUNT(*) FROM karyawan WHERE id = ?";
        PreparedStatement checkPs = conn.prepareStatement(checkSql);
        checkPs.setInt(1, Integer.parseInt(tf_id.getText()));
        ResultSet checkRs = checkPs.executeQuery();
        checkRs.next();
        
        if (checkRs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "ID karyawan sudah ada. Silakan gunakan ID yang berbeda.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simpan data jika ID belum ada
        String sql = "INSERT INTO karyawan (id, nama, jabatan, departemen) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id.getText()));
        ps.setString(2, tf_nama.getText());
        ps.setString(3, tf_jabatan.getText());
        ps.setString(4, tf_departemen.getText());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        loadDatakaryawan();

        // Clear JTextField after saving
        tf_id.setText("");
        tf_nama.setText("");
        tf_jabatan.setText("");
        tf_departemen.setText("");

    } catch (SQLException e) {
        System.out.println("Error Save Data: " + e.getMessage());
    }
}

    private void saveDatatransaksi() {
    try {
        String selectedKaryawan = JComboBox1.getSelectedItem().toString();
        String selectedProyek = JComboBox2.getSelectedItem().toString();
        String peran = tf_peran.getText();

        int karyawanId = getKaryawanId(selectedKaryawan);
        int proyekId = getProyekId(selectedProyek);

        // Cek apakah transaksi dengan kombinasi karyawan dan proyek sudah ada
        String checkSql = "SELECT COUNT(*) FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement checkPs = conn.prepareStatement(checkSql);
        checkPs.setInt(1, karyawanId);
        checkPs.setInt(2, proyekId);
        ResultSet checkRs = checkPs.executeQuery();
        checkRs.next();
        
        if (checkRs.getInt(1) > 0) {
            JOptionPane.showMessageDialog(this, "Data transaksi untuk karyawan dan proyek ini sudah ada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Simpan data transaksi jika kombinasi karyawan dan proyek belum ada
        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, karyawanId);
        ps.setInt(2, proyekId);
        ps.setString(3, peran);
        ps.executeUpdate();

        JOptionPane.showMessageDialog(this, "Data transaksi saved successfully");
        loadDatatransaksi();

        // Clear JTextField after saving
        JComboBox1.setSelectedIndex(-1);
        JComboBox2.setSelectedIndex(-1);
        tf_peran.setText("");

    } catch (SQLException e) {
        System.out.println("Error Save Data Transaksi: " + e.getMessage());
    }
}

private void saveDataproyek() {
    try {
        String sql = "INSERT INTO proyek (id, nama_proyek, durasi_pengerjaan) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(td_id.getText()));
        ps.setString(2, tf_namaProyek.getText());
        ps.setInt(3, Integer.parseInt(tf_durasiProyek.getText()));
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data saved successfully");
        
        // Perbarui tabel proyek dan combobox transaksi
        loadDataproyek();
        loadDatatransaksi();  // Panggil ini untuk memperbarui JComboBox di tab transaksi

        // Clear JTextField after saving
        td_id.setText("");
        tf_namaProyek.setText("");
        tf_durasiProyek.setText("");

    } catch (SQLException e) {
        System.out.println("Error saving proyek data: " + e.getMessage());
    }
}
    
    
private void updateDatakaryawan() {
    try {
        String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);   
        ps.setString(1, tf_nama.getText());
        ps.setString(2, tf_jabatan.getText());
        ps.setString(3, tf_departemen.getText());
        ps.setInt(4, Integer.parseInt(tf_id.getText()));
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data updated successfully");
        loadDatakaryawan();

        // Clear JTextFields after updating
        tf_id.setText("");
        tf_nama.setText("");
        tf_jabatan.setText("");
        tf_departemen.setText("");

    } catch (SQLException e) {
        System.out.println("Error Update Data: " + e.getMessage());
    }
}
 
private void updateDataproyek() {
    try {
        String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, tf_namaProyek.getText());
        ps.setInt(2, Integer.parseInt(tf_durasiProyek.getText())); 
        ps.setInt(3, Integer.parseInt(td_id.getText())); 
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data updated successfully");
        loadDataproyek();

        // Clear JTextFields after updating
        td_id.setText("");
        tf_namaProyek.setText("");
        tf_durasiProyek.setText("");

    } catch (SQLException e) {
        System.out.println("Error Update Data: " + e.getMessage());
    }
}
  
    private void updateDatatransaksi() {
    try {
        String karyawanBaru = JComboBox1.getSelectedItem().toString();
        String proyekBaru = JComboBox2.getSelectedItem().toString();
        String peranBaru = tf_peran.getText();
        
        int karyawanIdBaru = getKaryawanId(karyawanBaru);
        int proyekIdBaru = getProyekId(proyekBaru);
        
        String sql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, peranBaru);         
        ps.setInt(2, karyawanIdBaru);       
        ps.setInt(3, proyekIdBaru);         
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(this, "Data updated successfully");     
        loadDatatransaksi(); 
        
        // Clear JTextFields after updating
        JComboBox1.setSelectedIndex(-1);
        JComboBox2.setSelectedIndex(-1);
        tf_peran.setText("");
    } catch (SQLException e) {
        System.out.println("Error Update Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error saat memperbarui data transaksi.");
    }
}
    
    //Delete Data
    private void deleteDatakaryawan() {
    try {
        String sql = "DELETE FROM karyawan WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(tf_id.getText()));
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data deleted successfully");
        // Clear JTextFields after updating
        tf_id.setText("");
        tf_nama.setText("");
        tf_jabatan.setText("");
        tf_departemen.setText("");
        
        // Perbarui tabel karyawan dan combobox transaksi
        loadDatakaryawan();
        loadDatatransaksi();  // Panggil ini untuk memperbarui JComboBox di tab transaksi
    } catch (SQLException e) {
        System.out.println("Error deleting karyawan data: " + e.getMessage());
    }
}

private void deleteDataproyek() {
    try {
        String sql = "DELETE FROM proyek WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, Integer.parseInt(td_id.getText()));
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data deleted successfully");
        // Clear JTextField after saving
        td_id.setText("");
        tf_namaProyek.setText("");
        tf_durasiProyek.setText("");

        
        // Perbarui tabel proyek dan combobox transaksi
        loadDataproyek();
        loadDatatransaksi();  // Panggil ini untuk memperbarui JComboBox di tab transaksi
    } catch (SQLException e) {
        System.out.println("Error deleting proyek data: " + e.getMessage());
    }
}

     
    private void deleteDatatransaksi() {
    try {
        String selectedKaryawan = JComboBox1.getSelectedItem().toString();
        String selectedProyek = JComboBox2.getSelectedItem().toString();
        
        int karyawanId = getKaryawanId(selectedKaryawan);
        int proyekId = getProyekId(selectedProyek);
        
            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, karyawanId);
            ps.setInt(2, proyekId);
            ps.executeUpdate();
            
            JOptionPane.showMessageDialog(this, "Data transaksi deleted successfully");
            loadDatatransaksi();
            // Clear JTextFields after updating
        JComboBox1.setSelectedIndex(-1);
        JComboBox2.setSelectedIndex(-1);
        tf_peran.setText("");

    } catch (SQLException e) {
        System.out.println("Error Delete Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error deleting transaksi data");
    }
}

    // Ambil ID Karyawan nama
    private int getKaryawanId(String namaKaryawan) throws SQLException {
        return getIdFromName("karyawan", "nama", namaKaryawan);
    }

    // Ambil ID Proyek nama
    private int getProyekId(String namaProyek) throws SQLException {
        return getIdFromName("proyek", "nama_proyek", namaProyek);
    }

    // Metode umum untuk ID dari nama
    private int getIdFromName(String tableName, String columnName, String name) throws SQLException {
        String sql = "SELECT id FROM " + tableName + " WHERE " + columnName + " = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt("id");
                } else {
                    throw new SQLException("ID not found for name: " + name);
                }
            }
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tf_id = new javax.swing.JTextField();
        tf_nama = new javax.swing.JTextField();
        tf_jabatan = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        tf_departemen = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton12 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        td_id = new javax.swing.JTextField();
        tf_namaProyek = new javax.swing.JTextField();
        tf_durasiProyek = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JComboBox1 = new javax.swing.JComboBox<>();
        JComboBox2 = new javax.swing.JComboBox<>();
        tf_peran = new javax.swing.JTextField();
        jPanel15 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable4 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 204, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText(" Karyawan");
        jPanel7.add(jLabel1, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 60));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setText("id");

        jLabel5.setText("Nama");

        jLabel6.setText("Jabatan");

        jLabel7.setText("Departemen");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tf_id, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                    .addComponent(tf_nama)
                    .addComponent(tf_jabatan)
                    .addComponent(tf_departemen))
                .addContainerGap(175, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tf_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tf_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_jabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_departemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 460, 140));

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setLayout(null);

        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton1);
        jButton1.setBounds(80, 0, 73, 23);

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton2);
        jButton2.setBounds(160, 0, 72, 23);

        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton3);
        jButton3.setBounds(240, 0, 72, 23);

        jButton12.setText("Reset");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton12);
        jButton12.setBounds(320, 0, 72, 23);

        jPanel1.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 460, 30));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nama", "Jabatan", "Departemen"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 260, 460, 220));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Karyawan", jPanel4);

        jPanel2.setBackground(new java.awt.Color(204, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 204, 255));
        jPanel8.setLayout(new java.awt.BorderLayout());

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText(" Proyek");
        jPanel8.add(jLabel2, java.awt.BorderLayout.CENTER);

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 60));

        jPanel12.setBackground(new java.awt.Color(204, 255, 204));

        jLabel8.setText("id");

        jLabel9.setText("Nama proyek");

        jLabel10.setText("Durasi proyek");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(td_id, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                    .addComponent(tf_namaProyek)
                    .addComponent(tf_durasiProyek))
                .addContainerGap(160, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(td_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_namaProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tf_durasiProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 450, 120));

        jPanel14.setBackground(new java.awt.Color(204, 255, 204));
        jPanel14.setLayout(null);

        jButton4.setText("Tambah");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton4);
        jButton4.setBounds(66, 18, 73, 23);

        jButton5.setText("Edit");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton5);
        jButton5.setBounds(149, 18, 72, 23);

        jButton6.setText("Hapus");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton6);
        jButton6.setBounds(230, 20, 72, 20);

        jButton11.setText("Reset");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton11);
        jButton11.setBounds(310, 20, 81, 20);

        jPanel2.add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 450, 60));

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NamaProyek", "DurasiProyek"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 270, 450, 210));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab(" Proyek", jPanel5);

        jPanel3.setBackground(new java.awt.Color(204, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel9.setBackground(new java.awt.Color(255, 204, 255));
        jPanel9.setLayout(new java.awt.BorderLayout());

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB", 0, 24)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText(" Transaksi");
        jPanel9.add(jLabel3, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 60));

        jPanel13.setBackground(new java.awt.Color(204, 204, 255));

        jLabel11.setText("Karyawan");

        jLabel12.setText("Proyek");

        jLabel13.setText("Peran");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(JComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel13Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(JComboBox2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(218, 218, 218))
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(JComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(JComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(tf_peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, 450, 100));

        jPanel15.setBackground(new java.awt.Color(204, 204, 255));
        jPanel15.setLayout(new java.awt.GridBagLayout());

        jButton7.setText("Tambah");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 80, 17, 0);
        jPanel15.add(jButton7, gridBagConstraints);

        jButton8.setText("Edit");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 17, 17, 0);
        jPanel15.add(jButton8, gridBagConstraints);

        jButton9.setText("Hapus");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 18, 17, 118);
        jPanel15.add(jButton9, gridBagConstraints);

        jPanel3.add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 450, 50));

        jTable4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Nama Karyawan", "Nama Proyek", "Peran"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable4);

        jPanel3.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, -1, 220));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab(" Transaksi", jPanel6);

        jDesktopPane1.setLayer(jTabbedPane2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDesktopPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane2)
                .addGap(20, 20, 20))
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        saveDatakaryawan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        updateDatakaryawan();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        deleteDatakaryawan();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        saveDataproyek();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
       updateDataproyek();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        deleteDataproyek();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        saveDatatransaksi();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        updateDatatransaksi();
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        deleteDatatransaksi() ;
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        tf_id.setText("");
        tf_nama.setText("");
        tf_jabatan.setText("");
        tf_departemen.setText("");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        tf_id.setText("");
        tf_nama.setText("");
        tf_durasiProyek.setText("");
    }//GEN-LAST:event_jButton11ActionPerformed
//
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> JComboBox1;
    private javax.swing.JComboBox<String> JComboBox2;
    private javax.swing.JButton jButton1;
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
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
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
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable4;
    private javax.swing.JTextField td_id;
    private javax.swing.JTextField tf_departemen;
    private javax.swing.JTextField tf_durasiProyek;
    private javax.swing.JTextField tf_id;
    private javax.swing.JTextField tf_jabatan;
    private javax.swing.JTextField tf_nama;
    private javax.swing.JTextField tf_namaProyek;
    private javax.swing.JTextField tf_peran;
    // End of variables declaration//GEN-END:variables
}
