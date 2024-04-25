package companylib;

import java.util.*;

/**
 * Company
 */
public class Company {

    private List<Employee> employees = new ArrayList<>();

    public List<Employee> getTopSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, (emp1, emp2) -> Double.compare(emp2.getMonthSalary(), emp1.getMonthSalary()));
        return sortedEmployees.subList(0, Math.min(count, sortedEmployees.size()));
    }

    public List<Employee> getLowestSalaryStaff(int count) {
        List<Employee> sortedEmployees = new ArrayList<>(employees);
        Collections.sort(sortedEmployees, (emp1, emp2) -> Double.compare(emp1.getMonthSalary(), emp2.getMonthSalary()));
        return sortedEmployees.subList(0, Math.min(count, sortedEmployees.size()));
    }
    public int getPeople() {
        return employees.size();
    }
    public void hire(Employee employee) {
        employees.add(employee);
    }
    public void hireAll(Collection<Employee> employeeList) {
        employees.addAll(employeeList);
    }

    public void fire(String workerType) {
        for (int i = 0; i < employees.size(); i++) {
            if (workerType == employees.get(i).getWorkerType()) {
                employees.remove(i);
                return;
            }
        }
    }
    public double getIncome() {
        var random = new Random();
        return random.nextInt(9_000_000, 11_000_000);

    }
}
