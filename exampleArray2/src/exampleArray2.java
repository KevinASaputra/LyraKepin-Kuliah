public class exampleArray2 {
    public static void main(String[] args) {
        int[] array = new int[10];

        // isi elemnt array dulu
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }

        // reverse array output
        System.out.println("Isi array secara terbalik:");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.println(array[i]);
        }
    }
}
