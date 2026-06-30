// ========================================================
// 1. CLASS - Pasien adalah class induk (parent class)
// Menyimpan data dasar seorang pasien
// ========================================================
public class Pasien {

    // 3. ATRIBUT - data yang dimiliki setiap pasien
    // 7. ENCAPSULATION - atribut dibuat private agar tidak bisa diakses langsung dari luar
    private String nama;
    private String idPasien;
    private int umur;

    // 4. CONSTRUCTOR - digunakan untuk membuat objek Pasien baru dengan data awal
    public Pasien(String nama, String idPasien, int umur) {
        this.nama     = nama;
        this.idPasien = idPasien;
        this.umur     = umur;
    }

    // 6. ACCESSOR (Getter) - mengambil nilai atribut dari luar class
    public String getNama()     { return nama; }
    public String getIdPasien() { return idPasien; }
    public int    getUmur()     { return umur; }

    // 5. MUTATOR (Setter) - mengubah nilai atribut dari luar class
    public void setNama(String nama)         { this.nama     = nama; }
    public void setIdPasien(String idPasien) { this.idPasien = idPasien; }
    public void setUmur(int umur)            { this.umur     = umur; }

    // Method displayInfo() versi dasar - akan di-OVERRIDE oleh PasienDetail
    public String displayInfo() {
        return "Nama     : " + nama + "\n" +
               "ID       : " + idPasien + "\n" +
               "Umur     : " + umur + " tahun";
    }
}