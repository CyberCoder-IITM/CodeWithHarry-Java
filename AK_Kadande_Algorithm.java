public class AK_Kadande_Algorithm {
    public static void Kadanes(int arr[]){
        int currentsum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length;i++){
            currentsum+=arr[i];
            if(currentsum<0){
                currentsum= 0;
            }
            maxSum=Integer.max(currentsum,maxSum);
        }
        System.out.println(maxSum);
    }
    public static void main(String[] args) {
        int arr [] = {-5,-1,5,-3,-1,2,3,-6};
        Kadanes(arr);
    }
}
