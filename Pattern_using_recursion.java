public class Pattern_using_recursion {

    public static void pat(int n){
        if (n>0){

            pat(n-1);
            for (int i = 0; i <n ; i++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        pat(6);

    }}
