public class Fibonacci_recursion {
    public static int fib(int n){
        if(n == 1 || n == 2){
            return n-1;

        }
        else{
            return fib(n-1)+fib(n-2);
        }
    }

    public static void main(String[] args) {

        Fibonacci_recursion obj = new Fibonacci_recursion();


        System.out.println(fib(8));

    }
}
