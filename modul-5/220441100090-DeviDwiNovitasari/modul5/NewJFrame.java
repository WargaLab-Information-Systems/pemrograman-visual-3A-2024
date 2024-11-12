/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul5;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author HP
 */
public class NewJFrame extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel modelKaryawan;
    private DefaultTableModel modelProyek;
    private DefaultTableModel modelTransaksi;

    // Konstruktor
    public NewJFrame() {
        initComponents();
        namaKaryawan.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });

        jabatan.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });

        departemen.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkButtons(); }
        public void removeUpdate(DocumentEvent e) { checkButtons(); }
        public void changedUpdate(DocumentEvent e) { checkButtons(); }
    });
        
        // Menambahkan DocumentListener setelah inisialisasi komponen
        idKaryawan.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkField(); checkHapusButton(); }
        public void removeUpdate(DocumentEvent e) { checkField(); checkHapusButton(); }
        public void changedUpdate(DocumentEvent e) { checkField(); checkHapusButton(); }
    });
        
        idProyek.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checktambahproyek(); checkHapusproyek(); }
        public void removeUpdate(DocumentEvent e) { checktambahproyek(); checkHapusproyek(); }
        public void changedUpdate(DocumentEvent e) { checktambahproyek(); checkHapusproyek(); }
    });
        
        namaProyek.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkproyek(); }
        public void removeUpdate(DocumentEvent e) { checkproyek(); }
        public void changedUpdate(DocumentEvent e) { checkproyek(); }
    });
        
        durasiProyek.getDocument().addDocumentListener(new DocumentListener() {
        public void insertUpdate(DocumentEvent e) { checkproyek(); }
        public void removeUpdate(DocumentEvent e) { checkproyek(); }
        public void changedUpdate(DocumentEvent e) { checkproyek(); }
    });

        
        // Inisialisasi koneksi ke database
        conn = koneksi.getConnection();
        
        // Inisialisasi model untuk tabel karyawan
        modelKaryawan = new DefaultTableModel();
        modelKaryawan.addColumn("ID");
        modelKaryawan.addColumn("Nama");
        modelKaryawan.addColumn("Jabatan");
        modelKaryawan.addColumn("Departemen");
        jTable1.setModel(modelKaryawan);

        // Inisialisasi model untuk tabel proyek
        modelProyek = new DefaultTableModel();
        modelProyek.addColumn("ID");
        modelProyek.addColumn("Nama Proyek");
        modelProyek.addColumn("Durasi");
        jTable2.setModel(modelProyek);

        // Inisialisasi model untuk tabel transaksi
        modelTransaksi = new DefaultTableModel();
        modelTransaksi.addColumn("id Karyawan");
        modelTransaksi.addColumn("Karyawan");
        modelTransaksi.addColumn("id Proyek");
        modelTransaksi.addColumn("Nama Proyek");
        modelTransaksi.addColumn("Peran");
        jTable3.setModel(modelTransaksi);

        // Muat data ke tabel masing-masing
        loadDataKaryawan();
        loadDataProyek();
        loadDataTransaksi();
        loadKaryawanComboBox();
        loadProyekComboBox();
}
    
private void loadDataKaryawan(){
    modelKaryawan.setRowCount(0);

    try{
        String sql = "SELECT * FROM karyawan";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
           modelKaryawan.addRow(new Object[]{
                rs.getInt("Id"),
                rs.getString("Nama"),
                rs.getString("Jabatan"),
                rs.getString("Departemen")
            });
//            model.addRow(row);
        }
    } catch (SQLException e) {
        System.out.println("Error" + e.getMessage());
    }
}

private void tambahKaryawan() {
    try{
        String sql = "INSERT INTO karyawan (Nama, Jabatan, Departemen) VALUES (?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, namaKaryawan.getText());
        stmt.setString(2, jabatan.getText());
        stmt.setString(3, departemen.getText());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data karyawan berhasil ditambahkan.");
        loadDataKaryawan(); // Memuat ulang data karyawan
    } catch (SQLException e) {
        System.out.println("Error" + e.getMessage());
    }
}
    
