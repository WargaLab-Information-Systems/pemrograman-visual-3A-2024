import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Lenovo
 */
public class Soal1Mo3 extends javax.swing.JFrame {

    /**
     * Creates new form Soal1Mo3
     */
    public Soal1Mo3() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        gambarBanyak = new javax.swing.JLabel();
        ApotekPanggung = new javax.swing.JLabel();
        GambarApoteker = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        nama = new javax.swing.JLabel();
        TextFieldnamaPasien = new javax.swing.JTextField();
        gejalaDirasakan = new javax.swing.JLabel();
        ComboBoxGejala = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        amoxcillin = new javax.swing.JLabel();
        famocid = new javax.swing.JLabel();
        entrostop = new javax.swing.JLabel();
        avesco = new javax.swing.JLabel();
        panadolBiru = new javax.swing.JLabel();
        paramex = new javax.swing.JLabel();
        polycrol = new javax.swing.JLabel();
        ardium = new javax.swing.JLabel();
        rohto = new javax.swing.JLabel();
        sangobion = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TextAreaDeskripsi = new javax.swing.JTextArea();
        Deskripsi = new javax.swing.JLabel();
        ButtonKeluar = new javax.swing.JButton();
        ButtonCari = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jPanel3.setBackground(new java.awt.Color(0, 204, 204));

        gambarBanyak.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\apotek11.png")); // NOI18N
        jPanel3.add(gambarBanyak);

        ApotekPanggung.setFont(new java.awt.Font("OCR A Extended", 1, 24)); // NOI18N
        ApotekPanggung.setText("Apotek Panggung");
        jPanel3.add(ApotekPanggung);

        GambarApoteker.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\iconApoteker.png")); // NOI18N
        jPanel3.add(GambarApoteker);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        nama.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        nama.setForeground(new java.awt.Color(255, 255, 255));
        nama.setText("Nama Pasien : ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 38, 0, 0);
        jPanel1.add(nama, gridBagConstraints);

        TextFieldnamaPasien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldnamaPasienActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 80;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 12, 32, 0);
        jPanel1.add(TextFieldnamaPasien, gridBagConstraints);

        gejalaDirasakan.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        gejalaDirasakan.setForeground(new java.awt.Color(255, 255, 255));
        gejalaDirasakan.setText("Gejala Dirasakan :");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(32, 68, 0, 0);
        jPanel1.add(gejalaDirasakan, gridBagConstraints);

        ComboBoxGejala.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxGejala.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Gejala Yang Dirasakan :", "1. Perut Dan Ulu Hati Sakit (Maagh)", "2. BAB Keluar Darah", "3. Infeksi Bakteri", "4. Kurang Darah", "5. Asam Lambung Naik", "6. Pegal-Pegal Otot Nyeri", "7. Kolestrol Tinggi", "8. BAB Terus Menerus", "9. Mata Merah Berair", "10. Kepala Pusing Demam" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = -66;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(24, 18, 32, 197);
        jPanel1.add(ComboBoxGejala, gridBagConstraints);

        jPanel4.setBackground(new java.awt.Color(0, 204, 204));
        jPanel4.setLayout(new java.awt.GridLayout(2, 5, 7, 4));

        amoxcillin.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\amoxcilin(infeksi bakteri).jpg")); // NOI18N
        jPanel4.add(amoxcillin);

        famocid.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\asam lambung (famocid).jpg")); // NOI18N
        jPanel4.add(famocid);

        entrostop.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\entronstop.jpg")); // NOI18N
        jPanel4.add(entrostop);

        avesco.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\Kolestrol1.jpg")); // NOI18N
        jPanel4.add(avesco);

        panadolBiru.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\panadol biru .jpg")); // NOI18N
        jPanel4.add(panadolBiru);

        paramex.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\paramex nyeri otot.jpg")); // NOI18N
        jPanel4.add(paramex);

        polycrol.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\PolycrolMaag1.jpg")); // NOI18N
        jPanel4.add(polycrol);

        ardium.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\bab berdarah (ardium).jpg")); // NOI18N
        jPanel4.add(ardium);

        rohto.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\Rohto.jpg")); // NOI18N
        jPanel4.add(rohto);

