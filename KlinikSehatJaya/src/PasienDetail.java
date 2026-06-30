// ========================================================
// 8. INHERITANCE - PasienDetail mewarisi (extends) class Pasien
// Artinya PasienDetail otomatis punya semua atribut dan method Pasien
// ========================================================
public class PasienDetail extends Pasien {

    // 3. ATRIBUT TAMBAHAN milik PasienDetail
    // 7. ENCAPSULATION - tetap private
    private String golonganDarah;
    private String keluhan;

    // 4. CONSTRUCTOR PasienDetail - memanggil constructor Pasien dengan super()
    public PasienDetail(String nama, String idPasien, int umur,
                        String keluhan, String golonganDarah) {
        super(nama, idPasien, umur); // memanggil constructor parent class
        this.keluhan      = keluhan;
        this.golonganDarah = golonganDarah;
    }

    // 6. ACCESSOR tambahan
    public String getGolonganDarah() { return golonganDarah; }
    public String getKeluhan()       { return keluhan; }

    // 5. MUTATOR tambahan
    public void setGolonganDarah(String golonganDarah) { this.golonganDarah = golonganDarah; }
    public void setKeluhan(String keluhan)             { this.keluhan = keluhan; }

    // --------------------------------------------------------
    // 10. SELEKSI - menentukan kategori umur pasien
    // --------------------------------------------------------
    public String kategoriUmur() {
        int umur = getUmur();
        if (umur <= 4) {
            return "Balita";
        } else if (umur <= 12) {
            return "Anak-anak";
        } else if (umur <= 17) {
            return "Remaja";
        } else if (umur <= 59) {
            return "Dewasa";
        } else {
            return "Lansia";
        }
    }

    // --------------------------------------------------------
    // 10. SELEKSI - menentukan poli tujuan berdasarkan keluhan
    // --------------------------------------------------------
    public String tentukanPoli() {
        // Ubah keluhan ke huruf kecil agar pengecekan tidak case-sensitive
        String k = keluhan.toLowerCase();

        if (k.contains("gigi berlubang") || k.contains("sakit gigi")) {
            return "Poli Gigi";
        } else if (k.contains("mata merah") || k.contains("rabun")) {
            return "Poli Mata";
        } else if (k.contains("patah tulang") || k.contains("keseleo") || k.contains("sakit pinggang")) {
            return "Poli Ortopedi";
        } else {
            // demam, flu, batuk, sakit kepala, atau keluhan lain → Poli Umum
            return "Poli Umum";
        }
    }

    // --------------------------------------------------------
    // 9. POLYMORPHISM - OVERRIDING
    // Menimpa method displayInfo() milik class Pasien
    // Versi ini menampilkan info lebih lengkap
    // --------------------------------------------------------
    @Override
    public String displayInfo() {
        return "Nama          : " + getNama()       + "\n" +
               "ID Pasien     : " + getIdPasien()  + "\n" +
               "Umur          : " + getUmur()      + " tahun (" + kategoriUmur() + ")\n" +
               "Golongan Darah: " + golonganDarah  + "\n" +
               "Keluhan       : " + keluhan        + "\n" +
               "Poli Tujuan   : " + tentukanPoli();
    }

    // --------------------------------------------------------
    // 9. POLYMORPHISM - OVERLOADING
    // Method displayInfo() dengan parameter tambahan (catatan dokter)
    // Nama method sama tapi parameternya berbeda → Overloading
    // --------------------------------------------------------
    public String displayInfo(String catatanDokter) {
        return displayInfo() + "\n" +
               "Catatan Dokter: " + catatanDokter;
    }
}