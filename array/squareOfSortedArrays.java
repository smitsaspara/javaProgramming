package array;

public class squareOfSortedArrays {

    public void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int i = 0;
        int j = nums.length-1;
        for(int k = nums.length - 1; k >= 0; k--){
            if(Math.abs(nums[i]) > Math.abs(nums[j]) ){
                result[k] = nums[i] * nums[i];
                i++;
            }
            else{
                result[k] = nums[j] * nums[j];
                j--;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        squareOfSortedArrays sa = new squareOfSortedArrays();
        
        int[] result = sa.sortedSquares(new int[]{-3,-2,-1,0,2,4,6,8,9});

        sa.printArray(result);

    }
}
