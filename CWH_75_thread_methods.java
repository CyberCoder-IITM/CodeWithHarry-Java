class Mtr1 extends Thread{

    public void run(){

        for (int i = 1;i<50;i++){
            System.out.println("hello Mr thread names as "+ currentThread().getName() + " and id as " + currentThread().getId());
            try {
                Thread.sleep(455); // stops this method  for some time.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Mtr2 extends Thread{

    public void run(){

        for (int i = 1;i<50;i++){
            System.out.println("Thank you");

        }
    }
}

public class CWH_75_thread_methods {
    public static void main(String[] args) {
        Mtr1 t1 = new Mtr1();
        Mtr2 t2 = new Mtr2();
        t1.start();
//        try {
//            t1.join(); // Used to finish all code of t1 and then start t2.
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        t2.start();

    }
}
