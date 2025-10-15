import java.util.Scanner;
// DIFFERENCE BETWEEN .nextInt() and .next() , is very important --> https://www.geeksforgeeks.org/difference-between-next-and-nextline-methods-in-java/
public class CoreJavaL1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Sl No. :");
        int sl = sc.nextInt();
        System.out.println("Enter the percentage of discount :");
        double discount = sc.nextDouble();
        System.out.println("Enter your name: ");

        String name = sc.next();
        System.out.println(sl+ discount + name);

    }
}
