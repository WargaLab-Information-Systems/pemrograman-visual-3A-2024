/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul2;
import static java.lang.reflect.Array.set;
import javax.swing.JOptionPane;
        
/**
 *
 * @author LENOVO
 */
public class roti extends javax.swing.JFrame {
    
    double hargaRoti,hargaTopping;
    int jumlahPesanan;
    private Object[] totalHarga;

    /**
     * Creates new form roti
     */
    public roti() {
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
        jPanel6 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        susu = new javax.swing.JRadioButton();
        sosis = new javax.swing.JRadioButton();
        mayo = new javax.swing.JRadioButton();
        dagingsuwir = new javax.swing.JRadioButton();
        almond = new javax.swing.JRadioButton();
        abon = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        coklat = new javax.swing.JRadioButton();
        matcha = new javax.swing.JRadioButton();
        keju = new javax.swing.JRadioButton();
        blueberry = new javax.swing.JRadioButton();
        strawberry = new javax.swing.JRadioButton();
        kacang = new javax.swing.JRadioButton();
        coklatkeju = new javax.swing.JRadioButton();
        coklatkacang = new javax.swing.JRadioButton();
        strawberrykeju = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();
        tambah = new javax.swing.JButton();
        kurang = new javax.swing.JButton();
        total = new javax.swing.JTextField();
        jumlahpesanan = new javax.swing.JTextField();
        TFcash = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        kembali = new javax.swing.JTextField();
        hitung = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtdc = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();

        jPanel6.setBackground(new java.awt.Color(102, 255, 204));
        jPanel6.setForeground(new java.awt.Color(153, 255, 153));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 630, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 0, 51));
        jLabel1.setFont(new java.awt.Font("DialogInput", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("--Roti Lembut Selembut Hatiku--");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 360, 30));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("DialogInput", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Roti Gemoii!");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, 320, 40));

        jPanel2.setBackground(new java.awt.Color(153, 204, 255));

        buttonGroup1.add(susu);
        susu.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        susu.setText("Susu -Rp.3.000");
        susu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                susuActionPerformed(evt);
            }
        });

        buttonGroup1.add(sosis);
        sosis.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        sosis.setText("Sosis -Rp.8.000");
        sosis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sosisActionPerformed(evt);
            }
        });

        buttonGroup1.add(mayo);
        mayo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        mayo.setText("Mayo -Rp.7.000");

        buttonGroup1.add(dagingsuwir);
        dagingsuwir.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        dagingsuwir.setText("Daging Slice - Rp.8.000");
        dagingsuwir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dagingsuwirActionPerformed(evt);
            }
        });

        buttonGroup1.add(almond);
        almond.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        almond.setText("Almond -Rp.12.000");

        buttonGroup1.add(abon);
        abon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        abon.setText("Abon -Rp.8.000");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mayo)
                    .addComponent(dagingsuwir))
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(almond)
                    .addComponent(abon))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sosis)
                    .addComponent(susu))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sosis)
                    .addComponent(mayo)
                    .addComponent(almond))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dagingsuwir)
                    .addComponent(abon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(susu))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 630, 90));

        jPanel3.setBackground(new java.awt.Color(153, 204, 255));

        buttonGroup2.add(coklat);
        coklat.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        coklat.setText("Coklat -Rp.12.000");
        coklat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                coklatActionPerformed(evt);
            }
        });

        buttonGroup2.add(matcha);
        matcha.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        matcha.setText(" Matcha -Rp.18.000");

        buttonGroup2.add(keju);
        keju.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        keju.setText(" Keju -Rp.15.000");
        keju.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kejuActionPerformed(evt);
            }
        });

        buttonGroup2.add(blueberry);
        blueberry.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        blueberry.setText("Blueberry -Rp.18.000");
        blueberry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                blueberryActionPerformed(evt);
            }
        });

        buttonGroup2.add(strawberry);
        strawberry.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        strawberry.setText("Strawberry -Rp.15.000");

        buttonGroup2.add(kacang);
        kacang.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        kacang.setText("Kacang -Rp.18.000");

        buttonGroup2.add(coklatkeju);
        coklatkeju.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        coklatkeju.setText("Coklat Keju -Rp.15.000");

        buttonGroup2.add(coklatkacang);
        coklatkacang.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        coklatkacang.setText("Coklat Kacang -Rp.18.000");

        buttonGroup2.add(strawberrykeju);
        strawberrykeju.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        strawberrykeju.setText("Strawberry Keju -Rp.18.000");

        jPanel7.setBackground(new java.awt.Color(51, 153, 255));
        jPanel7.setForeground(new java.awt.Color(153, 255, 153));

        jLabel9.setFont(new java.awt.Font("Segoe UI Black", 2, 18)); // NOI18N
        jLabel9.setText("Pilihan Topping");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(244, 244, 244)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matcha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(coklat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(strawberry, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(strawberrykeju, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(kacang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(52, 52, 52))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(coklatkeju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(coklatkacang)
                                .addGap(22, 22, 22)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(blueberry, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(76, 76, 76))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(keju, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(108, 108, 108))))))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(coklat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keju)
                    .addComponent(coklatkeju))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(matcha)
                    .addComponent(coklatkacang)
                    .addComponent(blueberry))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(strawberry)
                    .addComponent(strawberrykeju)
                    .addComponent(kacang))
                .addGap(18, 18, 18)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 640, 160));

        reset.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });
        jPanel1.add(reset, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 440, 80, -1));

        tambah.setText("+");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });
        jPanel1.add(tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, -1, -1));

        kurang.setText("-");
        kurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kurangActionPerformed(evt);
            }
        });
        jPanel1.add(kurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 430, -1, -1));

        total.setEditable(false);
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });
        jPanel1.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 490, 160, -1));

        jumlahpesanan.setEditable(false);
        jPanel1.add(jumlahpesanan, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, 100, -1));

        TFcash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TFcashActionPerformed(evt);
            }
        });
        TFcash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TFcashKeyReleased(evt);
            }
        });
        jPanel1.add(TFcash, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 490, 120, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Total");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 470, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cash");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 470, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Kembali");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 470, -1, -1));

        kembali.setEditable(false);
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        jPanel1.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 490, 120, -1));

        hitung.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        hitung.setText("HITUNG");
        hitung.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(51, 153, 255), null, null));
        hitung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitungActionPerformed(evt);
            }
        });
        jPanel1.add(hitung, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, 70, 30));

        jPanel4.setBackground(new java.awt.Color(51, 153, 255));
        jPanel4.setForeground(new java.awt.Color(153, 255, 153));

        jLabel5.setFont(new java.awt.Font("Segoe UI Black", 3, 18)); // NOI18N
        jLabel5.setText("Pilihan Rasa");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(249, 249, 249)
                .addComponent(jLabel5)
                .addContainerGap(265, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 630, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul2/roti.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 100, 130));

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jButton1.setText("KELUAR");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 490, -1, -1));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/modul2/Bread.png"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, -1, -1));

        txtdc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdcActionPerformed(evt);
            }
        });
        jPanel1.add(txtdc, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 160, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Diskon");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, -1, -1));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 623, 682);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        buttonGroup1.clearSelection();
        buttonGroup2.clearSelection();
        jumlahpesanan.setText("0");
        TFcash.setText("");
        kembali.setText("");
        total.setText("");
        txtdc.setText("");
    }//GEN-LAST:event_resetActionPerformed

    private void hitungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitungActionPerformed
        // TODO add your handling code here:
        if (!coklat.isSelected() && !keju.isSelected() && !matcha.isSelected() && !coklatkeju.isSelected() && !coklatkeju.isSelected() && !strawberrykeju.isSelected() &&
        !blueberry.isSelected() && !strawberry.isSelected() && !kacang.isSelected()) {
        JOptionPane.showMessageDialog(this, "Silakan pilih jenis roti terlebih dahulu!");
        return;
        }
        
        if (!susu.isSelected() && !sosis.isSelected() && !mayo.isSelected() && !almond.isSelected() && !abon.isSelected() && !dagingsuwir.isSelected()) {
        JOptionPane.showMessageDialog(this, "Silakan pilih topping terlebih dahulu!");
        return;
        }
        
        if(coklat.isSelected()){
            hargaRoti = 12000;
        }else if(keju.isSelected()){
            hargaRoti = 15000;
        }else if(matcha.isSelected()){
            hargaRoti = 18000;
        }else if(blueberry.isSelected()){
            hargaRoti = 18000;
        }else if(strawberry.isSelected()){
            hargaRoti = 12000;
        }else if(kacang.isSelected()){
            hargaRoti = 18000;
        }else if(coklatkeju.isSelected()){
            hargaRoti = 18000;
        }else if(coklatkacang.isSelected()){
            hargaRoti = 18000;
        }else if(strawberrykeju.isSelected()){
            hargaRoti = 18000;
        }
        
        if(susu.isSelected()){
            hargaTopping = 3000;
        }else if(sosis.isSelected()){
            hargaTopping = 5000;
        }else if(mayo.isSelected()){
            hargaTopping = 7000;
        }else if(dagingsuwir.isSelected()){
            hargaTopping = 8000;
        }else if(almond.isSelected()){
            hargaTopping = 12000;
        }else if(abon.isSelected()){
            hargaTopping = 8000;
        }
            
