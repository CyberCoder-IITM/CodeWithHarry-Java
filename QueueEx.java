import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
    public static void main(String[] args) {
        Queue<String> jk = new LinkedList<>();
        jk.offer("Hi");
        jk.offer("Hello");
        jk.offer("How");
        System.out.println("Queue: " + jk);


        String accessedNumber = jk.peek();

        System.out.println("Accessed Element: " + accessedNumber);

        String removed = jk.poll();
        System.out.println("Removed Element: " + removed);

        System.out.println("Updated Queue: " + jk);


    }
}
