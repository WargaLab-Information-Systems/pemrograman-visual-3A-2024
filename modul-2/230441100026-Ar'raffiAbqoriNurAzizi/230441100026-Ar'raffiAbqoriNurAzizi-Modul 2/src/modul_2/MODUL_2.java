package modul_2;

import javax.swing.Icon;
import javax.swing.JOptionPane;

public class MODUL_2 extends javax.swing.JFrame {
    Icon sukses = new javax.swing.ImageIcon(getClass().getResource("/modul_2/sukses.png"));
    Icon logo = new javax.swing.ImageIcon(getClass().getResource("/modul_2/logo.png"));
    int jumlahBeli = 0;
    
    public MODUL_2() {
        initComponents();
        jumlahBeli = 0;
        tfKembalian.setEditable(false);
        tfTotal.setEditable(false);
        tfDiskon.setEditable(false);
        tfJumlah.setEditable(false);
//        tfJumlah.setText("0");
    }

    @SuppressWarnings("unchecked")
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGmenu = new javax.swing.ButtonGroup();
        BGtopping = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        Seblak1 = new javax.swing.JRadioButton();
        Seblak2 = new javax.swing.JRadioButton();
        Seblak8 = new javax.swing.JRadioButton();
        Seblak4 = new javax.swing.JRadioButton();
        Seblak3 = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Seblak5 = new javax.swing.JRadioButton();
        Seblak6 = new javax.swing.JRadioButton();
        Seblak7 = new javax.swing.JRadioButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        Topping1 = new javax.swing.JRadioButton();
        Topping2 = new javax.swing.JRadioButton();
        Topping3 = new javax.swing.JRadioButton();
        Topping4 = new javax.swing.JRadioButton();
        Topping5 = new javax.swing.JRadioButton();
        Topping6 = new javax.swing.JRadioButton();
        Topping7 = new javax.swing.JRadioButton();
        Topping8 = new javax.swing.JRadioButton();
        Topping9 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        plus = new javax.swing.JButton();
        minus = new javax.swing.JButton();
        tfTotal = new javax.swing.JTextField();
        btTOTAL = new javax.swing.JButton();
        tfDiskon = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfKembalian = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfPembayaran = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Keluar = new javax.swing.JButton();
        btRESET = new javax.swing.JButton();
        tfJumlah = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(910, 650));
        setUndecorated(true);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/Seblak Jeletot.png"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 170));

        jPanel3.setBackground(new java.awt.Color(163, 29, 34));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Polos.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        BGmenu.add(Seblak1);
        Seblak1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak1.setForeground(new java.awt.Color(255, 255, 255));
        Seblak1.setText("Seblak Polos");

        BGmenu.add(Seblak2);
        Seblak2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak2.setForeground(new java.awt.Color(255, 255, 255));
        Seblak2.setText("Seblak Spesial");

        BGmenu.add(Seblak8);
        Seblak8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak8.setForeground(new java.awt.Color(255, 255, 255));
        Seblak8.setText("Seblak Mie");

        BGmenu.add(Seblak4);
        Seblak4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak4.setForeground(new java.awt.Color(255, 255, 255));
        Seblak4.setText("Seblak Ceker");

        BGmenu.add(Seblak3);
        Seblak3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak3.setForeground(new java.awt.Color(255, 255, 255));
        Seblak3.setText("Seblak Cireng");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 51));
        jLabel12.setText("Menu Seblak Mang Amba :");

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 51));
        jLabel13.setText("Tambahan Topping :");

        BGmenu.add(Seblak5);
        Seblak5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak5.setForeground(new java.awt.Color(255, 255, 255));
        Seblak5.setText("Seblak Bakso");

        BGmenu.add(Seblak6);
        Seblak6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak6.setForeground(new java.awt.Color(255, 255, 255));
        Seblak6.setText("Seblak Komplit");

        BGmenu.add(Seblak7);
        Seblak7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Seblak7.setForeground(new java.awt.Color(255, 255, 255));
        Seblak7.setText("Seblak Kerupuk");

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Bakso.png"))); // NOI18N
        jLabel17.setText("jLabel3");

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Mie.png"))); // NOI18N
        jLabel18.setText("jLabel3");

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Ceker.png"))); // NOI18N
        jLabel19.setText("jLabel3");

        jLabel20.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Komplit.png"))); // NOI18N
        jLabel20.setText("jLabel3");

        jLabel21.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Spesial.png"))); // NOI18N
        jLabel21.setText("jLabel3");

        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Cireng.png"))); // NOI18N
        jLabel22.setText("jLabel3");

        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul_2/IMAGES/MENU/Seblak Kerupuk.png"))); // NOI18N
        jLabel23.setText("jLabel3");

        BGtopping.add(Topping1);
        Topping1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping1.setForeground(new java.awt.Color(255, 255, 255));
        Topping1.setText("Pilus  ( Rp. 2.000 )");

        BGtopping.add(Topping2);
        Topping2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping2.setForeground(new java.awt.Color(255, 255, 255));
        Topping2.setText("Kerupuk  ( Rp. 2.000 )");

        BGtopping.add(Topping3);
        Topping3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping3.setForeground(new java.awt.Color(255, 255, 255));
        Topping3.setText("Sosis  ( Rp. 2.000 )");

        BGtopping.add(Topping4);
        Topping4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping4.setForeground(new java.awt.Color(255, 255, 255));
        Topping4.setText("Telur  ( Rp. 3.000 )");

        BGtopping.add(Topping5);
        Topping5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping5.setForeground(new java.awt.Color(255, 255, 255));
        Topping5.setText("Mie  ( Rp. 3.000 )");

        BGtopping.add(Topping6);
        Topping6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping6.setForeground(new java.awt.Color(255, 255, 255));
        Topping6.setText("Cireng  ( Rp. 3.000 )");

        BGtopping.add(Topping7);
        Topping7.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping7.setForeground(new java.awt.Color(255, 255, 255));
        Topping7.setText("Dumpling  ( Rp. 3.000 )");

        BGtopping.add(Topping8);
        Topping8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping8.setForeground(new java.awt.Color(255, 255, 255));
        Topping8.setText("Siomay Kering  ( Rp. 3.000 )");

        BGtopping.add(Topping9);
        Topping9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        Topping9.setForeground(new java.awt.Color(255, 255, 255));
        Topping9.setText("Tulang Rangu  ( Rp. 5.000 )");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Seblak1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addComponent(Seblak2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(Seblak3, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Seblak4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel12)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Topping2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Topping3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Topping1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Topping4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Topping6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Topping5, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Topping8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Topping7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Topping9, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Seblak5, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel3Layout.createSequentialGroup()
                                                .addGap(148, 148, 148)
                                                .addComponent(Seblak6, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(37, 37, 37)
                                                .addComponent(Seblak7, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(Seblak8, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(29, 29, 29))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Seblak2)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Seblak3)
                            .addComponent(Seblak4))
                        .addComponent(Seblak1)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Seblak6)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Seblak7)
                            .addComponent(Seblak8))
                        .addComponent(Seblak5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Topping1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Topping2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Topping3))
                        .addGroup(jPanel3Layout.createSequentialGroup()
                            .addComponent(Topping4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Topping5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Topping6)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(Topping7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Topping8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Topping9)))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 610, 470));

        jPanel4.setBackground(new java.awt.Color(82, 30, 16));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("JUMLAH : ");

        plus.setText("+");
        plus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                plusActionPerformed(evt);
            }
        });

        minus.setText("-");
        minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minusActionPerformed(evt);
            }
        });

        btTOTAL.setText("TOTAL");
        btTOTAL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTOTALActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Diskon :");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Kembalian anda :");

        tfPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfPembayaranActionPerformed(evt);
            }
        });
        tfPembayaran.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfPembayaranKeyReleased(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Masukkan Uang anda : ");

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("INFORMASI PESANAN ANDA !!!");

        Keluar.setText("KELUAR");
        Keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KeluarActionPerformed(evt);
            }
        });

        btRESET.setText("RESET");
        btRESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRESETActionPerformed(evt);
            }
        });

        tfJumlah.setBackground(new java.awt.Color(0, 0, 0));
        tfJumlah.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        tfJumlah.setForeground(new java.awt.Color(255, 255, 255));
        tfJumlah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfJumlah.setText("0");
        tfJumlah.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        tfJumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfJumlahActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(tfDiskon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(tfPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(btRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(Keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(86, 86, 86))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btTOTAL, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addComponent(jLabel4))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(tfTotal)
                                .addGroup(jPanel4Layout.createSequentialGroup()
                                    .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(tfJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(plus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(minus, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addComponent(tfJumlah))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btTOTAL, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfDiskon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tfPembayaran, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(tfKembalian, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Keluar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btRESET, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 290, 470));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void KeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KeluarActionPerformed

        if (JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION,HEIGHT, logo) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_KeluarActionPerformed

    private void plusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_plusActionPerformed
        // TODO add your handling code here:
        jumlahBeli+=1;
        tfJumlah.setText(String.valueOf(jumlahBeli));
    }//GEN-LAST:event_plusActionPerformed

    private void minusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusActionPerformed

        // Kurangi 1 dari jumlah pembelian jika jumlah lebih dari 0
        if (jumlahBeli > 0) {
            jumlahBeli-=1;
        } else {
            JOptionPane.showMessageDialog(this, "Pesan tidak boleh kurang dari 0", "INI PERINGATAN", JOptionPane.WARNING_MESSAGE);
        }
        tfJumlah.setText(String.valueOf(jumlahBeli));
    }//GEN-LAST:event_minusActionPerformed

    private void btRESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRESETActionPerformed
        // TODO add your handling code here:
        BGmenu.clearSelection();
        BGtopping.clearSelection();
        tfJumlah.setText("0");
        tfTotal.setText("");
        tfPembayaran.setText("");
        tfKembalian.setText("");
        tfDiskon.setText("");
        int Harga_total= 0;
        int jumlahBeli = 0;
        if(jumlahBeli==0){      
            System.out.println("berhasils");
        }
        int diskon = 0;
        tfJumlah.setText(String.valueOf(jumlahBeli));
    }//GEN-LAST:event_btRESETActionPerformed

    private void btTOTALActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTOTALActionPerformed
        // TODO add your handling code here:
        int menu = 0;
        int topping = 0;
        int Harga_total = 0;
        int diskon = 0;

        int jumlahBeli = Integer.parseInt(tfJumlah.getText());
            if (jumlahBeli <= 0) {
                JOptionPane.showMessageDialog(null, "Jumlah pembelian minimal 1!", "Peringatan", JOptionPane.WARNING_MESSAGE, logo);
                return;
            }
            if (jumlahBeli == 1) {
                JOptionPane.showMessageDialog(null, "Anda sudah memesan", ":)", JOptionPane.WARNING_MESSAGE, logo);
            }
        
        
        if(BGmenu.getSelection()== null ){
            tfJumlah.setText("0");
            tfTotal.setText("0");
            JOptionPane.showMessageDialog(null, "Pilih salah satu menu dulu yaaa!!", "-_-", JOptionPane.WARNING_MESSAGE, logo);
            return;
        }else {
            if(Seblak1.isSelected()){
                menu = 12000;
            } else if(Seblak2.isSelected()){
                menu = 18000;
            } else if(Seblak3.isSelected()){
                menu = 12000;
            } else if(Seblak4.isSelected()){
                menu = 12000;
            } else if(Seblak5.isSelected()){
                menu = 12000;
            } else if(Seblak6.isSelected()){
                menu = 18000;
            } else if(Seblak7.isSelected()){
                menu = 12000;
            } else if(Seblak8.isSelected()){
                menu = 12000;
            }
            
            if(Topping1.isSelected()){
                topping = 2000;
            } else if(Topping2.isSelected()){
                topping = 2000;
            } else if(Topping3.isSelected()){
                topping = 2000;
            } else if(Topping4.isSelected()){
                topping = 3000;
            } else if(Topping5.isSelected()){
                topping = 3000;
            } else if(Topping6.isSelected()){
                topping = 3000;
            } else if(Topping7.isSelected()){
                topping = 3000;
            } else if(Topping8.isSelected()){
                topping = 3000;
            } else if(Topping9.isSelected()){
                topping = 5000;
            }
        
            int totalHarga = jumlahBeli * (menu + topping);
            if (totalHarga > 100000) {
                diskon = (int) (totalHarga * 0.05); //  diskon 5%
                tfDiskon.setText(String.valueOf("Rp. " + diskon));
                totalHarga = totalHarga - diskon;
                tfTotal.setText(String.valueOf("Rp. " + totalHarga));
                JOptionPane.showMessageDialog(this, "Berhasil Mendapatkan diskon pembayaran!", "Peringatan", JOptionPane.WARNING_MESSAGE,sukses);
            } else {
                tfDiskon.setText("0");
                tfTotal.setText(String.valueOf("Rp. " + totalHarga));
            }
            
            if (BGmenu.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Harap pilih menu roti dan topping dahulu!");
            }
        }
    }//GEN-LAST:event_btTOTALActionPerformed

    private void tfJumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfJumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfJumlahActionPerformed

    private void tfPembayaranKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPembayaranKeyReleased
        // TODO add your handling code here:
        try{
            int Harga_total = Integer.parseInt(tfTotal.getText().replace("Rp. ", ""));
            int cash = Integer.parseInt(tfPembayaran.getText());
            
            if (cash < Harga_total){
                tfKembalian.setText("Uang anda kurang");
            } else {
                int kembalian = cash - Harga_total;
                tfKembalian.setText(String.valueOf("Rp. " + kembalian));        
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Masukkan Angka");
            tfKembalian.setText("Masukkan angka saja");
        }
    }//GEN-LAST:event_tfPembayaranKeyReleased

    private void tfPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfPembayaranActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfPembayaranActionPerformed

    public static void main(String args[]) {
        
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
            java.util.logging.Logger.getLogger(MODUL_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MODUL_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MODUL_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MODUL_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MODUL_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGmenu;
    private javax.swing.ButtonGroup BGtopping;
    private javax.swing.JButton Keluar;
    public javax.swing.JRadioButton Seblak1;
    public javax.swing.JRadioButton Seblak2;
    public javax.swing.JRadioButton Seblak3;
    public javax.swing.JRadioButton Seblak4;
    public javax.swing.JRadioButton Seblak5;
    public javax.swing.JRadioButton Seblak6;
    public javax.swing.JRadioButton Seblak7;
    public javax.swing.JRadioButton Seblak8;
    public javax.swing.JRadioButton Topping1;
    public javax.swing.JRadioButton Topping2;
    public javax.swing.JRadioButton Topping3;
    public javax.swing.JRadioButton Topping4;
    public javax.swing.JRadioButton Topping5;
    public javax.swing.JRadioButton Topping6;
    public javax.swing.JRadioButton Topping7;
    public javax.swing.JRadioButton Topping8;
    public javax.swing.JRadioButton Topping9;
    private javax.swing.JButton btRESET;
    private javax.swing.JButton btTOTAL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public javax.swing.JButton minus;
    public javax.swing.JButton plus;
    private javax.swing.JTextField tfDiskon;
    private javax.swing.JTextField tfJumlah;
    private javax.swing.JTextField tfKembalian;
    private javax.swing.JTextField tfPembayaran;
    private javax.swing.JTextField tfTotal;
    // End of variables declaration//GEN-END:variables
}
