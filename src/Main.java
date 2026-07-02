/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
 
public class Main {
 
    // ARRAY - simpan daftar kendaraan (max 20)
    static Kendaraan[] daftarKendaraan = new Kendaraan[20];
    static int jumlahKendaraan = 0;
 
    // ARRAY - simpan daftar transaksi (max 50)
    static TransaksiRental[] daftarTransaksi = new TransaksiRental[50];
    static int jumlahTransaksi = 0;
 
    static Scanner sc = new Scanner(System.in);
    static int counterTrx = 1;
 
    public static void main(String[] args) {
 
        isiDataAwal();
 
        System.out.println("==========================================");
        System.out.println("   SELAMAT DATANG DI RENTGO INDONESIA!   ");
        System.out.println("==========================================");
 
        boolean jalan = true;
 
        // PERULANGAN - loop menu sampai user keluar
        while (jalan) {
            tampilkanMenu();
 
            // IO SEDERHANA - input dari keyboard
            System.out.print("Pilih menu: ");
            String pilih = sc.nextLine().trim();
 
            // SELEKSI - switch case pilihan menu
            switch (pilih) {
                case "1": lihatKendaraan();     break;
                case "2": sewaKendaraan();      break;
                case "3": kembalikanKendaraan(); break;
                case "4": lihatTransaksiAktif(); break;
                case "5": TransaksiRental.bacaRiwayat(); break; // IO Stream
                case "6":
                    System.out.println("\nTerima kasih sudah pakai RentGo!");
                    System.out.println("Sampai jumpa!");
                    jalan = false;
                    break;
                default:
                    System.out.println("[!] Menu tidak valid, coba lagi.");
            }
        }
 
        sc.close();
    }
 
    // -------------------------------------------------------
    // Data kendaraan awal
    // -------------------------------------------------------
    static void isiDataAwal() {
        // Motor
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("M001", "Honda Beat",   "Motor", "Merah",   2022,  75000);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("M002", "Yamaha NMAX",  "Motor", "Hitam",   2023, 120000);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("M003", "Honda CBR",    "Motor", "Biru",    2021, 150000);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("M004", "Kawasaki KLX", "Motor", "Hijau",   2022, 130000);
 
        // Mobil
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("K001", "Toyota Avanza",  "Mobil", "Putih",   2021, 350000);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("K002", "Honda Brio",     "Mobil", "Silver",  2022, 280000);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("K003", "Toyota Fortuner","Mobil", "Hitam",   2023, 650000);
        daftarKendaraan[jumlahKendaraan++] = new Kendaraan("K004", "Suzuki Ertiga",  "Mobil", "Abu-abu", 2022, 320000);
    }
 
    // -------------------------------------------------------
    // Tampilkan menu
    // -------------------------------------------------------
    static void tampilkanMenu() {
        System.out.println("\n==========================================");
        System.out.println("             MENU UTAMA                  ");
        
        System.out.println("  1. Lihat Semua Kendaraan");
        System.out.println("  2. Sewa Kendaraan");
        System.out.println("  3. Kembalikan Kendaraan");
        System.out.println("  4. Lihat Transaksi Aktif");
        System.out.println("  5. Riwayat Transaksi (dari file)");
        System.out.println("  6. Keluar");
        System.out.println("==========================================");
    }
 
    // -------------------------------------------------------
    // Menu 1: Lihat semua kendaraan
    // -------------------------------------------------------
    static void lihatKendaraan() {
        System.out.println("\n========== DAFTAR KENDARAAN ==========");
 
        // PERULANGAN + SELEKSI tipe
        System.out.println("\n--- MOTOR ---");
        for (int i = 0; i < jumlahKendaraan; i++) {
            if (daftarKendaraan[i].getTipe().equals("Motor")) {
                daftarKendaraan[i].tampilkanInfo();
            }
        }
 
        System.out.println("\n--- MOBIL ---");
        for (int i = 0; i < jumlahKendaraan; i++) {
            if (daftarKendaraan[i].getTipe().equals("Mobil")) {
                daftarKendaraan[i].tampilkanInfo();
            }
        }
    }
 
