package stack;

import java.util.Stack;

public class stackArray {

    private int top;
    private int[] arr;

    public stackArray(int capacity) {
      top = -1;
      arr = new int[capacity];
    }

    public stackArray() {
       this(10);
    }

    public int size() {
       return top + 1;
    }

    public boolean isEmpty() {
       return top < 0;
    }

    public boolean isFull() {
       return arr.length == size();
    }

    public void push(int data) {
        if (isFull()) {
            throw new RuntimeException("Stack is full !!!");
        }
        top++;
        arr[top] = data;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty !!!");
        }
        int result = arr[top];
        top--;
        return result;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty !!!");
        }
        return arr[top];
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
        stackArray stack = new stackArray(3);
        stack.push(10);
        stack.push(15);
        stack.push(20);

        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
   }
}