double totalHarga = (hargaRoti + hargaTopping) * jumlahPesanan;

// Jika total harga lebih dari 100.000, diskon 5% diterapkan
if (totalHarga > 100000) {
    double diskon = totalHarga * 0.05;  // Menghitung diskon 5%
    totalHarga *= 0.95;  // Mengurangi total harga dengan diskon 5%
    txtdc.setText(String.format("Rp %.2f", diskon));  // Menampilkan nilai diskon
} else {
    txtdc.setText("Rp 0.00");  // Jika tidak ada diskon, menampilkan Rp 0.00
}

// Menampilkan total harga setelah diskon (jika ada)
total.setText(String.format("Rp %.2f", totalHarga));

// Validasi input uang
try {
    double uang = Double.parseDouble(TFcash.getText());
    
    // Cek apakah uang cukup untuk membayar total harga
    if (uang < totalHarga) {
        JOptionPane.showMessageDialog(this, "Uang kurang!");
        return;
    }

    // Menghitung kembalian
    double kembalian = uang - totalHarga;
    kembali.setText(String.format("Rp %.2f", kembalian));
} catch (NumberFormatException e) {
}

    }//GEN-LAST:event_hitungActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here
        jumlahPesanan++;
        jumlahpesanan.setText(String.valueOf(jumlahPesanan));
    }//GEN-LAST:event_tambahActionPerformed

    private void kurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kurangActionPerformed
        // TODO add your handling code here:
        if (jumlahPesanan == 0){
            jumlahPesanan = 0;
        }else{
            jumlahPesanan -= 1;
        }
        jumlahpesanan.setText(String.valueOf(jumlahPesanan));
    }//GEN-LAST:event_kurangActionPerformed

    private void blueberryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_blueberryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_blueberryActionPerformed

    private void coklatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_coklatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_coklatActionPerformed

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_totalActionPerformed

    private void dagingsuwirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dagingsuwirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dagingsuwirActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int exit = JOptionPane.showConfirmDialog(null,"Akhiri Pesanan?","Keluar",JOptionPane.YES_NO_OPTION);
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TFcashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TFcashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TFcashActionPerformed

    private void kejuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kejuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kejuActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembaliActionPerformed

    private void sosisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sosisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sosisActionPerformed

    private void susuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_susuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_susuActionPerformed

    private void TFcashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TFcashKeyReleased
        // TODO add your handling code here: 
