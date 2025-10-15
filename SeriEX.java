import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SeriEX {

    public static void main(String[] args) {

        try {

            Student s1;
            s1 = new Student(211, "ravi");
            Address a=new Address ("x","y","z");
            FileOutputStream fout = new FileOutputStream("f.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            out.close();
            System.out.println("Done with streaming");
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}