/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package manajemen_proyek;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;

/**
 *
 * @author TOSHIBA
 */
public class Manajemen_Proyek extends javax.swing.JFrame {

    public Manajemen_Proyek() {
        initComponents();
        LoadDataKaryawan();
        LoadDataProyek();
        LoadDataTransaksi();
        LoadComboBoxKaryawan();
        LoadComboBoxProyek();
        
    }
    
    private void kosong(){
        IDKaryawan.setText("") ; 
        NamaKaryawan.setText("") ; 
        Jabatan.setText("") ;
        Departemen.setText("") ;
        IDProyek.setText("") ; 
        Proyek.setText("") ; 
        Durasi.setText("") ;
        CbKaryawan.setSelectedIndex(0);
        CbProyek.setSelectedIndex(0);
        Peran.setText("") ;
    }
    
//    Karyawan
    private void LoadDataKaryawan(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("No");
        tableModel.addColumn("ID");
        tableModel.addColumn("Nama");
        tableModel.addColumn("Jabatan");
        tableModel.addColumn("Departemen");
        try{
            int no = 1;
            String sql = "SELECT * FROM karyawan";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            tableModel.addRow(new Object[]{
                no++,
                res.getString("id_karyawan"),
                res.getString("nama"),
                res.getString("jabatan"),
                res.getString("departemen")
            });
        }

        TableKaryawan.setModel(tableModel);

        } catch (SQLException e) {
            System.out.println("Error mengambil data: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage());
        }
    }
    
    private void SimpanDataKaryawan() {
        try {
            if (IDKaryawan.getText().isEmpty() || NamaKaryawan.getText().isEmpty() || 
            Jabatan.getText().isEmpty() || Departemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return; 
            }
            if (!IDKaryawan.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "ID Karyawan harus berupa angka!");
            return; 
            }
            String sql = "INSERT INTO karyawan (id_karyawan, nama, jabatan, departemen) VALUES ('" 
                    + IDKaryawan.getText() + "','" 
                    + NamaKaryawan.getText() + "','" 
                    + Jabatan.getText() + "','" 
                    + Departemen.getText() + "')";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
        
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            LoadDataKaryawan();
            LoadComboBoxKaryawan();
            kosong(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
            e.printStackTrace(); 

        }
    }
    
    private void UbahDataKaryawan() {
        try {
            if (IDKaryawan.getText().isEmpty() || NamaKaryawan.getText().isEmpty() || 
            Jabatan.getText().isEmpty() || Departemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return; 
            }
            if (!IDKaryawan.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "ID Karyawan harus berupa angka!");
                return; 
            }
            String sql = "UPDATE karyawan SET "
                        + "nama = '" + NamaKaryawan.getText() + "', "
                        + "jabatan = '" + Jabatan.getText() + "', "
                        + "departemen = '" + Departemen.getText() + "' "
                        + "WHERE id_karyawan = '" + IDKaryawan.getText() + "'";

            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
        
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            LoadDataKaryawan();
            kosong(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage());
        }
    }
    
    private void HapusDataKaryawan() {
        try {
            String sql = "DELETE FROM karyawan WHERE id_karyawan='" + IDKaryawan.getText() + "'";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
        
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            LoadDataKaryawan(); 
            kosong();
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
        }
    }
    
