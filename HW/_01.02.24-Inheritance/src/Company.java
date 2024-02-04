import workingRates_pkg.Worker;

public class Company {
    Worker[] workers = new Worker[10];
    int workersAmount = 0;

    public void addWorker(Worker newWorker) {
        workers[workersAmount] = newWorker;
        workersAmount++;
    }

    public void printWageStats() {
        int totalWage = 0;
        System.out.println();
        for (int i = 0; i < workersAmount; i++) {
            System.out.printf("%s \t\t| %s  \t| %d\n", workers[i].getName(), workers[i].getRate(), workers[i].getWage());
            totalWage += workers[i].getWage();
        }
        System.out.printf("Total: %d\n", totalWage);
    }

    public void printTaxStats() {
        for (int i = 0; i < workersAmount; i++) {
            System.out.printf("%s \t\t| %d%% \t| %d   \t| %d\n", workers[i].getName(), workers[i].getTax(), workers[i].getWage(), workers[i].calcTaxedWage(1));
        }
        System.out.println();
    }
}
