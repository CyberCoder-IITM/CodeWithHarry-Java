import java.util.Scanner;

public class PrintNaturalNumberInReverseOrder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number : ");
        int i = sc.nextInt();


        for (int a  =i; a>=0 ; a--){
            System.out.println(a);
        }

    }
}
