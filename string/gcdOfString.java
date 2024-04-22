package string;

public class gcdOfString {
        public String gcdOfStrings(String str1, String str2) {
            int n = str1.length();
            int m = str2.length(); 
            
            if(!(str1+str2).equals(str2+str1)){
                return "";
            }
    
            int upto = gcdFinder(n,m);
            return str1.substring(0, upto);
        }
    
        public int gcdFinder(int a, int b){
            while(b!=0){
                int temp = b;
                b = a % b;
                a = temp;
            }
            return a;
        }

}
