import java.util.Scanner;

public class AverageCalculatorSimple {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    int sum = 0;

    for (int i = 0; i < 8; i++) {
      System.out.print("Masukkan bilangan ke-" + (i + 1) + ": ");
      sum += input.nextInt();
    }

    System.out.println("Rata-rata dari bilangan tersebut adalah: " + (double) sum / 8);
  }
}
