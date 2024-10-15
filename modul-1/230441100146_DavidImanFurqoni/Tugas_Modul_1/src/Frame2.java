public class Frame2 extends javax.swing.JFrame {
    public Frame2() {
        initComponents();
    }
    Frame2(String nama, String noTelp, String jenisKelamin, String alamat, String email, String kelas, String tanggalLahir, String PilihanEkstrakurikuler, String alasan) {
        initComponents();
        
        
        KotakNama.setText(nama);
        KotakTelepon.setText(noTelp);
        KotakKelamin.setText(jenisKelamin);
        KotakAlamat.setText(alamat);
        KotakEmail.setText(email);
        KotakKelas.setText(kelas);
        KotakTanggalLahir.setText(tanggalLahir);
        KotakPilihan.setText(PilihanEkstrakurikuler);
        KotakAlasan.setText(alasan);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Nama = new javax.swing.JLabel();
        NoTelepon = new javax.swing.JLabel();
        JenisKelamin = new javax.swing.JLabel();
        Alamat = new javax.swing.JLabel();
        Email = new javax.swing.JLabel();
        Kelas = new javax.swing.JLabel();
        TanggalLahir = new javax.swing.JLabel();
        KotakNama = new javax.swing.JTextField();
        KotakTelepon = new javax.swing.JTextField();
        KotakKelamin = new javax.swing.JTextField();
        KotakAlamat = new javax.swing.JTextField();
        KotakEmail = new javax.swing.JTextField();
        KotakKelas = new javax.swing.JTextField();
        KotakTanggalLahir = new javax.swing.JTextField();
        PilihanEkstrakurikuler = new javax.swing.JLabel();
        Alasan = new javax.swing.JLabel();
        KotakPilihan = new javax.swing.JTextField();
        KotakAlasan = new javax.swing.JTextField();
        Keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel2.setBackground(new java.awt.Color(40, 150, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("DATA PENDAFTAR");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setText("TERSIMPAN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addContainerGap())
        );

        Nama.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Nama.setText("Nama Lengkap:");

        NoTelepon.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        NoTelepon.setText("No Telepon:");

        JenisKelamin.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        JenisKelamin.setText("Jenis  Kelamin:");

        Alamat.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Alamat.setText("Alamat:");

        Email.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Email.setText("Email:");

        Kelas.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Kelas.setText("Kelas:");

        TanggalLahir.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        TanggalLahir.setText("Tanggal Lahir:");

        KotakNama.setEditable(false);
        KotakNama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KotakTelepon.setEditable(false);
        KotakTelepon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KotakKelamin.setEditable(false);
        KotakKelamin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KotakAlamat.setEditable(false);
        KotakAlamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KotakEmail.setEditable(false);
        KotakEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KotakKelas.setEditable(false);
        KotakKelas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        KotakTanggalLahir.setEditable(false);
        KotakTanggalLahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        KotakTanggalLahir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KotakTanggalLahirActionPerformed(evt);
            }
        });

        PilihanEkstrakurikuler.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        PilihanEkstrakurikuler.setText("Pilihan Ektrakurikuler:");

        Alasan.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Alasan.setText("Alasan Memilih Ekstrakurikuler:");

        KotakPilihan.setEditable(false);
        KotakPilihan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        KotakPilihan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KotakPilihanActionPerformed(evt);
            }
        });

        KotakAlasan.setEditable(false);
        KotakAlasan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Keluar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Keluar.setText("Keluar");
        Keluar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });

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
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NoTelepon)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(JenisKelamin, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Alamat, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(TanggalLahir, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Kelas, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(PilihanEkstrakurikuler, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Email, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Alasan, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addComponent(Nama, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(KotakAlasan, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                                    .addComponent(KotakPilihan)
                                    .addComponent(KotakTanggalLahir)
                                    .addComponent(KotakKelas)
                                    .addComponent(KotakEmail)
                                    .addComponent(KotakAlamat)
                                    .addComponent(KotakKelamin)
                                    .addComponent(KotakTelepon)
                                    .addComponent(KotakNama)))
                            .addComponent(Keluar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nama)
                    .addComponent(KotakNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoTelepon)
                    .addComponent(KotakTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JenisKelamin)
                    .addComponent(KotakKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KotakAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Alamat))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KotakEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Email))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Kelas)
                    .addComponent(KotakKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TanggalLahir)
                    .addComponent(KotakTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KotakPilihan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PilihanEkstrakurikuler))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(KotakAlasan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Alasan))
                .addGap(18, 18, 18)
                .addComponent(Keluar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KotakPilihanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KotakPilihanActionPerformed
    }//GEN-LAST:event_KotakPilihanActionPerformed

    private void KotakTanggalLahirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KotakTanggalLahirActionPerformed
    }//GEN-LAST:event_KotakTanggalLahirActionPerformed

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed
        this.dispose();
    }//GEN-LAST:event_KeluarActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame2().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Alasan;
    private javax.swing.JLabel Email;
    private javax.swing.JLabel JenisKelamin;
    private javax.swing.JLabel Kelas;
    private javax.swing.JButton Keluar;
    private javax.swing.JTextField KotakAlamat;
    private javax.swing.JTextField KotakAlasan;
    private javax.swing.JTextField KotakEmail;
    private javax.swing.JTextField KotakKelamin;
    private javax.swing.JTextField KotakKelas;
    private javax.swing.JTextField KotakNama;
    private javax.swing.JTextField KotakPilihan;
    private javax.swing.JTextField KotakTanggalLahir;
    private javax.swing.JTextField KotakTelepon;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel NoTelepon;
    private javax.swing.JLabel PilihanEkstrakurikuler;
    private javax.swing.JLabel TanggalLahir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
