
package modull5;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Muhammad Fajri
 */
public class Main extends javax.swing.JFrame {
DefaultTableModel model  = new DefaultTableModel();
DefaultTableModel model2  = new DefaultTableModel();
DefaultTableModel model3  = new DefaultTableModel();
Connection conn = Koneksi.getConnection();
HashMap<String, Integer> karyawanMap = new HashMap<>(); 
HashMap<String, Integer> proyekMap = new HashMap<>();  
String idKaryawan;
String idProyek;
 
 public Main() {
        initComponents();
        tbl_karyawan.setModel(model);
        model.addColumn("ID");
        model.addColumn("NAMA");
        model.addColumn("JABATAN");
        model.addColumn("DEPARTEMEN");
        loadData();
        btnupdate.setVisible(true);

        
        tbl_proyek.setModel(model2);
        model2.addColumn("ID");
        model2.addColumn("NAMA PROYEK");
        model2.addColumn("DURASI PROYEK/MINGGU"); 
        load();
        btnupdate2.setVisible(true);
        
        
        tbl_transaksi.setModel(model3);
        model3.addColumn("NAMA KARYAWAN"); 
        model3.addColumn("NAMA PROYEK"); 
        model3.addColumn("PERAN");
        loadtransaksi();
        data();
        btnupdate3.setVisible(true);

    }
private void loadData() {
      model.setRowCount(0);
      try {
          String sql = "SELECT * FROM karyawan";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();         
          while (rs.next()) {
             model.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("Nama"),
             rs.getString("Jabatan"),
             rs.getString("Departemen")
           });
          }           
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
       txtnama.setText(null);
       txtjabatan.setText(null);
       txtdepartemen.setText(null);
    }
private void loadData2() {
      model2.setRowCount(0);
      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();         
          while (rs.next()) {
             model2.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("nama_proyek"),
             rs.getInt("durasi_pengerjaan"),
           });
          }           
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
       txtproyek.setText(null);
       txtdurasi.setText(null);
    }
private void loadData3() {
      model3.setRowCount(0); 
    try {
        String sql = "SELECT transaksi.*, karyawan.nama AS nama_karyawan, proyek.nama_proyek AS nama_proyek " +
                     "FROM transaksi " +
                     "JOIN karyawan ON transaksi.id_karyawan = karyawan.id " +
                     "JOIN proyek ON transaksi.id_proyek = proyek.id";
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();         
        while (rs.next()) {
            model3.addRow(new Object[]{
                rs.getString("nama_karyawan"),
                rs.getString("nama_proyek"),   
                rs.getString("peran")         
            });
        }           
    } catch (SQLException e) {
        System.out.println("Error Load Data: " + e.getMessage());
    }
    cbxkaryawan.setSelectedItem(null);
    cbxproyek.setSelectedItem(null);
    txtperan.setText(null);
    }

private void load() {
      model2.setRowCount(0);
      try {
          String sql = "SELECT * FROM proyek";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();         
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model2.addRow(new Object[]{
             rs.getInt("id"),
             rs.getString("Nama_Proyek"),
             rs.getString("Durasi_Pengerjaan")
           });
          }           
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
//       buttonGroup2.clearSelection();
       btnupdate2.setVisible(false);
       txtproyek.setText("");
       txtdurasi.setText("");
    }
