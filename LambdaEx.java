interface  Addable{
    int add(int a, int b);
}

public class LambdaEx {
    public static void main(String[] args) {
        Addable ad1 = (a,b)->(a+b);
        // arrow in lambda expression with no return   value.


        //lambda with return value
        Addable ad2 = (int a, int b)->{return (a+b);};
        System.out.println(ad2.add(100,200));
        System.out.println(ad1.add(1,2));
    }
}
