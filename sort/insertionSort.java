package sort;

public class insertionSort {

    public void sort(int[] arr){

        for (int i = 1; i < arr.length; i++) {
            
            int temp = arr[i];
             
            int j = i - 1;
            
            while ((j >= 0) && arr[j] > temp  ) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = temp;

        }
    }

    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");    
        }
        System.out.println();
    }

    public static void main(String[] args) {

        insertionSort is = new insertionSort();

        int[] arr = new int[]{8,7,6,5,4,3,2,1,0};

        is.printArray(arr);

        System.out.println();

        is.sort(arr);

        is.printArray(arr);
    }
}
