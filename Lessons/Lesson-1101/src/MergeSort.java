import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] array = {600, 7, -4, 23, 590, -4, -45, 45, -4, 6, 0};
        mergeSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            merge(array, start, mid, end);
        }
    }

    private static void merge(int[] array, int start, int mid, int end) {
        int[] leftPart = getPart(array, start, mid);
        int[] rightPart = getPart(array, mid + 1, end);
        int[] result = mergeParts(leftPart, rightPart);
        System.arraycopy(result, 0, array, start, result.length);
    }

    static int[] getPart(int[] array, int start, int end) {
        int[] part = new int[end - start + 1];
        System.arraycopy(array, start, part, 0, part.length);
        return part;
    }

    static int[] mergeParts(int[] left, int[] right) {
        int iLeft = 0;
        int iRight = 0;
        int[] result = new int[left.length + right.length];

        while (iLeft < left.length && iRight < right.length) {
            if (left[iLeft] < right[iRight]) {
                result[iLeft + iRight] = left[iLeft];
                iLeft ++;
            } else {
                result[iLeft + iRight] = right[iRight];
                iRight++;
            }
        }
        if (iLeft == left.length) {
            System.arraycopy(right, iRight, result, iRight + iLeft, right.length - iRight);
        } else {
            System.arraycopy(left, iLeft, result, iRight + iLeft, left.length - iLeft);
        }

        return result;
    }
}
