
public class Amazon_Array {
    public static void main(String[] args) {
        int [] arr = new int[] {2,3,1,2,3};

        for(int i = 0; i < arr.length ; i++){
            for (int j =i+1; j < arr.length;j++){
                if(arr[i]==arr[j]){
                    System.out.println(arr[j]);
                }
            }
        }
    }
}
//This java program finds and prints the duplicate elements within the integer array 'arr'. It uses nested loops to compare each element with the subsequent elements in the array. When a duplicate is found, it prints the duplicate value to the console.
