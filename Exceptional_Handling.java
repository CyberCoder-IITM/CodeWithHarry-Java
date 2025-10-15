public class Exceptional_Handling {
    public static void main(String[] args) {
        int a = 50;
        int b = 10;
        int c = 10;

        int x = a/(b+c);
        System.out.println("The value of x in add is " + x);

        int y;
        try {
            // check for exception

            System.out.println("Hello WORLD");
            System.out.println("Hello WORLD 2ND");
            y = a/(b-c);
            System.out.println("Hello WORLD 3rd");
            System.out.println("Hello WORLD 4th");
        } catch (Exception e){
            // throws an exception
            e.printStackTrace();
        }

        finally {
            // what decision what value final you want y to be?
            y=1;
        }
        System.out.println("The value of y in divide by zero exception is " + y);
        System.out.println("Hello");

        System.out.println("Hello Java");
    }
}
