import java.util.Random;
import java.util.Scanner;

public class RockPaperScissor {
    public static void main(String[] args) {
        System.out.println("Choose Rock Paper Scissor : ");
        System.out.println("\n 0 --> ROCK \n 1 --> paper \n 2 --> Scissor");

        Scanner sc = new Scanner(System.in);
        Random rm = new Random();

        int user;

        user = sc.nextInt();

        int pc;
        pc = rm.nextInt(3);

        switch(user){
            case 0:
                System.out.println("You Choose Rock");
                break;
            case 1:
                System.out.println("You choose Paper");
                break;
            case 2:
                System.out.println("You choose scissor");
                break;
            default:
                System.out.println("INVALID INPUT");
                break;

        }
        switch (pc){
            case 0:
                System.out.println("PC choose Rock");
                break;
            case 1:
                System.out.println("PC choose Paper");
                break;
            case 2:
                System.out.println("PC choose scissor");
                break;
            }

        if(pc==user){
            System.out.println("THE GAME IS TIE");
        }

        if(pc==0){
            switch (user){
                case 1:
                    System.out.println("YOU WON");
                    break;
                case 2:
                    System.out.println("YOU LOST");
                    break;
            }

        }

        else if (pc==1){
            switch (user){
                case 0:
                    System.out.println("YOU LOST");
                    break;
                case 2:
                    System.out.println("YOU WON");
                    break;

            }
        }

        else
        {
            switch(user){
                case 0:
                    System.out.println("YOU WON");
                    break;
                case 1:
                    System.out.println("YOU LOST");
                    break;

            }
        }
    }
}