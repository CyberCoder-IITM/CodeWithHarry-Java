import java.util.Scanner;
public class CWH_06_MarksToPercentageCalculator {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter The Marks : ");
        System.out.println("Enter your English Makrs : ");
        int a = sc.nextInt();
        System.out.println("Enter your SOCIAL Makrs : ");
        int b = sc.nextInt();
        System.out.println("Enter your SCIENCE Makrs : ");
        int c = sc.nextInt();
        System.out.println("Enter your MATHS Makrs : ");
        int d = sc.nextInt();
        System.out.println("Enter your HINDI Makrs : ");
        int e = sc.nextInt();

        System.out.println("Your percentage is : ");

        float total = a+b+c+d+e;
        float percentage = (total/500)*100;

        System.out.print(percentage);
        System.out.print("%");


    }
}