        sangobion.setIcon(new javax.swing.ImageIcon("D:\\Praktikum Pemvis\\MODUL 3\\Sangobion2.jpg")); // NOI18N
        jPanel4.add(sangobion);

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setLayout(new java.awt.BorderLayout());

        TextAreaDeskripsi.setColumns(20);
        TextAreaDeskripsi.setRows(5);
        jScrollPane1.setViewportView(TextAreaDeskripsi);

        Deskripsi.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Deskripsi.setForeground(new java.awt.Color(255, 255, 255));
        Deskripsi.setText("~~~ Deskripsi Obat ~~~");

        ButtonKeluar.setBackground(new java.awt.Color(153, 153, 153));
        ButtonKeluar.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonKeluar.setText("Exit");
        ButtonKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonKeluarActionPerformed(evt);
            }
        });

        ButtonCari.setBackground(new java.awt.Color(153, 153, 153));
        ButtonCari.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonCari.setText("Cari");
        ButtonCari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCariActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 708, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(162, 162, 162)
                                .addComponent(ButtonCari)
                                .addGap(82, 82, 82)
                                .addComponent(ButtonKeluar))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(275, 275, 275)
                        .addComponent(Deskripsi)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Deskripsi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonKeluar)
                    .addComponent(ButtonCari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextFieldnamaPasienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldnamaPasienActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(this, "Masukkan Nama Pasien ", "Information", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_TextFieldnamaPasienActionPerformed

    private void ButtonCariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCariActionPerformed
                                         
    // 
    String namaPasien = TextFieldnamaPasien.getText().trim();  
    String gejala = (String) ComboBoxGejala.getSelectedItem();

    // Reset
    TextAreaDeskripsi.setText("");

    // cek nama&gejala kosong
    if (namaPasien.isEmpty() || gejala == null) {
        TextAreaDeskripsi.append("Nama Pasien dan Gejala harus diisi!\n");
        return;
    }

    // tambah nama pasien
    TextAreaDeskripsi.append("Nama Pasien : " + namaPasien + "\n");
    TextAreaDeskripsi.append("Gejala : " + gejala + "\n\n");

    // Ganti kasus untuk menampilkan detail obat berdasarkan gejala yang dipilih
    switch (gejala) {
        case "1. Maagh Perut Dan Ulu Hati":
            TextAreaDeskripsi.append("Obat untuk Maagh : Polycrol Forte\n");
            TextAreaDeskripsi.append("\n*** Cara Penggunaan Obat Polycrol Forte ***\n");
            TextAreaDeskripsi.append("Dosis: 1-2 tablet kunyah, 3 kali sehari\n");
            TextAreaDeskripsi.append("Diminum 1 jam sebelum makan atau 2 jam setelah makan, dan menjelang tidur\n");
            TextAreaDeskripsi.append("\n*** Efek Samping Polycrol Forte ***\n");
            TextAreaDeskripsi.append("Mual\nMuntah\nDiare\nSembelit\nHipermagnesemia (kadar magnesium dalam darah tinggi)\n");
            break;

        case "2. BAB Keluar Darah":
            TextAreaDeskripsi.append("Obat untuk BAB Keluar Darah : Ardium\n");
            TextAreaDeskripsi.append("\n*** Cara Penggunaan Ardium ***\n");
            TextAreaDeskripsi.append("Untuk Kronik: 2 Tablet/hari\n");
            TextAreaDeskripsi.append("Untuk Akut: 4 Tablet/Hari selama 3 hari\n");
            TextAreaDeskripsi.append("\n*** Efek Samping ***\n");
            TextAreaDeskripsi.append("Sakit perut, diare, pusing\n");
            break;

        case "3. Infeksi Bakteri":
            TextAreaDeskripsi.append("Obat untuk Infeksi Bakteri : Amoxicillin\n");
            TextAreaDeskripsi.append("\n*** Cara Penggunaan Amoxicillin ***\n");
            TextAreaDeskripsi.append("Dosis: 12 jam (dua kali sehari) atau setiap 8 jam (tiga kali sehari) tergantung seberapa parah gangguan yang terjadi.\n");
            TextAreaDeskripsi.append("\n*** Efek Samping ***\n");
            TextAreaDeskripsi.append("Mual, muntah dan diare\n");
            break;
        case "4. Kurang Darah" :
            TextAreaDeskripsi.append("Obat untuk Kurang Drah : Sangobion\n");
            TextAreaDeskripsi.append("");
            TextAreaDeskripsi.append("*** Cara Penggunaan Sangobion\n");
            TextAreaDeskripsi.append("1 Kapsul, diminum 1 kali per hari\n");
            TextAreaDeskripsi.append("");
            TextAreaDeskripsi.append("*** Efek Samping Sangobion\n");
            TextAreaDeskripsi.append("Sembelit atau diare\n");
            TextAreaDeskripsi.append("Mual atau muntah\n");
            TextAreaDeskripsi.append("Kram perut atau sakit maag\n");
            TextAreaDeskripsi.append("Hilang selera makan\n");
            TextAreaDeskripsi.append("Feses berwarna hijau\n");
            TextAreaDeskripsi.append("Noda pada gigi\n");
            break;
       case "5. Asam Lambung Naik":    
                TextAreaDeskripsi.append("Obat untuk Asam Lambung Naik : Famocid\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Cara Penggunaan Famocid ***\n");
                TextAreaDeskripsi.append("Dosis awal diberikan 1x sehari 2 tablet (40 mg) sebelum tidur, 2x sehari 1 tablet (20 mg).\n");
                TextAreaDeskripsi.append("Pengobatan cukup selama 4 minggu. Jarang Famocid digunakan lebih dari 6-8 minggu\n");
                TextAreaDeskripsi.append("Selanjutnya, dosis pemeliharaan diberikan 1x sehari 1 tablet (20 mg) sebelum tidur\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Efek Samping Famocid ***\n");
                TextAreaDeskripsi.append("Kadang-kadang demam\n");
                TextAreaDeskripsi.append("edema orbita karena reaksi hipersensitif\n");
                TextAreaDeskripsi.append("sesak\n");
                TextAreaDeskripsi.append("perdarahan atau memar\n");
                TextAreaDeskripsi.append("palpitasi, astenia\n");
                TextAreaDeskripsi.append("Sakit kepala\n");
                TextAreaDeskripsi.append("diare\n");
                break;
            case "6. Pegal - Pegal Otot Nyeri\n" :
                TextAreaDeskripsi.append("Obat untuk Nyeri Otot : Paramex Nyeri Otot\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Cara Penggunaan Paramex Nyeri Otot ***\n");
                TextAreaDeskripsi.append("1 tablet, 3 - 4 kali per hari. Tidak boleh melebihi dosis yang dianjurkan\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Efek Samping Paramex Nyeri Otot ***\n");
                TextAreaDeskripsi.append("Perut kembung\n");
                TextAreaDeskripsi.append("Mual dan muntah\n");
                TextAreaDeskripsi.append("Diare atau sembelit\n");
                TextAreaDeskripsi.append("Perubahan detak jantung, lebih kencang, atau lebih lambat\n");
                TextAreaDeskripsi.append("Tubuh terasa lemas\n");
                break;
            case "7. Kolestrol Tinggi\n" :
                TextAreaDeskripsi.append("Obat untuk Kolestrol Tinggi : Avosco\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Cara Penggunaan Avosco ***\n");
                TextAreaDeskripsi.append("Dosis awal yang biasa diberikan adalah 10 mg 1 kali sehari\n");
                TextAreaDeskripsi.append("Rentang dosis adalah antara 10-80 mg sekali sehari\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Efek Samping Avosco ***\n");
                TextAreaDeskripsi.append("perut kembung\n");
                TextAreaDeskripsi.append("dispepsia\n");
                TextAreaDeskripsi.append("nyeri abdomen\n");
                TextAreaDeskripsi.append("sakit kepala\n");
                TextAreaDeskripsi.append("mual\n");
                TextAreaDeskripsi.append("mialgia\n");
                TextAreaDeskripsi.append("lemas\n");
                break;
            case "8. BAB Terus Menerus\n":    
                TextAreaDeskripsi.append("Obat untuk BAB Terus Menerus : Entrostop\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Cara Penggunaan Entrostop ***\n");
                TextAreaDeskripsi.append("Dewasa dan Anak > 12 tahun : 2 tablet setiap kali setelah diare, maximum 12 tablet per hari (24 jam)\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Efek Samping Entrostop ***\n");
                TextAreaDeskripsi.append("Konstipasi\n");
                TextAreaDeskripsi.append("Perut kembung\n");
                TextAreaDeskripsi.append("Nyeri perut\n");
                TextAreaDeskripsi.append("Mual\n");
                TextAreaDeskripsi.append("Sakit kepala\n");
                TextAreaDeskripsi.append("Pusing\n");
                break;
            case "9. Mata Merah Berair\n":
                TextAreaDeskripsi.append("Obat untuk Mata Merah Berair : Rohto\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Cara Penggunaan Rohto ***\n");
                TextAreaDeskripsi.append("3 - 4 kali per hari teteskan 1 atau 2 tetes pada masing -masing mata\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Efek Samping Rohto ***\n");
                TextAreaDeskripsi.append("Mata merah\n");
                TextAreaDeskripsi.append("Mata terasa tersengat (ringan)\n");
                TextAreaDeskripsi.append("Silau saat melihat cahaya\n");
                TextAreaDeskripsi.append("Penglihatan buram sementara\n");
                break;
            case "10. Demam\n":
                TextAreaDeskripsi.append("Obat untuk Demam : Panadol Biru\n");
                TextAreaDeskripsi.append("Dewasa dan anak usia lebih dari 12 tahun : 1 - 2 kaplet, 3-4 kali sehari (Maksimum 8 kaplet dalam 24 jam)\n");
                TextAreaDeskripsi.append("Anak-anak usia 6-11 tahun : 1/2 - 1 kaplet, 3-4 kali sehari (maksimum 4 kaplet dalam 24 jam)\n");
                TextAreaDeskripsi.append("");
                TextAreaDeskripsi.append("*** Efek Samping Panadol ***\n");
                TextAreaDeskripsi.append("Penggunaan jangka panjang dan dosis besar dapat menyebabkan kerusakan hati\n");
                TextAreaDeskripsi.append("Kadang-kadang gangguan pernafasan atau bengkak pada bibir, lidah, tenggorokan\n");
                TextAreaDeskripsi.append("Sariawan\n");
                break;
        default:
            TextAreaDeskripsi.append("Klik untuk melihat Info Detail Obat Yang Tersedia");
            break;
    }


    }//GEN-LAST:event_ButtonCariActionPerformed

    private void ButtonKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonKeluarActionPerformed
        // TODO add your handling code here:
            int klik = JOptionPane.showConfirmDialog(null,"Ingin Keluar dari Halaman???", "Peringatan", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
        //kalau pilih YES maka tutup program.
        if (klik == JOptionPane.YES_OPTION){
        //pembatalan
        dispose();
    }
    }//GEN-LAST:event_ButtonKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(Soal1Mo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Soal1Mo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Soal1Mo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Soal1Mo3.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Soal1Mo3().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ApotekPanggung;
    private javax.swing.JButton ButtonCari;
    private javax.swing.JButton ButtonKeluar;
    private javax.swing.JComboBox<String> ComboBoxGejala;
    private javax.swing.JLabel Deskripsi;
    private javax.swing.JLabel GambarApoteker;
    private javax.swing.JTextArea TextAreaDeskripsi;
    private javax.swing.JTextField TextFieldnamaPasien;
    private javax.swing.JLabel amoxcillin;
    private javax.swing.JLabel ardium;
    private javax.swing.JLabel avesco;
    private javax.swing.JLabel entrostop;
    private javax.swing.JLabel famocid;
    private javax.swing.JLabel gambarBanyak;
    private javax.swing.JLabel gejalaDirasakan;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nama;
    private javax.swing.JLabel panadolBiru;
    private javax.swing.JLabel paramex;
    private javax.swing.JLabel polycrol;
    private javax.swing.JLabel rohto;
    private javax.swing.JLabel sangobion;
    // End of variables declaration//GEN-END:variables
}
