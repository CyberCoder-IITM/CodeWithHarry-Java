import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * A simple console utility to count the frequency of each word in a text file.
 */
public class WordCounter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordCounts = new HashMap<>();

        System.out.println("--- Word Frequency Counter ---");

        // 1. Get the file path from the user
        System.out.print("Enter the absolute path to the .txt file: ");
        String filePath = scanner.nextLine();

        File file = new File(filePath);
        
        try (Scanner fileScanner = new Scanner(file)) {
            System.out.println("\nProcessing file...");

            // 2. Read the file line by line
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                
                // 3. Split the line into words
                // This regex splits by any non-alphabetic character (e.g., spaces, punctuation)
                String[] words = line.split("[^a-zA-Z]+");

                for (String word : words) {
                    if (word.isEmpty()) {
                        continue; // Skip empty strings that result from splitting
                    }

                    // 4. Normalize to lowercase and update the count
                    String lowerCaseWord = word.toLowerCase();
                    int count = wordCounts.getOrDefault(lowerCaseWord, 0);
                    wordCounts.put(lowerCaseWord, count + 1);
                }
            }

            // 5. Print the results
            System.out.println("\n--- Results ---");
            System.out.println("Total unique words: " + wordCounts.size());
            System.out.println("-----------------");

            for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found at path: " + filePath);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}