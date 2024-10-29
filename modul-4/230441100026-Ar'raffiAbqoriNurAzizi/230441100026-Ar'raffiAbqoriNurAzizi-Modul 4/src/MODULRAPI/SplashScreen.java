package MODULRAPI;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.Icon;
import javax.swing.JOptionPane;
import javax.swing.plaf.ProgressBarUI;

public class SplashScreen extends javax.swing.JFrame {
    Icon Logostart = new javax.swing.ImageIcon(getClass().getResource("/source/StartTheGames.png"));

    public SplashScreen() {
        initComponents();
        startLoading();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Progressbar = new javax.swing.JProgressBar();
        ProgressNumber = new javax.swing.JLabel();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 255, 153));
        jPanel1.setLayout(null);

        Progressbar.setBackground(new java.awt.Color(255, 255, 255));
        Progressbar.setFont(new java.awt.Font("Segoe UI", 1, 10)); // NOI18N
        Progressbar.setForeground(new java.awt.Color(102, 255, 102));
        jPanel1.add(Progressbar);
        Progressbar.setBounds(50, 220, 500, 30);

        ProgressNumber.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 18)); // NOI18N
        ProgressNumber.setForeground(new java.awt.Color(255, 255, 255));
        ProgressNumber.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ProgressNumber.setText("0 %");
        jPanel1.add(ProgressNumber);
        ProgressNumber.setBounds(240, 260, 114, 21);

        background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/source/Loading-Page2.gif"))); // NOI18N
        jPanel1.add(background);
        background.setBounds(0, 0, 600, 360);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(600, 360));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void startLoading() {
        // Run loading animation in a separate thread
        new Thread(() -> {
            try {
                for (int i = 0; i <= 100; i++) {
                    Thread.sleep(20); // Simulate loading
                    Progressbar.setValue(i);
                    ProgressNumber.setText(i + " %");
                }
                
                // After loading is complete, dispose of the splash screen and open the main game screen
                java.awt.EventQueue.invokeLater(() -> {
                    new GuessTheNumberGames().setVisible(true); // Open main game window
                    this.dispose(); // Close splash screen
                    JOptionPane.showMessageDialog(rootPane, "SILAKAN COBA TEBAK ANGKA. \nMASUKKAN ANGKA ANTARA 1-100", "PERMAINAN DIMULAI !!!", HEIGHT, Logostart);
                });
                
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
    
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
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SplashScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        SplashScreen LoadingScreen = new SplashScreen();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoadingScreen.setVisible(true);
            }
        });
//        GuessTheNumberGames Games = new GuessTheNumberGames();
//        try {
//            for (int i=0; i<=100; i++){
//                Thread.sleep(40);
//                LoadingScreen.Progressbar.setValue(i);
//                LoadingScreen.ProgressNumber.setText(Integer.toString(i)+"%");
//            }
//        } catch (Exception e){
//            
//        }
//        new SplashScreen().setVisible(false);
//        Games.setVisible(true);
//        LoadingScreen.dispose();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ProgressNumber;
    private javax.swing.JProgressBar Progressbar;
    private javax.swing.JLabel background;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
