import javax.swing.JOptionPane;

public class Frame1 extends javax.swing.JFrame {
    public Frame1() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jProgressBar1 = new javax.swing.JProgressBar();
        jPanel1 = new javax.swing.JPanel();
        Nama = new javax.swing.JLabel();
        NoTelepon = new javax.swing.JLabel();
        Kelas = new javax.swing.JLabel();
        KotakTelepon = new javax.swing.JTextField();
        LakiLaki = new javax.swing.JRadioButton();
        JenisKelamin = new javax.swing.JLabel();
        Perempuan = new javax.swing.JRadioButton();
        jPanel2 = new javax.swing.JPanel();
        formulir = new javax.swing.JLabel();
        ekstrakurikuler = new javax.swing.JLabel();
        sekolah = new javax.swing.JLabel();
        KotakNama = new javax.swing.JTextField();
        Alamat = new javax.swing.JLabel();
        KotakAlamat = new javax.swing.JTextField();
        Email = new javax.swing.JLabel();
        KotakEmail = new javax.swing.JTextField();
        TanggalLahir = new javax.swing.JLabel();
        KotakTanggalLahir = new javax.swing.JTextField();
        PilihanEkstrakurikuler = new javax.swing.JLabel();
        GarisBawahPilihanEkstrakurikuler = new javax.swing.JLabel();
        Futsal = new javax.swing.JCheckBox();
        Basket = new javax.swing.JCheckBox();
        Pramuka = new javax.swing.JCheckBox();
        Kesenian = new javax.swing.JCheckBox();
        Paskibra = new javax.swing.JCheckBox();
        Beladiri = new javax.swing.JCheckBox();
        Robotik = new javax.swing.JCheckBox();
        Volly = new javax.swing.JCheckBox();
        DesainGrafis = new javax.swing.JCheckBox();
        PMR = new javax.swing.JCheckBox();
        PaduanSuara = new javax.swing.JCheckBox();
        Alasan = new javax.swing.JLabel();
        KotakAlasan = new javax.swing.JTextField();
        CBKelas = new javax.swing.JComboBox<>();
        ResetButton = new javax.swing.JButton();
        SimpanButton = new javax.swing.JButton();
        DataBenar = new javax.swing.JCheckBox();
        Batal = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Nama.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Nama.setText("Nama Lengkap");

        NoTelepon.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        NoTelepon.setText("No. Telepon ");

        Kelas.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Kelas.setText("Kelas        ");

        KotakTelepon.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        buttonGroup1.add(LakiLaki);
        LakiLaki.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        LakiLaki.setText("Laki - Laki");
        LakiLaki.setBorder(null);

        JenisKelamin.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        JenisKelamin.setText("Jenis Kelamin ");

        buttonGroup1.add(Perempuan);
        Perempuan.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Perempuan.setText("Perempuan");

