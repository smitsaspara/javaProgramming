package queue;

import java.util.LinkedList;
import java.util.Queue;

public class binaryNumber {
    public String[] binaryNum(int n){
    String[] result = new String[n];

    Queue<String> qu  = new LinkedList<>();

    qu.offer("1");

    for(int i = 0 ; i < n ; i++ ){
        
        result[i] = qu.poll();

        String s1 = result[i] + "0";
        String s2 = result[i] + "1";

        qu.offer(s1);
        qu.offer(s2);
    }           
  
    return result;
    }

    public static void main(String[] args) {
        binaryNumber bn = new binaryNumber();

        String[] result = bn.binaryNum(5);

        for (String n : result) {
            System.out.println(n);
        }
        
    }
}
