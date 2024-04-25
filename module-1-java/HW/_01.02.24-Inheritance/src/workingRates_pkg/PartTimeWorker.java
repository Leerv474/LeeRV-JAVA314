package workingRates_pkg;

public class PartTimeWorker extends Worker {

    final int wage = 800;
    final int tax = 20;
    final String name;
    final String rate = "hourly";
    public PartTimeWorker(String name) {
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

    public int calcWage(int hours) {
        return super.calcWage(hours, this.wage, 0);
    }
    @Override
    public int calcTaxedWage(int days) {
        return super.calcWage(days, this.wage, 20);
    }
}
