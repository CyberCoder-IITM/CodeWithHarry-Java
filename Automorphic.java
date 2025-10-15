import java.util.Scanner;
public class Automorphic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int result = a*a;
        System.out.println(result);
        if ( a%10 != result%10){
            System.out.println("Not Automorphic");
        }
        else{
            System.out.println("Automorphic");
        }
    }
}
