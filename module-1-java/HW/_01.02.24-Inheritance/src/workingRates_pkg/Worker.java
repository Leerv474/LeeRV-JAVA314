package workingRates_pkg;

public abstract class Worker {
    final int wage = 3000;

    public abstract String getName();

    public abstract String getRate();

    public abstract int getWage();

    public abstract int getTax();
    protected int calcWage(int time, int wage, int tax) {
        return (int) (time * wage * (double) (100 - tax)/100);
    }

    public abstract int calcTaxedWage(int time);
}
