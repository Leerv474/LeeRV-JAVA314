import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
class ParallelCollectionSearch implements Runnable {
    List<Integer> numbers;
    List<Integer> SyncedNumbers;
    int target;
    boolean result;

    public ParallelCollectionSearch(List<Integer> numbers, int target) {
        this.numbers = numbers;
        this.SyncedNumbers = Collections.synchronizedList(numbers);
        this.target = target;
    }
    public boolean getResult() {
        return this.result;
    }
    public void run() {
        for (Integer number : numbers) {
            if (number == target) {
                System.out.println("Found");
                result = true;
                break;
            }
        }
        System.out.println("Not found");
        result = false;
    }
}