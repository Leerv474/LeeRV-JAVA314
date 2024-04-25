public class Sum implements Runnable {
    private int[] array;
    private int result;
    public Sum(int[] array) {
        this.array = array;
    }
    public int CalcSum() {
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        return sum;
    }
    public void run() {
        result = CalcSum();
    }
    public final int getResult() {
        return result;
    }
}
