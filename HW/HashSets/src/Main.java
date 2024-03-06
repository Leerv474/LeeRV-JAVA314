import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[] numbers = new int[]{1, 2, 3, 4 ,8};
        int targetSum = 7;
        System.out.println(Arrays.toString(findTargetSumNumbers(numbers, targetSum)));
    }


    public static int[] findTargetSumNumbers(int[] numbers, int targetSum) {
        HashSet<Integer> storage = new HashSet<>();

        for (int i = 0; i < numbers.length; i++) {
            if (storage.contains(targetSum - numbers[i])) {
                int targetSumIndex = -1;
                for (int j = 0; j < numbers.length; j++) {
                    if (numbers[j] == targetSum - numbers[i]) {
                        targetSumIndex = j;
                        break;
                    }
                }
                return new int[]{targetSumIndex, i};
            }
            storage.add(numbers[i]);
        }
        return null;
    }
}