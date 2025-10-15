public class Practice_Array3x3 {
    public static void main(String[] args) {
        int [][]  arr ;

        arr = new int[3][3];
        arr = new int[][] {
                {2,3,4},
                {5,6,7},
                {8,9,10}
        };

        for( int i=0; i < arr.length ; i++ ){
            for(int j = 0; j< arr[i].length ; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("\n");
        }

    }
}
