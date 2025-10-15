import com.sun.security.jgss.GSSUtil;
import org.w3c.dom.ls.LSOutput;

public class AK_BasicSorting {
    public static int[] bubbleSort(int arr[]){
        int swap = 0;
        for (int turn = 0; turn < arr.length-1; turn++){

            for (int j = 0 ; j < arr.length - 1 - turn ; j++){
                if(arr[j]>arr[j+1]){
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swap++;

                }

            }

        }
        if(swap == 0){
            System.out.println("The array is already sorted.");
        }
        else{
            System.out.println("Sorting complete");
        }

        return arr;

    }

    public static void selectionSort(int arr []){
        for (int turns  = 0 ; turns < arr.length-1 ; turns++){
            int minPosition = turns ;
            // here j is the start of unsorted array
            for(int  j = turns+1 ; j < arr.length; j++){
                if(arr[minPosition] > arr[j]){
                    minPosition = j;
                }
            }
            int temp = arr[minPosition];
            arr[minPosition] = arr[turns];
            arr[turns] = temp;
        }
    }


    public static void printArr(int arr[]){
        for(int i = 0; i < arr.length;i++){
            System.out.println(arr[i]+ " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[] = {5,4,1,3,2};
//        int arr[] = {1,2,3,4,5};

//        bubbleSort(arr);
        selectionSort(arr);
        printArr(arr);

//        System.out.println(bubbleSort(arr));
    }
}
