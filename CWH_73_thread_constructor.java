class MyThr extends Thread{
    public MyThr(String name){
        super(name);
    }
    public void run(){
        int i = 34; // just wrote simply and this code is of no use.
        System.out.println("Thank you");
//        while(true){
//            System.out.println("I am a thread");
//        }
    }
    }


public class CWH_73_thread_constructor{
    public static void main(String[] args) {
        MyThr t = new MyThr("harsa");
        MyThr t1 = new MyThr("Harry");
        MyThr t2 = new MyThr("Ram Candr");
        t.start();
        t1.start();
        t2.start();
        System.out.println("The id of the thread t is " + t.getId());
        System.out.println("The name of the thread t is " + t.getName());
        System.out.println("The id of the thread t is " + t1.getId());
        System.out.println("The name of the thread t is " + t1.getName());
        System.out.println("The id of the thread t is " + t2.getId());
        System.out.println("The name of the thread t is " + t2.getName());

    }
}