//    Proyek
    private void LoadDataProyek(){
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("No");
        tableModel.addColumn("ID");
        tableModel.addColumn("Proyek");
        tableModel.addColumn("Durasi");
        try{
            int no = 1;
            String sql = "SELECT * FROM proyek";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

        while (res.next()) {
            tableModel.addRow(new Object[]{
                no++,
                res.getString("id_proyek"),
                res.getString("nama_proyek"),
                res.getString("durasi"),
            });
        }

        TableProyek.setModel(tableModel);

        } catch (SQLException e) {
            System.out.println("Error mengambil data: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal mengambil data: " + e.getMessage());
        }
    }
    
    private void SimpanDataProyek() {
        try {
            if (IDProyek.getText().isEmpty() || Proyek.getText().isEmpty() || Durasi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return; 
            }
    
            if (!IDProyek.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "ID Proyek harus berupa angka!");
                return; 
            }
            if (!Durasi.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "Durasi harus berupa angka!");
                return; 
            }
            String p = Durasi.getText()+ "Minggu";
            String sql = "INSERT INTO proyek (id_proyek, nama_proyek, durasi) VALUES ('" 
                    + IDProyek.getText() + "','" 
                    + Proyek.getText() + "','" 
                    + p + "')";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
        
            JOptionPane.showMessageDialog(null, "Data berhasil disimpan!");
            LoadDataProyek();
            LoadComboBoxProyek();
            kosong(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal menyimpan data: " + e.getMessage());
            

        }
    }
    
    private void UbahDataProyek() {
        try {
            if (IDProyek.getText().isEmpty() || Proyek.getText().isEmpty() || Durasi.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Semua field harus diisi!");
            return; 
            }
            if (!IDProyek.getText().matches("\\d+")) {
                JOptionPane.showMessageDialog(null, "ID Proyek harus berupa angka!");
                return;
            }
           String sql = "UPDATE proyek SET nama_proyek = ?, durasi = ? WHERE id_proyek = ?";

            Connection conn = Koneksi.getkoneksi();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, Proyek.getText());   
            pstmt.setString(2, Durasi.getText());  
            pstmt.setInt(3, Integer.parseInt(IDProyek.getText())); 
            pstmt.executeUpdate();

        
            JOptionPane.showMessageDialog(null, "Data berhasil diubah!");
            LoadDataProyek();
            kosong(); 
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal mengubah data: " + e.getMessage());
        }
    }
    
    private void HapusDataProyek() {
        try {
            String sql = "DELETE FROM proyek WHERE id_proyek='" + IDProyek.getText() + "'";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
        
            JOptionPane.showMessageDialog(null, "Data berhasil dihapus!");
            LoadDataProyek(); 
            kosong();
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Gagal menghapus data: " + e.getMessage());
        }
    }
    
