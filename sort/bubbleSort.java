package sort;

public class bubbleSort {


    public void sort(int[] arr){
        int n = arr.length;

        boolean isSwapped;

        for (int i = 0; i < arr.length - 1; i++) {
            isSwapped = false;
            for (int j = 0; j < arr.length - 1 -i ; j++) {
                
                if (arr[j] > arr [j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    isSwapped = true;
                }

            }
            if (isSwapped == false) {
                break;
            }
        }

      
    }

    public void printArray(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");    
        }
        System.out.println();
    }

    public static void main(String[] args) {

        bubbleSort bs = new bubbleSort();

        int[] arr = new int[]{8,7,6,5,4,3,2,1,0};

        bs.printArray(arr);

        System.out.println();

        bs.sort(arr);

        bs.printArray(arr);

    }
}
