import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CWH_111_file_handling {
    public static void main(String[] args) {

        // code to create a new file.
//        File myFile = new File("cwh111file.txt");
//        try {
//            myFile.createNewFile();
//        } catch (IOException e) {
//            System.out.println("Unable to create file");
//            e.printStackTrace();
//        }

        //code to write to a file

//        try {
//            FileWriter fileWriter = new FileWriter("cwh111file.txt");
//            fileWriter.write("this is our first file from this java course\n ok now bye");
//            fileWriter.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        /*
        // Reading a file
        File myFile = new File("cwh111file.txt");
        try {
            Scanner sc = new Scanner(myFile);
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                System.out.println(line);
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        */
        // Deleting a file
        File myFile = new File("cwh111file.txt");
        if(myFile.delete()){
            System.out.println("I have deleted: " + myFile.getName());
        }
        else{
            System.out.println("Some problem occurred while deleting the file");
        }
    }
}
