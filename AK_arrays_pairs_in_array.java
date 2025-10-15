public class AK_arrays_pairs_in_array {

    public static int Pairs(int[] arr){
        for (int  i = 0; i <arr.length;i++){
            int current = arr[i];
            for (int j = i+1; j<arr.length;j++){
                System.out.print("("+ current+ ","+arr[j]+")" + " ");
            }
            System.out.println();
        }
        return -1;
    }
    public static void main(String[] args) {
        int array [] = {1,2,3,4};
        Pairs(array);


    }
}


