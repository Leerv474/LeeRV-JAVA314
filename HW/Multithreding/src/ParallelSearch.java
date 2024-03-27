import javax.naming.PartialResultException;

public class ParallelSearch implements Runnable{
    private int[] array;
    private int[] result;
    public ParallelSearch(int[] array) {
        this.array = array;
    }
    public int[] searchArray() {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            min = Integer.min(i, min);
            max = Integer.max(i, max);
        }
        return new int[]{min, max};
    }
    public void run() {
        result = searchArray();
    }
    public final int[] getResult() {
        return result;
    }
}
