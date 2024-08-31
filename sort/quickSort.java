package sort;

public class quickSort {

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void sort(int[] arr, int low, int high){
        if(low < high){
            int p = partition(arr, low, high);
            sort(arr, low, p-1);
            sort(arr, p+1, high); 
        }
    }

    public int partition(int[] arr, int low, int high){

        int i = low;
        int j = low;
        int pivot = arr[high];

        while (i <= high) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
            i++;
        }
        return j-1;
    }
    public static void main(String[] args) {
        quickSort qs = new quickSort();

        int[] arr = new int[]{8,7,6,5,4,3,2,1,0};

        qs.printArray(arr);

        qs.sort(arr, 0, arr.length - 1);
        
        qs.printArray(arr);
    }
}
