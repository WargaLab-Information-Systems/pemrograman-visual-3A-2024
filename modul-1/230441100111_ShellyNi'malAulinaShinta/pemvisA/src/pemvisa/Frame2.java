/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pemvisa;


/**
 *
 * @author Shely
 */
public class Frame2 extends javax.swing.JFrame {
    

    /**
     * Creates new form Frame2
     */
    public Frame2() {
        initComponents();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelGambar = new javax.swing.JLabel();
        labelFormulir = new javax.swing.JLabel();
        labelSekolah = new javax.swing.JLabel();
        labelJalan = new javax.swing.JLabel();
        labelNomor = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        labelNama = new javax.swing.JLabel();
        labelNisn = new javax.swing.JLabel();
        labelAlamat = new javax.swing.JLabel();
        labelTempat = new javax.swing.JLabel();
        labelTanggal = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelKelamin = new javax.swing.JLabel();
        labelTelepon = new javax.swing.JLabel();
        labelKelas = new javax.swing.JLabel();
        textFieldAlamat = new javax.swing.JTextField();
        textFieldemail = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        textFieldTelepon = new javax.swing.JTextField();
        textFieldKelamin = new javax.swing.JTextField();
        textFieldKelas = new javax.swing.JTextField();
        textTanggal = new javax.swing.JTextField();
        textTempat = new javax.swing.JTextField();
        textNisn = new javax.swing.JTextField();
        textNama = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 51, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        labelGambar.setIcon(new javax.swing.ImageIcon("C:\\Users\\Shely\\Downloads\\foto.jpg")); // NOI18N

        labelFormulir.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelFormulir.setText("FORMULIR PENDAFTARAN SISWA SEKOLAH");

        labelSekolah.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        labelSekolah.setText("SMA NEGERI 1 NUSANTARA");

        labelJalan.setText("JL. Raya Telang, PO, Box. 2 Kamal, Bangkalan - Madura");

        labelNomor.setText("Telp : (031) 3011146, Fax (031) 3011506");

        jLabel1.setText("NPSN : 20506325");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(labelGambar)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addComponent(labelSekolah)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(labelNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(90, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelJalan)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(labelFormulir)
                            .addGap(81, 81, 81))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(186, 186, 186)))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelFormulir, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelGambar)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(labelSekolah)
                        .addGap(1, 1, 1)
                        .addComponent(labelJalan, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelNomor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        labelNama.setText("Nama : ");

        labelNisn.setText("NISN :");

        labelAlamat.setText("Alamat : ");

        labelTempat.setText("Tempat Lahir : ");

        labelTanggal.setText("Tanggal Lahir : ");

        labelEmail.setText("Email : ");

        labelKelamin.setText("Jenis Kelamin : ");

        labelTelepon.setText("No. Telepon : ");

        labelKelas.setText("Kelas : ");

        textFieldAlamat.setEditable(false);
        textFieldAlamat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldAlamatActionPerformed(evt);
            }
        });

        textFieldemail.setEditable(false);
        textFieldemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldemailActionPerformed(evt);
            }
        });

        jButton1.setText("Keluar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        textFieldTelepon.setEditable(false);
        textFieldTelepon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldTeleponActionPerformed(evt);
            }
        });

        textFieldKelamin.setEditable(false);

        textFieldKelas.setEditable(false);

        textTanggal.setEditable(false);
        textTanggal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTanggalActionPerformed(evt);
            }
        });

        textTempat.setEditable(false);

        textNisn.setEditable(false);
        textNisn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNisnActionPerformed(evt);
            }
        });

        textNama.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNisn)
                    .addComponent(labelNama)
                    .addComponent(labelTempat)
                    .addComponent(labelTanggal)
                    .addComponent(labelAlamat)
                    .addComponent(labelEmail)
                    .addComponent(labelTelepon)
                    .addComponent(labelKelamin)
                    .addComponent(labelKelas))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(textFieldemail, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldKelamin)
                    .addComponent(textFieldTelepon)
                    .addComponent(textFieldKelas, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
                    .addComponent(textTanggal)
                    .addComponent(textTempat)
                    .addComponent(textNisn)
                    .addComponent(textNama))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(textNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNisn, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textNisn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTempat)
                    .addComponent(textTempat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTanggal)
                    .addComponent(textTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAlamat)
                    .addComponent(textFieldAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelEmail)
                    .addComponent(textFieldemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelKelamin)
                    .addComponent(textFieldKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTelepon)
                    .addComponent(textFieldTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textFieldKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelKelas))
                .addGap(46, 46, 46)
                .addComponent(jButton1)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
//        tombol keluar untuk kembali ke frame1
//        cobaAja frame1 = new cobaAja();
//        frame1.setVisible(false);
//tombol keluar untuk menutup aplikasi
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void textFieldTeleponActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldTeleponActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldTeleponActionPerformed

    private void textFieldemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldemailActionPerformed

    private void textFieldAlamatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldAlamatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldAlamatActionPerformed

    private void textTanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTanggalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTanggalActionPerformed

    private void textNisnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNisnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNisnActionPerformed

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
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFormulir;
    private javax.swing.JLabel labelGambar;
    private javax.swing.JLabel labelJalan;
    private javax.swing.JLabel labelKelamin;
    private javax.swing.JLabel labelKelas;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelNisn;
    private javax.swing.JLabel labelNomor;
    private javax.swing.JLabel labelSekolah;
    private javax.swing.JLabel labelTanggal;
    private javax.swing.JLabel labelTelepon;
    private javax.swing.JLabel labelTempat;
    private javax.swing.JTextField textFieldAlamat;
    private javax.swing.JTextField textFieldKelamin;
    private javax.swing.JTextField textFieldKelas;
    private javax.swing.JTextField textFieldTelepon;
    private javax.swing.JTextField textFieldemail;
    private javax.swing.JTextField textNama;
    private javax.swing.JTextField textNisn;
    private javax.swing.JTextField textTanggal;
    private javax.swing.JTextField textTempat;
    // End of variables declaration//GEN-END:variables

    void setData(String nama, String nisn, String tempatlahir, String tanggalahir, String alamat, String email, String telepon, String gender, String kelas) {
        textNama.setText(nama);
        textNisn.setText(nisn);
        textTempat.setText(tempatlahir);
        textTanggal.setText(tanggalahir);
        textFieldAlamat.setText(alamat);
        textFieldemail.setText(email);
        textFieldTelepon.setText(telepon);
        textFieldKelamin.setText(gender);
        textFieldKelas.setText(kelas);
    }
}