package karyawanprojek;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import moduldatabase.koneksi;


public class Karyawan extends javax.swing.JFrame {

    
    public Karyawan() {
        initComponents();
        load_karyawan();
        load_projek();
        load_transaksi();
        loadComboBoxKaryawan(); // Memuat data ke combo box karyawan
        loadComboBoxProyek();   // Memuat data ke combo box proyek
        
            // Menambahkan MouseListener ke txtIdKaryawan
    txtIdKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            generateIdKaryawan(); // Panggil metode untuk mengisi ID Karyawan saat diklik
            txtIdKaryawan.setEditable(true); // Aktifkan pengeditan saat diklik
            JOptionPane.showMessageDialog(null, "Pengeditan ID Karyawan diaktifkan.");
            // Listener ini hanya akan dipanggil sekali per klik
        }
    });

    // Menambahkan MouseListener ke txtIdProyek
    txtIdProyek.addMouseListener(new java.awt.event.MouseAdapter() {
        @Override
        public void mouseClicked(java.awt.event.MouseEvent evt) {
            generateIdProyek(); // Panggil metode untuk mengisi ID Proyek saat diklik
            txtIdProyek.setEditable(true); // Aktifkan pengeditan saat diklik
            JOptionPane.showMessageDialog(null, "Pengeditan ID Proyek diaktifkan.");
            // Listener ini hanya akan dipanggil sekali per klik
        }
    });
    }


   
    @SuppressWarnings("unchecked")
