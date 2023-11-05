package lyra;

import java.util.Scanner;

public class BioskopWithScanner15 {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int baris = 10, kolom = 10, menuOption;
    String nama = null;
    String tambahKursi;

    // Inisialisasi array 2 dimensi sekali saja di luar loop
    String[][] penonton = new String[baris][kolom];
    Boolean[][] bookingKursi = new Boolean[baris][kolom];

    // Mengatur semua kursi menjadi belum dipesan (false)
    for (int i = 0; i < baris; i++) {
      for (int j = 0; j < kolom; j++) {
        bookingKursi[i][j] = false;
      }
    }

    do {
      System.out.println("---------------------------------");
      System.out.println("MENU:");
      System.out.println("1. Input data penonton");
      System.out.println("2. Tampilkan daftar penonton");
      System.out.println("3. Exit");
      System.out.println("~~~~~~~~");
      System.out.print("Pilih menu: ");
      menuOption = input.nextInt();
      input.nextLine(); // Consume newline left-over

      switch (menuOption) {
        case 1:
          // Input data penonton
          if (nama == null) {
            System.out.print("Masukkan Nama Penonton: ");
            nama = input.nextLine();
          }
          do {
            // Tampilkan status kursi
            for (int i = 0; i < baris; i++) {
              for (int j = 0; j < kolom; j++) {
                if (bookingKursi[i][j]) {
                  System.out.print("X "); // Kursi terisi
                } else {
                  System.out.print("O "); // Kursi kosong
                }
              }
              System.out.println(); // Pindah ke baris berikutnya
            }

            System.out.print("Masukkan baris (1-" + baris + "): ");
            int inputBaris = input.nextInt();
            System.out.print("Masukkan kolom (1-" + kolom + "): ");
            int inputKolom = input.nextInt();
            input.nextLine(); // Consume newline left-over

            // Memeriksa apakah kursi sudah terisi
            if (inputBaris >= 1 && inputBaris <= baris && inputKolom >= 1 && inputKolom <= kolom) {
              if (bookingKursi[inputBaris - 1][inputKolom - 1]) {
                System.out.println("Maaf, kursi ini sudah terisi. Silakan pilih kursi lain.");
              } else {
                bookingKursi[inputBaris - 1][inputKolom - 1] = true;
                penonton[inputBaris - 1][inputKolom - 1] = nama;
                System.out.println("Anda telah memilih kursi pada baris " + inputBaris + ", kolom " + inputKolom);
              }
            } else {
              System.out.println("Input baris atau kolom tidak valid. Silakan masukkan angka antara 1 dan " + baris
                  + " untuk baris, dan antara 1 dan " + kolom + " untuk kolom.");
            }
            System.out.println("Apakah anda ingin menambah kursi?? (Ya/Tidak)");
            tambahKursi = input.nextLine();
          } while (tambahKursi.equalsIgnoreCase("Ya"));
          break;

        case 2:
          System.out.println("--------------------------------");
          System.out.println("DAFTAR PENONTON:");
          for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
              if (penonton[i][j] != null) {
                System.out.println("Baris " + (i + 1) + ", Kolom " + (j + 1) + ": " + penonton[i][j]);
              }
            }
          }
          break;
        case 3:
          System.out.println("Program selesai.");
          break;
        default:
          System.out.println("Pilihan tidak valid. Silakan coba lagi.");
          break;
      }
    } while (menuOption != 3);

    input.close();
  }
}
