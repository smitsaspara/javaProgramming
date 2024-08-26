package sort;

public class selectionSort {

    public void sort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;

            for (int j = i + 1; j < arr.length; j++) {
                
                if (arr[j] <  arr[min]) {
                   min = j; 
                }
            }

            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

    }
    
    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");    
        }
        System.out.println();
    }
    public static void main(String[] args) {

        selectionSort ss = new selectionSort();

        int[] arr = new int[]{8,7,6,5,4,3,2,1,0};

        ss.printArray(arr);

        System.out.println();

        ss.sort(arr);

        ss.printArray(arr);

    }
}
