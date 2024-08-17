package binaryTree;

public class sortedMatrix {

    public void search(int[][] matrix, int n, int value){
        
        int i = 0;
        int j = n - 1;

        while( i < n  && j >= 0){
            if(matrix[i][j] == value) {
                System.out.println("Value found at " + i + ", " + j);
                return;
            }
            if (matrix[i][j] > value) {
                j--;
            } else {
                i++;
            }
        }
        System.out.println("value not found");
    }
    
    public static void main(String[] args) {
        int[][] matrix ={ 
                            { 10, 20, 30, 40 },
                            { 15, 25, 35, 45 },
                            { 27, 29, 37, 48 },
                            { 32, 33, 39, 51 }
                        };
  
        sortedMatrix sm = new sortedMatrix();
        sm.search(matrix, matrix.length, 32);
        sm.search(matrix, matrix.length, 100);
     }
}
