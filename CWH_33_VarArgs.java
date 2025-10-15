public class CWH_33_VarArgs {

//    static int sum(int a){
//        return a;
//    }
//    static int sum(int a, int b ){
//        return a+b;
//    }
//    static int sum(int a, int b, int c ){
//        return a+b+c;
//    }
//    static int sum(int a, int b, int c, int d ){
//        return a+b+c+d;
//    }

    //static int sum(int x, int ...arr)
    public static int sum(int ...arr){
        // arr is available here as int[] arr
        int result = 0;
        for (int a:arr) {
            result+=a;
        }
        return result;
    }

    public static void main(String[] args) {
//        System.out.println("Welcome to VarArgs");
//        System.out.println("The sum of 4 is: " + sum(4 ));
//        System.out.println("The sum of 4 and 5 is: " + sum(4 , 5));
//        System.out.println("The sum of 4 , 6 and 5 is: " + sum(4 , 5,6));
//        System.out.println("The sum of 4 ,6,7 and 5 is: " + sum(4 , 5,6,7));

        // The above syntax is not efficient so we use var args here.

        System.out.println("Welcome to VarArgs");
        System.out.println("The sum of nothing is: " + sum() + " as it is empty because only 0 initialized ");
        System.out.println("The sum of 4 is: " + sum(4 ));
        System.out.println("The sum of 4 and 5 is: " + sum(4 , 5));
        System.out.println("The sum of 4 , 6 and 5 is: " + sum(4 , 5,6));
        System.out.println("The sum of 4 ,6,7 and 5 is: " + sum(4 , 5,6,7));

    }
}
