package stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class stack {

    private ListNode top;
    
    private int length;

    public class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public stack(){
        top = null;
        length = 0;
    }

    public int length(){
        return length;
    }

    public boolean isEmpty(){
        return length == 0;
    }

    public void push(int data){
        ListNode temp = new ListNode(data);
        temp.next = top;
        top = temp;
        length++;
    }

    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        int var = top.data;
        top = top.next;
        length--;

        return var;
    }

    public int peek(){
        if(isEmpty()){
            throw new EmptyStackException();
        }

        return top.data;
    }
    
    public int[] nextGreaterElementArray(int[] arr){

        int[] result = new int[arr.length];

        Stack<Integer> st = new Stack<>();

        for(int i = arr.length - 1; i>=0; i--){

            if (!st.isEmpty()) {
                while (!st.isEmpty() && st.peek() <= arr[i]) {
                    st.pop();                    
                }
            }

            if(st.isEmpty()){
                result[i] = -1;
            }
            else{
                result[i] = st.peek();
            }

            st.push(arr[i]);
        }
        return result;
    }


    public static void main(String[] args) {
        stack st = new stack();
        st.push(1);
        st.push(2);    
        st.push(3);
        st.push(4);
        st.push(5);

        System.out.println(st.peek());

        st.pop();

        System.out.println(st.peek());

    }
    
}