        jPanel2.setBackground(new java.awt.Color(40, 150, 255));
        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED, null, new java.awt.Color(204, 204, 204), new java.awt.Color(0, 0, 0), null));

        formulir.setBackground(new java.awt.Color(102, 102, 255));
        formulir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        formulir.setText("FORMULIR PENDAFTARAN");

        ekstrakurikuler.setFont(new java.awt.Font("Sitka Text", 1, 16)); // NOI18N
        ekstrakurikuler.setText("Ekstrakurikuler");

        sekolah.setFont(new java.awt.Font("Sitka Text", 1, 14)); // NOI18N
        sekolah.setText("SMKN 5 Pamekasan");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(formulir)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(ekstrakurikuler)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(sekolah)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(formulir, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ekstrakurikuler, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(sekolah))))
        );

        KotakNama.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Alamat.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Alamat.setText("Alamat");

        KotakAlamat.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        Email.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Email.setText("Email");

        KotakEmail.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        TanggalLahir.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        TanggalLahir.setText("Tanggal Lahir");

        KotakTanggalLahir.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PilihanEkstrakurikuler.setFont(new java.awt.Font("Sitka Text", 1, 18)); // NOI18N
        PilihanEkstrakurikuler.setText("Pilihan Ekstrakurikuler");

        GarisBawahPilihanEkstrakurikuler.setText("--------------------------------------------------");

        Futsal.setText("Futsal");

        Basket.setText("Basket");

        Pramuka.setText("Pramuka");

        Kesenian.setText("Kesenian");

        Paskibra.setText("Paskibra");

        Beladiri.setText("Beladiri");

        Robotik.setText("Robotik");

        Volly.setText("volly");

        DesainGrafis.setText("Desain Grafis");

        PMR.setText("PMR");

        PaduanSuara.setText("Paduan Suara");

        Alasan.setFont(new java.awt.Font("Sitka Text", 1, 12)); // NOI18N
        Alasan.setText("Alasan Mengikuti Ekstrakurikuler yang Dipilih");

        KotakAlasan.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CBKelas.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Kelas--", "X MIPA 1", "X MIPA 2", "X MIPA 3", "X MIPA 4", "X MIPA 5" }));
        CBKelas.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        CBKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBKelasActionPerformed(evt);
            }
        });

        ResetButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ResetButton.setText("Reset");
        ResetButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        ResetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetButtonActionPerformed(evt);
            }
        });

        SimpanButton.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        SimpanButton.setText("Simpan");
        SimpanButton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SimpanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SimpanButtonActionPerformed(evt);
            }
        });

        DataBenar.setText("Data Yang Diinputlkan Sudah benar");
        DataBenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DataBenarActionPerformed(evt);
            }
        });

        Batal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        Batal.setText("Batal");
        Batal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        Batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BatalActionPerformed(evt);
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
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PilihanEkstrakurikuler, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(GarisBawahPilihanEkstrakurikuler)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(Volly, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Paskibra, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(DesainGrafis))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Basket, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Kesenian, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(12, 12, 12)
                                                .addComponent(Robotik, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(Futsal, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(Pramuka, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Beladiri)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(PMR, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PaduanSuara)))
                                    .addComponent(Alasan)
                                    .addComponent(DataBenar))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(Batal, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)
                                        .addComponent(ResetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(36, 36, 36)
                                        .addComponent(SimpanButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(KotakAlasan, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NoTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Nama)
                                            .addComponent(JenisKelamin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Email, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(KotakAlamat, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(LakiLaki)
                                                    .addComponent(Perempuan)
                                                    .addComponent(KotakTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(Kelas)
                                                        .addGap(28, 28, 28))
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(TanggalLahir)
                                                        .addGap(18, 18, 18)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(KotakTanggalLahir)
                                                    .addComponent(CBKelas, 0, 132, Short.MAX_VALUE)))
                                            .addComponent(KotakNama, javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(KotakEmail))))
                                .addGap(33, 33, 33)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Nama)
                    .addComponent(KotakNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NoTelepon)
                    .addComponent(KotakTelepon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Kelas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBKelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TanggalLahir)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(JenisKelamin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(LakiLaki)
                        .addComponent(KotakTanggalLahir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(4, 4, 4)
                .addComponent(Perempuan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(KotakAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(KotakEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Email, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(Alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PilihanEkstrakurikuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(GarisBawahPilihanEkstrakurikuler)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Futsal)
                    .addComponent(Beladiri)
                    .addComponent(Pramuka)
                    .addComponent(PMR))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Basket)
                    .addComponent(Robotik)
                    .addComponent(Kesenian)
                    .addComponent(PaduanSuara))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Paskibra)
                    .addComponent(Volly)
                    .addComponent(DesainGrafis))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Alasan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KotakAlasan, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DataBenar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SimpanButton)
                    .addComponent(ResetButton)
                    .addComponent(Batal))
                .addGap(38, 38, 38))
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

    private void SimpanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SimpanButtonActionPerformed
        // TODO add your handling code here:
        if (!DataBenar.isSelected()||
                (!LakiLaki.isSelected()) ||
                ((String)CBKelas.getSelectedItem()== "--Pilih Kelas--") ||
                KotakNama.getText().isEmpty() || 
                KotakTelepon.getText().isEmpty() || 
                KotakAlamat.getText().isEmpty() || 
                KotakEmail.getText().isEmpty() || 
                KotakTanggalLahir.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, 
                "DIISI DULU BOSS!", 
                "PERINGATAN", 
                JOptionPane.WARNING_MESSAGE);
        } else {
            String nama = KotakNama.getText();
            String noTelp = KotakTelepon.getText();
            String jenisKelamin = LakiLaki.isSelected() ? "Laki-Laki" : "Perempuan";
            String alamat = KotakAlamat.getText();
            String email = KotakEmail.getText();
            String kelas = (String) CBKelas.getSelectedItem();
            String tanggalLahir = KotakTanggalLahir.getText();
            String pilihanEkstrakurikuler = "";
            
            if (Futsal.isSelected()) pilihanEkstrakurikuler += "Futsal, ";
            if (Basket.isSelected()) pilihanEkstrakurikuler += "Basket, ";
            if (Volly.isSelected()) pilihanEkstrakurikuler += "Volly, ";
            if (Pramuka.isSelected()) pilihanEkstrakurikuler += "Pramuka, ";
            if (Kesenian.isSelected()) pilihanEkstrakurikuler += "Kesenian, ";
            if (Paskibra.isSelected()) pilihanEkstrakurikuler += "Paskibra, ";
            if (Beladiri.isSelected()) pilihanEkstrakurikuler += "Beladiri, ";
            if (Robotik.isSelected()) pilihanEkstrakurikuler += "Robotik, ";
            if (DesainGrafis.isSelected()) pilihanEkstrakurikuler += "Desain Grafis, ";
            if (PMR.isSelected()) pilihanEkstrakurikuler += "PMR, ";
            if (PaduanSuara.isSelected()) pilihanEkstrakurikuler += "Paduan Suara ";
            
            String alasan = KotakAlasan.getText();
            
            
            Frame2 frame2 = new Frame2(nama, noTelp, jenisKelamin, alamat, email, kelas, tanggalLahir, pilihanEkstrakurikuler, alasan);
            frame2.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_SimpanButtonActionPerformed
    private void ResetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetButtonActionPerformed
        KotakNama.setText("");
        KotakTelepon.setText("");
        
        buttonGroup1.clearSelection();
        
        KotakAlamat.setText("");
        KotakEmail.setText("");
        
        CBKelas.setSelectedIndex(0);
        
        KotakTanggalLahir.setText("");
        
        Futsal.setSelected(false);
        Basket.setSelected(false);
        Volly.setSelected(false);
        Pramuka.setSelected(false);
        Kesenian.setSelected(false);
        Paskibra.setSelected(false);
        Beladiri.setSelected(false);
        Robotik.setSelected(false);
        DesainGrafis.setSelected(false);
        PMR.setSelected(false);
        PaduanSuara.setSelected(false);
        
        KotakAlasan.setText("");
        DataBenar.setSelected(false);
    }//GEN-LAST:event_ResetButtonActionPerformed

    private void BatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BatalActionPerformed
       this.dispose();
    }//GEN-LAST:event_BatalActionPerformed

    private void DataBenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DataBenarActionPerformed
    }//GEN-LAST:event_DataBenarActionPerformed

    private void CBKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBKelasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBKelasActionPerformed
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Alamat;
    private javax.swing.JLabel Alasan;
    private javax.swing.JCheckBox Basket;
    private javax.swing.JButton Batal;
    private javax.swing.JCheckBox Beladiri;
    private javax.swing.JComboBox<String> CBKelas;
    private javax.swing.JCheckBox DataBenar;
    private javax.swing.JCheckBox DesainGrafis;
    private javax.swing.JLabel Email;
    private javax.swing.JCheckBox Futsal;
    private javax.swing.JLabel GarisBawahPilihanEkstrakurikuler;
    private javax.swing.JLabel JenisKelamin;
    private javax.swing.JLabel Kelas;
    private javax.swing.JCheckBox Kesenian;
    private javax.swing.JTextField KotakAlamat;
    private javax.swing.JTextField KotakAlasan;
    private javax.swing.JTextField KotakEmail;
    private javax.swing.JTextField KotakNama;
    private javax.swing.JTextField KotakTanggalLahir;
    private javax.swing.JTextField KotakTelepon;
    private javax.swing.JRadioButton LakiLaki;
    private javax.swing.JLabel Nama;
    private javax.swing.JLabel NoTelepon;
    private javax.swing.JCheckBox PMR;
    private javax.swing.JCheckBox PaduanSuara;
    private javax.swing.JCheckBox Paskibra;
    private javax.swing.JRadioButton Perempuan;
    private javax.swing.JLabel PilihanEkstrakurikuler;
    private javax.swing.JCheckBox Pramuka;
    private javax.swing.JButton ResetButton;
    private javax.swing.JCheckBox Robotik;
    private javax.swing.JButton SimpanButton;
    private javax.swing.JLabel TanggalLahir;
    private javax.swing.JCheckBox Volly;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel ekstrakurikuler;
    private javax.swing.JLabel formulir;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel sekolah;
    // End of variables declaration//GEN-END:variables
}
