
import java.util.Scanner;

public class kasirApotekFinal {

 private static final String ADMIN_PASSWORD = "admin123";

 public static void main(String[] args) {
  Scanner scanner = new Scanner(System.in);

  // MENU
  System.out.println("Selamat datang di Aplikasi Apotek");
  System.out.println("--------------------------------------------");
  System.out.print("Apakah Anda pengguna (1) atau admin (2)? ");
  // input jawaban pilihan 1/2
  int multi = scanner.nextInt();

  // jika pilih 1 di menu
  if (multi == 1) {
   fiturUser();

   // jika pilih 2 di menu
  } else if (multi == 2) {
   System.out.print("\nMasukkan password admin: ");
   // input password admin
   String password = scanner.next();

   // ---------------------------------------------------
   // jika password benar
   if (password.equals(ADMIN_PASSWORD)) {
    fiturAdmin();

    // jika password salah
   } else {
    System.out.println("Password salah. Aplikasi akan ditutup.");
   }
   // -------------------------------------------------------------

   // jika pilih selain 1 dan 2 di menu
  } else {
   System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
  }
 }



 // mulai masuk ke fitur utama USER
 // private agar bisa diakses di class ini saja
 private static void fiturUser() {

  System.out.println("\n--- Fitur User ---");
  System.out.println("1. Pembayaran");
  System.out.println("2. Exit");
  System.out.print("Masukkan pilihan Anda: ");

  // deklarasi scanner lagi untuk khusus fitur utama USER
  Scanner scanner = new Scanner(System.in);
  // input pilihan 1 / 2
  int userChoice = scanner.nextInt();

  // memakai switch karena tidak perlu rumus/ribet di pemilihan input userChoice
  switch (userChoice) {
   // jika pilih 1
   case 1:
    fiturPembayaran();
    break;

    // jika pilih 2
   case 2:
    System.out.println("...Terimakasih....");
    break;

   // jika memilih pilihan selain 1 dan 2
   default:
    System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
  }
 }

 // Masuk ke fitur utama Admin
 private static void fiturAdmin() {
  System.out.println("\n--- Fitur Admin ---");
  System.out.println("1. Kelola Stok Obat");
  System.out.println("2. Identifikasi Kadaluwarsa");
  System.out.println("3. Keluar");
  System.out.print("Masukkan pilihan Anda: ");

  // membuat deklarasi scanner baru untuk fitur utama admin
  Scanner scanner = new Scanner(System.in);

  // input pilihan 1/2/3
  int adminChoice = scanner.nextInt();

  // pemilihan switch karena hanya perlu mention private static void beberapa
  // fitur
  switch (adminChoice) {

   // jika pilih 1
   case 1:
    fiturKelolaStokObat();
    break;
   // jika pilih 2
   case 2:
    fiturIdentifikasiKadaluwarsa();
    break;
   // jika pilih 3
   case 3:
    System.out.println("..Keluar..");
    break;
   // jika pilih selain pilihan 1,2,dan 3
   default:
    System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
  }
 }

 // masuk ke salah satu fitur Admin, stok obat
 private static void fiturKelolaStokObat() {
  // Menggunakan Array 2 dimensi

  String[][] stokObat = {
    { "Obat Batuk", "20" },
    { "Obat Pilek", "20" },
    { "Obat Pusing", "20" }
  };

  // deklarasi scanner baru khusus untuk fitur stok obat fitur Admin
  Scanner scanner = new Scanner(System.in);
  // deklrasi variabel
  int pilihan;

  // Menggunakan perulangan do while
  do {
   System.out.println("\n--- Menu Kelola Stok Obat ---");
   System.out.println("1. Tampilkan Detail Stok Obat");
   System.out.println("2. Tambah Stok Obat");
   System.out.println("3. Kurangi Stok Obat");
   System.out.println("4. Keluar");
   System.out.print("\nMasukkan pilihan Anda: ");

   // input pilihan 1/2/3/4
   pilihan = scanner.nextInt();

   // pakai pemilihan switch case
   switch (pilihan) {
    // jika pilih 1
    case 1:
     tampilkanDetailStok(stokObat);
     break;
    // jika pilih 2
    case 2:
     tambahStok(stokObat);
     break;
    // jika pilih 3
    case 3:
     kurangiStok(stokObat);
     break;
    // jika pilih 4
    case 4:
     System.out.println("..Keluar..");
     break;
    // jika pilih selain 1,2,3 dan 4
    default:
     System.out.println("Pilihan tidak valid, harap masukkan angka 1-4!");
   }
  }
  // perulangan do while mengatakan while bukan inputan 4
  while (pilihan != 4);
 }

