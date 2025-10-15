public class AK_print_subarrays {
    public static void SubArray(int [] arr){
        int total = 0;
        for (int i =0 ; i < arr.length;i++){
            for (int j =i; j < arr.length;j++){
                for (int k = i ; k<=j;k++){
                    System.out.print(arr[k]+" ");
                    total++;
                }
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total number of sub arrays are "+ total);
    }
    public static void main(String[] args) {
        int [] arr = {1,2,3,4};
        SubArray(arr);
    }
}