private void editKaryawan() {
        try{
            String sql = "UPDATE karyawan SET Nama = ?, Jabatan = ?, Departemen = ? WHERE Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, namaKaryawan.getText());
            stmt.setString(2, jabatan.getText());
            stmt.setString(3, departemen.getText());
            stmt.setInt(4, Integer.parseInt(idKaryawan.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil diubah.");
            loadDataKaryawan();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
}
    
private void hapusKaryawan() {
        try {
            String sql = "DELETE FROM karyawan WHERE Id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(idKaryawan.getText()));
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(this, "Data karyawan berhasil dihapus.");
            loadDataKaryawan();
        } catch (SQLException e) {
            System.out.println("Error" + e.getMessage());
        }
}

private void checkButtons() {
    int filledFields = 0;
    if (!namaKaryawan.getText().trim().isEmpty()) filledFields++;
    if (!jabatan.getText().trim().isEmpty()) filledFields++;
    if (!departemen.getText().trim().isEmpty()) filledFields++;
    edit1.setEnabled(filledFields >= 2); // Aktifkan jika minimal 2 terisi
}

private void checkHapusButton() {
    hapus1.setEnabled(!idKaryawan.getText().trim().isEmpty()); // Aktifkan jika ID terisi
}

private void checkField() {
    tambah1.setEnabled(idKaryawan.getText().trim().isEmpty()); // Enable jika kosong
}


private void loadDataProyek(){
    modelProyek.setRowCount(0);

    try{
        String sql = "SELECT * FROM proyek";
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
           modelProyek.addRow(new Object[]{
                rs.getInt("Id"),
                rs.getString("Nama_proyek"),
                rs.getString("Durasi")
            });
//            model.addRow(row);
        }
    } catch (SQLException e) {
        System.out.println("Error" + e.getMessage());
    }
}

private void tambahProyek(){
    try{
        String sql = "INSERT INTO proyek (Nama_proyek, Durasi) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, namaProyek.getText());
        stmt.setString(2, durasiProyek.getText());
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil ditambahkan.");
        loadDataProyek();
    }catch(SQLException e){
        System.out.println("Error" + e.getMessage());
    }
}

private void editProyek(){
    try{
        String sql = "UPDATE proyek SET Nama_proyek = ?, Durasi = ? WHERE Id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, namaProyek.getText());
        stmt.setString(2, durasiProyek.getText());
        stmt.setInt(3, Integer.parseInt(idProyek.getText()));
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil dirubah.");
        loadDataProyek();
    }catch(SQLException e){
        System.out.println("Error" + e.getMessage());
    }
}

private void hapusProyek(){
    try{
        String sql = "DELETE from proyek WHERE Id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, Integer.parseInt(idProyek.getText()));
        stmt.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus.");
        loadDataProyek();
    }catch(SQLException e){
        System.out.println("Error" + e.getMessage());
    }
}

private void checkproyek() {
    int filled = 0;
    if (!idProyek.getText().trim().isEmpty()) filled++;
    if (!namaProyek.getText().trim().isEmpty()) filled++;
    if (!durasiProyek.getText().trim().isEmpty()) filled++;
    edit2.setEnabled(filled >= 2); // Aktifkan jika minimal 2 terisi
}

private void checkHapusproyek() {
    hapus2.setEnabled(!idProyek.getText().trim().isEmpty()); // Aktifkan jika ID terisi
}

private void checktambahproyek() {
    tambah2.setEnabled(idProyek.getText().trim().isEmpty()); // Enable jika kosong
}

private void loadKaryawanComboBox(){
    try{
        String query = "SELECT Id, Nama FROM karyawan";
        PreparedStatement ps = conn.prepareStatement(query);
//        Result rs = st.excecuteQuery(query);
        ResultSet rs = ps.executeQuery();
       
        while(rs.next()){
            String tampilan = String.format("%d - %s", 
                rs.getInt("Id"),
                rs.getString("Nama"));
            cbKaryawan.addItem(tampilan);
            }
    }catch(SQLException e){
        System.out.println("Error k" + e.getMessage());
    }
}

private void loadProyekComboBox(){
    try{
        String query = "SELECT Id, Nama_proyek FROM proyek";
        PreparedStatement ps = conn.prepareStatement(query);
//        Result rs = st.excecuteQuery(query);
        ResultSet rs = ps.executeQuery();
       
        while(rs.next()){
            String tampilan = String.format("%d - %s", 
                rs.getInt("Id"),
                rs.getString("Nama_proyek"));
            cbProyek.addItem(tampilan);
    }
    }catch(SQLException e){
        System.out.println("Error p" + e.getMessage());
    }
}

   private int getSelectedId(String comboBoxText) {
    if (comboBoxText == null || comboBoxText.isEmpty()) return -1;
    try {
        // Format combo box: "1 - Nama"
        return Integer.parseInt(comboBoxText.split(" - ")[0]);
    } catch (Exception e) {
        System.out.println("Error parsing ID: " + e.getMessage());
        return -1;
    }
}

private void loadDataTransaksi() {
    modelTransaksi.setRowCount(0);
    try {
        String sql = "SELECT k.Nama as nama_karyawan, p.Nama_proyek, " +
                     "t.peran, t.Id_karyawan, t.Id_proyek " +
                     "FROM transaksi t " +
                     "JOIN karyawan k ON t.Id_karyawan = k.Id " +
                     "JOIN proyek p ON t.Id_proyek = p.Id " +
                     "ORDER BY k.Nama, p.Nama_proyek";
        
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            modelTransaksi.addRow(new Object[]{
                rs.getInt("Id_karyawan"),
                rs.getString("nama_karyawan"),
                rs.getInt("Id_proyek"),
                rs.getString("Nama_proyek"),
                rs.getString("peran")
            });
        }
    } catch (SQLException e) {
        System.out.println("Error Load Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Gagal memuat data transaksi: " + e.getMessage());
    }
}
    private void clearTransaksiFields() {
    durasi.setText("");
    cbKaryawan.setSelectedIndex(0);
    cbProyek.setSelectedIndex(0);
}
    
private void tambahTransaksi() {
    try {
        if (cbKaryawan.getSelectedItem() == null || cbProyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(null, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }
        
        String selectedKaryawan = cbKaryawan.getSelectedItem().toString();
        String selectedProyek = cbProyek.getSelectedItem().toString();
        
        int idkaryawan = getSelectedId(selectedKaryawan);
        int idproyek = getSelectedId(selectedProyek);
        
        if (idkaryawan == -1 || idproyek == -1) {
            JOptionPane.showMessageDialog(null, "ID Karyawan atau ID Proyek tidak valid");
            return;
        }
        // Menghapus pengecekan apakah kombinasi sudah ada
        // Jika belum ada, tambahkan data baru
        String sql ="INSERT INTO transaksi (Id_karyawan, Id_proyek, peran) VALUES (?, ?, ?)";
 
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, idkaryawan);
        ps.setInt(2, idproyek);
        ps.setString(3, durasi.getText().trim());
        
        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Data Transaksi berhasil ditambahkan");
        loadDataTransaksi();
        clearTransaksiFields();
        
    } catch (SQLException e) {
        System.out.println("Error Tambah Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(null, "Gagal menambah data: " + e.getMessage());
    }
}
    
private void editTransaksi() {
    try {
        String sql = "UPDATE transaksi SET peran = ? WHERE Id_karyawan = ? AND Id_proyek = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        
        int idkaryawan = getSelectedId(cbKaryawan.getSelectedItem().toString());
        int idproyek = getSelectedId(cbProyek.getSelectedItem().toString());
        
        ps.setString(1, durasi.getText());
        ps.setInt(2, idkaryawan);
        ps.setInt(3, idproyek);
        ps.executeUpdate();
        JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
        loadDataTransaksi();
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }
}

private void hapusTransaksi() {
    try {
        // Memastikan pengguna sudah memilih karyawan dan proyek dari ComboBox
        if (cbKaryawan.getSelectedItem() == null || cbProyek.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "Pilih karyawan dan proyek terlebih dahulu");
            return;
        }

        // Mendapatkan ID karyawan dan proyek dari ComboBox
        int idkaryawan = getSelectedId(cbKaryawan.getSelectedItem().toString());
        int idproyek = getSelectedId(cbProyek.getSelectedItem().toString());

        int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus data transaksi ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            String sql = "DELETE FROM transaksi WHERE Id_karyawan = ? AND Id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idkaryawan);
            ps.setInt(2, idproyek);

            int result = ps.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "Data Transaksi berhasil dihapus");
                loadDataTransaksi();
                clearTransaksiFields();  // Membersihkan field setelah menghapus data
            } else {
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau sudah terhapus");
            }
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
    }
}

    /**
     * Creates new form NewJFrame
     */
