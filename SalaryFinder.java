import java.util.*;
import java.util.stream.Collectors;

public class SalaryFinder {
    public static void main(String[] args) {
        // Example 1: Standard case
        List<Integer> salaries1 = Arrays.asList(100, 200, 300);
        System.out.println("Second Highest (Example 1): " + getSecondHighest(salaries1));

        // Example 2: No second highest (returns null)
        List<Integer> salaries2 = Arrays.asList(100);
        System.out.println("Second Highest (Example 2): " + getSecondHighest(salaries2));

        // Example 3: Duplicates (handles distinct)
        List<Integer> salaries3 = Arrays.asList(300, 300, 100);
        System.out.println("Second Highest (Example 3): " + getSecondHighest(salaries3));
    }

    public static Integer getSecondHighest(List<Integer> salaries) {
        return salaries.stream()
                .distinct()                             // 1. Remove duplicates (like DISTINCT in SQL)
                .sorted(Comparator.reverseOrder())      // 2. Sort descending (like ORDER BY DESC)
                .skip(1)                                // 3. Skip the first one (like OFFSET 1)
                .findFirst()                            // 4. Take the next one (like LIMIT 1)
                .orElse(null);                          // 5. If empty, return null
    }
}
