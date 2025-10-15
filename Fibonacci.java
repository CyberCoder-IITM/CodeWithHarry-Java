import java.util.Scanner;
public class Fibonacci {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int a1 = 0;
        int a2 = 1;
        int an = sc.nextInt();
        System.out.print(a1 + " " + a2);
        for(int i = 2 ; i <an  ; ++i ) {
            int a3;
            a3 = a1 + a2;
            System.out.print(" " + a3);
            a1 = a2;
            a2 = a3;

        }
    }
}
