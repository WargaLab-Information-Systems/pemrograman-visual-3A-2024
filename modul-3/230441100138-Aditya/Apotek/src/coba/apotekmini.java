package coba;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class apotekmini extends javax.swing.JFrame {

    public apotekmini() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        BGObat = new javax.swing.ButtonGroup();
        pAtas = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        pKanan = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jumlah = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JTextField();
        buy = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        keluar = new javax.swing.JButton();
        kurang = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        pTengah = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        iBodrex = new javax.swing.JLabel();
        iHufagrip = new javax.swing.JLabel();
        iSucralfate = new javax.swing.JLabel();
        iBetason = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        iStimuno = new javax.swing.JLabel();
        bodrex = new javax.swing.JCheckBox();
        stimuno = new javax.swing.JCheckBox();
        hufagrip = new javax.swing.JCheckBox();
        sucralfate = new javax.swing.JCheckBox();
        betason = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        iEntrostop = new javax.swing.JLabel();
        iSanadryl = new javax.swing.JLabel();
        iBufect = new javax.swing.JLabel();
        iNebacetin = new javax.swing.JLabel();
        iDiapet = new javax.swing.JLabel();
        nebacetin = new javax.swing.JCheckBox();
        bufect = new javax.swing.JCheckBox();
        sanadryl = new javax.swing.JCheckBox();
        entrostop = new javax.swing.JCheckBox();
        diapet = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pAtas.setBackground(new java.awt.Color(98, 111, 71));

        jLabel21.setFont(new java.awt.Font("Bookshelf Symbol 7", 3, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 204));
        jLabel21.setText("jLabel21dghdrwwwwwww");
        pAtas.add(jLabel21);

        jLabel1.setFont(new java.awt.Font("Serif", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("APOTEK MINI");
        pAtas.add(jLabel1);

        jLabel22.setFont(new java.awt.Font("Bookshelf Symbol 7", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 204));
        jLabel22.setText("jLabel21dghdrhdasgsh");
        pAtas.add(jLabel22);

        getContentPane().add(pAtas, java.awt.BorderLayout.PAGE_START);

        pKanan.setBackground(new java.awt.Color(121, 134, 69));
        pKanan.setMinimumSize(new java.awt.Dimension(252, 443));
        pKanan.setPreferredSize(new java.awt.Dimension(200, 398));
        pKanan.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("MS PGothic", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Jumlah");
        pKanan.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 51, 21));

        jumlah.setText("0");
        jumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jumlahActionPerformed(evt);
            }
        });
        pKanan.add(jumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 60, -1));

        jLabel3.setFont(new java.awt.Font("MS PGothic", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Total");
        pKanan.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, -1));

        jLabel6.setFont(new java.awt.Font("MS PGothic", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Rp.");
        pKanan.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 191, -1, 20));

        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        pKanan.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(59, 191, 120, -1));

        buy.setText("Buy");
        buy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buyActionPerformed(evt);
            }
        });
        pKanan.add(buy, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 80, -1));

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        pKanan.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 371, -1, -1));

        keluar.setText("Keluar");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });
        pKanan.add(keluar, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 371, -1, -1));

        kurang.setText("-");
        kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangActionPerformed(evt);
            }
        });
        pKanan.add(kurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, -1));

        tambah.setText("+");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        pKanan.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, -1, -1));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/apoteker.png"))); // NOI18N
        pKanan.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 231, -1, 170));

        jPanel1.setBackground(new java.awt.Color(102, 102, 0));
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));
        pKanan.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 580, 200, 40));

        getContentPane().add(pKanan, java.awt.BorderLayout.LINE_END);

        pTengah.setBackground(new java.awt.Color(204, 204, 204));
        pTengah.setMinimumSize(new java.awt.Dimension(800, 100));
        pTengah.setPreferredSize(new java.awt.Dimension(500, 100));
        pTengah.setLayout(new java.awt.GridLayout(2, 1));

        jPanel4.setBackground(new java.awt.Color(242, 238, 215));
        jPanel4.setMinimumSize(new java.awt.Dimension(514, 121));
        jPanel4.setPreferredSize(new java.awt.Dimension(800, 191));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        iBodrex.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/bodrex.png"))); // NOI18N
        iBodrex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iBodrexMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iBodrex, gridBagConstraints);

        iHufagrip.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/hufagrip.png"))); // NOI18N
        iHufagrip.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iHufagripMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iHufagrip, gridBagConstraints);

        iSucralfate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/sucralfate.png"))); // NOI18N
        iSucralfate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iSucralfateMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iSucralfate, gridBagConstraints);

        iBetason.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/betason.png"))); // NOI18N
        iBetason.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iBetasonMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iBetason, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel5.setText("Tablet");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel5, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel8.setText("Kapsul");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel9.setText("Sirup");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel10.setText("Suspensi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel10, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Consolas", 3, 14)); // NOI18N
        jLabel20.setText("Salep");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(jLabel20, gridBagConstraints);

        iStimuno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/stimuno.png"))); // NOI18N
        iStimuno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iStimunoMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel4.add(iStimuno, gridBagConstraints);

        bodrex.setText("bodrex - 8000");
        bodrex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bodrexActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        jPanel4.add(bodrex, gridBagConstraints);

        stimuno.setText("stimuno - 25000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        jPanel4.add(stimuno, gridBagConstraints);

        hufagrip.setText("hufagrip - 18000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        jPanel4.add(hufagrip, gridBagConstraints);

        sucralfate.setText("sucralfate - 18000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 2;
        jPanel4.add(sucralfate, gridBagConstraints);

        betason.setText("betason - 13000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        jPanel4.add(betason, gridBagConstraints);

        pTengah.add(jPanel4);

        jPanel5.setBackground(new java.awt.Color(254, 250, 224));
        jPanel5.setLayout(new java.awt.GridBagLayout());

        iEntrostop.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/entrostop.png"))); // NOI18N
        iEntrostop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iEntrostopMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iEntrostop, gridBagConstraints);

        iSanadryl.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/sanadryl.png"))); // NOI18N
        iSanadryl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iSanadrylMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iSanadryl, gridBagConstraints);

        iBufect.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/bufect.png"))); // NOI18N
        iBufect.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iBufectMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iBufect, gridBagConstraints);

        iNebacetin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/nebacetin.png"))); // NOI18N
        iNebacetin.setPreferredSize(new java.awt.Dimension(105, 90));
        iNebacetin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iNebacetinMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iNebacetin, gridBagConstraints);

        iDiapet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/coba/diapet.png"))); // NOI18N
        iDiapet.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                iDiapetMouseClicked(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanel5.add(iDiapet, gridBagConstraints);

        nebacetin.setText("nebacetin - 24000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        jPanel5.add(nebacetin, gridBagConstraints);

        bufect.setText("bufect - 22000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        jPanel5.add(bufect, gridBagConstraints);

        sanadryl.setText("sanadryl - 18000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        jPanel5.add(sanadryl, gridBagConstraints);

        entrostop.setText("entrostop - 9000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanel5.add(entrostop, gridBagConstraints);

        diapet.setText("diapet - 4000");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        jPanel5.add(diapet, gridBagConstraints);

        pTengah.add(jPanel5);

        getContentPane().add(pTengah, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iBodrexMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iBodrexMouseClicked
        ImageIcon Bodrex = new ImageIcon(getClass().getResource("bodrex.png"));
        JOptionPane.showMessageDialog(null, "Obat bebas yang digunakan untuk meredakan gejala \n"
                + "sakit kepala, demam, dan nyeri ringan. \n"
                + "Direkomendasikan untuk penggunaan jangka pendek.", 
                "Bodrex", JOptionPane.WIDTH,Bodrex);
    }//GEN-LAST:event_iBodrexMouseClicked

    private void iStimunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iStimunoMouseClicked
        ImageIcon Stimuno = new ImageIcon(getClass().getResource("stimuno.png"));
        JOptionPane.showMessageDialog(null, "Suplemen herbal yang berfungsi meningkatkan daya tahan tubuh. \n"
                + "Membantu memperkuat sistem imun dengan merangsang produksi antibodi, \n"
                + "Aman digunakan untuk jangka panjang sesuai anjuran.", 
                "Stimuno", JOptionPane.WIDTH,Stimuno);
    }//GEN-LAST:event_iStimunoMouseClicked

    private void iHufagripMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iHufagripMouseClicked
        ImageIcon Hufagrip = new ImageIcon(getClass().getResource("hufagrip.png"));
        JOptionPane.showMessageDialog(null, "Obat ini tersedia dalam beberapa varian, \n"
                + "seperti Hufagrip Flu dan Batuk, Hufagrip Pilek, serta Hufagrip BP (Batuk Pilek). \n"
                + "Cocok untuk meredakan gejala flu pada anak-anak.", 
                "Hufagrip", JOptionPane.WIDTH,Hufagrip);
    }//GEN-LAST:event_iHufagripMouseClicked

    private void iSucralfateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iSucralfateMouseClicked
        ImageIcon Sucralfate = new ImageIcon(getClass().getResource("sucralfate.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk mengobati dan mencegah \n"
                + "tukak lambung serta tukak usus. Obat ini biasanya tersedia dalam \n"
                + "bentuk tablet atau suspensi cair dan dikonsumsi sebelum makan.", 
                "Sucralfate", JOptionPane.WIDTH,Sucralfate);
    }//GEN-LAST:event_iSucralfateMouseClicked

    private void iBetasonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iBetasonMouseClicked
        ImageIcon Betason = new ImageIcon(getClass().getResource("betason.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk mengobati kondisi peradangan pada kulit, \n"
                + "seperti eksim, dermatitis, atau psoriasis. Betason tersedia dalam bentuk krim atau salep \n"
                + "untuk penggunaan topikal, dan harus digunakan sesuai petunjuk dokter untuk menghindari efek samping.", 
                "Betason", JOptionPane.WIDTH,Betason);
    }//GEN-LAST:event_iBetasonMouseClicked

    private void iNebacetinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iNebacetinMouseClicked
        ImageIcon Nebacetin = new ImageIcon(getClass().getResource("nebacetin.png"));
        JOptionPane.showMessageDialog(null, "Salep antibiotik yang mengandung neomycin dan bacitracin. Untuk mengobati \n"
                + "infeksi kulit ringan, seperti luka kecil, luka bakar, dan luka lecet. \n"
                + "Nebacetin dioleskan langsung pada area yang terinfeksi. \n"
                + "Biasanya diresepkan untuk penggunaan jangka pendek sesuai anjuran dokter.", 
                "Nebacetin", JOptionPane.WIDTH,Nebacetin);
    }//GEN-LAST:event_iNebacetinMouseClicked

    private void iBufectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iBufectMouseClicked
        ImageIcon Bufect = new ImageIcon(getClass().getResource("bufect.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk meredakan nyeri ringan hingga sedang, \n"
                + "seperti sakit kepala, nyeri otot, nyeri haid, serta meredakan demam. \n"
                + "Tersedia dalam bentuk tablet atau sirup, dan dosisnya harus disesuaikan dengan usia dan kondisi pasien.", 
                "Bufect", JOptionPane.WIDTH,Bufect);
    }//GEN-LAST:event_iBufectMouseClicked

    private void iSanadrylMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iSanadrylMouseClicked
        ImageIcon Sanadryl = new ImageIcon(getClass().getResource("sanadryl.png"));
        JOptionPane.showMessageDialog(null, "Cocok digunakan untuk meredakan gejala alergi, seperti bersin, \n"
                + "Sanadryl tersedia dalam bentuk tablet atau sirup, \n"
                + "dan dapat menyebabkan kantuk, sehingga disarankan untuk menghindari \n"
                + "aktivitas yang membutuhkan konsentrasi tinggi setelah mengonsumsinya.", 
                "Sanadryl", JOptionPane.WIDTH,Sanadryl);
    }//GEN-LAST:event_iSanadrylMouseClicked

    private void iDiapetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iDiapetMouseClicked
        ImageIcon Diapet = new ImageIcon(getClass().getResource("diapet.png"));
        JOptionPane.showMessageDialog(null, "Cocok untuk yang mempunyai gejala mabuk \n"
                + "perjalanan, mual, dan muntah", 
                "Diapet", JOptionPane.WIDTH,Diapet);
    }//GEN-LAST:event_iDiapetMouseClicked

    private void iEntrostopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_iEntrostopMouseClicked
        ImageIcon Entrostop = new ImageIcon(getClass().getResource("entrostop.png"));
        JOptionPane.showMessageDialog(null, "Cocok untuk yang mempunyai gejala mabuk \n"
                + "perjalanan, mual, dan muntah", 
                "Entrostop", JOptionPane.WIDTH,Entrostop);
    }//GEN-LAST:event_iEntrostopMouseClicked

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        int exit = JOptionPane.showConfirmDialog(null,"Ingin keluar?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        BGObat.clearSelection();
    }//GEN-LAST:event_resetActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalActionPerformed

    private void buyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buyActionPerformed
    if (!bodrex.isSelected() && !stimuno.isSelected() && !hufagrip.isSelected() && 
        !sucralfate.isSelected() && !betason.isSelected() && !nebacetin.isSelected() && 
        !bufect.isSelected() && !sanadryl.isSelected() && !diapet.isSelected() && 
        !entrostop.isSelected()) {
        JOptionPane.showMessageDialog(null, "Mohon pilih setidaknya satu obat!");
    } 
    else if (jumlah.getText().equals("0") || jumlah.getText().isEmpty()) {
        JOptionPane.showMessageDialog(null, "Mohon masukkan jumlah obat yang ingin dipesan!");
    } 
    else {
        int Jumlah = Integer.parseInt(jumlah.getText());
        int Total = 0; 

        if (bodrex.isSelected()) {
            Total += 8000 * Jumlah;
        }
        if (stimuno.isSelected()) {
            Total += 25000 * Jumlah;
        }
        if (hufagrip.isSelected()) {
            Total += 18000 * Jumlah;
        }
        if (sucralfate.isSelected()) {
            Total += 18000 * Jumlah;
        }
        if (betason.isSelected()) {
            Total += 13000 * Jumlah;
        }
        if (nebacetin.isSelected()) {
            Total += 24000 * Jumlah;
        }
        if (bufect.isSelected()) {
            Total += 22000 * Jumlah;
        }
        if (sanadryl.isSelected()) {
            Total += 18000 * Jumlah;
        }
        if (diapet.isSelected()) {
            Total += 4000 * Jumlah;
        }
        if (entrostop.isSelected()) {
            Total += 9000 * Jumlah;
        }

        total.setText(String.valueOf(Total));
    }

    }//GEN-LAST:event_buyActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        int Jumlah = Integer.parseInt(jumlah.getText());
        Jumlah++;

        jumlah.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_tambahActionPerformed

    private void jumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jumlahActionPerformed

    private void kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangActionPerformed
        int Jumlah = Integer.parseInt(jumlah.getText());
        if(Jumlah <= 0){
            JOptionPane.showMessageDialog(null, "jumlah tidak boleh kurang dari 0");
        }
        else{
            Jumlah--;
        }
        jumlah.setText(String.valueOf(Jumlah));
    }//GEN-LAST:event_kurangActionPerformed

    private void bodrexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bodrexActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bodrexActionPerformed

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
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(apotekmini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apotekmini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGObat;
    private javax.swing.JCheckBox betason;
    private javax.swing.JCheckBox bodrex;
    private javax.swing.JCheckBox bufect;
    private javax.swing.JButton buy;
    private javax.swing.JCheckBox diapet;
    private javax.swing.JCheckBox entrostop;
    private javax.swing.JCheckBox hufagrip;
    private javax.swing.JLabel iBetason;
    private javax.swing.JLabel iBodrex;
    private javax.swing.JLabel iBufect;
    private javax.swing.JLabel iDiapet;
    private javax.swing.JLabel iEntrostop;
    private javax.swing.JLabel iHufagrip;
    private javax.swing.JLabel iNebacetin;
    private javax.swing.JLabel iSanadryl;
    private javax.swing.JLabel iStimuno;
    private javax.swing.JLabel iSucralfate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jumlah;
    private javax.swing.JButton keluar;
    private javax.swing.JButton kurang;
    private javax.swing.JCheckBox nebacetin;
    private javax.swing.JPanel pAtas;
    private javax.swing.JPanel pKanan;
    private javax.swing.JPanel pTengah;
    private javax.swing.JButton reset;
    private javax.swing.JCheckBox sanadryl;
    private javax.swing.JCheckBox stimuno;
    private javax.swing.JCheckBox sucralfate;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField total;
    // End of variables declaration//GEN-END:variables
}
