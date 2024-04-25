package companylib;
import java.util.Random;

/**
 * TopManager
 */
public class TopManager implements Employee {
    double bonusRatio = 1.5;
    int fixedPart = 100_000;

    private String workerType = "TopManager";
    @Override
    public String getWorkerType() {
        return workerType;
    }
    @Override
    public double getMonthSalary() {
        double bonus = 0;

        var random = new Random();
        int lowerBound = 9_000_000;
        int upperBound = 12_000_000;
        int companyIncome = random.nextInt(upperBound - lowerBound) + lowerBound;
        if (companyIncome > 10_000_000) {
            bonus = fixedPart * 2 * bonusRatio;
        }

        return fixedPart * 2 + bonus;
    }
}
