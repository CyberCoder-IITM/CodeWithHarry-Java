import java.util.*;
public class Harsha_Doubt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int marks[][] = new int[2][3];
        System.out.println("Your marks");
        for (int i=0;i<2;i++) {
            for (int j = 0; j<3; j++) {
                marks[i][j] = sc.nextInt();
            }
        }
        for (int i =0; i<2; i++) {
            for (int j = 0; j<3; j++) {
                if (marks[i][j] < 12) {
                    System.out.println(marks[i][j]+ " : "+ "Fail");
                }
                else {
                    System.out.println(marks[i][j]+ " : "+ "Pass");
                }
            }
        }
    }
}