package modul.pkg3;
import javax.swing.JOptionPane;

public class Apotek extends javax.swing.JFrame {
    public Apotek() {
        initComponents();
        setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel3 = new javax.swing.JPanel();
        simpan = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        a = new javax.swing.JCheckBox();
        b = new javax.swing.JCheckBox();
        c = new javax.swing.JCheckBox();
        d = new javax.swing.JCheckBox();
        e = new javax.swing.JCheckBox();
        f = new javax.swing.JCheckBox();
        g = new javax.swing.JCheckBox();
        h = new javax.swing.JCheckBox();
        i = new javax.swing.JCheckBox();
        j = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 51, 51));

        simpan.setBackground(new java.awt.Color(255, 204, 255));
        simpan.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        simpan.setText("Simpan");
        simpan.setPreferredSize(new java.awt.Dimension(78, 30));
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });
        jPanel3.add(simpan);

        getContentPane().add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setPreferredSize(new java.awt.Dimension(890, 80));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("APOTEK ");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));
        jPanel2.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 0, 90, 80));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(3, 52, 110));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("Gambar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 7;
        jPanel1.add(jLabel3, gridBagConstraints);

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Nama Obat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 7;
        jPanel1.add(jLabel4, gridBagConstraints);

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Fungsi/Manfaat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.ipady = 7;
        jPanel1.add(jLabel5, gridBagConstraints);

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-masuk-angin-antangin-cair.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel8, gridBagConstraints);

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-masuk-angin-antangin-Jrg-.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel9, gridBagConstraints);

        jLabel10.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(204, 255, 255));
        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-masuk-angin-ob-herbal-antangin.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel10, gridBagConstraints);

        jLabel11.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(204, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-masuk-angin-tolak-angin.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel11, gridBagConstraints);

        jLabel12.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 255, 255));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-pelancar-bab-dulcolax-tablet.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel12, gridBagConstraints);

        jLabel16.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(204, 255, 255));
        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-pelancar-bab-vegeta-herbal-anggur.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel16, gridBagConstraints);

        jLabel17.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(204, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-sakit-kepala-bodrek-migra.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel17, gridBagConstraints);

        jLabel18.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(204, 255, 255));
        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-sakit-kepala-dumin-sirup.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel18, gridBagConstraints);

        jLabel19.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(204, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-sakit-kepala-panadol-extra.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel19, gridBagConstraints);

        jLabel20.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(204, 255, 255));
        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul/pkg3/obat-sakit-kepala-poldan-mig.png"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel20, gridBagConstraints);

        a.setBackground(new java.awt.Color(3, 52, 110));
        a.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        a.setForeground(new java.awt.Color(204, 255, 255));
        a.setText("Amoxicilin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(a, gridBagConstraints);

        b.setBackground(new java.awt.Color(3, 52, 110));
        b.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        b.setForeground(new java.awt.Color(204, 255, 255));
        b.setText("Antasida");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(b, gridBagConstraints);

        c.setBackground(new java.awt.Color(3, 52, 110));
        c.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        c.setForeground(new java.awt.Color(204, 255, 255));
        c.setText("Paracetamol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(c, gridBagConstraints);

        d.setBackground(new java.awt.Color(3, 52, 110));
        d.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        d.setForeground(new java.awt.Color(204, 255, 255));
        d.setText("Ibuprofen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(d, gridBagConstraints);

        e.setBackground(new java.awt.Color(3, 52, 110));
        e.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        e.setForeground(new java.awt.Color(204, 255, 255));
        e.setText("Domperidone");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(e, gridBagConstraints);

        f.setBackground(new java.awt.Color(3, 52, 110));
        f.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        f.setForeground(new java.awt.Color(204, 255, 255));
        f.setText("Sentraline");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(f, gridBagConstraints);

        g.setBackground(new java.awt.Color(3, 52, 110));
        g.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        g.setForeground(new java.awt.Color(204, 255, 255));
        g.setText("Cetirizine");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(g, gridBagConstraints);

        h.setBackground(new java.awt.Color(3, 52, 110));
        h.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        h.setForeground(new java.awt.Color(204, 255, 255));
        h.setText("Loperamid");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(h, gridBagConstraints);

        i.setBackground(new java.awt.Color(3, 52, 110));
        i.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        i.setForeground(new java.awt.Color(204, 255, 255));
        i.setText("Omeprazole");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(i, gridBagConstraints);

        j.setBackground(new java.awt.Color(3, 52, 110));
        j.setFont(new java.awt.Font("Cambria", 1, 18)); // NOI18N
        j.setForeground(new java.awt.Color(204, 255, 255));
        j.setText("Katerolac");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 2;
        gridBagConstraints.ipady = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(j, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Antibiotik. Mengobati infeksi bakteri seperti infeksi telinga, hidung, tenggorokan, dan saluran kemih.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel6, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(204, 255, 255));
        jLabel7.setText("Mengobati gejala maag, gastritis, atau refluks asam.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(204, 255, 255));
        jLabel13.setText("Penurun Panas. Mengurangi rasa sakit dan demam.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel13, gridBagConstraints);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(204, 255, 255));
        jLabel14.setText("Mengurangi nyeri, peradangan, dan demam. ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel14, gridBagConstraints);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(204, 255, 255));
        jLabel15.setText("Mengatasi mual dan muntah, terutama akibat pengobatan atau gangguan pencernaan.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel15, gridBagConstraints);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(204, 255, 255));
        jLabel22.setText("Mengatasi gejala alergi seperti hidung meler, bersin, dan gatal-gatal.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel22, gridBagConstraints);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(204, 255, 255));
        jLabel23.setText("Mengobati depresi, kecemasan, dan gangguan obsesif-kompulsif.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel23, gridBagConstraints);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(204, 255, 255));
        jLabel24.setText("Mengatasi diare akut dan kronis.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel24, gridBagConstraints);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(204, 255, 255));
        jLabel25.setText("Mengobati tukak lambung, refluks gastroesofageal, dan kondisi berlebihan asam lambung.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel25, gridBagConstraints);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(204, 255, 255));
        jLabel26.setText("Mengurangi nyeri singkat, biasanya setelah operasi.");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.ipady = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        jPanel1.add(jLabel26, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        String selectedOptions = "";
        if (a.isSelected()){
            selectedOptions += "Anda memilih " + a.getText() + 
           " untuk mengobati infeksi bakteri seperti infeksi telinga, hidung, tenggorokan, dan saluran kemih.\n";
        }if (b.isSelected()) {
            selectedOptions += "Anda memilih " + b.getText() + 
            " untuk mengobati gejala maag, gastritis, atau refluks asam\n";
        }if (c.isSelected()) {
            selectedOptions += "Anda memilih " + c.getText() + 
           " untuk penurun panas, mengurangi rasa sakit dan demam\n";
        }if (d.isSelected()) {
            selectedOptions += "Anda memilih " + d.getText() + 
          " untuk mengurangi nyeri, peradangan, dan demam\n";
        }if (e.isSelected()) {
            selectedOptions += "Anda memilih " + e.getText() + 
          " untuk mengatasi mual dan muntah, terutama akibat pengobatan atau gangguan pencernaan\n";
        }if (f.isSelected()) {
            selectedOptions += "Anda memilih " + f.getText() + 
          " untuk mengobati depresi, kecemasan, dan gangguan obsesif-kompulsif\n";
        }if (g.isSelected()) {
            selectedOptions += "Anda memilih " + g.getText() + 
          " untuk mengatasi gejala alergi seperti hidung meler, bersin, dan gatal-gatal\n";
        }if (h.isSelected()) {
            selectedOptions += "Anda memilih " + h.getText() + " untuk mengatasi diare akut dan kronis\n";
        }if (i.isSelected()) {
            selectedOptions += "Anda memilih " +i.getText() + 
          " untuk mengobati tukak lambung, refluks gastroesofageal, dan kondisi berlebihan asam lambung\n";
        }if (j.isSelected()) {
            selectedOptions += "Anda memilih " + j.getText() + 
          " untuk mengurangi nyeri singkat, biasanya setelah operasi\n";
        }
        // Menampilkan hasil menggunakan JOptionPane
        if (selectedOptions.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Pilih dulu dongg !!!",
                    "Peringatan", JOptionPane.WARNING_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, selectedOptions, "Hasil Pilihan",
                    JOptionPane.INFORMATION_MESSAGE);
        }
        a.setSelected(false);
        b.setSelected(false);
        c.setSelected(false);
        d.setSelected(false);
        e.setSelected(false);
        f.setSelected(false);
        g.setSelected(false);
        h.setSelected(false);
        i.setSelected(false);
        j.setSelected(false);
    }//GEN-LAST:event_simpanActionPerformed

    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Apotek().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox a;
    private javax.swing.JCheckBox b;
    private javax.swing.JCheckBox c;
    private javax.swing.JCheckBox d;
    private javax.swing.JCheckBox e;
    private javax.swing.JCheckBox f;
    private javax.swing.JCheckBox g;
    private javax.swing.JCheckBox h;
    private javax.swing.JCheckBox i;
    private javax.swing.JCheckBox j;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables
}
