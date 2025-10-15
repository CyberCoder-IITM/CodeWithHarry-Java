import java.util.HashMap;
import java.util.Map;

interface sqr{

    int square(String a , int b);


}

public class MapEx {
    public static void main(String[] args) {
        Map<String, Integer> names = new HashMap<>();
        names.put("first", 2);
        names.put("second", 3);
        names.put("third", 4);

        names.forEach((key, value) -> System.out.println("Key: " + key + " Value: " + value*value));
        // using
        sqr ad2 = (String a, int b)->{return (b*b);};
        System.out.println(ad2.square("square is", 4));



    }
}
