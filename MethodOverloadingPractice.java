public class MethodOverloadingPractice {

//    static void change(int [ ] arr){
//        arr[0]= 42;
//    }
    static int change(int [ ] arr){
        arr[1]= 42;
        return arr[1] ;
    }

    public static void main(String[] args) {

        int [] marks = {52, 73, 77, 89, 98, 94};
         change(marks);
         System.out.println("The value of x after running change is: " + marks[1] );

//        for(int element: marks){
//            System.out.println(element);
//        }
    }
}
