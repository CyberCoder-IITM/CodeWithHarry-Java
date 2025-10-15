
import java.util.Scanner;
public class ExceptionalHandlingProblem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try{
            System.out.println("Enter the number :");
            int x =  Integer.parseInt(sc.next());
//            System.out.println(x*x);
            if (x<100){
                System.out.println("Customer id is invalid");
            }

        }
        catch (Exception e){
            System.out.println("Something is wrong");
        }

        System.out.println("Valid customer");


    }







}
