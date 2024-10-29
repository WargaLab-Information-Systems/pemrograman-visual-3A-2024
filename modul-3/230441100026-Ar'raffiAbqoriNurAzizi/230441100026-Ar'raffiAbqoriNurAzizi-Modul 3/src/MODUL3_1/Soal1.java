package MODUL3_1;

import java.awt.Color;
import java.awt.Insets;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import java.awt.CardLayout;
import javax.swing.ImageIcon;



public class Soal1 extends javax.swing.JFrame {
    Icon logo = new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/logos.png"));

    public Soal1() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tengah = new javax.swing.JPanel();
        Jutama = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel22 = new javax.swing.JPanel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        Jmigrain = new javax.swing.JPanel();
        judulMigrain = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton8 = new javax.swing.JButton();
        jCBpanadol = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        labelparamex = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jCBparamex = new javax.swing.JCheckBox();
        jLabel15 = new javax.swing.JLabel();
        Jdemam = new javax.swing.JPanel();
        judulMigrain1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        jCBparacetamol = new javax.swing.JCheckBox();
        jLabel18 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jButton11 = new javax.swing.JButton();
        jCBsanmol = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        Jlinu = new javax.swing.JPanel();
        judulMigrain2 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();
        jCBcounterpain = new javax.swing.JCheckBox();
        jLabel24 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jButton13 = new javax.swing.JButton();
        jCBneuromacyl = new javax.swing.JCheckBox();
        Jflu = new javax.swing.JPanel();
        judulMigrain3 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        jCBvicksformula = new javax.swing.JCheckBox();
        jLabel30 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jCBpanadolcold = new javax.swing.JCheckBox();
        jLabel35 = new javax.swing.JLabel();
        Jradang = new javax.swing.JPanel();
        judulMigrain4 = new javax.swing.JLabel();
        jPanel18 = new javax.swing.JPanel();
        jPanel19 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jButton16 = new javax.swing.JButton();
        jCBdegirol = new javax.swing.JCheckBox();
        jLabel38 = new javax.swing.JLabel();
        jPanel20 = new javax.swing.JPanel();
        jPanel21 = new javax.swing.JPanel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jButton17 = new javax.swing.JButton();
        jCBmethilprednisolone = new javax.swing.JCheckBox();
        jLabel41 = new javax.swing.JLabel();
        atas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bawah = new javax.swing.JPanel();
        keluar = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        kanan = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        JDetailGambar = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        JNamaObat = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jDosis = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jIndikasi = new javax.swing.JTextArea();
        kiri = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        migrain = new javax.swing.JButton();
        demam = new javax.swing.JButton();
        linu = new javax.swing.JButton();
        flu = new javax.swing.JButton();
        radang = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(900, 700));

        jPanel1.setPreferredSize(new java.awt.Dimension(950, 700));
        jPanel1.setLayout(new java.awt.BorderLayout());

        tengah.setBackground(new java.awt.Color(153, 255, 51));
        tengah.setForeground(new java.awt.Color(255, 204, 153));
        tengah.setPreferredSize(new java.awt.Dimension(400, 300));
        tengah.setLayout(new java.awt.CardLayout());

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel31.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel31.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel31.setText("Apa Gejala yang anda rasakan?");

        jLabel32.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel32.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel32.setText("Silahkan Memilih gejala yang dialami pada bagian menu kiri :)");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/PANADOL-Migrain.jpg"))); // NOI18N
        jLabel8.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/PARAMEX-Migrain.jpg"))); // NOI18N
        jLabel42.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/PARACETAMOL-demam.jpg"))); // NOI18N
        jLabel46.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/SANMOL-demam.jpg"))); // NOI18N
        jLabel47.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Counterpain-linu.jpg"))); // NOI18N
        jLabel48.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/NeoRheumacyl-linu.jpg"))); // NOI18N
        jLabel49.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Panadol-Flu (2).jpg"))); // NOI18N
        jLabel50.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel51.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Panadol-Flu.jpg"))); // NOI18N
        jLabel51.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Degirol-Radang.jpg"))); // NOI18N
        jLabel52.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Methylprednisolone-Radang.jpg"))); // NOI18N
        jLabel53.setPreferredSize(new java.awt.Dimension(100, 66));

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel31))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32)
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel22Layout.createSequentialGroup()
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel22Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel52, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel22);

        javax.swing.GroupLayout JutamaLayout = new javax.swing.GroupLayout(Jutama);
        Jutama.setLayout(JutamaLayout);
        JutamaLayout.setHorizontalGroup(
            JutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3)
        );
        JutamaLayout.setVerticalGroup(
            JutamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JutamaLayout.createSequentialGroup()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 562, Short.MAX_VALUE)
                .addContainerGap())
        );

        tengah.add(Jutama, "card2");

        Jmigrain.setBackground(new java.awt.Color(255, 255, 255));
        Jmigrain.setPreferredSize(new java.awt.Dimension(400, 300));

        judulMigrain.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        judulMigrain.setText("OBAT UNTUK GEJALA MIGRAIN - SAKIT KEPALA :");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/PANADOL-Migrain.jpg"))); // NOI18N
        jLabel7.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Panadol Extra");
        jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel11.setIconTextGap(50);

        jButton8.setBackground(new java.awt.Color(51, 204, 0));
        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("DETAIL");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jCBpanadol.setText("Rp. 14.000 / Strip");
        jCBpanadol.setBorderPaintedFlat(true);
        jCBpanadol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBpanadol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBpanadol.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBpanadol.setIconTextGap(10);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("NAMA OBAT :");
        jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel12.setIconTextGap(50);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBpanadol, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jCBpanadol, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jLabel11.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/PARAMEX-Migrain.jpg"))); // NOI18N
        jLabel13.setPreferredSize(new java.awt.Dimension(100, 66));

        labelparamex.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        labelparamex.setForeground(new java.awt.Color(255, 0, 0));
        labelparamex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelparamex.setText("PARAMEX");
        labelparamex.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        labelparamex.setIconTextGap(50);

        jButton9.setBackground(new java.awt.Color(51, 204, 0));
        jButton9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton9.setForeground(new java.awt.Color(255, 255, 255));
        jButton9.setText("DETAIL");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jCBparamex.setText("Rp. 3.000 / Strip");
        jCBparamex.setBorderPaintedFlat(true);
        jCBparamex.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBparamex.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBparamex.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBparamex.setIconTextGap(10);

        jLabel15.setBackground(new java.awt.Color(255, 255, 255));
        jLabel15.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("NAMA OBAT :");
        jLabel15.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel15.setIconTextGap(50);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelparamex, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBparamex, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelparamex, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBparamex, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JmigrainLayout = new javax.swing.GroupLayout(Jmigrain);
        Jmigrain.setLayout(JmigrainLayout);
        JmigrainLayout.setHorizontalGroup(
            JmigrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JmigrainLayout.createSequentialGroup()
                .addGroup(JmigrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JmigrainLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(judulMigrain))
                    .addGroup(JmigrainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JmigrainLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JmigrainLayout.setVerticalGroup(
            JmigrainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JmigrainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulMigrain, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tengah.add(Jmigrain, "card3");

        Jdemam.setBackground(new java.awt.Color(255, 255, 255));

        judulMigrain1.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        judulMigrain1.setText("OBAT UNTUK GEJALA DEMAM :");

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/PARACETAMOL-demam.jpg"))); // NOI18N
        jLabel16.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel17.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 0, 0));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("PARACETAMOL");
        jLabel17.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel17.setIconTextGap(50);

        jButton10.setBackground(new java.awt.Color(51, 204, 0));
        jButton10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("DETAIL");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        jCBparacetamol.setText("Rp 3.800 / Strip");
        jCBparacetamol.setBorderPaintedFlat(true);
        jCBparacetamol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBparacetamol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBparacetamol.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBparacetamol.setIconTextGap(10);

        jLabel18.setBackground(new java.awt.Color(255, 255, 255));
        jLabel18.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("NAMA OBAT :");
        jLabel18.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel18.setIconTextGap(50);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBparacetamol, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jCBparacetamol, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(26, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/SANMOL-demam.jpg"))); // NOI18N
        jLabel19.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 0, 0));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("SANMOL");
        jLabel20.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel20.setIconTextGap(50);

        jButton11.setBackground(new java.awt.Color(51, 204, 0));
        jButton11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton11.setForeground(new java.awt.Color(255, 255, 255));
        jButton11.setText("DETAIL");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        jCBsanmol.setText("Rp 3.000 / Strip");
        jCBsanmol.setBorderPaintedFlat(true);
        jCBsanmol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBsanmol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBsanmol.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBsanmol.setIconTextGap(10);

        jLabel21.setBackground(new java.awt.Color(255, 255, 255));
        jLabel21.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("NAMA OBAT :");
        jLabel21.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel21.setIconTextGap(50);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBsanmol, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBsanmol, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout JdemamLayout = new javax.swing.GroupLayout(Jdemam);
        Jdemam.setLayout(JdemamLayout);
        JdemamLayout.setHorizontalGroup(
            JdemamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdemamLayout.createSequentialGroup()
                .addGroup(JdemamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JdemamLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(judulMigrain1))
                    .addGroup(JdemamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JdemamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JdemamLayout.setVerticalGroup(
            JdemamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JdemamLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulMigrain1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );

        tengah.add(Jdemam, "card4");

        Jlinu.setBackground(new java.awt.Color(255, 255, 255));

        judulMigrain2.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        judulMigrain2.setText("OBAT UNTUK GEJALA LINU :");

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Counterpain-linu.jpg"))); // NOI18N
        jLabel22.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel23.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 0, 0));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("COUNTERPAIN");
        jLabel23.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel23.setIconTextGap(50);

        jButton12.setBackground(new java.awt.Color(51, 204, 0));
        jButton12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton12.setForeground(new java.awt.Color(255, 255, 255));
        jButton12.setText("DETAIL");
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });

        jCBcounterpain.setText("Rp 33.800 / tube");
        jCBcounterpain.setBorderPaintedFlat(true);
        jCBcounterpain.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBcounterpain.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBcounterpain.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBcounterpain.setIconTextGap(10);

        jLabel24.setBackground(new java.awt.Color(255, 255, 255));
        jLabel24.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("NAMA OBAT :");
        jLabel24.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel24.setIconTextGap(50);

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBcounterpain, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jCBcounterpain, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));
        jPanel13.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/NeoRheumacyl-linu.jpg"))); // NOI18N
        jLabel25.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel26.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 0, 0));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("NEORHEMACYL");
        jLabel26.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel26.setIconTextGap(50);

        jButton13.setBackground(new java.awt.Color(51, 204, 0));
        jButton13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton13.setForeground(new java.awt.Color(255, 255, 255));
        jButton13.setText("DETAIL");
        jButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton13ActionPerformed(evt);
            }
        });

        jCBneuromacyl.setText("Rp 11.600 / Strip");
        jCBneuromacyl.setBorderPaintedFlat(true);
        jCBneuromacyl.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBneuromacyl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBneuromacyl.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBneuromacyl.setIconTextGap(10);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBneuromacyl, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBneuromacyl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 219, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JlinuLayout = new javax.swing.GroupLayout(Jlinu);
        Jlinu.setLayout(JlinuLayout);
        JlinuLayout.setHorizontalGroup(
            JlinuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JlinuLayout.createSequentialGroup()
                .addGroup(JlinuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JlinuLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(judulMigrain2))
                    .addGroup(JlinuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JlinuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JlinuLayout.setVerticalGroup(
            JlinuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JlinuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulMigrain2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tengah.add(Jlinu, "card5");

        Jflu.setBackground(new java.awt.Color(255, 255, 255));

        judulMigrain3.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        judulMigrain3.setText("OBAT UNTUK GEJALA FLU - PILEK :");

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Panadol-Flu (2).jpg"))); // NOI18N
        jLabel28.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel29.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 0));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("VICKS Formula 44");
        jLabel29.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel29.setIconTextGap(50);

        jButton14.setBackground(new java.awt.Color(51, 204, 0));
        jButton14.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton14.setForeground(new java.awt.Color(255, 255, 255));
        jButton14.setText("DETAIL");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });

        jCBvicksformula.setText("Rp 32.800 / Botol");
        jCBvicksformula.setBorderPaintedFlat(true);
        jCBvicksformula.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBvicksformula.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBvicksformula.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBvicksformula.setIconTextGap(10);

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("NAMA OBAT :");
        jLabel30.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel30.setIconTextGap(50);

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBvicksformula, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jCBvicksformula, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 238, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Panadol-Flu.jpg"))); // NOI18N
        jLabel33.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel34.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 0, 0));
        jLabel34.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel34.setText("Panadol Cold & Flu");
        jLabel34.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel34.setIconTextGap(50);

        jButton15.setBackground(new java.awt.Color(51, 204, 0));
        jButton15.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton15.setForeground(new java.awt.Color(255, 255, 255));
        jButton15.setText("DETAIL");
        jButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton15ActionPerformed(evt);
            }
        });

        jCBpanadolcold.setText("Rp 18.700 / Strip");
        jCBpanadolcold.setBorderPaintedFlat(true);
        jCBpanadolcold.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBpanadolcold.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBpanadolcold.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBpanadolcold.setIconTextGap(10);

        jLabel35.setBackground(new java.awt.Color(255, 255, 255));
        jLabel35.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel35.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel35.setText("NAMA OBAT :");
        jLabel35.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel35.setIconTextGap(50);

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel34, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addComponent(jCBpanadolcold, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)))
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel33, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jCBpanadolcold, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JfluLayout = new javax.swing.GroupLayout(Jflu);
        Jflu.setLayout(JfluLayout);
        JfluLayout.setHorizontalGroup(
            JfluLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfluLayout.createSequentialGroup()
                .addGroup(JfluLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JfluLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(judulMigrain3))
                    .addGroup(JfluLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JfluLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JfluLayout.setVerticalGroup(
            JfluLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JfluLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulMigrain3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tengah.add(Jflu, "card6");

        Jradang.setBackground(new java.awt.Color(255, 255, 255));

        judulMigrain4.setFont(new java.awt.Font("Arial Black", 0, 14)); // NOI18N
        judulMigrain4.setText("OBAT UNTUK GEJALA RADANG - SAKIT TENGGOROKAN :");

        jPanel19.setBackground(new java.awt.Color(255, 255, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel36.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Degirol-Radang.jpg"))); // NOI18N
        jLabel36.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel37.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 0, 0));
        jLabel37.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel37.setText("DEGIROL");
        jLabel37.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel37.setIconTextGap(50);

        jButton16.setBackground(new java.awt.Color(51, 204, 0));
        jButton16.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton16.setForeground(new java.awt.Color(255, 255, 255));
        jButton16.setText("DETAIL");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });

        jCBdegirol.setText("Rp 30.700 / box");
        jCBdegirol.setBorderPaintedFlat(true);
        jCBdegirol.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBdegirol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBdegirol.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBdegirol.setIconTextGap(10);

        jLabel38.setBackground(new java.awt.Color(255, 255, 255));
        jLabel38.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("NAMA OBAT :");
        jLabel38.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel38.setIconTextGap(50);

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCBdegirol, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jCBdegirol, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel36, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel21.setBackground(new java.awt.Color(255, 255, 255));
        jPanel21.setPreferredSize(new java.awt.Dimension(170, 150));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/OBAT/Methylprednisolone-Radang.jpg"))); // NOI18N
        jLabel39.setPreferredSize(new java.awt.Dimension(100, 66));

        jLabel40.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 0, 0));
        jLabel40.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel40.setText("Methylprednisolone");
        jLabel40.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel40.setIconTextGap(50);

        jButton17.setBackground(new java.awt.Color(51, 204, 0));
        jButton17.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton17.setForeground(new java.awt.Color(255, 255, 255));
        jButton17.setText("DETAIL");
        jButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton17ActionPerformed(evt);
            }
        });

        jCBmethilprednisolone.setText("Rp 8.600 / strip");
        jCBmethilprednisolone.setBorderPaintedFlat(true);
        jCBmethilprednisolone.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jCBmethilprednisolone.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jCBmethilprednisolone.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jCBmethilprednisolone.setIconTextGap(10);

        jLabel41.setBackground(new java.awt.Color(255, 255, 255));
        jLabel41.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabel41.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel41.setText("NAMA OBAT :");
        jLabel41.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel41.setIconTextGap(50);

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCBmethilprednisolone, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel21Layout.createSequentialGroup()
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jCBmethilprednisolone, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );

        javax.swing.GroupLayout jPanel20Layout = new javax.swing.GroupLayout(jPanel20);
        jPanel20.setLayout(jPanel20Layout);
        jPanel20Layout.setHorizontalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel20Layout.setVerticalGroup(
            jPanel20Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel20Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel21, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout JradangLayout = new javax.swing.GroupLayout(Jradang);
        Jradang.setLayout(JradangLayout);
        JradangLayout.setHorizontalGroup(
            JradangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JradangLayout.createSequentialGroup()
                .addGroup(JradangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(JradangLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(judulMigrain4))
                    .addGroup(JradangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(JradangLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JradangLayout.setVerticalGroup(
            JradangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JradangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judulMigrain4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tengah.add(Jradang, "card7");

        jPanel1.add(tengah, java.awt.BorderLayout.CENTER);
        tengah.getAccessibleContext().setAccessibleName("");

        atas.setBackground(new java.awt.Color(255, 255, 255));
        atas.setPreferredSize(new java.awt.Dimension(1000, 90));
        atas.setLayout(new java.awt.BorderLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/2.png"))); // NOI18N
        atas.add(jLabel2, java.awt.BorderLayout.CENTER);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/1.png"))); // NOI18N
        atas.add(jLabel3, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(atas, java.awt.BorderLayout.PAGE_START);

        bawah.setBackground(new java.awt.Color(255, 255, 255));
        bawah.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bawah.setPreferredSize(new java.awt.Dimension(800, 60));

        keluar.setBackground(new java.awt.Color(204, 221, 240));
        keluar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        keluar.setText("KELUAR");
        keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                keluarActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(255, 151, 0));
        reset.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout bawahLayout = new javax.swing.GroupLayout(bawah);
        bawah.setLayout(bawahLayout);
        bawahLayout.setHorizontalGroup(
            bawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, bawahLayout.createSequentialGroup()
                .addContainerGap(710, Short.MAX_VALUE)
                .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        bawahLayout.setVerticalGroup(
            bawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bawahLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(bawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1.add(bawah, java.awt.BorderLayout.PAGE_END);

        kanan.setBackground(new java.awt.Color(255, 255, 255));
        kanan.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        kanan.setPreferredSize(new java.awt.Dimension(300, 353));

        jLabel10.setBackground(new java.awt.Color(0, 0, 0));
        jLabel10.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(45, 71, 127));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("DOSIS :");
        jLabel10.setToolTipText("");

        JDetailGambar.setBackground(new java.awt.Color(0, 0, 0));
        JDetailGambar.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        JDetailGambar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jLabel43.setBackground(new java.awt.Color(0, 0, 0));
        jLabel43.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(45, 71, 127));
        jLabel43.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel43.setText("INFORMASI DETAIL OBAT ANDA !!!");

        jLabel44.setBackground(new java.awt.Color(0, 0, 0));
        jLabel44.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(45, 71, 127));
        jLabel44.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel44.setText("INDIKASI UMUM :");
        jLabel44.setToolTipText("");

        jLabel45.setBackground(new java.awt.Color(0, 0, 0));
        jLabel45.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(45, 71, 127));
        jLabel45.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel45.setText("Nama Obat :");
        jLabel45.setToolTipText("");

        JNamaObat.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        JNamaObat.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        jDosis.setColumns(20);
        jDosis.setRows(5);
        jScrollPane1.setViewportView(jDosis);

        jIndikasi.setColumns(20);
        jIndikasi.setRows(5);
        jScrollPane2.setViewportView(jIndikasi);

        javax.swing.GroupLayout kananLayout = new javax.swing.GroupLayout(kanan);
        kanan.setLayout(kananLayout);
        kananLayout.setHorizontalGroup(
            kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kananLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JNamaObat)
                    .addComponent(JDetailGambar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(kananLayout.createSequentialGroup()
                        .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 4, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );
        kananLayout.setVerticalGroup(
            kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kananLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JDetailGambar, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JNamaObat, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel1.add(kanan, java.awt.BorderLayout.LINE_END);

        kiri.setBackground(new java.awt.Color(255, 255, 255));
        kiri.setPreferredSize(new java.awt.Dimension(130, 353));
        kiri.setLayout(new java.awt.GridLayout(7, 0, 0, 10));

        jLabel1.setBackground(new java.awt.Color(56, 92, 168));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(56, 92, 168));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("DAFTAR GEJALA : ");
        kiri.add(jLabel1);

        migrain.setBackground(new java.awt.Color(255, 98, 68));
        migrain.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        migrain.setText("Migrain");
        migrain.setMaximumSize(new java.awt.Dimension(96, 35));
        migrain.setMinimumSize(new java.awt.Dimension(96, 35));
        migrain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                migrainActionPerformed(evt);
            }
        });
        kiri.add(migrain);

        demam.setBackground(new java.awt.Color(255, 98, 68));
        demam.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        demam.setText("Demam");
        demam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                demamActionPerformed(evt);
            }
        });
        kiri.add(demam);

        linu.setBackground(new java.awt.Color(255, 98, 68));
        linu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        linu.setText("Linu");
        linu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linuActionPerformed(evt);
            }
        });
        kiri.add(linu);

        flu.setBackground(new java.awt.Color(255, 98, 68));
        flu.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        flu.setText("Flu");
        flu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fluActionPerformed(evt);
            }
        });
        kiri.add(flu);

        radang.setBackground(new java.awt.Color(255, 98, 68));
        radang.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        radang.setText("Radang");
        radang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radangActionPerformed(evt);
            }
        });
        kiri.add(radang);

        jPanel1.add(kiri, java.awt.BorderLayout.LINE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 988, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 718, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void migrainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_migrainActionPerformed

        CardLayout c2 = (CardLayout) (tengah.getLayout());
        c2.show(tengah, "card3");
    }//GEN-LAST:event_migrainActionPerformed

    private void keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_keluarActionPerformed
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION,HEIGHT, logo) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_keluarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here
        int reset = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin menghapus pesanan?",
            "Konfirmasi", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (reset == JOptionPane.YES_OPTION) {
            jCBpanadol.setSelected(false);
            jCBparamex.setSelected(false);
            jCBparacetamol.setSelected(false);
            jCBsanmol.setSelected(false);
            jCBcounterpain.setSelected(false);
            jCBneuromacyl.setSelected(false);
            jCBvicksformula.setSelected(false);
            jCBpanadolcold.setSelected(false);
            jCBdegirol.setSelected(false);
            jCBmethilprednisolone.setSelected(false);
            JDetailGambar.setIcon(null);

            JNamaObat.setText("");
            jDosis.setText("");
            jIndikasi.setText("");
        } else{
            return;
        }
    }//GEN-LAST:event_resetActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/PANADOL-Migrain.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Panadol Extra");
        jDosis.setText("- Dewasa > 12 tahun   : 3x sehari\n"+"- Anak 6-12 tahun       : 2x sehari");
        jIndikasi.setText("- Meringankan sakit Kepala dan Sakit Gigi\n" +
        "- Paracetamol sebagai analgetik\n" +
        "- Mengurangi rasa nyeri.");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/PARAMEX-Migrain.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Paramex");
        jDosis.setText("- Dewasa dan Anak > 12 tahun   : 2-3x sehari");
        jIndikasi.setText("- Meringankan sakit Kepala dan Sakit Gigi\n" +
        "- Mengurangi rasa nyeri.\n");
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/PARACETAMOL-demam.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Paracetamol 500 mg");
        jDosis.setText("- Dewasa > 12 tahun     : 3x sehari\n"+"- Anak 7-12 tahun     : 2x sehari");
        jIndikasi.setText("- Meredakan nyeri ringan\n" +
        "- Meredakan nyeri seperti Sakit Kepala\n" +
        "- Meredakan nyeri seperti Sakit Gigi\n" +
        "- Meredakan nyeri Otot\n" +
        "- Serta menurunkan demam.");
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/SANMOL-demam.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Sanmol Forte");
        jDosis.setText("- Dewasa dan Anak > 12 tahun   : 2-3x sehari");
        jIndikasi.setText("- Meringankan sakit Kepala dan Sakit Gigi\n" +
        "- Menurunkan Demam.");
    }//GEN-LAST:event_jButton11ActionPerformed

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/Counterpain-linu.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Counterpain Cream 15 g");
        jDosis.setText("- Dewasa dan Anak       : 2-3x sehari");
        jIndikasi.setText("- Meringankan rasa sakit pada Otot\n" +
            "- Meringankan rasa sakit pada Nyeri Sendi\n" +
            "- Meringankan rasa Keseleo dan nyeri akibat Encok.");
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/NeoRheumacyl-linu.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Neo Rheumacyl Neuro");
        jDosis.setText("- Dewasa dan Anak > 12 tahun   : 2-3x sehari");
        jIndikasi.setText("- Meringankan rasa nyeri yang disertai Kebas\n" +
        "- Meringankan rasa ngilu atau Kesemutan dan Kram.");
    }//GEN-LAST:event_jButton13ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/Panadol-Flu (2).jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Vicks Formula 44 Sirup 100 ml");
        jDosis.setText("- Dewasa > 12 tahun   : 1-6x sehari\n" +
            "Anak 6-12 tahun :      1 sendok takar.");
        jIndikasi.setText("- Meringankan rasa nyeri yang disertai Kebas\n" +
        "- Meringankan rasa ngilu atau Kesemutan dan Kram.");
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/Panadol-Flu.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Panadol Cold & Flu 10 Kaplet");
        jDosis.setText("- Dewasa dan Anak > 12 tahun   : 2-3x sehari");
        jIndikasi.setText("- Meredakan gejala flu seperti :\n" +
        "- Demam, Sakit Kepala, Hidung Tersumbat dan Batuk Berdahak");
    }//GEN-LAST:event_jButton15ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/Degirol-Radang.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Degirol Hisap 0.25 mg 20 Tablet");
        jDosis.setText("- Dewasa   : 1 tablet dihisap maks 8 tablet perhari");
        jIndikasi.setText("- Sakit Tenggorokan\n" +
        "- Peradangan pada rongga mulut dan tenggorokan");
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
        // TODO add your handling code here:
        ImageIcon icon = new ImageIcon("src/MODUL3_1/OBAT/Methylprednisolone-Radang.jpg");
        JDetailGambar.setIcon(icon);
        JNamaObat.setText("Methylprednisolone 8 mg 10 Tablet");
        jDosis.setText("- Dewasa dan Anak > 12 tahun   : 2-3x sehari");
        jIndikasi.setText("- OBAT INI HANYA UNTUK KALANGAN MEDIS\n" +
        "- Untuk Keadaan Alergi dan Mengurangi peradangan.");
    }//GEN-LAST:event_jButton17ActionPerformed

    private void demamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_demamActionPerformed
        // TODO add your handling code here:
        CardLayout c3 = (CardLayout) (tengah.getLayout());
        c3.show(tengah, "card4");
    }//GEN-LAST:event_demamActionPerformed

    private void linuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linuActionPerformed
        // TODO add your handling code here:
        CardLayout c4 = (CardLayout) (tengah.getLayout());
        c4.show(tengah, "card5");
    }//GEN-LAST:event_linuActionPerformed

    private void fluActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fluActionPerformed
        // TODO add your handling code here:
        CardLayout c5 = (CardLayout) (tengah.getLayout());
        c5.show(tengah, "card6");
    }//GEN-LAST:event_fluActionPerformed

    private void radangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radangActionPerformed
        // TODO add your handling code here:
        CardLayout c6 = (CardLayout) (tengah.getLayout());
        c6.show(tengah, "card7");
    }//GEN-LAST:event_radangActionPerformed

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
            java.util.logging.Logger.getLogger(Soal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Soal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Soal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Soal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Soal1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JDetailGambar;
    private javax.swing.JTextField JNamaObat;
    private javax.swing.JPanel Jdemam;
    private javax.swing.JPanel Jflu;
    private javax.swing.JPanel Jlinu;
    private javax.swing.JPanel Jmigrain;
    private javax.swing.JPanel Jradang;
    private javax.swing.JPanel Jutama;
    private javax.swing.JPanel atas;
    private javax.swing.JPanel bawah;
    private javax.swing.JButton demam;
    private javax.swing.JButton flu;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton13;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCBcounterpain;
    private javax.swing.JCheckBox jCBdegirol;
    private javax.swing.JCheckBox jCBmethilprednisolone;
    private javax.swing.JCheckBox jCBneuromacyl;
    private javax.swing.JCheckBox jCBpanadol;
    private javax.swing.JCheckBox jCBpanadolcold;
    private javax.swing.JCheckBox jCBparacetamol;
    private javax.swing.JCheckBox jCBparamex;
    private javax.swing.JCheckBox jCBsanmol;
    private javax.swing.JCheckBox jCBvicksformula;
    private javax.swing.JTextArea jDosis;
    private javax.swing.JTextArea jIndikasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
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
    private javax.swing.JLabel judulMigrain;
    private javax.swing.JLabel judulMigrain1;
    private javax.swing.JLabel judulMigrain2;
    private javax.swing.JLabel judulMigrain3;
    private javax.swing.JLabel judulMigrain4;
    private javax.swing.JPanel kanan;
    private javax.swing.JButton keluar;
    private javax.swing.JPanel kiri;
    private javax.swing.JLabel labelparamex;
    private javax.swing.JButton linu;
    private javax.swing.JButton migrain;
    private javax.swing.JButton radang;
    private javax.swing.JButton reset;
    private javax.swing.JPanel tengah;
    // End of variables declaration//GEN-END:variables
}
