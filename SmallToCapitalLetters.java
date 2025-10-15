import java.text.DecimalFormat;
import java.util.Scanner;
public class SmallToCapitalLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(str.toLowerCase());


        System.out.println(str.charAt(1));


        String sentence = "The quick brown fox jumps over the lazy dog.";
        String Changed = sentence.replace("fox","cat");
        System.out.println(Changed);
        //defining array list




    }



}
