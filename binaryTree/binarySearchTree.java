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

    public void insert(int value){
        root = insert(root, value);
    }

    //recursive insert
    public TreeNode insert(TreeNode root, int value){
        if(root == null ){
            root = new TreeNode(value);
            return root; 
        }

        if(value < root.data){
            root.left = insert(root.left, value);
        }else{
            root.right = insert(root.right, value);
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

    public static void main(String[] args) {
        binarySearchTree bst = new binarySearchTree();
        bst.insert(6);
        bst.insert(2);
        bst.insert(8);
        bst.insert(0);
        bst.insert(10);

        bst.inOrder();

    }

    
}
