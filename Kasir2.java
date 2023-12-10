import java.util.Scanner;
import java.util.HashMap;

public class Kasir2 {
 private static final String ADMIN_PASSWORD = "admin123";
 private static final Scanner scanner = new Scanner(System.in);
 private static HashMap<String, Integer> stokObat = new HashMap<>();
 private static int totalTransaksiPembayaran = 0;
 private static int[] totalTransaksi = new int[100];
 private static int[] totalPembelian = new int[100];
 private static int indeksTransaksi = 0;

 public static void main(String[] args) {
  inisialisasiStokObat();
  boolean ulangProgram = true;

  do {
   System.out.println("Selamat datang di Aplikasi Apotek!");
   System.out.println("==== Selamat Berbelanja! ====");
   System.out.println("--------------------------------------------");
   System.out.print("Apakah Anda pengguna (1) | admin (2)? ");

   int multi = scanner.nextInt();

   if (multi == 1) {
    fiturUser();
   } else if (multi == 2) {
    fiturAdmin();
   } else {
    System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
    break;
   }

   ulangProgram = tanyaUlangProgram();
  } while (ulangProgram);
  System.out.println("Terima kasih telah menggunakan Aplikasi Apotek. Sampai jumpa lagi!");
 }

 private static void inisialisasiStokObat() {
  stokObat.put("Batuk", 20);
  stokObat.put("Pilek", 20);
  stokObat.put("Pusing", 20);
  // Tambahkan obat lainnya sesuai kebutuhan
 }

 private static void fiturAdmin() {
  System.out.print("\nMasukkan password admin: ");
  String password = scanner.next();

  if (password.equals(ADMIN_PASSWORD)) {
   int adminChoice;
   do {
    System.out.println("\n--- Fitur Admin ---");
    System.out.println("1. Kelola Stok Obat");
    System.out.println("2. Identifikasi Kadaluwarsa");
    System.out.println("3. Total Transaksi");
    System.out.println("4. Kembali ke menu utama");
    System.out.println("5. Keluar");
    System.out.print("Masukkan pilihan Anda: ");
    adminChoice = scanner.nextInt();

    switch (adminChoice) {
     case 1:
      fiturKelolaStokObat();
      break;
     case 2:
      fiturIdentifikasiKadaluwarsa();
      break;
     case 3:
      lihatTotalTransaksi();
      break;
     case 4:
      return;
     case 5:
      System.exit(0);
      break;
     default:
      System.out.println("Pilihan tidak sesuai, Coba lagi!");
    }
   } while (adminChoice != 4);
  } else {
   System.out.println("Password salah. Aplikasi akan ditutup.");
  }
 }

 // Metode fiturKelolaStokObat, fiturIdentifikasiKadaluwarsa,
 // lihatTotalTransaksi, fiturUser, dan lainnya
 private static void fiturKelolaStokObat() {
  int pilihan;
  String[][] stokObat = {
    { "Batuk", "20" },
    { "Pilek", "20" },
    { "Pusing", "20" }
  };

  do {
   System.out.println("\n--- Menu Kelola Stok Obat ---");
   System.out.println("1. Tampilkan Detail Stok Obat");
   System.out.println("2. Tambah Stok Obat");
   System.out.println("3. Kurangi Stok Obat");
   System.out.println("4. Kembali ke menu");
   System.out.println("5. Keluar");
   System.out.print("\nMasukkan pilihan Anda: ");
   pilihan = scanner.nextInt();

   switch (pilihan) {
    case 1:
     tampilkanDetailStok(stokObat);
     break;
    case 2:
     tambahStok(stokObat);
     break;
    case 3:
     kurangiStok(stokObat);
     break;
    case 4:
     System.out.println("----------------------------");
     System.out.println("...kembali ke menu...");
     return;
    case 5:
     System.out.println("..Keluar..");
     System.exit(0);
     break;
    default:
     System.out.println("Pilihan tidak valid, harap masukkan angka 1-4!");
   }
  } while (pilihan != 5);

  scanner.close();
 }

