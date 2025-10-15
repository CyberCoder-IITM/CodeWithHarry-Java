import java.util.Scanner;
public class Temperature_conversion {
    public static double temp(double t){
        double c;
        c = ( t * (9.0/5)) + 32.0;
        return c;

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Temperature in Celsius : ");

        double celsius = sc.nextDouble();

        double t;
        System.out.println(temp(celsius));
    }
}
