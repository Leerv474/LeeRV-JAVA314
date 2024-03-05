package companylib;
import java.util.Random;

/**
 * Manager
 */
public class Manager implements Employee {
    double bonus = 0.05;

    int fixedPart = 50_000;

    private String workerType = "Manager";
    @Override
    public String getWorkerType() {
        return workerType;
    }
    
    @Override
    public double getMonthSalary() {
        var random = new Random();
        int lowerBound = 10_000;
        int upperBound = 40_000;
        int moneyMade = random.nextInt(upperBound - lowerBound) + lowerBound;
        return fixedPart * 1.5 + moneyMade * bonus;
    }

}
