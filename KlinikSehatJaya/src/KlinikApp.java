import java.util.Scanner;

// ========================================================
// 1. CLASS - KlinikApp adalah class utama yang menjalankan program
// ========================================================
public class KlinikApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 13. ARRAY - menyimpan banyak objek PasienDetail dalam satu variabel
        // Kapasitas maksimal klinik untuk 10 pasien per hari
        PasienDetail[] daftarPasien = new PasienDetail[10];
        int jumlahPasien = 0; // mencatat berapa pasien yang sudah diinput

        System.out.println("============================================");
        System.out.println("        INFORMASI KLINIK SEHAT JAYA     ");
        System.out.println("============================================");
        System.out.println("  Kapasitas maksimal: 10 pasien per hari   ");
        System.out.println("============================================");

        // 11. PERULANGAN - while loop agar bisa terus input sampai user berhenti
        boolean lanjut = true;
        while (lanjut && jumlahPasien < daftarPasien.length) {

            System.out.println("\n--- Input Data Pasien ke-" + (jumlahPasien + 1) + " ---");

            // 14. ERROR HANDLING - try-catch untuk menangani input yang salah
            try {
                // 12. IO SEDERHANA - menerima input dari user dengan Scanner
                System.out.print("Nama Pasien     : ");
                String nama = scanner.nextLine();

                System.out.print("ID Pasien       : ");
                String id = scanner.nextLine();

                System.out.print("Umur            : ");
                int umur = Integer.parseInt(scanner.nextLine()); // bisa throw NumberFormatException

                System.out.print("Keluhan         : ");
                String keluhan = scanner.nextLine();

                System.out.print("Golongan Darah  : ");
                String golDarah = scanner.nextLine();

                // 2. OBJECT - membuat objek baru dari class PasienDetail
                daftarPasien[jumlahPasien] = new PasienDetail(nama, id, umur, keluhan, golDarah);
                jumlahPasien++;

                System.out.println("✔ Data pasien ke-" + jumlahPasien + " berhasil disimpan.");

            } catch (NumberFormatException e) {
                // Menangkap error jika umur diisi bukan angka
                System.out.println("✘ Error: Umur harus berupa angka! (" + e.getMessage() + ")");
                System.out.println("  Silakan ulangi input untuk pasien ini.");
                continue; // kembali ke awal loop, tidak increment jumlahPasien
            } catch (Exception e) {
                // Menangkap error umum lainnya
                System.out.println("✘ Error tidak terduga: " + e.getMessage());
                continue;
            }

            // --------------------------------------------------------
            // 10. SELEKSI + 12. IO - Pilihan Y/N untuk tambah pasien berikutnya
            // --------------------------------------------------------
            if (jumlahPasien < daftarPasien.length) {
                System.out.println("\n--------------------------------------------");
                System.out.print("Tambah data pasien berikutnya? (y/n) : ");
                String pilihan = scanner.nextLine().trim().toLowerCase();

                // 10. SELEKSI - cek pilihan user
                if (pilihan.equals("y")) {
                    lanjut = true; // lanjut input pasien berikutnya
                } else if (pilihan.equals("n")) {
                    lanjut = false; // berhenti input, langsung tampilkan rekap
                    System.out.println("--------------------------------------------");
                    System.out.println("✔ Input data pasien selesai.");
                } else {
                    // input selain y/n dianggap tidak lanjut
                    System.out.println("⚠ Pilihan tidak dikenal, dianggap tidak menambah pasien lagi.");
                    lanjut = false;
                }
            } else {
                System.out.println("\n⚠ Kapasitas maksimal pasien hari ini sudah penuh (10 pasien).");
                lanjut = false;
            }
        }

        // --------------------------------------------------------
        // 5. MUTATOR - contoh penggunaan setter untuk update data pasien
        // Misalnya petugas ingin memperbarui ID dan golongan darah pasien pertama
        // --------------------------------------------------------
        if (jumlahPasien > 0) {
            System.out.println("\n[INFO] Sistem memperbarui ID resmi untuk pasien pertama...");
            daftarPasien[0].setIdPasien("KSJ-" + String.format("%03d", 1));
            System.out.println("✔ ID Pasien 1 diperbarui menjadi: " + daftarPasien[0].getIdPasien());
        }

        // --------------------------------------------------------
        // Menampilkan rekap semua data pasien
        // --------------------------------------------------------
        System.out.println("\n============================================");
        System.out.println("        REKAP DATA PASIEN HARI INI         ");
        System.out.println("  Total Pasien Terdaftar: " + jumlahPasien + " orang          ");
        System.out.println("============================================");

        // 11. PERULANGAN - for loop untuk menampilkan data pasien
        if (jumlahPasien == 0) {
            System.out.println("Tidak ada data pasien yang tersimpan.");
        } else {
            for (int i = 0; i < jumlahPasien; i++) {
                System.out.println("\n[ Pasien #" + (i + 1) + " ]");
                // 12. IO SEDERHANA - menampilkan output ke layar
                // Memanggil displayInfo() hasil OVERRIDING dari PasienDetail
                System.out.println(daftarPasien[i].displayInfo());
                System.out.println("--------------------------------------------");
            }
        }

        // --------------------------------------------------------
        // Catatan dokter untuk setiap pasien
        // Menggunakan OVERLOADING - displayInfo(String catatan)
        // --------------------------------------------------------
        if (jumlahPasien > 0) {
            System.out.println("\n============================================");
            System.out.println("     CATATAN DOKTER UNTUK SETIAP PASIEN    ");
            System.out.println("============================================");

            // 11. PERULANGAN - for loop untuk menampilkan catatan dokter
            for (int i = 0; i < jumlahPasien; i++) {

                // 10. SELEKSI - menentukan catatan dokter berdasarkan poli tujuan
                String catatan;
                String poli = daftarPasien[i].tentukanPoli();

                if (poli.equals("Poli Umum")) {
                    catatan = "Istirahat cukup, minum obat sesuai resep, dan perbanyak minum air putih.";
                } else if (poli.equals("Poli Gigi")) {
                    catatan = "Hindari makanan manis dan keras. Sikat gigi 2x sehari. Kontrol ulang 1 minggu.";
                } else if (poli.equals("Poli Mata")) {
                    catatan = "Kurangi penggunaan gadget. Gunakan obat tetes mata sesuai anjuran dokter.";
                } else { // Poli Ortopedi
                    catatan = "Istirahatkan area yang sakit. Hindari aktivitas berat. Fisioterapi jika perlu.";
                }

                System.out.println("\n[ Pasien #" + (i + 1) + " - " + daftarPasien[i].getNama() + " ]");
                // Memanggil versi OVERLOADING displayInfo dengan catatan dokter
                System.out.println(daftarPasien[i].displayInfo(catatan));
                System.out.println("--------------------------------------------");
            }
        }

        System.out.println("\n============================================");
        System.out.println("      Terima kasih telah menggunakan        ");
        System.out.println("      Sistem Klinik Sehat Jaya!             ");
        System.out.println("============================================");

        scanner.close();
    }
}