//    public NewJFrame() {
//        initComponents();
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        tabbedPaneCustom1 = new modul5.TabbedPaneCustom();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jabatan = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        departemen = new javax.swing.JTextField();
        namaKaryawan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        idKaryawan = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel9 = new javax.swing.JPanel();
        tambah1 = new javax.swing.JButton();
        edit1 = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        durasiProyek = new javax.swing.JTextField();
        namaProyek = new javax.swing.JTextField();
        idProyek = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel12 = new javax.swing.JPanel();
        tambah2 = new javax.swing.JButton();
        edit2 = new javax.swing.JButton();
        hapus2 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        durasi = new javax.swing.JTextField();
        cbKaryawan = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cbProyek = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        tambah3 = new javax.swing.JButton();
        edit3 = new javax.swing.JButton();
        hapus3 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(51, 255, 0));

        jPanel2.setBackground(new java.awt.Color(51, 255, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 204, 0));
        jPanel7.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 15, 18);
        jPanel7.add(jabatan, gridBagConstraints);

        jLabel4.setText("Jabatan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        jPanel7.add(jLabel4, gridBagConstraints);

        jLabel3.setText("Departemen :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        jPanel7.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 18);
        jPanel7.add(departemen, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 18);
        jPanel7.add(namaKaryawan, gridBagConstraints);

        jLabel2.setText("Nama :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 6, 0, 0);
        jPanel7.add(jLabel2, gridBagConstraints);

        jLabel1.setText("ID :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(23, 6, 0, 0);
        jPanel7.add(jLabel1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 113;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 18);
        jPanel7.add(idKaryawan, gridBagConstraints);

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 15, -1, -1));

        jPanel8.setBackground(new java.awt.Color(255, 0, 102));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel8.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 752, 256));

        jPanel2.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 162, -1, -1));

        jPanel9.setBackground(new java.awt.Color(0, 102, 255));
        jPanel9.setLayout(new java.awt.GridLayout());

        tambah1.setText("Tambah");
        tambah1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah1ActionPerformed(evt);
            }
        });
        jPanel9.add(tambah1);

        edit1.setText("Edit");
        edit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit1ActionPerformed(evt);
            }
        });
        jPanel9.add(edit1);

        hapus1.setText("Hapus");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        jPanel9.add(hapus1);

        jPanel2.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 436, 764, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 795, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tabbedPaneCustom1.addTab("Karyawan", jPanel1);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(102, 255, 0));

        jPanel10.setBackground(new java.awt.Color(255, 255, 0));
        jPanel10.setLayout(new java.awt.GridBagLayout());

        jLabel5.setText("ID :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 6, 0, 0);
        jPanel10.add(jLabel5, gridBagConstraints);

        jLabel6.setText("Nama Proyek :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel10.add(jLabel6, gridBagConstraints);

        jLabel7.setText("Durasi Pengerjaan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 6, 0, 0);
        jPanel10.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 23, 6);
        jPanel10.add(durasiProyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(12, 6, 0, 6);
        jPanel10.add(namaProyek, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 121;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(17, 6, 0, 6);
        jPanel10.add(idProyek, gridBagConstraints);

        jPanel11.setBackground(new java.awt.Color(255, 102, 102));
        jPanel11.setLayout(new java.awt.GridLayout());

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        jPanel11.add(jScrollPane2);

        jPanel12.setBackground(new java.awt.Color(0, 204, 255));

        tambah2.setText("Tambah");
        tambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah2ActionPerformed(evt);
            }
        });

        edit2.setText("Edit");
        edit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit2ActionPerformed(evt);
            }
        });

        hapus2.setText("Hapus");
        hapus2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(tambah2)
                .addGap(109, 109, 109)
                .addComponent(edit2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(hapus2)
                .addGap(17, 17, 17))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tambah2)
                    .addComponent(edit2)
                    .addComponent(hapus2))
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        tabbedPaneCustom1.addTab("Proyek", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(51, 255, 0));

        jPanel13.setBackground(new java.awt.Color(255, 204, 102));
        jPanel13.setLayout(new java.awt.GridBagLayout());

        jLabel8.setText("Durasi :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(9, 6, 0, 0);
        jPanel13.add(jLabel8, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 131;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 36, 0);
        jPanel13.add(durasi, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 116;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 63, 36, 0);
        jPanel13.add(cbKaryawan, gridBagConstraints);

        jLabel9.setText("Karyawan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 63, 0, 0);
        jPanel13.add(jLabel9, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 122;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 12, 36, 65);
        jPanel13.add(cbProyek, gridBagConstraints);

        jLabel10.setText("Proyek :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 57;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 12, 0, 0);
        jPanel13.add(jLabel10, gridBagConstraints);

        jPanel14.setBackground(new java.awt.Color(153, 255, 204));
        jPanel14.setLayout(new java.awt.GridLayout());

        tambah3.setText("Tambah");
        tambah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambah3ActionPerformed(evt);
            }
        });
        jPanel14.add(tambah3);

        edit3.setText("Edit");
        edit3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                edit3ActionPerformed(evt);
            }
        });
        jPanel14.add(edit3);

        hapus3.setText("Hapus");
        hapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus3ActionPerformed(evt);
            }
        });
        jPanel14.add(hapus3);

        jPanel15.setBackground(new java.awt.Color(255, 153, 153));

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable3);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 540));

        tabbedPaneCustom1.addTab("Transaksi Proyek", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 791, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tambah1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah1ActionPerformed
        // TODO add your handling code here:
        tambahKaryawan();
    }//GEN-LAST:event_tambah1ActionPerformed

    private void edit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit1ActionPerformed
        // TODO add your handling code here:
        editKaryawan();
    }//GEN-LAST:event_edit1ActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        // TODO add your handling code here:
        hapusKaryawan();
    }//GEN-LAST:event_hapus1ActionPerformed

    private void tambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah2ActionPerformed
        // TODO add your handling code here:
        tambahProyek();
    }//GEN-LAST:event_tambah2ActionPerformed

    private void edit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit2ActionPerformed
        // TODO add your handling code here:
        editProyek();
    }//GEN-LAST:event_edit2ActionPerformed

    private void hapus2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus2ActionPerformed
        // TODO add your handling code here:
        hapusProyek();
    }//GEN-LAST:event_hapus2ActionPerformed

    private void tambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambah3ActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_tambah3ActionPerformed

    private void edit3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_edit3ActionPerformed
        // TODO add your handling code here:
        editTransaksi();
    }//GEN-LAST:event_edit3ActionPerformed

    private void hapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus3ActionPerformed
        // TODO add your handling code here:
        hapusTransaksi();
    }//GEN-LAST:event_hapus3ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int row = jTable1.getSelectedRow(); 
        
        if (row != -1) {
            idKaryawan.setText(jTable1.getValueAt(row, 0).toString());
            namaKaryawan.setText(jTable1.getValueAt(row, 1).toString()); 
            jabatan.setText(jTable1.getValueAt(row, 2).toString());
            departemen.setText(jTable1.getValueAt(row, 3).toString());
            
        }
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked
        // TODO add your handling code here:
                int row = jTable2.getSelectedRow(); 
        
        if (row != -1) {
            idProyek.setText(jTable2.getValueAt(row, 0).toString());
            namaProyek.setText(jTable2.getValueAt(row, 1).toString()); 
            durasiProyek.setText(jTable2.getValueAt(row, 2).toString());
            
        }
    }//GEN-LAST:event_jTable2MouseClicked

    private void jTable3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable3MouseClicked
