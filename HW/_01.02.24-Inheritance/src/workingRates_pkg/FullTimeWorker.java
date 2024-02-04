package workingRates_pkg;

import java.lang.annotation.Inherited;

public class FullTimeWorker extends Worker {
    final int wage = 3000;

    final int tax = 20;
    final String name;
    final String rate = "full";

    public FullTimeWorker(String name) {
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

    public int calcWage(int days) {
        return super.calcWage(days, this.wage, 0);
    }

    @Override
    public int calcTaxedWage(int days) {
        return super.calcWage(days, this.wage, this.tax);
    }
}
