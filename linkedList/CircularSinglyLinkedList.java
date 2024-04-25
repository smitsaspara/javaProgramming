package linkedList;

import java.util.NoSuchElementException;

import javax.swing.event.ListDataEvent;

public class CircularSinglyLinkedList {
    private ListNode last;
    private int length;

    private class ListNode {
        private ListNode next;
        private int data;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public CircularSinglyLinkedList() {
        last = null;
        length = 0;
    }

    public int length() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    //create
    public void createLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(5);
        
        first.next = second;
        second.next = third;
        third.next = first;

        last = third;
    }

    //print
    public void display(){
        if(last == null){
            return;
        }

        ListNode first = last.next;

        while (first != last) {
            System.out.print(first.data+" ");
            first = first.next;
        }
        System.out.print(first.data+" ");
    }

    //insert at the begining 

    public void insertFirst(int data){
        
        ListNode temp = new ListNode(data);

        if(last == null){
            last = temp;
        }
        else{
            temp.next = last.next;
        }
        last.next = temp;
        length++;
    }

    //insert at the last 
    public void insertLast(int data){
        
        ListNode temp = new ListNode(data);

        if(last == null){
            last = temp;
            last.next = last;
        }
        else{
            temp.next = last.next;
            last.next = temp;
            last = temp;
        }
        length++;
    }

    //remove first node
    public ListNode deleteFirst(){
        
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        
        ListNode temp = last.next;

        if (last.next == last) {
            last = null;
        }
        else{
            last.next = temp.next;
        }
        temp.next = null;
        length--;

        return temp;
    }


    public static void main(String[] args) {
        CircularSinglyLinkedList cll = new CircularSinglyLinkedList();
        //cll.createLinkedList();
                
        // cll.insertFirst(10);
        // cll.insertFirst(20);
        // cll.display();

        // cll.insertLast(10);
        // cll.insertLast(20);
        // cll.insertLast(30);
        // cll.display();

        // cll.display();
        // cll.deleteFirst();
        // cll.display();

    }

}
