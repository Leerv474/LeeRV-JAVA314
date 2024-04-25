package companylib;
/**
 * Operator
 */
public class Operator implements Employee {

    private String workerType = "Operator";
    @Override
    public String getWorkerType() {
        return workerType;
    }
    private int fixedPart = 30_000;
    public double getMonthSalary() {
        return fixedPart;
    }
    
}
