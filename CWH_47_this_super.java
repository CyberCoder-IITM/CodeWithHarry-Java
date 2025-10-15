class EkClass{
    int a;

    public int getA(){
        return a;
    }
    public int returnone(){
        return 1;
    }


    EkClass(int a){
        this.a = a;
//        a = a;
        //the above line just gives us 0 because it is unable to identify to which object it is referencing.

    }
}

class DoClass extends EkClass{
     DoClass(int c){
         super(c);
         System.out.println("I am a constructor");
     }
}

public class CWH_47_this_super {
    public static void main(String[] args) {
        EkClass e  = new EkClass(65);
        DoClass d = new DoClass(5);
        System.out.println(e.getA());
    }
}
