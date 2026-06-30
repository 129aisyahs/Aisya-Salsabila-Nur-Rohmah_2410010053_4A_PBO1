# Proyek Akhir Pemrograman Berbasis Objek 1

Proyek ini adalah contoh sederhana aplikasi pengolahan data pasien menggunakan Java sebagai tugas akhir dari mata kuliah pemrograman berbasis objek 1.

## Deskripsi

Aplikasi ini menerima input berupa nama, ID, umur, keluhan, dan golongan darah pasien, dan memberikan output berupa informasi detail pasien seperti kategori umur dan poli tujuan berdasarkan keluhan yang dialami.

Aplikasi ini mengimplementasikan beberapa konsep penting dalam pemrograman berorientasi objek (OOP) seperti Class, Object, Atribut, Method Constructor, Method Mutator, Method Accessor, Encapsulation, Inheritance, Overloading, Overriding, Seleksi, Perulangan, IO Sederhana, Array, dan Error Handling.

## Penjelasan Kode

Berikut adalah bagian kode yang relevan dengan konsep OOP yang dijelaskan:

1. **Class** adalah template atau blueprint dari object. Pada kode ini, `Pasien`, `PasienDetail`, dan `KlinikApp` adalah contoh dari class.

```bash
public class Pasien {
    ...
}

public class PasienDetail extends Pasien {
    ...
}

public class KlinikApp {
    ...
}
```

2. **Object** adalah instance dari class. Pada kode ini, `daftarPasien[jumlahPasien] = new PasienDetail(nama, id, umur, keluhan, golDarah);` adalah contoh pembuatan object.

```bash
daftarPasien[jumlahPasien] = new PasienDetail(nama, id, umur, keluhan, golDarah);
```

3. **Atribut** adalah variabel yang ada dalam class. Pada kode ini, `nama`, `idPasien`, `umur`, `golonganDarah`, dan `keluhan` adalah contoh atribut.

```bash
private String nama;
private String idPasien;
private int umur;
```

4. **Constructor** adalah method yang pertama kali dijalankan pada saat pembuatan object. Pada kode ini, constructor ada di dalam class `Pasien` dan `PasienDetail`.

```bash
public Pasien(String nama, String idPasien, int umur) {
    this.nama = nama;
    this.idPasien = idPasien;
    this.umur = umur;
}

public PasienDetail(String nama, String idPasien, int umur, String keluhan, String golonganDarah) {
    super(nama, idPasien, umur);
    this.keluhan = keluhan;
    this.golonganDarah = golonganDarah;
}
```

5. **Mutator** atau setter digunakan untuk mengubah nilai dari suatu atribut. Pada kode ini, `setNama`, `setIdPasien`, `setUmur`, `setGolonganDarah`, dan `setKeluhan` adalah contoh method mutator.

```bash
public void setIdPasien(String idPasien) {
    this.idPasien = idPasien;
}

public void setNama(String nama) {
    this.nama = nama;
}
```

6. **Accessor** atau getter digunakan untuk mengambil nilai dari suatu atribut. Pada kode ini, `getNama`, `getIdPasien`, `getUmur`, `getGolonganDarah`, dan `getKeluhan` adalah contoh method accessor.

```bash
public String getNama() {
    return nama;
}

public String getIdPasien() {
    return idPasien;
}
```

7. **Encapsulation** adalah konsep menyembunyikan data dengan membuat atribut menjadi private dan hanya bisa diakses melalui method. Pada kode ini, atribut `nama`, `idPasien`, `umur`, `golonganDarah`, dan `keluhan` dienkapsulasi dan hanya bisa diakses melalui method getter dan setter.

```bash
private String nama;
private String idPasien;
private int umur;
```

8. **Inheritance** adalah konsep di mana sebuah class bisa mewarisi property dan method dari class lain. Pada kode ini, `PasienDetail` mewarisi `Pasien` dengan sintaks `extends`.

```bash
public class PasienDetail extends Pasien {
    ...
}
```