//    load data karyawan
    private void load_karyawan() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Karyawan");
        model.addColumn("Nama");
        model.addColumn("Jabatan");
        model.addColumn("Departemen");

        try {
            String sql = "SELECT id, nama, jabatan, departemen FROM karyawan";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                // Masukkan data sesuai urutan kolom di database
                model.addRow(new Object[]{
                    res.getString("id"),        // ID karyawan
                    res.getString("nama"),      // Nama karyawan
                    res.getString("jabatan"),   // Jabatan karyawan
                    res.getString("departemen") // Departemen karyawan
                });
            }
            tblKaryawan.setModel(model); // Set model setelah loop selesai
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

        }
    private void kosong() {
        // Karyawan
        txtIdKaryawan.setText("");
        txtNamaKaryawan.setText("");
        txtJabatan.setText("");
        txtDepartemen.setText("");

        // Proyek
        txtIdProyek.setText("");
        txtNamaProyek.setText("");
        txtDurasiPengerjaan.setText("");

        // Transaksi
        txtPeran.setText("");

        // Set combobox ke pilihan pertama (indeks 0)
        cbIdKaryawan.setSelectedIndex(0);
        cbIdProyek.setSelectedIndex(0);

        // Mengatur text field ID Karyawan agar bisa diedit jika diperlukan
        txtIdKaryawan.setEditable(true);
        txtIdProyek.setEditable(true);
        cbIdKaryawan.setEditable(true);
        cbIdProyek.setEditable(true);
    }



    private void load_projek() {        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Proyek");
        model.addColumn("Nama Proyek");
        model.addColumn("Durasi Pengerjaan(mingguan)");

        try {
            String sql = "SELECT id, nama_proyek, durasi_pengerjaan FROM proyek";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                // Tambahkan keterangan "minggu" pada kolom durasi pengerjaan
                String durasi = res.getString("durasi_pengerjaan") + " minggu";

                // Masukkan data sesuai urutan kolom di database
                model.addRow(new Object[]{
                    res.getString("id"),                // ID proyek
                    res.getString("nama_proyek"),       // Nama proyek
                    durasi                              // Durasi pengerjaan dengan tambahan "minggu"
                });
            }
            tblProyek.setModel(model); // Set model setelah loop selesai
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void load_transaksi() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID Karyawan");
        model.addColumn("ID Proyek");
        model.addColumn("Peran");


        try {
            String sql = "SELECT id_karyawan, id_proyek, peran FROM transaksi";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                // Masukkan data sesuai urutan kolom di database
                model.addRow(new Object[]{
                    res.getString("id_karyawan"),        // ID karyawan
                    res.getString("id_proyek"),      // id projek karyawan
                    res.getString("peran")   // peran karyawan
                 
                });
            }
            tblTransaksi.setModel(model); // Set model setelah loop selesai
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    
    private void loadComboBoxKaryawan() {
        try {
            String sql = "SELECT id FROM karyawan";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            cbIdKaryawan.removeAllItems(); // Kosongkan combo box terlebih dahulu
            while (res.next()) {
                cbIdKaryawan.addItem(res.getString("id")); // Tambahkan ID karyawan ke combo box
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void loadComboBoxProyek() {
        try {
            String sql = "SELECT id FROM proyek";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            cbIdProyek.removeAllItems(); // Kosongkan combo box terlebih dahulu
            while (res.next()) {
                cbIdProyek.addItem(res.getString("id")); // Tambahkan ID proyek ke combo box
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelJudul = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panelKaryawan = new javax.swing.JPanel();
        lblID = new javax.swing.JLabel();
        lblNama = new javax.swing.JLabel();
        lblJabatan = new javax.swing.JLabel();
        lblDepartermen = new javax.swing.JLabel();
        txtIdKaryawan = new javax.swing.JTextField();
        txtNamaKaryawan = new javax.swing.JTextField();
        txtJabatan = new javax.swing.JTextField();
        txtDepartemen = new javax.swing.JTextField();
        paneltabelKaryawan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKaryawan = new javax.swing.JTable();
        btnSimpan = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnKeluar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblProyek = new javax.swing.JPanel();
        lblIdProyek = new javax.swing.JLabel();
        lblNamaProyek = new javax.swing.JLabel();
        lblDurasi = new javax.swing.JLabel();
        txtIdProyek = new javax.swing.JTextField();
        txtNamaProyek = new javax.swing.JTextField();
        txtDurasiPengerjaan = new javax.swing.JTextField();
        lblTabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProyek = new javax.swing.JTable();
        btnSimpanProyek = new javax.swing.JButton();
        btnUpdateProyek = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnUlang = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        lblidkaryawan = new javax.swing.JLabel();
        lblidproyek = new javax.swing.JLabel();
        lblPeran = new javax.swing.JLabel();
        cbIdKaryawan = new javax.swing.JComboBox<>();
        cbIdProyek = new javax.swing.JComboBox<>();
        txtPeran = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnSimpanTransaksi = new javax.swing.JButton();
        btnRiset = new javax.swing.JButton();
        btnUbahTransaksi = new javax.swing.JButton();
        btnhapusTransaksi = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jTabbedPane1.setBackground(new java.awt.Color(153, 153, 255));
        jTabbedPane1.setFont(new java.awt.Font("Rockwell Extra Bold", 1, 12)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 0, 102));

        jPanel3.setBackground(new java.awt.Color(0, 0, 102));

        panelJudul.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Regime", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 0, 0));
        jLabel1.setText("~~~~ FORM KARYAWAN ~~~~");

        javax.swing.GroupLayout panelJudulLayout = new javax.swing.GroupLayout(panelJudul);
        panelJudul.setLayout(panelJudulLayout);
        panelJudulLayout.setHorizontalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1))
        );
        panelJudulLayout.setVerticalGroup(
            panelJudulLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelJudulLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panelKaryawan.setBackground(new java.awt.Color(255, 153, 255));

        lblID.setFont(new java.awt.Font("Regime", 1, 12)); // NOI18N
        lblID.setForeground(new java.awt.Color(0, 0, 51));
        lblID.setText("ID Karyawan : ");

        lblNama.setFont(new java.awt.Font("Regime", 1, 12)); // NOI18N
        lblNama.setForeground(new java.awt.Color(0, 0, 51));
        lblNama.setText("Nama Karyawan : ");

        lblJabatan.setFont(new java.awt.Font("Regime", 1, 12)); // NOI18N
        lblJabatan.setForeground(new java.awt.Color(0, 0, 51));
        lblJabatan.setText("Jabatan : ");

        lblDepartermen.setFont(new java.awt.Font("Regime", 1, 12)); // NOI18N
        lblDepartermen.setForeground(new java.awt.Color(0, 0, 51));
        lblDepartermen.setText("Departemen : ");

        txtIdKaryawan.setBackground(new java.awt.Color(255, 153, 102));
        txtIdKaryawan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtIdKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdKaryawanMouseClicked(evt);
            }
        });
        txtIdKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdKaryawanActionPerformed(evt);
            }
        });

        txtNamaKaryawan.setBackground(new java.awt.Color(255, 153, 102));
        txtNamaKaryawan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtNamaKaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaKaryawanActionPerformed(evt);
            }
        });

        txtJabatan.setBackground(new java.awt.Color(255, 153, 102));
        txtJabatan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N

        txtDepartemen.setBackground(new java.awt.Color(255, 153, 102));
        txtDepartemen.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        txtDepartemen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDepartemenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelKaryawanLayout = new javax.swing.GroupLayout(panelKaryawan);
        panelKaryawan.setLayout(panelKaryawanLayout);
        panelKaryawanLayout.setHorizontalGroup(
            panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKaryawanLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNama)
                    .addComponent(lblID)
                    .addComponent(lblJabatan)
                    .addComponent(lblDepartermen))
                .addGap(18, 18, 18)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtIdKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 24, Short.MAX_VALUE))
        );
        panelKaryawanLayout.setVerticalGroup(
            panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelKaryawanLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txtIdKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNama)
                    .addComponent(txtNamaKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtJabatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblJabatan))
                .addGap(29, 29, 29)
                .addGroup(panelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDepartermen)
                    .addComponent(txtDepartemen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        paneltabelKaryawan.setBackground(new java.awt.Color(255, 204, 255));

        jLabel2.setBackground(new java.awt.Color(255, 255, 204));
        jLabel2.setFont(new java.awt.Font("Regime", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("~~~~ FORM TABEL KARYAWAN ~~~~");

        javax.swing.GroupLayout paneltabelKaryawanLayout = new javax.swing.GroupLayout(paneltabelKaryawan);
        paneltabelKaryawan.setLayout(paneltabelKaryawanLayout);
        paneltabelKaryawanLayout.setHorizontalGroup(
            paneltabelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(paneltabelKaryawanLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        paneltabelKaryawanLayout.setVerticalGroup(
            paneltabelKaryawanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, paneltabelKaryawanLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );

        tblKaryawan.setBackground(new java.awt.Color(255, 255, 204));
        tblKaryawan.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tblKaryawan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblKaryawan.setModel(new javax.swing.table.DefaultTableModel(
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
        tblKaryawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKaryawanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKaryawan);

        btnSimpan.setBackground(new java.awt.Color(255, 204, 153));
        btnSimpan.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnSimpan.setText("Tambah");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnHapus.setBackground(new java.awt.Color(255, 204, 153));
        btnHapus.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnHapus.setText("Delete");
        btnHapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnHapusMouseClicked(evt);
            }
        });
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnReset.setBackground(new java.awt.Color(255, 204, 153));
        btnReset.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnUpdate.setBackground(new java.awt.Color(255, 204, 153));
        btnUpdate.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnKeluar.setBackground(new java.awt.Color(255, 204, 153));
        btnKeluar.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnKeluar.setText("Exit");
        btnKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKeluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(paneltabelKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSimpan)
                        .addGap(90, 90, 90)
                        .addComponent(btnHapus))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(29, 29, 29)
                            .addComponent(panelKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addGap(112, 112, 112)
                            .addComponent(btnUpdate)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset))))
                .addGap(44, 44, 44)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKeluar)
                .addGap(27, 27, 27))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(panelJudul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(paneltabelKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(panelKaryawan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpan)
                            .addComponent(btnHapus))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnUpdate)
                            .addComponent(btnReset)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(btnKeluar)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Form Karyawan", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 204, 255));

        jLabel3.setFont(new java.awt.Font("Regime", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 0, 0));
        jLabel3.setText("~~~~ FORM PROYEK ~~~~");

        lblProyek.setBackground(new java.awt.Color(255, 204, 153));
        lblProyek.setLayout(new java.awt.GridBagLayout());

        lblIdProyek.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        lblIdProyek.setText("ID Proyek : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 31, 0, 0);
        lblProyek.add(lblIdProyek, gridBagConstraints);

        lblNamaProyek.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        lblNamaProyek.setText("Nama Proyek : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 31, 0, 0);
        lblProyek.add(lblNamaProyek, gridBagConstraints);

        lblDurasi.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        lblDurasi.setText("Durasi Pengerjaan : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 31, 0, 0);
        lblProyek.add(lblDurasi, gridBagConstraints);

        txtIdProyek.setBackground(new java.awt.Color(255, 153, 102));
        txtIdProyek.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        txtIdProyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtIdProyekMouseClicked(evt);
            }
        });
        txtIdProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdProyekActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(19, 17, 0, 39);
        lblProyek.add(txtIdProyek, gridBagConstraints);

        txtNamaProyek.setBackground(new java.awt.Color(255, 153, 102));
        txtNamaProyek.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 110;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(31, 17, 0, 39);
        lblProyek.add(txtNamaProyek, gridBagConstraints);

        txtDurasiPengerjaan.setBackground(new java.awt.Color(255, 153, 102));
        txtDurasiPengerjaan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 109;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 18, 37, 39);
        lblProyek.add(txtDurasiPengerjaan, gridBagConstraints);

        lblTabel.setFont(new java.awt.Font("Regime", 1, 18)); // NOI18N
        lblTabel.setForeground(new java.awt.Color(102, 0, 0));
        lblTabel.setText("~~~~ TABEL PROYEK ~~~~");

        tblProyek.setBackground(new java.awt.Color(255, 153, 255));
        tblProyek.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblProyek.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProyekMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProyek);

        btnSimpanProyek.setBackground(new java.awt.Color(255, 102, 102));
        btnSimpanProyek.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnSimpanProyek.setText("Tambah");
        btnSimpanProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanProyekActionPerformed(evt);
            }
        });

        btnUpdateProyek.setBackground(new java.awt.Color(255, 102, 102));
        btnUpdateProyek.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnUpdateProyek.setText("Update");
        btnUpdateProyek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateProyekActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 102, 102));
        btnDelete.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnUlang.setBackground(new java.awt.Color(255, 102, 102));
        btnUlang.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnUlang.setText("Reset");
        btnUlang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUlangActionPerformed(evt);
            }
        });

        btnExit.setBackground(new java.awt.Color(255, 102, 102));
        btnExit.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(jLabel3)
                        .addGap(272, 272, 272)
                        .addComponent(lblTabel))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnUlang)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(btnSimpanProyek)
                                        .addGap(80, 80, 80)
                                        .addComponent(btnUpdateProyek)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnDelete)))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 419, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnExit)
                .addGap(88, 88, 88))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTabel))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblProyek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpanProyek)
                            .addComponent(btnUpdateProyek)
                            .addComponent(btnDelete)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(22, 22, 22)
                .addComponent(btnUlang)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExit)
                .addContainerGap(87, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("From Proyek", jPanel4);

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));

        jLabel5.setFont(new java.awt.Font("Regime", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 0, 0));
        jLabel5.setText("~~~~ TABEL TRANSAKSI ~~~~");

        jPanel6.setBackground(new java.awt.Color(239, 217, 165));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        lblidkaryawan.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        lblidkaryawan.setText("ID Karyawan : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 20, 0, 0);
        jPanel6.add(lblidkaryawan, gridBagConstraints);

        lblidproyek.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        lblidproyek.setText("ID Proyek : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 20, 0, 0);
        jPanel6.add(lblidproyek, gridBagConstraints);

        lblPeran.setFont(new java.awt.Font("Segoe Script", 0, 12)); // NOI18N
        lblPeran.setText("Peran : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 20, 0, 0);
        jPanel6.add(lblPeran, gridBagConstraints);

        cbIdKaryawan.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 18, 0, 80);
        jPanel6.add(cbIdKaryawan, gridBagConstraints);

        cbIdProyek.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 94;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(29, 18, 0, 80);
        jPanel6.add(cbIdProyek, gridBagConstraints);

        txtPeran.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 102;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(30, 18, 62, 80);
        jPanel6.add(txtPeran, gridBagConstraints);

        tblTransaksi.setBackground(new java.awt.Color(255, 204, 204));
        tblTransaksi.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
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
        tblTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTransaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblTransaksi);

        btnSimpanTransaksi.setBackground(new java.awt.Color(255, 102, 102));
        btnSimpanTransaksi.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnSimpanTransaksi.setText("Tambah");
        btnSimpanTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanTransaksiActionPerformed(evt);
            }
        });

        btnRiset.setBackground(new java.awt.Color(255, 102, 102));
        btnRiset.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnRiset.setText("Riset");
        btnRiset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRisetActionPerformed(evt);
            }
        });

        btnUbahTransaksi.setBackground(new java.awt.Color(255, 102, 102));
        btnUbahTransaksi.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnUbahTransaksi.setText("Update");
        btnUbahTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUbahTransaksiActionPerformed(evt);
            }
        });

        btnhapusTransaksi.setBackground(new java.awt.Color(255, 102, 102));
        btnhapusTransaksi.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnhapusTransaksi.setText("Delete");
        btnhapusTransaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhapusTransaksiMouseClicked(evt);
            }
        });
        btnhapusTransaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhapusTransaksiActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 102, 102));
        btnBack.setFont(new java.awt.Font("Rockwell", 1, 12)); // NOI18N
        btnBack.setText("Exit");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jPanel7.setBackground(new java.awt.Color(255, 204, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel4.setFont(new java.awt.Font("Regime", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 0, 0));
        jLabel4.setText("~~~~ FORM TRANSAKSI ~~~~");
        jPanel7.add(jLabel4, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(37, 37, 37)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addComponent(btnSimpanTransaksi)
                                        .addGap(96, 96, 96)
                                        .addComponent(btnRiset))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(btnUbahTransaksi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnhapusTransaksi)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 393, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(126, 126, 126)
                                .addComponent(jLabel5)))
                        .addGap(0, 30, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSimpanTransaksi)
                            .addComponent(btnRiset)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnUbahTransaksi)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnhapusTransaksi)
                        .addGap(24, 24, 24)))
                .addComponent(btnBack)
                .addGap(23, 23, 23))
        );

        jTabbedPane1.addTab("Form Transaksi", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void txtDepartemenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDepartemenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDepartemenActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        // TODO add your handling code here:
        // Validasi input kosong
        if (txtIdKaryawan.getText().isEmpty() || txtNamaKaryawan.getText().isEmpty() ||
            txtJabatan.getText().isEmpty() || txtDepartemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi semua kolom sebelum menyimpan.");
            return;
        }

        // Validasi input ID hanya angka
        if (!txtIdKaryawan.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "ID Karyawan harus berupa angka dan tidak boleh mengandung huruf atau simbol.");
            return;
        }

        // Validasi ID karyawan agar tidak duplikat
        try {
            String sqlCheckId = "SELECT COUNT(*) FROM karyawan WHERE id = ?";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pstCheckId = conn.prepareStatement(sqlCheckId);
            pstCheckId.setString(1, txtIdKaryawan.getText());
            java.sql.ResultSet rsCheckId = pstCheckId.executeQuery();

            if (rsCheckId.next() && rsCheckId.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "ID Karyawan sudah digunakan, harap masukkan ID yang berbeda.");
                return; // Hentikan eksekusi jika ID sudah ada
            }

            // Lanjutkan proses simpan jika ID belum ada
            String sql = "INSERT INTO karyawan VALUES (?, ?, ?, ?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtIdKaryawan.getText());
            pst.setString(2, txtNamaKaryawan.getText());
            pst.setString(3, txtJabatan.getText());
            pst.setString(4, txtDepartemen.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            load_karyawan();
            kosong();
            generateIdKaryawan();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnSimpanActionPerformed

    private void txtNamaKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaKaryawanActionPerformed

    private void btnSimpanProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanProyekActionPerformed
        // TODO add your handling code here:
        // Validasi input kosong
        if (txtIdProyek.getText().isEmpty() || txtNamaProyek.getText().isEmpty() ||
            txtDurasiPengerjaan.getText().isEmpty() ||
            txtDurasiPengerjaan.getText().equals("Isi durasi dalam hitungan minggu")) {
            JOptionPane.showMessageDialog(null, "Harap isi semua kolom sebelum menyimpan.");
            return;
        }

        // Validasi input ID hanya angka
        if (!txtIdProyek.getText().matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "ID Proyek harus berupa angka dan tidak boleh mengandung huruf atau simbol.");
            return;
        }

        // Validasi ID proyek agar tidak duplikat
        try {
            String sqlCheckIdProyek = "SELECT COUNT(*) FROM proyek WHERE id = ?";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pstCheckIdProyek = conn.prepareStatement(sqlCheckIdProyek);
            pstCheckIdProyek.setString(1, txtIdProyek.getText());
            java.sql.ResultSet rsCheckIdProyek = pstCheckIdProyek.executeQuery();

            if (rsCheckIdProyek.next() && rsCheckIdProyek.getInt(1) > 0) {
                JOptionPane.showMessageDialog(null, "ID Proyek sudah digunakan, harap masukkan ID yang berbeda.");
                return; // Hentikan eksekusi jika ID sudah ada
            }

            // Lanjutkan proses simpan jika ID belum ada
            String sql = "INSERT INTO proyek VALUES (?, ?, ?)";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, txtIdProyek.getText());
            pst.setString(2, txtNamaProyek.getText());
            pst.setString(3, txtDurasiPengerjaan.getText());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            load_projek();
            kosong();
            generateIdProyek();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_btnSimpanProyekActionPerformed
    
