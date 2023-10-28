import java.util.Scanner;

public class ArrayAnalysis {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Input banyaknya elemen
        System.out.print("Masukkan banyaknya elemen: ");
        int n = input.nextInt();

        int[] array = new int[n];

        // Input value tiap elemen
        for (int i = 0; i < n; i++) {
            System.out.print("Masukkan elemen ke-" + (i + 1) + ": ");
            array[i] = input.nextInt();
        }

        // Inisialisasi value tertinggi, terendah, dan total untuk rata-rata
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

        // Output nilai tertinggi, terendah, dan rata-rata
        System.out.println("Nilai tertinggi: " + max);
        System.out.println("Nilai terendah: " + min);
        System.out.println("Nilai rata-rata: " + average);
    }
}
