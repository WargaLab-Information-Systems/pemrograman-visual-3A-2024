// ---BUTTON TAMBAH---
    private void ButtonTambahActionPerformed(java.awt.event.ActionEvent evt) {                                             

//   agar inputan ttep + walaupun setelah riset 0, 0 e hilang makanya pakai String agar berfungsi
//mengambil dari TextFieldJumlah, menyimpan dlm va text Tambah
        String textTambah = TextFieldJumlah.getText();
        int JumlahOrderan = 0;
//       (dimulai dari 0)
//        periksa apakah TextField tidak kosong, hanya bersisi angka
//
        if(!textTambah.isEmpty() && textTambah.matches("\\d+")){
//        matches untuk ada isiannya
//tidak ada angka ataupun ada angka tetap bertambah  
//  
        JumlahOrderan = Integer.parseInt(textTambah);}

        // tambah jumlah pesanan
        JumlahOrderan++;
//    set nilai baru ke text field
        TextFieldJumlah.setText(String.valueOf(JumlahOrderan));
    }   


// ---BUTTON KURANG---
    private void ButtonKurangActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
//       mengambil nilai dari TextFieldJumlah, jumlah orderan itu disimpan dlm variabel baru
        int JumlahOrderan = Integer.parseInt(TextFieldJumlah.getText());
//       jika Jumlah Orderan > dari 0 maka nilainya akan dikurangi 1* tmbol - di klik
        if(JumlahOrderan > 0){
            JumlahOrderan--;
        }
//        dan langsung menyimpan nilai baru di TextFieldJumlah
        TextFieldJumlah.setText(String.valueOf(JumlahOrderan));
