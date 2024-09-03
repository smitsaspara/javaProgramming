package hashing;

public class hashTable{

    private HashNode[] buckets;
    private int capacity; 
    private int size; //number of pairs

    public hashTable(){
        this(10);
    }

    public hashTable(int capacity){
        this.capacity = capacity;
        this.buckets = new HashNode[capacity];
        this.size = 0;
    }

    private class HashNode{
        private Integer key;
        private String value;
        private HashNode nextHashNode;

        public HashNode(Integer key, String value){
            this.key = key;
            this.value = value;
        }
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //put value in hash table
    public void put(Integer key, String value){
        if (key == null || value == null) {
            throw new IllegalArgumentException("key or value not present");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                head.value = value;
                return;
            }
        }

        size++;
        head = buckets[bucketIndex];
        HashNode node = new HashNode(key, value);
        node.nextHashNode = head;
        buckets[bucketIndex] = node;
    }

    private int getBucketIndex(int key){
            return key % capacity;
    }

    //get value from hash table
    public String get(Integer key){
        if(key == null){
            throw new IllegalArgumentException("key is null");
        }

        int bucketIndex = getBucketIndex(key);

        HashNode head = buckets[bucketIndex];

        while (head != null) {
            if (head.key.equals(key)) {
                return head.value;
            }
            head = head.nextHashNode;
        }

        return null;
    }

    //remove a value from hashtable using a key
    public String remove(Integer key){
        if(key == null){
            throw new IllegalArgumentException("key is null");
        }

        int bucketIndex = getBucketIndex(key);
        HashNode head = buckets[bucketIndex];
        HashNode previous = null;
        
        while (head != null) {
            if (head.key.equals(key)) {
                break;
            }

            previous = head;
            head = head.nextHashNode;
        }

        if (head == null) {
            return null;
        }

        size--;
        
        if (previous != null) {
            previous.nextHashNode = head.nextHashNode;
        }
        else{
            buckets[bucketIndex] = head.nextHashNode;
        }

        return head.value;
    } 

    public static void main(String[] args) {

        hashTable ht = new hashTable(10);
        ht.put(21, "Smit");
        ht.put(105, "saspara");
        ht.put(21, "kumar");
        System.out.println(ht.size);

        System.out.println(ht.get(105));

        System.out.println(ht.remove(105));
    }
}