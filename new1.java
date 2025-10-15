import java.util.HashMap;
import java.util.Set;

public class new1 {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap<>(){
            {
                put("1", "ONE");
            }{
                put("2", "TWO");
            }{
                put("3", "THREE");
            }
        };
        Set<String> keySet = map.keySet();
        for (String string : keySet) {
            System.out.println(string+" ->"+map.get(string));
        }
    }
}