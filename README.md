# Aplikasi Data Mahasiswa

**Nama:** Sabrina Mawadathun Salsabila  
**NIM:** F1D02410092

## 1. Deskripsi Program

Aplikasi Data Mahasiswa merupakan aplikasi desktop sederhana yang dibuat menggunakan Java Swing dan MySQL. Aplikasi ini digunakan untuk mengelola data mahasiswa, seperti menambahkan, menampilkan, mengubah, dan menghapus data.

Aplikasi ini juga menerapkan Thread agar proses database berjalan di background sehingga tampilan aplikasi tetap responsif.

## 2. Fitur Aplikasi

1. **Tambah:** Menambahkan data mahasiswa ke database.
2. **Tampilkan:** Menampilkan seluruh data mahasiswa.
3. **Ubah:** Mengubah data mahasiswa berdasarkan ID.
4. **Hapus:** Menghapus data mahasiswa berdasarkan ID.

## 3. Teknologi yang Digunakan

- Java
- Java Swing
- MySQL
- JDBC
- MySQL Connector/J

## 4. Struktur Program

- `Koneksi.java`: Menghubungkan aplikasi Java dengan database MySQL.
- `MahasiswaDAO.java`: Mengelola proses CRUD pada database.
- `Main.java`: Menampilkan GUI dan mengatur interaksi pengguna.

## 5. Penerapan Materi

**Connection:** Digunakan untuk menghubungkan Java dengan database MySQL.

**DAO (Data Access Object):** Digunakan untuk memisahkan proses pengolahan database dari tampilan aplikasi.

**PreparedStatement:** Digunakan untuk menjalankan perintah SQL dengan parameter.

**Transaction:** Menggunakan `commit()` untuk menyimpan perubahan dan `rollback()` untuk membatalkan perubahan jika terjadi kesalahan.

**ResultSet:** Digunakan untuk membaca data hasil query SELECT.

**Thread:** Digunakan untuk menjalankan proses database di background agar GUI tidak terhambat.

**SwingUtilities.invokeLater():** Digunakan untuk memperbarui tampilan GUI melalui Event Dispatch Thread.

**Event Handling:** Menggunakan `addActionListener()` untuk menangani klik tombol.

## 6. Cara Menjalankan Program

1. Aktifkan MySQL melalui Laragon atau XAMPP.
2. Buat database dengan nama `db_mahasiswa`.
3. Buat tabel `mahasiswa`.
4. Masukkan MySQL Connector/J ke Referenced Libraries.
5. Sesuaikan konfigurasi koneksi database pada `Koneksi.java`.
6. Jalankan file `Main.java`.

## 7. Screenshot Aplikasi

### Tampilan Utama
![Tampilan Utama](screenshots/1.png)

### Proses Penyimpanan
![Proses Saving](screenshots/2.png)

### Hasil Data Mahasiswa
![Hasil Data Mahasiswa](screenshots/3.png)

## 8. Kesimpulan

Melalui aplikasi ini, saya mempelajari cara menghubungkan Java dengan database MySQL, menerapkan operasi CRUD menggunakan DAO, serta menggunakan Thread dan invokeLater untuk menjalankan proses database tanpa mengganggu tampilan GUI.