 // Fitur ke 1 fitur stok obat dari fitur admin, penampilan detail stok obat
 // memakai array 2 dimensi
 private static void tampilkanDetailStok(String[][] obatList) {
  System.out.println("\nDetail Stok Obat:");
  // perulangan for dengan array 1 dimensi
  for (String[] obat : obatList) {
   int stok = Integer.parseInt(obat[1]);
   System.out.println("Obat: " + obat[0] + ", Stok: " + stok);

   // Nested loop untuk mencetak karakter '*' sebanyak stok obat
   for (int i = 0; i < stok; i++) {
    System.out.print("*");
   }
   System.out.println(); // Pindah baris setelah mencetak stok obat
  }
 }

 // Fitur ke 2 fitur stok obat dari fitur admin, update penambahan stok obat
 // array 2 dimensi
 private static void tambahStok(String[][] obatList) {
  System.out.print("\nMasukkan nama obat untuk menambah stok (Obat...): ");
  // deklarasi scanner khusus fitur tambah stok
  Scanner scanner0 = new Scanner(System.in);
  // input nama obat
  String nama = scanner0.nextLine();

  // jika boolean obat tidak ditemukan
  boolean ditemukan = false;

  // perulangan for dengan array 1 dimensi nama obat dan stok obatnya
  for (String[] obat : obatList) {
   // jika nama obat sesuai dengan nama
   if (obat[0].equalsIgnoreCase(nama)) {
    boolean inputValid = false;
    // dimulai jumlah obat dari 0
    int jumlah = 0;

    // perulangan while, jika inputan input valid tidak sesuai
    while (!inputValid) {
     System.out.print("\nMasukkan jumlah stok yang akan ditambahkan untuk " + obat[0] + ": ");

     // ini knp pk stringsrharusny int & jelasin
     String inputJumlah = scanner0.nextLine();
     if (inputJumlah.matches("\\d+")) {
      jumlah = Integer.parseInt(inputJumlah);

      // pemilihan if else jika jumlah lebih besar sama dengan 0
      if (jumlah >= 0) {
       inputValid = true;
       // jika sebaliknya
      } else {
       System.out.println("Jumlah stok tidak boleh negatif.");
      }

      // jika tidak memasukkan angka sesuai syarat
     } else {
      System.out.println("Masukkan angka yang valid.");
     }
    }

    // deklarasi variabel update an stok
    int stokSaatIni = Integer.parseInt(obat[1]);
    // mengubah nilai di indeks ke-1 dari array obat dengan hasil penjumlahan stok
    // saat ini.
    obat[1] = Integer.toString(stokSaatIni + jumlah);
    // jika variabel ditemukan bersifat true
    ditemukan = true;
    System.out.println("----------------------------------------------------------");
    System.out.println("Stok " + obat[0] + " ditambahkan sebanyak : " + jumlah);
    System.out.println("Jumlah stok saat ini: " + obat[1]);
    break;
   }
  }

  // jika variabel yang ditemukan tidak sesuai
  if (!ditemukan) {
   System.out.println("Obat tidak ditemukan dalam daftar stok.");
  }
 }

