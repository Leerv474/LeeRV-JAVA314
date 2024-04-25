import java.util.Arrays;


// O(n)
public class CountSort {
    public static void main(String[] args) {
        int[] array = {600, 7, -4, 23, 590, -4, -45, 45, -4, 6, 0};
        countSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static void countSort(int[] array) {
        int[] minmax = minmax(array);
        int[] buckets = getBuckets(array, minmax[0], minmax[1]);
        transform(array, buckets, minmax[0]);
    }

    private static int[] minmax(int[] array) {
        int[] minmax = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        for (int element : array) {
            if (element < minmax[0]) {
                minmax[0] = element;
            }
            if (element > minmax[1]) {
                minmax[1] = element;
            }
        }
        return minmax;
    }

    private static int[] getBuckets(int[] array, int min, int max) {
        int[] buckets = new int[max - min + 1];
        for (int element : array) {
            buckets[element - min]++;
        }
        return buckets;
    }

    private static void transform(int[] array, int[] buckets, int min) {
        int index = 0;
        for (int i = 0; i < buckets.length; i ++) {  // по возрастанию
            // for (int i = buckets.length - 1; i >= 0; i --) { # по убыванию
            for (int j = buckets[i]; j > 0; j --) {
                array[index] = i + min;
                index ++;
            }
        }
    }
}
