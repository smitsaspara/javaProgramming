package linkedList;

public class DoublyLinkedList {
    
    private ListNode head;
    private ListNode tail;

    private int length;

    private class ListNode {
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data) {
           this.data = data;
        }
    }

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }
  
    public boolean isEmpty() {
        return length == 0;
    }
  
    public int length() {
        return length;
    }

    public void displayForward() {
        if (head == null) {
           return;
        }

        ListNode temp = head;
        
        while (temp != null) {
           System.out.print(temp.data + " ");
           temp = temp.next;
        }
        System.out.println("null");
    }
  
    public void displayBackward() {
        if (head == null) {
           return;
        }
  
        ListNode temp = tail;
        while (temp != null) {
           System.out.print(temp.data + " ");
           temp = temp.previous;
        }
        System.out.println("null");
    }

    //insert at the beginning of DoublyLinkedList
    public void insertFirst(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
           tail = newNode;
        } else {
           head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }

    //insert at the end
    public void insertEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (isEmpty()) {
           head = newNode;
        } else {
           tail.next = newNode;
           newNode.previous = tail;
        }
        tail = newNode;
        length++;
    }

     
    public static void main(String[] args){
        
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertEnd(1);
        dll.insertEnd(2);
        dll.insertEnd(3);

        dll.displayForward();
        System.out.println();
        dll.displayBackward();
    }

}