9. **Polymorphism** adalah konsep di mana sebuah nama dapat digunakan untuk merujuk ke beberapa tipe atau bentuk objek berbeda. Ini memungkinkan metode-metode dengan nama yang sama untuk berperilaku berbeda tergantung pada tipe objek yang mereka manipulasi, polymorphism bisa berbentuk Overloading ataupun Overriding. Pada kode ini, method `displayInfo(String)` di `PasienDetail` merupakan overloading dari method `displayInfo()`, dan `displayInfo()` di `PasienDetail` merupakan override dari method `displayInfo()` di `Pasien`.

```bash
public String displayInfo(String catatanDokter) {
    return displayInfo() + "\nCatatan Dokter: " + catatanDokter;
}

@Override
public String displayInfo() {
    ...
}
```

10. **Seleksi** adalah statement kontrol yang digunakan untuk membuat keputusan berdasarkan kondisi. Pada kode ini, digunakan seleksi `if else` dalam method `kategoriUmur` dan `tentukanPoli`, serta seleksi pilihan lanjut/berhenti (y/n) saat input data pasien.

```bash
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

public String tentukanPoli() {
    String k = keluhan.toLowerCase();
    if (k.contains("gigi berlubang") || k.contains("sakit gigi")) {
        return "Poli Gigi";
    } else if (k.contains("mata merah") || k.contains("rabun")) {
        return "Poli Mata";
    } else if (k.contains("patah tulang") || k.contains("keseleo") || k.contains("sakit pinggang")) {
        return "Poli Ortopedi";
    } else {
        return "Poli Umum";
    }
}
```

11. **Perulangan** adalah statement kontrol yang digunakan untuk menjalankan blok kode berulang kali. Pada kode ini, digunakan loop `while` untuk meminta input data pasien selama user memilih lanjut, dan loop `for` untuk menampilkan rekap data.

```bash
while (lanjut && jumlahPasien < daftarPasien.length) {
    ...
}

for (int i = 0; i < jumlahPasien; i++) {
    ...
}
```

12. **Input Output Sederhana** digunakan untuk menerima input dari user dan menampilkan output ke user. Pada kode ini, digunakan class `Scanner` untuk menerima input dan method `System.out.println` untuk menampilkan output.

```bash
Scanner scanner = new Scanner(System.in);
System.out.print("Nama Pasien     : ");
String nama = scanner.nextLine();

System.out.println(daftarPasien[i].displayInfo());
```

13. **Array** adalah struktur data yang digunakan untuk menyimpan beberapa nilai dalam satu variabel. Pada kode ini, `PasienDetail[] daftarPasien = new PasienDetail[10];` adalah contoh penggunaan array.

```bash
PasienDetail[] daftarPasien = new PasienDetail[10];
```

14. **Error Handling** digunakan untuk menangani error yang mungkin terjadi saat runtime. Pada kode ini, digunakan `try catch` untuk menangani error saat input umur bukan berupa angka.

```bash
try {
    int umur = Integer.parseInt(scanner.nextLine());
    ...
} catch (NumberFormatException e) {
    System.out.println("Error: Umur harus berupa angka! (" + e.getMessage() + ")");
    continue;
} catch (Exception e) {
    System.out.println("Error tidak terduga: " + e.getMessage());
    continue;
}
```

## Usulan nilai

| No  | Materi         |  Nilai  |
| :-: | -------------- | :-----: |
|  1  | Class          |    5    |
|  2  | Object         |    5    |
|  3  | Atribut        |    5    |
|  4  | Constructor    |    5    |
|  5  | Mutator        |    5    |
|  6  | Accessor       |    5    |
|  7  | Encapsulation  |    5    |
|  8  | Inheritance    |    5    |
|  9  | Polymorphism   |   10    |
| 10  | Seleksi        |    5    |
| 11  | Perulangan     |    5    |
| 12  | IO Sederhana   |   10    |
| 13  | Array          |   15    |
| 14  | Error Handling |   15    |
|     | **TOTAL**      | **100** |

## Pembuat

Nama: Aisya Salsabila Nur Rohmah
NPM: 2410010053
