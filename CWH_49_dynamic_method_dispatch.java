class Phone{
    public void showTime(){
        System.out.println("Time is 8 am");
    }
    public void on(){
        System.out.println("Turning on phone");
    }
}
class SmartPhone extends Phone{

    public void music(){
        System.out.println("Playing music");
    }
    public void on(){
        System.out.println("Turning on smart phone");
    }
    public void meth3(){
        System.out.println("Method of smartphone ");
    }
}

public class CWH_49_dynamic_method_dispatch {

    //Dynamic method dispatch is also called as Runtime polymorphism

    public static void main(String[] args) {
        // Phone obj = new Phone(); // Allowed
        // SmartPhone smob = new SmartPhone(); // Allowed
        // obj.name();
        Phone obj = new SmartPhone();// Yes it is allowed
        // SmartPhone obj2 = new Phone(); // Not allowed

        obj.showTime();
        obj.on();

//        obj.music(); Not allowed
//        obj.meth3(); Not allowed
    }
}
