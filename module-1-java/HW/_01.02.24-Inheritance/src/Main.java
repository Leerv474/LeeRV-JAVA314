import workingRates_pkg.FullTimeWorker;
import workingRates_pkg.PartTimeWorker;
import workingRates_pkg.PieceWorker;

public class Main {
    public static void main(String[] args) {
        Company test = new Company();
        test.addWorker(new FullTimeWorker("Andy"));
        test.addWorker(new PieceWorker("Marnie"));
        test.addWorker(new PartTimeWorker("Lewis"));

        test.printWageStats();

        test.printTaxStats();
    }
}