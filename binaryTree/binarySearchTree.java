package binaryTree;

public class binarySearchTree {
    
    private TreeNode root;

    private class TreeNode {
        private int data; // Generic type
        private TreeNode left;
        private TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
 
    //recursive insert
    public void insertR(int value){
        root = insertR(root, value);
    }

    //recursive insert
    public TreeNode insertR(TreeNode root, int value){
        if(root == null ){
            root = new TreeNode(value);
            return root; 
        }

        if(value < root.data){
            root.left = insertR(root.left, value);
        }else{
            root.right = insertR(root.right, value);
        }
        return root;
    }


    //iterative insert
    public void insertI(int value){
        root = insertI(root, value);
    }

    public TreeNode insertI(TreeNode root, int value){

        if(root == null ){
            root = new TreeNode(value);
            return root; 
        }

        TreeNode current = root;
        TreeNode parent = null;

        while (true) {
            parent = current;
            if(value < parent.data){
                current = current.left;
                if(current == null){
                    parent.left = new TreeNode(value);
                    break;
                }
            }
            else if(value > parent.data){
                current = current.right;
                if(current == null){
                    parent.right = new TreeNode(value);
                    break;
                }
            }
            else{
                break;
            }
        }
        return root;
    }


    //inorder
    public void inOrder(){
        inOrder(root);
    }

    public void inOrder(TreeNode root){
        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.print(root.data);
        inOrder(root.right);
    }

    //recursive search
    public TreeNode searchR(int key) {
        return searchR(root, key);
    }

    public TreeNode searchR(TreeNode root, int key) {
        if (root == null || root.data == key) { // base case 
           return root;
        }
  
        if (key < root.data) {
           return searchR(root.left, key);
        } else {
           return searchR(root.right, key);
        }
    }

    //Iterative way
    public TreeNode searchI(int key) {
        return searchI(root, key);
    }

    public TreeNode searchI(TreeNode root, int key) {
        TreeNode current = root;

        while (current != null && current.data != key) {
            if (key < current.data) {
                current = current.left;  // Move to the left subtree
            } else {
                current = current.right; // Move to the right subtree
            }
        }

        return current; // Return the found node, or null if not found
    }

    // valid BST
    public boolean isValidBST() {
        return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    // Helper function to validate the BST by checking the boundaries
    private boolean isValidBST(TreeNode node, int min, int max) {
        if (node == null) {
            return true; // An empty tree is a valid BST
        }

        // Check if the current node's value violates the min/max constraint
        if (node.data <= min || node.data >= max) {
            return false;
        }

        // Recursively check the left subtree with updated max constraint
        // and the right subtree with updated min constraint
        return isValidBST(node.left, min, node.data) && 
               isValidBST(node.right, node.data, max);
    }

    public static void main(String[] args) {
        binarySearchTree bst = new binarySearchTree();
        bst.insertI(6);
        bst.insertI(2);
        bst.insertI(8);
        bst.insertI(0);
        bst.insertI(10);

        bst.inOrder();

        System.out.println();

        if(null != bst.searchI(10)){
            System.out.println("value found");
        }else{
            System.out.println("value not found");
        }

        if(bst.isValidBST()){
            System.out.println("Valid bst");
        }else{
            System.out.println("Not valid bst");
        };

    }

}
