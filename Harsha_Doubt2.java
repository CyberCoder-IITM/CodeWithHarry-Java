import java.util.*;
public class Harsha_Doubt2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] marks = new int[2][3];
        System.out.println("Harsha marks");
        for (int i=0;i<2;i++) {
            System.out.println("Enter marks for subject" + (i+1));
            for (int j = 0; j<3; j++) {
                marks[i][j] = sc.nextInt();
            }
        }
        for (int i =0; i<2; i++) {
            System.out.println("Result for subject" + (i+1));
            for (int j = 0; j<3; j++) {
                if (marks[i][j] < 12) {
                    System.out.print(" "+marks[i][j]+ " : "+ "Fail");
                }
                else {
                    System.out.print(" "+marks[i][j]+ " : "+ "Pass");
                }
            }
            System.out.println("\n");

        }
    }
}
