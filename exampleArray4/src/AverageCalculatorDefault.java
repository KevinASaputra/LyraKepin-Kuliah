import java.util.Scanner;

public class AverageCalculatorDefault {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[8];
        int sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Masukkan bilangan ke-" + (i + 1) + ": ");
            numbers[i] = input.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / numbers.length;
        System.out.println("Rata-rata dari bilangan tersebut adalah: " + average);
    }
}