//        try {
//            double uangPembeli = Double.parseDouble(cash.getText());
//            double totalHarga = 0;
//            double kembalian = uangPembeli - totalHarga;
//
//            // Menampilkan kembalian dengan 2 angka di belakang koma
//            kembali.setText(String.format("Rp %.2f", kembalian));
//        } catch (NumberFormatException e) {
//            JOptionPane.showMessageDialog(this, "Masukkan jumlah uang yang valid!");
//        }
  
  
    }//GEN-LAST:event_TFcashKeyReleased

    private void txtdcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdcActionPerformed

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
            java.util.logging.Logger.getLogger(roti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(roti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(roti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(roti.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new roti().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField TFcash;
    private javax.swing.JRadioButton abon;
    private javax.swing.JRadioButton almond;
    private javax.swing.JRadioButton blueberry;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton coklat;
    private javax.swing.JRadioButton coklatkacang;
    private javax.swing.JRadioButton coklatkeju;
    private javax.swing.JRadioButton dagingsuwir;
    private javax.swing.JButton hitung;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JTextField jumlahpesanan;
    private javax.swing.JRadioButton kacang;
    private javax.swing.JRadioButton keju;
    private javax.swing.JTextField kembali;
    private javax.swing.JButton kurang;
    private javax.swing.JRadioButton matcha;
    private javax.swing.JRadioButton mayo;
    private javax.swing.JButton reset;
    private javax.swing.JRadioButton sosis;
    private javax.swing.JRadioButton strawberry;
    private javax.swing.JRadioButton strawberrykeju;
    private javax.swing.JRadioButton susu;
    private javax.swing.JButton tambah;
    private javax.swing.JTextField total;
    private javax.swing.JTextField txtdc;
    // End of variables declaration//GEN-END:variables
}