
public class AK_prefix_sum {
    public static void maxSubArraySum(int numbers []){
        int currsum = 0;
        int maxsum = Integer.MIN_VALUE;
        int prefix [] = new int[numbers.length];
        prefix[0] = numbers[0];
        // creating a prefix sum array
        for (int z = 1 ; z < numbers.length;z++){
            prefix[z] = prefix[z-1] + numbers[z];
            }

        //traversing through all elements
        for (int i = 0 ; i < numbers.length;i++ ){
            int start  = i;
            for (int j = start; j < numbers.length;j++){
                int end  = j;

                currsum = start == 0 ? prefix[end]: prefix[end]-prefix[start-1];

                if (maxsum<currsum){
                    maxsum = currsum;
                }
            }
        }
        System.out.println("maximum sum of sub array is " + maxsum);
    }
    //------------------------------------------------------------------------------------------
    //THIS BELOW CODE IS KADANE'S ALGORITHM
    //------------------------------------------------------------------------------------------

    public static void kadanes(int numbers []){
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for(int i = 0; i < numbers.length; i++){
            cs += numbers[i];
            if (cs < 0){
                cs = 0;
            }
            ms = Math.max(cs, ms);
        }
        System.out.println("Our Max Subarray sum is "+ ms);
    }

    //------------------------------------------------------------------------------------------

    public static void main(String[] args) {
        int arr [] = {1,-2,3,8,4,-1};
        int num []= {-2,-3,4,-1,-2,1,5,-3};

//        maxSubArraySum(arr);
        kadanes(num);
    }
}
