# Sistem Rental Kendaraan - RentGo Indonesia

Aplikasi manajemen rental kendaraan berbasis Java OOP sebagai tugas akhir UAS Pemrograman Berbasis Objek 1.

\---

## Deskripsi Program

**RentGo Indonesia** adalah sistem rental kendaraan sederhana berbasis konsol yang memungkinkan pengguna untuk:

* Melihat daftar kendaraan (Motor \& Mobil) beserta status ketersediaannya
* Melakukan transaksi penyewaan kendaraan
* Mengembalikan kendaraan yang telah disewa
* Melihat riwayat transaksi yang tersimpan di file .txt

\---

## Struktur Class

```
Kendaraan        → Parent Class (class induk)
TransaksiRental  → Child Class (extends Kendaraan)
Main             → Program Utama
```

\---

## Cara Menjalankan

1. Pastikan Java (JDK) sudah terinstall
2. Masuk ke folder `src`
3. Kompilasi:

```bash
   javac \\\*.java
   ```

4. Jalankan:

```bash
   java Main
   ```

\---

## Tabel Penilaian

|No|Materi|Bobot|Implementasi|Nilai|
|-|-|-|-|-|
|1|Class|5|Terdapat 3 class: `Kendaraan`, `TransaksiRental`, `Main`|5|
|2|Object|5|Objek `Kendaraan` dan `TransaksiRental` dibuat di `Main.java`|5|
|3|Atribut|5|`idKendaraan`, `merek`, `tipe`, `warna`, `tahun`, `hargaPerHari`, `tersedia`, dll|5|
|4|Constructor|5|Semua class punya constructor dengan parameter lengkap|5|
|5|Mutator|5|Setter method di `Kendaraan` dan `TransaksiRental`|5|
|6|Accessor|5|Getter method di semua class|5|
|7|Encapsulation|5|Semua atribut `private`, diakses via getter/setter|5|
|8|Inheritance|5|`TransaksiRental extends Kendaraan`, pakai `super()` di constructor|5|
|9|Polymorphism|10|Override `hitungBiaya()` di `TransaksiRental` — logika Motor dan Mobil beda|10|
|10|Seleksi|5|`switch` menu utama, `if-else` validasi dan filter tipe kendaraan|5|
|11|Perulangan|5|`while` loop menu utama, `for` iterasi array kendaraan dan transaksi|5|
|12|IO Sederhana|10|`Scanner` input keyboard + `FileWriter/BufferedWriter/FileReader/BufferedReader`|10|
|13|Array|15|`Kendaraan\\\[20]` dan `TransaksiRental\\\[50]` untuk menyimpan data|15|
|14|Error Handling|15|`try-catch-throw` di `sewaKendaraan()`, `kembalikanKendaraan()`, dan IO Stream|15|
||**TOTAL**|**100**||**100**|

\---

## Identitas

* **Nama**: \[Enru Rizky Saputra]
* **NPM**: \[2410010143]
* **Kelas**: \[4A]
* **Mata Kuliah**: Pemrograman Berbasis Objek 1
* **Dosen**: \[Muhammad Edya Rosadi]

\---

## Video Penjelasan

\[Link YouTube: ISI LINK VIDEO KAMU]

