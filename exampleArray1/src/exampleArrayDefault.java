public class exampleArrayDefault {
  public static void main(String[] args) {
    int[] array = new int[60]; // Deklarasi array dengan 60 elemen

    // Mengisi elemen array dengan looping
    for (int i = 0; i < array.length; i++) {
      array[i] = i + 1; // Contoh pengisian dengan nilai i + 1
    }

    // Menampilkan elemen array
    for (int i = 0; i < array.length; i++) {
      System.out.println("Elemen ke-" + (i + 1) + ": " + array[i]);
    }
  }
}

// test