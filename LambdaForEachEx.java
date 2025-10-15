import java.util.ArrayList;
import java.util.List;



public class LambdaForEachEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("Ankit");
        list.add("Anki");
        list.add("Ankt");
        list.add("Anit");
        // traverse the list using foreach and lambda

        list.forEach((n)->System.out.println(n));
    }
}
