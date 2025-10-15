public class AK_reverse_an_array {

    public static void Reverse(int array []){
        int first=0;
        int last= array.length-1;
        while (first<last){
            int temp = array[first];
            array[first] = array[last];
            array[last] = temp;
            first++;
            last--;
        }

        for (int i = 0; i < array.length;i++){
            System.out.print(array[i]+" ");
        }
    }
    public static void main(String[] args) {
        int array[] = {2, 3, 4, 5,9,11};
        Reverse(array);


    }
}