 private static void tampilkanDetailStok(String[][] obatList) {
  System.out.println("\nDetail Stok Obat:");
  for (String[] obat : obatList) {
   int stok = Integer.parseInt(obat[1]);
   System.out.println("Obat: " + obat[0] + ", Stok: " + stok);

   for (int i = 0; i < stok; i++) {
    System.out.print("*");
   }
   System.out.println();
  }

 }

 private static void tambahStok(String[][] obatList) {
  System.out.print("\nMasukkan nama obat untuk menambah stok : ");
  String nama = scanner.nextLine();
  boolean ditemukan = false;

  for (String[] obat : obatList) {
   if (obat[0].equalsIgnoreCase(nama)) {
    boolean inputValid = false;
    int jumlah = 0;

    while (!inputValid) {
     System.out.print("\nMasukkan jumlah stok yang akan ditambahkan untuk " + obat[0] + ": ");

     String inputJumlah = scanner.nextLine();
     if (inputJumlah.matches("\\d+")) {
      jumlah = Integer.parseInt(inputJumlah);

      if (jumlah >= 0) {
       inputValid = true;
      } else {
       System.out.println("Jumlah stok tidak boleh negatif.");
      }

     } else {
      System.out.println("Masukkan angka yang valid.");
     }
    }

    int stokSaatIni = Integer.parseInt(obat[1]);
    obat[1] = Integer.toString(stokSaatIni + jumlah);
    ditemukan = true;
    System.out.println("----------------------------------------------------------");
    System.out.println("Stok " + obat[0] + " ditambahkan sebanyak : " + jumlah);
    System.out.println("Jumlah stok saat ini: " + obat[1]);
    return;
   }
  }

  if (!ditemukan) {
   System.out.println("Obat tidak ditemukan dalam daftar stok.");
  }
  scanner.close();
 }

 private static void kurangiStok(String[][] obatList) {
  System.out.print("\nMasukkan nama obat untuk mengurangi stok : ");
  String nama = scanner.nextLine();
  boolean ditemukan = false;

  for (String[] obat : obatList) {
   if (obat[0].equalsIgnoreCase(nama)) {
    boolean inputValid = false;
    int jumlah = 0;

    while (!inputValid) {
     System.out.print("\nMasukkan jumlah yang akan dikurangi dari stok " + obat[0] + ": ");
     String inputJumlah = scanner.nextLine();

     if (inputJumlah.matches("\\d+")) {
      jumlah = Integer.parseInt(inputJumlah);
      int stokSaatIni = Integer.parseInt(obat[1]);

      if (jumlah >= 0 && jumlah <= stokSaatIni) {
       inputValid = true;
       break;

      } else {
       System.out
         .println("Jumlah tidak valid. Tidak boleh negatif atau lebih dari stok saat ini.");
      }
     } else {
      System.out.println("Masukkan angka yang valid.");
     }
    }

    int stokSaatIni = Integer.parseInt(obat[1]);
    obat[1] = Integer.toString(stokSaatIni - jumlah);
    ditemukan = true;
    System.out.println("Stok " + obat[0] + " dikurangi sebanyak : " + jumlah);
    System.out.println("Jumlah stok saat ini: " + obat[1]);
    return;
   }
  }

  if (!ditemukan) {
   System.out.println("Obat tidak ditemukan dalam daftar stok.");
  }
  scanner.close();
 }