    // -------------------------------------------------------
    // Menu 2: Sewa kendaraan
    // -------------------------------------------------------
    static void sewaKendaraan() {
        System.out.println("\n========== SEWA KENDARAAN ==========");
 
        // IO SEDERHANA - input data penyewa
        System.out.print("Nama penyewa : ");
        String nama = sc.nextLine();
 
        System.out.print("No. HP       : ");
        String noHP = sc.nextLine();
 
        System.out.print("ID Kendaraan : ");
        String idInput = sc.nextLine().toUpperCase();
 
        // ERROR HANDLING
        try {
            // Validasi nama tidak boleh kosong
            if (nama.trim().isEmpty()) {
                throw new Exception("Nama penyewa tidak boleh kosong!");
            }
 
            // PERULANGAN - cari kendaraan berdasarkan ID
            Kendaraan dipilih = null;
            for (int i = 0; i < jumlahKendaraan; i++) {
                if (daftarKendaraan[i].getIdKendaraan().equals(idInput)) {
                    dipilih = daftarKendaraan[i];
                    break;
                }
            }
 
            // SELEKSI - validasi kendaraan ditemukan atau tidak
            if (dipilih == null) {
                throw new Exception("Kendaraan ID '" + idInput + "' tidak ditemukan!");
            }
 
            if (!dipilih.isTersedia()) {
                throw new Exception("Kendaraan " + dipilih.getMerek() + " sedang disewa!");
            }
 
            // Input jumlah hari + validasi
            System.out.print("Jumlah hari  : ");
            String inputHari = sc.nextLine();
            int hari;
 
            try {
                hari = Integer.parseInt(inputHari);
                if (hari <= 0) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                throw new Exception("Jumlah hari harus angka positif!");
            }
 
            // Buat transaksi (Inheritance + Polymorphism otomatis jalan)
            String idTrx = "TRX" + String.format("%03d", counterTrx++);
            System.out.println("\nMenghitung biaya...");
 
            TransaksiRental trx = new TransaksiRental(idTrx, nama, noHP, dipilih, hari);
 
            // Update status kendaraan jadi tidak tersedia
            dipilih.setTersedia(false);
 
            // Simpan ke array
            daftarTransaksi[jumlahTransaksi++] = trx;
 
            // Simpan ke file (IO Stream)
            trx.simpanKeFile();
 
            // Tampilkan struk
            trx.tampilkanStruk();
 
        } catch (Exception e) {
            System.out.println("\n[ERROR] " + e.getMessage());
            System.out.println("Silakan coba lagi.");
        }
    }
 
    // -------------------------------------------------------
    // Menu 3: Kembalikan kendaraan
    // -------------------------------------------------------
    static void kembalikanKendaraan() {
        System.out.println("\n========== KEMBALIKAN KENDARAAN ==========");
        System.out.print("Masukkan ID Transaksi: ");
        String idInput = sc.nextLine().toUpperCase();
 
        // ERROR HANDLING
        try {
            TransaksiRental ditemukan = null;
 
            // PERULANGAN - cari transaksi
            for (int i = 0; i < jumlahTransaksi; i++) {
                if (daftarTransaksi[i].getIdTransaksi().equals(idInput)) {
                    ditemukan = daftarTransaksi[i];
                    break;
                }
            }
 
            if (ditemukan == null) {
                throw new Exception("Transaksi ID '" + idInput + "' tidak ditemukan!");
            }
 
            // Update status kendaraan jadi tersedia lagi
            // PERULANGAN - cari kendaraan yang sesuai
            for (int i = 0; i < jumlahKendaraan; i++) {
                if (daftarKendaraan[i].getIdKendaraan().equals(ditemukan.getIdKendaraan())) {
                    daftarKendaraan[i].setTersedia(true);
                    break;
                }
            }
 
            System.out.println("\n[✓] Kendaraan berhasil dikembalikan!");
            System.out.println("    " + ditemukan.getMerek() + " (" +
                               ditemukan.getIdKendaraan() + ") kini tersedia kembali.");
 
        } catch (Exception e) {
            System.out.println("\n[ERROR] " + e.getMessage());
        }
    }
 
    // -------------------------------------------------------
    // Menu 4: Lihat transaksi aktif
    // -------------------------------------------------------
    static void lihatTransaksiAktif() {
        System.out.println("\n========== TRANSAKSI AKTIF ==========");
 
        if (jumlahTransaksi == 0) {
            System.out.println("Belum ada transaksi.");
            return;
        }
 
        // PERULANGAN - tampilkan semua transaksi
        for (int i = 0; i < jumlahTransaksi; i++) {
            TransaksiRental t = daftarTransaksi[i];
            String status = t.isTersedia() ? "Sudah Kembali" : "Masih Disewa";
            System.out.println((i + 1) + ". [" + t.getIdTransaksi() + "] "
                    + t.getNamaPenyewa() + " - "
                    + t.getMerek() + " | "
                    + t.getJumlahHari() + " hari | Rp "
                    + String.format("%,.0f", t.getTotalBiaya())
                    + " | " + status);
        }
    }
}
