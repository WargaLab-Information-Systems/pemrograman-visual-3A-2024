/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package formulir;

import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class BG extends javax.swing.JFrame {

    /**
     * Creates new form BG
     */
    
    public BG() {
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

        buttonGroup1DIRI = new javax.swing.ButtonGroup();
        buttonGroup1SETUJU = new javax.swing.ButtonGroup();
        jOptionPane1 = new javax.swing.JOptionPane();
        background = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        FORMULIR = new javax.swing.JLabel();
        PENDAFTARAN = new javax.swing.JLabel();
        PARTNER = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        BGIDENTITAS = new javax.swing.JPanel();
        IDENTITASDIRI = new javax.swing.JLabel();
        NAMA = new javax.swing.JLabel();
        TTL = new javax.swing.JLabel();
        ASALKOTA = new javax.swing.JLabel();
        JENISKELAMIN = new javax.swing.JLabel();
        NOTLP = new javax.swing.JLabel();
        ALASAN = new javax.swing.JLabel();
        ISINAMA = new javax.swing.JTextField();
        ISITTL = new javax.swing.JTextField();
        ISIKOTA = new javax.swing.JTextField();
        ISITELP = new javax.swing.JTextField();
        ISIALASAN = new javax.swing.JTextField();
        PRIA = new javax.swing.JRadioButton();
        WANITA = new javax.swing.JRadioButton();
        BGKETENTUAN = new javax.swing.JPanel();
        KETENTUAN = new javax.swing.JLabel();
        AMANAH = new javax.swing.JLabel();
        PPDANBIO = new javax.swing.JLabel();
        PAKET = new javax.swing.JLabel();
        JENISKELAMINORTU = new javax.swing.JLabel();
        NOREF = new javax.swing.JLabel();
        ISIAMANAH = new javax.swing.JTextField();
        ISIPP = new javax.swing.JTextField();
        IYA = new javax.swing.JRadioButton();
        TIDAK = new javax.swing.JRadioButton();
        ISINOREF = new javax.swing.JTextField();
        cek = new javax.swing.JCheckBox();
        batal = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        simpan = new javax.swing.JButton();
        ISIPAKET = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        background.setBackground(new java.awt.Color(252, 250, 213));

        jPanel1.setBackground(new java.awt.Color(54, 85, 98));

        FORMULIR.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        FORMULIR.setForeground(new java.awt.Color(255, 255, 255));
        FORMULIR.setText("FORMULIR");

        PENDAFTARAN.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        PENDAFTARAN.setForeground(new java.awt.Color(255, 255, 255));
        PENDAFTARAN.setText("PENDAFTARAN");

        PARTNER.setFont(new java.awt.Font("Eras Bold ITC", 1, 24)); // NOI18N
        PARTNER.setForeground(new java.awt.Color(255, 255, 255));
        PARTNER.setText("PT/OWN JB DONZ");

        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/qnjqwt-01.png"))); // NOI18N
        logo.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PENDAFTARAN)
                    .addComponent(FORMULIR)
                    .addComponent(PARTNER))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(FORMULIR)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PENDAFTARAN, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PARTNER)))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        BGIDENTITAS.setBackground(new java.awt.Color(227, 113, 61));

        IDENTITASDIRI.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        IDENTITASDIRI.setForeground(new java.awt.Color(255, 255, 255));
        IDENTITASDIRI.setText("IDENTITAS DIRI");

        javax.swing.GroupLayout BGIDENTITASLayout = new javax.swing.GroupLayout(BGIDENTITAS);
        BGIDENTITAS.setLayout(BGIDENTITASLayout);
        BGIDENTITASLayout.setHorizontalGroup(
            BGIDENTITASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGIDENTITASLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(IDENTITASDIRI)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BGIDENTITASLayout.setVerticalGroup(
            BGIDENTITASLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGIDENTITASLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(IDENTITASDIRI)
                .addContainerGap())
        );

        NAMA.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        NAMA.setText("NAMA                          :");

        TTL.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        TTL.setText("TMPT & TGL LAHIR    :");

        ASALKOTA.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        ASALKOTA.setText("ASAL KOTA                 :");

        JENISKELAMIN.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        JENISKELAMIN.setText("JENIS KELAMIN          :");

        NOTLP.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        NOTLP.setText("NO TLP                        :");

        ALASAN.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        ALASAN.setText("ALALAN INGIN JOIN :");

        ISINAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISINAMAActionPerformed(evt);
            }
        });

        ISITTL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISITTLActionPerformed(evt);
            }
        });

        ISIKOTA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISIKOTAActionPerformed(evt);
            }
        });

        ISITELP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISITELPActionPerformed(evt);
            }
        });

        ISIALASAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISIALASANActionPerformed(evt);
            }
        });

        buttonGroup1DIRI.add(PRIA);
        PRIA.setText("PRIA");
        PRIA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PRIAActionPerformed(evt);
            }
        });

        buttonGroup1DIRI.add(WANITA);
        WANITA.setText("WANITA");
        WANITA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WANITAActionPerformed(evt);
            }
        });

        BGKETENTUAN.setBackground(new java.awt.Color(227, 113, 61));

        KETENTUAN.setFont(new java.awt.Font("Eras Bold ITC", 1, 12)); // NOI18N
        KETENTUAN.setForeground(new java.awt.Color(255, 255, 255));
        KETENTUAN.setText("SYARAT DAN KETENTUAN");

        javax.swing.GroupLayout BGKETENTUANLayout = new javax.swing.GroupLayout(BGKETENTUAN);
        BGKETENTUAN.setLayout(BGKETENTUANLayout);
        BGKETENTUANLayout.setHorizontalGroup(
            BGKETENTUANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BGKETENTUANLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(KETENTUAN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        BGKETENTUANLayout.setVerticalGroup(
            BGKETENTUANLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, BGKETENTUANLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(KETENTUAN)
                .addContainerGap())
        );

        AMANAH.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        AMANAH.setText("BERSEDIA AMANAH :");

        PPDANBIO.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        PPDANBIO.setText("PASANG PP & BIO     :");

        PAKET.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        PAKET.setText("PILIH PAKET               :");

        JENISKELAMINORTU.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        JENISKELAMINORTU.setText("SETUJU                        :");

        NOREF.setFont(new java.awt.Font("Eras Demi ITC", 0, 12)); // NOI18N
        NOREF.setText("NO REFF JIKA OUT   :");

        ISIAMANAH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISIAMANAHActionPerformed(evt);
            }
        });

        ISIPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ISIPPActionPerformed(evt);
            }
        });

        buttonGroup1SETUJU.add(IYA);
        IYA.setText("IYA");
        IYA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IYAActionPerformed(evt);
            }
        });

        buttonGroup1SETUJU.add(TIDAK);
        TIDAK.setText("TIDAK");
        TIDAK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TIDAKActionPerformed(evt);
            }
        });

        cek.setFont(new java.awt.Font("Eras Medium ITC", 0, 12)); // NOI18N
        cek.setText("Data Yang Saya Masukkan Benar");

        batal.setText("Batal");
        batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                batalActionPerformed(evt);
            }
        });

        reset.setText("Reset");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        simpan.setText("Simpan");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        ISIPAKET.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "PILIH PAKET:", "OWN", "PARTNER", "RESELLER PANEL", "RESELLER DIAMOND", " " }));

        jPanel2.setBackground(new java.awt.Color(54, 85, 98));

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("@DONZZ STORE");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(183, 183, 183)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 8)); // NOI18N

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(backgroundLayout.createSequentialGroup()
                        .addComponent(cek, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(BGIDENTITAS, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(NOTLP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ALASAN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JENISKELAMIN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NAMA)
                                .addComponent(TTL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ASALKOTA, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ISITTL)
                                .addComponent(ISINAMA)
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addComponent(PRIA, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(WANITA, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 93, Short.MAX_VALUE))
                                .addComponent(ISIKOTA)
                                .addComponent(ISITELP)
                                .addComponent(ISIALASAN)))
                        .addComponent(BGKETENTUAN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(PPDANBIO)
                                .addComponent(AMANAH))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ISIAMANAH)
                                .addComponent(ISIPP)))
                        .addGroup(backgroundLayout.createSequentialGroup()
                            .addComponent(batal)
                            .addGap(105, 105, 105)
                            .addComponent(reset)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(simpan))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backgroundLayout.createSequentialGroup()
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(NOREF, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PAKET, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(JENISKELAMINORTU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addComponent(ISIPAKET, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backgroundLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(ISINOREF))
                                .addGroup(backgroundLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(IYA, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(TIDAK, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(27, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BGIDENTITAS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NAMA)
                    .addComponent(ISINAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TTL)
                    .addComponent(ISITTL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ASALKOTA)
                    .addComponent(ISIKOTA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JENISKELAMIN)
                    .addComponent(PRIA)
                    .addComponent(WANITA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOTLP)
                    .addComponent(ISITELP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ALASAN)
                    .addComponent(ISIALASAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(BGKETENTUAN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AMANAH)
                    .addComponent(ISIAMANAH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PPDANBIO)
                    .addComponent(ISIPP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PAKET)
                    .addComponent(ISIPAKET, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NOREF)
                    .addComponent(ISINOREF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JENISKELAMINORTU)
                    .addComponent(IYA)
                    .addComponent(TIDAK))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cek, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reset, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(batal)
                        .addComponent(simpan)))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(230, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ISINAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISINAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISINAMAActionPerformed

    private void ISITTLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISITTLActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISITTLActionPerformed

    private void ISIKOTAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISIKOTAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISIKOTAActionPerformed

    private void ISITELPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISITELPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISITELPActionPerformed

    private void ISIALASANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISIALASANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISIALASANActionPerformed

    private void PRIAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PRIAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PRIAActionPerformed

    private void WANITAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WANITAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WANITAActionPerformed

    private void ISIAMANAHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISIAMANAHActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISIAMANAHActionPerformed

    private void ISIPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ISIPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ISIPPActionPerformed

    private void IYAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IYAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IYAActionPerformed

    private void TIDAKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TIDAKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TIDAKActionPerformed

    private void batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalActionPerformed
        // TODO add your handling code here:
        dispose ();
    }//GEN-LAST:event_batalActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here:
        ISINAMA.setText("");
        ISITTL.setText("");
        ISIKOTA.setText("");
        ISITELP.setText("");
        ISIALASAN.setText("");
        ISIAMANAH.setText("");
        ISIPP.setText("");
        ISINOREF.setText("");
        buttonGroup1DIRI.clearSelection();
        buttonGroup1SETUJU.clearSelection();
        ISIPAKET.setSelectedItem("PILIH PAKET:");
        JOptionPane.showMessageDialog(this,"Anda Telah Meriset","COBA LAGI",JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_resetActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        if(cek.isSelected()){
            HAL2 hal2 = new HAL2();
            hal2.ISINAMA.setText(ISINAMA.getText());
            hal2.ISITTL.setText(ISITTL.getText());   
            hal2.ISIKOTA.setText(ISIKOTA.getText());
            hal2.ISITELP.setText(ISITELP.getText());
            hal2.ISIALASAN.setText(ISIALASAN.getText());
            hal2.ISIAMANAH.setText(ISIAMANAH.getText());
            hal2.ISIPP.setText(ISIPP.getText());
            hal2.ISINOREF.setText(ISINOREF.getText());
            if(PRIA.isSelected()==true){
                hal2.kelamin.setText("Laki");
            }else if(WANITA.isSelected()==true){
                hal2.kelamin.setText("Wanita");
            }
            
            if(IYA.isSelected()==true){
                hal2.setuju.setText("Iya");
            }else if(TIDAK.isSelected()==true){
                hal2.setuju.setText("Tidak");
            }
            String PILIH = (String)ISIPAKET.getSelectedItem().toString();
            hal2.paket.setText(PILIH);

            hal2.setVisible(true);

            }
        else{
            JOptionPane.showMessageDialog(this,"Klik Centang Agar Bisa Melanjutkan","COBA LAGI",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_simpanActionPerformed

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
            java.util.logging.Logger.getLogger(BG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BG.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BG().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ALASAN;
    private javax.swing.JLabel AMANAH;
    private javax.swing.JLabel ASALKOTA;
    private javax.swing.JPanel BGIDENTITAS;
    private javax.swing.JPanel BGKETENTUAN;
    private javax.swing.JLabel FORMULIR;
    private javax.swing.JLabel IDENTITASDIRI;
    public javax.swing.JTextField ISIALASAN;
    public javax.swing.JTextField ISIAMANAH;
    public javax.swing.JTextField ISIKOTA;
    public javax.swing.JTextField ISINAMA;
    public javax.swing.JTextField ISINOREF;
    public javax.swing.JComboBox<String> ISIPAKET;
    public javax.swing.JTextField ISIPP;
    public javax.swing.JTextField ISITELP;
    public javax.swing.JTextField ISITTL;
    public javax.swing.JRadioButton IYA;
    private javax.swing.JLabel JENISKELAMIN;
    private javax.swing.JLabel JENISKELAMINORTU;
    private javax.swing.JLabel KETENTUAN;
    private javax.swing.JLabel NAMA;
    private javax.swing.JLabel NOREF;
    private javax.swing.JLabel NOTLP;
    private javax.swing.JLabel PAKET;
    private javax.swing.JLabel PARTNER;
    private javax.swing.JLabel PENDAFTARAN;
    private javax.swing.JLabel PPDANBIO;
    public javax.swing.JRadioButton PRIA;
    public javax.swing.JRadioButton TIDAK;
    private javax.swing.JLabel TTL;
    public javax.swing.JRadioButton WANITA;
    private javax.swing.JPanel background;
    private javax.swing.JButton batal;
    private javax.swing.ButtonGroup buttonGroup1DIRI;
    private javax.swing.ButtonGroup buttonGroup1SETUJU;
    private javax.swing.JCheckBox cek;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel logo;
    private javax.swing.JButton reset;
    private javax.swing.JButton simpan;
    // End of variables declaration//GEN-END:variables
}
