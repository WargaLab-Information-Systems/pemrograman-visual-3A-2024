
import javax.swing.JOptionPane;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


public class apotek_2 extends javax.swing.JFrame {
      private int jumlah = 0; 
     
    /**
     * @author amanda aulia
     */
    public apotek_2() {
        initComponents();
        tfjumlah.setText(String.valueOf(jumlah));
    }
    private void showDetail(String namaObat) {
        String detail = "";
        switch (namaObat) {
            case "Paracetamol":
                detail = "Paracetamol digunakan untuk mengurangi rasa sakit dan demam.";
                break;
            case "Decolgen":
                detail = "Decolgen digunakan untuk meredakan flu dan pilek.";
                break;
            case "Vitamin C":
                detail = "Vitamin C membantu meningkatkan daya tahan tubuh.";
                break;
            case "Tetra":
                detail = "Tetra digunakan sebagai antibiotik untuk infeksi bakteri.";
                break;
            case "Sangobion":
                detail = "Sangobion digunakan untuk mengatasi anemia.";
                break;
            case "Antangin":
                detail = "Antangin digunakan untuk meredakan masuk angin.";
                break;
            case "Betadine":
                detail = "Betadine digunakan sebagai antiseptik untuk luka.";
                break;
            case "Promag":
                detail = "Promag digunakan untuk mengatasi gangguan lambung.";
                break;
            case "Konidin":
                detail = "Konidin digunakan untuk meredakan batuk.";
                break;
            case "Paramex":
                detail = "Paramex digunakan untuk mengurangi sakit kepala.";
                break;
            default:
                detail = "Detail tidak tersedia untuk obat ini.";
        }
        javax.swing.JOptionPane.showMessageDialog(this, detail, "Informasi Obat", javax.swing.JOptionPane.INFORMATION_MESSAGE);
    }
     private void showGejala(String namaObat) {
    String gejala = "";
    switch (namaObat) {
        case "Paracetamol":
            gejala = "Demam, Sakit Kepala, Nyeri Otot";
            break;
        case "Decolgen":
            gejala = "Pilek, Batuk, Demam";
            break;
        case "Vitamin C":
            gejala = "Daya Tahan Tubuh Lemah, Sariawan";
            break;
        case "Tetra":
            gejala = "Infeksi Bakteri, Radang Tenggorokan";
            break;
        case "Sangobion":
            gejala = "Anemia, Kekurangan Zat Besi";
            break;
        case "Antangin":
            gejala = "Masuk Angin, Kembung, Mual";
            break;
        case "Betadine":
            gejala = "Luka Ringan , Luka Terbuka";
            break;
        case "Promag":
            gejala = "Maag, Nyeri Lambung";
            break;
        case "Konidin":
            gejala = "Batuk Kering, Batuk Berdahak";
            break;
        case "Paramex":
            gejala = "Sakit Kepala, Demam";
            break;
        default:
            gejala = "Gejala tidak tersedia untuk obat ini.";
    }
    txt3.setText(gejala);
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        ButtonGroupObat = new javax.swing.ButtonGroup();
        jPanelbawah = new javax.swing.JPanel();
        btnreset = new javax.swing.JButton();
        btnkeluar = new javax.swing.JButton();
        jPaneljudul = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        btnantangin = new javax.swing.JButton();
        rdbtnantangin = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        btnsangobion = new javax.swing.JButton();
        btntetra = new javax.swing.JButton();
        btnvitiminci = new javax.swing.JButton();
        btnkonidin = new javax.swing.JButton();
        btnparacetamol = new javax.swing.JButton();
        btnpromag = new javax.swing.JButton();
        btndecolgen = new javax.swing.JButton();
        btnparamex = new javax.swing.JButton();
        btnbetadine = new javax.swing.JButton();
        rdbtnbetadine = new javax.swing.JRadioButton();
        rdbtnparamex = new javax.swing.JRadioButton();
        rdbtnpromag = new javax.swing.JRadioButton();
        rdbtndecolgen = new javax.swing.JRadioButton();
        rdbtnvitaminci = new javax.swing.JRadioButton();
        rdbtnsangobion = new javax.swing.JRadioButton();
        rdbtntetra = new javax.swing.JRadioButton();
        rdbtnkonidin = new javax.swing.JRadioButton();
        rdbtnparacetamol = new javax.swing.JRadioButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt1 = new javax.swing.JPanel();
        tfjumlah = new javax.swing.JTextField();
        btnkurang = new javax.swing.JButton();
        btntambah = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txt2 = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        btnsimpan = new javax.swing.JButton();
        txt3 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelbawah.setLayout(new java.awt.GridLayout(1, 0));

        btnreset.setText("Reset");
        btnreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresetActionPerformed(evt);
            }
        });
        jPanelbawah.add(btnreset);

        btnkeluar.setText("Keluar");
        btnkeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkeluarActionPerformed(evt);
            }
        });
        jPanelbawah.add(btnkeluar);

        getContentPane().add(jPanelbawah, java.awt.BorderLayout.PAGE_END);

        jPaneljudul.setBackground(new java.awt.Color(255, 153, 153));

        jPanel2.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setBackground(new java.awt.Color(0, 102, 204));
        jLabel1.setFont(new java.awt.Font("Snap ITC", 1, 24)); // NOI18N
        jLabel1.setText("APOTEK MINI ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(529, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(375, 375, 375))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        jPaneljudul.add(jPanel2);

        getContentPane().add(jPaneljudul, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jLabel6.setText("Antangin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 20);
        jPanel1.add(jLabel6, gridBagConstraints);

        btnantangin.setText("detail");
        btnantangin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnantanginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 20);
        jPanel1.add(btnantangin, gridBagConstraints);

        ButtonGroupObat.add(rdbtnantangin);
        rdbtnantangin.setText("pilih");
        rdbtnantangin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnantanginActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.ipady = -5;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 20);
        jPanel1.add(rdbtnantangin, gridBagConstraints);

        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Pictures\\antangin.png")); // NOI18N
        jLabel7.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.insets = new java.awt.Insets(0, 10, 0, 0);
        jPanel1.add(jLabel7, gridBagConstraints);

        jLabel8.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Pictures\\promag.png")); // NOI18N
        jLabel8.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 12;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanel1.add(jLabel8, gridBagConstraints);

        jLabel9.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\supertetra.png")); // NOI18N
        jLabel9.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel9, gridBagConstraints);

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\konidin.png")); // NOI18N
        jLabel10.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel10, gridBagConstraints);

        jLabel11.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\paramex.png")); // NOI18N
        jLabel11.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanel1.add(jLabel11, gridBagConstraints);

        jLabel13.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\del.png")); // NOI18N
        jLabel13.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanel1.add(jLabel13, gridBagConstraints);

        jLabel14.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\vitacimin.png")); // NOI18N
        jLabel14.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel14, gridBagConstraints);

        jLabel15.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\betadine.png")); // NOI18N
        jLabel15.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        jPanel1.add(jLabel15, gridBagConstraints);

        jLabel16.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\sangobion.png")); // NOI18N
        jLabel16.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 20);
        jPanel1.add(jLabel16, gridBagConstraints);

        jLabel17.setIcon(new javax.swing.ImageIcon("C:\\Users\\HP\\Videos\\paracetamol.png")); // NOI18N
        jLabel17.setText("jLabel5");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.ipadx = -47;
        gridBagConstraints.ipady = -14;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel17, gridBagConstraints);

        jLabel12.setText("Decolgen");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel12, gridBagConstraints);

        jLabel18.setText("Paracetamol");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel18, gridBagConstraints);

        jLabel19.setText("Betadine");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel19, gridBagConstraints);

        jLabel20.setText("Promag");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel20, gridBagConstraints);

        jLabel21.setText("Paramex");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel21, gridBagConstraints);

        jLabel22.setText("Konidin");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel22, gridBagConstraints);

        jLabel23.setText("Vitamin C");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel23, gridBagConstraints);

        jLabel24.setText("Sangobion");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 20);
        jPanel1.add(jLabel24, gridBagConstraints);

        jLabel25.setText("SuperTetra");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(jLabel25, gridBagConstraints);

        btnsangobion.setText("detail");
        btnsangobion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsangobionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 20);
        jPanel1.add(btnsangobion, gridBagConstraints);

        btntetra.setText("detail");
        btntetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntetraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btntetra, gridBagConstraints);

        btnvitiminci.setText("detail");
        btnvitiminci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvitiminciActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 9;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btnvitiminci, gridBagConstraints);

        btnkonidin.setText("detail");
        btnkonidin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkonidinActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 13;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btnkonidin, gridBagConstraints);

        btnparacetamol.setText("detail");
        btnparacetamol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnparacetamolActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btnparacetamol, gridBagConstraints);

        btnpromag.setText("detail");
        btnpromag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpromagActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btnpromag, gridBagConstraints);

        btndecolgen.setText("detail");
        btndecolgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndecolgenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btndecolgen, gridBagConstraints);

        btnparamex.setText("detail");
        btnparamex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnparamexActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 19;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btnparamex, gridBagConstraints);

        btnbetadine.setText("detail");
        btnbetadine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbetadineActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(btnbetadine, gridBagConstraints);

        ButtonGroupObat.add(rdbtnbetadine);
        rdbtnbetadine.setText("pilih");
        rdbtnbetadine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnbetadineActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtnbetadine, gridBagConstraints);

        ButtonGroupObat.add(rdbtnparamex);
        rdbtnparamex.setText("pilih");
        rdbtnparamex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnparamexActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtnparamex, gridBagConstraints);

        ButtonGroupObat.add(rdbtnpromag);
        rdbtnpromag.setText("pilih");
        rdbtnpromag.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnpromagActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtnpromag, gridBagConstraints);

        ButtonGroupObat.add(rdbtndecolgen);
        rdbtndecolgen.setText("pilih");
        rdbtndecolgen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtndecolgenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtndecolgen, gridBagConstraints);

        ButtonGroupObat.add(rdbtnvitaminci);
        rdbtnvitaminci.setText("pilih");
        rdbtnvitaminci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnvitaminciActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtnvitaminci, gridBagConstraints);

        ButtonGroupObat.add(rdbtnsangobion);
        rdbtnsangobion.setText("pilih");
        rdbtnsangobion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnsangobionActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 50, 0, 20);
        jPanel1.add(rdbtnsangobion, gridBagConstraints);

        ButtonGroupObat.add(rdbtntetra);
        rdbtntetra.setText("pilih");
        rdbtntetra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtntetraActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtntetra, gridBagConstraints);

        ButtonGroupObat.add(rdbtnkonidin);
        rdbtnkonidin.setText("pilih");
        rdbtnkonidin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnkonidinActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtnkonidin, gridBagConstraints);

        ButtonGroupObat.add(rdbtnparacetamol);
        rdbtnparacetamol.setText("pilih");
        rdbtnparacetamol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbtnparacetamolActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.ipadx = 8;
        gridBagConstraints.insets = new java.awt.Insets(10, 0, 0, 20);
        jPanel1.add(rdbtnparacetamol, gridBagConstraints);

        jPanel6.setBackground(new java.awt.Color(255, 204, 51));

        jLabel4.setBackground(new java.awt.Color(0, 102, 204));
        jLabel4.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        jLabel4.setText("             PILIH OBAT");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel5))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 47;
        gridBagConstraints.ipady = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(13, 63, 0, 6);
        jPanel1.add(jPanel6, gridBagConstraints);

        tfjumlah.setEditable(false);
        tfjumlah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfjumlahActionPerformed(evt);
            }
        });

        btnkurang.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btnkurang.setText("-");
        btnkurang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkurangActionPerformed(evt);
            }
        });

        btntambah.setFont(new java.awt.Font("Segoe UI Black", 1, 18)); // NOI18N
        btntambah.setText("+");
        btntambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntambahActionPerformed(evt);
            }
        });

        jLabel3.setText("obat dipilih");

        txt2.setEditable(false);

        jLabel26.setText("gejala penyakit");

        btnsimpan.setText("simpan");
        btnsimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout txt1Layout = new javax.swing.GroupLayout(txt1);
        txt1.setLayout(txt1Layout);
        txt1Layout.setHorizontalGroup(
            txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txt1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsimpan)
                .addGap(41, 41, 41))
            .addGroup(txt1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txt1Layout.createSequentialGroup()
                        .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnkurang)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txt1Layout.createSequentialGroup()
                                .addComponent(txt2)
                                .addGap(6, 6, 6))
                            .addComponent(txt3))
                        .addGap(31, 31, 31))
                    .addGroup(txt1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tfjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btntambah)
                        .addGap(48, 48, 48))))
        );
        txt1Layout.setVerticalGroup(
            txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txt1Layout.createSequentialGroup()
                .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, txt1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnkurang)
                        .addGap(18, 18, 18))
                    .addGroup(txt1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btntambah)
                            .addComponent(tfjumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(txt1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnsimpan)
                .addGap(35, 35, 35))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.ipady = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(6, 66, 54, 9);
        jPanel1.add(txt1, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnkonidinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkonidinActionPerformed
        // TODO add your handling code here:
         showDetail("Konidin");
    }//GEN-LAST:event_btnkonidinActionPerformed

    private void btnvitiminciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvitiminciActionPerformed
        // TODO add your handling code here:
        showDetail("Vitamin C");

    }//GEN-LAST:event_btnvitiminciActionPerformed

    private void rdbtndecolgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtndecolgenActionPerformed
        // TODO add your handling code here:
           txt2.setText("Decolgen");
           showGejala("Decolgen");
    }//GEN-LAST:event_rdbtndecolgenActionPerformed

    private void rdbtnparacetamolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnparacetamolActionPerformed
        // TODO add your handling code here:
          txt2.setText("Paracetamol");
          showGejala("Paracetamol");
    }//GEN-LAST:event_rdbtnparacetamolActionPerformed

    private void rdbtnvitaminciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnvitaminciActionPerformed
        // TODO add your handling code here:
         txt2.setText("Vitamin C");
          showGejala("Vitamin C");
    }//GEN-LAST:event_rdbtnvitaminciActionPerformed

    private void rdbtntetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtntetraActionPerformed
        // TODO add your handling code here:
         txt2.setText("Tetra");
          showGejala("Tetra");
    }//GEN-LAST:event_rdbtntetraActionPerformed

    private void rdbtnsangobionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnsangobionActionPerformed
        // TODO add your handling code here:
          txt2.setText("Sangobion");
           showGejala("sangobion");
    }//GEN-LAST:event_rdbtnsangobionActionPerformed

    private void btnparacetamolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnparacetamolActionPerformed
        // TODO add your handling code here:
         showDetail("Paracetamol");

    }//GEN-LAST:event_btnparacetamolActionPerformed

    private void rdbtnantanginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnantanginActionPerformed
        // TODO add your handling code here:
         txt2.setText("Antangin");
         showGejala("Antangin");
    }//GEN-LAST:event_rdbtnantanginActionPerformed

    private void btnbetadineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbetadineActionPerformed
        // TODO add your handling code here:
        showDetail("Betadine");

    }//GEN-LAST:event_btnbetadineActionPerformed

    private void rdbtnbetadineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnbetadineActionPerformed
        // TODO add your handling code here:
         txt2.setText("Betadine");
          showGejala("Betadine");
    }//GEN-LAST:event_rdbtnbetadineActionPerformed

    private void btndecolgenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndecolgenActionPerformed
        // TODO add your handling code here:
         showDetail("Decolgen");

    }//GEN-LAST:event_btndecolgenActionPerformed

    private void btnpromagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpromagActionPerformed
        // TODO add your handling code here:
         showDetail("Promag");

    }//GEN-LAST:event_btnpromagActionPerformed

    private void rdbtnpromagActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnpromagActionPerformed
        // TODO add your handling code here:
         txt2.setText("Promag");
         showGejala("Promag");
    }//GEN-LAST:event_rdbtnpromagActionPerformed

    private void rdbtnparamexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnparamexActionPerformed
        // TODO add your handling code here:
         txt2.setText("Paramex");
          showGejala("Paramex");
    }//GEN-LAST:event_rdbtnparamexActionPerformed

    private void btnantanginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnantanginActionPerformed
        // TODO add your handling code here:
        showDetail("Antangin");

    }//GEN-LAST:event_btnantanginActionPerformed

    private void btnparamexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnparamexActionPerformed
        // TODO add your handling code here:
         showDetail("Paramex");

    }//GEN-LAST:event_btnparamexActionPerformed

    private void btnsangobionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsangobionActionPerformed
        // TODO add your handling code here:
          showDetail("Sangobion");

    }//GEN-LAST:event_btnsangobionActionPerformed

    private void btntetraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntetraActionPerformed
        // TODO add your handling code here:
         showDetail("Tetra");

    }//GEN-LAST:event_btntetraActionPerformed

    private void btnresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresetActionPerformed
        // TODO add your handling code here:
         
         txt2.setText("");
         txt3.setText("");
         ButtonGroupObat.clearSelection();
         jumlah = 0;
         tfjumlah.setText(String.valueOf(jumlah));
    }//GEN-LAST:event_btnresetActionPerformed

    private void btnkeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnkeluarActionPerformed

    private void rdbtnkonidinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbtnkonidinActionPerformed
        // TODO add your handling code here:
        txt2.setText("Konidin");
        showGejala("Konidin");
    }//GEN-LAST:event_rdbtnkonidinActionPerformed

    private void btnkurangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkurangActionPerformed
        // TODO add your handling code here:
         if (jumlah > 0) {
        jumlah--; 
        tfjumlah.setText(String.valueOf(jumlah));
         } else {
        JOptionPane.showMessageDialog(this, "Jumlah tidak boleh kurang dari 0", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnkurangActionPerformed

    private void btntambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntambahActionPerformed
        // TODO add your handling code here:
        jumlah++; 
        tfjumlah.setText(String.valueOf(jumlah));
       
    }//GEN-LAST:event_btntambahActionPerformed

    private void btnsimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimpanActionPerformed
        // TODO add your handling code here:
         String namaObat = txt2.getText(); 
         String gejala = txt3.getText(); 
         int jumlahObat = jumlah;        

   
    if (namaObat.isEmpty() || gejala.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Pilih obat terlebih dahulu.", "Peringatan", JOptionPane.WARNING_MESSAGE);
        return;
    }
    String struk = "Struk Pembelian Obat\n" +
                   "=====================\n" +
                   "Nama Obat: " + namaObat + "\n" +
                   "Gejala: " + gejala + "\n" +
                   "Jumlah Obat: " + jumlahObat + "\n" +
                   "=====================\n" +
                   "Terima kasih telah berbelanja di Apotek kami.";

 
    JOptionPane.showMessageDialog(this, struk, "Struk Pembelian", JOptionPane.INFORMATION_MESSAGE);

    }//GEN-LAST:event_btnsimpanActionPerformed

    private void tfjumlahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfjumlahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfjumlahActionPerformed

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
            java.util.logging.Logger.getLogger(apotek_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(apotek_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(apotek_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(apotek_2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new apotek_2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ButtonGroupObat;
    private javax.swing.JButton btnantangin;
    private javax.swing.JButton btnbetadine;
    private javax.swing.JButton btndecolgen;
    private javax.swing.JButton btnkeluar;
    private javax.swing.JButton btnkonidin;
    private javax.swing.JButton btnkurang;
    private javax.swing.JButton btnparacetamol;
    private javax.swing.JButton btnparamex;
    private javax.swing.JButton btnpromag;
    private javax.swing.JButton btnreset;
    private javax.swing.JButton btnsangobion;
    private javax.swing.JButton btnsimpan;
    private javax.swing.JButton btntambah;
    private javax.swing.JButton btntetra;
    private javax.swing.JButton btnvitiminci;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelbawah;
    private javax.swing.JPanel jPaneljudul;
    private javax.swing.JRadioButton rdbtnantangin;
    private javax.swing.JRadioButton rdbtnbetadine;
    private javax.swing.JRadioButton rdbtndecolgen;
    private javax.swing.JRadioButton rdbtnkonidin;
    private javax.swing.JRadioButton rdbtnparacetamol;
    private javax.swing.JRadioButton rdbtnparamex;
    private javax.swing.JRadioButton rdbtnpromag;
    private javax.swing.JRadioButton rdbtnsangobion;
    private javax.swing.JRadioButton rdbtntetra;
    private javax.swing.JRadioButton rdbtnvitaminci;
    private javax.swing.JTextField tfjumlah;
    private javax.swing.JPanel txt1;
    private javax.swing.JTextField txt2;
    private javax.swing.JTextField txt3;
    // End of variables declaration//GEN-END:variables
}
