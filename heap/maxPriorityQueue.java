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

    public static void main(String[] args) {
        
        maxPriorityQueue mq = new maxPriorityQueue(5);

        System.out.println(mq.size());

        System.out.println(mq.isEmpty());

    }
    
}
