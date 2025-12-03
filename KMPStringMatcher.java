public class KMPStringMatcher {

    /**
     * Finds all occurrences of the pattern in the text using the KMP algorithm.
     * @param text The larger string to search within.
     * @param pattern The string to search for.
     */
    public static void KMPSearch(String text, String pattern) {
        int M = pattern.length();
        int N = text.length();
        int count = 0;

        if (M == 0) {
            System.out.println("Pattern is empty.");
            return;
        }
        if (N == 0) {
            System.out.println("Text is empty.");
            return;
        }

        // 1. Pre-process the pattern to get the LPS array
        int[] lps = computeLPSArray(pattern);

        int j = 0; // index for pattern[]
        int i = 0; // index for text[]

        while (i < N) {
            // Case 1: Characters match
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            // Case 2: Pattern found
            if (j == M) {
                System.out.println("✅ Found pattern at index " + (i - j));
                count++;
                // Shift the pattern using the LPS value
                j = lps[j - 1];
            }

            // Case 3: Mismatch after j > 0 matches
            else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters, 
                // they will be matched anyway because of the shift.
                if (j != 0) {
                    j = lps[j - 1];
                } 
                // Case 4: Mismatch at j = 0
                else {
                    i++;
                }
            }
        }
        System.out.println("\nTotal occurrences found: " + count);
    }

    /**
     * Pre-processes the pattern to build the LPS array.
     * lps[i] stores the length of the longest proper prefix of pattern[0..i] 
     * which is also a suffix of pattern[0..i].
     */
    private static int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        
        int len = 0; // length of the previous longest prefix suffix
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else { 
                // (pattern.charAt(i) != pattern.charAt(len))
                if (len != 0) {
                    // Try the longest prefix suffix for the sub-pattern pattern[0..len-1]
                    len = lps[len - 1];
                    // Note that we do not increment i here
                } else { 
                    // (len == 0)
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    public static void main(String[] args) {
        String text1 = "ABABDABACDABABCABAB";
        String pattern1 = "ABABCABAB";
        
        System.out.println("--- Example 1 ---");
        System.out.println("Text: " + text1);
        System.out.println("Pattern: " + pattern1);
        KMPSearch(text1, pattern1); 

        System.out.println("\n--- Example 2 ---");
        String text2 = "AAAAABAAABA";
        String pattern2 = "AAAB";
        System.out.println("Text: " + text2);
        System.out.println("Pattern: " + pattern2);
        KMPSearch(text2, pattern2); 
    }
}