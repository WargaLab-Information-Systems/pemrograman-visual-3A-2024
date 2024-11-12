package MODULRAPI;

import javax.swing.JOptionPane;
import javax.swing.DefaultListModel;
import java.util.Random;
import javax.swing.Icon;

public class GuessTheNumberGames extends javax.swing.JFrame {
    Icon Logostart = new javax.swing.ImageIcon(getClass().getResource("/source/StartTheGames.png"));
    Icon logoWarning = new javax.swing.ImageIcon(getClass().getResource("/source/Warning.png"));
    Icon logoBenar = new javax.swing.ImageIcon(getClass().getResource("/source/Benar.png"));
    Icon logoSalah = new javax.swing.ImageIcon(getClass().getResource("/source/salah2.gif"));

    private int targetAngka;
    private int kesempatanTebakan = 10;
    private DefaultListModel<String> listScoreModel = new DefaultListModel<>(); // Model untuk JList
    private int skor = 0;
    private int nomorList = 1;
    
    public GuessTheNumberGames() {
        initComponents();
        setTargetAngka(); // Atur target angka acak
        listScore.setModel(listScoreModel); // Set model ke JList
        tfCek.setText("minimal bisa sekali percobaan !!");
    }
    
    // Metode untuk mengacak angka target
    private void setTargetAngka() {
        Random AcakAngka = new Random();
        targetAngka = AcakAngka.nextInt(100) + 1; // Angka antara 1-100
//        System.out.println("Score Yang Benar : " + targetAngka);
        kesempatanTebakan = 10; // Reset kesempatan
        skor = 0; // Reset skor
        btnTebak.setText("Tebak (" + kesempatanTebakan + ")");
        tfScore.setText("Score: " + skor);
        tfInputAngkaTebakan.setText(""); // Kosongkan input tebakan
        tfCek.setText(""); // Kosongkan hasil cek tebakan
        System.out.println("Score Yang Benar : " + targetAngka);
//        JOptionPane.showMessageDialog(rootPane, "Permainan dimulai! Silakan coba tebak angka. \n\t\tMasukkan angka antara 1-100", "AYOO MAIN !!!", HEIGHT, Logostart);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tabbedPaneCustom1 = new TabCustom.TabbedPaneCustom();
        Panel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfInputAngkaTebakan = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfCek = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfScore = new javax.swing.JTextField();
        btnTebak = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        background1 = new javax.swing.JLabel();
        Panel2 = new javax.swing.JPanel();
        Exit = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listScore = new javax.swing.JList<>();
        background2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(207, 242, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(455, 600));

        tabbedPaneCustom1.setBackground(new java.awt.Color(207, 242, 255));
        tabbedPaneCustom1.setFont(new java.awt.Font("Geometr415 Blk BT", 3, 14)); // NOI18N
        tabbedPaneCustom1.setSelectedColor(new java.awt.Color(16, 208, 0));
        tabbedPaneCustom1.setUnselectedColor(new java.awt.Color(207, 242, 255));

        Panel1.setBackground(new java.awt.Color(207, 242, 255));
        Panel1.setPreferredSize(new java.awt.Dimension(455, 660));
        Panel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Cobak Tebak       :");
        Panel1.add(jLabel1);
        jLabel1.setBounds(40, 170, 150, 50);

        tfInputAngkaTebakan.setFont(new java.awt.Font("Geometr706 BlkCn BT", 1, 18)); // NOI18N
        tfInputAngkaTebakan.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Panel1.add(tfInputAngkaTebakan);
        tfInputAngkaTebakan.setBounds(200, 170, 210, 50);

        jLabel2.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Check                   :");
        Panel1.add(jLabel2);
        jLabel2.setBounds(40, 230, 150, 50);

        tfCek.setEditable(false);
        tfCek.setFont(new java.awt.Font("Geometr706 BlkCn BT", 1, 14)); // NOI18N
        tfCek.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        tfCek.setActionCommand("<Not Set>");
        Panel1.add(tfCek);
        tfCek.setBounds(200, 230, 210, 50);

        jLabel3.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel3.setText("Score                    :");
        Panel1.add(jLabel3);
        jLabel3.setBounds(40, 290, 150, 50);

        tfScore.setEditable(false);
        tfScore.setFont(new java.awt.Font("Geometr706 BlkCn BT", 1, 18)); // NOI18N
        tfScore.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Panel1.add(tfScore);
        tfScore.setBounds(200, 290, 210, 50);

        btnTebak.setBackground(new java.awt.Color(254, 255, 0));
        btnTebak.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        btnTebak.setText("TEBAK");
        btnTebak.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnTebak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTebakActionPerformed(evt);
            }
        });
        Panel1.add(btnTebak);
        btnTebak.setBounds(240, 410, 170, 50);

        btnReset.setBackground(new java.awt.Color(255, 72, 0));
        btnReset.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        btnReset.setText("RESET");
        btnReset.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        Panel1.add(btnReset);
        btnReset.setBounds(40, 410, 170, 50);

        background1.setIcon(new javax.swing.ImageIcon("C:\\Users\\winar\\OneDrive\\Documents\\NetBeansProjects\\230441100026-Ar'raffiAbqoriNurAzizi-Modul 4\\src\\source\\game-TEBAK-ANGKA.gif")); // NOI18N
        Panel1.add(background1);
        background1.setBounds(0, 0, 450, 660);

        tabbedPaneCustom1.addTab("GAME TEBAK ANGKANYA !!!", Panel1);

        Panel2.setBackground(new java.awt.Color(207, 242, 255));
        Panel2.setLayout(null);

        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/button-EXIT.png"))); // NOI18N
        Exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ExitMouseClicked(evt);
            }
        });
        Panel2.add(Exit);
        Exit.setBounds(130, 540, 180, 70);

        listScore.setFont(new java.awt.Font("Geometr212 BkCn BT", 1, 18)); // NOI18N
        listScore.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(listScore);

        Panel2.add(jScrollPane1);
        jScrollPane1.setBounds(60, 160, 340, 340);

        background2.setIcon(new javax.swing.ImageIcon("C:\\Users\\winar\\OneDrive\\Documents\\NetBeansProjects\\230441100026-Ar'raffiAbqoriNurAzizi-Modul 4\\src\\source\\game-SCORE.gif")); // NOI18N
        Panel2.add(background2);
        background2.setBounds(0, 0, 450, 660);

        tabbedPaneCustom1.addTab("GAME SCORE", Panel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabbedPaneCustom1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 699, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTebakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTebakActionPerformed
        // TODO add your handling code here:
        try {
            int tebakan = Integer.parseInt(tfInputAngkaTebakan.getText()); // Ambil input dari tfInputAngkaTebakan

            if (tebakan == targetAngka) {
                skor = kesempatanTebakan * 10; // Hitung skor
                tfScore.setText("Score: " + skor); // Tampilkan skor di tfScore
                String nama = JOptionPane.showInputDialog(this, "Anda Berhasil! Masukkan nama Anda: ");
                if (nama != null && !nama.trim().isEmpty()) { // Cek jika pengguna tidak menekan Cancel atau mengosongkan nama
                    listScoreModel.addElement((nomorList++) + ". " + nama + " - Score: " + skor); // Tambah skor ke model list
                }
                setTargetAngka(); // Reset permainan setelah tebakan benar
            } else {
                kesempatanTebakan--;
                skor = kesempatanTebakan * 10; // Update skor berdasarkan kesempatan tersisa
                tfScore.setText("Score: " + skor); // Tampilkan skor setiap kali kesempatan berkurang
                btnTebak.setText("Tebak (" + kesempatanTebakan + ")");
                if (kesempatanTebakan == 0) {
                    JOptionPane.showMessageDialog(this, "Anda Gagal! Permainan direset.");
                    setTargetAngka();
                } else if (tebakan < targetAngka) {
                    tfCek.setText("Tebakanmu masih rendah!");
                } else {
                    tfCek.setText("Tebakanmu terlalu tinggi!");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "MASUKKAN ANGKA YANG VALID !!", "Error", JOptionPane.ERROR_MESSAGE, logoSalah);
        }
    }//GEN-LAST:event_btnTebakActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        // TODO add your handling code here:
        setTargetAngka(); // Reset permainan
        tfInputAngkaTebakan.setText("");
        tfCek.setText("");
        tfCek.setText("minimal bisa sekali percobaan !!");
        JOptionPane.showMessageDialog(rootPane, "LANJUT NIHH..! \nAYOO COBA TEBAK ANGKANYA LAGI TUH. \nMasukkan angka antara 1-100", "AYOO MAIN LAGI...!!!", HEIGHT, Logostart);
    }//GEN-LAST:event_btnResetActionPerformed

    private void ExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ExitMouseClicked
        // TODO add your handling code here:
        if (JOptionPane.showConfirmDialog(null, "Yakin Ingin Keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION,HEIGHT, Logostart) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_ExitMouseClicked

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
            java.util.logging.Logger.getLogger(GuessTheNumberGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GuessTheNumberGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GuessTheNumberGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GuessTheNumberGames.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GuessTheNumberGames().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Exit;
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JLabel background1;
    private javax.swing.JLabel background2;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnTebak;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> listScore;
    private TabCustom.TabbedPaneCustom tabbedPaneCustom1;
    private javax.swing.JTextField tfCek;
    private javax.swing.JTextField tfInputAngkaTebakan;
    private javax.swing.JTextField tfScore;
    // End of variables declaration//GEN-END:variables
}
