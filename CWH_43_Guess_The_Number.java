//
//import java.util.Scanner;
//
//class Game{
//    int userNumber; //Note while creating a class fist declare all the variables at top.
//    int compNumber;
//    int counter = 0;
//    public Game(){
//        compNumber = (int)(Math.random()*100); // always use this to generate random numbers.
//    }
//    public void setNum(int n){
//        userNumber = n;
//    }
//    public int isCorrect(){
//        if(userNumber > compNumber) return -1;
//        else if(userNumber < compNumber) return 1;
//        else return 0;
//    }
//
//    public void Counter(){
//        counter++;
//    }
//
//    public void showComputerNumber() {
//        System.out.println("The computer-generated number was: " + compNumber);
//    }
//}
//
//public class CWH_43_Guess_The_Number {
//    public static void main(String[] args) {
//        Game obj = new Game();
//
//        Scanner sc = new Scanner(System.in);
//        int n = 0;
//        while(true){
//            System.out.println("Enter a number between 1-100: ");
//            n = sc.nextInt();
//            obj.setNum(n);
//
//            if(obj.isCorrect() == 0){
//                obj.Counter();
//                System.out.println("Congratulations, You've guessed the number.");
//                System.out.println("Number of counts: " + (obj.counter));
//                obj.showComputerNumber();
//                break;
//            }
//            else if(obj.isCorrect() == 1){
//                obj.Counter();
//                System.out.println("Higher number please!");
//            }
//            else if(obj.isCorrect() == -1){
//                obj.Counter();
//                System.out.println("Lower number please!");
//            }
//        }
//
//    }
//}


//---------------------------------------------------------------------------------------------

import java.util.Scanner;
import java.util.Random;
class game{
    Scanner sc=new Scanner(System.in);
    int compInput;
    int counter;
    int userInput;
    game(int q){
        compInput=q;
        counter=0;
    }
    void getter(){
        System.out.println("Enter a number : \n");
        userInput=sc.nextInt();
        counter++;
        process(userInput);
    }
    void process(int s){
        if(s==compInput)
        {
            System.out.println("You won");
            System.out.println("No. of attempts :"+counter);
        }
        else if(s>compInput)
        {
            System.out.println("Entered number is greater");
            getter();
        }
        else
        {
            System.out.println("Entered number is smaller");
            getter();
        }
    }
}

public class CWH_43_Guess_The_Number {

    public static void main(String[] args) {

        Random rnd=new Random();
        int a=rnd.nextInt(11);
        game g=new game(a);
        g.getter();
    }
}

// FROM CWM YOUTUBE
//package com.company;
//        import java.util.Random;
//        import java.util.Scanner;
//
//class Game{
//    public int number;
//    public int inputNumber;
//    public int noOfGuesses = 0;
//
//    public int getNoOfGuesses() {
//        return noOfGuesses;
//    }
//
//    public void setNoOfGuesses(int noOfGuesses) {
//        this.noOfGuesses = noOfGuesses;
//    }
//
//    Game(){
//        Random rand = new Random();
//        this.number = rand.nextInt(100);
//    }
//    void takeUserInput(){
//        System.out.println("Guess the number");
//        Scanner sc = new Scanner(System.in);
//        inputNumber = sc.nextInt();
//    }
//    boolean isCorrectNumber(){
//        noOfGuesses++;
//        if (inputNumber==number){
//            System.out.format("Yes you guessed it right, it was %d\nYou guessed it in %d attempts", number, noOfGuesses);
//            return true;
//        }
//        else if(inputNumber<number){
//            System.out.println("Too low...");
//        }
//        else if(inputNumber>number){
//            System.out.println("Too high...");
//        }
//        return false;
//    }
//
//}
//public class cwh_50_ex3sol {
//    public static void main(String[] args) {
//        /*
//            Create a class Game, which allows a user to play "Guess the Number"
//            game once. Game should have the following methods:
//            1. Constructor to generate the random number
//            2. takeUserInput() to take a user input of number
//            3. isCorrectNumber() to detect whether the number entered by the user is true
//            4. getter and setter for noOfGuesses
//            Use properties such as noOfGuesses(int), etc to get this task done!
//         */
//
//        Game g = new Game();
//        boolean b= false;
//        while(!b){
//            g.takeUserInput();
//            b = g.isCorrectNumber();
//        }
//
//
//    }
//}
