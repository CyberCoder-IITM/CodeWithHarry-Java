/**
 * A simple demonstration of a Palindrome Checker.
 * A palindrome is a word or phrase that reads the same backward as forward.
 */
public class PalindromeChecker {

    public static void main(String[] args) {
        System.out.println("--- Palindrome Checker ---");

        // 1. A simple, true case
        String test1 = "racecar";
        System.out.println("\nChecking: '" + test1 + "'");
        System.out.println(">>> Result: " + isPalindrome(test1));

        // 2. A simple, false case
        String test2 = "hello";
        System.out.println("\nChecking: '" + test2 + "'");
        System.out.println(">>> Result: " + isPalindrome(test2));

        // 3. A complex, true case (with case and punctuation)
        String test3 = "A man, a plan, a canal: Panama";
        System.out.println("\nChecking: '" + test3 + "'");
        System.out.println(">>> Result: " + isPalindrome(test3));
        
        // 4. A complex, false case
        String test4 = "This is not a palindrome";
        System.out.println("\nChecking: '" + test4 + "'");
        System.out.println(">>> Result: " + isPalindrome(test4));
    }

    /**
     * Checks if a given string is a palindrome.
     * This method is case-insensitive and ignores non-alphanumeric characters.
     *
     * @param text The string to check.
     * @return true if the string is a palindrome, false otherwise.
     */
    public static boolean isPalindrome(String text) {
        
        // 1. Clean the string
        // [^a-zA-Z0-9] is a regex for "any character that is NOT a-z, A-Z, or 0-9"
        // We replace all of those with an empty string ("")
        String cleanedText = text.toLowerCase().replaceAll("[^a-z0-9]", "");

        // 2. Use the "two-pointer" technique to check
        int left = 0;
        int right = cleanedText.length() - 1;

        // 3. Loop until the pointers meet or cross
        while (left < right) {
            // Check if the characters at the left and right pointers are different
            if (cleanedText.charAt(left) != cleanedText.charAt(right)) {
                return false; // Not a palindrome
            }
            
            // Move the pointers inward
            left++;
            right--;
        }

        // If the loop finished without finding a mismatch, it's a palindrome
        return true;
    }
}