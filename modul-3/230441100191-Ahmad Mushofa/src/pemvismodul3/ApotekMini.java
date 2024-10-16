/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pemvismodul3;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author AHMAD
 */
public class ApotekMini extends javax.swing.JFrame {

    /**
     * Creates new form ApotekMini
     */
    public ApotekMini() {
        initComponents();
        tfjumlah.setEditable(false);
        tftotal.setEditable(false);
        tfkembali.setEditable(false);
        
        tfcash.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                penghitungan();
            }
        });
          tfjumlah.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void penghitungan() {
        try {
        double totalHarga = Double.parseDouble(tftotal.getText()); // Total harga
        double uangMasuk = Double.parseDouble(tfcash.getText()); // Uang yang sudah dimasukkan
        double kembalian = uangMasuk - totalHarga;

        if (kembalian >= 0) {
            tfkembali.setText(String.valueOf(kembalian));
        } else {
            tfkembali.setText("Uang Tidak Cukup");
        }
    } catch (NumberFormatException e) {
        tfkembali.setText("");
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        panel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        obat1 = new javax.swing.JRadioButton();
        obat6 = new javax.swing.JRadioButton();
        obat2 = new javax.swing.JRadioButton();
        obat7 = new javax.swing.JRadioButton();
        obat3 = new javax.swing.JRadioButton();
        obat8 = new javax.swing.JRadioButton();
        obat9 = new javax.swing.JRadioButton();
        obat4 = new javax.swing.JRadioButton();
        obat5 = new javax.swing.JRadioButton();
        obat10 = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        namaobat2 = new javax.swing.JLabel();
        namaobat3 = new javax.swing.JLabel();
        namaobat4 = new javax.swing.JLabel();
        namaobat5 = new javax.swing.JLabel();
        namaobat1 = new javax.swing.JLabel();
        namaobat7 = new javax.swing.JLabel();
        namaobat8 = new javax.swing.JLabel();
        namaobat9 = new javax.swing.JLabel();
        namaobat10 = new javax.swing.JLabel();
        namaobat6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        labelpesan = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        tfjumlah = new javax.swing.JTextField();
        btntambah = new javax.swing.JButton();
        btntotal = new javax.swing.JButton();
        tftotal = new javax.swing.JTextField();
        btnkurang = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfcash = new javax.swing.JTextField();
        btnreset = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tfkembali = new javax.swing.JTextField();
        btncancel = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        panel1.setBackground(new java.awt.Color(0, 153, 153));

        panel2.setBackground(new java.awt.Color(0, 153, 153));
        panel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        panel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 6, -1, -1));

        jLabel1.setFont(new java.awt.Font("Goudy Old Style", 1, 60)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Apotek");
        panel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 242, 128));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));
        jPanel3.setLayout(new java.awt.GridLayout(8, 5));

        buttonGroup1.add(obat1);
        obat1.setText("Paracetamol");
        obat1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat1ActionPerformed(evt);
            }
        });
        jPanel3.add(obat1);

        buttonGroup1.add(obat6);
        obat6.setText("Cetirizine");
        obat6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat6ActionPerformed(evt);
            }
        });
        jPanel3.add(obat6);

        buttonGroup1.add(obat2);
        obat2.setText("Amoxicillin");
        obat2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat2ActionPerformed(evt);
            }
        });
        jPanel3.add(obat2);

        buttonGroup1.add(obat7);
        obat7.setText("Desamethasone");
        obat7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat7ActionPerformed(evt);
            }
        });
        jPanel3.add(obat7);

        buttonGroup1.add(obat3);
        obat3.setText("Loratadine");
        obat3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat3ActionPerformed(evt);
            }
        });
        jPanel3.add(obat3);

        buttonGroup1.add(obat8);
        obat8.setText("Metformin");
        obat8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat8ActionPerformed(evt);
            }
        });
        jPanel3.add(obat8);

        buttonGroup1.add(obat9);
        obat9.setText("Napacin");
        obat9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat9ActionPerformed(evt);
            }
        });
        jPanel3.add(obat9);

        buttonGroup1.add(obat4);
        obat4.setText("Ibuprofen");
        obat4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat4ActionPerformed(evt);
            }
        });
        jPanel3.add(obat4);

        buttonGroup1.add(obat5);
        obat5.setText("Antasida");
        obat5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat5ActionPerformed(evt);
            }
        });
        jPanel3.add(obat5);

        buttonGroup1.add(obat10);
        obat10.setText("Omeprazole");
        obat10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                obat10ActionPerformed(evt);
            }
        });
        jPanel3.add(obat10);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(null);

        namaobat2.setText("- Amoxicillin-Rp10.000");
        jPanel4.add(namaobat2);
        namaobat2.setBounds(70, 70, 123, 16);

        namaobat3.setText("- Loratadine-Rp15.000");
        jPanel4.add(namaobat3);
        namaobat3.setBounds(70, 240, 121, 16);

        namaobat4.setText("- Ibuprofen-Rp10.000");
        jPanel4.add(namaobat4);
        namaobat4.setBounds(70, 310, 119, 16);

        namaobat5.setText("- Antasida-Rp20.000");
        jPanel4.add(namaobat5);
        namaobat5.setBounds(70, 370, 110, 16);

        namaobat1.setText("- Paracetamol-Rp7.000");
        jPanel4.add(namaobat1);
        namaobat1.setBounds(70, 150, 120, 16);

        namaobat7.setText("- Desamethasone-Rp5.000");
        jPanel4.add(namaobat7);
        namaobat7.setBounds(290, 150, 146, 17);

        namaobat8.setText("- Metformin-Rp19.000");
        jPanel4.add(namaobat8);
        namaobat8.setBounds(300, 240, 131, 16);

        namaobat9.setText("- Napacin-Rp12.000");
        jPanel4.add(namaobat9);
        namaobat9.setBounds(300, 310, 111, 16);

        namaobat10.setText("- Omeprazole-Rp.30000");
        jPanel4.add(namaobat10);
        namaobat10.setBounds(290, 370, 129, 16);

        namaobat6.setText("- Cetirizine-Rp25.000");
        jPanel4.add(namaobat6);
        namaobat6.setBounds(300, 70, 112, 14);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/amoxcilin.jpg"))); // NOI18N
        jPanel4.add(jLabel3);
        jLabel3.setBounds(100, 20, 64, 43);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cetrizine.jpg"))); // NOI18N
        jPanel4.add(jLabel8);
        jLabel8.setBounds(330, 20, 64, 50);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dexametasone.jpg"))); // NOI18N
        jPanel4.add(jLabel9);
        jLabel9.setBounds(330, 100, 64, 43);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/metformin.jpg"))); // NOI18N
        jPanel4.add(jLabel10);
        jLabel10.setBounds(330, 180, 70, 50);

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/napacin.jpg"))); // NOI18N
        jLabel12.setText("jLabel12");
        jPanel4.add(jLabel12);
        jLabel12.setBounds(330, 260, 60, 40);

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/omeprazole.jpg"))); // NOI18N
        jLabel13.setText("jLabel13");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(330, 330, 60, 40);

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/antasidadoen.jpg"))); // NOI18N
        jLabel14.setText("jLabel14");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(100, 330, 70, 40);

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ibuprofen.jpg"))); // NOI18N
        jLabel15.setText("jLabel15");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(100, 260, 70, 40);

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/loratadine.jpg"))); // NOI18N
        jPanel4.add(jLabel16);
        jLabel16.setBounds(100, 180, 64, 53);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/paracetamol1.jpg"))); // NOI18N
        jPanel4.add(jLabel17);
        jLabel17.setBounds(100, 90, 67, 50);

        jLabel11.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nama Obat");

        labelpesan.setFont(new java.awt.Font("Cooper Black", 0, 24)); // NOI18N
        labelpesan.setText("Pesan Obat");

        jPanel6.setBackground(new java.awt.Color(0, 204, 204));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Berlin Sans FB Demi", 0, 14)); // NOI18N
        jLabel4.setText("JUMLAH");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 6, 53, -1));

        tfjumlah.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(tfjumlah, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 43, 42, 36));

        btntambah.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btntambah.setText("+");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });
        jPanel6.add(btntambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(149, 43, 38, 36));

        btntotal.setBackground(new java.awt.Color(204, 255, 255));
        btntotal.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btntotal.setText("Total");
        btntotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntotalActionPerformed(evt);
            }
        });
        jPanel6.add(btntotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 97, 63, 48));

        tftotal.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(tftotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(95, 101, 98, 39));

        btnkurang.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnkurang.setText("-");
        btnkurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkurangActionPerformed(evt);
            }
        });
        jPanel6.add(btnkurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 43, 40, 36));

        jPanel8.setBackground(new java.awt.Color(0, 204, 204));
        jPanel8.setLayout(new java.awt.GridBagLayout());

        jLabel5.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel5.setText("Cash");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 0, 0);
        jPanel8.add(jLabel5, gridBagConstraints);

        tfcash.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 26;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
        jPanel8.add(tfcash, gridBagConstraints);

        btnreset.setBackground(new java.awt.Color(204, 255, 255));
        btnreset.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 18;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 28, 0);
        jPanel8.add(btnreset, gridBagConstraints);

        jLabel6.setFont(new java.awt.Font("Berlin Sans FB", 0, 14)); // NOI18N
        jLabel6.setText("Kembalian");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(10, 40, 0, 0);
        jPanel8.add(jLabel6, gridBagConstraints);

        tfkembali.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 56;
        gridBagConstraints.ipady = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 7);
        jPanel8.add(tfkembali, gridBagConstraints);

        btncancel.setBackground(new java.awt.Color(204, 255, 255));
        btncancel.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btncancel.setText("Cancel");
        btncancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 48;
        gridBagConstraints.ipady = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(20, 10, 28, 7);
        jPanel8.add(btncancel, gridBagConstraints);

        jLabel7.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel7.setText("Pembayaran");

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panel1Layout.createSequentialGroup()
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(labelpesan)
                        .addGap(139, 139, 139)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(60, 60, 60)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addComponent(panel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelpesan)
                    .addComponent(jLabel7))
                .addGap(2, 2, 2)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowActivated

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
        buttonGroup1.clearSelection();
        int jumlah = 0;
        tfjumlah.setText(String.valueOf(jumlah));
        tftotal.setText("");
        tfcash.setText("");
        tfkembali.setText("");
        tftotal.setText("");
    }//GEN-LAST:event_btnresetActionPerformed

    private void btntotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntotalActionPerformed
        // TODO add your handling code here:
        // Pengecekan jika tidak ada obat yang dipilih
        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Anda harus memilih obat terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Pengecekan jika jumlah pesanan tidak valid
        String jumlahpesanan = tfjumlah.getText();
        if (jumlahpesanan.isEmpty() || Integer.parseInt(jumlahpesanan) <= 0) {
            JOptionPane.showMessageDialog(null, "Jumlah pembelian harus lebih dari 0!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
        

        // Mulai penghitungan harga total
        double harga = 0;

        // Menampilkan detail obat berdasarkan yang dipilih
        if (obat1.isSelected()) {
            harga += 7000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();
        

        if (obat2.isSelected()) {
            harga += 10000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        if (obat3.isSelected()) {
            harga += 15000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        if (obat4.isSelected()) {
            harga += 10000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        if (obat5.isSelected()) {
            harga += 20000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        if (obat6.isSelected()) {
            harga += 25000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        if (obat7.isSelected()) {
            harga += 5000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        if (obat8.isSelected()) {
            harga += 19000 * Integer.parseInt(jumlahpesanan);
        }

        if (obat9.isSelected()) {
            harga += 12000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        if (obat10.isSelected()) {
            harga += 30000 * Integer.parseInt(jumlahpesanan);
        }
        tftotal.setText(String.valueOf(harga));

                    
        penghitungan();

        
    }//GEN-LAST:event_btntotalActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        int jumlah = Integer.parseInt(tfjumlah.getText());
        jumlah += 1;
        tfjumlah.setText(String.valueOf(jumlah));
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnkurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkurangActionPerformed
        // TODO add your handling code here:
        if(Integer.parseInt(tfjumlah.getText())>0)
        {
        int jumlah = Integer.parseInt(tfjumlah.getText());
            jumlah -= 1;
            tfjumlah.setText(String.valueOf(jumlah));
        }else{
            tfjumlah.setText("0");
        }
    }//GEN-LAST:event_btnkurangActionPerformed

    private void obat1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat1ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Paracetamol: \nHarga: 12000\nDeskripsi: Meredakan sakit kepala,demam\nDosis: 500 mg setiap 4-6 jam";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat1ActionPerformed

    private void obat2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat2ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Amoxcillin: \nHarga: 10000\nDeskripsi: Antibiotik untuk infeksi tenggorokan, saluran pernapasan\nDosis: 500 mg 3 kali sehari selama 7 hari";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat2ActionPerformed

    private void obat3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat3ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Loratadine: \nHarga: 15000\nDeskripsi: Mengatasi alergi seperti pilek alergi dan gatal-gatal\nDosis: 10 mg sekali sehari";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat3ActionPerformed

    private void obat4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat4ActionPerformed
        // TODO add your handling code here:
         String detailObat = "IbuProfen: \nHarga: 10000\nDeskripsi: Meredakan nyeri, peradangan, dan demam\nDosis: 400-600 mg setiap 6-8 jam";
         JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat4ActionPerformed

    private void obat5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat5ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Antasida: \nHarga: 20000\nDeskripsi: Mengatasi asam lambung berlebih, dan gangguan pencernaan\nDosis: 1-2 tablet saat gejala muncul";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat5ActionPerformed

    private void obat6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat6ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Cetirizine: \nHarga: 25000\nDeskripsi: Meredakan gejala alergi seperti bersin dan mata berair\nDosis: 10 mg sekali sehari";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat 6", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat6ActionPerformed

    private void obat7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat7ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Dexamethasone: \nHarga: 5000\nDeskripsi: Steroid untuk mengatasi peradangan dan alergi berat\nDosis: 0.5-4 mg per hari";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat7ActionPerformed

    private void obat8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat8ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Metformin: \nHarga: 19000\nDeskripsi: Membantu mengontrol kadar gula darah\nDosis: 500 mg 2-3 kali sehari";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat8ActionPerformed

    private void obat9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat9ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Napacin: \nHarga: 12000\nDeskripsi: Mengatasi nyeri otot dan kekakuan akibat keseleo\nDosis: 1-2 tablet setiap 6-8 jam";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat9ActionPerformed

    private void obat10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_obat10ActionPerformed
        // TODO add your handling code here:
        String detailObat = "Omeprazole: \nHarga: 30000\nDeskripsi: Mengatasi asam lambung, GERD, dan tukak lambung\nDosis: 20-40 mg sekali sehari";
        JOptionPane.showMessageDialog(null, detailObat, "Detail Obat:", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_obat10ActionPerformed

    private void btncancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelActionPerformed
        // TODO add your handling code here:
        int keluar = JOptionPane.showConfirmDialog(null, "Anda Yakin Ingin Keluar Program?", 
                                                   "Keluar", JOptionPane.YES_NO_OPTION, 
                                                   JOptionPane.QUESTION_MESSAGE);
        if (keluar == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btncancelActionPerformed

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
            java.util.logging.Logger.getLogger(ApotekMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApotekMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApotekMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApotekMini.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApotekMini().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancel;
    private javax.swing.JButton btnkurang;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntotal;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JLabel labelpesan;
    private javax.swing.JLabel namaobat1;
    private javax.swing.JLabel namaobat10;
    private javax.swing.JLabel namaobat2;
    private javax.swing.JLabel namaobat3;
    private javax.swing.JLabel namaobat4;
    private javax.swing.JLabel namaobat5;
    private javax.swing.JLabel namaobat6;
    private javax.swing.JLabel namaobat7;
    private javax.swing.JLabel namaobat8;
    private javax.swing.JLabel namaobat9;
    private javax.swing.JRadioButton obat1;
    private javax.swing.JRadioButton obat10;
    private javax.swing.JRadioButton obat2;
    private javax.swing.JRadioButton obat3;
    private javax.swing.JRadioButton obat4;
    private javax.swing.JRadioButton obat5;
    private javax.swing.JRadioButton obat6;
    private javax.swing.JRadioButton obat7;
    private javax.swing.JRadioButton obat8;
    private javax.swing.JRadioButton obat9;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JTextField tfcash;
    private javax.swing.JTextField tfjumlah;
    private javax.swing.JTextField tfkembali;
    private javax.swing.JTextField tftotal;
    // End of variables declaration//GEN-END:variables
}