//        int row = jTable3.getSelectedRow(); // Mendapatkan baris yang dipilih
//    
//    if (row != -1) {
//        String karyawan = jTable3.getValueAt(row, 1).toString().split(" - ")[1];
//        String proyek = jTable3.getValueAt(row, 3).toString().split(" - ")[1];
//        durasi.setText(jTable3.getValueAt(row, 4).toString()); // Kolom 4 untuk Durasi
//        cbKaryawan.setSelectedItem(karyawan);
//        cbProyek.setSelectedItem(proyek);
//
//    }
        // Mengambil nilai dari tabel berdasarkan kolom untuk Karyawan dan Proyek
//        String karyawan = jTable3.getValueAt(row, 1).toString(); // Kolom 1 untuk Karyawan
//        String proyek = jTable3.getValueAt(row, 3).toString(); // Kolom 3 untuk Nama Proyek
//        durasi.setText(jTable3.getValueAt(row, 4).toString()); // Kolom 4 untuk Durasi
//        
//        // Periksa dan set item pada ComboBox Karyawan
//        if (isItemExistInComboBox(cbKaryawan, karyawan)) {
//            cbKaryawan.setSelectedItem(karyawan);
//        } else {
//            cbKaryawan.addItem(karyawan);
//            cbKaryawan.setSelectedItem(karyawan);
//        }
//
//        // Periksa dan set item pada ComboBox Proyek
//        if (isItemExistInComboBox(cbProyek, proyek)) {
//            cbProyek.setSelectedItem(proyek);
//        } else {
//            cbProyek.addItem(proyek);
//            cbProyek.setSelectedItem(proyek);
//        }
//    }
//    
//
//}
//
//// Fungsi untuk memeriksa apakah item sudah ada di ComboBox
//private boolean isItemExistInComboBox(JComboBox<String> comboBox, String item) {
//    for (int i = 0; i < comboBox.getItemCount(); i++) {
//        if (comboBox.getItemAt(i).equals(item)) {
//            return true;
//        }
//    }
//    return false;
    }//GEN-LAST:event_jTable3MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbKaryawan;
    private javax.swing.JComboBox<String> cbProyek;
    private javax.swing.JTextField departemen;
    private javax.swing.JTextField durasi;
    private javax.swing.JTextField durasiProyek;
    private javax.swing.JButton edit1;
    private javax.swing.JButton edit2;
    private javax.swing.JButton edit3;
    private javax.swing.JButton hapus1;
    private javax.swing.JButton hapus2;
    private javax.swing.JButton hapus3;
    private javax.swing.JTextField idKaryawan;
    private javax.swing.JTextField idProyek;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextField jabatan;
    private javax.swing.JTextField namaKaryawan;
    private javax.swing.JTextField namaProyek;
    private modul5.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JButton tambah1;
    private javax.swing.JButton tambah2;
    private javax.swing.JButton tambah3;
    // End of variables declaration//GEN-END:variables
}
