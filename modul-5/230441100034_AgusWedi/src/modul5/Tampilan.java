package modul5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Tampilan extends javax.swing.JFrame {
    Connection conn;
    private DefaultTableModel tb_karyawan;
    private DefaultTableModel tb_proyek;
    private DefaultTableModel tb_transaksi;

    
    public Tampilan() {
        initComponents();
        conn = koneksi.getConnection();
        tb_karyawan = new DefaultTableModel();
        tb1.setModel(tb_karyawan);

        tb_karyawan.addColumn("ID");
        tb_karyawan.addColumn("NAMA");
        tb_karyawan.addColumn("JABATAN");
        tb_karyawan.addColumn("DEPARTEMEN");

        tb_proyek = new DefaultTableModel();
        tb2.setModel(tb_proyek);
        tb_proyek.addColumn("ID Proyek");
        tb_proyek.addColumn("Nama Proyek");
        tb_proyek.addColumn("Durasi Pekerjaan");

        tb_transaksi = new DefaultTableModel();
        tb3.setModel(tb_transaksi);
        tb_transaksi.addColumn("Nama Karyawan");
        tb_transaksi.addColumn("Nama Proyek");
        tb_transaksi.addColumn("Peran");

        loadData();
        loadData1();
        loadDataTransaksi();
        loadKaryawanToComboBox();
        loadProyekToComboBox();
    }
    
    private void loadData() {
        tb_karyawan.setRowCount(0);

        try {
            String sql = "SELECT * FROM tb_karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tb_karyawan.addRow(new Object[]{
                    rs.getInt("id_karyawan"),
                    rs.getString("nama_karyawan"),
                    rs.getString("jabatan"),
                    rs.getString("departemen")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void loadData1() {
        tb_proyek.setRowCount(0);

        try {
            String sql = "SELECT * FROM tb_proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tb_proyek.addRow(new Object[]{
                    rs.getInt("id_proyek"),
                    rs.getString("nama_proyek"),
                    rs.getString("durasi_pengerjaan")
                });
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void loadDataTransaksi() {
        tb_transaksi.setRowCount(0);
        try {
            String sql = "SELECT k.nama_karyawan as nama_karyawan, p.nama_proyek, "
                    + "t.peran, t.id_karyawan, t.id_proyek "
                    + "FROM tb_transaksi t "
                    + "JOIN tb_karyawan k ON t.id_karyawan = k.id_karyawan "
                    + "JOIN tb_proyek p ON t.id_proyek = p.id_proyek "
                    + "ORDER BY k.nama_karyawan, p.nama_proyek";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                tb_transaksi.addRow(new Object[]{
                    rs.getString("nama_karyawan"),
                    rs.getString("nama_proyek"),
                    rs.getString("peran"),
                    rs.getInt("id_karyawan"),
                    rs.getInt("id_proyek")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error Load Data Transaksi: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Gagal memuat data transaksi: " + e.getMessage());
        }
    }
    
    private void loadKaryawanToComboBox() {
        cbt1.removeAllItems(); 
        try {
            String sql = "SELECT id_karyawan, nama_karyawan FROM tb_karyawan ORDER BY nama_karyawan";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String item = rs.getInt("id_karyawan") + " - " + rs.getString("nama_karyawan");
                cbt1.addItem(item); 
            }
        } catch (SQLException e) {
            System.out.println("Error memuat karyawan: " + e.getMessage());
        }
    }
    
    private void loadProyekToComboBox() {
        cbt2.removeAllItems(); 
        try {
            String sql = "SELECT id_proyek, nama_proyek FROM tb_proyek ORDER BY nama_proyek";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String item = rs.getInt("id_proyek") + " - " + rs.getString("nama_proyek");
                cbt2.addItem(item); 
            }
        } catch (SQLException e) {
            System.out.println("Error memuat proyek: " + e.getMessage());
        }
    }
    
    private void simpanDataTransaksi() {
//        if (cbt1.getSelectedIndex() == 0 && cbt2.getSelectedIndex() == 0 && txtp1.getText().isEmpty()){
//            JOptionPane.showMessageDialog(null, "data transaksi harus di pilih terlebih dahulu");
//            return;
//        }
        try {
            String selectedKaryawan = (String) cbt1.getSelectedItem();
            String selectedProyek = (String) cbt2.getSelectedItem();

            int idKaryawan = Integer.parseInt(selectedKaryawan.split(" - ")[0]);
            int idProyek = Integer.parseInt(selectedProyek.split(" - ")[0]);
            String peran = txtp1.getText();

            String sql = "INSERT INTO tb_transaksi (id_karyawan, id_proyek, peran ) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.setInt(2, idProyek);
            ps.setString(3, peran);
            ps.executeUpdate();
            loadDataTransaksi();

            JOptionPane.showMessageDialog(null, "Transaksi berhasil ditambahkan");

            
            txtp1.setText("");
            txtdp2.setText("");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Durasi harus berupa angka. Silakan periksa input Anda.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "tidak dapat menyimpan data karena ada kesamaan data");
//            JOptionPane.showMessageDialog(null, "Error menyimpan transaksi: " + e);
            return;
        }
    }
    
    private int getSelectedId(String selectedItem) {
        try {
            return Integer.parseInt(selectedItem.split(" - ")[0]); // Mengambil ID dari "ID - Nama"
        } catch (Exception e) {
            System.out.println("Kesalahan parsing ID: " + e.getMessage());
            return -1; // Mengembalikan -1 jika ada kesalahan parsing
        }
    }
    
    private void updateTransaksi() {
    try {
        int idKaryawan = getSelectedId(cbt1.getSelectedItem().toString());
        int idProyek = getSelectedId(cbt2.getSelectedItem().toString());

        // Cek apakah data transaksi dengan id_karyawan dan id_proyek yang dipilih ada di tabel transaksi
        String cekSql = "SELECT COUNT(*) AS jumlah FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?";
        PreparedStatement psCek = conn.prepareStatement(cekSql);
        psCek.setInt(1, idKaryawan);
        psCek.setInt(2, idProyek);
        ResultSet rs = psCek.executeQuery();
        
        // Jika data transaksi ditemukan (jumlah > 0), lanjutkan update
        if (rs.next() && rs.getInt("jumlah") > 0) {
            String sql = "UPDATE tb_transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, txtp1.getText());
            ps.setInt(2, idKaryawan);
            ps.setInt(3, idProyek);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Transaksi berhasil diperbarui");
            loadDataTransaksi();
        } else {
            // Jika data tidak ditemukan, tampilkan pesan peringatan
            JOptionPane.showMessageDialog(this, "Data tidak ditemukan di tabel transaksi. Pastikan data yang dipilih sesuai dengan data di tabel.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        }
    } catch (SQLException e) {
        System.out.println("Kesalahan Memperbarui Data Transaksi: " + e.getMessage());
    }
    }
    
    // Metode untuk menghapus data transaksi
    private void hapusTransaksi() {
        try {
            // Mendapatkan nilai dari ComboBox karyawan dan proyek
            String selectedKaryawan = (String) cbt1.getSelectedItem();
            String selectedProyek = (String) cbt2.getSelectedItem();

            // Parsing id_karyawan dan id_proyek dari ComboBox
            int idKaryawan = Integer.parseInt(selectedKaryawan.split(" - ")[0]);
            int idProyek = Integer.parseInt(selectedProyek.split(" - ")[0]);

            // Konfirmasi penghapusan
            int confirm = JOptionPane.showConfirmDialog(this,
                    "Apakah Anda yakin ingin menghapus data transaksi ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                // Perintah SQL untuk delete data
                String sql = "DELETE FROM tb_transaksi WHERE id_karyawan = ? AND id_proyek = ?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, idKaryawan);
                ps.setInt(2, idProyek);

                // Eksekusi delete
                int result = ps.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data transaksi berhasil dihapus");
                    loadDataTransaksi(); // Memuat ulang data setelah penghapusan
                } else {
                    JOptionPane.showMessageDialog(this, "Data tidak ditemukan atau sudah terhapus");
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error menghapus data transaksi: " + e.getMessage());
        }
    }
    
    private void simpanData() {
        if(txtnama1.getText().isEmpty() && cmb1.getSelectedIndex() == 0 && txtdep1.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
            return;
        }
        try {
            String sql = "INSERT INTO tb_karyawan (nama_karyawan, jabatan,Departemen) VALUES (?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtnama1.getText());
//            ps.setString(2, nama.getText());
            ps.setString(2, cmb1.getSelectedItem().toString());
            ps.setString(3, txtdep1.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Succes");
            loadData();
            loadKaryawanToComboBox();
            loadProyekToComboBox();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Save DAta" + e);
        }
    }
    
    private void editData() {
        try {
            String sql = "UPDATE tb_karyawan SET nama_karyawan = ?, jabatan = ?, Departemen = ? WHERE id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtnama1.getText());
//            ps.setString(2, nama.getText());
            ps.setString(2, cmb1.getSelectedItem().toString());
            ps.setString(3, txtdep1.getText());
            ps.setInt(4, Integer.parseInt(txtid1.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data UPDATE Succes");
            loadData();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Save DAta" + e);
        }
    }
    
    private void hapusData() {
    try {
        int idKaryawan = Integer.parseInt(txtid1.getText());

        // Cek apakah id_karyawan masih ada di tabel transaksi
        String cekSql = "SELECT COUNT(*) AS jumlah FROM tb_transaksi WHERE id_karyawan = ?";
        PreparedStatement psCek = conn.prepareStatement(cekSql);
        psCek.setInt(1, idKaryawan);
        ResultSet rs = psCek.executeQuery();

        // Jika data karyawan masih ada di transaksi, batalkan penghapusan
        if (rs.next() && rs.getInt("jumlah") > 0) {
            JOptionPane.showMessageDialog(this, "Data Karyawan tidak dapat dihapus karena masih terkait dengan transaksi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            // Hapus data karyawan jika tidak terkait dengan transaksi
            String sql = "DELETE FROM tb_karyawan WHERE id_karyawan = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idKaryawan);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Karyawan berhasil dihapus");
            aturUlangID();
            resetAutoIncrement();
            loadKaryawanToComboBox();
            loadData();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan Menghapus Data Karyawan: " + e.getMessage());
    }
    }
    
    private void aturUlangID() {
        try {
            // Ambil data yang sudah diurutkan berdasarkan ID
            String selectSQL = "SELECT id_karyawan FROM tb_karyawan ORDER BY id_karyawan";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(selectSQL);

            int newId = 1;
            while (rs.next()) {
                // Memperbarui ID dengan nilai berurutan mulai dari 1
                rs.updateInt("id_karyawan", newId++);
                rs.updateRow();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mengatur ulang ID: " + e);
        }
    }
    
    private void resetAutoIncrement() {
        try {
            String sql = "ALTER TABLE tb_karyawan AUTO_INCREMENT = 1";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mereset auto-increment: " + e);
        }
    }
    
    private void aturUlangID1() {
        try {
            // Ambil data yang sudah diurutkan berdasarkan ID
            String selectSQL = "SELECT id_proyek FROM tb_proyek ORDER BY id_proyek";
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(selectSQL);

            int newId = 1;
            while (rs.next()) {
                // Memperbarui ID dengan nilai berurutan mulai dari 1
                rs.updateInt("id_proyek", newId++);
                rs.updateRow();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mengatur ulang ID: " + e);
        }
    }
    
    private void resetAutoIncrement1() {
        try {
            String sql = "ALTER TABLE tb_proyek AUTO_INCREMENT = 1";
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error saat mereset auto-increment: " + e);
        }
    }
    
    private void tambahDataProyek() {
            if(txtnamap2.getText().isEmpty() && txtdp2.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Data tidakk boleh kosong");
                return;
            }
        try {
            String sql = "INSERT INTO tb_proyek (nama_proyek, durasi_pengerjaan) VALUES (?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtnamap2.getText());
            ps.setString(2, txtdp2.getText());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Add Succes");
            loadData1();
            loadKaryawanToComboBox();
            loadProyekToComboBox();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Save DAta" + e);
        }
    }
    
    private void editDataProyek() {
        try {
            String sql = "UPDATE tb_proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, txtnamap2.getText());
            ps.setString(2, txtdp2.getText());
            ps.setInt(3, Integer.parseInt(txtidp2.getText()));
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data UPDATE Succes");
            loadData1();
            loadProyekToComboBox();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error Save DAta" + e);
        }
    }
    
    private void deleteDataProyek() {
    try {
        int idProyek = Integer.parseInt(txtidp2.getText());
        
        String cekSql = "SELECT COUNT(*) AS jumlah FROM tb_transaksi WHERE id_proyek = ?";
        PreparedStatement psCek = conn.prepareStatement(cekSql);
        psCek.setInt(1, idProyek);
        ResultSet rs = psCek.executeQuery();
        
//        int jumlah = rs.getInt("jumlah");
//        System.out.println("jumlah nya adalah" + jumlah);
        if (rs.next() && rs.getInt("jumlah") > 0) {
            JOptionPane.showMessageDialog(this, "Data Proyek tidak dapat dihapus karena masih terkait dengan transaksi.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            
            String sql = "DELETE FROM tb_proyek WHERE id_proyek = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idProyek);
            ps.executeUpdate();

            JOptionPane.showMessageDialog(this, "Data Proyek berhasil dihapus");
//            loadKaryawanToComboBox();
            aturUlangID1();
            resetAutoIncrement1();
            loadProyekToComboBox();
            loadData1();
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Kesalahan Menghapus Data Proyek: " + e.getMessage());
    }
    }
    
    


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        tambahk1 = new javax.swing.JButton();
        editk1 = new javax.swing.JButton();
        hapusk1 = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtid1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtnama1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        cmb1 = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtdep1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1 = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        reset1 = new javax.swing.JButton();
        hapus1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txtidp2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtnamap2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtdp2 = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        tambahp2 = new javax.swing.JButton();
        editp2 = new javax.swing.JButton();
        hapusp2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb2 = new javax.swing.JTable();
        jPanel11 = new javax.swing.JPanel();
        reset2 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        cbt1 = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        cbt2 = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtp1 = new javax.swing.JTextField();
        jPanel13 = new javax.swing.JPanel();
        tambahT3 = new javax.swing.JButton();
        editT3 = new javax.swing.JButton();
        hapusT3 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tb3 = new javax.swing.JTable();
        jPanel14 = new javax.swing.JPanel();
        reset3 = new javax.swing.JButton();
        hapus3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Manajemen Karyawan dan Proyek");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\Free Vector _ A construction worker in uniform2.jpg")); // NOI18N

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER\\Downloads\\Free Vector _ A construction worker in uniform2.jpg")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel6)
                .addGap(52, 52, 52)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(34, 34, 34))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 255, 255));

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));

        tambahk1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tambahk1.setText("Tambah");
        tambahk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahk1ActionPerformed(evt);
            }
        });
        jPanel6.add(tambahk1);

        editk1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        editk1.setText("Edit");
        editk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editk1ActionPerformed(evt);
            }
        });
        jPanel6.add(editk1);

        hapusk1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        hapusk1.setText("Hapus");
        hapusk1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusk1ActionPerformed(evt);
            }
        });
        jPanel6.add(hapusk1);

        jPanel7.setLayout(new java.awt.GridLayout(4, 0));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("ID :");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel7.add(jLabel2);

        txtid1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel7.add(txtid1);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Nama :");
        jPanel7.add(jLabel3);

        txtnama1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel7.add(txtnama1);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Jabatan :");
        jPanel7.add(jLabel4);

        cmb1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cmb1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select", "Jajaran Direksi", "Direktur Utama", "Direktur", "Direktur Keuangan ", "Manajer Personalia ", "Manajer Pemasaran", "Manajer Pabrik", "Manajer Pengembangan Bisnis", "Manajer Hukum", "Manajer Produk", "Manajer IT", "Sekretaris Perusahaan ", "Administrasi dan Gudang" }));
        jPanel7.add(cmb1);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Departemen :");
        jPanel7.add(jLabel5);

        txtdep1.setBackground(new java.awt.Color(51, 255, 255));
        jPanel7.add(txtdep1);

        tb1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nama", "Departemen", "Jabatan"
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
        jScrollPane1.setViewportView(tb1);

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));

        reset1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        reset1.setText("Reset");
        reset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset1ActionPerformed(evt);
            }
        });
        jPanel8.add(reset1);

        hapus1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hapus1.setText("Finished");
        hapus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus1ActionPerformed(evt);
            }
        });
        jPanel8.add(hapus1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 609, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        jTabbedPane1.addTab("Karyawan", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));

        jPanel9.setBackground(new java.awt.Color(255, 255, 0));
        jPanel9.setLayout(new java.awt.GridLayout(3, 0));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("ID PROYEK :");
        jPanel9.add(jLabel9);
        jPanel9.add(txtidp2);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NAMA PROYEK :");
        jPanel9.add(jLabel8);
        jPanel9.add(txtnamap2);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("DURASI PENGERJAAN :");
        jPanel9.add(jLabel10);
        jPanel9.add(txtdp2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 0));

        tambahp2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tambahp2.setText("Tambah");
        tambahp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahp2ActionPerformed(evt);
            }
        });
        jPanel10.add(tambahp2);

        editp2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        editp2.setText("Edit");
        editp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editp2ActionPerformed(evt);
            }
        });
        jPanel10.add(editp2);

        hapusp2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hapusp2.setText("Hapus");
        hapusp2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusp2ActionPerformed(evt);
            }
        });
        jPanel10.add(hapusp2);

        tb2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID Proyek", "Nama Proyek", "Durasi Pengerjaan"
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
        jScrollPane2.setViewportView(tb2);

        jPanel11.setBackground(new java.awt.Color(255, 255, 0));

        reset2.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        reset2.setText("Reset");
        reset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset2ActionPerformed(evt);
            }
        });
        jPanel11.add(reset2);

        jButton10.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jButton10.setText("Finished");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton10);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Proyek", jPanel4);

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));

        jPanel12.setBackground(new java.awt.Color(0, 255, 204));
        jPanel12.setLayout(new java.awt.GridLayout(3, 3, 3, 3));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("ID Karyawan");
        jPanel12.add(jLabel11);

        cbt1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cbt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbt1ActionPerformed(evt);
            }
        });
        jPanel12.add(cbt1);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ID Proyek");
        jPanel12.add(jLabel12);

        cbt2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select" }));
        cbt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbt2ActionPerformed(evt);
            }
        });
        jPanel12.add(cbt2);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Peran");
        jPanel12.add(jLabel13);
        jPanel12.add(txtp1);

        jPanel13.setBackground(new java.awt.Color(0, 255, 204));

        tambahT3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        tambahT3.setText("Tambah");
        tambahT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahT3ActionPerformed(evt);
            }
        });
        jPanel13.add(tambahT3);

        editT3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        editT3.setText("Edit");
        editT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editT3ActionPerformed(evt);
            }
        });
        jPanel13.add(editT3);

        hapusT3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hapusT3.setText("Hapus");
        hapusT3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusT3ActionPerformed(evt);
            }
        });
        jPanel13.add(hapusT3);

        tb3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tb3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tb3);

        jPanel14.setBackground(new java.awt.Color(0, 255, 204));

        reset3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        reset3.setText("Reset");
        reset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reset3ActionPerformed(evt);
            }
        });
        jPanel14.add(reset3);

        hapus3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        hapus3.setText("Finished");
        hapus3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapus3ActionPerformed(evt);
            }
        });
        jPanel14.add(hapus3);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Transaksi", jPanel5);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 621, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1))
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
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tambahk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahk1ActionPerformed
        // TODO add your handling code here:
    simpanData();
    }//GEN-LAST:event_tambahk1ActionPerformed

    private void editk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editk1ActionPerformed
        // TODO add your handling code here:
    editData();
    }//GEN-LAST:event_editk1ActionPerformed

    private void hapusk1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusk1ActionPerformed
    hapusData();      // TODO add your handling code here:
    }//GEN-LAST:event_hapusk1ActionPerformed

    private void tambahp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahp2ActionPerformed
    tambahDataProyek();        // TODO add your handling code here:
    }//GEN-LAST:event_tambahp2ActionPerformed

    private void editp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editp2ActionPerformed
    editDataProyek();        // TODO add your handling code here:
    }//GEN-LAST:event_editp2ActionPerformed

    private void hapusp2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusp2ActionPerformed
    deleteDataProyek();    // TODO add your handling code here:
    }//GEN-LAST:event_hapusp2ActionPerformed

    private void tambahT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahT3ActionPerformed
    simpanDataTransaksi();    // TODO add your handling code here:
    }//GEN-LAST:event_tambahT3ActionPerformed

    private void editT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editT3ActionPerformed
    updateTransaksi();        // TODO add your handling code here:
    }//GEN-LAST:event_editT3ActionPerformed

    private void hapusT3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusT3ActionPerformed
    hapusTransaksi();      // TODO add your handling code here:
    }//GEN-LAST:event_hapusT3ActionPerformed

    private void reset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset2ActionPerformed
        // TODO add your handling code here:
        txtidp2.setText("");
        txtnamap2.setText("");
        txtdp2.setText("");
    }//GEN-LAST:event_reset2ActionPerformed

    private void reset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset1ActionPerformed
        // TODO add your handling code here:
        txtid1.setText("");
        txtnama1.setText("");
        cmb1.setSelectedIndex(0);
        txtdep1.setText("");
    }//GEN-LAST:event_reset1ActionPerformed

    private void reset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reset3ActionPerformed
        // TODO add your handling code here:
        cbt1.setSelectedIndex(0);
        cbt2.setSelectedIndex(0);
        txtp1.setText("");
        
    }//GEN-LAST:event_reset3ActionPerformed

    private void hapus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_hapus1ActionPerformed

    private void hapus3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapus3ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_hapus3ActionPerformed

    private void cbt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbt1ActionPerformed
        // TODO add your handling code here:
