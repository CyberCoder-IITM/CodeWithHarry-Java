import java.util.Scanner;
public class CWH_05_TakingInput {
    public static void main(String[] args) {
        System.out.println("Taking Input form the user");
        Scanner sc = new Scanner(System.in);

//        System.out.println("Enter first number : ");
//        int a = sc.nextInt();
//        System.out.println("Enter second number : ");
//        int b = sc.nextInt();
//        int sum = a + b;
//        System.out.println("The sum is : ");
//        System.out.println(sum);
//        boolean b1 = sc.hasNextInt();// Used to check whether the value is int or not.
//        System.out.println(b1);
//        String str = sc.next();

        String str = sc.nextLine();
        System.out.println(str);

    }
}
