// Project UAS PBO1 - RentGo Indonesia
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
/**
 *
 * @author User
 */
public class TransaksiRental extends Kendaraan {
    // Atribut tambahan khusus transaksi
    private String idTransaksi;
    private String namaPenyewa;
    private String noHP;
    private int jumlahHari;
    private double totalBiaya;
 
    private static final String FILE_TRANSAKSI = "data_transaksi.txt";
 
    // CONSTRUCTOR - panggil constructor parent pakai super()
    public TransaksiRental(String idTransaksi, String namaPenyewa, String noHP,
                           Kendaraan k, int jumlahHari) {
        // Inheritance: ambil data kendaraan dari parent
        super(k.getIdKendaraan(), k.getMerek(), k.getTipe(),
              k.getWarna(), k.getTahun(), k.getHargaPerHari());
 
        this.idTransaksi = idTransaksi;
        this.namaPenyewa = namaPenyewa;
        this.noHP        = noHP;
        this.jumlahHari  = jumlahHari;
        this.totalBiaya  = hitungBiaya(jumlahHari); // Polymorphism
    }
 
    // MUTATOR
    public void setIdTransaksi(String idTransaksi) { this.idTransaksi = idTransaksi; }
    public void setNamaPenyewa(String namaPenyewa) { this.namaPenyewa = namaPenyewa; }
    public void setNoHP(String noHP)               { this.noHP        = noHP; }
    public void setJumlahHari(int jumlahHari)      { this.jumlahHari  = jumlahHari; }
 
    // ACCESSOR
    public String getIdTransaksi() { return idTransaksi; }
    public String getNamaPenyewa() { return namaPenyewa; }
    public String getNoHP()        { return noHP; }
    public int getJumlahHari()     { return jumlahHari; }
    public double getTotalBiaya()  { return totalBiaya; }
 
    // OVERRIDE hitungBiaya() - POLYMORPHISM
    // Motor (tipe "Motor") diskon 10% kalau sewa > 3 hari
    // Mobil kena biaya tambahan driver Rp 50.000/hari
    @Override
    public double hitungBiaya(int hari) {
        double total = getHargaPerHari() * hari;
 
        if (getTipe().equalsIgnoreCase("Motor") && hari > 3) {
            System.out.println("  [Info] Motor sewa > 3 hari, dapat diskon 10%!");
            total = total * 0.9;
        } else if (getTipe().equalsIgnoreCase("Mobil")) {
            double biayaDriver = 50000 * hari;
            System.out.println("  [Info] Mobil kena biaya driver: +Rp " +
                               String.format("%,.0f", biayaDriver));
            total += biayaDriver;
        }
 
        return total;
    }
 
    // Tampilkan struk transaksi
    public void tampilkanStruk() {
        System.out.println("\n==========================================");
        System.out.println("        STRUK RENTAL RENTGO INDONESIA     ");
        System.out.println("==========================================");
        System.out.println("ID Transaksi : " + idTransaksi);
        System.out.println("Nama Penyewa : " + namaPenyewa);
        System.out.println("No. HP       : " + noHP);
        System.out.println("Kendaraan    : " + getMerek() + " (" + getTipe() + ")");
        System.out.println("Lama Sewa    : " + jumlahHari + " hari");
        System.out.println("Total Biaya  : Rp " + String.format("%,.0f", totalBiaya));
        System.out.println("==========================================");
    }
 
    // -------------------------------------------------------
    // IO STREAM - Simpan transaksi ke file .txt
    // -------------------------------------------------------
    public void simpanKeFile() {
        try (FileWriter fw = new FileWriter(FILE_TRANSAKSI, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter pw = new PrintWriter(bw)) {
 
            pw.println(idTransaksi + "|" + namaPenyewa + "|" + noHP + "|" +
                       getIdKendaraan() + "|" + getMerek() + "|" + getTipe() + "|" +
                       jumlahHari + "|" + totalBiaya);
 
            System.out.println("[✓] Transaksi berhasil disimpan ke file.");
 
        } catch (IOException e) {
            System.out.println("[✗] Gagal simpan transaksi: " + e.getMessage());
        }
    }
 
    // -------------------------------------------------------
    // IO STREAM - Baca semua transaksi dari file .txt
    // -------------------------------------------------------
    public static void bacaRiwayat() {
        File file = new File(FILE_TRANSAKSI);
 
        if (!file.exists()) {
            System.out.println("[!] Belum ada riwayat transaksi.");
            return;
        }
 
        try (FileReader fr = new FileReader(file);
             BufferedReader br = new BufferedReader(fr)) {
 
            String line;
            int no = 1;
            System.out.println("==========================================");
            System.out.println("          RIWAYAT TRANSAKSI              ");
            System.out.println("==========================================");
            System.out.printf("%-4s %-10s %-15s %-12s %-6s %s%n",
                    "No", "ID", "Nama", "Kendaraan", "Hari", "Total");
            System.out.println("------------------------------------------");
 
            while ((line = br.readLine()) != null) {
                String[] d = line.split("\\|");
                if (d.length >= 8) {
                    System.out.printf("%-4d %-10s %-15s %-12s %-6s Rp %s%n",
                            no++, d[0], d[1], d[4] + "(" + d[5] + ")",
                            d[6], String.format("%,.0f", Double.parseDouble(d[7])));
                }
            }
            System.out.println("==========================================");
 
        } catch (IOException e) {
            System.out.println("[✗] Gagal baca file: " + e.getMessage());
        }
    }
}