 private static void fiturIdentifikasiKadaluwarsa() {
  Scanner input = new Scanner(System.in);
  char Tgl_Kadaluwarsa, metode_pembuangan;
  boolean ulangLagi = true;

  do {
   System.out.println("\n--- Menu kelola obat kadaluwarsa ---");
   System.out.println("Obat kadaluwarsa? | a.Iya | b.Tidak |");
   System.out.print("Masukkan disini (a) / (b) : ");
   Tgl_Kadaluwarsa = input.next().charAt(0);

   if (Tgl_Kadaluwarsa == 'a') {
    System.out.println(
      "\nPilih metode pembuangan :\na) Penghancuran dengan penghancur obat khusus,\nb) Pengembalian ke pemasok obat, \nc) Pembuangan di tempat pembuangan obat yang aman,yang biasanya dikelola oleh pemerintah setempat.");
    System.out.print("Pilih salah satu : ");
    metode_pembuangan = input.next().charAt(0);

    if (metode_pembuangan == 'a') {
     System.out.println("------------------------------------------------------------------------");
     System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
     System.exit(0);
    }

    else if (metode_pembuangan == 'b') {
     System.out.println("------------------------------------------------------------------------");
     System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
     System.exit(0);

    } else if (metode_pembuangan == 'c') {
     System.out.println("------------------------------------------------------------------------");
     System.out.println("Pilihan anda akan disampaikan kepada pihak pengelola, terimakasih.");
     System.exit(0);

    } else {
     System.out.println("----------------------------------------------------");
     System.out.println("Terjadi Kesalahan! Pilih sesuai yang tertera!");
     System.out.println("\n.....Kembali ke pertanyaan obat kadaluwarsa....");
     ulangLagi = false;
    }
   } else if (Tgl_Kadaluwarsa == 'b') {
    System.out.println("------------------------");
    System.out.println("Obat masih valid.");
    System.out.println(".....keluar.....");
    System.exit(0);
   } else {
    System.out.println("----------------------------------------------------");
    System.out.println("Terjadi kesalahan! Pilih sesuai yang tertera!"); // Obat kadaluwarsa iya apa tidak
    ulangLagi = false;
   }
  } while (!ulangLagi);
  System.out.println();

  input.close();
 }

 private static void lihatTotalTransaksi() {
  System.out.println("\n---  Menu Total Transaksi ---");
  for (int i = 0; i < indeksTransaksi; i++) {
   System.out.println("\nTransaksi ke-" + (i + 1) + ": Rp." + totalPembelian[i] + ",-");

   if (totalPembelian[i] > 100000) {
    double diskon = hitungDiskon(totalPembelian[i]);
    double hargaSebelumDiskon = totalPembelian[i];
    double hargaSetelahDiskon = hargaSebelumDiskon - (hargaSebelumDiskon * diskon);

    System.out.println("  Harga Sebelum Diskon: Rp." + hargaSebelumDiskon + ",-");
    System.out.println("  Diskon " + (diskon * 100) + "%: Rp." + (hargaSebelumDiskon * diskon) + ",-");
    System.out.println("  Harga Sesudah Diskon: Rp." + hargaSetelahDiskon + ",-");
   }
  }

  int totalKeseluruhan = 0;
  for (int i = 0; i < indeksTransaksi; i++) {
   totalKeseluruhan += totalPembelian[i];
  }
  System.out.println("==================================================");
  System.out.println("Total Keseluruhan: Rp." + totalKeseluruhan + ",-");
  System.exit(0);
 }

 private static void fiturUser() {
  System.out.println("\n--- Fitur User ---");
  System.out.println("(1) Yuk, Berbelanja!  || (2) ..Yah Sampai Jumpa..");
  System.out.print("Masukkan pilihan Anda: ");
  int userChoice = scanner.nextInt();

  switch (userChoice) {
   case 1:
    fiturPembayaran();
    break;
   case 2:
    System.out.println("======================================");
    System.out.println("Terimakasih! Bye bye~ ^_^");
    System.exit(0);

   default:
    System.out.println("Pilihan tidak sesuai (2) / (1). Aplikasi akan ditutup.");
    System.exit(0);
  }

 }

