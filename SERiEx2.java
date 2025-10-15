import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

//class Person implements Serializable {
//    int id;
//    String name;
//
//    Person(int id, String name) {
//        this.id = id;
//        this.name = name;
//    }
//}

class Student extends Person {
    String course;
    int fee;

    public Student(int id, String name, String course, int fee) {
        super(id, name);
        this.course = course;
        this.fee = fee;
    }

    public Student(int id, String ravi) {
        super(id, ravi);
    }
}

public class SERiEx2 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        try {
            Student s1 = new Student(111, "john", "JAVA", 2000);
            FileOutputStream fout = new FileOutputStream("f1.txt");
            ObjectOutputStream out = new ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            out.close();
            System.out.println("done with the serialzation");
        } catch (Exception e) {
            System.out.println(e);
        }

//deserialization
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream("f1.txt"));
            Student s=(Student)in.readObject();

            System.out.println(s.id+"  "+s.name+"  "+s.course+"  "+s.fee+"  ");

        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("done with the deserialzation");

    }
}