 // Fitur ke 3 fitur stok obat dari fitur admin, update pengurangan stok obat
 // menggunakan array 2 dimensi
 private static void kurangiStok(String[][] obatList) {
  System.out.print("\nMasukkan nama obat untuk mengurangi stok (obat....): ");
  // deklarasi scanner baru khusus fitur update pengurangan stok obat
  Scanner scanner1 = new Scanner(System.in);
  // input nama obat
  String nama = scanner1.nextLine();
  // jika variabel boolean tidak ditemukan
  boolean ditemukan = false;

  // perulangan serta array 1 dimensi
  for (String[] obat : obatList) {
   // jika inputan nama obat sesuai nama obat yang tertera
   if (obat[0].equalsIgnoreCase(nama)) {
    // jika variabel boolean tidak ditemukan
    boolean inputValid = false;
    // deklarasi jumlah berupa angka dimulai dari 0
    int jumlah = 0;

    // perulangan while dengan kondisi variabel inputValid tidak sesuai
    while (!inputValid) {
     System.out.print("\nMasukkan jumlah yang akan dikurangi dari stok " + obat[0] + ": ");
     // input Jumlah obat
     String inputJumlah = scanner1.nextLine();

     // Jika nilai dari inputJumlah adalah sebuah string yang terdiri dari satu atau
     // lebih digit (0-9), maka program akan lanjut ke kode didalam {}
     if (inputJumlah.matches("\\d+")) {
      jumlah = Integer.parseInt(inputJumlah);
      int stokSaatIni = Integer.parseInt(obat[1]);

      // jika jumlah lebih banyak sama dengan 0 dan jumlah lebih kecil sama dengan
      // variabel stok saat ini
      if (jumlah >= 0 && jumlah <= stokSaatIni) {
       inputValid = true;

       // jika jumlah tidak sesuai yang tertera diatas
      } else {
       System.out
         .println("Jumlah tidak valid. Tidak boleh negatif atau lebih dari stok saat ini.");
      }
     } else {
      System.out.println("Masukkan angka yang valid.");
     }
    }

    // update an pengurangan stok obat
    // mengambil nilai dari elemen array obat pada indeks 1 dan mengubahnya ke tipe
    // data int
    int stokSaatIni = Integer.parseInt(obat[1]);
    obat[1] = Integer.toString(stokSaatIni - jumlah);
    ditemukan = true;
    System.out.println("Stok " + obat[0] + " dikurangi sebanyak : " + jumlah);
    System.out.println("Jumlah stok saat ini: " + obat[1]);
    break;
   }
  }

  // jika variabel ditemukan tidak sesuai
  if (!ditemukan) {
   System.out.println("Obat tidak ditemukan dalam daftar stok.");
  }
 }

 // memasuki fitur kadaluwarsa, salah satu fitur admin
 private static void fiturIdentifikasiKadaluwarsa() {
  // deklarasi scanner khusus fitur kadaluwarsa
  Scanner input = new Scanner(System.in);
  // deklarasi variabel
  char Tgl_Kadaluwarsa, metode_pembuangan;
  boolean ulangLagi = true;

  do {
  System.out.println("\nObat kadaluwarsa? \na.Iya \nb.Tidak");
  System.out.print("Masukkan disini (a) / (b) : ");
  // input iya apa tidak
  Tgl_Kadaluwarsa = input.next().charAt(0);

  // jika inputan = A
  if (Tgl_Kadaluwarsa == 'a') {
   System.out.println("\nPilih metode pembuangan :\na) Penghancuran dengan penghancur obat khusus,\nb) Pengembalian ke pemasok obat, \nc) Pembuangan di tempat pembuangan obat yang aman,yang biasanya dikelola oleh pemerintah setempat.");
   System.out.print("Pilih salah satu : ");
   metode_pembuangan = input.next().charAt(0);

   // nested if
   // inputan pilihan metode pembuangan jika pilih A
   if (metode_pembuangan == 'a') {
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
    break;
   }

   // inputan pilihan metode pembuangan jika pilih B
   else if (metode_pembuangan == 'b') {
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
    break;

    // inputan pilihan metode pembuangan jika pilih C
   } else if (metode_pembuangan == 'c') {
    System.out.println("------------------------------------------------------------------------");
    System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
    break;

    // inputan pilihan metode pembuangan jika tidak memilih A/B/C
   } else {
    System.out.println("----------------------------------------------------");
    System.out.println("Terjadi Kesalahan! Pilih sesuai yang tertera!"); //metode pembuangan
    System.out.println(".....Kembali ke pertanyaan obat kadaluwarsa....");
    ulangLagi = false;
   }
  }

  // jika inputan pilihan b
  else if (Tgl_Kadaluwarsa == 'b') {
    System.out.println("------------------------");
   System.out.println("Obat masih valid.");
   System.out.println(".....keluar.....");
  }

  // jika inputan pilihan bukan a/b
  else {
    System.out.println("----------------------------------------------------");
   System.out.println("Terjadi Kesalahan! Pilih sesuai yang tertera!"); // Obat kadaluwarsa iya apa tidak
   ulangLagi = false;
  }
 } while (!ulangLagi);
 System.out.println();
}



