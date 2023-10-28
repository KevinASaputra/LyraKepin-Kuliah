import java.util.Scanner;

public class ArrayAnalysisWithMenu {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    // Input banyaknya elemen
    System.out.print("Masukkan banyaknya elemen: ");
    int n = input.nextInt();

    int[] array = new int[n];

    // Input nilai tiap elemen
    for (int i = 0; i < n; i++) {
      System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
      array[i] = input.nextInt();
    }

    // Inisialisasi nilai tertinggi, terendah, dan total untuk rata-rata
    int max = array[0];
    int min = array[0];
    int total = 0;

    for (int i = 0; i < n; i++) {
      if (array[i] > max) {
        max = array[i];
      }
      if (array[i] < min) {
        min = array[i];
      }
      total += array[i];
    }

    double average = (double) total / n;

    int choice;
    do {
      // Menu untuk memilih tampilan hasil
      System.out.println("\nPilih hasil yang ingin ditampilkan:");
      System.out.println("1. Nilai tertinggi");
      System.out.println("2. Nilai terendah");
      System.out.println("3. Nilai rata-rata");
      System.out.print("Masukkan pilihan Anda (1/2/3): ");
      choice = input.nextInt();

      switch (choice) {
        case 1:
          System.out.println("Nilai tertinggi: " + max);
          break;
        case 2:
          System.out.println("Nilai terendah: " + min);
          break;
        case 3:
          System.out.println("Nilai rata-rata: " + average);
          break;
        default:
          System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
      }
    } while (choice < 1 || choice > 3);
  }
}
