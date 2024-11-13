# Meminta ukuran dari pengguna
size = int(input("Masukkan ukuran: "))

# Cetak angka 0
for row in range(size):
    if row == 0 or row == size - 1:  # Garis atas dan bawah untuk 0
        print('x' * size)
    else:  # Bagian tengah angka 0
        print('x' + ' ' * (size - 2) + 'x')

# Baris kosong sebagai pemisah antara angka
print()

# Cetak angka 7
for row in range(size):
    if row == 0:  # Garis atas untuk 7
        print('x' * size)
    else:  # Bagian diagonal untuk 7
        print(' ' * (size - row - 1) + 'x')

# Baris kosong sebagai pemisah antara angka
print()

# Cetak angka 1
for row in range(size):
    print(' ' * (size - 1) + 'x')
