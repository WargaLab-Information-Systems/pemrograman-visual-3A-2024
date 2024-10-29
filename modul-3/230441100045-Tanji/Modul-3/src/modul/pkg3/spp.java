package modul.pkg3;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class spp extends javax.swing.JFrame {
    private DefaultTableModel modelTbl; // Menggunakan DefaultTableModel
//    private JCheckBox aa, bb, cc, dd, ee, ff, gg, hh, ii, jj, kk, ll;
    public spp() {
        initComponents();
        setLocationRelativeTo(null);
        modelTbl = new DefaultTableModel(new String[]{"Nama", "Bulan", "Absen", "Nominal", "Status"}, 0);
        tbl.setModel(modelTbl);

        }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        nama = new javax.swing.JTextField();
        nominal = new javax.swing.JTextField();
        absen = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        btnBayar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        aa = new javax.swing.JCheckBox();
        bb = new javax.swing.JCheckBox();
        cc = new javax.swing.JCheckBox();
        dd = new javax.swing.JCheckBox();
        ee = new javax.swing.JCheckBox();
        ff = new javax.swing.JCheckBox();
        gg = new javax.swing.JCheckBox();
        hh = new javax.swing.JCheckBox();
        ii = new javax.swing.JCheckBox();
        jj = new javax.swing.JCheckBox();
        kk = new javax.swing.JCheckBox();
        ll = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 31, 63));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel7.setText("PEMBAYARAN SPP ");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 20, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 1230, 60));

        jPanel3.setBackground(new java.awt.Color(255, 255, 51));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Nama :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel1, gridBagConstraints);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Absen :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Nominal :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel4, gridBagConstraints);

        nama.setMinimumSize(new java.awt.Dimension(160, 22));
        nama.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(nama, gridBagConstraints);

        nominal.setPreferredSize(new java.awt.Dimension(150, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(nominal, gridBagConstraints);

        absen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih !", "1", "2", "3", "4", "5", "6", "7", "8" }));
        absen.setMinimumSize(new java.awt.Dimension(82, 22));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(absen, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setText("INPUT DATA SISWA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 12;
        gridBagConstraints.ipady = 12;
        jPanel3.add(jLabel6, gridBagConstraints);

        btnBayar.setText("Bayar");
        btnBayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBayarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 5;
        gridBagConstraints.ipady = 5;
        jPanel3.add(btnBayar, gridBagConstraints);

        jLabel8.setText("Bulan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jLabel8, gridBagConstraints);

        aa.setText("Januari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(aa, gridBagConstraints);

        bb.setText("februari");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(bb, gridBagConstraints);

        cc.setText("Maret");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(cc, gridBagConstraints);

        dd.setText("April");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(dd, gridBagConstraints);

        ee.setText("Mei");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(ee, gridBagConstraints);

        ff.setText("Juni");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(ff, gridBagConstraints);

        gg.setText("Juli");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(gg, gridBagConstraints);

        hh.setText("Agustus");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(hh, gridBagConstraints);

        ii.setText("September");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(ii, gridBagConstraints);

        jj.setText("Oktober");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(jj, gridBagConstraints);

        kk.setText("November");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(kk, gridBagConstraints);

        ll.setText("Desember");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel3.add(ll, gridBagConstraints);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 400, 270));

        jPanel4.setBackground(new java.awt.Color(209, 233, 246));

        tbl.setBackground(new java.awt.Color(255, 221, 255));
        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nama", "Bulan", "Absen", "Nominal", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tbl.setPreferredSize(new java.awt.Dimension(450, 100));
        jScrollPane1.setViewportView(tbl);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 808, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 820, 270));

        jPanel5.setBackground(new java.awt.Color(255, 255, 51));
        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 1230, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBayarActionPerformed
        String selectedOptions = "";
        String Nama = nama.getText();
        String Absen = absen.getSelectedItem().toString();
        int bulanCount = 0; // Menghitung jumlah bulan yang dipilih
        
        // Menghitung jumlah bulan yang dipilih berdasarkan checkbox
        if (aa.isSelected()) bulanCount++;
        if (bb.isSelected()) bulanCount++;
        if (cc.isSelected()) bulanCount++;
        if (dd.isSelected()) bulanCount++;
        if (ee.isSelected()) bulanCount++;
        if (ff.isSelected()) bulanCount++;
        if (gg.isSelected()) bulanCount++;
        if (hh.isSelected()) bulanCount++;
        if (ii.isSelected()) bulanCount++;
        if (jj.isSelected()) bulanCount++;
        if (kk.isSelected()) bulanCount++;
        if (ll.isSelected()) bulanCount++;

        String Bulan = bulanCount > 0 ? bulanCount + " Bulan" : 
                "Tidak ada bulan yang dipilih";
        String NominalStr = nominal.getText();
        
        // Validasi dan konversi nominal
        int Nominal = 0;
        try {
            Nominal = Integer.parseInt(NominalStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Nominal harus berupa angka.", 
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Menentukan status
        String Status;
        if (bulanCount > 1 && Nominal % 100000 == 0) {
            Status = "LUNAS";
        } else {
            Status = "NUNGGAK";
        }

        // Menambah baris ke tabel
        modelTbl.addRow(new Object[]{Nama, Bulan, Absen, Nominal, Status});

        nama.setText("");
        absen.setSelectedItem("PILIH");
        nominal.setText("");
        aa.setSelected(false);
        bb.setSelected(false);
        cc.setSelected(false);
        dd.setSelected(false);
        ee.setSelected(false);
        ff.setSelected(false);
        gg.setSelected(false);
        hh.setSelected(false);
        ii.setSelected(false);
        jj.setSelected(false);
        kk.setSelected(false);
        ll.setSelected(false);
    }//GEN-LAST:event_btnBayarActionPerformed

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
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(spp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new spp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox aa;
    private javax.swing.JComboBox<String> absen;
    private javax.swing.JCheckBox bb;
    private javax.swing.JButton btnBayar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JCheckBox cc;
    private javax.swing.JCheckBox dd;
    private javax.swing.JCheckBox ee;
    private javax.swing.JCheckBox ff;
    private javax.swing.JCheckBox gg;
    private javax.swing.JCheckBox hh;
    private javax.swing.JCheckBox ii;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox jj;
    private javax.swing.JCheckBox kk;
    private javax.swing.JCheckBox ll;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField nominal;
    private javax.swing.JTable tbl;
    // End of variables declaration//GEN-END:variables
}
