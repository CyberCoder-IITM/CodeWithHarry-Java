import java.util.ArrayList;
import java.util.Iterator;

public class ArraylistDeclaration {
    public static void main(String[] args) {
        ArrayList<String> slist = new ArrayList<String>();
        slist.add("Name1");
        slist.add("Name2");
        slist.add("Name3");
        Iterator itr = slist.iterator();

        System.out.println(slist);
    }
}
