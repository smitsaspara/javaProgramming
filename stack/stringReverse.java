package stack;

import java.util.Stack;

public class stringReverse {

    public static String reverseSTR(String str){

        Stack<Character> st = new Stack<>();
        char[] chArray = str.toCharArray(); 

        for(char c : chArray){
            st.push(c);
        }

        for(int i = 0; i < chArray.length ; i++ ){
            chArray[i] = st.pop(); 
        }

        return new String(chArray);
    }

    public static void main(String[] args) {
        
        stringReverse sr = new stringReverse();

        String result = sr.reverseSTR("smit");

        System.out.println((String)result);
        
    }
    
}
