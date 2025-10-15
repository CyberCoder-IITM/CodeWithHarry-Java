import java.util.Scanner;

public class Fatorial_Reverse {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int result = 1;


        System.out.println("Enter the number whose factorial you want : ");

        int n= sc.nextInt();

        // multiplying as  5 * 4 * 3 * 2 *1
        for (int i = n; i>=1 ; i-- ){

            result = result*i;





        }

        System.out.println(result);
    }
}
