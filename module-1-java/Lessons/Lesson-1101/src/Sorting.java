import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] array = {600, 7, -4, 23, 590, -4, -45, 45, -4, 6, 0};
        bubbleSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void bubbleSort(int[] array) {
        int buffer;
        for (int i = 0; i < array.length; i ++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
    }
}