 // memasuki fitur pembayaran, fitur utama USER
 private static void fiturPembayaran() {
  Scanner sc = new Scanner(System.in);
  int total = 0;
  String[] jenisObatan = { "Obat Batuk", "Obat Pilek", "Obat Pusing" };
  String pilihObatLagi;
  boolean memilihObatLagi;
  
  

  do {
   System.out.println("\nDaftar Jenis Obat di Apotek:");
   for (int i = 0; i < jenisObatan.length; i++) {
    System.out.println((i + 1) + ". " + jenisObatan[i]);
   }

   System.out.print("Masukkan nomor jenis obat yang ingin Anda pilih: ");
   int nomorJenisObat = sc.nextInt();

   if (nomorJenisObat >= 1 && nomorJenisObat <= jenisObatan.length) {
    String namaJenisObat = jenisObatan[nomorJenisObat - 1];
    System.out.println("Anda memilih jenis obat: " + namaJenisObat);

    String[] namaObat;
    // array 1 dimensi integer harga obat
    int[] hargaObat;

    // jika nama jenis obat batuk, maka akan ditampilkan array 1 dimensi merk obat
    // serta harga obat yang tertera
    if (namaJenisObat.equals("Obat Batuk")) {
     namaObat = new String[] { "Actifed cough", "Woods Antitussive", "Sanadryl DMP",
       "Siladex Antitussive", "Vicks Formula 44 Syrup", "Benadryl Original",
       "Bodrex Flu & Batuk PE", "Konidin", "Anadex", "Vectrine Dry Syrup" };
     hargaObat = new int[] { 20000, 25000, 22000, 18000, 30000, 19000, 21000, 28000, 24000, 26000 };

     // jika nama jenis obat pilek, maka akan ditampilkan array 1 dimensi merk obat
     // serta harga obat yang tertera
    } else if (namaJenisObat.equals("Obat Pilek")) {
     namaObat = new String[] { "Actifed Plus Expectorant", "Siladex Batuk dan Pilek",
       "Triaminic Expectorant & Pilek", "OBH Tropica Extra", "Pim-Tra-Kol", "Po Loong Pills",
       "Nalgestan", "Triaminic Batuk & Pilek", "Paratusin", "Silex" };
     hargaObat = new int[] { 22000, 26000, 23000, 21000, 25000, 27000, 24000, 20000, 23000, 25000 };

     // jika nama jenis obat pusing, maka akan ditampilkan array 1 dimensi merk obat
     // serta harga obat yang tertera
    } else {
     namaObat = new String[] { "Puyer Bintang Toedjoe", "Panadol Extra Tablet", "Bodrex", "Paramex",
       "Poldan Mig", "Tolak Angin Tablet", "Biogesic", "Decolgen Fx Tablet", "Pamol" };
     hargaObat = new int[] { 15000, 18000, 16000, 20000, 19000, 17000, 21000, 22000, 17000 };
    }

    // mencetak Daftar nama obat untuk jenis dengan menambahkan nilai dari
    // namaJenisObat
    System.out.println("\nDaftar Nama Obat untuk jenis " + namaJenisObat + ":");
    // perulangan for inisialisasi indeks = 0, kondisi integer lebih kecil dari
    // namaObat, serta i increment
    for (int i = 0; i < namaObat.length; i++) {
     System.out.println((i + 1) + ". " + namaObat[i] + " - Harga: Rp." + hargaObat[i] + ",-");
    }

    System.out.print("Masukkan nomor obat yang Anda pilih: ");
    int nomorObat1 = sc.nextInt();

    // jika nomorObat1 lebih besar sama dengan 1 dan nomorObat1 lebih kecil sama
    // dengan panjang namaObat
    if (nomorObat1 >= 1 && nomorObat1 <= namaObat.length) {

     // mengambil nama obat yang terkait dengan nomor obat yang telah dipilih
     String obatTerpilih = namaObat[nomorObat1 - 1];
     int hargaTerpilih = hargaObat[nomorObat1 - 1];
     System.out.println("\n" + "Obat yang Anda pilih adalah: " + obatTerpilih);
     System.out.println("Harga obat yang Anda pilih: Rp." + hargaTerpilih + ",-");
     System.out.println("-----------------------------------");
     total += hargaTerpilih;
     System.out.println("Total semua harga obat yang dipesan : Rp." + total + ",-");

     // jika nomor obat tidak sesuai yang tertera
    } else if (nomorObat1 > namaObat.length) {
     System.out.println("\nMohon pilih nomor obat yang benar! Pesanan obat anda akan hangus jika memasukkan nomor obat yang salah!");
     break;
     
    }

    // Tanya pengguna apakah ingin membeli obat lain
    
    memilihObatLagi = true;
    pilihObatLagi = String.valueOf(memilihObatLagi);
    System.out.print("Apakah Anda ingin memesan obat lagi (y/t)? : ");
    pilihObatLagi = sc.next();
     
     if (pilihObatLagi.equalsIgnoreCase("y")) {
      memilihObatLagi = true;
     }







     else if (pilihObatLagi.equalsIgnoreCase("t")) {
      boolean cobaLagi = true;
      do {
      if (total < 100000 ) {
        System.out.println("\nTotal akhir semua harga obat pesanan Anda : Rp." + total + ",-");
        System.out.println("Silahkan melakukan transaksi pembayaran via cash/debit/credit/Qris dll dengan penjaga kasir! ");
      break;
      }

      else if (total >= 100000 ) {
       // DISKON DAN KARTU MEMBER
      // nested if
      // jika total harga lebih besar dari 100.000

   System.out.print("\nApakah Anda ingin mendapatkan diskon (y/t)? ");
   String inginDiskonInput = sc.next();

   // nested if
   // jika inputan ingin diskon pilih y
   if (inginDiskonInput.equalsIgnoreCase("y")) {
    System.out.print("\nApakah Anda mempunyai kartu member (y/t)? ");
    String kartuMember = sc.next();
    double dis = 0;
    int poin = 0;

    if (kartuMember.equalsIgnoreCase("y")) {
      if (total >= 100000 && total <= 500000) {
      if (total < 200000) {
       dis = 0.2;
       poin = 5;
      } else if (total < 300000) {
       dis = 0.25;
       poin = 10;
      } else if (total < 400000) {
       dis = 0.3;
       poin = 15;
      } else if (total <= 500000) {
       dis = 0.35;
       poin = 20;
      }
      double diskonAmount = total * dis;
      System.out.println("Selamat! Anda mendapatkan diskon " + (dis * 100) + "% & tambahan poin " + poin + "! [Doorprize = 50++ poin]" );
      System.out.println("----------------------------------------------------");
      System.out.println("Total harga yang harus anda bayar adalah : " + (total - (total * dis)));
     }
    
    

    // jika inputan ingin diskon pilih t
  } else if (kartuMember.equalsIgnoreCase("t")) {
      // jika tidak punya kartu member, daftar dulu
      System.out.println("\nDAFTAR SEKARANG! ISI BIODATA ANDA! ");
      System.out.print("Nama (Isi nama panggilan): ");
      String nama = sc.next();
      System.out.print("Umur (Isi angka saja): ");
      String umur = sc.next();
      System.out.print("Tempat lahir (kota saja): ");
      String tmptLahir = sc.next();
      System.out.print("Tanggal lahir (Angka saja): ");
      int TglLahir = sc.nextInt();
      System.out.print("Bulan (ketik huruf): ");
      String bulan = sc.next();
      System.out.print("Tahun (angka saja) : ");
      int tahun = sc.nextInt();
      System.out.print("Email: ");
      String email = sc.next();
      System.out.print("Password (Huruf saja,tanpa spasi): ");
      String password = sc.next();
      System.out.println("------------------------------------------");
      System.out.println("Selamat! dengan pengguna " + nama + " telah menjadi Member Premium!");

        // jika kondisi total lebih besar sama dengan 100.000 dan total lebih kecil sama
        // dengan 500.000
        if (total >= 100000 && total <= 500000) {
          // nested if
          // jika kondisi total lebih kecil dari 200.000

          if (total < 200000) {
          // diskon nya bernilai awal 0.2
          dis = 0.2;
          // poin bernilai awal 5
          poin = 5;

          // jika total lebih kecil dari 300.000
          } else if (total < 300000) {
          // diskon nya bernilai awal 0.25
          dis = 0.25;
          // poin bernilai awal 10
          poin = 10;

          // jika total lebih kecil dari 400.000
          } else if (total < 400000) {
          // diskon nya bernilai awal 0.3
          dis = 0.3;
          // poin bernilai awal 15
          poin = 15;

          // jika total lebih kecil sama dengan 500.000
          } else if (total <= 500000) {
          // diskon nya bernilai awal 0.35
          dis = 0.35;
          // poin bernilai awal 20
          poin = 20;
          }
          

      double diskonAmount = total * dis;
    System.out.println("Pengguna dengan nama " + nama + " mendapatkan diskon " + (dis * 100) + "% & tambahan poin " + poin + "! [Doorprize = 50++ poin]"); 
    System.out.println("----------------------------------------------------");
      System.out.println("Total harga yang harus anda bayar adalah : " + (total - (total * dis)));
     }


     // nested if
     // jika punya kartu member
    } else {
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      System.out.println("INPUT PILIHAN YANG BENAR! (y) / (t)! ");
      System.out.println("...kembali ke pertanyaan diskon....");
      cobaLagi = false;
    }

   } else if (inginDiskonInput.equalsIgnoreCase("t")) {
        System.out.println("Total harga yang harus dibayar sebanyak : Rp." + total + ",-");
        System.out.println("Silahkan melakukan transaksi pembayaran via cash/debit/credit/Qris dll dengan penjaga kasir! ");
      
      
      } else {
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    System.out.println("SILAHKAN INPUT YANG BENAR! (y) / (t)!");
    cobaLagi = false;
   }
  }


} while (!cobaLagi);
System.out.println();



  // Terima kasih setelah selesai pembelian
  System.out.println("-----------------------------------------------------------------");
  System.out.println("Terima kasih telah melakukan pembelian di apotek kami! Have a great day!");
  break;
      }
     
   
     else {
      System.out.println("\n Pilih (y) / (t) saja. Lakukan lagi!");
     }
   
    

   } 
  else {
    System.out.println("Nomor obat tidak valid. Silakan coba lagi.");
    pilihObatLagi = "true";
    memilihObatLagi = Boolean.parseBoolean(pilihObatLagi);
    memilihObatLagi = true;
   }
  
  } while (memilihObatLagi);
  System.out.println();
  
 }
 
}