//        
    } 


    // ---BUTTON BATAL----
        private void ButtonBatalActionPerformed(java.awt.event.ActionEvent evt) {                                            

    int response = JOptionPane.showConfirmDialog(null,"Ingin Keluar dari Orderan???", "Peringatan", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
//    int reponse itu variabel 
//kalau pilih YES maka tutup jendela program
//NO tetap di halaman
    if (response == JOptionPane.YES_OPTION){
    //pembatalan
    dispose();
    }
    }


    // ---BUTTON TOTAL---
        private void ButtonTotalActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        int hargaPerMenu = 0;
        double diskon = 0;
        double totalHargaMenu = 0;
        boolean MenuDipilih = false;
        boolean ToppingDipilih = false;
        
//        ---MENU---
        if (RadioButtonBakar.isSelected()){
            hargaPerMenu = 10000;
            MenuDipilih = true;
        }else if (RadioButtonHotLava.isSelected()){
            hargaPerMenu = 10000;
            MenuDipilih = true;
        }else if (RadioButtonNugget.isSelected()){
            hargaPerMenu = 10000;
            MenuDipilih = true;
        }else if (RadioButtonJamur.isSelected()){
            hargaPerMenu = 12000;
            MenuDipilih = true;
        }else if (RadioButtonTongkol.isSelected()){
            hargaPerMenu = 12000;
            MenuDipilih = true;
        }else if (RadioButtonBeef.isSelected()){
            hargaPerMenu = 13000;
            MenuDipilih = true;
        }else if (RadioButtonParu.isSelected()){
            hargaPerMenu = 14000;
            MenuDipilih = true;
        }else if (RadioButtonCumi.isSelected()){
            hargaPerMenu = 15000;
            MenuDipilih = true;
        }
        String JumlahDipilih = TextFieldJumlah.getText();
        if(JumlahDipilih.isEmpty()){
            JOptionPane.showMessageDialog(this,"Masukkan Jumlah Yang Dipilih!!", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
            return;
        } 

        //      ---TOPPING---

        int JumlahPorsi = Integer.parseInt(JumlahDipilih);
//        Hitung total harga sebelum diskon
        totalHargaMenu = hargaPerMenu * JumlahPorsi;
//        menambahkan total harga Topping jika Dipilih
        if(RadioButtonNoTopping.isSelected()){
            ToppingDipilih = true;
        }else if (RadioButtonTelorAsin.isSelected()){
            totalHargaMenu += 3000 * JumlahPorsi;
            ToppingDipilih = true;
        }else if (RadioButtonForKids.isSelected()){
            totalHargaMenu += 1000 * JumlahPorsi;
            ToppingDipilih = true;
        }else if(RadioButtonMatah.isSelected()){
            totalHargaMenu += 2000 * JumlahPorsi;
            ToppingDipilih = true;
        }else if(RadioButtonMentai.isSelected()){
            totalHargaMenu += 2500 * JumlahPorsi;
            ToppingDipilih = true;
    }    
    if(!MenuDipilih){
        JOptionPane.showMessageDialog(this, "Pilih Menu Yang Tersedia!!", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
        return;
       }
    if(!ToppingDipilih){
        JOptionPane.showMessageDialog(this, "Pilih Topping Yang Tersedia!!", "Peringatan", JOptionPane.INFORMATION_MESSAGE);
        return;
    }
//    diskon jika pembelian lebih dari 100.000
    if(totalHargaMenu > 100000){
        diskon = totalHargaMenu * 0.05;
        totalHargaMenu -= diskon;
        JOptionPane.showMessageDialog(this, "Diskon 5% Pembelian telah lebih dari 100000");
        
    }
//    Total Hrga setelah diskon
    TextFieldHargaKeseluruhan.setText(String.valueOf(totalHargaMenu));
    }                                           


    // BUTTON PEMBAYARAN
        private void TextFieldPembayaranActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        
        try{
            
            double hargaKeseluruhan = Double.parseDouble(TextFieldPembayaran.getText());
            double pembayaran = Double.parseDouble(TextFieldPembayaran.getText());
            double diskon = 0;
//            total pembelian lebih dari 100.000?diskon5% 
           
            if(hargaKeseluruhan > 100000){
            diskon = hargaKeseluruhan * 0.05;
            hargaKeseluruhan = hargaKeseluruhan - diskon;
        }
            double SisaUang =  pembayaran - hargaKeseluruhan;
            TextFieldSisaUang.setText(String.valueOf(SisaUang));
//            variabel menyimpan detail menu
            String menuTerpilih = "";
            int jumlah = 0;
            if(RadioButtonBakar.isSelected()){
            menuTerpilih = "Chicken Pop Mozzarella";
        }else if(RadioButtonHotLava.isSelected()){
            menuTerpilih = "Chicken Skin Nori Hot Lava";
        }else if(RadioButtonNugget.isSelected()){
            menuTerpilih = "Nugget Jagung Cheese";
        }else if(RadioButtonJamur.isSelected()){
            menuTerpilih = "Chicken&Jamur Honey Yougurt";
        }else if(RadioButtonTongkol.isSelected()){
            menuTerpilih = "Tongkol Suwir Kemangi";
        }else if(RadioButtonBeef.isSelected()){
            menuTerpilih = "Smoked Beef BlackPaper";
        }else if(RadioButtonParu.isSelected()){
            menuTerpilih = "Paru Sambal Bali";
        }else if(RadioButtonCumi.isSelected()){
            menuTerpilih = "Cumi -  Cumi Barbeque";
        }
        String ToppingTerpilih = "";
        if(RadioButtonTelorAsin.isSelected()){
            ToppingTerpilih += "Saos Telor Asin";
        }else if(RadioButtonForKids.isSelected()){
            ToppingTerpilih += "Saos For Kids";
        }else if(RadioButtonMatah.isSelected()){
            ToppingTerpilih += "Sambal Matah";
        }else if(RadioButtonMentai.isSelected()){
            ToppingTerpilih += "Saos Mentai";
        }
        double uangBayar = pembayaran;
        JOptionPane.showMessageDialog(null, "Berhasil Melakukan Pembayaran\nMenu Yang Dibeli : "+ menuTerpilih + "\nTopping : " + ToppingTerpilih + "\nBayar : Rp. " + pembayaran + "\nSisaUang : Rp. " + SisaUang, "Penambahan menu",JOptionPane.INFORMATION_MESSAGE, iconSukses);
//        pilihan sama seperti if else
        }catch (NumberFormatException e){
        JOptionPane.showMessageDialog(null, "Masukkan jumlah uang!!", "ERROR",JOptionPane.ERROR);
        }
    } 