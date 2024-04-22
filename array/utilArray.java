package array;

class utilArray{

    //printing an array
    public static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
           System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    //demo 
    public void demoArray(){
        int[] arr = new int[10];
        printArray(arr);
    }
    

    //remove even integers from arry
    public int[] removeEven(int[] arr){
        int n = arr.length;
        int oddCount = 0;

        for(int i=0; i < n; i++){
            if(arr[i]%2 != 0){
                oddCount++;
            }
        }

        int result[] = new int[oddCount];

        int newIndex = 0;
        for(int i = 0; i < n ; i++){
            if(arr[i]%2 != 0){
                result[newIndex] = arr[i];
                newIndex++;
            }
        }
        return result;
    }


    //reverse an array
    public int[] reverseArray(int[] arr){
        int n = arr.length;
        int start = 0;
        int end = n-1;

        while (start < end) {
            int temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;

            start++;
            end--;   
        }

        return arr;
    }

    //minimum value
    public int minimumValue(int[] arr){

        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < min){
                min = arr[i];
            }
            
        }
        return min;
    }
    
    //second maximumvalue
    public int secondMaximumValue(int[] arr){
        
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }
            else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }
        return secondMax;
    }

    //zeroes to end of an array
    public void zerosToEnd(int[] arr){
        int j = 0;
        for(int i = 0; i< arr.length; i++){
            if(arr[i] != 0 && arr[j] == 0 ){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
        }
        printArray(arr);
    }

    //resize an array
    public int[] resizeArray(int[] arr, int capacity){
        int[] newArray = new int[capacity];
        for(int i = 0; i<arr.length ; i++){
            newArray[i] = arr[i];
        }
        return newArray;
    }

    //missing number in an array
    public int missingNumber(int[] arr){
        int n = arr.length + 1;
        int sum = ( n * ( n + 1 ) ) / 2;
        for(int num : arr){
            sum = sum - num ; 
        }
        return sum;
    }

    public static void main(String[] args) {
        utilArray arrObject = new utilArray();
        int arry[] = {1,3,4,2};
        int missingNum = arrObject.missingNumber(arry);
        //arr.printArray(arr.reverseArray(new int[]{1,2,3,4,5,6,7,8,9}));
        //int[] reversedArry = arr.reverseArray(arry);
        //System.out.println("minimum Value " + arr.minimumValue(reversedArry));
        //System.out.println("second max " + arr.secondMaximumValue(reversedArry));
        //arrObject.zerosToEnd(arry);
        //printArray(arrObject.resizeArray(arry, 10));
        System.out.println(missingNum);

    }
} 