/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package moduldua;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author THINKPAD
 */
public class tokoMinuman extends javax.swing.JFrame {
    ImageIcon icon_sukses = new ImageIcon(getClass().getResource("iconSukses.png"));
    ImageIcon icon_warning = new ImageIcon(getClass().getResource("iconWarning.png"));
    /**
     * Creates new form tokoMinuman
     */
    public tokoMinuman() {
        initComponents();
        JmlhBeli.setText("0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bGMenu = new javax.swing.ButtonGroup();
        bGTopping = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();
        btnSend = new javax.swing.JButton();
        btnKurang = new javax.swing.JButton();
        JmlhBeli = new javax.swing.JTextField();
        btnTambah = new javax.swing.JButton();
        btnTotal = new javax.swing.JButton();
        TotalBeli = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Cash = new javax.swing.JTextField();
        Back = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PopIce = new javax.swing.JRadioButton();
        Espresso = new javax.swing.JRadioButton();
        Joshua = new javax.swing.JRadioButton();
        IceTea = new javax.swing.JRadioButton();
        GreenTea = new javax.swing.JRadioButton();
        LemonTea = new javax.swing.JRadioButton();
        Waffle = new javax.swing.JRadioButton();
        Cheese = new javax.swing.JRadioButton();
        Choco = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        Soda = new javax.swing.JRadioButton();
        Matcha = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(250, 238, 208));
        jPanel2.setForeground(new java.awt.Color(255, 51, 51));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(89, 74, 71));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("FreshField");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 2, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Fell The Taste");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Jumlah Pembelian");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cash");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Back");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jPanel5.setBackground(new java.awt.Color(250, 238, 208));

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(89, 74, 71));
        jLabel11.setText("Purchase Here");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel11)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 210, 30));

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel1.add(btnReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        btnSend.setText("Send");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });
        jPanel1.add(btnSend, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, -1, -1));

        btnKurang.setText("-");
        btnKurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKurangActionPerformed(evt);
            }
        });
        jPanel1.add(btnKurang, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 40, -1));

        JmlhBeli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JmlhBeliActionPerformed(evt);
            }
        });
        jPanel1.add(JmlhBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 90, -1));

        btnTambah.setText("+");
        btnTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTambahActionPerformed(evt);
            }
        });
        jPanel1.add(btnTambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 40, -1));

        btnTotal.setText("Total");
        btnTotal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTotalActionPerformed(evt);
            }
        });
        jPanel1.add(btnTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 60, 40));
        jPanel1.add(TotalBeli, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 140, -1));

        jPanel6.setBackground(new java.awt.Color(250, 238, 208));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(89, 74, 71));
        jLabel6.setText("Payment");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 340, 210, 30));

        Cash.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CashActionPerformed(evt);
            }
        });
        Cash.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CashKeyReleased(evt);
            }
        });
        jPanel1.add(Cash, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 150, -1));
        jPanel1.add(Back, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 450, 150, -1));

        jPanel2.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 230, 640));

        jPanel4.setBackground(new java.awt.Color(89, 74, 71));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(250, 238, 208));
        jLabel9.setText("Menu Here");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel9)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 220, 30));

        jPanel3.setBackground(new java.awt.Color(89, 74, 71));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(250, 238, 208));
        jLabel10.setText("Get Topping");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 220, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\THINKPAD\\Downloads\\banner minuman (1).png")); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 100));

        bGMenu.add(PopIce);
        PopIce.setText("Pop Ice - Rp. 5K");
        jPanel2.add(PopIce, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        bGMenu.add(Espresso);
        Espresso.setText("Espresso - Rp. 7k");
        jPanel2.add(Espresso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, -1, -1));

        bGMenu.add(Joshua);
        Joshua.setText("Joshua - Rp. 6k");
        Joshua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JoshuaActionPerformed(evt);
            }
        });
        jPanel2.add(Joshua, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, -1, -1));

        bGMenu.add(IceTea);
        IceTea.setText("Ice Tea - Rp.4k");
        jPanel2.add(IceTea, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, -1, -1));

        bGMenu.add(GreenTea);
        GreenTea.setText("Green Tea - Rp. 7k");
        GreenTea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GreenTeaActionPerformed(evt);
            }
        });
        jPanel2.add(GreenTea, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, -1));

        bGMenu.add(LemonTea);
        LemonTea.setText("Lemon Tea - Rp. 5k");
        jPanel2.add(LemonTea, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));

        bGTopping.add(Waffle);
        Waffle.setText("Waffle - Rp. 3k");
        jPanel2.add(Waffle, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, -1, -1));

        bGTopping.add(Cheese);
        Cheese.setText("Cheese - Rp. 4k");
        Cheese.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheeseActionPerformed(evt);
            }
        });
        jPanel2.add(Cheese, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 390, -1, -1));

        bGTopping.add(Choco);
        Choco.setText("Choco - Rp. 2k");
        jPanel2.add(Choco, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 430, -1, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\THINKPAD\\Downloads\\wave.png")); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-180, 520, -1, 130));

        bGMenu.add(Soda);
        Soda.setText("Soda - Rp. 5k");
        jPanel2.add(Soda, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        bGMenu.add(Matcha);
        Matcha.setText("Matcha - Rp. 7k");
        Matcha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MatchaActionPerformed(evt);
            }
        });
        jPanel2.add(Matcha, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 290, -1, -1));

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 500, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CheeseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheeseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CheeseActionPerformed

    private void MatchaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MatchaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MatchaActionPerformed

    private void GreenTeaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GreenTeaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GreenTeaActionPerformed

    private void JoshuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JoshuaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JoshuaActionPerformed

    private void btnTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTambahActionPerformed
        // TODO add your handling code here:
        int jumlahBeli  = Integer.parseInt(JmlhBeli.getText());
        jumlahBeli+=1;
        JmlhBeli.setText(String.valueOf(jumlahBeli));
    }//GEN-LAST:event_btnTambahActionPerformed

    private void JmlhBeliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JmlhBeliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JmlhBeliActionPerformed

    private void btnTotalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTotalActionPerformed
        // TODO add your handling code here:
        if (bGMenu.getSelection()== null ){
            JOptionPane.showMessageDialog(rootPane, "Harap pilih menu dahulu boss!", "Peringatan", JOptionPane.WARNING_MESSAGE,icon_warning);
        }else{
            int jumlahBeli = Integer.parseInt(JmlhBeli.getText());
            // Terima harga menu yang dipilih
            int hargaMenu = 0;
            if (PopIce.isSelected()) {
                hargaMenu = 5000;
            } else if (Espresso.isSelected()) {
                hargaMenu = 7000;
            } else if (GreenTea.isSelected()) {
                hargaMenu = 7000;
            } else if (IceTea.isSelected()) {
                hargaMenu = 4000;
            } else if (LemonTea.isSelected()) {
                hargaMenu = 5000;
            } else if (Joshua.isSelected()) {
                hargaMenu = 6000;
            } else if (Soda.isSelected()) {
                hargaMenu = 5000;
            } else if (Matcha.isSelected()) {
                hargaMenu = 7000;
            }
            // Terima harga topping yang dipilih
            int hargaTopping = 0;
            if (Waffle.isSelected()) {
                hargaTopping = 3000;
            } else if (Cheese.isSelected()) {
                hargaTopping = 4000;
            } else if (Choco.isSelected()) {
                hargaTopping = 2000;
            }
            // Hitung total harga
            int totalHarga = jumlahBeli * (hargaMenu + hargaTopping);
            // Periksa apakah total pembelian melebihi Rp. 100.000
            if (totalHarga > 100000) {
                //  diskon 5%
                totalHarga = totalHarga - (totalHarga * 5 / 100);
            }
            // Perbarui field total
            TotalBeli.setText("Rp. " + totalHarga);
        }
    }//GEN-LAST:event_btnTotalActionPerformed

    private void btnKurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKurangActionPerformed
        // TODO add your handling code here:
        // Mendapatkan jumlah pembelian dari field
        int jumlahBeli = Integer.parseInt(JmlhBeli.getText());
        // Kurangi 1 dari jumlah pembelian jika jumlah lebih dari 0
        if (jumlahBeli > 0) {
            jumlahBeli-=1;
    }
        // Perbarui jumlah pembelian di field
        JmlhBeli.setText(String.valueOf(jumlahBeli));
    }//GEN-LAST:event_btnKurangActionPerformed

    private void CashActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CashActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CashActionPerformed

    private void CashKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CashKeyReleased
        // TODO add your handling code here:
        try{
            int totalHarga = Integer.parseInt(TotalBeli.getText().replace("Rp. ", ""));
             // Ambil jumlah uang dari field cash
            int cash = Integer.parseInt(Cash.getText());
            // Hitung kembalian
            int kembalian = cash - totalHarga;
            // Periksa apakah uang yang dimasukkan kurang
            if (cash < totalHarga) {
                Back.setText("Uang anda kurang");
            } else {
                Back.setText("Rp. " + kembalian);
            }
        }catch (NumberFormatException e) {
            // Jika input bukan angka atau field cash kosong, field back menampilkan pesan error
            JOptionPane.showMessageDialog(rootPane, "masukkan angka");
//            Back.setText("Masukkan angka");
        }
    }//GEN-LAST:event_CashKeyReleased

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        bGMenu.clearSelection();
        bGTopping.clearSelection();
        JmlhBeli.setText("0");
        TotalBeli.setText("");
        Cash.setText("");
        Back.setText("");
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed
        // TODO add your handling code here:
         JOptionPane.showMessageDialog(rootPane, "Pesanan sudah dicatat boss!", "Informasi", JOptionPane.INFORMATION_MESSAGE,icon_sukses);
    }//GEN-LAST:event_btnSendActionPerformed

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
            java.util.logging.Logger.getLogger(tokoMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(tokoMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(tokoMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(tokoMinuman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new tokoMinuman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Back;
    private javax.swing.JTextField Cash;
    private javax.swing.JRadioButton Cheese;
    private javax.swing.JRadioButton Choco;
    private javax.swing.JRadioButton Espresso;
    private javax.swing.JRadioButton GreenTea;
    private javax.swing.JRadioButton IceTea;
    private javax.swing.JTextField JmlhBeli;
    private javax.swing.JRadioButton Joshua;
    private javax.swing.JRadioButton LemonTea;
    private javax.swing.JRadioButton Matcha;
    private javax.swing.JRadioButton PopIce;
    private javax.swing.JRadioButton Soda;
    private javax.swing.JTextField TotalBeli;
    private javax.swing.JRadioButton Waffle;
    private javax.swing.ButtonGroup bGMenu;
    private javax.swing.ButtonGroup bGTopping;
    private javax.swing.JButton btnKurang;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnTambah;
    private javax.swing.JButton btnTotal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    // End of variables declaration//GEN-END:variables
}