//        loadKaryawanToComboBox();
    }//GEN-LAST:event_cbt1ActionPerformed

    private void cbt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbt2ActionPerformed
        // TODO add your handling code here:
//        loadProyekToComboBox();
    }//GEN-LAST:event_cbt2ActionPerformed

    
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
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tampilan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tampilan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbt1;
    private javax.swing.JComboBox<String> cbt2;
    private javax.swing.JComboBox<String> cmb1;
    private javax.swing.JButton editT3;
    private javax.swing.JButton editk1;
    private javax.swing.JButton editp2;
    private javax.swing.JButton hapus1;
    private javax.swing.JButton hapus3;
    private javax.swing.JButton hapusT3;
    private javax.swing.JButton hapusk1;
    private javax.swing.JButton hapusp2;
    private javax.swing.JButton jButton10;
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
    private javax.swing.JButton reset1;
    private javax.swing.JButton reset2;
    private javax.swing.JButton reset3;
    private javax.swing.JButton tambahT3;
    private javax.swing.JButton tambahk1;
    private javax.swing.JButton tambahp2;
    private javax.swing.JTable tb1;
    private javax.swing.JTable tb2;
    private javax.swing.JTable tb3;
    private javax.swing.JTextField txtdep1;
    private javax.swing.JTextField txtdp2;
    private javax.swing.JTextField txtid1;
    private javax.swing.JTextField txtidp2;
    private javax.swing.JTextField txtnama1;
    private javax.swing.JTextField txtnamap2;
    private javax.swing.JTextField txtp1;
    // End of variables declaration//GEN-END:variables

}
