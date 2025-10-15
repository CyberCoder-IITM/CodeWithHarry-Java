import java.util.ArrayList;
import java.util.Iterator;

public class oddeven {
    public static void main(String args[]){
        ArrayList<Integer> list=new ArrayList<Integer>();//Creating arraylist
        list.add(2);//Adding object in arraylist
        list.add(3);
        list.add(4);
        list.add(5);
//Traversing list through Iterator
        for (Integer integer : list) {
            System.out.println("Odd Numbers : ");

        }
    }
}
