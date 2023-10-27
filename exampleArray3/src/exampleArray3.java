import java.util.Scanner;

public class exampleArray3 {
    public static void main(String[] args) {
        String[] months = {
                "Januari", "Februari", "Maret", "April", "Mei", "Juni",
                "Juli", "Agustus", "September", "Oktober", "November", "Desember"
        };

        Scanner input = new Scanner(System.in);
        int monthNumber;

        do {
            System.out.print("Masukkan angka (1-12): ");
            monthNumber = input.nextInt();

            if (monthNumber >= 1 && monthNumber <= 12) {
                System.out.println("Bulan: " + months[monthNumber - 1]);
                break;
            } else {
                System.out.println("Angka tidak valid. Silakan coba lagi.");
            }
        } while (true);
    }
}
