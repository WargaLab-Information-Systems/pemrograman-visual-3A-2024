package percobaan;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.synth.SynthLookAndFeel;
import javax.swing.border.*;

public class coba_cobabosss extends javax.swing.JFrame {
    String name,tahal,asalsekolah,notelp,namaortu,pekortu,jeniskelamin,kelas;
    public coba_cobabosss() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jBBatal = new javax.swing.JButton();
        jBReset = new javax.swing.JButton();
        jBSimpan = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jCKelas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rb_Laki = new javax.swing.JRadioButton();
        rb_Perempuan = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTNama = new javax.swing.JTextField();
        jTLahir = new javax.swing.JTextField();
        jTSekolah = new javax.swing.JTextField();
        jTTelpon = new javax.swing.JTextField();
        jTOrtu = new javax.swing.JTextField();
        jTPek = new javax.swing.JTextField();
        untukAllert = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(23, 59, 69));

        jPanel2.setBackground(new java.awt.Color(248, 237, 237));

        jBBatal.setBackground(new java.awt.Color(102, 102, 102));
        jBBatal.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jBBatal.setForeground(new java.awt.Color(255, 255, 255));
        jBBatal.setText("Batal");
        jBBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBBatalActionPerformed(evt);
            }
        });

        jBReset.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jBReset.setForeground(new java.awt.Color(255, 255, 0));
        jBReset.setText("Reset");
        jBReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBResetActionPerformed(evt);
            }
        });

        jBSimpan.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jBSimpan.setForeground(new java.awt.Color(255, 255, 255));
        jBSimpan.setText("Simpan");
        jBSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBSimpanActionPerformed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(0, 0, 0));
        jCheckBox1.setText("Data yang anda masukkan sudah benar?");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        jCKelas.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jCKelas.setForeground(new java.awt.Color(255, 255, 255));
        jCKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kelas 1", "Kelas 2", "Kelas 3", "Kelas 4", "Kelas 5", "Kelas 6" }));

        jLabel2.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nama Lengkap");

        jLabel3.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Tanggal Lahir");

        jLabel4.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Asal Sekolah");

        buttonGroup1.add(rb_Laki);
        rb_Laki.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        rb_Laki.setForeground(new java.awt.Color(0, 0, 0));
        rb_Laki.setText("L");
        rb_Laki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rb_LakiActionPerformed(evt);
            }
        });

        buttonGroup1.add(rb_Perempuan);
        rb_Perempuan.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        rb_Perempuan.setForeground(new java.awt.Color(0, 0, 0));
        rb_Perempuan.setText("P");

        jLabel5.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Kelas");

        jLabel7.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("No Telpon");

        jLabel8.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Nama Orang Tua");

        jLabel9.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Pekerjaan Orang Tua");

        jTNama.setBackground(new java.awt.Color(23, 59, 69));
        jTNama.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N

        jTLahir.setBackground(new java.awt.Color(23, 59, 69));
        jTLahir.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N

        jTSekolah.setBackground(new java.awt.Color(23, 59, 69));
        jTSekolah.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N

        jTTelpon.setBackground(new java.awt.Color(23, 59, 69));
        jTTelpon.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N

        jTOrtu.setBackground(new java.awt.Color(23, 59, 69));
        jTOrtu.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N

        jTPek.setBackground(new java.awt.Color(23, 59, 69));
        jTPek.setFont(new java.awt.Font("Futura Bk BT", 0, 12)); // NOI18N

        untukAllert.setFont(new java.awt.Font("Futura Lt BT", 0, 12)); // NOI18N
        untukAllert.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jCheckBox1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jBBatal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBReset)
                        .addGap(187, 187, 187)
                        .addComponent(jBSimpan)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(32, 32, 32))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel3))
                                    .addGap(40, 40, 40)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel7))
                                .addGap(72, 72, 72)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTSekolah, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                    .addComponent(jTLahir))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(rb_Laki)
                                        .addGap(18, 18, 18)
                                        .addComponent(rb_Perempuan))
                                    .addComponent(jCKelas, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jTNama)
                            .addComponent(jTTelpon)
                            .addComponent(jTOrtu)
                            .addComponent(jTPek))
                        .addGap(29, 29, 29))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(untukAllert)
                .addGap(324, 324, 324))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(untukAllert)
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(rb_Laki)
                    .addComponent(rb_Perempuan)
                    .addComponent(jLabel5)
                    .addComponent(jTLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jCKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTSekolah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTTelpon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTOrtu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jTPek, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 49, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBBatal)
                    .addComponent(jBReset)
                    .addComponent(jBSimpan))
                .addGap(27, 27, 27))
        );

        jLabel1.setFont(new java.awt.Font("Futura", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORMULIR PENDAFTARAN BIMBEL ABC");

        jLabel10.setFont(new java.awt.Font("Futura Lt BT", 0, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Jl. Sawah Besar No.28 RT.016/RW.010, Kel.Pademangan Besar, Kec.Pademangan, Kota Jakarta Utara");

        jLabel11.setFont(new java.awt.Font("Futura Lt BT", 0, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("DKI Jakarta");

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\ya991\\Downloads\\—Pngtree—english characters abc color_1659862.png")); // NOI18N

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\ya991\\Downloads\\—Pngtree—english characters abc color_1659862.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(69, 69, 69))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addGap(221, 221, 221)))
                        .addComponent(jLabel14)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11)
                                .addGap(8, 8, 8))
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rb_LakiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rb_LakiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rb_LakiActionPerformed

    private void jBBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBBatalActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_jBBatalActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jBResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBResetActionPerformed
        // TODO add your handling code here:
        jTNama.setText("");
        jTLahir.setText("");
        jTSekolah.setText("");
        jTTelpon.setText("");
        jTOrtu.setText("");
        jTPek.setText("");
        buttonGroup1.clearSelection();
        jCKelas.setSelectedIndex(0);
        
    }//GEN-LAST:event_jBResetActionPerformed

    private void jBSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBSimpanActionPerformed
        // TODO add your handling code here:
        
        if (jCheckBox1.isSelected()){
        name = jTNama.getText();
        tahal = jTLahir.getText();
        asalsekolah = jTSekolah.getText();
        notelp = jTTelpon.getText();
        namaortu = jTOrtu.getText();
        pekortu = jTPek.getText();
        
        if (rb_Laki.isSelected()){
            jeniskelamin = "Laki-laki";
        }
        else if (rb_Perempuan.isSelected()){
            jeniskelamin = "Perempuan";
        } else {
            jeniskelamin = "";
        }
        
        kelas = jCKelas.getSelectedItem().toString();
        if (!name.isEmpty() && !tahal.isBlank() && !asalsekolah.isEmpty() && !notelp.isEmpty() && !namaortu.isEmpty() 
                && !pekortu.isEmpty() && !jeniskelamin.isEmpty() && !kelas.isEmpty()) {
            
            cobalagi b = new cobalagi(name, tahal, asalsekolah, notelp, namaortu, pekortu, jeniskelamin, kelas);
            b.setVisible(true);
            dispose();
            
        } else {
            JOptionPane.showMessageDialog(this, "Isi dulu bro!", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "Data tidak dapat disimpan. Silakan centang kotak yang telah disediakan.", "WARNING", JOptionPane.WARNING_MESSAGE);
    }
        
        
    }//GEN-LAST:event_jBSimpanActionPerformed
    
    public static void main(String args[]) {
        try {
            // Menggunakan FlatMacDarkLaf dengan memanggil metode setup()
            UIManager.setLookAndFeel(new FlatMacDarkLaf());
            UIManager.put( "Button.arc", 999 );
            UIManager.put( "TextComponent.arc", 999 );
            UIManager.put( "CheckBox.arc", 999 );
            UIManager.put( "ComboBox.arc", 999 );
            UIManager.put( "Panel.arc", 999 );
            
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new coba_cobabosss().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jBBatal;
    private javax.swing.JButton jBReset;
    private javax.swing.JButton jBSimpan;
    private javax.swing.JComboBox<String> jCKelas;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField jTLahir;
    private javax.swing.JTextField jTNama;
    private javax.swing.JTextField jTOrtu;
    private javax.swing.JTextField jTPek;
    private javax.swing.JTextField jTSekolah;
    private javax.swing.JTextField jTTelpon;
    private javax.swing.JRadioButton rb_Laki;
    private javax.swing.JRadioButton rb_Perempuan;
    private javax.swing.JLabel untukAllert;
    // End of variables declaration//GEN-END:variables
}
