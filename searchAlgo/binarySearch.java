package searchAlgo;

public class binarySearch {
    
    public int search(int[] arr, int value){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            if(arr[mid] == value){
                return mid;
            }

            if(arr[mid] < value){
                start = mid + 1;
            }

            if(arr[mid] > value){
                end = mid + 1;
            }


        }

        return -1;
    }

    public static void main(String[] args) {
        binarySearch bs  = new binarySearch();
        int[] arr = {1,3,5,7,10,2,4,6,8,0};
        
        System.out.println(bs.search(arr, 10));
    }
}
