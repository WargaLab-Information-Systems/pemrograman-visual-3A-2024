-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 22 Nov 2024 pada 15.54
-- Versi server: 10.4.32-MariaDB
-- Versi PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_perpus`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `admin`
--

CREATE TABLE `admin` (
  `id_admin` varchar(30) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_admin` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `admin`
--

INSERT INTO `admin` (`id_admin`, `username`, `password`, `nama_admin`) VALUES
('A0001', 'adit', '715', 'Aditya');

-- --------------------------------------------------------

--
-- Struktur dari tabel `buku`
--

CREATE TABLE `buku` (
  `id_buku` varchar(30) NOT NULL,
  `judul` varchar(30) NOT NULL,
  `pengarang` varchar(30) NOT NULL,
  `penerbit` varchar(30) NOT NULL,
  `kategori` varchar(30) NOT NULL,
  `deskripsi` text NOT NULL,
  `stok` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `buku`
--

INSERT INTO `buku` (`id_buku`, `judul`, `pengarang`, `penerbit`, `kategori`, `deskripsi`, `stok`) VALUES
('B0001', 'Laskar Pelangi', 'Andrea Hirata', 'Bentang Pustaka', 'Fiksi', 'Kisah inspiratif tentang perjuangan anak-anak dari keluarga sederhana di Belitung untuk meraih pendidikan dan cita-cita, penuh nilai persahabatan dan optimisme.', 11),
('B0002', 'Hujan', 'Tere Liye', 'Gramedia Pustaka Utama', 'Fiksi', 'Cerita emosional tentang kehilangan, bencana alam, dan harapan di masa depan.', 16),
('B0003', 'Pulang', 'Leila S. Chudori', 'Kepustakaan Populer Gramedia', 'Fiksi', 'Kisah tentang keluarga Indonesia yang hidup di pengasingan selama masa orde baru.', 21),
('B0004', 'Sejarah Dunia', 'E.H. Gombrich', 'Yale University Press', 'Sejarah', 'Gambaran sejarah dunia dari zaman kuno hingga modern dengan bahasa yang sederhana dan menarik.\n\n', 5),
('B0005', 'Jejak Langkah', 'Pramoedya Ananta Toer', 'Lentera Dipantara', 'Sejarah', 'Perjuangan identitas dan perlawanan rakyat Indonesia di masa kolonial.', 3),
('B0006', 'Sejarah Indonesia', 'M.C. Ricklefs', 'Macmillan Education', 'Sejarah', 'Gambaran mendalam tentang perjalanan sejarah Indonesia dari era kuno hingga masa modern.', 3),
('B0007', 'Habibie & Ainun', 'B.J. Habibie', 'THC Mandiri', 'Biografi', 'Memoar perjalanan cinta B.J. Habibie dan istrinya Ainun, penuh inspirasi tentang kesetiaan dan perjuangan hidup.', 0),
('B0008', 'Kisah Epik Soekarno', 'Roso Daras', 'Kompas', 'Biografi', 'Kisah perjuangan dan visi Soekarno.', 1),
('B0009', 'Para Pelancong Muslim', 'A.M. Roedhyat', 'Pustaka Alvabet', 'Biografi', 'Perjalanan para pelancong Muslim di dunia.', 1),
('B0010', 'Bumi', 'Tere Liye', 'PenerbitGramedia Pustaka Utama', 'Fantasi', 'Petualangan Raib di dunia paralel dengan misteri dan tantangan luar biasa.', 7),
('B0011', 'Harry Potter 1', 'J.K. Rowling', 'Bloomsbury', 'Fantasi', 'Petualangan Harry Potter di Hogwarts, sekolah sihir yang penuh misteri.', 4),
('B0012', 'Percy Jackson 1', 'Rick Riordan', 'Disney Hyperion', 'Fantasi', 'Kisah Percy, seorang setengah dewa, yang menjalani misi penyelamatan dunia dari ancaman mitologi Yunani.', 5);

-- --------------------------------------------------------

--
-- Struktur dari tabel `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `npm` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `fakultas` varchar(30) NOT NULL,
  `jurusan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `mahasiswa`
--

INSERT INTO `mahasiswa` (`npm`, `nama`, `fakultas`, `jurusan`) VALUES
('230441100007', 'Cristiano Ronaldo', 'Teknik', 'Sistem Informasi'),
('230441100009', 'Erling Braut Haland', 'Teknik', 'Sistem Informasi'),
('230441100010', 'Lionel Messi', 'Teknik', 'Sistem Informasi'),
('230441100138', 'Aditya', 'Teknik', 'Sistem Informasi');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pinjaman`
--

CREATE TABLE `pinjaman` (
  `id_pinjam` varchar(30) NOT NULL,
  `npm` varchar(30) NOT NULL,
  `nama` varchar(30) NOT NULL,
  `id_buku` varchar(30) NOT NULL,
  `judul` varchar(30) NOT NULL,
  `jumlah` int(30) NOT NULL,
  `tgl_pinjam` varchar(30) NOT NULL,
  `tgl_balik` varchar(30) NOT NULL,
  `denda` int(30) NOT NULL,
  `status` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data untuk tabel `pinjaman`
--

INSERT INTO `pinjaman` (`id_pinjam`, `npm`, `nama`, `id_buku`, `judul`, `jumlah`, `tgl_pinjam`, `tgl_balik`, `denda`, `status`) VALUES
('P0001', '230441100007', 'Cristiano Ronaldo', 'B0009', 'Para Pelancong Muslim', 1, '18 November 2024', '25 November 2024', 0, 'Belum Kembali'),
('P0002', '230441100010', 'Lionel Messi', 'b0007', 'Habibie & Ainun', 1, '13 November 2024', '27 November 2024', 0, 'Belum Kembali'),
('P0003', '230441100009', 'Erling Braut Haland', 'b0011', 'Harry Potter 1', 1, '12 November 2024', '21 November 2024', 5000, 'Sudah Kembali'),
('P0004', '230441100138', 'Aditya', 'B0006', 'Sejarah Indonesia', 1, '01 November 2024', '19 November 2024', 15000, 'Sudah Kembali');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `buku`
--
ALTER TABLE `buku`
  ADD PRIMARY KEY (`id_buku`);

--
-- Indeks untuk tabel `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`npm`);

--
-- Indeks untuk tabel `pinjaman`
--
ALTER TABLE `pinjaman`
  ADD PRIMARY KEY (`id_pinjam`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
