import java.util.*;

class Customer {
    int id;
    String name;
    Integer refereeId; // can be null

    public Customer(int id, String name, Integer refereeId) {
        this.id = id;
        this.name = name;
        this.refereeId = refereeId;
    }
}

public class CustomerRefereeAnalyzer {

    public static List<String> findValidCustomers(List<Customer> customers) {
        List<String> result = new ArrayList<>();

        for (Customer c : customers) {
            // Condition:
            // referee_id != 2 OR referee_id IS NULL
            if (c.refereeId == null || c.refereeId != 2) {
                result.add(c.name);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        List<Customer> customers = Arrays.asList(
            new Customer(1, "Will", null),
            new Customer(2, "Jane", null),
            new Customer(3, "Alex", 2),
            new Customer(4, "Bill", null),
            new Customer(5, "Zack", 1),
            new Customer(6, "Mark", 2)
        );

        List<String> validCustomers = findValidCustomers(customers);

        System.out.println("Valid Customers:");
        for (String name : validCustomers) {
            System.out.println(name);
        }
    }
}