// Metode untuk mendapatkan ID Karyawan terbaru dan menampilkannya di txtIdKaryawan
    private void generateIdKaryawan() {
        try {
            String sql = "SELECT MAX(id) FROM karyawan";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int lastId = rs.getInt(1);
                txtIdKaryawan.setText(String.valueOf(lastId + 1));
            } else {
                txtIdKaryawan.setText("1"); // Jika tabel kosong, mulai dari ID 1
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat mengisi ID otomatis: " + e.getMessage());
        }
    }

    // Metode untuk mendapatkan ID Proyek terbaru dan menampilkannya di txtIdProyek
    private void generateIdProyek() {
        try {
            String sql = "SELECT MAX(id) FROM proyek";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.Statement st = conn.createStatement();
            java.sql.ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                int lastId = rs.getInt(1);
                txtIdProyek.setText(String.valueOf(lastId + 1));
            } else {
                txtIdProyek.setText("1"); // Jika tabel kosong, mulai dari ID 1
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saat mengisi ID otomatis: " + e.getMessage());
        }
    }

    // Panggil metode generate ID saat form diinisialisasi
    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        generateIdKaryawan();
        generateIdProyek();
    }
    
    
    private void btnSimpanTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanTransaksiActionPerformed
        // TODO add your handling code here:
        // Validasi input kosong
        if (cbIdKaryawan.getSelectedItem() == null || cbIdProyek.getSelectedItem() == null || 
            txtPeran.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap isi semua kolom sebelum menyimpan.");
            return;
        }

        // Simpan data ke database
        try {
            String sql = "insert into transaksi values ('" + cbIdKaryawan.getSelectedItem() + "','" + 
                         cbIdProyek.getSelectedItem() + "','" + txtPeran.getText() + "')";
            java.sql.Connection conn = (Connection) koneksi.getKoneksi();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Data Berhasil Disimpan");
            load_transaksi();
            kosong();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnSimpanTransaksiActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        // TODO add your handling code here:
        try {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
                java.sql.Connection conn = (Connection) koneksi.getKoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);

                // Isi parameter PreparedStatement
                pst.setString(1, txtNamaKaryawan.getText());
                pst.setString(2, txtJabatan.getText());
                pst.setString(3, txtDepartemen.getText());
                pst.setString(4, txtIdKaryawan.getText()); // ID tetap sebagai parameter terakhir

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

                // Refresh tabel dan kosongkan form
                load_karyawan(); 
                kosong();

                // Aktifkan kembali pengeditan ID setelah pembaruan (jika perlu)
                txtIdKaryawan.setEditable(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnUpdateProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateProyekActionPerformed
        // TODO add your handling code here:
        try {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
                java.sql.Connection conn = (Connection) koneksi.getKoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);

                // Isi parameter PreparedStatement
                pst.setString(1, txtNamaProyek.getText());
                pst.setString(2, txtDurasiPengerjaan.getText());
                pst.setString(3, txtIdProyek.getText());


                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

                // Refresh tabel dan kosongkan form
                load_projek(); 
                kosong();

                // Aktifkan kembali pengeditan ID setelah pembaruan (jika perlu)
                txtIdProyek.setEditable(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUpdateProyekActionPerformed

    private void btnUbahTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUbahTransaksiActionPerformed
        // TODO add your handling code here:
        try {
            // Tampilkan konfirmasi sebelum menyimpan perubahan
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "UPDATE transaksi SET id_proyek = ?, peran = ? WHERE id_karyawan = ?";
                java.sql.Connection conn = (Connection) koneksi.getKoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);

                // Isi parameter PreparedStatement dengan data dari combo box dan text field
                pst.setString(1, cbIdProyek.getSelectedItem().toString()); // ID proyek dari combo box
                pst.setString(2, txtPeran.getText()); // Peran dari text field
                pst.setString(3, cbIdKaryawan.getSelectedItem().toString()); // ID karyawan dari combo box

                pst.executeUpdate(); // Eksekusi query update
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

                // Refresh tabel dan kosongkan form
                load_transaksi();
                kosong(); // Bersihkan input form
            }
        } catch (Exception e) {
            // Tampilkan pesan kesalahan jika terjadi exception
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnUbahTransaksiActionPerformed

    private void tblKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKaryawanMouseClicked
        // TODO add your handling code here:
        int row = tblKaryawan.getSelectedRow();
        if (row != -1) {
            txtIdKaryawan.setText(tblKaryawan.getValueAt(row, 0).toString()); // ID Karyawan
            txtNamaKaryawan.setText(tblKaryawan.getValueAt(row, 1).toString()); // Nama Karyawan
            txtJabatan.setText(tblKaryawan.getValueAt(row, 2).toString()); // Jabatan
            txtDepartemen.setText(tblKaryawan.getValueAt(row, 3).toString()); // Departemen

            // Nonaktifkan text field ID agar tidak bisa diubah
            txtIdKaryawan.setEditable(false);
        }
    }//GEN-LAST:event_tblKaryawanMouseClicked

    private void tblProyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProyekMouseClicked
        // TODO add your handling code here:
        int row = tblProyek.getSelectedRow();
        if (row != -1) {
            txtIdProyek.setText(tblProyek.getValueAt(row, 0).toString()); // ID proyek
            txtNamaProyek.setText(tblProyek.getValueAt(row, 1).toString()); // Nama proyek
            txtDurasiPengerjaan.setText(tblProyek.getValueAt(row, 2).toString()); // durasi pengerjaan
 

            // Nonaktifkan text field ID agar tidak bisa diubah
            txtIdProyek.setEditable(false);
        }
    }//GEN-LAST:event_tblProyekMouseClicked

    private void tblTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTransaksiMouseClicked
        // TODO add your handling code here:
        int row = tblTransaksi.getSelectedRow();
        if (row != -1) {
            cbIdKaryawan.setSelectedItem(tblTransaksi.getValueAt(row, 0).toString()); // ID proyek
            cbIdProyek.setSelectedItem(tblTransaksi.getValueAt(row, 1).toString()); // Nama proyek
            txtPeran.setText(tblTransaksi.getValueAt(row, 2).toString()); // durasi pengerjaan
 
        }
    }//GEN-LAST:event_tblTransaksiMouseClicked

    private void btnRisetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRisetActionPerformed
        // TODO add your handling code here:
        // Tampilkan dialog konfirmasi sebelum mereset data
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mereset data ini?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            kosong(); // Hapus data di form jika pengguna menekan "Yes"
            JOptionPane.showMessageDialog(null, "Data berhasil direset.");
        }
    }//GEN-LAST:event_btnRisetActionPerformed

    private void btnUlangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUlangActionPerformed
        // TODO add your handling code here:
        // Tampilkan dialog konfirmasi sebelum mereset data
       int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mereset data ini?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);

       if (confirm == JOptionPane.YES_OPTION) {
           kosong(); // Hapus data di form jika pengguna menekan "Yes"
           JOptionPane.showMessageDialog(null, "Data berhasil direset.");
       }
    }//GEN-LAST:event_btnUlangActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
            // Tampilkan dialog konfirmasi sebelum mereset data
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin mereset data ini?", "Konfirmasi Reset", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            kosong(); // Hapus data di form jika pengguna menekan "Yes"
            JOptionPane.showMessageDialog(null, "Data berhasil direset.");
        }
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKeluarActionPerformed
        // TODO add your handling code here:
            // Tampilkan dialog konfirmasi sebelum keluar
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); // Menutup jendela jika pengguna memilih "Yes"
        }
    }//GEN-LAST:event_btnKeluarActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
           // Tampilkan dialog konfirmasi sebelum keluar
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); // Menutup jendela jika pengguna memilih "Yes"
        }
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
           // Tampilkan dialog konfirmasi sebelum keluar
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            dispose(); // Menutup jendela jika pengguna memilih "Yes"
        }
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        // TODO add your handling code here:
    // Periksa apakah ada baris yang dipilih
    int row = tblKaryawan.getSelectedRow();
    if (row != -1) {
        // Menampilkan konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Mendapatkan ID karyawan dari kolom yang sesuai (misalnya kolom ke-0)
                String id = tblKaryawan.getValueAt(row, 0).toString();

                // Query SQL untuk menghapus data berdasarkan ID
                String sql = "DELETE FROM karyawan WHERE id = ?";
                java.sql.Connection conn = (Connection) koneksi.getKoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);

                int deleted = pst.executeUpdate();
                if (deleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

                    // Hapus baris dari tampilan tabel tanpa memuat ulang seluruh data
                    ((DefaultTableModel) tblKaryawan.getModel()).removeRow(row);
                    kosong(); // Kosongkan form input
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus. Pastikan data masih ada di database.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
            }
        }
    } else {
        // Jika tidak ada baris yang dipilih
        JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus terlebih dahulu");
    }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void btnHapusMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnHapusMouseClicked
        // TODO add your handling code here:
        // Menampilkan data baris yang diklik ke dalam TextField
        int row = tblKaryawan.getSelectedRow();

        if (row != -1) {
            txtIdKaryawan.setText(tblKaryawan.getValueAt(row, 0).toString());
            txtNamaKaryawan.setText(tblKaryawan.getValueAt(row, 1).toString());
            txtJabatan.setText(tblKaryawan.getValueAt(row, 2).toString());
            txtDepartemen.setText(tblKaryawan.getValueAt(row, 3).toString());
        }
    }//GEN-LAST:event_btnHapusMouseClicked

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
    // Periksa apakah ada baris yang dipilih
    int row = tblProyek.getSelectedRow();
    if (row != -1) {
        // Menampilkan konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Mendapatkan ID proyek dari kolom pertama (pastikan indeks kolom sesuai)
                String id = tblProyek.getValueAt(row, 0).toString(); // Pastikan ini sesuai dengan kolom ID proyek

                // Query SQL untuk menghapus data berdasarkan ID
                String sql = "DELETE FROM proyek WHERE id = ?";
                java.sql.Connection conn = (Connection) koneksi.getKoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, id);

                int deleted = pst.executeUpdate();
                if (deleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

                    // Hapus baris dari tampilan tabel tanpa memuat ulang seluruh data
                    ((DefaultTableModel) tblProyek.getModel()).removeRow(row);
                    kosong(); // Kosongkan form input
                } else {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan atau gagal dihapus.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
            }
        }
    } else {
        // Jika tidak ada baris yang dipilih
        JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus terlebih dahulu");
    }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
        // TODO add your handling code here:
    // Periksa apakah ada baris yang dipilih di tabel proyek
    int row = tblProyek.getSelectedRow(); 

    if (row != -1) {
        // Mengisi text field dengan data dari baris yang dipilih (pastikan indeks kolom sesuai)
        txtIdProyek.setText(tblProyek.getValueAt(row, 0).toString()); // Pastikan indeks kolom untuk ID proyek benar
        txtNamaProyek.setText(tblProyek.getValueAt(row, 1).toString()); // Nama proyek
        txtDurasiPengerjaan.setText(tblProyek.getValueAt(row, 2).toString()); // Durasi pengerjaan
    } else {
        // Tampilkan pesan jika tidak ada baris yang dipilih
        JOptionPane.showMessageDialog(null, "Pilih data yang ingin ditampilkan terlebih dahulu");
    }
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void btnhapusTransaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhapusTransaksiActionPerformed
        // TODO add your handling code here:
    // Periksa apakah ada baris yang dipilih
    int row = tblTransaksi.getSelectedRow();
    if (row != -1) {
        // Menampilkan konfirmasi penghapusan
        int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus data ini?", "Konfirmasi Penghapusan", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            try {
                // Mendapatkan ID karyawan dan ID proyek dari kolom yang sesuai di tabel
                String idKaryawan = tblTransaksi.getValueAt(row, 0).toString(); // Pastikan indeks kolom benar
                String idProyek = tblTransaksi.getValueAt(row, 1).toString();   // Pastikan indeks kolom benar

                // Query SQL untuk menghapus data berdasarkan ID karyawan dan proyek
                String sql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
                java.sql.Connection conn = (Connection) koneksi.getKoneksi();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, idKaryawan);
                pst.setString(2, idProyek);

                int deleted = pst.executeUpdate();
                if (deleted > 0) {
                    JOptionPane.showMessageDialog(null, "Data Berhasil Dihapus");

                    // Hapus baris dari tampilan tabel tanpa memuat ulang seluruh data
                    ((DefaultTableModel) tblTransaksi.getModel()).removeRow(row);
                    kosong(); // Kosongkan form input
                } else {
                    JOptionPane.showMessageDialog(null, "Data gagal dihapus. Pastikan data masih ada di database.");
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage());
            }
        }
    } else {
        // Jika tidak ada baris yang dipilih
        JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus terlebih dahulu");
    }
    }//GEN-LAST:event_btnhapusTransaksiActionPerformed

    private void btnhapusTransaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhapusTransaksiMouseClicked
        // TODO add your handling code here:
    // Periksa apakah ada baris yang dipilih di tabel transaksi
    int row = tblTransaksi.getSelectedRow(); 

    if (row != -1) {
        // Mengisi combo box dan text field dengan data yang dipilih di tabel
        cbIdKaryawan.setSelectedItem(tblTransaksi.getValueAt(row, 0).toString()); // Pastikan indeks kolom benar
        cbIdProyek.setSelectedItem(tblTransaksi.getValueAt(row, 1).toString());   // Pastikan indeks kolom benar
        txtPeran.setText(tblTransaksi.getValueAt(row, 2).toString());             // Pastikan indeks kolom benar
    } else {
        // Jika tidak ada baris yang dipilih, tampilkan pesan peringatan
        JOptionPane.showMessageDialog(null, "Pilih data yang ingin dihapus terlebih dahulu");
    }

    }//GEN-LAST:event_btnhapusTransaksiMouseClicked

    private void txtIdKaryawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdKaryawanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKaryawanMouseClicked

    private void txtIdProyekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdProyekActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProyekActionPerformed

    private void txtIdProyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtIdProyekMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdProyekMouseClicked

    private void txtIdKaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdKaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIdKaryawanActionPerformed

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
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Karyawan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Karyawan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKeluar;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnRiset;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnSimpanProyek;
    private javax.swing.JButton btnSimpanTransaksi;
    private javax.swing.JButton btnUbahTransaksi;
    private javax.swing.JButton btnUlang;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JButton btnUpdateProyek;
    private javax.swing.JButton btnhapusTransaksi;
    private javax.swing.JComboBox<String> cbIdKaryawan;
    private javax.swing.JComboBox<String> cbIdProyek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblDepartermen;
    private javax.swing.JLabel lblDurasi;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblIdProyek;
    private javax.swing.JLabel lblJabatan;
    private javax.swing.JLabel lblNama;
    private javax.swing.JLabel lblNamaProyek;
    private javax.swing.JLabel lblPeran;
    private javax.swing.JPanel lblProyek;
    private javax.swing.JLabel lblTabel;
    private javax.swing.JLabel lblidkaryawan;
    private javax.swing.JLabel lblidproyek;
    private javax.swing.JPanel panelJudul;
    private javax.swing.JPanel panelKaryawan;
    private javax.swing.JPanel paneltabelKaryawan;
    private javax.swing.JTable tblKaryawan;
    private javax.swing.JTable tblProyek;
    private javax.swing.JTable tblTransaksi;
    private javax.swing.JTextField txtDepartemen;
    private javax.swing.JTextField txtDurasiPengerjaan;
    private javax.swing.JTextField txtIdKaryawan;
    private javax.swing.JTextField txtIdProyek;
    private javax.swing.JTextField txtJabatan;
    private javax.swing.JTextField txtNamaKaryawan;
    private javax.swing.JTextField txtNamaProyek;
    private javax.swing.JTextField txtPeran;
    // End of variables declaration//GEN-END:variables







}
