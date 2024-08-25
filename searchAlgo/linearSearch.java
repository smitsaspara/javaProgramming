package searchAlgo;

public class linearSearch {
    
    public int search(int[] arr, int x){
        int n = arr.length;
        
        for(int i = 0; i < n ; i++){
            if (arr[i] == x) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        linearSearch ls = new linearSearch();
        int[] arr = {1,3,5,7,10,2,4,6,8,0};
        ls.search(arr, 10);
        System.out.println(ls.search(arr, 10));
    }
}
