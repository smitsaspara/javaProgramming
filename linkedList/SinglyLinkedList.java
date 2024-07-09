package linkedList;

public class SinglyLinkedList {

    private ListNode head;

    //node defination
    private static class ListNode {
        private int data; 
        private ListNode next; 
  
        public ListNode(int data) {
           this.data = data;
           this.next = null;
        }
    }

    //displaying node
    public void displayList(ListNode head){
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data+" ");  
            current = current.next;          
        }
        System.out.print(current);
    }

    //displaying node
    public void displayList(){
        ListNode current = head;
        while (current != null) {
            System.out.print(current.data+" ");  
            current = current.next;          
        }
        System.out.print(current);
    }

    //lenth of the linkedlist
    public int listLength(){
        int count = 0;
        ListNode current = head;
        while (current != null) {
            count++;  
            current = current.next;          
        }
        return count;
    }

    //insert at the beginning
    public void insertFirst(int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }

    //insert at the end
    public void insertEnd(int value){
        ListNode newNode = new ListNode(value);
        if(head == null){
            head = newNode;
            return;
        }
        ListNode current =  head;
        while (current.next != null ) {
            current = current.next;            
        }
        current.next = newNode;
    }

    //insert next at the given position
    public void insertAtPosition(int position, int value){
        ListNode newNode = new ListNode(value);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        }
        else{
            ListNode previous = head;
            int count = 1;
            while(count < position-1){
                previous = previous.next;
                count++;
            }
            ListNode current = previous.next;
            newNode.next = current;
            previous.next = newNode;
        }
    }

    //delete node at first
    public ListNode deleteFirstNode(){
        
        if(head == null){
            return null;
        }
        
        ListNode temp = head;
        head = head.next;
        temp.next = null;

        return temp;
    }

    //delete the last node of the linkedList
    public ListNode deleteLastNode(){
        if(head == null || head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode previous = null;
        while (current.next != null) {
            previous = current;
            current = current.next;     
        }

        previous.next = null;

        return current;
    }

    //delete any node at given position
    public void deleteNode(int position){
        if(position == 1){
            head = head.next;
        }
        else{
            ListNode previos = head;
            int count = 1;
            while(count < position -1){
                previos = previos.next;
                count++;
            }
            ListNode current = previos.next;
            previos.next = current.next;        
        }

    }

    //find an element 
    public boolean findElement(int element){
        if(head == null){
            return false;
        }
        
        ListNode current = head;
        while (current != null) {
            if(current.data == element){
                return true;
            }
            current = current.next;            
        }
        return false;
    }

    //reverse a linkedlist
    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        
        ListNode current = head;
        ListNode previous = null;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;   
        }
        return previous;
    }

    //find the nth value from the backward in linkedlist
    public ListNode findFfromBackward(int position){
        if(head == null){
            return null;
        }
        if(position <= 0){
            return null;
        }

        ListNode mainPointer = head;
        ListNode refPointer = head;

        int count = 0;

        while (count < position) {
            if (refPointer == null) {
                System.out.println("Invalid number");                
            }
            refPointer = refPointer.next;
            count++ ;            
        }

        while (refPointer != null) {
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }

    //remove duplicates from the linkedlist

    public void removeDuplicates(){
        if(head == null){
            return;
        }
        else{
            ListNode current = head;
            while (current != null && current.next != null) {
                if (current.data  == current.next.data) {
                    current.next = current.next.next;                    
                }           
                else{
                    current = current.next;
                }     
            }
        }
    }

    //insert a node in sorted Linked List
    public ListNode insertNodeSortedLL(int value){
        ListNode newNode = new ListNode(value);
        if (head == null) {
            return newNode;
        }
        ListNode current = head;
        ListNode temp = null;
        while (current != null && current.data < newNode.data) {
            temp = current;
            current = current.next;
        }
        newNode.next = current;
        temp.next = newNode;
        return head;
    }

    //to check if the linkedlist contains a loop
    public boolean containsLoop(){  
        if(head == null){
            return false;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (fastPointer == slowPointer) {
                return true;                
            }
        }
        return false;
    } 

    //created looped linkedlist
    public void LoopInLinkedList() {
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
  
        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;
    }

    public ListNode getStartingNode(ListNode slowPointer){
        ListNode temp = head;
        while(temp != slowPointer){
            temp = temp.next;
            slowPointer = slowPointer.next;
        }
        return temp;
    }
    
    //floyd's cycle detection algo and return starting node of a loop
    public ListNode startNodeOfLoop(){  
        if(head.next == null){
            return head;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (fastPointer == slowPointer) {
                return  getStartingNode(slowPointer);               
            }
        }
        return null;
    } 

    //remove loop from the list
    public void removeLoopFromLinkedList(){  
        if(head.next == null){
            return;
        }

        ListNode fastPointer = head;
        ListNode slowPointer = head;

        while (fastPointer != null && fastPointer.next != null) {

            fastPointer = fastPointer.next.next;
            slowPointer = slowPointer.next;

            if (fastPointer == slowPointer) {
                removeLoop(slowPointer);  
                return;          
            }
        }
    } 
    
    //remove loop from the linkedlist
    public void removeLoop(ListNode slowPointer){
        ListNode temp = head;
        while(temp.next != slowPointer.next){
            temp = temp.next;
            slowPointer = slowPointer.next;
        }
        slowPointer.next = null;
    }

    //merge two sorted linkedlist
    public static ListNode mergeSoretdLL(ListNode a, ListNode b){

        ListNode start = new ListNode(0);
        ListNode tail = start;

        while(a != null && b != null ){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }
            else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null){
            tail.next = b;
        }
        else{
            tail.next = a;
        }

        return start.next;
    }

    public static void main(String[] args) {
        //SinglyLinkedList sl = new SinglyLinkedList();
        // sl.head = new ListNode(1);
        // ListNode second = new ListNode(2);
        // ListNode third = new ListNode(4);
        // ListNode forth = new ListNode(5);
        // sl.head.next = second;
        // second.next = third;
        // third.next = forth;
        //sl.insertFirst(10);
        // sl.insertEnd(25);
        //sl.insertAtPosition(5,25);
        // sl.displayList();
        // System.out.println();
        // ListNode newNode =  sl.deleteFirstNode();
        // System.out.println(newNode.data);
        // sl.displayList();
        // sl.deleteLastNode();
        // System.out.println();
        // sl.displayList();
        // sl.deleteNode(2);
        // sl.displayList();
        // int count  =  sl.listLength();
        // System.out.println(count);
        //sl.displayList();
        // ListNode back = sl.findFfromBackward(2);
        // System.out.println(back.data);

        // sl.displayList();
        // ListNode reversed = sl.reverseList(sl.head);
        // sl.displayList(reversed);
        //sl.findElement(2);
        //ListNode temp = sl.findFfromBackward(2);
        //System.out.println(temp.data);
        //sl.removeDuplicates();
        //System.err.println();
        //ListNode n = sl.insertNodeSortedLL(3);
        //sl.displayList(n);
        // sl.displayList();
        // sl.LoopInLinkedList();
        // System.out.println(sl.containsLoop());
        // sl.removeLoopFromLinkedList();
        // System.out.println(sl.containsLoop());
        // sl.displayList();

        // SinglyLinkedList sll1 = new SinglyLinkedList();
        // sll1.insertEnd(1);
        // sll1.insertEnd(4);
        // sll1.insertEnd(8);

        // SinglyLinkedList sll2 = new SinglyLinkedList();
        // sll2.insertEnd(3);
        // sll2.insertEnd(5);
        // sll2.insertEnd(8);
        // sll2.insertEnd(9);
        // sll2.insertEnd(14);
        // sll2.insertEnd(18);

        // sll1.displayList();
        // sll2.displayList();
        
        // SinglyLinkedList mergedLL = new SinglyLinkedList();

        // mergedLL.head = mergeSoretdLL(sll1.head, sll2.head);

        // mergedLL.displayList();
    }

}
