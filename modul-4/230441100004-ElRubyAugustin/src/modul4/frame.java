/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package modul4;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.Icon;
import javax.swing.JOptionPane;

public class frame extends javax.swing.JFrame {
    int target = (int)(Math.random() * 100);
    int sisapermainan = 10;
//    private DefaultListModel<String> tampung;
    ArrayList<String> tampung = new ArrayList<String>();
    Icon iconSukses = new javax.swing.ImageIcon(getClass().getResource("../custome/close.png"));



    public frame() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel4 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        hint = new javax.swing.JTextField();
        Hasil = new javax.swing.JTextField();
        tebak = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CEK :");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("TEBAK :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, -1, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CEK :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 160, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("SCORE :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, -1, -1));

        jButton1.setText("TEBAK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, -1, 36));

        jButton5.setText("RESET");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, -1, 36));
        jPanel1.add(hint, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 174, 29));
        jPanel1.add(Hasil, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, 174, 29));
        jPanel1.add(tebak, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 110, 174, 32));

        jPanel3.setBackground(new java.awt.Color(0, 255, 0));
        jPanel3.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PERMAINAN TEBAK ANGKA");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 112, 38, 124);
        jPanel3.add(jLabel1, gridBagConstraints);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Permainan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setViewportView(jList1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(179, 142, 243, 186));

        jPanel4.setBackground(new java.awt.Color(0, 255, 0));
        jPanel4.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("SCORE");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(35, 237, 35, 274);
        jPanel4.add(jLabel6, gridBagConstraints);

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTabbedPane1.addTab("Score", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    target = (int)(Math.random() * 100);
    sisapermainan = 10;

    tebak.setText(""); 
    hint.setText(""); 
    Hasil.setText("");

    System.out.println("Permainan telah di-reset. Target angka yang benar adalah: " + target);    
    // Reset teks tombol tebakan
    jButton1.setText("TEBAK");
    jButton1.setEnabled(true);  // Mengaktifkan kembali tombol jika di-disable
   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (sisapermainan > 0) {
        try {
            int guess = Integer.parseInt(tebak.getText());
            System.out.println("Guess: " + guess + ", Target: " +target);
            int tebakanUser = Integer.parseInt(tebak.getText());
            if (tebakanUser < 1 || tebakanUser > 100) {
                JOptionPane.showMessageDialog(this, "Angka harus antara 1 sampai 100", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            } else if (tebakanUser < target) {
                hint.setText("Terlalu Kecil");
                sisapermainan--;
                jButton1.setText("Tebak " + sisapermainan);
                return;
            } else if (tebakanUser > target) {
                hint.setText("Terlalu Besar");
                sisapermainan--;
                jButton1.setText("Tebak " + sisapermainan);
               
                if (sisapermainan == 0) {
                    JOptionPane.showMessageDialog(this, "Anda gagal menebak angka!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
                    jButton1.setEnabled(false);  // Disable the button after failure
                }
                return;

            } else {
                JOptionPane.showMessageDialog(this, "Selamat Anda Berhasil Menebak");
                String nama = JOptionPane.showInputDialog(this, "Masukkan Nama Anda:");

            if (nama != null && !nama.trim().isEmpty()) { // Check if the input is not empty
                int score = sisapermainan * 10;
                Hasil.setText(String.valueOf(score));
        
                tampung.add(nama + " - Skor: " + score);

                DefaultListModel<String> listModel = new DefaultListModel<>();
            for (String entry : tampung) {
                listModel.addElement(entry);
        }
                jList1.setModel(listModel);
    } else {
        JOptionPane.showMessageDialog(this, "Masukkan Nama dulu!", "Error", JOptionPane.WARNING_MESSAGE);
    }
}
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Masukkan Angka Dulu", "Message", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_jButton1ActionPerformed
        }
    }
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
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Hasil;
    private javax.swing.JTextField hint;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JList<String> jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField tebak;
    // End of variables declaration//GEN-END:variables
}
