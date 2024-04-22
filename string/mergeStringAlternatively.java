package string;

public class mergeStringAlternatively {
        public String mergeAlternately(String word1, String word2) {
            StringBuilder output  = new StringBuilder();
            for(int i = 0; i < word1.length() || i < word2.length() ; i++){
                if(i < word1.length()){
                    output.append(word1.charAt(i));
                }
                if(i < word2.length()){
                    output.append(word2.charAt(i));
                }
    
            }
    
            return output.toString();
        }
}
