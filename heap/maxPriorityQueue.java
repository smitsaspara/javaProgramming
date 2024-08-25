package heap;

public class maxPriorityQueue {

    private Integer[] heap;

    private int n;

    public maxPriorityQueue(int capacity){
        heap = new Integer[capacity + 1];

        n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < heap.length ; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    //insert the element
    public void insert(int val){
        if(n == heap.length - 1){
            resize(2 * heap.length);
        }
        n++;
        heap[n] = val;
        swim(n);
    }

    public void swim(int k){
        while ( k > 1 && heap[k/2] < heap[k] ) {
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    public void printMaxHeap() {
        for (int i = 1; i <= n; i++) {
           System.out.print(heap[i] + " ");
        }
    }

    public void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b] ;
        heap[b] = temp;
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n+1] = null;
        if((n > 0) && ( n == (heap.length-1)/4)){
            resizeM(heap.length / 2);
        }
        return max;
    }

    public void sink(int k){
        while ((2 * k) <= n) {
            
            int j = 2 * k;

            if (j < n && heap[j] < heap [j+1]) {
                j++;
            }

            if (heap[k] > heap[j]) {
                break;
            }

            swap(k, j);
            k = j;
        }
    }

    public void resizeM(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < heap.length ; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public static void main(String[] args) {
        
        maxPriorityQueue mq = new maxPriorityQueue(5);

        mq.insert(3);
        mq.insert(4);
        mq.insert(5);
        mq.insert(10);
        mq.insert(8);
        mq.insert(7);
        mq.insert(2);
        mq.insert(1);

        System.out.println(mq.size());

        System.out.println(mq.isEmpty());

        mq.printMaxHeap();

        mq.deleteMax();

        System.out.println();

        mq.printMaxHeap();

    }
    
}
