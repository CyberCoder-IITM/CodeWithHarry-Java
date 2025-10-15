public class AK_max_subarray_sum_brute {

    public static void SubArrayMaxSum(int [] arr){
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i =0 ; i < arr.length;i++){
            int start = i;
            for (int j =i; j < arr.length;j++){
                int end = j;
                currSum = 0;
                for (int k = start ; k<=end;k++){ // be careful here.
                    currSum+=arr[k];
//                    System.out.print(arr[k]+" ");
                }
                System.out.println(currSum);
                if (maxSum<currSum){
                    maxSum=currSum;
                }
//                System.out.println();
            }
//            System.out.println();
        }
        System.out.println("The maximum sum of subarray is  " + maxSum);

    }
    public static void main(String[] args) {
        int [] arr = {2,4,6,8,10};
        SubArrayMaxSum(arr);

    }
}
