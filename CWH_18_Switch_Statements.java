public class CWH_18_Switch_Statements {
    public static void main(String[] args) {
        String var = "Saurabh";
        switch (var) {
            case "Shubham" -> {
                System.out.println("You are going to become an Adult!");
                System.out.println("You are going to become an Adult!");
                System.out.println("You are going to become an Adult!");
            }
            case "Saurabh" -> System.out.println("You are going to join a Job!");
            case "Vishaka" -> System.out.println("You are going to get retired!");
            default -> System.out.println("Enjoy Your life!");
        }
        System.out.println("Thanks for using my Java Code!");

        //---------------------------------------------------------------
        //Traditional Switch syntax
//        switch(expression)
//        {
//            case value1 :
//                // Statements
//                break; // break is optional
//
//            case value2 :
//                // Statements
//                break; // break is optional
//     ....
//     ....
//     ....
//            default :
//                // default Statement
//        }

        //-----------------------------------------------------------------------------


        /*
        int age;
        System.out.println("Enter Your Age");
        Scanner sc = new Scanner(System.in);
        age = sc.nextInt();
        if (age>56){
            System.out.println("You are experienced!");
        }
        else if(age>46){
            System.out.println("You are semi-experienced!");
        }
        else if(age>36){
            System.out.println("You are semi-semi-experienced!");
        }
        else{
            System.out.println("You are not experienced");
        }
        if(age>2){
            System.out.println("You are not a baby!");
        }
        */
    }

}
