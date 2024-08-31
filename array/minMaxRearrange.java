package array;

public class minMaxRearrange {
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void arrangeMinMax(int[] arr){
        int minIdx = 0;
        int maxIdx = arr.length - 1;

        int max = arr[maxIdx] + 1;

        for (int i = 0; i < arr.length; i++) {
            if (i%2 == 0) {
                arr[i] = arr[i] + (arr[maxIdx]%max)*max;
                maxIdx--;
            } else {
                arr[i] = arr[i] + (arr[minIdx]%max)*max;
                minIdx++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i]/max;
        }
    }

    public static void main(String[] args) {
        minMaxRearrange mr = new minMaxRearrange();
        int[] arr = {1,2,3,4,5,6,7,8,9};
        mr.arrangeMinMax(arr);
        printArray(arr);
    }
}
