public class AK_Binary_Search {
    public static int BinarySearch(int key,int array []){
        int start = 0;
        int end = array.length-1;
        while (start<=end){
            int mid = (start+end)/2;

            if (array[mid]==key){
                return mid;
            }
            else if(array[mid]<key){
                start = mid+1;
            }
            else{
                end = mid -1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int arr []={10, 20, 30, 44, 55, 66};
        System.out.println(BinarySearch(66, arr));
    }
}
                                   