 private static int fiturPembayaran() {
  int total = 0;
  String[] jenisObatan = { "Obat Batuk", "Obat Pilek", "Obat Pusing" };
  String pilihObatLagi;
  boolean mengulang = false;
  boolean memilihObatLagi;

  do {
   System.out.println("\nDaftar Jenis Obat di Apotek:");
   for (int i = 0; i < jenisObatan.length; i++) {
    System.out.println((i + 1) + ". " + jenisObatan[i]);
   }
   System.out.print("Masukkan nomor jenis obat yang ingin Anda pilih: ");
   int nomorJenisObat = scanner.nextInt();

   if (nomorJenisObat >= 1 && nomorJenisObat <= jenisObatan.length) {
    String namaJenisObat = jenisObatan[nomorJenisObat - 1];
    System.out.println("Anda memilih jenis obat: " + namaJenisObat);
    String[] namaObat;
    int[] hargaObat;

    if (namaJenisObat.equals("Obat Batuk")) {
     namaObat = new String[] { "Actifed cough", "Woods Antitussive", "Sanadryl DMP",
       "Siladex Antitussive", "Vicks Formula 44 Syrup", "Benadryl Original",
       "Bodrex Flu & Batuk PE", "Konidin", "Anadex", "Vectrine Dry Syrup" };
     hargaObat = new int[] { 20000, 25000, 22000, 18000, 30000, 19000, 21000, 28000, 24000, 26000 };

    } else if (namaJenisObat.equals("Obat Pilek")) {
     namaObat = new String[] { "Actifed Plus Expectorant", "Siladex Batuk dan Pilek",
       "Triaminic Expectorant & Pilek", "OBH Tropica Extra", "Pim-Tra-Kol", "Po Loong Pills",
       "Nalgestan", "Triaminic Batuk & Pilek", "Paratusin", "Silex" };
     hargaObat = new int[] { 22000, 26000, 23000, 21000, 25000, 27000, 24000, 20000, 23000, 25000 };

    } else {
     namaObat = new String[] { "Puyer Bintang Toedjoe", "Panadol Extra Tablet", "Bodrex", "Paramex",
       "Poldan Mig", "Tolak Angin Tablet", "Biogesic", "Decolgen Fx Tablet", "Pamol" };
     hargaObat = new int[] { 15000, 18000, 16000, 20000, 19000, 17000, 21000, 22000, 17000 };
    }

    do {
     System.out.println("\n\nDaftar Nama Obat untuk jenis " + namaJenisObat + ":\n");
     for (int i = 0; i < namaObat.length; i++) {
      System.out.println((i + 1) + "." + namaObat[i] + "\nHarga: Rp." + hargaObat[i] + ",-\n");
     }

     System.out.print("Masukkan nomor obat yang Anda pilih: ");
     int nomorObat1 = scanner.nextInt();

     if (nomorObat1 >= 1 && nomorObat1 <= namaObat.length) {
      String obatTerpilih = namaObat[nomorObat1 - 1];
      int hargaTerpilih = hargaObat[nomorObat1 - 1];
      System.out.println("\n" + "Obat yang Anda pilih adalah: " + obatTerpilih);
      System.out.println("Harga obat yang Anda pilih: Rp." + hargaTerpilih + ",-");
      System.out.println("-----------------------------------");
      total += hargaTerpilih;
      System.out.println("Total semua harga obat yang dipesan : Rp." + total + ",-");
      break;
     } else {
      System.out.println(
        "\nMohon pilih nomor obat yang benar! Pesanan obat anda akan hangus jika memasukkan nomor obat yang salah!");
      System.out.println("\n1. Kembali ke awal program");
      System.out.println("2. Keluar ");
      System.out.print("Pilihan Anda: ");
      int pilihan = scanner.nextInt();

      if (pilihan == 1) {
       System.out.println();
      } else if (pilihan == 2) {
       System.out.println("...Terimakasih....");
       System.exit(0);
      } else {
       System.out.println("Pilihan tidak valid. Aplikasi akan ditutup.");
       System.exit(0);
      }
     }
    } while (!mengulang);
    memilihObatLagi = true;
    pilihObatLagi = String.valueOf(memilihObatLagi);
    System.out.print("Apakah Anda ingin memesan obat lagi (y/t)? : ");
    pilihObatLagi = scanner.next();

    if (pilihObatLagi.equalsIgnoreCase("y")) {
     memilihObatLagi = true;
    }

    else if (pilihObatLagi.equalsIgnoreCase("t")) {
     boolean cobaLagi = true;
     do {

      if (total < 100000) {
       System.out
         .println("Silahkan melakukan transaksi pembayaran via cash/debit/credit/Qris dll dengan penjaga kasir! ");
       break;
      } else if (total >= 100000) {
       System.out.print("\nApakah Anda ingin mendapatkan diskon (y/t)? ");
       String inginDiskonInput = scanner.next();

       if (inginDiskonInput.equalsIgnoreCase("y")) {
        System.out.print("\nApakah Anda mempunyai kartu member (y/t)? ");
        String kartuMember = scanner.next();
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

          System.out.println("Selamat! Anda mendapatkan diskon " + (dis * 100) + "% & tambahan poin " + poin
            + "! [Doorprize = 50++ poin]");
          System.out.println("----------------------------------------------------");
          System.out.println("Total harga yang harus anda bayar adalah : " + (total - (total * dis)));
         }

        } else if (kartuMember.equalsIgnoreCase("t")) {
         System.out.println("\nDAFTAR SEKARANG! ISI BIODATA ANDA! ");
         System.out.print("Nama (Isi nama panggilan): ");
         String nama = scanner.next();
         System.out.print("Umur (Isi angka saja): ");
         String umur = scanner.next();
         System.out.print("Tempat lahir (kota saja): ");
         String tmptLahir = scanner.next();
         System.out.print("Tanggal lahir (Angka saja): ");
         int TglLahir = scanner.nextInt();
         System.out.print("Bulan (ketik huruf): ");
         String bulan = scanner.next();
         System.out.print("Tahun (angka saja) : ");
         int tahun = scanner.nextInt();
         System.out.print("Email: ");
         String email = scanner.next();
         System.out.print("Password (Huruf saja,tanpa spasi): ");
         String password = scanner.next();
         System.out.println("------------------------------------------");
         System.out.println("Selamat! dengan pengguna " + nama + " telah menjadi Member Premium!");

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

          System.out.println("Pengguna dengan nama " + nama + " mendapatkan diskon " + (dis * 100)
            + "% & tambahan poin " + poin + "! [Doorprize = 50++ poin]");
          System.out.println("----------------------------------------------------");
          System.out.println("Total harga yang harus anda bayar adalah : " + (total - (total * dis)));
         }

        } else {
         System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
         System.out.println("INPUT PILIHAN YANG BENAR! (y) / (t)! ");
         System.out.println("...kembali ke pertanyaan diskon....");
         cobaLagi = false;
        }
       } else if (inginDiskonInput.equalsIgnoreCase("t")) {
        System.out.println("Total harga yang harus dibayar sebanyak : Rp." + total + ",-");
        System.out
          .println("Silahkan melakukan transaksi pembayaran via cash/debit/credit/Qris dll dengan penjaga kasir! ");
       } else {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("SILAHKAN INPUT YANG BENAR! (y) / (t)!");
        cobaLagi = false;
       }
      }

     } while (!cobaLagi);
     System.out.println();
     // Menyimpan total pembelian pada array totalPembelian
     totalPembelian[indeksTransaksi] = total;

     // Menyimpan total transaksi pada array totalTransaksi
     totalTransaksi[indeksTransaksi++] = totalTransaksiPembayaran += total;

     System.out.println("-----------------------------------------------------------------");
     System.out.println("Terima kasih telah melakukan pembelian di apotek kami! Have a great day!");
     break;
    } else {
     System.out.println("\n Pilih (y) / (t) saja. Lakukan lagi!");
    }
   } else {
    System.out.println("Nomor obat tidak valid. Silakan coba lagi.");
    pilihObatLagi = "true";
    memilihObatLagi = Boolean.parseBoolean(pilihObatLagi);
    memilihObatLagi = true;
   }
  } while (memilihObatLagi);
  System.out.println();

  return total;

 }

 private static double hitungDiskon(int totalPembelian) {
  double diskon = 0;

  if (totalPembelian >= 100000 && totalPembelian <= 500000) {
   if (totalPembelian < 200000) {
    diskon = 0.2;
   } else if (totalPembelian < 300000) {
    diskon = 0.25;
   } else if (totalPembelian < 400000) {
    diskon = 0.3;
   } else if (totalPembelian <= 500000) {
    diskon = 0.35;
   }
  }
  return diskon;
 }

 private static boolean tanyaUlangProgram() {
  System.out.print("\nApakah Anda ingin memulai kembali program? (y/t): ");
  char pilihan = scanner.next().charAt(0);
  return pilihan == 'y' || pilihan == 'Y';
 }
}
