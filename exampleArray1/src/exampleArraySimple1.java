public class exampleArraySimple1 {
    public static void main(String[] args) {
        int[] array = new int[60];

        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
            System.out.println("Elemen ke-" + (i + 1) + ": " + array[i]);
        }
    }
}
