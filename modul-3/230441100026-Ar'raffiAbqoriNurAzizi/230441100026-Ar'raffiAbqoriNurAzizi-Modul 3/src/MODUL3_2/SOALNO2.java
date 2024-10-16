package MODUL3_2;

import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SOALNO2 extends javax.swing.JFrame {
    boolean[] statusPembayaranBulan = new boolean[12];
    private String namaSiswa = "";
    private String nisnSiswa = "";
    
    @SuppressWarnings("unchecked")
    
    public SOALNO2() {      
        initComponents();
        JTPEMBAYARAN.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                penghitungan();
            }
        });
    }
    
    private void penghitungan() {
        try {
            double pembayaran = Double.parseDouble(JTBAYARSPP.getText()); 
            double uangmasuk = Double.parseDouble(JTPEMBAYARAN.getText()); 
            double kembalian = uangmasuk - pembayaran;

            if (kembalian >= 0) {
                JTKEMBALIAN.setText(String.valueOf("Rp. " + kembalian)); 
            } else {
                JTKEMBALIAN.setText("Uang Tidak Cukup"); 
            }        
        } catch (NumberFormatException e) {
            JTKEMBALIAN.setText(""); 
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        atas = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bawah = new javax.swing.JPanel();
        kanan = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        januari = new javax.swing.JCheckBox();
        februari = new javax.swing.JCheckBox();
        maret = new javax.swing.JCheckBox();
        april = new javax.swing.JCheckBox();
        mei = new javax.swing.JCheckBox();
        juni = new javax.swing.JCheckBox();
        juli = new javax.swing.JCheckBox();
        agustus = new javax.swing.JCheckBox();
        september = new javax.swing.JCheckBox();
        oktober = new javax.swing.JCheckBox();
        november = new javax.swing.JCheckBox();
        desember = new javax.swing.JCheckBox();
        JLabelBulan = new javax.swing.JLabel();
        KELUAR = new javax.swing.JButton();
        reset = new javax.swing.JButton();
        kiri = new javax.swing.JPanel();
        tengah = new javax.swing.JPanel();
        tombolTab = new javax.swing.JPanel();
        ButtonPembayaran = new javax.swing.JButton();
        ButtonRiwayat = new javax.swing.JButton();
        panel = new javax.swing.JPanel();
        JPpembayaran = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JTNAMA = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        JTNIM = new javax.swing.JTextField();
        JTBAYARSPP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        JTStatus = new javax.swing.JTextField();
        JLabelBulan1 = new javax.swing.JLabel();
        JLabelBulan2 = new javax.swing.JLabel();
        CEK = new javax.swing.JButton();
        JTKEMBALIAN = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        JTPEMBAYARAN = new javax.swing.JTextField();
        BAYAR = new javax.swing.JButton();
        JPriwayat = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTabel = new javax.swing.JTable();
        btnStatus = new javax.swing.JButton();
        cekRiwayat = new javax.swing.JButton();

        setAutoRequestFocus(false);
        setPreferredSize(new java.awt.Dimension(900, 650));
        setResizable(false);
        setSize(new java.awt.Dimension(900, 700));

        atas.setBackground(new java.awt.Color(255, 255, 255));
        atas.setMinimumSize(new java.awt.Dimension(900, 130));
        atas.setPreferredSize(new java.awt.Dimension(900, 130));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/2.png"))); // NOI18N
        jLabel3.setText("jLabel3");
        jLabel3.setMinimumSize(new java.awt.Dimension(70, 10));
        jLabel3.setPreferredSize(new java.awt.Dimension(1000, 90));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MODUL3_1/1.png"))); // NOI18N
        jLabel4.setText("jLabel4");
        jLabel4.setMinimumSize(new java.awt.Dimension(80, 16));

        javax.swing.GroupLayout atasLayout = new javax.swing.GroupLayout(atas);
        atas.setLayout(atasLayout);
        atasLayout.setHorizontalGroup(
            atasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atasLayout.createSequentialGroup()
                .addGroup(atasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 901, Short.MAX_VALUE))
                .addGap(141, 141, 141))
        );
        atasLayout.setVerticalGroup(
            atasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(atasLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        bawah.setBackground(new java.awt.Color(204, 204, 204));
        bawah.setPreferredSize(new java.awt.Dimension(900, 40));

        javax.swing.GroupLayout bawahLayout = new javax.swing.GroupLayout(bawah);
        bawah.setLayout(bawahLayout);
        bawahLayout.setHorizontalGroup(
            bawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        bawahLayout.setVerticalGroup(
            bawahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        kanan.setBackground(new java.awt.Color(204, 204, 204));
        kanan.setPreferredSize(new java.awt.Dimension(300, 400));
        kanan.setRequestFocusEnabled(false);

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 470));

        januari.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        januari.setText("Januari");
        januari.setIconTextGap(10);
        januari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                januariActionPerformed(evt);
            }
        });

        februari.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        februari.setText("Februari");
        februari.setIconTextGap(10);
        februari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                februariActionPerformed(evt);
            }
        });

        maret.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        maret.setText("Maret");
        maret.setIconTextGap(10);
        maret.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                maretActionPerformed(evt);
            }
        });

        april.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        april.setText("April");
        april.setIconTextGap(10);
        april.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aprilActionPerformed(evt);
            }
        });

        mei.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        mei.setText("Mei");
        mei.setIconTextGap(10);
        mei.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                meiActionPerformed(evt);
            }
        });

        juni.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        juni.setText("Juni");
        juni.setIconTextGap(10);
        juni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juniActionPerformed(evt);
            }
        });

        juli.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        juli.setText("Juli");
        juli.setIconTextGap(10);
        juli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                juliActionPerformed(evt);
            }
        });

        agustus.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        agustus.setText("Agustus");
        agustus.setIconTextGap(10);
        agustus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agustusActionPerformed(evt);
            }
        });

        september.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        september.setText("September");
        september.setIconTextGap(10);
        september.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                septemberActionPerformed(evt);
            }
        });

        oktober.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        oktober.setText("Oktober");
        oktober.setIconTextGap(10);
        oktober.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                oktoberActionPerformed(evt);
            }
        });

        november.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        november.setText("November");
        november.setIconTextGap(10);
        november.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                novemberActionPerformed(evt);
            }
        });

        desember.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        desember.setText("Desember");
        desember.setIconTextGap(10);
        desember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                desemberActionPerformed(evt);
            }
        });

        JLabelBulan.setBackground(new java.awt.Color(0, 0, 0));
        JLabelBulan.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        JLabelBulan.setForeground(new java.awt.Color(45, 71, 127));
        JLabelBulan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelBulan.setText("PIIHAN BULAN !!!");

        KELUAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        KELUAR.setText("KELUAR");
        KELUAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KELUARActionPerformed(evt);
            }
        });

        reset.setBackground(new java.awt.Color(255, 151, 0));
        reset.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        reset.setForeground(new java.awt.Color(255, 255, 255));
        reset.setText("RESET");
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                        .addContainerGap(7, Short.MAX_VALUE)
                        .addComponent(KELUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JLabelBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(januari, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(maret, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(september, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(november, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(mei, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(juli, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(februari, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(april, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oktober, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(desember, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(agustus, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(juni, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(reset, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabelBulan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(januari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(februari, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(maret, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(april, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mei, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(juni, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(juli, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(agustus, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(september, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(oktober, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(november, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(desember, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(reset, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KELUAR, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout kananLayout = new javax.swing.GroupLayout(kanan);
        kanan.setLayout(kananLayout);
        kananLayout.setHorizontalGroup(
            kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(kananLayout.createSequentialGroup()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );
        kananLayout.setVerticalGroup(
            kananLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE)
        );

        kiri.setBackground(new java.awt.Color(204, 204, 204));
        kiri.setPreferredSize(new java.awt.Dimension(70, 400));

        javax.swing.GroupLayout kiriLayout = new javax.swing.GroupLayout(kiri);
        kiri.setLayout(kiriLayout);
        kiriLayout.setHorizontalGroup(
            kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        kiriLayout.setVerticalGroup(
            kiriLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 448, Short.MAX_VALUE)
        );

        tengah.setBackground(new java.awt.Color(255, 255, 255));
        tengah.setPreferredSize(new java.awt.Dimension(580, 380));

        tombolTab.setLayout(new java.awt.GridLayout(1, 0));

        ButtonPembayaran.setBackground(new java.awt.Color(102, 255, 0));
        ButtonPembayaran.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        ButtonPembayaran.setText("PEMBAYARAN");
        ButtonPembayaran.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonPembayaranActionPerformed(evt);
            }
        });
        tombolTab.add(ButtonPembayaran);

        ButtonRiwayat.setBackground(new java.awt.Color(102, 255, 0));
        ButtonRiwayat.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        ButtonRiwayat.setText("RIWAYAT");
        ButtonRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonRiwayatActionPerformed(evt);
            }
        });
        tombolTab.add(ButtonRiwayat);

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panel.setLayout(new java.awt.CardLayout());

        JPpembayaran.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Nama     :");

        JTNAMA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTNAMA.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTNAMA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTNAMAActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("NIM        :");

        JTNIM.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTNIM.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        JTBAYARSPP.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTBAYARSPP.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTBAYARSPP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTBAYARSPPActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("Tagihan SPP / Bulan :");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Status Pembayaran  :");

        JTStatus.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTStatus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTStatusActionPerformed(evt);
            }
        });

        JLabelBulan1.setBackground(new java.awt.Color(0, 0, 0));
        JLabelBulan1.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        JLabelBulan1.setForeground(new java.awt.Color(45, 71, 127));
        JLabelBulan1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelBulan1.setText("Pembayaran SPP !!!");

        JLabelBulan2.setBackground(new java.awt.Color(0, 0, 0));
        JLabelBulan2.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 14)); // NOI18N
        JLabelBulan2.setForeground(new java.awt.Color(45, 71, 127));
        JLabelBulan2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLabelBulan2.setText("Masukkan Data Diri Anda !!!");

        CEK.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        CEK.setText("CEK");
        CEK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CEKActionPerformed(evt);
            }
        });

        JTKEMBALIAN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTKEMBALIAN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTKEMBALIAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTKEMBALIANActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("kembalian Uang        :");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("Masukkan Uang        :");

        JTPEMBAYARAN.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        JTPEMBAYARAN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        JTPEMBAYARAN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTPEMBAYARANActionPerformed(evt);
            }
        });

        BAYAR.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        BAYAR.setText("BAYAR");
        BAYAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BAYARActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPpembayaranLayout = new javax.swing.GroupLayout(JPpembayaran);
        JPpembayaran.setLayout(JPpembayaranLayout);
        JPpembayaranLayout.setHorizontalGroup(
            JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPpembayaranLayout.createSequentialGroup()
                .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JTNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(JPpembayaranLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(JPpembayaranLayout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(JTNIM))
                                .addComponent(JLabelBulan1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(JPpembayaranLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(JLabelBulan2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(JPpembayaranLayout.createSequentialGroup()
                            .addGap(15, 15, 15)
                            .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(CEK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                .addComponent(JTBAYARSPP)
                                .addComponent(JTStatus)))
                        .addGroup(JPpembayaranLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel6))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, JPpembayaranLayout.createSequentialGroup()
                            .addGap(11, 11, 11)
                            .addComponent(jLabel8)
                            .addGap(10, 10, 10)
                            .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(BAYAR, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
                                .addComponent(JTKEMBALIAN, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(JTPEMBAYARAN, javax.swing.GroupLayout.Alignment.TRAILING)))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        JPpembayaranLayout.setVerticalGroup(
            JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPpembayaranLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLabelBulan2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JLabelBulan1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTBAYARSPP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CEK, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTPEMBAYARAN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPpembayaranLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTKEMBALIAN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BAYAR, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );

        panel.add(JPpembayaran, "card2");
        JPpembayaran.getAccessibleContext().setAccessibleName("card2");

        JPriwayat.setBackground(new java.awt.Color(51, 255, 153));

        JTabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Bulan", "Status"
            }
        ));
        jScrollPane1.setViewportView(JTabel);

        btnStatus.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        btnStatus.setText("Cek Status");
        btnStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStatusActionPerformed(evt);
            }
        });

        cekRiwayat.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        cekRiwayat.setText("Cek Riwayat");
        cekRiwayat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cekRiwayatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout JPriwayatLayout = new javax.swing.GroupLayout(JPriwayat);
        JPriwayat.setLayout(JPriwayatLayout);
        JPriwayatLayout.setHorizontalGroup(
            JPriwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPriwayatLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPriwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(JPriwayatLayout.createSequentialGroup()
                        .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                        .addComponent(cekRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        JPriwayatLayout.setVerticalGroup(
            JPriwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPriwayatLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(JPriwayatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cekRiwayat, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        panel.add(JPriwayat, "card3");
        JPriwayat.getAccessibleContext().setAccessibleName("card3");

        javax.swing.GroupLayout tengahLayout = new javax.swing.GroupLayout(tengah);
        tengah.setLayout(tengahLayout);
        tengahLayout.setHorizontalGroup(
            tengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tombolTab, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(panel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        tengahLayout.setVerticalGroup(
            tengahLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tengahLayout.createSequentialGroup()
                .addComponent(tombolTab, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        panel.getAccessibleContext().setAccessibleName("panel");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(atas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(kiri, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(tengah, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(kanan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(bawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(atas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kiri, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tengah, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kanan, javax.swing.GroupLayout.PREFERRED_SIZE, 448, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addComponent(bawah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void januariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_januariActionPerformed

//        bulan = 100000;
    }//GEN-LAST:event_januariActionPerformed

    private void februariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_februariActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_februariActionPerformed

    private void aprilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aprilActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_aprilActionPerformed

    private void meiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_meiActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_meiActionPerformed

    private void juniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juniActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_juniActionPerformed

    private void novemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_novemberActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_novemberActionPerformed

    private void ButtonPembayaranActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonPembayaranActionPerformed
        // TODO add your handling code here:
        CardLayout c2 = (CardLayout) (panel.getLayout());
        c2.show(panel, "card2");
    }//GEN-LAST:event_ButtonPembayaranActionPerformed

    private void JTBAYARSPPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTBAYARSPPActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTBAYARSPPActionPerformed

    private void JTStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTStatusActionPerformed

    private void KELUARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KELUARActionPerformed
        // TODO add your handling code here:
        int pilihan = JOptionPane.showConfirmDialog(null, "Apakah Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION);
    
        if (pilihan == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_KELUARActionPerformed

    private void CEKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CEKActionPerformed
        // TODO add your handling code here:
        boolean lunasSemua = true;

        // Mengecek status pembayaran per bulan
        if (!januari.isSelected() || !februari.isSelected() ||
            !maret.isSelected() || !april.isSelected() ||
            !mei.isSelected() || !juni.isSelected() ||
            !juli.isSelected() || !agustus.isSelected() ||
            !september.isSelected() || !oktober.isSelected() ||
            !november.isSelected() || !desember.isSelected()) {
            
            lunasSemua = false;
        }

        // Menampilkan hasil pada text field
        if (lunasSemua) {
            JTStatus.setText("Lunas");
        } else {
            JTStatus.setText("Menunggak");
        }
        
        String nama = JTNAMA.getText();
        String nisn = JTNIM.getText();

        if (nama.isEmpty() || nisn.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap mengisi semua data siswa!");
        } else {
            namaSiswa = nama;
            nisnSiswa = nisn;

            JTNAMA.getText();
            JTNIM.getText();

            JOptionPane.showMessageDialog(null, "Data siswa berhasil dikirim!");
        }
        
        
        if (namaSiswa.isEmpty() || nisnSiswa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Harap mengisi data siswa terlebih dahulu!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }

       
        if (statusPembayaranBulan[0]) {
            januari.setEnabled(false);
            januari.setSelected(false); 
        }
        if (statusPembayaranBulan[1]) {
            februari.setEnabled(false);
            februari.setSelected(false);
        }
        if (statusPembayaranBulan[2]) {
            maret.setEnabled(false);
            maret.setSelected(false);
        }
        if (statusPembayaranBulan[3]) {
            april.setEnabled(false);
            april.setSelected(false);
        }
        if (statusPembayaranBulan[4]) {
            mei.setEnabled(false);
            mei.setSelected(false);
        }
        if (statusPembayaranBulan[5]) {
            juni.setEnabled(false);
            juni.setSelected(false);
        }
        if (statusPembayaranBulan[6]) {
            juli.setEnabled(false);
            juli.setSelected(false);
        }
        if (statusPembayaranBulan[7]) {
            agustus.setEnabled(false);
            agustus.setSelected(false);
        }
        if (statusPembayaranBulan[8]) {
            september.setEnabled(false);
            september.setSelected(false);
        }
        if (statusPembayaranBulan[9]) {
            oktober.setEnabled(false);
            oktober.setSelected(false);
        }
        if (statusPembayaranBulan[10]) {
            november.setEnabled(false);
            november.setSelected(false);
        }
        if (statusPembayaranBulan[11]) {
            desember.setEnabled(false);
            desember.setSelected(false);
        }

        try {
            double sppPerBulan = 100000; 
            int jumlahBulanDipilih = 0;

            if (januari.isSelected() && !statusPembayaranBulan[0]) jumlahBulanDipilih++;
            if (februari.isSelected() && !statusPembayaranBulan[1]) jumlahBulanDipilih++;
            if (maret.isSelected() && !statusPembayaranBulan[2]) jumlahBulanDipilih++;
            if (april.isSelected() && !statusPembayaranBulan[3]) jumlahBulanDipilih++;
            if (mei.isSelected() && !statusPembayaranBulan[4]) jumlahBulanDipilih++;
            if (juni.isSelected() && !statusPembayaranBulan[5]) jumlahBulanDipilih++;
            if (juli.isSelected() && !statusPembayaranBulan[6]) jumlahBulanDipilih++;
            if (agustus.isSelected() && !statusPembayaranBulan[7]) jumlahBulanDipilih++;
            if (september.isSelected() && !statusPembayaranBulan[8]) jumlahBulanDipilih++;
            if (oktober.isSelected() && !statusPembayaranBulan[9]) jumlahBulanDipilih++;
            if (november.isSelected() && !statusPembayaranBulan[10]) jumlahBulanDipilih++;
            if (desember.isSelected() && !statusPembayaranBulan[11]) jumlahBulanDipilih++;

            double totalPembayaran = jumlahBulanDipilih * sppPerBulan;
            JTBAYARSPP.setText(String.valueOf(totalPembayaran));

            String uangDibayarText = JTPEMBAYARAN.getText().trim();
            if (uangDibayarText.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Harap masukkan jumlah uang yang dibayar!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                return;
            }

            double uangDibayar = Double.parseDouble(uangDibayarText);

            penghitungan();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Masukkan jumlah uang yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
        }                                      
         
        
    }                                        

    private void btnstatusActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
        updateStatusPembayaranTabel();
    }
    
    
    private void updateStatusPembayaranTabel() {
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        DefaultTableModel model = (DefaultTableModel) JTabel.getModel();
        model.setRowCount(0);  

        boolean lunasSemua = true;  
        for (int i = 0; i < statusPembayaranBulan.length; i++) {
            String status = statusPembayaranBulan[i] ? "Lunas" : "Belum dibayar";
            model.addRow(new Object[]{bulan[i], status});

            if (!statusPembayaranBulan[i]) {
                lunasSemua = false;
            }
        }

        if (lunasSemua) {
            JOptionPane.showMessageDialog(null, "Pembayaran sudah lunas untuk semua bulan.", "Status Pembayaran", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Pembayaran belum lunas. Silakan cek bulan yang belum dibayar.", "Status Pembayaran", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_CEKActionPerformed

    private void JTKEMBALIANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTKEMBALIANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTKEMBALIANActionPerformed

    private void JTPEMBAYARANActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTPEMBAYARANActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTPEMBAYARANActionPerformed

    private void BAYARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BAYARActionPerformed
        // TODO add your handling code here:
        double totalPembayaran = Double.parseDouble(JTBAYARSPP.getText());
        double uangDibayar = Double.parseDouble(JTPEMBAYARAN.getText());
        if (uangDibayar < totalPembayaran) {
            JOptionPane.showMessageDialog(null, "Pembayaran kurang!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (januari.isSelected()) statusPembayaranBulan[0] = true;
        if (februari.isSelected()) statusPembayaranBulan[1] = true;
        if (maret.isSelected()) statusPembayaranBulan[2] = true;
        if (april.isSelected()) statusPembayaranBulan[3] = true;
        if (mei.isSelected()) statusPembayaranBulan[4] = true;
        if (juni.isSelected()) statusPembayaranBulan[5] = true;
        if (juli.isSelected()) statusPembayaranBulan[6] = true;
        if (agustus.isSelected()) statusPembayaranBulan[7] = true;
        if (september.isSelected()) statusPembayaranBulan[8] = true;
        if (oktober.isSelected()) statusPembayaranBulan[9] = true;
        if (november.isSelected()) statusPembayaranBulan[10] = true;
        if (desember.isSelected()) statusPembayaranBulan[11] = true;

        // Kosongkan semua field setelah data terkirim
        JTPEMBAYARAN.setText("");
        JTKEMBALIAN.setText("");
        JTBAYARSPP.setText("");
        januari.setSelected(false);
        februari.setSelected(false);
        maret.setSelected(false);
        april.setSelected(false);
        mei.setSelected(false);
        juni.setSelected(false);
        juli.setSelected(false);
        agustus.setSelected(false);
        september.setSelected(false);
        oktober.setSelected(false);
        november.setSelected(false);
        desember.setSelected(false);

        JOptionPane.showMessageDialog(null, "Pembayaran berhasil dan data telah disimpan.");
    }//GEN-LAST:event_BAYARActionPerformed

    private void ButtonRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonRiwayatActionPerformed
        // TODO add your handling code here:
        CardLayout c2 = (CardLayout) (panel.getLayout());
        c2.show(panel, "card3");
    }//GEN-LAST:event_ButtonRiwayatActionPerformed

    private void maretActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_maretActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_maretActionPerformed

    private void juliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_juliActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_juliActionPerformed

    private void agustusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agustusActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_agustusActionPerformed

    private void septemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_septemberActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_septemberActionPerformed

    private void oktoberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_oktoberActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_oktoberActionPerformed

    private void desemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_desemberActionPerformed
        // TODO add your handling code here:
//        bulan = 100000;
    }//GEN-LAST:event_desemberActionPerformed

    private void btnStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStatusActionPerformed
        // TODO add your handling code here:
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        DefaultTableModel model = (DefaultTableModel) JTabel.getModel();
        model.setRowCount(0);  

        boolean lunasSemua = true;  
        for (int i = 0; i < statusPembayaranBulan.length; i++) {
            String status = statusPembayaranBulan[i] ? "Lunas" : "Belum dibayar";
            model.addRow(new Object[]{bulan[i], status});

            if (!statusPembayaranBulan[i]) {
                lunasSemua = false;
            }
        }

        if (lunasSemua) {
            JOptionPane.showMessageDialog(null, "Pembayaran sudah lunas untuk semua bulan.", "Status Pembayaran", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "Pembayaran belum lunas. Silakan cek bulan yang belum dibayar.", "Status Pembayaran", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnStatusActionPerformed
  
    
    private void cekRiwayatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cekRiwayatActionPerformed
        // TODO add your handling code here:
        if (namaSiswa.isEmpty() || nisnSiswa.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Belum ada data siswa yang diinputkan!", "Peringatan", JOptionPane.WARNING_MESSAGE);
            return;
        }
    
        StringBuilder riwayat = new StringBuilder();
        String[] bulan = {"Januari", "Februari", "Maret", "April", "Mei", "Juni", 
                          "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        riwayat.append("Nama: ").append(namaSiswa).append("\n");
        riwayat.append("NIM: ").append(nisnSiswa).append("\n\n");

        boolean adaPembayaran = false;
        for (int i = 0; i < statusPembayaranBulan.length; i++) {
            if (statusPembayaranBulan[i]) {
                riwayat.append(bulan[i]).append(" sudah dibayar\n");
                adaPembayaran = true;
            }
        }
        if (!adaPembayaran) {
            riwayat.append("Belum ada pembayaran yang dilakukan.");
        }

        JOptionPane.showMessageDialog(null, riwayat.toString(), "Riwayat Pembayaran", JOptionPane.INFORMATION_MESSAGE);
        
    }//GEN-LAST:event_cekRiwayatActionPerformed

    private void JTNAMAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTNAMAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTNAMAActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        // TODO add your handling code here
        januari.setSelected(false);
        februari.setSelected(false);
        maret.setSelected(false);
        april.setSelected(false);
        mei.setSelected(false);
        juni.setSelected(false);
        juli.setSelected(false);
        agustus.setSelected(false);
        september.setSelected(false);
        oktober.setSelected(false);
        november.setSelected(false);
        desember.setSelected(false);

        JTBAYARSPP.setText("");
        JTPEMBAYARAN.setText("");

        JOptionPane.showMessageDialog(null, "Pilihan pembayaran telah dibatalkan.", "Pembatalan", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_resetActionPerformed


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
            java.util.logging.Logger.getLogger(SOALNO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SOALNO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SOALNO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SOALNO2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SOALNO2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BAYAR;
    private javax.swing.JButton ButtonPembayaran;
    private javax.swing.JButton ButtonRiwayat;
    private javax.swing.JButton CEK;
    private javax.swing.JLabel JLabelBulan;
    private javax.swing.JLabel JLabelBulan1;
    private javax.swing.JLabel JLabelBulan2;
    private javax.swing.JPanel JPpembayaran;
    private javax.swing.JPanel JPriwayat;
    private javax.swing.JTextField JTBAYARSPP;
    private javax.swing.JTextField JTKEMBALIAN;
    private javax.swing.JTextField JTNAMA;
    private javax.swing.JTextField JTNIM;
    private javax.swing.JTextField JTPEMBAYARAN;
    private javax.swing.JTextField JTStatus;
    private javax.swing.JTable JTabel;
    private javax.swing.JButton KELUAR;
    private javax.swing.JCheckBox agustus;
    private javax.swing.JCheckBox april;
    private javax.swing.JPanel atas;
    private javax.swing.JPanel bawah;
    private javax.swing.JButton btnStatus;
    private javax.swing.JButton cekRiwayat;
    private javax.swing.JCheckBox desember;
    private javax.swing.JCheckBox februari;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox januari;
    private javax.swing.JCheckBox juli;
    private javax.swing.JCheckBox juni;
    private javax.swing.JPanel kanan;
    private javax.swing.JPanel kiri;
    private javax.swing.JCheckBox maret;
    private javax.swing.JCheckBox mei;
    private javax.swing.JCheckBox november;
    private javax.swing.JCheckBox oktober;
    private javax.swing.JPanel panel;
    private javax.swing.JButton reset;
    private javax.swing.JCheckBox september;
    private javax.swing.JPanel tengah;
    private javax.swing.JPanel tombolTab;
    // End of variables declaration//GEN-END:variables
}
