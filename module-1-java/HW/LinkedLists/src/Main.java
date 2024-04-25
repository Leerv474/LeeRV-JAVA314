import companylib.Employee;
import companylib.Company;
import companylib.Manager;
import companylib.Operator;
import companylib.TopManager;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Company aurora = new Company();
        for (int i = 0; i < 180; i++) {
            aurora.hire(new Operator());
        }
        for (int i = 0; i < 80; i++) {
            aurora.hire(new Manager());
        }
        for (int i = 0; i < 10; i++) {
            aurora.hire(new TopManager());
        }

        List<Employee> top = aurora.getTopSalaryStaff(12);
        List<Employee> low = aurora.getLowestSalaryStaff(30);

        System.out.println("Best workers: ");
        for (Employee employee : top) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("\nWorst workers: ");
        for (Employee employee : low) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("\n");

        System.out.println("Great fire: ");
        while (aurora.getPeople() > 135) {
            var random = new Random();
            int rnd = random.nextInt(3);
            if (rnd == 0) {
                aurora.fire("Operator");
                System.out.println("Operator fired");
            }
            if (rnd == 1) {
                aurora.fire("Manager");
                System.out.println("Manager fired");
            }
            if (rnd == 2) {
                aurora.fire("TopManager");
                System.out.println("TopManager fired");
            }
        }
        System.out.println("\n");

        List<Employee> newtop = aurora.getTopSalaryStaff(12);
        List<Employee> newlow = aurora.getLowestSalaryStaff(30);

        System.out.println("Best workers: ");
        for (Employee employee : newtop) {
            System.out.println(employee.getMonthSalary());
        }
        System.out.println("\nWorst workers: ");
        for (Employee employee : newlow) {
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("\n ppl: " + aurora.getPeople());
        
    }
}
