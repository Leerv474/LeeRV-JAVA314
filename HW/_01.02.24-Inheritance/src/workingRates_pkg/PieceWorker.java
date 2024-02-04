package workingRates_pkg;

public class PieceWorker extends Worker {
    final int wage = 5500;
    final int tax = 15;
    final String name;
    final String rate = "piece";

    public PieceWorker(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
    @Override
    public String getRate() {
        return rate;
    }
    @Override
    public int getWage() {
        return wage;
    }
    @Override
    public int getTax() {
        return tax;
    }

    public int calcWage() {
        return super.calcWage(1, this.wage, 0);
    }
    @Override
    public int calcTaxedWage(int days) {
        return super.calcWage(days, this.wage, 15);
    }
}
