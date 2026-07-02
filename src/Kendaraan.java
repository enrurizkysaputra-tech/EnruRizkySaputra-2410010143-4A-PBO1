/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author User
 */
public class Kendaraan {
     // ATRIBUT - private (Encapsulation)
    private String idKendaraan;
    private String merek;
    private String tipe;        // "Motor" atau "Mobil"
    private String warna;
    private int tahun;
    private double hargaPerHari;
    private boolean tersedia;
 
    // CONSTRUCTOR
    public Kendaraan(String idKendaraan, String merek, String tipe,
                     String warna, int tahun, double hargaPerHari) {
        this.idKendaraan  = idKendaraan;
        this.merek        = merek;
        this.tipe         = tipe;
        this.warna        = warna;
        this.tahun        = tahun;
        this.hargaPerHari = hargaPerHari;
        this.tersedia     = true;
    }
 
    // MUTATOR (Setter)
    public void setIdKendaraan(String idKendaraan)   { this.idKendaraan  = idKendaraan; }
    public void setMerek(String merek)               { this.merek        = merek; }
    public void setTipe(String tipe)                 { this.tipe         = tipe; }
    public void setWarna(String warna)               { this.warna        = warna; }
    public void setTahun(int tahun)                  { this.tahun        = tahun; }
    public void setHargaPerHari(double hargaPerHari) { this.hargaPerHari = hargaPerHari; }
    public void setTersedia(boolean tersedia)        { this.tersedia     = tersedia; }
 
    // ACCESSOR (Getter)
    public String getIdKendaraan()  { return idKendaraan; }
    public String getMerek()        { return merek; }
    public String getTipe()         { return tipe; }
    public String getWarna()        { return warna; }
    public int getTahun()           { return tahun; }
    public double getHargaPerHari() { return hargaPerHari; }
    public boolean isTersedia()     { return tersedia; }
 
    // METHOD - hitung biaya (bisa di-override = Polymorphism)
    public double hitungBiaya(int hari) {
        return hargaPerHari * hari;
    }
 
    // Tampilkan info kendaraan
    public void tampilkanInfo() {
        System.out.println("------------------------------------------");
        System.out.println("ID        : " + idKendaraan);
        System.out.println("Tipe      : " + tipe);
        System.out.println("Merek     : " + merek);
        System.out.println("Warna     : " + warna);
        System.out.println("Tahun     : " + tahun);
        System.out.println("Harga/Hari: Rp " + String.format("%,.0f", hargaPerHari));
        System.out.println("Status    : " + (tersedia ? "Tersedia" : "Sedang Disewa"));
    }
 
    // Format untuk disimpan ke file (IO Stream)
    public String toFileString() {
        return idKendaraan + "|" + merek + "|" + tipe + "|" + warna + "|" +
               tahun + "|" + hargaPerHari + "|" + tersedia;
    }
}
