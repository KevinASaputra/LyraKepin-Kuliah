import java.util.Scanner;

public class ArrayAnalysisBestPractice {

  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      int[] array = getInputArray(scanner);
      displayResults(array);
    }
  }

  /**
   * Meminta pengguna untuk memasukkan elemen array.
   * 
   * @param scanner Scanner untuk membaca input
   * @return array yang diisi oleh pengguna
   */
  private static int[] getInputArray(Scanner scanner) {
    System.out.print("Masukkan banyaknya elemen: ");
    int n = scanner.nextInt();
    int[] array = new int[n];

    for (int i = 0; i < n; i++) {
      System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
      array[i] = scanner.nextInt();
    }
    return array;
  }

  /**
   * Menampilkan hasil analisis array: nilai tertinggi, terendah, dan rata-rata.
   * 
   * @param array array yang akan dianalisis
   */
  private static void displayResults(int[] array) {
    int max = findMax(array);
    int min = findMin(array);
    double average = findAverage(array);

    System.out.println("Nilai tertinggi: " + max);
    System.out.println("Nilai terendah: " + min);
    System.out.println("Nilai rata-rata: " + average);
  }

  private static int findMax(int[] array) {
    int max = array[0];
    for (int value : array) {
      if (value > max) {
        max = value;
      }
    }
    return max;
  }

  private static int findMin(int[] array) {
    int min = array[0];
    for (int value : array) {
      if (value < min) {
        min = value;
      }
    }
    return min;
  }

  private static double findAverage(int[] array) {
    int total = 0;
    for (int value : array) {
      total += value;
    }
    return (double) total / array.length;
  }
}
