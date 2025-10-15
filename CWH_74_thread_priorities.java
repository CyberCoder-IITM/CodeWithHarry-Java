class Mt extends Thread{

    public Mt(String name){
        super(name);
    }

    public void run(){

        for (int i = 1;i<100;i++){
            System.out.println("hello Mr thread names as "+ currentThread().getName() + " and id as " + currentThread().getId());
        }
    }
}

public class CWH_74_thread_priorities {
    public static void main(String[] args) {

        Mt t1 = new Mt("Adnan ");
        Mt t2 = new Mt("Afnan ");
        Mt t3 = new Mt("Abnan (Most/maximum important)");
        Mt t4 = new Mt("Abnan (Less important)");
        Mt t5 = new Mt("Abnan (minimum important)");

        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.NORM_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}
