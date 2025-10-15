public class CWH_31_Methods_In_Java {

// Static method meaning, if in your main class  you are calling any method without creating the object
// then you can only call static method.m

    /**
     * The static keyword before a method in Java has the following implications:
     * 1. Method Belongs to the Class, Not an Instance:
     *
     * When a method is declared static, it becomes associated with the class itself, not with individual instances of the class. This means that you can call the method directly on the class name without creating an object.
     * For example, if you have a class Calculator with a static method add, you can call it like this: Calculator.add(2, 3);
     * 2. No Need for an Object to Access:
     *
     * Since static methods are associated with the class, you don't need to create an instance of the class to access them. This can be useful when you want to provide utility methods that don't require specific object data.
     * 3. Shared Across Instances:
     *
     * If multiple instances of a class exist, a static method is shared among all of them. Any changes made to static variables within the method will be reflected in all instances.
     * 4. Cannot Access Instance Variables or Methods:
     *
     * A static method cannot directly access non-static (instance) variables or methods within the same class. This is because instance variables and methods are associated with specific objects, while static methods are associated with the class itself.
     * 5. Commonly Used for Utility Methods:
     *
     * static methods are often used for utility functions that provide common operations, such as mathematical calculations, string manipulation, or input/output operations. These methods can be accessed directly without creating unnecessary objects.
     * Example:
     *
     * Java
     * public class Calculator {
     *     public static int add(int a, int b) {
     *         return a + b;
     *     }
     *
     *     public void subtract(int a, int b) {
     *         // This method is not static and requires an instance of Calculator
     *         System.out.println(a - b);
     *     }
     * }
     * Use code with caution.
     *
     * In this example, the add method is static, so you can call it like Calculator.add(2, 3). However, the subtract method is not static, so you need to create an instance of Calculator to call it.
     */


    static int logic(int x, int y){
        int z;
        if(x>y){
            z = x+y;
        }
        else {
            z = (x +y) * 5;
        }
//        x = 566;
        //christine papakadis birthday is 25/02/1962 OOpS faculty

        return z;
    }


    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        int c;
        // Method invocation using Object creation
        // CWH_31_Methods_In_Java obj = new CWH_31_Methods_In_Java();
        //c = obj.logic(a, b);
        c = logic(a, b);
        System.out.println(a + " "+ b);
        int a1 = 2;
        int b1 = 1;
        int c1;
        c1 = logic(a1, b1);
        System.out.println(c);
        System.out.println(c1);
    }
}
