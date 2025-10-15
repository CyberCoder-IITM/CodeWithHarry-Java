public class CWH_85_finally {
    public static int greet(){
        try{
            int a = 50;
            int b = 10;
            int c =  a/b;
            return c;
        }
        catch (Exception e){
            System.out.println(e);
        }
        finally {
            System.out.println("Cleaning up resources....This is the end of program .");
        }
        return -1;
    }
    public static void main(String[] args) {
//        greet();
        int k = greet();
        System.out.println(k);
        int a = 7;
        int b = 9;

        while(true){
            try{
                System.out.println(a/b);
            }
            catch (Exception e){
                System.out.println(e);
                break;
            }
            finally{
                System.out.println("I am finally for value of b = " + b);
            }
            b--;
        }
        try{
            System.out.println(50/3);
//            System.out.println(50/0); //-->it throws exception error
        }
        finally {
            System.out.println("Yes this is finally");
        }

        //----finally example using for loop
//        for (int i = 0;i < 10 ;i++){
//            if (i==5){
//                try{
//                    break;
//                }
//                finally{
//                    System.out.println("FInally runned");
//                }
//            }


        }

    }

