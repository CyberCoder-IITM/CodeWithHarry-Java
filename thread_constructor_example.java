
//class Run implements Runnable{
//    public void run(){
//        System.out.println("runnable implemented successfully");
//    }
//}
//public class thread_constructor_example{
//    public static void main(String[]args){
//        Run r=new Run();
//        Thread p1=new Thread(r,"KHUSI");
//        p1.start();
//        System.out.println(p1.getName());
//        System.out.println(p1.getId());
//    }
//}
//-----------------------------------------------------------------------------------------------------------
//This is example of cwh_73 constructor of thread with 2 parameters using runnable interface and can also be done extending thread class.

//class MyRunnable implements Runnable {
//
//    @Override
//    public void run() {
//        System.out.println("Hello from thread " + Thread.currentThread().getName());
//    }
//
//}
//
//public class thread_constructor_example {
//
//    public static void main(String[] args) {

//        // Create a new Runnable object.
//        MyRunnable runnable = new MyRunnable();
//
//        // Create a new Thread object and pass the Runnable object to the constructor.
//        Thread thread = new Thread(runnable, "MyThread");
//
//        // Start the thread.
//        thread.start();
//    }
//
//}
//-----------------------------------------------------------------------------------------------
class MyTr extends Thread implements Runnable{

    public MyTr(Runnable r,String name){
        super(r,name);
    }

    public void run(){
        System.out.println("Hello Mr thread "+ currentThread().getName() + " with id is "+currentThread().getId());
    }

}

public class thread_constructor_example{
    public static void main(String[] args) {
        Runnable r = null;
        MyTr t = new MyTr(r,"Adnan");
        t.start();
    }
}