private void keluar(){
        int response = JOptionPane.showConfirmDialog(null, "Apakah Anda Ingin Keluar", "Keluar", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
}
private void loadtransaksi() {
    model3.setRowCount(0);
    try {
    String sql = "SELECT t.id_proyek, t.id_karyawan, t.Peran, p.Nama_Proyek, k.Nama " +
                 "FROM transaksi t " +
                 "JOIN proyek p ON t.id_proyek = p.id " +
                 "JOIN karyawan k ON t.id_karyawan = k.id";
          PreparedStatement ps = conn.prepareStatement(sql);
          ResultSet rs = ps.executeQuery();         
          while (rs.next()) {
             // Menambahkan baris ke dalam model tabel
             model3.addRow(new Object[]{
             rs.getString("nama"),
             rs.getString("nama_proyek"),   
             rs.getString("peran")  
           });
          }           
      } catch (SQLException e) {
         System.out.println("Error Save Data" + e.getMessage());
       }
}

private void data(){
    String proyek= "SELECT id, Nama_Proyek FROM proyek"; 
    String karyawan = "SELECT id, Nama FROM karyawan"; 
    cbxproyek.removeAllItems();
    cbxkaryawan.removeAllItems();
    proyekMap.clear();
    karyawanMap.clear();
    
    try (PreparedStatement psKaryawan = conn.prepareStatement(karyawan);
         ResultSet rsKaryawan = psKaryawan.executeQuery()) {

        while (rsKaryawan.next()) {
            String namaKaryawan = rsKaryawan.getString("Nama");
            cbxkaryawan.addItem(namaKaryawan);
            int idkaryawan = rsKaryawan.getInt("id");
            karyawanMap.put(namaKaryawan, idkaryawan);
        }
    } catch (SQLException e) {
        System.out.println("Error Save Data" + e.getMessage());
    }
    
    try (PreparedStatement psProyek = conn.prepareStatement(proyek);
         ResultSet rsProyek = psProyek.executeQuery()) {

        while (rsProyek.next()) {
            String namaProyek = rsProyek.getString("Nama_Proyek"); 
            cbxproyek.addItem(namaProyek);
            int idproyek = rsProyek.getInt("id");
            proyekMap.put(namaProyek, idproyek);
        }
    } catch (SQLException e) {
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

        tabbedPaneCustom1 = new Efek.TabbedPaneCustom();
        hal1 = new javax.swing.JPanel();
        txtnama = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtjabatan = new javax.swing.JTextField();
        txtdepartemen = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btndelete = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        btnupdate = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        btnreset = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_karyawan = new javax.swing.JTable();
        BG = new javax.swing.JLabel();
        hal2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtproyek = new javax.swing.JTextField();
        txtdurasi = new javax.swing.JTextField();
        button = new javax.swing.JPanel();
        btndelete2 = new javax.swing.JButton();
        btnkeluar2 = new javax.swing.JButton();
        btntambah2 = new javax.swing.JButton();
        btnupdate2 = new javax.swing.JButton();
        btnreset2 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_proyek = new javax.swing.JTable();
        BG1 = new javax.swing.JLabel();
        hal3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cbxkaryawan = new javax.swing.JComboBox<>();
        cbxproyek = new javax.swing.JComboBox<>();
        txtperan = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btndelete3 = new javax.swing.JButton();
        btnkeluar3 = new javax.swing.JButton();
        btntambah3 = new javax.swing.JButton();
        btnupdate3 = new javax.swing.JButton();
        btnreset3 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        BG2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabbedPaneCustom1.setBackground(new java.awt.Color(255, 153, 0));

        hal1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtnama.setBackground(new java.awt.Color(204, 204, 255));
        hal1.add(txtnama, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 100, 260, 40));

        jLabel4.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel4.setText("DEPARTEMEN");
        hal1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 130, 19));

        jLabel5.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel5.setText("NAMA");
        hal1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 110, 60, 19));

        jLabel6.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel6.setText("Jabatan");
        hal1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 90, 19));

        txtjabatan.setBackground(new java.awt.Color(204, 204, 255));
        hal1.add(txtjabatan, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 150, 260, 40));

        txtdepartemen.setBackground(new java.awt.Color(204, 204, 255));
        hal1.add(txtdepartemen, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 260, 40));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new java.awt.GridBagLayout());

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 40;
        jPanel6.add(btndelete, gridBagConstraints);

        btnkeluar.setBackground(new java.awt.Color(255, 0, 51));
        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = 40;
        jPanel6.add(btnkeluar, gridBagConstraints);

        btnupdate.setBackground(new java.awt.Color(51, 255, 51));
        btnupdate.setText("Update");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 6;
        gridBagConstraints.ipady = 40;
        jPanel6.add(btnupdate, gridBagConstraints);

        btntambah.setBackground(new java.awt.Color(0, 255, 0));
        btntambah.setText("Tambah");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipady = 40;
        jPanel6.add(btntambah, gridBagConstraints);

        btnreset.setBackground(new java.awt.Color(255, 255, 51));
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipady = 40;
        jPanel6.add(btnreset, gridBagConstraints);

        hal1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 480, 80));

        jPanel4.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane2.setBackground(new java.awt.Color(0, 255, 0));

        tbl_karyawan.setBackground(new java.awt.Color(255, 204, 204));
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
        tbl_karyawan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_karyawanMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_karyawan);

        jPanel4.add(jScrollPane2);

        hal1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 500, 440));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modull5/1.png"))); // NOI18N
        hal1.add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 570, 820));

        tabbedPaneCustom1.addTab("Form Karyawan", hal1);

        hal2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel1.setText("DURASI/MINGGU");
        hal2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 150, -1));

        jLabel2.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel2.setText("NAMA proyek");
        hal2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 150, -1));

        txtproyek.setBackground(new java.awt.Color(204, 204, 255));
        hal2.add(txtproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 152, 220, 40));

        txtdurasi.setBackground(new java.awt.Color(204, 204, 255));
        hal2.add(txtdurasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 220, 40));

        button.setBackground(new java.awt.Color(255, 255, 255));
        button.setLayout(new java.awt.GridBagLayout());

        btndelete2.setBackground(new java.awt.Color(255, 0, 0));
        btndelete2.setText("Delete");
        btndelete2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        button.add(btndelete2, gridBagConstraints);

        btnkeluar2.setBackground(new java.awt.Color(255, 0, 51));
        btnkeluar2.setText("Keluar");
        btnkeluar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluar2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        button.add(btnkeluar2, gridBagConstraints);

        btntambah2.setBackground(new java.awt.Color(0, 255, 0));
        btntambah2.setText("Tambah");
        btntambah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        button.add(btntambah2, gridBagConstraints);

        btnupdate2.setBackground(new java.awt.Color(51, 255, 51));
        btnupdate2.setText("Update");
        btnupdate2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        button.add(btnupdate2, gridBagConstraints);

        btnreset2.setBackground(new java.awt.Color(255, 255, 0));
        btnreset2.setText("Reset");
        btnreset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset2ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        button.add(btnreset2, gridBagConstraints);

        hal2.add(button, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 250, 460, 60));

        jPanel1.setLayout(new java.awt.GridLayout(1, 0));

        tbl_proyek.setBackground(new java.awt.Color(255, 204, 204));
        tbl_proyek.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_proyek.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_proyekMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_proyek);

        jPanel1.add(jScrollPane1);

        hal2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, 500, 430));

        BG1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modull5/2.png"))); // NOI18N
        hal2.add(BG1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 570, 820));

        tabbedPaneCustom1.addTab("Form Proyek", hal2);

        hal3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel3.setText("peran");
        hal3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 160, -1));

        jLabel7.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel7.setText("NAMA KARYAWAN");
        hal3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 140, 180, -1));

        jLabel8.setFont(new java.awt.Font("Sirukota", 1, 24)); // NOI18N
        jLabel8.setText("NAMA Proyek");
        hal3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, 180, -1));

        cbxkaryawan.setBackground(new java.awt.Color(204, 204, 255));
        cbxkaryawan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxkaryawanActionPerformed(evt);
            }
        });
        hal3.add(cbxkaryawan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 250, 40));

        cbxproyek.setBackground(new java.awt.Color(204, 204, 255));
        hal3.add(cbxproyek, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, 250, 40));

        txtperan.setBackground(new java.awt.Color(204, 204, 255));
        txtperan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtperanActionPerformed(evt);
            }
        });
        hal3.add(txtperan, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 250, 50));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        btndelete3.setBackground(new java.awt.Color(255, 0, 0));
        btndelete3.setText("Delete");
        btndelete3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndelete3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        jPanel2.add(btndelete3, gridBagConstraints);

        btnkeluar3.setBackground(new java.awt.Color(255, 0, 0));
        btnkeluar3.setText("Keluar");
        btnkeluar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluar3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        jPanel2.add(btnkeluar3, gridBagConstraints);

        btntambah3.setBackground(new java.awt.Color(0, 255, 0));
        btntambah3.setText("Tambah");
        btntambah3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambah3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        jPanel2.add(btntambah3, gridBagConstraints);

        btnupdate3.setBackground(new java.awt.Color(51, 255, 51));
        btnupdate3.setText("Update");
        btnupdate3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdate3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        jPanel2.add(btnupdate3, gridBagConstraints);

        btnreset3.setBackground(new java.awt.Color(255, 255, 0));
        btnreset3.setText("Reset");
        btnreset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnreset3ActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipady = 40;
        jPanel2.add(btnreset3, gridBagConstraints);

        hal3.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 480, 80));

        jPanel3.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane3.setBackground(new java.awt.Color(255, 204, 204));

        tbl_transaksi.setBackground(new java.awt.Color(255, 204, 204));
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbl_transaksi);

        jPanel3.add(jScrollPane3);

        hal3.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 500, 400));

        BG2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modull5/3.png"))); // NOI18N
        hal3.add(BG2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 570, 820));

        tabbedPaneCustom1.addTab("Form Transaksi Proyek", hal3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.PREFERRED_SIZE, 757, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        keluar();
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
     try {
            // Memuat ikon
            ImageIcon icon = new ImageIcon(getClass().getResource("/modull5/delete.png"));
            ImageIcon icon2 = new ImageIcon(getClass().getResource("/modull5/info.png"));
            // Meminta input ID dari pengguna
            String input = (String) JOptionPane.showInputDialog(null, 
                "Silakan Masukkan ID", 
                "HAPUS DATA", 
                JOptionPane.PLAIN_MESSAGE, 
                icon, 
                null, 
                null);

            if (input != null && !input.trim().isEmpty()) {
                int id = Integer.parseInt(input);

                // Periksa apakah data dengan ID yang dimasukkan ada di dalam tabel
                String checkSql = "SELECT COUNT(*) FROM karyawan WHERE id = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setInt(1, id);

                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                    // Jika data ditemukan, minta konfirmasi untuk menghapus
                    int confirm = JOptionPane.showConfirmDialog(null, 
                        "Apakah Anda yakin ingin menghapus data ini?", 
                        "Konfirmasi Hapus", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        // Eksekusi query DELETE
                        String deleteSql = "DELETE FROM karyawan WHERE id = ?";
                        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
                        deleteStmt.setInt(1, id);
                        deleteStmt.executeUpdate();
                        
                        
                      
                        conn.prepareStatement("SET @count = 0;").execute();
                        conn.prepareStatement("UPDATE karyawan SET id = @count := @count + 1;").executeUpdate();
                        conn.prepareStatement("ALTER TABLE karyawan AUTO_INCREMENT = 1;").execute();

                    
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "KONFIRMASI", JOptionPane.INFORMATION_MESSAGE, icon2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Penghapusan dibatalkan.");
                    }
                } else {
                    // Jika data tidak ditemukan, beri tahu pengguna
                    JOptionPane.showMessageDialog(null, "Data dengan ID tersebut tidak ditemukan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE, icon2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ID tidak valid atau tidak diisi.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE, icon2);
            }
            loadData();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }                                         

    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed
        // TODO add your handling code here:
        try {
    int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
        if (txtnama.getText().isEmpty() || txtjabatan.getText().isEmpty() || txtdepartemen.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Pastikan semua data telah diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            String sql = "UPDATE karyawan SET nama = ?, jabatan = ?, departemen = ? WHERE id = ?";
            java.sql.Connection conn = Koneksi.getConnection();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, txtnama.getText());
            pst.setString(2, txtjabatan.getText());
            pst.setString(3, txtdepartemen.getText());
            pst.setString(4, idKaryawan);  // idKaryawan untuk menentukan baris yang akan diupdate

            
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

            loadData();  
        }
    }
} catch (Exception e) {
    JOptionPane.showMessageDialog(this, "Terjadi kesalahan: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_btnupdateActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        txtnama.setText("");
        txtjabatan.setText("");
        txtdepartemen.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        try {
    if (txtnama.getText().isEmpty() || txtjabatan.getText().isEmpty() || txtdepartemen.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Pastikan semua data telah diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        String sql = "INSERT INTO karyawan (nama, jabatan, departemen) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txtnama.getText());
        ps.setString(2, txtjabatan.getText());
        ps.setString(3, txtdepartemen.getText());
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        loadData();
        // data();
    }
} catch (SQLException e) {
    System.out.println("Error Save Data: " + e.getMessage());
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
}

    }//GEN-LAST:event_btntambahActionPerformed

    private void tbl_karyawanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_karyawanMouseClicked
        // TODO add your handling code here:
        int row = tbl_karyawan.getSelectedRow(); 
        
        if (row != -1) {
            
            idKaryawan = tbl_karyawan.getValueAt(row, 0).toString();
            txtnama.setText(tbl_karyawan.getValueAt(row, 1).toString());
            txtjabatan.setText(tbl_karyawan.getValueAt(row, 2).toString());        
            txtdepartemen.setText(tbl_karyawan.getValueAt(row, 3).toString());        
        }
    }//GEN-LAST:event_tbl_karyawanMouseClicked

    private void btntambah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah2ActionPerformed
        // TODO add your handling code here:
        try {
    if (txtproyek.getText().isEmpty() || txtdurasi.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Pastikan semua data telah diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        // Menyiapkan query SQL untuk insert
        String sql = "INSERT INTO proyek (nama_proyek, durasi_pengerjaan) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, txtproyek.getText());
        ps.setString(2, txtdurasi.getText());
        ps.executeUpdate();
        
        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        loadData2();
        // data();
    }
} catch (SQLException e) {
    System.out.println("Error Save Data: " + e.getMessage());
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btntambah2ActionPerformed

    private void btndelete2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete2ActionPerformed
        // TODO add your handling code here:
         try {
            // Memuat ikon
            ImageIcon icon = new ImageIcon(getClass().getResource("/modull5/delete.png"));
            ImageIcon icon2 = new ImageIcon(getClass().getResource("/modull5/info.png"));
            // Meminta input ID dari pengguna
            String input = (String) JOptionPane.showInputDialog(null, 
                "Silakan Masukkan ID", 
                "HAPUS DATA", 
                JOptionPane.PLAIN_MESSAGE, 
                icon, 
                null, 
                null);

            if (input != null && !input.trim().isEmpty()) {
                int id = Integer.parseInt(input);

                // Periksa apakah data dengan ID yang dimasukkan ada di dalam tabel
                String checkSql = "SELECT COUNT(*) FROM proyek WHERE id = ?";
                PreparedStatement checkStmt = conn.prepareStatement(checkSql);
                checkStmt.setInt(1, id);

                ResultSet rs = checkStmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);

                if (count > 0) {
                    // Jika data ditemukan, minta konfirmasi untuk menghapus
                    int confirm = JOptionPane.showConfirmDialog(null, 
                        "Apakah Anda yakin ingin menghapus data ini?", 
                        "Konfirmasi Hapus", 
                        JOptionPane.YES_NO_OPTION, 
                        JOptionPane.WARNING_MESSAGE);

                    if (confirm == JOptionPane.YES_OPTION) {
                        // Eksekusi query DELETE
                        String deleteSql = "DELETE FROM proyek WHERE id = ?";
                        PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
                        deleteStmt.setInt(1, id);
                        deleteStmt.executeUpdate();
                        
                        
                      
                        conn.prepareStatement("SET @count = 0;").execute();
                        conn.prepareStatement("UPDATE proyek SET id = @count := @count + 1;").executeUpdate();
                        conn.prepareStatement("ALTER TABLE proyek AUTO_INCREMENT = 1;").execute();

                    
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "KONFIRMASI", JOptionPane.INFORMATION_MESSAGE, icon2);
                    } else {
                        JOptionPane.showMessageDialog(null, "Penghapusan dibatalkan.");
                    }
                } else {
                    // Jika data tidak ditemukan, beri tahu pengguna
                    JOptionPane.showMessageDialog(null, "Data dengan ID tersebut tidak ditemukan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE, icon2);
                }
            } else {
                JOptionPane.showMessageDialog(null, "ID tidak valid atau tidak diisi.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE, icon2);
            }
            loadData2();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }                                         
    }//GEN-LAST:event_btndelete2ActionPerformed

    private void tbl_proyekMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_proyekMouseClicked
        // TODO add your handling code here:
        int row = tbl_proyek.getSelectedRow(); 
        
        if (row != -1) {
            
            idProyek = tbl_proyek.getValueAt(row, 0).toString();
            txtproyek.setText(tbl_proyek.getValueAt(row, 1).toString());
            txtdurasi.setText(tbl_proyek.getValueAt(row, 2).toString());                
        }
    }//GEN-LAST:event_tbl_proyekMouseClicked

    private void btnupdate2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate2ActionPerformed
        // TODO add your handling code here:
        try {
            int confirm = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menyimpan perubahan data ini?", "Konfirmasi Perubahan", JOptionPane.YES_NO_OPTION);

            if (confirm == JOptionPane.YES_OPTION) {
                String sql = "UPDATE proyek SET nama_proyek = ?, durasi_pengerjaan = ? WHERE id = ?";
                java.sql.Connection conn = (Connection) Koneksi.getConnection();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                
                pst.setString(1, txtproyek.getText());
                pst.setString(2, txtdurasi.getText());
                pst.setString(3, idProyek);

                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Data Berhasil Diupdate");

                loadData2(); 
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnupdate2ActionPerformed

    private void btnreset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset2ActionPerformed
        // TODO add your handling code here:
        txtproyek.setText(null);
        txtdurasi.setText(null);
    }//GEN-LAST:event_btnreset2ActionPerformed

    private void btnkeluar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluar2ActionPerformed
        // TODO add your handling code here:
        keluar();
    }//GEN-LAST:event_btnkeluar2ActionPerformed

    private void btntambah3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambah3ActionPerformed
        // TODO add your handling code here:
         try {
    // Mengecek apakah semua field sudah terisi
    if (cbxkaryawan.getSelectedItem() == null || cbxproyek.getSelectedItem() == null || txtperan.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Pastikan semua data telah diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
    } else {
        // Menyiapkan query SQL untuk mendapatkan id karyawan
        String sqlKaryawan = "SELECT id FROM karyawan WHERE nama = ?";
        PreparedStatement psKaryawan = conn.prepareStatement(sqlKaryawan);
        psKaryawan.setString(1, cbxkaryawan.getSelectedItem().toString());
        ResultSet rsKaryawan = psKaryawan.executeQuery();
        
        int idkaryawan = 0;
        if (rsKaryawan.next()) {
            idkaryawan = rsKaryawan.getInt("id");
        }

        // Menyiapkan query SQL untuk mendapatkan id proyek
        String sqlProyek = "SELECT id FROM proyek WHERE nama_proyek = ?";
        PreparedStatement psProyek = conn.prepareStatement(sqlProyek);
        psProyek.setString(1, cbxproyek.getSelectedItem().toString());
        ResultSet rsProyek = psProyek.executeQuery();
        
        int idproyek = 0;
        if (rsProyek.next()) {
            idproyek = rsProyek.getInt("id");
        }

        // Menyiapkan query SQL untuk insert ke tabel transaksi
        String sqlInsert = "INSERT INTO transaksi (id_karyawan, id_proyek, peran) VALUES (?, ?, ?)";
        PreparedStatement psInsert = conn.prepareStatement(sqlInsert);
        psInsert.setInt(1, idkaryawan);
        psInsert.setInt(2, idproyek);
        psInsert.setString(3, txtperan.getText());
        psInsert.executeUpdate();

        JOptionPane.showMessageDialog(null, "Data berhasil disimpan!", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
        loadData3();
    }
} catch (SQLException e) {
    System.out.println("Error Save Data: " + e.getMessage());
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan saat menyimpan data: " + e.getMessage(), "Kesalahan", JOptionPane.ERROR_MESSAGE);
}
    }//GEN-LAST:event_btntambah3ActionPerformed

    private void txtperanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtperanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtperanActionPerformed

    private void cbxkaryawanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxkaryawanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxkaryawanActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        // TODO add your handling code here:
        int row = tbl_transaksi.getSelectedRow(); 
        
        if (row != -1) {
            
            cbxkaryawan.setSelectedItem(tbl_transaksi.getValueAt(row, 0).toString());                
            cbxproyek.setSelectedItem(tbl_transaksi.getValueAt(row, 1).toString());
            txtperan.setText(tbl_transaksi.getValueAt(row, 2).toString());                
        }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void btnreset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnreset3ActionPerformed
        // TODO add your handling code here:
        cbxkaryawan.setSelectedItem(null);
        cbxproyek.setSelectedItem(null);
        txtperan.setText(null);
    }//GEN-LAST:event_btnreset3ActionPerformed

    private void btnkeluar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluar3ActionPerformed
        // TODO add your handling code here:
        keluar();
    }//GEN-LAST:event_btnkeluar3ActionPerformed

    private void btndelete3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndelete3ActionPerformed
        // TODO add your handling code here:
    try {
            // Memuat ikon
            ImageIcon iconDelete = new ImageIcon(getClass().getResource("/modull5/delete.png"));
            ImageIcon iconInfo = new ImageIcon(getClass().getResource("/modull5/info.png"));

            // Meminta input nama karyawan dan nama proyek dari pengguna
            String selectedKaryawan = String.valueOf(JOptionPane.showInputDialog(null, "Masukkan nama karyawan:", "Input Nama Karyawan", JOptionPane.INFORMATION_MESSAGE, iconDelete, null, null));
            String selectedProyek = String.valueOf(JOptionPane.showInputDialog(null, "Masukkan nama proyek:", "Input Nama Proyek", JOptionPane.QUESTION_MESSAGE));

            if (selectedKaryawan == null || selectedProyek == null || selectedKaryawan.trim().isEmpty() || selectedProyek.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nama karyawan dan nama proyek harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            // Mendapatkan id_karyawan berdasarkan nama karyawan
            String sqlKaryawan = "SELECT id FROM karyawan WHERE Nama = ?";
            PreparedStatement psKaryawan = conn.prepareStatement(sqlKaryawan);
            psKaryawan.setString(1, selectedKaryawan);
            ResultSet rsKaryawan = psKaryawan.executeQuery();
            int idKaryawan = -1;
            if (rsKaryawan.next()) {
                idKaryawan = rsKaryawan.getInt("id");
            }

            // Mendapatkan id_proyek berdasarkan nama proyek
            String sqlProyek = "SELECT id FROM proyek WHERE Nama_Proyek = ?";
            PreparedStatement psProyek = conn.prepareStatement(sqlProyek);
            psProyek.setString(1, selectedProyek);
            ResultSet rsProyek = psProyek.executeQuery();
            int idProyek = -1;
            if (rsProyek.next()) {
                idProyek = rsProyek.getInt("id");
            }

            // Pastikan id_karyawan dan id_proyek ditemukan
            if (idKaryawan != -1 && idProyek != -1) {
                // Konfirmasi penghapusan
                int confirm = JOptionPane.showConfirmDialog(null,
                        "Apakah Anda yakin ingin menghapus data untuk karyawan " + selectedKaryawan +
                        " pada proyek " + selectedProyek + "?",
                        "Konfirmasi Hapus",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                if (confirm == JOptionPane.YES_OPTION) {
                    // Eksekusi query DELETE berdasarkan id_karyawan dan id_proyek
                    String deleteSql = "DELETE FROM transaksi WHERE id_karyawan = ? AND id_proyek = ?";
                    PreparedStatement deleteStmt = conn.prepareStatement(deleteSql);
                    deleteStmt.setInt(1, idKaryawan);
                    deleteStmt.setInt(2, idProyek);
                    int rowsDeleted = deleteStmt.executeUpdate();

                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "Data berhasil dihapus!", "KONFIRMASI", JOptionPane.INFORMATION_MESSAGE, iconInfo);
                    } else {
                        JOptionPane.showMessageDialog(null, "Data tidak ditemukan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE, iconInfo);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Penghapusan dibatalkan.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Data karyawan atau proyek tidak ditemukan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE, iconInfo);
            }

            // Refresh data setelah penghapusan
            loadtransaksi();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
        }
        
    }//GEN-LAST:event_btndelete3ActionPerformed

    private void btnupdate3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdate3ActionPerformed
        // TODO add your handling code here:                                            
   try {
    // Meminta input nama karyawan, nama proyek, dan peran baru dari pengguna
    String selectedKaryawan = JOptionPane.showInputDialog(null, "Masukkan nama karyawan:", "Input Nama Karyawan", JOptionPane.INFORMATION_MESSAGE);
    String selectedProyek = JOptionPane.showInputDialog(null, "Masukkan nama proyek:", "Input Nama Proyek", JOptionPane.INFORMATION_MESSAGE);
    String newRole = JOptionPane.showInputDialog(null, "Masukkan peran baru:", "Input Peran Baru", JOptionPane.INFORMATION_MESSAGE);

    // Validasi input
    if (selectedKaryawan == null || selectedProyek == null || newRole == null ||
        selectedKaryawan.trim().isEmpty() || selectedProyek.trim().isEmpty() || newRole.trim().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Semua data harus diisi!", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }

    // Mendapatkan id_karyawan berdasarkan nama karyawan
    String sqlKaryawan = "SELECT id FROM karyawan WHERE Nama = ?";
    PreparedStatement psKaryawan = conn.prepareStatement(sqlKaryawan);
    psKaryawan.setString(1, selectedKaryawan);
    ResultSet rsKaryawan = psKaryawan.executeQuery();
    int idKaryawan = -1;
    if (rsKaryawan.next()) {
        idKaryawan = rsKaryawan.getInt("id");
    }

    // Mendapatkan id_proyek berdasarkan nama proyek
    String sqlProyek = "SELECT id FROM proyek WHERE Nama_Proyek = ?";
    PreparedStatement psProyek = conn.prepareStatement(sqlProyek);
    psProyek.setString(1, selectedProyek);
    ResultSet rsProyek = psProyek.executeQuery();
    int idProyek = -1;
    if (rsProyek.next()) {
        idProyek = rsProyek.getInt("id");
    }

    // Pastikan id_karyawan dan id_proyek ditemukan
    if (idKaryawan != -1 && idProyek != -1) {
        // Konfirmasi pembaruan
        int confirm = JOptionPane.showConfirmDialog(null,
                "Apakah Anda yakin ingin mengupdate peran karyawan " + selectedKaryawan +
                " pada proyek " + selectedProyek + " menjadi " + newRole + "?",
                "Konfirmasi Update",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirm == JOptionPane.YES_OPTION) {
            // Eksekusi query UPDATE untuk memperbarui peran di database
            String updateSql = "UPDATE transaksi SET peran = ? WHERE id_karyawan = ? AND id_proyek = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateSql);
            updateStmt.setString(1, newRole);
            updateStmt.setInt(2, idKaryawan);
            updateStmt.setInt(3, idProyek);
            int rowsUpdated = updateStmt.executeUpdate();

            if (rowsUpdated > 0) {
                // Update tampilan GUI jika perlu
                txtperan.setText(newRole);
                JOptionPane.showMessageDialog(null, "Data berhasil diupdate!", "KONFIRMASI", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Pembaruan dibatalkan.");
        }
    } else {
        JOptionPane.showMessageDialog(null, "Data karyawan atau proyek tidak ditemukan.", "INFORMASI", JOptionPane.INFORMATION_MESSAGE);
    }

} catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Terjadi kesalahan: " + e.getMessage());
}
    loadData3();
    }//GEN-LAST:event_btnupdate3ActionPerformed

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
    private javax.swing.JLabel BG;
    private javax.swing.JLabel BG1;
    private javax.swing.JLabel BG2;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btndelete2;
    private javax.swing.JButton btndelete3;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkeluar2;
    private javax.swing.JButton btnkeluar3;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnreset2;
    private javax.swing.JButton btnreset3;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntambah2;
    private javax.swing.JButton btntambah3;
    private javax.swing.JButton btnupdate;
    private javax.swing.JButton btnupdate2;
    private javax.swing.JButton btnupdate3;
    private javax.swing.JPanel button;
    private javax.swing.JComboBox<String> cbxkaryawan;
    private javax.swing.JComboBox<String> cbxproyek;
    private javax.swing.JPanel hal1;
    private javax.swing.JPanel hal2;
    private javax.swing.JPanel hal3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private Efek.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTable tbl_karyawan;
    private javax.swing.JTable tbl_proyek;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JTextField txtdepartemen;
    private javax.swing.JTextField txtdurasi;
    private javax.swing.JTextField txtjabatan;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtperan;
    private javax.swing.JTextField txtproyek;
    // End of variables declaration//GEN-END:variables
}