//    Transaksi
    private void LoadDataTransaksi() {
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("No");
        tableModel.addColumn("ID Karyawan");
        tableModel.addColumn("Nama Karyawan");
        tableModel.addColumn("Peran");
        tableModel.addColumn("ID Proyek");
        tableModel.addColumn("Nama Proyek");
        tableModel.addColumn("Durasi");

        try {
            int no = 1;
            String sql = "SELECT t.id_karyawan, t.id_proyek, t.peran, " +
                         "k.nama AS nama_karyawan, p.nama_proyek AS nama_proyek, " +
                         "p.durasi AS durasi " +
                         "FROM transaksi t " +
                         "JOIN karyawan k ON t.id_karyawan = k.id_karyawan " +
                         "JOIN proyek p ON t.id_proyek = p.id_proyek";

            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                tableModel.addRow(new Object[]{
                    no++,  
                    res.getInt("id_karyawan"),  
                    res.getString("nama_karyawan"), 
                    res.getString("peran"),
                    res.getInt("id_proyek"), 
                    res.getString("nama_proyek"), 
                    res.getString("durasi") ,
                     
                });
            }

            TableTransaksi.setModel(tableModel); 

        } catch (SQLException e) {
            System.out.println("Error Load Data Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal memuat data transaksi: " + e.getMessage());
        }
    }

    
    private void LoadComboBoxKaryawan() {
        CbKaryawan.setSelectedIndex(0);
        try {
            String sql = "SELECT id_karyawan, nama, jabatan, departemen FROM karyawan";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                String tampilan = String.format("ID: %s - %s (%s, %s)", 
                    res.getString("id_karyawan"),  
                    res.getString("nama"),        
                    res.getString("jabatan"),     
                    res.getString("departemen")   
                );
                CbKaryawan.addItem(tampilan); 
            }
            if (CbKaryawan.getItemCount() == 0) {
                CbKaryawan.addItem("Tidak ada data tersedia");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan memuat data karyawan: " + e.getMessage());
        }
    }
    
    private void LoadComboBoxProyek() {
        CbProyek.setSelectedIndex(0);
        try {
            String sql = "SELECT id_proyek, nama_proyek, durasi FROM proyek";
            Connection conn = Koneksi.getkoneksi();
            Statement stm = conn.createStatement();
            ResultSet res = stm.executeQuery(sql);

            while (res.next()) {
                String tampilan = String.format("ID: %s - %s (%s)", 
                    res.getString("id_proyek"),  
                    res.getString("nama_proyek"),        
                    res.getString("durasi")        
                );
                CbProyek.addItem(tampilan); 
            }
            if (CbProyek.getItemCount() == 0) {
                CbProyek.addItem("Tidak ada data tersedia");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Kesalahan memuat data karyawan: " + e.getMessage());
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
    
    private void tambahTransaksi() {
        if (CbKaryawan.getSelectedItem() == null || CbKaryawan.getSelectedItem().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih karyawan terlebih dahulu");
            return;
        }
        if (CbProyek.getSelectedItem() == null || CbProyek.getSelectedItem().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih proyek terlebih dahulu");
            return;
        }
        if (Peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan isi peran terlebih dahulu");
            return;
        }

        String sql = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
            try (PreparedStatement ps = Koneksi.getkoneksi().prepareStatement(sql)) {
                int idKaryawan = getSelectedId(CbKaryawan.getSelectedItem().toString());
                int idProyek = getSelectedId(CbProyek.getSelectedItem().toString());

                if (idKaryawan <= 0) {
                    JOptionPane.showMessageDialog(this, "ID Karyawan tidak valid");
                    return;
                }
                if (idProyek <= 0) {
                    JOptionPane.showMessageDialog(this, "ID Proyek tidak valid");
                    return;
                }
                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);
                ps.setString(3, Peran.getText().trim());
                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data Transaksi berhasil ditambahkan");
                    LoadDataTransaksi(); 
                    kosong(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Data Transaksi gagal ditambahkan, coba lagi");
                }
            } catch (SQLException e) {
                System.err.println("Kesalahan Menambah Data Transaksi: " + e.getMessage());
                JOptionPane.showMessageDialog(this, "Gagal menambah data: " + e.getMessage());
            } catch (Exception ex) {
                System.err.println("Kesalahan Tidak Terduga: " + ex.getMessage());
                JOptionPane.showMessageDialog(this, "Kesalahan tidak terduga: " + ex.getMessage());
        }
    }
    
    private void HapusDataTransaksi() {
        int selectedRow = TableTransaksi.getSelectedRow(); 
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data transaksi yang ingin dihapus");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, 
            "Apakah Anda yakin ingin menghapus data transaksi ini?", 
            "Konfirmasi", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            int idKaryawan = Integer.parseInt(TableTransaksi.getValueAt(selectedRow, 1).toString());
            int idProyek = Integer.parseInt(TableTransaksi.getValueAt(selectedRow, 4).toString());

            String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
            try (PreparedStatement ps = Koneksi.getkoneksi().prepareStatement(sql)) {
                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);

                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus!");
                    LoadDataTransaksi(); 
                    kosong(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Data transaksi gagal dihapus");
                }
            }
        } catch (SQLException e) {
            System.err.println("Kesalahan Menghapus Data Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal menghapus data transaksi: " + e.getMessage());
        } catch (Exception ex) {
            System.err.println("Kesalahan Tidak Terduga: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Kesalahan tidak terduga: " + ex.getMessage());
        }
    }
    
    private void UbahDataTransaksi() {
        int selectedRow = TableTransaksi.getSelectedRow(); 
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Pilih data transaksi yang ingin diubah");
            return;
        }

        if (CbKaryawan.getSelectedItem() == null || CbKaryawan.getSelectedItem().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih karyawan terlebih dahulu");
            return;
        }
        if (CbProyek.getSelectedItem() == null || CbProyek.getSelectedItem().toString().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan pilih proyek terlebih dahulu");
            return;
        }
        if (Peran.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Silakan isi peran terlebih dahulu");
            return;
        }

        try {
            int idKaryawanLama = Integer.parseInt(TableTransaksi.getValueAt(selectedRow, 1).toString());
            int idProyekLama = Integer.parseInt(TableTransaksi.getValueAt(selectedRow, 4).toString());

            int idKaryawanBaru = getSelectedId(CbKaryawan.getSelectedItem().toString());
            int idProyekBaru = getSelectedId(CbProyek.getSelectedItem().toString());

            String sql = "UPDATE transaksi SET id_karyawan = ?, id_proyek = ?, peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            try (PreparedStatement pstmt = Koneksi.getkoneksi().prepareStatement(sql)) {
                pstmt.setInt(1, idKaryawanBaru);
                pstmt.setInt(2, idProyekBaru);
                pstmt.setString(3, Peran.getText().trim());
                pstmt.setInt(4, idKaryawanLama);
                pstmt.setInt(5, idProyekLama);

                int result = pstmt.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil diubah!");
                    LoadDataTransaksi(); 
                    kosong(); 
                } else {
                    JOptionPane.showMessageDialog(this, "Data transaksi gagal diubah");
                }
            }
        } catch (SQLException e) {
            System.err.println("Kesalahan Mengubah Data Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(this, "Gagal mengubah data transaksi: " + e.getMessage());
        } catch (Exception ex) {
            System.err.println("Kesalahan Tidak Terduga: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "Kesalahan tidak terduga: " + ex.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        tabbedPaneCustom1 = new raven.tabbed.TabbedPaneCustom();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        IDKaryawan = new javax.swing.JTextField();
        Jabatan = new javax.swing.JTextField();
        NamaKaryawan = new javax.swing.JTextField();
        Departemen = new javax.swing.JTextField();
        BtnEdit = new rojerusan.RSMaterialButtonRectangle();
        BtnDelete = new rojerusan.RSMaterialButtonRectangle();
        BtnSimpan = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableKaryawan = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        IDProyek = new javax.swing.JTextField();
        Durasi = new javax.swing.JTextField();
        Proyek = new javax.swing.JTextField();
        rSMaterialButtonRectangle7 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle8 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle9 = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableProyek = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        Peran = new javax.swing.JTextField();
        rSMaterialButtonRectangle10 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle11 = new rojerusan.RSMaterialButtonRectangle();
        rSMaterialButtonRectangle12 = new rojerusan.RSMaterialButtonRectangle();
        jScrollPane3 = new javax.swing.JScrollPane();
        TableTransaksi = new javax.swing.JTable();
        CbKaryawan = new javax.swing.JComboBox<>();
        CbProyek = new javax.swing.JComboBox<>();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabbedPaneCustom1.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(204, 204, 204));
        tabbedPaneCustom1.setUnselectedColor(new java.awt.Color(0, 102, 102));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel1.setText("Tambah Karyawan");
        jPanel3.add(jLabel1);
        jLabel1.setBounds(147, 8, 254, 31);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Jabatan");
        jPanel3.add(jLabel2);
        jLabel2.setBounds(27, 140, 60, 25);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Departemen");
        jPanel3.add(jLabel3);
        jLabel3.setBounds(27, 183, 98, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Nama");
        jPanel3.add(jLabel4);
        jLabel4.setBounds(27, 97, 47, 25);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("ID Karyawan");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(27, 54, 98, 25);

        IDKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(IDKaryawan);
        IDKaryawan.setBounds(158, 51, 367, 31);

        Jabatan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(Jabatan);
        Jabatan.setBounds(158, 137, 367, 31);

        NamaKaryawan.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(NamaKaryawan);
        NamaKaryawan.setBounds(158, 94, 367, 31);

        Departemen.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel3.add(Departemen);
        Departemen.setBounds(158, 180, 367, 31);

        BtnEdit.setBackground(new java.awt.Color(0, 0, 0));
        BtnEdit.setText("edit");
        BtnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEditActionPerformed(evt);
            }
        });
        jPanel3.add(BtnEdit);
        BtnEdit.setBounds(234, 220, 108, 40);

        BtnDelete.setBackground(new java.awt.Color(0, 0, 0));
        BtnDelete.setText("delete");
        BtnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeleteActionPerformed(evt);
            }
        });
        jPanel3.add(BtnDelete);
        BtnDelete.setBounds(417, 220, 108, 40);

        BtnSimpan.setBackground(new java.awt.Color(0, 0, 0));
        BtnSimpan.setText("simpan");
        BtnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnSimpanActionPerformed(evt);
            }
        });
        jPanel3.add(BtnSimpan);
        BtnSimpan.setBounds(27, 220, 108, 40);

        TableKaryawan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "No", "ID", "Nama", "Jabatan", "Departemen"
            }
        ));
        TableKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableKaryawan);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(27, 266, 498, 220);

        tabbedPaneCustom1.addTab("Karyawan", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel8.setText("Tambah Proyek");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Durasi");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Proyek");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("ID");

        IDProyek.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Durasi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        Proyek.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        rSMaterialButtonRectangle7.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle7.setText("edit");
        rSMaterialButtonRectangle7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle7ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle8.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle8.setText("delete");
        rSMaterialButtonRectangle8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle8ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle9.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle9.setText("simpan");
        rSMaterialButtonRectangle9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle9ActionPerformed(evt);
            }
        });

        TableProyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "No", "ID", "Proyek", "Durasi"
            }
        ));
        TableProyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableProyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableProyek);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(rSMaterialButtonRectangle9, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 428, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel13)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Proyek, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(Durasi)
                            .addComponent(IDProyek, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(29, 29, 29))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(128, 128, 128)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IDProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Proyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Durasi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSMaterialButtonRectangle9, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSMaterialButtonRectangle7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(rSMaterialButtonRectangle8, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.add(jPanel8);

        tabbedPaneCustom1.addTab("Proyek", jPanel4);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel12.setFont(new java.awt.Font("Showcard Gothic", 1, 24)); // NOI18N
        jLabel12.setText("Transaksi");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Peran");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel16.setText("ID Proyek");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel17.setText("ID Karyawan");

        Peran.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        rSMaterialButtonRectangle10.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle10.setText("edit");
        rSMaterialButtonRectangle10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle10ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle11.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle11.setText("delete");
        rSMaterialButtonRectangle11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle11ActionPerformed(evt);
            }
        });

        rSMaterialButtonRectangle12.setBackground(new java.awt.Color(0, 0, 0));
        rSMaterialButtonRectangle12.setText("simpan");
        rSMaterialButtonRectangle12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonRectangle12ActionPerformed(evt);
            }
        });

        TableTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        TableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(TableTransaksi);

        CbKaryawan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Karyawan --" }));
        CbKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CbKaryawanActionPerformed(evt);
            }
        });

        CbProyek.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Proyek --" }));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(rSMaterialButtonRectangle12, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                        .addComponent(rSMaterialButtonRectangle10, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(79, 79, 79)
                        .addComponent(rSMaterialButtonRectangle11, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Peran)
                            .addComponent(CbKaryawan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CbProyek, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(29, 29, 29))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(198, 198, 198)
                .addComponent(jLabel12)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(CbKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel16)
                    .addComponent(CbProyek, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Peran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rSMaterialButtonRectangle12, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rSMaterialButtonRectangle11, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rSMaterialButtonRectangle10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel9);

        tabbedPaneCustom1.addTab("Transaksi", jPanel5);

        jPanel1.add(tabbedPaneCustom1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 105, -1, -1));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Forte", 1, 36)); // NOI18N
        jLabel6.setText("Management Proyek");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(161, 161, 161))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel6)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 677, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BtnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEditActionPerformed
        // TODO add your handling code here:
        UbahDataKaryawan();
    }//GEN-LAST:event_BtnEditActionPerformed

    private void BtnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeleteActionPerformed
        // TODO add your handling code here:
        HapusDataKaryawan();
    }//GEN-LAST:event_BtnDeleteActionPerformed

    private void BtnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnSimpanActionPerformed
        // TODO add your handling code here:
        SimpanDataKaryawan();
    }//GEN-LAST:event_BtnSimpanActionPerformed

    private void rSMaterialButtonRectangle7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle7ActionPerformed
        // TODO add your handling code here:
        UbahDataProyek();
    }//GEN-LAST:event_rSMaterialButtonRectangle7ActionPerformed

    private void rSMaterialButtonRectangle8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle8ActionPerformed
        // TODO add your handling code here:
        HapusDataProyek();
    }//GEN-LAST:event_rSMaterialButtonRectangle8ActionPerformed

    private void rSMaterialButtonRectangle9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle9ActionPerformed
        // TODO add your handling code here:
        SimpanDataProyek();
    }//GEN-LAST:event_rSMaterialButtonRectangle9ActionPerformed

    private void rSMaterialButtonRectangle10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle10ActionPerformed
        // TODO add your handling code here:
       UbahDataTransaksi();
    }//GEN-LAST:event_rSMaterialButtonRectangle10ActionPerformed

    private void rSMaterialButtonRectangle11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle11ActionPerformed
        // TODO add your handling code here:\
         HapusDataTransaksi();
    }//GEN-LAST:event_rSMaterialButtonRectangle11ActionPerformed

    private void rSMaterialButtonRectangle12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonRectangle12ActionPerformed
        // TODO add your handling code here:
        tambahTransaksi();
    }//GEN-LAST:event_rSMaterialButtonRectangle12ActionPerformed

    private void TableKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableKaryawanMouseClicked
        // TODO add your handling code here:
        TableKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = TableKaryawan.getSelectedRow();
            IDKaryawan.setText(TableKaryawan.getValueAt(row, 1).toString());
            NamaKaryawan.setText(TableKaryawan.getValueAt(row, 2).toString());
            Jabatan.setText(TableKaryawan.getValueAt(row, 3).toString());
            Departemen.setText(TableKaryawan.getValueAt(row, 4).toString());
            }
        });
    }//GEN-LAST:event_TableKaryawanMouseClicked

    private void TableProyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableProyekMouseClicked
        // TODO add your handling code here:
        TableProyek.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = TableProyek.getSelectedRow();
            IDProyek.setText(TableProyek.getValueAt(row, 1).toString());
            Proyek.setText(TableProyek.getValueAt(row, 2).toString());
            Durasi.setText(TableProyek.getValueAt(row, 3).toString());
            
            }
        });
    }//GEN-LAST:event_TableProyekMouseClicked

    private void TableTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableTransaksiMouseClicked
        // TODO add your handling code here:
        TableTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            int row = TableTransaksi.getSelectedRow(); 
            if (row != -1) { 
                IDKaryawan.setText(TableTransaksi.getValueAt(row, 1).toString());
                NamaKaryawan.setText(TableTransaksi.getValueAt(row, 2).toString());
                Peran.setText(TableTransaksi.getValueAt(row, 3).toString());
                IDProyek.setText(TableTransaksi.getValueAt(row, 4).toString());
                Proyek.setText(TableTransaksi.getValueAt(row, 5).toString());
                Durasi.setText(TableTransaksi.getValueAt(row, 6).toString());
            }
        }
    });

    }//GEN-LAST:event_TableTransaksiMouseClicked

    private void CbKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CbKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CbKaryawanActionPerformed

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
            java.util.logging.Logger.getLogger(Manajemen_Proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Manajemen_Proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Manajemen_Proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Manajemen_Proyek.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Manajemen_Proyek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonRectangle BtnDelete;
    private rojerusan.RSMaterialButtonRectangle BtnEdit;
    private rojerusan.RSMaterialButtonRectangle BtnSimpan;
    private javax.swing.JComboBox<String> CbKaryawan;
    private javax.swing.JComboBox<String> CbProyek;
    private javax.swing.JTextField Departemen;
    private javax.swing.JTextField Durasi;
    private javax.swing.JTextField IDKaryawan;
    private javax.swing.JTextField IDProyek;
    private javax.swing.JTextField Jabatan;
    private javax.swing.JTextField NamaKaryawan;
    private javax.swing.JTextField Peran;
    private javax.swing.JTextField Proyek;
    private javax.swing.JTable TableKaryawan;
    private javax.swing.JTable TableProyek;
    private javax.swing.JTable TableTransaksi;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle10;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle11;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle12;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle7;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle8;
    private rojerusan.RSMaterialButtonRectangle rSMaterialButtonRectangle9;
    private raven.tabbed.TabbedPaneCustom tabbedPaneCustom1;
    // End of variables declaration//GEN-END:variables
}
