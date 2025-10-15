
import java.util.Scanner;

public class PizzaOrderingSystem {
    public static void main(String[] args) {


        float sum = 0;


        System.out.println("S NO.           Item Category");

        System.out.println("----------------------------------");
        System.out.println("0                PIZZA");
        System.out.println("1                GARLIC BREAD");
        System.out.println("2                BEVERAGES");
        System.out.println("----------------------------------");

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 0 for Pizza,\n 1 for Garlic Bread,\n 2 for Beverages\n ");
        int userInput = sc.nextInt();


        if (userInput == 0) {

            System.out.println("S NO.                    PIZZA      PRICE ");

            System.out.println("----------------------------------");
            System.out.println("1                AFRICAN PERI PERI      450");
            System.out.println("2                BARBEQUE VEG           300");
            System.out.println("3                JAMAICAN JERK VEG      350");
            System.out.println("4                WHAT-A-PIZZA           200");
            System.out.println("5                ENGLISH CHEDDAR        400");
            int PizzaType = sc.nextInt();
            if (PizzaType == 1) {
               
                sum += 450;
                System.out.println("----------------------------------");
                System.out.print("Enter 0 for wheat thin crust [60/-],\nEnter 1 fresh pan base [80/-],\nEnter 2 for hand tossed [70/-]");
                int CrustInput = sc.nextInt();
                if (CrustInput == 0) {
                    sum += 60;


                    System.out.println("----------------------------------");
                    System.out.println(" Do you Want Extra ? YES OR NO  \n: Press 1 for Yes and 2 for No");


                    int Extra = sc.nextInt();
                    if (Extra==1){

                        System.out.println("----------------------------------");
                        System.out.println("1                Extra Cheese      80");
                        System.out.println("2                Veg Topping       120");
                        System.out.println("----------------------------------");
                        System.out.println("Enter 1 for EXTRA CHEESE \nEnter 2 for VEG TOPPING");
                        int Ext = sc.nextInt();
                        if (Ext==1){
                            sum += 80;
                            System.out.println("Your Total Bill amount is " + sum);

                        }
                        else if (Ext==2){
                            sum += 120;
                            System.out.println("----------------------------------------");
                            System.out.println("Your Total Bill amount without discount is " + sum);
                            if(sum>=500 && sum<1000 ){
                                System.out.println("You will get 5% Discount : ");
                                System.out.println("------------DISCOUNTED PRICE-----------");
                                System.out.println(sum - (((double)5)/100)*sum);
                                sum=sum - (5.f/100)*sum;


                            }
                            else{
                                System.out.println("You will get 10% Discount : ");
                                System.out.println("------------DISCOUNTED PRICE-----------");
                                System.out.println(sum - (((double)10)/100)*sum);
                                sum=sum - (10.f/100)*sum;


                            }
                            System.out.println("Total Amount with home delivery is : " + (sum+100) );
                            sum += 100;
                            System.out.println("You should pay : " + sum);


                        }

                    }
                    else{
                        System.out.println("You are Done");
                    }








                }
                else if (CrustInput == 1) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 780");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");

                }
                else {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 900");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                }


            }
            if (PizzaType == 2) {
                System.out.print("Enter 0 for wheat thin crust [60/-],\nEnter 1 fresh pan base [80/-],\nEnter 2 for hand tossed [70/-]");
                int CrustInput = sc.nextInt();
                if (CrustInput == 0) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 550");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");


                }
                else if (CrustInput == 1) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 680");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                }
                else  {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 490");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                }

            }
            if (PizzaType == 3) {
                System.out.print("Enter 0 for wheat thin crust [60/-],\nEnter 1 fresh pan base [80/-],\nEnter 2 for hand tossed [70/-]");
                int CrustInput = sc.nextInt();
                if (CrustInput == 0) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 750");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");

                }
                else if (CrustInput == 1) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 650");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                }
                else  {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 550");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                }

            }
            if (PizzaType == 4) {
                System.out.print("Enter 0 for wheat thin crust [60/-],\nEnter 1 fresh pan base [80/-],\nEnter 2 for hand tossed [70/-]");
                int CrustInput = sc.nextInt();
                if (CrustInput == 0) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 550");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");

                } else if (CrustInput == 1) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 600");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                } else {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 750");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                }

            }
            if (PizzaType == 4) {
                System.out.print("Enter 0 for wheat thin crust [60/-],\nEnter 1 fresh pan base [80/-],\nEnter 2 for hand tossed [70/-]");
                int CrustInput = sc.nextInt();
                if (CrustInput == 0) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 390");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");


                } else if (CrustInput == 1) {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 760");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                } else {
                    System.out.println("----------------------------------");
                    System.out.println("1                Extra Cheese      80");
                    System.out.println("2                Veg Topping       120");
                    System.out.println("Your total bill amount is 680");
                    System.out.println("------------DISCOUNTED PRICE-----------");

                    System.out.println("      Your total bill amount is 680    ");
                    System.out.println("       + 100/- For Home Delivery    ");

                    System.out.println("----------------------------------------");
                }


            }

        }


        if (userInput == 1) {
            System.out.println("S NO            GARLIC BREAD    PRICE ");

            System.out.println("-----------------------------------------");
            System.out.println("1                STUFFED GARLIC      90");
            System.out.println("2                PLAIN GARLIC        80");
            int BreadType = sc.nextInt();
            if (BreadType == 1) {
                System.out.println("Your Total Amount is: 90 ");
                System.out.println("------------DISCOUNTED PRICE-----------");

                System.out.println("      Your total bill amount is 90    ");
                System.out.println("       + 100/- For Home Delivery    ");

                System.out.println("----------------------------------------");

            }
            if (BreadType == 2) {

                System.out.println("Your Total amount is: 80 ");
                System.out.println("------------DISCOUNTED PRICE-----------");

                System.out.println("      Your total bill amount is 80    ");
                System.out.println("       + 100/- For Home Delivery    ");

                System.out.println("----------------------------------------");

            }
        }

        if (userInput == 2) {
            System.out.println("S NO.                    BEVERAGE     PRICE ");

            System.out.println("-----------------------------------------");
            System.out.println("1                PEPSI           90");
            System.out.println("2                COCA COLA       80");
            int BeverageType = sc.nextInt();
            if (BeverageType == 1) {
                System.out.println("Your Total Amount is: 90 ");
                System.out.println("------------DISCOUNTED PRICE-----------");

                System.out.println("      Your total bill amount is 90    ");
                System.out.println("       + 100/- For Home Delivery    ");

                System.out.println("----------------------------------------");

            }
            if (BeverageType == 2) {

                System.out.println("Your Total amount is: 80 ");
                System.out.println("------------DISCOUNTED PRICE-----------");

                System.out.println("      Your total bill amount is 80    ");
                System.out.println("       + 100/- For Home Delivery    ");

                System.out.println("----------------------------------------");

            }

        }

    }

}
