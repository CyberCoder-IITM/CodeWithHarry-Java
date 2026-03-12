import java.util.Scanner;

public class PrimeNumberAnalyzer {

    // Function to check if a number is prime
    public static boolean isPrime(int num) {

        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

    // Function to count primes in array
    public static int countPrimes(int[] arr) {

        int count = 0;

        for (int num : arr) {
            if (isPrime(num)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        int[] numbers = new int[n];

        System.out.println("Enter " + n + " numbers:");

        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int primeCount = countPrimes(numbers);

        System.out.println("\nPrime numbers in array:");

        for (int num : numbers) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }

        System.out.println("\nTotal prime numbers: " + primeCount);

        scanner.close();
    }
}
