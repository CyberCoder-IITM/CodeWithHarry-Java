
import java.util.Arrays;
import java.util.List;
public class Generics {
    public static void main(String[] args) {

        List <Integer> list1 = Arrays.asList(4,5,6,7,8);
        System.out.println(list1);
        List <Number> list2 = Arrays.asList(4.5,5.5,6,8);
        System.out.println(list2);

        //Wildcard demo
        //---------------------------------------------01-10-2024---------------------------------------------
        // Mid-Term syllabus is from week 0 to week 4 - Written and Practicum
        // --> Written -> short essay answers to true and false and MCQ, focus is on OOPs
        // why does java not allow static to be included in interface class
        // Practicum ->  Design a class hierarchy and implement basic methods and what would be object design of casino
        // Class structure and hierarchy, tell me what is wrong or what is right?
        // Casino example and super-market class, just designing logic is your work 
        // -------------------------------------------------------------------------------------------------------

        List <Integer> list3 = Arrays.asList(44,55,66,77,88);
        printOnlyInteger(list3);
        List <Number> list4 = Arrays.asList(4444.5,5555.5,6666,8);
        printOnlyInteger(list4);
        //  this is the dummy text i am writing after a tiring night shift at warren towers dining hall.

    }
    private static void printOnlyInteger(List<? super Integer> list){
        System.out.println(list);
    }
}
//difference between template and interface in cpp and java - may be an interview questions

