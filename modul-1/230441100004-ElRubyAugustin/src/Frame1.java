
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


/**
 *
 * @author NAOFUMI
 */
public class Frame1 extends javax.swing.JFrame {
    
    private final Frame2 jF2 = new Frame2();

    /**
     * Creates new form Frame1
     */
    
    public Frame1() {
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

        groupGender = new javax.swing.ButtonGroup();
        panel1 = new javax.swing.JPanel();
        judul1 = new javax.swing.JLabel();
        judul2 = new javax.swing.JLabel();
        judul3 = new javax.swing.JLabel();
        judul4 = new javax.swing.JLabel();
        panel2 = new javax.swing.JPanel();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        toFrame2 = new javax.swing.JButton();
        labelNama = new javax.swing.JLabel();
        labelTempatLahir = new javax.swing.JLabel();
        labelTanggalLahir = new javax.swing.JLabel();
        labelGender = new javax.swing.JLabel();
        labelAlamat = new javax.swing.JLabel();
        labelTlpn = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelProdi = new javax.swing.JLabel();
        labelFakultas = new javax.swing.JLabel();
        txtAlamat = new javax.swing.JTextField();
        txtTempat = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jTextFieldNama = new javax.swing.JTextField();
        txtNo = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtProdi = new javax.swing.JTextField();
        LakiLaki = new javax.swing.JRadioButton();
        Perempuan = new javax.swing.JRadioButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        ComboBox1 = new javax.swing.JComboBox<>();
        SyaratNama = new javax.swing.JLabel();
        SyaratTempat = new javax.swing.JLabel();
        SyaratTanggal = new javax.swing.JLabel();
        SyaratAlamat = new javax.swing.JLabel();
        SyaratNo = new javax.swing.JLabel();
        SyaratEmail = new javax.swing.JLabel();
        SyaratProdi = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        panel1.setBackground(new java.awt.Color(0, 153, 255));

        judul1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        judul1.setText("FORMULIR PENDAFTARAN MAHASISWA");

        judul2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        judul2.setText("UNIVERSITAS TRUNOJOYO MADURA");

        judul3.setText("Jl. Raya Telang PO Box.2 Kamal, Bangkalan-Madura");

        judul4.setText("Telp. : (031) 3011146, Fax. (031) 3011506");

        panel2.setBackground(new java.awt.Color(0, 51, 153));
        panel2.setPreferredSize(new java.awt.Dimension(500, 370));

        button1.setText("Batal");
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setText("Reset");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        toFrame2.setText("Simpan");
        toFrame2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                toFrame2MouseClicked(evt);
            }
        });
        toFrame2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                toFrame2ActionPerformed(evt);
            }
        });

        labelNama.setForeground(new java.awt.Color(255, 255, 255));
        labelNama.setText("Nama :");

        labelTempatLahir.setForeground(new java.awt.Color(255, 255, 255));
        labelTempatLahir.setText("Tempat Lahir :");

        labelTanggalLahir.setForeground(new java.awt.Color(255, 255, 255));
        labelTanggalLahir.setText("Tanggal Lahir :");

        labelGender.setForeground(new java.awt.Color(255, 255, 255));
        labelGender.setText("Jenis Kelamin :");

        labelAlamat.setForeground(new java.awt.Color(255, 255, 255));
        labelAlamat.setText("Alamat :");

        labelTlpn.setForeground(new java.awt.Color(255, 255, 255));
        labelTlpn.setText("No. Tlp. :");

        labelEmail.setForeground(new java.awt.Color(255, 255, 255));
        labelEmail.setText("Email :");

        labelProdi.setForeground(new java.awt.Color(255, 255, 255));
        labelProdi.setText("Prodi :");

        labelFakultas.setForeground(new java.awt.Color(255, 255, 255));
        labelFakultas.setText("Fakultas :");

        jTextFieldNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNamaActionPerformed(evt);
            }
        });

        groupGender.add(LakiLaki);
        LakiLaki.setForeground(new java.awt.Color(255, 255, 255));
        LakiLaki.setText("Laki-Laki");

        groupGender.add(Perempuan);
        Perempuan.setForeground(new java.awt.Color(255, 255, 255));
        Perempuan.setText("Perempuan");

        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("Data Yang Saya Masukkan Sudah Benar");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        ComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Pilih Fakultas--", "Fakultas Teknik", "Fakultas Pertanian", "Fakultas Kelautan", "Fakultas Kedokteran", "Fakultas Pendidikan" }));
        ComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTempatLahir)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(labelNama)))
                        .addGap(18, 18, 18)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addComponent(LakiLaki)
                                .addGap(47, 47, 47)
                                .addComponent(Perempuan))
                            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(SyaratTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTanggal, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                .addComponent(SyaratNama, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SyaratTempat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTempat)
                                .addComponent(jTextFieldNama))))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelTanggalLahir)
                                    .addComponent(labelAlamat, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelGender, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelTlpn, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelEmail, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(16, 16, 16))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(labelFakultas)
                                    .addComponent(labelProdi))
                                .addGap(18, 18, 18)))
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SyaratProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(toFrame2)
                                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SyaratEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SyaratNo, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(SyaratAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtAlamat, javax.swing.GroupLayout.DEFAULT_SIZE, 414, Short.MAX_VALUE)
                                    .addComponent(txtNo)
                                    .addComponent(txtEmail)
                                    .addComponent(txtProdi)))))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button2)
                            .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panel2Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(button1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNama)
                    .addComponent(jTextFieldNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SyaratNama, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTempat, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTempatLahir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SyaratTempat, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(labelTanggalLahir)
                        .addGap(29, 29, 29)
                        .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelGender)
                            .addComponent(LakiLaki)
                            .addComponent(Perempuan)))
                    .addGroup(panel2Layout.createSequentialGroup()
                        .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SyaratTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelAlamat)
                    .addComponent(txtAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SyaratAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTlpn))
                .addGap(2, 2, 2)
                .addComponent(SyaratNo, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SyaratEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProdi)
                    .addComponent(txtProdi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SyaratProdi, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelFakultas))
                .addGap(18, 18, 18)
                .addComponent(jCheckBox1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1)
                    .addComponent(button2)
                    .addComponent(toFrame2))
                .addGap(72, 72, 72))
        );

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panel1Layout.createSequentialGroup()
                .addContainerGap(199, Short.MAX_VALUE)
                .addGroup(panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(judul1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(109, 109, 109))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(judul2)
                        .addGap(162, 162, 162))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(judul3)
                        .addGap(151, 151, 151))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                        .addComponent(judul4)
                        .addGap(156, 156, 156))))
            .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 671, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(judul1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judul2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judul3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(judul4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel2, javax.swing.GroupLayout.DEFAULT_SIZE, 563, Short.MAX_VALUE))
        );

        getContentPane().add(panel1);
        panel1.setBounds(0, 0, 671, 670);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void toFrame2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_toFrame2ActionPerformed
        // TODO add your handling code here:
        
        if(jCheckBox1.isSelected()){
            Frame2 Frame2 = new Frame2();
            Frame2.TextFieldNama.setText(jTextFieldNama.getText());
            Frame2.TextFieldTempatLahir.setText(txtTempat.getText());
            Frame2.TextFieldTanggalLahir.setText(txtTanggal.getText());
            Frame2.TextFieldTlp.setText(txtNo.getText());
            Frame2.TextFieldEmail.setText(txtEmail.getText());
            Frame2.TextFieldProdi.setText(txtProdi.getText());
            Frame2.TextFieldAlamat.setText(txtAlamat.getText());
            String Fakultas = (String)ComboBox1.getSelectedItem().toString();
            Frame2.TextFieldFakultas.setText(Fakultas);
            if (LakiLaki.isSelected()){
                Frame2.TextFieldGender.setText("Laki-Laki");
            } else if (Perempuan.isSelected()){
                Frame2.TextFieldGender.setText("Perempuan");
            }
            Frame2.setVisible(true);    
//            this.dispose();
        }else {
//            lblSyarat.setText("Mohon centang terlebih dahulu");
            JOptionPane.showMessageDialog(null,"Harap Checklist Terlebih Dahulu!", "Peringatan", JOptionPane.ERROR_MESSAGE);
        }
        
        if(jTextFieldNama.getText().trim().isEmpty()||
           txtTempat.getText().trim().isEmpty()||
           txtTanggal.getText().trim().isEmpty()||
           txtAlamat.getText().trim().isEmpty()||
           txtNo.getText().trim().isEmpty()||
           txtEmail.getText().trim().isEmpty()||
           txtProdi.getText().trim().isEmpty()
                ){
            SyaratNama.setText("Form harus diisi!!!");
            SyaratTempat.setText("Form harus diisi!!!");
            SyaratTanggal.setText("Form harus diisi!!!");
            SyaratAlamat.setText("Form harus diisi!!!");
            SyaratNo.setText("Form harus diisi!!!");
            SyaratEmail.setText("Form harus diisi!!!");
            SyaratProdi.setText("Form harus diisi!!!");
            
        }else{
            SyaratNama.setText(null);
            SyaratTempat.setText(null);
            SyaratTanggal.setText(null);
            SyaratAlamat.setText(null);
            SyaratNo.setText(null);
            SyaratEmail.setText(null);
            SyaratProdi.setText(null);
        }
        
    }//GEN-LAST:event_toFrame2ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_button1ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1ActionPerformed
    
    private void bersih(){
        txtAlamat.setText(null);
        txtTempat.setText(null);
        txtTanggal.setText(null);
        jTextFieldNama.setText(null);
        txtNo.setText(null);
        txtEmail.setText(null);
        txtProdi.setText(null);
        ComboBox1.requestFocus();
        groupGender.clearSelection();
    }
    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        // TODO add your handling code here:
        bersih();
    }//GEN-LAST:event_button2ActionPerformed

    private void toFrame2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_toFrame2MouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_toFrame2MouseClicked

    private void ComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBox1ActionPerformed

    private void jTextFieldNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNamaActionPerformed

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
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBox1;
    private javax.swing.JRadioButton LakiLaki;
    private javax.swing.JRadioButton Perempuan;
    private javax.swing.JLabel SyaratAlamat;
    private javax.swing.JLabel SyaratEmail;
    private javax.swing.JLabel SyaratNama;
    private javax.swing.JLabel SyaratNo;
    private javax.swing.JLabel SyaratProdi;
    private javax.swing.JLabel SyaratTanggal;
    private javax.swing.JLabel SyaratTempat;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.ButtonGroup groupGender;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JTextField jTextFieldNama;
    private javax.swing.JLabel judul1;
    private javax.swing.JLabel judul2;
    private javax.swing.JLabel judul3;
    private javax.swing.JLabel judul4;
    private javax.swing.JLabel labelAlamat;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelFakultas;
    private javax.swing.JLabel labelGender;
    private javax.swing.JLabel labelNama;
    private javax.swing.JLabel labelProdi;
    private javax.swing.JLabel labelTanggalLahir;
    private javax.swing.JLabel labelTempatLahir;
    private javax.swing.JLabel labelTlpn;
    private javax.swing.JPanel panel1;
    private javax.swing.JPanel panel2;
    private javax.swing.JButton toFrame2;
    private javax.swing.JTextField txtAlamat;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNo;
    private javax.swing.JTextField txtProdi;
    private javax.swing.JTextField txtTanggal;
    private javax.swing.JTextField txtTempat;
    // End of variables declaration//GEN-END:variables
}