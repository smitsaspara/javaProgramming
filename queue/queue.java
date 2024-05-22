package queue;

import java.util.NoSuchElementException;

public class queue {

    private ListNode rear;

    private ListNode front;
    
    private int length;

    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public queue(){
        front = null;
        rear = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void enqueue(int data){
        ListNode temp = new ListNode(data);
        if(isEmpty()){
            front = temp;
        }
        else{
            rear.next = temp;
        }
        rear = temp;
        length++;
    }

    public int dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("Queue is already empty");
        }
        
        int result = front.data;

        front = front.next;
        if(front == null){
            rear = null;
        }

        length--;
    
        return result;
    }

    public void print(){
        if(isEmpty()){
            return;
        }else{
            ListNode current = front;
            while (current != null) { 

                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.print("null");
        }
    }


    public static void main(String[] args) {
        queue qu = new queue();
        qu.enqueue(10);
        qu.enqueue(20);
        qu.enqueue(30);
        qu.enqueue(40);

        qu.print();
    }

}
