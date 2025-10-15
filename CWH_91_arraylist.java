import java.util.ArrayList;

public class CWH_91_arraylist {
    public static void main(String[] args) {

        ArrayList<Integer> l1 = new ArrayList<>();
        ArrayList<Integer> l2 = new ArrayList<>();

        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        l1.add(5);
        l1.add(6);

        l2.add(11);
        l2.add(12);
        l2.add(13);
        l2.add(14);

        System.out.println("L1 Array list : "+ l1);
        System.out.println("L2 Array list : " +l2);
        l1.addAll(l2); // adds at the last of the list
//        l1.addAll(0,l2); //----> adds the list l2 from 0th index
        System.out.println("L1 Array list after merging: "+ l1);
        System.out.println("L2 Array list : " +l2);
    }
}
