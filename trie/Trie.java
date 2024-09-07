package trie;

public class Trie{
    
    private TrieNode root;

    public Trie(){
        this.root = new TrieNode();
    }

    private class TrieNode{

        private TrieNode[] children;

        private boolean isWord;

        public TrieNode(){
            this.children = new TrieNode[26];
            this.isWord = false;
        }

    }

    //intsering a word in trie
    public void insert(String word){

        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        word = word.toLowerCase();

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);
            int index = c - 'a';

            if (current.children[index] == null) {
                TrieNode node = new TrieNode();
                current.children[index] = node;
                current = node;
            }
            else{
                current = current.children[index];
            }
        }

        current.isWord = true; 
    }

    //search for a word
    public boolean search(String word){

        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Invalid input");
        }

        word = word.toLowerCase();

        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            
            char c = word.charAt(i);

            int index = c - 'a';

            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        return current.isWord;
    }

    
    public static void main(String[] args) {

        Trie tri = new Trie();

        tri.insert("smit");
        tri.insert("mit");
        tri.insert("it");
        tri.insert("t");

        System.out.println("words inserted successfully");

        System.out.println("Search for 'cat': " + tri.search("Smit")); 
        System.out.println("Search for 'cab': " + tri.search("Smmit")); 
        System.out.println("Search for 'son': " + tri.search("mit")); 
        System.out.println("Search for 'so': " + tri.search("so"));   
        System.out.println("Search for 'sad': " + tri.search("sad"));
        
    }
}