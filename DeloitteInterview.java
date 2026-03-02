import java.util.*;
import java.util.stream.Collectors;

// 1. Data Model (kept package-private so it can live in the same file)
class Employee {
    private String name;
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

// 2. Main Execution Class
public class DeloitteInterview {
    public static void main(String[] args) {
        
        // Initialize dummy data
        List<Employee> employees = Arrays.asList(
            new Employee("Alice", "IT", 75000),
            new Employee("Bob", "HR", 55000),
            new Employee("Charlie", "IT", 85000),
            new Employee("David", "Finance", 90000),
            new Employee("Eve", "HR", 60000)
        );

        System.out.println("--- Department Salary Champions ---");

        // The Core Logic: Java 8 Stream API
        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
            ));

        // Outputting the results
        highestPaidByDept.forEach((department, employeeOpt) -> 
            employeeOpt.ifPresent(employee -> 
                System.out.println(department + " : " + employee.getName() + " earning $" + employee.getSalary())
            )
        );
    }
}
