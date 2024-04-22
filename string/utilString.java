package string;

public class utilString {

    //check palindrome
    public boolean isPalindrome(String value){
        char[] valueArray = value.toCharArray();
        int i = 0;
        int j = valueArray.length - 1;

        while (i<j) {
            if(valueArray[i] != valueArray [j]){
                return false;
            }
            i++ ;
            j-- ;
        }
        return true;
    }
    public static void main(String[] args) {
        utilString obj = new utilString();

        if(obj.isPalindrome("smit")){
            System.out.println("string is palindrome");
        }
        else{
            System.out.println("string is not palindrom");
        }
    }
}
